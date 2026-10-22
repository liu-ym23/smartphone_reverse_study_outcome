package com.ss.android.common.applog;

import android.os.Handler;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final class k0 extends PthreadHandlerThreadV2 {
    public static volatile k0 g;
    public Handler c;
    public final Object d;
    public volatile boolean e;
    public final LinkedList<Runnable> f;

    public k0() {
        super("TeaThread");
        this.d = new Object();
        this.e = false;
        this.f = new LinkedList();
    }

    public static k0 d() {
        if (g != null) goto L15;
        monitor-enter(k0.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (g != null) goto L9;
        g = new k0();     // Catch: Throwable -> L11
        ThreadMethodProxy.start(g);     // Catch: Throwable -> L11
    L9:
        monitor-exit(k0.class);     // Catch: Throwable -> L11
    L15:
        return g;
    }

    public final Handler e() {
        if (this.c != null) goto L14;
        monitor-enter(this);
    L10:
        th = move-exception;
        throw th;
    L6:
        if (this.c != null) goto L8;
        this.c = new Handler(getLooper());     // Catch: Throwable -> L10
    L8:
        monitor-exit(this);     // Catch: Throwable -> L10
    L14:
        return this.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onLooperPrepared() {
        super/*android.os.HandlerThread*/.onLooperPrepared();
        Object r0 = this.d;
        monitor-enter(r0);
        this.e = true;     // Catch: Throwable -> L15
        ArrayList r1 = new ArrayList(this.f);     // Catch: Throwable -> L15
        this.f.clear();     // Catch: Throwable -> L15
        if (r1.isEmpty() == true) goto L13;
        Iterator r2 = r1.iterator();     // Catch: Throwable -> L15
    L9:
        if (r2.hasNext() == false) goto L13;
        Runnable r3 = (Runnable) r2.next();     // Catch: Throwable -> L15
        if (r3 == null) goto L9;
        e().post(r3);     // Catch: Throwable -> L15
    L13:
        monitor-exit(r0);     // Catch: Throwable -> L15
        return;
    L15:
        th = move-exception;
        throw th;
    }

    public final void b(Runnable r5) {
        if (this.e == false) goto L5;
        e().postDelayed(r5, 0);
        return;
    L5:
        Object r0 = this.d;
        monitor-enter(r0);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.e == false) goto L11;
        e().postDelayed(r5, 0);     // Catch: Throwable -> L16
    L14:
        monitor-exit(r0);     // Catch: Throwable -> L16
        return;
    L11:
        if (this.f.size() <= 1000) goto L13;
        this.f.poll();     // Catch: Throwable -> L16
    L13:
        this.f.add(r5);     // Catch: Throwable -> L16
        goto L14
    }
}
