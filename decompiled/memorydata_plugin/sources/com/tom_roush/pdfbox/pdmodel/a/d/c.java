package com.tom_roush.pdfbox.pdmodel.a.d;

import com.tom_roush.pdfbox.a.j;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class c implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.a f16164a;

    public c() {
        com.tom_roush.pdfbox.a.a r0 = new com.tom_roush.pdfbox.a.a();
        this.f16164a = r0;
        r0.a(j.f16062b);
        r0.a(j.f16062b);
        r0.a(j.f16062b);
        r0.a(j.f16062b);
    }

    public c(com.tom_roush.pdfbox.a.a r4) {
        this.f16164a = r4;
        if (r4.b() >= 4) goto L7;
        int r5 = r4.b() - 1;
    L5:
        if (r5 >= 4) goto L9;
        this.f16164a.a(j.f16062b);
        r5 = r5 + 1;
        goto L5
    L9:
        return;
    }

    private com.tom_roush.pdfbox.pdmodel.graphics.b.f a(int r3) {
        com.tom_roush.pdfbox.a.b r2 = this.f16164a.a(r3);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.a.class) == true) goto L7;
        return null;
    L7:
        return new com.tom_roush.pdfbox.pdmodel.graphics.b.f((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin"));
    }

    private void a(int r1, com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        if (r2 != null) goto L4;
        com.tom_roush.pdfbox.a.b r3 = j.f16062b;
    L5:
        this.f16164a.b(r1, r3);
        return;
    L4:
        r3 = r2.a();
        goto L5
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f a() {
        return a(0);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(0, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f b() {
        return a(1);
    }

    public void b(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(1, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f c() {
        return a(2);
    }

    public void c(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(2, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.graphics.b.f d() {
        return a(3);
    }

    public void d(com.tom_roush.pdfbox.pdmodel.graphics.b.f r2) {
        a(3, r2);
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return this.f16164a;
    }
}
