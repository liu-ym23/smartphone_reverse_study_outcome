package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.openLoginPage.AbsOpenLoginPageMethodIDL;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class l implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ l(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        f3.h r0 = this.a;
        int r1 = OpenLoginPageMethod.b;
        Object r11 = ((Result) r10).unbox-impl();
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L5;
        Unit r13 = (Unit) r11;
        Intrinsics.checkNotNullParameter(AbsOpenLoginPageMethodIDL.a.class, "<this>");
        f3.h.a.b(r0, (ResultModel) k3.c.a(AbsOpenLoginPageMethodIDL.a.class));
    L10:
        return Unit.INSTANCE;
    L5:
        com.bytedance.ai.utils.g.a.e("OpenLoginPageMethod", "open MOA login page failed: " + r12.getMessage());
        String r14 = r12.getMessage();
        if (r14 != null) goto L8;
        r14 = "openLoginPage failed";
    L8:
        f3.h.a.a(r0, r14, null, null, 14);
        goto L10
    }
}
