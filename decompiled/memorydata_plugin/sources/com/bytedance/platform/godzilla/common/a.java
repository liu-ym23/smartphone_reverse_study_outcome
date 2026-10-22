package com.bytedance.platform.godzilla.common;

import android.os.Looper;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public class a implements Thread.UncaughtExceptionHandler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f2990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f2991b;
    private final List<g> c;

    public a() {
        this.c = new LinkedList();
    }

    private void a(Thread r2, Throwable r3) {
        Thread.UncaughtExceptionHandler r0 = this.f2991b;
        if (r0 == null) goto L7;
        if (r0 == this) goto L8;
        r0.uncaughtException(r2, r3);
        return;
    L8:
        return;
    }

    private boolean a(Throwable r3) {
        if (r3 != null) goto L5;
        return false;
    L5:
        int r0 = 0;
    L6:
        if (r3 == null) goto L16;
        if (ZeusTransformUtils.instanceOf(r3, OutOfMemoryError.class) == true) goto L9;
        if (r0 > 20) goto L13;
        r0 = r0 + 1;     // Catch: Throwable -> L17
        r3 = r3.getCause();     // Catch: Throwable -> L17
    L13:
        return false;
    L9:
        return true;
    L16:
        return false;
    }

    private boolean b(Thread r5, Throwable r6) {
        List<g> r0 = this.c;     // Catch: Throwable -> L19
        monitor-enter(r0);     // Catch: Throwable -> L19
        Iterator<g> r4 = this.c.iterator();     // Catch: Throwable -> L14
    L6:
        if (r4.hasNext() == false) goto L12;
        if (((g) ZeusTransformUtils.preCheckCast(r4.next(), g.class, "com.obric.memorydata.plugin")).a(r5, r6) == false) goto L6;
        monitor-exit(r0);     // Catch: Throwable -> L14
        return true;
    L12:
        monitor-exit(r0);     // Catch: Throwable -> L14
        return false;
    L14:
        th = move-exception;
        throw th;     // Catch: Throwable -> L19
    L25:
        return false;
    }

    public void a() {
        List<g> r0 = this.c;
        monitor-enter(r0);
        this.c.clear();     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public boolean a(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        List<g> r0 = this.c;
        monitor-enter(r0);
        boolean r2 = this.c.add(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    public void b() {
        if (this.f2990a == false) goto L5;
        return;
    L5:
        Thread.UncaughtExceptionHandler r0 = Thread.getDefaultUncaughtExceptionHandler();
        this.f2991b = r0;
        if (r0 == this) goto L8;
        Thread.setDefaultUncaughtExceptionHandler(this);
    L9:
        this.f2990a = true;
        return;
    L8:
        this.f2991b = null;
        goto L9
    }

    public boolean b(g r3) {
        g r4 = (g) ZeusTransformUtils.wrapperContextForParams(r3, g.class, "com.obric.memorydata.plugin");
        List<g> r0 = this.c;
        monitor-enter(r0);
        boolean r2 = this.c.remove(r4);     // Catch: Throwable -> L7
        monitor-exit(r0);     // Catch: Throwable -> L7
        return r2;
    L7:
        th = move-exception;
        throw th;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread r2, Throwable e) {
    L18:
        th = move-exception;
        a(r2, th);
        return;
    L3:
        if (a(e) == false) goto L5;
    L16:
        a(r2, e);     // Catch: Throwable -> L18
        return;
    L5:
        if (b(r2, e) == false) goto L16;
        if (r2 != null) goto L8;
        return;
    L8:
        if (r2.getName().equals("main") == false) goto L31;
    L21:
        Looper.loop();     // Catch: Exception -> L11 Throwable -> L18
    L11:
        e = e;
        if (a(e) == true) goto L16;
        if (b(r2, e) == true) goto L21;
    }
}
