package com.ctc.wstx.io;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.Reader;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public final class l {
    public static d a(com.ctc.wstx.a.b r6, k r7, String r8, r r9, Reader r10, boolean r11) {
        URL r0 = r6.D();
        if (r0 == null) goto L5;
        r9 = r.a(r0);
    L5:
        d r12 = new d(r6, r8, r9, r10, r11);
        if (r7 == null) goto L8;
        r12.a(r7.e(), r7.f(), -r7.g());
    L8:
        return r12;
    }

    public static p a(com.ctc.wstx.a.b r8, v r9, String r10, k r11, String r12, r r13, int r14, Reader r15) {
        p r16 = new p(r8, r9, r10, r12, r13, r15, true);
        if (r11 == null) goto L5;
        r16.a(r11.e(), r11.f(), -r11.g());
    L5:
        return r16;
    }

    public static v a(v r8, String r9, char[] r10, int r11, int r12, javax.xml.stream.a r13, URL r14) {
        javax.xml.stream.a r6 = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r13, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        return new f(r8, r9, r10, r11, r12, r6, r.a(r6.getSystemId(), r14));
    }
}
