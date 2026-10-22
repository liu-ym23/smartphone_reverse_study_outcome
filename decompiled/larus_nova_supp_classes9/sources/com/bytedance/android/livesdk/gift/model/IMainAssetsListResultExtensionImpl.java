package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.ModelExtensionBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\b\u0012\u0004\u0012\u00020\u00020\u00042\u00020\u00032\u00020\u0002B\u000f\u0012\u0006\u0010<\u001a\u00020\u0002¢\u0006\u0004\b=\u0010>J.\u0010\b\u001a\u00028\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\b\u0010\tJ0\u0010\n\u001a\u0004\u0018\u00018\u0000\"\u000e\b\u0000\u0010\u0005*\b\u0012\u0004\u0012\u00020\u00020\u00042\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006H\u0096\u0001¢\u0006\u0004\b\n\u0010\tR\u001c\u0010\u0010\u001a\u00020\u000b8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR0\u0010\u0016\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011j\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0012`\u00138\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R,\u0010\u001e\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR,\u0010!\u001a\u0012\u0012\u0004\u0012\u00020\u00180\u0017j\b\u0012\u0004\u0012\u00020\u0018`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR4\u0010&\u001a\u001a\u0012\b\u0012\u00060\"j\u0002`#0\u0017j\f\u0012\b\u0012\u00060\"j\u0002`#`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b$\u0010\u001b\"\u0004\b%\u0010\u001dR\u001c\u0010,\u001a\u00020'8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u00102\u001a\u00020-8\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u001c\u00108\u001a\u0002038\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b4\u00105\"\u0004\b6\u00107R4\u0010;\u001a\u001a\u0012\b\u0012\u00060\"j\u0002`#0\u0017j\f\u0012\b\u0012\u00060\"j\u0002`#`\u00198\u0016@\u0016X\u0097\u000f¢\u0006\f\u001a\u0004\b9\u0010\u001b\"\u0004\b:\u0010\u001d¨\u0006?"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IMainAssetsListResultExtensionImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/ModelExtensionBase;", "Lcom/bytedance/android/livesdk/gift/model/d;", "Lcom/bytedance/android/livesdk/gift/model/i2;", "Lvh7/e;", "R", "Ljava/lang/Class;", "type", "castTo", "(Ljava/lang/Class;)Lvh7/e;", "castToOrNull", BuildConfig.FLAVOR, "getAssetMetaBaseVersion", "()Ljava/lang/String;", "setAssetMetaBaseVersion", "(Ljava/lang/String;)V", "assetMetaBaseVersion", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/core/resources/c;", "Lcom/bytedance/revenue/platform/api/core/KmpMap;", "getAssetPools", "()Ljava/util/Map;", "assetPools", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/core/resources/e;", "Lcom/bytedance/revenue/platform/api/core/KmpList;", "getAssets", "()Ljava/util/List;", "setAssets", "(Ljava/util/List;)V", "assets", "getBaseAssets", "setBaseAssets", "baseAssets", BuildConfig.FLAVOR, "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getDeleteAssets", "setDeleteAssets", "deleteAssets", "Lcom/bytedance/android/live/core/resources/d;", "getDynamicControl", "()Lcom/bytedance/android/live/core/resources/d;", "setDynamicControl", "(Lcom/bytedance/android/live/core/resources/d;)V", "dynamicControl", BuildConfig.FLAVOR, "getEnableEffectListV2", "()Z", "setEnableEffectListV2", "(Z)V", "enableEffectListV2", "Lcom/bytedance/android/livesdk/gift/model/f2;", "getImageTemplate", "()Lcom/bytedance/android/livesdk/gift/model/f2;", "setImageTemplate", "(Lcom/bytedance/android/livesdk/gift/model/f2;)V", "imageTemplate", "getZipSweepMarkAssets", "setZipSweepMarkAssets", "zipSweepMarkAssets", "base", "<init>", "(Lcom/bytedance/android/livesdk/gift/model/d;)V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public class IMainAssetsListResultExtensionImpl extends ModelExtensionBase<d, i2> implements i2, d {
    private final /* synthetic */ d $$delegate_0;

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public <R extends vh7.e<d>> R castTo(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castTo(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public <R extends vh7.e<d>> R castToOrNull(Class<R> r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return (R) this.$$delegate_0.castToOrNull(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public String getAssetMetaBaseVersion() {
        return this.$$delegate_0.getAssetMetaBaseVersion();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public Map<String, com.bytedance.android.live.core.resources.c> getAssetPools() {
        return this.$$delegate_0.getAssetPools();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public List<com.bytedance.android.live.core.resources.e> getAssets() {
        return this.$$delegate_0.getAssets();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public List<com.bytedance.android.live.core.resources.e> getBaseAssets() {
        return this.$$delegate_0.getBaseAssets();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public List<Long> getDeleteAssets() {
        return this.$$delegate_0.getDeleteAssets();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public com.bytedance.android.live.core.resources.d getDynamicControl() {
        return this.$$delegate_0.getDynamicControl();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public boolean getEnableEffectListV2() {
        return this.$$delegate_0.getEnableEffectListV2();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public f2 getImageTemplate() {
        return this.$$delegate_0.getImageTemplate();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public List<Long> getZipSweepMarkAssets() {
        return this.$$delegate_0.getZipSweepMarkAssets();
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setAssetMetaBaseVersion(String r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setAssetMetaBaseVersion(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setAssets(List<? extends com.bytedance.android.live.core.resources.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setAssets(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setBaseAssets(List<? extends com.bytedance.android.live.core.resources.e> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setBaseAssets(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setDeleteAssets(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setDeleteAssets(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setDynamicControl(com.bytedance.android.live.core.resources.d r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setDynamicControl(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setEnableEffectListV2(boolean r2) {
        this.$$delegate_0.setEnableEffectListV2(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setImageTemplate(f2 r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setImageTemplate(r2);
    }

    @Override // com.bytedance.android.livesdk.gift.model.i2, com.bytedance.android.livesdk.gift.model.d
    public void setZipSweepMarkAssets(List<Long> r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.$$delegate_0.setZipSweepMarkAssets(r2);
    }

    public IMainAssetsListResultExtensionImpl(d r2) {
        Intrinsics.checkNotNullParameter(r2, "base");
        super(r2);
        this.$$delegate_0 = r2;
    }
}
