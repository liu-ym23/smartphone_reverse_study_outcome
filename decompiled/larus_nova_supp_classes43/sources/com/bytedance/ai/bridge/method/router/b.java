package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Function3<k2.j, Boolean, String, Unit> {
    public final /* synthetic */ f3.h<AbsCreateTextMethodIDL.b> a;

    public b(f3.h<AbsCreateTextMethodIDL.b> r1) {
        this.a = r1;
    }

    public final Object invoke(Object r1, Object r10, Object r11) {
        k2.j r12 = (k2.j) r1;
        boolean r13 = ((Boolean) r10).booleanValue();
        Intrinsics.checkNotNullParameter((String) r11, com.bytedance.android.ec.core.event.a.KEY_MSG);
        if (r13 == false) goto L5;
        f3.h<AbsCreateTextMethodIDL.b> r14 = this.a;
        Intrinsics.checkNotNullParameter(AbsCreateTextMethodIDL.b.class, "<this>");
        f3.h.a.b(r14, (ResultModel) k3.c.a(AbsCreateTextMethodIDL.b.class));
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(this.a, null, null, null, 15);
        goto L7
    }
}
