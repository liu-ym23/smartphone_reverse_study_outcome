package com.bytedance.android.live.revlink.impl.behavior;

import com.larus.apm.impl.protector.RunnableProtector;
import io.reactivex.disposables.Disposable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class b implements Runnable, Disposable {
    public Function0<Unit> a;

    public final void dispose() {
        this.a = null;
    }

    public final boolean isDisposed() {
        if (this.a != null) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Function0<Unit> r0 = this.a;     // Catch: Throwable -> L6
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

    public b(Function0<Unit> r2) {
        Intrinsics.checkNotNullParameter(r2, "block");
        this.a = r2;
    }
}
