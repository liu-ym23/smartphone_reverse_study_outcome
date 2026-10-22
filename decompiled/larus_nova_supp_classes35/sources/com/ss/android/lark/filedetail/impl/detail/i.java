package com.ss.android.lark.filedetail.impl.detail;

import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final /* synthetic */ class i implements Runnable {
    public final /* synthetic */ FileTransmissionPresenter a;
    public final /* synthetic */ int b;

    public /* synthetic */ i(FileTransmissionPresenter r1, int r2, long r3) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FileTransmissionPresenter r0 = this.a;
        int r1 = this.b;
        WeakReference<z> r2 = r0.a;
        if (r2 == null) goto L10;
        z r3 = r2.get();
        if (r3 == null) goto L11;
        r3.dX(r1);
        return;
    L11:
        return;
    }
}
