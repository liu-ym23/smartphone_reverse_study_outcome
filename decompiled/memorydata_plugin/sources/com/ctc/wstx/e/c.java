package com.ctc.wstx.e;

import com.ctc.wstx.io.WstxInputLocation;
import com.ctc.wstx.io.l;
import com.ctc.wstx.io.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class c extends a {
    protected final javax.xml.stream.a d;
    final char[] e;
    String f;

    public c(javax.xml.stream.a r3, String r4, URL r5, char[] r6, javax.xml.stream.a r7) {
        javax.xml.stream.a r8 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        javax.xml.stream.a r9 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r7, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        super(r8, r4, r5);
        this.f = null;
        this.e = r6;
        this.d = r9;
    }

    public static c a(String r0, String r1) {
        return a(r0, r1.toCharArray());
    }

    public static c a(String r7, char[] r8) {
        WstxInputLocation r5 = WstxInputLocation.getEmptyLocation();
        return new c(r5, r7, null, r8, r5);
    }

    @Override // com.ctc.wstx.e.a
    public v a(v r8, javax.xml.stream.d r9, com.ctc.wstx.a.b r10, int r11) {
        javax.xml.stream.d r12 = (javax.xml.stream.d) ZeusTransformUtils.wrapperContextForParams(r9, javax.xml.stream.d.class, "com.obric.memorydata.plugin");
        String r1 = this.f3505a;
        char[] r2 = this.e;
        return l.a(r8, r1, r2, 0, r2.length, this.d, null);
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String d() {
        return null;
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String e() {
        return null;
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String f() {
        if (this.f != null) goto L10;
        if (this.e.length != 0) goto L7;
        String r0 = "";
    L8:
        this.f = r0;
        goto L10
    L7:
        r0 = new String(this.e);
    L10:
        return this.f;
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String g() {
        return null;
    }

    @Override // com.ctc.wstx.e.a
    public char[] i() {
        return this.e;
    }

    @Override // com.ctc.wstx.e.a
    public boolean j() {
        return false;
    }

    @Override // com.ctc.wstx.e.a
    public boolean k() {
        return true;
    }
}
