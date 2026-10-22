package com.bytedance.applog.p;

import android.os.Handler;
import android.os.HandlerThread;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: classes.dex */
public class e extends HandlerThread {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f1760a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile Handler f1761b;
    private final Object c;
    private volatile boolean d;
    private final LinkedList<Runnable> e;

    private e() {
        super("TeaThread");
        this.c = new Object();
        this.d = false;
        this.e = new LinkedList();
    }

    public static e a() {
        if (f1760a != null) goto L15;
        monitor-enter(e.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (f1760a != null) goto L9;
        f1760a = new e();     // Catch: Throwable -> L11
        f1760a.start();     // Catch: Throwable -> L11
    L9:
        monitor-exit(e.class);     // Catch: Throwable -> L11
    L15:
        return f1760a;
    }

    public void a(Runnable r3) {
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"), 0);
    }

    public void a(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 != null) goto L6;
        return;
    L6:
        if (this.d == false) goto L8;
        c(r5, r4);
        return;
    L8:
        Object r0 = this.c;
        monitor-enter(r0);
    L19:
        th = move-exception;
        throw th;
    L11:
        if (this.d == false) goto L14;
        c(r5, r4);     // Catch: Throwable -> L19
    L17:
        monitor-exit(r0);     // Catch: Throwable -> L19
        return;
    L14:
        if (this.e.size() <= 1000) goto L16;
        this.e.poll();     // Catch: Throwable -> L19
    L16:
        this.e.add(r5);     // Catch: Throwable -> L19
        goto L17
    }

    public Handler b() {
        if (this.f1761b != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.f1761b != null) goto L8;
        this.f1761b = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.f1761b;
    }

    public void b(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r4 == null) goto L6;
        b().post(r4);
        return;
    }

    public void b(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        c(r5);
        c(r5, r4);
        return;
    }

    public void c(Runnable r3) {
        Runnable r4 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        b().removeCallbacks(r4);
    }

    public void c(Runnable r3, long r4) {
        Runnable r5 = (Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin");
        if (r5 == null) goto L6;
        b().postDelayed(r5, r4);
        return;
    }

    public void d(Runnable r3) {
        a((Runnable) ZeusTransformUtils.wrapperContextForParams(r3, Runnable.class, "com.obric.memorydata.plugin"));
    }

    @Override // android.os.HandlerThread
    public void onLooperPrepared() {
        super.onLooperPrepared();
        Object r0 = this.c;
        monitor-enter(r0);
        this.d = true;     // Catch: Throwable -> L13
        ArrayList r1 = new ArrayList(this.e);     // Catch: Throwable -> L13
        this.e.clear();     // Catch: Throwable -> L13
        if (r1.isEmpty() == true) goto L11;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L13
    L9:
        if (r2.hasNext() == false) goto L11;
        b((Runnable) ZeusTransformUtils.preCheckCast(r2.next(), Runnable.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L13
    L11:
        monitor-exit(r0);     // Catch: Throwable -> L13
        return;
    L13:
        th = move-exception;
        throw th;
    }
}
