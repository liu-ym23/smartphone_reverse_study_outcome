package ke;

/* JADX INFO: loaded from: classes2.dex */
public final class c extends a {

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final c f9116n = null;

    static {
        f9116n = new c(1, 0);
    }

    public c(int r8, int r10) {
        super(r8, r10, 1);
    }

    @Override // ke.a
    public final boolean equals(Object r8) {
        if ((r8 instanceof c) == true) goto L5;
    L13:
        return false;
    L5:
        if (isEmpty() == true) goto L7;
    L8:
        c r10 = (c) r8;
        int r11 = r10.f9109a;
        if (this.f9109a != r11) goto L13;
        int r12 = r10.f9110b;
        if (this.f9110b != r12) goto L13;
    L12:
        return true;
    L7:
        if (((c) r8).isEmpty() == true) goto L12;
        goto L8
    }

    @Override // ke.a
    public final int hashCode() {
        if (isEmpty() == false) goto L5;
        return -1;
    L5:
        int r8 = this.f9109a * 31;
        return this.f9110b + r8;
    }

    @Override // ke.a
    public final boolean isEmpty() {
        if (this.f9109a <= this.f9110b) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // ke.a
    public final String toString() {
        return this.f9109a + ".." + this.f9110b;
    }
}
