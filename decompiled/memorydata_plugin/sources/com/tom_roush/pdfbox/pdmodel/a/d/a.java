package com.tom_roush.pdfbox.pdmodel.a.d;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class a extends com.tom_roush.pdfbox.pdmodel.a.b.a {
    public a(com.tom_roush.pdfbox.a.d r2) {
        super(com.tom_roush.pdfbox.a.i.D, r2);
    }

    private boolean a(String r4) {
        com.tom_roush.pdfbox.a.a r3 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(b().a(com.tom_roush.pdfbox.a.i.K), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r3 == null) goto L12;
        int r1 = 0;
    L6:
        if (r1 >= r3.b()) goto L12;
        if (r4.equals(r3.d(r1)) == true) goto L9;
        r1 = r1 + 1;
        goto L6
    L9:
        return true;
    L12:
        return false;
    }

    public String getType() {
        return b().g(com.tom_roush.pdfbox.a.i.iz);
    }

    public com.tom_roush.pdfbox.pdmodel.common.h i() {
        com.tom_roush.pdfbox.a.a r2 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(b().a(com.tom_roush.pdfbox.a.i.S), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.common.h(r2);
    }

    public boolean j() {
        return a("Top");
    }

    public boolean k() {
        return a("Bottom");
    }

    public boolean l() {
        return a("Left");
    }

    public boolean m() {
        return a("Right");
    }

    public String n() {
        return b().g(com.tom_roush.pdfbox.a.i.hT);
    }
}
