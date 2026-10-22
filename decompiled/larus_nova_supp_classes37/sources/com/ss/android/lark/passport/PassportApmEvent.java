package com.ss.android.lark.passport;

import com.bytedance.apm.ApmAgent;
import com.ss.android.lark.openplatform.common.constant.AppbrandHostConstants;
import com.ss.android.lark.opmonitor.trace.OPTrace;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class PassportApmEvent {
    public static final PassportApmEvent a = null;

    static {
        a = new PassportApmEvent();
    }

    public PassportApmEvent() {
    }

    public static com.bytedance.apm.config.d h(final String r3) {
        return A("office_sdk.passport.flow_runtime", OPTrace.BATCH_CODE, "model_transform_start", new PassportApmEvent$flowRuntimeModelTransformStartEvent$1(r3));
    }

    public static com.bytedance.apm.config.d p(final String r3) {
        final String r1 = "first_party";
        Intrinsics.checkNotNullParameter("first_party", "type");
        return A("office_sdk.passport.mfa", OPTrace.BATCH_CODE, "mfa_start", new PassportApmEvent$mfaStartEvent$1(r1, r3));
    }

    public static com.bytedance.apm.config.d y(String r5) {
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        com.bytedance.apm.config.d.a r1 = new com.bytedance.apm.config.d.a();
        r1.a = "passport_office_event";
        JSONObject r2 = new JSONObject();
        r2.put("monitor_message", "office_sdk_passport_net_start");
        r2.put(AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, r5);
        r1.c = r2;
        return new com.bytedance.apm.config.d(r1);
    }

    public final void q(Function1<? super PassportApmEvent, ? extends com.bytedance.apm.config.d> r2) {
        Intrinsics.checkNotNullParameter(r2, "func");
        ApmAgent.monitorEvent((com.bytedance.apm.config.d) r2.invoke(this));
    }

    public static com.bytedance.apm.config.d B(final Object r2, final String r3) {
        return A("office_sdk.passport.common", OPTrace.BATCH_CODE, "runtime_anomaly", new PassportApmEvent$runtimeAnomalyEvent$1(r2, r3));
    }

    public static com.bytedance.apm.config.d d(boolean r4, long r5) {
        com.bytedance.apm.config.d.a r0 = new com.bytedance.apm.config.d.a();
        r0.a = "passport_office_event";
        JSONObject r1 = new JSONObject();
        r1.put("monitor_message", "flow_passport_check_mfa_result");
        if (r4 == false) goto L5;
        String r6 = "success";
    L6:
        r1.put("result_type", r6);
        r1.put("duration", r5);
        r0.c = r1;
        return new com.bytedance.apm.config.d(r0);
    L5:
        r6 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d f(final String r2, final String r3) {
        return A("office_sdk.passport.flow_runtime", 10002, "event_handle_start", new PassportApmEvent$flowRuntimeEventHandleStartEvent$1(r2, r3));
    }

    public static com.bytedance.apm.config.d j(final String r2, final Boolean r3) {
        return A("office_sdk.passport.idp", 10004, "idp_dispatch_start", new PassportApmEvent$idpDispatchStartEvent$1(r2, r3));
    }

    public static com.bytedance.apm.config.d l(final String r2, final Boolean r3) {
        return A("office_sdk.passport.idp", OPTrace.BATCH_CODE, "idp_prepare_start", new PassportApmEvent$idpPrepareStartEvent$1(r2, r3));
    }

    public static com.bytedance.apm.config.d n(final String r2, final Boolean r3) {
        return A("office_sdk.passport.idp", 10002, "idp_verify_start", new PassportApmEvent$idpVerifyStartEvent$1(r2, r3));
    }

    public static final void c(PassportApmEvent r0, JSONObject r1, boolean r2) {
        r0.getClass();
        if (r2 == false) goto L5;
        String r3 = "success";
    L6:
        r1.put("result_type", r3);
        return;
    L5:
        r3 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d g(final boolean r1, final long r2, final String r4) {
        return A("office_sdk.passport.flow_runtime", 10001, "model_transform_result", new PassportApmEvent$flowRuntimeModelTransformResultEvent$1(r1, r2, r4));
    }

    public static com.bytedance.apm.config.d o(final boolean r7, final long r8, final String r10) {
        final String r4 = "first_party";
        Intrinsics.checkNotNullParameter("first_party", "type");
        return A("office_sdk.passport.mfa", 10001, "mfa_result", new PassportApmEvent$mfaResultEvent$1(r7, r8, r4, r10));
    }

    public static com.bytedance.apm.config.d z(String r4, boolean r5, long r6) {
        Intrinsics.checkNotNullParameter(r4, "uid");
        com.bytedance.apm.config.d.a r0 = new com.bytedance.apm.config.d.a();
        r0.a = "passport_office_event";
        JSONObject r1 = new JSONObject();
        r1.put("monitor_message", "office_sdk_passport_online_result");
        if (r5 == false) goto L5;
        String r7 = "success";
    L6:
        r1.put("result_type", r7);
        r1.put("duration", r6);
        r1.put("lark_uid", r4);
        r0.c = r1;
        return new com.bytedance.apm.config.d(r0);
    L5:
        r7 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d A(String r3, int r4, String r5, Function1 r6) {
        com.bytedance.apm.config.d.a r0 = new com.bytedance.apm.config.d.a();
        r0.a = "passport_office_event";
        JSONObject r1 = new JSONObject();
        r1.put("monitor_domain", r3);
        r1.put("monitor_code", r4);
        r1.put("monitor_message", r5);
        r6.invoke(r1);
        r0.c = r1;
        return new com.bytedance.apm.config.d(r0);
    }

    public static final void a(PassportApmEvent r0, JSONObject r1, String r2, String r3) {
        r0.getClass();
        if (r3 != null) goto L5;
    L8:
        boolean r4 = true;
    L9:
        if (r4 == true) goto L12;
        r1.put(r2, r3);
        return;
    L12:
        return;
    L5:
        if (StringsKt.isBlank(r3) == true) goto L8;
        r4 = false;
        goto L9
    }

    public static final void b(PassportApmEvent r0, JSONObject r1, String r2, Object r3) {
        r0.getClass();
        if (r3 == null) goto L6;
        r1.put(r2, r3);
        return;
    }

    public static com.bytedance.apm.config.d e(final boolean r7, final long r8, final String r10, final String r11) {
        return A("office_sdk.passport.flow_runtime", 10003, "event_handle_result", new PassportApmEvent$flowRuntimeEventHandleResultEvent$1(r7, r8, r10, r11));
    }

    public static com.bytedance.apm.config.d i(final String r7, final Boolean r8, final boolean r9, final long r10) {
        return A("office_sdk.passport.idp", 10005, "idp_dispatch_result", new PassportApmEvent$idpDispatchResultEvent$1(r9, r10, r7, r8));
    }

    public static com.bytedance.apm.config.d k(final String r7, final Boolean r8, final boolean r9, final long r10) {
        return A("office_sdk.passport.idp", 10001, "idp_prepare_result", new PassportApmEvent$idpPrepareResultEvent$1(r9, r10, r7, r8));
    }

    public static com.bytedance.apm.config.d m(final String r7, final Boolean r8, final boolean r9, final long r10) {
        return A("office_sdk.passport.idp", 10003, "idp_verify_result", new PassportApmEvent$idpVerifyResultEvent$1(r9, r10, r7, r8));
    }

    public static com.bytedance.apm.config.d s(final String r7, final String r8, final String r9, final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r7, "factorType");
        return A("office_sdk.passport.multi_verify", 10002, "challenge_start", new PassportApmEvent$multiVerifyChallengeStartEvent$1(r7, r8, r9, r10, r11));
    }

    public static com.bytedance.apm.config.d t(final String r7, final String r8, final String r9, final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r7, "factorType");
        return A("office_sdk.passport.multi_verify", 10001, "factor_cancel", new PassportApmEvent$multiVerifyFactorCancelEvent$1(r7, r8, r9, r10, r11));
    }

    public static com.bytedance.apm.config.d u(final String r7, final String r8, final String r9, final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r7, "factorType");
        return A("office_sdk.passport.multi_verify", OPTrace.BATCH_CODE, "factor_enter", new PassportApmEvent$multiVerifyFactorEnterEvent$1(r7, r8, r9, r10, r11));
    }

    public static com.bytedance.apm.config.d w(final String r7, final String r8, final String r9, final String r10, final String r11) {
        Intrinsics.checkNotNullParameter(r7, "factorType");
        return A("office_sdk.passport.multi_verify", 10004, "verify_start", new PassportApmEvent$multiVerifyVerifyStartEvent$1(r7, r8, r9, r10, r11));
    }

    public static com.bytedance.apm.config.d x(String r5, boolean r6, long r7, Integer r9, String r10) {
        Intrinsics.checkNotNullParameter(r5, AppbrandHostConstants.Schema_RESERVED_FIELD.PATH);
        com.bytedance.apm.config.d.a r1 = new com.bytedance.apm.config.d.a();
        r1.a = "passport_office_event";
        JSONObject r2 = new JSONObject();
        r2.put("monitor_message", "office_sdk_passport_net_result");
        if (r6 == false) goto L5;
        String r8 = "success";
    L6:
        r2.put("result_type", r8);
        r2.put("duration", r7);
        r2.put("http_code", r9);
        r2.put("logid", r10);
        r2.put(AppbrandHostConstants.Schema_RESERVED_FIELD.PATH, r5);
        r1.c = r2;
        return new com.bytedance.apm.config.d(r1);
    L5:
        r8 = "fail";
        goto L6
    }

    public static com.bytedance.apm.config.d r(final String r10, final String r11, final String r12, final String r13, final String r14, final boolean r15, final long r16) {
        Intrinsics.checkNotNullParameter(r10, "factorType");
        return A("office_sdk.passport.multi_verify", 10003, "challenge_result", new PassportApmEvent$multiVerifyChallengeResultEvent$1(r15, r16, r10, r11, r12, r13, r14));
    }

    public static com.bytedance.apm.config.d v(final String r10, final String r11, final String r12, final String r13, final String r14, final boolean r15, final long r16) {
        Intrinsics.checkNotNullParameter(r10, "factorType");
        return A("office_sdk.passport.multi_verify", 10005, "verify_result", new PassportApmEvent$multiVerifyVerifyResultEvent$1(r15, r16, r10, r11, r12, r13, r14));
    }
}
