package com.bytedance.monitor.collector;

import android.util.Pair;
import androidx.annotation.CallSuper;

/* JADX INFO: loaded from: classes.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected String f2245a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected int f2246b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f2247c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected volatile boolean f2248d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected z3.c f2249e;

    class a implements Runnable {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ int f2250c;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ b f2251g;

        a(b r10, int r11) {
            this.f2251g = r10;
            this.f2250c = r11;
        }

        @Override // java.lang.Runnable
        public void run() {
            b r10 = this.f2251g;
            int r11 = r10.f2246b;
            if (r11 > (-1)) goto L6;
            return;
        L6:
            if (r11 != 2) goto L11;
            int r12 = r10.f2247c;
            int r13 = this.f2250c;
            if (r12 == r13) goto L12;
            r10.f2247c = r13;
            r10.f(r13);
            return;
        L12:
            return;
        }
    }

    public b(int r10, String r11) {
        this.f2246b = 0;
        this.f2247c = 1;
        this.f2248d = false;
        this.f2245a = r11;
        this.f2247c = r10;
        k.n().a(this);
        this.f2249e = z3.b.a();
    }

    Pair<String, ?> a() {
        return null;
    }

    Pair<String, ?> b(long r10, long r11) {
        return null;
    }

    public final void c(int r10) {
        z3.d r11 = z3.b.e("refreshConfig", new a(this, r10));
        z3.c r12 = this.f2249e;
        if (r12 == null) goto L6;
        r12.d(r11);
        return;
    }

    @CallSuper
    void d() {
        if (this.f2246b < 0) goto L7;
        this.f2246b = 2;
        return;
    L7:
        throw new IllegalStateException("collector has destroyed, can not start.");
    }

    @CallSuper
    void e() {
        this.f2246b = 1;
    }

    protected abstract void f(int r10);
}
