package ka;

import ha.c0;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

/* JADX INFO: loaded from: classes.dex */
public final class q<T> extends c0<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ha.j f9051a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final c0<T> f9052b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Type f9053c;

    public q(ha.j r8, c0<T> r10, Type r11) {
        this.f9051a = r8;
        this.f9052b = r10;
        this.f9053c = r11;
    }

    @Override // ha.c0
    public final T a(pa.a r8) {
        return this.f9052b.a(r8);
    }

    @Override // ha.c0
    public final void b(pa.c r8, T r10) {
        Type r11 = this.f9053c;
        if (r10 != null) goto L5;
    L9:
        Type r12 = r11;
    L10:
        c0<T> r13 = this.f9052b;
        if (r12 == r11) goto L26;
        c0<T> r14 = this.f9051a.f(oa.a.get(r12));
        if ((r14 instanceof n.a) == false) goto L25;
        c0<T> r15 = r13;
    L17:
        if ((r15 instanceof o) == false) goto L23;
        c0<T> r16 = ((o) r15).c();
        if (r16 == r15) goto L23;
        r15 = r16;
    L23:
        if ((r15 instanceof n.a) == false) goto L26;
    L25:
        r13 = r14;
    L26:
        r13.b(r8, r10);
        return;
    L5:
        if ((r11 instanceof Class) == false) goto L7;
    L8:
        r12 = r10.getClass();
        goto L10
    L7:
        if ((r11 instanceof TypeVariable) == false) goto L9;
        goto L8
    }
}
