package xd;

import java.io.Serializable;

/* JADX INFO: loaded from: classes2.dex */
public final class f<T> implements b<T>, Serializable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ge.a<? extends T> f13871a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile Object f13872b;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final Object f13873m;

    public f(ge.a r8) {
        he.i.f(r8, "initializer");
        this.f13871a = r8;
        this.f13872b = defpackage.c.f3214s;
        this.f13873m = this;
    }

    @Override // xd.b
    public final T getValue() {
        T r8 = (T) this.f13872b;
        defpackage.c r10 = defpackage.c.f3214s;
        if (r8 == r10) goto L5;
        return r8;
    L5:
        Object r11 = this.f13873m;
        monitor-enter(r11);
        T r12 = (T) this.f13872b;
        if (r12 != r10) goto L11;
        ge.a<? extends T> r13 = this.f13871a;     // Catch: Throwable -> L13
        he.i.c(r13);     // Catch: Throwable -> L13
        r12 = r13.f();     // Catch: Throwable -> L13
        this.f13872b = r12;     // Catch: Throwable -> L13
        this.f13871a = null;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r11);
        return r12;
    L13:
        th = move-exception;
        throw th;
    }

    public final String toString() {
        if (this.f13872b == defpackage.c.f3214s) goto L5;
        boolean r8 = true;
    L6:
        if (r8 == true) goto L10;
        return "Lazy value not initialized yet.";
    L10:
        return String.valueOf(getValue());
    L5:
        r8 = false;
        goto L6
    }
}
