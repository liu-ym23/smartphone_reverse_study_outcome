package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.postMcpLogin.AbsPostLoginResultMethodIDL;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class o implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ o(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        f3.h r0 = this.a;
        int r1 = PostLoginResultMethod.b;
        Object r11 = ((Result) r10).unbox-impl();
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L6;
        Unit r13 = (Unit) r11;
        Intrinsics.checkNotNullParameter(AbsPostLoginResultMethodIDL.a.class, "<this>");
        f3.h.a.b(r0, (ResultModel) k3.c.a(AbsPostLoginResultMethodIDL.a.class));
    L13:
        return Unit.INSTANCE;
    L6:
        if ((r12 instanceof Exception) == false) goto L8;
        Exception r14 = (Exception) r12;
    L9:
        if (r14 != null) goto L11;
        r14 = new Exception(r12);
    L11:
        f3.h.a.a(r0, "Error: " + r12.getMessage(), d.a(r14), null, 10);
        goto L13
    L8:
        r14 = null;
        goto L9
    }
}
