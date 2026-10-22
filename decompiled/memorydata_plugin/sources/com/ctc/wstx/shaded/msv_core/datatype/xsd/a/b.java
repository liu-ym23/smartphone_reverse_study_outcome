package com.ctc.wstx.shaded.msv_core.datatype.xsd.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b {
    public b() {
    }

    public static b a() {
        String[] r1 = {"com.ctc.wstx.shaded.msv_core.datatype.regexp.InternalImpl", "com.ctc.wstx.shaded.msv_core.datatype.xsd.regex.XercesImpl", "com.ctc.wstx.shaded.msv_core.datatype.xsd.regex.JDKImpl"};
        int r2 = 0;
    L4:
        if (r2 >= 3) goto L10;
        String r3 = r1[r2];
        return (b) ZeusTransformUtils.preCheckCast(b.class.getClassLoader().loadClass(r3).newInstance(), b.class, "com.obric.memorydata.plugin");
    L8:
        r2 = r2 + 1;
        goto L4
    L10:
        throw new Error("no implementation of regexp was found.");
    }

    public abstract a a(String r1);
}
