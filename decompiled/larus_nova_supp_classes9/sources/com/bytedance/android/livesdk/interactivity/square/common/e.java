package com.bytedance.android.livesdk.interactivity.square.common;

import android.view.animation.TranslateAnimation;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements Runnable {
    public final /* synthetic */ BaseModelListScrollManager a;

    public e(BaseModelListScrollManager r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        TranslateAnimation r9 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 1, 1.0f, 1, 0.0f);     // Catch: Throwable -> L4
        r9.setDuration(100);     // Catch: Throwable -> L4
        this.a.k.startAnimation(r9);     // Catch: Throwable -> L4
        this.a.k.setVisibility(0);     // Catch: Throwable -> L4
        this.a.l.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
