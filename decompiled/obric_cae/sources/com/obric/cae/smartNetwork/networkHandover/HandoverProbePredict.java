package com.obric.cae.smartNetwork.networkHandover;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import com.bytedance.bdlocation.client.LocationInfoConst;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.networkHandoverRL.ModelSettingObserver;
import com.obric.cae.smartNetwork.networkHandoverRL.NetworkSwitchPolicyML;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureCallback;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.FeatureManager;
import com.obric.cae.smartNetwork.networkMonitor.ActivityMonitor;

/* JADX INFO: loaded from: classes2.dex */
public class HandoverProbePredict {
    public static final int PREDICT_STATE_SWITCH = 1;
    public static final int PREDICT_STATE_UNSWITCH = 0;
    private static final String TAG = "HandoverProbePredict";
    private ActivityMonitor mActivityMonitor;
    private final ActivityMonitor.ActivityMonitorListener mActivityMonitorListener;
    private Context mContext;
    private int mContinuousHighCount;
    private boolean mEMAInitialized;
    private final FeatureCallback mFeatureCallback;
    private FeatureManager mFeatureManager;
    private String mForegroundPackageName;
    private HandoverParameterManager mHandoverParameterManager;
    private boolean mIsRunning;
    private float mLastEMA;
    private final Object mLock;
    private ModelSettingObserver mModelSettingObserver;
    private NetworkPolicyCenter mNetworkPolicyCenter;
    private final BroadcastReceiver mNetworkStateChangeReceiver;
    private NetworkSwitchPolicyML mNetworkSwitchPolicyML;
    private final ScenarioMonitor mScenarioMonitor;
    private boolean mWifiConnected;

    public HandoverProbePredict(Context r8, FeatureManager r10, NetworkPolicyCenter r11) {
        this.mLock = new Object();
        this.mIsRunning = false;
        this.mWifiConnected = false;
        this.mLastEMA = 0.0f;
        this.mEMAInitialized = false;
        this.mContinuousHighCount = 0;
        this.mForegroundPackageName = "";
        this.mFeatureCallback = new AnonymousClass1(this);
        this.mNetworkStateChangeReceiver = new AnonymousClass2(this);
        this.mActivityMonitorListener = new AnonymousClass3(this);
        this.mContext = r8;
        this.mFeatureManager = r10;
        this.mNetworkPolicyCenter = r11;
        this.mNetworkSwitchPolicyML = NetworkSwitchPolicyML.getInstance(r8);
        this.mModelSettingObserver = ModelSettingObserver.getInstance(this.mContext);
        this.mScenarioMonitor = ScenarioMonitor.getInstance(this.mContext);
        this.mActivityMonitor = ActivityMonitor.getInstance(this.mContext);
        this.mHandoverParameterManager = HandoverParameterManager.getInstance(this.mContext);
        this.mForegroundPackageName = this.mActivityMonitor.getPackageName();
    }

    public static /* synthetic */ String access$000(HandoverProbePredict r8) {
        return r8.mForegroundPackageName;
    }

    public static /* synthetic */ String access$002(HandoverProbePredict r8, String r10) {
        r8.mForegroundPackageName = r10;
        return r10;
    }

    public static /* synthetic */ HandoverParameterManager access$100(HandoverProbePredict r8) {
        return r8.mHandoverParameterManager;
    }

    public static /* synthetic */ NetworkSwitchPolicyML access$200(HandoverProbePredict r8) {
        return r8.mNetworkSwitchPolicyML;
    }

    public static /* synthetic */ Object access$300(HandoverProbePredict r8) {
        return r8.mLock;
    }

    public static /* synthetic */ void access$400(HandoverProbePredict r8, float r10, float r11) {
        r8.calculatePredictResult(r10, r11);
    }

    public static /* synthetic */ boolean access$500(HandoverProbePredict r8) {
        return r8.mWifiConnected;
    }

    public static /* synthetic */ boolean access$502(HandoverProbePredict r8, boolean r10) {
        r8.mWifiConnected = r10;
        return r10;
    }

    public static /* synthetic */ float access$602(HandoverProbePredict r8, float r10) {
        r8.mLastEMA = r10;
        return r10;
    }

    public static /* synthetic */ boolean access$702(HandoverProbePredict r8, boolean r10) {
        r8.mEMAInitialized = r10;
        return r10;
    }

    public static /* synthetic */ int access$802(HandoverProbePredict r8, int r10) {
        r8.mContinuousHighCount = r10;
        return r10;
    }

    private float calculateEMA(float r8, float r10) {
        if (this.mEMAInitialized == true) goto L6;
        this.mLastEMA = r8;
        this.mEMAInitialized = true;
        return r8;
    L6:
        float r11 = r8 * r10;
        float r12 = ((1.0f - r10) * this.mLastEMA) + r11;
        this.mLastEMA = r12;
        return r12;
    }

