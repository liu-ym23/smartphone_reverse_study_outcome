package nu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000f"}, d2 = {"Lcom/larus/settings/provider/dora/MediaPostProcessConfig;", "", "enableVideoFeature", "", "imageFaceSr", "videoPowerMode", "", "<init>", "(ZZI)V", "getEnableVideoFeature", "()Z", "getImageFaceSr", "getVideoPowerMode", "()I", "Companion", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class x {

    @SerializedName("enable_video_feature")
    private final boolean enableVideoFeature;

    @SerializedName("image_face_sr")
    private final boolean imageFaceSr;

    @SerializedName("video_power_mode")
    private final int videoPowerMode;

    public static final class a {
    }

    static {
    }

    public x() {
        this(0);
    }

    public final boolean a() {
        return this.enableVideoFeature;
    }

    public final boolean b() {
        return this.imageFaceSr;
    }

    public final int c() {
        return this.videoPowerMode;
    }

    public x(int r1) {
        this.enableVideoFeature = true;
        this.imageFaceSr = true;
        this.videoPowerMode = 1;
    }
}
