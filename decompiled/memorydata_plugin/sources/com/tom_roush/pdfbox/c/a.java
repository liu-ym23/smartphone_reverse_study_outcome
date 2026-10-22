package com.tom_roush.pdfbox.c;

import android.util.Log;
import com.tom_roush.fontbox.f.ah;
import com.tom_roush.pdfbox.contentstream.operator.a.e;
import com.tom_roush.pdfbox.contentstream.operator.a.f;
import com.tom_roush.pdfbox.contentstream.operator.a.g;
import com.tom_roush.pdfbox.contentstream.operator.a.i;
import com.tom_roush.pdfbox.contentstream.operator.a.j;
import com.tom_roush.pdfbox.contentstream.operator.a.k;
import com.tom_roush.pdfbox.contentstream.operator.a.l;
import com.tom_roush.pdfbox.contentstream.operator.a.m;
import com.tom_roush.pdfbox.contentstream.operator.a.n;
import com.tom_roush.pdfbox.contentstream.operator.a.o;
import com.tom_roush.pdfbox.contentstream.operator.a.p;
import com.tom_roush.pdfbox.pdmodel.common.h;
import com.tom_roush.pdfbox.pdmodel.font.ad;
import com.tom_roush.pdfbox.pdmodel.font.q;
import com.tom_roush.pdfbox.pdmodel.font.w;
import com.tom_roush.pdfbox.pdmodel.font.x;
import com.tom_roush.pdfbox.pdmodel.font.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes6.dex */
class a extends com.tom_roush.pdfbox.contentstream.b {
    private static final com.tom_roush.pdfbox.pdmodel.font.a.d d = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f16080a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private h f16081b;
    private com.tom_roush.pdfbox.util.c c;
    private final Map<com.tom_roush.pdfbox.a.d, Float> e;

    static {
    L9:
        e = move-exception;
        throw new RuntimeException(e);
    L4:
        if (com.tom_roush.pdfbox.android.a.a() == false) goto L6;
        InputStream r0 = com.tom_roush.pdfbox.android.a.a("com/tom_roush/pdfbox/resources/glyphlist/additional.txt");     // Catch: IOException -> L9
    L7:
        d = new com.tom_roush.pdfbox.pdmodel.font.a.d(com.tom_roush.pdfbox.pdmodel.font.a.d.a(), r0);     // Catch: IOException -> L9
        r0.close();     // Catch: IOException -> L9
        return;
    L6:
        r0 = com.tom_roush.pdfbox.pdmodel.font.a.d.class.getResourceAsStream("/com/tom_roush/pdfbox/resources/glyphlist/additional.txt");     // Catch: IOException -> L9
        goto L7
    }

    a() {
        this.e = new WeakHashMap();
        a(new com.tom_roush.pdfbox.contentstream.operator.a.a());
        a(new com.tom_roush.pdfbox.contentstream.operator.state.a());
        a(new com.tom_roush.pdfbox.contentstream.operator.a());
        a(new com.tom_roush.pdfbox.contentstream.operator.a.b());
        a(new com.tom_roush.pdfbox.contentstream.operator.state.d());
        a(new com.tom_roush.pdfbox.contentstream.operator.state.c());
        a(new com.tom_roush.pdfbox.contentstream.operator.state.b());
        a(new e());
        a(new f());
        a(new com.tom_roush.pdfbox.contentstream.operator.a.c());
        a(new com.tom_roush.pdfbox.contentstream.operator.a.d());
        a(new g());
        a(new m());
        a(new n());
        a(new i());
        a(new com.tom_roush.pdfbox.contentstream.operator.state.e());
        a(new j());
        a(new k());
        a(new l());
        a(new com.tom_roush.pdfbox.contentstream.operator.a.h());
        a(new o());
        a(new p());
    }

    public float a(com.tom_roush.pdfbox.pdmodel.font.p r6) {
        com.tom_roush.fontbox.g.a r5 = r6.j();
        if (r5.b() >= (-32768.0f)) goto L5;
        r5.b(-(r5.b() + 65536.0f));
    L5:
        float r7 = r5.e() / 2.0f;
        q r1 = r6.b();
        if (r1 == null) goto L26;
        float r3 = r1.n();
        if (Float.compare(r3, 0.0f) != 0) goto L10;
    L14:
        float r4 = r1.l();
        float r2 = r1.m();
        if (r3 <= r4) goto L26;
        if (r4 <= 0.0f) goto L26;
        if (r2 >= 0.0f) goto L26;
        float r0 = (r4 - r2) / 2.0f;
        if (r0 >= r7) goto L23;
    L24:
        r7 = r0;
        goto L26
    L23:
        if (Float.compare(r7, 0.0f) != 0) goto L26;
    L10:
        if (r3 >= r7) goto L12;
    L13:
        r7 = r3;
        goto L14
    L12:
        if (Float.compare(r7, 0.0f) != 0) goto L14;
    L26:
        if (ZeusTransformUtils.instanceOf(r6, ad.class) == false) goto L29;
        return r6.i().a(0.0f, r7).y;
    L29:
        return r7 / 1000.0f;
    }

