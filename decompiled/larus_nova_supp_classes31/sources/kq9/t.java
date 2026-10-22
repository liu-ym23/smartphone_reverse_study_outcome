package kq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001B[\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000b\u0010\fR\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0010\u0010\u000eR\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0016\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/larus/platform/model/album/PreprocessAlbumImgOptConfig;", "", "enable", "", "enableAlbumWebpOutput", "enableCameraWebpOutput", "minSizeToCompress", "", "useImageXWebpEncoder", "webpEncodeSpeed", "enableEduWebpOutput", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableAlbumWebpOutput", "getEnableCameraWebpOutput", "getMinSizeToCompress", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getUseImageXWebpEncoder", "getWebpEncodeSpeed", "getEnableEduWebpOutput", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class t {

    @SerializedName("enable")
    private final Boolean enable;

    @SerializedName("enable_album_webp_output")
    private final Boolean enableAlbumWebpOutput;

    @SerializedName("enable_camera_webp_output")
    private final Boolean enableCameraWebpOutput;

    @SerializedName("enable_edu_webp_output")
    private final Boolean enableEduWebpOutput;

    @SerializedName("min_size_to_compress")
    private final Integer minSizeToCompress;

    @SerializedName("use_imagex_webp_encoder")
    private final Boolean useImageXWebpEncoder;

    @SerializedName("webp_encode_speed")
    private final Integer webpEncodeSpeed;

    public t() {
        this(0);
    }

    public final Boolean a() {
        return this.enable;
    }

    public final Boolean b() {
        return this.enableAlbumWebpOutput;
    }

    public final Boolean c() {
        return this.enableCameraWebpOutput;
    }

    public final Boolean d() {
        return this.enableEduWebpOutput;
    }

    public final Integer e() {
        return this.minSizeToCompress;
    }

    public final Boolean f() {
        return this.useImageXWebpEncoder;
    }

    public final Integer g() {
        return this.webpEncodeSpeed;
    }

    public t(int r2) {
        Boolean r3 = Boolean.FALSE;
        this.enable = r3;
        this.enableAlbumWebpOutput = r3;
        this.enableCameraWebpOutput = r3;
        this.minSizeToCompress = null;
        this.useImageXWebpEncoder = r3;
        this.webpEncodeSpeed = null;
        this.enableEduWebpOutput = r3;
    }
}
