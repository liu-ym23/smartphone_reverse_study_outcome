package com.bytedance.crypto.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.security.cert.X509Certificate;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public byte[] f2214a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f2215b;
    public List<X509Certificate> c;

    public g(byte[] r3, byte[] r4, List<X509Certificate> r5) {
        List<X509Certificate> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.f2214a = r3;
        this.f2215b = r4;
        this.c = r6;
    }
}
