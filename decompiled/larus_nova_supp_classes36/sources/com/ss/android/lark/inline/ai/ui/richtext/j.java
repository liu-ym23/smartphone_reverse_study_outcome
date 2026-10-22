package com.ss.android.lark.inline.ai.ui.richtext;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class j implements Runnable {
    public final /* synthetic */ RichtextPreviewWebview a;

    public j(RichtextPreviewWebview r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.setVerticalScrollBarEnabled(false);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
