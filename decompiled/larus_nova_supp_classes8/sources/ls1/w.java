package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0006\n\u0002\b'\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\bR\u0010SR\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\u000f\u0010\u000bR(\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006R\u001a\u0010\u0019\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0019\u0010\u0004\u001a\u0004\b\u001a\u0010\u0006R\u001a\u0010\u001b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u001b\u0010\t\u001a\u0004\b\u001c\u0010\u000bR\"\u0010\u001d\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\t\u001a\u0004\b\u001e\u0010\u000b\"\u0004\b\u001f\u0010\rR\"\u0010 \u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b \u0010\t\u001a\u0004\b!\u0010\u000b\"\u0004\b\"\u0010\rR\"\u0010#\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b#\u0010\t\u001a\u0004\b$\u0010\u000b\"\u0004\b%\u0010\rR\"\u0010&\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006\"\u0004\b(\u0010)R\"\u0010*\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b*\u0010\u0004\u001a\u0004\b+\u0010\u0006\"\u0004\b,\u0010)R\"\u0010-\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b-\u0010.\u001a\u0004\b/\u00100\"\u0004\b1\u00102R.\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00120\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b3\u0010\u0014\u001a\u0004\b4\u0010\u0016\"\u0004\b5\u00106R.\u00107\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b7\u0010\u0014\u001a\u0004\b8\u0010\u0016\"\u0004\b9\u00106R*\u0010;\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010:8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@R\u001a\u0010A\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bA\u0010\u0004\u001a\u0004\bB\u0010\u0006R\u001a\u0010C\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bC\u0010\u0004\u001a\u0004\bD\u0010\u0006R\u001a\u0010F\u001a\u00020E8\u0006X\u0087D¢\u0006\f\n\u0004\bF\u0010G\u001a\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bJ\u0010\u0004\u001a\u0004\bK\u0010\u0006R\u001a\u0010L\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\bL\u0010\u0004\u001a\u0004\bM\u0010\u0006R\u001c\u0010N\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0004¢\u0006\f\n\u0004\bN\u0010O\u001a\u0004\bP\u0010Q¨\u0006T"}, d2 = {"Lls1/w;", "", "", "imageHashTolerance", "I", "getImageHashTolerance", "()I", "", "enableDynamicSkip", "Z", "getEnableDynamicSkip", "()Z", "setEnableDynamicSkip", "(Z)V", "enableSimilarImageSkip", "getEnableSimilarImageSkip", "", "", "", "devicePerfThresholds", "Ljava/util/Map;", "getDevicePerfThresholds", "()Ljava/util/Map;", "detectType", "getDetectType", "textureConverterType", "getTextureConverterType", "enableSaveImage", "getEnableSaveImage", "enable", "getEnable", "setEnable", "enableReleaseResource", "getEnableReleaseResource", "setEnableReleaseResource", "enableFeatureReport", "getEnableFeatureReport", "setEnableFeatureReport", "detectResultReportType", "getDetectResultReportType", "setDetectResultReportType", "(I)V", "predictIntervalMs", "getPredictIntervalMs", "setPredictIntervalMs", "scoreThreshold", "D", "getScoreThreshold", "()D", "setScoreThreshold", "(D)V", "multipleClassifyScoreThreshold", "getMultipleClassifyScoreThreshold", "setMultipleClassifyScoreThreshold", "(Ljava/util/Map;)V", "pitayaAbParams", "getPitayaAbParams", "setPitayaAbParams", "", "liveModeList", "Ljava/util/List;", "getLiveModeList", "()Ljava/util/List;", "setLiveModeList", "(Ljava/util/List;)V", "imageHeight", "getImageHeight", "imageWidth", "getImageWidth", "", "imageCompressRate", "F", "getImageCompressRate", "()F", "maxConcurrentDetectTasks", "getMaxConcurrentDetectTasks", "maxDetectQueueSize", "getMaxDetectQueueSize", "labVersion", "Ljava/lang/String;", "getLabVersion", "()Ljava/lang/String;", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class w {

    @SerializedName("enable_detect_result_report")
    private int detectResultReportType;

    @SerializedName("detect_type")
    private final int detectType;

    @SerializedName("device_performance_thresholds")
    private final Map<String, Double> devicePerfThresholds;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_dynamic_skip_task")
    private boolean enableDynamicSkip;

    @SerializedName("enable_feature_report")
    private boolean enableFeatureReport;

    @SerializedName("enable_release_resource")
    private boolean enableReleaseResource;

    @SerializedName("enable_save_image")
    private final boolean enableSaveImage;

    @SerializedName("enable_similar_image_skip_task")
    private final boolean enableSimilarImageSkip;

    @SerializedName("image_compress_rate")
    private final float imageCompressRate;

    @SerializedName("image_hash_tolerance")
    private final int imageHashTolerance;

    @SerializedName("image_height")
    private final int imageHeight;

    @SerializedName("image_width")
    private final int imageWidth;

    @SerializedName("lab_version")
    private final String labVersion;

    @SerializedName("live_type")
    private List<String> liveModeList;

    @SerializedName("max_concurrent_detect_tasks")
    private final int maxConcurrentDetectTasks;

    @SerializedName("max_detect_queue_size")
    private final int maxDetectQueueSize;

    @SerializedName("multiple_classify_score_threshold")
    private Map<String, Double> multipleClassifyScoreThreshold;

    @SerializedName("pitaya_ab_params")
    private Map<String, ? extends Object> pitayaAbParams;

    @SerializedName("predict_interval")
    private int predictIntervalMs;

    @SerializedName("score_threshold")
    private double scoreThreshold;

    @SerializedName("texture_converter_type")
    private final int textureConverterType;

    public w() {
        this.imageHashTolerance = 5;
        this.devicePerfThresholds = new HashMap();
        this.predictIntervalMs = 500;
        this.scoreThreshold = 0.1d;
        this.multipleClassifyScoreThreshold = new HashMap();
        this.pitayaAbParams = new HashMap();
        this.liveModeList = CollectionsKt.arrayListOf(new String[]{"video_live"});
        this.imageHeight = 640;
        this.imageWidth = 360;
        this.imageCompressRate = 0.4f;
        this.maxConcurrentDetectTasks = 1;
        this.maxDetectQueueSize = 2;
    }
}
