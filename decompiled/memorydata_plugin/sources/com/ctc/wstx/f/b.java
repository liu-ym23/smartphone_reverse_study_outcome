package com.ctc.wstx.f;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public class b extends org.codehaus.stax2.b.a.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final URL f3507a;

    public b(javax.xml.stream.a r3, String r4, String r5, String r6, URL r7) {
        super((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), r4, r5, r6);
        this.f3507a = r7;
    }

    @Override // org.codehaus.stax2.b.a.b, org.codehaus.stax2.a.a
    public String a() {
        URL r0 = this.f3507a;
        if (r0 != null) goto L7;
        return super.a();
    L7:
        return r0.toExternalForm();
    }
}
