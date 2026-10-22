package com.google.common.cache;

/* JADX INFO: loaded from: classes2.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final r0 f8687a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final r0 f8688b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final r0 f8689c;
    public final r0 d;
    public final r0 e;
    public final r0 f;

    public a() {
        this.f8687a = u0.a();
        this.f8688b = u0.a();
        this.f8689c = u0.a();
        this.d = u0.a();
        this.e = u0.a();
        this.f = u0.a();
    }

    public static long h(long r5) {
        if (r5 >= 0) goto L7;
        return Long.MAX_VALUE;
    L7:
        return r5;
    }

    @Override // com.google.common.cache.b
    public final void a(int r5) {
        this.f8687a.add(r5);
    }

    @Override // com.google.common.cache.b
    public final void b(int r5) {
        this.f8688b.add(r5);
    }

    @Override // com.google.common.cache.b
    public final void c() {
        this.f.increment();
    }

    @Override // com.google.common.cache.b
    public final void d(long r5) {
        this.d.increment();
        this.e.add(r5);
    }

    @Override // com.google.common.cache.b
    public final void e(long r5) {
        this.f8689c.increment();
        this.e.add(r5);
    }

    @Override // com.google.common.cache.b
    public final i f() {
        return new i(h(this.f8687a.sum()), h(this.f8688b.sum()), h(this.f8689c.sum()), h(this.d.sum()), h(this.e.sum()), h(this.f.sum()));
    }

    public final void g(b r5) {
        i r10 = r5.f();
        long r11 = r10.f8719a;
        this.f8687a.add(r11);
        this.f8688b.add(r10.f8720b);
        this.f8689c.add(r10.f8721c);
        this.d.add(r10.d);
        this.e.add(r10.e);
        this.f.add(r10.f);
    }
}
