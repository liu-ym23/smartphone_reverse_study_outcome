package com.obric.cae.smartNetwork.networkHandoverRL.clustering;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkHandover.HandoverParameterManager;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.ClusteringFeatureManager;
import com.obric.cae.statusReport.network.UserClusterReport;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class UserClusteringManager {
    private static final long CLUSTERING_INTERVAL_MS = 0;
    private static final String TAG = "UserClusteringManager";
    private static final int USER_CLUSTER_0 = 0;
    private static final int USER_CLUSTER_1 = 1;
    private static final int USER_CLUSTER_2 = 2;
    private static final int USER_CLUSTER_UNKNOWN = -1;
    private final ClusteringFeatureManager mClusteringFeatureManager;
    private final ClusteringModelClient mClusteringModelClient;
    private final Context mContext;
    private final ExecutorService mExecutor;
    private final HandoverParameterManager mHandoverParameterManager;
    private boolean mIsRunning;
    private long mLastClusteringTime;
    private final BroadcastReceiver mScreenOnReceiver;
    private final UserClusterReport mUserClusterReport;

    static {
        CLUSTERING_INTERVAL_MS = TimeUnit.DAYS.toMillis(1);
    }

    public UserClusteringManager(Context r8) {
        this.mIsRunning = false;
        this.mLastClusteringTime = 0;
        this.mScreenOnReceiver = new AnonymousClass1(this);
        this.mContext = r8;
        this.mClusteringModelClient = new ClusteringModelClient(r8);
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        this.mClusteringFeatureManager = ClusteringFeatureManager.getInstance(r8);
        this.mUserClusterReport = UserClusterReport.getInstance(r8);
        this.mExecutor = Executors.newSingleThreadExecutor();
    }

    public static /* synthetic */ ClusteringModelClient access$000(UserClusteringManager r8) {
        return r8.mClusteringModelClient;
    }

    public static /* synthetic */ long access$100(UserClusteringManager r8) {
        return r8.mLastClusteringTime;
    }

    public static /* synthetic */ long access$102(UserClusteringManager r8, long r10) {
        r8.mLastClusteringTime = r10;
        return r10;
    }

    public static /* synthetic */ long access$200() {
        return CLUSTERING_INTERVAL_MS;
    }

    public static /* synthetic */ ClusteringFeatureManager access$300(UserClusteringManager r8) {
        return r8.mClusteringFeatureManager;
    }

    public static /* synthetic */ int access$400(UserClusteringManager r8, ClusteringFeatureManager.TrafficFeature r10) {
        return r8.evaluateUserCluster(r10);
    }

    public static /* synthetic */ void access$500(UserClusteringManager r8, int r10) {
        r8.handleUserClusterResult(r10);
    }

    public static /* synthetic */ UserClusterReport access$600(UserClusteringManager r8) {
        return r8.mUserClusterReport;
    }

    public static /* synthetic */ ExecutorService access$700(UserClusteringManager r8) {
        return r8.mExecutor;
    }

    private int evaluateUserCluster(ClusteringFeatureManager.TrafficFeature r18) {
        if (r18 != null) goto L6;
        return 0;
    L6:
        CaeLog.i(TAG, "Evaluate user cluster, feature = " + r18.toString());
        long r8 = r18.day7CellDataUsed;
        long r10 = r18.day7WifiDataUsed + r8;
        float r11 = 0.0f;
        if (r10 <= 0) goto L9;
        float r12 = r8 / r10;
    L10:
        long r13 = r18.day7VideoCellDataUsed;
        if (r13 <= 0) goto L13;
        float r14 = r13 / (r13 + r18.day7VideoWifiDataUsed);
    L14:
        long r15 = r18.day7SocialCellDataUsed;
        if (r15 <= 0) goto L17;
        float r16 = r15 / (r15 + r18.day7SocialWifiDataUsed);
    L18:
        long r17 = r18.day7GameCellDataUsed;
        if (r17 <= 0) goto L21;
        float r19 = r17 / (r17 + r18.day7GameWifiDataUsed);
    L22:
        long r20 = r18.day7NewsCellDataUsed;
        if (r20 <= 0) goto L25;
        r11 = r20 / (r20 + r18.day7NewsWifiDataUsed);
    L25:
        Float r21 = this.mClusteringModelClient.runSync(r10, r12, r14, r16, r19, r11);
        if (r21 != null) goto L30;
        CaeLog.w(TAG, "Clustering model run failed and return null.");
        return -1;
    L30:
        return r21.intValue();
    L21:
        r19 = 0.0f;
        goto L22
    L17:
        r16 = 0.0f;
        goto L18
    L13:
        r14 = 0.0f;
        goto L14
    L9:
        r12 = 0.0f;
        goto L10
    }

    private void handleUserClusterResult(int r8) {
        if (r8 != 0) goto L5;
        CaeLog.i(TAG, "User cluster 0, update parameter scenario to network_handover_cluster_0");
        HandoverParameterManager r10 = this.mHandoverParameterManager;
        String r11 = HandoverParameterManager.SCENARIO_CLUSTER_0;
    L12:
        r10.updateScenario(r11);
        return;
    L5:
        if (r8 != 1) goto L7;
        CaeLog.i(TAG, "User cluster 1, update parameter scenario to network_handover_cluster_1");
        r10 = this.mHandoverParameterManager;
        r11 = HandoverParameterManager.SCENARIO_CLUSTER_1;
        goto L12
    L7:
        if (r8 != 2) goto L14;
        CaeLog.i(TAG, "User cluster 2, update parameter scenario to network_handover_cluster_2");
        r10 = this.mHandoverParameterManager;
        r11 = HandoverParameterManager.SCENARIO_CLUSTER_2;
        goto L12
    }

    public void start() {
        if (this.mIsRunning == false) goto L5;
        return;
    L5:
        this.mIsRunning = true;
        CaeLog.i(TAG, "Start user clustering manager");
        this.mClusteringModelClient.init();
        IntentFilter r8 = new IntentFilter("android.intent.action.SCREEN_ON");
        this.mContext.registerReceiver(this.mScreenOnReceiver, r8);
    }

    public void stop() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        this.mIsRunning = false;
        CaeLog.i(TAG, "Stop user clustering manager");
        this.mContext.unregisterReceiver(this.mScreenOnReceiver);
        this.mClusteringModelClient.release();
        this.mHandoverParameterManager.updateScenario(HandoverParameterManager.SCENARIO_CONSERVATIVE);
    }
}
