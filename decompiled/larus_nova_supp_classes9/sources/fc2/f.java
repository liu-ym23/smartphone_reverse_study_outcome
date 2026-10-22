package fc2;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0003\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001a\u0010\u0007\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001a\u0010\n\u001a\u00020\t8\u0006X\u0087D¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u00028\u0006X\u0087D¢\u0006\f\n\u0004\b\u000e\u0010\u0004\u001a\u0004\b\u000f\u0010\u0006¨\u0006\u0012"}, d2 = {"Lfc2/f;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "enable", "Z", "b", "()Z", "enableLandscape", "c", BuildConfig.FLAVOR, "checkDuration", "I", "a", "()I", "enableTargetCheck", "d", "<init>", "()V", "interactivity-platform-base_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("check_duration")
    private final int checkDuration;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("enable_landscape")
    private final boolean enableLandscape;

    @SerializedName("enable_target_check")
    private final boolean enableTargetCheck;

    public f() {
        this.checkDuration = 200;
    }

    public final int a() {
        return this.checkDuration;
    }

    public final boolean b() {
        return this.enable;
    }

    public final boolean c() {
        return this.enableLandscape;
    }

    public final boolean d() {
        return this.enableTargetCheck;
    }
}
