package com.bytedance.android.annie.bridge.method;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class n implements Runnable {
    public final /* synthetic */ DownloadFileMethod a;
    public final /* synthetic */ DownloadFileMethod.DownloadFileResModel b;

    public n(DownloadFileMethod r1, DownloadFileMethod.DownloadFileResModel r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.finishWithResult(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
