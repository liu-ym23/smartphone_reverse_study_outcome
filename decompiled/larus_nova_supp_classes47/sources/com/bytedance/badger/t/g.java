package com.bytedance.badger.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g extends l {
    public final int a;

    public final boolean equals(Object r4) {
        if (this != r4) goto L5;
    L13:
        return true;
    L5:
        if ((r4 instanceof g) == true) goto L7;
    L12:
        return false;
    L7:
        if (this.a != ((g) r4).a) goto L9;
        boolean r5 = true;
    L10:
        if (r5 == false) goto L12;
    L9:
        r5 = false;
        goto L10
    }

    public final int hashCode() {
        return this.a;
    }

    public final String toString() {
        return "IntVal(value=" + this.a + ")";
    }

    public g(int r1) {
        this.a = r1;
    }
}
