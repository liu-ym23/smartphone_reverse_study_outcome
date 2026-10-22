package ls1;

import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010$\n\u0002\u0010\u0006\n\u0002\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b]\u0010^R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\"\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\t\u001a\u0004\b\r\u0010\u000b\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R*\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\u001f\u0010\t\u001a\u0004\b \u0010\u000bR\u001a\u0010!\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b!\u0010\u0004\u001a\u0004\b\"\u0010\u0006R\u001a\u0010#\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b#\u0010\u0004\u001a\u0004\b$\u0010\u0006R\u001a\u0010%\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b%\u0010\u0004\u001a\u0004\b&\u0010\u0006R\u001a\u0010(\u001a\u00020'8\u0006X\u0087D¢\u0006\f\n\u0004\b(\u0010)\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b,\u0010\t\u001a\u0004\b-\u0010\u000bR\u001a\u0010.\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b.\u0010\u0004\u001a\u0004\b/\u0010\u0006R\u001a\u00100\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006R\u001a\u00102\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b2\u0010\u0004\u001a\u0004\b3\u0010\u0006R\u001a\u00104\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b4\u0010\t\u001a\u0004\b5\u0010\u000bR\u001a\u00106\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b6\u0010\t\u001a\u0004\b7\u0010\u000bR\u001a\u00108\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b8\u0010\t\u001a\u0004\b8\u0010\u000bR\u001a\u00109\u001a\u00020'8\u0006X\u0087D¢\u0006\f\n\u0004\b9\u0010)\u001a\u0004\b:\u0010+R\"\u0010;\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b;\u0010\t\u001a\u0004\b<\u0010\u000b\"\u0004\b=\u0010\u000fR(\u0010@\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020?\u0018\u00010>8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b@\u0010A\u001a\u0004\bB\u0010CR\"\u0010D\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bD\u0010\t\u001a\u0004\bE\u0010\u000b\"\u0004\bF\u0010\u000fR\u001a\u0010G\u001a\u00020\u00108\u0006X\u0087D¢\u0006\f\n\u0004\bG\u0010\u0012\u001a\u0004\bH\u0010\u0014R\"\u0010I\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bI\u0010\t\u001a\u0004\bJ\u0010\u000b\"\u0004\bK\u0010\u000fR\"\u0010L\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bL\u0010\t\u001a\u0004\bM\u0010\u000b\"\u0004\bN\u0010\u000fR\"\u0010O\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bO\u0010\u0004\u001a\u0004\bP\u0010\u0006\"\u0004\bQ\u0010RR$\u0010S\u001a\u0004\u0018\u00010\u00188\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\bS\u0010T\u001a\u0004\bU\u0010V\"\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\bY\u0010\t\u001a\u0004\bZ\u0010\u000bR\u001c\u0010[\u001a\u0004\u0018\u00010\u00188\u0006X\u0087\u0004¢\u0006\f\n\u0004\b[\u0010T\u001a\u0004\b\\\u0010V¨\u0006_"}, d2 = {"Lls1/k;", "", "", "imageHashTolerance", "I", "getImageHashTolerance", "()I", "", "enableSimilarImageSkip", "Z", "getEnableSimilarImageSkip", "()Z", "enable", "getEnable", "setEnable", "(Z)V", "", "predictIntervalMs", "J", "getPredictIntervalMs", "()J", "setPredictIntervalMs", "(J)V", "", "", "liveModeList", "Ljava/util/List;", "getLiveModeList", "()Ljava/util/List;", "setLiveModeList", "(Ljava/util/List;)V", "enableCustomizeImageSize", "getEnableCustomizeImageSize", "customizeImageType", "getCustomizeImageType", "imageHeight", "getImageHeight", "imageWidth", "getImageWidth", "", "imageScale", "F", "getImageScale", "()F", "enableSaveImage", "getEnableSaveImage", "scanToolType", "getScanToolType", "maxConcurrentDetectTasks", "getMaxConcurrentDetectTasks", "maxDetectQueueSize", "getMaxDetectQueueSize", "enableMultiReader", "getEnableMultiReader", "enableVisionSmallQrcodeDetect", "getEnableVisionSmallQrcodeDetect", "isPictureScanMode", "cacheResultDuration", "getCacheResultDuration", "enableDynamicSkip", "getEnableDynamicSkip", "setEnableDynamicSkip", "", "", "devicePerfThresholds", "Ljava/util/Map;", "getDevicePerfThresholds", "()Ljava/util/Map;", "enableScanTimeout", "getEnableScanTimeout", "setEnableScanTimeout", "timeoutMsThreshold", "getTimeoutMsThreshold", "enableRecycleBitmapWhenTimeout", "getEnableRecycleBitmapWhenTimeout", "setEnableRecycleBitmapWhenTimeout", "enableRandomSampling", "getEnableRandomSampling", "setEnableRandomSampling", "sampleThreshold", "getSampleThreshold", "setSampleThreshold", "(I)V", "libraVersion", "Ljava/lang/String;", "getLibraVersion", "()Ljava/lang/String;", "setLibraVersion", "(Ljava/lang/String;)V", "testEnable", "getTestEnable", "labVersion", "getLabVersion", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class k {

    @SerializedName("cacheResultDuration")
    private final float cacheResultDuration;

    @SerializedName("customize_image_type")
    private final int customizeImageType;

    @SerializedName("device_performance_thresholds")
    private final Map<String, Double> devicePerfThresholds;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("enable_customize_image_size")
    private final boolean enableCustomizeImageSize;

    @SerializedName("enable_dynamic_skip_task")
    private boolean enableDynamicSkip;

    @SerializedName("enable_multi_reader")
    private final boolean enableMultiReader;

    @SerializedName("enableRandomSampling")
    private boolean enableRandomSampling;

    @SerializedName("enable_recycle_bitmap_when_timeout")
    private boolean enableRecycleBitmapWhenTimeout;

    @SerializedName("enable_save_image")
    private final boolean enableSaveImage;

    @SerializedName("enable_scan_timeout")
    private boolean enableScanTimeout;

    @SerializedName("enable_similar_image_skip_task")
    private final boolean enableSimilarImageSkip;

    @SerializedName("enable_vision_small_qrcode_detect")
    private final boolean enableVisionSmallQrcodeDetect;

    @SerializedName("image_hash_tolerance")
    private final int imageHashTolerance;

    @SerializedName("image_height")
    private final int imageHeight;

    @SerializedName("image_scale_value")
    private final float imageScale;

    @SerializedName("image_width")
    private final int imageWidth;

    @SerializedName("is_picture_scan_mode")
    private final boolean isPictureScanMode;

    @SerializedName("lab_version")
    private final String labVersion;

    @SerializedName("libra_version")
    private String libraVersion;

    @SerializedName("live_type")
    private List<String> liveModeList;

    @SerializedName("max_concurrent_detect_tasks")
    private final int maxConcurrentDetectTasks;

    @SerializedName("max_detect_queue_size")
    private final int maxDetectQueueSize;

    @SerializedName("predict_interval")
    private long predictIntervalMs;

    @SerializedName("sample_threshold")
    private int sampleThreshold;

    @SerializedName("scan_tool_type")
    private final int scanToolType;

    @SerializedName("test_enable")
    private final boolean testEnable;

    @SerializedName("timeout_ms_threshold")
    private final long timeoutMsThreshold;

    public k() {
        this.imageHashTolerance = 5;
        this.predictIntervalMs = 1000;
        this.liveModeList = CollectionsKt.arrayListOf(new String[]{"video_live"});
        this.enableCustomizeImageSize = true;
        this.imageHeight = 320;
        this.imageWidth = 180;
        this.imageScale = 0.8f;
        this.scanToolType = 2;
        this.maxConcurrentDetectTasks = 1;
        this.maxDetectQueueSize = 2;
        this.enableMultiReader = true;
        this.enableVisionSmallQrcodeDetect = true;
        this.isPictureScanMode = true;
        this.cacheResultDuration = 1.0f;
        this.devicePerfThresholds = new HashMap();
        this.timeoutMsThreshold = 1000;
        this.sampleThreshold = 50;
    }
}
