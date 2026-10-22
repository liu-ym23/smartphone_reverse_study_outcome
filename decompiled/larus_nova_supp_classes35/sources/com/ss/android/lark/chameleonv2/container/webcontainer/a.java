package com.ss.android.lark.chameleonv2.container.webcontainer;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleon.ChameleonResourceLoadCallback;
import com.ss.android.lark.vfs.VFSPath;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements Runnable {
    public final /* synthetic */ ChameleonResourceLoadCallback a;
    public final /* synthetic */ VFSPath b;
    public final /* synthetic */ String c;

    public a(ChameleonResourceLoadCallback r1, VFSPath r2, String r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.onLoadSuccess(this.b, this.c);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
