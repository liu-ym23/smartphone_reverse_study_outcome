package oq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\u0018\u0000 \r2\u00020\u0001:\u0001\rB+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\f\u0010\t¨\u0006\u000e"}, d2 = {"Lcom/larus/platform/model/camera/AppImageUploadConfig;", "", "maxCameraShortSize", "", "maxCompressShortSize", "quality", "<init>", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getMaxCameraShortSize", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMaxCompressShortSize", "getQuality", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class b {
    public static final b a = null;
    public static final b b = null;

    @SerializedName("max_camera_short_size")
    private final Integer maxCameraShortSize;

    @SerializedName("max_compress_short_size")
    private final Integer maxCompressShortSize;

    @SerializedName("quality")
    private final Integer quality;

    public static final class a {
    }

    public b() {
        this(0);
    }

    static {
        a = new b(1080, 1080, 95);
        b = new b(1440, 1440, 95);
    }

    public final Integer a() {
        return this.maxCameraShortSize;
    }

    public final Integer b() {
        return this.maxCompressShortSize;
    }

    public final Integer c() {
        return this.quality;
    }

    public /* synthetic */ b(int r3) {
        this(1440, 1080, 95);
    }

    public b(Integer r1, Integer r2, Integer r3) {
        this.maxCameraShortSize = r1;
        this.maxCompressShortSize = r2;
        this.quality = r3;
    }
}
