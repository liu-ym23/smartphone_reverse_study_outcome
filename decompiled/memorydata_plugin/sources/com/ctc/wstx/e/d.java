package com.ctc.wstx.e;

import com.ctc.wstx.io.h;
import com.ctc.wstx.io.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class d extends b {
    public d(javax.xml.stream.a r7, String r8, URL r9, String r10, String r11) {
        super((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r7, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), r8, r9, r10, r11);
    }

    @Override // com.ctc.wstx.e.a
    public v a(v r9, javax.xml.stream.d r10, com.ctc.wstx.a.b r11, int r12) {
        javax.xml.stream.d r5 = (javax.xml.stream.d) ZeusTransformUtils.wrapperContextForParams(r10, javax.xml.stream.d.class, "com.obric.memorydata.plugin");
        if (r12 != 0) goto L5;
        r12 = 256;
    L5:
        URL r1 = this.f3506b;
        String r2 = this.f3505a;
        String r3 = e();
        String r4 = g();
        return h.a(r9, r1, r2, r3, r4, r5, r11, r12);
    }

    @Override // com.ctc.wstx.e.a, com.ctc.wstx.f.a, javax.xml.stream.a.a
    public String d() {
        return null;
    }

    @Override // com.ctc.wstx.e.a
    public boolean k() {
        return true;
    }
}
