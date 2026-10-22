package ay1;

import com.bytedance.bdlocation.BuildConfig;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0007¢\u0006\u0004\b\b\u0010\tR\u0016\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0016\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lay1/a;", BuildConfig.FLAVOR, BuildConfig.FLAVOR, "hasAudienceAuthSwitch", "Z", BuildConfig.FLAVOR, "authSwitch", "J", "<init>", "()V", "a", "liveui_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("auth_switch")
    public long authSwitch;

    @SerializedName("has_audience_auth_switch")
    public boolean hasAudienceAuthSwitch;

    /* JADX INFO: renamed from: ay1.a$a, reason: collision with other inner class name */
    public static final class C0003a {
    }

    static {
    }

    public a() {
        this.authSwitch = 2;
    }
}
