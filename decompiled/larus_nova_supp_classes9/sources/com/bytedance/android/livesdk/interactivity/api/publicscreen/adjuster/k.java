package com.bytedance.android.livesdk.interactivity.api.publicscreen.adjuster;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class k {
    public final int a;
    public final int b;
    public final int c;

    public k() {
        this(0, 0, 7);
    }

    public final String toString() {
        return "WidthInfo(width=" + this.a + ", leftMargin=" + this.b + ", rightMargin=" + this.c + ')';
    }

    public k(int r3, int r4, int r5) {
        if ((r5 & 1) == 0) goto L6;
        r3 = -10086;
    L6:
        if ((r5 & 2) == 0) goto L8;
        int r0 = -10086;
    L10:
        if ((r5 & 4) == 0) goto L12;
        r4 = -10086;
    L12:
        this.a = r3;
        this.b = r0;
        this.c = r4;
        return;
    L8:
        r0 = 0;
        goto L10
    }
}
