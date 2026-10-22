package com.suite.lark.platform.feature.forward.doubao;

import android.content.Context;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.compose.foundation.toast.FlowToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ DoubaoForwardConfirmFragment a;
    public final /* synthetic */ String b;

    public f(DoubaoForwardConfirmFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L18;
        throw th;
    L18:
        return;
    L3:
        if (this.a.isAdded() == false) goto L13;
        Context r0 = this.a.getContext();     // Catch: Throwable -> L10
        if (r0 == null) goto L17;
        FlowToast.e(r0, this.b, 2131235476);     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }
}
