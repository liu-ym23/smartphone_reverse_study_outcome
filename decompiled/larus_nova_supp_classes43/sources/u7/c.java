package u7;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public final boolean a;
    public final boolean b;

    public c() {
        this(0);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof c) == true) goto L8;
        return false;
    L8:
        c r11 = (c) r10;
        if (this.a == r11.a) goto L12;
        return false;
    L12:
        if (this.b == r11.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.a == false) goto L5;
        int r0 = 1231;
    L6:
        int r10 = r0 * 31;
        if (this.b == true) goto L11;
        r1 = 1237;
    L11:
        return r10 + r1;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "FlavorModel(isLynx=" + this.a + ", isDouyin=" + this.b + ')';
    }

    public /* synthetic */ c(int r10) {
        this(false, true);
    }

    public c(boolean r1, boolean r10) {
        this.a = r1;
        this.b = r10;
    }
}
