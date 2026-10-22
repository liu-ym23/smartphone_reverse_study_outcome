package com.obric.cae.smartNetwork.networkHandoverRL.feature;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.HandlerThread;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.obric.cae.log.CaeLog;
import com.obric.cae.smartNetwork.trafficMonitor.TrafficMonitorUtil;
import java.util.Calendar;
import z.g;

/* JADX INFO: loaded from: classes2.dex */
public class MobileTrafficQuery {
    private static final String KEY_PREFIX_SIM_LAST_QUERY_TIME = "sim_last_query_time_";
    private static final String KEY_PREFIX_SIM_REMAINING_TRAFFIC = "sim_remaining_traffic_";
    private static final String KEY_PREFIX_SIM_USED_TRAFFIC = "sim_used_traffic_";
    private static final String KEY_SIM_ID = "sim_id";
    private static final long ONE_DAY_IN_MILLIS = 86400000;
    private static final long ONE_MONTH_IN_MILLIS = 2592000000L;
    private static final String PREF_NAME = "traffic_query_prefs";
    private static final int SMS_QUERY_DELAY_MS = 10000;
    private static final int SUBSCRIBER_ID_DELAY_MS = 10000;
    private static final String TAG = "CaeMobileTrafficQuery";
    private final Context mContext;
    private final Handler mHandler;
    private final HandlerThread mHandlerThread;
    private String mRemainingTraffic;
    private final SharedPreferences mSharedPreferences;
    private boolean mSimReady;
    private String mSubscriberId;
    private final TelephonyManager mTelephonyManager;
    private String mUsedTraffic;

    /* JADX INFO: renamed from: com.obric.cae.smartNetwork.networkHandoverRL.feature.MobileTrafficQuery$3, reason: invalid class name */
    public class AnonymousClass3 extends BroadcastReceiver {
        final /* synthetic */ MobileTrafficQuery this$0;

        public AnonymousClass3(MobileTrafficQuery r8) {
            this.this$0 = r8;
        }

        public static /* synthetic */ void a(AnonymousClass3 r8) {
            r8.lambda$onReceive$0();
        }

        private /* synthetic */ void lambda$onReceive$0() {
            MobileTrafficQuery.access$1000(this.this$0);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context r8, Intent r10) {
            if ("android.intent.action.SIM_STATE_CHANGED".equals(r10.getAction()) == false) goto L12;
            MobileTrafficQuery r11 = this.this$0;
            if (5 != MobileTrafficQuery.access$800(r11).getSimState()) goto L7;
            boolean r12 = true;
        L8:
            MobileTrafficQuery.access$702(r11, r12);
            CaeLog.d(MobileTrafficQuery.TAG, "sim state changed, simReady: " + MobileTrafficQuery.access$700(this.this$0));
            if (MobileTrafficQuery.access$700(this.this$0) == false) goto L13;
            MobileTrafficQuery.access$900(this.this$0).postDelayed(new a(this), 10000);
            return;
        L13:
            return;
        L7:
            r12 = false;
            goto L8
        }
    }

    public MobileTrafficQuery(Context r8) {
        this.mUsedTraffic = "";
        this.mRemainingTraffic = "";
        this.mContext = r8;
        this.mTelephonyManager = (TelephonyManager) r8.getSystemService("phone");
        HandlerThread r10 = new HandlerThread(TAG);
        this.mHandlerThread = r10;
        r10.start();
        this.mHandler = new Handler(r10.getLooper());
        this.mSharedPreferences = r8.getSharedPreferences("traffic_query_prefs", 0);
        registerScreenChangeReceiver();
        registerSmsQueryReceiver();
        registerSimReceiver();
    }

    public static /* synthetic */ void a(MobileTrafficQuery r8, int r10) {
        r8.lambda$sendSmsDataUsageQueryDelayed$0(r10);
    }

    public static /* synthetic */ void access$000(MobileTrafficQuery r8) {
        r8.handleScreenOnForSmsQuery();
    }

    public static /* synthetic */ String access$100(MobileTrafficQuery r8, int r10) {
        return r8.getSimIdForSubId(r10);
    }

    public static /* synthetic */ void access$1000(MobileTrafficQuery r8) {
        r8.handleSimStateChanged();
    }

    public static /* synthetic */ String access$200(MobileTrafficQuery r8) {
        return r8.mUsedTraffic;
    }

    public static /* synthetic */ String access$202(MobileTrafficQuery r8, String r10) {
        r8.mUsedTraffic = r10;
        return r10;
    }

