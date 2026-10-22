package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.CustomizedDiamond")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b!\u0010\"R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u0010\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u0005\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0015\u001a\u00020\u00118VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0014R\u001b\u0010\u0018\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u001d\u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u001cR\u001d\u0010 \u001a\u0004\u0018\u00010\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\u0005\u001a\u0004\b\u001f\u0010\u001c¨\u0006#"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/ICustomDiamondFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/e;", "", "id$delegate", "Ljava/lang/Object;", "getId", "()J", "id", "", "minPrice$delegate", "getMinPrice", "()I", "minPrice", "maxPrice$delegate", "getMaxPrice", "maxPrice", "", "diamondCountRate$delegate", "getDiamondCountRate", "()F", "diamondCountRate", "rewardDiamondCount$delegate", "getRewardDiamondCount", "rewardDiamondCount", "", "describe$delegate", "getDescribe", "()Ljava/lang/String;", "describe", "couponId$delegate", "getCouponId", "couponId", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class ICustomDiamondFlexImpl extends FlexModelBase<e> implements e, vh7.h {

    @SerializedName("coupon_id")
    protected String _$$couponId;

    @SerializedName("describe")
    protected String _$$describe;

    @SerializedName("diamond_count_rate")
    protected float _$$diamondCountRate;

    @SerializedName("id")
    protected long _$$id;

    @SerializedName("price_max")
    protected int _$$maxPrice;

    @SerializedName("price_min")
    protected int _$$minPrice;

    @SerializedName("giving_count")
    protected int _$$rewardDiamondCount;

    public ICustomDiamondFlexImpl() {
        super(e.class);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public final String getCouponId() {
        return this._$$couponId;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public final String getDescribe() {
        return this._$$describe;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public final float getDiamondCountRate() {
        return this._$$diamondCountRate;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public final long getId() {
        return this._$$id;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public final int getMaxPrice() {
        return this._$$maxPrice;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public final int getMinPrice() {
        return this._$$minPrice;
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public final int getRewardDiamondCount() {
        return this._$$rewardDiamondCount;
    }

    public ICustomDiamondFlexImpl(am3.g r5) {
        super(e.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L15;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L14;
            case 2: goto L13;
            case 3: goto L12;
            case 4: goto L11;
            case 5: goto L10;
            case 6: goto L9;
            case 7: goto L8;
            default: goto L7;
        };
    L8:
        this._$$couponId = am3.h.c(r5);
        goto L3
    L9:
        this._$$describe = am3.h.c(r5);
        goto L3
    L10:
        this._$$rewardDiamondCount = r5.i();
        goto L3
    L11:
        this._$$diamondCountRate = Float.intBitsToFloat(r5.g());
        goto L3
    L12:
        this._$$maxPrice = r5.i();
        goto L3
    L13:
        this._$$minPrice = r5.i();
        goto L3
    L14:
        this._$$id = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L15:
        r5.d(r0);
        setThreadSafe(true);
    }
}
