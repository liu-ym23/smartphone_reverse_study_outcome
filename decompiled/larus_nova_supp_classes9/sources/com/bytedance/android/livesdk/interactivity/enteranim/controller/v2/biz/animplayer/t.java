package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.common.utility.Lists;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.backends.pipeline.Fresco;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class t extends AnimPlayer<k32.a> {

    public class a extends s72.c {
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a a;
        public final /* synthetic */ ViewGroup b;
        public final /* synthetic */ ViewGroup c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            this.b.removeView(this.c);
            ((v72.c.a) this.a).a();
        }

        @Override // s72.c, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
            com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2 = this.a;
            if (r2 == null) goto L6;
            ((v72.c.a) r2).b();
            return;
        }

        public a(com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r1, ViewGroup r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.SmallEnterAnim;
    }

    public t(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r7, @Nonnull Context r8, @Nonnull AnimPlayer.a r9, @Nonnull ViewGroup r10, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r11) {
        va.a r13 = r7.k;
        if (r13 != null) goto L5;
        return;
    L5:
        ViewGroup r14 = (ViewGroup) LayoutInflater.from(r8).inflate(2131567904, r10, false);
        ViewGroup r0 = (ViewGroup) r14.findViewById(2131378926);
        ViewGroup r2 = (ViewGroup) r14.findViewById(2131373269);
        r14.setX(r10.getWidth());
        r14.setY(0.0f);
        FrameLayout.LayoutParams r3 = new FrameLayout.LayoutParams(-1, -2);
        r3.gravity = 80;
        r10.addView(r14, r3);
        ViewGroup.MarginLayoutParams r4 = (ViewGroup.MarginLayoutParams) r14.getLayoutParams();
        r4.bottomMargin = r9.a;
        r14.setLayoutParams(r4);
        r0.setVisibility(8);
        r2.setVisibility(0);
        HSImageView r15 = r14.findViewById(2131376621);
        TextView r1 = (TextView) r14.findViewById(2131391482);
        if (r13.getTextIcon() != null) goto L8;
    L10:
        com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.b.b(r1, r13, this.b);
        r1.setSelected(true);
        Animator r16 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r14, new a(r11, r10, r14), c());
        r16.start();
        ((v72.c.a) r11).a.i = r16;
        return;
    L8:
        if (Lists.isEmpty(r13.getTextIcon().getUrls()) == true) goto L10;
        r15.setController(Fresco.newDraweeControllerBuilder().setUri(UriProtector.parse((String) ListProtector.get(r13.getTextIcon().getUrls(), 0))).setAutoPlayAnimations(true).build());
        goto L10
    }
}
