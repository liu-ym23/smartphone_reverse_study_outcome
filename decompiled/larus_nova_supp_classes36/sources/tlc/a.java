package tlc;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a {
    public final int a;

    /* JADX INFO: renamed from: tlc.a$a, reason: collision with other inner class name */
    public static final class C0330a {
    }

    static {
    }

    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.a == ((a) r2).a) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "HistoryMessageFetchParams(fetchMessageCount=" + this.a + ")";
    }

    public a(int r1) {
        this.a = r1;
    }
}
