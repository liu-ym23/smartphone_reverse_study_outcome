package com.ss.android.ugc.quota;

/* JADX INFO: loaded from: classes6.dex */
public class e<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f15762a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f15763b;
    private T c;

    public e() {
        this.f15762a = false;
        this.f15763b = false;
    }

    private T a() {
        if (this.f15763b == true) goto L5;
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L8:
        if (this.f15763b == false) goto L12;
        T r0 = this.c;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r0;
    L12:
        this.c = b();     // Catch: Throwable -> L15
        this.f15763b = true;     // Catch: Throwable -> L15
        T r1 = this.c;     // Catch: Throwable -> L15
        monitor-exit(this);     // Catch: Throwable -> L15
        return r1;
    L5:
        return this.c;
    }

    public void a(T r1) {
        this.c = r1;
        this.f15762a = true;
    }

    public T b() {
        return null;
    }

    public T c() {
        T r0 = this.c;
        if (r0 == null) goto L6;
        return r0;
    L6:
        return a();
    }

    public boolean d() {
        return this.f15762a;
    }
}
