package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.view.UserSpecialEntryView;
import com.bytedance.android.livesdk.message.model.va;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class u extends AnimPlayer<k32.a> {

    public class a extends s72.c {
        public final /* synthetic */ UserSpecialEntryView a;
        public final /* synthetic */ com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a b;
        public final /* synthetic */ ViewGroup c;

        @Override // s72.c
        public final void a() {
            UserSpecialEntryView r0 = (UserSpecialEntryView) this.a.findViewById(2131392616);
            if (r0 == null) goto L12;
            View r1 = r0.d;
            if (r1 != null) goto L7;
            return;
        L7:
            if (r0.c == null) goto L14;
            int r2 = r1.getWidth() - r0.c.getWidth();
            if (r2 <= 0) goto L15;
            ObjectAnimator.ofInt(r0.c, "scrollX", new int[]{0, r2}).setDuration(r0.f).start();
            return;
        L15:
            return;
        L14:
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

        public a(UserSpecialEntryView r1, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r2, ViewGroup r3) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
        }
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.SpecialEnterAnim;
    }

    public u(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r9, @Nonnull Context r10, @Nonnull AnimPlayer.a r11, @Nonnull ViewGroup r13, @Nonnull com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.a r14) {
        va.a r0 = r9.k;
        if (r0 != null) goto L5;
        return;
    L5:
        UserSpecialEntryView r1 = (UserSpecialEntryView) LayoutInflater.from(r10).inflate(2131567913, r13, false);
        r1.a(r9, com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.b.a(this.b));
        View r15 = r1.findViewById(2131366966);
        if (r15 == null) goto L8;
        r15.setOnClickListener(r11.c);
    L8:
        ViewGroup.MarginLayoutParams r16 = (ViewGroup.MarginLayoutParams) r1.getLayoutParams();
        r16.bottomMargin = r11.a;
        r1.setLayoutParams(r16);
        r1.setX(r13.getWidth());
        r1.setY(0.0f);
        r13.addView(r1);
        Animator r17 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.b(r1, new a(r1, r14, r13), -1, -1, r0.getStayTime(), c(), false);
        r17.start();
        ((v72.c.a) r14).a.i = r17;
    }
}
