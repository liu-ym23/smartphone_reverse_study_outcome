package com.larksuite.framework.utils;

import android.view.PixelCopy;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class c0 implements Runnable {
    public final /* synthetic */ PixelCopy.OnPixelCopyFinishedListener a;

    public c0(d0.a r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onPixelCopyFinished(1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
