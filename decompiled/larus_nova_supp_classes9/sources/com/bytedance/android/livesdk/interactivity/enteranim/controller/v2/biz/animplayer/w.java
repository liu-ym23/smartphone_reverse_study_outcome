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
import com.bytedance.android.livesdk.interactivity.enteranim.view.BaseEnterSpecialView;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.facebook.drawee.backends.pipeline.Fresco;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w extends AnimPlayer<k32.a> {

    public class a extends s72.c {
        public final /* synthetic */ BaseEnterSpecialView a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a b;
        public final /* synthetic */ ViewGroup c;
        public final /* synthetic */ View d;

        @Override // s72.c
        public final void a() {
            this.a.S5();
            this.a.T5();
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

        public a(BaseEnterSpecialView r1, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2, ViewGroup r3, View r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.WebpEnter;
    }

    public w(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.view.View, android.view.ViewGroup, com.bytedance.android.livesdk.interactivity.enteranim.view.BaseEnterSpecialView] */
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r6, @Nonnull Context r7, @Nonnull AnimPlayer.a r8, @Nonnull ViewGroup r9, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r10) {
        if (r6.k != null) goto L5;
        return;
    L5:
        ?? r0 = new BaseEnterSpecialView(r7);
        r0.R5(r6, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.b.a(this.b));
        r0.setOnClickListener(r8.c);
        r0.setX(0.0f);
        r0.setY(0.0f);
        FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
        r11.gravity = 80;
        r9.addView(r0, r11);
        ViewGroup.MarginLayoutParams r13 = (ViewGroup.MarginLayoutParams) r0.getLayoutParams();
        r13.bottomMargin = s1.f(175.0f);
        r0.setLayoutParams(r13);
        View r14 = LayoutInflater.from(r7).inflate(2131567905, r9, false);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, -2);
        r3.gravity = 80;
        r9.addView(r14, r3);
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r14.getLayoutParams();
        r1.bottomMargin = s1.f(79.0f);
        r14.setLayoutParams(r1);
        HSImageView r2 = r14.findViewById(2131393136);
        com.bytedance.android.livesdk.utils.t.b r15 = r6.l;
        if (r15 == null) goto L8;
        String r16 = r15.a(r7);
    L10:
        if (TextUtils.isEmpty(r16) == true) goto L12;
        Uri r17 = new Uri.Builder().scheme("file").path(r16).build();
        r2.setController(Fresco.newDraweeControllerBuilder().setUri(r17).setAutoPlayAnimations(true).build());
    L12:
        Animator r18 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r0, new a(r0, r10, r9, r14), c());
        r18.start();
        ((v72.c.a) r10).a.i = r18;
        return;
    L8:
        r16 = null;
        goto L10
    }
}
