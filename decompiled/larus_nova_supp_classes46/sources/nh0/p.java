package nh0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class p {
    public final int a;
    public final int b;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof p) == false) goto L10;
        p r4 = (p) r3;
        if (this.a == r4.a) goto L8;
        return false;
    L8:
        if (this.b == r4.b) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        return (this.a * 31) + this.b;
    }

    public final String toString() {
        return "StateBeforeUpdateConfig(scene=" + this.a + ", uiLayout=" + this.b + ")";
    }

    public p(int r1, int r2) {
        this.a = r1;
        this.b = r2;
    }
}
