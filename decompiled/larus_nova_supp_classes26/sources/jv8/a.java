package jv8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof a) == true) goto L8;
        return false;
    L8:
        a r6 = (a) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L15;
        return false;
    L15:
        if (this.c == r6.c) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.a * 31) + this.b) * 31) + this.c;
    }

    public final String toString() {
        return "BrowserScreencastParameters(maxWidth=" + this.a + ", maxHeight=" + this.b + ", quality=" + this.c + ')';
    }

    public a(int r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
