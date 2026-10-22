package com.bytedance.android.live.revlink.impl.pk.feedview;

import android.view.View;
import android.widget.FrameLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class i implements Runnable {
    public final /* synthetic */ FeedPkLynxWidget a;
    public final /* synthetic */ FrameLayout.LayoutParams b;
    public final /* synthetic */ View c;

    public i(FeedPkLynxWidget r1, FrameLayout.LayoutParams r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        FeedPkLynxWidget r0 = this.a;
        com.bytedance.android.live.revlink.impl.lynxcontainer.c.a(r0.n, this.b, r0.y.getWidth(), this.a.y.getHeight());
        FeedPkLynxWidget r1 = this.a;
        r1.p(r1.n, this.b, r1.y, this.c);
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
