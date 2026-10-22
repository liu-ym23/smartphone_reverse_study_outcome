package o72;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\b\u001a\u00020\u00078\u0006X\u0087D¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\r\u001a\u00020\f8\u0006X\u0087D¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0012\u0010\u0006¨\u0006\u0015"}, d2 = {"Lo72/e;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enableOtp", "Z", "a", "()Z", BuildConfig.FLAVOR, "refreshDuration", "J", "d", "()J", BuildConfig.FLAVOR, "refreshCount", "I", "c", "()I", "enablePreLoad", "b", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class e {

    @SerializedName("enable_refresh_enter_room_optimize_android")
    private final boolean enableOtp;

    @SerializedName("enable_pre_load")
    private final boolean enablePreLoad;

    @SerializedName("refresh_list_msg_count_android")
    private final int refreshCount;

    @SerializedName("refresh_list_time_duration_android")
    private final long refreshDuration;

    public e() {
        this.enableOtp = true;
        this.refreshDuration = 600;
        this.refreshCount = 1;
        this.enablePreLoad = true;
    }

    public final boolean a() {
        return this.enableOtp;
    }

    public final boolean b() {
        return this.enablePreLoad;
    }

    public final int c() {
        return this.refreshCount;
    }

    public final long d() {
        return this.refreshDuration;
    }
}
