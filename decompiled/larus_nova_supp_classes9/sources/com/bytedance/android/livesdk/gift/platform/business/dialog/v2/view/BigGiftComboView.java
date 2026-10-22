package com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.bytedance.android.livesdk.gift.biggift.view.d;
import com.bytedance.android.livesdk.gift.model.h2;
import com.bytedance.android.livesdk.gift.model.l1;
import com.bytedance.android.livesdk.gift.model.n;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.ComboProgressAnimationView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.view.combo.RoundWaveAnimationView;
import com.bytedance.android.livesdk.interactivity.api.entity.RiskAdviseSyncData;
import io.reactivex.disposables.Disposable;
import jy0.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class BigGiftComboView extends BaseGiftComboView {
    public View a;
    public View b;
    public AnimatorSet c;
    public boolean d;
    public long e;
    public ComboProgressAnimationView f;
    public RoundWaveAnimationView g;

    public class a implements Animator.AnimatorListener {
        public Long a;
        public Long b;
        public final /* synthetic */ Runnable c;
        public final /* synthetic */ BigGiftComboView d;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            this.d.d = true;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r5) {
            if (this.d.d == false) goto L5;
            return;
        L5:
            Runnable r6 = this.c;
            if (r6 == null) goto L8;
            r6.run();
        L8:
            this.d.b.setVisibility(8);
            this.d.a.setVisibility(8);
            this.b = Long.valueOf(System.currentTimeMillis());
            b.d("BigGiftComboView", "show time:" + (this.b.longValue() - this.a.longValue()) + "ms");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r3) {
            this.a = Long.valueOf(System.currentTimeMillis());
        }

        public a(BigGiftComboView r1, d r2) {
            this.d = r1;
            this.c = r2;
        }
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void a(long r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void b(h2 r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setComboCount(int r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setGiftType(String r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void d() {
        AnimatorSet r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        this.b.setVisibility(8);
        this.a.setVisibility(8);
        RoundWaveAnimationView r1 = this.g;
        if (r1 == null) goto L14;
        Disposable r2 = r1.a;
        if (r2 == null) goto L12;
        r2.dispose();
    L12:
        r1.removeAllViews();
        return;
    L14:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.c.cancel();
        this.c.removeAllListeners();
        this.c = null;
        goto L7
    }

    public BigGiftComboView(Context r2) {
        this(r2, null);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setCountDownTime(long r1) {
        this.e = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsGroupSend(boolean r2) {
        ComboProgressAnimationView r0 = this.f;
        if (r0 == null) goto L6;
        r0.setGroupSend(r2);
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public void setIsSeriesSend(boolean r2) {
        ComboProgressAnimationView r0 = this.f;
        if (r0 == null) goto L6;
        r0.setSeriesSend(r2);
        return;
    }

    public BigGiftComboView(Context r2, AttributeSet r3) {
        this(r2, r3, 0);
    }

    public BigGiftComboView(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.e = RiskAdviseSyncData.PRIORITY;
        View.inflate(r1, 2131565235, this);
        this.a = findViewById(2131367228);
        this.b = findViewById(2131367262);
        ComboProgressAnimationView r4 = (ComboProgressAnimationView) findViewById(2131367251);
        this.f = r4;
        r4.setVisibility(4);
        this.g = (RoundWaveAnimationView) findViewById(2131384854);
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void c(Runnable r11, int r13, int r14) {
        AnimatorSet r0 = this.c;
        if (r0 != null) goto L5;
    L7:
        this.a.setAlpha(1.0f);
        this.b.setAlpha(1.0f);
        this.c = new AnimatorSet();
        ObjectAnimator r1 = ObjectAnimator.ofFloat(this.b, "scaleX", new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r2 = ObjectAnimator.ofFloat(this.b, "scaleY", new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r3 = ObjectAnimator.ofFloat(this.a, "scaleX", new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r4 = ObjectAnimator.ofFloat(this.a, "scaleY", new float[]{1.0f, 0.9f, 1.0f}).setDuration(133);
        ObjectAnimator r5 = ObjectAnimator.ofFloat(this.a, "rotation", new float[]{0.0f, 360.0f}).setDuration(this.e);
        this.c.playTogether(new Animator[]{r1, r2, r3, r4, r5});
        this.c.addListener(new a(this, (d) r11));
        this.d = false;
        this.c.start();
        this.b.setVisibility(0);
        this.a.setVisibility(0);
        this.f.setVisibility(0);
        this.f.i(r14, r13);
        this.f.j();
        RoundWaveAnimationView r15 = this.g;
        if (r15 == null) goto L11;
        r15.a();
        return;
    L11:
        return;
    L5:
        if (r0.isRunning() == false) goto L7;
        this.c.cancel();
        this.c.removeAllListeners();
        this.c = null;
        goto L7
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.dialog.v2.view.newcombo.BaseGiftComboView
    public final void e(h2 r1, l1 r2, n r3) {
        ComboProgressAnimationView r4 = this.f;
        if (r4 == null) goto L6;
        r4.setGift(r1);
        return;
    }
}
