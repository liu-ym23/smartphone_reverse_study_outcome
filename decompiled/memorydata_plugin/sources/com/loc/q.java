package com.loc;

import android.content.Context;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: classes3.dex */
public final class q extends n implements Thread.UncaughtExceptionHandler {
    private static ExecutorService e;
    private static Set<Integer> f;
    private static WeakReference<Context> g;
    private static final ThreadFactory h = null;
    private Context d;

    static {
        f = Collections.synchronizedSet(new HashSet());
        h = new AnonymousClass2();
    }

    private q(Context r4) {
        this.d = ZeusTransformUtils.wrapperContext((Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin"), "com.obric.memorydata.plugin");
        this.f5616b = Thread.getDefaultUncaughtExceptionHandler();     // Catch: Throwable -> L17
        if (this.f5616b != null) goto L7;
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.c = true;     // Catch: Throwable -> L17
        return;
    L7:
        String r5 = this.f5616b.toString();     // Catch: Throwable -> L17
        if (r5.startsWith("com.amap.apis.utils.core.dynamiccore") == false) goto L10;
    L15:
        Thread.setDefaultUncaughtExceptionHandler(this);     // Catch: Throwable -> L17
        this.c = true;     // Catch: Throwable -> L17
        return;
    L10:
        if (r5.indexOf("com.amap.api") == (-1)) goto L12;
    L13:
        this.c = false;     // Catch: Throwable -> L17
        return;
    L12:
        if (r5.indexOf("com.loc") == (-1)) goto L15;
    L17:
        th = move-exception;
        th.printStackTrace();
    }

    static /* synthetic */ Context a(q r0) {
        return r0.d;
    }

    public static synchronized q a(Context r3, fw r4) {
        monitor-enter(q.class);
        Context r5 = (Context) ZeusTransformUtils.wrapperContextForParams(r3, Context.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        if (r4 == null) goto L29;
        if (r4.a() == null) goto L27;
        if ("".equals(r4.a()) == true) goto L27;
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L30
    L23:
        q r6 = (q) ZeusTransformUtils.preCheckCast(n.f5615a, q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L30
        monitor-exit(q.class);
        return r6;
    L11:
        if (f.add(Integer.valueOf(r4.hashCode())) == true) goto L16;
        q r7 = (q) ZeusTransformUtils.preCheckCast(n.f5615a, q.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L21
        monitor-exit(q.class);
        return r7;
    L16:
        if (n.f5615a != null) goto L18;
        n.f5615a = new q(r5);     // Catch: Throwable -> L21
    L19:
        n.f5615a.a(r4, n.f5615a.c);     // Catch: Throwable -> L21
        goto L23
    L18:
        n.f5615a.c = false;     // Catch: Throwable -> L21
    L27:
        throw new l("sdk name is invalid");     // Catch: Throwable -> L30
    L29:
        throw new l("sdk info is null");     // Catch: Throwable -> L30
    L30:
        th = move-exception;
        throw th;
    }

    public static void a(fw r6, String r7, l r8) {
        if (r8 == null) goto L5;
        a(r6, r7, r8.c(), r8.d(), r8.e(), r8.b());
        return;
    }

    public static void a(fw r6, String r7, String r8, String r9, String r10) {
        a(r6, r7, r8, r9, "", r10);
    }

    public static void a(fw r2, String r3, String r4, String r5, String r6, String r7) {
        if (n.f5615a == null) goto L9;
        StringBuilder r0 = new StringBuilder("path:");     // Catch: Throwable -> L6
        r0.append(r3).append(",type:").append(r4).append(",gsid:").append(r5).append(",csid:").append(r6).append(",code:").append(r7);     // Catch: Throwable -> L6
        n.f5615a.a(r2, r0.toString(), "networkError");     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static synchronized void b() {
        monitor-enter(q.class);
        ExecutorService r1 = e;     // Catch: Throwable -> L9
        if (r1 == null) goto L7;
        r1.shutdown();     // Catch: Throwable -> L9
    L7:
        ah.a();     // Catch: Throwable -> L9
    L28:
    L21:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        return;
    L12:
        if (n.f5615a != null) goto L14;
    L18:
        n.f5615a = null;     // Catch: Throwable -> L21
        monitor-exit(q.class);
        return;
    L14:
        if (Thread.getDefaultUncaughtExceptionHandler() != n.f5615a) goto L18;
        if (n.f5615a.f5616b == null) goto L18;
        Thread.setDefaultUncaughtExceptionHandler(n.f5615a.f5616b);     // Catch: Throwable -> L21
        goto L18
    L25:
        th = move-exception;
        throw th;
    L9:
        th = move-exception;
        th.printStackTrace();     // Catch: Throwable -> L25
        goto L28
    }

    public static void b(fw r1, String r2, String r3) {
        if (n.f5615a == null) goto L9;
        n.f5615a.a(r1, r2, r3);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void b(Throwable r2, String r3, String r4) {
        if (n.f5615a == null) goto L9;
        n.f5615a.a(r2, 1, r3, r4);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    public static void c() {
        WeakReference<Context> r0 = g;
        if (r0 == null) goto L9;
        if (r0.get() == null) goto L9;
        o.a((Context) ZeusTransformUtils.preCheckCast(g.get(), Context.class, "com.obric.memorydata.plugin"));
        return;
    L9:
        if (n.f5615a == null) goto L12;
        n.f5615a.a();
        return;
    }

    @Override // com.loc.n
    public final void a() {
        o.a(this.d);
    }

    @Override // com.loc.n
    public final void a(fw r1, String r2, String r3) {
        r.a(r1, this.d, r3, r2);
    }

    @Override // com.loc.n
    public final void a(final fw r3, final boolean r4) {
        bp.a().b(new AnonymousClass1(this, r3, r4));     // Catch: Throwable -> L4 RejectedExecutionException -> L7
        return;
    L4:
        th = move-exception;
        th.printStackTrace();
        return;
    }

    @Override // com.loc.n
    public final void a(Throwable r1, int r2, String r3, String r4) {
        r.a(this.d, r1, r2, r3, r4);
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public final void uncaughtException(Thread r3, Throwable r4) {
        if (r4 != null) goto L4;
        return;
    L4:
        a(r4, 0, null, null);
        if (this.f5616b == null) goto L12;
        Thread.setDefaultUncaughtExceptionHandler(this.f5616b);     // Catch: Throwable -> L9
    L7:
        this.f5616b.uncaughtException(r3, r4);
        return;
    }
}
