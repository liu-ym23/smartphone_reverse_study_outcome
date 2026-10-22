package com.bytedance.android.livesdk.feed.openui.view;

import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements Runnable {
    public final /* synthetic */ h a;
    public final /* synthetic */ ViewGroup.LayoutParams b;

    public g(h r1, ViewGroup.LayoutParams r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleLiveView.b(this.a.a, true, this.b.width);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
