package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickTopCloseBtn;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c1 implements View.OnClickListener {
    public final /* synthetic */ GiftMVITopView a;

    public c1(GiftMVITopView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.o(new ClickTopCloseBtn());
    }
}
