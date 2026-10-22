package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.fontbox.f.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public class n extends l {
    private final ah c;
    private final int[] d;
    private final boolean e;
    private final boolean f;
    private final com.tom_roush.fontbox.f.c g;
    private com.tom_roush.pdfbox.util.c h;
    private com.tom_roush.fontbox.g.a i;
    private final Set<Integer> j;

    public n(com.tom_roush.pdfbox.a.d r2, y r3) {
        this(r2, r3, null);
    }

    public n(com.tom_roush.pdfbox.a.d r5, y r6, ah r7) {
        super(r5, r6);
        this.j = new HashSet();
        q r8 = d();
        boolean r1 = true;
        if (r7 == null) goto L5;
        this.c = r7;
        this.e = true;
        this.f = false;
    L29:
        this.g = this.c.a(false);
        this.d = h();
        return;
    L5:
        com.tom_roush.fontbox.f.x r9 = null;
        r9 = null;
        if (r8 == null) goto L12;
        com.tom_roush.pdfbox.pdmodel.common.i r2 = r8.q();
        if (r2 != null) goto L10;
        r2 = r8.r();
    L10:
        if (r2 != null) goto L13;
        r2 = r8.p();
    L13:
        if (r2 != null) goto L31;
    L21:
        boolean r10 = false;
        com.tom_roush.fontbox.f.x r11 = r9;
    L22:
        if (r11 != null) goto L25;
        r1 = false;
    L25:
        this.e = r1;
        this.f = r10;
        ah r12 = r11;
        if (r11 != null) goto L28;
        r12 = m();
    L28:
        this.c = r12;
        goto L29
    L31:
        r9 = new com.tom_roush.fontbox.f.v(true).a(r2.b());     // Catch: IOException -> L18
        if (r9.f() == false) goto L21;
        Log.w("PdfBox-Android", "Found CFF/OTF but expected embedded TTF font " + r8.g());     // Catch: IOException -> L18
        com.tom_roush.fontbox.f.x r13 = r9;
    L20:
        r10 = true;
        r11 = r13;
    L18:
        e = move-exception;
        Log.w("PdfBox-Android", "Could not read embedded OTF for font " + b(), e);
        r13 = r9;
        goto L20
    L12:
        r2 = null;
        goto L13
    }

    private ah m() {
        a r0 = i.a().a(b(), d(), g());
        if (r0.b() == false) goto L5;
        com.tom_roush.fontbox.b r1 = r0.c();
    L6:
        ah r2 = (ah) ZeusTransformUtils.preCheckCast(r1, ah.class, "com.obric.memorydata.plugin");
        if (r0.d() == false) goto L9;
        Log.w("PdfBox-Android", "Using fallback font " + r2.b() + " for CID-keyed TrueType font " + b());
    L9:
        return r2;
    L5:
        r1 = r0.a();
        goto L6
    }

    private com.tom_roush.fontbox.g.a n() {
        if (d() == null) goto L17;
        com.tom_roush.pdfbox.pdmodel.common.h r0 = d().k();
        if (r0 == null) goto L17;
        if (Float.compare(r0.b(), 0.0f) != 0) goto L15;
        if (Float.compare(r0.c(), 0.0f) != 0) goto L15;
        if (Float.compare(r0.d(), 0.0f) != 0) goto L15;
        if (Float.compare(r0.f(), 0.0f) == 0) goto L17;
    L15:
        return new com.tom_roush.fontbox.g.a(r0.b(), r0.c(), r0.d(), r0.f());
    L17:
        return this.c.c();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.l
    public int d(int r2) {
        com.tom_roush.fontbox.c.b r1 = this.f16243a.p();
        if (r1.a() == true) goto L11;
        if (r1.b() == false) goto L11;
        String r0 = r1.a(r2);
        if (r0 == null) goto L11;
        return r0.codePointAt(0);
    L11:
        return r1.b(r2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.l
    public int e(int r5) {
        if (this.e == false) goto L5;
        int r6 = d(r5);
        int[] r0 = this.d;
        if (r0 == null) goto L33;
        if (r6 < r0.length) goto L30;
        return 0;
    L30:
        return r0[r6];
    L33:
        if (r6 >= this.c.u()) goto L35;
        return r6;
    L35:
        return 0;
    L5:
        if (this.d != null) goto L7;
    L13:
        String r1 = this.f16243a.e(r5);
        if (r1 != null) goto L21;
        if (this.j.contains(Integer.valueOf(r5)) == true) goto L19;
        this.j.add(Integer.valueOf(r5));
        Log.w("PdfBox-Android", "Failed to find a character mapping for " + r5 + " in " + c());
    L19:
        return d(r5);
    L21:
        if (r1.length() <= 1) goto L24;
        Log.w("PdfBox-Android", "Trying to map multi-byte character using 'cmap', result will be poor");
    L24:
        return this.g.a(r1.codePointAt(0));
    L7:
        if (this.f == true) goto L13;
        Log.w("PdfBox-Android", "Using non-embedded GIDs in font " + c());
        int r7 = d(r5);
        int[] r4 = this.d;
        if (r7 < r4.length) goto L11;
        return 0;
    L11:
        return r4[r7];
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public float g(int r2) {
        float r3 = this.c.a(e(r2));
        int r1 = this.c.v();
        if (r1 != 1000) goto L5;
        return r3;
    L5:
        return r3 * (1000.0f / r1);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.pdfbox.util.c i() {
        if (this.h != null) goto L6;
        this.h = new com.tom_roush.pdfbox.util.c(0.001f, 0.0f, 0.0f, 0.001f, 0.0f, 0.0f);
    L6:
        return this.h;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.fontbox.g.a j() {
        if (this.i != null) goto L6;
        this.i = n();
    L6:
        return this.i;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public boolean k() {
        return this.e;
    }

    public ah l() {
        return this.c;
    }
}
