package com.bytedance.android.btm.impl.page.unknown;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a {
    public long a;
    public Boolean b;
    public final boolean c;

    public final boolean equals(Object r10) {
        if (this != r10) goto L4;
        return true;
    L4:
        if ((r10 instanceof a) == true) goto L6;
        return false;
    L6:
        if (this.c == ((a) r10).c) goto L13;
        return false;
    L13:
        return true;
    }

    public final int hashCode() {
        boolean r0 = this.c;
        if (r0 == false) goto L6;
        return 1;
    L6:
        return r0 ? 1 : 0;
    }

    public final String toString() {
        return "DialogFragModel(isHybridContainer=" + this.c + ")";
    }

    public a() {
        this.c = true;
    }
}
