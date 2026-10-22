package com.bytedance.android.live.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.live.core.setting.LiveInfraSettingKeys;
import com.facebook.drawee.view.SimpleDraweeView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class a {
    public boolean a;
    public boolean b;
    public boolean c;
    public final View d;
    public final View e;
    public final LiveCircleView f;
    public ValueAnimator g;
    public ValueAnimator h;
    public AnimatorSet i;
    public boolean j;
    public final ViewOnAttachStateChangeListenerC0175a k;

    /* JADX INFO: renamed from: com.bytedance.android.live.core.view.a$a, reason: collision with other inner class name */
    public class ViewOnAttachStateChangeListenerC0175a implements View.OnAttachStateChangeListener {
        public final /* synthetic */ a a;

        public ViewOnAttachStateChangeListenerC0175a(a r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewAttachedToWindow(View r2) {
            a r3 = this.a;
            if (r3.c == false) goto L6;
            r3.c(0);
            r3.d();
            return;
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public final void onViewDetachedFromWindow(View r2) {
            a r3 = this.a;
            r3.a();
            r3.c(8);
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r5) {
            int r0 = ((Integer) r5.getAnimatedValue()).intValue();
            float r6 = r5.getAnimatedFraction();
            if (r6 > 0.5f) goto L5;
            float r1 = 1.0f - ((r6 / 0.5f) * 0.08f);
        L6:
            View r7 = this.a.d;
            if (r7 == null) goto L10;
            r7.setScaleX(r1);
            this.a.d.setScaleY(r1);
        L10:
            if (r0 >= 730) goto L12;
            return;
        L12:
            if (r0 >= 740) goto L18;
            a r8 = this.a;
            if (r8.a == true) goto L19;
            r8.a = true;
            r8.h.start();
            return;
        L19:
            return;
        L18:
            return;
        L5:
            r1 = 0.92f + (((r6 - 0.5f) / 0.5f) * 0.08f);
            goto L6
        }
    }

    public class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ a a;

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            int r3 = ((Integer) r2.getAnimatedValue()).intValue();
            if (r3 >= 0) goto L5;
            return;
        L5:
            if (r3 > 640) goto L11;
            float r4 = (r3 * 1.0f) / 640.0f;
            LiveCircleView r0 = this.a.f;
            if (r0 == null) goto L12;
            r0.setFraction(r4);
            return;
        L12:
            return;
        }
    }

    public class d extends AnimatorListenerAdapter {
        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        public d() {
        }
    }

    public class e extends AnimatorListenerAdapter {
        public final /* synthetic */ a a;

        public e(a r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            ValueAnimator r3 = this.a.h;
            if (r3 == null) goto L5;
            r3.cancel();
        L5:
            ValueAnimator r4 = this.a.g;
            if (r4 == null) goto L8;
            r4.cancel();
        L8:
            a r5 = this.a;
            r5.b = false;
            r5.a = false;
        }
    }

    public final void a() {
        AnimatorSet r0 = this.i;
        if (r0 == null) goto L5;
        r0.cancel();
        this.b = false;
        this.a = false;
    L5:
        ValueAnimator r1 = this.h;
        if (r1 == null) goto L9;
        r1.cancel();
        return;
    }

    public final void d() {
        if (LiveInfraSettingKeys.LIVE_AVATAR_BORDER_ANIM_OPTIMIZE.getValue().booleanValue() == true) goto L6;
    L11:
        boolean r0 = true;
    L13:
        if (r0 == true) goto L17;
        ALogger.d("AvatarBorderViewController", "isAvatarBorderViewVisible return not");
        return;
    L17:
        if (this.j == false) goto L21;
        ALogger.d("AvatarBorderViewController", "not to show anim by degrade");
        return;
    L21:
        if (this.g != null) goto L24;
        ValueAnimator r1 = ValueAnimator.ofInt(new int[]{0, 800});
        this.g = r1;
        r1.setRepeatCount(-1);
        this.g.setRepeatMode(1);
        this.g.addUpdateListener(new b(this));
    L24:
        if (this.h != null) goto L27;
        ValueAnimator r2 = ValueAnimator.ofInt(new int[]{0, 800});
        this.h = r2;
        r2.setRepeatCount(-1);
        this.h.setRepeatMode(1);
        this.h.setDuration(800);
        this.h.addUpdateListener(new c(this));
        this.h.addListener(new d());
    L27:
        if (this.i != null) goto L29;
        AnimatorSet r3 = new AnimatorSet();
        this.i = r3;
        r3.setDuration(800);
        this.i.addListener(new e(this));
    L29:
        this.i.play(this.g);
        this.b = true;
        this.i.start();
        return;
    L6:
        if (b(this.d) == true) goto L11;
        if (b(this.e) == true) goto L11;
        r0 = false;
        goto L13
    }

    static {
    }

    public static boolean b(View r1) {
        if (r1 != null) goto L4;
    L12:
        return false;
    L4:
        if (r1.getVisibility() != 0) goto L12;
        if (r1.getParent() == null) goto L12;
        if ((r1.getParent() instanceof View) == false) goto L12;
        if (((View) r1.getParent()).getVisibility() != 0) goto L12;
        return true;
    }

    public final void c(int r4) {
        if (r4 != 0) goto L14;
        LiveCircleView r5 = this.f;
        if (r5 == null) goto L7;
        r5.setVisibility(0);
    L7:
        View r6 = this.d;
        if (r6 == null) goto L26;
        r6.setVisibility(0);
        View r7 = this.e;
        if (r7 != null) goto L12;
        return;
    L12:
        if (this.d == r7) goto L28;
        r7.setVisibility(8);
        return;
    L28:
        return;
    L26:
        return;
    L14:
        LiveCircleView r8 = this.f;
        if (r8 == null) goto L17;
        r8.setVisibility(8);
    L17:
        View r9 = this.d;
        if (r9 != null) goto L20;
    L22:
        View r11 = this.e;
        if (r11 == null) goto L30;
        r11.setVisibility(0);
        return;
    L30:
        return;
    L20:
        if (r9 == this.e) goto L22;
        r9.setVisibility(8);
        goto L22
    }

    public a(SimpleDraweeView r3, LiveCircleView r4) {
        this.c = true;
        this.j = false;
        ViewOnAttachStateChangeListenerC0175a r1 = new ViewOnAttachStateChangeListenerC0175a(this);
        this.k = r1;
        this.d = r3;
        this.e = r3;
        this.f = r4;
        r4.setVisibility(0);
        r3.addOnAttachStateChangeListener(r1);
    }

    public a(View r4, LiveCircleView r5, Boolean r6) {
        this.c = true;
        int r0 = 0;
        this.j = false;
        ViewOnAttachStateChangeListenerC0175a r1 = new ViewOnAttachStateChangeListenerC0175a(this);
        this.k = r1;
        this.c = r6.booleanValue();
        this.d = r4;
        this.e = r4;
        this.f = r5;
        if (r6.booleanValue() == true) goto L6;
        r0 = 8;
    L6:
        r5.setVisibility(r0);
        r4.addOnAttachStateChangeListener(r1);
    }
}