    public void a(c r1) {
    }

    @Override // com.tom_roush.pdfbox.contentstream.b
    public void a(com.tom_roush.pdfbox.pdmodel.g r3) {
        this.f16080a = r3.i();
        h r0 = r3.h();
        this.f16081b = r0;
        if (r0.b() == 0.0f) goto L5;
    L7:
        com.tom_roush.pdfbox.util.c r1 = com.tom_roush.pdfbox.util.c.b(-this.f16081b.b(), -this.f16081b.c());
    L8:
        this.c = r1;
        super.a(r3);
        return;
    L5:
        if (this.f16081b.c() != 0.0f) goto L7;
        r1 = null;
        goto L8
    }

    @Override // com.tom_roush.pdfbox.contentstream.b
    public void a(com.tom_roush.pdfbox.util.c r20, com.tom_roush.pdfbox.pdmodel.font.p r21, int r22, String r23, com.tom_roush.pdfbox.util.e r24) {
        com.tom_roush.pdfbox.pdmodel.graphics.state.b r0 = g();
        com.tom_roush.pdfbox.util.c r3 = r0.a();
        float r15 = r0.b().f();
        float r1 = r0.b().c() / 100.0f;
        com.tom_roush.pdfbox.util.c r4 = i();
        float r5 = r24.a();
        if (r21.l() == false) goto L16;
        r5 = r21.c(r22) / 1000.0f;
        ah r8 = null;
        if (ZeusTransformUtils.instanceOf(r21, x.class) == false) goto L8;
        r8 = ((x) ZeusTransformUtils.preCheckCast(r21, x.class, "com.obric.memorydata.plugin")).v();
    L12:
        if (r8 == null) goto L16;
        if (r8.v() == 1000) goto L16;
        r5 = r5 * (1000.0f / r8.v());
        goto L16
    L8:
        if (ZeusTransformUtils.instanceOf(r21, y.class) == false) goto L12;
        com.tom_roush.pdfbox.pdmodel.font.l r9 = ((y) ZeusTransformUtils.preCheckCast(r21, y.class, "com.obric.memorydata.plugin")).o();
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.pdmodel.font.n.class) == false) goto L12;
        r8 = ((com.tom_roush.pdfbox.pdmodel.font.n) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.pdmodel.font.n.class, "com.obric.memorydata.plugin")).l();
    L16:
        com.tom_roush.pdfbox.util.c r2 = com.tom_roush.pdfbox.util.c.b((r5 * r15) * r1, r24.b() * r15).b(r4).b(r3);
        float r6 = r2.i();
        float r7 = r2.j();
        float r10 = r6 - r20.i();
        Float r11 = (Float) ZeusTransformUtils.preCheckCast(this.e.get(r21.d()), Float.class, "com.obric.memorydata.plugin");
        if (r11 != null) goto L19;
        r11 = Float.valueOf(a(r21));
        this.e.put(r21.d(), r11);
    L19:
        float r12 = r20.d() * r11.floatValue();
        float r13 = 0.001f;
        if (ZeusTransformUtils.instanceOf(r21, ad.class) == false) goto L22;
        r13 = r21.i().e();
    L22:
        float r14 = r13;
        float r16 = r21.h() * r14;
    L28:
        if (r16 != 0.0f) goto L31;
        r16 = (r21.f() * r14) * 0.8f;
    L31:
        if (r16 != 0.0f) goto L33;
        r16 = 1.0f;
    L33:
        float r17 = r16 * r20.c();
        String r18 = r21.a(r22, d);
        if (r18 == null) goto L36;
        String r19 = r18;
    L40:
        com.tom_roush.pdfbox.util.c r25 = this.c;
        if (r25 != null) goto L43;
        com.tom_roush.pdfbox.util.c r26 = r20;
    L44:
        a(new c(this.f16080a, this.f16081b.g(), this.f16081b.h(), r26, r6, r7, Math.abs(r12), r10, Math.abs(r17), r19, new int[]{r22}, r21, r15, (int) (r4.c() * r15)));
        return;
    L43:
        r26 = com.tom_roush.pdfbox.util.c.b(r25, r20);
        r6 = r6 - this.f16081b.b();
        r7 = r7 - this.f16081b.c();
        goto L44
    L36:
        if (ZeusTransformUtils.instanceOf(r21, w.class) == false) goto L38;
        r19 = new String(new char[]{(char) r22});
        goto L40
    L38:
        return;
    L25:
        th = move-exception;
        Log.w("PdfBox-Android", th.getMessage(), th);
        r16 = 0.0f;
        goto L28
    }
}
