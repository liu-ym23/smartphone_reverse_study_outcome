package z9b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c {
    public final boolean a;
    public final int b;
    public final int c;
    public final boolean d;

    public c() {
        int r0 = 0;
        this(r0, r0, 15);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof c) == true) goto L8;
        return false;
    L8:
        c r6 = (c) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = ((((r0 * 31) + this.b) * 31) + this.c) * 31;
        if (this.d == true) goto L11;
        r1 = 1237;
    L11:
        return r2 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "UnifyAtStyleConfig(enable=" + this.a + ", atTextColorResFromMe=" + this.b + ", atTextColorResFromOther=" + this.c + ", enableBold=" + this.d + ')';
    }

    public /* synthetic */ c(int r3, int r4, int r5) {
        if ((r5 & 2) == 0) goto L6;
        r3 = 0;
    L6:
        if ((r5 & 4) == 0) goto L8;
        r4 = 0;
    L8:
        this(false, r3, r4, false);
    }

    public c(boolean r1, int r2, int r3, boolean r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }
}
