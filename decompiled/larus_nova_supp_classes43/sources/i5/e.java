package i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    public final int a;

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof e) == true) goto L9;
        return false;
    L9:
        if (this.a == ((e) r10).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "ProgressChanged(newProgress=" + this.a + ')';
    }

    public e(int r1) {
        this.a = r1;
    }
}
