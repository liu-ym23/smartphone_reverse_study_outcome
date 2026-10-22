package b30;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class s {
    public final boolean equals(Object r2) {
        if (this != r2) goto L4;
        return true;
    L4:
        if ((r2 instanceof s) == false) goto L6;
        ((s) r2).getClass();
        return true;
    L6:
        return false;
    }

    public final int hashCode() {
        return 0;
    }

    public final String toString() {
        return "OpenVerifyResultEvent(code=0)";
    }
}
