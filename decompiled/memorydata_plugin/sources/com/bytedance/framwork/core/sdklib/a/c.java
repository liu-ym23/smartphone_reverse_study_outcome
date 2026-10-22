package com.bytedance.framwork.core.sdklib.a;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final com.bytedance.framwork.core.sdklib.b.c.a<C0134c, Runnable> f2568a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final com.bytedance.framwork.core.sdklib.b.c.a<Message, Runnable> f2569b = null;
    private final HandlerThread c;
    private final Queue<C0134c> d;
    private final Queue<Message> e;
    private volatile Handler f;
    private final Object g;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f2570a;

        a(c r1) {
            this.f2570a = r1;
        }

        void a() {
        L3:
            if (c.c(this.f2570a).isEmpty() == true) goto L7;
            C0134c r0 = (C0134c) ZeusTransformUtils.preCheckCast(c.c(this.f2570a).poll(), C0134c.class, "com.obric.memorydata.plugin");
            if (c.b(this.f2570a) == null) goto L3;
            c.b(this.f2570a).sendMessageAtTime(r0.f2572a, r0.f2573b);
            goto L3
        }

        void b() {
        L3:
            if (c.d(this.f2570a).isEmpty() == true) goto L7;
            if (c.b(this.f2570a) == null) goto L3;
            c.b(this.f2570a).sendMessageAtFrontOfQueue((Message) ZeusTransformUtils.preCheckCast(c.d(this.f2570a).poll(), Message.class, "com.obric.memorydata.plugin"));
            goto L3
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }
    }

    class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ c f2571a;

        b(c r1, String r2) {
            this.f2571a = r1;
            super(r2);
        }

        /* JADX INFO: Infinite loop detected, blocks: 7, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = c.a(this.f2571a);
            monitor-enter(r0);
            c.a(this.f2571a, new Handler());     // Catch: Throwable -> L9
            monitor-exit(r0);     // Catch: Throwable -> L9
            c.b(this.f2571a).post(new a(this.f2571a));
        L13:
            Looper.loop();     // Catch: Throwable -> L12
        L9:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.framwork.core.sdklib.a.c$c, reason: collision with other inner class name */
    static class C0134c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f2572a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f2573b;

        C0134c(Message r1, long r2) {
            this.f2572a = r1;
            this.f2573b = r2;
        }
    }

    static {
        f2568a = new AnonymousClass1();
        f2569b = new AnonymousClass2();
    }

    public c(String r2) {
        this.d = new ConcurrentLinkedQueue();
        this.e = new ConcurrentLinkedQueue();
        this.g = new Object();
        this.c = new b(this, r2);
    }

    static /* synthetic */ Handler a(c r0, Handler r1) {
        r0.f = r1;
        return r1;
    }

    static /* synthetic */ Object a(c r0) {
        return r0.g;
    }

    static /* synthetic */ Handler b(c r0) {
        return r0.f;
    }

    private Message c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return Message.obtain(this.f, r4);
    }

    static /* synthetic */ Queue c(c r0) {
        return r0.d;
    }

    static /* synthetic */ Queue d(c r0) {
        return r0.e;
    }

    public void a() {
        this.c.start();
    }

    public final boolean a(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return b(r4, SystemClock.uptimeMillis() + r5);
    }

    public final boolean a(Runnable r3) {
        return a(c((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")), 0);
    }

    public final boolean a(Runnable r3, long r4) {
        return a(c((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")), r4);
    }

    public final void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.d.isEmpty() == true) goto L5;
    L6:
        com.bytedance.framwork.core.sdklib.b.c.a(this.d, r4, f2568a);
        com.bytedance.framwork.core.sdklib.b.c.a(this.e, r4, f2569b);
    L8:
        if (this.f == null) goto L11;
        this.f.removeCallbacks(r4);
        return;
    L11:
        return;
    L5:
        if (this.e.isEmpty() == true) goto L8;
        goto L6
    }

    public final boolean b(Message r3, long r4) {
        if (this.f != null) goto L17;
        Object r0 = this.g;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f != null) goto L11;
        this.d.add(new C0134c(r3, r4));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L17:
        return this.f.sendMessageAtTime(r3, r4);
    }
}
