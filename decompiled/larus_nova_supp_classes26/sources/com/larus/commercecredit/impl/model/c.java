package com.larus.commercecredit.impl.model;

import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.larus.basic.experience.downgrade.api.DowngradeSource;
import com.larus.basic.experience.downgrade.api.FlowDowngradeServiceDelegate;
import com.larus.basic.experience.downgrade.api.IFlowDowngradeService;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.larus.network.http.HttpExtKt;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.b1;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.j1;
import org.json.JSONObject;
import qz8.d;
import qz8.f;
import qz8.g;
import qz8.i;
import qz8.j;
import qz8.k;
import qz8.l;
import qz8.q;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class c {
    public static final c a = null;
    public static final Lazy b = null;
    public static final StateFlowImpl c = null;
    public static final b1 d = null;

    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001¨\u0006\u0004"}, d2 = {"com/larus/commercecredit/impl/model/CommerceCreditRepo$getAllCreditInfoFromLocal$creditTasks$1$1", "Lcom/google/gson/reflect/TypeToken;", "", "Lcom/larus/commercecredit/impl/entity/CreditTask;", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class a extends TypeToken<List<? extends j>> {
        public a() {
        }
    }

    public c() {
    }

    static {
        a = new c();
        b = LazyKt.lazy(new b());
        Long r0 = null;
        StateFlowImpl r1 = j1.a(null);
        c = r1;
        d = e.b(r1);
        g r2 = a();
        if (r2 == null) goto L7;
        f r3 = r2.a();
        if (r3 == null) goto L7;
        r0 = r3.f();
    L7:
        r1.setValue(r0);
    }

    public static g a() {
        FLogger.a.i("CommerceCreditRepo", "getCreditInfoFromLocal start");
        Keva r0 = c();
        Gson r2 = b();
        if (r0 == null) goto L5;
        String r5 = r0.getString("credit_info", "");
    L6:
        f r3 = (f) GsonProtectorUtils.fromJson(r2, r5, f.class);
        Gson r6 = b();
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L13
        if (r0 == null) goto L10;
        String r8 = r0.getString("credit_tasks", "");     // Catch: Throwable -> L13
    L11:
        Object r9 = Result.constructor-impl((List) r6.fromJson(r8, new a().getType()));     // Catch: Throwable -> L13
    L16:
        if (Result.isFailure-impl(r9) == false) goto L18;
        r9 = null;
    L18:
        List r10 = (List) r9;
        Gson r11 = b();
        if (r0 == null) goto L21;
        String r1 = r0.getString("credit_rule", "");
    L22:
        i r4 = (i) GsonProtectorUtils.fromJson(r11, r1, i.class);
        FLogger.a.i("CommerceCreditRepo", "getCreditInfoFromLocal end");
        if (r3 != null) goto L25;
        return null;
    L25:
        return new g(r3, r10, r4);
    L21:
        r1 = null;
        goto L22
    L10:
        r8 = null;
    L13:
        th = move-exception;
        Result.Companion r12 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L5:
        r5 = null;
        goto L6
    }

    public static Gson b() {
        return (Gson) b.getValue();
    }

    public static Keva c() {
        return Keva.getRepo("local_commerce_credit".concat(AccountService.a.getUserId()), 0);
    }

    public static void j(long r5) {
        FLogger r0 = FLogger.a;
        r0.i("CommerceCreditRepo", "updateTotalCreditNum: totalCreditNum=" + r5);
        g r1 = a();
        if (r1 == null) goto L6;
        f r2 = r1.a();
        if (r2 == null) goto L6;
    L7:
        f r3 = f.a(r2, Long.valueOf(r5));
        Keva r4 = c();
        if (r4 == null) goto L10;
        r4.storeString("credit_info", GsonProtectorUtils.toJson(b(), r3));
    L10:
        c.setValue(Long.valueOf(r5));
        r0.i("CommerceCreditRepo", "updateTotalCreditNum: updated successfully");
        return;
    L6:
        r2 = new f(0);
        goto L7
    }

    public final Object e(boolean r19, com.larus.commercecredit.impl.utils.a r20, Continuation r21) {
        if ((r21 instanceof CommerceCreditRepo$requestAllCreditInfo$1) == false) goto L7;
        CommerceCreditRepo$requestAllCreditInfo$1 r2 = (CommerceCreditRepo$requestAllCreditInfo$1) r21;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestAllCreditInfo$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        boolean r0 = r14.Z$0;
        Keva r6 = (Keva) r14.L$1;
        Function1 r7 = (Function1) r14.L$0;
        ResultKt.throwOnFailure(r1);
        Keva r8 = r6;
        Object r9 = r1;
        boolean r10 = r0;
    L18:
        com.larus.network.http.a r11 = (com.larus.network.http.a) r9;
        r7.invoke(r11);
        g r12 = (g) r11.b;
        if (r12 == null) goto L36;
        if (r8 == null) goto L22;
        r8.storeString("credit_info", GsonProtectorUtils.toJson(b(), r12.a()));
    L22:
        Long r13 = null;
        if (r10 == false) goto L32;
        if (r8 == null) goto L26;
        r8.storeString("credit_rule", GsonProtectorUtils.toJson(b(), r12.b()));
    L26:
        if (r8 == null) goto L32;
        Gson r15 = b();
        List<j> r16 = r12.c();
        if (r16 == null) goto L30;
        List r17 = CollectionsKt.filterNotNull(r16);
    L31:
        r8.storeString("credit_tasks", GsonProtectorUtils.toJson(r15, r17));
        goto L32
    L30:
        r17 = null;
    L32:
        StateFlowImpl r18 = c;
        f r22 = r12.a();
        if (r22 == null) goto L35;
        r13 = r22.f();
    L35:
        r18.setValue(r13);
    L36:
        FLogger.a.i("CommerceCreditRepo", "requestCreditInfoAndTasks end");
        return r12;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        FLogger.a.i("CommerceCreditRepo", "requestCreditInfoAndTasks start");
        Keva r23 = c();
        com.larus.commercecredit.impl.model.a.a.a();
        r14.L$0 = r20;
        r14.L$1 = r23;
        r14.Z$0 = r19;
        r14.label = 1;
        JSONObject r24 = new JSONObject();
        r24.put("need_tasks", r19);
        Unit r25 = Unit.INSTANCE;
        Object r26 = HttpExtKt.k("Basic", g.class, "/commerce/benefit_supply/credit/get_credit_num_optional_tasks", r24, null, null, true, null, null, null, r14, 944);
        if (r26 != r4) goto L17;
        return r4;
    L17:
        r8 = r23;
        r9 = r26;
        r10 = r19;
        r7 = r20;
    L7:
        r2 = new CommerceCreditRepo$requestAllCreditInfo$1(this, r21);
        goto L8
    }

    public final Object f(DowngradeSource r16, com.larus.commercecredit.impl.utils.e r17, Continuation r18) {
        if ((r18 instanceof CommerceCreditRepo$requestCreditTip$1) == false) goto L7;
        CommerceCreditRepo$requestCreditTip$1 r1 = (CommerceCreditRepo$requestCreditTip$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestCreditTip$1 r12 = r1;
        Object r0 = r12.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Function1 r5 = (Function1) r12.L$0;
        ResultKt.throwOnFailure(r0);
        Object r6 = r0;
        Function1 r7 = r5;
    L17:
        com.larus.network.http.a r8 = (com.larus.network.http.a) r6;
        r7.invoke(r8);
        k r9 = (k) r8.b;
        FLogger.a.i("CommerceCreditRepo", "requestCreditTip end");
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("CommerceCreditRepo", "requestCreditTip start");
        com.larus.commercecredit.impl.model.a.a.a();
        r7 = r17;
        r12.L$0 = r7;
        r12.label = 1;
        r6 = IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, "Basic", k.class, "/commerce/benefit_supply/credit/get_credit_tip", new JSONObject(), null, true, null, MapsKt.mapOf(TuplesKt.to(MusicAppletPage.KEY_SOURCE, r16.getValue())), r12, 944);
        if (r6 != r3) goto L17;
        return r3;
    L7:
        r1 = new CommerceCreditRepo$requestCreditTip$1(this, r18);
        goto L8
    }

    public final Object g(String r18, com.larus.commercecredit.impl.utils.b r19, Continuation r20) {
        if ((r20 instanceof CommerceCreditRepo$requestGroupInfo$1) == false) goto L7;
        CommerceCreditRepo$requestGroupInfo$1 r2 = (CommerceCreditRepo$requestGroupInfo$1) r20;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestGroupInfo$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Function1 r0 = (Function1) r14.L$1;
        String r6 = (String) r14.L$0;
        ResultKt.throwOnFailure(r1);
        Object r7 = r1;
        Function1 r8 = r0;
    L18:
        com.larus.network.http.a r9 = (com.larus.network.http.a) r7;
        r8.invoke(r9);
        d r10 = (d) r9.b;
        if (r10 == null) goto L23;
        Keva r11 = c();
        if (r11 == null) goto L23;
        r11.storeString("group_info_" + r6, GsonProtectorUtils.toJson(b(), r10));
    L23:
        FLogger.a.i("CommerceCreditRepo", "requestGroupInfo end");
        return r10;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        FLogger.a.i("CommerceCreditRepo", "requestGroupInfo start, campaignKey: " + r18);
        com.larus.commercecredit.impl.model.a.a.a();
        r14.L$0 = r18;
        r8 = r19;
        r14.L$1 = r8;
        r14.label = 1;
        JSONObject r12 = new JSONObject();
        r12.put("campaign_key", r18);
        Unit r13 = Unit.INSTANCE;
        r7 = HttpExtKt.k("Basic", d.class, "/commerce/benefit_supply/fission/get_campaign_info", r12, null, null, true, null, null, null, r14, 944);
        if (r7 != r4) goto L17;
        return r4;
    L17:
        r6 = r18;
    L7:
        r2 = new CommerceCreditRepo$requestGroupInfo$1(this, r20);
        goto L8
    }

    public final Object h(String r17, com.larus.commercecredit.impl.utils.c r18, Continuation r19) {
        if ((r19 instanceof CommerceCreditRepo$requestGroupInvitation$1) == false) goto L7;
        CommerceCreditRepo$requestGroupInvitation$1 r2 = (CommerceCreditRepo$requestGroupInvitation$1) r19;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$requestGroupInvitation$1 r14 = r2;
        Object r1 = r14.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r14.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        Function1 r0 = (Function1) r14.L$0;
        ResultKt.throwOnFailure(r1);
        Object r6 = r1;
    L18:
        com.larus.network.http.a r7 = (com.larus.network.http.a) r6;
        r0.invoke(r7);
        l r8 = (l) r7.b;
        FLogger.a.i("CommerceCreditRepo", "requestGroupInvitation end");
        return r8;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        FLogger.a.i("CommerceCreditRepo", "requestGroupInvitation start, campaignKey: " + r17);
        com.larus.commercecredit.impl.model.a.a.a();
        r14.L$0 = r18;
        r14.label = 1;
        JSONObject r9 = new JSONObject();
        r9.put("campaign_key", r17);
        Unit r10 = Unit.INSTANCE;
        Object r11 = HttpExtKt.k("Basic", l.class, "/commerce/benefit_supply/fission/get_group_invitation", r9, null, null, true, null, null, null, r14, 944);
        if (r11 != r4) goto L17;
        return r4;
    L17:
        r6 = r11;
        r0 = r18;
    L7:
        r2 = new CommerceCreditRepo$requestGroupInvitation$1(this, r19);
        goto L8
    }

    public final Object i(DowngradeSource r16, com.larus.commercecredit.impl.utils.f r17, Continuation r18) {
        if ((r18 instanceof CommerceCreditRepo$sendUserActivity$1) == false) goto L7;
        CommerceCreditRepo$sendUserActivity$1 r1 = (CommerceCreditRepo$sendUserActivity$1) r18;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$sendUserActivity$1 r12 = r1;
        Object r0 = r12.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        Function1 r5 = (Function1) r12.L$0;
        ResultKt.throwOnFailure(r0);
        Object r6 = r0;
        Function1 r7 = r5;
    L17:
        com.larus.network.http.a r8 = (com.larus.network.http.a) r6;
        r7.invoke(r8);
        q r9 = (q) r8.b;
        if (r9 == null) goto L22;
        long r10 = r9.a();
        Keva r11 = c();
        if (r11 == null) goto L22;
        r11.storeLong("user_activity_timestamp", r10);
    L22:
        FLogger.a.i("CommerceCreditRepo", "sendUserActivity end");
        return r9;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        FLogger.a.i("CommerceCreditRepo", "sendUserActivity start");
        com.larus.commercecredit.impl.model.a.a.a();
        r7 = r17;
        r12.L$0 = r7;
        r12.label = 1;
        r6 = IFlowDowngradeService.a.b(FlowDowngradeServiceDelegate.INSTANCE, "Basic", q.class, "/commerce/benefit_supply/credit/user_activity", new JSONObject(), null, true, null, MapsKt.mapOf(TuplesKt.to(MusicAppletPage.KEY_SOURCE, r16.getValue())), r12, 944);
        if (r6 != r3) goto L17;
        return r3;
    L7:
        r1 = new CommerceCreditRepo$sendUserActivity$1(this, r18);
        goto L8
    }

    public final Object d(String r19, String r20, com.larus.commercecredit.impl.utils.d r21, Continuation r22) {
        if ((r22 instanceof CommerceCreditRepo$joinGroup$1) == false) goto L7;
        CommerceCreditRepo$joinGroup$1 r3 = (CommerceCreditRepo$joinGroup$1) r22;
        int r4 = r3.label;
        if ((r4 & Integer.MIN_VALUE) == 0) goto L7;
        r3.label = r4 - Integer.MIN_VALUE;
    L8:
        CommerceCreditRepo$joinGroup$1 r15 = r3;
        Object r2 = r15.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r15.label;
        if (r6 == 0) goto L14;
        if (r6 != 1) goto L13;
        Function1 r0 = (Function1) r15.L$0;
        ResultKt.throwOnFailure(r2);
    L18:
        com.larus.network.http.a r7 = (com.larus.network.http.a) r2;
        r0.invoke(r7);
        FLogger.a.i("CommerceCreditRepo", "joinGroup end");
        return r7.b;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r2);
        FLogger.a.i("CommerceCreditRepo", "joinGroup start, inviteCode: " + r19 + ", campaignKey: " + r20);
        com.larus.commercecredit.impl.model.a.a.a();
        r15.L$0 = r21;
        r15.label = 1;
        JSONObject r8 = new JSONObject();
        r8.put("invite_code", r19);
        r8.put("campaign_key", r20);
        Unit r1 = Unit.INSTANCE;
        Object r9 = HttpExtKt.k("Basic", String.class, "/commerce/benefit_supply/fission/join_group", r8, null, null, true, null, null, null, r15, 944);
        if (r9 != r5) goto L17;
        return r5;
    L17:
        r2 = r9;
        r0 = r21;
    L7:
        r3 = new CommerceCreditRepo$joinGroup$1(this, r22);
        goto L8
    }
}
