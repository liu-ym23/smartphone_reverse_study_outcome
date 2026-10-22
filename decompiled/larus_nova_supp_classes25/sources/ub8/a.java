package ub8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class a {
    public final boolean a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof a) == true) goto L9;
        return false;
    L9:
        if (this.a == ((a) r4).a) goto L11;
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
        return "BooleanResult(success=" + this.a + ')';
    }

    public a(boolean r1) {
        this.a = r1;
    }
}
