package he;

/* JADX INFO: loaded from: classes2.dex */
public final class k implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Class<?> f8062a;

    public k(Class r8) {
        i.f(r8, "jClass");
        this.f8062a = r8;
    }

    @Override // he.c
    public final Class<?> a() {
        return this.f8062a;
    }

    public final boolean equals(Object r8) {
        if ((r8 instanceof k) == false) goto L7;
        Class<?> r10 = ((k) r8).f8062a;
        if (i.a(this.f8062a, r10) == false) goto L7;
        return true;
    L7:
        return false;
    }

    public final int hashCode() {
        return this.f8062a.hashCode();
    }

    public final String toString() {
        return this.f8062a.toString() + " (Kotlin reflection is not available)";
    }
}
