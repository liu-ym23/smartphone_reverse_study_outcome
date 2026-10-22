package com.larus.account.saas.mfa.verify;

import com.larus.account.saas.mfa.network.MfaApi;
import com.larus.account.saas.runtime.depend.ToastType;
import com.larus.account.saas.runtime.internal.delegate.SaasApp;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONArray;
import org.json.JSONObject;
import pc7.g;
import x38.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.larus.account.saas.mfa.verify.MfaVerifyManager$startVerify$1", f = "MfaVerifyManager.kt", i = {0}, l = {45}, m = "invokeSuspend", n = {"afid"}, s = {"I$0"})
final class MfaVerifyManager$startVerify$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ e $callback;
    final /* synthetic */ String $scene;
    final /* synthetic */ String $template;
    int I$0;
    int label;

    public static final class a implements g {
        public final /* synthetic */ e a;
        public final /* synthetic */ int b;
        public final /* synthetic */ String c;

        public final void onFail() {
            SaasTracking r0 = SaasTracking.a;
            JSONObject r1 = new JSONObject();
            int r2 = this.b;
            String r3 = this.c;
            r1.put("flow_scene", "mfa_explicit_flow_finish");
            r1.put("afid", String.valueOf(r2));
            r1.put("verify_scene", r3);
            r1.put("result", "failure");
            r1.put("err_code", -4);
            r1.put("err_msg", "mfa verify fail");
            Unit r4 = Unit.INSTANCE;
            r0.reportEvent("doubao_account_mfa_explicit_flow", r1);
            this.a.a(-4, "mfa verify fail", null);
        }

        public a(e r1, int r2, String r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }

        public final void b(String r7, String r8, Map<String, String> r9, Map<String, Object> r10) {
            SaasTracking r0 = SaasTracking.a;
            JSONObject r1 = new JSONObject();
            int r2 = this.b;
            String r3 = this.c;
            r1.put("flow_scene", "mfa_explicit_flow_finish");
            r1.put("afid", String.valueOf(r2));
            r1.put("verify_scene", r3);
            r1.put("result", "success");
            Unit r4 = Unit.INSTANCE;
            r0.reportEvent("doubao_account_mfa_explicit_flow", r1);
            this.a.b(r7, r8, r9, r10);
        }
    }

    public MfaVerifyManager$startVerify$1(String r1, String r2, e r3, Continuation<? super MfaVerifyManager$startVerify$1> r4) {
        this.$scene = r1;
        this.$template = r2;
        this.$callback = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new MfaVerifyManager$startVerify$1(this.$scene, this.$template, this.$callback, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final Object invokeSuspend(Object r31) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L8;
        if (r2 != 1) goto L7;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r31);
        Object r8 = r31;
    L12:
        com.larus.account.saas.mfa.network.a r9 = (com.larus.account.saas.mfa.network.a) r8;
        if ((r9 instanceof com.larus.account.saas.mfa.network.a.d) == false) goto L33;
        JSONObject r4 = (JSONObject) ((com.larus.account.saas.mfa.network.a.d) r9).a;
        if (r4 == null) goto L22;
        String r16 = "err_msg";
        JSONArray r10 = r4.optJSONArray("verify_ways");
        String r26 = "err_code";
        if (r10 == null) goto L23;
        ArrayList r5 = new ArrayList();
        int r11 = r10.length();
        int r12 = 0;
    L19:
        if (r12 >= r11) goto L21;
        int r17 = r11;
        JSONArray r19 = r10;
        r5.add(r10.optJSONObject(r12).optString("verify_way"));
        r12 = r12 + 1;
        r11 = r17;
        r10 = r19;
        goto L19
    L21:
        String r6 = CollectionsKt.joinToString$default(r5, ",", null, null, 0, null, null, 62, null);
    L24:
        SaasTracking r13 = SaasTracking.a;
        JSONObject r14 = new JSONObject();
        String r15 = this.$scene;
        r14.put("flow_scene", "mfa_explicit_query_decision_result");
        r14.put("afid", String.valueOf(r3));
        r14.put("verify_scene", r15);
        r14.put("success", 1);
        if (r6 == null) goto L27;
        r14.put("verify_ways", r6);
    L27:
        Unit r7 = Unit.INSTANCE;
        r13.reportEvent("doubao_account_mfa_explicit_flow", r14);
        boolean r20 = pc7.e.c().i(r4, new a(this.$callback, r3, this.$scene));
        if (r20 == false) goto L30;
        JSONObject r21 = new JSONObject();
        String r22 = this.$scene;
        r21.put("flow_scene", "mfa_explicit_open_h5");
        r21.put("afid", String.valueOf(r3));
        r21.put("verify_scene", r22);
        r13.reportEvent("doubao_account_mfa_explicit_flow", r21);
    L30:
        if (r20 == true) goto L46;
        com.larus.account.saas.runtime.internal.delegate.a.a.f("MfaVerifyManager", "startVerify, start twice verify fail");
        JSONObject r23 = new JSONObject();
        String r24 = this.$scene;
        r23.put("flow_scene", "mfa_explicit_flow_finish");
        r23.put("afid", String.valueOf(r3));
        r23.put("verify_scene", r24);
        r23.put("result", "failure");
        r23.put(r26, -3);
        r23.put(r16, "start mfa verify fail");
        r13.reportEvent("doubao_account_mfa_explicit_flow", r23);
        this.$callback.a(-3, "start mfa verify fail", null);
    L46:
        return Unit.INSTANCE;
    L23:
        r6 = null;
        goto L24
    L22:
        r26 = "err_code";
        r16 = "err_msg";
        goto L23
    L33:
        if ((r9 instanceof com.larus.account.saas.mfa.network.a.C0065a) == false) goto L46;
        com.larus.account.saas.runtime.internal.delegate.a r25 = com.larus.account.saas.runtime.internal.delegate.a.a;
        StringBuilder r27 = new StringBuilder("startVerify, query decision failed, code=");
        com.larus.account.saas.mfa.network.a.C0065a r29 = (com.larus.account.saas.mfa.network.a.C0065a) r9;
        r27.append(r29.a.a);
        r27.append(", tips=");
        r27.append(r29.a.b);
        r25.f("MfaVerifyManager", r27.toString());
        SaasTracking r30 = SaasTracking.a;
        JSONObject r32 = new JSONObject();
        String r110 = this.$scene;
        r32.put("flow_scene", "mfa_explicit_query_decision_result");
        r32.put("afid", String.valueOf(r3));
        r32.put("verify_scene", r110);
        r32.put("success", 0);
        r32.put("err_code", r29.a.a);
        String r111 = r29.a.b;
        if (r111 == null) goto L37;
        r32.put("err_msg", r111);
    L37:
        Unit r112 = Unit.INSTANCE;
        r30.reportEvent("doubao_account_mfa_explicit_flow", r32);
        JSONObject r33 = new JSONObject();
        String r113 = this.$scene;
        r33.put("flow_scene", "mfa_explicit_flow_finish");
        r33.put("afid", String.valueOf(r3));
        r33.put("verify_scene", r113);
        r33.put("result", "failure");
        r33.put("err_code", r29.a.a);
        String r34 = r29.a.b;
        if (r34 == null) goto L40;
        r33.put("err_msg", r34);
    L40:
        r30.reportEvent("doubao_account_mfa_explicit_flow", r33);
        if (r29.a.a != 2037) goto L43;
        String r35 = SaasApp.a.getApplication().getString(2131899101);
    L44:
        SaasApp.a.f(ToastType.INFO, r35);
        e r36 = this.$callback;
        com.larus.account.saas.mfa.network.a.b r37 = r29.a;
        r36.a(r37.a, r37.b, r37.c);
        goto L46
    L43:
        r35 = SaasApp.a.getApplication().getString(2131899100);
        goto L44
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r31);
        pc7.e.c().getClass();
        int r38 = pc7.e.c.get() + 1;
        SaasTracking r39 = SaasTracking.a;
        JSONObject r40 = new JSONObject();
        String r114 = this.$scene;
        r40.put("flow_scene", "mfa_explicit_flow_start");
        r40.put("afid", String.valueOf(r38));
        r40.put("verify_scene", r114);
        Unit r115 = Unit.INSTANCE;
        r39.reportEvent("doubao_account_mfa_explicit_flow", r40);
        int r41 = MfaApi.a;
        String r42 = this.$scene;
        String r43 = this.$template;
        this.I$0 = r38;
        this.label = 1;
        r8 = MfaApi.c(r42, r43, this);
        if (r8 != r1) goto L11;
        return r1;
    L11:
        r3 = r38;
        goto L12
    }
}
