package oq1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006¨\u0006\t"}, d2 = {"Loq1/d;", "", "", "timerInterval", "J", "b", "()J", "testTempDuration", "a", "vs-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class d {

    @SerializedName("test_temp_watch_duration")
    private final long testTempDuration;

    @SerializedName("timer_interval")
    private final long timerInterval;

    public d() {
        this.timerInterval = 30;
        this.testTempDuration = -1;
    }

    public final long a() {
        return this.testTempDuration;
    }

    public final long b() {
        return this.timerInterval;
    }
}
