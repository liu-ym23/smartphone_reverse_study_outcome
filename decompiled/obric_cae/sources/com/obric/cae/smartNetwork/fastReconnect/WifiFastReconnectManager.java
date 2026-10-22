package com.obric.cae.smartNetwork.fastReconnect;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.PowerManager;

/* JADX INFO: loaded from: classes2.dex */
public class WifiFastReconnectManager {
    private static final String TAG = "WifiFastReconnectManager";
    private static volatile WifiFastReconnectManager sInstance;
    private boolean mCellIdListenState;
    private CellNetworkListen mCelllisten;
    private final Context mContext;
    private WifiScanManager mScanManager;
    private boolean mScreenOn;
    private boolean mStepCounterListenState;
    private StepCounterListen mSteplisten;
    private boolean mWifiConnected;
    private boolean mWifiEnabled;

    private WifiFastReconnectManager(Context r8) {
        this.mWifiEnabled = false;
        this.mWifiConnected = false;
        this.mScreenOn = false;
        this.mStepCounterListenState = false;
        this.mCellIdListenState = false;
        this.mContext = r8;
        WifiScanManager r10 = new WifiScanManager(r8);
        this.mScanManager = r10;
        this.mSteplisten = new StepCounterListen(r8, r10);
        this.mCelllisten = new CellNetworkListen(r8, this.mScanManager);
        init();
    }

    public static /* synthetic */ void access$000(WifiFastReconnectManager r8, boolean r10) {
        r8.handleScreenStateChanged(r10);
    }

    public static /* synthetic */ void access$100(WifiFastReconnectManager r8, Intent r10) {
        r8.handleWifiStateChanged(r10);
    }

    public static /* synthetic */ void access$200(WifiFastReconnectManager r8, Intent r10) {
        r8.handleNetworkStateChanged(r10);
    }

    public static WifiFastReconnectManager getInstance(Context r8) {
        if (sInstance != null) goto L13;
        monitor-enter(WifiFastReconnectManager.class);
        sInstance = new WifiFastReconnectManager(r8);     // Catch: Throwable -> L9
        monitor-exit(WifiFastReconnectManager.class);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        throw th;
    L13:
        return sInstance;
    }

    private void handleNetworkStateChanged(Intent r8) {
        NetworkInfo r10 = (NetworkInfo) r8.getParcelableExtra("networkInfo");
        if (r10 != null) goto L5;
    L7:
        boolean r11 = false;
    L9:
        if (r11 == this.mWifiConnected) goto L12;
        this.mWifiConnected = r11;
        this.mScanManager.handleWifiConnectedStateChanged(r11);
        processCellIdListen();
        processStepCounterListen();
        return;
    L12:
        return;
    L5:
        if (r10.isConnected() == false) goto L7;
        r11 = true;
        goto L9
    }

    private void handleScreenStateChanged(boolean r8) {
        this.mScreenOn = r8;
        this.mScanManager.handleScreenStateChanged(r8);
        processStepCounterListen();
    }

    private void handleWifiStateChanged(Intent r8) {
        int r10 = r8.getIntExtra("wifi_state", 4);
        if (r10 != 1) goto L5;
        this.mWifiEnabled = false;
    L9:
        this.mScanManager.handleWifiEnabledStateChanged(this.mWifiEnabled);
        processCellIdListen();
        processStepCounterListen();
        return;
    L5:
        if (r10 != 3) goto L9;
        this.mWifiEnabled = true;
        goto L9
    }

    private void init() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        r8.addAction("android.net.wifi.STATE_CHANGE");
        r8.addAction("android.intent.action.SCREEN_ON");
        r8.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(new AnonymousClass1(this), r8);
        this.mScreenOn = ((PowerManager) this.mContext.getSystemService("power")).isScreenOn();
        WifiManager r10 = (WifiManager) this.mContext.getSystemService("wifi");
        boolean r11 = r10.isWifiEnabled();
        this.mWifiEnabled = r11;
        if (r11 == false) goto L9;
        WifiInfo r12 = r10.getConnectionInfo();
        if (r12 == null) goto L9;
        if (r12.getNetworkId() == (-1)) goto L9;
        this.mWifiConnected = true;
    L9:
        this.mScanManager.handleScreenStateChanged(this.mScreenOn);
        this.mScanManager.handleWifiEnabledStateChanged(this.mWifiEnabled);
        this.mScanManager.handleWifiConnectedStateChanged(this.mWifiConnected);
        processCellIdListen();
        processStepCounterListen();
    }

    private void processCellIdListen() {
        if (this.mWifiEnabled == false) goto L8;
        if (this.mCellIdListenState == true) goto L12;
        this.mCelllisten.register();
        boolean r8 = true;
    L10:
        this.mCellIdListenState = r8;
        return;
    L12:
        return;
    L8:
        if (this.mCellIdListenState == false) goto L13;
        this.mCelllisten.unregister();
        r8 = false;
        goto L10
    }

    private void processStepCounterListen() {
        if (this.mWifiEnabled == false) goto L12;
        if (this.mWifiConnected == true) goto L12;
        if (this.mScreenOn == false) goto L12;
        if (this.mStepCounterListenState == true) goto L16;
        this.mSteplisten.register();
        boolean r8 = true;
    L14:
        this.mStepCounterListenState = r8;
        return;
    L16:
        return;
    L12:
        if (this.mStepCounterListenState == false) goto L17;
        this.mSteplisten.unregister();
        r8 = false;
        goto L14
    }
}
