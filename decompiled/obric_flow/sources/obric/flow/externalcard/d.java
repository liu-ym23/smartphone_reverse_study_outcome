package obric.flow.externalcard;

/* JADX INFO: loaded from: classes3.dex */
public final class d extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20441a;

    public d(boolean r5) {
        this.f20441a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof d) == true) goto L9;
        return false;
    L9:
        if (this.f20441a == ((d) r5).f20441a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f20441a);
    }

    public final String toString() {
        return "minusOneExit(exit=" + this.f20441a + ")";
    }
}
