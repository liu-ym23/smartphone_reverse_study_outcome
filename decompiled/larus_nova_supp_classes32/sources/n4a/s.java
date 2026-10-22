package n4a;

import android.content.Context;
import android.os.Build;
import com.obric.aivoice.core.data.NameKeys;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
public final class s extends l1 {
    public final /* synthetic */ Context b;
    public final /* synthetic */ String c;
    public final /* synthetic */ h1 d;

    public s(Context r1, String r2, h1 r3) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
    }

    @Override // n4a.l1
    public final void a() {
        monitor-enter(t.class);     // Catch: Throwable -> L13
        n0 r7 = t0.a();     // Catch: Throwable -> L10
        t0.b(this.b, r7, this.c, 1000, 4096000, "1");     // Catch: Throwable -> L10
        r7.f = this.d;     // Catch: Throwable -> L10
        if (r7.g != null) goto L7;
        Context r3 = this.b;     // Catch: Throwable -> L10
        r7.g = new y0(new x0(new c1(), new c0(new e0(new f0())), "QImtleSI6IiVzIiwicGxhdGZvcm0iOiJhbmRyb2lkIiwiZGl1IjoiJXMiLCJhZGl1IjoiJXMiLCJwa2ciOiIlcyIsIm1vZGVsIjoiJXMiLCJhcHBuYW1lIjoiJXMiLCJhcHB2ZXJzaW9uIjoiJXMiLCJzeXN2ZXJzaW9uIjoiJXMi", new Object[]{v4.g(r3), NameKeys.UnloadStrategy_No_Strategy, x4.u(this.b), v4.d(this.b), Build.MODEL, v4.b(this.b), v4.e(this.b), Build.VERSION.RELEASE}));     // Catch: Throwable -> L10
    L7:
        r7.h = 3600000;     // Catch: Throwable -> L10
        o0.b(r7);     // Catch: Throwable -> L10
        monitor-exit(t.class);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        r.f(th, "lg", "pul");
    }
}
