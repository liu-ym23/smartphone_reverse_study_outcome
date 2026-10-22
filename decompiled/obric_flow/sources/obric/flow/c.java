package obric.flow;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f20434a;

    public c(boolean r5) {
        this.f20434a = r5;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L9;
        return false;
    L9:
        if (this.f20434a == ((c) r5).f20434a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f20434a);
    }

    public final String toString() {
        return "onResumeOrPause(resume=" + this.f20434a + ")";
    }
}
