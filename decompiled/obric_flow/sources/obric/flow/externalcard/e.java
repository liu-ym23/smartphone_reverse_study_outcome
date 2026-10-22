package obric.flow.externalcard;

/* JADX INFO: loaded from: classes3.dex */
public final class e extends h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20442a;

    public e(boolean r5) {
        this.f20442a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.f20442a == ((e) r5).f20442a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f20442a);
    }

    public final String toString() {
        return "onResumeOrPause(resume=" + this.f20442a + ")";
    }
}
