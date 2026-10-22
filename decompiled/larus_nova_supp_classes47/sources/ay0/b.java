package ay0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b'\u0010(R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u000f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000f\u0010\u0004\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\bR\"\u0010\u0012\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006\"\u0004\b\u0014\u0010\bR\"\u0010\u0015\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0004\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR\"\u0010\u0018\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0018\u0010\u0004\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006\"\u0004\b\u001d\u0010\bR\"\u0010\u001e\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001e\u0010\u0004\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR\"\u0010!\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR\"\u0010$\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006\"\u0004\b&\u0010\b¨\u0006)"}, d2 = {"Lay0/b;", "", "", "giftTopPanelEnable", "Z", "i", "()Z", "setGiftTopPanelEnable", "(Z)V", "giftExpansionEnable", "f", "setGiftExpansionEnable", "giftGroupEnable", "g", "setGiftGroupEnable", "giftCollectionEnable", "c", "setGiftCollectionEnable", "giftBannerEnable", "a", "setGiftBannerEnable", "giftBuffEnable", "b", "setGiftBuffEnable", "giftDiyEnable", "d", "setGiftDiyEnable", "giftMarketingEnable", "h", "setGiftMarketingEnable", "giftDynamicEnable", "e", "setGiftDynamicEnable", "taskTouchEnable", "j", "setTaskTouchEnable", "topicEnable", "k", "setTopicEnable", "<init>", "()V", "revenue-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class b {

    @SerializedName("gift_banner_enable")
    private boolean giftBannerEnable;

    @SerializedName("gift_buff_enable")
    private boolean giftBuffEnable;

    @SerializedName("gift_collection_enable")
    private boolean giftCollectionEnable;

    @SerializedName("gift_diy_enable")
    private boolean giftDiyEnable;

    @SerializedName("gift_dynamic_enable")
    private boolean giftDynamicEnable;

    @SerializedName("gift_expansion_enable")
    private boolean giftExpansionEnable;

    @SerializedName("gift_group_enable")
    private boolean giftGroupEnable;

    @SerializedName("gift_marketing_enable")
    private boolean giftMarketingEnable;

    @SerializedName("gift_top_panel_enable")
    private boolean giftTopPanelEnable;

    @SerializedName("task_touch_enable")
    private boolean taskTouchEnable;

    @SerializedName("gift_topic_enable")
    private boolean topicEnable;

    public b() {
    }

    public final boolean a() {
        return this.giftBannerEnable;
    }

    public final boolean b() {
        return this.giftBuffEnable;
    }

    public final boolean c() {
        return this.giftCollectionEnable;
    }

    public final boolean d() {
        return this.giftDiyEnable;
    }

    public final boolean e() {
        return this.giftDynamicEnable;
    }

    public final boolean f() {
        return this.giftExpansionEnable;
    }

    public final boolean g() {
        return this.giftGroupEnable;
    }

    public final boolean h() {
        return this.giftMarketingEnable;
    }

    public final boolean i() {
        return this.giftTopPanelEnable;
    }

    public final boolean j() {
        return this.taskTouchEnable;
    }

    public final boolean k() {
        return this.topicEnable;
    }
}
