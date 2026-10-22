package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R$\u0010\t\u001a\u0004\u0018\u00010\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R$\u0010\u0010\u001a\u0004\u0018\u00010\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR$\u0010\u0017\u001a\u0004\u0018\u00010\u00118&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0016\u0010\b\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/q;", "Lvh7/c;", "Lcom/bytedance/android/live/profit/privilege/model/touch/f;", "getGiftPanelTopDetail", "()Lcom/bytedance/android/live/profit/privilege/model/touch/f;", "setGiftPanelTopDetail", "(Lcom/bytedance/android/live/profit/privilege/model/touch/f;)V", "getGiftPanelTopDetail$annotations", "()V", "giftPanelTopDetail", "Lcom/bytedance/android/live/profit/privilege/model/touch/a;", "getDiamondListBannerDetail", "()Lcom/bytedance/android/live/profit/privilege/model/touch/a;", "setDiamondListBannerDetail", "(Lcom/bytedance/android/live/profit/privilege/model/touch/a;)V", "getDiamondListBannerDetail$annotations", "diamondListBannerDetail", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;", "getGiftPanelPrivilegeEntranceInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;", "setGiftPanelPrivilegeEntranceInfo", "(Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;)V", "getGiftPanelPrivilegeEntranceInfo$annotations", "giftPanelPrivilegeEntranceInfo", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface q extends vh7.c<q> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    @FieldName(name = "diamond_list_banner_detail")
    com.bytedance.android.live.profit.privilege.model.touch.a getDiamondListBannerDetail();

    @FieldName(name = "gift_panel_entrance_detail")
    GiftPanelEntranceDetail getGiftPanelPrivilegeEntranceInfo();

    @FieldName(name = "gift_panel_top_detail")
    f getGiftPanelTopDetail();

    @FieldName(name = "diamond_list_banner_detail#setter")
    void setDiamondListBannerDetail(com.bytedance.android.live.profit.privilege.model.touch.a r1);

    @FieldName(name = "gift_panel_entrance_detail#setter")
    void setGiftPanelPrivilegeEntranceInfo(GiftPanelEntranceDetail r1);

    @FieldName(name = "gift_panel_top_detail#setter")
    void setGiftPanelTopDetail(f r1);
}
