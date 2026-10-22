package com.bytedance.android.live.profit.privilege.model.touch;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.TouchPositionDetail")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR/\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR/\u0010\u0012\u001a\u0004\u0018\u00010\f2\b\u0010\u0004\u001a\u0004\u0018\u00010\f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\r\u0010\u0006\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R/\u0010\u0019\u001a\u0004\u0018\u00010\u00132\b\u0010\u0004\u001a\u0004\u0018\u00010\u00138V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0014\u0010\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/bytedance/android/live/profit/privilege/model/touch/TouchPositionDetailFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/privilege/model/touch/q;", "Lcom/bytedance/android/live/profit/privilege/model/touch/f;", "<set-?>", "giftPanelTopDetail$delegate", "Ljava/lang/Object;", "getGiftPanelTopDetail", "()Lcom/bytedance/android/live/profit/privilege/model/touch/f;", "setGiftPanelTopDetail", "(Lcom/bytedance/android/live/profit/privilege/model/touch/f;)V", "giftPanelTopDetail", "Lcom/bytedance/android/live/profit/privilege/model/touch/a;", "diamondListBannerDetail$delegate", "getDiamondListBannerDetail", "()Lcom/bytedance/android/live/profit/privilege/model/touch/a;", "setDiamondListBannerDetail", "(Lcom/bytedance/android/live/profit/privilege/model/touch/a;)V", "diamondListBannerDetail", "Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;", "giftPanelPrivilegeEntranceInfo$delegate", "getGiftPanelPrivilegeEntranceInfo", "()Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;", "setGiftPanelPrivilegeEntranceInfo", "(Lcom/bytedance/android/live/profit/privilege/model/touch/GiftPanelEntranceDetail;)V", "giftPanelPrivilegeEntranceInfo", "<init>", "()V", "revenue-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class TouchPositionDetailFlexImpl extends FlexModelBase<q> implements q, vh7.h {

    @SerializedName("diamond_list_banner_detail")
    protected a _$$diamondListBannerDetail;

    @SerializedName("gift_panel_entrance_detail")
    protected GiftPanelEntranceDetail _$$giftPanelPrivilegeEntranceInfo;

    @SerializedName("gift_panel_top_detail")
    protected f _$$giftPanelTopDetail;

    public TouchPositionDetailFlexImpl() {
        super(q.class);
    }

    /* JADX WARN: Type inference failed for: r2v2, types: [com.bytedance.android.live.profit.privilege.model.touch.GiftPanelEntranceDetail, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v4, types: [com.bytedance.android.live.profit.privilege.model.touch.a, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v6, types: [com.bytedance.android.live.profit.privilege.model.touch.f, java.lang.Object] */
    public TouchPositionDetailFlexImpl(am3.g r6) {
        super(q.class);
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        if (r2 != 1) goto L8;
        this._$$giftPanelTopDetail = vh7.f.a(r6, f.class);
        goto L3
    L8:
        if (r2 != 2) goto L10;
        this._$$diamondListBannerDetail = vh7.f.a(r6, a.class);
        goto L3
    L10:
        if (r2 != 5) goto L11;
        this._$$giftPanelPrivilegeEntranceInfo = vh7.f.a(r6, GiftPanelEntranceDetail.class);
        goto L3
    L11:
        am3.h.d(r3, r6);
        goto L3
    L15:
        r6.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.q
    public final a getDiamondListBannerDetail() {
        return this._$$diamondListBannerDetail;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.q
    public final GiftPanelEntranceDetail getGiftPanelPrivilegeEntranceInfo() {
        return this._$$giftPanelPrivilegeEntranceInfo;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.q
    public final f getGiftPanelTopDetail() {
        return this._$$giftPanelTopDetail;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.q
    public final void setDiamondListBannerDetail(a r1) {
        this._$$diamondListBannerDetail = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.q
    public final void setGiftPanelPrivilegeEntranceInfo(GiftPanelEntranceDetail r1) {
        this._$$giftPanelPrivilegeEntranceInfo = r1;
    }

    @Override // com.bytedance.android.live.profit.privilege.model.touch.q
    public final void setGiftPanelTopDetail(f r1) {
        this._$$giftPanelTopDetail = r1;
    }
}
