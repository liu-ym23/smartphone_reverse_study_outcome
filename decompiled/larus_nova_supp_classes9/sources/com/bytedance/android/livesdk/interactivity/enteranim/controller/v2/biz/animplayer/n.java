package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.view.UserEnterLevelView;
import com.bytedance.android.livesdk.interactivity.enteranim.view.UserEnterRankView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class n extends AnimPlayer<k32.a> {

    public class a extends s72.c {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a b;
        public final /* synthetic */ ViewGroup c;

        @Override // s72.c
        public final void a() {
            UserEnterLevelView r0 = (UserEnterLevelView) this.a.findViewById(2131392613);
            if (r0 == null) goto L6;
            r0.c();
            return;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.c.removeView(this.a);
            ((v72.c.a) this.b).a();
        }

        @Override // s72.c, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2 = this.b;
            if (r2 == null) goto L6;
            ((v72.c.a) r2).b();
            return;
        }

        public a(ViewGroup r1, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.LevelEnter;
    }

    public n(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r3, @Nonnull Context r4, @Nonnull AnimPlayer.a r5, @Nonnull ViewGroup r6, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r7) {
        ViewGroup r8 = (ViewGroup) LayoutInflater.from(r4).inflate(2131567901, r6, false);
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r8.getLayoutParams();
        r0.bottomMargin = r5.a;
        r8.setLayoutParams(r0);
        UserEnterLevelView r1 = (UserEnterLevelView) r8.findViewById(2131392613);
        r1.setUI(r3);
        r1.setOnClickListener(r5.c);
        UserEnterRankView r2 = (UserEnterRankView) r8.findViewById(2131377587);
        r2.setupUI(r3);
        r2.setOnClickListener(r5.c);
        r8.setX(r6.getWidth());
        r8.setY(0.0f);
        r6.addView(r8);
        Animator r9 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r8, new a(r8, r7, r6), c());
        r9.start();
        ((v72.c.a) r7).a.i = r9;
        RevenueUtils.a("HotsoonLevelEnter", r6, r3, r5.b);
    }
}
