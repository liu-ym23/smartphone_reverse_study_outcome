package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.livesdkapi.depend.model.IChargeDeal;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import py.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u00104\u001a\u00020\u0002¢\u0006\u0004\b5\u00106J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR$\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u00118\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0018\u001a\u00020\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001bR\u0016\u0010 \u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0014\u0010\"\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u001bR\u0014\u0010$\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u001bR\u0014\u0010(\u001a\u00020%8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0016\u0010*\u001a\u0004\u0018\u00010\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b)\u0010\u0017R\u0014\u0010.\u001a\u00020+8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b,\u0010-R\u0014\u0010/\u001a\u00020%8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b/\u0010'R\u0014\u00101\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b0\u0010\u001bR\u0014\u00103\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b2\u0010\u001b¨\u00067"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/IMainChargeDealExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;", "Lcom/bytedance/android/live/recharge/platform/model/d;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lpy/k;", "getIconImage", "()Lpy/k;", "iconImage", "", "Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal$ICurrencyPrice;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getCurrencyPrice", "()Ljava/util/List;", "currencyPrice", "", "getDescribe", "()Ljava/lang/String;", "describe", "", "getDescribeType", "()I", "describeType", "getDiamondCount", "diamondCount", "getDiamondSignInfo", "diamondSignInfo", "getDiscountPrice", "discountPrice", "getExchangePrice", "exchangePrice", "", "getHideGivingCount", "()Z", "hideGivingCount", "getIapProductId", "iapProductId", "", "getId", "()J", "id", "isCustomizedDiamond", "getPrice", "price", "getRewardDiamondCount", "rewardDiamondCount", "base", "<init>", "(Lcom/bytedance/android/livesdkapi/depend/model/IChargeDeal;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainChargeDealExtensionImpl extends ModelExtensionBase<IChargeDeal, d> implements d, IChargeDeal {
    private final /* synthetic */ IChargeDeal $$delegate_0;

    @Override // com.bytedance.android.live.recharge.platform.model.d
    public <R extends vh7.e<IChargeDeal>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.recharge.platform.model.d
    public <R extends vh7.e<IChargeDeal>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    public List<IChargeDeal.ICurrencyPrice> getCurrencyPrice() {
        return this.$$delegate_0.getCurrencyPrice();
    }

    public String getDescribe() {
        return this.$$delegate_0.getDescribe();
    }

    public int getDescribeType() {
        return this.$$delegate_0.getDescribeType();
    }

    public int getDiamondCount() {
        return this.$$delegate_0.getDiamondCount();
    }

    public String getDiamondSignInfo() {
        return this.$$delegate_0.getDiamondSignInfo();
    }

    public int getDiscountPrice() {
        return this.$$delegate_0.getDiscountPrice();
    }

    public int getExchangePrice() {
        return this.$$delegate_0.getExchangePrice();
    }

    public boolean getHideGivingCount() {
        return this.$$delegate_0.getHideGivingCount();
    }

    public String getIapProductId() {
        return this.$$delegate_0.getIapProductId();
    }

    public long getId() {
        return this.$$delegate_0.getId();
    }

    public int getPrice() {
        return this.$$delegate_0.getPrice();
    }

    public int getRewardDiamondCount() {
        return this.$$delegate_0.getRewardDiamondCount();
    }

    public boolean isCustomizedDiamond() {
        return this.$$delegate_0.isCustomizedDiamond();
    }

    @Override // com.bytedance.android.live.recharge.platform.model.d
    public k getIconImage() {
        return (k) get(13, d.class);
    }

    public IMainChargeDealExtensionImpl(IChargeDeal r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
