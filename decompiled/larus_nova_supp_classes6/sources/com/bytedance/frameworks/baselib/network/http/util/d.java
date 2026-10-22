package com.bytedance.frameworks.baselib.network.http.util;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class d {
    public char[] a;
    public int b;

    public final String toString() {
        return new String(this.a, 0, this.b);
    }

    public d(int r2) {
        if (r2 < 0) goto L7;
        this.a = new char[r2];
        return;
    L7:
        throw new IllegalArgumentException("Buffer capacity may not be negative");
    }

    public final void a(String r7) {
        if (r7 != null) goto L4;
        r7 = "null";
    L4:
        int r0 = r7.length();
        int r1 = this.b + r0;
        char[] r2 = this.a;
        if (r1 <= r2.length) goto L7;
        char[] r3 = new char[Math.max(r2.length << 1, r1)];
        System.arraycopy(this.a, 0, r3, 0, this.b);
        this.a = r3;
    L7:
        r7.getChars(0, r0, this.a, this.b);
        this.b = r1;
    }
}
