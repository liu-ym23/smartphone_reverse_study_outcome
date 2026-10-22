package com.bytedance.android.ec.core.toolbox.rxanimation;

import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements Runnable {
    public final /* synthetic */ Function0 a;

    public b(Function0 r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0 r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        Unit r1 = (Unit) r0.invoke();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
