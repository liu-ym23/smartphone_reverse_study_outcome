package com.bytedance.android.live.core.utils;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k2 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ boolean b;

    public k2(View r1) {
        this.a = r1;
        this.b = false;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (this.b == false) goto L5;
        UtilityKotlinExtentionsKt.t(this.a);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        UtilityKotlinExtentionsKt.u(this.a);     // Catch: Throwable -> L7
        goto L12
    }
}
