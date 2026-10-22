package com.bytedance.apm.l;

import com.bytedance.monitor.util.thread.AsyncTaskType;
import com.obric.aikernel.sdk.ext.CozeCloudExt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f1396a = 30000;
    private static long f = 30000;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    CopyOnWriteArraySet<InterfaceC0091b> f1397b;
    CopyOnWriteArraySet<InterfaceC0091b> c;
    private volatile ExecutorService d;
    private volatile boolean e;
    private com.bytedance.monitor.util.thread.c g;
    private final com.bytedance.monitor.util.thread.d h;
    private final com.bytedance.monitor.util.thread.d i;

    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final b f1401a = null;

        static {
            f1401a = new b(null);
        }
    }

    /* JADX INFO: renamed from: com.bytedance.apm.l.b$b, reason: collision with other inner class name */
    public interface InterfaceC0091b {
        void a(long r1);
    }

    static {
    }

    private b() {
        this.e = true;
        this.h = new AnonymousClass1(this);
        this.i = new AnonymousClass2(this);
        this.f1397b = new CopyOnWriteArraySet();
        this.c = new CopyOnWriteArraySet();
        this.g = com.bytedance.monitor.util.thread.b.a();
    }

    /* synthetic */ b(AnonymousClass1 r1) {
        this();
    }

    public static b a() {
        return a.f1401a;
    }

    private com.bytedance.monitor.util.thread.d a(Runnable r2, String r3) {
        return com.bytedance.monitor.util.thread.b.a("AsyncEventManager-" + r3, (Runnable) ZeusTransformUtils.wrapperContextForParams(r2, Runnable.class, "com.obric.memorydata.plugin"));
    }

    static /* synthetic */ boolean a(b r0) {
        return r0.e;
    }

    static /* synthetic */ long c() {
        return f;
    }

    public void a(InterfaceC0091b r3) {
        InterfaceC0091b r4 = (InterfaceC0091b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0091b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L13;
        if (this.e == true) goto L7;
        return;
    L7:
        if (this.f1397b.contains(r4) == true) goto L15;
        this.f1397b.add(r4);     // Catch: Throwable -> L10
        a(this.h);     // Catch: Throwable -> L10
        a(this.h, f1396a);     // Catch: Throwable -> L10
        return;
    L15:
        return;
    L16:
        return;
    }

    public void a(com.bytedance.monitor.util.thread.d r3) {
        com.bytedance.monitor.util.thread.d r4 = (com.bytedance.monitor.util.thread.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.monitor.util.thread.d.class, "com.obric.memorydata.plugin");
        com.bytedance.monitor.util.thread.c r2 = this.g;
        if (r2 == null) goto L8;
        if (r4 == null) goto L9;
        r2.b(r4);
        return;
    L9:
        return;
    }

    public void a(com.bytedance.monitor.util.thread.d r3, long r4) {
        com.bytedance.monitor.util.thread.d r5 = (com.bytedance.monitor.util.thread.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.monitor.util.thread.d.class, "com.obric.memorydata.plugin");
        if (this.g == null) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.e == false) goto L12;
        this.g.a(r5, r4);
        return;
    L12:
        return;
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.g == null) goto L10;
        if (r4 != null) goto L6;
        return;
    L6:
        if (this.e == false) goto L12;
        this.g.a(a(r4, CozeCloudExt.API_KEY_HTTP_POST_METHOD));
        return;
    L12:
        return;
    }

    public void a(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.g == null) goto L10;
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.e == false) goto L12;
        this.g.a(a(r5, "postDelayed"), r4);
        return;
    L12:
        return;
    }

    public void b(InterfaceC0091b r3) {
        InterfaceC0091b r4 = (InterfaceC0091b) ZeusTransformUtils.wrapperContextForParams(r3, InterfaceC0091b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L9;
        this.f1397b.remove(r4);     // Catch: Throwable -> L6
        return;
    L10:
        return;
    }

    public void b(com.bytedance.monitor.util.thread.d r3, long r4) {
        com.bytedance.monitor.util.thread.d r5 = (com.bytedance.monitor.util.thread.d) ZeusTransformUtils.wrapperContextForParams(r3, com.bytedance.monitor.util.thread.d.class, "com.obric.memorydata.plugin");
        com.bytedance.monitor.util.thread.c r2 = this.g;
        if (r2 == null) goto L8;
        if (r5 == null) goto L9;
        r2.a(r5, r4);
        return;
    L9:
        return;
    }

    public void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        com.bytedance.monitor.util.thread.c r0 = this.g;
        if (r0 == null) goto L8;
        if (r4 == null) goto L9;
        r0.a(a(r4, CozeCloudExt.API_KEY_HTTP_POST_METHOD));
        return;
    L9:
        return;
    }

    public boolean b() {
        if (this.g != null) goto L5;
    L7:
        return false;
    L5:
        if (Thread.currentThread().getId() != this.g.a(AsyncTaskType.LIGHT_WEIGHT)) goto L7;
        return true;
    }

    public void c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.d != null) goto L17;
        monitor-enter(this);
    L14:
        th = move-exception;
        throw th;
    L6:
        if (this.d != null) goto L12;
        com.bytedance.monitor.util.thread.c r0 = this.g;     // Catch: Throwable -> L14
        if (r0 == null) goto L11;
        ExecutorService r1 = r0.b();     // Catch: Throwable -> L14
    L10:
        this.d = r1;     // Catch: Throwable -> L14
        goto L12
    L11:
        r1 = Executors.newFixedThreadPool(1, new AnonymousClass3(this));     // Catch: Throwable -> L14
    L12:
        monitor-exit(this);     // Catch: Throwable -> L14
    L17:
        this.d.submit(r4);
    }
}
