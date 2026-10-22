package com.bytedance.android.livesdk.interactivity.comment.record.guide;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class g<T> implements Consumer {
    public final /* synthetic */ LiveHighlightRecordGuideDialog a;

    public g(LiveHighlightRecordGuideDialog r1) {
        this.a = r1;
    }

    public final void accept(Object r5) {
        LiveHighlightRecordGuideDialog r0 = this.a;
        boolean r6 = ((Boolean) r5).booleanValue();
        View r1 = r0.H;
        if (r1 == null) goto L28;
        if (r6 == false) goto L16;
        UtilityKotlinExtentionsKt.w(r1);
        if (r0.J != null) goto L9;
        ValueAnimator r7 = ValueAnimator.ofFloat(new float[]{0.0f, 360.0f});
        r7.setDuration(400);
        r7.setInterpolator(new LinearInterpolator());
        r7.setRepeatCount(-1);
        r7.addUpdateListener(new e(r1));
        r0.J = r7;
    L9:
        Animator r8 = r0.J;
        if (r8 != null) goto L12;
        return;
    L12:
        if (r8.isRunning() == true) goto L24;
        Animator r9 = r0.J;
        if (r9 == null) goto L25;
        r9.start();
        return;
    L25:
        return;
    L24:
        return;
    L16:
        Animator r10 = r0.J;
        if (r10 == null) goto L19;
        r10.cancel();
    L19:
        View r11 = r0.H;
        if (r11 == null) goto L27;
        UtilityKotlinExtentionsKt.t(r11);
        return;
    L27:
        return;
    }
}
