package com.obric.oui.orecyclerview.widget;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes5.dex */
public final class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f14141a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f14142b;
    private final i.e<T> c;

    public static final class a<T> {
        private static final Object d = null;
        private static Executor e;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Executor f14143a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Executor f14144b;
        private final i.e<T> c;

        static {
            d = new Object();
        }

        public a(i.e<T> r1) {
            this.c = r1;
        }

        public c<T> a() {
            if (this.f14144b != null) goto L15;
            Object r0 = d;
            monitor-enter(r0);
        L11:
            th = move-exception;
            throw th;
        L7:
            if (e != null) goto L9;
            e = Executors.newFixedThreadPool(2);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.f14144b = e;
        L15:
            return new c(this.f14143a, this.f14144b, this.c);
        }
    }

    c(Executor r3, Executor r4, i.e<T> r5) {
        Executor r6 = (Executor) ZeusTransformUtils.wrapperContextForParams(r3, Executor.class, "com.obric.memorydata.plugin");
        Executor r7 = (Executor) ZeusTransformUtils.wrapperContextForParams(r4, Executor.class, "com.obric.memorydata.plugin");
        this.f14141a = r6;
        this.f14142b = r7;
        this.c = r5;
    }

    public Executor a() {
        return this.f14141a;
    }

    public Executor b() {
        return this.f14142b;
    }

    public i.e<T> c() {
        return this.c;
    }
}
