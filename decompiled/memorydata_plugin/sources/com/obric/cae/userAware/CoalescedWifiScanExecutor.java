package com.obric.cae.userAware;

import android.content.Context;
import android.net.wifi.WifiScanner;
import android.os.Handler;
import android.os.HandlerThread;
import com.obric.cae.log.a;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
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
    private CommSenseScanTuningConfig mChanLatestTuningConfig;
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
    private CommSenseScanTuningConfig mFullLatestTuningConfig;
    private final WifiScanner.ScanListener mFullListener;
    private final Object mFullLock;
    private final HandlerThread mFullThread;
    private long mFullTimeoutMs;
    private final Runnable mFullTimeoutRunnable;
    private WifiScanner mWifiScanner;

    private CoalescedWifiScanExecutor(Context r5, WifiScanner r6) {
        Context r7 = (Context) ZeusTransformUtils.wrapperContextForParams(r5, Context.class, "com.obric.memorydata.plugin");
        WifiScanner r8 = (WifiScanner) ZeusTransformUtils.wrapperContextForParams(r6, WifiScanner.class, "com.obric.memorydata.plugin");
        this.mFullLock = new Object();
        this.mFullInFlight = false;
        this.mFullLatestCallback = null;
        this.mFullLatestTuningConfig = null;
        this.mFullFailureFastCb = null;
        this.mFullFailureSlowCb = null;
        this.mFullTimeoutMs = 3500;
        this.mFullTimeoutRunnable = new AnonymousClass1(this);
        this.mChanLock = new Object();
        this.mChanInFlight = false;
        this.mChanLatestChannels = new ArrayList();
        this.mChanLatestCallback = null;
        this.mChanLatestTuningConfig = null;
        this.mChanFailureFastCb = null;
        this.mChanFailureSlowCb = null;
        this.mChanTimeoutMs = 3500;
        this.mChanTimeoutRunnable = new AnonymousClass2(this);
        HandlerThread r9 = new HandlerThread("WifiCoalescedScan-Full");
        this.mFullThread = r9;
        r9.start();
        this.mFullHandler = new Handler(r9.getLooper());
        HandlerThread r10 = new HandlerThread("WifiCoalescedScan-Chan");
        this.mChanThread = r10;
        r10.start();
        this.mChanHandler = new Handler(r10.getLooper());
        this.mWifiScanner = r8;
        this.mFullListener = new AnonymousClass3(this);
        this.mChanListener = new AnonymousClass4(this);
    }

    public static /* synthetic */ Object access$000(CoalescedWifiScanExecutor r0) {
        return r0.mFullLock;
    }

    public static /* synthetic */ boolean access$100(CoalescedWifiScanExecutor r0) {
        return r0.mFullInFlight;
    }

    public static /* synthetic */ Handler access$1000(CoalescedWifiScanExecutor r0) {
        return r0.mFullHandler;
    }

    public static /* synthetic */ boolean access$102(CoalescedWifiScanExecutor r0, boolean r1) {
        r0.mFullInFlight = r1;
        return r1;
    }

    public static /* synthetic */ Runnable access$1100(CoalescedWifiScanExecutor r0) {
        return r0.mFullFailureSlowCb;
    }

    public static /* synthetic */ ConcurrentWifiScanner.ScanCallback access$1200(CoalescedWifiScanExecutor r0) {
        return r0.mChanLatestCallback;
    }

    public static /* synthetic */ Runnable access$1300(CoalescedWifiScanExecutor r0) {
        return r0.mChanTimeoutRunnable;
    }

    public static /* synthetic */ Handler access$1400(CoalescedWifiScanExecutor r0) {
        return r0.mChanHandler;
    }

    public static /* synthetic */ Runnable access$1500(CoalescedWifiScanExecutor r0) {
        return r0.mChanFailureSlowCb;
    }

    public static /* synthetic */ Runnable access$200(CoalescedWifiScanExecutor r0) {
        return r0.mFullFailureFastCb;
    }

    public static /* synthetic */ void access$300(CoalescedWifiScanExecutor r0) {
        r0.clearFullLatestLocked();
    }

    public static /* synthetic */ Object access$400(CoalescedWifiScanExecutor r0) {
        return r0.mChanLock;
    }

    public static /* synthetic */ boolean access$500(CoalescedWifiScanExecutor r0) {
        return r0.mChanInFlight;
    }

    public static /* synthetic */ boolean access$502(CoalescedWifiScanExecutor r0, boolean r1) {
        r0.mChanInFlight = r1;
        return r1;
    }

    public static /* synthetic */ Runnable access$600(CoalescedWifiScanExecutor r0) {
        return r0.mChanFailureFastCb;
    }

    public static /* synthetic */ void access$700(CoalescedWifiScanExecutor r0) {
        r0.clearChanLatestLocked();
    }

    public static /* synthetic */ ConcurrentWifiScanner.ScanCallback access$800(CoalescedWifiScanExecutor r0) {
        return r0.mFullLatestCallback;
    }

    public static /* synthetic */ Runnable access$900(CoalescedWifiScanExecutor r0) {
        return r0.mFullTimeoutRunnable;
    }

    private void clearChanLatestLocked() {
        this.mChanLatestChannels.clear();
        this.mChanLatestCallback = null;
        this.mChanLatestTuningConfig = null;
        this.mChanFailureFastCb = null;
        this.mChanFailureSlowCb = null;
    }

    private void clearFullLatestLocked() {
        this.mFullLatestCallback = null;
        this.mFullLatestTuningConfig = null;
        this.mFullFailureFastCb = null;
        this.mFullFailureSlowCb = null;
    }

    public static CoalescedWifiScanExecutor getInstance(Context r4, WifiScanner r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        WifiScanner r7 = (WifiScanner) ZeusTransformUtils.wrapperContextForParams(r5, WifiScanner.class, "com.obric.memorydata.plugin");
        if (sInstance == null) goto L5;
    L14:
        if (r7 == null) goto L17;
        sInstance.mWifiScanner = r7;
    L17:
        return sInstance;
    L5:
        monitor-enter(CoalescedWifiScanExecutor.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new CoalescedWifiScanExecutor((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(r6.getApplicationContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r7);     // Catch: Throwable -> L11
    L9:
        monitor-exit(CoalescedWifiScanExecutor.class);     // Catch: Throwable -> L11
        goto L14
    }

    /* JADX INFO: renamed from: lambda$ME7c58S-j9qGgO7yBEDsBpRXdXA, reason: not valid java name */
    public static /* synthetic */ void m397lambda$ME7c58Sj9qGgO7yBEDsBpRXdXA(CoalescedWifiScanExecutor r0) {
        r0.tryStartFull();
    }

    /* JADX INFO: renamed from: lambda$_RX2tfCB6XPOJgnrp69Pr-7cwhk, reason: not valid java name */
    public static /* synthetic */ void m398lambda$_RX2tfCB6XPOJgnrp69Pr7cwhk(CoalescedWifiScanExecutor r0) {
        r0.tryStartChannels();
    }

    private void setChanLatestChannelsLocked(List<Integer> r4) {
        List r5 = (List) ZeusTransformUtils.wrapperContextForParams(r4, List.class, "com.obric.memorydata.plugin");
        this.mChanLatestChannels.clear();
        if (r5 != null) goto L5;
        return;
    L5:
        Iterator r6 = r5.iterator();
    L7:
        if (r6.hasNext() == false) goto L11;
        Integer r0 = (Integer) ZeusTransformUtils.preCheckCast(r6.next(), Integer.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L7;
        this.mChanLatestChannels.add(r0);
        goto L7
    }

    private void tryStartChannels() {
        ArrayList r0 = new ArrayList();
        Object r1 = this.mChanLock;
        monitor-enter(r1);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (this.mChanInFlight == false) goto L8;
        monitor-exit(r1);     // Catch: Throwable -> L32
        return;
    L8:
        this.mChanInFlight = true;     // Catch: Throwable -> L32
        CommSenseScanTuningConfig r3 = this.mChanLatestTuningConfig;     // Catch: Throwable -> L32
        long r4 = this.mChanTimeoutMs;     // Catch: Throwable -> L32
        r0.addAll(this.mChanLatestChannels);     // Catch: Throwable -> L32
        monitor-exit(r1);     // Catch: Throwable -> L32
        WifiScanner.ScanSettings r2 = new WifiScanner.ScanSettings();
        r2.band = 0;
        r2.channels = new WifiScanner.ChannelSpec[r0.size()];
        int r7 = 0;
    L12:
        if (r7 >= r0.size()) goto L14;
        r2.channels[r7] = new WifiScanner.ChannelSpec(((Integer) ZeusTransformUtils.preCheckCast(r0.get(r7), Integer.class, "com.obric.memorydata.plugin")).intValue());
        r7 = r7 + 1;
        goto L12
    L14:
        r2.reportEvents = 1;
        CommSenseScanTuningMarker.attach(r2, r3);
        this.mWifiScanner.startScan(r2, this.mChanListener);     // Catch: Throwable -> L17
        this.mChanHandler.removeCallbacks(this.mChanTimeoutRunnable);     // Catch: Throwable -> L17
        this.mChanHandler.postDelayed(this.mChanTimeoutRunnable, r4);     // Catch: Throwable -> L17
        return;
    L17:
        th = move-exception;
        a.i(TAG, "startScan(CHAN) threw: " + th.getMessage());
        monitor-enter(this.mChanLock);
        this.mChanInFlight = false;     // Catch: Throwable -> L29
        Runnable r5 = this.mChanFailureFastCb;     // Catch: Throwable -> L29
        clearChanLatestLocked();     // Catch: Throwable -> L29
        this.mChanHandler.removeCallbacks(this.mChanTimeoutRunnable);
        if (r5 == null) goto L43;
        r5.run();     // Catch: Throwable -> L26
        return;
    L26:
        th = move-exception;
        a.i(TAG, "Chan failureCb threw: " + th.getMessage());
        return;
    L43:
        return;
    L29:
        th = move-exception;
        throw th;
    }

    private void tryStartFull() {
        Object r0 = this.mFullLock;
        monitor-enter(r0);
    L29:
        th = move-exception;
        throw th;
    L5:
        if (this.mFullInFlight == false) goto L8;
        monitor-exit(r0);     // Catch: Throwable -> L29
        return;
    L8:
        this.mFullInFlight = true;     // Catch: Throwable -> L29
        CommSenseScanTuningConfig r1 = this.mFullLatestTuningConfig;     // Catch: Throwable -> L29
        long r2 = this.mFullTimeoutMs;     // Catch: Throwable -> L29
        monitor-exit(r0);     // Catch: Throwable -> L29
        WifiScanner.ScanSettings r3 = new WifiScanner.ScanSettings();
        r3.band = 3;
        r3.reportEvents = 3;
        CommSenseScanTuningMarker.attach(r3, r1);
        this.mWifiScanner.startScan(r3, this.mFullListener);     // Catch: Throwable -> L13
        this.mFullHandler.removeCallbacks(this.mFullTimeoutRunnable);     // Catch: Throwable -> L13
        this.mFullHandler.postDelayed(this.mFullTimeoutRunnable, r2);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        a.i(TAG, "startScan(FULL) threw: " + th.getMessage());
        monitor-enter(this.mFullLock);
        this.mFullInFlight = false;     // Catch: Throwable -> L26
        Runnable r4 = this.mFullFailureFastCb;     // Catch: Throwable -> L26
        clearFullLatestLocked();     // Catch: Throwable -> L26
        this.mFullHandler.removeCallbacks(this.mFullTimeoutRunnable);
        if (r4 == null) goto L39;
        r4.run();     // Catch: Throwable -> L23
        return;
    L23:
        th = move-exception;
        a.i(TAG, "Full failureCb threw: " + th.getMessage());
        return;
    L39:
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public void startScanChannels(List<Integer> r3, ConcurrentWifiScanner.ScanCallback r4) {
        startScanChannels((List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin"), (ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r4, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin"), CommSenseScanTuningConfig.SCAN_TIME_OPTIMIZED_CONFIG);
    }

    public void startScanChannels(List<Integer> r3, ConcurrentWifiScanner.ScanCallback r4, CommSenseScanTuningConfig r5) {
        List<Integer> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ConcurrentWifiScanner.ScanCallback r7 = (ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r4, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin");
        Object r0 = this.mChanLock;
        monitor-enter(r0);
        setChanLatestChannelsLocked(r6);     // Catch: Throwable -> L8
        this.mChanLatestCallback = r7;     // Catch: Throwable -> L8
        this.mChanLatestTuningConfig = r5;     // Catch: Throwable -> L8
        this.mChanFailureFastCb = null;     // Catch: Throwable -> L8
        this.mChanFailureSlowCb = null;     // Catch: Throwable -> L8
        this.mChanTimeoutMs = 3500;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mChanHandler.post(new $$Lambda$CoalescedWifiScanExecutor$_RX2tfCB6XPOJgnrp69Pr7cwhk(this));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void startScanChannels(List<Integer> r3, ConcurrentWifiScanner.ScanCallback r4, CommSenseScanTuningConfig r5, Runnable r6, Runnable r7, long r8) {
        List<Integer> r9 = (List) ZeusTransformUtils.wrapperContextForParams(r3, List.class, "com.obric.memorydata.plugin");
        ConcurrentWifiScanner.ScanCallback r10 = (ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r4, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin");
        Runnable r11 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Runnable r12 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r7, Runnable.class, "com.obric.memorydata.plugin");
        Object r0 = this.mChanLock;
        monitor-enter(r0);
        setChanLatestChannelsLocked(r9);     // Catch: Throwable -> L12
        this.mChanLatestCallback = r10;     // Catch: Throwable -> L12
        this.mChanLatestTuningConfig = r5;     // Catch: Throwable -> L12
        this.mChanFailureFastCb = r11;     // Catch: Throwable -> L12
        this.mChanFailureSlowCb = r12;     // Catch: Throwable -> L12
        if (r8 > 0) goto L8;
        r8 = 3500;
    L8:
        this.mChanTimeoutMs = r8;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mChanHandler.post(new $$Lambda$CoalescedWifiScanExecutor$_RX2tfCB6XPOJgnrp69Pr7cwhk(this));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void startScanChannels(List<Integer> r11, ConcurrentWifiScanner.ScanCallback r12, Runnable r13, Runnable r14, long r15) {
        List<Integer> r3 = (List) ZeusTransformUtils.wrapperContextForParams(r11, List.class, "com.obric.memorydata.plugin");
        ConcurrentWifiScanner.ScanCallback r4 = (ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r12, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r13, Runnable.class, "com.obric.memorydata.plugin");
        Runnable r7 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r14, Runnable.class, "com.obric.memorydata.plugin");
        startScanChannels(r3, r4, CommSenseScanTuningConfig.SCAN_TIME_OPTIMIZED_CONFIG, r6, r7, r15);
    }

    public void startScanInternal(ConcurrentWifiScanner.ScanCallback r3) {
        startScanInternal((ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r3, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin"), CommSenseScanTuningConfig.SCAN_TIME_OPTIMIZED_CONFIG);
    }

    public void startScanInternal(ConcurrentWifiScanner.ScanCallback r3, CommSenseScanTuningConfig r4) {
        ConcurrentWifiScanner.ScanCallback r5 = (ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r3, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin");
        Object r0 = this.mFullLock;
        monitor-enter(r0);
        this.mFullLatestCallback = r5;     // Catch: Throwable -> L8
        this.mFullLatestTuningConfig = r4;     // Catch: Throwable -> L8
        this.mFullFailureFastCb = null;     // Catch: Throwable -> L8
        this.mFullFailureSlowCb = null;     // Catch: Throwable -> L8
        this.mFullTimeoutMs = 3500;     // Catch: Throwable -> L8
        monitor-exit(r0);     // Catch: Throwable -> L8
        this.mFullHandler.post(new $$Lambda$CoalescedWifiScanExecutor$ME7c58Sj9qGgO7yBEDsBpRXdXA(this));
        return;
    L8:
        th = move-exception;
        throw th;
    }

    public void startScanInternal(ConcurrentWifiScanner.ScanCallback r3, CommSenseScanTuningConfig r4, Runnable r5, Runnable r6, long r7) {
        ConcurrentWifiScanner.ScanCallback r8 = (ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r3, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin");
        Runnable r9 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        Runnable r10 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r6, Runnable.class, "com.obric.memorydata.plugin");
        Object r0 = this.mFullLock;
        monitor-enter(r0);
        this.mFullLatestCallback = r8;     // Catch: Throwable -> L12
        this.mFullLatestTuningConfig = r4;     // Catch: Throwable -> L12
        this.mFullFailureFastCb = r9;     // Catch: Throwable -> L12
        this.mFullFailureSlowCb = r10;     // Catch: Throwable -> L12
        if (r7 > 0) goto L8;
        r7 = 3500;
    L8:
        this.mFullTimeoutMs = r7;     // Catch: Throwable -> L12
        monitor-exit(r0);     // Catch: Throwable -> L12
        this.mFullHandler.post(new $$Lambda$CoalescedWifiScanExecutor$ME7c58Sj9qGgO7yBEDsBpRXdXA(this));
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public void startScanInternal(ConcurrentWifiScanner.ScanCallback r10, Runnable r11, Runnable r12, long r13) {
        ConcurrentWifiScanner.ScanCallback r3 = (ConcurrentWifiScanner.ScanCallback) ZeusTransformUtils.wrapperContextForParams(r10, ConcurrentWifiScanner.ScanCallback.class, "com.obric.memorydata.plugin");
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r11, Runnable.class, "com.obric.memorydata.plugin");
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r12, Runnable.class, "com.obric.memorydata.plugin");
        startScanInternal(r3, CommSenseScanTuningConfig.SCAN_TIME_OPTIMIZED_CONFIG, r5, r6, r13);
    }
}
