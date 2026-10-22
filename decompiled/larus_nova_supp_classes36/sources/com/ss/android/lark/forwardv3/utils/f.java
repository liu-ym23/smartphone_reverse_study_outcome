package com.ss.android.lark.forwardv3.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.keyboard.edittext2.KeyboardFunctionEditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class f implements Runnable {
    public final /* synthetic */ KeyboardFunctionEditText a;

    public f(KeyboardFunctionEditText r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
