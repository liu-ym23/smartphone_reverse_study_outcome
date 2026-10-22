package com.bytedance.android.annie.business.container;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class k implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ WebView b;

    public k(i r1, WebView r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.f(this.b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
