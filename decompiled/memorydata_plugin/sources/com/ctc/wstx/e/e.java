package com.ctc.wstx.e;

import com.ctc.wstx.io.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class e extends b {
    final String f;

    public e(javax.xml.stream.a r7, String r8, URL r9, String r10, String r11, String r12) {
        super((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r7, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
        this.f = r12;
    }

    @Override // com.ctc.wstx.e.a
    public v a(v r1, javax.xml.stream.d r2, com.ctc.wstx.a.b r3, int r4) {
        javax.xml.stream.d r0 = (javax.xml.stream.d) ZeusTransformUtils.wrapperContextForParams(r2, javax.xml.stream.d.class, "com.obric.memorydata.plugin");
        throw new IllegalStateException("Internal error: createInputSource() called for unparsed (external) entity.");
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String d() {
        return this.f;
    }

    @Override // com.ctc.wstx.e.a
    public boolean k() {
        return false;
    }
}
