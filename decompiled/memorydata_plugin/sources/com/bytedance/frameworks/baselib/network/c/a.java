package com.bytedance.frameworks.baselib.network.c;

/* JADX INFO: loaded from: classes2.dex */
final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2295a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f2296b;
    private long c;
    private long d;

    a() {
        this.f2295a = false;
        this.f2296b = -1;
        this.c = -1;
        this.d = -1;
    }

    public long a() {
        long r0 = this.c;
        if (r0 < 0) goto L11;
        long r4 = this.d;
        if (r4 >= 0) goto L7;
        return -1;
    L7:
        if (r0 <= r4) goto L10;
        return -1;
    L10:
        return r4 - r0;
    L11:
        return -1;
    }

    public void a(int r1) {
        this.f2296b = r1;
    }

    public void a(long r1) {
        this.c = r1;
    }

    public void a(boolean r1) {
        this.f2295a = r1;
    }

    public void b(long r1) {
        this.d = r1;
    }

    public boolean b() {
        return this.f2295a;
    }

    public int c() {
        return this.f2296b;
    }
}
