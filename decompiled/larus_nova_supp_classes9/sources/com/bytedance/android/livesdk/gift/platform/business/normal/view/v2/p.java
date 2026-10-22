package com.bytedance.android.livesdk.gift.platform.business.normal.view.v2;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.chatroom.utils.a1;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class p extends View {
    public final Disposable a;
    public AnimatorSet b;

    public static final class a extends o12.b {
        public final /* synthetic */ p a;

        public a(p r1) {
            this.a = r1;
        }

        @Override // o12.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.b();
        }
    }

    public final void b() {
        ViewParent r0 = getParent();
        if ((r0 instanceof ViewGroup) == true) goto L5;
        r0 = null;
    L5:
        ViewGroup r1 = (ViewGroup) r0;
        if (r1 == null) goto L8;
        r1.removeView(this);
    L8:
        AnimatorSet r2 = this.b;
        if (r2 != null) goto L11;
    L19:
        Disposable r3 = this.a;
        if (r3 == null) goto L23;
        r3.dispose();
        return;
    L23:
        return;
    L11:
        if (r2.isRunning() != true) goto L19;
        AnimatorSet r4 = this.b;
        if (r4 == null) goto L15;
        r4.removeAllListeners();
    L15:
        AnimatorSet r5 = this.b;
        if (r5 == null) goto L18;
        r5.cancel();
    L18:
        this.b = null;
        goto L19
    }

    public p(Context r3, py.k r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r3, "context");
        super(r3, null, 0);
        setBackgroundResource(2131250020);
        if (r4 == null) goto L6;
        this.a = a1.k(r4).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new n(this, r4), o.a);
    L6:
        if (r5 == false) goto L8;
        FrameLayout.LayoutParams r6 = new FrameLayout.LayoutParams(s1.f(138.0f), s1.f(36.0f));
        r6.gravity = 17;
        Unit r7 = Unit.INSTANCE;
    L9:
        setLayoutParams(r6);
        setAlpha(1.0f);
        return;
    L8:
        r6 = new FrameLayout.LayoutParams(s1.f(168.0f), s1.f(44.0f));
        r6.gravity = 17;
        Unit r8 = Unit.INSTANCE;
        goto L9
    }

    public final AnimatorSet a(float r4, float r5, long r6, long r8, long r10) {
        setX(r4);
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, "translationX", new float[]{r4, r5}).setDuration(r6);
        ObjectAnimator r9 = ObjectAnimator.ofFloat(this, "alpha", new float[]{1.0f, 0.0f}).setDuration(r8);
        AnimatorSet r11 = new AnimatorSet();
        this.b = r11;
        r11.setInterpolator(new PathInterpolator(0.4f, 0.75f, 0.74f, 1.0f));
        AnimatorSet r13 = this.b;
        if (r13 == null) goto L5;
        r13.play(r7);
    L5:
        AnimatorSet r14 = this.b;
        if (r14 == null) goto L10;
        AnimatorSet.Builder r15 = r14.play(r9);
        if (r15 == null) goto L10;
        r15.after(r10);
    L10:
        AnimatorSet r16 = this.b;
        if (r16 == null) goto L14;
        r16.addListener(new a(this));
    L14:
        return this.b;
    }
}
