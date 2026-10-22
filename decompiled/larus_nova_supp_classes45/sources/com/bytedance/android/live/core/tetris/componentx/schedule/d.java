package com.bytedance.android.live.core.tetris.componentx.schedule;

import com.bytedance.android.live.core.log.ALogger;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class d implements Runnable {
    public final /* synthetic */ e a;
    public final /* synthetic */ Ref.ObjectRef b;

    public d(e r1, Ref.ObjectRef r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ALogger.i(this.a.b, "loadedbatch = " + this.a.e() + " ____  loadingbatch = " + this.a.e + " __  batchLoadDelayTime = " + ((Long) this.b.element));
        this.a.f();
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
