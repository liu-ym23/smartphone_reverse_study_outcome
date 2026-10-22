package com.ss.android.lark.forseti.node;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ ForsetiNode a;

    public c(ForsetiNode r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewParent r0 = this.a.h.getParent();     // Catch: Throwable -> L4
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.view.ViewGroup");     // Catch: Throwable -> L4
        ((ViewGroup) r0).removeView(this.a.h);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
