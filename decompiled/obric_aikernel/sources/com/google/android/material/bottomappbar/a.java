package com.google.android.material.bottomappbar;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import com.google.android.material.shape.f;
import com.google.android.material.shape.n;

/* JADX INFO: loaded from: classes.dex */
public class a extends f implements Cloneable {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private float f3039c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f3040g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private float f3041h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f3042i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f3043j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f3044k;

    public a(float r10, float r11, float r12) {
        this.f3044k = -1.0f;
        this.f3040g = r10;
        this.f3039c = r11;
        k(r12);
        this.f3043j = 0.0f;
    }

    @Override // com.google.android.material.shape.f
    public void d(float r24, float r25, float r26, @NonNull n r27) {
        float r10 = this.f3041h;
        if (r10 != 0.0f) goto L6;
        r27.m(r24, 0.0f);
        return;
    L6:
        float r12 = ((this.f3040g * 2.0f) + r10) / 2.0f;
        float r13 = r26 * this.f3039c;
        float r14 = r25 + this.f3043j;
        float r11 = (this.f3042i * r26) + ((1.0f - r26) * r12);
        if ((r11 / r12) < 1.0f) goto L10;
        r27.m(r24, 0.0f);
        return;
    L10:
        float r15 = this.f3044k;
        float r16 = r15 * r26;
        if (r15 != (-1.0f)) goto L13;
    L16:
        boolean r17 = true;
    L17:
        boolean r18 = r17;
        if (r18 == true) goto L20;
        float r19 = 1.75f;
        float r110 = 0.0f;
    L21:
        float r20 = r12 + r13;
        float r21 = r110 + r13;
        float r22 = (float) Math.sqrt((r20 * r20) - (r21 * r21));
        float r23 = r14 - r22;
        float r111 = r14 + r22;
        float r28 = (float) Math.toDegrees(Math.atan(r22 / r21));
        float r112 = (90.0f - r28) + r19;
        r27.m(r23, 0.0f);
        float r29 = r13 * 2.0f;
        r27.a(r23 - r13, 0.0f, r23 + r13, r29, 270.0f, r28);
        if (r18 == false) goto L24;
        float r30 = r14 - r12;
        float r31 = (-r12) - r110;
        float r32 = r14 + r12;
        float r33 = r12 - r110;
        float r34 = 180.0f - r112;
        float r35 = (r112 * 2.0f) - 180.0f;
    L25:
        r27.a(r30, r31, r32, r33, r34, r35);
        r27.a(r111 - r13, 0.0f, r111 + r13, r29, 270.0f - r28, r28);
        r27.m(r24, 0.0f);
        return;
    L24:
        float r36 = this.f3040g;
        float r113 = r16 * 2.0f;
        float r37 = r14 - r12;
        r27.a(r37, -(r16 + r36), r37 + (r36 + r113), r36 + r16, 180.0f - r112, ((r112 * 2.0f) - 180.0f) / 2.0f);
        r32 = r14 + r12;
        float r38 = this.f3040g;
        r27.m(r32 - ((r38 / 2.0f) + r16), r38 + r16);
        float r39 = this.f3040g;
        r30 = r32 - (r113 + r39);
        r31 = -(r16 + r39);
        r33 = r39 + r16;
        r34 = 90.0f;
        r35 = r112 - 90.0f;
        goto L25
    L20:
        r110 = r11;
        r19 = 0.0f;
        goto L21
    L13:
        if (Math.abs((r15 * 2.0f) - r10) < 0.1f) goto L16;
        r17 = false;
        goto L17
    }

    float e() {
        return this.f3042i;
    }

    public float f() {
        return this.f3044k;
    }

    float g() {
        return this.f3040g;
    }

    float h() {
        return this.f3039c;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float i() {
        return this.f3041h;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public float j() {
        return this.f3043j;
    }

    void k(@FloatRange(from = 0.0d) float r10) {
        if (r10 < 0.0f) goto L7;
        this.f3042i = r10;
        return;
    L7:
        throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
    }

    public void l(float r10) {
        this.f3044k = r10;
    }

    void m(float r10) {
        this.f3040g = r10;
    }

    void n(float r10) {
        this.f3039c = r10;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public void o(float r10) {
        this.f3041h = r10;
    }

    void p(float r10) {
        this.f3043j = r10;
    }
}
