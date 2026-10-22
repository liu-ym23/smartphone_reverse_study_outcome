package com.bytedance.android.live.profit.dress.config;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.api.dress.ProfileSkinConfig")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b1\u00102R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR$\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R$\u0010\u0017\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR$\u0010\u001a\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0005\u001a\u0004\b\u001b\u0010\u0007\"\u0004\b\u001c\u0010\tR$\u0010\u001d\u001a\u0004\u0018\u00010\u00108\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0012\u001a\u0004\b\u001e\u0010\u0014\"\u0004\b\u001f\u0010\u0016R$\u0010 \u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u0007\"\u0004\b\"\u0010\tR\u001b\u0010(\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u001b\u0010+\u001a\u00020#8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b)\u0010%\u001a\u0004\b*\u0010'R\u001b\u00100\u001a\u00020,8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b-\u0010%\u001a\u0004\b.\u0010/¨\u00063"}, d2 = {"Lcom/bytedance/android/live/profit/dress/config/IProfileSkinConfigFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/profit/dress/config/r;", "Lpy/k;", "overallBgImg", "Lpy/k;", "getOverallBgImg", "()Lpy/k;", "setOverallBgImg", "(Lpy/k;)V", "panelOpenEffect", "getPanelOpenEffect", "setPanelOpenEffect", "panelLoopEffect", "getPanelLoopEffect", "setPanelLoopEffect", "Lcom/bytedance/android/live/base/model/d;", "borderPoint9", "Lcom/bytedance/android/live/base/model/d;", "getBorderPoint9", "()Lcom/bytedance/android/live/base/model/d;", "setBorderPoint9", "(Lcom/bytedance/android/live/base/model/d;)V", "borderPng", "getBorderPng", "setBorderPng", "rightPng", "getRightPng", "setRightPng", "mainButtonPng", "getMainButtonPng", "setMainButtonPng", "mainButtonWebp", "getMainButtonWebp", "setMainButtonWebp", "", "parallaxAssetId$delegate", "Ljava/lang/Object;", "getParallaxAssetId", "()J", "parallaxAssetId", "profileDisplayAssetId$delegate", "getProfileDisplayAssetId", "profileDisplayAssetId", "", "flashCardId$delegate", "getFlashCardId", "()I", "flashCardId", "<init>", "()V", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IProfileSkinConfigFlexImpl extends FlexModelBase<r> implements r, vh7.h {

    @SerializedName("flash_card_id")
    protected int _$$flashCardId;

    @SerializedName("parallax_asset_id")
    protected long _$$parallaxAssetId;

    @SerializedName("profile_display_asset_id")
    protected long _$$profileDisplayAssetId;

    @SerializedName("border_png")
    protected py.k borderPng;

    @SerializedName("border_point_9")
    protected com.bytedance.android.live.base.model.d borderPoint9;

    @SerializedName("main_button_png")
    protected com.bytedance.android.live.base.model.d mainButtonPng;

    @SerializedName("main_button_webp")
    protected py.k mainButtonWebp;

    @SerializedName("overall_bg_img")
    protected py.k overallBgImg;

    @SerializedName("panel_loop_effect")
    protected py.k panelLoopEffect;

    @SerializedName("panel_open_effect")
    protected py.k panelOpenEffect;

    @SerializedName("right_png")
    protected py.k rightPng;

    public IProfileSkinConfigFlexImpl() {
        super(r.class);
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public py.k getBorderPng() {
        return this.borderPng;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public com.bytedance.android.live.base.model.d getBorderPoint9() {
        return this.borderPoint9;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public final int getFlashCardId() {
        return this._$$flashCardId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public com.bytedance.android.live.base.model.d getMainButtonPng() {
        return this.mainButtonPng;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public py.k getMainButtonWebp() {
        return this.mainButtonWebp;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public py.k getOverallBgImg() {
        return this.overallBgImg;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public py.k getPanelLoopEffect() {
        return this.panelLoopEffect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public py.k getPanelOpenEffect() {
        return this.panelOpenEffect;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public final long getParallaxAssetId() {
        return this._$$parallaxAssetId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public final long getProfileDisplayAssetId() {
        return this._$$profileDisplayAssetId;
    }

    @Override // com.bytedance.android.live.profit.dress.config.r
    public py.k getRightPng() {
        return this.rightPng;
    }

    /* JADX WARN: Type inference failed for: r2v12, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v14, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v16, types: [com.bytedance.android.live.base.model.d, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.live.base.model.d, java.lang.Object] */
    public IProfileSkinConfigFlexImpl(am3.g r5) {
        super(r.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L19;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L14;
            case 6: goto L13;
            case 7: goto L12;
            case 8: goto L11;
            case 9: goto L10;
            case 10: goto L9;
            case 11: goto L8;
            default: goto L7;
        };
    L8:
        this._$$flashCardId = r5.i();
        goto L3
    L9:
        this.mainButtonWebp = vh7.f.a(r5, py.k.class);
        goto L3
    L10:
        this.mainButtonPng = vh7.f.a(r5, com.bytedance.android.live.base.model.d.class);
        goto L3
    L11:
        this.rightPng = vh7.f.a(r5, py.k.class);
        goto L3
    L12:
        this.borderPng = vh7.f.a(r5, py.k.class);
        goto L3
    L13:
        this._$$profileDisplayAssetId = r5.j();
        goto L3
    L14:
        this.borderPoint9 = vh7.f.a(r5, com.bytedance.android.live.base.model.d.class);
        goto L3
    L15:
        this._$$parallaxAssetId = r5.j();
        goto L3
    L16:
        this.panelLoopEffect = vh7.f.a(r5, py.k.class);
        goto L3
    L17:
        this.panelOpenEffect = vh7.f.a(r5, py.k.class);
        goto L3
    L18:
        this.overallBgImg = vh7.f.a(r5, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L19:
        r5.d(r0);
        setThreadSafe(true);
    }

    public void setBorderPng(py.k r1) {
        this.borderPng = r1;
    }

    public void setBorderPoint9(com.bytedance.android.live.base.model.d r1) {
        this.borderPoint9 = r1;
    }

    public void setMainButtonPng(com.bytedance.android.live.base.model.d r1) {
        this.mainButtonPng = r1;
    }

    public void setMainButtonWebp(py.k r1) {
        this.mainButtonWebp = r1;
    }

    public void setOverallBgImg(py.k r1) {
        this.overallBgImg = r1;
    }

    public void setPanelLoopEffect(py.k r1) {
        this.panelLoopEffect = r1;
    }

    public void setPanelOpenEffect(py.k r1) {
        this.panelOpenEffect = r1;
    }

    public void setRightPng(py.k r1) {
        this.rightPng = r1;
    }
}
