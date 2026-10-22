package com.bytedance.android.live.liveinteract.plantform.commonwindow.layer.guest;

import android.animation.AnimatorSet;
import com.bytedance.android.live.core.widget.HSImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class h implements Runnable {
    public final /* synthetic */ g.b.a a;

    public h(g.b.a r1) {
        this.a = r1;
    }

    public final void a() {
        HSImageView r0 = this.a.a.a.p;
        if (r0 == null) goto L5;
        r0.setController(null);
    L5:
        HSImageView r1 = this.a.a.a.p;
        if (r1 == null) goto L8;
        r1.setVisibility(8);
    L8:
        g.b r2 = this.a.a;
        if (r2.b.element >= 3) goto L15;
        AnimatorSet r3 = r2.a.r;
        if (r3 == null) goto L13;
        r3.start();
    L13:
        this.a.a.b.element++;
        return;
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
