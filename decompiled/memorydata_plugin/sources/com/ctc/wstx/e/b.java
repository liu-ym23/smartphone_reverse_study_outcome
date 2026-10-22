package com.ctc.wstx.e;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class b extends a {
    final String d;
    final String e;

    public b(javax.xml.stream.a r3, String r4, URL r5, String r6, String r7) {
        super((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), r4, r5);
        this.d = r6;
        this.e = r7;
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String e() {
        return this.d;
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String f() {
        return null;
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String g() {
        return this.e;
    }

    @Override // com.ctc.wstx.e.a
    public char[] i() {
        return null;
    }

    @Override // com.ctc.wstx.e.a
    public boolean j() {
        return true;
    }
}
