package com.bytedance.android.livesdk.gift.platform.business.pkProp;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import com.bytedance.android.GiftRecyclableWidget;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.core.GiftContext;
import com.bytedance.ies.sdk.widgets.Widget;
import com.bytedance.live.datacontext.n;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.AnimationListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/gift/platform/business/pkProp/PKBattlePropEffectWidget;", "Lcom/bytedance/android/GiftRecyclableWidget;", "<init>", "()V", "a", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PKBattlePropEffectWidget extends GiftRecyclableWidget {
    public HSImageView b;
    public u02.a c;
    public AnimatedDrawable2 d;
    public AnimatorSet e;
    public AnimatorSet f;
    public boolean g;
    public HSImageView h;
    public AnimatorSet i;
    public final c j;
    public final d k;
    public final b l;
    public boolean m;

    public static final class a {
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ PKBattlePropEffectWidget a;

        public b(PKBattlePropEffectWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            PKBattlePropEffectWidget r3 = this.a;
            r3.m = false;
            HSImageView r4 = r3.h;
            if (r4 == null) goto L6;
            r4.setVisibility(8);
            return;
        }
    }

    public static final class c extends AnimatorListenerAdapter {
        public final /* synthetic */ PKBattlePropEffectWidget a;

        public c(PKBattlePropEffectWidget r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            HSImageView r3 = this.a.b;
            if (r3 == null) goto L5;
            r3.setVisibility(8);
        L5:
            u02.a r4 = this.a.c;
            if (r4 == null) goto L9;
            r4.onEnd();
            return;
        }
    }

    public static final class d implements AnimationListener {
        public final /* synthetic */ PKBattlePropEffectWidget a;

        public final void onAnimationRepeat(AnimatedDrawable2 r1) {
        }

        public final void onAnimationReset(AnimatedDrawable2 r1) {
        }

        public final void onAnimationStart(AnimatedDrawable2 r1) {
        }

        public final void onAnimationStop(AnimatedDrawable2 r1) {
        }

        public d(PKBattlePropEffectWidget r1) {
            this.a = r1;
        }

        public final void onAnimationFrame(AnimatedDrawable2 r20, int r21) {
            if (r20 == null) goto L5;
            int r2 = r20.getFrameCount();
        L7:
            if (r21 < (r2 - 1)) goto L40;
            AnimatedDrawable2 r3 = this.a.d;
            if (r3 == null) goto L11;
            r3.stop();
        L11:
            AnimatedDrawable2 r4 = this.a.d;
            View r5 = null;
            if (r4 == null) goto L14;
            r4.setAnimationListener(null);
        L14:
            GiftContext r6 = com.bytedance.android.livesdk.gift.util.b.b();
            if (r6 == null) goto L19;
            n<View> r7 = r6.getGiftIcon();
            if (r7 == null) goto L19;
            r5 = (View) r7.getValue();
        L19:
            PKBattlePropEffectWidget r8 = this.a;
            HSImageView r9 = r8.b;
            if (r9 == null) goto L34;
            if (r5 == null) goto L34;
            if (r8.g == false) goto L34;
            int[] r10 = new int[2];
            r5.getLocationOnScreen(r10);
            r10[0] = r10[0] + (r5.getWidth() / 2);
            r10[1] = r10[1] + (r5.getHeight() / 2);
            HSImageView r11 = this.a.b;
            Intrinsics.checkNotNull(r11);
            int[] r13 = {r8 + (r9.getWidth() / 2), r8 + (r9.getHeight() / 2)};
            r11.getLocationOnScreen(r13);
            int r14 = r13[0];
            HSImageView r15 = this.a.b;
            Intrinsics.checkNotNull(r15);
            int r16 = r13[1];
            HSImageView r17 = this.a.b;
            Intrinsics.checkNotNull(r17);
            PKBattlePropEffectWidget r18 = this.a;
            HSImageView r19 = r18.b;
            Intrinsics.checkNotNull(r19);
            Intrinsics.checkNotNullParameter(r19, "animationView");
            Intrinsics.checkNotNullParameter(r13, "sourceLocation");
            Intrinsics.checkNotNullParameter(r10, "targetLocation");
            AnimatorSet r110 = new AnimatorSet();
            ObjectAnimator r111 = ObjectAnimator.ofFloat(r19, "translationX", new float[]{0.0f, (r10[0] - r13[0]) + 2});
            ObjectAnimator r23 = ObjectAnimator.ofFloat(r19, "translationY", new float[]{0.0f, (r10[1] - r13[1]) + 4});
            om3.a r112 = new om3.a(0.42f, 0.0f, 0.58f, 1.0f);
            r23.setInterpolator(r112);
            r111.setInterpolator(r112);
            r111.setDuration(500);
            r23.setDuration(500);
            ObjectAnimator r113 = ObjectAnimator.ofFloat(r19, "scaleX", new float[]{1.0f, 0.5f});
            ObjectAnimator r114 = ObjectAnimator.ofFloat(r19, "scaleY", new float[]{1.0f, 0.5f});
            r113.setDuration(500);
            r114.setDuration(500);
            ObjectAnimator r24 = ObjectAnimator.ofFloat(r19, "scaleX", new float[]{0.5f, 0.0f});
            ObjectAnimator r25 = ObjectAnimator.ofFloat(r19, "scaleY", new float[]{0.5f, 0.0f});
            r24.setDuration(200);
            r25.setDuration(200);
            r24.setStartDelay(750);
            r25.setStartDelay(750);
            r110.playTogether(new Animator[]{r111, r23, r113, r114, r24, r25});
            r18.e = r110;
            AnimatorSet r26 = this.a.e;
            if (r26 == null) goto L28;
            r26.start();
        L28:
            PKBattlePropEffectWidget r27 = this.a;
            Intrinsics.checkNotNullParameter(r5, "animationView");
            AnimatorSet r28 = new AnimatorSet();
            ObjectAnimator r29 = ObjectAnimator.ofFloat(r5, "scaleX", new float[]{0.4f, 1.04f, 1.0f});
            ObjectAnimator r115 = ObjectAnimator.ofFloat(r5, "scaleY", new float[]{0.4f, 1.04f, 1.0f});
            r29.setDuration(250);
            r115.setDuration(250);
            r29.setStartDelay(950);
            r115.setStartDelay(950);
            ObjectAnimator r116 = ObjectAnimator.ofFloat(r5, "scaleX", new float[]{1.04f, 0.98f, 1.0f});
            ObjectAnimator r117 = ObjectAnimator.ofFloat(r5, "scaleY", new float[]{1.04f, 0.98f, 1.0f});
            r116.setDuration(150);
            r117.setDuration(150);
            r116.setStartDelay(1200);
            r117.setStartDelay(1200);
            ObjectAnimator r30 = ObjectAnimator.ofFloat(r5, "scaleX", new float[]{0.98f, 1.01f, 1.0f});
            ObjectAnimator r31 = ObjectAnimator.ofFloat(r5, "scaleY", new float[]{0.98f, 1.01f, 1.0f});
            r30.setDuration(150);
            r31.setDuration(150);
            r30.setStartDelay(1350);
            r31.setStartDelay(1350);
            ObjectAnimator r33 = ObjectAnimator.ofFloat(r5, "scaleX", new float[]{1.01f, 1.0f, 1.0f});
            ObjectAnimator r34 = ObjectAnimator.ofFloat(r5, "scaleY", new float[]{1.01f, 1.0f, 1.0f});
            r33.setDuration(150);
            r34.setDuration(150);
            r33.setStartDelay(1500);
            r34.setStartDelay(1500);
            r28.playTogether(new Animator[]{r29, r116, r30, r33, r115, r117, r31, r34});
            r27.f = r28;
            AnimatorSet r1 = this.a.f;
            if (r1 == null) goto L31;
            r1.start();
        L31:
            PKBattlePropEffectWidget r35 = this.a;
            AnimatorSet r36 = r35.f;
            if (r36 == null) goto L41;
            r36.addListener(r35.j);
            return;
        L41:
            return;
        L34:
            if (r9 == null) goto L36;
            r9.setVisibility(8);
        L36:
            u02.a r37 = this.a.c;
            if (r37 == null) goto L43;
            r37.onEnd();
            return;
        L43:
            return;
        L40:
            return;
        L5:
            r2 = 0;
            goto L7
        }
    }

    static {
    }

    public final int getLayoutId() {
        return 2131565262;
    }

    public final void onInit(Object[] r1) {
    }

    public final void onUnload() {
        this.c = null;
    }

    public PKBattlePropEffectWidget() {
        this.j = new c(this);
        this.k = new d(this);
        this.l = new b(this);
    }

    public final void onLoad(Object[] r2) {
        GiftContext r3 = com.bytedance.android.livesdk.gift.util.b.b();
        if (r3 == null) goto L7;
        n<PKBattlePropEffectWidget> r4 = r3.getPkBattlePropEffectWidget();
        if (r4 == null) goto L7;
        r4.setValue(this);
    L7:
        this.b = ((Widget) this).containerView.findViewById(2131370353);
        this.h = ((Widget) this).containerView.findViewById(2131373050);
    }
}
