package com.tom_roush.fontbox.type1;

import com.tom_roush.fontbox.b.t;
import com.tom_roush.fontbox.b.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes6.dex */
public final class b implements com.tom_roush.fontbox.a, com.tom_roush.fontbox.b, a {
    List<Number> A;
    List<Number> B;
    List<Number> C;
    boolean D;
    int E;
    final List<byte[]> F;
    final Map<String, byte[]> G;
    private final Map<String, t> H;
    private final byte[] I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private final byte[] f16030J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    String f16031a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.tom_roush.fontbox.d.b f16032b;
    int c;
    int d;
    List<Number> e;
    List<Number> f;
    int g;
    float h;
    String i;
    String j;
    String k;
    String l;
    String m;
    String n;
    float o;
    boolean p;
    float q;
    float r;
    List<Number> s;
    List<Number> t;
    List<Number> u;
    List<Number> v;
    float w;
    int x;
    int y;
    List<Number> z;

    b(byte[] r3, byte[] r4) {
        this.f16031a = "";
        this.f16032b = null;
        this.e = new ArrayList();
        this.f = new ArrayList();
        this.i = "";
        this.j = "";
        this.k = "";
        this.l = "";
        this.m = "";
        this.n = "";
        this.s = new ArrayList();
        this.t = new ArrayList();
        this.u = new ArrayList();
        this.v = new ArrayList();
        this.z = new ArrayList();
        this.A = new ArrayList();
        this.B = new ArrayList();
        this.C = new ArrayList();
        this.F = new ArrayList();
        this.G = new LinkedHashMap();
        this.H = new ConcurrentHashMap();
        this.I = r3;
        this.f16030J = r4;
    }

    public static b a(InputStream r2) {
        com.tom_roush.fontbox.e.a r0 = new com.tom_roush.fontbox.e.a(r2);
        return new d().a(r0.a(), r0.b());
    }

    public static b a(byte[] r2) {
        com.tom_roush.fontbox.e.a r0 = new com.tom_roush.fontbox.e.a(r2);
        return new d().a(r0.a(), r0.b());
    }

    public static b a(byte[] r1, byte[] r2) {
        return new d().a(r1, r2);
    }

    @Override // com.tom_roush.fontbox.b
    public float a(String r1) {
        return b_(r1).a();
    }

    @Override // com.tom_roush.fontbox.a
    public com.tom_roush.fontbox.d.b a() {
        return this.f16032b;
    }

    @Override // com.tom_roush.fontbox.b
    public String b() {
        return this.f16031a;
    }

    @Override // com.tom_roush.fontbox.b
    public boolean b(String r1) {
        if (this.G.get(r1) == null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.tom_roush.fontbox.type1.a
    public t b_(String r5) {
        t r1 = (t) ZeusTransformUtils.preCheckCast(this.H.get(r5), t.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L9;
        byte[] r2 = (byte[]) ZeusTransformUtils.preCheckCast(this.G.get(r5), byte[].class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L7;
        r2 = (byte[]) ZeusTransformUtils.preCheckCast(this.G.get(".notdef"), byte[].class, "com.obric.memorydata.plugin");
    L7:
        List<Object> r0 = new u(this.f16031a, r5).a(r2, this.F);
        t r3 = new t(this, this.f16031a, r5, r0);
        this.H.put(r5, r3);
        return r3;
    L9:
        return r1;
    }

    @Override // com.tom_roush.fontbox.b
    public com.tom_roush.fontbox.g.a c() {
        return new com.tom_roush.fontbox.g.a(this.f);
    }

    @Override // com.tom_roush.fontbox.b
    public List<Number> d() {
        return Collections.unmodifiableList(this.e);
    }

    public String e() {
        return this.m;
    }

    public String f() {
        return this.n;
    }

    public String toString() {
        return getClass().getName() + "[fontName=" + this.f16031a + ", fullName=" + this.l + ", encoding=" + this.f16032b + ", charStringsDict=" + this.G + "]";
    }
}
