package com.bytedance.android.livesdk.feed.drawerfeed.viewholder;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class w implements Runnable {
    public final /* synthetic */ DrawerLynxViewHolder a;

    public w(DrawerLynxViewHolder r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.d;     // Catch: Throwable -> L9
        if (r0 == null) goto L5;
        r0.setVisibility(0);     // Catch: Throwable -> L9
    L5:
        ViewGroup r1 = this.a.Z3();     // Catch: Throwable -> L9
        if (r1 == null) goto L12;
        r1.setVisibility(8);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
