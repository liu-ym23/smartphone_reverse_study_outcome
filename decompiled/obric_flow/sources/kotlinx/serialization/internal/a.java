package kotlinx.serialization.internal;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public abstract class a implements kotlinx.serialization.c {
    @Override // kotlinx.serialization.b
    public Object a(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        return d(r5);
    }

    public abstract Object b();

    public abstract int c(Object r5);

    public final Object d(eu.b r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        Object r10 = b();
        int r11 = c(r10);
        eu.a r12 = r5.i(getDescriptor());
    L3:
        int r13 = r12.l(getDescriptor());
        if (r13 == (-1)) goto L6;
        e(r12, r13 + r11, r10, true);
        goto L3
    L6:
        r12.u(getDescriptor());
        return g(r10);
    }

    public abstract void e(eu.a r5, int r10, Object r11, boolean r12);

    public abstract Object f(Object r5);

    public abstract Object g(Object r5);
}
