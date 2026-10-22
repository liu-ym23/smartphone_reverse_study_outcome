package com.ss.android.lark.inline.ai.creationai;

import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class n implements Runnable {
    public final /* synthetic */ CreationAIDragView a;

    public n(CreationAIDragView r1) {
        this.a = r1;
    }

    public final void a() {
        CreationAIDragView r0 = this.a;
        r0.b.setAlpha(1.0f);
        Log.i("CreationAIDragView", "do showAnim, initTranslationY = " + (r0.r - r0.c.getTop()) + ", panelView.top = " + r0.c.getTop() + ",  rootViewHeight = " + r0.r + ",  panelView.height = " + r0.c.getHeight());
        float r1 = (float) r0.c.getHeight();
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r0.c, "translationY", new float[]{r1, 0.0f});
        r2.setDuration(250);
        r2.setInterpolator(new DecelerateInterpolator());
        r0.K = r2;
        if (r0.j != null) goto L5;
        r0.s();
    L5:
        View r3 = r0.X;
        if (r3 == null) goto L10;
        r3.setAlpha(0.0f);
        ObjectAnimator r4 = r0.K;
        if (r4 == null) goto L10;
        r4.addUpdateListener(new g(r1, r3, r0));
    L10:
        ObjectAnimator r5 = r0.K;
        if (r5 == null) goto L13;
        r5.addListener(new h(r0));
    L13:
        CreationAIDragView.h0++;
        ObjectAnimator r6 = r0.K;
        if (r6 == null) goto L17;
        r6.start();
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
