package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.bytedance.android.live.core.utils.ImageLoader;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.view.UserEnterLevelView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l extends AnimPlayer<k32.a> {

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
        return AnimPlayer.PlayerType.HotsoonDriveEnter;
    }

    public l(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r5, @Nonnull Context r6, @Nonnull AnimPlayer.a r7, @Nonnull ViewGroup r8, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r9) {
        r5.getClass();
        ViewGroup r10 = (ViewGroup) LayoutInflater.from(r6).inflate(2131567900, r8, false);
        ViewGroup.MarginLayoutParams r0 = (ViewGroup.MarginLayoutParams) r10.getLayoutParams();
        r0.bottomMargin = r7.a;
        r10.setLayoutParams(r0);
        UserEnterLevelView r1 = (UserEnterLevelView) r10.findViewById(2131392613);
        r1.d(r5, s1.f(22.0f), s1.B(2131916479));
        r1.setOnClickListener(r7.c);
        HSImageView r11 = r10.findViewById(2131362938);
        if (r5.k.getIcon() == null) goto L5;
        r11.setVisibility(0);
        ImageLoader.bindImage(r11, r5.k.getIcon());
    L5:
        r10.setX(r8.getWidth());
        r10.setY(0.0f);
        r8.addView(r10);
        Animator r13 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r10, new a(r10, r9, r8), c());
        r13.start();
        ((v72.c.a) r9).a.i = r13;
    }
}
