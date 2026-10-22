package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.tom_roush.fontbox.type1.DamagedFontException;
import com.tom_roush.harmony.awt.geom.AffineTransform;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public class aa extends w {
    public static final aa e = null;
    public static final aa f = null;
    public static final aa g = null;
    public static final aa h = null;
    public static final aa i = null;
    public static final aa j = null;
    public static final aa k = null;
    public static final aa l = null;
    public static final aa m = null;
    public static final aa n = null;
    public static final aa o = null;
    public static final aa p = null;
    public static final aa q = null;
    public static final aa r = null;
    private static final Map<String, String> s = null;
    private final Map<Integer, byte[]> A;
    private final com.tom_roush.fontbox.type1.b t;
    private final com.tom_roush.fontbox.b u;
    private final boolean v;
    private final boolean w;
    private com.tom_roush.pdfbox.util.c x;
    private final AffineTransform y;
    private com.tom_roush.fontbox.g.a z;

    static {
        HashMap r0 = new HashMap();
        s = r0;
        r0.put("ff", "f_f");
        r0.put("ffi", "f_f_i");
        r0.put("ffl", "f_f_l");
        r0.put("fi", "f_i");
        r0.put("fl", "f_l");
        r0.put("st", "s_t");
        r0.put("IJ", "I_J");
        r0.put("ij", "i_j");
        r0.put("ellipsis", "elipsis");
        e = new aa("Times-Roman");
        f = new aa("Times-Bold");
        g = new aa("Times-Italic");
        h = new aa("Times-BoldItalic");
        i = new aa("Helvetica");
        j = new aa("Helvetica-Bold");
        k = new aa("Helvetica-Oblique");
        l = new aa("Helvetica-BoldOblique");
        m = new aa("Courier");
        n = new aa("Courier-Bold");
        o = new aa("Courier-Oblique");
        p = new aa("Courier-BoldOblique");
        q = new aa("Symbol");
        r = new aa("ZapfDingbats");
    }

    public aa(com.tom_roush.pdfbox.a.d r11) {
        super(r11);
        this.A = new HashMap();
        q r12 = b();
        boolean r0 = true;
        com.tom_roush.fontbox.type1.b r3 = null;
        if (r12 != null) goto L5;
    L29:
        boolean r4 = false;
    L30:
        if (r3 != null) goto L33;
        r0 = false;
    L33:
        this.v = r0;
        this.w = r4;
        this.t = r3;
        if (r3 == null) goto L36;
        this.u = r3;
    L39:
        n();
        AffineTransform r13 = i().a();
        this.y = r13;
        r13.scale(1000.0d, 1000.0d);
        return;
    L36:
        j<com.tom_roush.fontbox.b> r14 = i.a().b(u(), r12);
        com.tom_roush.fontbox.b r1 = r14.c();
        this.u = r1;
        if (r14.d() == false) goto L39;
        Log.w("PdfBox-Android", "Using fallback font " + r1.b() + " for " + u());
        goto L39
    L5:
        if (r12.r() == null) goto L7;
        Log.w("PdfBox-Android", "/FontFile3 for Type1 font not supported");
    L7:
        com.tom_roush.pdfbox.pdmodel.common.i r5 = r12.p();
        if (r5 == null) goto L29;
        com.tom_roush.pdfbox.a.n r6 = r5.a();     // Catch: IOException -> L25 DamagedFontException -> L27
        int r7 = r6.i(com.tom_roush.pdfbox.a.i.ex);     // Catch: IOException -> L25 DamagedFontException -> L27
        int r8 = r6.i(com.tom_roush.pdfbox.a.i.ey);     // Catch: IOException -> L25 DamagedFontException -> L27
        byte[] r9 = r5.f();     // Catch: IOException -> L25 DamagedFontException -> L27
        if (r9.length == 0) goto L24;
        int r10 = a(r9, r7);     // Catch: IOException -> L25 DamagedFontException -> L27
        int r15 = a(r9, r10, r8);     // Catch: IOException -> L25 DamagedFontException -> L27
        if ((r9[0] & 255) != 128) goto L14;
        r3 = com.tom_roush.fontbox.type1.b.a(r9);     // Catch: IOException -> L25 DamagedFontException -> L27
        goto L29
    L14:
        if (r10 < 0) goto L22;
        int r16 = r10 + r15;     // Catch: IOException -> L25 DamagedFontException -> L27
        if (r10 > r16) goto L22;
        byte[] r17 = Arrays.copyOfRange(r9, 0, r10);     // Catch: IOException -> L25 DamagedFontException -> L27
        byte[] r18 = Arrays.copyOfRange(r9, r10, r16);     // Catch: IOException -> L25 DamagedFontException -> L27
        if (r10 <= 0) goto L29;
        if (r15 <= 0) goto L29;
        r3 = com.tom_roush.fontbox.type1.b.a(r17, r18);     // Catch: IOException -> L25 DamagedFontException -> L27
    L22:
        throw new IOException("Invalid length data, actual length: " + r9.length + ", /Length1: " + r10 + ", /Length2: " + r15);     // Catch: IOException -> L25 DamagedFontException -> L27
    L24:
        throw new IOException("Font data unavailable");     // Catch: IOException -> L25 DamagedFontException -> L27
    L27:
        Log.w("PdfBox-Android", "Can't read damaged embedded Type1 font " + r12.g());
    L28:
        r4 = true;
    L25:
        e = move-exception;
        Log.e("PdfBox-Android", "Can't read the embedded Type1 font " + r12.g(), e);
        goto L28
    }

    private aa(String r4) {
        super(r4);
        this.f16248b.a(com.tom_roush.pdfbox.a.i.hT, com.tom_roush.pdfbox.a.i.iB);
        this.f16248b.a(com.tom_roush.pdfbox.a.i.Q, r4);
        if ("ZapfDingbats".equals(r4) == false) goto L7;
        com.tom_roush.pdfbox.pdmodel.font.a.c r5 = com.tom_roush.pdfbox.pdmodel.font.a.l.c;
    L5:
        this.c = r5;
    L10:
        this.A = new ConcurrentHashMap();
        this.t = null;
        j<com.tom_roush.fontbox.b> r6 = i.a().b(u(), b());
        com.tom_roush.fontbox.b r0 = r6.c();
        this.u = r0;
        if (r6.d() == true) goto L18;
    L16:
        this.v = false;
        this.w = false;
        this.y = new AffineTransform();
        return;
    L18:
        String r7 = r0.b();     // Catch: IOException -> L14
    L15:
        Log.w("PdfBox-Android", "Using fallback font " + r7 + " for base font " + u());
    L14:
        r7 = "?";
        goto L15
    L7:
        if ("Symbol".equals(r4) == false) goto L9;
        r5 = com.tom_roush.pdfbox.pdmodel.font.a.i.c;
        goto L5
    L9:
        this.c = com.tom_roush.pdfbox.pdmodel.font.a.k.c;
        this.f16248b.a(com.tom_roush.pdfbox.a.i.cy, com.tom_roush.pdfbox.a.i.je);
        goto L10
    }

    private int a(byte[] r3, int r4) {
        int r0 = Math.max(0, r4 - 4);
        if (r0 > 0) goto L5;
    L6:
        r0 = r3.length - 4;
    L7:
        int r1 = b(r3, r0);
        if (r1 != 0) goto L12;
        if (r4 <= 0) goto L12;
        r1 = b(r3, r3.length - 4);
    L12:
        if ((r4 - r1) == 0) goto L16;
        if (r1 <= 0) goto L16;
        Log.w("PdfBox-Android", "Ignored invalid Length1 " + r4 + " for Type 1 font " + c());
        return r1;
    L16:
        return r4;
    L5:
        if (r0 <= (r3.length - 4)) goto L7;
        goto L6
    }

    private int a(byte[] r3, int r4, int r5) {
        if (r5 >= 0) goto L4;
    L7:
        Log.w("PdfBox-Android", "Ignored invalid Length2 " + r5 + " for Type 1 font " + c());
        return r3.length - r4;
    L4:
        if (r5 > (r3.length - r4)) goto L7;
        return r5;
    }

    private String a(String r6) {
        if (k() == false) goto L5;
    L29:
        return r6;
    L5:
        if (this.u.b(r6) == true) goto L29;
        String r0 = (String) ZeusTransformUtils.preCheckCast(s.get(r6), String.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L10;
    L14:
        String r1 = q().a(r6);
        if (r1 != null) goto L17;
    L28:
        return ".notdef";
    L17:
        if (r1.length() != 1) goto L28;
        String r2 = ag.a(r1.codePointAt(0));
        if (this.u.b(r2) == false) goto L22;
        return r2;
    L22:
        if ("SymbolMT".equals(this.u.b()) == false) goto L28;
        Integer r7 = (Integer) ZeusTransformUtils.preCheckCast(com.tom_roush.pdfbox.pdmodel.font.a.i.c.d().get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r7 == null) goto L28;
        String r8 = ag.a(r7.intValue() + 61440);
        if (this.u.b(r8) == false) goto L28;
        return r8;
    L10:
        if (r6.equals(".notdef") == true) goto L14;
        if (this.u.b(r0) == false) goto L14;
        return r0;
    }

    private static int b(byte[] r3, int r4) {
    L2:
        if (r4 <= 0) goto L24;
        if (r3[r4 + 0] != 101) goto L23;
        if (r3[r4 + 1] != 120) goto L23;
        if (r3[r4 + 2] != 101) goto L23;
        if (r3[r4 + 3] != 99) goto L23;
        r4 = r4 + 4;
    L13:
        if (r4 >= r3.length) goto L24;
        if (r3[r4] == 13) goto L22;
        if (r3[r4] == 10) goto L22;
        if (r3[r4] == 32) goto L22;
        if (r3[r4] != 9) goto L24;
    L22:
        r4 = r4 + 1;
    L23:
        r4 = r4 - 1;
    L24:
        return r4;
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
        return this.u.c();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public int a(InputStream r1) {
        return r1.read();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public String c() {
        return u();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public float f() {
        if (a() == null) goto L7;
        return a().a();
    L7:
        return super.f();
    }

    public String f(int r2) {
        if (p() == null) goto L5;
        String r3 = p().a(r2);
    L7:
        return a(r3);
    L5:
        r3 = ".notdef";
        goto L7
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public float g(int r9) {
        String r10 = f(r9);
        if (this.v == false) goto L5;
    L8:
        float[] r0 = {this.u.a(r10), 0.0f};
        this.y.transform(r0, 0, r0, 0, 1);
        return r0[0];
    L5:
        if (".notdef".equals(r10) == false) goto L8;
        return 250.0f;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p, com.tom_roush.pdfbox.pdmodel.font.s
    public final com.tom_roush.pdfbox.util.c i() {
        if (this.x != null) goto L15;
        List<Number> r0 = null;
        r0 = this.u.d();     // Catch: IOException -> L7
    L8:
        if (r0 == null) goto L13;
        if (r0.size() != 6) goto L13;
        this.x = new com.tom_roush.pdfbox.util.c(((Number) ZeusTransformUtils.preCheckCast(r0.get(0), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(1), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(2), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(3), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(4), Number.class, "com.obric.memorydata.plugin")).floatValue(), ((Number) ZeusTransformUtils.preCheckCast(r0.get(5), Number.class, "com.obric.memorydata.plugin")).floatValue());
    L13:
        return super.i();
    L7:
        this.x = f16247a;
    L15:
        return this.x;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.fontbox.g.a j() {
        if (this.z != null) goto L6;
        this.z = v();
    L6:
        return this.z;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public boolean k() {
        return this.v;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.w
    public com.tom_roush.pdfbox.pdmodel.font.a.c o() {
        if (k() == true) goto L9;
        if (a() == null) goto L9;
        return new com.tom_roush.pdfbox.pdmodel.font.a.j(a());
    L9:
        if (ZeusTransformUtils.instanceOf(this.u, com.tom_roush.fontbox.a.class) == false) goto L13;
        return com.tom_roush.pdfbox.pdmodel.font.a.j.a(((com.tom_roush.fontbox.a) ZeusTransformUtils.preCheckCast(this.u, com.tom_roush.fontbox.a.class, "com.obric.memorydata.plugin")).a());
    L13:
        return com.tom_roush.pdfbox.pdmodel.font.a.h.c;
    }

    public final String u() {
        return this.f16248b.g(com.tom_roush.pdfbox.a.i.Q);
    }
}
