package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.core.model.idl.ResultModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d implements Function3<k2.j, Boolean, String, Unit> {
    public final /* synthetic */ f3.h<AbsCreateWidgetMethodIDL.b> a;

    public d(f3.h<AbsCreateWidgetMethodIDL.b> r1) {
        this.a = r1;
    }

    public final Object invoke(Object r10, Object r11, Object r12) {
        k2.j r13 = (k2.j) r10;
        boolean r14 = ((Boolean) r11).booleanValue();
        String r15 = (String) r12;
        Intrinsics.checkNotNullParameter(r15, com.bytedance.android.ec.core.event.a.KEY_MSG);
        if (r14 == false) goto L5;
        f3.h<AbsCreateWidgetMethodIDL.b> r16 = this.a;
        Intrinsics.checkNotNullParameter(AbsCreateWidgetMethodIDL.b.class, "<this>");
        f3.h.a.b(r16, (ResultModel) k3.c.a(AbsCreateWidgetMethodIDL.b.class));
    L7:
        return Unit.INSTANCE;
    L5:
        f3.h.a.a(this.a, r15, null, null, 14);
        goto L7
    }
}
