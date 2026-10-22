package hq9;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class m3 {
    public final boolean a;
    public final int b;

    public m3() {
        this(0);
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof m3) == true) goto L8;
        return false;
    L8:
        m3 r6 = (m3) r5;
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
        return "NetworkAutoSwitchConfig(enable=" + this.a + ", dialogInterval=" + this.b + ')';
    }

    public /* synthetic */ m3(int r2) {
        this(false, 24);
    }

    public m3(boolean r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
