package com.lynx.tasm.behavior.ui.utils;

import com.lynx.react.bridge.ReadableArray;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class j {
    public final int a;
    public final float b;
    public final ReadableArray c;

    public final float a() {
        if (this.a == 0) goto L7;
        return 0.0f;
    L7:
        return this.b;
    }

    public j() {
        this.b = 0.0f;
        this.a = 0;
    }

    public final float b(float r4) {
        return c(this.c, this.b, this.a, r4);
    }

    public final boolean equals(Object r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        j r5 = (j) r4;
        int r1 = this.a;
        if (r1 == r5.a) goto L9;
        return false;
    L9:
        if (r1 == 2) goto L13;
        return com.lynx.tasm.utils.b.a(this.b, r5.b);
    L13:
        return this.c.asArrayList().equals(r5.c.asArrayList());
    }

    public j(f6a.a r3, int r4) {
        if (r4 != 2) goto L5;
        this.c = r3.asArray();
    L9:
        this.a = r4;
        return;
    L5:
        if (r4 != 0) goto L7;
    L8:
        this.b = (float) r3.asDouble();
        goto L9
    L7:
        if (r4 != 1) goto L9;
        goto L8
    }

    public static float c(ReadableArray r7, float r8, int r9, float r10) {
        if (r9 == 1) goto L5;
        if (r9 != 0) goto L9;
        return r8;
    L9:
        if (r9 != 2) goto L23;
        int r11 = 0;
        float r2 = 0.0f;
    L12:
        if (r11 >= r7.size()) goto L22;
        int r3 = r7.getInt(r11 + 1);
        if (r3 != 2) goto L17;
        ReadableArray r4 = r7.getArray(r11);
    L16:
        float r5 = 0.0f;
    L21:
        r2 = r2 + c(r4, r5, r3, r10);
        r11 = r11 + 2;
        goto L12
    L17:
        r4 = null;
        if (r3 == 0) goto L20;
        if (r3 != 1) goto L16;
    L20:
        r5 = (float) r7.getDouble(r11);
        goto L21
    L22:
        return r2;
    L23:
        return 0.0f;
    L5:
        return r8 * r10;
    }
}