    public static /* synthetic */ String access$300(MobileTrafficQuery r8) {
        return r8.mRemainingTraffic;
    }

    public static /* synthetic */ String access$302(MobileTrafficQuery r8, String r10) {
        r8.mRemainingTraffic = r10;
        return r10;
    }

    public static /* synthetic */ void access$400(MobileTrafficQuery r8, String r10, String r11) {
        r8.setUsedTrafficForSimId(r10, r11);
    }

    public static /* synthetic */ void access$500(MobileTrafficQuery r8, String r10, String r11) {
        r8.setRemainingTrafficForSimId(r10, r11);
    }

    public static /* synthetic */ void access$600(MobileTrafficQuery r8, String r10, long r11) {
        r8.setLastQueryTimeForSimId(r10, r11);
    }

    public static /* synthetic */ boolean access$700(MobileTrafficQuery r8) {
        return r8.mSimReady;
    }

    public static /* synthetic */ boolean access$702(MobileTrafficQuery r8, boolean r10) {
        r8.mSimReady = r10;
        return r10;
    }

    public static /* synthetic */ TelephonyManager access$800(MobileTrafficQuery r8) {
        return r8.mTelephonyManager;
    }

    public static /* synthetic */ Handler access$900(MobileTrafficQuery r8) {
        return r8.mHandler;
    }

    private String getDefaultSubscriberId() {
        int r8 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (SubscriptionManager.isValidSubscriptionId(r8) == true) goto L7;
        return null;
    L7:
        return this.mTelephonyManager.getSubscriberId(r8);
    }

    private long getLastQueryTimeForSimId(String r8) {
        return this.mSharedPreferences.getLong(keyForSim(KEY_PREFIX_SIM_LAST_QUERY_TIME, r8), 0);
    }

    private String getRemainingTrafficForSimId(String r8) {
        return this.mSharedPreferences.getString(keyForSim(KEY_PREFIX_SIM_REMAINING_TRAFFIC, r8), null);
    }

    private String getSimIdForSubId(int r8) {
        /*  JADX ERROR: Simple mode code generation failed
            java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:100)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:106)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:302)
            	at java.base/java.util.Objects.checkIndex(Objects.java:365)
            	at java.base/java.util.ArrayList.get(ArrayList.java:428)
            	at jadx.core.codegen.MethodGen.generateSimpleCode(MethodGen.java:354)
            	at jadx.core.codegen.MethodGen.addSimpleMethodCode(MethodGen.java:316)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:279)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:299)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
            	at jadx.core.ProcessClass.process(ProcessClass.java:89)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
            */
        /*
            this = this;
            java.lang.String r0 = "CaeMobileTrafficQuery"
            boolean r1 = android.telephony.SubscriptionManager.isValidSubscriptionId(r4)     // Catch: java.lang.Throwable -> Lf java.lang.SecurityException -> L1c
            if (r1 == 0) goto L32
            android.telephony.TelephonyManager r1 = r3.mTelephonyManager     // Catch: java.lang.Throwable -> Lf java.lang.SecurityException -> L1c
            java.lang.String r3 = r1.getSubscriberId(r4)     // Catch: java.lang.Throwable -> Lf java.lang.SecurityException -> L1c
            return r3
        Lf:
            r4 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getSubscriberId error: "
            r1.<init>(r2)
            java.lang.String r4 = r4.getMessage()
            goto L28
        L1c:
            r4 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "getSubscriberId(security) failed: "
            r1.<init>(r2)
            java.lang.String r4 = r4.getMessage()
        L28:
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            com.obric.cae.log.CaeLog.w(r0, r4)
        L32:
            java.lang.String r3 = r3.getDefaultSubscriberId()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.obric.cae.smartNetwork.networkHandoverRL.feature.MobileTrafficQuery.getSimIdForSubId(int):java.lang.String");
    }

    private String getUsedTrafficForSimId(String r8) {
        return this.mSharedPreferences.getString(keyForSim(KEY_PREFIX_SIM_USED_TRAFFIC, r8), null);
    }

    private void handleScreenOnForSmsQuery() {
        int r8 = SubscriptionManager.getDefaultDataSubscriptionId();
        if (this.mSimReady == true) goto L5;
        return;
    L5:
        if (SubscriptionManager.isValidSubscriptionId(r8) == false) goto L13;
        String r10 = getSimIdForSubId(r8);
        if (TextUtils.isEmpty(r10) == false) goto L9;
        return;
    L9:
        if (shouldQueryForSimId(r10) == false) goto L15;
        CaeLog.i(TAG, "send sms data usage query for subId: " + r8 + " reason: month changed or timeout.");
        sendSmsDataUsageQueryDelayed(r8);
        setLastQueryTimeForSimId(r10, System.currentTimeMillis());
        return;
    L15:
        return;
    }

    private void handleSimStateChanged() {
        String r8 = getDefaultSubscriberId();
        CaeLog.d(TAG, "sim subscriberId: " + r8);
        if (TextUtils.isEmpty(r8) == false) goto L5;
    L11:
        this.mSubscriberId = r8;
        return;
    L5:
        if (TextUtils.isEmpty(this.mSubscriberId) == true) goto L11;
        if (r8.equals(this.mSubscriberId) == true) goto L11;
        if (shouldQueryForSimId(r8) == false) goto L11;
        int r10 = SubscriptionManager.getDefaultDataSubscriptionId();
        CaeLog.i(TAG, "send sms data usage query for subId: " + r10 + " reason: sim subscriberId changed.");
        sendSmsDataUsageQueryDelayed(r10);
        setLastQueryTimeForSimId(r8, System.currentTimeMillis());
        goto L11
    }

    private String keyForSim(String r8, String r10) {
        return defpackage.a.e(r8, r10);
    }

    private /* synthetic */ void lambda$sendSmsDataUsageQueryDelayed$0(int r8) {
        sendSmsDataUsageQuery(r8);
    }

    private void registerScreenChangeReceiver() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.SCREEN_ON");
        this.mContext.registerReceiver(new AnonymousClass1(this), r8);
    }

