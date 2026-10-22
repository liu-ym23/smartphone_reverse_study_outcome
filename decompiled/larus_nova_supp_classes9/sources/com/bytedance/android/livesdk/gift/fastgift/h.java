package com.bytedance.android.livesdk.gift.fastgift;

import android.view.View;
import com.bytedance.android.live.base.model.user.IBaseUser;
import com.bytedance.android.live.revenue.common.ToastUtil;
import com.bytedance.android.livesdk.gift.platform.core.manager.GiftManagerKt;
import com.bytedance.android.livesdkapi.depend.model.live.IRoom;
import com.bytedance.android.livesdkapi.depend.model.live.IRoomAuthStatus;
import com.bytedance.ies.sdk.widgets.DataCenter;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class h implements View.OnClickListener {
    public final /* synthetic */ FastGiftViewV3 a;

    public h(FastGiftViewV3 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r13) {
        DataCenter r14 = this.a.B;
        String r0 = null;
        if (r14 == null) goto L5;
        IRoom r15 = (IRoom) r14.get("data_room", null);
    L7:
        if (this.a.A.enableGift() == true) goto L33;
        if (r15 != null) goto L10;
    L11:
        lr2.a r1 = FastGiftViewV3.b(this.a);
        if (r1 == null) goto L33;
        if (r1.m3() != true) goto L33;
        FastGiftViewV3 r2 = this.a;
        if (r15 == null) goto L22;
        IRoomAuthStatus r3 = r15.getRoomAuthStatus();
        if (r3 == null) goto L22;
        IRoomAuthStatus.IOffReason r4 = r3.getOffReason();
        if (r4 == null) goto L22;
        String r5 = r4.getGift();
    L23:
        r2.getClass();
        if (r5 == null) goto L26;
        ToastUtil.b(r5, 0);
    L26:
        FastGiftViewV3 r6 = this.a;
        boolean r7 = r6.k;
        long r8 = r6.A.getGiftId();
        GiftManagerKt.z.getClass();
        com.bytedance.android.livesdk.gift.platform.core.model.e0 r9 = GiftManagerKt.x();
        my1.a r10 = this.a.A.getFastTaskGiftModel();
        Map<String, String> r11 = this.a.A.getRecommendLog();
        int r16 = this.a.A.getRecommendNum();
        if (r15 == null) goto L31;
        IBaseUser r17 = r15.getOwner();
        if (r17 == null) goto L31;
        r0 = r17.getIdString();
    L31:
        a.e(r7, r8, r9, 1, r10, r11, r16, r0);
        return;
    L22:
        r5 = null;
        goto L23
    L10:
        if (r15.isMediaRoom() != true) goto L11;
    L33:
        this.a.i(1);
        return;
    L5:
        r15 = null;
        goto L7
    }
}
