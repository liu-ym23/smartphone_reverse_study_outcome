package com.bytedance.android.live.profit.dress.config;

import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u00100\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u0014\u0010\u000e\u001a\u00020\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0015\u001a\u00060\u0011j\u0002`\u00128\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0016\u0010\rR\u0014\u0010\u0019\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\rR\u0014\u0010\u001b\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001a\u0010\rR$\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u001d0\u001cj\b\u0012\u0004\u0012\u00020\u001d`\u001e8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0014\u0010#\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\"\u0010\rR\u0014\u0010'\u001a\u00020$8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0016\u0010+\u001a\u0004\u0018\u00010(8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0014\u0010-\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b,\u0010\rR\u0014\u0010/\u001a\u00020\u000b8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b.\u0010\r¨\u00063"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IMainLinkmicDecorationConfigExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/live/profit/dress/config/k;", "Lcom/bytedance/android/live/profit/dress/config/o;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", "", "getSponsorBgColor", "()Ljava/lang/String;", "sponsorBgColor", "getBeautyEffectId", "beautyEffectId", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getHonorIcon", "()Lpy/k;", "honorIcon", "getLinkmicDynamicEffect", "linkmicDynamicEffect", "getLinkmicStaticEffect", "linkmicStaticEffect", "getName", "name", "", "", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getPlayType", "()Ljava/util/List;", "playType", "getPlayValueIcon", "playValueIcon", "", "getShowFlymicEffect", "()Z", "showFlymicEffect", "Lcom/bytedance/android/live/profit/dress/config/l;", "getStarWishConfig", "()Lcom/bytedance/android/live/profit/dress/config/l;", "starWishConfig", "getValueBgColor", "valueBgColor", "getValueNumberColor", "valueNumberColor", "base", "<init>", "(Lcom/bytedance/android/live/profit/dress/config/k;)V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainLinkmicDecorationConfigExtensionImpl extends ModelExtensionBase<k, o> implements o, k {
    private final /* synthetic */ k $$delegate_0;

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public <R extends vh7.e<k>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public <R extends vh7.e<k>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public String getBeautyEffectId() {
        return this.$$delegate_0.getBeautyEffectId();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public py.k getHonorIcon() {
        return this.$$delegate_0.getHonorIcon();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public String getLinkmicDynamicEffect() {
        return this.$$delegate_0.getLinkmicDynamicEffect();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public String getLinkmicStaticEffect() {
        return this.$$delegate_0.getLinkmicStaticEffect();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public String getName() {
        return this.$$delegate_0.getName();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public List<Integer> getPlayType() {
        return this.$$delegate_0.getPlayType();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public String getPlayValueIcon() {
        return this.$$delegate_0.getPlayValueIcon();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public boolean getShowFlymicEffect() {
        return this.$$delegate_0.getShowFlymicEffect();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public l getStarWishConfig() {
        return this.$$delegate_0.getStarWishConfig();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public String getValueBgColor() {
        return this.$$delegate_0.getValueBgColor();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o, com.bytedance.android.live.profit.dress.config.k
    public String getValueNumberColor() {
        return this.$$delegate_0.getValueNumberColor();
    }

    @Override // com.bytedance.android.live.profit.dress.config.o
    public String getSponsorBgColor() {
        return (String) get(9, o.class, "");
    }

    public IMainLinkmicDecorationConfigExtensionImpl(k r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
