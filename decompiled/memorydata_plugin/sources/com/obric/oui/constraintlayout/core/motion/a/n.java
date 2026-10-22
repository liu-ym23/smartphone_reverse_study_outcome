package com.obric.oui.constraintlayout.core.motion.a;

/* JADX INFO: loaded from: classes5.dex */
public class n implements m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f13585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f13586b;
    private float c;
    private float d;
    private float e;
    private float f;
    private float g;
    private float h;
    private float i;
    private int j;
    private String k;
    private boolean l;
    private float m;
    private float n;
    private float o;
    private boolean p;

    public n() {
        this.l = false;
        this.p = false;
    }

    private void a(float r9, float r10, float r11, float r12, float r13) {
        this.p = false;
        this.i = r10;
        if (r9 != 0.0f) goto L5;
        r9 = 1.0E-4f;
    L5:
        float r1 = r9 / r11;
        float r2 = (r1 * r9) / 2.0f;
        if (r9 >= 0.0f) goto L14;
        float r14 = (float) Math.sqrt((r10 - ((((-r9) / r11) * r9) / 2.0f)) * r11);
        if (r14 >= r12) goto L11;
        this.k = "backward accelerate, decelerate";
        this.j = 2;
        this.f13585a = r9;
        this.f13586b = r14;
        this.c = 0.0f;
        float r15 = (r14 - r9) / r11;
        this.d = r15;
        this.e = r14 / r11;
        this.g = ((r9 + r14) * r15) / 2.0f;
        this.h = r10;
        this.i = r10;
        return;
    L11:
        this.k = "backward accelerate cruse decelerate";
        this.j = 3;
        this.f13585a = r9;
        this.f13586b = r12;
        this.c = r12;
        float r16 = (r12 - r9) / r11;
        this.d = r16;
        float r17 = r12 / r11;
        this.f = r17;
        float r18 = ((r9 + r12) * r16) / 2.0f;
        float r19 = (r17 * r12) / 2.0f;
        this.e = ((r10 - r18) - r19) / r12;
        this.g = r18;
        this.h = r10 - r19;
        this.i = r10;
        return;
    L14:
        if (r2 < r10) goto L17;
        this.k = "hard stop";
        this.j = 1;
        this.f13585a = r9;
        this.f13586b = 0.0f;
        this.g = r10;
        this.d = (2.0f * r10) / r9;
        return;
    L17:
        float r3 = r10 - r2;
        float r4 = r3 / r9;
        if ((r4 + r1) >= r13) goto L21;
        this.k = "cruse decelerate";
        this.j = 2;
        this.f13585a = r9;
        this.f13586b = r9;
        this.c = 0.0f;
        this.g = r3;
        this.h = r10;
        this.d = r4;
        this.e = r1;
        return;
    L21:
        float r110 = (float) Math.sqrt((r11 * r10) + ((r9 * r9) / 2.0f));
        float r5 = (r110 - r9) / r11;
        this.d = r5;
        float r6 = r110 / r11;
        this.e = r6;
        if (r110 >= r12) goto L25;
        this.k = "accelerate decelerate";
        this.j = 2;
        this.f13585a = r9;
        this.f13586b = r110;
        this.c = 0.0f;
        this.d = r5;
        this.e = r6;
        this.g = ((r9 + r110) * r5) / 2.0f;
        this.h = r10;
        return;
    L25:
        this.k = "accelerate cruse decelerate";
        this.j = 3;
        this.f13585a = r9;
        this.f13586b = r12;
        this.c = r12;
        float r111 = (r12 - r9) / r11;
        this.d = r111;
        float r112 = r12 / r11;
        this.f = r112;
        float r20 = ((r9 + r12) * r111) / 2.0f;
        float r113 = (r112 * r12) / 2.0f;
        this.e = ((r10 - r20) - r113) / r12;
        this.g = r20;
        this.h = r10 - r113;
        this.i = r10;
    }

    private float c(float r6) {
        this.p = false;
        float r0 = this.d;
        if (r6 > r0) goto L6;
        float r1 = this.f13585a;
        return (r1 * r6) + ((((this.f13586b - r1) * r6) * r6) / (r0 * 2.0f));
    L6:
        int r2 = this.j;
        if (r2 == 1) goto L9;
        float r7 = r6 - r0;
        float r3 = this.e;
        if (r7 >= r3) goto L15;
        float r4 = this.g;
        float r5 = this.f13586b;
        return (r4 + (r5 * r7)) + ((((this.c - r5) * r7) * r7) / (r3 * 2.0f));
    L15:
        if (r2 == 2) goto L17;
        float r8 = r7 - r3;
        float r9 = this.f;
        if (r8 > r9) goto L22;
        float r10 = this.h;
        float r11 = this.c;
        return (r10 + (r11 * r8)) - (((r11 * r8) * r8) / (r9 * 2.0f));
    L22:
        this.p = true;
        return this.i;
    L17:
        return this.h;
    L9:
        return this.g;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.m
    public float a() {
        if (this.l == false) goto L6;
        return -b(this.o);
    L6:
        return b(this.o);
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.m
    public float a(float r2) {
        float r0 = c(r2);
        this.n = r0;
        this.o = r2;
        boolean r3 = this.l;
        float r1 = this.m;
        if (r3 == false) goto L6;
        return r1 - r0;
    L6:
        return r1 + r0;
    }

    public void a(float r7, float r8, float r9, float r10, float r11, float r12) {
        boolean r2 = false;
        this.p = false;
        this.m = r7;
        if (r7 <= r8) goto L5;
        r2 = true;
    L5:
        this.l = r2;
        if (r2 == false) goto L8;
        float r3 = r7 - r8;
        float r1 = -r9;
    L9:
        a(r1, r3, r11, r12, r10);
        return;
    L8:
        r3 = r8 - r7;
        r1 = r9;
        goto L9
    }

    public float b(float r5) {
        float r0 = this.d;
        if (r5 > r0) goto L7;
        float r1 = this.f13585a;
        float r4 = this.f13586b;
    L6:
        return r1 + (((r4 - r1) * r5) / r0);
    L7:
        int r2 = this.j;
        if (r2 != 1) goto L10;
        return 0.0f;
    L10:
        r5 = r5 - r0;
        r0 = this.e;
        if (r5 >= r0) goto L14;
        r1 = this.f13586b;
        r4 = this.c;
        goto L6
    L14:
        if (r2 != 2) goto L16;
        return 0.0f;
    L16:
        float r6 = r5 - r0;
        float r3 = this.f;
        if (r6 >= r3) goto L20;
        float r7 = this.c;
        return r7 - ((r6 * r7) / r3);
    L20:
        return 0.0f;
    }

    @Override // com.obric.oui.constraintlayout.core.motion.a.m
    public boolean b() {
        if (a() < 1.0E-5f) goto L5;
    L7:
        return false;
    L5:
        if (Math.abs(this.i - this.n) >= 1.0E-5f) goto L7;
        return true;
    }
}
