package com.ss.android.lark.inline.ai.creationai;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements Runnable {
    public final /* synthetic */ CreationAIDragView a;

    public a(CreationAIDragView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Log.i("CreationAIDragView", "checkKeyboardTask, isKeyboardShowing = " + this.a.l);     // Catch: Throwable -> L4
        this.a.t(false, true, CreationAIDragView.AdjustTopSource.KEYBOARD_CHANGE);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
