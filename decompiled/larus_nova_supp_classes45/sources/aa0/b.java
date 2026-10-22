package aa0;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u001a\u0010\u001bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0011\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0017\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0017\u0010\u0004\u001a\u0004\b\u0018\u0010\u0006\"\u0004\b\u0019\u0010\b¨\u0006\u001c"}, d2 = {"Laa0/b;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "size", "I", "c", "()I", "setSize", "(I)V", "", "skipTimeThreshold", "J", "d", "()J", "setSkipTimeThreshold", "(J)V", "logEnable", "b", "setLogEnable", "<init>", "()V", "livefeature-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("log_enable")
    private boolean logEnable;

    @SerializedName("feats_count")
    private int size;

    @SerializedName("skip_time_threshold")
    private long skipTimeThreshold;

    public b() {
        this.enable = true;
        this.size = 50;
        this.skipTimeThreshold = 10000;
        this.logEnable = true;
    }

    public final boolean a() {
        return this.enable;
    }

    public final boolean b() {
        return this.logEnable;
    }

    public final int c() {
        return this.size;
    }

    public final long d() {
        return this.skipTimeThreshold;
    }
}
