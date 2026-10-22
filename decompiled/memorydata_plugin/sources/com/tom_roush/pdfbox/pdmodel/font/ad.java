package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class ad extends w {
    private com.tom_roush.pdfbox.pdmodel.i e;
    private com.tom_roush.pdfbox.a.d f;
    private com.tom_roush.pdfbox.util.c g;
    private com.tom_roush.fontbox.g.a h;
    private final com.tom_roush.pdfbox.pdmodel.k i;

    public ad(com.tom_roush.pdfbox.a.d r3, com.tom_roush.pdfbox.pdmodel.k r4) {
        com.tom_roush.pdfbox.pdmodel.k r5 = (com.tom_roush.pdfbox.pdmodel.k) ZeusTransformUtils.wrapperContextForParams(r4, com.tom_roush.pdfbox.pdmodel.k.class, "com.obric.memorydata.plugin");
        super(r3);
        this.i = r5;
        n();
    }

    private boolean a(com.tom_roush.pdfbox.a.a r4) {
        if (r4 != null) goto L5;
        return false;
    L5:
        if (r4.b() != 6) goto L19;
        Iterator<? extends com.tom_roush.pdfbox.a.b> r5 = r4.d().iterator();
    L9:
        if (r5.hasNext() == false) goto L13;
        if (ZeusTransformUtils.instanceOf((com.tom_roush.pdfbox.a.b) ZeusTransformUtils.preCheckCast(r5.next(), com.tom_roush.pdfbox.a.b.class, "com.obric.memorydata.plugin"), com.tom_roush.pdfbox.a.k.class) == true) goto L9;
        return false;
    L13:
        return true;
    L19:
        return false;
    }

    private com.tom_roush.fontbox.g.a w() {
        com.tom_roush.pdfbox.pdmodel.common.h r0 = u();
        if (r0 != null) goto L7;
        Log.w("PdfBox-Android", "FontBBox missing, returning empty rectangle");
        return new com.tom_roush.fontbox.g.a();
    L7:
        if (r0.b() != 0.0f) goto L28;
        if (r0.c() != 0.0f) goto L28;
        if (r0.d() != 0.0f) goto L28;
        if (r0.f() != 0.0f) goto L28;
        com.tom_roush.pdfbox.a.d r1 = v();
        if (r1 == null) goto L28;
        Iterator<com.tom_roush.pdfbox.a.i> r2 = r1.c().iterator();
    L18:
        if (r2.hasNext() == false) goto L28;
        com.tom_roush.pdfbox.a.n r3 = r1.e((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r2.next(), com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin"));
        if (r3 == null) goto L18;
        com.tom_roush.pdfbox.pdmodel.common.h r4 = new ac(this, r3).g();     // Catch: IOException -> L29
        if (r4 == null) goto L18;
        r0.a(Math.min(r0.b(), r4.b()));     // Catch: IOException -> L29
        r0.b(Math.min(r0.c(), r4.c()));     // Catch: IOException -> L29
        r0.c(Math.max(r0.d(), r4.d()));     // Catch: IOException -> L29
        r0.d(Math.max(r0.f(), r4.f()));     // Catch: IOException -> L29
    L28:
        return new com.tom_roush.fontbox.g.a(r0.b(), r0.c(), r0.d(), r0.f());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public int a(InputStream r1) {
        return r1.read();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public com.tom_roush.pdfbox.util.e b(int r3) {
        return i().b(new com.tom_roush.pdfbox.util.e(c(r3), 0.0f));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public float c(int r5) {
        int r0 = this.f16248b.b(com.tom_roush.pdfbox.a.i.cV, -1);
        int r1 = this.f16248b.b(com.tom_roush.pdfbox.a.i.eq, -1);
        List<Float> r2 = g();
        if (r2.isEmpty() == true) goto L14;
        if (r5 < r0) goto L14;
        if (r5 > r1) goto L14;
        int r6 = r5 - r0;
        if (r6 < r2.size()) goto L9;
        return 0.0f;
    L9:
        Float r4 = (Float) ZeusTransformUtils.preCheckCast(r2.get(r6), Float.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L13;
        return 0.0f;
    L13:
        return r4.floatValue();
    L14:
        q r3 = b();
        if (r3 == null) goto L19;
        return r3.o();
    L19:
        return g(r5);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public String c() {
        return this.f16248b.g(com.tom_roush.pdfbox.a.i.fh);
    }

    public ac f(int r3) {
        if (p() != null) goto L5;
        return null;
    L5:
        if (v() == null) goto L13;
        String r4 = p().a(r3);
        com.tom_roush.pdfbox.a.n r5 = v().e(com.tom_roush.pdfbox.a.i.a(r4));
        if (r5 != null) goto L10;
        return null;
    L10:
        return new ac(this, r5);
    L13:
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public float g(int r1) {
        ac r0 = f(r1);
        if (r0 != null) goto L5;
        return 0.0f;
    L5:
        if (r0.f().c() != 0) goto L8;
        return 0.0f;
    L8:
        return r0.h();
    }

    public com.tom_roush.pdfbox.pdmodel.i getResources() {
        if (this.e != null) goto L8;
        com.tom_roush.pdfbox.a.b r0 = this.f16248b.a(com.tom_roush.pdfbox.a.i.gU);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.d.class) == false) goto L8;
        this.e = new com.tom_roush.pdfbox.pdmodel.i((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), this.i);
    L8:
        return this.e;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p, com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.pdfbox.util.c i() {
        if (this.g != null) goto L10;
        com.tom_roush.pdfbox.a.a r0 = this.f16248b.f(com.tom_roush.pdfbox.a.i.dj);
        if (a(r0) == false) goto L7;
        com.tom_roush.pdfbox.util.c r1 = com.tom_roush.pdfbox.util.c.a(r0);
    L8:
        this.g = r1;
        goto L10
    L7:
        r1 = super.i();
    L10:
        return this.g;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.fontbox.g.a j() {
        if (this.h != null) goto L6;
        this.h = w();
    L6:
        return this.h;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public boolean k() {
        return true;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.w, com.tom_roush.pdfbox.pdmodel.font.p
    public boolean m() {
        return false;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.w
    public final void n() {
        com.tom_roush.pdfbox.a.b r0 = this.f16248b.a(com.tom_roush.pdfbox.a.i.cy);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.i.class) == false) goto L8;
        com.tom_roush.pdfbox.a.i r1 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        this.c = com.tom_roush.pdfbox.pdmodel.font.a.c.a(r1);
        if (this.c != null) goto L10;
        Log.w("PdfBox-Android", "Unknown encoding: " + r1.a());
    L10:
        this.d = com.tom_roush.pdfbox.pdmodel.font.a.d.a();
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.d.class) == false) goto L10;
        this.c = new com.tom_roush.pdfbox.pdmodel.font.a.b((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
        goto L10
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.w
    public com.tom_roush.pdfbox.pdmodel.font.a.c o() {
        throw new UnsupportedOperationException("not supported for Type 3 fonts");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.w
    public Boolean s() {
        return false;
    }

    public com.tom_roush.pdfbox.pdmodel.common.h u() {
        com.tom_roush.pdfbox.a.b r3 = this.f16248b.a(com.tom_roush.pdfbox.a.i.dd);
        if (ZeusTransformUtils.instanceOf(r3, com.tom_roush.pdfbox.a.a.class) == true) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.common.h((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r3, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin"));
    }

    public com.tom_roush.pdfbox.a.d v() {
        if (this.f != null) goto L6;
        this.f = this.f16248b.d(com.tom_roush.pdfbox.a.i.aC);
    L6:
        return this.f;
    }
}
