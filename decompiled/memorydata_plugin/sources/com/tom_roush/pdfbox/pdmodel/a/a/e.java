package com.tom_roush.pdfbox.pdmodel.a.a;

import com.tom_roush.pdfbox.a.n;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class e implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f16147a = "OBJR";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final com.tom_roush.pdfbox.a.d f16148b;

    public e() {
        com.tom_roush.pdfbox.a.d r0 = new com.tom_roush.pdfbox.a.d();
        this.f16148b = r0;
        r0.a(com.tom_roush.pdfbox.a.i.iz, f16147a);
    }

    public e(com.tom_roush.pdfbox.a.d r1) {
        this.f16148b = r1;
    }

    public com.tom_roush.pdfbox.a.d a() {
        return this.f16148b;
    }

    public void a(com.tom_roush.pdfbox.pdmodel.graphics.d r2) {
        a().a(com.tom_roush.pdfbox.a.i.fu, r2);
    }

    public void a(com.tom_roush.pdfbox.pdmodel.interactive.annotation.a r2) {
        a().a(com.tom_roush.pdfbox.a.i.fu, r2);
    }

    public com.tom_roush.pdfbox.pdmodel.common.c b() {
        com.tom_roush.pdfbox.a.b r4 = a().a(com.tom_roush.pdfbox.a.i.fu);
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.d.class) == true) goto L17;
        return null;
    L17:
        if (ZeusTransformUtils.instanceOf(r4, n.class) == false) goto L10;
        com.tom_roush.pdfbox.pdmodel.graphics.d r0 = com.tom_roush.pdfbox.pdmodel.graphics.d.a(r4, null);     // Catch: IOException -> L16
        if (r0 == null) goto L10;
        return r0;
    L10:
        com.tom_roush.pdfbox.a.d r1 = (com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin");     // Catch: IOException -> L16
        com.tom_roush.pdfbox.pdmodel.interactive.annotation.a r5 = com.tom_roush.pdfbox.pdmodel.interactive.annotation.a.a(r4);     // Catch: IOException -> L16
        if (ZeusTransformUtils.instanceOf(r5, com.tom_roush.pdfbox.pdmodel.interactive.annotation.k.class) == false) goto L14;
        if (com.tom_roush.pdfbox.a.i.u.equals(r1.a(com.tom_roush.pdfbox.a.i.iz)) == false) goto L15;
    L14:
        return r5;
    L15:
        return null;
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return a();
    }
}
