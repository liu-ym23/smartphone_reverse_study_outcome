package ke;

/* JADX INFO: loaded from: classes2.dex */
public final class f extends d {
    static {
        new f(1, 0);
    }

    public final boolean equals(Object r11) {
        if ((r11 instanceof f) == false) goto L20;
        long r8 = this.f9117a;
        long r10 = this.f9118b;
        if (r8 <= r10) goto L7;
        boolean r12 = true;
    L8:
        if (r12 == false) goto L14;
        f r13 = (f) r11;
        if (r13.f9117a <= r13.f9118b) goto L12;
        boolean r14 = true;
    L13:
        if (r14 == false) goto L14;
    L19:
        return true;
    L12:
        r14 = false;
    L14:
        f r15 = (f) r11;
        if (r8 == r15.f9117a) goto L17;
        return false;
    L17:
        if (r10 == r15.f9118b) goto L19;
        return false;
    L7:
        r12 = false;
        goto L8
    L20:
        return false;
    }

    public final int hashCode() {
        long r8 = this.f9117a;
        long r10 = this.f9118b;
        if (r8 <= r10) goto L5;
        boolean r11 = true;
    L6:
        if (r11 == false) goto L9;
        return -1;
    L9:
        return (int) ((((long) 31) * (r8 ^ (r8 >>> 32))) + ((r10 >>> 32) ^ r10));
    L5:
        r11 = false;
        goto L6
    }

    public final String toString() {
        return this.f9117a + ".." + this.f9118b;
    }
}
