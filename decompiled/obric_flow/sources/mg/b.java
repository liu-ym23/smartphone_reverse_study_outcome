package mg;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.lynx.tasm.behavior.ui.utils.n;
import com.lynx.tasm.behavior.x0;
import java.util.concurrent.ConcurrentHashMap;
import zm.z;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    public static final Object e = null;
    public static final Object f = null;
    public static final Object g = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ng.b f20083a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile ng.b f20084b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public volatile ng.b f20085c;
    public ConcurrentHashMap d;

    static {
        e = new Object();
        f = new Object();
        g = new Object();
    }

    public final ng.b a(d r5) {
        AsyncTaskType r10 = r5.p();
        if (r10 != AsyncTaskType.IO) goto L7;
        return b();
    L7:
        if (r10 != AsyncTaskType.TIME_SENSITIVE) goto L24;
        if (this.f20085c != null) goto L22;
        Object r11 = g;
        monitor-enter(r11);
    L15:
        th = move-exception;
        throw th;
    L13:
        if (this.f20085c != null) goto L17;
        e();     // Catch: Throwable -> L15
    L17:
        monitor-exit(r11);     // Catch: Throwable -> L15
    L22:
        return this.f20085c;
    L24:
        if (this.f20084b != null) goto L37;
        Object r12 = f;
        monitor-enter(r12);
    L30:
        th = move-exception;
        throw th;
    L28:
        if (this.f20084b != null) goto L32;
        d();     // Catch: Throwable -> L30
    L32:
        monitor-exit(r12);     // Catch: Throwable -> L30
    L37:
        return this.f20084b;
    }

    public final ng.b b() {
        if (this.f20083a != null) goto L16;
        Object r5 = e;
        monitor-enter(r5);
    L9:
        th = move-exception;
        throw th;
    L7:
        if (this.f20083a != null) goto L11;
        c();     // Catch: Throwable -> L9
    L11:
        monitor-exit(r5);     // Catch: Throwable -> L9
    L16:
        return this.f20083a;
    }

    public final void c() {
        Object r5 = e;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f20083a != null) goto L9;
        com.bytedance.ies.bullet.prefetchv2.d r10 = new com.bytedance.ies.bullet.prefetchv2.d("io-task", 2);     // Catch: Throwable -> L7
        r10.f5840b = new z(this);     // Catch: Throwable -> L7
        this.f20083a = new ng.b(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L7
    }

    public final void d() {
        Object r5 = f;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f20084b != null) goto L9;
        com.bytedance.ies.bullet.prefetchv2.d r10 = new com.bytedance.ies.bullet.prefetchv2.d("light-weight-task", 2);     // Catch: Throwable -> L7
        r10.f5840b = new x0(this);     // Catch: Throwable -> L7
        this.f20084b = new ng.b(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L7
    }

    public final void e() {
        Object r5 = g;
        monitor-enter(r5);
    L7:
        th = move-exception;
        throw th;
    L5:
        if (this.f20085c != null) goto L9;
        com.bytedance.ies.bullet.prefetchv2.d r10 = new com.bytedance.ies.bullet.prefetchv2.d("time-sensitive-task", 2);     // Catch: Throwable -> L7
        r10.f5840b = new n(this);     // Catch: Throwable -> L7
        this.f20085c = new ng.b(r10);     // Catch: Throwable -> L7
    L9:
        monitor-exit(r5);     // Catch: Throwable -> L7
    }

    public final void f(d r5) {
        a(r5).a(r5);     // Catch: Throwable -> L4
        return;
    }

    public final void g(d r5, long r10) {
        if (r5 != null) goto L7;
        return;
    L7:
        a(r5).b(r5, r10);     // Catch: Throwable -> L6
        return;
    }
}
