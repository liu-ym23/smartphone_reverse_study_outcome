package jf;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class j extends x {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public x f8846e;

    public j(x r8) {
        if (r8 == null) goto L7;
        this.f8846e = r8;
        return;
    L7:
        throw new IllegalArgumentException("delegate == null");
    }

    @Override // jf.x
    public final x a() {
        return this.f8846e.a();
    }

    @Override // jf.x
    public final x b() {
        return this.f8846e.b();
    }

    @Override // jf.x
    public final long c() {
        return this.f8846e.c();
    }

    @Override // jf.x
    public final x d(long r8) {
        return this.f8846e.d(r8);
    }

    @Override // jf.x
    public final boolean e() {
        return this.f8846e.e();
    }

    @Override // jf.x
    public final void f() {
        this.f8846e.f();
    }

    @Override // jf.x
    public final x g(long r8, TimeUnit r10) {
        return this.f8846e.g(r8, r10);
    }

    @Override // jf.x
    public final long h() {
        return this.f8846e.h();
    }
}
