package com.bytedance.android.live.effect;

import android.animation.ObjectAnimator;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.bytedance.android.live.effect.beauty.BeautyModeSelectPanel;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ LiveBeautifyDialogFragment a;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        public a(f r1) {
            this.a = r1;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r0 = this.a.a.S90(2131386044);     // Catch: Throwable -> L6
            if (r0 == null) goto L9;
            r0.setVisibility(0);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }
    }

    public f(LiveBeautifyDialogFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r7) {
        BeautyModeSelectPanel r0 = (BeautyModeSelectPanel) this.a.S90(2131364079);
        if (r0 == null) goto L5;
        r0.R5(((com.bytedance.android.live.effect.sticker.presenter.n) this.a.f.getValue()).i(), (String) m90.b.F.c(this.a.e).first);
    L5:
        ConstraintLayout r1 = (BeautyModeSelectPanel) this.a.S90(2131364079);
        if (r1 == null) goto L8;
        r1.setVisibility(0);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(r1, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r1.getHeight(), 0.0f});
        r2.setDuration(300);
        r2.start();
    L8:
        r7.postDelayed(new a(this), 300);
    }
}
