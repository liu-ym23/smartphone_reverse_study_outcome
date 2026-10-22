package com.loc;

import android.text.TextUtils;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: classes3.dex */
public final class bn implements ThreadFactory {
    private static final int k = 0;
    private static final int l = 0;
    private static final int m = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicLong f5361a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ThreadFactory f5362b;
    private final Thread.UncaughtExceptionHandler c;
    private final String d;
    private final Integer e;
    private final Boolean f;
    private final int g;
    private final int h;
    private final BlockingQueue<Runnable> i;
    private final int j;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ThreadFactory f5365a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Thread.UncaughtExceptionHandler f5366b;
        private String c;
        private Integer d;
        private Boolean e;
        private int f;
        private int g;
        private int h;
        private BlockingQueue<Runnable> i;

        public a() {
            this.f = bn.e();
            this.g = bn.f();
            this.h = 30;
        }

        static /* synthetic */ ThreadFactory a(a r0) {
            return r0.f5365a;
        }

        static /* synthetic */ int b(a r0) {
            return r0.f;
        }

        private void b() {
            this.f5365a = null;
            this.f5366b = null;
            this.c = null;
            this.d = null;
            this.e = null;
        }

        static /* synthetic */ int c(a r0) {
            return r0.h;
        }

        static /* synthetic */ BlockingQueue d(a r0) {
            return r0.i;
        }

        static /* synthetic */ String e(a r0) {
            return r0.c;
        }

        static /* synthetic */ Integer f(a r0) {
            return r0.d;
        }

        static /* synthetic */ Boolean g(a r0) {
            return r0.e;
        }

        static /* synthetic */ Thread.UncaughtExceptionHandler h(a r0) {
            return r0.f5366b;
        }

        public final a a(String r1) {
            this.c = r1;
            return this;
        }

        public final a a(Thread.UncaughtExceptionHandler r3) {
            Thread.UncaughtExceptionHandler r4 = (Thread.UncaughtExceptionHandler) ZeusTransformUtils.wrapperContextForParams(r3, Thread.UncaughtExceptionHandler.class, "com.obric.memorydata.plugin");
            Objects.requireNonNull(r4, "Uncaught exception handler must not be null!");
            this.f5366b = r4;
            return this;
        }

        public final bn a() {
            bn r0 = new bn(this, 0);
            b();
            return r0;
        }
    }

    static {
        int r0 = Runtime.getRuntime().availableProcessors();
        k = r0;
        l = Math.max(2, Math.min(r0 - 1, 4));
        m = (r0 * 2) + 1;
    }

    private bn(a r3) {
        if (a.a(r3) != null) goto L5;
        ThreadFactory r0 = Executors.defaultThreadFactory();
    L6:
        this.f5362b = r0;
        int r1 = a.b(r3);
        this.g = r1;
        int r2 = m;
        this.h = r2;
        if (r2 < r1) goto L19;
        this.j = a.c(r3);
        if (a.d(r3) != null) goto L11;
        BlockingQueue<Runnable> r4 = new LinkedBlockingQueue(256);
    L12:
        this.i = r4;
        if (TextUtils.isEmpty(a.e(r3)) == false) goto L15;
        String r5 = "amap-threadpool";
    L16:
        this.d = r5;
        this.e = a.f(r3);
        this.f = a.g(r3);
        this.c = a.h(r3);
        this.f5361a = new AtomicLong();
        return;
    L15:
        r5 = a.e(r3);
        goto L16
    L11:
        r4 = a.d(r3);
        goto L12
    L19:
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    L5:
        r0 = a.a(r3);
        goto L6
    }

    /* synthetic */ bn(a r1, byte r2) {
        this(r1);
    }

    static /* synthetic */ int e() {
        return l;
    }

    static /* synthetic */ int f() {
        return m;
    }

    private ThreadFactory g() {
        return this.f5362b;
    }

    private String h() {
        return this.d;
    }

    private Boolean i() {
        return this.f;
    }

    private Integer j() {
        return this.e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.c;
    }

    public final int a() {
        return this.g;
    }

    public final int b() {
        return this.h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.i;
    }

    public final int d() {
        return this.j;
    }

    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable r5) {
        final Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r5, Runnable.class, "com.obric.memorydata.plugin");
        new AnonymousClass1(this, r6);
        Thread r7 = g().newThread(r6);
        if (h() == null) goto L6;
        r7.setName(String.format(h() + "-%d", new Object[]{Long.valueOf(this.f5361a.incrementAndGet())}));
    L6:
        if (k() == null) goto L9;
        r7.setUncaughtExceptionHandler(k());
    L9:
        if (j() == null) goto L12;
        r7.setPriority(j().intValue());
    L12:
        if (i() == null) goto L14;
        r7.setDaemon(i().booleanValue());
    L14:
        return r7;
    }
}
