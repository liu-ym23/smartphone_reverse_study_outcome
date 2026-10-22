package b6;

import java.io.IOException;
import java.net.ProtocolException;
import we.a0;
import we.x;
import we.y;

/* JADX INFO: loaded from: classes.dex */
public final class b implements we.e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ y f3073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c f3074b;

    public b(c r8, y r10) {
        this.f3074b = r8;
        this.f3073a = r10;
    }

    public final void a(IOException r8) {
        this.f3074b.d(r8, null);
    }

    public final void b(x r8, a0 r10) {
        this.f3074b.b(r10);     // Catch: ProtocolException -> L13
        xe.a.f13878a.getClass();
        ze.g r11 = r8.f13328b.f376b;
        r11.f();
        ze.d r12 = r11.b();
        ze.c r13 = new ze.c(r12.f14380i, r12.f14381j, r11);
        c r14 = this.f3074b;     // Catch: Exception -> L10
        android.support.v4.media.a r15 = r14.f3076a;     // Catch: Exception -> L10
        if (r15 == null) goto L8;
        r15.u(r14, r10);     // Catch: Exception -> L10
    L8:
        this.f3074b.e("OkHttp WebSocket " + this.f3073a.f13337a.m(), r13);     // Catch: Exception -> L10
        r11.b().f14376e.setSoTimeout(0);     // Catch: Exception -> L10
        this.f3074b.f();     // Catch: Exception -> L10
        return;
    L10:
        e = move-exception;
        this.f3074b.d(e, null);
        return;
    L13:
        e = move-exception;
        this.f3074b.d(e, r10);
        xe.c.f(r10);
    }
}
