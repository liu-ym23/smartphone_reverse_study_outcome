package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview.adapter;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v3.stateMachine.ClickDIYCard;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ n a;

    public m(n r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        n r4 = this.a;
        r4.o(new ClickDIYCard(r4.p()));
    }
}
