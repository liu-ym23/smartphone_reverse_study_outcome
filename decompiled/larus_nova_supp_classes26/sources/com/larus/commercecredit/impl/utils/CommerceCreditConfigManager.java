package com.larus.commercecredit.impl.utils;

import com.bytedance.keva.Keva;
import com.ixigua.lib.track.TrackParams;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.bmhome.social.userchat.model.TriggerSendLoading;
import com.larus.commercecredit.api.CreditInfoScene;
import com.larus.commercecredit.api.ICommerceCreditService;
import com.larus.commercecredit.impl.page.i0;
import com.larus.minor.api.IMinorService;
import com.larus.platform.api.m4;
import com.larus.platform.model.EnableStatus;
import com.larus.platform.service.AccountService;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.utils.o0;
import hq9.m0;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.ExceptionsKt;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class CommerceCreditConfigManager {
    public static final CommerceCreditConfigManager a = null;
    public static final AtomicBoolean b = null;
    public static final AtomicBoolean c = null;

    public static final class a implements com.larus.platform.api.b {
        public a() {
        }

        public final void a(com.larus.platform.api.c r3) {
            Intrinsics.checkNotNullParameter(r3, "event");
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.a, "CommerceCreditConfigManager_onLogin");
            ICommerceCreditService.a.getClass();
            ICommerceCreditService r4 = ICommerceCreditService.a.a();
            if (r4 == null) goto L6;
            r4.h("CommerceCreditConfigManager-onLogIn", DowngradeSource.AFTER_LAUNCH);
            return;
        }

        public final void b(com.larus.platform.api.c r2) {
            Intrinsics.checkNotNullParameter(r2, "event");
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.a, "CommerceCreditConfigManager_onLogout");
        }
    }

    public static final class b implements m4 {
        public b() {
        }

        public final void S1() {
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.a, "CommerceCreditConfigManager_onMinorModeOn");
        }

        public final void b1() {
            CommerceCreditConfigManager.a(CommerceCreditConfigManager.a, "CommerceCreditConfigManager_onMinorModeOff");
        }
    }

    public CommerceCreditConfigManager() {
    }

    static {
        a = new CommerceCreditConfigManager();
        AccountService r0 = AccountService.a;
        r0.E(new a());
        r0.H(new b());
        b = new AtomicBoolean(false);
        c = new AtomicBoolean(false);
    }

    public static boolean f(String r6) {
        Intrinsics.checkNotNullParameter(r6, "scene");
        if (AccountService.a.isLogin().booleanValue() == true) goto L7;
        FLogger.a.i("CommerceCreditConfigManager", "isCommerceCreditEnabled: not login with scene=" + r6);
        return false;
    L7:
        if (IMinorService.a.a() == false) goto L10;
        FLogger.a.i("CommerceCreditConfigManager", "isCommerceCreditEnabled: minor mode with scene=" + r6);
        return false;
    L10:
        m0 r0 = z2.a.O0();
        FLogger.a.i("CommerceCreditConfigManager", "isCommerceCreditEnabled: scene=" + r6 + " enable=" + r0.b() + " creditVersion=" + r0.a());
        if (Intrinsics.areEqual(r0.b(), EnableStatus.ENABLE.getStatus()) == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static final void a(CommerceCreditConfigManager r1, String r2) {
        r1.getClass();
        FLogger.a.i("CommerceCreditConfigManager", "resetConfig scene=".concat(r2));
        com.larus.commercecredit.impl.model.c.c.setValue(null);
    }

    public static boolean g(long r4, long r6) {
        if (r6 != 0) goto L5;
        return true;
    L5:
        Calendar r0 = Calendar.getInstance();
        r0.setTimeInMillis(r4);
        Calendar r5 = Calendar.getInstance();
        r5.setTimeInMillis(r6);
        if (r0.get(1) == r5.get(1)) goto L8;
        return true;
    L8:
        if (r0.get(2) == r5.get(2)) goto L10;
        return true;
    L10:
        if (r0.get(5) != r5.get(5)) goto L16;
        return false;
    L16:
        return true;
    }

    public static Object h(String r3, String r4, Continuation r5) {
        FLogger.a.i("CommerceCreditConfigManager", "joinGroupFromZlink scene=" + r4 + " text=" + r3);
        Object r6 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$joinGroupFromZlink$2(r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public static Object i(DowngradeSource r3, com.larus.commercecredit.impl.b r4, Continuation r5) {
        Object r6 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$openCommerceCreditGuide$2(r3, r4, null), r5);
        if (r6 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r6;
    L6:
        return Unit.INSTANCE;
    }

    public final Object k(String r17, DowngradeSource r18, Continuation<? super Unit> r19) {
        if ((r19 instanceof CommerceCreditConfigManager$sendUserActivityCrossDay$1) == false) goto L7;
        CommerceCreditConfigManager$sendUserActivityCrossDay$1 r2 = (CommerceCreditConfigManager$sendUserActivityCrossDay$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r0 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L16;
        if (r5 != 1) goto L15;
        String r1 = (String) r2.L$0;
        ResultKt.throwOnFailure(r0);     // Catch: Throwable -> L36 Exception -> L38
    L40:
        c.set(false);
        return Unit.INSTANCE;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r0);
        if (z2.a.O0().c() == true) goto L21;
        FLogger.a.d("CommerceCreditConfigManager", "sendUserActivityCrossDay: scene=" + r17 + " setting config disable");
        return Unit.INSTANCE;
    L21:
        if (c.compareAndSet(false, true) == true) goto L24;
        FLogger.a.d("CommerceCreditConfigManager", "sendUserActivityCrossDay:  scene=" + r17 + " request already in progress, skip duplicate");
        return Unit.INSTANCE;
    L24:
        long r10 = System.currentTimeMillis();     // Catch: Throwable -> L36 Exception -> L38
        com.larus.commercecredit.impl.model.c r6 = com.larus.commercecredit.impl.model.c.a;     // Catch: Throwable -> L36 Exception -> L38
        Keva r7 = com.larus.commercecredit.impl.model.c.c();     // Catch: Throwable -> L36 Exception -> L38
        long r12 = 0;
        if (r7 == null) goto L27;
        r12 = r7.getLong("user_activity_timestamp", 0);     // Catch: Throwable -> L36 Exception -> L38
    L27:
        boolean r8 = g(r10, r12);     // Catch: Throwable -> L36 Exception -> L38
        FLogger r9 = FLogger.a;     // Catch: Throwable -> L36 Exception -> L38
        StringBuilder r14 = new StringBuilder("sendUserActivityCrossDay: scene=");     // Catch: Throwable -> L36 Exception -> L38
        r14.append(r17);     // Catch: Throwable -> L36 Exception -> L38
        r14.append(" isCrossDay=");     // Catch: Throwable -> L36 Exception -> L38
        if (r8 == false) goto L30;
        boolean r15 = true;
    L31:
        r14.append(r15);     // Catch: Throwable -> L36 Exception -> L38
        r14.append(" curTime=");     // Catch: Throwable -> L36 Exception -> L38
        r14.append(r10);     // Catch: Throwable -> L36 Exception -> L38
        r14.append(" lastTime=");     // Catch: Throwable -> L36 Exception -> L38
        r14.append(r12);     // Catch: Throwable -> L36 Exception -> L38
        r9.d("CommerceCreditConfigManager", r14.toString());     // Catch: Throwable -> L36 Exception -> L38
        if (r8 == false) goto L40;
        r2.L$0 = r17;     // Catch: Throwable -> L36 Exception -> L38
        r2.label = 1;     // Catch: Throwable -> L36 Exception -> L38
        if (j(r17, r18, null, r2) != r4) goto L40;
        return r4;
    L30:
        r15 = false;
    L36:
        th = move-exception;
        c.set(false);
        throw th;
    L38:
        e = move-exception;
        FLogger.a.e("CommerceCreditConfigManager", "sendUserActivityCrossDay: scene=" + r17 + " error=" + ExceptionsKt.stackTraceToString(e));     // Catch: Throwable -> L36
    L7:
        r2 = new CommerceCreditConfigManager$sendUserActivityCrossDay$1(this, r19);
        goto L8
    }

    public static Object d(String r3, String r4, i0 r5, Continuation r6) {
        if (f("getGroupInvitationInfo scene=" + r3 + " campaignKey=" + r4) == true) goto L6;
        r5.invoke(null);
        return Unit.INSTANCE;
    L6:
        Object r7 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$getGroupInvitationInfo$2(r3, r4, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r7;
    L10:
        return Unit.INSTANCE;
    }

    public static Object j(String r3, DowngradeSource r4, Function2 r5, Continuation r6) {
        if (f("sendUserActivity: scene=" + r3) == false) goto L5;
        Object r7 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$sendUserActivity$2(r3, r4, r5, null), r6);
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r7;
    L10:
        return Unit.INSTANCE;
    L5:
        return Unit.INSTANCE;
    }

    public static Object c(String r8, String r9, boolean r10, Function3 r11, Continuation r12) {
        if (f("getGroupInfo scene=" + r8 + " campaignKey=" + r9 + " isSupportFromLocal=" + r10) == true) goto L6;
        r11.invoke(null, null, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L6:
        Object r13 = BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$getGroupInfo$2(r10, r9, r8, r11, null), r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L10;
        return r13;
    L10:
        return Unit.INSTANCE;
    }

    public static Object b(CreditInfoScene r8, boolean r9, boolean r10, String r11, String r12, Function3 r13, Continuation r14, int r15) {
        if ((r15 & 2) == 0) goto L5;
        boolean r5 = true;
    L7:
        if ((r15 & 4) == 0) goto L9;
        boolean r3 = true;
    L11:
        if ((r15 & 8) == 0) goto L14;
        r11 = null;
    L14:
        if ((r15 & 16) == 0) goto L16;
        r12 = null;
    L16:
        String r16 = r8.getScene();
        if (o0.d(r11) == false) goto L20;
        r16 = r16 + '_' + r11;
    L20:
        if (o0.d(r12) == false) goto L22;
        r16 = r16 + '_' + r12;
    L22:
        String r4 = r16;
        if (f("getAllCreditInfo scene=" + r4 + " needTasks=" + r5 + " isSupportFromLocal=" + r3) == true) goto L26;
        r13.invoke(null, null, Boxing.boxBoolean(true));
        return Unit.INSTANCE;
    L26:
        return BuildersKt.withContext(Dispatchers.getIO(), new CommerceCreditConfigManager$getAllCreditInfo$2(r3, r4, r5, r13, null), r14);
    L9:
        r3 = r10;
        goto L11
    L5:
        r5 = r9;
        goto L7
    }

    public static void e(String r18, long r19, String r21, String r22, String r23, String r24, String r25, long r26, long r28, com.larus.network.http.a r30, int r31) {
        String r3 = null;
        if ((r31 & 1) == 0) goto L5;
        String r2 = null;
    L7:
        if ((r31 & 2) == 0) goto L9;
        long r4 = System.currentTimeMillis();
    L11:
        if ((r31 & 4) == 0) goto L13;
        String r6 = null;
    L15:
        if ((r31 & 8) == 0) goto L17;
        String r7 = null;
    L19:
        if ((r31 & 16) == 0) goto L21;
        String r8 = null;
    L23:
        if ((r31 & 32) == 0) goto L25;
        String r9 = null;
    L27:
        if ((r31 & 64) == 0) goto L29;
        String r10 = null;
    L31:
        if ((r31 & 128) == 0) goto L33;
        long r14 = -1;
    L35:
        if ((r31 & 256) == 0) goto L37;
        long r12 = -1;
    L39:
        if ((r30 instanceof com.larus.network.http.f) == false) goto L50;
        com.larus.network.http.f r0 = (com.larus.network.http.f) r30;
        long r16 = r0.d.getCode();
        String r1 = r0.d.getMessage();
        if (r1 != null) goto L43;
    L46:
        boolean r5 = true;
    L47:
        if (r5 == false) goto L49;
        CommerceCreditErrorCode.Companion.getClass();
        r1 = CommerceCreditErrorCode.a.a(r16);
    L49:
        String r11 = r1;
        FLogger.a.i("CommerceCreditConfigManager", "request failed scene=" + r2 + " with error code=" + r0.d.getCode() + " msg=" + r0.d.getMessage());
        String r13 = TriggerSendLoading.NO_LOADING;
        r3 = r11;
        long r15 = r16;
    L51:
        long r17 = System.currentTimeMillis() - r4;
        int r20 = sz8.b.a;
        JSONObject r27 = new JSONObject();
        Intrinsics.checkNotNullParameter(r27, "params");
    L86:
        e = move-exception;
        FLogger.a.e("CommerceCreditMetricsHelper", "error in CommerceCreditMetricsHelper mobCommerceCreditMetric " + e.getLocalizedMessage());
    L88:
        TrackParams r29 = new TrackParams().merge(r27);
        by7.a r32 = new by7.a("commerce_credit_metric_event");
        r32.a.merge(r29);
        r32.b();
        return;
    L53:
        if (o0.d(r2) == false) goto L56;
        r27.put("scene", r2);     // Catch: JSONException -> L86
    L56:
        if (o0.d(r13) == false) goto L58;
        r27.put("req_status", r13);     // Catch: JSONException -> L86
    L58:
        r27.put("error_code", r15);     // Catch: JSONException -> L86
        if (o0.d(r3) == false) goto L62;
        r27.put("error_msg", r3);     // Catch: JSONException -> L86
    L62:
        if (r17 < 0) goto L65;
        r27.put("duration", r17);     // Catch: JSONException -> L86
    L65:
        if (o0.d(r6) == false) goto L68;
        r27.put("event_type", r6);     // Catch: JSONException -> L86
    L68:
        if (o0.d(r8) == false) goto L71;
        r27.put("is_pull_tasks", r8);     // Catch: JSONException -> L86
    L71:
        if (o0.d(r9) == false) goto L74;
        r27.put("is_first_visit", r9);     // Catch: JSONException -> L86
    L74:
        if (o0.d(r10) == false) goto L77;
        r27.put("has_local_data", r10);     // Catch: JSONException -> L86
    L77:
        if (r14 < 0) goto L79;
        r27.put("total_credit_num", r14);     // Catch: JSONException -> L86
    L79:
        long r110 = r12;
        if (r110 < 0) goto L83;
        r27.put("active_time", r110);     // Catch: JSONException -> L86
    L83:
        if (o0.d(r7) == false) goto L88;
        r27.put("campaign_key", r7);     // Catch: JSONException -> L86
        goto L88
    L43:
        if (r1.length() == 0) goto L46;
        r5 = false;
        goto L47
    L50:
        r13 = "1";
        r15 = -1;
        goto L51
    L37:
        r12 = r28;
        goto L39
    L33:
        r14 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r9 = r24;
        goto L27
    L21:
        r8 = r23;
        goto L23
    L17:
        r7 = r22;
        goto L19
    L13:
        r6 = r21;
        goto L15
    L9:
        r4 = r19;
        goto L11
    L5:
        r2 = r18;
        goto L7
    }
}
