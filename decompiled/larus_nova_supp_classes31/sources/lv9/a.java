package lv9;

import com.google.gson.JsonObject;
import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u008d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\n\u0012\b\b\u0002\u0010\u000f\u001a\u00020\n\u0012\b\b\u0002\u0010\u0010\u001a\u00020\n\u0012\b\b\u0002\u0010\u0011\u001a\u00020\n\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u000b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001aR\u0016\u0010\r\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0016\u0010\u000e\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0016\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001eR\u0016\u0010\u0010\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001eR\u0016\u0010\u0011\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'¨\u0006("}, d2 = {"Lcom/larus/settings/provider/navigation/NavigationConfig;", "", "engineType", "", "reachEndThreshold", "yawVerbalTimeoutMillis", "", "enterBackgroundVerbalText", "", "enableEnterBackgroundVerbal", "", "enterBackgroundVerbalMinInterval", "startContinuousLocationTimeout", "uploadProjectPoints", "enableAgentKeyNodeReport", "eskfEnable", "useFusionLocation", "enableLocationPrewarm", "eskfConfig", "Lcom/google/gson/JsonObject;", "<init>", "(IIJLjava/lang/String;ZIJZZZZZLcom/google/gson/JsonObject;)V", "getEngineType", "()I", "getReachEndThreshold", "getYawVerbalTimeoutMillis", "()J", "getEnterBackgroundVerbalText", "()Ljava/lang/String;", "getEnableEnterBackgroundVerbal", "()Z", "getEnterBackgroundVerbalMinInterval", "getStartContinuousLocationTimeout", "getUploadProjectPoints", "getEnableAgentKeyNodeReport", "getEskfEnable", "getUseFusionLocation", "getEnableLocationPrewarm", "getEskfConfig", "()Lcom/google/gson/JsonObject;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class a {

    @SerializedName("enable_agent_key_node_report")
    private final boolean enableAgentKeyNodeReport;

    @SerializedName("enable_enter_background_verbal")
    private final boolean enableEnterBackgroundVerbal;

    @SerializedName("enable_location_prewarm")
    private final boolean enableLocationPrewarm;

    @SerializedName("engine_type")
    private final int engineType;

    @SerializedName("enter_background_verbal_min_interval")
    private final int enterBackgroundVerbalMinInterval;

    @SerializedName("enter_background_verbal_text")
    private final String enterBackgroundVerbalText;

    @SerializedName(alternate = {"flow_eskf_config"}, value = "eskf_config")
    private final JsonObject eskfConfig;

    @SerializedName("eskf_enable")
    private final boolean eskfEnable;

    @SerializedName("reach_end_threshold")
    private final int reachEndThreshold;

    @SerializedName("start_continuous_location_timeout")
    private final long startContinuousLocationTimeout;

    @SerializedName("upload_project_points")
    private final boolean uploadProjectPoints;

    @SerializedName("use_fusion_location")
    private final boolean useFusionLocation;

    @SerializedName("yaw_verbal_timeout_millis")
    private final long yawVerbalTimeoutMillis;

    public a() {
        this(0);
    }

    public final boolean a() {
        return this.enableAgentKeyNodeReport;
    }

    public final boolean b() {
        return this.enableEnterBackgroundVerbal;
    }

    public final boolean c() {
        return this.enableLocationPrewarm;
    }

    public final int d() {
        return this.engineType;
    }

    public final int e() {
        return this.enterBackgroundVerbalMinInterval;
    }

    public final String f() {
        return this.enterBackgroundVerbalText;
    }

    public final JsonObject g() {
        return this.eskfConfig;
    }

    public final boolean h() {
        return this.eskfEnable;
    }

    public final int i() {
        return this.reachEndThreshold;
    }

    public final long j() {
        return this.startContinuousLocationTimeout;
    }

    public final boolean k() {
        return this.uploadProjectPoints;
    }

    public final boolean l() {
        return this.useFusionLocation;
    }

    public final long m() {
        return this.yawVerbalTimeoutMillis;
    }

    public a(int r3) {
        this.engineType = 1;
        this.reachEndThreshold = 10;
        this.yawVerbalTimeoutMillis = 8000;
        this.enterBackgroundVerbalText = "当前导航已退至后台，位置更新不及时，请切换至前台获取精确导航信息。";
        this.enableEnterBackgroundVerbal = true;
        this.enterBackgroundVerbalMinInterval = 10000;
        this.startContinuousLocationTimeout = 5000;
        this.uploadProjectPoints = false;
        this.enableAgentKeyNodeReport = false;
        this.eskfEnable = false;
        this.useFusionLocation = false;
        this.enableLocationPrewarm = false;
        this.eskfConfig = null;
    }
}
