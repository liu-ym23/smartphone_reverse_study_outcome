package com.tom_roush.pdfbox.pdmodel.font;

import android.util.Log;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes6.dex */
public abstract class w extends p {
    protected com.tom_roush.pdfbox.pdmodel.font.a.c c;
    protected com.tom_roush.pdfbox.pdmodel.font.a.d d;
    private Boolean e;
    private final Set<Integer> f;

    w() {
        this.f = new HashSet();
    }

    w(com.tom_roush.pdfbox.a.d r1) {
        super(r1);
        this.f = new HashSet();
    }

    w(String r2) {
        super(r2);
        this.f = new HashSet();
        a(r2);
    }

    private void a(String r2) {
        if ("ZapfDingbats".equals(r2) == false) goto L5;
        com.tom_roush.pdfbox.pdmodel.font.a.d r3 = com.tom_roush.pdfbox.pdmodel.font.a.d.b();
    L6:
        this.d = r3;
        return;
    L5:
        r3 = com.tom_roush.pdfbox.pdmodel.font.a.d.a();
        goto L6
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public String a(int r5, com.tom_roush.pdfbox.pdmodel.font.a.d r6) {
        if (this.d == com.tom_roush.pdfbox.pdmodel.font.a.d.a()) goto L6;
        r6 = this.d;
    L6:
        String r0 = super.e(r5);
        if (r0 == null) goto L9;
        return r0;
    L9:
        com.tom_roush.pdfbox.pdmodel.font.a.c r1 = this.c;
        if (r1 == null) goto L14;
        String r2 = r1.a(r5);
        String r7 = r6.a(r2);
        if (r7 == null) goto L16;
        return r7;
    L16:
        if (this.f.contains(Integer.valueOf(r5)) == true) goto L22;
        this.f.add(Integer.valueOf(r5));
        if (r2 == null) goto L20;
        StringBuilder r8 = new StringBuilder().append("No Unicode mapping for ").append(r2).append(" (").append(r5);
        String r3 = ") in font ";
    L21:
        Log.w("PdfBox-Android", r8.append(r3).append(c()).toString());
        goto L22
    L20:
        r8 = new StringBuilder().append("No Unicode mapping for character code ").append(r5);
        r3 = " in font ";
    L22:
        return null;
    L14:
        r2 = null;
        goto L16
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public final float d(int r2) {
        if (a() == null) goto L17;
        String r3 = p().a(r2);
        if (".notdef".equals(r3) == false) goto L9;
        return 250.0f;
    L9:
        if ("nbspace".equals(r3) == false) goto L12;
        r3 = "space";
    L15:
        return a().a(r3);
    L12:
        if ("sfthyphen".equals(r3) == false) goto L15;
        r3 = "hyphen";
        goto L15
    L17:
        throw new IllegalStateException("No AFM");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public String e(int r2) {
        return a(r2, com.tom_roush.pdfbox.pdmodel.font.a.d.a());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public boolean l() {
        return false;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.font.p
    public boolean m() {
        if (ZeusTransformUtils.instanceOf(p(), com.tom_roush.pdfbox.pdmodel.font.a.b.class) == false) goto L14;
        com.tom_roush.pdfbox.pdmodel.font.a.b r0 = (com.tom_roush.pdfbox.pdmodel.font.a.b) ZeusTransformUtils.preCheckCast(p(), com.tom_roush.pdfbox.pdmodel.font.a.b.class, "com.obric.memorydata.plugin");
        if (r0.b().size() <= 0) goto L14;
        com.tom_roush.pdfbox.pdmodel.font.a.c r1 = r0.a();
        Iterator<Map.Entry<Integer, String>> r2 = r0.b().entrySet().iterator();
    L8:
        if (r2.hasNext() == false) goto L14;
        Map.Entry r3 = (Map.Entry) ZeusTransformUtils.preCheckCast(r2.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        if (((String) ZeusTransformUtils.preCheckCast(r3.getValue(), String.class, "com.obric.memorydata.plugin")).equals(r1.a(((Integer) ZeusTransformUtils.preCheckCast(r3.getKey(), Integer.class, "com.obric.memorydata.plugin")).intValue())) == true) goto L8;
        return false;
    L14:
        return super.m();
    }

    public void n() {
        com.tom_roush.pdfbox.a.b r0 = this.f16248b.a(com.tom_roush.pdfbox.a.i.cy);
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.i.class) == false) goto L8;
        com.tom_roush.pdfbox.a.i r1 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.pdmodel.font.a.c r2 = com.tom_roush.pdfbox.pdmodel.font.a.c.a(r1);
        this.c = r2;
        if (r2 != null) goto L23;
        Log.w("PdfBox-Android", "Unknown encoding: " + r1.a());
    L22:
        this.c = o();
    L23:
        a(ae.c(c()));
        return;
    L8:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.d.class) == false) goto L22;
        com.tom_roush.pdfbox.a.d r3 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");
        com.tom_roush.pdfbox.pdmodel.font.a.c r4 = null;
        Boolean r5 = t();
        com.tom_roush.pdfbox.a.i r6 = r3.b(com.tom_roush.pdfbox.a.i.P);
        if (r6 != null) goto L12;
    L14:
        boolean r7 = false;
    L15:
        if (r7 == false) goto L17;
    L19:
        if (r5 != null) goto L21;
        r5 = false;
    L21:
        this.c = new com.tom_roush.pdfbox.pdmodel.font.a.b(r3, !r5.booleanValue(), r4);
        goto L23
    L17:
        if (Boolean.TRUE.equals(r5) == false) goto L19;
        r4 = o();
        goto L19
    L12:
        if (com.tom_roush.pdfbox.pdmodel.font.a.c.a(r6) == null) goto L14;
        r7 = true;
        goto L15
    }

    public abstract com.tom_roush.pdfbox.pdmodel.font.a.c o();

    public com.tom_roush.pdfbox.pdmodel.font.a.c p() {
        return this.c;
    }

    public com.tom_roush.pdfbox.pdmodel.font.a.d q() {
        return this.d;
    }

    public final boolean r() {
        if (this.e != null) goto L10;
        boolean r0 = s();
        if (r0 != null) goto L8;
        r0 = true;
    L8:
        this.e = r0;
    L10:
        return this.e.booleanValue();
    }

    public Boolean s() {
        Boolean r0 = t();
        if (r0 == null) goto L5;
        return r0;
    L5:
        boolean r1 = false;
        if (m() == false) goto L14;
        String r5 = ae.c(c());
        if (r5.equals("Symbol") == false) goto L10;
    L11:
        r1 = true;
    L13:
        return Boolean.valueOf(r1);
    L10:
        if (r5.equals("ZapfDingbats") == false) goto L13;
    L14:
        com.tom_roush.pdfbox.pdmodel.font.a.c r2 = this.c;
        if (r2 != null) goto L23;
        if (ZeusTransformUtils.instanceOf(this, x.class) == false) goto L21;
        return true;
    L21:
        throw new IllegalStateException("PDFBox bug: encoding should not be null!");
    L23:
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.pdmodel.font.a.k.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(this.c, com.tom_roush.pdfbox.pdmodel.font.a.g.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(this.c, com.tom_roush.pdfbox.pdmodel.font.a.h.class) == true) goto L50;
        if (ZeusTransformUtils.instanceOf(this.c, com.tom_roush.pdfbox.pdmodel.font.a.b.class) == false) goto L47;
        Iterator<String> r6 = ((com.tom_roush.pdfbox.pdmodel.font.a.b) ZeusTransformUtils.preCheckCast(this.c, com.tom_roush.pdfbox.pdmodel.font.a.b.class, "com.obric.memorydata.plugin")).b().values().iterator();
    L33:
        if (r6.hasNext() == false) goto L46;
        String r3 = (String) ZeusTransformUtils.preCheckCast(r6.next(), String.class, "com.obric.memorydata.plugin");
        if (".notdef".equals(r3) == true) goto L33;
        if (com.tom_roush.pdfbox.pdmodel.font.a.k.c.a(r3) == false) goto L44;
        if (com.tom_roush.pdfbox.pdmodel.font.a.g.d.a(r3) == false) goto L44;
        if (com.tom_roush.pdfbox.pdmodel.font.a.h.c.a(r3) == true) goto L33;
    L44:
        return true;
    L46:
        return false;
    L47:
        return null;
    L50:
        return false;
    }

    public final Boolean t() {
        if (b() != null) goto L5;
        return null;
    L5:
        return Boolean.valueOf(b().c());
    }
}
