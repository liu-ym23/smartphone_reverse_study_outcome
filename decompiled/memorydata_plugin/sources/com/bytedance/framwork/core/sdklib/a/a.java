package com.bytedance.framwork.core.sdklib.a;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static long d = 30000;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    CopyOnWriteArraySet<b> f2564a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f2565b;
    private volatile boolean c;
    private final Runnable e;

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.a.a$a, reason: collision with other inner class name */
    private static final class C0133a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final a f2567a = null;

        static {
            f2567a = new a(null);
        }
    }

    static {
    }

    private a() {
        this.c = true;
        this.e = new AnonymousClass1(this);
        this.f2564a = new CopyOnWriteArraySet();
        c r0 = new c("AsyncEventManager-Thread");
        this.f2565b = r0;
        r0.a();
    }

    /* synthetic */ a(AnonymousClass1 r1) {
        this();
    }

    public static a a() {
        return C0133a.f2567a;
    }

    static /* synthetic */ boolean a(a r0) {
        return r0.c;
    }

    static /* synthetic */ long b() {
        return d;
    }

    static /* synthetic */ c b(a r0) {
        return r0.f2565b;
    }

    public void a(b r3) {
        b r4 = (b) ZeusTransformUtils.wrapperContextForParams(r3, b.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L11;
        this.f2564a.add(r4);     // Catch: Throwable -> L8
        if (this.c == false) goto L12;
        this.f2565b.b(this.e);     // Catch: Throwable -> L8
        this.f2565b.a(this.e, d);     // Catch: Throwable -> L8
        return;
    L12:
        return;
    L13:
        return;
    }

    public void a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 != null) goto L5;
        return;
    L5:
        this.f2565b.a(r4);
    }

    public void a(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L5;
        return;
    L5:
        this.f2565b.a(r5, r4);
    }
}
