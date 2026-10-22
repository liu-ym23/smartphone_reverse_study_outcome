package com.obric.cae.smartNetwork.networkRateLimit;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.UserHandle;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.NetworkAccelerate.VipAppManager;
import defpackage.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes2.dex */
public class SpecificAppManager {
    private static final String ACTION_SPECIFIC_APP_RATE_LIMIT_SET = "android.intent.action.APP_RATE_LIMIT_SET";
    private static final String ACTION_SPECIFIC_APP_RATE_LIMIT_UNSET = "android.intent.action.APP_RATE_LIMIT_UNSET";
    private static final String EXTRA_RATE_LIMIT = "RATE_LIMIT";
    private static final String EXTRA_SENDER_PACKAGE = "SENDER_PACKAGE";
    private static final String EXTRA_UID = "UID";
    private static final String EXTRA_USER_ID = "USER_ID";
    private static final int MIN_RATE_TO_MANAGE_THRESHOLD_IN_KBIT = 200;
    private static final String REQUIRED_BROADCAST_PERMISSION = "com.obric.cae.permission.SPECIFIC_APP_RATE_LIMIT";
    private static final String TAG = "SpecificAppManager";
    private boolean isSpecificAppQueueUpdate;
    private final AppRateLimitManager mAppRateLimitManager;
    private final RateControlManager mRateControlManager;
    private final ConcurrentHashMap<Integer, SpecificAppRateControlInfo> mSpecificAppQueue;
    private final BroadcastReceiver mSpecificAppRateLimitBroadcastReceiver;
    private final VipAppManager mVipAppManager;

    public static class SpecificAppRateControlInfo {
        volatile int effectiveRateLimit;
        AtomicBoolean isNeedToRemove;
        final ConcurrentHashMap<String, PackageRateEntry> packageRates;
        int uid;
        int userId;

        public static class PackageRateEntry {
            int rateLimit;
            String senderPackage;
            long timestampMs;

            public PackageRateEntry(String r8, int r10, long r11) {
                this.senderPackage = r8;
                this.rateLimit = r10;
                this.timestampMs = r11;
            }
        }

        public SpecificAppRateControlInfo(int r8, int r10) {
            this.packageRates = new ConcurrentHashMap();
            this.effectiveRateLimit = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            this.isNeedToRemove = new AtomicBoolean(false);
            this.userId = r8;
            this.uid = r10;
        }

        public void recomputeEffectiveRate() {
            Iterator<PackageRateEntry> r8 = this.packageRates.values().iterator();
            int r10 = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            long r11 = -1;
        L4:
            if (r8.hasNext() == false) goto L12;
            PackageRateEntry r12 = r8.next();
            int r13 = r12.rateLimit;
            if (r13 < r10) goto L7;
            if (r13 != r10) goto L4;
            long r14 = r12.timestampMs;
            if (r14 <= r11) goto L4;
            r11 = r14;
            goto L4
        L7:
            r11 = r12.timestampMs;
            r10 = r13;
            goto L4
        L12:
            this.effectiveRateLimit = r10;
        }

        public void removeRate(String r8) {
            this.packageRates.remove(r8);
            if (this.packageRates.isEmpty() == false) goto L5;
            this.isNeedToRemove.set(true);
            this.effectiveRateLimit = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
            return;
        L5:
            recomputeEffectiveRate();
        }

        public void updateRate(String r8, int r10) {
            PackageRateEntry r11 = new PackageRateEntry(r8, r10, System.currentTimeMillis());
            this.packageRates.put(r8, r11);
            recomputeEffectiveRate();
        }
    }

    public SpecificAppManager(Context r8, RateControlManager r10, AppRateLimitManager r11) {
        this.mSpecificAppQueue = new ConcurrentHashMap();
        this.isSpecificAppQueueUpdate = false;
        this.mSpecificAppRateLimitBroadcastReceiver = new AnonymousClass1(this);
        this.mRateControlManager = r10;
        this.mAppRateLimitManager = r11;
        this.mVipAppManager = VipAppManager.getInstance(r8);
        registerSpecificAppRateLimitReceiver(r8);
    }

    public static /* synthetic */ VipAppManager access$000(SpecificAppManager r8) {
        return r8.mVipAppManager;
    }

    public static /* synthetic */ int access$100(SpecificAppManager r8, int r10, int r11, int r12, String r13) {
        return r8.setSpecificAppRate(r10, r11, r12, r13);
    }

    public static /* synthetic */ int access$200(SpecificAppManager r8, int r10, int r11, String r12) {
        return r8.unsetSpecificAppRate(r10, r11, r12);
    }

    private void registerSpecificAppRateLimitReceiver(Context r10) {
        IntentFilter r8 = defpackage.a.c(ACTION_SPECIFIC_APP_RATE_LIMIT_SET, ACTION_SPECIFIC_APP_RATE_LIMIT_UNSET);
        r10.registerReceiver(this.mSpecificAppRateLimitBroadcastReceiver, r8, REQUIRED_BROADCAST_PERMISSION, null, 2);
    }

