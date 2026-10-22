package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public abstract class l implements com.tom_roush.pdfbox.pdmodel.common.c, s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final y f16243a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final com.tom_roush.pdfbox.a.d f16244b;
    private Map<Integer, Float> c;
    private float d;
    private float e;
    private final Map<Integer, Float> f;
    private final Map<Integer, com.tom_roush.pdfbox.util.e> g;
    private float[] h;
    private q i;

    l(com.tom_roush.pdfbox.a.d r2, y r3) {
        this.f = new HashMap();
        this.g = new HashMap();
        this.h = new float[]{880.0f, -1000.0f};
        this.f16244b = r2;
        this.f16243a = r3;
        l();
        m();
    }

    private com.tom_roush.pdfbox.util.e f(int r3) {
        return new com.tom_roush.pdfbox.util.e(h(r3) / 2.0f, this.h[0]);
    }

    private float h(int r3) {
        Float r4 = (Float) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r3)), Float.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L6;
        r4 = Float.valueOf(n());
    L6:
        return r4.floatValue();
    }

    private void l() {
        this.c = new HashMap();
        com.tom_roush.pdfbox.a.b r0 = this.f16244b.a(com.tom_roush.pdfbox.a.i.iY);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L32;
        com.tom_roush.pdfbox.a.a r1 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        int r2 = r1.b();
        int r4 = 0;
    L6:
        if (r4 >= (r2 - 1)) goto L48;
        int r5 = r4 + 1;
        com.tom_roush.pdfbox.a.b r6 = r1.a(r4);
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.k.class) == false) goto L9;
        com.tom_roush.pdfbox.a.k r7 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        int r8 = r5 + 1;
        com.tom_roush.pdfbox.a.b r9 = r1.a(r5);
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.a.a.class) == true) goto L12;
        if (r8 >= r2) goto L21;
        int r10 = r8 + 1;
        com.tom_roush.pdfbox.a.b r11 = r1.a(r8);
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.a.k.class) == true) goto L25;
    L30:
        Log.w("PdfBox-Android", "Expected two numbers, got " + r9 + " and " + r11);
    L31:
        r4 = r10;
        goto L6
    L25:
        if (ZeusTransformUtils.instanceOf(r11, com.tom_roush.pdfbox.a.k.class) == false) goto L30;
        com.tom_roush.pdfbox.a.k r12 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.k r13 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r11, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        int r14 = r7.c();
        int r15 = r12.c();
        float r16 = r13.a();
    L28:
        if (r14 > r15) goto L31;
        this.c.put(Integer.valueOf(r14), Float.valueOf(r16));
        r14 = r14 + 1;
        goto L28
    L21:
        Log.w("PdfBox-Android", "premature end of widths array");
        return;
    L12:
        com.tom_roush.pdfbox.a.a r17 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        int r18 = r7.c();
        int r19 = r17.b();
        int r110 = 0;
    L13:
        if (r110 >= r19) goto L19;
        com.tom_roush.pdfbox.a.b r111 = r17.a(r110);
        if (ZeusTransformUtils.instanceOf(r111, com.tom_roush.pdfbox.a.k.class) == false) goto L17;
        this.c.put(Integer.valueOf(r18 + r110), Float.valueOf(((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r111, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a()));
    L18:
        r110 = r110 + 1;
        goto L13
    L17:
        Log.w("PdfBox-Android", "Expected a number array member, got " + r111);
        goto L18
    L19:
        r4 = r8;
        goto L6
    L9:
        Log.w("PdfBox-Android", "Expected a number array member, got " + r6);
        r4 = r5;
        goto L6
    L48:
        return;
    }

    private void m() {
        com.tom_roush.pdfbox.a.b r0 = this.f16244b.a(com.tom_roush.pdfbox.a.i.cp);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L9;
        com.tom_roush.pdfbox.a.a r1 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.a.b r2 = r1.a(0);
        com.tom_roush.pdfbox.a.b r3 = r1.a(1);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.k.class) == false) goto L9;
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.k.class) == false) goto L9;
        this.h[0] = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a();
        this.h[1] = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a();
    L9:
        com.tom_roush.pdfbox.a.b r4 = this.f16244b.a(com.tom_roush.pdfbox.a.i.iZ);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.a.class) == false) goto L24;
        com.tom_roush.pdfbox.a.a r5 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        int r6 = 0;
    L13:
        if (r6 >= r5.b()) goto L28;
        com.tom_roush.pdfbox.a.k r7 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r5.a(r6), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        int r8 = r6 + 1;
        com.tom_roush.pdfbox.a.b r9 = r5.a(r8);
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.a.a.class) == false) goto L20;
        com.tom_roush.pdfbox.a.a r10 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        int r11 = 0;
    L18:
        if (r11 >= r10.b()) goto L23;
        int r12 = r7.c() + (r11 / 3);
        com.tom_roush.pdfbox.a.k r13 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r10.a(r11), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        int r14 = r11 + 1;
        com.tom_roush.pdfbox.a.k r15 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r10.a(r14), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        int r16 = r14 + 1;
        com.tom_roush.pdfbox.a.k r17 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r10.a(r16), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        this.f.put(Integer.valueOf(r12), Float.valueOf(r13.a()));
        this.g.put(Integer.valueOf(r12), new com.tom_roush.pdfbox.util.e(r15.a(), r17.a()));
        r11 = r16 + 1;
    L23:
        r6 = r8 + 1;
        goto L13
    L20:
        int r18 = r7.c();
        int r19 = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).c();
        int r20 = r8 + 1;
        com.tom_roush.pdfbox.a.k r21 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r5.a(r20), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        int r22 = r20 + 1;
        com.tom_roush.pdfbox.a.k r23 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r5.a(r22), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
        r8 = r22 + 1;
        com.tom_roush.pdfbox.a.k r24 = (com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r5.a(r8), com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin");
    L21:
        if (r18 > r19) goto L23;
        this.f.put(Integer.valueOf(r18), Float.valueOf(r21.a()));
        this.g.put(Integer.valueOf(r18), new com.tom_roush.pdfbox.util.e(r23.a(), r24.a()));
        r18 = r18 + 1;
        goto L21
    L28:
        return;
    }

    private float n() {
        if (this.d != 0.0f) goto L10;
        com.tom_roush.pdfbox.a.b r0 = this.f16244b.a(com.tom_roush.pdfbox.a.i.co);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.k.class) == false) goto L7;
        float r1 = ((com.tom_roush.pdfbox.a.k) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.k.class, "com.obric.memorydata.plugin")).a();
    L8:
        this.d = r1;
        goto L10
    L7:
        r1 = 1000.0f;
    L10:
        return this.d;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16244b;
    }

    public com.tom_roush.pdfbox.util.e a(int r4) {
        int r5 = d(r4);
        com.tom_roush.pdfbox.util.e r0 = (com.tom_roush.pdfbox.util.e) ZeusTransformUtils.preCheckCast(this.g.get(Integer.valueOf(r5)), com.tom_roush.pdfbox.util.e.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L5;
        return r0;
    L5:
        return f(r5);
    }

    public float b(int r3) {
        int r4 = d(r3);
        Float r5 = (Float) ZeusTransformUtils.preCheckCast(this.f.get(Integer.valueOf(r4)), Float.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        r5 = Float.valueOf(this.h[1]);
    L6:
        return r5.floatValue();
    }

    public String b() {
        return this.f16244b.g(com.tom_roush.pdfbox.a.i.Q);
    }

    public float c(int r1) {
        return h(d(r1));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public String c() {
        return b();
    }

    public abstract int d(int r1);

    public q d() {
        if (this.i != null) goto L8;
        com.tom_roush.pdfbox.a.d r0 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(this.f16244b.a(com.tom_roush.pdfbox.a.i.de), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        if (r0 == null) goto L8;
        this.i = new q(r0);
    L8:
        return this.i;
    }

    public abstract int e(int r1);

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public float f() {
        if (this.e != 0.0f) goto L21;
        int r0 = 0;
        Map<Integer, Float> r2 = this.c;
        if (r2 == null) goto L12;
        Iterator<Float> r3 = r2.values().iterator();
        float r4 = 0.0f;
    L8:
        if (r3.hasNext() == false) goto L13;
        Float r5 = (Float) ZeusTransformUtils.preCheckCast(r3.next(), Float.class, "com.obric.memorydata.plugin");
        if (r5.floatValue() <= 0.0f) goto L8;
        r4 = r4 + r5.floatValue();
        r0 = r0 + 1;
    L13:
        if (r0 == 0) goto L15;
        this.e = r4 / r0;
    L15:
        float r1 = this.e;
        if (r1 > 0.0f) goto L18;
    L19:
        this.e = n();
        goto L21
    L18:
        if (Float.isNaN(r1) == false) goto L21;
    L12:
        r4 = 0.0f;
    L21:
        return this.e;
    }

    public o g() {
        com.tom_roush.pdfbox.a.b r3 = this.f16244b.a(com.tom_roush.pdfbox.a.i.aK);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.d.class) == true) goto L5;
        return null;
    L5:
        return new o((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }

    final int[] h() {
        com.tom_roush.pdfbox.a.b r6 = this.f16244b.a(com.tom_roush.pdfbox.a.i.aI);
        if (ZeusTransformUtils.instanceOf(r6, com.tom_roush.pdfbox.a.n.class) == false) goto L7;
        com.tom_roush.pdfbox.a.g r7 = ((com.tom_roush.pdfbox.a.n) ZeusTransformUtils.preCheckCast(r6, com.tom_roush.pdfbox.a.n.class, "com.obric.memorydata.plugin")).h();
        byte[] r0 = com.tom_roush.pdfbox.io.a.a(r7);
        com.tom_roush.pdfbox.io.a.a(r7);
        int r8 = r0.length / 2;
        int[] r1 = new int[r8];
        int r2 = 0;
        int r3 = 0;
    L5:
        if (r2 >= r8) goto L10;
        r1[r2] = ((r0[r3] & 255) << 8) | (r0[r3 + 1] & 255);
        r3 = r3 + 2;
        r2 = r2 + 1;
        goto L5
    L10:
        return r1;
    L7:
        return null;
    }
}
