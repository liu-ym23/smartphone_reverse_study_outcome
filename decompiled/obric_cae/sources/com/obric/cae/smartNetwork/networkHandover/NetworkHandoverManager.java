package com.obric.cae.smartNetwork.networkHandover;

import android.content.ContentResolver;
import android.content.Context;
import android.content.IntentFilter;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.PowerManager;
import android.provider.Settings;
import com.obric.cae.libs.network.ICaeNetworkHandoverListener;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluate;
import com.obric.cae.smartNetwork.networkHandoverRL.ModelSettingObserver;
import com.obric.cae.smartNetwork.networkHandoverRL.clustering.UserClusteringManager;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureManager;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;
import com.obric.cae.smartNetwork.qoe.NetworkQoEMonitor;
import com.obric.cae.statusReport.network.NetworkHandoverMetrics;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkHandoverManager {
    private static final boolean DEBUG = true;
    private static final String TAG = "NetworkHandoverManager";
    private static volatile NetworkHandoverManager sInstance;
    private final ActivityMonitor mActivityMonitor;
    private final AospWifiScoreMonitor mAospWifiScoreMonitor;
    private final ContentResolver mContentResolver;
    private final Context mContext;
    private final DownloaderWorkMonitor mDownloaderWorkMonitor;
    private final FeatureManager mFeatureManager;
    private final HandoverProbePredict mHandoverProbePredict;
    private boolean mIsRunning;
    private final L4NetEvaluate mL4NetEvaluate;
    private final ModelSettingObserver mModelSettingObserver;
    private final NetworkExecutor mNetworkExecutor;
    private final NetworkHandoverLimiter mNetworkHandoverLimiter;
    private final NetworkHandoverMetrics mNetworkHandoverMetrics;
    private final NetworkKeepAlive mNetworkKeepAlive;
    private final NetworkL4QoEMonitor mNetworkL4QoEMonitor;
    private final NetworkPolicyCenter mNetworkPolicyCenter;
    private final NetworkQoEMonitor mNetworkQoEMonitor;
    private final NetworkQoeCollector mNetworkQoeCollector;
    private final NetworkStateMonitor mNetworkStateMonitor;
    private final PowerManager mPowerManager;
    private List<Uri> mSettingUris;
    private final TrafficStatsMonitor mTrafficStatsMonitor;
    private final UserClusteringManager mUserClusteringManager;

    public class SettingObserver extends ContentObserver {
        final /* synthetic */ NetworkHandoverManager this$0;

        public SettingObserver(NetworkHandoverManager r8) {
            this.this$0 = r8;
            super(null);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8) {
            CaeLog.e(NetworkHandoverManager.TAG, "Should never be reached.");
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r8, Uri r10) {
            if (r10 != null) goto L5;
            return;
        L5:
            if (r10.equals(Settings.Global.getUriFor(ModelSettingObserver.GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED)) == false) goto L13;
            CaeLog.i(NetworkHandoverManager.TAG, "settings global_rl_network_handover_enabled is changed. status: " + NetworkHandoverManager.access$200(this.this$0).getRlHandoverEnabled());
            if (NetworkHandoverManager.access$200(this.this$0).getRlHandoverEnabled() == true) goto L9;
        L11:
            NetworkHandoverManager.access$300(this.this$0).stop();
            return;
        L9:
            if (this.this$0.shouldEnabledHandover() == false) goto L11;
            NetworkHandoverManager.access$300(this.this$0).start();
            return;
        L13:
            if (r10.equals(Settings.Global.getUriFor(ModelSettingObserver.GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED)) == false) goto L21;
            CaeLog.i(NetworkHandoverManager.TAG, "settings global_cluster_network_handover_enabled is changed. status: " + NetworkHandoverManager.access$200(this.this$0).getClusterHandoverEnabled());
            if (NetworkHandoverManager.access$200(this.this$0).getClusterHandoverEnabled() == true) goto L17;
        L19:
            NetworkHandoverManager.access$400(this.this$0).stop();
            return;
        L17:
            if (this.this$0.shouldEnabledHandover() == false) goto L19;
            NetworkHandoverManager.access$400(this.this$0).start();
            return;
        L21:
            if (r10.equals(Settings.Global.getUriFor("network_avoid_bad_wifi")) == false) goto L31;
            CaeLog.i(NetworkHandoverManager.TAG, "settings network_avoid_bad_wifi is changed. status: " + this.this$0.shouldEnabledHandover());
            boolean r11 = this.this$0.shouldEnabledHandover();
            NetworkHandoverManager r12 = this.this$0;
            if (r11 == false) goto L25;
            NetworkHandoverManager.access$500(r12);
            return;
        L25:
            NetworkHandoverManager.access$600(r12);
            return;
        }
    }

    private NetworkHandoverManager(Context r8, NetworkQoEMonitor r10) {
        this.mIsRunning = false;
        this.mContext = r8;
        this.mContentResolver = r8.getContentResolver();
        this.mPowerManager = (PowerManager) r8.getSystemService("power");
        ActivityMonitor r11 = ActivityMonitor.getInstance(r8);
        this.mActivityMonitor = r11;
        this.mNetworkQoEMonitor = r10;
        NetworkExecutor r12 = new NetworkExecutor(r8);
        this.mNetworkExecutor = r12;
        NetworkHandoverMetrics r13 = new NetworkHandoverMetrics(r8, r10);
        this.mNetworkHandoverMetrics = r13;
        NetworkPolicyCenter r14 = new NetworkPolicyCenter(r8, r12, r13);
        this.mNetworkPolicyCenter = r14;
        this.mNetworkKeepAlive = new NetworkKeepAlive(r8, r14);
        this.mNetworkQoeCollector = new NetworkQoeCollector(r8, r14, r10, r11);
        NetworkL4QoEMonitor r15 = new NetworkL4QoEMonitor(r8, r14);
        this.mNetworkL4QoEMonitor = r15;
        this.mL4NetEvaluate = L4NetEvaluate.getInstance(r8);
        TrafficStatsMonitor r16 = new TrafficStatsMonitor(r8, r14);
        this.mTrafficStatsMonitor = r16;
        this.mNetworkStateMonitor = new NetworkStateMonitor(r8, r14, r15, r16);
        this.mNetworkHandoverLimiter = new NetworkHandoverLimiter(r8, r14);
        FeatureManager r17 = FeatureManager.getInstance(r8, r10);
        this.mFeatureManager = r17;
        this.mHandoverProbePredict = new HandoverProbePredict(r8, r17, r14);
        this.mUserClusteringManager = new UserClusteringManager(r8);
        this.mModelSettingObserver = ModelSettingObserver.getInstance(r8);
        this.mDownloaderWorkMonitor = new DownloaderWorkMonitor(r8, r14);
        this.mAospWifiScoreMonitor = new AospWifiScoreMonitor(r8, r14);
        init();
    }

    public static /* synthetic */ void a(NetworkHandoverManager r8, Uri r10) {
        r8.lambda$init$0(r10);
    }

    public static /* synthetic */ void access$000(NetworkHandoverManager r8) {
        r8.screenOnProcess();
    }

    public static /* synthetic */ void access$100(NetworkHandoverManager r8) {
        r8.screenOffProcess();
    }

    public static /* synthetic */ ModelSettingObserver access$200(NetworkHandoverManager r8) {
        return r8.mModelSettingObserver;
    }

    public static /* synthetic */ HandoverProbePredict access$300(NetworkHandoverManager r8) {
        return r8.mHandoverProbePredict;
    }

    public static /* synthetic */ UserClusteringManager access$400(NetworkHandoverManager r8) {
        return r8.mUserClusteringManager;
    }

    public static /* synthetic */ void access$500(NetworkHandoverManager r8) {
        r8.handoverStart();
    }

    public static /* synthetic */ void access$600(NetworkHandoverManager r8) {
        r8.handoverStop();
    }

    public static NetworkHandoverManager getInstance(Context r8, NetworkQoEMonitor r10) {
        if (sInstance != null) goto L15;
        monitor-enter(NetworkHandoverManager.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetworkHandoverManager(r8, r10);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetworkHandoverManager.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    private void handoverStart() {
        if (this.mIsRunning == false) goto L5;
        return;
    L5:
        this.mIsRunning = true;
        CaeLog.i(TAG, "start NetworkHandover.");
        this.mNetworkKeepAlive.start();
        this.mNetworkStateMonitor.start();
        this.mNetworkQoeCollector.start();
        this.mNetworkL4QoEMonitor.start();
        this.mNetworkPolicyCenter.start();
        this.mNetworkQoEMonitor.start();
        this.mL4NetEvaluate.start();
        this.mNetworkHandoverLimiter.start();
        this.mNetworkHandoverMetrics.start();
        this.mFeatureManager.start();
        this.mDownloaderWorkMonitor.start();
        if (this.mModelSettingObserver.getRlHandoverEnabled() == false) goto L9;
        this.mHandoverProbePredict.start();
    L9:
        if (this.mModelSettingObserver.getClusterHandoverEnabled() == false) goto L11;
        this.mUserClusteringManager.start();
    L11:
        this.mAospWifiScoreMonitor.start();
    }

    private void handoverStop() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        this.mIsRunning = false;
        CaeLog.i(TAG, "stop NetworkHandover.");
        this.mL4NetEvaluate.stop();
        this.mNetworkQoEMonitor.stop();
        this.mNetworkHandoverLimiter.stop();
        this.mNetworkPolicyCenter.stop();
        this.mNetworkL4QoEMonitor.stop();
        this.mNetworkQoeCollector.stop();
        this.mNetworkStateMonitor.stop();
        this.mNetworkKeepAlive.stop();
        this.mNetworkHandoverMetrics.stop();
        this.mHandoverProbePredict.stop();
        this.mUserClusteringManager.stop();
        this.mFeatureManager.stop();
        this.mDownloaderWorkMonitor.stop();
        this.mAospWifiScoreMonitor.stop();
    }

    private void init() {
        if (isScreenOn() == false) goto L6;
        screenOnProcess();
    L6:
        if (shouldEnabledHandover() == false) goto L8;
        handoverStart();
    L8:
        IntentFilter r8 = defpackage.a.c("android.intent.action.SCREEN_ON", "android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(new AnonymousClass1(this), r8);
        List<Uri> r10 = Arrays.asList(new Uri[]{Settings.Global.getUriFor(ModelSettingObserver.GLOBAL_SETTINGS_RL_NETWORK_HANDOVER_ENABLED), Settings.Global.getUriFor(ModelSettingObserver.GLOBAL_SETTINGS_CLUSTER_NETWORK_HANDOVER_ENABLED), Settings.Global.getUriFor("network_avoid_bad_wifi")});
        this.mSettingUris = r10;
        r10.forEach(new b(this, 0));
    }

    private /* synthetic */ void lambda$init$0(Uri r8) {
        this.mContentResolver.registerContentObserver(r8, false, new SettingObserver(this));
    }

    private void screenOffProcess() {
        CaeLog.d(TAG, "NetworkQoECollector stop. unregister wifiQoe, cellQoe listener and activity listener.");
        this.mNetworkQoEMonitor.unregisterWiFiQoECallback(this.mNetworkQoeCollector);
        this.mNetworkQoEMonitor.unregisterCellularQoECallback(this.mNetworkQoeCollector);
        this.mActivityMonitor.unregisterActivityListener(this.mNetworkQoeCollector);
    }

    private void screenOnProcess() {
        CaeLog.d(TAG, "NetworkQoECollector start. register wifiQoe, cellQoe listener and activity listener.");
        this.mNetworkQoEMonitor.registerWiFiQoECallback(this.mNetworkQoeCollector);
        this.mNetworkQoEMonitor.registerCellularQoECallback(this.mNetworkQoeCollector);
        this.mActivityMonitor.registerActivityListener(this.mNetworkQoeCollector);
    }

    public boolean isScreenOn() {
        return this.mPowerManager.isScreenOn();
    }

    public void registerNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
        CaeLog.d(TAG, "registerNetworkHandoverListener");
        this.mNetworkExecutor.registerListener(r8);
    }

    public boolean shouldEnabledHandover() {
        String r8 = Settings.Global.getString(this.mContentResolver, "network_avoid_bad_wifi");
        if (r8 != null) goto L5;
    L7:
        return false;
    L5:
        if (r8.equals("1") == false) goto L7;
        return true;
    }

    public void unregisterNetworkHandoverListener(ICaeNetworkHandoverListener r8) {
        CaeLog.d(TAG, "unregisterNetworkHandoverListener");
        this.mNetworkExecutor.unregisterListener(r8);
    }
}
