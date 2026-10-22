package com.bytedance.android.livesdk.gift.fastgift;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.live.core.widget.HSImageView;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends o12.b {
    public final /* synthetic */ FastGiftViewV3 a;
    public final /* synthetic */ View b;
    public final /* synthetic */ View c;

    public static final class a<T> implements Consumer {
        public final /* synthetic */ j a;

        public a(j r1) {
            this.a = r1;
        }

        public final void accept(Object r13) {
            Long r14 = (Long) r13;
            j r15 = this.a;
            FastGiftViewV3 r0 = r15.a;
            View r1 = r15.b;
            View r16 = r15.c;
            AnimatorSet r2 = r0.u;
            if (r2 == null) goto L5;
            r2.cancel();
        L5:
            r0.u = new AnimatorSet();
            ObjectAnimator r3 = ObjectAnimator.ofFloat(r16, "scaleX", new float[]{0.2f, 1.0f});
            ObjectAnimator r5 = ObjectAnimator.ofFloat(r16, "scaleY", new float[]{0.2f, 1.0f});
            ObjectAnimator r17 = ObjectAnimator.ofFloat(r16, "alpha", new float[]{0.0f, 1.0f});
            ObjectAnimator r4 = ObjectAnimator.ofFloat(r1, "scaleX", new float[]{1.0f, 0.2f});
            ObjectAnimator r6 = ObjectAnimator.ofFloat(r1, "scaleY", new float[]{1.0f, 0.2f});
            ObjectAnimator r7 = ObjectAnimator.ofFloat(r1, "alpha", new float[]{1.0f, 0.0f});
            AnimatorSet r8 = r0.u;
            if (r8 == null) goto L8;
            r8.playTogether(new Animator[]{r3, r5, r17, r4, r6, r7});
        L8:
            AnimatorSet r18 = r0.u;
            if (r18 == null) goto L11;
            r18.setDuration(400);
        L11:
            AnimatorSet r19 = r0.u;
            if (r19 == null) goto L14;
            r19.setInterpolator(new com.bytedance.android.live.core.widget.h());
        L14:
            AnimatorSet r110 = r0.u;
            if (r110 == null) goto L17;
            r110.addListener(new k(r0, r1));
        L17:
            AnimatorSet r111 = r0.u;
            if (r111 == null) goto L21;
            r111.start();
            return;
        }
    }

    @Override // o12.b, android.animation.Animator.AnimatorListener
    public final void onAnimationStart(Animator r2) {
        Intrinsics.checkNotNullParameter(r2, "animation");
        this.b.setVisibility(0);
    }

    @Override // android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3, boolean r4) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.w = false;
        this.c.setAlpha(0.0f);
        this.a.m();
        Disposable r5 = this.a.v;
        if (r5 == null) goto L5;
        r5.dispose();
    L5:
        FastGiftViewV3 r6 = this.a;
        r6.v = Observable.timer(1200, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(this));
    }

    public j(FastGiftViewV3 r1, HSImageView r2, View r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }
}
