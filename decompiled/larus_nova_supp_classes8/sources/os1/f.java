package os1;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\"\u0010\f\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u0011"}, d2 = {"Los1/f;", "", "", "enableService", "Z", "b", "()Z", "setEnableService", "(Z)V", "enableFollowService", "a", "setEnableFollowService", "enableUVService", "c", "setEnableUVService", "<init>", "()V", "infrastructure_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class f {

    @SerializedName("enable_follow_service")
    private boolean enableFollowService;

    @SerializedName("enable_service")
    private boolean enableService;

    @SerializedName("enable_uv_service")
    private boolean enableUVService;

    public f() {
    }

    public final boolean a() {
        return this.enableFollowService;
    }

    public final boolean b() {
        return this.enableService;
    }

    public final boolean c() {
        return this.enableUVService;
    }
}
