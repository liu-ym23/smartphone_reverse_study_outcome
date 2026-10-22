package com.larus.business.debug.base.controller.libra;

import com.larus.apm.impl.protector.RunnableProtector;
import java.util.TimerTask;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class d$a extends TimerTask {
    @Override // java.util.TimerTask, java.lang.Runnable
    public final void run() {
        String r0 = d.a;     // Catch: Throwable -> L4
        Function1 r1 = new b();     // Catch: Throwable -> L4
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new CriticalLibraController$fetchAndCompareSetting$1(r1, null), 3, null);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d$a() {
    }
}
