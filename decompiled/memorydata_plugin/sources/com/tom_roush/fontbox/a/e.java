package com.tom_roush.fontbox.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes6.dex */
public class e {
    private boolean A;
    private float B;
    private float C;
    private List<b> D;
    private Map<String, b> E;
    private List<h> F;
    private List<c> G;
    private List<f> H;
    private List<f> I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    private List<f> f15892J;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float f15893a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15894b;
    private String c;
    private String d;
    private String e;
    private String f;
    private com.tom_roush.fontbox.g.a g;
    private String h;
    private String i;
    private String j;
    private int k;
    private int l;
    private String m;
    private int n;
    private boolean o;
    private float[] p;
    private boolean q;
    private float r;
    private float s;
    private float t;
    private float u;
    private final List<String> v;
    private float w;
    private float x;
    private float y;
    private float[] z;

    public e() {
        this.f15894b = 0;
        this.v = new ArrayList();
        this.D = new ArrayList();
        this.E = new HashMap();
        this.F = new ArrayList();
        this.G = new ArrayList();
        this.H = new ArrayList();
        this.I = new ArrayList();
        this.f15892J = new ArrayList();
    }

    public float a() {
        Iterator<b> r6 = this.D.iterator();
        float r1 = 0.0f;
        float r2 = 0.0f;
    L4:
        if (r6.hasNext() == false) goto L9;
        b r3 = (b) ZeusTransformUtils.preCheckCast(r6.next(), b.class, "com.obric.memorydata.plugin");
        if (r3.c() <= 0.0f) goto L4;
        r1 = r1 + r3.c();
        r2 = r2 + 1.0f;
        goto L4
    L9:
        if (r1 > 0.0f) goto L11;
        return 0.0f;
    L11:
        return r1 / r2;
    }

    public float a(String r2) {
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.E.get(r2), b.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L7;
        return 0.0f;
    L7:
        return r1.c();
    }

    public void a(float r1) {
        this.f15893a = r1;
    }

    public void a(int r1) {
        this.k = r1;
    }

    public void a(c r1) {
        this.G.add(r1);
    }

    public void a(f r1) {
        this.H.add(r1);
    }

    public void a(h r1) {
        this.F.add(r1);
    }

    public void a(com.tom_roush.fontbox.g.a r1) {
        this.g = r1;
    }

    public void a(List<b> r5) {
        List<b> r6 = (List) ZeusTransformUtils.wrapperContextForParams(r5, List.class, "com.obric.memorydata.plugin");
        this.D = r6;
        this.E = new HashMap(this.D.size());
        Iterator<b> r7 = r6.iterator();
    L4:
        if (r7.hasNext() == false) goto L6;
        b r0 = (b) ZeusTransformUtils.preCheckCast(r7.next(), b.class, "com.obric.memorydata.plugin");
        this.E.put(r0.b(), r0);
        goto L4
    }

    public void a(boolean r1) {
        this.o = r1;
    }

    public void a(float[] r1) {
        this.p = r1;
    }

    public String b() {
        return this.c;
    }

    public void b(float r1) {
        this.r = r1;
    }

    public void b(int r1) {
        this.l = r1;
    }

    public void b(f r1) {
        this.I.add(r1);
    }

    public void b(String r1) {
        this.v.add(r1);
    }

    public void b(boolean r1) {
        this.q = r1;
    }

    public void b(float[] r1) {
        this.z = r1;
    }

    public String c() {
        return this.e;
    }

    public void c(float r1) {
        this.s = r1;
    }

    public void c(int r1) {
        this.n = r1;
    }

    public void c(f r1) {
        this.f15892J.add(r1);
    }

    public void c(String r1) {
        this.c = r1;
    }

    public void c(boolean r1) {
        this.A = r1;
    }

    public com.tom_roush.fontbox.g.a d() {
        return this.g;
    }

    public void d(float r1) {
        this.t = r1;
    }

    public void d(String r1) {
        this.d = r1;
    }

    public String e() {
        return this.j;
    }

    public void e(float r1) {
        this.u = r1;
    }

    public void e(String r1) {
        this.e = r1;
    }

    public String f() {
        return this.m;
    }

    public void f(float r1) {
        this.w = r1;
    }

    public void f(String r1) {
        this.f = r1;
    }

    public float g() {
        return this.r;
    }

    public void g(float r1) {
        this.x = r1;
    }

    public void g(String r1) {
        this.i = r1;
    }

    public float h() {
        return this.s;
    }

    public void h(float r1) {
        this.y = r1;
    }

    public void h(String r1) {
        this.j = r1;
    }

    public float i() {
        return this.t;
    }

    public void i(float r1) {
        this.B = r1;
    }

    public void i(String r1) {
        this.m = r1;
    }

    public float j() {
        return this.u;
    }

    public void j(float r1) {
        this.C = r1;
    }

    public void j(String r1) {
        this.h = r1;
    }

    public float k() {
        return this.y;
    }

    public List<b> l() {
        return Collections.unmodifiableList(this.D);
    }
}
