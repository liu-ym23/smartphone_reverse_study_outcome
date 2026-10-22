package com.bytedance.apm.l;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.bytedance.apm.h;
import com.bytedance.apm.util.i;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final i.a<c, Runnable> f1408b = null;
    static final i.a<Message, Runnable> c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Handler f1409a;
    private final HandlerThread d;
    private final Queue<c> e;
    private final Queue<Message> f;
    private long g;
    private final Object h;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f1410a;

        a(e r1) {
            this.f1410a = r1;
        }

        void a() {
        L3:
            if (e.b(this.f1410a).isEmpty() == true) goto L14;
            Object r0 = e.a(this.f1410a);
            monitor-enter(r0);
            c r1 = (c) ZeusTransformUtils.preCheckCast(e.b(this.f1410a).poll(), c.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L11
            if (this.f1410a.f1409a == null) goto L9;
            this.f1410a.f1409a.sendMessageAtTime(r1.f1412a, r1.f1413b);     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        void b() {
        L3:
            if (e.c(this.f1410a).isEmpty() == true) goto L14;
            Object r0 = e.a(this.f1410a);
            monitor-enter(r0);
            if (this.f1410a.f1409a == null) goto L9;
            this.f1410a.f1409a.sendMessageAtFrontOfQueue((Message) ZeusTransformUtils.preCheckCast(e.c(this.f1410a).poll(), Message.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L11
        L9:
            monitor-exit(r0);     // Catch: Throwable -> L11
        L11:
            th = move-exception;
            throw th;
        }

        @Override // java.lang.Runnable
        public void run() {
            b();
            a();
        }
    }

    class b extends HandlerThread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ e f1411a;

        b(e r1, String r2) {
            this.f1411a = r1;
            super(r2);
        }

        /* JADX INFO: Infinite loop detected, blocks: 9, insns: 0 */
        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            super.onLooperPrepared();
            Object r0 = e.a(this.f1411a);
            monitor-enter(r0);
            e r1 = this.f1411a;     // Catch: Throwable -> L11
            r1.f1409a = new Handler();     // Catch: Throwable -> L11
            monitor-exit(r0);     // Catch: Throwable -> L11
            this.f1411a.f1409a.post(new a(this.f1411a));
        L16:
            Looper.loop();     // Catch: Throwable -> L9
        L9:
            th = move-exception;
            h.a().b(th, CommonConsts.APM_INNER_ERROR);
        L11:
            th = move-exception;
            throw th;
        }
    }

    static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Message f1412a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        long f1413b;

        c(Message r1, long r2) {
            this.f1412a = r1;
            this.f1413b = r2;
        }
    }

    static {
        f1408b = new AnonymousClass1();
        c = new AnonymousClass2();
    }

    public e(String r3) {
        this.e = new ConcurrentLinkedQueue();
        this.f = new ConcurrentLinkedQueue();
        this.g = 0;
        this.h = new Object();
        this.d = new b(this, r3);
    }

    static /* synthetic */ Object a(e r0) {
        return r0.h;
    }

    static /* synthetic */ Queue b(e r0) {
        return r0.e;
    }

    static /* synthetic */ Queue c(e r0) {
        return r0.f;
    }

    public Message a(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        return Message.obtain(this.f1409a, r4);
    }

    public void a() {
        this.d.start();
    }

    public final boolean a(Message r4, long r5) {
        if (r5 >= 0) goto L6;
        r5 = 0;
    L6:
        return b(r4, SystemClock.uptimeMillis() + r5);
    }

    public final boolean a(Runnable r3, long r4) {
        return a(a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")), r4);
    }

    public boolean b() {
        if (this.f1409a == null) goto L5;
        return true;
    L5:
        return false;
    }

    public final boolean b(Message r3, long r4) {
        if (this.f1409a != null) goto L17;
        Object r0 = this.h;
        monitor-enter(r0);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (this.f1409a != null) goto L11;
        this.e.add(new c(r3, r4));     // Catch: Throwable -> L13
        monitor-exit(r0);     // Catch: Throwable -> L13
        return true;
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
    L17:
        return this.f1409a.sendMessageAtTime(r3, r4);
    }

    public final boolean b(Runnable r3) {
        return a(a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin")), 0);
    }

    public final void c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (this.e.isEmpty() == true) goto L5;
    L6:
        i.a(this.e, r4, f1408b);
        i.a(this.f, r4, c);
    L8:
        if (this.f1409a == null) goto L11;
        this.f1409a.removeCallbacks(r4);
        return;
    L11:
        return;
    L5:
        if (this.f.isEmpty() == true) goto L8;
        goto L6
    }
}
