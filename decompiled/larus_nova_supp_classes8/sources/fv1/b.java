package fv1;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b*\n\u0002\u0010 \n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bS\u0010TR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\"\u0010\u0010\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0004\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\bR\"\u0010\u0019\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR.\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e0\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R.\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b%\u0010 \u001a\u0004\b&\u0010\"\"\u0004\b'\u0010$R0\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001e\u0018\u00010\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b(\u0010 \u001a\u0004\b)\u0010\"\"\u0004\b*\u0010$R.\u0010+\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u001d0\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b+\u0010 \u001a\u0004\b,\u0010\"\"\u0004\b-\u0010$R$\u0010.\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b.\u0010/\u001a\u0004\b0\u00101\"\u0004\b2\u00103R$\u00104\u001a\u0004\u0018\u00010\u001d8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b4\u0010/\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\"\u00107\u001a\u00020\u001e8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u00108\u001a\u0004\b9\u0010:\"\u0004\b;\u0010<R\"\u0010=\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b=\u0010\u0011\u001a\u0004\b>\u0010\u0013\"\u0004\b?\u0010\u0015R\"\u0010@\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b@\u0010\u0011\u001a\u0004\bA\u0010\u0013\"\u0004\bB\u0010\u0015R\"\u0010C\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bC\u0010\u0011\u001a\u0004\bD\u0010\u0013\"\u0004\bE\u0010\u0015R\"\u0010F\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bF\u0010\u0011\u001a\u0004\bG\u0010\u0013\"\u0004\bH\u0010\u0015R(\u0010J\u001a\b\u0012\u0004\u0012\u00020\u001e0I8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bJ\u0010K\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\"\u0010P\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bP\u0010\u0004\u001a\u0004\bQ\u0010\u0006\"\u0004\bR\u0010\b¨\u0006U"}, d2 = {"Lfv1/b;", "", "", "isOptEnable", "Z", "l", "()Z", "setOptEnable", "(Z)V", "isFluencyEnable", "k", "setFluencyEnable", "radicalDegrade", "i", "setRadicalDegrade", "", "stableDays", "J", "j", "()J", "setStableDays", "(J)V", "localPerfTestEnable", "e", "setLocalPerfTestEnable", "pushIntervalDebug", "getPushIntervalDebug", "setPushIntervalDebug", "", "", "", "degradeScene", "Ljava/util/Map;", "b", "()Ljava/util/Map;", "setDegradeScene", "(Ljava/util/Map;)V", "degradeSceneDesc", "c", "setDegradeSceneDesc", "enhanceScene", "getEnhanceScene", "setEnhanceScene", "enhanceSceneDesc", "getEnhanceSceneDesc", "setEnhanceSceneDesc", "degradeNotesSchema", "Ljava/lang/String;", "a", "()Ljava/lang/String;", "setDegradeNotesSchema", "(Ljava/lang/String;)V", "enhanceNotesSchema", "getEnhanceNotesSchema", "setEnhanceNotesSchema", "pushTimesLimit", "I", "getPushTimesLimit", "()I", "setPushTimesLimit", "(I)V", "pushTimeGap", "getPushTimeGap", "setPushTimeGap", "pushShowDuration", "h", "setPushShowDuration", "pushDelayDuration", "f", "setPushDelayDuration", "levelInheritanceTimeLimit", "d", "setLevelInheritanceTimeLimit", "", "pushDeviceLevel", "Ljava/util/List;", "g", "()Ljava/util/List;", "setPushDeviceLevel", "(Ljava/util/List;)V", "advancedDegrade", "getAdvancedDegrade", "setAdvancedDegrade", "<init>", "()V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("advanced_Degrade")
    private boolean advancedDegrade;

    @SerializedName("degrade_notes_schema")
    private String degradeNotesSchema;

    @SerializedName("degrade_scene")
    private Map<String, Integer> degradeScene;

    @SerializedName("degrade_scene_description")
    private Map<String, String> degradeSceneDesc;

    @SerializedName("upgrade_notes_schema")
    private String enhanceNotesSchema;

    @SerializedName("upgrade_scene")
    private Map<String, Integer> enhanceScene;

    @SerializedName("upgrade_scene_description")
    private Map<String, String> enhanceSceneDesc;

    @SerializedName("enable_fluency")
    private boolean isFluencyEnable;

    @SerializedName("enable")
    private boolean isOptEnable;

    @SerializedName("level_inheritance_time_limit")
    private long levelInheritanceTimeLimit;

    @SerializedName("local_perf_test_enable")
    private boolean localPerfTestEnable;

    @SerializedName("push_delay_duration")
    private long pushDelayDuration;

    @SerializedName("push_device_level")
    private List<Integer> pushDeviceLevel;

    @SerializedName("push_interval_debug")
    private boolean pushIntervalDebug;

    @SerializedName("push_show_duration")
    private long pushShowDuration;

    @SerializedName("push_time_gap")
    private long pushTimeGap;

    @SerializedName("push_times_limit")
    private int pushTimesLimit;

    @SerializedName("radical_degrade")
    private boolean radicalDegrade;

    @SerializedName("stable_days")
    private long stableDays;

    public b() {
        this.stableDays = 3;
        this.degradeScene = MapsKt.mapOf(new Pair[]{TuplesKt.to("toolbar_anim", 1), TuplesKt.to("short_touch_anim", 1), TuplesKt.to("high_level_enter_anim", 2), TuplesKt.to("high_level_ecom_anim", 0), TuplesKt.to("hot_comment_tray", 0), TuplesKt.to("portrait_danmaku", 0), TuplesKt.to("like_flow", 0), TuplesKt.to("comment_carnival", 0), TuplesKt.to("public_screen_anim", 1), TuplesKt.to("hour_rank_anim", 0), TuplesKt.to("live_drawer_anim", 0), TuplesKt.to("hide_other_digg", 0), TuplesKt.to("gift_tray_anim", 0), TuplesKt.to("interactive_comp_delay", 0), TuplesKt.to("disable_high_level_enter", 1), TuplesKt.to("disable_gift_tray", 1), TuplesKt.to("disable_global_notify", 1), TuplesKt.to("disable_gift_effect", 1), TuplesKt.to("disable_hour_rank", 1), TuplesKt.to("disable_long_touch", 1), TuplesKt.to("disable_top_right_banner", 1)});
        this.degradeSceneDesc = MapsKt.mapOf(new Pair[]{TuplesKt.to("toolbar_anim", "Toolbar动画"), TuplesKt.to("short_touch_anim", "短触动画"), TuplesKt.to("high_level_enter_anim", "高级进房消息"), TuplesKt.to("high_level_ecom_anim", "高级购买消息"), TuplesKt.to("hot_comment_tray", "热评托盘"), TuplesKt.to("portrait_danmaku", "竖屏场景下弹幕"), TuplesKt.to("like_flow", "飘赞"), TuplesKt.to("comment_carnival", "评论狂欢"), TuplesKt.to("public_screen_anim", "公屏动画"), TuplesKt.to("hour_rank_anim", "小时榜动画"), TuplesKt.to("live_drawer_anim", "更多直播动画"), TuplesKt.to("gift_tray_anim", "礼物托盘动画"), TuplesKt.to("high_level_enter_anim", "高级进场动画"), TuplesKt.to("interactive_comp_delay", "交互层延迟组件"), TuplesKt.to("disable_high_level_enter", "屏蔽高级进场"), TuplesKt.to("disable_gift_tray", " 屏蔽礼物托盘"), TuplesKt.to("disable_global_notify", "屏蔽全服广播"), TuplesKt.to("disable_gift_effect", "屏蔽大礼物效果"), TuplesKt.to("disable_hour_rank", "屏蔽小时榜"), TuplesKt.to("disable_long_touch", "屏蔽长触"), TuplesKt.to("disable_top_right_banner", "屏蔽活动banner")});
        this.enhanceSceneDesc = MapsKt.emptyMap();
        this.degradeNotesSchema = "sslocal://webcast_lynxview?url=https%3A%2F%2Flf-webcast-gr-sourcecdn.bytegecko.com%2Fobj%2Fbyte-gurd-source-gr%2Fwebcast%2Fmono%2Flynx%2Fcommunity_openlive_douyin%2Fpages%2Fscreen_cast_rule%2Ftemplate.js&enable_latch=1%0A&hide_nav_bar=1";
        this.pushTimesLimit = 5;
        this.pushTimeGap = 60;
        this.pushShowDuration = 5;
        this.pushDelayDuration = 10;
        this.levelInheritanceTimeLimit = 60;
        this.pushDeviceLevel = CollectionsKt.listOf(1);
    }

    public final String a() {
        return this.degradeNotesSchema;
    }

    public final Map<String, Integer> b() {
        return this.degradeScene;
    }

    public final Map<String, String> c() {
        return this.degradeSceneDesc;
    }

    public final long d() {
        return this.levelInheritanceTimeLimit;
    }

    public final boolean e() {
        return this.localPerfTestEnable;
    }

    public final long f() {
        return this.pushDelayDuration;
    }

    public final List<Integer> g() {
        return this.pushDeviceLevel;
    }

    public final long h() {
        return this.pushShowDuration;
    }

    public final boolean i() {
        return this.radicalDegrade;
    }

    public final long j() {
        return this.stableDays;
    }

    public final boolean k() {
        return this.isFluencyEnable;
    }

    public final boolean l() {
        return this.isOptEnable;
    }
}
