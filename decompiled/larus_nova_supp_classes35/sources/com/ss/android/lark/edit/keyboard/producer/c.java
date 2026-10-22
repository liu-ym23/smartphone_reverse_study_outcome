package com.ss.android.lark.edit.keyboard.producer;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements Runnable {
    public final /* synthetic */ b a;

    public c(b r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        b r0 = this.a;     // Catch: Throwable -> L6
        BaseKeyboardHeightProducer.b r1 = r0.k;     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        Log.i("InsetsKBH#Producer", "notify keyboardChanged " + r0.k);     // Catch: Throwable -> L6
        r0.f.a(r1);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
