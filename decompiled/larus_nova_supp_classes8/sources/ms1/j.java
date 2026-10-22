package ms1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0015\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001c\u0010\u001dR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\"\u0010\u0013\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u000b\u001a\u0004\b\u0014\u0010\r\"\u0004\b\u0015\u0010\u000fR\"\u0010\u0016\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0017\u0010\r\"\u0004\b\u0018\u0010\u000fR\"\u0010\u0019\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0019\u0010\u000b\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000f¨\u0006\u001e"}, d2 = {"Lms1/j;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "delayTime", "I", "getDelayTime", "()I", "setDelayTime", "(I)V", "sampleSize", "d", "setSampleSize", "initialDelay", "b", "setInitialDelay", "times", "e", "setTimes", "internalTime", "c", "setInternalTime", "<init>", "()V", "liveutility_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class j {

    @SerializedName("delay_time")
    private int delayTime;

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("initial_delay")
    private int initialDelay;

    @SerializedName("internal_time")
    private int internalTime;

    @SerializedName("sample_size")
    private int sampleSize;

    @SerializedName("times")
    private int times;

    public j() {
        this.delayTime = 10;
        this.sampleSize = 5;
        this.initialDelay = 5;
        this.times = 3;
        this.internalTime = 5;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.initialDelay;
    }

    public final int c() {
        return this.internalTime;
    }

    public final int d() {
        return this.sampleSize;
    }

    public final int e() {
        return this.times;
    }
}
