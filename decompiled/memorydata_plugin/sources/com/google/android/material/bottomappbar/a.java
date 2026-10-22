package com.google.android.material.bottomappbar;

import com.google.android.material.shape.f;
import com.google.android.material.shape.n;

/* JADX INFO: loaded from: classes2.dex */
public class a extends f implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f3799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float f3800b;
    private float c;
    private float d;
    private float e;
    private float f;

    public a(float r2, float r3, float r4) {
        this.f = -1.0f;
        this.f3800b = r2;
        this.f3799a = r3;
        c(r4);
        this.e = 0.0f;
    }

    public float a() {
        return this.c;
    }

    public void a(float r1) {
        this.c = r1;
    }

    @Override // com.google.android.material.shape.f
    public void a(float r24, float r25, float r26, n r27) {
        float r2 = this.c;
        if (r2 != 0.0f) goto L6;
        r27.b(r24, 0.0f);
        return;
    L6:
        float r12 = ((this.f3800b * 2.0f) + r2) / 2.0f;
        float r13 = r26 * this.f3799a;
        float r14 = r25 + this.e;
        float r3 = (this.d * r26) + ((1.0f - r26) * r12);
        if ((r3 / r12) < 1.0f) goto L10;
        r27.b(r24, 0.0f);
        return;
    L10:
        float r4 = this.f;
        float r15 = r4 * r26;
        if (r4 != (-1.0f)) goto L13;
    L16:
        boolean r5 = true;
    L17:
        boolean r16 = r5;
        if (r16 == true) goto L20;
        float r6 = 1.75f;
        float r17 = 0.0f;
    L21:
        float r7 = r12 + r13;
        float r8 = r17 + r13;
        float r9 = (float) Math.sqrt((r7 * r7) - (r8 * r8));
        float r10 = r14 - r9;
        float r18 = r14 + r9;
        float r11 = (float) Math.toDegrees(Math.atan(r9 / r8));
        float r19 = (90.0f - r11) + r6;
        r27.b(r10, 0.0f);
        float r20 = r13 * 2.0f;
        r27.a(r10 - r13, 0.0f, r10 + r13, r20, 270.0f, r11);
        if (r16 == false) goto L24;
        float r21 = r14 - r12;
        float r22 = (-r12) - r17;
        float r23 = r14 + r12;
        float r28 = r12 - r17;
        float r29 = 180.0f - r19;
        float r30 = (r19 * 2.0f) - 180.0f;
    L25:
        r27.a(r21, r22, r23, r28, r29, r30);
        r27.a(r18 - r13, 0.0f, r18 + r13, r20, 270.0f - r11, r11);
        r27.b(r24, 0.0f);
        return;
    L24:
        float r31 = this.f3800b;
        float r110 = r15 * 2.0f;
        float r32 = r14 - r12;
        r27.a(r32, -(r15 + r31), r32 + (r31 + r110), r31 + r15, 180.0f - r19, ((r19 * 2.0f) - 180.0f) / 2.0f);
        r23 = r14 + r12;
        float r33 = this.f3800b;
        r27.b(r23 - ((r33 / 2.0f) + r15), r33 + r15);
        float r0 = this.f3800b;
        r21 = r23 - (r110 + r0);
        r22 = -(r15 + r0);
        r28 = r0 + r15;
        r29 = 90.0f;
        r30 = r19 - 90.0f;
        goto L25
    L20:
        r17 = r3;
        r6 = 0.0f;
        goto L21
    L13:
        if (Math.abs((r4 * 2.0f) - r2) < 0.1f) goto L16;
        r5 = false;
        goto L17
    }

    public float b() {
        return this.e;
    }

    void b(float r1) {
        this.e = r1;
    }

    float c() {
        return this.d;
    }

    void c(float r2) {
        if (r2 < 0.0f) goto L7;
        this.d = r2;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    float d() {
        return this.f3800b;
    }

    void d(float r1) {
        this.f3800b = r1;
    }

    float e() {
        return this.f3799a;
    }

    void e(float r1) {
        this.f3799a = r1;
    }

    public float f() {
        return this.f;
    }

    public void f(float r1) {
        this.f = r1;
    }
}
