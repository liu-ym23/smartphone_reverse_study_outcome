package com.ss.android.lark.passport.flow.verify.viewmodel;

import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.passport.flow.core.router.FlowStep;
import com.ss.android.lark.passport.flow.core.security.RsaInfo;
import com.ss.android.lark.passport.flow.mfa.FlowMfaError;
import com.ss.android.lark.passport.flow.mfa.FlowMfaErrorCategory;
import com.ss.android.lark.passport.flow.mfa.FlowMfaFlowSession;
import com.ss.android.lark.passport.flow.mfa.FlowVerifyFactor;
import com.ss.android.lark.passport.flow.mfa.g;
import com.ss.android.lark.passport.flow.mfa.j;
import com.ss.android.lark.passport.flow.mfa.x;
import com.ss.android.lark.passport.flow.mfa.y;
import com.ss.android.lark.passport.flow.verify.entity.ButtonBean;
import com.ss.android.lark.passport.flow.verify.entity.InputBean;
import com.ss.android.lark.passport.flow.verify.entity.VerifyBean;
import com.ss.android.lark.passport.flow.verify.entity.VerifyListStepInfo;
import com.ss.android.lark.passport.signinsdk_api.base.NetworkErrorResult;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static x b(RsaInfo r3) {
        String r0 = r3.publicKey;
        if (r0 != null) goto L5;
        return null;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L22;
        String r4 = r3.rsaToken;
        if (r4 != null) goto L13;
        return null;
    L13:
        if ((!StringsKt.isBlank(r4)) == true) goto L16;
        r4 = null;
    L16:
        if (r4 != null) goto L19;
        return null;
    L19:
        return new x(r0, r4);
    L22:
        return null;
    }

    public static NetworkErrorResult c(FlowMfaError r12) {
        Intrinsics.checkNotNullParameter(r12, "error");
        Integer r0 = r12.getServerCode();
        if (r0 == null) goto L5;
        int r2 = r0.intValue();
    L6:
        String r1 = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{r12.getCategory().name(), r12.getStepName(), r12.getLogId()}), fyb.a.COMMA, null, null, 0, null, null, 62, null);
        String r3 = r12.getMessage();
        if (StringsKt.isBlank(r1) == false) goto L9;
        r1 = r12.getMessage();
    L9:
        NetworkErrorResult r4 = new NetworkErrorResult(r2, r3, 0, r1, 4, null);
        r4.setThrowable(r12.getCause());
        return r4;
    L5:
        r2 = -1;
        goto L6
    }

    public static j a(VerifyCommonViewModel r9, FlowStep r10) {
        if (r10 == null) goto L4;
        FlowMfaFlowSession r11 = r9.flowSession$flow_passport_mfa_release();
        if (r11 != null) goto L10;
        int r12 = g.a;
        return new j.c(new FlowMfaError(FlowMfaErrorCategory.PROCESS_RECREATED, "MFA flow state was lost", null, null, null, null, 60, null), true);
    L10:
        return r11.o(r10);
    L4:
        return new j.c(g.e(null), false);
    }

    public static Object d(VerifyCommonViewModel r20, Function3 r21, Continuation r22) {
        FlowMfaFlowSession r0 = r20.flowSession$flow_passport_mfa_release();
        if (r0 != null) goto L6;
        int r1 = g.a;
        return new j.c(new FlowMfaError(FlowMfaErrorCategory.PROCESS_RECREATED, "MFA flow state was lost", null, null, null, null, 60, null), true);
    L6:
        xyb.a r2 = (xyb.a) r20.getRepo().getValue();
        FlowVerifyFactor.a r3 = FlowVerifyFactor.Companion;
        int r4 = r2.a;
        r3.getClass();
        FlowVerifyFactor r5 = FlowVerifyFactor.a.a(r4);
        if (r5 != null) goto L9;
        r0 = r0;
        y r6 = null;
    L71:
        if (r6 != null) goto L75;
        int r7 = g.a;
        xyb.a r8 = (xyb.a) r20.getRepo().getValue();
        return new j.c(g.e(String.valueOf(xyb.a.g.get(Integer.valueOf(r8.a)))), false);
    L75:
        return r21.invoke(r0, r6, r22);
    L9:
        VerifyBean r9 = r2.e;
        String r10 = r9.getTitle();
        String r11 = r9.getSubTitle();
        String r12 = r9.getFlowType();
        boolean r13 = Intrinsics.areEqual(r9.getDisabled(), Boolean.TRUE);
        String r14 = r9.getDisabledToastText();
        InputBean r15 = r9.getInputBox();
        if (r15 == null) goto L12;
        String r16 = r15.getPlaceholder();
    L14:
        if (r16 != null) goto L16;
        r16 = "";
    L16:
        InputBean r17 = r9.getInputBox();
        if (r17 == null) goto L19;
        String r18 = r17.getLabel();
    L20:
        if (r18 != null) goto L22;
        r18 = "";
    L22:
        ButtonBean r19 = r9.getNextButton();
        if (r19 == null) goto L25;
        String r110 = r19.getText();
    L26:
        if (r110 != null) goto L28;
        r110 = "";
    L28:
        ButtonBean r111 = r9.getNextButton();
        if (r111 == null) goto L31;
        FlowStep r112 = r111.getNext();
    L32:
        RsaInfo r113 = r9.getRsaInfo();
        if (r113 == null) goto L35;
        x r114 = b(r113);
    L36:
        JSONObject r115 = new JSONObject();
        FlowStep r116 = r0.g();
        if (r116 == null) goto L44;
        JSONObject r23 = r116.getStepInfo();
        if (r23 == null) goto L44;
        JSONObject r24 = r23.getJSONObject(r5.getWireKey());
        if (r24 == null) goto L44;
        r115.putAll(r24);
    L44:
        if (r115.containsKey("title") == true) goto L47;
        r115.put("title", r9.getTitle());
    L47:
        if (r115.containsKey("subtitle") == true) goto L50;
        r115.put("subtitle", r9.getSubTitle());
    L50:
        if (r115.containsKey("flow_type") == true) goto L53;
        r115.put("flow_type", r9.getFlowType());
    L53:
        if (r115.containsKey("use_package_domain") == true) goto L60;
        VerifyListStepInfo r25 = r2.b;
        if (r25 == null) goto L57;
        boolean r26 = r25.getUsePackageDomain();
    L58:
        r115.put("use_package_domain", Boolean.valueOf(r26));
        goto L60
    L57:
        r26 = false;
    L60:
        if (r115.containsKey("rsa_info") == true) goto L69;
        RsaInfo r27 = r9.getRsaInfo();
        if (r27 == null) goto L69;
        x r28 = b(r27);
        if (r28 != null) goto L66;
        JSONObject r29 = null;
    L67:
        if (r29 == null) goto L70;
        r115.put("rsa_info", r29);
    L70:
        r6 = new y(r5, r10, r11, r12, r13, r14, r16, r18, r110, r112, r114, r115);
        goto L71
    L66:
        r29 = new JSONObject();
        r29.put("public_key", r28.a);
        r29.put("rsa_token", r28.b);
    L69:
        r0 = r0;
        goto L70
    L35:
        r114 = null;
        goto L36
    L31:
        r112 = null;
        goto L32
    L25:
        r110 = null;
        goto L26
    L19:
        r18 = null;
        goto L20
    L12:
        r16 = null;
        goto L14
    }
}
