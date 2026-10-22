package com.obric.cae.smartNetwork.fastReconnect;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Handler;
import android.os.HandlerThread;
import com.obric.cae.log.CaeLog;
import defpackage.b;

/* JADX INFO: loaded from: classes2.dex */
public class WifiScanManager {
    private static final long RESET_TIME_STAMP = Long.MIN_VALUE;
    private static final boolean SCAN_IMMEDIATELY = true;
    private static final boolean SCAN_ON_SCHEDULE = false;
    private static final String TAG = "WifiScanManager";
    private static final int WIFI_PERIOD_SCAN_INTERNAL_MS = 20000;
    private boolean mCellIdMatchSuccess;
    private Context mContext;
    private int mDeviceState;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private long mLastScanTimeStamp;
    private Runnable mPeriodScanTask;
    private boolean mPeriodScanTimerSet;
    private boolean mScreenOn;
    private boolean mWifiConnected;
    private boolean mWifiEnabled;
    private WifiManager mWifiManager;

    public WifiScanManager(Context r8) {
        this.mLastScanTimeStamp = RESET_TIME_STAMP;
        this.mPeriodScanTimerSet = false;
        this.mScreenOn = false;
        this.mWifiEnabled = false;
        this.mWifiConnected = false;
        this.mCellIdMatchSuccess = false;
        this.mDeviceState = 0;
        this.mContext = r8;
        this.mWifiManager = (WifiManager) r8.getSystemService("wifi");
        HandlerThread r10 = new HandlerThread("WifiScanManagerThread");
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
    }

    public static /* synthetic */ boolean access$002(WifiScanManager r8, boolean r10) {
        r8.mPeriodScanTimerSet = r10;
        return r10;
    }

    public static /* synthetic */ void access$100(WifiScanManager r8) {
        r8.startPeriodSingleScan();
    }

    private void cancelPeriodScanTimer() {
        if (this.mPeriodScanTimerSet == false) goto L6;
        CaeLog.d(TAG, "cancel period scan timer.");
        this.mHandler.removeCallbacks(this.mPeriodScanTask);
        this.mPeriodScanTimerSet = false;
        return;
    }

    private boolean isMotionDeviceState() {
        int r8 = this.mDeviceState;
        if (r8 != 3) goto L5;
    L8:
        return true;
    L5:
        if (r8 == 2) goto L8;
        return false;
    }

    private void mayStartFastReconnectScan(boolean r8) {
        cancelPeriodScanTimer();
        if (this.mWifiEnabled == true) goto L5;
        return;
    L5:
        if (this.mScreenOn == true) goto L7;
        return;
    L7:
        if (this.mWifiConnected == false) goto L9;
        return;
    L9:
        if (this.mCellIdMatchSuccess == true) goto L11;
        return;
    L11:
        if (isMotionDeviceState() == false) goto L20;
        if (r8 == false) goto L14;
        this.mLastScanTimeStamp = RESET_TIME_STAMP;
    L14:
        startPeriodSingleScan();
        return;
    }

    private void schedulePeriodScanTimer(int r8) {
        if (this.mPeriodScanTimerSet == false) goto L5;
        return;
    L5:
        this.mPeriodScanTimerSet = true;
        Handler r10 = this.mHandler;
        Runnable r11 = new AnonymousClass1(this);
        this.mPeriodScanTask = r11;
        r10.postDelayed(r11, r8);
    }

    private void startPeriodSingleScan() {
        long r8 = System.currentTimeMillis();
        long r10 = this.mLastScanTimeStamp;
        if (r10 == RESET_TIME_STAMP) goto L8;
        long r11 = r8 - r10;
        if (r11 >= 20000) goto L8;
        StringBuilder r12 = new StringBuilder("next cycle scan need waiting ");
        int r13 = WIFI_PERIOD_SCAN_INTERNAL_MS - ((int) r11);
        r12.append(r13);
        r12.append(" ms.");
        CaeLog.d(TAG, r12.toString());
        schedulePeriodScanTimer(r13);
        return;
    L8:
        CaeLog.d(TAG, "start a single scan. next single scan need 20000 ms.");
        this.mLastScanTimeStamp = r8;
        if (this.mWifiManager.startScan() == true) goto L11;
        CaeLog.e(TAG, "start single scan failed!");
    L11:
        schedulePeriodScanTimer(WIFI_PERIOD_SCAN_INTERNAL_MS);
    }

    public void handleCellIdMatchChanged(boolean r8) {
        if (this.mCellIdMatchSuccess != r8) goto L5;
        return;
    L5:
        CaeLog.d(TAG, "handle cellid macth changed. macth state:" + r8);
        this.mCellIdMatchSuccess = r8;
        mayStartFastReconnectScan(false);
    }

    public void handleDeviceStateChanged(int r8) {
        if (this.mDeviceState != r8) goto L5;
        return;
    L5:
        b.m("handle device state changed. DeviceState:", r8, TAG);
        this.mDeviceState = r8;
        mayStartFastReconnectScan(false);
    }

    public void handleScreenStateChanged(boolean r8) {
        if (this.mScreenOn != r8) goto L5;
        return;
    L5:
        CaeLog.d(TAG, "handle screen state changed. screen state: " + r8);
        this.mScreenOn = r8;
        mayStartFastReconnectScan(false);
    }

    public void handleWifiConnectedStateChanged(boolean r8) {
        if (this.mWifiConnected != r8) goto L5;
        return;
    L5:
        CaeLog.d(TAG, "handle wifi connected state changed. wifi connected state: " + r8);
        this.mWifiConnected = r8;
        mayStartFastReconnectScan(false);
    }

    public void handleWifiEnabledStateChanged(boolean r8) {
        if (this.mWifiEnabled != r8) goto L5;
        return;
    L5:
        CaeLog.d(TAG, "handle wifi enabled state changed. wifi enabled state: " + r8);
        this.mWifiEnabled = r8;
        mayStartFastReconnectScan(false);
    }
}
