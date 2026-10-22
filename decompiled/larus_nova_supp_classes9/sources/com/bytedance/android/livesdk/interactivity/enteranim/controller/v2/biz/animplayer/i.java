package com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer;

import android.animation.Animator;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.android.livesdk.interactivity.InteractivityPlatformContext;
import com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.RevenueUtils;
import com.bytedance.android.livesdk.interactivity.enteranim.view.EcomEnterTrayView;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdk.utils.condition.base.ConditionConstant;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class i extends AnimPlayer<k32.b> {
    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    @Nonnull
    public AnimPlayer.PlayerType getType() {
        return AnimPlayer.PlayerType.Ecom;
    }

    public i(InteractivityPlatformContext r1, DataCenter r2) {
        super(r1, r2);
    }

    @Override // com.bytedance.android.livesdk.interactivity.enteranim.controller.v2.biz.animplayer.AnimPlayer
    public final void b(@Nonnull k32.a r3, @Nonnull Context r4, @Nonnull AnimPlayer.a r5, @Nonnull ViewGroup r6, @Nonnull a r7) {
        k32.b r8 = (k32.b) r3;
        EcomEnterTrayView r9 = new EcomEnterTrayView(r6.getContext());
        r9.a(r8);
        r9.setX(r6.getWidth());
        r9.setY(0.0f);
        FrameLayout.LayoutParams r0 = new FrameLayout.LayoutParams(-2, -2);
        r0.gravity = 80;
        r6.addView(r9, r0);
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r9.getLayoutParams();
        r1.bottomMargin = r5.a;
        r9.setLayoutParams(r1);
        Animator r10 = com.bytedance.android.livesdk.interactivity.enteranim.utils.a.c(r9, new h(r7, r6, r9), c());
        r10.start();
        ((v72.c.a) r7).a.i = r10;
        xs2.b.a().post(new com.bytedance.android.livesdk.utils.condition.base.b(ConditionConstant.ConditionType.SHOW_SALE));
        RevenueUtils.a("EcomBarrage", r6, r8, r5.b);
        j0.l().sendLog("buying_comment_show", null, new Object[]{IRoom.class});
    }
}
