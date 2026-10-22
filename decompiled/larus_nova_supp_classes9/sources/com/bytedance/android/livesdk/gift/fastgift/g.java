package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.livesdk.gift.fastgift.di.FastGiftAnimationCreator;
import io.reactivex.functions.Consumer;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ FastGiftViewV3 a;

    public g(FastGiftViewV3 r1) {
        this.a = r1;
    }

    public final void accept(Object r9) {
        Long r10 = (Long) r9;
        FastGiftViewV3 r11 = this.a;
        r11.z = false;
        com.bytedance.android.livesdk.revenue.service.toolbar.d r1 = (dy0.b) com.bytedance.android.live.revenue.core.util.e.c(com.bytedance.android.live.revenue.core.util.j.C0.a(), com.bytedance.android.livesdk.revenue.service.toolbar.d.class);
        if (r1 == null) goto L5;
        r1.unlock(r11);
    L5:
        r11.o.setVisibility(8);
        FastGiftViewModel.comboFinish$default(r11.A, false, 1, null);
        if (r11.g != null) goto L8;
        View r2 = r11.a(2131372147);
        Lazy r3 = FastGiftAnimationCreator.a;
        Intrinsics.checkNotNullParameter(r2, "target");
        AnimatorSet r4 = new AnimatorSet();
        ObjectAnimator r5 = ObjectAnimator.ofFloat(r2, "scaleX", new float[]{1.24f, 1.0f});
        ObjectAnimator r6 = ObjectAnimator.ofFloat(r2, "scaleY", new float[]{1.24f, 1.0f});
        r5.setDuration(150);
        r6.setDuration(150);
        r4.playTogether(new Animator[]{r5, r6});
        r11.g = r4;
    L8:
        AnimatorSet r0 = r11.g;
        if (r0 == null) goto L11;
        r0.cancel();
    L11:
        AnimatorSet r13 = r11.g;
        if (r13 == null) goto L15;
        r13.start();
        return;
    }
}
