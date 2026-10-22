package l0;

import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private l0.b f10818a;

    static /* synthetic */ class a {
    }

    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static h f10819a;

        static {
            f10819a = new h(null);
        }

        static /* synthetic */ h a() {
            return f10819a;
        }
    }

    private h() {
        if (Build.VERSION.SDK_INT < 28) goto L5;
        l0.b r10 = new d();
    L6:
        this.f10818a = r10;
        this.f10818a.init();
        return;
    L5:
        r10 = new e();
        goto L6
    }

    /* synthetic */ h(a r10) {
        this();
    }

    public static h e() {
        return b.a();
    }

    public long a() {
        return this.f10818a.a();
    }

    public long b() {
        return this.f10818a.e();
    }

    public long c() {
        return this.f10818a.h();
    }

    public long d() {
        return this.f10818a.j();
    }

    public long f() {
        return this.f10818a.b();
    }

    public long g() {
        return this.f10818a.g();
    }

    public long h() {
        return this.f10818a.c();
    }

    public long i() {
        return this.f10818a.i();
    }

    public long j() {
        return this.f10818a.f();
    }

    void k(boolean r10) {
        this.f10818a.d(r10);
    }
}
