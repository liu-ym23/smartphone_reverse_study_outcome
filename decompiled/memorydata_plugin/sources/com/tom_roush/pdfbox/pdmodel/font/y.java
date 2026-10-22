package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.fontbox.f.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class y extends p {
    private final l c;
    private com.tom_roush.fontbox.c.b d;
    private com.tom_roush.fontbox.c.b e;
    private boolean f;
    private boolean g;
    private final Set<Integer> h;

    public y(com.tom_roush.pdfbox.a.d r6) {
        super(r6);
        this.h = new HashSet();
        com.tom_roush.pdfbox.a.b r7 = this.f16248b.a(com.tom_roush.pdfbox.a.i.bF);
        if (ZeusTransformUtils.instanceOf(r7, com.tom_roush.pdfbox.a.a.class) == false) goto L19;
        com.tom_roush.pdfbox.a.a r8 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r7, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r8.b() == 0) goto L17;
        com.tom_roush.pdfbox.a.b r9 = r8.a(0);
        if (ZeusTransformUtils.instanceOf(r9, com.tom_roush.pdfbox.a.d.class) == false) goto L15;
        if (com.tom_roush.pdfbox.a.i.dc.equals(((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin")).b(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.dc)) == false) goto L13;
        this.c = r.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r9, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"), this);
        q();
        r();
        return;
    L13:
        throw new IOException("Missing or wrong type in descendant font dictionary");
    L15:
        throw new IOException("Missing descendant font dictionary");
    L17:
        throw new IOException("Descendant font array is empty");
    L19:
        throw new IOException("Missing descendant font array");
    }

    private void q() {
        com.tom_roush.pdfbox.a.b r0 = this.f16248b.a(com.tom_roush.pdfbox.a.i.cy);
        boolean r2 = true;
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.i.class) == false) goto L5;
        this.d = c.a(((com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin")).a());
        this.f = true;
    L13:
        o r1 = this.c.g();
        if (r1 == null) goto L29;
        String r3 = r1.b();
        if ("Adobe".equals(r1.a()) == true) goto L18;
    L26:
        r2 = false;
    L27:
        this.g = r2;
        return;
    L18:
        if ("GB1".equals(r3) == true) goto L27;
        if ("CNS1".equals(r3) == true) goto L27;
        if ("Japan1".equals(r3) == true) goto L27;
        if ("Korea1".equals(r3) == false) goto L26;
    L29:
        return;
    L5:
        if (r0 == null) goto L13;
        com.tom_roush.fontbox.c.b r4 = a(r0);
        this.d = r4;
        if (r4 == null) goto L12;
        if (r4.a() == true) goto L13;
        Log.w("PdfBox-Android", "Invalid Encoding CMap in font " + c());
        goto L13
    L12:
        throw new IOException("Missing required CMap");
    }

    private void r() {
        com.tom_roush.pdfbox.a.i r0 = this.f16248b.b(com.tom_roush.pdfbox.a.i.cy);
        if (this.f == false) goto L9;
        if (r0 == com.tom_roush.pdfbox.a.i.dM) goto L9;
        if (r0 == com.tom_roush.pdfbox.a.i.dN) goto L9;
    L10:
        String r1 = null;
        if (this.g == false) goto L15;
        o r2 = this.c.g();
        if (r2 == null) goto L17;
        r1 = r2.a() + "-" + r2.b() + "-" + r2.c();
    L17:
        if (r1 == null) goto L26;
        com.tom_roush.fontbox.c.b r3 = c.a(r1);     // Catch: IOException -> L20
        this.e = c.a(r3.e() + "-" + r3.f() + "-UCS2");     // Catch: IOException -> L20
        return;
    L20:
        e = move-exception;
        Log.w("PdfBox-Android", "Could not get " + r1 + " UC2 map for font " + c(), e);
        return;
    L26:
        return;
    L15:
        if (r0 == null) goto L17;
        r1 = r0.a();
    L9:
        if (this.g == true) goto L10;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public int a(InputStream r1) {
        com.tom_roush.fontbox.c.b r0 = this.d;
        if (r0 == null) goto L7;
        return r0.a(r1);
    L7:
        throw new IOException("required cmap is null");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public com.tom_roush.pdfbox.util.e a(int r1) {
        return this.c.a(r1).a(-0.001f);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public q b() {
        return this.c.d();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public com.tom_roush.pdfbox.util.e b(int r3) {
        if (l() == false) goto L7;
        return new com.tom_roush.pdfbox.util.e(0.0f, this.c.b(r3) / 1000.0f);
    L7:
        return super.b(r3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public float c(int r1) {
        return this.c.c(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public String c() {
        return n();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public float d(int r1) {
        throw new UnsupportedOperationException("not supported");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public String e(int r6) {
        String r0 = super.e(r6);
        if (r0 == null) goto L6;
        return r0;
    L6:
        if (this.f == true) goto L10;
        if (this.g == true) goto L10;
    L14:
        if (ZeusTransformUtils.instanceOf(this.c, n.class) == false) goto L33;
        ah r1 = ((n) ZeusTransformUtils.preCheckCast(this.c, n.class, "com.obric.memorydata.plugin")).l();
        if (r1 == null) goto L33;
        com.tom_roush.fontbox.f.c r2 = r1.a(false);     // Catch: IOException -> L30
        if (r2 == null) goto L33;
        if (this.c.k() == false) goto L23;
        int r4 = this.c.e(r6);     // Catch: IOException -> L30
    L24:
        List<Integer> r3 = r2.b(r4);     // Catch: IOException -> L30
        if (r3 == null) goto L33;
        if (r3.isEmpty() == true) goto L33;
        return Character.toString((char) ((Integer) ZeusTransformUtils.preCheckCast(r3.get(0), Integer.class, "com.obric.memorydata.plugin")).intValue());
    L23:
        r4 = this.c.d(r6);     // Catch: IOException -> L30
    L30:
        e = move-exception;
        Log.w("PdfBox-Android", "get unicode from font cmap fail", e);
    L33:
        if (this.h.contains(Integer.valueOf(r6)) == true) goto L39;
        Log.w("PdfBox-Android", "No Unicode mapping for " + ("CID+" + f(r6)) + " (" + r6 + ") in font " + c());
        this.h.add(Integer.valueOf(r6));
        return null;
    L39:
        return null;
    L10:
        if (this.e == null) goto L14;
        return this.e.a(f(r6));
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public float f() {
        return this.c.f();
    }

    public int f(int r1) {
        return this.c.d(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public float g(int r1) {
        return this.c.g(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p, com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.pdfbox.util.c i() {
        return this.c.i();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.fontbox.g.a j() {
        return this.c.j();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public boolean k() {
        return this.c.k();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public boolean l() {
        com.tom_roush.fontbox.c.b r1 = this.d;
        if (r1 != null) goto L5;
    L7:
        return false;
    L5:
        if (r1.c() != 1) goto L7;
        return true;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public boolean m() {
        return false;
    }

    public String n() {
        return this.f16248b.g(com.tom_roush.pdfbox.a.i.Q);
    }

    public l o() {
        return this.c;
    }

    public com.tom_roush.fontbox.c.b p() {
        return this.d;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public String toString() {
        if (o() == null) goto L5;
        String r0 = o().getClass().getSimpleName();
    L7:
        return getClass().getSimpleName() + "/" + r0 + ", PostScript name: " + n();
    L5:
        r0 = null;
        goto L7
    }
}
