package com.obric.cae.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.util.Log;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class WiFiQoEManager {
    private static final long COLLECT_INTERVAL_MS = 1000;
    private static final String TAG = "WiFiQoEManager";
    private static final int WINDOW_SIZE = 5;
    private static volatile WiFiQoEManager sInstance;
    private final Runnable mCollectTask;
    private ConnectivityManager mConnectivityManager;
    private Context mContext;
    private volatile int mCurrentAverageScore;
    private volatile boolean mIsCollecting;
    private volatile boolean mIsScreenOn;
    private volatile boolean mIsWifiConnected;
    private final ConnectivityManager.NetworkCallback mNetworkCallback;
    private PowerManager mPowerManager;
    private final ConcurrentLinkedQueue<Integer> mScoreWindow;
    private final BroadcastReceiver mScreenReceiver;
    private WifiL4QoEFeatureCollector mWifiL4QoEFeatureCollector;
    private Handler mWorkHandler;
    private HandlerThread mWorkThread;

    private WiFiQoEManager(Context r8) {
        this.mIsScreenOn = false;
        this.mIsWifiConnected = false;
        this.mIsCollecting = false;
        this.mScoreWindow = new ConcurrentLinkedQueue();
        this.mCurrentAverageScore = 0;
        this.mCollectTask = new AnonymousClass1(this);
        this.mScreenReceiver = new AnonymousClass2(this);
        this.mNetworkCallback = new AnonymousClass3(this);
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mPowerManager = (PowerManager) r10.getSystemService("power");
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
        HandlerThread r11 = new HandlerThread("WiFiQoE_CollectThread");
        this.mWorkThread = r11;
        r11.start();
        this.mWorkHandler = new Handler(this.mWorkThread.getLooper());
        this.mWifiL4QoEFeatureCollector = new WifiL4QoEFeatureCollector(this.mContext);
    }

    public static /* synthetic */ boolean access$000(WiFiQoEManager r8) {
        return r8.mIsCollecting;
    }

    public static /* synthetic */ WifiL4QoEFeatureCollector access$100(WiFiQoEManager r8) {
        return r8.mWifiL4QoEFeatureCollector;
    }

    public static /* synthetic */ ConcurrentLinkedQueue access$200(WiFiQoEManager r8) {
        return r8.mScoreWindow;
    }

    public static /* synthetic */ int access$300(WiFiQoEManager r8) {
        return r8.mCurrentAverageScore;
    }

    public static /* synthetic */ int access$302(WiFiQoEManager r8, int r10) {
        r8.mCurrentAverageScore = r10;
        return r10;
    }

    public static /* synthetic */ Handler access$400(WiFiQoEManager r8) {
        return r8.mWorkHandler;
    }

    public static /* synthetic */ boolean access$502(WiFiQoEManager r8, boolean r10) {
        r8.mIsScreenOn = r10;
        return r10;
    }

    public static /* synthetic */ void access$600(WiFiQoEManager r8) {
        r8.checkAndToggleCollection();
    }

    public static /* synthetic */ ConnectivityManager access$700(WiFiQoEManager r8) {
        return r8.mConnectivityManager;
    }

    public static /* synthetic */ boolean access$802(WiFiQoEManager r8, boolean r10) {
        r8.mIsWifiConnected = r10;
        return r10;
    }

    private synchronized void checkAndToggleCollection() {
        monitor-enter(this);
    L19:
        th = move-exception;
        throw th;
    L4:
        if (this.mIsScreenOn == true) goto L6;
    L8:
        boolean r8 = false;
    L9:
        if (r8 == true) goto L11;
    L13:
        if (r8 == false) goto L15;
    L17:
        monitor-exit(this);
        return;
    L15:
        if (this.mIsCollecting == false) goto L17;
        Log.i(TAG, "Conditions not met. Stopping collection.");     // Catch: Throwable -> L19
        stopCollection();     // Catch: Throwable -> L19
        goto L17
    L11:
        if (this.mIsCollecting == true) goto L13;
        Log.i(TAG, "Conditions met. Starting periodic collection.");     // Catch: Throwable -> L19
        this.mIsCollecting = true;     // Catch: Throwable -> L19
        this.mWifiL4QoEFeatureCollector.initialize();     // Catch: Throwable -> L19
        this.mWorkHandler.post(this.mCollectTask);     // Catch: Throwable -> L19
        goto L17
    L6:
        if (this.mIsWifiConnected == false) goto L8;
        r8 = true;
        goto L9
    }

    public static WiFiQoEManager getInstance(Context r8) {
        if (sInstance != null) goto L15;
        monitor-enter(WiFiQoEManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new WiFiQoEManager(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(WiFiQoEManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void stopCollection() {
        this.mIsCollecting = false;
        this.mWorkHandler.removeCallbacks(this.mCollectTask);
        this.mWifiL4QoEFeatureCollector.release();
        this.mScoreWindow.clear();
        this.mCurrentAverageScore = 0;
    }

    public int getAverageWifiQoeScore() {
        return this.mCurrentAverageScore;
    }

    public void start() {
        IntentFilter r8 = defpackage.a.c("android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mScreenReceiver, r8);
        NetworkRequest r10 = new NetworkRequest.Builder().addCapability(12).build();
        this.mConnectivityManager.registerNetworkCallback(r10, this.mNetworkCallback);
        this.mIsScreenOn = this.mPowerManager.isInteractive();
        Network r11 = this.mConnectivityManager.getActiveNetwork();
        NetworkCapabilities r12 = this.mConnectivityManager.getNetworkCapabilities(r11);
        if (r12 == null) goto L7;
        boolean r13 = true;
        if (r12.hasTransport(1) == false) goto L7;
    L8:
        this.mIsWifiConnected = r13;
        checkAndToggleCollection();
        return;
    L7:
        r13 = false;
        goto L8
    }

    public void stop() {
        this.mContext.unregisterReceiver(this.mScreenReceiver);     // Catch: Exception -> L5
    L17:
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);     // Catch: Exception -> L9
    L11:
        stopCollection();
        HandlerThread r8 = this.mWorkThread;
        if (r8 == null) goto L19;
        r8.quitSafely();
        this.mWorkThread = null;
        return;
    L19:
        return;
    L9:
        e = move-exception;
        Log.e(TAG, "Failed to unregister network callback", e);
    L5:
        e = move-exception;
        Log.e(TAG, "Failed to unregister receiver", e);
        goto L17
    }
}
