package vz;

import com.google.gson.annotations.SerializedName;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b/\u00100R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0004\u001a\u0004\b\b\u0010\u0006R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0004\u001a\u0004\b\n\u0010\u0006R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\u0004\u001a\u0004\b\f\u0010\u0006R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\u0016R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\r8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0017\u0010\u000f\u001a\u0004\b\u0018\u0010\u0011R\"\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0019\u0010\u0014\u001a\u0004\b\u001a\u0010\u0016R\"\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001b\u0010\u0014\u001a\u0004\b\u001c\u0010\u0016R\"\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u001d\u0010\u0014\u001a\u0004\b\u001e\u0010\u0016R(\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u001f8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\"\u0010#R\u001c\u0010$\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b$\u0010\u0004\u001a\u0004\b%\u0010\u0006R\u001c\u0010&\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b&\u0010\u0004\u001a\u0004\b'\u0010\u0006R\u001c\u0010)\u001a\u0004\u0018\u00010(8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b+\u0010,R\u001c\u0010-\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b-\u0010\u0004\u001a\u0004\b.\u0010\u0006¨\u00061"}, d2 = {"Lvz/a;", "", "", "policyId", "Ljava/lang/String;", "getPolicyId", "()Ljava/lang/String;", "policyName", "getPolicyName", "owner", "getOwner", "description", "getDescription", "", "priority", "Ljava/lang/Integer;", "getPriority", "()Ljava/lang/Integer;", "", "resource", "Ljava/util/Set;", "getResource", "()Ljava/util/Set;", "intent", "getIntent", "role", "getRole", "businessSource", "getBusinessSource", "apiSource", "getApiSource", "", "conditions", "Ljava/util/Map;", "getConditions", "()Ljava/util/Map;", "excludeBusinessSource", "getExcludeBusinessSource", "excludeApiSource", "getExcludeApiSource", "", "permission", "Ljava/lang/Boolean;", "getPermission", "()Ljava/lang/Boolean;", "reason", "getReason", "<init>", "()V", "livebroadcast-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("apiSource")
    private final Set<String> apiSource;

    @SerializedName("businessSource")
    private final Set<String> businessSource;

    @SerializedName("conditions")
    private final Map<String, String> conditions;

    @SerializedName("description")
    private final String description;

    @SerializedName("excludeApiSource")
    private final String excludeApiSource;

    @SerializedName("excludeBusinessSource")
    private final String excludeBusinessSource;

    @SerializedName("intent")
    private final Integer intent;

    @SerializedName("owner")
    private final String owner;

    @SerializedName("permission")
    private final Boolean permission;

    @SerializedName("policyId")
    private final String policyId;

    @SerializedName("policyName")
    private final String policyName;

    @SerializedName("priority")
    private final Integer priority;

    @SerializedName("reason")
    private final String reason;

    @SerializedName("resource")
    private final Set<Integer> resource;

    @SerializedName("role")
    private final Set<Integer> role;

    public a() {
    }
}
