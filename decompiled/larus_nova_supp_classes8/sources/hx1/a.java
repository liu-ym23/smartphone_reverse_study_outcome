package hx1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class a implements hx1.b {
    public AnimatorSet a;
    public AnimatorSet b;
    public final PropertyOwner<Unit> c;
    public final PropertyOwner d;
    public final PropertyOwner<Unit> e;
    public final PropertyOwner f;
    public final PropertyOwner<Unit> g;
    public final PropertyOwner h;
    public final PropertyOwner<Unit> i;
    public final PropertyOwner j;
    public final ViewGroup k;
    public final ViewGroup l;
    public final DataCenter m;

    /* JADX INFO: renamed from: hx1.a$a, reason: collision with other inner class name */
    public static final class C0392a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ a a;

        public b(a r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "it");
            Object r3 = r2.getAnimatedValue();
            if ((r3 instanceof Float) == true) goto L5;
            r3 = null;
        L5:
            Float r4 = (Float) r3;
            if (r4 == null) goto L9;
            float r5 = r4.floatValue();
            int r6 = (int) r5;
            this.a.k.getLayoutParams().height = r6;
            this.a.k.requestLayout();
            return;
        }
    }

    public static final class c implements Animator.AnimatorListener {
        public final /* synthetic */ a a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public c(a r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.k.clearAnimation();
            this.a.k.removeAllViews();
            this.a.k.getLayoutParams().height = -2;
            this.a.k.setVisibility(8);
            this.a.i.a(Unit.INSTANCE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.k.setAlpha(1.0f);
            this.a.g.a(Unit.INSTANCE);
        }
    }

    public static final class d implements Animator.AnimatorListener {
        public final /* synthetic */ a a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public d(a r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.a.e.a(Unit.INSTANCE);
            this.a.m.put("cmd_scroll_public_screen_msg_to_last", Boolean.TRUE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.k.setAlpha(0.0f);
            this.a.k.setVisibility(0);
            this.a.c.a(Unit.INSTANCE);
        }
    }

    static {
    }

    @Override // hx1.b
    public final void cancel() {
        AnimatorSet r0 = this.a;
        AnimatorSet r1 = null;
        if (r0 != null) goto L5;
    L10:
        AnimatorSet r2 = this.b;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r2.isRunning() == false) goto L15;
        r1 = r2;
    L15:
        if (r1 == null) goto L19;
        r1.cancel();
        return;
    L19:
        return;
    L5:
        if (r0.isRunning() == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L10;
        r0.cancel();
        goto L10
    }

    @Override // hx1.b
    public final void hide() {
        AnimatorSet r0 = this.b;
        if (r0 != null) goto L5;
    L7:
        int r1 = this.k.getMeasuredHeight();
        ViewGroup.LayoutParams r2 = this.k.getLayoutParams();
        if (r2 == null) goto L10;
        int r3 = r2.height;
    L11:
        ValueAnimator r4 = ValueAnimator.ofFloat(new float[]{Math.max(r1, r3) * 1.0f, 0.0f});
        r4.addUpdateListener(new b(this));
        ObjectAnimator r5 = ObjectAnimator.ofPropertyValuesHolder(this.k, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.8f, 0.75f), Keyframe.ofFloat(1.0f, 0.0f)})});
        AnimatorSet r6 = this.b;
        if (r6 == null) goto L14;
        r6.end();
    L14:
        AnimatorSet r7 = this.b;
        if (r7 == null) goto L17;
        r7.removeAllListeners();
    L17:
        AnimatorSet r8 = new AnimatorSet();
        r8.setDuration(400);
        r8.setInterpolator(new LinearInterpolator());
        r8.addListener(new c(this));
        r8.playTogether(new Animator[]{r4, r5});
        Unit r9 = Unit.INSTANCE;
        this.b = r8;
        r8.start();
        return;
    L10:
        r3 = 0;
        goto L11
    L5:
        if (r0.isRunning() != true) goto L7;
    }

    @Override // hx1.b
    public final void show() {
        AnimatorSet r0 = this.a;
        if (r0 != null) goto L5;
    L7:
        boolean r1 = false;
    L8:
        if (r1 == false) goto L10;
        return;
    L10:
        this.k.setVisibility(4);
        this.k.getLayoutParams().height = -2;
        this.k.removeAllViews();
        this.k.addView(this.l);
        this.k.clearAnimation();
        AnimatorSet r2 = this.a;
        if (r2 == null) goto L13;
        r2.end();
    L13:
        AnimatorSet r3 = this.a;
        if (r3 == null) goto L16;
        r3.removeAllListeners();
    L16:
        ObjectAnimator r4 = ObjectAnimator.ofPropertyValuesHolder(this.k, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.8f, 0.25f), Keyframe.ofFloat(1.0f, 1.0f)})});
        AnimatorSet r5 = new AnimatorSet();
        r5.setDuration(400);
        r5.setInterpolator(new LinearInterpolator());
        r5.addListener(new d(this));
        r5.playTogether(new Animator[]{r4});
        Unit r6 = Unit.INSTANCE;
        this.a = r5;
        r5.start();
        ScaleAnimation r7 = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 1.0f);
        r7.setInterpolator(new LinearInterpolator());
        r7.setDuration(400);
        this.k.startAnimation(r7);
        return;
    L5:
        if (r0.isRunning() != true) goto L7;
        r1 = true;
        goto L8
    }

    @Override // hx1.b
    public final PropertyOwner a() {
        return this.j;
    }

    @Override // hx1.b
    public final PropertyOwner b() {
        return this.h;
    }

    @Override // hx1.b
    public final PropertyOwner c() {
        return this.d;
    }

    @Override // hx1.b
    public final PropertyOwner d() {
        return this.f;
    }

    public a(ViewGroup r2, ViewGroup r3, DataCenter r4) {
        Intrinsics.checkNotNullParameter(r2, "widgetContainer");
        Intrinsics.checkNotNullParameter(r3, "feedbackPage");
        Intrinsics.checkNotNullParameter(r4, "dataCenter");
        this.k = r2;
        this.l = r3;
        this.m = r4;
        Unit r5 = Unit.INSTANCE;
        PropertyOwner<Unit> r6 = new PropertyOwner(r5);
        this.c = r6;
        this.d = r6;
        PropertyOwner<Unit> r7 = new PropertyOwner(r5);
        this.e = r7;
        this.f = r7;
        PropertyOwner<Unit> r8 = new PropertyOwner(r5);
        this.g = r8;
        this.h = r8;
        PropertyOwner<Unit> r9 = new PropertyOwner(r5);
        this.i = r9;
        this.j = r9;
    }
}
