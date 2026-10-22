package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b?\u0010@R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006R\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006R\u001a\u0010\u0010\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0010\u0010\u0004\u001a\u0004\b\u0011\u0010\u0006R\u001a\u0010\u0012\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0012\u0010\u0004\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0014\u0010\u0004\u001a\u0004\b\u0015\u0010\u0006R\u001a\u0010\u0017\u001a\u00020\u00168\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u00168\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\u0018\u001a\u0004\b\u001c\u0010\u001aR\"\u0010\u001d\u001a\u00020\u00168\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u0018\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b!\u0010\t\u001a\u0004\b\"\u0010\u000b\"\u0004\b#\u0010$R&\u0010(\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020'0%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R&\u0010,\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00020%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b,\u0010)\u001a\u0004\b-\u0010+R\u001a\u0010.\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b.\u0010\t\u001a\u0004\b/\u0010\u000bR\u001a\u00100\u001a\u00020\u00168\u0006X\u0087D¢\u0006\f\n\u0004\b0\u0010\u0018\u001a\u0004\b1\u0010\u001aR\u001a\u00102\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b2\u0010\t\u001a\u0004\b3\u0010\u000bR(\u00104\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0007\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b4\u0010)\u001a\u0004\b5\u0010+R(\u00106\u001a\u0010\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u0016\u0018\u00010%8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b6\u0010)\u001a\u0004\b7\u0010+R\"\u00109\u001a\n\u0012\u0004\u0012\u00020&\u0018\u0001088\u0006X\u0087\u0004¢\u0006\f\n\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010=\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b=\u0010\t\u001a\u0004\b>\u0010\u000b¨\u0006A"}, d2 = {"Lls1/b;", "", "", "performanceSmoothingFactor", "F", "getPerformanceSmoothingFactor", "()F", "", "performanceTrendWindowSize", "I", "getPerformanceTrendWindowSize", "()I", "performanceThresholdDecreaseFactor", "getPerformanceThresholdDecreaseFactor", "performanceThresholdIncreaseFactor", "getPerformanceThresholdIncreaseFactor", "performanceDegradationThreshold", "getPerformanceDegradationThreshold", "performanceImprovementThreshold", "getPerformanceImprovementThreshold", "performanceThresholdMaxGrowthFactor", "getPerformanceThresholdMaxGrowthFactor", "", "enableAsyncInit", "Z", "getEnableAsyncInit", "()Z", "enableAsyncDispatcher", "getEnableAsyncDispatcher", "enable", "getEnable", "setEnable", "(Z)V", "serviceTriggerSource", "getServiceTriggerSource", "setServiceTriggerSource", "(I)V", "", "", "", "devicePerfThresholds", "Ljava/util/Map;", "getDevicePerfThresholds", "()Ljava/util/Map;", "performanceFeedbackThresholds", "getPerformanceFeedbackThresholds", "scheduleType", "getScheduleType", "enableScheduleByScene", "getEnableScheduleByScene", "devicePerfCountWindow", "getDevicePerfCountWindow", "unexpectedStopLiveCountThresholds", "getUnexpectedStopLiveCountThresholds", "abVidsMap", "getAbVidsMap", "", "extraDatasList", "Ljava/util/List;", "getExtraDatasList", "()Ljava/util/List;", "anchorServiceInitTime", "getAnchorServiceInitTime", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("ab_params")
    private final Map<String, Boolean> abVidsMap;

    @SerializedName("anchor_service_init_time")
    private final int anchorServiceInitTime;

    @SerializedName("device_performance_count_window")
    private final int devicePerfCountWindow;

    @SerializedName("device_performance_thresholds")
    private final Map<String, Double> devicePerfThresholds;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_async_dispatcher")
    private final boolean enableAsyncDispatcher;

    @SerializedName("enable_async_init")
    private final boolean enableAsyncInit;

    @SerializedName("enable_schedule_by_scene")
    private final boolean enableScheduleByScene;

    @SerializedName("extra_datas_list")
    private final List<String> extraDatasList;

    @SerializedName("performance_degradation_threshold")
    private final float performanceDegradationThreshold;

    @SerializedName("performance_feedback_thresholds")
    private final Map<String, Float> performanceFeedbackThresholds;

    @SerializedName("performance_improvement_threshold")
    private final float performanceImprovementThreshold;

    @SerializedName("performance_smoothing_factor")
    private final float performanceSmoothingFactor;

    @SerializedName("performance_threshold_decrease_factor")
    private final float performanceThresholdDecreaseFactor;

    @SerializedName("performance_threshold_increase_factor")
    private final float performanceThresholdIncreaseFactor;

    @SerializedName("device_performance_threshold_max_growth_factor")
    private final float performanceThresholdMaxGrowthFactor;

    @SerializedName("performance_trend_window_size")
    private final int performanceTrendWindowSize;

    @SerializedName("schedule_type")
    private final int scheduleType;

    @SerializedName("service_trigger_source")
    private int serviceTriggerSource;

    @SerializedName("unexpected_stop_live_count_thresholds")
    private final Map<String, Integer> unexpectedStopLiveCountThresholds;

    public b() {
        this.performanceSmoothingFactor = 0.5f;
        this.performanceTrendWindowSize = 5;
        this.performanceThresholdDecreaseFactor = 0.8f;
        this.performanceThresholdIncreaseFactor = 0.01f;
        this.performanceDegradationThreshold = 0.05f;
        this.performanceImprovementThreshold = -0.05f;
        this.performanceThresholdMaxGrowthFactor = 1.5f;
        this.devicePerfThresholds = new HashMap();
        this.performanceFeedbackThresholds = new HashMap();
        this.devicePerfCountWindow = 1;
        this.unexpectedStopLiveCountThresholds = new HashMap();
        this.abVidsMap = new HashMap();
        this.extraDatasList = CollectionsKt.emptyList();
        this.anchorServiceInitTime = 1;
    }
}
