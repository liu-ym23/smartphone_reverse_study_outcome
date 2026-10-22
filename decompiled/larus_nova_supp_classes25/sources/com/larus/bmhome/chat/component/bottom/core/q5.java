package com.larus.bmhome.chat.component.bottom.core;

import android.view.View;
import com.obric.assistant.spi.keyguard.a;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class q5 implements Function1 {
    public final /* synthetic */ CoreInputComponent a;

    public /* synthetic */ q5(CoreInputComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r3) {
        final CoreInputComponent r0 = this.a;
        int r1 = CoreInputComponent.d3;
        Intrinsics.checkNotNullParameter((View) r3, "it");
        if (r0.F4().getActionShown() == 1) goto L6;
        return Unit.INSTANCE;
    L6:
        if (r0.k4().c1() == true) goto L12;
        if (r0.i5() == true) goto L12;
        a.b(false, new e3(r0), 3);
        return Unit.INSTANCE;
    L12:
        return Unit.INSTANCE;
    }
}
