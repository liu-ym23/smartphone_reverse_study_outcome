package com.obric.oui.shadow;

import android.content.res.TypedArray;
import com.obric.oui.graphic.BlendMode;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f14458a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f14459b;
    private float c;
    private int d;
    private float e;
    private int f;

    public b(float r8, float r9, float r10, int r11, float r12) {
        this(r8, r9, r10, r11, r12, -1);
    }

    public b(float r1, float r2, float r3, int r4, float r5, int r6) {
        this.f14458a = r1;
        this.f14459b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    public static b a(TypedArray r4, int r5, int r6, int r7, int r8, int r9) {
        return new b(r4.getDimension(r7, 0.0f), r4.getDimension(r8, 0.0f), r4.getDimension(r6, 0.0f), r4.getColor(r5, 0), r4.getDimension(r9, 0.0f));
    }

    public static b a(b r8) {
        if (r8 != null) goto L6;
        return null;
    L6:
        return new b(r8.f14458a, r8.f14459b, r8.c, r8.d, r8.e, r8.f);
    }

    public static b[] a(b[] r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        b[] r0 = new b[r3.length];
        int r1 = 0;
    L7:
        if (r1 >= r3.length) goto L9;
        r0[r1] = a(r3[r1]);
        r1 = r1 + 1;
        goto L7
    L9:
        return r0;
    }

    public static int[] b(b r3) {
        if (r3.f != (-1)) goto L6;
        r3.f = BlendMode.SRC_OVER.getPorterDuffMode();
    L6:
        return new int[]{r3.d, r3.f};
    }

    public float a() {
        return this.f14458a;
    }

    public float b() {
        return this.f14459b;
    }

    public float c() {
        return this.c;
    }

    public int d() {
        return this.d;
    }

    public float e() {
        return this.e;
    }

    public int f() {
        return this.f;
    }
}
