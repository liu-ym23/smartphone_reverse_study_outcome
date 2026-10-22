package bu9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0012\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0006HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/larus/settings/provider/camera/CameraRecordVideoEncodeSettings;", "", "supportHWEnc", "", "enableRecordingMp4", "encodeStandard", "", "fps", "<init>", "(ZZII)V", "getSupportHWEnc", "()Z", "getEnableRecordingMp4", "getEncodeStandard", "()I", "getFps", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class o {

    @SerializedName("enable_recording_mp4")
    private final boolean enableRecordingMp4;

    @SerializedName("encode_standard")
    private final int encodeStandard;

    @SerializedName("fps")
    private final int fps;

    @SerializedName("support_hw_enc")
    private final boolean supportHWEnc;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof o) == true) goto L8;
        return false;
    L8:
        o r6 = (o) r5;
        if (this.supportHWEnc == r6.supportHWEnc) goto L12;
        return false;
    L12:
        if (this.enableRecordingMp4 == r6.enableRecordingMp4) goto L15;
        return false;
    L15:
        if (this.encodeStandard == r6.encodeStandard) goto L18;
        return false;
    L18:
        if (this.fps == r6.fps) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r1 = 1231;
        if (this.supportHWEnc == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.enableRecordingMp4 == true) goto L11;
        r1 = 1237;
    L11:
        return ((((r2 + r1) * 31) + this.encodeStandard) * 31) + this.fps;
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "CameraRecordVideoEncodeSettings(supportHWEnc=" + this.supportHWEnc + ", enableRecordingMp4=" + this.enableRecordingMp4 + ", encodeStandard=" + this.encodeStandard + ", fps=" + this.fps + ')';
    }

    public o() {
        this.supportHWEnc = true;
        this.enableRecordingMp4 = true;
        this.encodeStandard = 1;
        this.fps = 30;
    }

    public final boolean a() {
        return this.enableRecordingMp4;
    }

    public final int b() {
        return this.encodeStandard;
    }

    public final int c() {
        return this.fps;
    }

    public final boolean d() {
        return this.supportHWEnc;
    }
}
