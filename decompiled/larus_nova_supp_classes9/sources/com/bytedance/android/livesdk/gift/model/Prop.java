package com.bytedance.android.livesdk.gift.model;

import com.bytedance.android.live.base.model.ImageModel;
import com.bytedance.android.livesdkapi.depend.model.live.BannerInRoom;
import com.bytedance.android.livesdkapi.depend.model.live._BannerInRoom_ProtoDecoder;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.data.PropSummary")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b/\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0007\u0018\u0000 ¤\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002¥\u0001B\t¢\u0006\u0006\b¢\u0001\u0010£\u0001R\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR$\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0014\u0010\u0005\u001a\u0004\b\u0015\u0010\u0007\"\u0004\b\u0016\u0010\tR$\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R$\u0010\u001a\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u000f\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\"\u0010\u001d\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0005\u001a\u0004\b\u001e\u0010\u0007\"\u0004\b\u001f\u0010\tR\"\u0010!\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\"\u0010/\u001a\u00020.8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u00100\u001a\u0004\b1\u00102\"\u0004\b3\u00104R$\u00105\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000f\u001a\u0004\b6\u0010\u0011\"\u0004\b7\u0010\u0013R\"\u00109\u001a\u0002088\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R$\u0010?\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b?\u0010)\u001a\u0004\b@\u0010+\"\u0004\bA\u0010-R$\u0010B\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bB\u0010)\u001a\u0004\bC\u0010+\"\u0004\bD\u0010-R\"\u0010E\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bE\u0010\u0005\u001a\u0004\bF\u0010\u0007\"\u0004\bG\u0010\tR$\u0010I\u001a\u0004\u0018\u00010H8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010J\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\"\u0010O\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0005\u001a\u0004\bP\u0010\u0007\"\u0004\bQ\u0010\tR\"\u0010R\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0005\u001a\u0004\bS\u0010\u0007\"\u0004\bT\u0010\tR$\u0010U\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bU\u0010\u000f\u001a\u0004\bV\u0010\u0011\"\u0004\bW\u0010\u0013R\"\u0010X\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bX\u0010\"\u001a\u0004\bY\u0010$\"\u0004\bZ\u0010&R\"\u0010[\u001a\u00020 8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b[\u0010\"\u001a\u0004\b\\\u0010$\"\u0004\b]\u0010&R$\u0010^\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b^\u0010\u000f\u001a\u0004\b_\u0010\u0011\"\u0004\b`\u0010\u0013R$\u0010a\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\ba\u0010\u000f\u001a\u0004\bb\u0010\u0011\"\u0004\bc\u0010\u0013R$\u0010d\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bd\u0010\u000f\u001a\u0004\be\u0010\u0011\"\u0004\bf\u0010\u0013R\"\u0010g\u001a\u00020\u00038\u0016@\u0016X\u0096\u000e¢\u0006\u0012\n\u0004\bg\u0010\u0005\u001a\u0004\bh\u0010\u0007\"\u0004\bi\u0010\tR\u0014\u0010k\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0007R\u0014\u0010m\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bl\u0010\u0007R\u0014\u0010o\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bn\u0010\u0011R\u0014\u0010q\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bp\u0010\u0007R\u0014\u0010s\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\br\u0010\u0011R\u0014\u0010u\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bt\u0010\u0007R\u0014\u0010w\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bv\u0010$R\u0016\u0010{\u001a\u0004\u0018\u00010x8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\by\u0010zR$\u0010\u007f\u001a\u00020.2\u0006\u0010|\u001a\u00020.8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b}\u00102\"\u0004\b~\u00104R\u0016\u0010\u0081\u0001\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0080\u0001\u0010\u0011R\u0018\u0010\u0085\u0001\u001a\u00030\u0082\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u0083\u0001\u0010\u0084\u0001R\u0018\u0010\u0087\u0001\u001a\u0004\u0018\u00010x8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0086\u0001\u0010zR\u0018\u0010\u0089\u0001\u001a\u0004\u0018\u00010x8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0088\u0001\u0010zR\u0016\u0010\u008a\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008a\u0001\u0010\u0007R\u001a\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008b\u00018VX\u0096\u0004¢\u0006\b\u001a\u0006\b\u008c\u0001\u0010\u008d\u0001R\u0016\u0010\u0090\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u008f\u0001\u0010\u0007R\u0016\u0010\u0092\u0001\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0091\u0001\u0010\u0007R\u0016\u0010\u0094\u0001\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0093\u0001\u0010\u0011R\u0016\u0010\u0095\u0001\u001a\u00020 8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\b\u0095\u0001\u0010$R'\u0010\u0098\u0001\u001a\u00020 2\u0006\u0010|\u001a\u00020 8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0096\u0001\u0010$\"\u0005\b\u0097\u0001\u0010&R'\u0010\u009b\u0001\u001a\u00020\r2\u0006\u0010|\u001a\u00020\r8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0099\u0001\u0010\u0011\"\u0005\b\u009a\u0001\u0010\u0013R'\u0010\u009e\u0001\u001a\u00020\r2\u0006\u0010|\u001a\u00020\r8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009c\u0001\u0010\u0011\"\u0005\b\u009d\u0001\u0010\u0013R'\u0010¡\u0001\u001a\u00020\r2\u0006\u0010|\u001a\u00020\r8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009f\u0001\u0010\u0011\"\u0005\b \u0001\u0010\u0013¨\u0006¦\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/Prop;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/l2;", BuildConfig.FLAVOR, "_primaryEffectId", "J", "get_primaryEffectId", "()J", "set_primaryEffectId", "(J)V", "_nextExpire", "get_nextExpire", "set_nextExpire", BuildConfig.FLAVOR, "_description", "Ljava/lang/String;", "get_description", "()Ljava/lang/String;", "set_description", "(Ljava/lang/String;)V", "_id", "get_id", "set_id", "_manual", "get_manual", "set_manual", "guideUrl", "getGuideUrl", "setGuideUrl", "_diamond", "get_diamond", "set_diamond", BuildConfig.FLAVOR, "_reddotTip", "Z", "get_reddotTip", "()Z", "set_reddotTip", "(Z)V", "Lcom/bytedance/android/live/base/model/ImageModel;", "_icon", "Lcom/bytedance/android/live/base/model/ImageModel;", "get_icon", "()Lcom/bytedance/android/live/base/model/ImageModel;", "set_icon", "(Lcom/bytedance/android/live/base/model/ImageModel;)V", BuildConfig.FLAVOR, "_count", "I", "get_count", "()I", "set_count", "(I)V", "_name", "get_name", "set_name", "Lcom/bytedance/android/livesdk/gift/model/Gift;", "_gift", "Lcom/bytedance/android/livesdk/gift/model/Gift;", "get_gift", "()Lcom/bytedance/android/livesdk/gift/model/Gift;", "set_gift", "(Lcom/bytedance/android/livesdk/gift/model/Gift;)V", "_labelIcon", "get_labelIcon", "set_labelIcon", "_diamondLabel", "get_diamondLabel", "set_diamondLabel", "_isAwemeFreeGift", "get_isAwemeFreeGift", "set_isAwemeFreeGift", "Lcom/bytedance/android/livesdkapi/depend/model/live/BannerInRoom;", "_banner", "Lcom/bytedance/android/livesdkapi/depend/model/live/BannerInRoom;", "get_banner", "()Lcom/bytedance/android/livesdkapi/depend/model/live/BannerInRoom;", "set_banner", "(Lcom/bytedance/android/livesdkapi/depend/model/live/BannerInRoom;)V", "_propType", "get_propType", "set_propType", "_propDefSubType", "get_propDefSubType", "set_propDefSubType", "_schemeUrl", "get_schemeUrl", "set_schemeUrl", "_isDisplayedOnPanel", "get_isDisplayedOnPanel", "set_isDisplayedOnPanel", "_setGray", "get_setGray", "set_setGray", "_propDescription", "get_propDescription", "set_propDescription", "_expiredDescription", "get_expiredDescription", "set_expiredDescription", "_refId", "get_refId", "set_refId", "nowTimeDiff", "getNowTimeDiff", "setNowTimeDiff", "getPrimaryEffectId", "primaryEffectId", "getNextExpire", "nextExpire", "getDescription", "description", "getId", "id", "getManual", "manual", "getDiamond", "diamond", "getReddotTip", "reddotTip", "Lpy/k;", "getIcon", "()Lpy/k;", "icon", "value", "getCount", "setCount", "count", "getName", "name", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGift", "()Lcom/bytedance/android/livesdk/gift/model/h1;", "gift", "getLabelIcon", "labelIcon", "getDiamondLabel", "diamondLabel", "isAwemeFreeGift", "Lcom/bytedance/android/livesdk/gift/model/b1;", "getBanner", "()Lcom/bytedance/android/livesdk/gift/model/b1;", "banner", "getPropType", "propType", "getPropDefSubType", "propDefSubType", "getSchemeUrl", "schemeUrl", "isDisplayedOnPanel", "getSetGray", "setSetGray", "setGray", "getPropDescription", "setPropDescription", "propDescription", "getExpiredException", "setExpiredException", "expiredException", "getRefId", "setRefId", "refId", "<init>", "()V", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Prop extends FlexModelBase<l2> implements l2, vh7.h {
    public static final int CNY_PROP_SEND_COUNT = 10;
    public static final a Companion = null;
    public static final long PROP_TYPE_PERIOD_CARD = 9;
    public static final long PROP_TYPE_POPULAR_CARD = 4;

    @SerializedName("banner")
    protected BannerInRoom _banner;

    @SerializedName("count")
    protected int _count;

    @SerializedName("description")
    protected String _description;

    @SerializedName("diamond")
    protected long _diamond;

    @SerializedName("diamond_icon")
    protected ImageModel _diamondLabel;

    @SerializedName("expire_description")
    protected String _expiredDescription;

    @SerializedName("gift")
    protected Gift _gift;

    @SerializedName("icon")
    protected ImageModel _icon;

    @SerializedName("prop_def_id")
    protected long _id;

    @SerializedName("is_aweme_free_gift")
    protected long _isAwemeFreeGift;

    @SerializedName("is_displayed_on_panel")
    protected boolean _isDisplayedOnPanel;

    @SerializedName("label_icon")
    protected ImageModel _labelIcon;

    @SerializedName("manual")
    protected String _manual;

    @SerializedName("name")
    protected String _name;

    @SerializedName("next_expire")
    protected long _nextExpire;

    @SerializedName("primary_effect_id")
    protected long _primaryEffectId;

    @SerializedName("prop_def_sub_type")
    protected long _propDefSubType;

    @SerializedName("prop_description")
    protected String _propDescription;

    @SerializedName("prop_def_type")
    protected long _propType;

    @SerializedName("reddot_tip")
    protected boolean _reddotTip;

    @SerializedName("ref_id")
    protected String _refId;

    @SerializedName("scheme_url")
    protected String _schemeUrl;

    @SerializedName("set_gray")
    protected boolean _setGray;

    @IgnoreProtoFieldCheck
    @SerializedName("guide_url")
    private String guideUrl;
    private long nowTimeDiff;

    public static final class a {
        public a() {
        }
    }

    static {
        Companion = new a();
    }

    public Prop() {
        super(l2.class);
        this._gift = new Gift();
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public String getDescription() {
        String r0 = this._description;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public String getExpiredException() {
        String r0 = this._expiredDescription;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public String getPropDescription() {
        String r0 = this._propDescription;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public String getRefId() {
        String r0 = this._refId;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public String getSchemeUrl() {
        String r0 = this._schemeUrl;
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public b1 getBanner() {
        return this._banner;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public int getCount() {
        return this._count;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long getDiamond() {
        return this._diamond;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public py.k getDiamondLabel() {
        return this._diamondLabel;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public h1 getGift() {
        return this._gift;
    }

    public final String getGuideUrl() {
        return this.guideUrl;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public py.k getIcon() {
        return this._icon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long getId() {
        return this._id;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public py.k getLabelIcon() {
        return this._labelIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public String getManual() {
        return this._manual;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public String getName() {
        return this._name;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long getNextExpire() {
        return this._nextExpire;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long getNowTimeDiff() {
        return this.nowTimeDiff;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long getPrimaryEffectId() {
        return this._primaryEffectId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long getPropDefSubType() {
        return this._propDefSubType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long getPropType() {
        return this._propType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public boolean getReddotTip() {
        return this._reddotTip;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public boolean getSetGray() {
        return this._setGray;
    }

    public final BannerInRoom get_banner() {
        return this._banner;
    }

    public final int get_count() {
        return this._count;
    }

    public final String get_description() {
        return this._description;
    }

    public final long get_diamond() {
        return this._diamond;
    }

    public final ImageModel get_diamondLabel() {
        return this._diamondLabel;
    }

    public final String get_expiredDescription() {
        return this._expiredDescription;
    }

    public final Gift get_gift() {
        return this._gift;
    }

    public final ImageModel get_icon() {
        return this._icon;
    }

    public final long get_id() {
        return this._id;
    }

    public final long get_isAwemeFreeGift() {
        return this._isAwemeFreeGift;
    }

    public final boolean get_isDisplayedOnPanel() {
        return this._isDisplayedOnPanel;
    }

    public final ImageModel get_labelIcon() {
        return this._labelIcon;
    }

    public final String get_manual() {
        return this._manual;
    }

    public final String get_name() {
        return this._name;
    }

    public final long get_nextExpire() {
        return this._nextExpire;
    }

    public final long get_primaryEffectId() {
        return this._primaryEffectId;
    }

    public final long get_propDefSubType() {
        return this._propDefSubType;
    }

    public final String get_propDescription() {
        return this._propDescription;
    }

    public final long get_propType() {
        return this._propType;
    }

    public final boolean get_reddotTip() {
        return this._reddotTip;
    }

    public final String get_refId() {
        return this._refId;
    }

    public final String get_schemeUrl() {
        return this._schemeUrl;
    }

    public final boolean get_setGray() {
        return this._setGray;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public long isAwemeFreeGift() {
        return this._isAwemeFreeGift;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public boolean isDisplayedOnPanel() {
        return this._isDisplayedOnPanel;
    }

    public Prop(am3.g r5) {
        super(l2.class);
        setThreadSafe(false);
        long r0 = r5.c();
    L3:
        int r2 = r5.f();
        if (r2 == (-1)) goto L31;
        am3.g.a r3 = decodeExtensionFields(r2, r5);
        switch(r2) {
            case 1: goto L30;
            case 2: goto L29;
            case 3: goto L28;
            case 4: goto L27;
            case 5: goto L26;
            case 6: goto L25;
            case 7: goto L24;
            case 8: goto L23;
            case 9: goto L22;
            case 10: goto L21;
            case 11: goto L20;
            case 12: goto L19;
            case 13: goto L7;
            case 14: goto L7;
            case 15: goto L18;
            case 16: goto L17;
            case 17: goto L16;
            case 18: goto L15;
            case 19: goto L7;
            case 20: goto L14;
            case 21: goto L13;
            case 22: goto L12;
            case 23: goto L11;
            case 24: goto L10;
            case 25: goto L9;
            case 26: goto L8;
            default: goto L7;
        };
    L8:
        this._refId = am3.h.c(r5);
        goto L3
    L9:
        this._expiredDescription = am3.h.c(r5);
        goto L3
    L10:
        this._propDescription = am3.h.c(r5);
        goto L3
    L11:
        this._setGray = am3.h.a(r5);
        goto L3
    L12:
        this._propDefSubType = r5.j();
        goto L3
    L13:
        this._isDisplayedOnPanel = am3.h.a(r5);
        goto L3
    L14:
        this._schemeUrl = am3.h.c(r5);
        goto L3
    L15:
        this._propType = r5.j();
        goto L3
    L16:
        this._banner = _BannerInRoom_ProtoDecoder.decodeStatic(r5);
        goto L3
    L17:
        this._diamondLabel = com.bytedance.android.live.base.model.x.a(r5);
        goto L3
    L18:
        this._isAwemeFreeGift = r5.j();
        goto L3
    L19:
        this._labelIcon = com.bytedance.android.live.base.model.x.a(r5);
        goto L3
    L20:
        this._gift = new Gift(r5);
        goto L3
    L21:
        this._name = am3.h.c(r5);
        goto L3
    L22:
        this._count = r5.i();
        goto L3
    L23:
        this._icon = com.bytedance.android.live.base.model.x.a(r5);
        goto L3
    L24:
        this._reddotTip = am3.h.a(r5);
        goto L3
    L25:
        this._diamond = r5.j();
        goto L3
    L26:
        this._manual = am3.h.c(r5);
        goto L3
    L27:
        this._id = r5.j();
        goto L3
    L28:
        this._description = am3.h.c(r5);
        goto L3
    L29:
        this._nextExpire = r5.j();
        goto L3
    L30:
        this._primaryEffectId = r5.j();
        goto L3
    L7:
        am3.h.d(r3, r5);
        goto L3
    L31:
        r5.d(r0);
        setThreadSafe(true);
        if (this._gift != null) goto L85;
        this._gift = new Gift();
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public void setCount(int r1) {
        this._count = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public void setExpiredException(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._expiredDescription = r2;
    }

    public final void setGuideUrl(String r1) {
        this.guideUrl = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public void setNowTimeDiff(long r1) {
        this.nowTimeDiff = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public void setPropDescription(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._propDescription = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public void setRefId(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._refId = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.l2
    public void setSetGray(boolean r1) {
        this._setGray = r1;
    }

    public final void set_banner(BannerInRoom r1) {
        this._banner = r1;
    }

    public final void set_count(int r1) {
        this._count = r1;
    }

    public final void set_description(String r1) {
        this._description = r1;
    }

    public final void set_diamond(long r1) {
        this._diamond = r1;
    }

    public final void set_diamondLabel(ImageModel r1) {
        this._diamondLabel = r1;
    }

    public final void set_expiredDescription(String r1) {
        this._expiredDescription = r1;
    }

    public final void set_gift(Gift r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this._gift = r2;
    }

    public final void set_icon(ImageModel r1) {
        this._icon = r1;
    }

    public final void set_id(long r1) {
        this._id = r1;
    }

    public final void set_isAwemeFreeGift(long r1) {
        this._isAwemeFreeGift = r1;
    }

    public final void set_isDisplayedOnPanel(boolean r1) {
        this._isDisplayedOnPanel = r1;
    }

    public final void set_labelIcon(ImageModel r1) {
        this._labelIcon = r1;
    }

    public final void set_manual(String r1) {
        this._manual = r1;
    }

    public final void set_name(String r1) {
        this._name = r1;
    }

    public final void set_nextExpire(long r1) {
        this._nextExpire = r1;
    }

    public final void set_primaryEffectId(long r1) {
        this._primaryEffectId = r1;
    }

    public final void set_propDefSubType(long r1) {
        this._propDefSubType = r1;
    }

    public final void set_propDescription(String r1) {
        this._propDescription = r1;
    }

    public final void set_propType(long r1) {
        this._propType = r1;
    }

    public final void set_reddotTip(boolean r1) {
        this._reddotTip = r1;
    }

    public final void set_refId(String r1) {
        this._refId = r1;
    }

    public final void set_schemeUrl(String r1) {
        this._schemeUrl = r1;
    }

    public final void set_setGray(boolean r1) {
        this._setGray = r1;
    }
}
