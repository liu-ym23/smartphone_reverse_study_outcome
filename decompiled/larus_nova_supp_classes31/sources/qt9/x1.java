package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import hq9.i4;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R&\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/larus/settings/provider/ImageEditUploadConfig;", "", "<init>", "()V", "shortSideCompressThreshold", "", "getShortSideCompressThreshold", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "longSideCompressThreshold", "getLongSideCompressThreshold", "compressQuality", "getCompressQuality", "sceneBasedConfig", "", "", "Lcom/larus/platform/model/SceneBasedCompressionConfig;", "getSceneBasedConfig", "()Ljava/util/Map;", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class x1 {

    @SerializedName("compress_quality")
    private final Integer compressQuality;

    @SerializedName("long_side_compress_threshold")
    private final Integer longSideCompressThreshold;

    @SerializedName("scene_based_config_map")
    private final Map<String, i4> sceneBasedConfig;

    @SerializedName("short_side_compress_threshold")
    private final Integer shortSideCompressThreshold;

    public x1() {
        this.shortSideCompressThreshold = 2160;
        this.longSideCompressThreshold = 4096;
        this.compressQuality = 100;
    }

    public final Integer a() {
        return this.compressQuality;
    }

    public final Integer b() {
        return this.longSideCompressThreshold;
    }

    public final Map<String, i4> c() {
        return this.sceneBasedConfig;
    }

    public final Integer d() {
        return this.shortSideCompressThreshold;
    }
}
