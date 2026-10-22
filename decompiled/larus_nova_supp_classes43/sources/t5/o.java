package t5;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001b\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000e¢\u0006\u0004\b\u0010\u0010\u0011J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0007HÆ\u0003J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\t\u0010\"\u001a\u00020\u0007HÆ\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\u0015\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0003Ja\u0010%\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00072\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\u0014\b\u0002\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000eHÆ\u0001J\u0013\u0010&\u001a\u00020\u00032\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\u0005HÖ\u0001J\t\u0010)\u001a\u00020\fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0016\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\"\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u000f0\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/bytedance/ai/settings/provider/RateLimitSettings;", "", "enabled", "", "globalMaxCount", "", "globalWindowMs", "", "perMethodMaxCount", "perMethodWindowMs", "exemptMethods", "", "", "methodOverrides", "", "Lcom/bytedance/ai/settings/provider/MethodRateLimitOverride;", "<init>", "(ZIJIJLjava/util/List;Ljava/util/Map;)V", "getEnabled", "()Z", "getGlobalMaxCount", "()I", "getGlobalWindowMs", "()J", "getPerMethodMaxCount", "getPerMethodWindowMs", "getExemptMethods", "()Ljava/util/List;", "getMethodOverrides", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "ai-sdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class o {

    @SerializedName("enabled")
    private final boolean enabled;

    @SerializedName("exempt_methods")
    private final List<String> exemptMethods;

    @SerializedName("global_max_count")
    private final int globalMaxCount;

    @SerializedName("global_window_ms")
    private final long globalWindowMs;

    @SerializedName("method_overrides")
    private final Map<String, k> methodOverrides;

    @SerializedName("per_method_max_count")
    private final int perMethodMaxCount;

    @SerializedName("per_method_window_ms")
    private final long perMethodWindowMs;

    public o() {
        this(null);
    }

    public final boolean equals(Object r10) {
        if (this != r10) goto L6;
        return true;
    L6:
        if ((r10 instanceof o) == true) goto L8;
        return false;
    L8:
        o r11 = (o) r10;
        if (this.enabled == r11.enabled) goto L12;
        return false;
    L12:
        if (this.globalMaxCount == r11.globalMaxCount) goto L15;
        return false;
    L15:
        if (this.globalWindowMs == r11.globalWindowMs) goto L18;
        return false;
    L18:
        if (this.perMethodMaxCount == r11.perMethodMaxCount) goto L21;
        return false;
    L21:
        if (this.perMethodWindowMs == r11.perMethodWindowMs) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.exemptMethods, r11.exemptMethods) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.methodOverrides, r11.methodOverrides) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        if (this.enabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r1 = ((r0 * 31) + this.globalMaxCount) * 31;
        long r10 = this.globalWindowMs;
        int r11 = (((r1 + ((int) (r10 ^ (r10 >>> 32)))) * 31) + this.perMethodMaxCount) * 31;
        long r12 = this.perMethodWindowMs;
        return ((((r11 + ((int) (r12 ^ (r12 >>> 32)))) * 31) + this.exemptMethods.hashCode()) * 31) + this.methodOverrides.hashCode();
    L5:
        r0 = 1237;
        goto L6
    }

    public final String toString() {
        return "RateLimitSettings(enabled=" + this.enabled + ", globalMaxCount=" + this.globalMaxCount + ", globalWindowMs=" + this.globalWindowMs + ", perMethodMaxCount=" + this.perMethodMaxCount + ", perMethodWindowMs=" + this.perMethodWindowMs + ", exemptMethods=" + this.exemptMethods + ", methodOverrides=" + this.methodOverrides + ')';
    }

    public final boolean a() {
        return this.enabled;
    }

    public final List<String> b() {
        return this.exemptMethods;
    }

    public final int c() {
        return this.globalMaxCount;
    }

    public final long d() {
        return this.globalWindowMs;
    }

    public final Map<String, k> e() {
        return this.methodOverrides;
    }

    public final int f() {
        return this.perMethodMaxCount;
    }

    public final long g() {
        return this.perMethodWindowMs;
    }

    public o(Object r10) {
        List<String> r11 = CollectionsKt.emptyList();
        Map<String, k> r0 = MapsKt.emptyMap();
        Intrinsics.checkNotNullParameter(r11, "exemptMethods");
        Intrinsics.checkNotNullParameter(r0, "methodOverrides");
        this.enabled = false;
        this.globalMaxCount = 200;
        this.globalWindowMs = 1000;
        this.perMethodMaxCount = 50;
        this.perMethodWindowMs = 1000;
        this.exemptMethods = r11;
        this.methodOverrides = r0;
    }
}
