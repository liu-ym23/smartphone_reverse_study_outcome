package com.ctc.wstx.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends org.codehaus.stax2.b.a.a implements javax.xml.stream.a.a {
    public a(javax.xml.stream.a r3) {
        super((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin"));
    }

    public abstract String b();

    public abstract String c();

    public abstract String d();

    public abstract String e();

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, javax.xml.stream.a.a.class) == true) goto L11;
        return false;
    L11:
        javax.xml.stream.a.a r6 = (javax.xml.stream.a.a) ZeusTransformUtils.preCheckCast(r5, javax.xml.stream.a.a.class, "com.obric.memorydata.plugin");
        if (b(c(), r6.c()) == false) goto L25;
        if (b(b(), r6.b()) == false) goto L25;
        if (b(d(), r6.d()) == false) goto L25;
        if (b(e(), r6.e()) == false) goto L25;
        if (b(f(), r6.f()) == false) goto L25;
        if (b(g(), r6.g()) == false) goto L25;
        return true;
    L25:
        return false;
    }

    public abstract String f();

    public abstract String g();

    public int hashCode() {
        return c().hashCode();
    }

    @Override // org.codehaus.stax2.b.a.a
    public int l() {
        return 15;
    }
}
