package com.larus.settings.provider.bootprotector;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BM\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J!\u0010\u001a\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\bHÆ\u0003JT\u0010\u001b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052 \b\u0002\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001cJ\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\tHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R.\u0010\u0007\u001a\u001a\u0012\u0004\u0012\u00020\t\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u000b\u0018\u00010\n\u0018\u00010\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lcom/larus/settings/provider/bootprotector/BootProtectorSilentCleanConfig;", "", "silentCleanEnable", "", "minUpdateVersionCode", "", "maxUpdateVersionCode", "crashCountToStrategiesMapConfig", "", "", "", "Lcom/larus/settings/provider/bootprotector/PreciseFixStategy;", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)V", "getSilentCleanEnable", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getMinUpdateVersionCode", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getMaxUpdateVersionCode", "getCrashCountToStrategiesMapConfig", "()Ljava/util/Map;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Boolean;Ljava/lang/Long;Ljava/lang/Long;Ljava/util/Map;)Lcom/larus/settings/provider/bootprotector/BootProtectorSilentCleanConfig;", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class BootProtectorSilentCleanConfig {

    @SerializedName("crash_count_to_strategy_map_config")
    private final Map<String, List<PreciseFixStategy>> crashCountToStrategiesMapConfig;

    @SerializedName("max_update_version_code")
    private final Long maxUpdateVersionCode;

    @SerializedName("min_update_version_code")
    private final Long minUpdateVersionCode;

    @SerializedName("silent_clean_enable")
    private final Boolean silentCleanEnable;

    public BootProtectorSilentCleanConfig() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ BootProtectorSilentCleanConfig copy$default(BootProtectorSilentCleanConfig r0, Boolean r1, Long r2, Long r3, Map r4, int r5, Object r6) {
        if ((r5 & 1) == 0) goto L6;
        r1 = r0.silentCleanEnable;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r2 = r0.minUpdateVersionCode;
    L9:
        if ((r5 & 4) == 0) goto L12;
        r3 = r0.maxUpdateVersionCode;
    L12:
        if ((r5 & 8) == 0) goto L15;
        r4 = r0.crashCountToStrategiesMapConfig;
    L15:
        return r0.copy(r1, r2, r3, r4);
    }

    public final Boolean component1() {
        return this.silentCleanEnable;
    }

    public final Long component2() {
        return this.minUpdateVersionCode;
    }

    public final Long component3() {
        return this.maxUpdateVersionCode;
    }

    public final Map<String, List<PreciseFixStategy>> component4() {
        return this.crashCountToStrategiesMapConfig;
    }

    public final BootProtectorSilentCleanConfig copy(Boolean r2, Long r3, Long r4, Map<String, ? extends List<PreciseFixStategy>> r5) {
        return new BootProtectorSilentCleanConfig(r2, r3, r4, r5);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof BootProtectorSilentCleanConfig) == true) goto L8;
        return false;
    L8:
        BootProtectorSilentCleanConfig r6 = (BootProtectorSilentCleanConfig) r5;
        if (Intrinsics.areEqual(this.silentCleanEnable, r6.silentCleanEnable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.minUpdateVersionCode, r6.minUpdateVersionCode) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.maxUpdateVersionCode, r6.maxUpdateVersionCode) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.crashCountToStrategiesMapConfig, r6.crashCountToStrategiesMapConfig) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.silentCleanEnable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Long r4 = this.minUpdateVersionCode;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Long r7 = this.maxUpdateVersionCode;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Map<String, List<PreciseFixStategy>> r10 = this.crashCountToStrategiesMapConfig;
        if (r10 == null) goto L19;
        r1 = r10.hashCode();
    L19:
        return r9 + r1;
    L13:
        r8 = r7.hashCode();
        goto L14
    L9:
        r5 = r4.hashCode();
        goto L10
    L5:
        r2 = r0.hashCode();
        goto L6
    }

    public String toString() {
        return "BootProtectorSilentCleanConfig(silentCleanEnable=" + this.silentCleanEnable + ", minUpdateVersionCode=" + this.minUpdateVersionCode + ", maxUpdateVersionCode=" + this.maxUpdateVersionCode + ", crashCountToStrategiesMapConfig=" + this.crashCountToStrategiesMapConfig + ')';
    }

    public final Map<String, List<PreciseFixStategy>> getCrashCountToStrategiesMapConfig() {
        return this.crashCountToStrategiesMapConfig;
    }

    public final Long getMaxUpdateVersionCode() {
        return this.maxUpdateVersionCode;
    }

    public final Long getMinUpdateVersionCode() {
        return this.minUpdateVersionCode;
    }

    public final Boolean getSilentCleanEnable() {
        return this.silentCleanEnable;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BootProtectorSilentCleanConfig(Boolean r1, Long r2, Long r3, Map<String, ? extends List<PreciseFixStategy>> r4) {
        this.silentCleanEnable = r1;
        this.minUpdateVersionCode = r2;
        this.maxUpdateVersionCode = r3;
        this.crashCountToStrategiesMapConfig = r4;
    }

    public /* synthetic */ BootProtectorSilentCleanConfig(Boolean r3, Long r4, Long r5, Map r6, int r7, DefaultConstructorMarker r8) {
        if ((r7 & 1) == 0) goto L6;
        r3 = Boolean.FALSE;
    L6:
        if ((r7 & 2) == 0) goto L9;
        r4 = 0L;
    L9:
        if ((r7 & 4) == 0) goto L12;
        r5 = 0L;
    L12:
        if ((r7 & 8) == 0) goto L14;
        r6 = MapsKt.emptyMap();
    L14:
        this(r3, r4, r5, r6);
    }
}
