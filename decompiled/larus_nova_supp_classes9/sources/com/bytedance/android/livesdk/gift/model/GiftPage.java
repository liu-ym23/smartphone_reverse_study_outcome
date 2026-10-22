package com.bytedance.android.livesdk.gift.model;

import android.text.TextUtils;
import com.bytedance.android.livesdkapi.util.KotlinTypeUtilsKt;
import com.bytedance.android.tools.pbadapter.annotation.IgnoreProtoFieldCheck;
import com.bytedance.android.tools.pbadapter.annotation.ProtoMessage;
import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.FlexModelBase;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@ProtoMessage("webcast.api.gift.GiftPage")
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b4\b\u0007\u0018\u0000 \u009f\u00012\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002:\u0002 \u0001B\b¢\u0006\u0005\b\u009e\u0001\u0010aR\"\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR$\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R*\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001a\u0010\u0014\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\"\u0010\u001e\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R$\u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\f\u001a\u0004\b%\u0010\u000e\"\u0004\b&\u0010\u0010R$\u0010(\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R$\u0010.\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010)\u001a\u0004\b/\u0010+\"\u0004\b0\u0010-R$\u00101\u001a\u0004\u0018\u00010'8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b1\u0010)\u001a\u0004\b2\u0010+\"\u0004\b3\u0010-R$\u00105\u001a\u0004\u0018\u0001048\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u00106\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R$\u0010<\u001a\u0004\u0018\u00010;8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b<\u0010=\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR$\u0010C\u001a\u0004\u0018\u00010B8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010D\u001a\u0004\bE\u0010F\"\u0004\bG\u0010HR0\u0010K\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020J\u0018\u00010I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bM\u0010N\"\u0004\bO\u0010PR*\u0010R\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bR\u0010\u0014\u001a\u0004\bS\u0010\u0016\"\u0004\bT\u0010\u0018R,\u0010V\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010U\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bV\u0010\u0014\u001a\u0004\bW\u0010\u0016\"\u0004\bX\u0010\u0018R*\u0010Z\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bZ\u0010\u0014\u001a\u0004\b[\u0010\u0016\"\u0004\b\\\u0010\u0018R(\u0010]\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0018\n\u0004\b]\u0010\u0005\u0012\u0004\b`\u0010a\u001a\u0004\b^\u0010\u0007\"\u0004\b_\u0010\tR*\u0010c\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bc\u0010\u0014\u001a\u0004\bd\u0010\u0016\"\u0004\be\u0010\u0018R$\u0010i\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bg\u0010\u0007\"\u0004\bh\u0010\tR$\u0010l\u001a\u00020\n2\u0006\u0010f\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bj\u0010\u000e\"\u0004\bk\u0010\u0010R0\u0010p\u001a\b\u0012\u0004\u0012\u00020m0\u00112\f\u0010f\u001a\b\u0012\u0004\u0012\u00020m0\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bn\u0010\u0016\"\u0004\bo\u0010\u0018R4\u0010s\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00112\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bq\u0010\u0016\"\u0004\br\u0010\u0018R$\u0010v\u001a\u00020\u001d2\u0006\u0010f\u001a\u00020\u001d8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bt\u0010!\"\u0004\bu\u0010#R$\u0010y\u001a\u00020\n2\u0006\u0010f\u001a\u00020\n8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bw\u0010\u000e\"\u0004\bx\u0010\u0010R(\u0010|\u001a\u0004\u0018\u00010'2\b\u0010f\u001a\u0004\u0018\u00010'8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\bz\u0010+\"\u0004\b{\u0010-R(\u0010\u007f\u001a\u0004\u0018\u00010'2\b\u0010f\u001a\u0004\u0018\u00010'8V@VX\u0096\u000e¢\u0006\f\u001a\u0004\b}\u0010+\"\u0004\b~\u0010-R+\u0010\u0082\u0001\u001a\u0004\u0018\u00010'2\b\u0010f\u001a\u0004\u0018\u00010'8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0080\u0001\u0010+\"\u0005\b\u0081\u0001\u0010-R+\u0010\u0085\u0001\u001a\u0004\u0018\u0001042\b\u0010f\u001a\u0004\u0018\u0001048V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0083\u0001\u00108\"\u0005\b\u0084\u0001\u0010:R+\u0010\u0088\u0001\u001a\u0004\u0018\u00010;2\b\u0010f\u001a\u0004\u0018\u00010;8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0086\u0001\u0010?\"\u0005\b\u0087\u0001\u0010AR+\u0010\u008b\u0001\u001a\u0004\u0018\u00010B2\b\u0010f\u001a\u0004\u0018\u00010B8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0089\u0001\u0010F\"\u0005\b\u008a\u0001\u0010HRC\u0010\u008e\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020J\u0018\u00010I2\u0014\u0010f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020J\u0018\u00010I8V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008c\u0001\u0010N\"\u0005\b\u008d\u0001\u0010PR3\u0010\u0091\u0001\u001a\b\u0012\u0004\u0012\u00020Q0\u00112\f\u0010f\u001a\b\u0012\u0004\u0012\u00020Q0\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u008f\u0001\u0010\u0016\"\u0005\b\u0090\u0001\u0010\u0018R3\u0010\u0094\u0001\u001a\b\u0012\u0004\u0012\u00020U0\u00112\f\u0010f\u001a\b\u0012\u0004\u0012\u00020U0\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0092\u0001\u0010\u0016\"\u0005\b\u0093\u0001\u0010\u0018R7\u0010\u0097\u0001\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u00112\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0095\u0001\u0010\u0016\"\u0005\b\u0096\u0001\u0010\u0018R'\u0010\u009a\u0001\u001a\u00020\u00032\u0006\u0010f\u001a\u00020\u00038V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u0098\u0001\u0010\u0007\"\u0005\b\u0099\u0001\u0010\tR7\u0010\u009d\u0001\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010\u00112\u000e\u0010f\u001a\n\u0012\u0004\u0012\u00020b\u0018\u00010\u00118V@VX\u0096\u000e¢\u0006\u000e\u001a\u0005\b\u009b\u0001\u0010\u0016\"\u0005\b\u009c\u0001\u0010\u0018¨\u0006¡\u0001"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/GiftPage;", "Lcom/bytedance/tools/kcp/modelx/runtime/FlexModelBase;", "Lcom/bytedance/android/livesdk/gift/model/w1;", BuildConfig.FLAVOR, "_pageType", "I", "get_pageType", "()I", "set_pageType", "(I)V", BuildConfig.FLAVOR, "_pageName", "Ljava/lang/String;", "get_pageName", "()Ljava/lang/String;", "set_pageName", "(Ljava/lang/String;)V", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/Gift;", "_gifts", "Ljava/util/List;", "get_gifts", "()Ljava/util/List;", "set_gifts", "(Ljava/util/List;)V", "Lcom/bytedance/android/livesdk/gift/model/c1;", "_baseGifts", "get_baseGifts", "set_baseGifts", BuildConfig.FLAVOR, "_display", "Z", "get_display", "()Z", "set_display", "(Z)V", "_eventName", "get_eventName", "set_eventName", "Lpy/k;", "_backgroundImage", "Lpy/k;", "get_backgroundImage", "()Lpy/k;", "set_backgroundImage", "(Lpy/k;)V", "_receiversModBg", "get_receiversModBg", "set_receiversModBg", "_receiversLongModBg", "get_receiversLongModBg", "set_receiversLongModBg", "Lcom/bytedance/android/livesdk/gift/model/x2;", "_pageInfo", "Lcom/bytedance/android/livesdk/gift/model/x2;", "get_pageInfo", "()Lcom/bytedance/android/livesdk/gift/model/x2;", "set_pageInfo", "(Lcom/bytedance/android/livesdk/gift/model/x2;)V", "Lcom/bytedance/android/livesdk/gift/model/b3;", "_pageNameStyleInfo", "Lcom/bytedance/android/livesdk/gift/model/b3;", "get_pageNameStyleInfo", "()Lcom/bytedance/android/livesdk/gift/model/b3;", "set_pageNameStyleInfo", "(Lcom/bytedance/android/livesdk/gift/model/b3;)V", "Lcom/bytedance/android/livesdk/gift/model/z2;", "_lynxConfig", "Lcom/bytedance/android/livesdk/gift/model/z2;", "get_lynxConfig", "()Lcom/bytedance/android/livesdk/gift/model/z2;", "set_lynxConfig", "(Lcom/bytedance/android/livesdk/gift/model/z2;)V", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "_forceInsertMap", "Ljava/util/Map;", "get_forceInsertMap", "()Ljava/util/Map;", "set_forceInsertMap", "(Ljava/util/Map;)V", "Lcom/bytedance/android/livesdk/gift/model/g2;", "_liteGifts", "get_liteGifts", "set_liteGifts", "Lcom/bytedance/android/livesdk/gift/model/d2;", "_topicList", "get_topicList", "set_topicList", "Lcom/bytedance/android/livesdk/gift/model/o2;", "_scrollPageNames", "get_scrollPageNames", "set_scrollPageNames", "_pageSortStrategy", "get_pageSortStrategy", "set_pageSortStrategy", "get_pageSortStrategy$annotations", "()V", "Lcom/bytedance/android/livesdk/gift/model/c3;", "_sectionList", "get_sectionList", "set_sectionList", "value", "getPageType", "setPageType", "pageType", "getPageName", "setPageName", "pageName", "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGifts", "setGifts", "gifts", "getBaseGifts", "setBaseGifts", "baseGifts", "getDisplay", "setDisplay", "display", "getEventName", "setEventName", "eventName", "getBackgroundImage", "setBackgroundImage", "backgroundImage", "getReceiversModBg", "setReceiversModBg", "receiversModBg", "getReceiversLongModBg", "setReceiversLongModBg", "receiversLongModBg", "getPageInfo", "setPageInfo", "pageInfo", "getPageNameStyleInfo", "setPageNameStyleInfo", "pageNameStyleInfo", "getLynxConfig", "setLynxConfig", "lynxConfig", "getForceInsertMap", "setForceInsertMap", "forceInsertMap", "getLiteGifts", "setLiteGifts", "liteGifts", "getTopicList", "setTopicList", "topicList", "getScrollPageNames", "setScrollPageNames", "scrollPageNames", "getPageSortStrategy", "setPageSortStrategy", "pageSortStrategy", "getSectionList", "setSectionList", "sectionList", "<init>", "Companion", "a", "livebase_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class GiftPage extends FlexModelBase<w1> implements w1, vh7.h {
    public static final a Companion = null;
    public static final int PAGE_TYPE_AIRDROP = 100;
    public static final int PAGE_TYPE_DEFAULT = 0;
    public static final int PAGE_TYPE_FANSCLUB = 2;
    public static final int PAGE_TYPE_GIFT = 1;
    public static final int PAGE_TYPE_HONOR_LEVEL = 3;
    private static final int PAGE_TYPE_NOBLE = 0;
    public static final int PAGE_TYPE_PRIVILEGE = 13;
    public static final int PAGE_TYPE_PROPERTY = 5;
    private static final int PAGE_TYPE_VIP = 0;
    private static final Map<Integer, String> pageNameMap = null;

    @SerializedName("background_image")
    protected py.k _backgroundImage;

    @SerializedName("remaining_gifts")
    protected List<? extends c1> _baseGifts;

    @SerializedName("display")
    protected boolean _display;

    @SerializedName("event_name")
    protected String _eventName;

    @IgnoreProtoFieldCheck
    @SerializedName("force_insert_index")
    protected Map<Integer, Long> _forceInsertMap;

    @SerializedName("gifts")
    protected List<Gift> _gifts;

    @SerializedName("lite_gifts")
    protected List<? extends g2> _liteGifts;

    @SerializedName("lynx_config")
    protected z2 _lynxConfig;

    @SerializedName("page_info")
    protected x2 _pageInfo;

    @SerializedName("page_name")
    protected String _pageName;

    @SerializedName("page_name_style_info")
    protected b3 _pageNameStyleInfo;

    @SerializedName("sort_strategy")
    protected int _pageSortStrategy;

    @SerializedName("page_type")
    protected int _pageType;

    @SerializedName("multiple_selected_receiver_long_image")
    protected py.k _receiversLongModBg;

    @SerializedName("multiple_selected_receiver_image")
    protected py.k _receiversModBg;

    @SerializedName("scroll_page_names")
    protected List<? extends o2> _scrollPageNames;

    @SerializedName("section_info")
    protected List<c3> _sectionList;

    @SerializedName("topics")
    protected List<? extends d2> _topicList;

    public static final class a {
        public a() {
        }
    }

    public GiftPage() {
        super(w1.class);
    }

    public static /* synthetic */ void get_pageSortStrategy$annotations() {
    }

    static {
        Companion = new a();
        PAGE_TYPE_NOBLE = 4;
        PAGE_TYPE_VIP = 6;
        pageNameMap = new HashMap();
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public List<c1> getBaseGifts() {
        ArrayList r0 = new ArrayList();
        List<? extends c1> r1 = this._baseGifts;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.addAll(r1);
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public List<h1> getGifts() {
        ArrayList r0 = new ArrayList();
        List<Gift> r1 = this._gifts;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.addAll(r1);
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public List<g2> getLiteGifts() {
        ArrayList r0 = new ArrayList();
        List<? extends g2> r1 = this._liteGifts;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.addAll(r1);
    L5:
        return r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public List<d2> getTopicList() {
        ArrayList r0 = new ArrayList();
        List<? extends d2> r1 = this._topicList;
        if (r1 == null) goto L5;
        Intrinsics.checkNotNull(r1);
        r0.addAll(r1);
    L5:
        return r0;
    }

    public static final /* synthetic */ int access$getPAGE_TYPE_NOBLE$cp() {
        return PAGE_TYPE_NOBLE;
    }

    public static final /* synthetic */ int access$getPAGE_TYPE_VIP$cp() {
        return PAGE_TYPE_VIP;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public py.k getBackgroundImage() {
        return this._backgroundImage;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public boolean getDisplay() {
        return this._display;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public String getEventName() {
        return this._eventName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public Map<Integer, Long> getForceInsertMap() {
        return this._forceInsertMap;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public z2 getLynxConfig() {
        return this._lynxConfig;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public x2 getPageInfo() {
        return this._pageInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public String getPageName() {
        return this._pageName;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public b3 getPageNameStyleInfo() {
        return this._pageNameStyleInfo;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public int getPageSortStrategy() {
        return this._pageSortStrategy;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public int getPageType() {
        return this._pageType;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public py.k getReceiversLongModBg() {
        return this._receiversLongModBg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public py.k getReceiversModBg() {
        return this._receiversModBg;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public List<o2> getScrollPageNames() {
        return this._scrollPageNames;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public List<c3> getSectionList() {
        return this._sectionList;
    }

    public final py.k get_backgroundImage() {
        return this._backgroundImage;
    }

    public final List<c1> get_baseGifts() {
        return this._baseGifts;
    }

    public final boolean get_display() {
        return this._display;
    }

    public final String get_eventName() {
        return this._eventName;
    }

    public final Map<Integer, Long> get_forceInsertMap() {
        return this._forceInsertMap;
    }

    public final List<Gift> get_gifts() {
        return this._gifts;
    }

    public final List<g2> get_liteGifts() {
        return this._liteGifts;
    }

    public final z2 get_lynxConfig() {
        return this._lynxConfig;
    }

    public final x2 get_pageInfo() {
        return this._pageInfo;
    }

    public final String get_pageName() {
        return this._pageName;
    }

    public final b3 get_pageNameStyleInfo() {
        return this._pageNameStyleInfo;
    }

    public final int get_pageSortStrategy() {
        return this._pageSortStrategy;
    }

    public final int get_pageType() {
        return this._pageType;
    }

    public final py.k get_receiversLongModBg() {
        return this._receiversLongModBg;
    }

    public final py.k get_receiversModBg() {
        return this._receiversModBg;
    }

    public final List<o2> get_scrollPageNames() {
        return this._scrollPageNames;
    }

    public final List<c3> get_sectionList() {
        return this._sectionList;
    }

    public final List<d2> get_topicList() {
        return this._topicList;
    }

    /* JADX WARN: Type inference failed for: r2v11, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v14, types: [com.bytedance.android.livesdk.gift.model.b3, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v28, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v30, types: [com.bytedance.android.livesdk.gift.model.z2, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v7, types: [java.lang.Object, py.k] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.bytedance.android.livesdk.gift.model.x2, java.lang.Object] */
    public GiftPage(am3.g r11) {
        super(w1.class);
        this._gifts = new ArrayList();
        this._baseGifts = new ArrayList();
        this._forceInsertMap = new HashMap();
        this._liteGifts = new ArrayList();
        this._topicList = new ArrayList();
        this._scrollPageNames = new ArrayList();
        this._sectionList = new ArrayList();
        setThreadSafe(false);
        long r0 = r11.c();
    L3:
        int r2 = r11.f();
        if (r2 == (-1)) goto L44;
        am3.g.a r5 = decodeExtensionFields(r2, r11);
        switch(r2) {
            case 1: goto L43;
            case 2: goto L42;
            case 3: goto L40;
            case 4: goto L39;
            case 5: goto L7;
            case 6: goto L38;
            case 7: goto L37;
            case 8: goto L36;
            case 9: goto L35;
            case 10: goto L34;
            case 11: goto L33;
            case 12: goto L31;
            case 13: goto L14;
            case 14: goto L13;
            case 15: goto L12;
            case 16: goto L11;
            case 17: goto L10;
            case 18: goto L9;
            case 19: goto L8;
            default: goto L7;
        };
    L8:
        this._lynxConfig = vh7.f.a(r11, z2.class);
        goto L3
    L9:
        this._receiversLongModBg = vh7.f.a(r11, py.k.class);
        goto L3
    L10:
        this._pageSortStrategy = (int) r11.j();
        goto L3
    L11:
        List r3 = this._scrollPageNames;
        Class r4 = o2.class;
    L32:
        Object r6 = vh7.f.a(r11, r4);
    L41:
        r3.add(r6);
        goto L3
    L12:
        r3 = this._topicList;
        r4 = d2.class;
        goto L32
    L13:
        r3 = this._liteGifts;
        r4 = g2.class;
        goto L32
    L14:
        long r7 = r11.c();
        Integer r8 = null;
        Long r9 = null;
    L15:
        int r10 = r11.f();
        if (r10 == (-1)) goto L23;
        if (r10 != 1) goto L19;
        r8 = Integer.valueOf(r11.i());
        goto L15
    L19:
        if (r10 != 2) goto L20;
        r9 = Long.valueOf(r11.j());
        goto L15
    L20:
        am3.h.e(r11);
        goto L15
    L23:
        r11.d(r7);
        Map<Integer, Long> r13 = this._forceInsertMap;
        if (r8 == null) goto L30;
        if (r9 == null) goto L28;
        r13.put(r8, r9);
        goto L3
    L28:
        throw new IllegalStateException("Value must not be null");
    L30:
        throw new IllegalStateException("Key must not be null");
    L31:
        r3 = this._baseGifts;
        r4 = c1.class;
        goto L32
    L33:
        this._pageNameStyleInfo = vh7.f.a(r11, b3.class);
        goto L3
    L34:
        r3 = this._sectionList;
        r6 = new c3(r11);
        goto L41
    L35:
        this._receiversModBg = vh7.f.a(r11, py.k.class);
        goto L3
    L36:
        this._pageInfo = vh7.f.a(r11, x2.class);
        goto L3
    L37:
        this._backgroundImage = vh7.f.a(r11, py.k.class);
        goto L3
    L38:
        this._eventName = am3.h.c(r11);
        goto L3
    L39:
        this._display = am3.h.a(r11);
        goto L3
    L40:
        r3 = this._gifts;
        r6 = new Gift(r11);
        goto L41
    L42:
        this._pageName = am3.h.c(r11);
        goto L3
    L43:
        this._pageType = r11.i();
        goto L3
    L7:
        am3.h.d(r5, r11);
        goto L3
    L44:
        r11.d(r0);
        setThreadSafe(true);
    }

    @JvmStatic
    public static final int convertPageTypeFromString(String r1) {
        Companion.getClass();
        if (TextUtils.equals(r1, "prop") == false) goto L5;
        return 5;
    L5:
        return 0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setBackgroundImage(py.k r1) {
        this._backgroundImage = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setBaseGifts(List<? extends c1> r1) {
        this._baseGifts = KotlinTypeUtilsKt.castElementType(r1);
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setDisplay(boolean r1) {
        this._display = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setEventName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._eventName = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setForceInsertMap(Map<Integer, Long> r1) {
        this._forceInsertMap = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setGifts(List<? extends h1> r3) {
        Intrinsics.checkNotNullParameter(r3, "value");
        ArrayList r0 = new ArrayList();
        Iterator<? extends h1> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L10;
        h1 r1 = r4.next();
        if (r1 == null) goto L9;
        r0.add((Gift) r1);
        goto L4
    L9:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.livesdk.gift.model.Gift");
    L10:
        this._gifts = r0;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setLiteGifts(List<? extends g2> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._liteGifts = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setLynxConfig(z2 r1) {
        this._lynxConfig = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setPageInfo(x2 r1) {
        this._pageInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setPageName(String r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._pageName = r2;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setPageNameStyleInfo(b3 r1) {
        this._pageNameStyleInfo = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setPageSortStrategy(int r1) {
        this._pageSortStrategy = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setPageType(int r1) {
        this._pageType = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setReceiversLongModBg(py.k r1) {
        this._receiversLongModBg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setReceiversModBg(py.k r1) {
        this._receiversModBg = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setScrollPageNames(List<? extends o2> r1) {
        this._scrollPageNames = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setSectionList(List<c3> r1) {
        this._sectionList = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.model.w1
    public void setTopicList(List<? extends d2> r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        this._topicList = r2;
    }

    public final void set_backgroundImage(py.k r1) {
        this._backgroundImage = r1;
    }

    public final void set_baseGifts(List<? extends c1> r1) {
        this._baseGifts = r1;
    }

    public final void set_display(boolean r1) {
        this._display = r1;
    }

    public final void set_eventName(String r1) {
        this._eventName = r1;
    }

    public final void set_forceInsertMap(Map<Integer, Long> r1) {
        this._forceInsertMap = r1;
    }

    public final void set_gifts(List<Gift> r1) {
        this._gifts = r1;
    }

    public final void set_liteGifts(List<? extends g2> r1) {
        this._liteGifts = r1;
    }

    public final void set_lynxConfig(z2 r1) {
        this._lynxConfig = r1;
    }

    public final void set_pageInfo(x2 r1) {
        this._pageInfo = r1;
    }

    public final void set_pageName(String r1) {
        this._pageName = r1;
    }

    public final void set_pageNameStyleInfo(b3 r1) {
        this._pageNameStyleInfo = r1;
    }

    public final void set_pageSortStrategy(int r1) {
        this._pageSortStrategy = r1;
    }

    public final void set_pageType(int r1) {
        this._pageType = r1;
    }

    public final void set_receiversLongModBg(py.k r1) {
        this._receiversLongModBg = r1;
    }

    public final void set_receiversModBg(py.k r1) {
        this._receiversModBg = r1;
    }

    public final void set_scrollPageNames(List<? extends o2> r1) {
        this._scrollPageNames = r1;
    }

    public final void set_sectionList(List<c3> r1) {
        this._sectionList = r1;
    }

    public final void set_topicList(List<? extends d2> r1) {
        this._topicList = r1;
    }
}
