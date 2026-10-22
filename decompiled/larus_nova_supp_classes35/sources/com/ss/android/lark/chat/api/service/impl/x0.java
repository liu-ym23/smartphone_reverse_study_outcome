package com.ss.android.lark.chat.api.service.impl;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;
import kotlin.Lazy;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class x0 implements Runnable {
    public static final x0 a = null;

    static {
        a = new x0();
    }

    public x0() {
    }

    public static void a() {
        Lazy<PreviewCache> r0 = PreviewCache.f;
        PreviewCache r1 = PreviewCache.a.a();
        r1.getClass();
        r1.d.writeLock().lock();     // Catch: Throwable -> L6
        Log.i("PreviewPushCache", "preview push cache clear");     // Catch: Throwable -> L6
        r1.b.clear();     // Catch: Throwable -> L6
        r1.c.clear();     // Catch: Throwable -> L6
        r1.d.writeLock().unlock();
        return;
    L6:
        th = move-exception;
        r1.d.writeLock().unlock();
        throw th;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
