package com.bytedance.android.ec.core.utils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class l {
    public char[] a;
    public int b;

    public final String toString() {
        return new String(this.a, 0, this.b);
    }

    public l(int r10) {
        if (r10 < 0) goto L7;
        this.a = new char[r10];
        return;
    L7:
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    public final void a(String r10) {
        if (r10 != null) goto L4;
        r10 = "null";
    L4:
        int r0 = r10.length();
        int r1 = this.b + r0;
        char[] r11 = this.a;
        if (r1 <= r11.length) goto L7;
        char[] r12 = new char[Math.max(r11.length << 1, r1)];
        System.arraycopy(this.a, 0, r12, 0, this.b);
        this.a = r12;
    L7:
        r10.getChars(0, r0, this.a, this.b);
        this.b = r1;
    }
}
