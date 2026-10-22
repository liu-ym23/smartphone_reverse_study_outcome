package com.larus.camera.impl.ui.viewmodel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class n0 {
    public final int a;
    public final long b;

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof n0) == true) goto L8;
        return false;
    L8:
        n0 r9 = (n0) r8;
        if (this.a == r9.a) goto L12;
        return false;
    L12:
        if (this.b == r9.b) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        int r0 = this.a * 31;
        long r1 = this.b;
        return r0 + ((int) (r1 ^ (r1 >>> 32)));
    }

    public final String toString() {
        return "MutableIntState(state=" + this.a + ", version=" + this.b + ')';
    }

    public n0(int r1, long r2) {
        this.a = r1;
        this.b = r2;
    }
}
