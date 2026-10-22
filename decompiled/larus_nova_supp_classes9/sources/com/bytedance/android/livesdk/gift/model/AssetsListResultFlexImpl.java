package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.core.resources.AssetPoolConfigFlexImpl;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.AssetsEffectResponse.Data")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010=R7\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0006\u0010\u0007\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR7\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u000e\u0010\u0007\u001a\u0004\b\u000f\u0010\t\"\u0004\b\u0010\u0010\u000bR+\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0007\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R'\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001b0\u00198VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0007\u001a\u0004\b\u001d\u0010\u001eR7\u0010#\u001a\b\u0012\u0004\u0012\u00020\r0\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\r0\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b \u0010\u0007\u001a\u0004\b!\u0010\t\"\u0004\b\"\u0010\u000bR+\u0010*\u001a\u00020$2\u0006\u0010\u0005\u001a\u00020$8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b%\u0010\u0007\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R7\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b+\u0010\u0007\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR+\u00104\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u001a8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0007\u001a\u0004\b0\u00101\"\u0004\b2\u00103R+\u0010;\u001a\u0002052\u0006\u0010\u0005\u001a\u0002058V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\u0007\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/AssetsListResultFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/d;", BuildConfig.FLAVOR, "Lcom/bytedance/android/live/core/resources/e;", "<set-?>", "assets$delegate", "Ljava/lang/Object;", "getAssets", "()Ljava/util/List;", "setAssets", "(Ljava/util/List;)V", "assets", BuildConfig.FLAVOR, "deleteAssets$delegate", "getDeleteAssets", "setDeleteAssets", "deleteAssets", BuildConfig.FLAVOR, "enableEffectListV2$delegate", "getEnableEffectListV2", "()Z", "setEnableEffectListV2", "(Z)V", "enableEffectListV2", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "Lcom/bytedance/android/live/core/resources/AssetPoolConfigFlexImpl;", "assetPools$delegate", "getAssetPools", "()Ljava/util/Map;", "assetPools", "zipSweepMarkAssets$delegate", "getZipSweepMarkAssets", "setZipSweepMarkAssets", "zipSweepMarkAssets", "Lcom/bytedance/android/livesdk/gift/model/f2;", "imageTemplate$delegate", "getImageTemplate", "()Lcom/bytedance/android/livesdk/gift/model/f2;", "setImageTemplate", "(Lcom/bytedance/android/livesdk/gift/model/f2;)V", "imageTemplate", "baseAssets$delegate", "getBaseAssets", "setBaseAssets", "baseAssets", "assetMetaBaseVersion$delegate", "getAssetMetaBaseVersion", "()Ljava/lang/String;", "setAssetMetaBaseVersion", "(Ljava/lang/String;)V", "assetMetaBaseVersion", "Lcom/bytedance/android/live/core/resources/d;", "dynamicControl$delegate", "getDynamicControl", "()Lcom/bytedance/android/live/core/resources/d;", "setDynamicControl", "(Lcom/bytedance/android/live/core/resources/d;)V", "dynamicControl", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class AssetsListResultFlexImpl extends FlexModelBase<d> implements d, vh7.h {

    @SerializedName("asset_meta_base_version")
    protected String _$$assetMetaBaseVersion;

    @SerializedName("asset_pools")
    protected Map<String, AssetPoolConfigFlexImpl> _$$assetPools;

    @SerializedName("assets")
    protected List<? extends com.bytedance.android.live.core.resources.e> _$$assets;

    @SerializedName("base_assets")
    protected List<? extends com.bytedance.android.live.core.resources.e> _$$baseAssets;

    @SerializedName("delete_assets")
    protected List<Long> _$$deleteAssets;

    @SerializedName("dynamic_control")
    protected com.bytedance.android.live.core.resources.d _$$dynamicControl;

    @SerializedName("enable_effect_list_v2")
    protected boolean _$$enableEffectListV2;

    @SerializedName("image_template")
    protected f2 _$$imageTemplate;

    @SerializedName("zip_sweep_mark_assets")
    protected List<Long> _$$zipSweepMarkAssets;

    public AssetsListResultFlexImpl() {
        super(d.class);
        this._$$assets = $defaultValue_assets$();
        this._$$deleteAssets = $defaultValue_deleteAssets$();
        this._$$enableEffectListV2 = false;
        this._$$assetPools = $defaultValue_assetPools$();
        this._$$zipSweepMarkAssets = $defaultValue_zipSweepMarkAssets$();
        this._$$imageTemplate = $defaultValue_imageTemplate$();
        this._$$baseAssets = $defaultValue_baseAssets$();
        this._$$assetMetaBaseVersion = BuildConfig.FLAVOR;
        this._$$dynamicControl = $defaultValue_dynamicControl$();
    }

    public final com.bytedance.android.live.core.resources.d $defaultValue_dynamicControl$() {
        return (com.bytedance.android.live.core.resources.d) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(com.bytedance.android.live.core.resources.d.class);
    }

    public final f2 $defaultValue_imageTemplate$() {
        return (f2) com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.c(f2.class);
    }

    public final Map<String, AssetPoolConfigFlexImpl> $defaultValue_assetPools$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<com.bytedance.android.live.core.resources.e> $defaultValue_assets$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<com.bytedance.android.live.core.resources.e> $defaultValue_baseAssets$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<Long> $defaultValue_deleteAssets$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    public final List<Long> $defaultValue_zipSweepMarkAssets$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final String getAssetMetaBaseVersion() {
        return this._$$assetMetaBaseVersion;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final Map<String, AssetPoolConfigFlexImpl> getAssetPools() {
        return this._$$assetPools;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final List<com.bytedance.android.live.core.resources.e> getAssets() {
        return this._$$assets;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final List<com.bytedance.android.live.core.resources.e> getBaseAssets() {
        return this._$$baseAssets;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final List<Long> getDeleteAssets() {
        return this._$$deleteAssets;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final com.bytedance.android.live.core.resources.d getDynamicControl() {
        return this._$$dynamicControl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final boolean getEnableEffectListV2() {
        return this._$$enableEffectListV2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final f2 getImageTemplate() {
        return this._$$imageTemplate;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final List<Long> getZipSweepMarkAssets() {
        return this._$$zipSweepMarkAssets;
    }

    /* JADX WARN: Type inference failed for: r4v11, types: [com.bytedance.android.livesdk.gift.model.f2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v17, types: [com.bytedance.android.live.core.resources.d, java.lang.Object] */
    public AssetsListResultFlexImpl(am3.g r13) {
        super(d.class);
        this._$$assets = new ArrayList();
        this._$$deleteAssets = new ArrayList();
        this._$$assetPools = new HashMap();
        this._$$zipSweepMarkAssets = new ArrayList();
        this._$$baseAssets = new ArrayList();
        setThreadSafe(false);
        long r1 = r13.c();
        boolean r3 = false;
    L3:
        int r4 = r13.f();
        if (r4 == (-1)) goto L36;
        am3.g.a r7 = decodeExtensionFields(r4, r13);
        switch(r4) {
            case 1: goto L33;
            case 2: goto L31;
            case 3: goto L30;
            case 4: goto L29;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            case 9: goto L8;
            default: goto L7;
        };
    L8:
        this._$$dynamicControl = vh7.f.a(r13, com.bytedance.android.live.core.resources.d.class);
        goto L3
    L9:
        this._$$assetMetaBaseVersion = am3.h.c(r13);
        goto L3
    L10:
        List<? extends com.bytedance.android.live.core.resources.e> r5 = this._$$baseAssets;
    L34:
        Object r6 = vh7.f.a(r13, com.bytedance.android.live.core.resources.e.class);
    L35:
        r5.add(r6);
        goto L3
    L11:
        this._$$imageTemplate = vh7.f.a(r13, f2.class);
        goto L3
    L12:
        long r8 = r13.c();
        String r9 = null;
        AssetPoolConfigFlexImpl r10 = null;
    L13:
        int r11 = r13.f();
        if (r11 == (-1)) goto L21;
        if (r11 != 1) goto L17;
        r9 = am3.h.c(r13);
        goto L13
    L17:
        if (r11 != 2) goto L18;
        r10 = new AssetPoolConfigFlexImpl(r13);
        goto L13
    L18:
        am3.h.e(r13);
        goto L13
    L21:
        r13.d(r8);
        Map<String, AssetPoolConfigFlexImpl> r14 = this._$$assetPools;
        if (r9 == null) goto L28;
        if (r10 == null) goto L26;
        r14.put(r9, r10);
        goto L3
    L26:
        throw new IllegalStateException("Value must not be null");
    L28:
        throw new IllegalStateException("Key must not be null");
    L29:
        r5 = this._$$zipSweepMarkAssets;
    L32:
        r6 = Long.valueOf(r13.j());
        goto L35
    L30:
        this._$$enableEffectListV2 = am3.h.a(r13);
        r3 = r3 | true;
        goto L3
    L31:
        r5 = this._$$deleteAssets;
        goto L32
    L33:
        r5 = this._$$assets;
        goto L34
    L7:
        am3.h.d(r7, r13);
        goto L3
    L36:
        r13.d(r1);
        setThreadSafe(true);
        if (this._$$assets.isEmpty() == false) goto L40;
        this._$$assets = $defaultValue_assets$();
    L40:
        if (this._$$deleteAssets.isEmpty() == false) goto L43;
        this._$$deleteAssets = $defaultValue_deleteAssets$();
    L43:
        if ((r3 & true) == true) goto L46;
        this._$$enableEffectListV2 = false;
    L46:
        if (this._$$assetPools != null) goto L49;
        this._$$assetPools = $defaultValue_assetPools$();
    L49:
        if (this._$$zipSweepMarkAssets.isEmpty() == false) goto L52;
        this._$$zipSweepMarkAssets = $defaultValue_zipSweepMarkAssets$();
    L52:
        if (this._$$imageTemplate != null) goto L55;
        this._$$imageTemplate = $defaultValue_imageTemplate$();
    L55:
        if (this._$$baseAssets.isEmpty() == false) goto L58;
        this._$$baseAssets = $defaultValue_baseAssets$();
    L58:
        if (this._$$assetMetaBaseVersion != null) goto L61;
        this._$$assetMetaBaseVersion = BuildConfig.FLAVOR;
    L61:
        if (this._$$dynamicControl != null) goto L94;
        this._$$dynamicControl = $defaultValue_dynamicControl$();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setAssetMetaBaseVersion(String r1) {
        this._$$assetMetaBaseVersion = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setAssets(List<? extends com.bytedance.android.live.core.resources.e> r1) {
        this._$$assets = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setBaseAssets(List<? extends com.bytedance.android.live.core.resources.e> r1) {
        this._$$baseAssets = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setDeleteAssets(List<Long> r1) {
        this._$$deleteAssets = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setDynamicControl(com.bytedance.android.live.core.resources.d r1) {
        this._$$dynamicControl = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setEnableEffectListV2(boolean r1) {
        this._$$enableEffectListV2 = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setImageTemplate(f2 r1) {
        this._$$imageTemplate = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.d
    public final void setZipSweepMarkAssets(List<Long> r1) {
        this._$$zipSweepMarkAssets = r1;
    }
}
