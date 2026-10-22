package com.tom_roush.pdfbox.pdmodel.graphics;

import com.tom_roush.pdfbox.a.n;
import com.tom_roush.pdfbox.pdmodel.common.i;
import com.tom_roush.pdfbox.pdmodel.k;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public class d implements com.tom_roush.pdfbox.pdmodel.common.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final i f16269a;

    public d(n r2, com.tom_roush.pdfbox.a.i r3) {
        this.f16269a = new i(r2);
        r2.a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.ji.a());
        r2.a(com.tom_roush.pdfbox.a.i.hT, r3.a());
    }

    public d(i r3, com.tom_roush.pdfbox.a.i r4) {
        this.f16269a = r3;
        r3.a().a(com.tom_roush.pdfbox.a.i.iz, com.tom_roush.pdfbox.a.i.ji.a());
        r3.a().a(com.tom_roush.pdfbox.a.i.hT, r4.a());
    }

    public static d a(com.tom_roush.pdfbox.a.b r3, com.tom_roush.pdfbox.pdmodel.i r4) {
        k r0 = null;
        if (r3 != null) goto L6;
        return null;
    L6:
        if (ZeusTransformUtils.instanceOf(r3, n.class) == false) goto L30;
        n r5 = (n) ZeusTransformUtils.preCheckCast(r3, n.class, "com.obric.memorydata.plugin");
        String r1 = r5.g(com.tom_roush.pdfbox.a.i.hT);
        if (com.tom_roush.pdfbox.a.i.dR.a().equals(r1) == false) goto L12;
        return new com.tom_roush.pdfbox.pdmodel.graphics.d.b(new i(r5), r4);
    L12:
        if (com.tom_roush.pdfbox.a.i.dn.a().equals(r1) == false) goto L24;
        if (r4 == null) goto L15;
        r0 = r4.c();
    L15:
        com.tom_roush.pdfbox.a.d r6 = r5.d(com.tom_roush.pdfbox.a.i.dw);
        if (r6 == null) goto L22;
        if (com.tom_roush.pdfbox.a.i.is.equals(r6.b(com.tom_roush.pdfbox.a.i.he)) == false) goto L22;
        return new com.tom_roush.pdfbox.pdmodel.graphics.c.b(r5, r0);
    L22:
        return new com.tom_roush.pdfbox.pdmodel.graphics.c.a(r5, r0);
    L24:
        if (com.tom_roush.pdfbox.a.i.gC.a().equals(r1) == false) goto L28;
        return new c(r5);
    L28:
        throw new IOException("Invalid XObject Subtype: " + r1);
    L30:
        throw new IOException("Unexpected object type: " + r3.getClass().getName());
    }

    @Override // com.tom_roush.pdfbox.pdmodel.common.c
    public /* synthetic */ com.tom_roush.pdfbox.a.b e() {
        return k_();
    }

    public final n k_() {
        return this.f16269a.a();
    }

    public final i l_() {
        return this.f16269a;
    }
}
