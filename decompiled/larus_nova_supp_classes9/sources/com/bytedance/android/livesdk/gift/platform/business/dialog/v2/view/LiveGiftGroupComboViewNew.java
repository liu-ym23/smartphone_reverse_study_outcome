package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.GroupWaveAnimationView;
import qz1.e;
import qz1.f;
import qz1.g;
import qz1.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class LiveGiftGroupComboViewNew extends FrameLayout {
    public static final /* synthetic */ int g = 0;
    public LottieAnimationView a;
    public int b;
    public AnimatorSet c;
    public Animator.AnimatorListener d;
    public LottieAnimationView e;
    public GroupWaveAnimationView f;

    public class a implements Animator.AnimatorListener {
        public final /* synthetic */ Runnable a;
        public final /* synthetic */ LiveGiftGroupComboViewNew b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.b.b = 0;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.a.run();
            this.b.f.removeAllViews();
            this.b.b = 0;
        }

        public a(LiveGiftGroupComboViewNew r1, Runnable r2) {
            this.b = r1;
            this.a = r2;
        }
    }

    public final void a() {
        AnimatorSet r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        this.c = null;
        LottieAnimationView r1 = this.a;
        if (r1 == null) goto L13;
        Animator.AnimatorListener r2 = this.d;
        if (r2 == null) goto L14;
        r1.removeAnimatorListener(r2);
        this.d = null;
        return;
    L14:
        return;
    L13:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.c.removeAllListeners();
        this.c.cancel();
        goto L7
    }

    public LiveGiftGroupComboViewNew(Context r2) {
        this(r2, null);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [qz1.e] */
    public final void b(final Runnable r13) {
        this.a.setVisibility(0);
        if (this.b != 0) goto L7;
        a();
        this.b = 1;
        this.c = new AnimatorSet();
        ObjectAnimator r0 = ObjectAnimator.ofFloat(this, "scaleX", new float[]{0.9f, 1.1f, 1.0f});
        ObjectAnimator r7 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{0.9f, 1.1f, 1.0f});
        this.c.playTogether(new Animator[]{r0, r7});
        this.c.setDuration(300);
        this.c.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        this.c.addListener(new f(this, r13));
        this.c.start();
        this.f.a();
        LottieAnimationView r14 = this.e;
        if (r14 == null) goto L9;
        r14.cancelAnimation();
        this.e.playAnimation();
        return;
    L9:
        return;
    L7:
        ?? r1 = new e(this, r13);
        a();
        this.b = 1;
        this.c = new AnimatorSet();
        ObjectAnimator r15 = ObjectAnimator.ofFloat(this, "scaleX", new float[]{1.0f, 0.95f, 1.0f});
        ObjectAnimator r8 = ObjectAnimator.ofFloat(this, "scaleY", new float[]{1.0f, 0.95f, 1.0f});
        this.c.playTogether(new Animator[]{r15, r8});
        this.c.setDuration(200);
        this.c.setInterpolator(new PathInterpolator(0.42f, 0.0f, 0.58f, 1.0f));
        this.c.addListener(new g(r1));
        this.c.start();
        this.a.setSpeed(-20.0f);
        this.d = new h();
        this.f.a();
        this.a.addAnimatorListener(this.d);
    }

    public final void c(Runnable r3) {
        a();
        this.b = 2;
        this.a.setSpeed(1.0f);
        a r0 = new a(this, r3);
        this.d = r0;
        this.a.addAnimatorListener(r0);
        this.a.playAnimation();
    }

    public LiveGiftGroupComboViewNew(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public LiveGiftGroupComboViewNew(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.b = 0;
        View.inflate(r1, 2131565239, this);
        this.a = findViewById(2131367228);
        this.e = findViewById(2131370085);
        this.f = (GroupWaveAnimationView) findViewById(2131393020);
        this.a.setImageAssetsFolder("images");
        this.a.setAnimation("ttlive_gift_group_combo_button.json");
        this.e.setAnimation("ttlive_gift_group_dot.json");
        this.a.loop(false);
        this.e.loop(true);
    }
}
