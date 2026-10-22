package com.ss.android.lark.keyboard.editor.input;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class y implements Runnable {
    public final /* synthetic */ RichTextInputShrinkPlugin a;

    public y(RichTextInputShrinkPlugin r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.X().findViewById(2131380993).setBackgroundResource(2131238372);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
