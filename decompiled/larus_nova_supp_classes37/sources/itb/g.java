package itb;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class g {
    public final int a;
    public final boolean b;
    public final boolean c;
    public final int d;
    public final boolean e;
    public final boolean f;
    public final boolean g;

    public g() {
        this(0, false, false, false, 127);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof g) == true) goto L8;
        return false;
    L8:
        g r6 = (g) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L18;
        return false;
    L18:
        if (this.d == r6.d) goto L21;
        return false;
    L21:
        if (this.e == r6.e) goto L24;
        return false;
    L24:
        if (this.f == r6.f) goto L27;
        return false;
    L27:
        if (this.g == r6.g) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        int r2 = 1231;
        if (this.b == false) goto L5;
        int r1 = 1231;
    L6:
        int r3 = (r0 + r1) * 31;
        if (this.c == false) goto L9;
        int r4 = 1231;
    L10:
        int r5 = (((r3 + r4) * 31) + this.d) * 31;
        if (this.e == false) goto L13;
        int r6 = 1231;
    L14:
        int r7 = (r5 + r6) * 31;
        if (this.f == false) goto L17;
        int r8 = 1231;
    L18:
        int r9 = (r7 + r8) * 31;
        if (this.g == true) goto L23;
        r2 = 1237;
    L23:
        return r9 + r2;
    L17:
        r8 = 1237;
        goto L18
    L13:
        r6 = 1237;
        goto L14
    L9:
        r4 = 1237;
        goto L10
    L5:
        r1 = 1237;
        goto L6
    }

    public final String toString() {
        return "MediaPickConfig(maxSelectCount=" + this.a + ", supportImage=" + this.b + ", supportVideo=" + this.c + ", maxDurationMs=" + this.d + ", saveToAlbum=" + this.e + ", keepOriginal=" + this.f + ", useFrontCamera=" + this.g + ')';
    }

    public /* synthetic */ g(int r9, boolean r10, boolean r11, boolean r12, int r13) {
        if ((r13 & 1) == 0) goto L5;
        int r1 = 9;
    L7:
        if ((r13 & 2) == 0) goto L9;
        boolean r2 = true;
    L11:
        if ((r13 & 4) == 0) goto L13;
        boolean r3 = false;
    L15:
        if ((r13 & 8) == 0) goto L17;
        int r4 = 60000;
    L19:
        if ((r13 & 32) == 0) goto L21;
        boolean r6 = false;
    L22:
        this(r1, r2, r3, r4, false, r6, false);
        return;
    L21:
        r6 = r12;
        goto L22
    L17:
        r4 = 0;
        goto L19
    L13:
        r3 = r11;
        goto L15
    L9:
        r2 = r10;
        goto L11
    L5:
        r1 = r9;
        goto L7
    }

    public g(int r1, boolean r2, boolean r3, int r4, boolean r5, boolean r6, boolean r7) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
        this.g = r7;
    }
}
