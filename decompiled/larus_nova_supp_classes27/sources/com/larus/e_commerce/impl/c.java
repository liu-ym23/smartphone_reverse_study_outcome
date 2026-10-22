package com.larus.e_commerce.impl;

import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final /* synthetic */ class c implements Runnable {
    public final /* synthetic */ Function0 a;
    public final /* synthetic */ Function1 b;

    public /* synthetic */ c(k r1, l r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;
        Function1 r1 = this.b;
        int r2 = ThreadMethodProxy.currentThread().getPriority();
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), 10);
        e.a.getClass();
        e.b(r0, r1);
        ThreadMethodProxy.setPriority(ThreadMethodProxy.currentThread(), r2);
    }
}
