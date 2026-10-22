package com.bytedance.android.live.feature.config;

import com.bytedance.android.live.base.model.message.n5;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b;\n\u0002\u0010\u0011\n\u0002\b\f\n\u0002\u0010\u0007\n\u0002\b)\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0013\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140e¢\u0006\u0003\u0010\u0099\u0001J\r\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\f\"\u0004\b\u0011\u0010\u000eR&\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\f\"\u0004\b\u001b\u0010\u000eR\u001e\u0010\u001c\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\f\"\u0004\b\u001e\u0010\u000eR\u001e\u0010\u001f\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\f\"\u0004\b!\u0010\u000eR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R,\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R&\u0010.\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0016\"\u0004\b0\u0010\u0018R\u001e\u00101\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0006\"\u0004\b3\u0010\bR\u001e\u00104\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\f\"\u0004\b6\u0010\u000eR\u001e\u00107\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010\u0006\"\u0004\b9\u0010\bR\u001e\u0010:\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010\f\"\u0004\b<\u0010\u000eR&\u0010=\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010\u0016\"\u0004\b?\u0010\u0018R&\u0010@\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010\u0018R&\u0010C\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\u0016\"\u0004\bE\u0010\u0018R\u001e\u0010F\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\f\"\u0004\bH\u0010\u000eR\u001e\u0010I\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\f\"\u0004\bK\u0010\u000eR,\u0010L\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bM\u0010+\"\u0004\bN\u0010-R\u001e\u0010O\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\f\"\u0004\bQ\u0010\u000eR&\u0010R\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\u0016\"\u0004\bT\u0010\u0018R\u001e\u0010U\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\f\"\u0004\bW\u0010\u000eR\u001e\u0010X\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bY\u0010%\"\u0004\bZ\u0010'R&\u0010[\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\u0016\"\u0004\b]\u0010\u0018R\u001e\u0010^\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010\u0006\"\u0004\b`\u0010\bR\u001e\u0010a\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010%\"\u0004\bc\u0010'R\u001c\u0010d\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010e8\u0002@\u0002X\u0083\u000e¢\u0006\u0004\n\u0002\u0010fR\u001e\u0010g\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\f\"\u0004\bi\u0010\u000eR\u001e\u0010j\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bk\u0010%\"\u0004\bl\u0010'R\u001a\u0010m\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00138\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001e\u0010n\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\u0006\"\u0004\bp\u0010\bR\u001e\u0010q\u001a\u00020r8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bs\u0010t\"\u0004\bu\u0010vR\u001e\u0010w\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bx\u0010\f\"\u0004\by\u0010\u000eR\u001e\u0010z\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b{\u0010\f\"\u0004\b|\u0010\u000eR&\u0010}\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00138\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b~\u0010\u0016\"\u0004\b\u007f\u0010\u0018R!\u0010\u0080\u0001\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0081\u0001\u0010\u0006\"\u0005\b\u0082\u0001\u0010\bR!\u0010\u0083\u0001\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0084\u0001\u0010%\"\u0005\b\u0085\u0001\u0010'R!\u0010\u0086\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010\f\"\u0005\b\u0088\u0001\u0010\u000eR!\u0010\u0089\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010\f\"\u0005\b\u008b\u0001\u0010\u000eR/\u0010\u008c\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u0001\u0018\u00010)8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008d\u0001\u0010+\"\u0005\b\u008e\u0001\u0010-R!\u0010\u008f\u0001\u001a\u00020#8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0090\u0001\u0010%\"\u0005\b\u0091\u0001\u0010'R!\u0010\u0092\u0001\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\f\"\u0005\b\u0094\u0001\u0010\u000eR!\u0010\u0095\u0001\u001a\u00020r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0096\u0001\u0010t\"\u0005\b\u0097\u0001\u0010v¨\u0006\u009b\u0001"}, d2 = {"Lcom/bytedance/android/live/feature/config/LiveFeatureConfig;", "", "()V", "deadlineValue", "", "getDeadlineValue", "()I", "setDeadlineValue", "(I)V", "enable", "", "getEnable", "()Z", "setEnable", "(Z)V", "featureApplogListenerEnable", "getFeatureApplogListenerEnable", "setFeatureApplogListenerEnable", "featureApplogListenerEvents", "", "", "getFeatureApplogListenerEvents", "()Ljava/util/List;", "setFeatureApplogListenerEvents", "(Ljava/util/List;)V", "featureInterceptorEnable", "getFeatureInterceptorEnable", "setFeatureInterceptorEnable", "featureLogLogicFeatureProviderEnable", "getFeatureLogLogicFeatureProviderEnable", "setFeatureLogLogicFeatureProviderEnable", "featureTestEnable", "getFeatureTestEnable", "setFeatureTestEnable", "featureTestFrequency", "", "getFeatureTestFrequency", "()J", "setFeatureTestFrequency", "(J)V", "featureTestMap", "", "getFeatureTestMap", "()Ljava/util/Map;", "setFeatureTestMap", "(Ljava/util/Map;)V", "feedFeatureProducerList", "getFeedFeatureProducerList", "setFeedFeatureProducerList", "initType", "getInitType", "setInitType", "kevaOptEnable", "getKevaOptEnable", "setKevaOptEnable", "limitRoomFeaturesSize", "getLimitRoomFeaturesSize", "setLimitRoomFeaturesSize", "liveFeatureProducerEnable", "getLiveFeatureProducerEnable", "setLiveFeatureProducerEnable", "liveFuzzyCommentStringList", "getLiveFuzzyCommentStringList", "setLiveFuzzyCommentStringList", "liveNotFuzzyCommentStringList", "getLiveNotFuzzyCommentStringList", "setLiveNotFuzzyCommentStringList", "liveShowRecordParams", "getLiveShowRecordParams", "setLiveShowRecordParams", "logEnable", "getLogEnable", "setLogEnable", "mockFeatureEnable", "getMockFeatureEnable", "setMockFeatureEnable", "mockFeatureMap", "getMockFeatureMap", "setMockFeatureMap", "portraitCenterEnable", "getPortraitCenterEnable", "setPortraitCenterEnable", "portraitCenterGetTypeList", "getPortraitCenterGetTypeList", "setPortraitCenterGetTypeList", "portraitCenterSetupEnable", "getPortraitCenterSetupEnable", "setPortraitCenterSetupEnable", "portraitCenterUpdateInterval", "getPortraitCenterUpdateInterval", "setPortraitCenterUpdateInterval", "previewStayDurationReportList", "getPreviewStayDurationReportList", "setPreviewStayDurationReportList", "previewStayDurationUpdateInterval", "getPreviewStayDurationUpdateInterval", "setPreviewStayDurationUpdateInterval", "previewStayDurationUpdatePeriod", "getPreviewStayDurationUpdatePeriod", "setPreviewStayDurationUpdatePeriod", "publishPointList", "", "[Ljava/lang/String;", "reacquireFeatureEnable", "getReacquireFeatureEnable", "setReacquireFeatureEnable", "reacquireFeatureInterval", "getReacquireFeatureInterval", "setReacquireFeatureInterval", "reacquireFeatureList", "recentFrequencyValue", "getRecentFrequencyValue", "setRecentFrequencyValue", "recentSessionValue", "", "getRecentSessionValue", "()F", "setRecentSessionValue", "(F)V", "roomFeatureOpt", "getRoomFeatureOpt", "setRoomFeatureOpt", "roomFeatureOptMerge", "getRoomFeatureOptMerge", "setRoomFeatureOptMerge", "roomStayDurationReportList", "getRoomStayDurationReportList", "setRoomStayDurationReportList", "roomStayDurationUpdateInterval", "getRoomStayDurationUpdateInterval", "setRoomStayDurationUpdateInterval", "roomStayDurationUpdatePeriod", "getRoomStayDurationUpdatePeriod", "setRoomStayDurationUpdatePeriod", "stallLogInfoEnable", "getStallLogInfoEnable", "setStallLogInfoEnable", "timeOptEnable", "getTimeOptEnable", "setTimeOptEnable", "timerUpdateFeatureMap", "getTimerUpdateFeatureMap", "setTimerUpdateFeatureMap", "timerUpdateFrequency", "getTimerUpdateFrequency", "setTimerUpdateFrequency", "timerUpdatePreviewPerformanceDataEnable", "getTimerUpdatePreviewPerformanceDataEnable", "setTimerUpdatePreviewPerformanceDataEnable", "watchSessionThreshold", "getWatchSessionThreshold", "setWatchSessionThreshold", "getPublishPointList", "()[Ljava/lang/String;", "getReacquireFeatureList", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveFeatureConfig {

    @SerializedName("deadline_value")
    private int deadlineValue;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("feature_applog_listener_enable")
    private boolean featureApplogListenerEnable;

    @SerializedName("feature_applog_listener_events")
    private List<String> featureApplogListenerEvents;

    @SerializedName("feature_interceptor_enable")
    private boolean featureInterceptorEnable;

    @SerializedName("log_logic_feature_provider_enable")
    private boolean featureLogLogicFeatureProviderEnable;

    @SerializedName("feature_test_enable")
    private boolean featureTestEnable;

    @SerializedName("feature_test_frequency")
    private long featureTestFrequency;

    @SerializedName("test_feature_map")
    private Map<String, ? extends Object> featureTestMap;

    @SerializedName("feed_feature_producer_list")
    private List<String> feedFeatureProducerList;

    @SerializedName("init_type")
    private int initType;

    @SerializedName("keva_opt_enable")
    private boolean kevaOptEnable;

    @SerializedName("limit_room_features_size")
    private int limitRoomFeaturesSize;

    @SerializedName("live_feature_producer_enable")
    private boolean liveFeatureProducerEnable;

    @SerializedName("live_fuzzy_comment_string_list")
    private List<String> liveFuzzyCommentStringList;

    @SerializedName("live_not_fuzzy_comment_string_list")
    private List<String> liveNotFuzzyCommentStringList;

    @SerializedName("live_show_record_params")
    private List<String> liveShowRecordParams;

    @SerializedName("log_enable")
    private boolean logEnable;

    @SerializedName("mock_feature_enable")
    private boolean mockFeatureEnable;

    @SerializedName("mock_feature_map")
    private Map<String, ? extends Object> mockFeatureMap;

    @SerializedName("portrait_center_enable")
    private boolean portraitCenterEnable;

    @SerializedName("portrait_center_get_type_list")
    private List<Integer> portraitCenterGetTypeList;

    @SerializedName("portrait_center_setup_enable")
    private boolean portraitCenterSetupEnable;

    @SerializedName("portrait_center_update_interval")
    private long portraitCenterUpdateInterval;

    @SerializedName("preview_stay_duration_report_list")
    private List<Integer> previewStayDurationReportList;

    @SerializedName("preview_stay_duration_update_Interval_in_sec")
    private int previewStayDurationUpdateInterval;

    @SerializedName("preview_stay_duration_update_period")
    private long previewStayDurationUpdatePeriod;

    @SerializedName("publish_point_list")
    private String[] publishPointList;

    @SerializedName("reacquire_feature_when_getFeatureMap_enable")
    private boolean reacquireFeatureEnable;

    @SerializedName("reacquire_feature_interval")
    private long reacquireFeatureInterval;

    @SerializedName("reacquire_feature_list")
    private List<String> reacquireFeatureList;

    @SerializedName("recent_frequency_value")
    private int recentFrequencyValue;

    @SerializedName("recent_session_value")
    private float recentSessionValue;

    @SerializedName("room_feature_opt")
    private boolean roomFeatureOpt;

    @SerializedName("room_feature_opt_merge")
    private boolean roomFeatureOptMerge;

    @SerializedName("room_stay_duration_report_list")
    private List<Integer> roomStayDurationReportList;

    @SerializedName("room_stay_duration_update_Interval_in_sec")
    private int roomStayDurationUpdateInterval;

    @SerializedName("room_stay_duration_update_period")
    private long roomStayDurationUpdatePeriod;

    @SerializedName("stall_log_info_enable")
    private boolean stallLogInfoEnable;

    @SerializedName("time_opt_enable")
    private boolean timeOptEnable;

    @SerializedName("timer_update_feature_map")
    private Map<String, ? extends Object> timerUpdateFeatureMap;

    @SerializedName("feature_update_frequency")
    private long timerUpdateFrequency;

    @SerializedName("timer_update_preview_performance_data_enable")
    private boolean timerUpdatePreviewPerformanceDataEnable;

    @SerializedName("watch_session_threshold")
    private float watchSessionThreshold;

    public final String[] getPublishPointList() {
        String[] r0 = this.publishPointList;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L11:
        if (r1 == true) goto L13;
        Intrinsics.checkNotNull(r0);
        return r0;
    L13:
        return new String[]{"vrthird2d", "vrthird", "vrfantasy", "thirdgame", "stage", "third", "media", "game", "fantasy", "radio", "format", "encryption"};
    L5:
        if (r0.length != 0) goto L7;
        boolean r2 = true;
    L8:
        if (r2 == true) goto L11;
        r1 = false;
        goto L11
    L7:
        r2 = false;
        goto L8
    }

    public final List<String> getReacquireFeatureList() {
        List<String> r1 = this.reacquireFeatureList;
        if (r1 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L11;
        List<String> r3 = this.reacquireFeatureList;
        Intrinsics.checkNotNull(r3);
        return r3;
    L11:
        return CollectionsKt.listOf(new String[]{"memory_available_rate", "ui_stall_rate", "avg_stall_ui_rate_per_week", "avg_stall_ui_video_rate_per_week", "avg_enter_room_duration_per_week", "performance_monitor_ready", "net_quality", "downstream_throughput_kbps", "screen_brightness", "cur_environment_brightness", "auto_brightness_enable", "current_media_volume_percent", "live_watch_duration", "audience_change_definition", "cur_day_of_week", "cur_hour", "live_brightness", "is_enable_personal_recommend", "stay_live_duration", "live_quit_dialog_show_interval", "current_resolution", "current_resolution_level", "last_play_resolution_key", "cur_minute", "cur_minute_in_day", "anchor_fans_count", "anchor_follow_count", "follow_status", "anchor_gender", "live_duration", "drawer_preload_interval", "drawer_preload_interval_app", "drawer_open_interval", "drawer_open_interval_app", "enter_inner_live_scene", "app_stay_duration", "non_live_stay_duration", "preview_stay_duration"});
    L5:
        if (r1.isEmpty() == true) goto L8;
        r2 = false;
        goto L9
    }

    public LiveFeatureConfig() {
        this.enable = true;
        this.initType = 2;
        this.kevaOptEnable = true;
        this.liveFeatureProducerEnable = true;
        this.featureInterceptorEnable = true;
        this.featureApplogListenerEnable = true;
        this.featureLogLogicFeatureProviderEnable = true;
        this.recentFrequencyValue = 5;
        this.recentSessionValue = 30.0f;
        this.watchSessionThreshold = 5.0f;
        this.deadlineValue = 7;
        this.portraitCenterEnable = true;
        this.portraitCenterGetTypeList = CollectionsKt.listOf(new Integer[]{1, 2});
        this.portraitCenterUpdateInterval = n5.DEFAULT_SHOW_DURATION;
        this.featureTestFrequency = 10000;
        this.reacquireFeatureEnable = true;
        this.reacquireFeatureInterval = 10000;
        this.feedFeatureProducerList = CollectionsKt.listOf(new String[]{"common", "portrait", "commercialize", "feed_aweme", "pitaya"});
        this.timerUpdatePreviewPerformanceDataEnable = true;
        this.timeOptEnable = true;
        this.stallLogInfoEnable = true;
        this.timerUpdateFrequency = 1000;
        this.roomStayDurationUpdateInterval = 5;
        this.previewStayDurationUpdateInterval = 5;
        this.limitRoomFeaturesSize = 64;
        this.roomFeatureOpt = true;
        this.roomFeatureOptMerge = true;
    }

    public final int getDeadlineValue() {
        return this.deadlineValue;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final boolean getFeatureApplogListenerEnable() {
        return this.featureApplogListenerEnable;
    }

    public final List<String> getFeatureApplogListenerEvents() {
        return this.featureApplogListenerEvents;
    }

    public final boolean getFeatureInterceptorEnable() {
        return this.featureInterceptorEnable;
    }

    public final boolean getFeatureLogLogicFeatureProviderEnable() {
        return this.featureLogLogicFeatureProviderEnable;
    }

    public final boolean getFeatureTestEnable() {
        return this.featureTestEnable;
    }

    public final long getFeatureTestFrequency() {
        return this.featureTestFrequency;
    }

    public final Map<String, Object> getFeatureTestMap() {
        return this.featureTestMap;
    }

    public final List<String> getFeedFeatureProducerList() {
        return this.feedFeatureProducerList;
    }

    public final int getInitType() {
        return this.initType;
    }

    public final boolean getKevaOptEnable() {
        return this.kevaOptEnable;
    }

    public final int getLimitRoomFeaturesSize() {
        return this.limitRoomFeaturesSize;
    }

    public final boolean getLiveFeatureProducerEnable() {
        return this.liveFeatureProducerEnable;
    }

    public final List<String> getLiveFuzzyCommentStringList() {
        return this.liveFuzzyCommentStringList;
    }

    public final List<String> getLiveNotFuzzyCommentStringList() {
        return this.liveNotFuzzyCommentStringList;
    }

    public final List<String> getLiveShowRecordParams() {
        return this.liveShowRecordParams;
    }

    public final boolean getLogEnable() {
        return this.logEnable;
    }

    public final boolean getMockFeatureEnable() {
        return this.mockFeatureEnable;
    }

    public final Map<String, Object> getMockFeatureMap() {
        return this.mockFeatureMap;
    }

    public final boolean getPortraitCenterEnable() {
        return this.portraitCenterEnable;
    }

    public final List<Integer> getPortraitCenterGetTypeList() {
        return this.portraitCenterGetTypeList;
    }

    public final boolean getPortraitCenterSetupEnable() {
        return this.portraitCenterSetupEnable;
    }

    public final long getPortraitCenterUpdateInterval() {
        return this.portraitCenterUpdateInterval;
    }

    public final List<Integer> getPreviewStayDurationReportList() {
        return this.previewStayDurationReportList;
    }

    public final int getPreviewStayDurationUpdateInterval() {
        return this.previewStayDurationUpdateInterval;
    }

    public final long getPreviewStayDurationUpdatePeriod() {
        return this.previewStayDurationUpdatePeriod;
    }

    public final boolean getReacquireFeatureEnable() {
        return this.reacquireFeatureEnable;
    }

    public final long getReacquireFeatureInterval() {
        return this.reacquireFeatureInterval;
    }

    public final int getRecentFrequencyValue() {
        return this.recentFrequencyValue;
    }

    public final float getRecentSessionValue() {
        return this.recentSessionValue;
    }

    public final boolean getRoomFeatureOpt() {
        return this.roomFeatureOpt;
    }

    public final boolean getRoomFeatureOptMerge() {
        return this.roomFeatureOptMerge;
    }

    public final List<Integer> getRoomStayDurationReportList() {
        return this.roomStayDurationReportList;
    }

    public final int getRoomStayDurationUpdateInterval() {
        return this.roomStayDurationUpdateInterval;
    }

    public final long getRoomStayDurationUpdatePeriod() {
        return this.roomStayDurationUpdatePeriod;
    }

    public final boolean getStallLogInfoEnable() {
        return this.stallLogInfoEnable;
    }

    public final boolean getTimeOptEnable() {
        return this.timeOptEnable;
    }

    public final Map<String, Object> getTimerUpdateFeatureMap() {
        return this.timerUpdateFeatureMap;
    }

    public final long getTimerUpdateFrequency() {
        return this.timerUpdateFrequency;
    }

    public final boolean getTimerUpdatePreviewPerformanceDataEnable() {
        return this.timerUpdatePreviewPerformanceDataEnable;
    }

    public final float getWatchSessionThreshold() {
        return this.watchSessionThreshold;
    }

    public final void setDeadlineValue(int r1) {
        this.deadlineValue = r1;
    }

    public final void setEnable(boolean r1) {
        this.enable = r1;
    }

    public final void setFeatureApplogListenerEnable(boolean r1) {
        this.featureApplogListenerEnable = r1;
    }

    public final void setFeatureApplogListenerEvents(List<String> r1) {
        this.featureApplogListenerEvents = r1;
    }

    public final void setFeatureInterceptorEnable(boolean r1) {
        this.featureInterceptorEnable = r1;
    }

    public final void setFeatureLogLogicFeatureProviderEnable(boolean r1) {
        this.featureLogLogicFeatureProviderEnable = r1;
    }

    public final void setFeatureTestEnable(boolean r1) {
        this.featureTestEnable = r1;
    }

    public final void setFeatureTestFrequency(long r1) {
        this.featureTestFrequency = r1;
    }

    public final void setFeatureTestMap(Map<String, ? extends Object> r1) {
        this.featureTestMap = r1;
    }

    public final void setFeedFeatureProducerList(List<String> r1) {
        this.feedFeatureProducerList = r1;
    }

    public final void setInitType(int r1) {
        this.initType = r1;
    }

    public final void setKevaOptEnable(boolean r1) {
        this.kevaOptEnable = r1;
    }

    public final void setLimitRoomFeaturesSize(int r1) {
        this.limitRoomFeaturesSize = r1;
    }

    public final void setLiveFeatureProducerEnable(boolean r1) {
        this.liveFeatureProducerEnable = r1;
    }

    public final void setLiveFuzzyCommentStringList(List<String> r1) {
        this.liveFuzzyCommentStringList = r1;
    }

    public final void setLiveNotFuzzyCommentStringList(List<String> r1) {
        this.liveNotFuzzyCommentStringList = r1;
    }

    public final void setLiveShowRecordParams(List<String> r1) {
        this.liveShowRecordParams = r1;
    }

    public final void setLogEnable(boolean r1) {
        this.logEnable = r1;
    }

    public final void setMockFeatureEnable(boolean r1) {
        this.mockFeatureEnable = r1;
    }

    public final void setMockFeatureMap(Map<String, ? extends Object> r1) {
        this.mockFeatureMap = r1;
    }

    public final void setPortraitCenterEnable(boolean r1) {
        this.portraitCenterEnable = r1;
    }

    public final void setPortraitCenterGetTypeList(List<Integer> r1) {
        this.portraitCenterGetTypeList = r1;
    }

    public final void setPortraitCenterSetupEnable(boolean r1) {
        this.portraitCenterSetupEnable = r1;
    }

    public final void setPortraitCenterUpdateInterval(long r1) {
        this.portraitCenterUpdateInterval = r1;
    }

    public final void setPreviewStayDurationReportList(List<Integer> r1) {
        this.previewStayDurationReportList = r1;
    }

    public final void setPreviewStayDurationUpdateInterval(int r1) {
        this.previewStayDurationUpdateInterval = r1;
    }

    public final void setPreviewStayDurationUpdatePeriod(long r1) {
        this.previewStayDurationUpdatePeriod = r1;
    }

    public final void setReacquireFeatureEnable(boolean r1) {
        this.reacquireFeatureEnable = r1;
    }

    public final void setReacquireFeatureInterval(long r1) {
        this.reacquireFeatureInterval = r1;
    }

    public final void setRecentFrequencyValue(int r1) {
        this.recentFrequencyValue = r1;
    }

    public final void setRecentSessionValue(float r1) {
        this.recentSessionValue = r1;
    }

    public final void setRoomFeatureOpt(boolean r1) {
        this.roomFeatureOpt = r1;
    }

    public final void setRoomFeatureOptMerge(boolean r1) {
        this.roomFeatureOptMerge = r1;
    }

    public final void setRoomStayDurationReportList(List<Integer> r1) {
        this.roomStayDurationReportList = r1;
    }

    public final void setRoomStayDurationUpdateInterval(int r1) {
        this.roomStayDurationUpdateInterval = r1;
    }

    public final void setRoomStayDurationUpdatePeriod(long r1) {
        this.roomStayDurationUpdatePeriod = r1;
    }

    public final void setStallLogInfoEnable(boolean r1) {
        this.stallLogInfoEnable = r1;
    }

    public final void setTimeOptEnable(boolean r1) {
        this.timeOptEnable = r1;
    }

    public final void setTimerUpdateFeatureMap(Map<String, ? extends Object> r1) {
        this.timerUpdateFeatureMap = r1;
    }

    public final void setTimerUpdateFrequency(long r1) {
        this.timerUpdateFrequency = r1;
    }

    public final void setTimerUpdatePreviewPerformanceDataEnable(boolean r1) {
        this.timerUpdatePreviewPerformanceDataEnable = r1;
    }

    public final void setWatchSessionThreshold(float r1) {
        this.watchSessionThreshold = r1;
    }
}
