package com.bytedance.android.livesdk.feed;

import android.text.TextUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class b1 {
    public boolean a;
    public String b;
    public int c;
    public int d;

    public final int hashCode() {
        int r4 = 1;
        Object[] r1 = {Boolean.valueOf(this.a), this.b, Integer.valueOf(this.c), Integer.valueOf(this.d)};
        int r2 = 0;
    L3:
        if (r2 >= 4) goto L9;
        Object r5 = r1[r2];
        int r6 = r4 * 31;
        if (r5 != null) goto L7;
        int r7 = 0;
    L8:
        r4 = r6 + r7;
        r2 = r2 + 1;
        goto L3
    L7:
        r7 = r5.hashCode();
        goto L8
    L9:
        return r4;
    }

    public b1() {
        this.a = false;
    }

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if (r5 != null) goto L8;
    L21:
        return false;
    L8:
        if (b1.class != r5.getClass()) goto L21;
        b1 r6 = (b1) r5;
        if (this.a == r6.a) goto L13;
    L19:
        return false;
    L13:
        if (this.c != r6.c) goto L19;
        if (this.d != r6.d) goto L19;
        if (TextUtils.equals(this.b, r6.b) == false) goto L19;
        return true;
    }
}
