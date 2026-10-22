package d49;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class c$d implements c {
    public static final c$d a = null;

    static {
        a = new c$d();
    }

    public c$d() {
    }

    public final boolean equals(Object r3) {
        if (this != r3) goto L6;
        return true;
    L6:
        if ((r3 instanceof c$d) == true) goto L9;
        return false;
    L9:
        c$d r4 = (c$d) r3;
        return true;
    }

    public final int hashCode() {
        return 200501981;
    }

    public final String toString() {
        return "Loading";
    }
}
