package com.suite.lark.platform.feature.forward.doubao;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b0 implements Runnable {
    public final /* synthetic */ ForwardDoubaoActivity a;

    public b0(ForwardDoubaoActivity r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ForwardDoubaoActivity r0 = this.a;     // Catch: Throwable -> L7
        int r1 = ForwardDoubaoActivity.p;     // Catch: Throwable -> L7
        r0.getClass();     // Catch: Throwable -> L7
        this.a.B1();     // Catch: Throwable -> L7
        View r2 = this.a.l;     // Catch: Throwable -> L7
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("bottomSheetContainer");     // Catch: Throwable -> L7
        r2 = null;
    L5:
        r2.setTranslationY(this.a.j);     // Catch: Throwable -> L7
        ForwardDoubaoActivity.A1(this.a, 0.0f, 1.0f, null, 12);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
