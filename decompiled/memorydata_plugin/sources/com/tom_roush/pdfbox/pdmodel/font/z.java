package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class z extends w {
    private final Map<String, Float> e;
    private Float f;
    private com.tom_roush.pdfbox.util.c g;
    private final AffineTransform h;
    private final com.tom_roush.fontbox.b.n i;
    private final com.tom_roush.fontbox.b j;
    private final boolean k;
    private final boolean l;
    private com.tom_roush.fontbox.g.a m;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.font.z$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements com.tom_roush.fontbox.b.k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ z f16253a;

        private a(z r1) {
            this.f16253a = r1;
        }

        /* synthetic */ a(z r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v16 */
    public z(com.tom_roush.pdfbox.a.d r9) {
        super(r9);
        this.e = new HashMap();
        AnonymousClass1 r10 = 0;
        com.tom_roush.fontbox.b.n r11 = 0;
        this.f = null;
        q r1 = b();
        if (r1 == null) goto L9;
        com.tom_roush.pdfbox.pdmodel.common.i r3 = r1.r();
        if (r3 == null) goto L9;
        byte[] r4 = r3.f();
        if (r4.length != 0) goto L11;
        Log.e("PdfBox-Android", "Invalid data for embedded Type1C font " + c());
    L11:
        if (r4 != null) goto L30;
    L20:
        boolean r0 = false;
        r11 = r10;
    L21:
        this.l = r0;
        this.i = r11;
        if (r11 == 0) goto L24;
        this.j = r11;
        this.k = true;
    L28:
        n();
        AffineTransform r12 = i().a();
        this.h = r12;
        r12.scale(1000.0d, 1000.0d);
        return;
    L24:
        j<com.tom_roush.fontbox.b> r13 = i.a().b(u(), r1);
        com.tom_roush.fontbox.b r2 = r13.c();
        this.j = r2;
        if (r13.d() == false) goto L27;
        Log.w("PdfBox-Android", "Using fallback font " + r2.b() + " for " + u());
    L27:
        this.k = false;
        goto L28
    L30:
        com.tom_roush.fontbox.b.h r5 = (com.tom_roush.fontbox.b.h) ZeusTransformUtils.preCheckCast(new com.tom_roush.fontbox.b.k().a(r4, new a(this, r10)).get(0), com.tom_roush.fontbox.b.h.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L17
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.fontbox.b.n.class) == false) goto L15;
        r10 = (com.tom_roush.fontbox.b.n) ZeusTransformUtils.preCheckCast(r5, com.tom_roush.fontbox.b.n.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L17
        goto L20
    L15:
        Log.e("PdfBox-Android", "Expected CFFType1Font, got " + r5.getClass().getSimpleName());     // Catch: IOException -> L17
    L19:
        r0 = true;
    L17:
        e = move-exception;
        Log.e("PdfBox-Android", "Can't read the embedded Type1C font " + c(), e);
    L9:
        r4 = null;
        goto L11
    }

    private String a(String r3) {
        if (k() == false) goto L5;
    L16:
        return r3;
    L5:
        if (this.j.b(r3) == true) goto L16;
        String r4 = q().a(r3);
        if (r4 != null) goto L10;
        return ".notdef";
    L10:
        if (r4.length() != 1) goto L17;
        String r5 = ag.a(r4.codePointAt(0));
        if (this.j.b(r5) == false) goto L18;
        return r5;
    L18:
        return ".notdef";
    L17:
        return ".notdef";
    }

    private com.tom_roush.fontbox.g.a v() {
        if (b() == null) goto L17;
        com.tom_roush.pdfbox.pdmodel.common.h r0 = b().k();
        if (r0 == null) goto L17;
        if (r0.b() != 0.0f) goto L15;
        if (r0.c() != 0.0f) goto L15;
        if (r0.d() != 0.0f) goto L15;
        if (r0.f() == 0.0f) goto L17;
    L15:
        return new com.tom_roush.fontbox.g.a(r0.b(), r0.c(), r0.d(), r0.f());
    L17:
        return this.j.c();
    }

    private float w() {
        return 500.0f;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public int a(InputStream r1) {
        return r1.read();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public final String c() {
        return u();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public float f() {
        if (this.f != null) goto L6;
        this.f = Float.valueOf(w());
    L6:
        return this.f.floatValue();
    }

    public String f(int r1) {
        return p().a(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public float g(int r9) {
        float[] r0 = {this.j.a(a(f(r9))), 0.0f};
        this.h.transform(r0, 0, r0, 0, 1);
        return r0[0];
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p, com.tom_roush.pdfbox.pdmodel.font.s
    public final com.tom_roush.pdfbox.util.c i() {
        if (this.g != null) goto L15;
        List<Number> r0 = null;
        r0 = this.j.d();     // Catch: IOException -> L7
    L8:
        if (r0 == null) goto L13;
        if (r0.size() != 6) goto L13;
        this.g = new com.tom_roush.pdfbox.util.c(((Number) ZeusTransformUtils.preCheckCast(r0.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(1), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(2), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(3), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(4), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(5), Number.class, "com.obric.memorydata.plugin")).floatValue());
    L13:
        return super.i();
    L7:
        this.g = f16247a;
    L15:
        return this.g;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.fontbox.g.a j() {
        if (this.m != null) goto L6;
        this.m = v();
    L6:
        return this.m;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public boolean k() {
        return this.k;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.w
    public com.tom_roush.pdfbox.pdmodel.font.a.c o() {
        if (k() == true) goto L9;
        if (a() == null) goto L9;
        return new com.tom_roush.pdfbox.pdmodel.font.a.j(a());
    L9:
        if (ZeusTransformUtils.instanceOf(this.j, com.tom_roush.fontbox.a.class) == false) goto L13;
        return com.tom_roush.pdfbox.pdmodel.font.a.j.a(((com.tom_roush.fontbox.a) ZeusTransformUtils.preCheckCast(this.j, com.tom_roush.fontbox.a.class, "com.obric.memorydata.plugin")).a());
    L13:
        return com.tom_roush.pdfbox.pdmodel.font.a.h.c;
    }

    public final String u() {
        return this.f16248b.g(com.tom_roush.pdfbox.a.i.Q);
    }
}
