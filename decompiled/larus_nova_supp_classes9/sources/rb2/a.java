package rb2;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import java.util.Map;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\r\u0010\u000eR0\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR0\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\u000f"}, d2 = {"Lrb2/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, BuildConfig.FLAVOR, "fansClubDowngrade", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setFansClubDowngrade", "(Ljava/util/Map;)V", "honorLevelDowngrade", "b", "setHonorLevelDowngrade", "<init>", "()V", "community-service_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("live_user_enter_fansclub_downgrade")
    private Map<String, String> fansClubDowngrade;

    @SerializedName("live_user_enter_grade_downgrade")
    private Map<String, String> honorLevelDowngrade;

    public a() {
    }

    public final Map<String, String> a() {
        return this.fansClubDowngrade;
    }

    public final Map<String, String> b() {
        return this.honorLevelDowngrade;
    }
}
