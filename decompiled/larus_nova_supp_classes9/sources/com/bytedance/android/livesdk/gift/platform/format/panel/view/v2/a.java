package com.bytedance.android.livesdk.gift.platform.format.panel.view.v2;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftStateMachineConfig;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.utils.h;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ FormatGiftBottomWidget.d a;
    public final /* synthetic */ FormatGiftBottomWidget.b b;

    public a(FormatGiftBottomWidget.d r1, FormatGiftBottomWidget.b r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r9) {
        int r10 = this.b.b;
        int r6 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.c();
        com.bytedance.android.livesdk.gift.util.b.f(new GiftStateMachineConfig.Event.d(r10, false, false, true, true));
        DataCenter r3 = ((Widget) this.a.b).dataCenter;
        String r4 = com.bytedance.android.livesdk.gift.platform.format.panel.statemachine.helper.b.m().getIdString();
        GiftViewModelManager r0 = this.a.b.n;
        if (r0 == null) goto L5;
        IRoom r1 = r0.getRoom();
    L6:
        h.V(r10, r6, "click", r3, r4, r1);
        return;
    L5:
        r1 = null;
        goto L6
    }
}
