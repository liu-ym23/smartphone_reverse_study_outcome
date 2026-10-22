package com.bytedance.android.livesdk.gift.model;

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
@ProtoMessage("webcast.data.DIYGiftCardInfo")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\t¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001R$\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0016@\u0016X\u0097\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR+\u0010\u0012\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R+\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R/\u0010\u001a\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u0017\u0010\r\u001a\u0004\b\u0018\u0010\u0007\"\u0004\b\u0019\u0010\tR/\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b\u001b\u0010\r\u001a\u0004\b\u001c\u0010\u0007\"\u0004\b\u001d\u0010\tR7\u0010&\u001a\b\u0012\u0004\u0012\u00020 0\u001f2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020 0\u001f8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b!\u0010\r\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R+\u0010-\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020'8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b(\u0010\r\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R/\u00101\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b.\u0010\r\u001a\u0004\b/\u0010\u0007\"\u0004\b0\u0010\tR/\u00105\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b2\u0010\r\u001a\u0004\b3\u0010\u000f\"\u0004\b4\u0010\u0011R/\u00109\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b6\u0010\r\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R+\u0010=\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020'8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b:\u0010\r\u001a\u0004\b;\u0010*\"\u0004\b<\u0010,R+\u0010A\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020'8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b>\u0010\r\u001a\u0004\b?\u0010*\"\u0004\b@\u0010,R+\u0010E\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020'8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bB\u0010\r\u001a\u0004\bC\u0010*\"\u0004\bD\u0010,R/\u0010I\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bF\u0010\r\u001a\u0004\bG\u0010\u000f\"\u0004\bH\u0010\u0011R/\u0010P\u001a\u0004\u0018\u00010J2\b\u0010\u000b\u001a\u0004\u0018\u00010J8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bK\u0010\r\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR/\u0010T\u001a\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\u00038V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bQ\u0010\r\u001a\u0004\bR\u0010\u0007\"\u0004\bS\u0010\tR/\u0010X\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\n8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bU\u0010\r\u001a\u0004\bV\u0010\u000f\"\u0004\bW\u0010\u0011R+\u0010_\u001a\u00020Y2\u0006\u0010\u000b\u001a\u00020Y8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bZ\u0010\r\u001a\u0004\b[\u0010\\\"\u0004\b]\u0010^R+\u0010c\u001a\u00020'2\u0006\u0010\u000b\u001a\u00020'8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\b`\u0010\r\u001a\u0004\ba\u0010*\"\u0004\bb\u0010,RC\u0010k\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020'0d2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020'0d8V@VX\u0096\u008e\u0002¢\u0006\u0012\n\u0004\bf\u0010\r\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR\u001b\u0010o\u001a\u00020e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bl\u0010\r\u001a\u0004\bm\u0010nR\u001b\u0010r\u001a\u00020Y8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bp\u0010\r\u001a\u0004\bq\u0010\\R\u001d\u0010w\u001a\u0004\u0018\u00010s8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bt\u0010\r\u001a\u0004\bu\u0010vR\u001b\u0010z\u001a\u00020e8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\bx\u0010\r\u001a\u0004\by\u0010nR\u001b\u0010}\u001a\u00020\n8VX\u0096\u0084\u0002¢\u0006\f\n\u0004\b{\u0010\r\u001a\u0004\b|\u0010\u000fR+\u0010\u0081\u0001\u001a\u0010\u0012\u0004\u0012\u00020e\u0012\u0004\u0012\u00020~\u0018\u00010d8VX\u0096\u0084\u0002¢\u0006\r\n\u0004\b\u007f\u0010\r\u001a\u0005\b\u0080\u0001\u0010h¨\u0006\u0084\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/DIYGiftCardInfoFlexImpl;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/n;", "Lpy/k;", "dynamicGiftIcon", "Lpy/k;", "getDynamicGiftIcon", "()Lpy/k;", "setDynamicGiftIcon", "(Lpy/k;)V", BuildConfig.FLAVOR, "<set-?>", "mainText$delegate", "Ljava/lang/Object;", "getMainText", "()Ljava/lang/String;", "setMainText", "(Ljava/lang/String;)V", n.KEY_MAIN_TEXT, "subText$delegate", "getSubText", "setSubText", n.KEY_SUB_TEXT, "iconImg$delegate", "getIconImg", "setIconImg", n.KEY_ICON_IMG, "giftDescribeImg$delegate", "getGiftDescribeImg", "setGiftDescribeImg", n.KEY_GIFT_DESCRIBE_IMG, BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/e3;", "pluginsFlex$delegate", "getPluginsFlex", "()Ljava/util/List;", "setPluginsFlex", "(Ljava/util/List;)V", "pluginsFlex", BuildConfig.FLAVOR, "totalDiamonds$delegate", "getTotalDiamonds", "()J", "setTotalDiamonds", "(J)V", n.KEY_TOTAL_DIAMONDS, "giftCellIcon$delegate", "getGiftCellIcon", "setGiftCellIcon", "giftCellIcon", "mainTextAfterSend$delegate", "getMainTextAfterSend", "setMainTextAfterSend", n.KEY_MAIN_TEXT_AFTER_SEND, "cardName$delegate", "getCardName", "setCardName", "cardName", "startTime$delegate", "getStartTime", "setStartTime", "startTime", "endTime$delegate", "getEndTime", "setEndTime", "endTime", "configId$delegate", "getConfigId", "setConfigId", "configId", "configIdStr$delegate", "getConfigIdStr", "setConfigIdStr", "configIdStr", "Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "lockInfo$delegate", "getLockInfo", "()Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;", "setLockInfo", "(Lcom/bytedance/android/livesdk/gift/model/CardLockInfo;)V", "lockInfo", "statusIconImg$delegate", "getStatusIconImg", "setStatusIconImg", "statusIconImg", "labelText$delegate", "getLabelText", "setLabelText", "labelText", BuildConfig.FLAVOR, "showRemindDot$delegate", "getShowRemindDot", "()Z", "setShowRemindDot", "(Z)V", "showRemindDot", "updateTime$delegate", "getUpdateTime", "setUpdateTime", "updateTime", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "pageTypeToDefaultChoseActionMap$delegate", "getPageTypeToDefaultChoseActionMap", "()Ljava/util/Map;", "setPageTypeToDefaultChoseActionMap", "(Ljava/util/Map;)V", "pageTypeToDefaultChoseActionMap", "cardType$delegate", "getCardType", "()I", "cardType", "notCache$delegate", "getNotCache", "notCache", "Lcom/bytedance/android/livesdk/gift/model/ComboHintInfoFlexImpl;", "comboHintInfo$delegate", "getComboHintInfo", "()Lcom/bytedance/android/livesdk/gift/model/ComboHintInfoFlexImpl;", "comboHintInfo", "giftSelectedStyle$delegate", "getGiftSelectedStyle", "giftSelectedStyle", "sendButtonText$delegate", "getSendButtonText", "sendButtonText", "Lcom/bytedance/android/livesdk/gift/model/IGiftTextInfoFlexImpl;", "defaultGiftTextMap$delegate", "getDefaultGiftTextMap", "defaultGiftTextMap", "<init>", "()V", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class DIYGiftCardInfoFlexImpl extends FlexModelBase<n> implements n, vh7.h {

    @SerializedName("card_name")
    protected String _$$cardName;

    @SerializedName("card_type")
    protected int _$$cardType;

    @SerializedName("combo_hint_info")
    protected ComboHintInfoFlexImpl _$$comboHintInfo;

    @SerializedName("config_id")
    protected long _$$configId;

    @SerializedName("config_id_str")
    protected String _$$configIdStr;

    @SerializedName("default_gift_text")
    protected Map<Integer, IGiftTextInfoFlexImpl> _$$defaultGiftTextMap;

    @SerializedName("end_time")
    protected long _$$endTime;

    @SerializedName("gift_cell_icon")
    protected py.k _$$giftCellIcon;

    @SerializedName("gift_describe_img")
    protected py.k _$$giftDescribeImg;

    @SerializedName("gift_selected_style")
    protected int _$$giftSelectedStyle;

    @SerializedName("icon_img")
    protected py.k _$$iconImg;

    @SerializedName("label_text")
    protected String _$$labelText;

    @SerializedName("lock_info")
    protected CardLockInfo _$$lockInfo;

    @SerializedName("main_text")
    protected String _$$mainText;

    @SerializedName("main_text_after_send")
    protected String _$$mainTextAfterSend;

    @SerializedName("not_cache")
    protected boolean _$$notCache;

    @SerializedName("tab_chose_action")
    protected Map<Integer, Long> _$$pageTypeToDefaultChoseActionMap;

    @SerializedName(n.KEY_PLUGINS)
    protected List<? extends e3> _$$pluginsFlex;

    @SerializedName("send_button_text")
    protected String _$$sendButtonText;

    @SerializedName("show_remind_point")
    protected boolean _$$showRemindDot;

    @SerializedName("start_time")
    protected long _$$startTime;

    @SerializedName("status_icon_img")
    protected py.k _$$statusIconImg;

    @SerializedName("sub_text")
    protected String _$$subText;

    @SerializedName("total_diamonds")
    protected long _$$totalDiamonds;

    @SerializedName("update_time")
    protected long _$$updateTime;

    @SerializedName("gift_icon_asset_img")
    protected py.k dynamicGiftIcon;

    public DIYGiftCardInfoFlexImpl() {
        super(n.class);
        this._$$mainText = BuildConfig.FLAVOR;
        this._$$subText = BuildConfig.FLAVOR;
        this._$$pluginsFlex = $defaultValue_pluginsFlex$();
        this._$$showRemindDot = false;
        this._$$pageTypeToDefaultChoseActionMap = $defaultValue_pageTypeToDefaultChoseActionMap$();
        this._$$notCache = false;
        this._$$sendButtonText = BuildConfig.FLAVOR;
    }

    public final Map<Integer, Long> $defaultValue_pageTypeToDefaultChoseActionMap$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.b();
    }

    public final List<e3> $defaultValue_pluginsFlex$() {
        return com.bytedance.tools.kcp.modelx.runtime.internal.reflect.d.a();
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public /* bridge */ /* synthetic */ ComboHintInfo getComboHintInfo() {
        return getComboHintInfo();
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final String getCardName() {
        return this._$$cardName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final int getCardType() {
        return this._$$cardType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final long getConfigId() {
        return this._$$configId;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final String getConfigIdStr() {
        return this._$$configIdStr;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final Map<Integer, IGiftTextInfoFlexImpl> getDefaultGiftTextMap() {
        return this._$$defaultGiftTextMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public py.k getDynamicGiftIcon() {
        return this.dynamicGiftIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final long getEndTime() {
        return this._$$endTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final py.k getGiftCellIcon() {
        return this._$$giftCellIcon;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final py.k getGiftDescribeImg() {
        return this._$$giftDescribeImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final int getGiftSelectedStyle() {
        return this._$$giftSelectedStyle;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final py.k getIconImg() {
        return this._$$iconImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final String getLabelText() {
        return this._$$labelText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final CardLockInfo getLockInfo() {
        return this._$$lockInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final String getMainText() {
        return this._$$mainText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final String getMainTextAfterSend() {
        return this._$$mainTextAfterSend;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final boolean getNotCache() {
        return this._$$notCache;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final Map<Integer, Long> getPageTypeToDefaultChoseActionMap() {
        return this._$$pageTypeToDefaultChoseActionMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final List<e3> getPluginsFlex() {
        return this._$$pluginsFlex;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final String getSendButtonText() {
        return this._$$sendButtonText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final boolean getShowRemindDot() {
        return this._$$showRemindDot;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final long getStartTime() {
        return this._$$startTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final py.k getStatusIconImg() {
        return this._$$statusIconImg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final String getSubText() {
        return this._$$subText;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final long getTotalDiamonds() {
        return this._$$totalDiamonds;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final long getUpdateTime() {
        return this._$$updateTime;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final ComboHintInfoFlexImpl getComboHintInfo() {
        return this._$$comboHintInfo;
    }

    /* JADX WARN: Type inference failed for: r6v10, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r6v17, types: [com.bytedance.android.livesdk.gift.model.CardLockInfo, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v19, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r6v34, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r6v6, types: [java.lang.Object, py.k] */
    public DIYGiftCardInfoFlexImpl(am3.g r19) {
        super(n.class);
        this._$$pluginsFlex = new ArrayList();
        this._$$pageTypeToDefaultChoseActionMap = new HashMap();
        this._$$defaultGiftTextMap = new HashMap();
        setThreadSafe(false);
        long r3 = r19.c();
        int r5 = 0;
    L3:
        int r6 = r19.f();
        if (r6 == (-1)) goto L64;
        am3.g.a r9 = decodeExtensionFields(r6, r19);
        Integer r13 = null;
        switch(r6) {
            case 1: goto L63;
            case 2: goto L62;
            case 3: goto L61;
            case 4: goto L60;
            case 5: goto L59;
            case 6: goto L58;
            case 7: goto L57;
            case 8: goto L56;
            case 9: goto L55;
            case 10: goto L54;
            case 11: goto L53;
            case 12: goto L52;
            case 13: goto L51;
            case 14: goto L50;
            case 15: goto L49;
            case 16: goto L48;
            case 17: goto L47;
            case 18: goto L46;
            case 19: goto L45;
            case 20: goto L7;
            case 21: goto L44;
            case 22: goto L28;
            case 23: goto L27;
            case 24: goto L26;
            case 25: goto L7;
            case 26: goto L7;
            case 27: goto L7;
            case 28: goto L7;
            case 29: goto L7;
            case 30: goto L25;
            case 31: goto L24;
            case 32: goto L8;
            default: goto L7;
        };
    L8:
        long r14 = r19.c();
        Object r7 = null;
    L9:
        int r10 = r19.f();
        if (r10 == (-1)) goto L16;
        if (r10 != 1) goto L12;
        r13 = Integer.valueOf(r19.i());
        goto L9
    L12:
        if (r10 != 2) goto L13;
        r7 = new IGiftTextInfoFlexImpl(r19);
        goto L9
    L13:
        am3.h.e(r19);
        goto L9
    L16:
        r19.d(r14);
        Map r8 = this._$$defaultGiftTextMap;
        if (r13 == null) goto L23;
        if (r7 == null) goto L21;
    L39:
        r8.put(r13, r7);
        goto L3
    L21:
        throw new IllegalStateException("Value must not be null");
    L23:
        throw new IllegalStateException("Key must not be null");
    L24:
        this.dynamicGiftIcon = vh7.f.a(r19, py.k.class);
        goto L3
    L25:
        this._$$sendButtonText = am3.h.c(r19);
        goto L3
    L26:
        this._$$giftSelectedStyle = r19.i();
        r5 = r5 | 256;
        goto L3
    L27:
        this._$$comboHintInfo = new ComboHintInfoFlexImpl(r19);
        goto L3
    L28:
        long r15 = r19.c();
        r7 = null;
    L29:
        int r11 = r19.f();
        if (r11 == (-1)) goto L36;
        if (r11 != 1) goto L32;
        r13 = Integer.valueOf(r19.i());
        goto L29
    L32:
        if (r11 != 2) goto L33;
        r7 = Long.valueOf(r19.j());
        goto L29
    L33:
        am3.h.e(r19);
        goto L29
    L36:
        r19.d(r15);
        r8 = this._$$pageTypeToDefaultChoseActionMap;
        if (r13 == null) goto L43;
        if (r7 != null) goto L39;
        throw new IllegalStateException("Value must not be null");
    L43:
        throw new IllegalStateException("Key must not be null");
    L44:
        this._$$notCache = am3.h.a(r19);
        r5 = r5 | 128;
        goto L3
    L45:
        this._$$cardType = r19.i();
        r5 = r5 | 64;
        goto L3
    L46:
        this._$$updateTime = r19.j();
        r5 = r5 | 32;
        goto L3
    L47:
        this._$$showRemindDot = am3.h.a(r19);
        r5 = r5 | 16;
        goto L3
    L48:
        this._$$labelText = am3.h.c(r19);
        goto L3
    L49:
        this._$$configIdStr = am3.h.c(r19);
        goto L3
    L50:
        this._$$statusIconImg = vh7.f.a(r19, py.k.class);
        goto L3
    L51:
        this._$$lockInfo = vh7.f.a(r19, CardLockInfo.class);
        goto L3
    L52:
        this._$$configId = r19.j();
        r5 = r5 | 8;
        goto L3
    L53:
        this._$$endTime = r19.j();
        r5 = r5 | 4;
        goto L3
    L54:
        this._$$startTime = r19.j();
        r5 = r5 | 2;
        goto L3
    L55:
        this._$$cardName = am3.h.c(r19);
        goto L3
    L56:
        this._$$mainTextAfterSend = am3.h.c(r19);
        goto L3
    L57:
        this._$$giftCellIcon = vh7.f.a(r19, py.k.class);
        goto L3
    L58:
        this._$$totalDiamonds = r19.j();
        r5 = r5 | 1;
        goto L3
    L59:
        this._$$pluginsFlex.add(vh7.f.a(r19, e3.class));
        goto L3
    L60:
        this._$$giftDescribeImg = vh7.f.a(r19, py.k.class);
        goto L3
    L61:
        this._$$iconImg = vh7.f.a(r19, py.k.class);
        goto L3
    L62:
        this._$$subText = am3.h.c(r19);
        goto L3
    L63:
        this._$$mainText = am3.h.c(r19);
        goto L3
    L7:
        am3.h.d(r9, r19);
        goto L3
    L64:
        r19.d(r3);
        setThreadSafe(true);
        if (this._$$mainText != null) goto L68;
        this._$$mainText = BuildConfig.FLAVOR;
    L68:
        if (this._$$subText != null) goto L71;
        this._$$subText = BuildConfig.FLAVOR;
    L71:
        if (this._$$pluginsFlex.isEmpty() == false) goto L74;
        this._$$pluginsFlex = $defaultValue_pluginsFlex$();
    L74:
        if ((r5 & 16) != 0) goto L77;
        this._$$showRemindDot = false;
    L77:
        if (this._$$pageTypeToDefaultChoseActionMap != null) goto L80;
        this._$$pageTypeToDefaultChoseActionMap = $defaultValue_pageTypeToDefaultChoseActionMap$();
    L80:
        if ((r5 & 128) != 0) goto L83;
        this._$$notCache = false;
    L83:
        if (this._$$sendButtonText != null) goto L163;
        this._$$sendButtonText = BuildConfig.FLAVOR;
        return;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setCardName(String r1) {
        this._$$cardName = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setConfigId(long r1) {
        this._$$configId = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setConfigIdStr(String r1) {
        this._$$configIdStr = r1;
    }

    public void setDynamicGiftIcon(py.k r1) {
        this.dynamicGiftIcon = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setEndTime(long r1) {
        this._$$endTime = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setGiftCellIcon(py.k r1) {
        this._$$giftCellIcon = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setGiftDescribeImg(py.k r1) {
        this._$$giftDescribeImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setIconImg(py.k r1) {
        this._$$iconImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setLabelText(String r1) {
        this._$$labelText = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setLockInfo(CardLockInfo r1) {
        this._$$lockInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setMainText(String r1) {
        this._$$mainText = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setMainTextAfterSend(String r1) {
        this._$$mainTextAfterSend = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setPageTypeToDefaultChoseActionMap(Map<Integer, Long> r1) {
        this._$$pageTypeToDefaultChoseActionMap = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setPluginsFlex(List<? extends e3> r1) {
        this._$$pluginsFlex = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setShowRemindDot(boolean r1) {
        this._$$showRemindDot = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setStartTime(long r1) {
        this._$$startTime = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setStatusIconImg(py.k r1) {
        this._$$statusIconImg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setSubText(String r1) {
        this._$$subText = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setTotalDiamonds(long r1) {
        this._$$totalDiamonds = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.n
    public final void setUpdateTime(long r1) {
        this._$$updateTime = r1;
    }
}
