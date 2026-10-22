package com.ss.android.lark.inline.ai.ui;

import android.animation.ObjectAnimator;
import android.view.animation.DecelerateInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class l implements Runnable {
    public final /* synthetic */ InlineAIDragView a;

    public l(InlineAIDragView r1) {
        this.a = r1;
    }

    public final void a() {
        InlineAIDragView r0 = this.a;
        r0.b.setAlpha(1.0f);
        int r1 = r0.q - r0.c.getTop();
        Log.i("InlineAIDragView", "do showAnim, initTranslationY = " + r1 + ", panelView.top = " + r0.c.getTop());
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r0.c, "translationY", new float[]{(float) r1, 0.0f});
        r2.setDuration(200);
        r2.setInterpolator(new DecelerateInterpolator());
        r0.K = r2;
        r2.addListener(new i(r0));
        ObjectAnimator r3 = r0.K;
        if (r3 == null) goto L6;
        r3.start();
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
