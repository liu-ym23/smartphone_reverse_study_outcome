package com.ss.android.socialbase.downloader.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes6.dex */
public class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Object f15453a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Queue<b> f15454b;
    private a c;
    private Handler d;

    private class a extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f15455a;

        a(e r1, String r2) {
            this.f15455a = r1;
            super(r2);
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Looper r0 = getLooper();
            Object r1 = e.a(this.f15455a);
            monitor-enter(r1);
            e.a(this.f15455a, new Handler(r0));     // Catch: Throwable -> L12
            monitor-exit(r1);     // Catch: Throwable -> L12
        L7:
            if (e.b(this.f15455a).isEmpty() == true) goto L11;
            b r2 = (b) ZeusTransformUtils.preCheckCast(e.b(this.f15455a).poll(), b.class, "com.obric.memorydata.plugin");
            if (r2 == null) goto L7;
            e.c(this.f15455a).postDelayed(r2.f15456a, r2.f15457b);
            goto L7
        L11:
            return;
        L12:
            th = move-exception;
            throw th;
        }
    }

    private class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Runnable f15456a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public long f15457b;
        final /* synthetic */ e c;

        public b(e r3, Runnable r4, long r5) {
            Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
            this.c = r3;
            this.f15456a = r6;
            this.f15457b = r5;
        }
    }

    public e(String r2) {
        this.f15453a = new Object();
        this.f15454b = new ConcurrentLinkedQueue();
        this.c = new a(this, r2);
    }

    static /* synthetic */ Handler a(e r0, Handler r1) {
        r0.d = r1;
        return r1;
    }

    static /* synthetic */ Object a(e r0) {
        return r0.f15453a;
    }

    static /* synthetic */ Queue b(e r0) {
        return r0.f15454b;
    }

    static /* synthetic */ Handler c(e r0) {
        return r0.d;
    }

    public void a() {
        this.c.start();
    }

    public void a(Runnable r3) {
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), 0);
    }

    public void a(Runnable r4, long r5) {
        Runnable r6 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r4, Runnable.class, "com.obric.memorydata.plugin");
        if (this.d != null) goto L16;
        Object r0 = this.f15453a;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.d != null) goto L11;
        this.f15454b.add(new b(this, r6, r5));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L16:
        this.d.postDelayed(r6, r5);
    }

    public void b() {
        this.c.quit();
    }
}
