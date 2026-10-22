package com.bytedance.android.live.revlink.impl.pk.ui;

import android.widget.TextView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class u implements Runnable {
    public final /* synthetic */ PkTopTipView a;

    public u(PkTopTipView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ((TextView) this.a._$_findCachedViewById(2131391645)).setFocusable(true);     // Catch: Throwable -> L4
        ((TextView) this.a._$_findCachedViewById(2131391645)).setFocusableInTouchMode(true);     // Catch: Throwable -> L4
        ((TextView) this.a._$_findCachedViewById(2131391645)).requestFocus();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
