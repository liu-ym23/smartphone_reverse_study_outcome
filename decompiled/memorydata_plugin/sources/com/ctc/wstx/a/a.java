package com.ctc.wstx.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final HashMap<String, Integer> f3446a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected boolean f3447b;

    static {
        HashMap<String, Integer> r0 = new HashMap(16);
        f3446a = r0;
        r0.put("org.codehaus.stax2.implName", 1);
        r0.put("org.codehaus.stax2.implVersion", 2);
        r0.put("org.codehaus.stax2.supportsXml11", 3);
        r0.put("org.codehaus.stax2.supportXmlId", 4);
        r0.put("com.ctc.wstx.returnNullForDefaultNamespace", 5);
        r0.put("http://java.sun.com/xml/stream/properties/implementation-name", 1);
    }

    public a(a r1) {
        if (r1 != null) goto L5;
        boolean r2 = Boolean.getBoolean("com.ctc.wstx.returnNullForDefaultNamespace");
    L6:
        this.f3447b = r2;
        return;
    L5:
        r2 = r1.f3447b;
        goto L6
    }

    public void a(String r3) {
        throw new IllegalArgumentException("Unrecognized property '" + r3 + "'");
    }

    public boolean a() {
        return this.f3447b;
    }

    public abstract boolean a(String r1, int r2, Object r3);

    public boolean a(String r2, Object r3) {
        int r0 = b(r2);
        if (r0 >= 0) goto L5;
        int r1 = c(r2);
        if (r1 >= 0) goto L11;
        a(r2);
        return false;
    L11:
        return b(r2, r1, r3);
    L5:
        return a(r2, r0, r3);
    }

    public abstract int b(String r1);

    public boolean b(String r2, int r3, Object r4) {
        if (r3 == 5) goto L6;
        return false;
    L6:
        this.f3447b = com.ctc.wstx.util.a.a(r2, r4);
        return true;
    }

    public int c(String r2) {
        Integer r1 = (Integer) ZeusTransformUtils.preCheckCast(f3446a.get(r2), Integer.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L6;
        return -1;
    L6:
        return r1.intValue();
    }
}
