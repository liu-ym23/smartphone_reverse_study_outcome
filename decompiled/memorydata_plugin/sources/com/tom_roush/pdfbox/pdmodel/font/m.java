package com.tom_roush.pdfbox.pdmodel.font;

import android.graphics.PointF;
import android.util.Log;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class m extends l {
    private final com.tom_roush.fontbox.b.a c;
    private final com.tom_roush.fontbox.b d;
    private final Map<Integer, Float> e;
    private final boolean f;
    private final boolean g;
    private Float h;
    private com.tom_roush.pdfbox.util.c i;
    private final AffineTransform j;
    private com.tom_roush.fontbox.g.a k;
    private int[] l;

    /* JADX INFO: renamed from: com.tom_roush.pdfbox.pdmodel.font.m$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
    }

    private class a implements com.tom_roush.fontbox.b.k.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ m f16245a;

        private a(m r1) {
            this.f16245a = r1;
        }

        /* synthetic */ a(m r1, AnonymousClass1 r2) {
            this(r1);
        }
    }

    public m(com.tom_roush.pdfbox.a.d r8, y r9) {
        super(r8, r9);
        this.e = new HashMap();
        AnonymousClass1 r10 = null;
        this.h = null;
        this.l = null;
        q r11 = d();
        if (r11 == null) goto L7;
        com.tom_roush.pdfbox.pdmodel.common.i r0 = r11.r();
        if (r0 == null) goto L7;
        byte[] r1 = r0.f();
    L9:
        if (r1 != null) goto L11;
    L16:
        if (r1 != null) goto L44;
        com.tom_roush.fontbox.b.h r2 = null;
    L23:
        boolean r12 = false;
    L24:
        if (r2 != null) goto L26;
        com.tom_roush.pdfbox.pdmodel.font.a r3 = i.a().a(b(), d(), g());
        if (r3.b() == false) goto L36;
        com.tom_roush.fontbox.b.h r4 = ((com.tom_roush.fontbox.f.x) ZeusTransformUtils.preCheckCast(r3.c(), com.tom_roush.fontbox.f.x.class, "com.obric.memorydata.plugin")).a().a();
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.fontbox.b.a.class) == false) goto L35;
        com.tom_roush.fontbox.b.a r5 = (com.tom_roush.fontbox.b.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.fontbox.b.a.class, "com.obric.memorydata.plugin");
        this.c = r5;
        this.d = null;
        com.tom_roush.fontbox.b r6 = r5;
    L39:
        if (r3.d() == false) goto L41;
        Log.w("PdfBox-Android", "Using fallback " + r6.b() + " for CID-keyed font " + b());
    L41:
        this.f = false;
        this.g = r12;
    L42:
        AffineTransform r13 = i().a();
        this.j = r13;
        r13.scale(1000.0d, 1000.0d);
        return;
    L35:
        com.tom_roush.fontbox.b.n r7 = (com.tom_roush.fontbox.b.n) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.fontbox.b.n.class, "com.obric.memorydata.plugin");
        this.c = null;
        com.tom_roush.fontbox.b r14 = r7;
    L37:
        this.d = r14;
        r6 = r14;
        goto L39
    L36:
        this.c = null;
        r14 = r3.a();
        goto L37
    L26:
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.fontbox.b.a.class) == false) goto L28;
        this.c = (com.tom_roush.fontbox.b.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.fontbox.b.a.class, "com.obric.memorydata.plugin");
        this.d = null;
    L29:
        this.l = h();
        this.f = true;
        this.g = false;
        goto L42
    L28:
        this.c = null;
        this.d = r2;
        goto L29
    L44:
        r2 = (com.tom_roush.fontbox.b.h) ZeusTransformUtils.preCheckCast(new com.tom_roush.fontbox.b.k().a(r1, new a(this, r10)).get(0), com.tom_roush.fontbox.b.h.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L20
    L20:
        e = move-exception;
        Log.e("PdfBox-Android", "Can't read the embedded CFF font " + r11.g(), e);
    L15:
        r2 = null;
        r12 = true;
        goto L24
    L11:
        if (r1.length <= 0) goto L16;
        if ((r1[0] & 255) != 37) goto L16;
        Log.w("PdfBox-Android", "Found PFB but expected embedded CFF font " + r11.g());
    L7:
        r1 = null;
        goto L9
    }

    private String h(int r1) {
        String r0 = this.f16243a.e(r1);
        if (r0 != null) goto L7;
        return ".notdef";
    L7:
        return ag.a(r0.codePointAt(0));
    }

    private com.tom_roush.fontbox.g.a l() {
        if (d() == null) goto L14;
        com.tom_roush.pdfbox.pdmodel.common.h r0 = d().k();
        if (r0.b() != 0.0f) goto L13;
        if (r0.c() != 0.0f) goto L13;
        if (r0.d() != 0.0f) goto L13;
        if (r0.f() == 0.0f) goto L14;
    L13:
        return new com.tom_roush.fontbox.g.a(r0.b(), r0.c(), r0.d(), r0.f());
    L14:
        com.tom_roush.fontbox.b.a r1 = this.c;
        if (r1 != null) goto L17;
        return this.d.c();
    L21:
        return new com.tom_roush.fontbox.g.a();
    L17:
        return r1.c();
    }

    private float m() {
        return 500.0f;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.l
    public int d(int r1) {
        return this.f16243a.p().b(r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.l
    public int e(int r1) {
        int r2 = d(r1);
        com.tom_roush.fontbox.b.a r0 = this.c;
        if (r0 != null) goto L5;
        return r2;
    L5:
        return r0.h().c(r2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.l
    public float f() {
        if (this.h != null) goto L6;
        this.h = Float.valueOf(m());
    L6:
        return this.h.floatValue();
    }

    public com.tom_roush.fontbox.b.v f(int r3) {
        com.tom_roush.fontbox.b.a r0 = this.c;
        if (r0 == null) goto L7;
        return r0.b(r3);
    L7:
        if (ZeusTransformUtils.instanceOf(this.d, com.tom_roush.fontbox.b.n.class) == true) goto L9;
        return null;
    L9:
        return ((com.tom_roush.fontbox.b.n) ZeusTransformUtils.preCheckCast(this.d, com.tom_roush.fontbox.b.n.class, "com.obric.memorydata.plugin")).a(r3);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public float g(int r4) {
        int r0 = d(r4);
        if (this.c == null) goto L7;
        com.tom_roush.fontbox.b.v r5 = f(r0);
    L5:
        float r6 = r5.a();
    L12:
        PointF r1 = new PointF(r6, 0.0f);
        this.j.transform(r1, r1);
        return r1.x;
    L7:
        if (this.f == true) goto L9;
    L11:
        r6 = this.d.a(h(r4));
        goto L12
    L9:
        if (ZeusTransformUtils.instanceOf(this.d, com.tom_roush.fontbox.b.n.class) == false) goto L11;
        r5 = ((com.tom_roush.fontbox.b.n) ZeusTransformUtils.preCheckCast(this.d, com.tom_roush.fontbox.b.n.class, "com.obric.memorydata.plugin")).a(r0);
        goto L5
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public final com.tom_roush.pdfbox.util.c i() {
        if (this.i != null) goto L16;
        com.tom_roush.fontbox.b.a r1 = this.c;
        if (r1 == null) goto L17;
        List<Number> r2 = r1.d();
    L8:
        if (r2 != null) goto L10;
    L12:
        this.i = new com.tom_roush.pdfbox.util.c(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
        goto L16
    L10:
        if (r2.size() != 6) goto L12;
        this.i = new com.tom_roush.pdfbox.util.c(((Number) ZeusTransformUtils.preCheckCast(r2.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.get(1), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.get(2), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.get(3), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.get(4), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r2.get(5), Number.class, "com.obric.memorydata.plugin")).floatValue());
        goto L16
    L17:
        r2 = this.d.d();     // Catch: IOException -> L13
    L14:
        return new com.tom_roush.pdfbox.util.c(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
    L16:
        return this.i;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.fontbox.g.a j() {
        if (this.k != null) goto L6;
        this.k = l();
    L6:
        return this.k;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public boolean k() {
        return this.f;
    }
}
