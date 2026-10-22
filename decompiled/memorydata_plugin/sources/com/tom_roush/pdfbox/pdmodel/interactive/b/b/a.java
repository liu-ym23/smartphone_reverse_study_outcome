package com.tom_roush.pdfbox.pdmodel.interactive.b.b;

import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.pdmodel.c;
import com.tom_roush.pdfbox.pdmodel.g;
import com.tom_roush.pdfbox.pdmodel.interactive.action.d;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public final class a extends b {
    public g a(c r5) {
        com.tom_roush.pdfbox.pdmodel.interactive.b.a.a r0 = b();
        if (r0 != null) goto L8;
        com.tom_roush.pdfbox.pdmodel.interactive.action.a r4 = c();
        if (ZeusTransformUtils.instanceOf(r4, d.class) == false) goto L8;
        r0 = ((d) ZeusTransformUtils.preCheckCast(r4, d.class, "com.obric.memorydata.plugin")).b();
    L8:
        if (r0 != null) goto L11;
        return null;
    L11:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.pdmodel.interactive.b.a.b.class) == false) goto L16;
        com.tom_roush.pdfbox.pdmodel.interactive.b.a.c r1 = r5.b().a((com.tom_roush.pdfbox.pdmodel.interactive.b.a.b) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.pdmodel.interactive.b.a.b.class, "com.obric.memorydata.plugin"));
        if (r1 != null) goto L18;
        return null;
    L18:
        g r6 = r1.a();
        if (r6 != null) goto L26;
        int r2 = r1.b();
        if (r2 != (-1)) goto L23;
        return r6;
    L23:
        return r5.a(r2);
    L26:
        return r6;
    L16:
        if (ZeusTransformUtils.instanceOf(r0, com.tom_roush.pdfbox.pdmodel.interactive.b.a.c.class) == false) goto L25;
        r1 = (com.tom_roush.pdfbox.pdmodel.interactive.b.a.c) ZeusTransformUtils.preCheckCast(r0, com.tom_roush.pdfbox.pdmodel.interactive.b.a.c.class, "com.obric.memorydata.plugin");
        goto L18
    L25:
        throw new IOException("Error: Unknown destination type " + r0);
    }

    public com.tom_roush.pdfbox.pdmodel.interactive.b.a.a b() {
        return com.tom_roush.pdfbox.pdmodel.interactive.b.a.a.a(a().a(i.bH));
    }

    public com.tom_roush.pdfbox.pdmodel.interactive.action.a c() {
        return com.tom_roush.pdfbox.pdmodel.interactive.action.c.a((com.tom_roush.pdfbox.a.d) ZeusTransformUtils.preCheckCast(a().a(i.f16057a), com.tom_roush.pdfbox.a.d.class, "com.obric.memorydata.plugin"));
    }
}
