package com.larus.bmhome.chat.list.cell.edu_continue_shot;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class b implements Function1 {
    public final /* synthetic */ EduContinueShotCell a;

    public /* synthetic */ b(EduContinueShotCell r1) {
        this.a = r1;
    }

    public final Object invoke(Object r4) {
        final EduContinueShotCell r0 = this.a;
        ii9.b r5 = (ii9.b) r4;
        Intrinsics.checkNotNullParameter(r5, "$this$expose");
        Function0 r1 = new c(r0);
        r5.getClass();
        Intrinsics.checkNotNullParameter(r1, "cellId");
        r5.a = r1;
        Function1 r2 = new d(r0);
        Intrinsics.checkNotNullParameter(r2, "block");
        r5.b = r2;
        return Unit.INSTANCE;
    }
}
