package dr9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class d implements t1a.c {
    public final boolean a;

    public d() {
        this(false);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof d) == true) goto L9;
        return false;
    L9:
        if (this.a == ((d) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        return 1231;
    L5:
        return 1237;
    }

    public final String toString() {
        return "MediaInputHostPolicy(mobilePreviewEnabled=" + this.a + ')';
    }

    public d(boolean r1) {
        this.a = r1;
    }
}
