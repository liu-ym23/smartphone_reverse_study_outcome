package obric.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20436a;

    public e(boolean r5) {
        this.f20436a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f20436a == ((e) r5).f20436a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f20436a);
    }

    public final String toString() {
        return "screenChange(screenOn=" + this.f20436a + ")";
    }
}
