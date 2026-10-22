package com.ss.android.lark.feed.shared.page.binder2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final int h;

    public a(int r3, int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        if ((r11 & 1) == 0) goto L6;
        r3 = -1;
    L6:
        if ((r11 & 2) == 0) goto L9;
        r4 = -1;
    L9:
        if ((r11 & 4) == 0) goto L12;
        r5 = -1;
    L12:
        if ((r11 & 8) == 0) goto L15;
        r6 = -1;
    L15:
        if ((r11 & 16) == 0) goto L18;
        r7 = 0;
    L18:
        if ((r11 & 32) == 0) goto L21;
        r8 = 0;
    L21:
        if ((r11 & 64) == 0) goto L24;
        r9 = 0;
    L24:
        if ((r11 & 128) == 0) goto L26;
        r10 = 0;
    L26:
        this.a = r3;
        this.b = r4;
        this.c = r5;
        this.d = r6;
        this.e = r7;
        this.f = r8;
        this.g = r9;
        this.h = r10;
    }
}
