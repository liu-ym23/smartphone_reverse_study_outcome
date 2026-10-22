package com.obric.cae.userAware;

import android.content.Context;
import android.net.wifi.WifiScanner;
import android.os.Handler;
import android.os.HandlerThread;
import com.obric.cae.log.CommSenseLog;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class CoalescedWifiScanExecutor {
    private static final int FULL_BAND = 3;
    private static final String TAG = "CoalescedWifiScanExecutor";
    private static volatile CoalescedWifiScanExecutor sInstance;
    private Runnable mChanFailureFastCb;
    private Runnable mChanFailureSlowCb;
    private final Handler mChanHandler;
    private boolean mChanInFlight;
    private ConcurrentWifiScanner.ScanCallback mChanLatestCallback;
    private final List<Integer> mChanLatestChannels;
    private final WifiScanner.ScanListener mChanListener;
    private final Object mChanLock;
    private final HandlerThread mChanThread;
    private long mChanTimeoutMs;
    private final Runnable mChanTimeoutRunnable;
    private Runnable mFullFailureFastCb;
    private Runnable mFullFailureSlowCb;
    private final Handler mFullHandler;
    private boolean mFullInFlight;
    private ConcurrentWifiScanner.ScanCallback mFullLatestCallback;
    private final WifiScanner.ScanListener mFullListener;
    private final Object mFullLock;
    private final HandlerThread mFullThread;
    private long mFullTimeoutMs;
    private final Runnable mFullTimeoutRunnable;
    private WifiScanner mWifiScanner;

    private CoalescedWifiScanExecutor(Context r8, WifiScanner r10) {
        this.mFullLock = new Object();
        this.mFullInFlight = false;
        this.mFullLatestCallback = null;
        this.mFullFailureFastCb = null;
        this.mFullFailureSlowCb = null;
        this.mFullTimeoutMs = 3500;
        this.mFullTimeoutRunnable = new AnonymousClass1(this);
        this.mChanLock = new Object();
        this.mChanInFlight = false;
        this.mChanLatestChannels = new ArrayList();
        this.mChanLatestCallback = null;
        this.mChanFailureFastCb = null;
        this.mChanFailureSlowCb = null;
        this.mChanTimeoutMs = 3500;
        this.mChanTimeoutRunnable = new AnonymousClass2(this);
        HandlerThread r11 = new HandlerThread("WifiCoalescedScan-Full");
        this.mFullThread = r11;
        r11.start();
        this.mFullHandler = new Handler(r11.getLooper());
        HandlerThread r12 = new HandlerThread("WifiCoalescedScan-Chan");
        this.mChanThread = r12;
        r12.start();
        this.mChanHandler = new Handler(r12.getLooper());
        this.mWifiScanner = r10;
        this.mFullListener = new AnonymousClass3(this);
        this.mChanListener = new AnonymousClass4(this);
    }

    public static /* synthetic */ void a(CoalescedWifiScanExecutor r8) {
        r8.tryStartFull();
    }

    public static /* synthetic */ Object access$000(CoalescedWifiScanExecutor r8) {
        return r8.mFullLock;
    }

    public static /* synthetic */ boolean access$100(CoalescedWifiScanExecutor r8) {
        return r8.mFullInFlight;
    }

    public static /* synthetic */ ConcurrentWifiScanner.ScanCallback access$1000(CoalescedWifiScanExecutor r8) {
        return r8.mChanLatestCallback;
    }

    public static /* synthetic */ boolean access$102(CoalescedWifiScanExecutor r8, boolean r10) {
        r8.mFullInFlight = r10;
        return r10;
    }

    public static /* synthetic */ Runnable access$1100(CoalescedWifiScanExecutor r8) {
        return r8.mChanTimeoutRunnable;
    }

    public static /* synthetic */ Handler access$1200(CoalescedWifiScanExecutor r8) {
        return r8.mChanHandler;
    }

    public static /* synthetic */ Runnable access$1300(CoalescedWifiScanExecutor r8) {
        return r8.mChanFailureSlowCb;
    }

    public static /* synthetic */ Runnable access$200(CoalescedWifiScanExecutor r8) {
        return r8.mFullFailureFastCb;
    }

    public static /* synthetic */ Object access$300(CoalescedWifiScanExecutor r8) {
        return r8.mChanLock;
    }

    public static /* synthetic */ boolean access$400(CoalescedWifiScanExecutor r8) {
        return r8.mChanInFlight;
    }

    public static /* synthetic */ boolean access$402(CoalescedWifiScanExecutor r8, boolean r10) {
        r8.mChanInFlight = r10;
        return r10;
    }

    public static /* synthetic */ Runnable access$500(CoalescedWifiScanExecutor r8) {
        return r8.mChanFailureFastCb;
    }

    public static /* synthetic */ ConcurrentWifiScanner.ScanCallback access$600(CoalescedWifiScanExecutor r8) {
        return r8.mFullLatestCallback;
    }

    public static /* synthetic */ Runnable access$700(CoalescedWifiScanExecutor r8) {
        return r8.mFullTimeoutRunnable;
    }

    public static /* synthetic */ Handler access$800(CoalescedWifiScanExecutor r8) {
        return r8.mFullHandler;
    }

    public static /* synthetic */ Runnable access$900(CoalescedWifiScanExecutor r8) {
        return r8.mFullFailureSlowCb;
    }

    public static /* synthetic */ void b(CoalescedWifiScanExecutor r8) {
        r8.tryStartChannels();
    }

    public static CoalescedWifiScanExecutor getInstance(Context r8, WifiScanner r10) {
        if (sInstance == null) goto L5;
    L14:
        if (r10 == null) goto L17;
        sInstance.mWifiScanner = r10;
    L17:
        return sInstance;
    L5:
        monitor-enter(CoalescedWifiScanExecutor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CoalescedWifiScanExecutor(r8.getApplicationContext(), r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoalescedWifiScanExecutor.class);     // Catch: Throwable -> L11
        goto L14
    }

    private void tryStartChannels() {
        Object r8 = this.mChanLock;
        monitor-enter(r8);
    L34:
        th = move-exception;
        throw th;
    L5:
        if (this.mChanInFlight == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L34
        return;
    L8:
        this.mChanInFlight = true;     // Catch: Throwable -> L34
        monitor-exit(r8);     // Catch: Throwable -> L34
        ArrayList r10 = new ArrayList();
        Object r11 = this.mChanLock;
        monitor-enter(r11);
        r10.addAll(this.mChanLatestChannels);     // Catch: Throwable -> L31
        monitor-exit(r11);     // Catch: Throwable -> L31
        WifiScanner.ScanSettings r12 = new WifiScanner.ScanSettings();
        r12.band = 0;
        r12.channels = new WifiScanner.ChannelSpec[r10.size()];
        int r13 = 0;
    L16:
        if (r13 >= r10.size()) goto L18;
        r12.channels[r13] = new WifiScanner.ChannelSpec(((Integer) r10.get(r13)).intValue());
        r13 = r13 + 1;
        goto L16
    L18:
        r12.reportEvents = 1;
        this.mWifiScanner.startScan(r12, this.mChanListener);     // Catch: Throwable -> L21
        this.mChanHandler.removeCallbacks(this.mChanTimeoutRunnable);     // Catch: Throwable -> L21
        this.mChanHandler.postDelayed(this.mChanTimeoutRunnable, this.mChanTimeoutMs);     // Catch: Throwable -> L21
        return;
    L21:
        th = move-exception;
        CommSenseLog.e(TAG, "startScan(CHAN) threw: " + th.getMessage());
        monitor-enter(this.mChanLock);
        this.mChanInFlight = false;     // Catch: Throwable -> L28
        this.mChanHandler.removeCallbacks(this.mChanTimeoutRunnable);
        return;
    L28:
        th = move-exception;
        throw th;
    L31:
        th = move-exception;
        throw th;
    }

    private void tryStartFull() {
        Object r8 = this.mFullLock;
        monitor-enter(r8);
    L24:
        th = move-exception;
        throw th;
    L5:
        if (this.mFullInFlight == false) goto L8;
        monitor-exit(r8);     // Catch: Throwable -> L24
        return;
    L8:
        this.mFullInFlight = true;     // Catch: Throwable -> L24
        monitor-exit(r8);     // Catch: Throwable -> L24
        WifiScanner.ScanSettings r10 = new WifiScanner.ScanSettings();
        r10.band = 3;
        r10.reportEvents = 3;
        this.mWifiScanner.startScan(r10, this.mFullListener);     // Catch: Throwable -> L13
        this.mFullHandler.removeCallbacks(this.mFullTimeoutRunnable);     // Catch: Throwable -> L13
        this.mFullHandler.postDelayed(this.mFullTimeoutRunnable, this.mFullTimeoutMs);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        CommSenseLog.e(TAG, "startScan(FULL) threw: " + th.getMessage());
        monitor-enter(this.mFullLock);
        this.mFullInFlight = false;     // Catch: Throwable -> L21
        this.mFullHandler.removeCallbacks(this.mFullTimeoutRunnable);
        return;
    L21:
        th = move-exception;
        throw th;
    }

    public void startScanChannels(List<Integer> r8, ConcurrentWifiScanner.ScanCallback r10) {
        Object r11 = this.mChanLock;
        monitor-enter(r11);
        this.mChanLatestChannels.clear();     // Catch: Throwable -> L11
        if (r8 == null) goto L7;
        this.mChanLatestChannels.addAll(r8);     // Catch: Throwable -> L11
    L7:
        this.mChanLatestCallback = r10;     // Catch: Throwable -> L11
        this.mChanFailureFastCb = null;     // Catch: Throwable -> L11
        this.mChanFailureSlowCb = null;     // Catch: Throwable -> L11
        this.mChanTimeoutMs = 3500;     // Catch: Throwable -> L11
        monitor-exit(r11);     // Catch: Throwable -> L11
        this.mChanHandler.post(new b(this, 0));
        return;
    L11:
        th = move-exception;
        throw th;
    }

    public void startScanInternal(ConcurrentWifiScanner.ScanCallback r8) {
        Object r10 = this.mFullLock;
        monitor-enter(r10);
        this.mFullLatestCallback = r8;     // Catch: Throwable -> L8
        this.mFullFailureFastCb = null;     // Catch: Throwable -> L8
        this.mFullFailureSlowCb = null;     // Catch: Throwable -> L8
        this.mFullTimeoutMs = 3500;     // Catch: Throwable -> L8
        monitor-exit(r10);     // Catch: Throwable -> L8
        this.mFullHandler.post(new a(this, 0));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void startScanChannels(List<Integer> r8, ConcurrentWifiScanner.ScanCallback r10, Runnable r11, Runnable r12, long r13) {
        Object r14 = this.mChanLock;
        monitor-enter(r14);
        this.mChanLatestChannels.clear();     // Catch: Throwable -> L15
        if (r8 == null) goto L7;
        this.mChanLatestChannels.addAll(r8);     // Catch: Throwable -> L15
    L7:
        this.mChanLatestCallback = r10;     // Catch: Throwable -> L15
        this.mChanFailureFastCb = r11;     // Catch: Throwable -> L15
        this.mChanFailureSlowCb = r12;     // Catch: Throwable -> L15
        if (r13 > 0) goto L11;
        r13 = 3500;
    L11:
        this.mChanTimeoutMs = r13;     // Catch: Throwable -> L15
        monitor-exit(r14);     // Catch: Throwable -> L15
        this.mChanHandler.post(new g(this, 3));
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public void startScanInternal(ConcurrentWifiScanner.ScanCallback r8, Runnable r10, Runnable r11, long r12) {
        Object r13 = this.mFullLock;
        monitor-enter(r13);
        this.mFullLatestCallback = r8;     // Catch: Throwable -> L12
        this.mFullFailureFastCb = r10;     // Catch: Throwable -> L12
        this.mFullFailureSlowCb = r11;     // Catch: Throwable -> L12
        if (r12 > 0) goto L8;
        r12 = 3500;
    L8:
        this.mFullTimeoutMs = r12;     // Catch: Throwable -> L12
        monitor-exit(r13);     // Catch: Throwable -> L12
        this.mFullHandler.post(new a(this, 1));
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
