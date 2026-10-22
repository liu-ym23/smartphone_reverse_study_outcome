package com.ss.android.lark.passport.flow.mfa;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.flow.core.network.FlowPassportAccountsHttpClient;
import com.ss.android.lark.passport.flow.core.network.PassportHttpMethod;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class FlowMfaRepository {
    public static final Set<FlowVerifyFactor> b = null;
    public static final List<String> c = null;
    public final FlowPassportAccountsHttpClient a;

    public static final class a {
    }

    static {
        b = SetsKt.setOf(new FlowVerifyFactor[]{FlowVerifyFactor.PHONE, FlowVerifyFactor.EMAIL});
        c = CollectionsKt.listOf(new String[]{"auth_url", "url", "web_url", "redirect_url"});
    }

    @Inject
    public FlowMfaRepository(com.bytedance.lark.rustclient.api.l r2) {
        Intrinsics.checkNotNullParameter(r2, "rustClient");
        this.a = new FlowPassportAccountsHttpClient(r2);
    }

    public static String f(JSONObject r4) {
        Iterator<T> r0 = c.iterator();
    L3:
        String r2 = null;
        if (r0.hasNext() == false) goto L11;
        String r1 = r4.getString((String) r0.next());
        if (r1 == null) goto L10;
        if ((!StringsKt.isBlank(r1)) == false) goto L10;
        r2 = r1;
    L10:
        if (r2 == null) goto L3;
    L11:
        return r2;
    }

    public static JSONObject h(JSONObject r2) {
        Object r3 = r2.get("data");
        if ((r3 instanceof JSONObject) == true) goto L20;
        Object r1 = null;
        if ((r3 instanceof String) == false) goto L17;
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L9
        Object r4 = Result.constructor-impl(JSON.parseObject((String) r3));     // Catch: Throwable -> L9
    L12:
        if (Result.isFailure-impl(r4) == true) goto L21;
        r1 = r4;
    L21:
        return (JSONObject) r1;
    L9:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    L17:
        return null;
    L20:
        return (JSONObject) r3;
    }

    public final FlowStep j(com.ss.android.lark.passport.flow.core.network.f r5) {
        JSONObject r0 = h(i(r5, SetsKt.setOf(0)));
        if (r0 == null) goto L22;
        JSONObject r1 = r0.getJSONObject("step_info");
        if (r1 != null) goto L7;
    L8:
        r1 = r0;
    L9:
        String r2 = r0.getString("next_step");
        if (r2 != null) goto L20;
        if (f(r0) == null) goto L14;
    L18:
        r2 = "web_url";
        goto L20
    L14:
        if (f(r1) != null) goto L18;
        throw new IllegalStateException("MFA response missing next_step");
    L20:
        return new FlowStep(r2, r1, r5.b("x-tt-logid"));
    L7:
        if (r1.isEmpty() == false) goto L9;
    L22:
        throw new IllegalStateException("MFA response missing data");
    }

    public static JSONObject i(com.ss.android.lark.passport.flow.core.network.f r12, Set r13) {
        JSONObject r0 = JSON.parseObject(com.ss.android.lark.passport.flow.core.network.f.a(r12));
        if (r0 == null) goto L17;
        Integer r1 = r0.getInteger("code");
        if (r1 == null) goto L7;
        int r2 = r1.intValue();
    L9:
        if (r13.contains(Integer.valueOf(r2)) == true) goto L15;
        FlowMfaErrorCategory r3 = FlowMfaErrorCategory.SERVER;
        String r4 = r0.getString("message");
        if (r4 != null) goto L14;
        r4 = "Passport MFA server error";
    L14:
        throw new FlowMfaException(new FlowMfaError(r3, r4, null, null, Integer.valueOf(r2), r12.b("x-tt-logid"), 12, null));
    L15:
        return r0;
    L7:
        r2 = 0;
        goto L9
    L17:
        throw new IllegalStateException("MFA response body is empty");
    }

    public final Object d(String r4, Continuation r5) {
        if ((r5 instanceof FlowMfaRepository$chooseOptIn$1) == false) goto L7;
        FlowMfaRepository$chooseOptIn$1 r6 = (FlowMfaRepository$chooseOptIn$1) r5;
        int r0 = r6.label;
        if ((r0 & Integer.MIN_VALUE) == 0) goto L7;
        r6.label = r0 - Integer.MIN_VALUE;
    L8:
        Object r7 = r6.result;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r6.label;
        if (r1 == 0) goto L15;
        if (r1 != 1) goto L14;
        ResultKt.throwOnFailure(r7);
        com.ss.android.lark.passport.flow.core.network.f r8 = (com.ss.android.lark.passport.flow.core.network.f) r7;
        r8.c();
        return j(r8);
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r7);
        r6.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r9 = com.ss.android.lark.passport.flow.core.network.b.a;
        throw null;
    L7:
        r6 = new FlowMfaRepository$chooseOptIn$1(this, r5);
        goto L8
    }

    public final Object a(String r11, y r12, Continuation<? super b> r13) {
        if ((r13 instanceof FlowMfaRepository$applyCode$1) == false) goto L7;
        FlowMfaRepository$applyCode$1 r0 = (FlowMfaRepository$applyCode$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$applyCode$1 r6 = r0;
        Object r14 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        boolean r7 = false;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L22:
        com.ss.android.lark.passport.flow.core.network.f r15 = (com.ss.android.lark.passport.flow.core.network.f) r14;
        r15.c();
        JSONObject r16 = i(r15, SetsKt.setOf(new Integer[]{Boxing.boxInt(0), Boxing.boxInt(4206)}));
        JSONObject r17 = h(r16);
        Integer r4 = r16.getInteger("code");
        if (r4 == null) goto L25;
        int r5 = r4.intValue();
    L27:
        if (r17 == null) goto L29;
        Integer r18 = r17.getInteger("expire");
    L30:
        String r19 = r16.getString("message");
        if (r5 != 4206) goto L34;
        r7 = true;
    L34:
        return new b(r18, r19, r7);
    L29:
        r18 = null;
        goto L30
    L25:
        r5 = 0;
        goto L27
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        FlowVerifyFactor r110 = r12.a;
        if (b.contains(r110) == false) goto L35;
        FlowPassportAccountsHttpClient r8 = this.a;
        String r111 = r12.d;
        if (StringsKt.isBlank(r111) == false) goto L19;
        r111 = "login";
    L19:
        r6.label = 1;
        r14 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.a, r8, r11, "/accounts/auth/code/apply", MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("code_type", Boxing.boxInt(0)), TuplesKt.to("flow_type", r111)}), r6);
        if (r14 != r2) goto L22;
        return r2;
    L35:
        int r112 = g.a;
        throw new FlowMfaException(g.e(r110.getWireKey()));
    L7:
        r0 = new FlowMfaRepository$applyCode$1(this, r13);
        goto L8
    }

    public final Object b(String r8, String r9, JSONObject r10, Continuation<? super FlowStep> r11) {
        if ((r11 instanceof FlowMfaRepository$applyFirstParty$1) == false) goto L7;
        FlowMfaRepository$applyFirstParty$1 r0 = (FlowMfaRepository$applyFirstParty$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$applyFirstParty$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L22:
        com.ss.android.lark.passport.flow.core.network.f r13 = (com.ss.android.lark.passport.flow.core.network.f) r12;
        r13.c();
        return j(r13);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        FlowPassportAccountsHttpClient r14 = this.a;
        r6.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r4 = com.ss.android.lark.passport.flow.core.network.b.a;
        LinkedHashMap r5 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("scope", r9), TuplesKt.to("support_qr_code", Boxing.boxBoolean(true)), TuplesKt.to("support_verify_list", Boxing.boxBoolean(true))});
        if (r10 != null) goto L17;
    L19:
        r12 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.a, r14, r8, "/accounts/mfa_token/apply", r5, r6);
        if (r12 != r2) goto L22;
        return r2;
    L17:
        if ((!r10.isEmpty()) == false) goto L19;
        r5.put("custom_params", r10);
    L7:
        r0 = new FlowMfaRepository$applyFirstParty$1(this, r11);
        goto L8
    }

    public final Object c(String r9, String r10, String r11, Continuation<? super FlowMfaTokenStatus> r12) {
        if ((r12 instanceof FlowMfaRepository$checkToken$1) == false) goto L7;
        FlowMfaRepository$checkToken$1 r0 = (FlowMfaRepository$checkToken$1) r12;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$checkToken$1 r6 = r0;
        Object r13 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r13);
    L17:
        com.ss.android.lark.passport.flow.core.network.f r14 = (com.ss.android.lark.passport.flow.core.network.f) r13;
        r14.c();
        JSONObject r15 = h(i(r14, SetsKt.setOf(0)));
        if (r15 == null) goto L20;
        Integer r16 = r15.getInteger("token_status");
    L21:
        if (r16 != null) goto L24;
    L26:
        if (r16 == null) goto L32;
        if (r16.intValue() != 2) goto L32;
        return FlowMfaTokenStatus.INVALID;
    L32:
        return FlowMfaTokenStatus.UNKNOWN;
    L24:
        if (r16.intValue() != 1) goto L26;
        return FlowMfaTokenStatus.VALID;
    L20:
        r16 = null;
        goto L21
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r13);
        FlowPassportAccountsHttpClient r4 = this.a;
        r6.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r17 = com.ss.android.lark.passport.flow.core.network.b.a;
        r13 = com.ss.android.lark.passport.flow.core.network.b.b(r4, r9, "/accounts/mfa_token/validate", MapsKt.mapOf(TuplesKt.to("x-mfa-token", r11)), MapsKt.mapOf(TuplesKt.to("scope", r10)), r6);
        if (r13 != r2) goto L17;
        return r2;
    L7:
        r0 = new FlowMfaRepository$checkToken$1(this, r12);
        goto L8
    }

    public final Object e(String r8, String r9, String r10, Continuation<? super FlowStep> r11) {
        if ((r11 instanceof FlowMfaRepository$dispatchBidp$1) == false) goto L7;
        FlowMfaRepository$dispatchBidp$1 r0 = (FlowMfaRepository$dispatchBidp$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$dispatchBidp$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L25:
        com.ss.android.lark.passport.flow.core.network.f r13 = (com.ss.android.lark.passport.flow.core.network.f) r12;
        r13.c();
        return j(r13);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        FlowPassportAccountsHttpClient r14 = this.a;
        r6.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r5 = com.ss.android.lark.passport.flow.core.network.b.a;
        LinkedHashMap r7 = MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("state", r9)});
        if (r10 != null) goto L17;
    L20:
        if (r4 == true) goto L22;
        r7.put("code_verifier", r10);
    L22:
        r12 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.a, r14, r8, "/accounts/idp/dispatch", r7, r6);
        if (r12 != r2) goto L25;
        return r2;
    L17:
        if (StringsKt.isBlank(r10) == true) goto L20;
        r4 = false;
    L7:
        r0 = new FlowMfaRepository$dispatchBidp$1(this, r11);
        goto L8
    }

    public final Object g(String r11, JSONObject r12, String r13, Continuation<? super FlowStep> r14) {
        if ((r14 instanceof FlowMfaRepository$fetchBidpAuthUrl$1) == false) goto L7;
        FlowMfaRepository$fetchBidpAuthUrl$1 r0 = (FlowMfaRepository$fetchBidpAuthUrl$1) r14;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$fetchBidpAuthUrl$1 r8 = r0;
        Object r15 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        boolean r4 = true;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r15);
    L27:
        com.ss.android.lark.passport.flow.core.network.f r16 = (com.ss.android.lark.passport.flow.core.network.f) r15;
        r16.c();
        return j(r16);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r15);
        String r5 = r12.getString("channel");
        Set<String> r6 = wyb.a.b;
        if (wyb.a.C0203a.b(r5) == false) goto L30;
        FlowPassportAccountsHttpClient r7 = this.a;
        r8.label = 1;
        com.ss.android.lark.passport.flow.core.network.b r9 = com.ss.android.lark.passport.flow.core.network.b.a;
        LinkedHashMap r10 = new LinkedHashMap();
        com.ss.android.lark.passport.flow.core.network.b r17 = com.ss.android.lark.passport.flow.core.network.b.a;
        com.ss.android.lark.passport.flow.core.network.b.a(r12, r10, "flow_type");
        com.ss.android.lark.passport.flow.core.network.b.a(r12, r10, "channel");
        com.ss.android.lark.passport.flow.core.network.b.a(r12, r10, "tenant_domain");
        com.ss.android.lark.passport.flow.core.network.b.a(r12, r10, "user_id");
        com.ss.android.lark.passport.flow.core.network.b.a(r12, r10, "target_session_key");
        com.ss.android.lark.passport.flow.core.network.b.a(r12, r10, "login_type");
        r10.put("client_schema", "doubaolarkauth");
        r10.put("use_package_domain", String.valueOf(Intrinsics.areEqual(r12.getBoolean("use_package_domain"), Boxing.boxBoolean(true))));
        if (r13 != null) goto L19;
    L22:
        if (r4 == true) goto L24;
        r10.put("code_challenge", r13);
        r10.put("code_challenge_method", "S256");
    L24:
        r15 = FlowPassportAccountsHttpClient.c(r7, r11, "/accounts/idp/auth_url", PassportHttpMethod.GET, r10, null, null, r8, 496);
        if (r15 != r2) goto L27;
        return r2;
    L19:
        if (StringsKt.isBlank(r13) == true) goto L22;
        r4 = false;
        goto L22
    L30:
        throw new FlowMfaException(g.d());
    L7:
        r0 = new FlowMfaRepository$fetchBidpAuthUrl$1(this, r14);
        goto L8
    }

    public final Object k(String r8, String r9, y r10, Continuation<? super FlowStep> r11) {
        if ((r11 instanceof FlowMfaRepository$verifyCode$1) == false) goto L7;
        FlowMfaRepository$verifyCode$1 r0 = (FlowMfaRepository$verifyCode$1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        FlowMfaRepository$verifyCode$1 r6 = r0;
        Object r12 = r6.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r6.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r12);
    L24:
        com.ss.android.lark.passport.flow.core.network.f r13 = (com.ss.android.lark.passport.flow.core.network.f) r12;
        r13.c();
        return j(r13);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        FlowVerifyFactor r14 = r10.a;
        if (b.contains(r14) == true) goto L17;
        int r15 = g.a;
        throw new FlowMfaException(g.e(r14.getWireKey()));
    L17:
        if (StringsKt.isBlank(r9) == true) goto L27;
        FlowPassportAccountsHttpClient r16 = this.a;
        String r17 = r10.d;
        if (StringsKt.isBlank(r17) == false) goto L21;
        r17 = "login";
    L21:
        r6.label = 1;
        r12 = com.ss.android.lark.passport.flow.core.network.b.c(com.ss.android.lark.passport.flow.core.network.b.a, r16, r8, "/accounts/auth/code/verify", MapsKt.linkedMapOf(new Pair[]{TuplesKt.to("code", r9), TuplesKt.to("flow_type", r17)}), r6);
        if (r12 != r2) goto L24;
        return r2;
    L27:
        throw new FlowMfaException(g.c("MFA verify code must not be blank"));
    L7:
        r0 = new FlowMfaRepository$verifyCode$1(this, r11);
        goto L8
    }
}
