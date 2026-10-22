package com.obric.cae.smartNetwork.networkRateLimit;

import android.content.Context;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.L4NetEvaluate.L4NetEvaluateObserver;
import com.obric.cae.smartNetwork.networkHandoverRL.feature.AppCategoryHelper;
import defpackage.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class RateStrategyManager {
    private static final int CELLULAR_BACKGROUND_RATE_LIMIT_DEFAULT = 2048;
    private static final int CELLULAR_FOREGROUND_RATE_LIMIT_DEFAULT = 10240;
    private static final int[][] RATE_PERCENTAGE = null;
    private static final String TAG = "RateStrategyManager";
    private final AppRateLimitManager mAppRateLimitManager;
    private int mBackgroundOthersRateLimit;
    private boolean mBackgroundRateLimitSetCauseForegroundRtt;
    private final Context mContext;
    private TrafficControlConfig.AppClassType mForegroundClassType;
    private int mForegroundRateLimit;
    private final TrafficControlConfig mNetTCConfig;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkRateLimit.RateStrategyManager$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType = null;

        static {
            int[] r8 = new int[RateControlManager.AppCtrlType.values().length];
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType = r8;
            r8[RateControlManager.AppCtrlType.FOREGROUND.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[RateControlManager.AppCtrlType.BACKGROUND_1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[RateControlManager.AppCtrlType.BACKGROUND_2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            $SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[RateControlManager.AppCtrlType.BACKGROUND_3.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static class StrategyContext {
        public int backgroundOthersRateNow;
        public boolean isForegroundRttOverThreshold;
        public boolean isTragetNetifWlan;
        public int maxBandWidthEstimatedVal;

        public StrategyContext(int r8, int r10, boolean r11, boolean r12) {
            this.maxBandWidthEstimatedVal = r8;
            this.backgroundOthersRateNow = r10;
            this.isForegroundRttOverThreshold = r11;
            this.isTragetNetifWlan = r12;
        }
    }

    static {
        RATE_PERCENTAGE = new int[][]{new int[]{0, 0, 0, 0, 35}, new int[]{50, 10, 5, 5, 5}, new int[]{30, 0, 0, 0, 0}};
    }

    public RateStrategyManager(Context r8, TrafficControlConfig r10, AppRateLimitManager r11) {
        this.mBackgroundOthersRateLimit = 0;
        this.mForegroundRateLimit = 0;
        this.mBackgroundRateLimitSetCauseForegroundRtt = false;
        this.mForegroundClassType = TrafficControlConfig.AppClassType.DEFAULT_CLASS;
        this.mContext = r8.getApplicationContext();
        this.mNetTCConfig = r10;
        this.mAppRateLimitManager = r11;
    }

    private void backgroundOthersRateLimitUpdate(RateControlManager.StrategyType r8, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r10, StrategyContext r11) {
        int r12 = r8.ordinal();
        int[][] r13 = RATE_PERCENTAGE;
        int r14 = (r11.maxBandWidthEstimatedVal * r13[r12][r13[0].length - 1]) / 100;
        if (r8 == RateControlManager.StrategyType.NORMAL_TEMPERATURE_STRATEGY) goto L5;
    L12:
        setBackgroundOthersRateLimit(r14, r8, r10, r11);
        return;
    L5:
        if (this.mBackgroundRateLimitSetCauseForegroundRtt == false) goto L10;
        if (r14 < this.mBackgroundOthersRateLimit) goto L10;
        return;
    L10:
        if (r11.isForegroundRttOverThreshold == false) goto L12;
        r14 = Math.min(r14, ((r11.backgroundOthersRateNow * 8) / 1024) / 2);
        this.mBackgroundRateLimitSetCauseForegroundRtt = true;
        CaeLog.i(TAG, "try set BackgroundOthersRate from " + ((r11.backgroundOthersRateNow * 8) / 1024) + "Kbps to " + r14 + "kbps, cause by foreground rtt");
        goto L12
    }

    private TrafficControlConfig.AppClassType getAppClassType(RateControlManager.UidRateControlInfo r8) {
        if (r8 != null) goto L6;
        return TrafficControlConfig.AppClassType.DEFAULT_CLASS;
    L6:
        if (r8.isVipApp == false) goto L10;
        return TrafficControlConfig.AppClassType.VIP_CLASS;
    L10:
        if (r8.appCtrlType != RateControlManager.AppCtrlType.FOREGROUND) goto L22;
        String r10 = r8.appPackageName;
        if (r10 == null) goto L20;
        if (r10.isEmpty() == true) goto L20;
        if (AppCategoryHelper.getInstance(this.mContext).getAppCategory(r8.appPackageName) != 4) goto L20;
        return TrafficControlConfig.AppClassType.FOREGROUND_LOW_LATENCY_CLASS;
    L20:
        return TrafficControlConfig.AppClassType.FOREGROUND_NORMAL_CLASS;
    L22:
        return TrafficControlConfig.AppClassType.DEFAULT_CLASS;
    }

    private List<TrafficControlConfig.UidSocketInfo> getBackgroundOthersSockList(RateControlManager.StrategyType r8, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r10, StrategyContext r11) {
        if (r11.isTragetNetifWlan == true) goto L5;
    L10:
        boolean r12 = true;
    L11:
        ArrayList r13 = new ArrayList();
        Iterator<RateControlManager.UidRateControlInfo> r14 = r10.values().iterator();
    L13:
        if (r14.hasNext() == false) goto L25;
        RateControlManager.UidRateControlInfo r15 = r14.next();
        if (r15.isSpecificApp == true) goto L13;
        if (r12 == false) goto L19;
    L21:
        if (r12 == false) goto L13;
        if (r15.appCtrlType == RateControlManager.AppCtrlType.FOREGROUND) goto L13;
    L20:
        r13.addAll(r15.socketList);
        goto L13
    L19:
        if (r15.appCtrlType != RateControlManager.AppCtrlType.BACKGROUND_OTHERS) goto L21;
    L25:
        return r13;
    L5:
        if (r8 != RateControlManager.StrategyType.TEMPERATURE_LEVEL1_STRATEGY) goto L7;
    L9:
        r12 = false;
        goto L11
    L7:
        if (r8 == RateControlManager.StrategyType.TEMPERATURE_LEVEL2_STRATEGY) goto L9;
        goto L9
    }

    private void setBackgroundOthersRateLimit(int r8, RateControlManager.StrategyType r10, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r11, StrategyContext r12) {
        List<TrafficControlConfig.UidSocketInfo> r13 = getBackgroundOthersSockList(r10, r11, r12);
        if (r13.isEmpty() == false) goto L6;
        return;
    L6:
        if (r12.isTragetNetifWlan == true) goto L16;
        if (L4NetEvaluateObserver.getInstance(this.mContext).getVipNetworkEnable() == true) goto L11;
        return;
    L11:
        if (this.mBackgroundOthersRateLimit == 2048) goto L13;
        CaeLog.i(TAG, "updateBackgroundOtherRateLimit in cellular condition, socketList size: " + r13.size());
    L13:
        this.mAppRateLimitManager.push(0, 2048, r13, true, TrafficControlConfig.AppClassType.DEFAULT_CLASS);
        this.mBackgroundOthersRateLimit = 2048;
        return;
    L16:
        if (Math.abs(this.mBackgroundOthersRateLimit - r8) > 5000) goto L20;
        if (r10 == RateControlManager.StrategyType.VIP_APP_STRATEGY) goto L20;
        return;
    L20:
        if (this.mBackgroundOthersRateLimit == r8) goto L22;
        StringBuilder r14 = b.f("updateBackgroundOtherRateLimit ", r8, ", socketList size: ");
        r14.append(r13.size());
        CaeLog.i(TAG, r14.toString());
    L22:
        this.mAppRateLimitManager.push(0, r8, r13, false, TrafficControlConfig.AppClassType.DEFAULT_CLASS);
        this.mBackgroundOthersRateLimit = r8;
    }

    private void updateCellCommonStrategyLimit(RateControlManager.StrategyType r8, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r10, StrategyContext r11) {
        if (L4NetEvaluateObserver.getInstance(this.mContext).getVipNetworkEnable() == true) goto L5;
        return;
    L5:
        Iterator<RateControlManager.UidRateControlInfo> r12 = r10.values().iterator();
    L7:
        if (r12.hasNext() == false) goto L15;
        RateControlManager.UidRateControlInfo r13 = r12.next();
        if (r13.appCtrlType != RateControlManager.AppCtrlType.FOREGROUND) goto L7;
        if (r13.isVipApp == false) goto L13;
        int r14 = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
    L14:
        updateForegroundRateLimit(r14, getAppClassType(r13));
        goto L7
    L13:
        r14 = CELLULAR_FOREGROUND_RATE_LIMIT_DEFAULT;
        goto L14
    L15:
        setBackgroundOthersRateLimit(262144, r8, r10, r11);
    }

    private void updateForegroundRateLimit(int r8, TrafficControlConfig.AppClassType r10) {
        if (r8 > 0) goto L7;
        android.aimedia.a.p("Invalid foregroundRateLimit: ", r8, TAG);
        return;
    L7:
        if (Math.abs(this.mForegroundRateLimit - r8) <= 5000) goto L9;
    L10:
        int r11 = this.mNetTCConfig.getPriorityByClassType(r10);
        StringBuilder r12 = new StringBuilder("updateForegroundRateLimit rate from ");
        b.q(r12, this.mForegroundRateLimit, " to ", r8, ", classType from ");
        r12.append(this.mForegroundClassType);
        r12.append(" to ");
        r12.append(r10);
        r12.append(", priority: ");
        b.p(r12, r11, TAG);
        this.mNetTCConfig.setDefaultClassRateLimit(r8, r11);
        this.mForegroundRateLimit = r8;
        this.mForegroundClassType = r10;
        return;
    L9:
        if (this.mForegroundClassType != r10) goto L10;
    }

    private void updateSpecificAppStrategyLimit(RateControlManager.StrategyType r8, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r10, StrategyContext r11) {
        setBackgroundOthersRateLimit(TrafficControlConfig.DEFAULT_UNLIMITED_RATE, r8, r10, r11);
        Iterator<RateControlManager.UidRateControlInfo> r12 = r10.values().iterator();
    L4:
        if (r12.hasNext() == false) goto L9;
        RateControlManager.UidRateControlInfo r13 = r12.next();
        if (r13.isSpecificApp == true) goto L7;
        this.mAppRateLimitManager.remove(r13.uid);
        goto L4
    L7:
        this.mAppRateLimitManager.push(r13.uid, r13.rateLimit, r13.socketList, true, getAppClassType(r13));
        goto L4
    }

    private void updateVipAppStrategyLimit(RateControlManager.StrategyType r10, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r11, StrategyContext r12) {
        Iterator<RateControlManager.UidRateControlInfo> r8 = r11.values().iterator();
    L4:
        if (r8.hasNext() == false) goto L15;
        RateControlManager.UidRateControlInfo r13 = r8.next();
        if (r13.isVipApp == true) goto L7;
        if (r13.appCtrlType != RateControlManager.AppCtrlType.FOREGROUND) goto L4;
        if (r12.isTragetNetifWlan == false) goto L13;
        int r14 = (int) (((double) r12.maxBandWidthEstimatedVal) * 0.5d);
    L14:
        updateForegroundRateLimit(r14, getAppClassType(r13));
        goto L4
    L13:
        r14 = CELLULAR_FOREGROUND_RATE_LIMIT_DEFAULT;
        goto L14
    L7:
        this.mAppRateLimitManager.push(r13.uid, TrafficControlConfig.DEFAULT_UNLIMITED_RATE, r13.socketList, false, getAppClassType(r13));
        goto L4
    L15:
        setBackgroundOthersRateLimit((int) (((double) r12.maxBandWidthEstimatedVal) * 0.1d), r10, r11, r12);
    }

    private void updateWlanCommonStrategyLimit(RateControlManager.StrategyType r11, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r12, StrategyContext r13) {
        int r8 = r11.ordinal();
        int r10 = (r13.maxBandWidthEstimatedVal * RATE_PERCENTAGE[r8][0]) / 100;
        if (r10 != 0) goto L5;
        r10 = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
    L5:
        backgroundOthersRateLimitUpdate(r11, r12, r13);
        Iterator<RateControlManager.UidRateControlInfo> r14 = r12.values().iterator();
    L7:
        if (r14.hasNext() == false) goto L38;
        RateControlManager.UidRateControlInfo r15 = r14.next();
        int r16 = AnonymousClass1.$SwitchMap$com$obric$cae$smartNetwork$networkRateLimit$RateControlManager$AppCtrlType[r15.appCtrlType.ordinal()];
        if (r16 != 1) goto L11;
        if (r15.isVipApp == false) goto L35;
        if (r15.appPackageName == null) goto L7;
    L35:
        if (r15.isSpecificApp == true) goto L36;
        r15.rateLimit = r10;
        updateForegroundRateLimit(r10, getAppClassType(r15));
        goto L7
    L36:
        int r17 = Math.min(r15.rateLimit, r10);
        r15.rateLimit = r17;
        AppRateLimitManager r18 = this.mAppRateLimitManager;
        int r19 = r15.uid;
        List<TrafficControlConfig.UidSocketInfo> r20 = r15.socketList;
        boolean r21 = false;
    L19:
        r18.push(r19, r17, r20, r21, getAppClassType(r15));
        goto L7
    L11:
        if (r16 == 2) goto L21;
        if (r16 == 3) goto L21;
        if (r16 == 4) goto L21;
        if (r15.isSpecificApp == true) goto L18;
        this.mAppRateLimitManager.remove(r15.uid);
        goto L7
    L18:
        r18 = this.mAppRateLimitManager;
        r19 = r15.uid;
        r17 = r15.rateLimit;
        r20 = r15.socketList;
        r21 = true;
    L21:
        int r22 = (r13.maxBandWidthEstimatedVal * RATE_PERCENTAGE[r8][r15.appCtrlType.ordinal()]) / 100;
        if (r15.isSpecificApp == false) goto L25;
        if (r22 == 0) goto L26;
        r15.rateLimit = Math.min(r22, r15.rateLimit);
    L26:
        if (r22 == 0) goto L7;
        this.mAppRateLimitManager.push(r15.uid, r15.rateLimit, r15.socketList, r15.isSpecificApp, getAppClassType(r15));
        goto L7
    L25:
        r15.rateLimit = r22;
        goto L26
    }

    public int getBackgroundOthersRateLimit() {
        return this.mBackgroundOthersRateLimit;
    }

    public int getForegroundRateLimit() {
        return this.mForegroundRateLimit;
    }

    public void reset() {
        this.mBackgroundOthersRateLimit = 0;
        this.mForegroundRateLimit = 0;
        this.mBackgroundRateLimitSetCauseForegroundRtt = false;
    }

    public void updateStrategyLimit(RateControlManager.StrategyType r8, ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r10, StrategyContext r11) {
        if (r8 != RateControlManager.StrategyType.NONE_STRATEGY) goto L6;
        return;
    L6:
        if (r8 != RateControlManager.StrategyType.VIP_APP_STRATEGY) goto L10;
        updateVipAppStrategyLimit(r8, r10, r11);
        return;
    L10:
        if (r8 != RateControlManager.StrategyType.SPECIFIC_APP_STRATEGY) goto L14;
        updateSpecificAppStrategyLimit(r8, r10, r11);
        return;
    L14:
        if (r11.isTragetNetifWlan == true) goto L17;
        updateCellCommonStrategyLimit(r8, r10, r11);
        return;
    L17:
        updateWlanCommonStrategyLimit(r8, r10, r11);
    }
}
