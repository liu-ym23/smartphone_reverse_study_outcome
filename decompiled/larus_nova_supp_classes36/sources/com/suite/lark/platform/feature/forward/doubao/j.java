package com.suite.lark.platform.feature.forward.doubao;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.compose.foundation.toast.FlowToast;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements Runnable {
    public final /* synthetic */ DoubaoForwardFragment a;
    public final /* synthetic */ String b;

    public j(DoubaoForwardFragment r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FlowToast.e(this.a.requireContext(), this.b, 2131235476);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
