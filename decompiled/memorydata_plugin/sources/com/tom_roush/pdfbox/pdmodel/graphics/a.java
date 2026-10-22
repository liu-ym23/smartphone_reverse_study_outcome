package com.tom_roush.pdfbox.pdmodel.graphics;

import com.tom_roush.pdfbox.a.f;
import com.tom_roush.pdfbox.a.k;
import com.tom_roush.pdfbox.pdmodel.font.p;
import com.tom_roush.pdfbox.pdmodel.font.r;
import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes6.dex */
public class a implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tom_roush.pdfbox.a.a f16256a;

    public a() {
        this.f16256a = null;
        com.tom_roush.pdfbox.a.a r1 = new com.tom_roush.pdfbox.a.a();
        this.f16256a = r1;
        r1.a(null);
        this.f16256a.a(new f(1.0f));
    }

    public a(com.tom_roush.pdfbox.a.a r2) {
        this.f16256a = null;
        this.f16256a = r2;
    }

    public p a() {
        com.tom_roush.pdfbox.a.b r2 = this.f16256a.a(0);
        if (ZeusTransformUtils.instanceOf(r2, com.tom_roush.pdfbox.a.d.class) == true) goto L7;
        return null;
    L7:
        return r.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r2, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }

    public float b() {
        return ((k) ZeusTransformUtils.preCheckCast(this.f16256a.b(1), k.class, "com.obric.memorydata.plugin")).a();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public com.tom_roush.pdfbox.a.b e() {
        return this.f16256a;
    }
}
