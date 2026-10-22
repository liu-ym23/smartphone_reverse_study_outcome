package com.larksuite.framework.callback;

import android.os.Handler;
import androidx.arch.core.util.Function;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c extends a {
    public final WeakHashMap<Runnable, WeakReference<Runnable>> b;

    public final void d() {
        monitor-enter(this);
        Iterator<Runnable> r0 = this.b.keySet().iterator();     // Catch: Throwable -> L14
    L5:
        if (r0.hasNext() == false) goto L11;
        Runnable r1 = r0.next();     // Catch: Throwable -> L14
        WeakReference<Runnable> r2 = this.b.get(r1);     // Catch: Throwable -> L14
        if (r2 == null) goto L5;
        Runnable r3 = r2.get();     // Catch: Throwable -> L14
        if (r3 == null) goto L5;
        this.a.removeCallbacks(r3);     // Catch: Throwable -> L14
        goto L5
    L11:
        this.b.clear();     // Catch: Throwable -> L14
        monitor-exit(this);     // Catch: Throwable -> L14
        return;
    L14:
        th = move-exception;
        throw th;
    }

    public c(Handler r1) {
        super(r1);
        this.b = new WeakHashMap();
    }

    @Override // com.larksuite.framework.callback.a
    public final void a(Runnable r4) {
        Function<? super Runnable, ? extends Runnable> r0 = b.a;
        if (r0 == null) goto L5;
        Runnable r1 = (Runnable) r0.apply(r4);
    L6:
        monitor-enter(this);
        this.b.put(r4, new WeakReference(r1));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        super.a(r1);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r1 = r4;
        goto L6
    }

    public final void c(Runnable r2) {
        monitor-enter(this);
        WeakReference<Runnable> r3 = this.b.remove(r2);     // Catch: Throwable -> L12
        if (r3 != null) goto L7;
        monitor-exit(this);     // Catch: Throwable -> L12
        return;
    L7:
        Runnable r4 = r3.get();     // Catch: Throwable -> L12
        monitor-exit(this);     // Catch: Throwable -> L12
        if (r4 == null) goto L16;
        this.a.removeCallbacks(r4);
        return;
    L16:
        return;
    L12:
        th = move-exception;
        throw th;
    }

    @Override // com.larksuite.framework.callback.a
    public final void b(Runnable r4, long r5) {
        Function<? super Runnable, ? extends Runnable> r0 = b.a;
        if (r0 == null) goto L5;
        Runnable r1 = (Runnable) r0.apply(r4);
    L6:
        monitor-enter(this);
        this.b.put(r4, new WeakReference(r1));     // Catch: Throwable -> L11
        monitor-exit(this);     // Catch: Throwable -> L11
        super.b(r1, r5);
        return;
    L11:
        th = move-exception;
        throw th;
    L5:
        r1 = r4;
        goto L6
    }
}
