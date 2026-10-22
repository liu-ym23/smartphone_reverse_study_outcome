package ot9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J'\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/larus/settings/opt/CognitiveConfig;", "", "cameraFirstFrameDelay", "", "albumFirstFrameDelay", "sendMessageRenderDelay", "<init>", "(JJJ)V", "getCameraFirstFrameDelay", "()J", "getAlbumFirstFrameDelay", "getSendMessageRenderDelay", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class d {

    @SerializedName("album_first_frame_delay")
    private final long albumFirstFrameDelay;

    @SerializedName("camera_first_frame_delay")
    private final long cameraFirstFrameDelay;

    @SerializedName("send_message_render_delay")
    private final long sendMessageRenderDelay;

    public d() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof d) == true) goto L8;
        return false;
    L8:
        d r9 = (d) r8;
        if (this.cameraFirstFrameDelay == r9.cameraFirstFrameDelay) goto L12;
        return false;
    L12:
        if (this.albumFirstFrameDelay == r9.albumFirstFrameDelay) goto L15;
        return false;
    L15:
        if (this.sendMessageRenderDelay == r9.sendMessageRenderDelay) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        long r0 = this.cameraFirstFrameDelay;
        int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
        long r3 = this.albumFirstFrameDelay;
        int r2 = (r1 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r4 = this.sendMessageRenderDelay;
        return r2 + ((int) (r4 ^ (r4 >>> 32)));
    }

    public final String toString() {
        return "CognitiveConfig(cameraFirstFrameDelay=" + this.cameraFirstFrameDelay + ", albumFirstFrameDelay=" + this.albumFirstFrameDelay + ", sendMessageRenderDelay=" + this.sendMessageRenderDelay + ')';
    }

    public final long a() {
        return this.albumFirstFrameDelay;
    }

    public final long b() {
        return this.cameraFirstFrameDelay;
    }

    public final long c() {
        return this.sendMessageRenderDelay;
    }

    public d(int r3) {
        this.cameraFirstFrameDelay = 0;
        this.albumFirstFrameDelay = 0;
        this.sendMessageRenderDelay = 0;
    }
}
