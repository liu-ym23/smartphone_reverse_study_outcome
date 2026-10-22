package t0;

import androidx.lifecycle.h0;
import androidx.lifecycle.i0;
import he.i;

/* JADX INFO: loaded from: classes.dex */
public final class b implements i0.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<?>[] f12208a;

    public b(e<?>... r8) {
        i.f(r8, "initializers");
        this.f12208a = r8;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // androidx.lifecycle.i0.b
    public final h0 b(Class r8, d r10) {
        e<?>[] r11 = this.f12208a;
        int r12 = r11.length;
        int r13 = 0;
        h0 r14 = null;
    L3:
        if (r13 >= r12) goto L11;
        e<?> r15 = r11[r13];
        if (i.a(r15.f12210a, r8) == false) goto L10;
        Object r16 = r15.f12211b.invoke(r10);
        if ((r16 instanceof h0) == false) goto L9;
        r14 = (h0) r16;
        goto L10
    L9:
        r14 = null;
    L10:
        r13 = r13 + 1;
        goto L3
    L11:
        if (r14 == null) goto L14;
        return r14;
    L14:
        throw new IllegalArgumentException("No initializer set for given class ".concat(r8.getName()));
    }
}
