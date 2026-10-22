package com.ss.android.lark.keyboard.widget;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements Runnable {
    public final /* synthetic */ View a;

    public c(View r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a;     // Catch: Throwable -> L4
        r0.setTranslationY(r0.getMeasuredHeight());     // Catch: Throwable -> L4
        r0.animate().translationY(0.0f).setDuration(300).start();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
