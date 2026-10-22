package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.view.UserEnterLevelView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m extends AnimPlayer<k32.a> {

    public class a extends s72.c {
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ View d;

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

        public a(ViewGroup r1, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2, ViewGroup r3, View r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.HotsoonDriveWebp;
    }

    public m(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r6, @Nonnull Context r7, @Nonnull AnimPlayer.a r8, @Nonnull ViewGroup r9, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r10) {
        if (r6.k != null) goto L5;
        return;
    L5:
        ViewGroup r0 = (ViewGroup) LayoutInflater.from(r7).inflate(2131567900, r9, false);
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0.getLayoutParams();
        r1.bottomMargin = r8.a;
        r0.setLayoutParams(r1);
        UserEnterLevelView r2 = (UserEnterLevelView) r0.findViewById(2131392613);
        r2.d(r6, s1.f(22.0f), s1.B(2131916479));
        r2.setOnClickListener(r8.c);
        r0.setX(r9.getWidth());
        r0.setY(0.0f);
        r9.addView(r0);
        View r3 = LayoutInflater.from(r7).inflate(2131567905, r9, false);
        FrameLayout.LayoutParams r4 = new FrameLayout.LayoutParams(-1, -2);
        r4.gravity = 80;
        r9.addView(r3, r4);
        ViewGroup.MarginLayoutParams r5 = (ViewGroup.MarginLayoutParams) r3.getLayoutParams();
        r5.bottomMargin = r8.a - (s1.j(2131168987) - s1.f(78.0f));
        r3.setLayoutParams(r5);
        HSImageView r11 = r3.findViewById(2131393136);
        FrameLayout.LayoutParams r13 = (FrameLayout.LayoutParams) r11.getLayoutParams();
        r13.height = s1.f(255.0f);
        r11.setLayoutParams(r13);
        com.bytedance.android.livesdk.utils.t.b r14 = r6.l;
        if (r14 == null) goto L8;
        String r15 = r14.a(r7);
    L10:
        if (TextUtils.isEmpty(r15) == true) goto L12;
        r11.setController(Fresco.newDraweeControllerBuilder().setUri(new Uri.Builder().scheme("file").path(r15).build()).setAutoPlayAnimations(true).build());
    L12:
        Animator r16 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r0, new a(r0, r10, r9, r3), c());
        r16.start();
        ((v72.c.a) r10).a.i = r16;
        return;
    L8:
        r15 = null;
        goto L10
    }
}
