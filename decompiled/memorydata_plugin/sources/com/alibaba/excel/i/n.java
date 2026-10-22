package com.alibaba.excel.i;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final org.slf4j.c f218a = null;

    static {
        f218a = org.slf4j.d.a(n.class);
    }

    private n() {
    }

    public static com.alibaba.excel.h.c.b a(com.alibaba.excel.h.c.b r8, com.alibaba.excel.e.a r9) {
        com.alibaba.excel.e.a r10 = (com.alibaba.excel.e.a) ZeusTransformUtils.wrapperContextForParams(r9, com.alibaba.excel.e.a.class, "com.obric.memorydata.plugin");
        com.alibaba.excel.h.c.a.e r0 = r10.a();
        if (r0.E().booleanValue() == false) goto L5;
        return r8;
    L5:
        Iterator<com.alibaba.excel.h.c.b> r1 = r0.D().iterator();
    L7:
        if (r1.hasNext() == false) goto L44;
        com.alibaba.excel.h.c.b r2 = (com.alibaba.excel.h.c.b) ZeusTransformUtils.preCheckCast(r1.next(), com.alibaba.excel.h.c.b.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        boolean r4 = false;
        if (r2.k() != null) goto L20;
        if (r2.l() != null) goto L20;
        org.slf4j.c r3 = f218a;
        if (r3.isDebugEnabled() == false) goto L18;
        r3.debug("The first is read by default.");
    L18:
        r2.b(0);
    L20:
        if (r2.k() != null) goto L22;
    L24:
        boolean r5 = false;
    L25:
        if (r5 == true) goto L41;
        String r6 = r2.l();
        if (o.a(r6) == true) goto L41;
        if (r2.d() == null) goto L33;
        if (r2.d().booleanValue() == false) goto L33;
    L36:
        r4 = true;
    L37:
        String r7 = r8.l();
        if (r4 == false) goto L40;
        r6 = r6.trim();
        r7 = r7.trim();
    L40:
        r5 = r6.equals(r7);
    L33:
        if (r2.d() != null) goto L37;
        if (r10.a().f().a().booleanValue() == false) goto L37;
    L41:
        if (r5 == false) goto L7;
        r8.a(r2);
        return r8;
    L22:
        if (r2.k().equals(r8.k()) == false) goto L24;
        r5 = true;
        goto L25
    L44:
        return null;
    }
}
