package com.bytedance.android.live.recharge.platform.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@ProtoMessage("webcast.data.BannerRechargeInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b<\u0010=R\u001b\u0010\b\u001a\u00020\u00038VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\r\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0005\u001a\u0004\b\u0010\u0010\u0011R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\u0005\u001a\u0004\b\u0014\u0010\u0011R\u001d\u0010\u0018\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0005\u001a\u0004\b\u0017\u0010\u0011R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u0005\u001a\u0004\b\u001a\u0010\u0011R\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u0011R\u001d\u0010!\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0005\u001a\u0004\b \u0010\u0011R\u001d\u0010$\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\"\u0010\u0005\u001a\u0004\b#\u0010\u0011R\u001b\u0010'\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b%\u0010\u0005\u001a\u0004\b&\u0010\fR\u001b\u0010*\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010\fR\u001d\u0010-\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b+\u0010\u0005\u001a\u0004\b,\u0010\u0011R\u001d\u00100\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b.\u0010\u0005\u001a\u0004\b/\u0010\u0011R\u001b\u00103\u001a\u00020\t8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b1\u0010\u0005\u001a\u0004\b2\u0010\fR\u001d\u00106\u001a\u0004\u0018\u00010\u000e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b4\u0010\u0005\u001a\u0004\b5\u0010\u0011R\u001b\u0010;\u001a\u0002078VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b8\u0010\u0005\u001a\u0004\b9\u0010:¨\u0006>"}, d2 = {"Lcom/bytedance/android/live/recharge/platform/model/RechargeBannerInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/live/recharge/platform/model/RechargeBannerInfo;", "", "bannerType$delegate", "Ljava/lang/Object;", "getBannerType", "()I", "bannerType", "", "bannerId$delegate", "getBannerId", "()J", "bannerId", "", "bannerTopDescText$delegate", "getBannerTopDescText", "()Ljava/lang/String;", "bannerTopDescText", "bannerTopDescColor$delegate", "getBannerTopDescColor", "bannerTopDescColor", "bannerBottomDescText$delegate", "getBannerBottomDescText", "bannerBottomDescText", "bannerBottomDescColor$delegate", "getBannerBottomDescColor", "bannerBottomDescColor", "bannerIconImage$delegate", "getBannerIconImage", "bannerIconImage", "bannerBgImage$delegate", "getBannerBgImage", "bannerBgImage", "schemeUrl$delegate", "getSchemeUrl", "schemeUrl", "currentProgress$delegate", "getCurrentProgress", "currentProgress", "totalProgress$delegate", "getTotalProgress", "totalProgress", "progressBgColor$delegate", "getProgressBgColor", "progressBgColor", "progressIndicatorColor$delegate", "getProgressIndicatorColor", "progressIndicatorColor", "validEndTime$delegate", "getValidEndTime", "validEndTime", "bannerGuideDescIcon$delegate", "getBannerGuideDescIcon", "bannerGuideDescIcon", "", "screenShield$delegate", "getScreenShield", "()Z", "screenShield", "<init>", "()V", "liverecharge-impl_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class RechargeBannerInfoFlexImpl extends FlexModelBase<RechargeBannerInfo> implements RechargeBannerInfo, vh7.h {

    @SerializedName("banner_bg_img")
    protected String _$$bannerBgImage;

    @SerializedName("banner_bottom_desc_color")
    protected String _$$bannerBottomDescColor;

    @SerializedName("banner_bottom_desc_text")
    protected String _$$bannerBottomDescText;

    @SerializedName("banner_guide_desc_img")
    protected String _$$bannerGuideDescIcon;

    @SerializedName("banner_icon_img")
    protected String _$$bannerIconImage;

    @SerializedName("banner_id")
    protected long _$$bannerId;

    @SerializedName("banner_top_desc_color")
    protected String _$$bannerTopDescColor;

    @SerializedName("banner_top_desc_text")
    protected String _$$bannerTopDescText;

    @SerializedName("banner_type")
    protected int _$$bannerType;

    @SerializedName("current_cnt")
    protected long _$$currentProgress;

    @SerializedName("progress_bg_color")
    protected String _$$progressBgColor;

    @SerializedName("progress_indicator_color")
    protected String _$$progressIndicatorColor;

    @SerializedName("scheme_url")
    protected String _$$schemeUrl;

    @SerializedName("screen_shield")
    protected boolean _$$screenShield;

    @SerializedName("total_progress")
    protected long _$$totalProgress;

    @SerializedName("valid_end_time")
    protected long _$$validEndTime;

    public RechargeBannerInfoFlexImpl() {
        super(RechargeBannerInfo.class);
        this._$$screenShield = false;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getBannerBgImage() {
        return this._$$bannerBgImage;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getBannerBottomDescColor() {
        return this._$$bannerBottomDescColor;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getBannerBottomDescText() {
        return this._$$bannerBottomDescText;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getBannerGuideDescIcon() {
        return this._$$bannerGuideDescIcon;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getBannerIconImage() {
        return this._$$bannerIconImage;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final long getBannerId() {
        return this._$$bannerId;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getBannerTopDescColor() {
        return this._$$bannerTopDescColor;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getBannerTopDescText() {
        return this._$$bannerTopDescText;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final int getBannerType() {
        return this._$$bannerType;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final long getCurrentProgress() {
        return this._$$currentProgress;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getProgressBgColor() {
        return this._$$progressBgColor;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getProgressIndicatorColor() {
        return this._$$progressIndicatorColor;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final String getSchemeUrl() {
        return this._$$schemeUrl;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final boolean getScreenShield() {
        return this._$$screenShield;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final long getTotalProgress() {
        return this._$$totalProgress;
    }

    @Override // com.bytedance.android.live.recharge.platform.model.RechargeBannerInfo
    public final long getValidEndTime() {
        return this._$$validEndTime;
    }

    public RechargeBannerInfoFlexImpl(am3.g r7) {
        super(RechargeBannerInfo.class);
        setThreadSafe(false);
        long r1 = r7.c();
        int r3 = 0;
    L3:
        int r4 = r7.f();
        if (r4 == (-1)) goto L24;
        am3.g.a r5 = decodeExtensionFields(r4, r7);
        switch(r4) {
            case 1: goto L23;
            case 2: goto L22;
            case 3: goto L21;
            case 4: goto L20;
            case 5: goto L19;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L16;
            case 9: goto L15;
            case 10: goto L14;
            case 11: goto L13;
            case 12: goto L12;
            case 13: goto L11;
            case 14: goto L10;
            case 15: goto L9;
            case 16: goto L8;
            default: goto L7;
        };
    L8:
        this._$$screenShield = am3.h.a(r7);
        r3 = r3 | 32;
        goto L3
    L9:
        this._$$bannerTopDescColor = am3.h.c(r7);
        goto L3
    L10:
        this._$$bannerId = r7.j();
        r3 = r3 | 2;
        goto L3
    L11:
        this._$$bannerGuideDescIcon = am3.h.c(r7);
        goto L3
    L12:
        this._$$validEndTime = r7.j();
        r3 = r3 | 16;
        goto L3
    L13:
        this._$$progressIndicatorColor = am3.h.c(r7);
        goto L3
    L14:
        this._$$progressBgColor = am3.h.c(r7);
        goto L3
    L15:
        this._$$totalProgress = r7.j();
        r3 = r3 | 8;
        goto L3
    L16:
        this._$$currentProgress = r7.j();
        r3 = r3 | 4;
        goto L3
    L17:
        this._$$schemeUrl = am3.h.c(r7);
        goto L3
    L18:
        this._$$bannerBgImage = am3.h.c(r7);
        goto L3
    L19:
        this._$$bannerIconImage = am3.h.c(r7);
        goto L3
    L20:
        this._$$bannerBottomDescColor = am3.h.c(r7);
        goto L3
    L21:
        this._$$bannerBottomDescText = am3.h.c(r7);
        goto L3
    L22:
        this._$$bannerTopDescText = am3.h.c(r7);
        goto L3
    L23:
        this._$$bannerType = r7.i();
        r3 = r3 | 1;
        goto L3
    L7:
        am3.h.d(r5, r7);
        goto L3
    L24:
        r7.d(r1);
        setThreadSafe(true);
        if ((r3 & 32) != 0) goto L64;
        this._$$screenShield = false;
        return;
    }
}
