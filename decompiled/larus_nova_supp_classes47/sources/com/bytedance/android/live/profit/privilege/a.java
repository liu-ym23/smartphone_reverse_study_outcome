package com.bytedance.android.live.profit.privilege;

import com.bytedance.android.live.profit.privilege.model.danmu.DanmakuTabList;
import com.bytedance.android.live.profit.privilege.model.danmu.PrivilegeBarrageResponse;
import com.bytedance.android.live.profit.privilege.model.danmu.SendPrivilegeBarrageArgs;
import com.bytedance.android.live.profit.privilege.model.paygrade.PayGrade;
import com.bytedance.android.live.profit.privilege.model.touch.GiftPanelTouchData;
import com.bytedance.android.live.profit.privilege.model.touch.TouchPositionData;
import com.bytedance.live.datacontext.m;
import io.reactivex.Single;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public interface a extends dy0.d {
    void Te();

    Single<PrivilegeBarrageResponse> V3(SendPrivilegeBarrageArgs r1);

    m<Long> getBubbleRefId();

    m<? extends DanmakuTabList> getDanmakuTabList();

    m<? extends GiftPanelTouchData> getGiftPanelTouchData();

    m<? extends PayGrade> getPayGrade();

    m<? extends TouchPositionData> getTouchPositionData();

    m<Boolean> isInDanmakuMode();

    void jl();

    void k0(int r1);

    void k6();

    void nl(Long r1);

    void vo(long r1, String r3, String r4, String r5);
}
