package com.bytedance.monitor.util.thread;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: classes2.dex */
public class a implements c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f2890b = null;
    private static final Object d = null;
    private static final Object f = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile com.bytedance.monitor.util.thread.a.b f2891a;
    private volatile com.bytedance.monitor.util.thread.a.b c;
    private volatile com.bytedance.monitor.util.thread.a.b e;
    private Map<AsyncTaskType, Long> g;
    private e h;
    private c.a i;

    /* JADX INFO: renamed from: com.bytedance.monitor.util.thread.a$a, reason: collision with other inner class name */
    private static final class C0145a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f2895a = null;

        static {
            f2895a = new a();
        }
    }

    static {
        f2890b = new Object();
        d = new Object();
        f = new Object();
    }

    public a() {
        this.g = new ConcurrentHashMap(3);
    }

    public static a a() {
        return C0145a.f2895a;
    }

    static /* synthetic */ Map a(a r0) {
        return r0.g;
    }

    private void a(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        Object r0 = f2890b;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.f2891a != null) goto L7;
        com.bytedance.monitor.util.thread.a.a r1 = new com.bytedance.monitor.util.thread.a.a("io-task");     // Catch: Throwable -> L9
        r1.a(r6);     // Catch: Throwable -> L9
        r1.a(new AnonymousClass1(this));     // Catch: Throwable -> L9
        com.bytedance.monitor.util.thread.a.b r2 = new com.bytedance.monitor.util.thread.a.b(1, r1);     // Catch: Throwable -> L9
        r2.a(r6);     // Catch: Throwable -> L9
        this.f2891a = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private void b(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        Object r0 = d;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.c != null) goto L7;
        com.bytedance.monitor.util.thread.a.a r1 = new com.bytedance.monitor.util.thread.a.a("light-weight-task");     // Catch: Throwable -> L9
        r1.a(r6);     // Catch: Throwable -> L9
        r1.a(new AnonymousClass2(this));     // Catch: Throwable -> L9
        com.bytedance.monitor.util.thread.a.b r2 = new com.bytedance.monitor.util.thread.a.b(1, r1);     // Catch: Throwable -> L9
        r2.a(r6);     // Catch: Throwable -> L9
        this.c = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    private com.bytedance.monitor.util.thread.a.c c(d r3) {
        AsyncTaskType r4 = ((d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin")).b();
        if (r4 != AsyncTaskType.IO) goto L7;
        return e();
    L7:
        if (r4 != AsyncTaskType.TIME_SENSITIVE) goto L11;
        return f();
    L11:
        return d();
    }

    private void c(e r5) {
        e r6 = (e) ZeusTransformUtils.wrapperContextForParams(r5, e.class, "com.obric.memorydata.plugin");
        Object r0 = f;
        monitor-enter(r0);
    L9:
        th = move-exception;
        throw th;
    L5:
        if (this.e != null) goto L7;
        com.bytedance.monitor.util.thread.a.a r1 = new com.bytedance.monitor.util.thread.a.a("time-sensitive-task");     // Catch: Throwable -> L9
        r1.a(r6);     // Catch: Throwable -> L9
        r1.a(new AnonymousClass3(this));     // Catch: Throwable -> L9
        com.bytedance.monitor.util.thread.a.b r2 = new com.bytedance.monitor.util.thread.a.b(1, r1);     // Catch: Throwable -> L9
        r2.a(r6);     // Catch: Throwable -> L9
        this.e = r2;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r0);     // Catch: Throwable -> L9
    }

    @Override // com.bytedance.monitor.util.thread.c
    public long a(AsyncTaskType r2) {
        Long r1 = (Long) ZeusTransformUtils.preCheckCast(this.g.get(r2), Long.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L5;
        return -1;
    L5:
        return r1.longValue();
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void a(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        c(r4).a(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-post");
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void a(d r3, long r4) {
        d r5 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L10;
        return;
    L10:
        c(r5).a(r5, r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-postDelayed");
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void a(d r7, long r8, long r10) {
        d r1 = (d) ZeusTransformUtils.wrapperContextForParams(r7, d.class, "com.obric.memorydata.plugin");
        if (r1 != null) goto L10;
        return;
    L10:
        c(r1).a(r1, r8, r10);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.util.thread.c
    public void a(Throwable r1, String r2) {
        c.a r0 = this.i;
        if (r0 == null) goto L6;
        r0.a(r1, r2);
        return;
    }

    @Override // com.bytedance.monitor.util.thread.c
    public ExecutorService b() {
        return e();
    }

    @Override // com.bytedance.monitor.util.thread.a.c
    public void b(d r3) {
        d r4 = (d) ZeusTransformUtils.wrapperContextForParams(r3, d.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L10;
        return;
    L10:
        c(r4).b(r4);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        a(th, "Apm-Async-task-removeTask");
    }

    @Override // com.bytedance.monitor.util.thread.c
    public e c() {
        return this.h;
    }

    public com.bytedance.monitor.util.thread.a.b d() {
        if (this.c != null) goto L15;
        Object r0 = d;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.c != null) goto L9;
        b(this.h);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.c;
    }

    public com.bytedance.monitor.util.thread.a.b e() {
        if (this.f2891a != null) goto L15;
        Object r0 = f2890b;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f2891a != null) goto L9;
        a(this.h);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.f2891a;
    }

    public com.bytedance.monitor.util.thread.a.b f() {
        if (this.e != null) goto L15;
        Object r0 = f;
        monitor-enter(r0);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.e != null) goto L9;
        c(this.h);     // Catch: Throwable -> L11
    L9:
        monitor-exit(r0);     // Catch: Throwable -> L11
    L15:
        return this.e;
    }
}
