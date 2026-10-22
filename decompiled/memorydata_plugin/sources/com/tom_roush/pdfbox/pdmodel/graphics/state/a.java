package com.tom_roush.pdfbox.pdmodel.graphics.state;

import android.graphics.Paint;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.a.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes6.dex */
public class a implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16273a;

    public a() {
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16273a = r0;
        r0.a(i.iz, i.cI);
    }

    public a(com.tom_roush.pdfbox.a.d r1) {
        this.f16273a = r1;
    }

    private float a(Float r1, float r2) {
        if (r1 != null) goto L4;
        return r2;
    L4:
        return r1.floatValue();
    }

    private Float a(i r2) {
        com.tom_roush.pdfbox.a.b r1 = this.f16273a.a(r2);
        if (ZeusTransformUtils.instanceOf(r1, k.class) == true) goto L7;
        return null;
    L7:
        return Float.valueOf(((k) ZeusTransformUtils.preCheckCast(r1, k.class, "com.obric.memorydata.plugin")).a());
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16273a;
    }

    public void a(b r6) {
        Iterator<i> r0 = this.f16273a.c().iterator();
    L4:
        if (r0.hasNext() == false) goto L77;
        i r1 = (i) ZeusTransformUtils.preCheckCast(r0.next(), i.class, "com.obric.memorydata.plugin");
        if (r1.equals(i.eH) == true) goto L7;
        if (r1.equals(i.es) == true) goto L10;
        if (r1.equals(i.eB) == true) goto L13;
        if (r1.equals(i.fc) == true) goto L16;
        if (r1.equals(i.br) == true) goto L19;
        if (r1.equals(i.gW) == true) goto L22;
        if (r1.equals(i.fK) == true) goto L25;
        if (r1.equals(i.fG) == true) goto L28;
        if (r1.equals(i.fH) == true) goto L31;
        if (r1.equals(i.dc) == true) goto L34;
        if (r1.equals(i.cX) == true) goto L39;
        if (r1.equals(i.ht) == true) goto L42;
        if (r1.equals(i.hf) == true) goto L45;
        if (r1.equals(i.ao) == true) goto L48;
        if (r1.equals(i.ap) == true) goto L51;
        if (r1.equals(i.o) == true) goto L54;
        if (r1.equals(i.ij) == true) goto L57;
        if (r1.equals(i.hu) == true) goto L60;
        if (r1.equals(i.ae) == true) goto L66;
        if (r1.equals(i.im) == true) goto L70;
        if (r1.equals(i.in) == false) goto L4;
        com.tom_roush.pdfbox.a.b r2 = w();
    L76:
        r6.a(r2);
        goto L4
    L70:
        if (this.f16273a.m(i.in) == true) goto L4;
        r2 = v();
        goto L76
    L66:
        r6.a(s());
        goto L4
    L60:
        c r3 = t();
        if (r3 == null) goto L63;
        r3.a(r6.a().b());
    L63:
        r6.a(r3);
        goto L4
    L57:
        r6.b().a(u());
        goto L4
    L54:
        r6.b(r());
        goto L4
    L51:
        r6.b(a(q(), 1.0f));
        goto L4
    L48:
        r6.a(a(p(), 1.0f));
        goto L4
    L45:
        r6.a(o());
        goto L4
    L42:
        r6.e(a(n(), 0.0f));
        goto L4
    L39:
        r6.d(a(m(), 1.0f));
        goto L4
    L34:
        com.tom_roush.pdfbox.pdmodel.graphics.a r4 = l();
        if (r4 == null) goto L4;
        r6.b().a(r4.a());
        r6.b().e(r4.b());
        goto L4
    L31:
        r6.d(j());
        goto L4
    L28:
        r6.c(i());
        goto L4
    L25:
        r6.c(a(k(), 0.0f));
        goto L4
    L22:
        r6.a(h());
        goto L4
    L19:
        r6.a(g());
        goto L4
    L16:
        r6.b(a(f(), 10.0f));
        goto L4
    L13:
        r6.a(d());
        goto L4
    L10:
        r6.a(c());
        goto L4
    L7:
        r6.a(a(b(), 1.0f));
        goto L4
    }

    public Float b() {
        return a(i.eH);
    }

    public Paint.Cap c() {
        int r1 = this.f16273a.i(i.es);
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L11;
        return null;
    L11:
        return Paint.Cap.SQUARE;
    L13:
        return Paint.Cap.ROUND;
    L15:
        return Paint.Cap.BUTT;
    }

    public Paint.Join d() {
        int r1 = this.f16273a.i(i.eB);
        if (r1 == 0) goto L15;
        if (r1 == 1) goto L13;
        if (r1 == 2) goto L11;
        return null;
    L11:
        return Paint.Join.BEVEL;
    L13:
        return Paint.Join.ROUND;
    L15:
        return Paint.Join.MITER;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public Float f() {
        return a(i.fc);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b g() {
        com.tom_roush.pdfbox.a.b r4 = this.f16273a.a(i.br);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.a.class) == true) goto L5;
    L11:
        return null;
    L5:
        if (((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).b() != 2) goto L11;
        com.tom_roush.pdfbox.a.b r0 = ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).a(0);
        com.tom_roush.pdfbox.a.b r5 = ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).a(1);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == false) goto L11;
        if (ZeusTransformUtils.instanceOf(r5, k.class) == false) goto L11;
        return new com.tom_roush.pdfbox.pdmodel.graphics.b((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin"), ((k) ZeusTransformUtils.preCheckCast(r5, k.class, "com.obric.memorydata.plugin")).c());
    }

    public RenderingIntent h() {
        String r1 = this.f16273a.b("RI");
        if (r1 != null) goto L5;
        return null;
    L5:
        return RenderingIntent.fromString(r1);
    }

    public boolean i() {
        return this.f16273a.b(i.fG, false);
    }

    public boolean j() {
        return this.f16273a.b(i.fH, i());
    }

    public Float k() {
        return a(i.fK);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.a l() {
        com.tom_roush.pdfbox.a.b r2 = this.f16273a.a(i.dc);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.graphics.a((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin"));
    }

    public Float m() {
        return a(i.cX);
    }

    public Float n() {
        return a(i.ht);
    }

    public boolean o() {
        return this.f16273a.b(i.hf, false);
    }

    public Float p() {
        return a(i.ao);
    }

    public Float q() {
        return a(i.ap);
    }

    public boolean r() {
        return this.f16273a.b(i.o, false);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.a.a s() {
        return com.tom_roush.pdfbox.pdmodel.graphics.a.a.a(this.f16273a.a(i.ae));
    }

    public c t() {
        if (this.f16273a.m(i.hu) == true) goto L7;
        return null;
    L7:
        return c.a(this.f16273a.a(i.hu));
    }

    public boolean u() {
        return this.f16273a.b(i.ij, true);
    }

    public com.tom_roush.pdfbox.a.b v() {
        com.tom_roush.pdfbox.a.b r2 = this.f16273a.a(i.im);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L5;
        return r2;
    L5:
        if (((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).b() == 4) goto L9;
        return null;
    L9:
        return r2;
    }

    public com.tom_roush.pdfbox.a.b w() {
        com.tom_roush.pdfbox.a.b r2 = this.f16273a.a(i.in);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L5;
        return r2;
    L5:
        if (((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).b() == 4) goto L9;
        return null;
    L9:
        return r2;
    }
}
