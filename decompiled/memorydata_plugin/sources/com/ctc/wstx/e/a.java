package com.ctc.wstx.e;

import com.ctc.wstx.io.v;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.net.URL;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a extends com.ctc.wstx.f.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f3505a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final URL f3506b;
    protected boolean c;

    public a(javax.xml.stream.a r3, String r4, URL r5) {
        super((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin"));
        this.c = false;
        this.f3505a = r4;
        this.f3506b = r5;
    }

    public abstract v a(v r1, javax.xml.stream.d r2, com.ctc.wstx.a.b r3, int r4);

    public void a() {
        this.c = true;
    }

    @Override // com.ctc.wstx.f.a, javax.xml.stream.a.a
    public final String b() {
        return this.f3506b.toExternalForm();
    }

    @Override // com.ctc.wstx.f.a, javax.xml.stream.a.a
    public final String c() {
        return this.f3505a;
    }

    @Override // com.ctc.wstx.f.a, javax.xml.stream.a.a
    public abstract String d();

    @Override // com.ctc.wstx.f.a, javax.xml.stream.a.a
    public abstract String e();

    @Override // com.ctc.wstx.f.a, javax.xml.stream.a.a
    public abstract String f();

    @Override // com.ctc.wstx.f.a, javax.xml.stream.a.a
    public abstract String g();

    public boolean h() {
        return this.c;
    }

    public abstract char[] i();

    public abstract boolean j();

    public abstract boolean k();
}
