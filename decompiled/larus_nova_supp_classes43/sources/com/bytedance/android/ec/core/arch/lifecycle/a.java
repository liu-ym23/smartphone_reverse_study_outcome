package com.bytedance.android.ec.core.arch.lifecycle;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.ArrayDeque;
import kotlin.coroutines.CoroutineContext;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ CoroutineContext b;
    public final /* synthetic */ Runnable c;

    public a(b r1, CoroutineContext r10, Runnable r11) {
        this.a = r1;
        this.b = r10;
        this.c = r11;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r0 = this.a;     // Catch: Throwable -> L7
        Runnable r1 = this.c;     // Catch: Throwable -> L7
        if (((ArrayDeque) r0.d).offer(r1) == false) goto L6;
        r0.a();     // Catch: Throwable -> L7
        return;
    L6:
        throw new IllegalStateException("cannot enqueue any more runnables".toString());     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
