package com.bytedance.android.livesdk.gift.model;

import com.bytedance.bdlocation.BuildConfig;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u0000 ]2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002:\u0001^R\u001c\u0010\b\u001a\u00020\u00038&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001c\u0010\u000e\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0014\u001a\u00020\u000f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0017\u001a\u00020\t8&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\"\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00190\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR*\u0010%\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8&@&X¦\u000e¢\u0006\f\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\"\u0010)\u001a\b\u0012\u0004\u0012\u00020&0\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b'\u0010\u001b\"\u0004\b(\u0010\u001dR\"\u0010-\u001a\b\u0012\u0004\u0012\u00020*0\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b+\u0010\u001b\"\u0004\b,\u0010\u001dR$\u00101\u001a\n\u0012\u0004\u0012\u00020.\u0018\u00010\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\b/\u0010\u001b\"\u0004\b0\u0010\u001dR\"\u00106\u001a\u00020\u00038&@&X¦\u000e¢\u0006\u0012\u0012\u0004\b4\u00105\u001a\u0004\b2\u0010\u0005\"\u0004\b3\u0010\u0007R\u001e\u0010<\u001a\u0004\u0018\u0001078&@&X¦\u000e¢\u0006\f\u001a\u0004\b8\u00109\"\u0004\b:\u0010;R\u001e\u0010?\u001a\u0004\u0018\u0001078&@&X¦\u000e¢\u0006\f\u001a\u0004\b=\u00109\"\u0004\b>\u0010;R\u001e\u0010B\u001a\u0004\u0018\u0001078&@&X¦\u000e¢\u0006\f\u001a\u0004\b@\u00109\"\u0004\bA\u0010;R\u001e\u0010H\u001a\u0004\u0018\u00010C8&@&X¦\u000e¢\u0006\f\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001e\u0010N\u001a\u0004\u0018\u00010I8&@&X¦\u000e¢\u0006\f\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010T\u001a\u0004\u0018\u00010O8&@&X¦\u000e¢\u0006\f\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR$\u0010X\u001a\n\u0012\u0004\u0012\u00020U\u0018\u00010\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\bV\u0010\u001b\"\u0004\bW\u0010\u001dR$\u0010\\\u001a\n\u0012\u0004\u0012\u00020Y\u0018\u00010\u00188&@&X¦\u000e¢\u0006\f\u001a\u0004\bZ\u0010\u001b\"\u0004\b[\u0010\u001d¨\u0006_"}, d2 = {"Lcom/bytedance/android/livesdk/gift/model/w1;", "Lvh7/c;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getPageType", "()I", "setPageType", "(I)V", "pageType", BuildConfig.FLAVOR, "getPageName", "()Ljava/lang/String;", "setPageName", "(Ljava/lang/String;)V", "pageName", BuildConfig.FLAVOR, "getDisplay", "()Z", "setDisplay", "(Z)V", "display", "getEventName", "setEventName", "eventName", BuildConfig.FLAVOR, "Lcom/bytedance/android/livesdk/gift/model/h1;", "getGifts", "()Ljava/util/List;", "setGifts", "(Ljava/util/List;)V", "gifts", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "getForceInsertMap", "()Ljava/util/Map;", "setForceInsertMap", "(Ljava/util/Map;)V", "forceInsertMap", "Lcom/bytedance/android/livesdk/gift/model/g2;", "getLiteGifts", "setLiteGifts", "liteGifts", "Lcom/bytedance/android/livesdk/gift/model/d2;", "getTopicList", "setTopicList", "topicList", "Lcom/bytedance/android/livesdk/gift/model/o2;", "getScrollPageNames", "setScrollPageNames", "scrollPageNames", "getPageSortStrategy", "setPageSortStrategy", "getPageSortStrategy$annotations", "()V", "pageSortStrategy", "Lpy/k;", "getBackgroundImage", "()Lpy/k;", "setBackgroundImage", "(Lpy/k;)V", "backgroundImage", "getReceiversModBg", "setReceiversModBg", "receiversModBg", "getReceiversLongModBg", "setReceiversLongModBg", "receiversLongModBg", "Lcom/bytedance/android/livesdk/gift/model/x2;", "getPageInfo", "()Lcom/bytedance/android/livesdk/gift/model/x2;", "setPageInfo", "(Lcom/bytedance/android/livesdk/gift/model/x2;)V", "pageInfo", "Lcom/bytedance/android/livesdk/gift/model/b3;", "getPageNameStyleInfo", "()Lcom/bytedance/android/livesdk/gift/model/b3;", "setPageNameStyleInfo", "(Lcom/bytedance/android/livesdk/gift/model/b3;)V", "pageNameStyleInfo", "Lcom/bytedance/android/livesdk/gift/model/z2;", "getLynxConfig", "()Lcom/bytedance/android/livesdk/gift/model/z2;", "setLynxConfig", "(Lcom/bytedance/android/livesdk/gift/model/z2;)V", "lynxConfig", "Lcom/bytedance/android/livesdk/gift/model/c3;", "getSectionList", "setSectionList", "sectionList", "Lcom/bytedance/android/livesdk/gift/model/c1;", "getBaseGifts", "setBaseGifts", "baseGifts", "Companion", "a", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w1 extends vh7.c<w1> {
    public static final a Companion = null;
    public static final int PAGE_GAME = 25;
    public static final int PAGE_TYPE_AIRDROP = 100;
    public static final int PAGE_TYPE_AI_AGENT = 26;
    public static final int PAGE_TYPE_CARNIVAL = 23;
    public static final int PAGE_TYPE_CURATED = 16;
    public static final int PAGE_TYPE_DEFAULT = 0;
    public static final int PAGE_TYPE_FANSCLUB = 2;
    public static final int PAGE_TYPE_GIFT = 1;
    public static final int PAGE_TYPE_HONOR_LEVEL = 3;
    public static final int PAGE_TYPE_INTERACT = 15;
    public static final int PAGE_TYPE_MOSTLY_USED = 17;
    public static final int PAGE_TYPE_PRIVILEGE = 13;
    public static final int PAGE_TYPE_PROPERTY = 5;
    public static final int PAGE_TYPE_VERTICAL = 27;

    public static final class a {
        public static final /* synthetic */ a a = null;

        public a() {
        }

        static {
            a = new a();
        }
    }

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class b {
    }

    static {
        Companion = a.a;
    }

    /* synthetic */ vh7.e castTo(Class r1);

    /* synthetic */ vh7.e castToOrNull(Class r1);

    py.k getBackgroundImage();

    List<c1> getBaseGifts();

    boolean getDisplay();

    String getEventName();

    Map<Integer, Long> getForceInsertMap();

    List<h1> getGifts();

    List<g2> getLiteGifts();

    z2 getLynxConfig();

    x2 getPageInfo();

    String getPageName();

    b3 getPageNameStyleInfo();

    int getPageSortStrategy();

    int getPageType();

    py.k getReceiversLongModBg();

    py.k getReceiversModBg();

    List<o2> getScrollPageNames();

    List<c3> getSectionList();

    List<d2> getTopicList();

    void setBackgroundImage(py.k r1);

    void setBaseGifts(List<? extends c1> r1);

    void setDisplay(boolean r1);

    void setEventName(String r1);

    void setForceInsertMap(Map<Integer, Long> r1);

    void setGifts(List<? extends h1> r1);

    void setLiteGifts(List<? extends g2> r1);

    void setLynxConfig(z2 r1);

    void setPageInfo(x2 r1);

    void setPageName(String r1);

    void setPageNameStyleInfo(b3 r1);

    void setPageSortStrategy(int r1);

    void setPageType(int r1);

    void setReceiversLongModBg(py.k r1);

    void setReceiversModBg(py.k r1);

    void setScrollPageNames(List<? extends o2> r1);

    void setSectionList(List<c3> r1);

    void setTopicList(List<? extends d2> r1);
}
