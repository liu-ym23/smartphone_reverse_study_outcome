package qt9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J;\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u001e"}, d2 = {"Lcom/larus/settings/provider/SoundAppeaseConfig;", "", "enable", "", "normalInterval", "", "radioInterval", "minPlayingTime", "gFeedBackTime", "<init>", "(ZJJJJ)V", "getEnable", "()Z", "getNormalInterval", "()J", "getRadioInterval", "getMinPlayingTime", "getGFeedBackTime", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class h4 {

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("g_feed_back_time")
    private final long gFeedBackTime;

    @SerializedName("min_playing_time")
    private final long minPlayingTime;

    @SerializedName("normal_interval")
    private final long normalInterval;

    @SerializedName("radio_interval")
    private final long radioInterval;

    public h4() {
        this(0);
    }

    public final boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof h4) == true) goto L8;
        return false;
    L8:
        h4 r9 = (h4) r8;
        if (this.enable == r9.enable) goto L12;
        return false;
    L12:
        if (this.normalInterval == r9.normalInterval) goto L15;
        return false;
    L15:
        if (this.radioInterval == r9.radioInterval) goto L18;
        return false;
    L18:
        if (this.minPlayingTime == r9.minPlayingTime) goto L21;
        return false;
    L21:
        if (this.gFeedBackTime == r9.gFeedBackTime) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.normalInterval;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.radioInterval;
        int r4 = (r2 + ((int) (r3 ^ (r3 >>> 32)))) * 31;
        long r5 = this.minPlayingTime;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.gFeedBackTime;
        return r6 + ((int) (r7 ^ (r7 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "SoundAppeaseConfig(enable=" + this.enable + ", normalInterval=" + this.normalInterval + ", radioInterval=" + this.radioInterval + ", minPlayingTime=" + this.minPlayingTime + ", gFeedBackTime=" + this.gFeedBackTime + ')';
    }

    public final boolean a() {
        return this.enable;
    }

    public final long b() {
        return this.gFeedBackTime;
    }

    public final long c() {
        return this.minPlayingTime;
    }

    public final long d() {
        return this.normalInterval;
    }

    public final long e() {
        return this.radioInterval;
    }

    public h4(int r3) {
        this.enable = true;
        this.normalInterval = 2500;
        this.radioInterval = 2500;
        this.minPlayingTime = 750;
        this.gFeedBackTime = 1000;
    }
}
