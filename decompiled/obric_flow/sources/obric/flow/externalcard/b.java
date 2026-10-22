package obric.flow.externalcard;

/* JADX INFO: loaded from: classes3.dex */
public final class b extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20438a;

    public b(boolean r5) {
        this.f20438a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.f20438a == ((b) r5).f20438a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f20438a);
    }

    public final String toString() {
        return "attachedToWindow(bool=" + this.f20438a + ")";
    }
}
