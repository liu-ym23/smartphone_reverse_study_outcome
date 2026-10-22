package pi8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class q extends j {
    public final boolean a;
    public final int b;
    public final int c;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof q) == true) goto L8;
        return false;
    L8:
        q r6 = (q) r5;
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
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.b) * 31) + this.c;
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "SearchTinyAdapterCreateParam(useSearchDetailBox=" + this.a + ", indicator=" + this.b + ", abVersion=" + this.c + ')';
    }

    public q(boolean r1, int r2, int r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
