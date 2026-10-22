package com.ss.android.lark.inline.ai.ui;

import com.larksuite.framework.utils.KeyboardUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements Runnable {
    public final /* synthetic */ InlineAIDragView a;

    public final void a() {
        Log.i("InlineAIDragView", "checkShowRunnable, needStartShowWhenKeyboardShow = " + this.a.O);
        InlineAIDragView r0 = this.a;
        if (r0.O == true) goto L5;
        return;
    L5:
        KeyboardUtils.showKeyboard(r0.a);
        this.a.b.postDelayed(this, 200);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public d(InlineAIDragView r1) {
        this.a = r1;
    }
}
