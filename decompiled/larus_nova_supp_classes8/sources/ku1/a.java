package ku1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0010\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0010\u0010\u000b\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000f¨\u0006\u0015"}, d2 = {"Lku1/a;", "", "", "enable", "Z", "a", "()Z", "setEnable", "(Z)V", "", "maxRunningCount", "I", "c", "()I", "setMaxRunningCount", "(I)V", "maxRunTimes", "b", "setMaxRunTimes", "<init>", "()V", "dynamicstrategy-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("enable")
    private boolean enable;

    @SerializedName("cep_run_times_max")
    private int maxRunTimes;

    @SerializedName("cep_running_max_count")
    private int maxRunningCount;

    public a() {
        this.enable = true;
        this.maxRunningCount = 3;
        this.maxRunTimes = 20;
    }

    public final boolean a() {
        return this.enable;
    }

    public final int b() {
        return this.maxRunTimes;
    }

    public final int c() {
        return this.maxRunningCount;
    }
}
