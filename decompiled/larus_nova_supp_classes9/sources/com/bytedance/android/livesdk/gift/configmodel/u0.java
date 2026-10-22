package com.bytedance.android.livesdk.gift.configmodel;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b(\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b8\u00109R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0013\u001a\u00020\u00128\u0006X\u0087D¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u0004\u001a\u0004\b\u001c\u0010\u0006R\u001a\u0010\u001d\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001d\u0010\u0004\u001a\u0004\b\u001e\u0010\u0006R\u001a\u0010\u001f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010\u0004\u001a\u0004\b \u0010\u0006R\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\"\u0010'\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b'\u0010\u000b\u001a\u0004\b(\u0010\r\"\u0004\b)\u0010*R\"\u0010+\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010\u0004\u001a\u0004\b,\u0010\u0006\"\u0004\b-\u0010.R\"\u0010/\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b/\u0010\u0004\u001a\u0004\b0\u0010\u0006\"\u0004\b1\u0010.R\"\u00102\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b2\u0010\u000b\u001a\u0004\b3\u0010\r\"\u0004\b4\u0010*R\"\u00105\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b5\u0010\u000b\u001a\u0004\b6\u0010\r\"\u0004\b7\u0010*¨\u0006:"}, d2 = {"Lcom/bytedance/android/livesdk/gift/configmodel/u0;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableTouchListener", "Z", "f", "()Z", "touchDownGetGiftList", "p", BuildConfig.FLAVOR, "defaultSelectTime", "J", "getDefaultSelectTime", "()J", "giftIconDoubleClick", "h", "syncOpenPanel", "n", BuildConfig.FLAVOR, "defaultSelectPos", "I", "d", "()I", "cancelDefaultSelect", "a", "defaultSelectFixed", "getDefaultSelectFixed", "giftRuleFix", "i", "topDefaultEnable", "o", "enableRequestPayGrade", "e", "useNewMatchStrategy", "q", "giftSelectedPostOnThread", "j", "getEmptyDescOpt", "g", "syncGiftForSortValidMills", "m", "setSyncGiftForSortValidMills", "(J)V", "lazyViewPagerOpt", "l", "setLazyViewPagerOpt", "(Z)V", "checkUpdateCorrect", "b", "setCheckUpdateCorrect", "checkUpdateDelay", "c", "setCheckUpdateDelay", "lazyLoadLynxViewTime", "k", "setLazyLoadLynxViewTime", "<init>", "()V", "livegift-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class u0 {

    @SerializedName("cancel_default_select")
    private final boolean cancelDefaultSelect;

    @SerializedName("lazy_view_pager_check_update_correct")
    private boolean checkUpdateCorrect;

    @SerializedName("lazy_view_pager_check_update_delay")
    private long checkUpdateDelay;

    @SerializedName("default_select_fixed")
    private final boolean defaultSelectFixed;

    @SerializedName("default_pos")
    private final int defaultSelectPos;

    @SerializedName("default_select_time_opt")
    private final long defaultSelectTime;

    @SerializedName("enable_request_pay_garde")
    private final boolean enableRequestPayGrade;

    @SerializedName("enable_touch_listener")
    private final boolean enableTouchListener;

    @SerializedName("get_empty_desc_opt")
    private final boolean getEmptyDescOpt;

    @SerializedName("close_double_click")
    private final boolean giftIconDoubleClick;

    @SerializedName("gift_rule_fix")
    private final boolean giftRuleFix;

    @SerializedName("gift_selected_post_on_thread")
    private final boolean giftSelectedPostOnThread;

    @SerializedName("lazy_load_lynx_view_time")
    private long lazyLoadLynxViewTime;

    @SerializedName("lazy_view_pager")
    private boolean lazyViewPagerOpt;

    @SerializedName("sync_gift_for_sort_valid_mills")
    private long syncGiftForSortValidMills;

    @SerializedName("sync_open_panel")
    private final boolean syncOpenPanel;

    @SerializedName("top_default_enable")
    private final boolean topDefaultEnable;

    @SerializedName("touch_down_opt")
    private final boolean touchDownGetGiftList;

    @SerializedName("use_new_match_strategy")
    private final boolean useNewMatchStrategy;

    public u0() {
        this.enableTouchListener = true;
        this.defaultSelectTime = 350;
        this.checkUpdateDelay = 500;
        this.lazyLoadLynxViewTime = 1000;
    }

    public final boolean a() {
        return this.cancelDefaultSelect;
    }

    public final boolean b() {
        return this.checkUpdateCorrect;
    }

    public final long c() {
        return this.checkUpdateDelay;
    }

    public final int d() {
        return this.defaultSelectPos;
    }

    public final boolean e() {
        return this.enableRequestPayGrade;
    }

    public final boolean f() {
        return this.enableTouchListener;
    }

    public final boolean g() {
        return this.getEmptyDescOpt;
    }

    public final boolean h() {
        return this.giftIconDoubleClick;
    }

    public final boolean i() {
        return this.giftRuleFix;
    }

    public final boolean j() {
        return this.giftSelectedPostOnThread;
    }

    public final long k() {
        return this.lazyLoadLynxViewTime;
    }

    public final boolean l() {
        return this.lazyViewPagerOpt;
    }

    public final long m() {
        return this.syncGiftForSortValidMills;
    }

    public final boolean n() {
        return this.syncOpenPanel;
    }

    public final boolean o() {
        return this.topDefaultEnable;
    }

    public final boolean p() {
        return this.touchDownGetGiftList;
    }

    public final boolean q() {
        return this.useNewMatchStrategy;
    }
}
