package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.GiftMarketingInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b9\u0010:R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\n\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\r\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\r\u0010\u0005\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR#\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\u0013\u001a\u0004\b\u0019\u0010\u001aR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u0013\u001a\u0004\b\u001d\u0010\u001aR\u001d\u0010!\u001a\u0004\u0018\u00010\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b\u001f\u0010\u0013\u001a\u0004\b \u0010\u001aR\u001b\u0010&\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\u0013\u001a\u0004\b$\u0010%R\u001d\u0010+\u001a\u0004\u0018\u00010'8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b(\u0010\u0013\u001a\u0004\b)\u0010*R\u001b\u0010.\u001a\u00020\"8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b,\u0010\u0013\u001a\u0004\b-\u0010%R\u001b\u00101\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b/\u0010\u0013\u001a\u0004\b0\u0010\u001aR\u001b\u00104\u001a\u00020\u00178VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b2\u0010\u0013\u001a\u0004\b3\u0010\u001aR#\u00108\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010\u00108VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b6\u0010\u0013\u001a\u0004\b7\u0010\u0015¨\u0006;"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingInfo;", "Lpy/k;", "icon", "Lpy/k;", "getIcon", "()Lpy/k;", "setIcon", "(Lpy/k;)V", "mainTitleImg", "getMainTitleImg", "setMainTitleImg", "jumpIcon", "getJumpIcon", "setJumpIcon", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/IRichTextFlexImpl;", "mainTitle$delegate", "Ljava/lang/Object;", "getMainTitle", "()Ljava/util/List;", "mainTitle", BuildConfig.FLAVOR, "mainTitleAfterMission$delegate", "getMainTitleAfterMission", "()Ljava/lang/String;", "mainTitleAfterMission", "subTitle$delegate", "getSubTitle", "subTitle", "subTitleSchema$delegate", "getSubTitleSchema", "subTitleSchema", BuildConfig.FLAVOR, "leftCount$delegate", "getLeftCount", "()I", "leftCount", "Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingBtnFlexImpl;", "giftMarketingButton$delegate", "getGiftMarketingButton", "()Lcom/bytedance/android/livesdk/gift/model/IGiftMarketingBtnFlexImpl;", "giftMarketingButton", "buffMergeType$delegate", "getBuffMergeType", "buffMergeType", "marketingType$delegate", "getMarketingType", "marketingType", "subMarketingType$delegate", "getSubMarketingType", "subMarketingType", BuildConfig.FLAVOR, "relatedGiftIds$delegate", "getRelatedGiftIds", "relatedGiftIds", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class IGiftMarketingInfoFlexImpl extends FlexModelBase<IGiftMarketingInfo> implements IGiftMarketingInfo, vh7.h {

    @SerializedName("buff_merge_type")
    protected int _$$buffMergeType;

    @SerializedName("gift_marketing_button")
    protected IGiftMarketingBtnFlexImpl _$$giftMarketingButton;

    @SerializedName("left_count")
    protected int _$$leftCount;

    @SerializedName("main_title")
    protected List<IRichTextFlexImpl> _$$mainTitle;

    @SerializedName("main_title_after_mission")
    protected String _$$mainTitleAfterMission;

    @SerializedName("marketing_type")
    protected String _$$marketingType;

    @SerializedName("related_gift_ids")
    protected List<Long> _$$relatedGiftIds;

    @SerializedName("sub_marketing_type")
    protected String _$$subMarketingType;

    @SerializedName("sub_title")
    protected String _$$subTitle;

    @SerializedName("sub_title_schema")
    protected String _$$subTitleSchema;

    @SerializedName("icon")
    protected py.k icon;

    @SerializedName("jump_icon")
    protected py.k jumpIcon;

    @SerializedName("main_title_img")
    protected py.k mainTitleImg;

    public IGiftMarketingInfoFlexImpl() {
        super(IGiftMarketingInfo.class);
        this._$$marketingType = BuildConfig.FLAVOR;
        this._$$subMarketingType = BuildConfig.FLAVOR;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public /* bridge */ /* synthetic */ v1 getGiftMarketingButton() {
        return getGiftMarketingButton();
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final int getBuffMergeType() {
        return this._$$buffMergeType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public py.k getIcon() {
        return this.icon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public py.k getJumpIcon() {
        return this.jumpIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final int getLeftCount() {
        return this._$$leftCount;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final List<IRichTextFlexImpl> getMainTitle() {
        return this._$$mainTitle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final String getMainTitleAfterMission() {
        return this._$$mainTitleAfterMission;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public py.k getMainTitleImg() {
        return this.mainTitleImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final String getMarketingType() {
        return this._$$marketingType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final List<Long> getRelatedGiftIds() {
        return this._$$relatedGiftIds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final String getSubMarketingType() {
        return this._$$subMarketingType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final String getSubTitle() {
        return this._$$subTitle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final String getSubTitleSchema() {
        return this._$$subTitleSchema;
    }

    @Override // com.bytedance.android.livesdk.gift.model.IGiftMarketingInfo
    public final IGiftMarketingBtnFlexImpl getGiftMarketingButton() {
        return this._$$giftMarketingButton;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v13, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.lang.Object, py.k] */
    public IGiftMarketingInfoFlexImpl(am3.g r6) {
        super(IGiftMarketingInfo.class);
        this._$$mainTitle = new ArrayList();
        this._$$relatedGiftIds = new ArrayList();
        setThreadSafe(false);
        long r0 = r6.c();
    L3:
        int r2 = r6.f();
        if (r2 == (-1)) goto L22;
        am3.g.a r3 = decodeExtensionFields(r2, r6);
        switch(r2) {
            case 1: goto L21;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            case 13: goto L8;
            default: goto L7;
        };
    L8:
        List r4 = this._$$relatedGiftIds;
        vh7.h r5 = Long.valueOf(r6.j());
    L20:
        r4.add(r5);
        goto L3
    L9:
        this._$$subMarketingType = am3.h.c(r6);
        goto L3
    L10:
        this._$$mainTitleAfterMission = am3.h.c(r6);
        goto L3
    L11:
        this.jumpIcon = vh7.f.a(r6, py.k.class);
        goto L3
    L12:
        this.mainTitleImg = vh7.f.a(r6, py.k.class);
        goto L3
    L13:
        this._$$marketingType = am3.h.c(r6);
        goto L3
    L14:
        this._$$buffMergeType = r6.i();
        goto L3
    L15:
        this._$$giftMarketingButton = new IGiftMarketingBtnFlexImpl(r6);
        goto L3
    L16:
        this._$$leftCount = r6.i();
        goto L3
    L17:
        this._$$subTitleSchema = am3.h.c(r6);
        goto L3
    L18:
        this._$$subTitle = am3.h.c(r6);
        goto L3
    L19:
        r4 = this._$$mainTitle;
        r5 = new IRichTextFlexImpl(r6);
        goto L20
    L21:
        this.icon = vh7.f.a(r6, py.k.class);
        goto L3
    L7:
        am3.h.d(r3, r6);
        goto L3
    L22:
        r6.d(r0);
        setThreadSafe(true);
        if (this._$$marketingType != null) goto L26;
        this._$$marketingType = BuildConfig.FLAVOR;
    L26:
        if (this._$$subMarketingType != null) goto L58;
        this._$$subMarketingType = BuildConfig.FLAVOR;
        return;
    }

    public void setIcon(py.k r1) {
        this.icon = r1;
    }

    public void setJumpIcon(py.k r1) {
        this.jumpIcon = r1;
    }

    public void setMainTitleImg(py.k r1) {
        this.mainTitleImg = r1;
    }
}
