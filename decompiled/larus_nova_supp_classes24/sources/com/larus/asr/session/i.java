package com.larus.asr.session;

import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final /* synthetic */ class i implements Function1 {
    public final /* synthetic */ AtomicBoolean a;
    public final /* synthetic */ ComponentAsrSession b;
    public final /* synthetic */ int c;
    public final /* synthetic */ com.larus.asr.session.component.b0 d;

    public /* synthetic */ i(AtomicBoolean r1, ComponentAsrSession r2, int r3, com.larus.asr.session.component.b0 r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final Object invoke(Object r7) {
        AtomicBoolean r0 = this.a;
        ComponentAsrSession r1 = this.b;
        int r2 = this.c;
        com.larus.asr.session.component.b0 r3 = this.d;
        com.larus.asr.session.component.c0 r8 = (com.larus.asr.session.component.c0) r7;
        Intrinsics.checkNotNullParameter(r8, "result");
        if (r0.compareAndSet(false, true) == true) goto L6;
        return Unit.INSTANCE;
    L6:
        if (Intrinsics.areEqual(r8, com.larus.asr.session.component.c0.b.a) == false) goto L9;
        r1.c(r2 + 1, r3);
    L12:
        return Unit.INSTANCE;
    L9:
        if (Intrinsics.areEqual(r8, com.larus.asr.session.component.c0.a.a) == false) goto L14;
        com.larus.asr.session.component.f0 r9 = r3.getContext();
        r1.getClass();
        r9.h.set(true);
        r9.f(true);
        goto L12
    L14:
        throw new NoWhenBranchMatchedException();
    }
}
