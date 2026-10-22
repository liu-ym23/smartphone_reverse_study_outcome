package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.core.model.idl.BaseModel;
import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import com.bytedance.ai.bridge.login.AbsLoginMethodIDL;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ f3.h a;

    public /* synthetic */ i(f3.h r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10) {
        f3.h r0 = this.a;
        int r1 = LoginMethod.b;
        Object r11 = ((Result) r10).unbox-impl();
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 != null) goto L6;
        Intrinsics.checkNotNullParameter(AbsLoginMethodIDL.b.class, "<this>");
        BaseModel r13 = k3.c.a(AbsLoginMethodIDL.b.class);
        ((AbsLoginMethodIDL.b) r13).setCode((String) r11);
        f3.h.a.b(r0, (ResultModel) r13);
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
