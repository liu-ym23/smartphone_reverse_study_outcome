package com.obric.cae.location.city;

import android.os.Handler;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: classes3.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f7061a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f7062b;
    public final Handler c;
    public final long d;
    public final b e;
    public final c f;
    public final AtomicReference<String> g;
    public final AtomicBoolean h;
    public final AtomicBoolean i;
    public final AtomicBoolean j;
    public final AtomicBoolean k;
    public final a l;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f7063a;

        public a(e r1) {
            this.f7063a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            this.f7063a.j.set(false);
            this.f7063a.a(null);
        }
    }

    public interface b {
        ExecutorService a();
    }

    public interface c {
        void a(String r1);
    }

    public e(String r3, String r4, Handler r5, b r6, c r7) {
        b r8 = (b) ZeusTransformUtils.wrapperContextForParams(r6, b.class, "com.obric.memorydata.plugin");
        c r9 = (c) ZeusTransformUtils.wrapperContextForParams(r7, c.class, "com.obric.memorydata.plugin");
        this.g = new AtomicReference(null);
        this.h = new AtomicBoolean(false);
        this.i = new AtomicBoolean(false);
        this.j = new AtomicBoolean(false);
        this.k = new AtomicBoolean(false);
        this.l = new a(this);
        this.f7061a = r3;
        this.f7062b = r4;
        this.c = r5;
        this.d = 5000;
        this.e = r8;
        this.f = r9;
    }

    public final void a() {
        this.k.set(false);
    }

    public final void a(String r4) {
        if (r4 != null) goto L4;
    L6:
        this.i.set(true);
        if (this.h.compareAndSet(false, true) == true) goto L10;
        com.obric.cae.log.a.d(this.f7061a, "skip enqueue: " + this.f7062b + " sync already scheduled, preferredCity=" + r4);
        return;
    L10:
        this.e.a().execute(new $$Lambda$HH94JwnFMA9tCUxWgYlLGFh0s6w(this));
        return;
    L4:
        if (r4.isEmpty() == true) goto L6;
        this.g.set(r4);
        goto L6
    }

    public final void b() {
        if (this.j.compareAndSet(false, true) == true) goto L6;
        com.obric.cae.log.a.d(this.f7061a, "skip schedule retry: already scheduled");
        return;
    L6:
        this.c.postDelayed(this.l, this.d);
    }

    public final void c() {
    L23:
        this.i.set(false);     // Catch: Throwable -> L16
        String r2 = (String) ZeusTransformUtils.preCheckCast(this.g.getAndSet(null), String.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L16
        this.f.a(r2);     // Catch: Throwable -> L6
    L9:
        if (this.i.get() == true) goto L23;
        this.h.set(false);
        if (this.i.get() == true) goto L13;
        return;
    L13:
        if (this.h.compareAndSet(false, true) == false) goto L30;
        this.e.a().execute(new $$Lambda$HH94JwnFMA9tCUxWgYlLGFh0s6w(this));
        return;
    L30:
        return;
    L6:
        th = move-exception;
        com.obric.cae.log.a.b(this.f7061a, "error", th);     // Catch: Throwable -> L16
    L16:
        th = move-exception;
        this.h.set(false);
        if (this.i.get() == true) goto L20;
    L22:
        throw th;
    L20:
        if (this.h.compareAndSet(false, true) == false) goto L22;
        this.e.a().execute(new $$Lambda$HH94JwnFMA9tCUxWgYlLGFh0s6w(this));
        goto L22
    }
}
