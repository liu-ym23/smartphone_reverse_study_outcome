package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.tom_roush.fontbox.f.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class x extends w {
    private static final Map<String, Integer> e = null;
    private com.tom_roush.fontbox.f.d f;
    private com.tom_roush.fontbox.f.d g;
    private com.tom_roush.fontbox.f.d h;
    private boolean i;
    private final ah j;
    private final boolean k;
    private final boolean l;
    private com.tom_roush.fontbox.g.a m;

    static {
        e = new HashMap(ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION);
        Iterator<Map.Entry<Integer, String>> r0 = com.tom_roush.pdfbox.pdmodel.font.a.f.c.c().entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L8;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        Map<String, Integer> r2 = e;
        if (r2.containsKey(r1.getValue()) == true) goto L4;
        Object r3 = r1.getValue();
        r2.put((String) r3, (Integer) r1.getKey());
        goto L4
    }

    public x(com.tom_roush.pdfbox.a.d r8) {
        super(r8);
        ah r9 = null;
        this.f = null;
        this.g = null;
        this.h = null;
        boolean r0 = false;
        this.i = false;
        if (b() == null) goto L14;
        com.tom_roush.pdfbox.pdmodel.common.i r1 = super.b().q();
        if (r1 == null) goto L14;
        com.tom_roush.fontbox.f.ae r4 = new com.tom_roush.fontbox.f.ae(true);     // Catch: IOException -> L11
        com.tom_roush.pdfbox.a.g r2 = r1.b();     // Catch: IOException -> L11
        r9 = r4.b(r2);     // Catch: IOException -> L9
    L9:
        e = e;
    L13:
        Log.w("PdfBox-Android", "Could not read embedded TTF for font " + u(), e);
        com.tom_roush.pdfbox.io.a.a(r2);
        boolean r3 = true;
    L15:
        if (r9 == null) goto L17;
        r0 = true;
    L17:
        this.k = r0;
        this.l = r3;
        if (r9 != null) goto L23;
        j<ah> r10 = i.a().a(u(), b());
        ah r5 = (ah) ZeusTransformUtils.preCheckCast(r10.c(), ah.class, "com.obric.memorydata.plugin");
        if (r10.d() == false) goto L22;
        Log.w("PdfBox-Android", "Using fallback font '" + r5 + "' for '" + u() + "'");
    L22:
        r9 = r5;
    L23:
        this.j = r9;
        n();
        return;
    L11:
        e = e;
        r2 = null;
    L14:
        r3 = false;
        goto L15
    }

    private com.tom_roush.fontbox.g.a w() {
        if (b() == null) goto L9;
        com.tom_roush.pdfbox.pdmodel.common.h r0 = b().k();
        if (r0 == null) goto L9;
        return new com.tom_roush.fontbox.g.a(r0.b(), r0.c(), r0.d(), r0.f());
    L9:
        return this.j.c();
    }

    private void x() {
        if (this.i == false) goto L5;
        return;
    L5:
        com.tom_roush.fontbox.f.e r0 = this.j.q();
        if (r0 == null) goto L33;
        com.tom_roush.fontbox.f.d[] r1 = r0.a();
        int r2 = r1.length;
        int r3 = 0;
    L8:
        if (r3 >= r2) goto L33;
        com.tom_roush.fontbox.f.d r4 = r1[r3];
        if (3 != r4.b()) goto L18;
        if (1 != r4.a()) goto L15;
    L13:
        this.f = r4;
    L32:
        r3 = r3 + 1;
        goto L8
    L15:
        if (r4.a() != 0) goto L32;
        this.g = r4;
        goto L32
    L18:
        if (1 != r4.b()) goto L23;
        if (r4.a() != 0) goto L23;
        this.h = r4;
    L23:
        if (r4.b() != 0) goto L28;
        if (r4.a() == 0) goto L13;
    L28:
        if (r4.b() != 0) goto L32;
        if (3 != r4.a()) goto L32;
    L33:
        this.i = true;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public int a(InputStream r1) {
        return r1.read();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public String c() {
        return u();
    }

    public int f(int r5) {
        x();
        int r2 = 0;
        if (r() == true) goto L21;
        String r6 = this.c.a(r5);
        if (".notdef".equals(r6) == false) goto L8;
        return 0;
    L8:
        if (this.f == null) goto L12;
        String r0 = com.tom_roush.pdfbox.pdmodel.font.a.d.a().a(r6);
        if (r0 == null) goto L12;
        int r1 = r0.codePointAt(0);
        r2 = this.f.a(r1);
    L12:
        if (r2 == 0) goto L14;
    L18:
        if (r2 == 0) goto L53;
        return r2;
    L53:
        return this.j.d(r6);
    L14:
        if (this.h == null) goto L18;
        Integer r3 = (Integer) ZeusTransformUtils.preCheckCast(e.get(r6), Integer.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L18;
        r2 = this.h.a(r3.intValue());
        goto L18
    L21:
        if (this.f != null) goto L23;
    L34:
        com.tom_roush.fontbox.f.d r4 = this.g;
        if (r4 == null) goto L47;
        int r7 = r4.a(r5);
        if (r5 >= 0) goto L39;
    L46:
        r2 = r7;
        goto L47
    L39:
        if (r5 > 255) goto L46;
        if (r7 != 0) goto L42;
        r7 = this.g.a(61440 + r5);
    L42:
        if (r7 != 0) goto L44;
        r7 = this.g.a(61696 + r5);
    L44:
        if (r7 != 0) goto L46;
        r7 = this.g.a(61952 + r5);
    L47:
        if (r2 != 0) goto L54;
        com.tom_roush.fontbox.f.d r8 = this.h;
        if (r8 != null) goto L51;
        return r2;
    L51:
        return r8.a(r5);
    L54:
        return r2;
    L23:
        if (ZeusTransformUtils.instanceOf(this.c, com.tom_roush.pdfbox.pdmodel.font.a.k.class) == false) goto L25;
    L28:
        String r9 = this.c.a(r5);
        if (".notdef".equals(r9) == false) goto L31;
        return 0;
    L31:
        String r10 = com.tom_roush.pdfbox.pdmodel.font.a.d.a().a(r9);
        if (r10 == null) goto L34;
        int r11 = r10.codePointAt(0);
        r2 = this.f.a(r11);
        goto L34
    L25:
        if (ZeusTransformUtils.instanceOf(this.c, com.tom_roush.pdfbox.pdmodel.font.a.g.class) == true) goto L28;
        r2 = this.f.a(r5);
        goto L34
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public float g(int r3) {
        float r4 = this.j.a(f(r3));
        float r2 = this.j.v();
        if (r2 != 1000.0f) goto L5;
        return r4;
    L5:
        return r4 * (1000.0f / r2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.s
    public com.tom_roush.fontbox.g.a j() {
        if (this.m != null) goto L6;
        this.m = w();
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
        if (t() != null) goto L11;
    L14:
        String r0 = ae.c(c());
        if (m() == true) goto L17;
    L22:
        com.tom_roush.fontbox.f.z r1 = this.j.j();
        HashMap r2 = new HashMap();
        int r3 = 0;
    L24:
        if (r3 > 256) goto L35;
        int r4 = f(r3);
        if (r4 <= 0) goto L33;
        String r5 = null;
        if (r1 == null) goto L30;
        r5 = r1.a(r4);
    L30:
        if (r5 != null) goto L32;
        r5 = Integer.toString(r4);
    L32:
        r2.put(Integer.valueOf(r3), r5);
    L33:
        r3 = r3 + 1;
        goto L24
    L35:
        return new com.tom_roush.pdfbox.pdmodel.font.a.a(r2);
    L17:
        if (r0.equals("Symbol") == true) goto L22;
        if (r0.equals("ZapfDingbats") == true) goto L22;
        return com.tom_roush.pdfbox.pdmodel.font.a.h.c;
    L11:
        if (t().booleanValue() == true) goto L14;
        return com.tom_roush.pdfbox.pdmodel.font.a.h.c;
    }

    public final String u() {
        return this.f16248b.g(com.tom_roush.pdfbox.a.i.Q);
    }

    public ah v() {
        return this.j;
    }
}
