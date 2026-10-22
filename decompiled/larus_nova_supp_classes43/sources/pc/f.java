package pc;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0019\u0010\u001aR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR.\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\t8\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R(\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lpc/f;", "", "", "scope", "Ljava/lang/String;", "getScope", "()Ljava/lang/String;", "setScope", "(Ljava/lang/String;)V", "", "Lpc/a;", "bcmAllowParamKeys", "Ljava/util/Map;", "a", "()Ljava/util/Map;", "setBcmAllowParamKeys", "(Ljava/util/Map;)V", "", "Lpc/b;", "bcmEventConfig", "Ljava/util/List;", "b", "()Ljava/util/List;", "setBcmEventConfig", "(Ljava/util/List;)V", "<init>", "()V", "bcm-impl-v2_cnRelease"}, k = 1, mv = {1, 4, 0})
public final class f {

    @SerializedName("bcm_allowlist")
    private Map<String, a> bcmAllowParamKeys;

    @SerializedName("bcm_event_config")
    private List<b> bcmEventConfig;

    @SerializedName("scope")
    private String scope;

    public f() {
        this.scope = "";
        this.bcmAllowParamKeys = MapsKt.emptyMap();
        this.bcmEventConfig = CollectionsKt.emptyList();
    }

    public final Map<String, a> a() {
        return this.bcmAllowParamKeys;
    }

    public final List<b> b() {
        return this.bcmEventConfig;
    }
}
