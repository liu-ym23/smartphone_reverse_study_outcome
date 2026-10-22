package com.ss.android.lark.inline.ai.ui;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ InlineAIDragView a;

    public c(InlineAIDragView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("InlineAIDragView", "checkKeyboardTask, isKeyboardShowing = " + this.a.k);     // Catch: Throwable -> L4
        this.a.n(false, true, InlineAIDragView.AdjustTopSource.KEYBOARD_CHANGE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
