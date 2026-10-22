package com.obric.audio.continuous_talk;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final /* synthetic */ class t implements Function1 {
    public final /* synthetic */ ObricContinuousTalkCtrlComponent a;

    public /* synthetic */ t(ObricContinuousTalkCtrlComponent r1) {
        this.a = r1;
    }

    public final Object invoke(Object r6) {
        final ObricContinuousTalkCtrlComponent r0 = this.a;
        kotlinx.coroutines.i r7 = (kotlinx.coroutines.i) r6;
        int r1 = ObricContinuousTalkCtrlComponent.L;
        Intrinsics.checkNotNullParameter(r7, "cont");
        final AtomicBoolean r2 = new AtomicBoolean(false);
        final b0 r3 = new b0(r0, r2, r7);
        com.larus.bmhome.chat.component.cvs.y r4 = r0.u0();
        if (r4 == null) goto L5;
        r4.rh(new n(), r3);
    L5:
        r7.i(new o(r2, r0, r3));
        return Unit.INSTANCE;
    }
}
