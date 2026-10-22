package com.tom_roush.pdfbox.pdmodel.common;

import com.tom_roush.pdfbox.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;

/* JADX INFO: loaded from: classes6.dex */
public class i implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n f16191a;

    public i(n r1) {
        this.f16191a = r1;
    }

    public com.tom_roush.pdfbox.a.g a(com.tom_roush.pdfbox.filter.h r1) {
        return this.f16191a.a(r1);
    }

    public n a() {
        return this.f16191a;
    }

    public com.tom_roush.pdfbox.a.g b() {
        return this.f16191a.h();
    }

    public int c() {
        return this.f16191a.b(com.tom_roush.pdfbox.a.i.ew, 0);
    }

    public List<com.tom_roush.pdfbox.a.i> d() {
        com.tom_roush.pdfbox.a.b r0 = this.f16191a.k();
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.i.class) == false) goto L6;
        com.tom_roush.pdfbox.a.i r1 = (com.tom_roush.pdfbox.a.i) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.i.class, "com.obric.memorydata.plugin");
        return new a(r1, r1, this.f16191a, com.tom_roush.pdfbox.a.i.cT);
    L6:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.a.a.class) == true) goto L11;
        return null;
    L11:
        return ((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).d();
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }

    public byte[] f() {
        com.tom_roush.pdfbox.a.g r1 = b();     // Catch: Throwable -> L9
        byte[] r0 = com.tom_roush.pdfbox.io.a.a(r1);     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        r1.close();
    L6:
        return r0;
    L7:
        th = th;
    L11:
        if (r1 == null) goto L13;
        r1.close();
    L13:
        throw th;
    L9:
        th = th;
        r1 = null;
        goto L11
    }
}
