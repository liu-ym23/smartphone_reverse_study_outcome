package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.privacySetting.AbsAgreePrivacyAuthorizationMethodIDL;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ c(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        f3.h r0 = this.a;
        int r1 = AgreeAuthMethod.b;
        Object r11 = ((Result) r10).unbox-impl();
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L5;
        Unit r13 = (Unit) r11;
        Intrinsics.checkNotNullParameter(AbsAgreePrivacyAuthorizationMethodIDL.a.class, "<this>");
        BaseModel r14 = k3.c.a(AbsAgreePrivacyAuthorizationMethodIDL.a.class);
        ((AbsAgreePrivacyAuthorizationMethodIDL.a) r14).setResult(true);
        f3.h.a.b(r0, (ResultModel) r14);
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(r0, "Error: " + r12.getMessage(), null, null, 14);
        goto L7
    }
}
