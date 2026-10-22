package com.bytedance.android.live.effect;

import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.effect.beauty.BeautyModeSelectPanel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ LiveBeautifyDialogFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ g a;

        public a(g r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.a.S90(2131386044);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setVisibility(4);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public g(LiveBeautifyDialogFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [android.view.ViewGroup, com.bytedance.android.live.effect.beauty.BeautyModeSelectPanel, java.lang.Object] */
    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        ?? r0 = (BeautyModeSelectPanel) this.a.S90(2131364079);
        if (r0 == 0) goto L5;
        ObjectAnimator r3 = ObjectAnimator.ofFloat(r0, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, r0.getHeight()});
        r3.setDuration(300);
        r3.addListener(new com.bytedance.android.live.effect.beauty.a(r0));
        r3.start();
    L5:
        r7.postDelayed(new a(this), 300);
    }
}
