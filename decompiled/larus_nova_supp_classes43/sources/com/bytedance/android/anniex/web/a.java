package com.bytedance.android.anniex.web;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements Runnable {
    public final /* synthetic */ AnnieXWebKit a;

    public a(AnnieXWebKit r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnnieXWebKit r0 = this.a;     // Catch: Throwable -> L4
        AnnieXWebKit.a(r0, r0.a);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
