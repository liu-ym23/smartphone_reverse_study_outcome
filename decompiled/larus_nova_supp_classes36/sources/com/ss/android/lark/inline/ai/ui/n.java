package com.ss.android.lark.inline.ai.ui;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements Runnable {
    public final /* synthetic */ InlineAIPanelController a;
    public final /* synthetic */ View b;

    public n(InlineAIPanelController r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.L.setMaxWidth(this.b.getMeasuredWidth() - 180);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
