package com.tom_roush.pdfbox.pdmodel.interactive.b.a;

import com.tom_roush.pdfbox.a.i;
import com.tom_roush.pdfbox.a.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.IOException;

/* JADX INFO: loaded from: classes6.dex */
public abstract class a implements com.tom_roush.pdfbox.pdmodel.common.d {
    public a() {
    }

    public static a a(com.tom_roush.pdfbox.a.b r4) {
        if (r4 != null) goto L5;
        return null;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, com.tom_roush.pdfbox.a.a.class) == false) goto L37;
        if (((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).b() <= 1) goto L37;
        if (ZeusTransformUtils.instanceOf(((com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin")).a(1), i.class) == false) goto L37;
        com.tom_roush.pdfbox.a.a r5 = (com.tom_roush.pdfbox.a.a) ZeusTransformUtils.preCheckCast(r4, com.tom_roush.pdfbox.a.a.class, "com.obric.memorydata.plugin");
        i r0 = (i) ZeusTransformUtils.preCheckCast(r5.a(1), i.class, "com.obric.memorydata.plugin");
        String r1 = r0.a();
        if (r1.equals("Fit") == false) goto L13;
    L35:
        a r2 = new d(r5);
    L46:
        return r2;
    L13:
        if (r1.equals("FitB") == true) goto L35;
        if (r1.equals("FitV") == false) goto L18;
    L34:
        r2 = new e(r5);
        goto L46
    L18:
        if (r1.equals("FitBV") == true) goto L34;
        if (r1.equals("FitR") == false) goto L24;
        r2 = new f(r5);
        goto L46
    L24:
        if (r1.equals("FitH") == false) goto L26;
    L33:
        r2 = new g(r5);
        goto L46
    L26:
        if (r1.equals("FitBH") == true) goto L33;
        if (r1.equals("XYZ") == false) goto L32;
        r2 = new h(r5);
        goto L46
    L32:
        throw new IOException("Unknown destination type: " + r0.a());
    L37:
        if (ZeusTransformUtils.instanceOf(r4, o.class) == false) goto L41;
        r2 = new b((o) ZeusTransformUtils.preCheckCast(r4, o.class, "com.obric.memorydata.plugin"));
        goto L46
    L41:
        if (ZeusTransformUtils.instanceOf(r4, i.class) == false) goto L45;
        r2 = new b((i) ZeusTransformUtils.preCheckCast(r4, i.class, "com.obric.memorydata.plugin"));
        goto L46
    L45:
        throw new IOException("Error: can't convert to Destination " + r4);
    }
}
