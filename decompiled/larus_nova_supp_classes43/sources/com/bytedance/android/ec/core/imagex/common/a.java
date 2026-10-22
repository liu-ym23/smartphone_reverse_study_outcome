package com.bytedance.android.ec.core.imagex.common;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a extends h {
    public char[] b;
    public int c;
    public int d;

    @Override // com.bytedance.android.ec.core.imagex.common.h
    public final void c() {
        this.c = 0;
        this.d = 0;
    }

    @Override // com.bytedance.android.ec.core.imagex.common.h
    public final boolean b() {
        if (this.d <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final String toString() {
        char[] r0 = this.b;
        int r1 = this.c;
        return new String(r0, r1, this.d - r1);
    }

    public a(int r1) {
        super(r1);
        this.b = new char[r1];
    }

    @Override // com.bytedance.android.ec.core.imagex.common.h
    public final void a(char r10) {
        int r0 = this.d;
        char[] r1 = this.b;
        if (r0 < r1.length) goto L5;
        char[] r11 = new char[r1.length + (this.a * 2)];
        System.arraycopy(r1, 0, r11, 0, r1.length);
        this.b = r11;
    L5:
        char[] r12 = this.b;
        int r13 = this.d;
        this.d = r13 + 1;
        r12[r13] = r10;
    }
}
