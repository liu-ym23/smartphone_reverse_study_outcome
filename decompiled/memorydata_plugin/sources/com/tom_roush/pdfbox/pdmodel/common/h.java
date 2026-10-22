package com.tom_roush.pdfbox.pdmodel.common;

import android.graphics.Path;
import android.graphics.PointF;
import com.tom_roush.pdfbox.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes6.dex */
public class h implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f16189a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final h f16190b = null;
    public static final h c = null;
    public static final h d = null;
    public static final h e = null;
    public static final h f = null;
    public static final h g = null;
    public static final h h = null;
    public static final h i = null;
    private final com.tom_roush.pdfbox.a.a j;

    static {
        f16189a = new h(612.0f, 792.0f);
        f16190b = new h(612.0f, 1008.0f);
        c = new h(2383.937f, 3370.3938f);
        d = new h(1683.7795f, 2383.937f);
        e = new h(1190.5513f, 1683.7795f);
        f = new h(841.8898f, 1190.5513f);
        g = new h(595.27563f, 841.8898f);
        h = new h(419.52756f, 595.27563f);
        i = new h(297.63782f, 419.52756f);
    }

    public h() {
        this(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public h(float r2, float r3) {
        this(0.0f, 0.0f, r2, r3);
    }

    public h(float r2, float r3, float r4, float r5) {
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        this.j = r0;
        r0.a(new com.tom_roush.pdfbox.a.f(r2));
        r0.a(new com.tom_roush.pdfbox.a.f(r3));
        r0.a(new com.tom_roush.pdfbox.a.f(r2 + r4));
        r0.a(new com.tom_roush.pdfbox.a.f(r3 + r5));
    }

    public h(com.tom_roush.fontbox.g.a r3) {
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        this.j = r0;
        r0.a(new com.tom_roush.pdfbox.a.f(r3.a()));
        r0.a(new com.tom_roush.pdfbox.a.f(r3.b()));
        r0.a(new com.tom_roush.pdfbox.a.f(r3.c()));
        r0.a(new com.tom_roush.pdfbox.a.f(r3.d()));
    }

    public h(com.tom_roush.pdfbox.a.a r8) {
        float[] r9 = Arrays.copyOf(r8.c(), 4);
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        this.j = r0;
        r0.a(new com.tom_roush.pdfbox.a.f(Math.min(r9[0], r9[2])));
        r0.a(new com.tom_roush.pdfbox.a.f(Math.min(r9[1], r9[3])));
        r0.a(new com.tom_roush.pdfbox.a.f(Math.max(r9[0], r9[2])));
        r0.a(new com.tom_roush.pdfbox.a.f(Math.max(r9[1], r9[3])));
    }

    public Path a(com.tom_roush.pdfbox.util.c r5) {
        float r0 = b();
        float r1 = c();
        float r2 = d();
        float r4 = f();
        PointF r3 = r5.a(r0, r1);
        PointF r6 = r5.a(r2, r1);
        PointF r7 = r5.a(r2, r4);
        PointF r8 = r5.a(r0, r4);
        Path r9 = new Path();
        r9.moveTo(r3.x, r3.y);
        r9.lineTo(r6.x, r6.y);
        r9.lineTo(r7.x, r7.y);
        r9.lineTo(r8.x, r8.y);
        r9.close();
        return r9;
    }

    public com.tom_roush.pdfbox.a.a a() {
        return this.j;
    }

    public void a(float r2) {
        this.j.b(0, new com.tom_roush.pdfbox.a.f(r2));
    }

    public boolean a(float r4, float r5) {
        float r0 = b();
        float r1 = d();
        float r2 = c();
        float r3 = f();
        if (r4 >= r0) goto L5;
    L11:
        return false;
    L5:
        if (r4 > r1) goto L11;
        if (r5 < r2) goto L11;
        if (r5 > r3) goto L11;
        return true;
    }

    public float b() {
        return ((k) ZeusTransformUtils.preCheckCast(this.j.b(0), k.class, "com.obric.memorydata.plugin")).a();
    }

    public void b(float r2) {
        this.j.b(1, new com.tom_roush.pdfbox.a.f(r2));
    }

    public float c() {
        return ((k) ZeusTransformUtils.preCheckCast(this.j.b(1), k.class, "com.obric.memorydata.plugin")).a();
    }

    public void c(float r2) {
        this.j.b(2, new com.tom_roush.pdfbox.a.f(r2));
    }

    public float d() {
        return ((k) ZeusTransformUtils.preCheckCast(this.j.b(2), k.class, "com.obric.memorydata.plugin")).a();
    }

    public void d(float r2) {
        this.j.b(3, new com.tom_roush.pdfbox.a.f(r2));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return this.j;
    }

    public float f() {
        return ((k) ZeusTransformUtils.preCheckCast(this.j.b(3), k.class, "com.obric.memorydata.plugin")).a();
    }

    public float g() {
        return d() - b();
    }

    public float h() {
        return f() - c();
    }

    public Path i() {
        float r0 = b();
        float r1 = c();
        float r2 = d();
        float r4 = f();
        Path r3 = new Path();
        r3.moveTo(r0, r1);
        r3.lineTo(r2, r1);
        r3.lineTo(r2, r4);
        r3.lineTo(r0, r4);
        r3.close();
        return r3;
    }

    public String toString() {
        return "[" + b() + "," + c() + "," + d() + "," + f() + "]";
    }
}
