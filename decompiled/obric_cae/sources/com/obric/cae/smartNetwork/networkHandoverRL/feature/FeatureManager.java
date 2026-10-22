package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.util.Log;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
public class FeatureManager {
    private static final long COLLECT_INTERVAL_MS = 1000;
    private static final String TAG = "FeatureManager";
    private static volatile FeatureManager sInstance;
    private final BroadcastReceiver mBroadcastReceiver;
    private final CopyOnWriteArrayList<FeatureCallback> mCallbacks;
    private final Runnable mCollectRunnable;
    private final ConnectivityManager mConnectivityManager;
    private Context mContext;
    private final FeatureCollector mFeatureCollector;
    private Handler mHandler;
    private HandlerThread mHandlerThread;
    private boolean mIsRunning;
    private boolean mIsScreenOn;
    private final Object mLock;
    private final MobileTrafficQuery mMobileTrafficQuery;
    private ConnectivityManager.NetworkCallback mNetworkCallback;
    private NetworkRequest mNetworkRequest;
    private final HashMap<Integer, Integer> mNetworks;
    private final PowerManager mPowerManager;

    private FeatureManager(Context r8, NetworkQoEMonitor r10) {
        this.mCallbacks = new CopyOnWriteArrayList();
        this.mNetworks = new HashMap();
        this.mLock = new Object();
        this.mIsRunning = false;
        this.mBroadcastReceiver = new AnonymousClass1(this);
        this.mNetworkRequest = new NetworkRequest.Builder().addCapability(12).build();
        this.mNetworkCallback = new AnonymousClass2(this);
        this.mCollectRunnable = new AnonymousClass3(this);
        this.mContext = r8;
        HandlerThread r11 = new HandlerThread(TAG);
        this.mHandlerThread = r11;
        r11.start();
        this.mHandler = new Handler(this.mHandlerThread.getLooper());
        this.mFeatureCollector = new FeatureCollector(r8, r10);
        this.mMobileTrafficQuery = new MobileTrafficQuery(r8);
        this.mPowerManager = (PowerManager) this.mContext.getSystemService("power");
        this.mConnectivityManager = (ConnectivityManager) this.mContext.getSystemService("connectivity");
    }

    public static /* synthetic */ boolean access$002(FeatureManager r8, boolean r10) {
        r8.mIsScreenOn = r10;
        return r10;
    }

    public static /* synthetic */ Object access$100(FeatureManager r8) {
        return r8.mLock;
    }

    public static /* synthetic */ void access$200(FeatureManager r8) {
        r8.controlFeatureCollector();
    }

    public static /* synthetic */ Context access$300(FeatureManager r8) {
        return r8.mContext;
    }

    public static /* synthetic */ HashMap access$400(FeatureManager r8) {
        return r8.mNetworks;
    }

    public static /* synthetic */ FeatureCollector access$500(FeatureManager r8) {
        return r8.mFeatureCollector;
    }

    public static /* synthetic */ CopyOnWriteArrayList access$600(FeatureManager r8) {
        return r8.mCallbacks;
    }

    public static /* synthetic */ Handler access$700(FeatureManager r8) {
        return r8.mHandler;
    }

    private void controlFeatureCollector() {
        if (isWifiConnected() == true) goto L5;
    L9:
        boolean r8 = false;
    L10:
        if (r8 == false) goto L12;
        startFeatureCollection();
        return;
    L12:
        stopFeatureCollection();
        return;
    L5:
        if (isCellularConnected() == false) goto L9;
        if (this.mIsScreenOn == false) goto L9;
        r8 = true;
        goto L10
    }

    public static FeatureManager getInstance(Context r8, NetworkQoEMonitor r10) {
        if (sInstance != null) goto L15;
        monitor-enter(FeatureManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new FeatureManager(r8, r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(FeatureManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private boolean isCellularConnected() {
        Iterator<Map.Entry<Integer, Integer>> r8 = this.mNetworks.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        if (r8.next().getValue().intValue() != 0) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean isWifiConnected() {
        Iterator<Map.Entry<Integer, Integer>> r8 = this.mNetworks.entrySet().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        if (r8.next().getValue().intValue() != 1) goto L4;
        return true;
    L8:
        return false;
    }

    private void startFeatureCollection() {
        if (this.mIsRunning == false) goto L6;
        Log.w(TAG, "Feature collection is already running");
        return;
    L6:
        this.mIsRunning = true;
        this.mFeatureCollector.initialize();
        this.mHandler.postDelayed(this.mCollectRunnable, 1000);
        Log.d(TAG, "Start feature collection successfully");
    }

    private void stopFeatureCollection() {
        if (this.mIsRunning == true) goto L6;
        Log.w(TAG, "Feature collection is not running");
        return;
    L6:
        this.mIsRunning = false;
        this.mFeatureCollector.release();
        this.mHandler.removeCallbacks(this.mCollectRunnable);
        Log.d(TAG, "Stop feature collection successfully");
    }

    public void registerCallback(FeatureCallback r8) {
        if (r8 != null) goto L4;
        return;
    L4:
        if (this.mCallbacks.contains(r8) == true) goto L8;
        this.mCallbacks.add(r8);
        Log.d(TAG, "Register callback successfully, current callback count: " + this.mCallbacks.size());
        return;
    }

    public void start() {
        IntentFilter r8 = defpackage.a.c("android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mBroadcastReceiver, r8);
        this.mIsScreenOn = this.mPowerManager.isInteractive();
        this.mConnectivityManager.registerNetworkCallback(this.mNetworkRequest, this.mNetworkCallback);
    }

    public void stop() {
        this.mContext.unregisterReceiver(this.mBroadcastReceiver);
        this.mConnectivityManager.unregisterNetworkCallback(this.mNetworkCallback);
        this.mNetworks.clear();
        stopFeatureCollection();
    }

    public void unregisterCallback(FeatureCallback r8) {
        if (r8 == null) goto L5;
        this.mCallbacks.remove(r8);
        Log.d(TAG, "Unregister callback successfully, current callback count: " + this.mCallbacks.size());
        return;
    }
}
