package com.bytedance.android.live.recharge.platform.business.model.diamond;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010%\u001a\u00020\u0002¢\u0006\u0004\b&\u0010'J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u000f8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011R\u0014\u0010\u0018\u001a\u00020\u00158\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u001c\u001a\u00020\u00198\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010 \u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010\"\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0014\u0010$\u001a\u00020\u001d8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b#\u0010\u001f¨\u0006("}, d2 = {"Lcom/bytedance/android/live/recharge/platform/business/model/diamond/IMainCustomDiamondExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/e;", "Lcom/bytedance/android/live/recharge/platform/business/model/diamond/f;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "Lpy/k;", "getIconImage", "()Lpy/k;", "iconImage", "", "getCouponId", "()Ljava/lang/String;", "couponId", "getDescribe", "describe", "", "getDiamondCountRate", "()F", "diamondCountRate", "", "getId", "()J", "id", "", "getMaxPrice", "()I", "maxPrice", "getMinPrice", "minPrice", "getRewardDiamondCount", "rewardDiamondCount", "base", "<init>", "(Lcom/bytedance/android/live/recharge/platform/business/model/diamond/e;)V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainCustomDiamondExtensionImpl extends ModelExtensionBase<e, f> implements f, e {
    private final /* synthetic */ e $$delegate_0;

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public <R extends vh7.e<e>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public <R extends vh7.e<e>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public String getCouponId() {
        return this.$$delegate_0.getCouponId();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public String getDescribe() {
        return this.$$delegate_0.getDescribe();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public float getDiamondCountRate() {
        return this.$$delegate_0.getDiamondCountRate();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public long getId() {
        return this.$$delegate_0.getId();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public int getMaxPrice() {
        return this.$$delegate_0.getMaxPrice();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public int getMinPrice() {
        return this.$$delegate_0.getMinPrice();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f, com.bytedance.android.live.recharge.platform.business.model.diamond.e
    public int getRewardDiamondCount() {
        return this.$$delegate_0.getRewardDiamondCount();
    }

    @Override // com.bytedance.android.live.recharge.platform.business.model.diamond.f
    public py.k getIconImage() {
        return (py.k) get(8, f.class);
    }

    public IMainCustomDiamondExtensionImpl(e r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
