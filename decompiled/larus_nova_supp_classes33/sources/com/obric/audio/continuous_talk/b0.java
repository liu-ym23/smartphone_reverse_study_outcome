package com.obric.audio.continuous_talk;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Result;
import kotlin.jvm.internal.Intrinsics;
import wc9.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class b0 implements com.larus.bmhome.chat.component.cvs.y.a<e> {
    public final /* synthetic */ ObricContinuousTalkCtrlComponent a;
    public final /* synthetic */ AtomicBoolean b;
    public final /* synthetic */ kotlinx.coroutines.i<e> c;

    public final void c(Object r4) {
        e r5 = (e) r4;
        Intrinsics.checkNotNullParameter(r5, "new");
        ObricContinuousTalkCtrlComponent r0 = this.a;
        int r1 = ObricContinuousTalkCtrlComponent.L;
        com.larus.bmhome.chat.component.cvs.y r2 = r0.u0();
        if (r2 == null) goto L6;
        r2.lQ(this);
    L6:
        if (this.b.compareAndSet(false, true) == false) goto L9;
        this.c.resumeWith(Result.constructor-impl(r5));
        return;
    }

    public b0(ObricContinuousTalkCtrlComponent r1, AtomicBoolean r2, kotlinx.coroutines.i<? super e> r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
