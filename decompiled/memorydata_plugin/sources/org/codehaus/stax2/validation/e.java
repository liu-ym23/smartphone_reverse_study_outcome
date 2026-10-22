package org.codehaus.stax2.validation;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected javax.xml.stream.a f17991a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected final String f17992b;
    protected final int c;
    protected String d;
    protected g e;

    public e(javax.xml.stream.a r3, String r4, int r5) {
        this((javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin"), r4, r5, null);
    }

    public e(javax.xml.stream.a r3, String r4, int r5, String r6) {
        this.f17991a = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
        this.f17992b = r4;
        this.c = r5;
        this.d = r6;
    }

    public javax.xml.stream.a a() {
        return this.f17991a;
    }

    public void a(String r1) {
        this.d = r1;
    }

    public void a(javax.xml.stream.a r3) {
        this.f17991a = (javax.xml.stream.a) ZeusTransformUtils.wrapperContextForParams(r3, javax.xml.stream.a.class, "com.obric.memorydata.plugin");
    }

    public void a(g r1) {
        this.e = r1;
    }

    public String b() {
        return this.f17992b;
    }

    public int c() {
        return this.c;
    }

    public String getType() {
        return this.d;
    }
}
