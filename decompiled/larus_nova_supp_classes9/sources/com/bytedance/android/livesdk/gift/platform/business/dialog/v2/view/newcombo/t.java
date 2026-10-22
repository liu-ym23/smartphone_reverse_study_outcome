package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.init.I18nInitTask;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.ss.android.ugc.aweme.compat.nullable.Observer;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t<T> implements Observer {
    public final /* synthetic */ GiftComboView a;

    public t(GiftComboView r1) {
        this.a = r1;
    }

    public final void onChanged(Object r7) {
        if (((Boolean) r7).booleanValue() == true) goto L32;
        final GiftComboView r8 = this.a;
        AnimatedDrawable2 r0 = r8.s;
        if (r0 != null) goto L7;
    L8:
        HSImageView r1 = r8.o;
        if (r1 != null) goto L11;
    L12:
        Animator r2 = r8.v;
        if (r2 == null) goto L15;
        c.a(r2);
    L15:
        HSImageView r3 = r8.o;
        if (r3 == null) goto L18;
        ObjectAnimator r4 = ObjectAnimator.ofFloat(r3, "alpha", new float[]{1.0f, 0.0f}).setDuration(800);
        Function1<Animator, Unit> r5 = new GiftComboView$playEndEffectAnimation$$inlined$let$lambda$1(r8);
        Intrinsics.checkNotNullParameter(r4, "$this$doOnNormalEnd");
        Intrinsics.checkNotNullParameter(r5, "action");
        r4.addListener(new b(r5));
    L19:
        r8.v = r4;
        if (r4 == null) goto L22;
        r4.start();
    L22:
        Animator r6 = r8.q;
        if (r6 == null) goto L25;
        c.a(r6);
    L25:
        Animator r9 = r8.r;
        if (r9 != null) goto L28;
    L30:
        ValueAnimator r10 = ValueAnimator.ofFloat(new float[]{r8.x, 0.0f});
        r10.setDuration((long) (r8.x * I18nInitTask.DELAY_TS_MS));
        r10.addUpdateListener(new x(r8));
        Unit r11 = Unit.INSTANCE;
        r8.r = r10;
        r10.start();
        return;
    L28:
        if (r9.isRunning() != true) goto L30;
        return;
    L18:
        r4 = null;
        goto L19
    L11:
        if (r1.getAlpha() == 0.0f) goto L22;
    L7:
        if (r0.isRunning() == true) goto L12;
    }
}
