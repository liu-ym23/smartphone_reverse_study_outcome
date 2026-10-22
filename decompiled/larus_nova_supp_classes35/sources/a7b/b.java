package a7b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b {
    public static final b b = null;
    public static final b c = null;
    public static final b d = null;
    public final int a;

    public static final class a {
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof b) == true) goto L9;
        return false;
    L9:
        if (this.a == ((b) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "DraftResourceSource(value=" + this.a + ')';
    }

    static {
        b = new b(0);
        c = new b(1);
        d = new b(2);
    }

    public b(int r1) {
        this.a = r1;
    }
}
