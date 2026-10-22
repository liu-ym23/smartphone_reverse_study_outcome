package oq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0007HÆ\u0003J;\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011¨\u0006 "}, d2 = {"Lcom/larus/platform/model/camera/MainCameraDetectConfig;", "", "enableDetect", "", "showLoadingThresholdMs", "", "eduDefaultIntentMode", "", "detectTimeoutMs", "imageCompressQuality", "<init>", "(ZJIJI)V", "getEnableDetect", "()Z", "getShowLoadingThresholdMs", "()J", "getEduDefaultIntentMode", "()I", "getDetectTimeoutMs", "getImageCompressQuality", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class j {
    public static final j a = null;
    public static final j b = null;

    @SerializedName("detect_timeout_ms")
    private final long detectTimeoutMs;

    @SerializedName("edu_default_intent_mode")
    private final int eduDefaultIntentMode;

    @SerializedName("enable_detect")
    private final boolean enableDetect;

    @SerializedName("image_compress_quality")
    private final int imageCompressQuality;

    @SerializedName("show_loading_threshold_ms")
    private final long showLoadingThresholdMs;

    public static final class a {
    }

    public j() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof j) == true) goto L8;
        return false;
    L8:
        j r9 = (j) r8;
        if (this.enableDetect == r9.enableDetect) goto L12;
        return false;
    L12:
        if (this.showLoadingThresholdMs == r9.showLoadingThresholdMs) goto L15;
        return false;
    L15:
        if (this.eduDefaultIntentMode == r9.eduDefaultIntentMode) goto L18;
        return false;
    L18:
        if (this.detectTimeoutMs == r9.detectTimeoutMs) goto L21;
        return false;
    L21:
        if (this.imageCompressQuality == r9.imageCompressQuality) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.enableDetect == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.showLoadingThresholdMs;
        int r2 = ((((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31) + this.eduDefaultIntentMode) * 31;
        long r3 = this.detectTimeoutMs;
        return ((r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31) + this.imageCompressQuality;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "MainCameraDetectConfig(enableDetect=" + this.enableDetect + ", showLoadingThresholdMs=" + this.showLoadingThresholdMs + ", eduDefaultIntentMode=" + this.eduDefaultIntentMode + ", detectTimeoutMs=" + this.detectTimeoutMs + ", imageCompressQuality=" + this.imageCompressQuality + ')';
    }

    static {
        a = new j(true, 200, 2, 1000, 70);
        b = new j(0);
    }

    public final long a() {
        return this.detectTimeoutMs;
    }

    public final int b() {
        return this.eduDefaultIntentMode;
    }

    public final boolean c() {
        return this.enableDetect;
    }

    public final int d() {
        return this.imageCompressQuality;
    }

    public final long e() {
        return this.showLoadingThresholdMs;
    }

    public /* synthetic */ j(int r9) {
        this(false, 200, 0, 5000, 70);
    }

    public j(boolean r1, long r2, int r4, long r5, int r7) {
        this.enableDetect = r1;
        this.showLoadingThresholdMs = r2;
        this.eduDefaultIntentMode = r4;
        this.detectTimeoutMs = r5;
        this.imageCompressQuality = r7;
    }
}
