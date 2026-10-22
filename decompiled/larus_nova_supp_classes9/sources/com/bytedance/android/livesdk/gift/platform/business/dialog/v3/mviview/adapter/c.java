package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.os.Handler;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OnGiftExposureAnimShow;
import com.bytedance.android.livesdk.gift.platform.business.normal.view.v2.GiftIconMaskView;
import com.facebook.fresco.animation.drawable.AnimatedDrawable2;
import com.facebook.fresco.animation.drawable.BaseAnimationListener;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c extends BaseAnimationListener {
    public final /* synthetic */ BasePanelViewHolderItem.c a;

    public c(BasePanelViewHolderItem.c r1) {
        this.a = r1;
    }

    public final void onAnimationStop(AnimatedDrawable2 r4) {
        BasePanelViewHolderItem r5 = this.a.a;
        Handler r0 = BasePanelViewHolderItem.d0;
        r5.z();
        BasePanelViewHolderItem.c r6 = this.a;
        r6.a.o(new OnGiftExposureAnimShow(r6.b.getPagerPosition(), this.a.b.getPosition()));
    }

    public final void onAnimationFrame(AnimatedDrawable2 r1, int r2) {
        if (r2 <= 1) goto L17;
        HSImageView r3 = this.a.a.v;
        if (r3 == null) goto L7;
        Integer r4 = Integer.valueOf(r3.getVisibility());
    L9:
        if (r4.intValue() != 0) goto L18;
        HSImageView r5 = this.a.a.v;
        if (r5 == null) goto L13;
        r5.setVisibility(4);
    L13:
        GiftIconMaskView r6 = this.a.a.B;
        if (r6 == null) goto L19;
        r6.setVisibility(4);
        return;
    L19:
        return;
    L18:
        return;
    L7:
        r4 = null;
        goto L9
    }
}
