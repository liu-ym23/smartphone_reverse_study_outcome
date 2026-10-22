package wd;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final int a;
    public final int b;
    public final int c;
    public final int d;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof c) == false) goto L14;
        c r11 = (c) r10;
        if (this.a == r11.a) goto L8;
        return false;
    L8:
        if (this.b == r11.b) goto L10;
        return false;
    L10:
        if (this.c == r11.c) goto L12;
        return false;
    L12:
        if (this.d == r11.d) goto L22;
        return false;
    L22:
        return true;
    L14:
        return false;
    }

    public final int hashCode() {
        return (((((this.a * 31) + this.b) * 31) + this.c) * 31) + this.d;
    }

    public final String toString() {
        return "ECRect(left=" + this.a + ", top=" + this.b + ", width=" + this.c + ", height=" + this.d + ")";
    }

    public c(int r1, int r10, int r11, int r12) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
        this.d = r12;
    }
}
