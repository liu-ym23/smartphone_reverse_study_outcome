package s1;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public abstract class s<T> implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t1.c<T> f12000a;

    public s() {
        this.f12000a = new t1.c();
    }

    public static r a(j1.b0 r8, String r10) {
        return new r(r8, r10);
    }

    public final t1.c b() {
        return this.f12000a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        t1.c<T> r8 = this.f12000a;
        r r10 = (r) this;     // Catch: Throwable -> L5
        ArrayList r11 = r10.f11998b.f8453c.f().u(r10.f11999m);     // Catch: Throwable -> L5
        r8.j((T) ((List) r1.t.f11338v.apply(r11)));     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        r8.k(th);
    }
}
