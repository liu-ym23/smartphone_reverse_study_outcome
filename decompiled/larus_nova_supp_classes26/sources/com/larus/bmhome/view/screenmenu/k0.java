package com.larus.bmhome.view.screenmenu;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class k0 {
    public final boolean a;
    public final float b;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof k0) == true) goto L8;
        return false;
    L8:
        k0 r6 = (k0) r5;
        if (this.a == r6.a) goto L12;
        return false;
    L12:
        if (Float.compare(this.b, r6.b) == 0) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        if (this.a == false) goto L5;
        int r0 = 1231;
    L7:
        return (r0 * 31) + Float.floatToIntBits(this.b);
    L5:
        r0 = 1237;
        goto L7
    }

    public final String toString() {
        return "MenuExtra(isEnabled=" + this.a + ", alpha=" + this.b + ')';
    }

    public k0() {
        this(true, 1.0f);
    }

    public k0(boolean r1, float r2) {
        this.a = r1;
        this.b = r2;
    }
}
