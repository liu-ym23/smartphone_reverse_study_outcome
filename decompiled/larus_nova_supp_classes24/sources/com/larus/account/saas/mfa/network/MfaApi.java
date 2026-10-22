package com.larus.account.saas.mfa.network;

import com.bytedance.sdk.account.impl.d0;
import com.larus.account.saas.mfa.assist.bean.MfaPushCodeResponse;
import com.larus.account.saas.runtime.internal.delegate.SaasTracking;
import kotlin.Pair;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import org.json.JSONObject;
import xa7.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class MfaApi {
    public static final /* synthetic */ int a = 0;

    public static final class a extends ua7.a<c> {
        public final /* synthetic */ i<com.larus.account.saas.mfa.network.a<MfaPushCodeResponse>> a;

        public a(j r1) {
            this.a = r1;
        }

        public final void onResponse(ua7.b r14) {
            c r15 = (c) r14;
            if (this.a.isActive() == true) goto L6;
            return;
        L6:
            if (r15 != null) goto L8;
        L10:
            boolean r2 = false;
        L11:
            String r4 = null;
            if (r2 == false) goto L43;
            JSONObject r3 = r15.z;
            if (r3 == null) goto L16;
            String r6 = r3.optString("push_code");
        L17:
            JSONObject r5 = r15.z;
            if (r5 == null) goto L20;
            Long r7 = Long.valueOf(r5.optLong("expire_time"));
        L21:
            JSONObject r8 = r15.z;
            if (r8 == null) goto L24;
            String r9 = r8.optString("title");
        L25:
            JSONObject r10 = r15.z;
            if (r10 == null) goto L28;
            String r11 = r10.optString("allow_pop_message");
        L29:
            JSONObject r12 = r15.z;
            if (r12 == null) goto L32;
            String r13 = r12.optString("code_pop_message");
        L33:
            JSONObject r16 = r15.z;
            if (r16 == null) goto L36;
            String r17 = r16.optString("login_location");
        L37:
            JSONObject r19 = r15.z;
            if (r19 == null) goto L40;
            String r110 = r19.optString("login_device_name");
        L41:
            MfaPushCodeResponse r1 = new MfaPushCodeResponse(r6, r7, r9, r11, r13, r17, r110);
            MfaApi.a("/passport/device/get_push_code/", true, null, null);
            Object r111 = new com.larus.account.saas.mfa.network.a.d(r1);
        L54:
            this.a.resumeWith(Result.constructor-impl(r111));
            return;
        L40:
            r110 = null;
            goto L41
        L36:
            r17 = null;
            goto L37
        L32:
            r13 = null;
            goto L33
        L28:
            r11 = null;
            goto L29
        L24:
            r9 = null;
            goto L25
        L20:
            r7 = null;
            goto L21
        L16:
            r6 = null;
            goto L17
        L43:
            if (r15 == null) goto L45;
            int r20 = ((ua7.b) r15).g;
        L46:
            if (r15 == null) goto L51;
            String r21 = ((ua7.b) r15).i;
            if (r21 == null) goto L51;
            r4 = r21;
        L53:
            com.larus.account.saas.mfa.network.a.b r0 = new com.larus.account.saas.mfa.network.a.b(r20, r4);
            int r112 = MfaApi.a;
            MfaApi.a("/passport/device/get_push_code/", false, Integer.valueOf(r20), r4);
            r111 = new com.larus.account.saas.mfa.network.a.C0065a(r0);
        L51:
            if (r15 == null) goto L53;
            r4 = ((ua7.b) r15).j;
            goto L53
        L45:
            r20 = -1;
            goto L46
        L8:
            if (((ua7.b) r15).c != true) goto L10;
            r2 = true;
            goto L11
        }
    }

    public static final class b extends ua7.a<c> {
        public final /* synthetic */ i<com.larus.account.saas.mfa.network.a<JSONObject>> a;

        public b(j r1) {
            this.a = r1;
        }

        public final void onResponse(ua7.b r7) {
            c r8 = (c) r7;
            if (this.a.isActive() == true) goto L6;
            return;
        L6:
            if (r8 != null) goto L8;
        L10:
            boolean r2 = false;
        L11:
            String r4 = null;
            if (r2 == false) goto L15;
            MfaApi.a("/passport/safe/query_decision/", true, null, null);
            Object r0 = new com.larus.account.saas.mfa.network.a.d(r8.z);
        L26:
            this.a.resumeWith(Result.constructor-impl(r0));
            return;
        L15:
            if (r8 == null) goto L17;
            int r3 = ((ua7.b) r8).g;
        L18:
            if (r8 == null) goto L23;
            String r5 = ((ua7.b) r8).i;
            if (r5 == null) goto L23;
            r4 = r5;
        L25:
            com.larus.account.saas.mfa.network.a.b r1 = new com.larus.account.saas.mfa.network.a.b(r3, r4);
            int r9 = MfaApi.a;
            MfaApi.a("/passport/safe/query_decision/", false, Integer.valueOf(r3), r4);
            r0 = new com.larus.account.saas.mfa.network.a.C0065a(r1);
        L23:
            if (r8 == null) goto L25;
            r4 = ((ua7.b) r8).j;
            goto L25
        L17:
            r3 = -2;
            goto L18
        L8:
            if (((ua7.b) r8).c != true) goto L10;
            r2 = true;
            goto L11
        }
    }

    static {
    }

    public MfaApi() {
    }

    public static Object b(String r7, String r8, Continuation r9) {
        j r0 = new j(IntrinsicsKt.intercepted(r9), 1);
        r0.C();
        final a r1 = new a(r0);
        r0.i(new MfaApi$requestPushCode$2$1(r1));
        SaasTracking r3 = SaasTracking.a;
        JSONObject r4 = new JSONObject();
        r4.put("path", "/passport/device/get_push_code/");
        Unit r5 = Unit.INSTANCE;
        r3.reportEvent("doubao_account_network_request", r4);
        d0 r6 = d0.c();
        Pair[] r10 = new Pair[2];
        r10[0] = TuplesKt.to("user_code", r7);
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        r10[1] = TuplesKt.to("scene", r8);
        d0 r11 = r6;
        r11.b("/passport/device/get_push_code/", null, MapsKt.mapOf(r10), r1);
        Object r12 = r0.B();
        if (r12 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L8;
        DebugProbesKt.probeCoroutineSuspended(r9);
    L8:
        return r12;
    }

    public static Object c(String r8, String r9, Continuation r10) {
        j r0 = new j(IntrinsicsKt.intercepted(r10), 1);
        r0.C();
        final b r1 = new b(r0);
        r0.i(new MfaApi$requestVerifyDecision$2$1(r1));
        SaasTracking r3 = SaasTracking.a;
        JSONObject r4 = new JSONObject();
        r4.put("path", "/passport/safe/query_decision/");
        Unit r5 = Unit.INSTANCE;
        r3.reportEvent("doubao_account_network_request", r4);
        d0 r6 = d0.c();
        d0 r7 = r6;
        r7.a("/passport/safe/query_decision/", null, MapsKt.mapOf(new Pair[]{TuplesKt.to("account_flow", "verify"), TuplesKt.to("template", r9), TuplesKt.to("verify_scene", r8)}), r1);
        Object r11 = r0.B();
        if (r11 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L5;
        DebugProbesKt.probeCoroutineSuspended(r10);
    L5:
        return r11;
    }

    public static void a(String r3, boolean r4, Integer r5, String r6) {
        SaasTracking r0 = SaasTracking.a;
        JSONObject r1 = new JSONObject();
        r1.put("path", r3);
        r1.put("success", r4 ? 1 : 0);
        if (r5 == null) goto L5;
        r1.put("err_code", r5.intValue());
    L5:
        if (r6 == null) goto L7;
        r1.put("err_msg", r6);
    L7:
        Unit r7 = Unit.INSTANCE;
        r0.reportEvent("doubao_account_network_result", r1);
    }
}
