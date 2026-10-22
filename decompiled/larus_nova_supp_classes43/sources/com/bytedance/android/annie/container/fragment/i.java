package com.bytedance.android.annie.container.fragment;

import android.webkit.WebView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i implements Runnable {
    public final /* synthetic */ AnnieFragment a;
    public final /* synthetic */ WebView b;

    public i(AnnieFragment r1, WebView r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnnieFragment r0 = this.a;     // Catch: Throwable -> L4
        WebView r1 = this.b;     // Catch: Throwable -> L4
        int r10 = AnnieFragment.H1;     // Catch: Throwable -> L4
        r0.da0(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
