package o8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;

    public d() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof d) == true) goto L8;
        return false;
    L8:
        d r11 = (d) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L15;
        return false;
    L15:
        if (this.c == r11.c) goto L18;
        return false;
    L18:
        if (this.d == r11.d) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == false) goto L9;
        int r11 = 1231;
    L10:
        int r12 = (r10 + r11) * 31;
        if (this.c == false) goto L13;
        int r13 = 1231;
    L14:
        int r14 = (r12 + r13) * 31;
        if (this.d == true) goto L19;
        r1 = 1237;
    L19:
        return r14 + r1;
    L13:
        r13 = 1237;
        goto L14
    L9:
        r11 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlavorConfig(isDouyin=" + this.a + ", isXT=" + this.b + ", isDylite=" + this.c + ", isHotsoon=" + this.d + ')';
    }

    public d(int r1) {
        this.a = false;
        this.b = false;
        this.c = false;
        this.d = false;
    }
}
