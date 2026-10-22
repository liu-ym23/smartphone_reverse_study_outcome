package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.OpenAnchorGiftPanel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m0 implements View.OnClickListener {
    public final /* synthetic */ GiftMVIRechargeView a;

    public m0(GiftMVIRechargeView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.o(new OpenAnchorGiftPanel());
    }
}
