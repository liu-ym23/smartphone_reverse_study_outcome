package com.obric.cae.smartNetwork.netPolicy;

import android.annotation.SuppressLint;
import android.app.SmtOpsManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.INetworkPolicyListener;
import android.net.NetworkPolicyManager;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.telephony.SubscriptionPlan;
import androidx.activity.d;
import androidx.activity.k;
import com.obric.cae.log.CaeLog;
import com.obric.cae.network.AppNetOpChangedEvent;
import com.obric.cae.network.BlockedReasonChangedEvent;
import com.obric.cae.network.MeteredIfacesChangedEvent;
import com.obric.cae.network.NetpolicyEvents;
import com.obric.cae.network.NetworkType;
import com.obric.cae.network.PowerStateEvent;
import com.obric.cae.network.PowerStateEventType;
import com.obric.cae.network.RestrictBackgroundChangedEvent;
import com.obric.cae.network.SleepModeChangedEvent;
import com.obric.cae.network.SubscriptionOverrideChangedEvent;
import com.obric.cae.network.SubscriptionPlansChangedEvent;
import com.obric.cae.network.UidPoliciesChangedEvent;
import com.obric.cae.network.UidRulesChangedEvent;
import defpackage.b;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class NetPolicyMetric {
    private static final String SLEEP_MODE = "sleepmode";
    private static final String SLEEP_MODE_CHANGED = "com.bytedanceos.action.SLEEP_MODE_CHANGED";
    private static final long START_DELAY_MS = 3000;
    private static final long START_RETRY_DELAY_MS = 5000;
    private static final String TAG = "NetPolicyMetric";
    private static volatile NetPolicyMetric sInstance;
    private final Context mContext;
    private final EventCache mEventCache;
    private final Handler mInitHandler;
    private final HandlerThread mInitThread;
    private final INetworkPolicyListener mListener;
    private final NetworkPolicyManager mNetworkPolicyManager;
    private volatile SmtOpsManager.OnOpChangedInternalListener mOnOpChangedListener;
    private final PowerManager mPowerManager;
    private final BroadcastReceiver mPowerReceiver;
    private final BroadcastReceiver mScreenReceiver;
    private final BroadcastReceiver mSleepModeReceiver;
    private volatile SmtOpsManager mSmtOpsManager;
    private volatile boolean mStartScheduled;
    private volatile boolean mStarted;

    @SuppressLint({"WrongConstant"})
    private NetPolicyMetric(Context r8) {
        Context r10 = r8.getApplicationContext();
        this.mContext = r10;
        this.mNetworkPolicyManager = NetworkPolicyManager.from(r10);
        this.mPowerManager = (PowerManager) r10.getSystemService("power");
        this.mEventCache = EventCache.getInstance(r10);
        this.mPowerReceiver = createPowerReceiver();
        this.mScreenReceiver = createScreenReceiver();
        this.mSleepModeReceiver = createSleepModeReceiver();
        this.mListener = createNetworkPolicyListener();
        HandlerThread r11 = new HandlerThread("NetPolicyMetricInit");
        this.mInitThread = r11;
        r11.start();
        this.mInitHandler = new Handler(r11.getLooper());
    }

    public static /* synthetic */ void a(NetPolicyMetric r8) {
        r8.scheduleStart();
    }

    public static /* synthetic */ int access$000(NetPolicyMetric r8, int r10, String r11, int r12) {
        return r8.getOpMode(r10, r11, r12);
    }

    public static /* synthetic */ String access$100() {
        return TAG;
    }

    public static /* synthetic */ void access$1000(NetPolicyMetric r8, int r10, SubscriptionPlan[] r11) {
        r8.addSubscriptionPlansChangedEvent(r10, r11);
    }

    public static /* synthetic */ void access$1100(NetPolicyMetric r8, int r10, int r11, int r12) {
        r8.addBlockedReasonChangedEvent(r10, r11, r12);
    }

    public static /* synthetic */ PowerManager access$1200(NetPolicyMetric r8) {
        return r8.mPowerManager;
    }

    public static /* synthetic */ void access$1300(NetPolicyMetric r8, PowerStateEventType r10, boolean r11) {
        r8.addPowerStateEvent(r10, r11);
    }

    public static /* synthetic */ void access$1400(NetPolicyMetric r8, boolean r10) {
        r8.addSleepModeChangedEvent(r10);
    }

    public static /* synthetic */ void access$200(NetPolicyMetric r8, int r10, String r11, int r12, int r13) {
        r8.addAppNetOpChangedEvent(r10, r11, r12, r13);
    }

    public static /* synthetic */ String access$300(NetPolicyMetric r8, int r10) {
        return r8.uidRulesToString(r10);
    }

    public static /* synthetic */ void access$400(NetPolicyMetric r8, int r10, int r11) {
        r8.addUidRulesChangedEvent(r10, r11);
    }

    public static /* synthetic */ void access$500(NetPolicyMetric r8, String[] r10) {
        r8.addMeteredIfacesChangedEvent(r10);
    }

    public static /* synthetic */ void access$600(NetPolicyMetric r8, boolean r10) {
        r8.addRestrictBackgroundChangedEvent(r10);
    }

    public static /* synthetic */ String access$700(NetPolicyMetric r8, int r10) {
        return r8.uidPoliciesToString(r10);
    }

    public static /* synthetic */ void access$800(NetPolicyMetric r8, int r10, int r11) {
        r8.addUidPoliciesChangedEvent(r10, r11);
    }

    public static /* synthetic */ void access$900(NetPolicyMetric r8, int r10, int r11, int r12, int[] r13) {
        r8.addSubscriptionOverrideChangedEvent(r10, r11, r12, r13);
    }

    private void addAppNetOpChangedEvent(int r8, String r10, int r11, int r12) {
        AppNetOpChangedEvent r13 = AppNetOpChangedEvent.newBuilder().setUid(r8).setPkgName(r10).setOpCode(r11).setMode(r12).setTimestamp(System.currentTimeMillis()).build();     // Catch: Exception -> L4
        NetpolicyEvents r14 = NetpolicyEvents.newBuilder().addAppNetOpChangedEvents(r13).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r14);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r15 = TAG;
        b.k(e, new StringBuilder("addAppNetOpChangedEvent failed: "), r15);
    }

    private void addBlockedReasonChangedEvent(int r8, int r10, int r11) {
        BlockedReasonChangedEvent r12 = BlockedReasonChangedEvent.newBuilder().setUid(r8).setOldBlockedReasonMask(r10).setNewBlockedReasonMask(r11).build();     // Catch: Exception -> L4
        NetpolicyEvents r13 = NetpolicyEvents.newBuilder().addBlockedReasonChangedEvents(r12).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r13);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r14 = TAG;
        b.k(e, new StringBuilder("addBlockedReasonChangedEvent failed: "), r14);
    }

    private void addMeteredIfacesChangedEvent(String[] r8) {
        MeteredIfacesChangedEvent r10 = MeteredIfacesChangedEvent.newBuilder().addAllMeteredIfaces(Arrays.asList(r8)).build();     // Catch: Exception -> L4
        NetpolicyEvents r11 = NetpolicyEvents.newBuilder().addMeteredIfacesChangedEvents(r10).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r12 = TAG;
        b.k(e, new StringBuilder("addMeteredIfacesChangedEvent failed: "), r12);
    }

    private void addPowerStateEvent(PowerStateEventType r8, boolean r10) {
        PowerStateEvent.Builder r11 = PowerStateEvent.newBuilder();     // Catch: Exception -> L4
        r11.setType(r8);     // Catch: Exception -> L4
        r11.setValue(r10);     // Catch: Exception -> L4
        r11.setTimestamp(System.currentTimeMillis());     // Catch: Exception -> L4
        NetpolicyEvents r12 = NetpolicyEvents.newBuilder().addPowerStateEvents(r11.build()).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r12);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r13 = TAG;
        b.k(e, new StringBuilder("addPowerStateEvent failed: "), r13);
    }

    private void addRestrictBackgroundChangedEvent(boolean r8) {
        RestrictBackgroundChangedEvent r10 = RestrictBackgroundChangedEvent.newBuilder().setRestrictBackground(r8).build();     // Catch: Exception -> L4
        NetpolicyEvents r11 = NetpolicyEvents.newBuilder().addRestrictBackgroundChangedEvents(r10).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r12 = TAG;
        b.k(e, new StringBuilder("addRestrictBackgroundChangedEvent failed: "), r12);
    }

    private void addSleepModeChangedEvent(boolean r8) {
        SleepModeChangedEvent r10 = SleepModeChangedEvent.newBuilder().setIsSleepMode(r8).setTimestamp(System.currentTimeMillis()).build();     // Catch: Exception -> L4
        NetpolicyEvents r11 = NetpolicyEvents.newBuilder().addSleepModeChangedEvents(r10).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r11);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r12 = TAG;
        b.k(e, new StringBuilder("addSleepModeChangedEvent failed: "), r12);
    }

    private void addSubscriptionOverrideChangedEvent(int r8, int r10, int r11, int[] r12) {
        SubscriptionOverrideChangedEvent.Builder r13 = SubscriptionOverrideChangedEvent.newBuilder().setSubId(r8).setOverrideMask(r10).setOverrideValue(r11);     // Catch: Exception -> L7
        int r14 = r12.length;     // Catch: Exception -> L7
        int r15 = 0;
    L3:
        if (r15 >= r14) goto L5;
        r13.addNetworkTypes(NetworkType.valueOf(r12[r15]));     // Catch: Exception -> L7
        r15 = r15 + 1;     // Catch: Exception -> L7
        goto L3
    L5:
        NetpolicyEvents r16 = NetpolicyEvents.newBuilder().addSubscriptionOverrideChangedEvents(r13.build()).build();     // Catch: Exception -> L7
        this.mEventCache.addEventToCache(r16);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        String r17 = TAG;
        b.k(e, new StringBuilder("addSubscriptionOverrideChangedEvent failed: "), r17);
    }

    private void addSubscriptionPlansChangedEvent(int r8, SubscriptionPlan[] r10) {
        SubscriptionPlansChangedEvent.Builder r11 = SubscriptionPlansChangedEvent.newBuilder().setSubId(r8);     // Catch: Exception -> L7
        int r12 = r10.length;     // Catch: Exception -> L7
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        r11.addPlans(r10[r13].toString());     // Catch: Exception -> L7
        r13 = r13 + 1;     // Catch: Exception -> L7
        goto L3
    L5:
        NetpolicyEvents r14 = NetpolicyEvents.newBuilder().addSubscriptionPlansChangedEvents(r11.build()).build();     // Catch: Exception -> L7
        this.mEventCache.addEventToCache(r14);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        String r15 = TAG;
        b.k(e, new StringBuilder("addSubscriptionPlansChangedEvent failed: "), r15);
    }

    private void addUidPoliciesChangedEvent(int r8, int r10) {
        UidPoliciesChangedEvent r11 = UidPoliciesChangedEvent.newBuilder().setUid(r8).setUidPoliciesMask(r10).build();     // Catch: Exception -> L4
        NetpolicyEvents r12 = NetpolicyEvents.newBuilder().addUidPoliciesChangedEvents(r11).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r12);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r13 = TAG;
        b.k(e, new StringBuilder("addUidPoliciesChangedEvent failed: "), r13);
    }

    private void addUidRulesChangedEvent(int r8, int r10) {
        UidRulesChangedEvent r11 = UidRulesChangedEvent.newBuilder().setUid(r8).setUidRulesMask(r10).build();     // Catch: Exception -> L4
        NetpolicyEvents r12 = NetpolicyEvents.newBuilder().addUidRulesChangedEvents(r11).build();     // Catch: Exception -> L4
        this.mEventCache.addEventToCache(r12);     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        String r13 = TAG;
        b.k(e, new StringBuilder("addUidRulesChangedEvent failed: "), r13);
    }

    public static /* synthetic */ void b(NetPolicyMetric r8) {
        r8.startOnWorkerThread();
    }

    private INetworkPolicyListener createNetworkPolicyListener() {
        return new AnonymousClass2(this);
    }

    private SmtOpsManager.OnOpChangedInternalListener createOnOpChangedListener() {
        return new AnonymousClass1(this);
    }

    private BroadcastReceiver createPowerReceiver() {
        return new AnonymousClass3(this);
    }

    private BroadcastReceiver createScreenReceiver() {
        return new AnonymousClass4(this);
    }

    private BroadcastReceiver createSleepModeReceiver() {
        return new AnonymousClass5(this);
    }

    private void getAndReportFullOpsList() {
        List r8 = this.mSmtOpsManager.getPackagesForOps(new int[]{16, 17});     // Catch: Exception -> L22
        if (r8 != null) goto L6;
        return;
    L6:
        if (r8.isEmpty() == true) goto L40;
        CaeLog.d(TAG, "Got full ops list with " + r8.size() + " packages");     // Catch: Exception -> L22
        Iterator r10 = r8.iterator();     // Catch: Exception -> L22
    L9:
        if (r10.hasNext() == false) goto L41;
        SmtOpsManager.PackageOps r11 = (SmtOpsManager.PackageOps) r10.next();     // Catch: Exception -> L22
        int r12 = r11.getUid();     // Catch: Exception -> L22
        String r13 = r11.getPackageName();     // Catch: Exception -> L22
        List r14 = r11.getOps();     // Catch: Exception -> L22
        if (r14 == null) goto L9;
        if (r14.isEmpty() == true) goto L9;
        Iterator r15 = r14.iterator();     // Catch: Exception -> L22
    L16:
        if (r15.hasNext() == false) goto L9;
        SmtOpsManager.OpEntry r16 = (SmtOpsManager.OpEntry) r15.next();     // Catch: Exception -> L22
        int r17 = r16.getOp();     // Catch: Exception -> L22
        int r18 = r16.getMode();     // Catch: Exception -> L22
        if (r17 == 16) goto L20;
        if (r17 != 17) goto L16;
    L20:
        CaeLog.d(TAG, "Reporting initial op state: op=" + r17 + ", pkgName=" + r13 + ", uid=" + r12 + ", mode=" + r18);     // Catch: Exception -> L22
        addAppNetOpChangedEvent(r12, r13, r17, r18);     // Catch: Exception -> L22
        goto L16
    L41:
        return;
    L40:
        return;
    L22:
        e = move-exception;
        b.k(e, new StringBuilder("Error getting full ops list: "), TAG);
    }

    private int getOpDefaultMode(int r8, int r10, String r11) {
        if (r8 != 16) goto L5;
    L9:
        CaeLog.d(TAG, "Default mode for network operation: ALLOWED");     // Catch: Exception -> L11
        return 0;
    L5:
        if (r8 == 17) goto L9;
        CaeLog.d(TAG, "Default mode for operation " + r8 + ": ALLOWED");     // Catch: Exception -> L11
        return 0;
    L11:
        e = move-exception;
        b.k(e, new StringBuilder("Error getting default op mode: "), TAG);
        return 0;
    }

    private int getOpMode(int r8, String r10, int r11) {
        List r12 = this.mSmtOpsManager.getOpsForPackage(r8, r10, new int[]{r11});     // Catch: Exception -> L19
        if (r12 != null) goto L6;
    L17:
        CaeLog.d(TAG, "No package ops found, getting default mode");     // Catch: Exception -> L19
        return getOpDefaultMode(r11, r8, r10);
    L6:
        if (r12.isEmpty() == true) goto L17;
        List r13 = ((SmtOpsManager.PackageOps) r12.get(0)).getOps();     // Catch: Exception -> L19
        if (r13 != null) goto L11;
    L15:
        CaeLog.d(TAG, "No op entries found, getting default mode");     // Catch: Exception -> L19
        return getOpDefaultMode(r11, r8, r10);
    L11:
        if (r13.isEmpty() == true) goto L15;
        SmtOpsManager.OpEntry r14 = (SmtOpsManager.OpEntry) r13.get(0);     // Catch: Exception -> L19
        CaeLog.d(TAG, "Duration: " + r14.getDuration() + ", Mode: " + r14.getMode() + ", Time: " + r14.getTime() + ", RejectTime: " + r14.getRejectTime() + ", Op: " + r14.getOp());     // Catch: Exception -> L19
        return r14.getMode();
    L19:
        e = move-exception;
        b.k(e, new StringBuilder("Error getting op mode: "), TAG);
        return getOpDefaultMode(r11, r8, r10);
    }

    public static NetPolicyMetric make(Context r8) {
        if (sInstance == null) goto L5;
    L14:
        sInstance.scheduleStart();
        return sInstance;
    L5:
        monitor-enter(NetPolicyMetric.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new NetPolicyMetric(r8);     // Catch: Throwable -> L11
    L9:
        monitor-exit(NetPolicyMetric.class);     // Catch: Throwable -> L11
        goto L14
    }

    private synchronized void scheduleStart() {
        monitor-enter(this);
    L13:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == false) goto L6;
    L11:
        monitor-exit(this);
        return;
    L6:
        if (this.mStartScheduled == true) goto L11;
        this.mStartScheduled = true;     // Catch: Throwable -> L13
        this.mInitHandler.postDelayed(new d(this, 24), 3000);     // Catch: Throwable -> L13
        monitor-exit(this);
    }

    private void start() {
        if (this.mSmtOpsManager == null) goto L9;
        if (this.mOnOpChangedListener == null) goto L9;
        IntentFilter r8 = defpackage.a.c("android.os.action.POWER_SAVE_MODE_CHANGED", "android.os.action.DEVICE_IDLE_MODE_CHANGED");
        this.mContext.registerReceiver(this.mPowerReceiver, r8);
        IntentFilter r10 = new IntentFilter();
        r10.addAction("android.intent.action.SCREEN_ON");
        r10.addAction("android.intent.action.SCREEN_OFF");
        this.mContext.registerReceiver(this.mScreenReceiver, r10);
        IntentFilter r11 = new IntentFilter();
        r11.addAction("com.bytedanceos.action.SLEEP_MODE_CHANGED");
        this.mContext.registerReceiver(this.mSleepModeReceiver, r11);
        this.mNetworkPolicyManager.registerListener(this.mListener);
        this.mSmtOpsManager.startWatchingMode(16, null, this.mOnOpChangedListener);
        this.mSmtOpsManager.startWatchingMode(17, null, this.mOnOpChangedListener);
        getAndReportFullOpsList();
        return;
    L9:
        throw new IllegalStateException("SmtOpsManager is not initialized");
    }

    private void startOnWorkerThread() {
        monitor-enter(this);
    L39:
        th = move-exception;
        throw th;
    L4:
        if (this.mStarted == false) goto L8;
        this.mStartScheduled = false;     // Catch: Throwable -> L39
        monitor-exit(this);     // Catch: Throwable -> L39
        return;
    L8:
        monitor-exit(this);     // Catch: Throwable -> L39
        SmtOpsManager r8 = (SmtOpsManager) this.mContext.getSystemService("smtops");
        if (r8 != null) goto L49;
        CaeLog.w(TAG, "SmtOpsManager not ready, retry later");
        monitor-enter(this);
        this.mStartScheduled = false;     // Catch: Throwable -> L17
        monitor-exit(this);     // Catch: Throwable -> L17
        this.mInitHandler.postDelayed(new k(this, 21), 5000);
        return;
    L17:
        th = move-exception;
        throw th;
    L49:
        this.mSmtOpsManager = r8;     // Catch: Exception -> L30
        this.mOnOpChangedListener = createOnOpChangedListener();     // Catch: Exception -> L30
        start();     // Catch: Exception -> L30
        monitor-enter(this);     // Catch: Exception -> L30
        this.mStarted = true;     // Catch: Throwable -> L27
        this.mStartScheduled = false;     // Catch: Throwable -> L27
        monitor-exit(this);     // Catch: Throwable -> L27
        CaeLog.i(TAG, "NetPolicyMetric start finished on worker thread");     // Catch: Exception -> L30
        return;
    L27:
        th = move-exception;
        throw th;     // Catch: Exception -> L30
    L30:
        e = move-exception;
        monitor-enter(this);
        this.mStartScheduled = false;     // Catch: Throwable -> L36
        CaeLog.e(TAG, "NetPolicyMetric start failed: " + e.getMessage(), e);
        return;
    L36:
        th = move-exception;
        throw th;
    }

    private String uidPoliciesToString(int r8) {
        StringBuilder r10 = new StringBuilder();
        if ((r8 & 1) == 0) goto L6;
        r10.append("REJECT_METERED_BACKGROUND ");
    L6:
        if ((r8 & 4) == 0) goto L9;
        r10.append("ALLOW_METERED_BACKGROUND ");
    L9:
        return r10.toString().trim();
    }

    private String uidRulesToString(int r8) {
        StringBuilder r10 = new StringBuilder();
        if ((r8 & 1) == 0) goto L6;
        r10.append("ALLOW_METERED ");
    L6:
        if ((r8 & 2) == 0) goto L9;
        r10.append("TEMPORARY_ALLOW_METERED ");
    L9:
        if ((r8 & 4) == 0) goto L12;
        r10.append("REJECT_METERED ");
    L12:
        if ((r8 & 32) == 0) goto L15;
        r10.append("ALLOW_ALL ");
    L15:
        if ((r8 & 64) == 0) goto L18;
        r10.append("REJECT_ALL ");
    L18:
        if ((r8 & 1024) == 0) goto L21;
        r10.append("REJECT_RESTRICTED_MODE ");
    L21:
        return r10.toString().trim();
    }
}
