package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.view.BaseEnterSpecialView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class v extends AnimPlayer<k32.a> {

    public class a extends s72.c {
        public final /* synthetic */ BaseEnterSpecialView a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ View d;

        @Override // s72.c
        public final void a() {
            BaseEnterSpecialView r0 = this.a;
            r0.d.setVisibility(0);
            ObjectAnimator.ofFloat(r0.d, "alpha", new float[]{0.0f, 1.0f}).setDuration(334).start();
            this.a.S5();
            this.a.T5();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.c.removeView(this.d);
            ((v72.c.a) this.b).a();
        }

        @Override // s72.c, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2 = this.b;
            if (r2 == null) goto L6;
            ((v72.c.a) r2).b();
            return;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public a(BaseEnterSpecialView r1, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2, ViewGroup r3, BaseEnterSpecialView r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.Vigo;
    }

    public v(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.interactivity.enteranim.view.BaseEnterSpecialView] */
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r2, @Nonnull Context r3, @Nonnull AnimPlayer.a r4, @Nonnull ViewGroup r5, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r6) {
        if (r2.k != null) goto L5;
        return;
    L5:
        ?? r0 = new BaseEnterSpecialView(r3);
        r0.R5(r2, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.b.a(this.b));
        r0.setOnClickListener(r4.c);
        r0.setX(0.0f);
        r0.setY(0.0f);
        FrameLayout.LayoutParams r7 = new FrameLayout.LayoutParams(-2, -2);
        r7.gravity = 80;
        r5.addView(r0, r7);
        ViewGroup.MarginLayoutParams r8 = (ViewGroup.MarginLayoutParams) r0.getLayoutParams();
        r8.bottomMargin = s1.f(175.0f);
        r0.setLayoutParams(r8);
        Animator r9 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r0, new a(r0, r6, r5, r0), c());
        r9.start();
        ((v72.c.a) r6).a.i = r9;
    }
}
