package com.obric.cae.smartNetwork.networkHandover;

import android.content.Context;
import android.net.Network;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkHandoverRL.ModelSettingObserver;
import com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchPolicyML;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureStorage;
import com.obric.cae.smartNetwork.networkHandoverRL.feedback.WifiCellSwitchMonitor;
import com.obric.cae.smartNetwork.networkMonitor.NetworkMonitor;
import com.obric.cae.statusReport.network.NetworkHandoverMetrics;
import com.obric.cae.statusReport.network.NetworkQoEInfoCollector;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkPolicyCenter extends Handler {
    private static final boolean DEBUG = false;
    public static final int MSG_ACTIVITY_PINNED = 16;
    public static final int MSG_ACTIVITY_UNPINNED = 17;
    public static final int MSG_AOSP_WIFI_SCORE_SWITCH = 21;
    public static final int MSG_AOSP_WIFI_SCORE_UNSWITCH = 22;
    public static final int MSG_APPLICATION_BACKGROUND = 9;
    public static final int MSG_APPLICATION_FOREGROUND = 10;
    public static final int MSG_APP_DATA_STALL = 14;
    public static final int MSG_DEFAULT_NETWORK_CHANGED = 11;
    public static final int MSG_DEFAULT_NETWORK_SELECTED = 13;
    public static final int MSG_DOWNLOADER_WORK_STATE_CHANGED = 20;
    public static final int MSG_HANDOVER_CELL_DNS_RESOLVER = 23;
    public static final int MSG_ML_HANDOVER_PREDICT_SWITCH = 18;
    public static final int MSG_ML_HANDOVER_PREDICT_UNSWITCH = 19;
    public static final int MSG_NETWORK_CONNECTED = 1;
    public static final int MSG_NETWORK_DISCONNECTED = 2;
    public static final int MSG_NETWORK_INVALID = 4;
    public static final int MSG_NETWORK_L2_QOE_BAD = 6;
    public static final int MSG_NETWORK_L2_QOE_GOOD = 5;
    public static final int MSG_NETWORK_L4_QOE_BAD = 8;
    public static final int MSG_NETWORK_L4_QOE_GOOD = 7;
    public static final int MSG_NETWORK_VALID = 3;
    public static final int MSG_SWITCH_LIMIT_STATE_CHANGED = 12;
    public static final int MSG_TRAFFIC_MONITOR_STATE_CHANGED = 15;
    private static final String TAG = "NetworkPolicyCenter";
    private static final boolean TOAST_ENABLED = false;
    public static final int UNVALID_NETWORK_ID = -1;
    private int mAospWifiScoreState;
    private final HashMap<String, AppNetState> mAppNetStateMap;
    private final AppNetworkHandler mAppNetworkHandler;
    private final Context mContext;
    private Network mDefaultNetwork;
    private int mDownloaderWorkState;
    private final FeatureStorage mFeatureStorage;
    private final HandlerThread mHandlerThread;
    private final HandoverParameterManager mHandoverParameterManager;
    private boolean mHasForegroundApp;
    private boolean mMakeDefaultCompleted;
    private final ModelSettingObserver mModelSettingObserver;
    private final NetworkExecutor mNetworkExecutor;
    private final NetworkHandoverMetrics mNetworkHandoverMetrics;
    private final HashMap<Integer, NetworkMonitor> mNetworkMonitors;
    private final NetworkQoEInfoCollector mNetworkQoEInfoCollector;
    private final NetworkRanker mNetworkRanker;
    private final NetworkSwitchPolicyML mNetworkSwitchPolicyML;
    private final NetworkUnswitchLimiter mNetworkUnswitchLimiter;
    private String mPackageName;
    private int mPredictResult;
    private final HashMap<Integer, NetworkScore> mScores;
    private int mSwitchLimitState;
    private int mTrafficMonitorState;
    private int mTrafficWarningType;
    private final WifiCellSwitchMonitor mWifiCellSwitchMonitor;

    public static class AppNetState {
        private boolean isCellAccelerating;
        private boolean isDataStall;
        private boolean isForeground;
        private final boolean isNotSupportHandover;
        private boolean isPinned;
        private final boolean isSupportCellAcc;
        private final Object object;
        private final String packageName;

        private AppNetState(String r8, boolean r10, boolean r11) {
            this.packageName = r8;
            this.isSupportCellAcc = r10;
            this.isNotSupportHandover = r11;
            this.object = new Object();
            this.isForeground = false;
            this.isPinned = false;
            this.isDataStall = false;
            this.isCellAccelerating = false;
        }

        public static /* synthetic */ void access$100(AppNetState r8, boolean r10) {
            r8.setForeground(r10);
        }

        public static /* synthetic */ String access$1000(AppNetState r8) {
            return r8.getPackageName();
        }

        public static /* synthetic */ boolean access$1200(AppNetState r8) {
            return r8.isNotSupportHandover();
        }

        public static /* synthetic */ void access$1300(AppNetState r8, boolean r10) {
            r8.setCellAccelerating(r10);
        }

        public static /* synthetic */ AppNetState access$200(String r8, boolean r10, boolean r11) {
            return create(r8, r10, r11);
        }

        public static /* synthetic */ boolean access$300(AppNetState r8) {
            return r8.isCellAccelerating();
        }

        public static /* synthetic */ Object access$400(AppNetState r8) {
            return r8.getObject();
        }

        public static /* synthetic */ boolean access$500(AppNetState r8) {
            return r8.isForeground();
        }

        public static /* synthetic */ boolean access$600(AppNetState r8) {
            return r8.isPinned();
        }

        public static /* synthetic */ String access$700(AppNetState r8) {
            return r8.packageName;
        }

        public static /* synthetic */ void access$800(AppNetState r8, boolean r10) {
            r8.setPinned(r10);
        }

        public static /* synthetic */ boolean access$900(AppNetState r8) {
            return r8.isSupportCellAcc();
        }

        private static AppNetState create(String r8, boolean r10, boolean r11) {
            return new AppNetState(r8, r10, r11);
        }

        private Object getObject() {
            return this.object;
        }

        private String getPackageName() {
            return this.packageName;
        }

        private boolean isCellAccelerating() {
            return this.isCellAccelerating;
        }

        private boolean isDataStall() {
            return this.isDataStall;
        }

        private boolean isForeground() {
            return this.isForeground;
        }

        private boolean isNotSupportHandover() {
            return this.isNotSupportHandover;
        }

        private boolean isPinned() {
            return this.isPinned;
        }

        private boolean isSupportCellAcc() {
            return this.isSupportCellAcc;
        }

        private void setCellAccelerating(boolean r8) {
            this.isCellAccelerating = r8;
        }

        private void setDataStall(boolean r8) {
            this.isDataStall = r8;
        }

        private void setForeground(boolean r8) {
            this.isForeground = r8;
        }

        private void setPinned(boolean r8) {
            this.isPinned = r8;
        }
    }

    public class AppNetworkHandler extends Handler {
        private static final int MSG_APP_NETWORK_UNBIND = 1;
        final /* synthetic */ NetworkPolicyCenter this$0;

        private AppNetworkHandler(NetworkPolicyCenter r8, HandlerThread r10) {
            this.this$0 = r8;
            super(r10.getLooper());
        }

        @Override // android.os.Handler
        public void handleMessage(Message r8) {
            super.handleMessage(r8);
            if (r8.what != 1) goto L7;
            NetworkPolicyCenter.access$1100(this.this$0, r8.obj);
            return;
        }

        public /* synthetic */ AppNetworkHandler(NetworkPolicyCenter r8, HandlerThread r10, AnonymousClass1 r11) {
            this(r8, r10);
        }
    }

    public NetworkPolicyCenter(Context r8, NetworkExecutor r10, NetworkHandoverMetrics r11) {
        this(r8, r10, r11, createHandlerThread());
    }

    public static /* synthetic */ void access$1100(NetworkPolicyCenter r8, Object r10) {
        r8.handleAppNetworkUnbindMsg(r10);
    }

    public static /* synthetic */ HandoverParameterManager access$1400(NetworkPolicyCenter r8) {
        return r8.mHandoverParameterManager;
    }

    public static /* synthetic */ NetworkExecutor access$1500(NetworkPolicyCenter r8) {
        return r8.mNetworkExecutor;
    }

    public static /* synthetic */ NetworkUnswitchLimiter access$1600(NetworkPolicyCenter r8) {
        return r8.mNetworkUnswitchLimiter;
    }

    public static /* synthetic */ NetworkHandoverMetrics access$1700(NetworkPolicyCenter r8) {
        return r8.mNetworkHandoverMetrics;
    }

    public static /* synthetic */ Context access$1800(NetworkPolicyCenter r8) {
        return r8.mContext;
    }

    public static /* synthetic */ FeatureStorage access$1900(NetworkPolicyCenter r8) {
        return r8.mFeatureStorage;
    }

    public static /* synthetic */ WifiCellSwitchMonitor access$2000(NetworkPolicyCenter r8) {
        return r8.mWifiCellSwitchMonitor;
    }

    public static /* synthetic */ boolean access$2102(NetworkPolicyCenter r8, boolean r10) {
        r8.mMakeDefaultCompleted = r10;
        return r10;
    }

    private void cancelAllAppNetworkAccelerate() {
        Iterator<AppNetState> r8 = this.mAppNetStateMap.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        AppNetState r10 = r8.next();
        if (AppNetState.access$300(r10) == false) goto L4;
        cancelAppNetworkAccelerate(AppNetState.access$1000(r10));
        goto L4
    }

    private void cancelAppNetworkAccelerate(final String r8) {
        final AppNetState r10 = this.mAppNetStateMap.get(r8);
        if (r10 != null) goto L7;
        CaeLog.e(TAG, "not found app net state. packageName: " + r8);
        return;
    L7:
        if (AppNetState.access$300(r10) == true) goto L10;
        CaeLog.i(TAG, "app network is not accelerating. packageName: " + r8);
        return;
    L10:
        final int r11 = NetworkUtil.getUidFromPackageName(this.mContext, r8);
        if (r11 != (-1)) goto L14;
        CaeLog.e(TAG, "invalid uid. packageName: " + r8);
        return;
    L14:
        Iterator<NetworkScore> r12 = this.mScores.values().iterator();
    L16:
        if (r12.hasNext() == false) goto L20;
        NetworkScore r13 = r12.next();
        if (r13.getNetType() != 1) goto L16;
    L21:
        if (r13 != null) goto L24;
        CaeLog.e(TAG, "wifi network not found.");
        return;
    L24:
        NetworkMonitor r14 = this.mNetworkMonitors.get(Integer.valueOf(r13.getNetId()));
        if (r14 != null) goto L29;
        CaeLog.e(TAG, "wifi network monitor not found.");
        return;
    L29:
        if (r13.hasPolicy(2) == false) goto L31;
        r14.startOnceDetectExternal(new AnonymousClass1(this, r11, r10, r8), 6);
        return;
    L31:
        CaeLog.d(TAG, "cancel app network accelerate failed. wifi network is not valid.");
        return;
    L20:
        r13 = null;
        goto L21
    }

    private static HandlerThread createHandlerThread() {
        HandlerThread r8 = new HandlerThread("NetworkPolicyCenterThread");
        r8.start();
        return r8;
    }

    private void forceCancelAllAppNetworkAccelerate() {
        Iterator<AppNetState> r8 = this.mAppNetStateMap.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        AppNetState r10 = r8.next();
        if (AppNetState.access$300(r10) == false) goto L4;
        forceCancelAppNetworkAccelerate(AppNetState.access$1000(r10));
        goto L4
    }

    private void forceCancelAppNetworkAccelerate(String r8) {
        AppNetState r10 = this.mAppNetStateMap.get(r8);
        if (r10 != null) goto L7;
        CaeLog.e(TAG, "not found app net state. packageName: " + r8);
        return;
    L7:
        if (AppNetState.access$300(r10) == true) goto L10;
        defpackage.b.o("app network is not accelerating. packageName: ", r8, TAG);
        return;
    L10:
        int r11 = NetworkUtil.getUidFromPackageName(this.mContext, r8);
        if (r11 != (-1)) goto L15;
        CaeLog.e(TAG, "invalid uid. packageName: " + r8);
        return;
    L15:
        if (this.mNetworkExecutor.tryCellToWifiForUid(r11) == false) goto L18;
        AppNetState.access$1300(r10, false);
        CaeLog.i(TAG, "force cancel app network accelerate success. packageName: " + r8);
        return;
    }

    private int getCellNetworkId() {
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        NetworkScore r10 = r8.next();
        if (r10.getNetType() != 0) goto L4;
        return r10.getNetId();
    L9:
        return -1;
    }

    private int getWifiNetworkId() {
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        NetworkScore r10 = r8.next();
        if (r10.getNetType() != 1) goto L4;
        return r10.getNetId();
    L9:
        return -1;
    }

    private void handleActivityPinned(String r8) {
        CaeLog.i(TAG, "handleActivityPinned packageName: " + r8);
        if (this.mAppNetStateMap.containsKey(r8) == false) goto L6;
        AppNetState.access$800(this.mAppNetStateMap.get(r8), true);
        return;
    }

    private void handleActivityUnpinned() {
        CaeLog.i(TAG, "handleActivityUnpinned");
        Iterator<AppNetState> r8 = this.mAppNetStateMap.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        AppNetState r10 = r8.next();
        if (AppNetState.access$600(r10) == false) goto L4;
        AppNetState.access$800(r10, false);
        if (AppNetState.access$300(r10) == false) goto L4;
        Message r11 = this.mAppNetworkHandler.obtainMessage(1, AppNetState.access$400(r10));
        StringBuilder r12 = new StringBuilder("wait ");
        r12.append(this.mHandoverParameterManager.getBackgroundAppUnbindTimeout());
        r12.append("ms, will send app network unbind msg. packageName: ");
        android.aimedia.a.r(r12, AppNetState.access$700(r10), TAG);
        this.mAppNetworkHandler.sendMessageDelayed(r11, this.mHandoverParameterManager.getBackgroundAppUnbindTimeout());
        goto L4
    }

    private void handleAospWifiScoreSwitch(int r8) {
        if (this.mAospWifiScoreState != 1) goto L5;
        return;
    L5:
        this.mAospWifiScoreState = 1;
        defpackage.a.i("AOSP Wi-Fi score update: switch (wifi→cell). score=", r8, TAG);
        selectNetworkAndExecute();
    }

    private void handleAospWifiScoreUnswitch(int r8) {
        if (this.mAospWifiScoreState != 0) goto L5;
        return;
    L5:
        this.mAospWifiScoreState = 0;
        defpackage.a.i("AOSP Wi-Fi score update: unswitch (cell→wifi). score=", r8, TAG);
        selectNetworkAndExecute();
    }

    private void handleAppDataStall(String r8) {
        AppNetState r10 = this.mAppNetStateMap.get(r8);
        if (r10 != null) goto L7;
        CaeLog.e(TAG, "app net data stall. but not found in mAppNetStateMap. packageName: " + r8);
        return;
    L7:
        if (AppNetState.access$900(r10) == false) goto L10;
        CaeLog.i(TAG, "app data stall. packageName: " + r8);
        makeAppNetworkAccelerate(this.mPackageName);
        return;
    }

    private void handleAppNetworkUnbindMsg(Object r8) {
        Iterator<AppNetState> r10 = this.mAppNetStateMap.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L15;
        AppNetState r11 = r10.next();
        if (AppNetState.access$400(r11) != r8) goto L4;
        if (AppNetState.access$300(r11) == false) goto L14;
        forceCancelAppNetworkAccelerate(AppNetState.access$1000(r11));
        return;
    L14:
        return;
    }

    private void handleBackgroundAppEvent(String r8) {
        this.mHasForegroundApp = false;
        this.mPackageName = r8;
        Iterator<AppNetState> r10 = this.mAppNetStateMap.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L16;
        AppNetState r11 = r10.next();
        if (AppNetState.access$500(r11) == false) goto L9;
        AppNetState.access$100(r11, false);
    L9:
        if (AppNetState.access$300(r11) == false) goto L4;
        if (AppNetState.access$600(r11) == true) goto L4;
        if (this.mAppNetworkHandler.hasMessages(1, AppNetState.access$400(r11)) == true) goto L4;
        Message r12 = this.mAppNetworkHandler.obtainMessage(1, AppNetState.access$400(r11));
        StringBuilder r13 = new StringBuilder("wait ");
        r13.append(this.mHandoverParameterManager.getBackgroundAppUnbindTimeout());
        r13.append("ms, will send app network unbind msg. packageName: ");
        android.aimedia.a.r(r13, AppNetState.access$700(r11), TAG);
        this.mAppNetworkHandler.sendMessageDelayed(r12, this.mHandoverParameterManager.getBackgroundAppUnbindTimeout());
        goto L4
    L16:
        this.mNetworkQoEInfoCollector.updateForegroundPackageName(r8);
    }

    private void handleDefaultNetworkChanged(Network r8) {
        StringBuilder r10 = new StringBuilder("default network changed to ");
        if (r8 != null) goto L5;
        String r11 = null;
    L6:
        android.aimedia.a.r(r10, r11, TAG);
        this.mNetworkQoEInfoCollector.updateDefaultNetwork(NetworkUtil.getNetworkType(this.mContext, r8));
        this.mDefaultNetwork = r8;
        selectNetworkAndExecute();
        return;
    L5:
        r11 = r8.toString();
        goto L6
    }

    private void handleDefaultNetworkSelected() {
        selectNetworkAndExecute();
    }

    private void handleDownloaderWorkStateChanged(int r8) {
        if (this.mDownloaderWorkState != r8) goto L5;
        return;
    L5:
        this.mDownloaderWorkState = r8;
        defpackage.a.i("update downloader work state: ", r8, TAG);
        selectNetworkAndExecute();
    }

    private void handleForegroundAppEvent(String r8) {
        this.mHasForegroundApp = true;
        this.mPackageName = r8;
        Iterator<AppNetState> r10 = this.mAppNetStateMap.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L7;
        AppNetState.access$100(r10.next(), false);
        goto L4
    L7:
        if (this.mAppNetStateMap.containsKey(r8) == false) goto L9;
        AppNetState r11 = this.mAppNetStateMap.get(r8);
    L10:
        AppNetState.access$100(r11, true);
        if (AppNetState.access$300(r11) == true) goto L13;
    L15:
        this.mNetworkQoEInfoCollector.updateForegroundPackageName(r8);
        selectNetworkAndExecute();
        return;
    L13:
        if (this.mAppNetworkHandler.hasMessages(1, AppNetState.access$400(r11)) == false) goto L15;
        CaeLog.i(TAG, "remove app network unbind msg. packageName: " + r8);
        this.mAppNetworkHandler.removeMessages(1, AppNetState.access$400(r11));
        goto L15
    L9:
        boolean r12 = this.mHandoverParameterManager.isAppInAccWhiteList(r8);
        boolean r13 = this.mHandoverParameterManager.isAppInHandoverBlackList(r8);
        AppNetState r14 = AppNetState.access$200(r8, r12, r13);
        StringBuilder r15 = new StringBuilder("app net state created. packageName: ");
        r15.append(r8);
        r15.append(" isNetAccSupport: ");
        r15.append(r12);
        r15.append(" isHandoverSupport: ");
        r15.append(!r13);
        CaeLog.i(TAG, r15.toString());
        this.mAppNetStateMap.put(r8, r14);
        r11 = r14;
        goto L10
    }

    private void handleHandoverCellDnsResolver() {
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L12;
        NetworkScore r10 = r8.next();
        if (r10.getNetType() != 0) goto L4;
        NetworkMonitor r11 = this.mNetworkMonitors.get(Integer.valueOf(r10.getNetId()));
        if (r11 == null) goto L10;
        r11.executeDnsResolve();
        goto L4
    L10:
        CaeLog.e(TAG, "mobile network monitor not found. netId: " + r10.getNetId());
        goto L4
    }

    private void handleMLPredictSwitch() {
        if (this.mPredictResult != 1) goto L5;
        return;
    L5:
        this.mPredictResult = 1;
        CaeLog.i(TAG, "update ML predict state: switch.");
        selectNetworkAndExecute();
    }

    private void handleMLPredictUnswitch() {
        if (this.mPredictResult != 0) goto L5;
        return;
    L5:
        this.mPredictResult = 0;
        CaeLog.i(TAG, "update ML predict state: unswitch.");
        selectNetworkAndExecute();
    }

    private void handleNetworkConnected(int r8, int r10) {
        NetworkScore r11 = this.mScores.get(Integer.valueOf(r8));
        if (r11 != null) goto L5;
        r11 = NetworkScore.create();
    L5:
        r11.setNetId(r8);
        r11.setNetType(r10);
        r11.addPolicy(1);
        r11.addPolicy(3);
        r11.addPolicy(4);
        CaeLog.i(TAG, "network connected. " + r11.toString());
        this.mScores.put(Integer.valueOf(r8), r11);
        if (this.mNetworkMonitors.get(Integer.valueOf(r8)) != null) goto L8;
        CaeLog.i(TAG, "network monitor created. " + r8);
        NetworkMonitor r12 = new NetworkMonitor(this.mContext, this.mNetworkExecutor, r8);
        r12.start();
        this.mNetworkMonitors.put(Integer.valueOf(r8), r12);
    L8:
        this.mNetworkHandoverMetrics.recordNetworkConnectedEvent(r8, r11);
        this.mNetworkQoEInfoCollector.updateNetworkStatus(r10, true);
        if (this.mModelSettingObserver.getRlHandoverEnabled() == false) goto L12;
        this.mPredictResult = 0;
        return;
    }

    private void handleNetworkDisconnected(int r8) {
        NetworkScore r10 = this.mScores.get(Integer.valueOf(r8));
        if (r10 == null) goto L8;
        if (r10.getNetType() != 0) goto L8;
        resetWifiNetworkPolicy();
    L8:
        if (this.mScores.containsKey(Integer.valueOf(r8)) == false) goto L11;
        this.mNetworkQoEInfoCollector.updateNetworkStatus(this.mScores.get(Integer.valueOf(r8)).getNetType(), false);
        this.mScores.remove(Integer.valueOf(r8));
        CaeLog.i(TAG, "network disconnected. " + r8);
    L11:
        if (this.mNetworkMonitors.containsKey(Integer.valueOf(r8)) == false) goto L13;
        this.mNetworkMonitors.get(Integer.valueOf(r8)).stop();
        this.mNetworkMonitors.remove(Integer.valueOf(r8));
        CaeLog.i(TAG, "network monitor removed. " + r8);
    L13:
        forceCancelAllAppNetworkAccelerate();
        this.mNetworkHandoverMetrics.recordNetworkDisconnectedEvent(r8);
        if (this.mModelSettingObserver.getRlHandoverEnabled() == false) goto L16;
        this.mPredictResult = 0;
    L16:
        this.mAospWifiScoreState = 0;
    }

    private void handleNetworkInvalidated(int r8, int r10) {
        NetworkScore r11 = this.mScores.get(Integer.valueOf(r8));
        if (r11 != null) goto L7;
        android.aimedia.a.p("network invalidated. but not found in mScores. netId: ", r8, TAG);
        return;
    L7:
        if (r11.hasPolicy(2) == true) goto L9;
        return;
    L9:
        r11.removePolicy(2);
        CaeLog.i(TAG, "remove valid policy for " + r8 + ". " + r11.toString());
        this.mNetworkHandoverMetrics.recordNetworkScoreChangeEvent(r11);
        this.mNetworkQoEInfoCollector.updateNetworkValidity(r10, false);
        selectNetworkAndExecute();
    }

    private void handleNetworkL2QoEBad(int r8) {
        Iterator<NetworkScore> r10 = this.mScores.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        NetworkScore r11 = r10.next();
        if (r11.getNetType() != r8) goto L4;
        if (r11.hasPolicy(3) == false) goto L18;
        r11.removePolicy(3);
        CaeLog.i(TAG, "remove l2 qoe good policy for " + r11.getNetId() + ". " + r11.toString());
        this.mNetworkHandoverMetrics.recordNetworkScoreChangeEvent(r11);
        selectNetworkAndExecute();
        goto L4
    L18:
        return;
    }

    private void handleNetworkL2QoEGood(int r8) {
        Iterator<NetworkScore> r10 = this.mScores.values().iterator();
    L4:
        if (r10.hasNext() == false) goto L11;
        NetworkScore r11 = r10.next();
        if (r11.getNetType() != r8) goto L4;
        if (r11.hasPolicy(3) == true) goto L18;
        r11.addPolicy(3);
        CaeLog.i(TAG, "add l2 qoe good policy for " + r11.getNetId() + ". " + r11.toString());
        this.mNetworkHandoverMetrics.recordNetworkScoreChangeEvent(r11);
        selectNetworkAndExecute();
        goto L4
    L18:
        return;
    }

    private void handleNetworkL4QoEBad(int r8) {
        NetworkScore r10 = this.mScores.get(Integer.valueOf(r8));
        if (r10 != null) goto L7;
        android.aimedia.a.p("network l4 qoe bad. but not found in mScores. netId: ", r8, TAG);
        return;
    L7:
        if (r10.hasPolicy(4) == true) goto L9;
        return;
    L9:
        r10.removePolicy(4);
        CaeLog.i(TAG, "remove l4 qoe good policy for " + r8 + ". " + r10.toString());
        this.mNetworkHandoverMetrics.recordNetworkScoreChangeEvent(r10);
        selectNetworkAndExecute();
    }

    private void handleNetworkL4QoEGood(int r8) {
        NetworkScore r10 = this.mScores.get(Integer.valueOf(r8));
        if (r10 != null) goto L6;
        return;
    L6:
        if (r10.hasPolicy(4) == false) goto L8;
        return;
    L8:
        r10.addPolicy(4);
        CaeLog.i(TAG, "add l4 qoe good policy for " + r8 + ". " + r10.toString());
        this.mNetworkHandoverMetrics.recordNetworkScoreChangeEvent(r10);
        selectNetworkAndExecute();
    }

    private void handleNetworkValidated(int r8, int r10) {
        NetworkScore r11 = this.mScores.get(Integer.valueOf(r8));
        if (r11 != null) goto L7;
        android.aimedia.a.p("network validated. but not found in mScores. netId: ", r8, TAG);
        return;
    L7:
        if (r11.hasPolicy(2) == false) goto L9;
        return;
    L9:
        r11.addPolicy(2);
        CaeLog.i(TAG, "add valid policy for " + r8 + ". " + r11.toString());
        this.mNetworkHandoverMetrics.recordNetworkScoreChangeEvent(r11);
        this.mNetworkQoEInfoCollector.updateNetworkValidity(r10, true);
        selectNetworkAndExecute();
    }

    private void handleSwitchLimitStateChanged(int r8) {
        if (r8 != 1) goto L5;
        String r10 = "enforce limit";
    L6:
        CaeLog.i(TAG, "switch limit state changed to ".concat(r10));
        this.mSwitchLimitState = r8;
        if (r8 != 2) goto L10;
        selectNetworkAndExecute();
        return;
    L10:
        return;
    L5:
        r10 = "release limit";
        goto L6
    }

    private void handleTrafficMonitorStateChanged(int r8, int r10) {
        if (this.mTrafficMonitorState == r8) goto L5;
    L7:
        StringBuilder r11 = new StringBuilder("traffic monitor state changed to ");
        if (r8 != 1) goto L10;
        String r12 = "warning";
    L11:
        r11.append(r12);
        r11.append(", warning type: ");
        r11.append(r10);
        CaeLog.i(TAG, r11.toString());
        this.mTrafficMonitorState = r8;
        this.mTrafficWarningType = r10;
        selectNetworkAndExecute();
        return;
    L10:
        r12 = "normal";
        goto L11
    L5:
        if (this.mTrafficWarningType != r10) goto L7;
    }

    private boolean hasCellNetwork() {
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L9;
        if (r8.next().getNetType() != 0) goto L4;
        return true;
    L9:
        return false;
    }

    private boolean hasWifiNetwork() {
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        if (r8.next().getNetType() != 1) goto L4;
        return true;
    L8:
        return false;
    }

    private boolean isInvalidNetwork(int r8) {
        NetworkScore r10 = this.mScores.get(Integer.valueOf(r8));
        if (r10 != null) goto L7;
        return false;
    L7:
        return !r10.hasPolicy(2);
    }

    private boolean isL2QoEBadNetwork(int r8) {
        NetworkScore r10 = this.mScores.get(Integer.valueOf(r8));
        if (r10 != null) goto L7;
        return false;
    L7:
        return !r10.hasPolicy(3);
    }

    private boolean isL4QoEBadNetwork(int r8) {
        NetworkScore r10 = this.mScores.get(Integer.valueOf(r8));
        if (r10 != null) goto L7;
        return false;
    L7:
        return !r10.hasPolicy(4);
    }

    private boolean isManagedNetwork(int r8) {
        return this.mScores.containsKey(Integer.valueOf(r8));
    }

    private boolean isNetworkSwitchLimited() {
        if (this.mSwitchLimitState == 1) goto L7;
        return false;
    L7:
        return true;
    }

    private boolean isNetworkUnswitchLimited(int r8) {
        if (NetworkUtil.getNetworkTypeForNetId(this.mContext, r8) == 1) goto L5;
        return false;
    L5:
        return this.mNetworkUnswitchLimiter.isNetworkUnswitchLimited();
    }

    private boolean isWifiNetworkInvalid() {
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L10;
        NetworkScore r10 = r8.next();
        if (r10.getNetType() != 1) goto L4;
        if (r10.hasPolicy(2) == true) goto L4;
        return true;
    L10:
        return false;
    }

    private void makeAppNetworkAccelerate(final String r8) {
        Network r10 = NetworkUtil.getDefaultNetwork(this.mContext);
        if (r10 != null) goto L7;
        CaeLog.e(TAG, "app network accelerate failed. current network is null.");
        return;
    L7:
        if (NetworkUtil.getNetworkType(this.mContext, r10) != 0) goto L10;
        CaeLog.d(TAG, "app network accelerate failed. current network is mobile.");
        return;
    L10:
        final AppNetState r11 = this.mAppNetStateMap.get(r8);
        if (r11 != null) goto L15;
        CaeLog.e(TAG, "not found app net state. packageName: " + r8);
        return;
    L15:
        if (AppNetState.access$300(r11) == false) goto L18;
        CaeLog.i(TAG, "app network is already accelerating. packageName: " + r8);
        return;
    L18:
        final int r12 = NetworkUtil.getUidFromPackageName(this.mContext, r8);
        if (r12 != (-1)) goto L22;
        CaeLog.e(TAG, "app network accelerate failed. invalid uid. packageName: " + r8);
        return;
    L22:
        Iterator<NetworkScore> r13 = this.mScores.values().iterator();
    L24:
        if (r13.hasNext() == false) goto L28;
        NetworkScore r14 = r13.next();
        if (r14.getNetType() != 0) goto L24;
    L29:
        if (r14 != null) goto L32;
        CaeLog.e(TAG, "app network accelerate failed. not found best mobile network.");
        return;
    L32:
        NetworkMonitor r15 = this.mNetworkMonitors.get(Integer.valueOf(r14.getNetId()));
        if (r15 != null) goto L37;
        CaeLog.e(TAG, "app network accelerate failed. not found best mobile network monitor.");
        return;
    L37:
        if (r14.hasPolicy(2) == false) goto L39;
        r15.startOnceDetectExternal(new AnonymousClass2(this, r12, r11, r8), 6);
        return;
    L39:
        CaeLog.i(TAG, "app network accelerate failed. mobile network is not valid.");
        return;
    L28:
        r14 = null;
        goto L29
    }

    private void makeDefaultNetwork(final int r8, final int r10) {
        if (r8 == (-1)) goto L20;
        if (r10 == (-1)) goto L20;
        if (this.mMakeDefaultCompleted == true) goto L11;
        CaeLog.i(TAG, "network switch is running, so abandon network switch.");
        return;
    L11:
        if (this.mScores.get(Integer.valueOf(r10)) != null) goto L14;
        android.aimedia.a.p("best network not found in mScores. netId: ", r10, TAG);
        return;
    L14:
        NetworkMonitor r11 = this.mNetworkMonitors.get(Integer.valueOf(r10));
        if (r11 != null) goto L18;
        android.aimedia.a.p("best network monitor not found in mNetworkMonitors. netId: ", r10, TAG);
        return;
    L18:
        this.mMakeDefaultCompleted = false;
        r11.startOnceDetectExternal(new AnonymousClass3(this, r10, r8), 6);
        return;
    L20:
        CaeLog.e(TAG, "invalid netId. currentNetId: " + r8 + ", bestNetId: " + r10);
    }

    private void resetWifiNetworkPolicy() {
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        NetworkScore r10 = r8.next();
        if (r10.getNetType() != 1) goto L4;
        this.mNetworkExecutor.resetNetworkPolicy(r10.getNetId());
        goto L4
    }

    private void selectNetworkAndExecute() {
        if (this.mHasForegroundApp == true) goto L5;
        return;
    L5:
        if (this.mPackageName == null) goto L133;
        Network r8 = NetworkUtil.getDefaultNetwork(this.mContext);
        this.mDefaultNetwork = r8;
        if (r8 != null) goto L11;
        return;
    L11:
        if (isWifiNetworkInvalid() == false) goto L15;
        CaeLog.i(TAG, "wifi network is invalid. network select follow AOSP policy.");
        return;
    L15:
        if (this.mModelSettingObserver.getRlHandoverEnabled() == true) goto L17;
        NetworkRanker r10 = this.mNetworkRanker;
        ArrayList r11 = new ArrayList(this.mScores.values());
    L21:
        int r12 = r10.getBestNetwork(r11);
        this.mNetworkHandoverMetrics.recordNetworkHandoverReason(2);
    L23:
        if (NetworkUtil.getNetworkTypeForNetId(this.mContext, r12) != 1) goto L28;
        r12 = this.mNetworkRanker.getAOSPBestNetwork(new ArrayList(this.mScores.values()), this.mAospWifiScoreState);
        if (NetworkUtil.getNetworkTypeForNetId(this.mContext, r12) != 0) goto L28;
        defpackage.a.i("execute AOSP Score policy and best network is mobile. bestNetId: ", r12, TAG);
        this.mNetworkHandoverMetrics.recordNetworkHandoverReason(3);
    L28:
        if (r12 != (-1)) goto L31;
        CaeLog.d(TAG, "no valid network found. abandon network selection.");
        return;
    L31:
        int r13 = Integer.parseInt(this.mDefaultNetwork.toString());
        int r14 = NetworkUtil.getNetworkTypeForNetId(this.mContext, r13);
        if (isManagedNetwork(r13) == true) goto L35;
        defpackage.a.i("current network is not managed. abandon network selection. currentType: ", r14, TAG);
        return;
    L35:
        AppNetState r15 = this.mAppNetStateMap.get(this.mPackageName);
        if (r15 != null) goto L39;
        CaeLog.e(TAG, "not found app net state. packageName: " + this.mPackageName);
        return;
    L39:
        int r16 = NetworkUtil.getNetworkTypeForNetId(this.mContext, r12);
        if (r13 == r12) goto L97;
        CaeLog.i(TAG, "current network: " + r13 + ", best network: " + r12);
        if (isNetworkSwitchLimited() == false) goto L45;
        CaeLog.i(TAG, "network switch is limited, abandon network selection.");
        this.mNetworkHandoverMetrics.reportHandoverFail(r13, r12, 40);
        return;
    L45:
        if (r16 == 0) goto L60;
        if (r16 == 1) goto L49;
        return;
    L49:
        if (AppNetState.access$1200(r15) == false) goto L52;
        CaeLog.i(TAG, AppNetState.access$1000(r15) + " is not support handover. so default network need to switch to wifi");
    L124:
        makeDefaultNetwork(r13, r12);
        return;
    L52:
        if (isNetworkUnswitchLimited(r12) == false) goto L56;
        CaeLog.i(TAG, "switch dwell time less than 60 seconds, unable to switch back to wifi.");
        return;
    L56:
        if (NetworkUtil.isWeakSignalWifi(this.mContext) == false) goto L124;
        CaeLog.i(TAG, "wifi signal is weak, unable to switch back to wifi.");
        return;
    L60:
        if (AppNetState.access$1200(r15) == false) goto L64;
        CaeLog.i(TAG, AppNetState.access$1000(r15) + " not support network handover.");
        this.mNetworkHandoverMetrics.reportHandoverFail(r13, r12, 20);
        return;
    L64:
        if (this.mTrafficMonitorState != 1) goto L72;
        defpackage.b.p(new StringBuilder("traffic monitor state is warning, disable network handover. warning type: "), this.mTrafficWarningType, TAG);
        NetworkHandoverMetrics r17 = this.mNetworkHandoverMetrics;
        if (this.mTrafficWarningType != 1) goto L68;
        int r18 = 30;
    L69:
        r17.reportHandoverFail(r13, r12, r18);
        return;
    L68:
        r18 = 31;
        goto L69
    L72:
        if (this.mDownloaderWorkState != 1) goto L76;
        CaeLog.i(TAG, "downloader is working, disable network handover.");
        this.mNetworkHandoverMetrics.reportHandoverFail(r13, r12, 21);
        return;
    L76:
        if (NetworkUtil.isLowStandardCell(this.mContext) == false) goto L80;
        CaeLog.i(TAG, "cell network is low standard, disable network handover.");
        this.mNetworkHandoverMetrics.reportHandoverFail(r13, r12, 13);
        return;
    L80:
        if (NetworkUtil.isWeakSignalCell(this.mContext) == false) goto L84;
        CaeLog.i(TAG, "cell network is weak signal, disable network handover.");
        this.mNetworkHandoverMetrics.reportHandoverFail(r13, r12, 14);
        return;
    L84:
        if (isL2QoEBadNetwork(r12) == false) goto L88;
        CaeLog.i(TAG, "cell network is l2 qoe bad, disable network handover.");
        this.mNetworkHandoverMetrics.reportHandoverFail(r13, r12, 15);
        return;
    L88:
        if (isL4QoEBadNetwork(r12) == false) goto L92;
        CaeLog.i(TAG, "cell network is l4 qoe bad, disable network handover.");
        this.mNetworkHandoverMetrics.reportHandoverFail(r13, r12, 16);
        return;
    L92:
        if (AppNetState.access$900(r15) == false) goto L124;
        if (AppNetState.access$300(r15) == false) goto L96;
        return;
    L96:
        makeAppNetworkAccelerate(this.mPackageName);
        return;
    L97:
        if (r16 == 0) goto L112;
        if (r16 != 1) goto L135;
        cancelAllAppNetworkAccelerate();
        if (isL2QoEBadNetwork(r13) == true) goto L105;
        if (isL4QoEBadNetwork(r13) == true) goto L105;
        return;
    L105:
        if (NetworkUtil.isSimStateReady(this.mContext) == true) goto L108;
        CaeLog.i(TAG, "sim state is not ready, unable network handover.");
        NetworkHandoverMetrics r19 = this.mNetworkHandoverMetrics;
        int r20 = 10;
    L110:
        r19.reportHandoverFail(r13, -1, r20);
        return;
    L108:
        if (NetworkUtil.isCellDataEnabled(this.mContext) == true) goto L129;
        CaeLog.i(TAG, "cell data is disabled, unable network handover.");
        r19 = this.mNetworkHandoverMetrics;
        r20 = 11;
        goto L110
    L129:
        return;
    L135:
        return;
    L112:
        if (hasWifiNetwork() == false) goto L131;
        forceCancelAllAppNetworkAccelerate();
        if (AppNetState.access$1200(r15) == false) goto L117;
        StringBuilder r21 = new StringBuilder();
        r21.append(AppNetState.access$1000(r15));
        r21.append(" is not support handover. so default network need to switch to wifi");
    L119:
        String r22 = r21.toString();
    L123:
        CaeLog.i(TAG, r22);
        r12 = getWifiNetworkId();
        goto L124
    L117:
        if (this.mTrafficMonitorState != 1) goto L121;
        r21 = new StringBuilder("traffic monitor state is warning, type: ");
        r21.append(this.mTrafficWarningType);
        r21.append(" so default network need to switch to wifi");
        goto L119
    L121:
        if (this.mDownloaderWorkState != 1) goto L132;
        r22 = "downloader is working, so default network need to switch to wifi";
        goto L123
    L132:
        return;
    L131:
        return;
    L17:
        if (this.mNetworkSwitchPolicyML.isAvailable() == false) goto L19;
        r12 = this.mNetworkRanker.getPredictBestNetwork(new ArrayList(this.mScores.values()), this.mPredictResult);
        this.mNetworkHandoverMetrics.recordNetworkHandoverReason(1);
        goto L23
    L19:
        CaeLog.i(TAG, "ML model is not available. network handover fallback to rule policy.");
        r10 = this.mNetworkRanker;
        r11 = new ArrayList(this.mScores.values());
        goto L21
    }

    @Override // android.os.Handler
    public void handleMessage(Message r8) {
        super.handleMessage(r8);
        switch(r8.what) {
            case 1: goto L27;
            case 2: goto L26;
            case 3: goto L25;
            case 4: goto L24;
            case 5: goto L23;
            case 6: goto L22;
            case 7: goto L21;
            case 8: goto L20;
            case 9: goto L19;
            case 10: goto L18;
            case 11: goto L17;
            case 12: goto L16;
            case 13: goto L15;
            case 14: goto L14;
            case 15: goto L13;
            case 16: goto L12;
            case 17: goto L11;
            case 18: goto L10;
            case 19: goto L9;
            case 20: goto L8;
            case 21: goto L7;
            case 22: goto L6;
            case 23: goto L5;
            default: goto L51;
        };
    L5:
        handleHandoverCellDnsResolver();
        return;
    L6:
        handleAospWifiScoreUnswitch(r8.arg1);
        return;
    L7:
        handleAospWifiScoreSwitch(r8.arg1);
        return;
    L8:
        handleDownloaderWorkStateChanged(r8.arg1);
        return;
    L9:
        handleMLPredictUnswitch();
        return;
    L10:
        handleMLPredictSwitch();
        return;
    L11:
        handleActivityUnpinned();
        return;
    L12:
        handleActivityPinned((String) r8.obj);
        return;
    L13:
        handleTrafficMonitorStateChanged(r8.arg1, r8.arg2);
        return;
    L14:
        handleAppDataStall((String) r8.obj);
        return;
    L15:
        handleDefaultNetworkSelected();
        return;
    L16:
        handleSwitchLimitStateChanged(r8.arg1);
        return;
    L17:
        handleDefaultNetworkChanged((Network) r8.obj);
        return;
    L18:
        handleForegroundAppEvent((String) r8.obj);
        return;
    L19:
        handleBackgroundAppEvent((String) r8.obj);
        return;
    L20:
        handleNetworkL4QoEBad(r8.arg1);
        return;
    L21:
        handleNetworkL4QoEGood(r8.arg1);
        return;
    L22:
        handleNetworkL2QoEBad(r8.arg1);
        return;
    L23:
        handleNetworkL2QoEGood(r8.arg1);
        return;
    L24:
        handleNetworkInvalidated(r8.arg1, r8.arg2);
        return;
    L25:
        handleNetworkValidated(r8.arg1, r8.arg2);
        return;
    L26:
        handleNetworkDisconnected(r8.arg1);
        return;
    L27:
        handleNetworkConnected(r8.arg1, r8.arg2);
        return;
    }

    public void start() {
    }

    public void stop() {
        this.mDefaultNetwork = null;
        this.mMakeDefaultCompleted = true;
        this.mHasForegroundApp = false;
        this.mSwitchLimitState = 2;
        Iterator<NetworkScore> r8 = this.mScores.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L8;
        NetworkScore r10 = r8.next();
        if (r10.getNetType() != 1) goto L4;
        this.mNetworkExecutor.resetNetworkPolicy(r10.getNetId());
        goto L4
    L8:
        this.mScores.clear();
    }

    private NetworkPolicyCenter(Context r8, NetworkExecutor r10, NetworkHandoverMetrics r11, HandlerThread r12) {
        super(r12.getLooper());
        this.mScores = new HashMap();
        this.mNetworkMonitors = new HashMap();
        this.mAppNetStateMap = new HashMap();
        this.mDefaultNetwork = null;
        this.mSwitchLimitState = 2;
        this.mMakeDefaultCompleted = true;
        this.mHasForegroundApp = false;
        this.mPackageName = null;
        this.mTrafficMonitorState = 2;
        this.mTrafficWarningType = 0;
        this.mPredictResult = 0;
        this.mDownloaderWorkState = 0;
        this.mAospWifiScoreState = 0;
        this.mContext = r8;
        this.mNetworkRanker = new NetworkRanker();
        this.mNetworkExecutor = r10;
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(r8);
        this.mNetworkHandoverMetrics = r11;
        this.mNetworkQoEInfoCollector = NetworkQoEInfoCollector.getInstance(r8);
        this.mHandlerThread = r12;
        this.mAppNetworkHandler = new AppNetworkHandler(this, r12, null);
        this.mFeatureStorage = FeatureStorage.getInstance(r8);
        this.mWifiCellSwitchMonitor = WifiCellSwitchMonitor.getInstance(r8);
        this.mModelSettingObserver = ModelSettingObserver.getInstance(r8);
        this.mNetworkUnswitchLimiter = NetworkUnswitchLimiter.getInstance(r8);
        this.mNetworkSwitchPolicyML = NetworkSwitchPolicyML.getInstance(r8);
    }
}
