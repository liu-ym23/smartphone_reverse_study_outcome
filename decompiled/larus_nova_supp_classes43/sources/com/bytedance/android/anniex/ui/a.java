package com.bytedance.android.anniex.ui;

import com.bytedance.ies.bullet.kit.resourceloader.i;
import com.bytedance.ies.bullet.service.base.BulletLogger;
import com.bytedance.ies.bullet.service.base.d1;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a<V> implements Callable {
    public final /* synthetic */ d1 a;
    public final /* synthetic */ b b;

    public a(d1 r1, b r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.util.concurrent.Callable
    public final void call() {
        InputStream r0 = this.a.c();
        String r10 = null;
        if (r0 != null) goto L15;
    L8:
        ExecutorService r1 = BulletLogger.a;
        BulletLogger.k("lynx error, 100 error,delete local resource url=" + this.a.a, null, "XLynxKit", 2);
        ConcurrentHashMap r11 = i.a;
        WeakReference<AnnieXLynxView> r12 = this.b.d;
        if (r12 == null) goto L13;
        AnnieXLynxView r13 = r12.get();
        if (r13 == null) goto L13;
        r10 = r13.getBid();
    L13:
        i.b(r10, 2).c(this.a);
        return;
    L15:
        r0.reset();     // Catch: Throwable -> L6
    L6:
        th = move-exception;
        ExecutorService r14 = BulletLogger.a;
        BulletLogger.k("lynx error, read file failed " + th.getMessage(), null, "XLynxKit", 2);
        goto L8
    }

    @Override // java.util.concurrent.Callable
    public /* bridge */ /* synthetic */ Object call() {
        call();
        return Unit.INSTANCE;
    }
}
