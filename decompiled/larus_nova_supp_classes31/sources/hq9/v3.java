package hq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class v3 {
    public final int a;

    public v3() {
        this(2);
    }

    public final boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if ((r4 instanceof v3) == true) goto L9;
        return false;
    L9:
        if (this.a == ((v3) r4).a) goto L11;
        return false;
    L11:
        return true;
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "ProgressLoadingStyleData(loadingStyle=" + this.a + ')';
    }

    public v3(int r1) {
        this.a = r1;
    }
}