    private synchronized int setSpecificAppRate(int r8, int r10, int r11, String r12) {
        monitor-enter(this);
        CaeLog.i(TAG, "setSpecificAppRate, userId=" + r8 + ", uid=" + r10 + ", rate=" + r11 + ", senderPkg=" + r12);     // Catch: Throwable -> L27
        if (this.mVipAppManager.isVipUid(r10) == false) goto L10;
        CaeLog.i(TAG, "setSpecificAppRate ignored, uid " + r10 + " is VIP APP");     // Catch: Throwable -> L27
        monitor-exit(this);
        return -1;
    L10:
        if (r11 <= 2097152) goto L12;
    L24:
        CaeLog.e(TAG, "setSpecificAppRate failed, rate " + r11 + " is not valid, rate must be in range [200, 2097152]");     // Catch: Throwable -> L27
        monitor-exit(this);
        return -1;
    L12:
        if (r11 < 200) goto L24;
        int r13 = UserHandle.myUserId();     // Catch: Throwable -> L27
        if (r8 == r13) goto L17;
        CaeLog.w(TAG, "setSpecificAppRate failed, userId " + r8 + " is not equal to userIdNow " + r13);     // Catch: Throwable -> L27
    L17:
        SpecificAppRateControlInfo r14 = this.mSpecificAppQueue.get(Integer.valueOf(r10));     // Catch: Throwable -> L27
        if (r14 != null) goto L20;
        r14 = new SpecificAppRateControlInfo(r8, r10);     // Catch: Throwable -> L27
        this.mSpecificAppQueue.put(Integer.valueOf(r10), r14);     // Catch: Throwable -> L27
    L20:
        r14.updateRate(r12, r11);     // Catch: Throwable -> L27
        this.isSpecificAppQueueUpdate = true;     // Catch: Throwable -> L27
        monitor-exit(this);
        return 0;
    L27:
        th = move-exception;
        throw th;
    }

    private synchronized int unsetSpecificAppRate(int r8, int r10, String r11) {
        monitor-enter(this);
        CaeLog.i(TAG, "unsetSpecificAppRate, userId=" + r8 + ", uid=" + r10 + ", senderPkg=" + r11);     // Catch: Throwable -> L17
        SpecificAppRateControlInfo r12 = this.mSpecificAppQueue.get(Integer.valueOf(r10));     // Catch: Throwable -> L17
        if (r12 != null) goto L10;
        CaeLog.w(TAG, "unsetSpecificAppRate failed, uid " + r10 + " is not in mSpecificAppQueue");     // Catch: Throwable -> L17
        monitor-exit(this);
        return -1;
    L10:
        r12.removeRate(r11);     // Catch: Throwable -> L17
        if (r12.isNeedToRemove.get() == false) goto L13;
        CaeLog.i(TAG, "all senders removed for uid " + r10 + ", will unset rate limit");     // Catch: Throwable -> L17
    L13:
        this.isSpecificAppQueueUpdate = true;     // Catch: Throwable -> L17
        monitor-exit(this);
        return 0;
    L17:
        th = move-exception;
        throw th;
    }

    public RateControlManager.StrategyType specificAppStrategy(ConcurrentHashMap<Integer, RateControlManager.UidRateControlInfo> r10) {
        if (this.mSpecificAppQueue.isEmpty() == false) goto L7;
        return RateControlManager.StrategyType.NONE_STRATEGY;
    L7:
        if (this.isSpecificAppQueueUpdate == false) goto L9;
        Iterator<Map.Entry<Integer, SpecificAppRateControlInfo>> r8 = this.mSpecificAppQueue.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L23;
        SpecificAppRateControlInfo r11 = r8.next().getValue();
        RateControlManager.UidRateControlInfo r12 = r10.get(Integer.valueOf(r11.uid));
        if (r12 == null) goto L15;
        if (this.mVipAppManager.isVipUid(r11.uid) == false) goto L20;
        r11.isNeedToRemove.set(true);
        CaeLog.i(TAG, "specificAppStrategy, uid " + r11.uid + " is VIP APP, removed from queue and skip rate limit");
    L20:
        if (r11.isNeedToRemove.get() == true) goto L21;
        r12.isSpecificApp = true;
        r12.rateLimit = r11.effectiveRateLimit;
        StringBuilder r13 = new StringBuilder("specificAppStrategy, uid ");
        r13.append(r11.uid);
        r13.append(" set rateLimit to ");
        b.p(r13, r11.effectiveRateLimit, TAG);
        goto L12
    L21:
        r8.remove();
        r12.rateLimit = TrafficControlConfig.DEFAULT_UNLIMITED_RATE;
        r12.isSpecificApp = false;
        this.mAppRateLimitManager.needToConfig(r11.uid);
        goto L12
    L15:
        CaeLog.i(TAG, "specificAppStrategy, uid " + r11.uid + " not found in rateCtrlMap, create new one");
        RateControlManager.UidRateControlInfo r14 = new RateControlManager.UidRateControlInfo();
        r14.uid = r11.uid;
        r14.ifName = this.mRateControlManager.getTargetNetif();
        r14.isSpecificApp = true;
        r14.rateLimit = r11.effectiveRateLimit;
        r14.socketList = new ArrayList();
        r10.put(Integer.valueOf(r11.uid), r14);
        goto L12
    L23:
        this.isSpecificAppQueueUpdate = false;
        return RateControlManager.StrategyType.SPECIFIC_APP_STRATEGY;
    L9:
        return RateControlManager.StrategyType.SPECIFIC_APP_STRATEGY;
    }
}
