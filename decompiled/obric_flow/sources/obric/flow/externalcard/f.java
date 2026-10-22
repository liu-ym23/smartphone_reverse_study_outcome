package obric.flow.externalcard;

/* JADX INFO: loaded from: classes3.dex */
public final class f extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20447a;

    public f(boolean r5) {
        this.f20447a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof f) == true) goto L9;
        return false;
    L9:
        if (this.f20447a == ((f) r5).f20447a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f20447a);
    }

    public final String toString() {
        return "screenChange(screenOn=" + this.f20447a + ")";
    }
}