    private void calculatePredictResult(float r24, float r25) {
        float r8 = getCurrentAlpha();
        float r10 = this.mModelSettingObserver.getSmoothHandoverThreshold();
        float r11 = this.mModelSettingObserver.getContinuousHandoverThreshold();
        float r12 = this.mHandoverParameterManager.getCellDnsPreresolveThreshold() / 100.0f;
        int r13 = getCurrentContinuousCount();
        float r14 = calculateEMA(r24, r8);
        if (r24 < r11) goto L5;
        this.mContinuousHighCount++;
    L7:
        if (r14 < r10) goto L9;
        boolean r15 = true;
    L11:
        if (this.mContinuousHighCount < r13) goto L13;
        boolean r16 = true;
    L15:
        if (r14 < r12) goto L17;
        boolean r17 = true;
    L18:
        CaeLog.i(TAG, String.format("Predict: raw=%.3f, l24weight=%.2f, EMA=%.3f, alpha=%.2f, smooth_thresh=%.2f, continuous_count=%d, continuous_high_thresh=%.2f, continuous_count_thresh=%d, is_aggressive=%b, switch_by_smooth=%b, switch_by_continuous=%b", new Object[]{Float.valueOf(r24), Float.valueOf(r25), Float.valueOf(r14), Float.valueOf(r8), Float.valueOf(r10), Integer.valueOf(this.mContinuousHighCount), Float.valueOf(r11), Integer.valueOf(r13), Boolean.valueOf(this.mScenarioMonitor.isAggressiveScenario()), Boolean.valueOf(r15), Boolean.valueOf(r16)}));
        if (r17 == false) goto L21;
        this.mNetworkPolicyCenter.sendEmptyMessage(23);
    L21:
        if (r15 == true) goto L27;
        if (r16 == true) goto L27;
        if (r14 > this.mModelSettingObserver.getPredictUnswitchThreshold()) goto L34;
        NetworkPolicyCenter r18 = this.mNetworkPolicyCenter;
        int r19 = 19;
    L32:
        r18.sendEmptyMessage(r19);
        return;
    L34:
        return;
    L27:
        Object[] r20 = new Object[4];
        r20[0] = Float.valueOf(r24);
        r20[1] = Float.valueOf(r14);
        r20[2] = Integer.valueOf(this.mContinuousHighCount);
        if (r16 == false) goto L30;
        String r21 = LocationInfoConst.CONTINUE;
    L31:
        r20[3] = r21;
        CaeLog.i(TAG, String.format("Trigger switch! raw=%.3f, EMA=%.3f, continuous_high=%d, reason=%s", r20));
        r18 = this.mNetworkPolicyCenter;
        r19 = 18;
        goto L32
    L30:
        r21 = "smooth";
        goto L31
    L17:
        r17 = false;
        goto L18
    L13:
        r16 = false;
        goto L15
    L9:
        r15 = false;
        goto L11
    L5:
        this.mContinuousHighCount = 0;
        goto L7
    }

    private float getCurrentAlpha() {
        boolean r8 = this.mScenarioMonitor.isAggressiveScenario();
        ModelSettingObserver r10 = this.mModelSettingObserver;
        if (r8 == false) goto L7;
        return r10.getEmaAlphaAggressive();
    L7:
        return r10.getEmaAlphaDefault();
    }

    private int getCurrentContinuousCount() {
        boolean r8 = this.mScenarioMonitor.isAggressiveScenario();
        ModelSettingObserver r10 = this.mModelSettingObserver;
        if (r8 == false) goto L7;
        return r10.getContinuousCountAggressive();
    L7:
        return r10.getContinuousCountDefault();
    }

    public void start() {
        if (this.mIsRunning == false) goto L5;
        return;
    L5:
        this.mIsRunning = true;
        CaeLog.i(TAG, "start HandoverProbePredict.");
        this.mFeatureManager.registerCallback(this.mFeatureCallback);
        this.mContext.registerReceiver(this.mNetworkStateChangeReceiver, new IntentFilter("android.net.wifi.STATE_CHANGE"));
        this.mActivityMonitor.registerActivityListener(this.mActivityMonitorListener);
    }

    public void stop() {
        if (this.mIsRunning == true) goto L5;
        return;
    L5:
        this.mIsRunning = false;
        CaeLog.i(TAG, "stop HandoverProbePredict.");
        this.mFeatureManager.unregisterCallback(this.mFeatureCallback);
        this.mContext.unregisterReceiver(this.mNetworkStateChangeReceiver);
        this.mActivityMonitor.unregisterActivityListener(this.mActivityMonitorListener);
    }
}
