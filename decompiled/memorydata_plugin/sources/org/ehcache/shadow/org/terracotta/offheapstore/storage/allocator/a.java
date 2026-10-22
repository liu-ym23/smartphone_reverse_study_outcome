package org.ehcache.shadow.org.terracotta.offheapstore.storage.allocator;

import com.volcengine.zeus.transform.ZeusTransformUtils;

/* JADX INFO: loaded from: classes7.dex */
class a extends org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a<a> implements Comparable<Comparable<?>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f18127a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f18128b;
    private int c;

    a(int r1, int r2) {
        this.f18127a = r1;
        this.f18128b = r2;
        l();
    }

    private void l() {
        a r1 = (a) ZeusTransformUtils.preCheckCast(g().f(), a.class, "com.obric.memorydata.plugin");
        a r0 = (a) ZeusTransformUtils.preCheckCast(h().f(), a.class, "com.obric.memorydata.plugin");
        int r2 = 0;
        if (r1 != null) goto L5;
        int r3 = 0;
    L6:
        if (r0 == null) goto L9;
        r2 = r0.a();
    L9:
        this.c = (b() | r3) | r2;
        return;
    L5:
        r3 = r1.a();
        goto L6
    }

    int a() {
        if (g().f() != null) goto L9;
        if (h().f() != null) goto L9;
        return b();
    L9:
        return this.c;
    }

    public int a(Comparable<?> r7) {
        Comparable r8 = (Comparable) ZeusTransformUtils.wrapperContextForParams(r7, Comparable.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r8, a.class) == false) goto L12;
        a r9 = (a) ZeusTransformUtils.preCheckCast(r8, a.class, "com.obric.memorydata.plugin");
        if (this.f18127a >= r9.f18127a) goto L8;
        return -1;
    L8:
        if (this.f18128b <= r9.f18128b) goto L10;
        return 1;
    L10:
        return 0;
    L12:
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L21;
        Integer r10 = (Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin");
        if (r10.intValue() <= this.f18128b) goto L17;
        return -1;
    L17:
        if (r10.intValue() >= this.f18127a) goto L19;
        return 1;
    L19:
        return 0;
    L21:
        throw new AssertionError();
    }

    @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
    public void a(org.ehcache.shadow.org.terracotta.offheapstore.util.a.b<a> r3) {
        super.a((org.ehcache.shadow.org.terracotta.offheapstore.util.a.b) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b.class, "com.obric.memorydata.plugin"));
        l();
    }

    int b() {
        int r0 = 0;
        int r1 = 0;
    L4:
        if (r0 >= 31) goto L9;
        int r3 = 1 << r0;
        int r4 = r3 - 1;
        if (((this.f18128b - ((~r4) & (this.f18127a + r4))) + 1) < r3) goto L8;
        r1 = r1 | r3;
    L8:
        r0 = r0 + 1;
        goto L4
    L9:
        return r1;
    }

    @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.AbstractC0895a, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
    public void b(org.ehcache.shadow.org.terracotta.offheapstore.util.a.b<a> r3) {
        super.b((org.ehcache.shadow.org.terracotta.offheapstore.util.a.b) ZeusTransformUtils.wrapperContextForParams(r3, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b.class, "com.obric.memorydata.plugin"));
        l();
    }

    public a c() {
        return this;
    }

    @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
    public void c(org.ehcache.shadow.org.terracotta.offheapstore.util.a.b<a> r4) {
        org.ehcache.shadow.org.terracotta.offheapstore.util.a.b r5 = (org.ehcache.shadow.org.terracotta.offheapstore.util.a.b) ZeusTransformUtils.wrapperContextForParams(r4, org.ehcache.shadow.org.terracotta.offheapstore.util.a.b.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r5, a.class) == false) goto L7;
        a r6 = (a) ZeusTransformUtils.preCheckCast(r5, a.class, "com.obric.memorydata.plugin");
        int r0 = this.f18127a;
        this.f18127a = r6.f18127a;
        r6.f18127a = r0;
        int r1 = this.f18128b;
        this.f18128b = r6.f18128b;
        r6.f18128b = r1;
        l();
        return;
    L7:
        throw new AssertionError();
    }

    @Override // java.lang.Comparable
    public /* synthetic */ int compareTo(Comparable<?> r3) {
        return a((Comparable) ZeusTransformUtils.preCheckCast(r3, Comparable.class, "com.obric.memorydata.plugin"));
    }

    public int d() {
        return this.f18127a;
    }

    public int e() {
        return this.f18128b;
    }

    public boolean equals(Object r3) {
        if (ZeusTransformUtils.instanceOf(r3, a.class) == false) goto L12;
        a r4 = (a) ZeusTransformUtils.preCheckCast(r3, a.class, "com.obric.memorydata.plugin");
        if (this.f18127a == r4.f18127a) goto L7;
    L9:
        return false;
    L7:
        if (this.f18128b != r4.f18128b) goto L9;
        return true;
    L12:
        throw new AssertionError();
    }

    @Override // org.ehcache.shadow.org.terracotta.offheapstore.util.a.b
    public /* synthetic */ Comparable f() {
        return c();
    }

    public int hashCode() {
        int r0 = this.f18127a * 3;
        return (this.f18128b * 7) ^ r0;
    }

    public String toString() {
        return "Range(" + this.f18127a + "," + this.f18128b + ") available:" + Integer.toBinaryString(b());
    }
}
