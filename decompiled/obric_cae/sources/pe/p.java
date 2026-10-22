package pe;

/* JADX INFO: loaded from: classes2.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f10053a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ge.l<Throwable, xd.j> f10054b;

    /* JADX WARN: Multi-variable type inference failed */
    public p(Object r8, ge.l<? super Throwable, xd.j> r10) {
        this.f10053a = r8;
        this.f10054b = r10;
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof p) == true) goto L8;
        return false;
    L8:
        p r10 = (p) r8;
        Object r11 = r10.f10053a;
        if (he.i.a(this.f10053a, r11) == true) goto L12;
        return false;
    L12:
        if (he.i.a(this.f10054b, r10.f10054b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        Object r8 = this.f10053a;
        if (r8 != null) goto L5;
        int r10 = 0;
    L6:
        int r11 = this.f10054b.hashCode();
        return r11 + (r10 * 31);
    L5:
        r10 = r8.hashCode();
        goto L6
    }

    public final String toString() {
        return "CompletedWithCancellation(result=" + this.f10053a + ", onCancellation=" + this.f10054b + ')';
    }
}
