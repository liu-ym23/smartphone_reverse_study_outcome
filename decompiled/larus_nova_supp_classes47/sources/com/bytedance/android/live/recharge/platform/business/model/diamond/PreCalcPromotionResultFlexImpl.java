package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.wallet.PreCalcPromotionPriceResult.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0014\u0010\u0015R)\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\tR;\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\u000e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/PreCalcPromotionResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/k;", "", "", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/IPanelExtraInfoFlexImpl;", "panelExtraInfo$delegate", "Ljava/lang/Object;", "getPanelExtraInfo", "()Ljava/util/Map;", "panelExtraInfo", "", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/d;", "<set-?>", "coupons$delegate", "getCoupons", "()Ljava/util/List;", "setCoupons", "(Ljava/util/List;)V", "coupons", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PreCalcPromotionResultFlexImpl extends FlexModelBase<k> implements k, vh7.h {

    @SerializedName("coupon_info_list")
    protected List<? extends d> _$$coupons;

    @SerializedName("panel_extra_info_map")
    protected Map<Long, IPanelExtraInfoFlexImpl> _$$panelExtraInfo;

    public PreCalcPromotionResultFlexImpl() {
        super(k.class);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.k
    public final List<d> getCoupons() {
        return this._$$coupons;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.k
    public final Map<Long, IPanelExtraInfoFlexImpl> getPanelExtraInfo() {
        return this._$$panelExtraInfo;
    }

    public PreCalcPromotionResultFlexImpl(am3.g r12) {
        super(k.class);
        this._$$panelExtraInfo = new HashMap();
        this._$$coupons = new ArrayList();
        setThreadSafe(false);
        long r0 = r12.c();
    L3:
        int r2 = r12.f();
        if (r2 == (-1)) goto L28;
        am3.g.a r5 = decodeExtensionFields(r2, r12);
        if (r2 != 1) goto L8;
        long r6 = r12.c();
        Long r3 = null;
        IPanelExtraInfoFlexImpl r7 = null;
    L12:
        int r8 = r12.f();
        if (r8 == (-1)) goto L20;
        if (r8 != 1) goto L16;
        r3 = Long.valueOf(r12.j());
        goto L12
    L16:
        if (r8 != 2) goto L17;
        r7 = new IPanelExtraInfoFlexImpl(r12);
        goto L12
    L17:
        am3.h.e(r12);
        goto L12
    L20:
        r12.d(r6);
        Map<Long, IPanelExtraInfoFlexImpl> r4 = this._$$panelExtraInfo;
        if (r3 == null) goto L27;
        if (r7 == null) goto L25;
        r4.put(r3, r7);
        goto L3
    L25:
        throw new IllegalStateException("Value must not be null");
    L27:
        throw new IllegalStateException("Key must not be null");
    L8:
        if (r2 != 14) goto L9;
        this._$$coupons.add(vh7.f.a(r12, d.class));
        goto L3
    L9:
        am3.h.d(r5, r12);
        goto L3
    L28:
        r12.d(r0);
        setThreadSafe(true);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.k
    public final void setCoupons(List<? extends d> r1) {
        this._$$coupons = r1;
    }
}