    private void registerSimReceiver() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction("android.intent.action.SIM_STATE_CHANGED");
        this.mContext.registerReceiver(new AnonymousClass3(this), r8);
    }

    private void registerSmsQueryReceiver() {
        IntentFilter r8 = new IntentFilter();
        r8.addAction(FeatureUtil.BROADCAST_TRAFFIC_QUERY_RESPONSE);
        this.mContext.registerReceiver(new AnonymousClass2(this), r8, 2);
    }

    private void sendSmsDataUsageQuery(int r8) {
        Intent r10 = new Intent(FeatureUtil.BROADCAST_TRAFFIC_QUERY);
        r10.putExtra(TrafficMonitorUtil.EXTRA_SUB_ID, r8);
        this.mContext.sendBroadcast(r10);
    }

    private void sendSmsDataUsageQueryDelayed(int r8) {
        this.mHandler.postDelayed(new g(r8, 3, this), 10000);
    }

    private void setLastQueryTimeForSimId(String r8, long r10) {
        this.mSharedPreferences.edit().putLong(keyForSim(KEY_PREFIX_SIM_LAST_QUERY_TIME, r8), r10).apply();
    }

    private void setRemainingTrafficForSimId(String r8, String r10) {
        SharedPreferences.Editor r11 = this.mSharedPreferences.edit();
        String r12 = keyForSim(KEY_PREFIX_SIM_REMAINING_TRAFFIC, r8);
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r11.putString(r12, r10).apply();
    }

    private void setUsedTrafficForSimId(String r8, String r10) {
        SharedPreferences.Editor r11 = this.mSharedPreferences.edit();
        String r12 = keyForSim(KEY_PREFIX_SIM_USED_TRAFFIC, r8);
        if (r10 != null) goto L5;
        r10 = "";
    L5:
        r11.putString(r12, r10).apply();
    }

    private boolean shouldQueryForSimId(String r8) {
        long r10 = getLastQueryTimeForSimId(r8);
        if (r10 != 0) goto L5;
        return true;
    L5:
        Calendar r11 = Calendar.getInstance();
        int r12 = r11.get(2);
        int r13 = r11.get(1);
        Calendar r14 = Calendar.getInstance();
        r14.setTimeInMillis(r10);
        int r15 = r14.get(2);
        int r16 = r14.get(1);
        if (r12 != r15) goto L10;
        if (r13 != r16) goto L10;
        boolean r17 = false;
    L12:
        if ((System.currentTimeMillis() - r10) <= 259200000) goto L14;
        boolean r18 = true;
    L15:
        if (r17 == true) goto L20;
        if (r18 == false) goto L19;
        return true;
    L19:
        return false;
    L20:
        return true;
    L14:
        r18 = false;
    L10:
        r17 = true;
        goto L12
    }
}
