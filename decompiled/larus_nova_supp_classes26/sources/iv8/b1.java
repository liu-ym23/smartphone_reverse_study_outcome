package iv8;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class b1 {
    public final boolean a;
    public final int b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof b1) == true) goto L8;
        return false;
    L8:
        b1 r6 = (b1) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (this.b == r6.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + this.b;
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "RemoteInputEnqueueResult(accepted=" + this.a + ", addedUnits=" + this.b + ')';
    }

    public b1(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
