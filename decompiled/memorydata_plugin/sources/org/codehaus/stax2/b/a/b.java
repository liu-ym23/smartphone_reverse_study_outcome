package org.codehaus.stax2.b.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class b extends a implements org.codehaus.stax2.a.a {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f17987b;
    final String c;
    final String d;

    public b(javax.xml.stream.a r3, String r4, String r5, String r6) {
        super((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin"));
        this.f17987b = r4;
        this.c = r5;
        this.d = r6;
    }

    public String a() {
        return "";
    }

    @Override // javax.xml.stream.a.b
    public String b() {
        return this.f17987b;
    }

    @Override // javax.xml.stream.a.b
    public String c() {
        return this.c;
    }

    @Override // javax.xml.stream.a.b
    public String d() {
        return this.d;
    }

    public boolean equals(Object r5) {
        if (r5 != this) goto L6;
        return true;
    L6:
        if (r5 != null) goto L9;
        return false;
    L9:
        if (ZeusTransformUtils.instanceOf(r5, org.codehaus.stax2.a.a.class) == true) goto L11;
        return false;
    L11:
        org.codehaus.stax2.a.a r6 = (org.codehaus.stax2.a.a) ZeusTransformUtils.preCheckCast(r5, org.codehaus.stax2.a.a.class, "com.obric.memorydata.plugin");
        if (b(b(), r6.b()) == false) goto L21;
        if (b(c(), r6.c()) == false) goto L21;
        if (b(d(), r6.d()) == false) goto L21;
        if (b(a(), r6.a()) == false) goto L21;
        return true;
    L21:
        return false;
    }

    public int hashCode() {
        String r0 = this.f17987b;
        int r1 = 0;
        if (r0 == null) goto L5;
        r1 = 0 ^ r0.hashCode();
    L5:
        String r2 = this.c;
        if (r2 == null) goto L8;
        r1 = r1 ^ r2.hashCode();
    L8:
        String r3 = this.d;
        if (r3 != null) goto L11;
        return r1;
    L11:
        return r1 ^ r3.hashCode();
    }

    @Override // org.codehaus.stax2.b.a.a
    public int l() {
        return 14;
    }
}
