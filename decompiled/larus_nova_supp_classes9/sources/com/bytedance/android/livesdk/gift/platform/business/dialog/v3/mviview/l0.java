package com.bytedance.android.livesdk.gift.platform.business.dialog.v3.mviview;

import android.view.View;
import com.bytedance.android.livesdk.gift.platform.business.dialog.v2.viewmodel.GiftViewModelManager;
import com.bytedance.android.livesdk.gift.platform.core.scope.service.GiftInRoomService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class l0 implements View.OnClickListener {
    public final /* synthetic */ GiftMVIRechargeView a;

    public l0(GiftMVIRechargeView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        if (com.bytedance.android.live.revenue.core.util.f.a(l01.d.class).isLogin() == true) goto L12;
        i12.e r4 = i12.o.b();
        if (r4 == null) goto L7;
        Object r5 = com.bytedance.android.scope.m.e.d(r4, GiftInRoomService.class);
    L8:
        GiftInRoomService r6 = (GiftInRoomService) r5;
        if (r6 == null) goto L14;
        r6.a(GiftViewModelManager.LIVE_GIFT_DIALOG_TASK_GIFT_LOGIN);
        return;
    L14:
        return;
    L7:
        r5 = null;
        goto L8
    L12:
        String r7 = vh6.c.b(dr2.a.class).vl();
        com.bytedance.android.live.revenue.core.util.f.a(zz0.g.class).S2(this.a.getContext(), r7);
    }
}
