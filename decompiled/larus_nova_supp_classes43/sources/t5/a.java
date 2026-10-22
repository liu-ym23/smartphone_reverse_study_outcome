package t5;

import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.larus.utils.gson.FilterNonNullTypeAdapterFactory;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/bytedance/ai/settings/provider/AIBridgeSettingsConfig;", "", "<init>", "()V", "mustRunInMainJsbList", "", "", "getMustRunInMainJsbList", "()Ljava/util/List;", "rateLimit", "Lcom/bytedance/ai/settings/provider/RateLimitSettings;", "getRateLimit", "()Lcom/bytedance/ai/settings/provider/RateLimitSettings;", "mtsJsbAllowList", "Lcom/bytedance/ai/settings/provider/MtsAllowListSettings;", "getMtsJsbAllowList", "()Lcom/bytedance/ai/settings/provider/MtsAllowListSettings;", "additionalAllowedMethods", "getAdditionalAllowedMethods", "additionalAllowedAppletIds", "getAdditionalAllowedAppletIds", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class a {

    @SerializedName("additional_allowed_applet_ids")
    private final List<String> additionalAllowedAppletIds;

    @SerializedName("additional_allowed_methods")
    private final List<String> additionalAllowedMethods;

    @SerializedName("mts_jsb_allow_list")
    private final l mtsJsbAllowList;

    @SerializedName("must_run_in_main_jsb_list")
    @JsonAdapter(FilterNonNullTypeAdapterFactory.class)
    private final List<String> mustRunInMainJsbList;

    @SerializedName("rate_limit")
    private final o rateLimit;

    public a() {
        this.mustRunInMainJsbList = CollectionsKt.listOf("x.getAppInfo");
    }

    public final List<String> a() {
        return this.additionalAllowedAppletIds;
    }

    public final List<String> b() {
        return this.additionalAllowedMethods;
    }

    public final l c() {
        return this.mtsJsbAllowList;
    }

    public final List<String> d() {
        return this.mustRunInMainJsbList;
    }

    public final o e() {
        return this.rateLimit;
    }
}
