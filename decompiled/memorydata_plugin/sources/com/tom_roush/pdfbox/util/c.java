package com.tom_roush.pdfbox.util;

import android.graphics.PointF;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.tom_roush.pdfbox.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public final class c implements Cloneable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f16299a;

    public c() {
        this.f16299a = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    public c(float r2, float r3, float r4, float r5, float r6, float r7) {
        this.f16299a = new float[]{r2, r3, 0.0f, r4, r5, 0.0f, r6, r7, 1.0f};
    }

    public c(com.tom_roush.pdfbox.a.a r6) {
        float[] r0 = new float[9];
        this.f16299a = r0;
        r0[0] = ((k) ZeusTransformUtils.preCheckCast(r6.a(0), k.class, "com.obric.memorydata.plugin")).a();
        this.f16299a[1] = ((k) ZeusTransformUtils.preCheckCast(r6.a(1), k.class, "com.obric.memorydata.plugin")).a();
        this.f16299a[3] = ((k) ZeusTransformUtils.preCheckCast(r6.a(2), k.class, "com.obric.memorydata.plugin")).a();
        this.f16299a[4] = ((k) ZeusTransformUtils.preCheckCast(r6.a(3), k.class, "com.obric.memorydata.plugin")).a();
        this.f16299a[6] = ((k) ZeusTransformUtils.preCheckCast(r6.a(4), k.class, "com.obric.memorydata.plugin")).a();
        this.f16299a[7] = ((k) ZeusTransformUtils.preCheckCast(r6.a(5), k.class, "com.obric.memorydata.plugin")).a();
        this.f16299a[8] = 1.0f;
    }

    private c(float[] r1) {
        this.f16299a = r1;
    }

    public static c a(com.tom_roush.pdfbox.a.b r4) {
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.a.class) == false) goto L5;
        com.tom_roush.pdfbox.a.a r5 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r5.b() < 6) goto L9;
        int r0 = 0;
    L11:
        if (r0 >= 6) goto L18;
        if (ZeusTransformUtils.instanceOf(r5.a(r0), k.class) == false) goto L15;
        r0 = r0 + 1;
        goto L11
    L15:
        return new c();
    L18:
        return new c(r5);
    L9:
        return new c();
    L5:
        return new c();
    }

    private void a(float[] r12, float[] r13, float[] r14) {
        r14[0] = ((r12[0] * r13[0]) + (r12[1] * r13[3])) + (r12[2] * r13[6]);
        r14[1] = ((r12[0] * r13[1]) + (r12[1] * r13[4])) + (r12[2] * r13[7]);
        r14[2] = ((r12[0] * r13[2]) + (r12[1] * r13[5])) + (r12[2] * r13[8]);
        r14[3] = ((r12[3] * r13[0]) + (r12[4] * r13[3])) + (r12[5] * r13[6]);
        r14[4] = ((r12[3] * r13[1]) + (r12[4] * r13[4])) + (r12[5] * r13[7]);
        r14[5] = ((r12[3] * r13[2]) + (r12[4] * r13[5])) + (r12[5] * r13[8]);
        r14[6] = ((r12[6] * r13[0]) + (r12[7] * r13[3])) + (r12[8] * r13[6]);
        r14[7] = ((r12[6] * r13[1]) + (r12[7] * r13[4])) + (r12[8] * r13[7]);
        r14[8] = ((r12[6] * r13[2]) + (r12[7] * r13[5])) + (r12[8] * r13[8]);
    }

    private static boolean a(float r1) {
        if (Math.abs(r1) > Float.MAX_VALUE) goto L5;
        return true;
    L5:
        return false;
    }

    public static c b(float r8, float r9) {
        return new c(1.0f, 0.0f, 0.0f, 1.0f, r8, r9);
    }

    public static c b(c r0, c r1) {
        return r1.b(r0);
    }

    public PointF a(float r7, float r8) {
        float[] r6 = this.f16299a;
        float r0 = r6[0];
        float r1 = r6[1];
        float r2 = r6[3];
        float r3 = r6[4];
        float r4 = r6[6];
        float r5 = ((r0 * r7) + (r2 * r8)) + r4;
        float r9 = (r7 * r1) + (r8 * r3);
        return new PointF(r5, r9 + r6[7]);
    }

    public AffineTransform a() {
        float[] r8 = this.f16299a;
        return new AffineTransform(r8[0], r8[1], r8[3], r8[4], r8[6], r8[7]);
    }

    @Deprecated
    public c a(c r3, c r4) {
        if (r4 == null) goto L6;
        if (r4 == r3) goto L6;
        if (r4 == this) goto L6;
        float[] r0 = r4.f16299a;
    L7:
        a(this.f16299a, r3.f16299a, r0);
        if (a(r0[0]) == false) goto L31;
        if (a(r0[1]) == false) goto L31;
        if (a(r0[2]) == false) goto L31;
        if (a(r0[3]) == false) goto L31;
        if (a(r0[4]) == false) goto L31;
        if (a(r0[5]) == false) goto L31;
        if (a(r0[6]) == false) goto L31;
        if (a(r0[7]) == false) goto L31;
        if (a(r0[8]) == false) goto L31;
        if (r4 == null) goto L27;
        r4.f16299a = r0;
        return r4;
    L27:
        return new c(r0);
    L31:
        throw new IllegalArgumentException("Multiplying two matrices produces illegal values");
    L6:
        r0 = new float[9];
        goto L7
    }

    public void a(c r1) {
        r1.a(this, this);
    }

    public void a(e r2) {
        a(b(r2.a(), r2.b()));
    }

    public c b() {
        return new c((float[]) ZeusTransformUtils.preCheckCast(this.f16299a.clone(), float[].class, "com.obric.memorydata.plugin"));
    }

    public c b(c r2) {
        return a(r2, new c());
    }

    public e b(e r8) {
        float[] r7 = this.f16299a;
        float r0 = r7[0];
        float r1 = r7[1];
        float r2 = r7[3];
        float r3 = r7[4];
        float r4 = r7[6];
        float r9 = r7[7];
        float r5 = r8.a();
        float r10 = r8.b();
        return new e(((r0 * r5) + (r2 * r10)) + r4, ((r5 * r1) + (r10 * r3)) + r9);
    }

    public float c() {
        float[] r0 = this.f16299a;
        if (r0[1] == 0.0f) goto L7;
        return (float) Math.sqrt(Math.pow(r0[0], 2.0d) + Math.pow(this.f16299a[1], 2.0d));
    L7:
        return r0[0];
    }

    public /* synthetic */ Object clone() {
        return b();
    }

    public float d() {
        float[] r0 = this.f16299a;
        if (r0[3] == 0.0f) goto L7;
        return (float) Math.sqrt(Math.pow(r0[3], 2.0d) + Math.pow(this.f16299a[4], 2.0d));
    L7:
        return r0[4];
    }

    public float e() {
        return this.f16299a[0];
    }

    public boolean equals(Object r4) {
        if (this != r4) goto L6;
        return true;
    L6:
        if (r4 != null) goto L9;
        return false;
    L9:
        if (getClass() == r4.getClass()) goto L12;
        return false;
    L12:
        return Arrays.equals(this.f16299a, ((c) ZeusTransformUtils.preCheckCast(r4, c.class, "com.obric.memorydata.plugin")).f16299a);
    }

    public float f() {
        return this.f16299a[1];
    }

    public float g() {
        return this.f16299a[3];
    }

    public float h() {
        return this.f16299a[4];
    }

    public int hashCode() {
        return Arrays.hashCode(this.f16299a);
    }

    public float i() {
        return this.f16299a[6];
    }

    public float j() {
        return this.f16299a[7];
    }

    public String toString() {
        return "[" + this.f16299a[0] + "," + this.f16299a[1] + "," + this.f16299a[3] + "," + this.f16299a[4] + "," + this.f16299a[6] + "," + this.f16299a[7] + "]";
    }
}
