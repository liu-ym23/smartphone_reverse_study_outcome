package com.tom_roush.pdfbox.pdmodel.a.c;

import com.tom_roush.pdfbox.a.b;
import com.tom_roush.pdfbox.a.d;
import com.tom_roush.pdfbox.a.h;
import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.common.c;
import com.tom_roush.pdfbox.pdmodel.graphics.b.e;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class a implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16160a = "S";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final String f16161b = "D";
    private final d c;

    public a() {
        this.c = new d();
    }

    public a(d r1) {
        this.c = r1;
    }

    public d a() {
        return this.c;
    }

    public void a(float r2) {
        this.c.a(i.iY, r2);
    }

    public void a(com.tom_roush.pdfbox.a.a r2) {
        if (r2 != null) goto L5;
        r2 = null;
    L5:
        this.c.a(i.br, r2);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.b.a r2) {
        if (r2 == null) goto L4;
        com.tom_roush.pdfbox.a.a r3 = r2.b();
    L5:
        this.c.a(i.al, r3);
        return;
    L4:
        r3 = null;
        goto L5
    }

    public void a(String r2) {
        this.c.a(i.he, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.a b() {
        com.tom_roush.pdfbox.a.a r0 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(this.c.a(i.al), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L6;
        r0 = new com.tom_roush.pdfbox.a.a();
        r0.a(h.f16054a);
        r0.a(h.f16054a);
        r0.a(h.f16054a);
        this.c.a(i.al, r0);
    L6:
        return new com.tom_roush.pdfbox.pdmodel.graphics.b.a(r0.c(), e.f16265b);
    }

    public float c() {
        return this.c.b(i.iY, 1.0f);
    }

    public String d() {
        return this.c.c(i.he, "S");
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ b e() {
        return a();
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b f() {
        com.tom_roush.pdfbox.a.a r0 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(this.c.a(i.br), com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        r0 = new com.tom_roush.pdfbox.a.a();
        r0.a(h.d);
        this.c.a(i.br, r0);
    L5:
        com.tom_roush.pdfbox.a.a r3 = new com.tom_roush.pdfbox.a.a();
        r3.a(r0);
        return new com.tom_roush.pdfbox.pdmodel.graphics.b(r3, 0);
    }
}
