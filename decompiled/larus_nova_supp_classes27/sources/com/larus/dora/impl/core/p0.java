package com.larus.dora.impl.core;

import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import qk4.e;
import qk4.g;
import qk4.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class p0 implements Function1<Throwable, Unit> {
    public final /* synthetic */ i a;
    public final /* synthetic */ q0 b;
    public final /* synthetic */ int c;
    public final /* synthetic */ e d;
    public final /* synthetic */ long e;

    public p0(g r1, q0 r2, int r3, e r4, long r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    public final Object invoke(Object r7) {
        Throwable r8 = (Throwable) r7;
        s0.b(this.c, this.d, this.e, true, "cancel");
        g r9 = this.a;
        q0 r0 = this.b;
        ((CopyOnWriteArraySet) r9.e).remove(r0);
        return Unit.INSTANCE;
    }
}
