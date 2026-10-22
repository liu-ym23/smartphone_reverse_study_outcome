package com.larus.settings.performance;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b¢\u0006\u0004\b\r\u0010\u000eJ\u000e\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\fJ\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0019\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0003JW\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0018\b\u0002\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000bHÆ\u0001J\u0013\u0010\"\u001a\u00020\u00032\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020%HÖ\u0001J\t\u0010&\u001a\u00020\fHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R&\u0010\n\u001a\u0012\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\t\u0018\u00010\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018¨\u0006'"}, d2 = {"Lcom/larus/settings/performance/SystemBatteryRecorderConfig;", "", "slardarReportEnabled", "", "teaReportEnabled", "galvanicAvgMinReportDurationMillis", "", "batteryPollIntervalMillis", "sceneDefaultConfig", "Lcom/larus/settings/performance/SceneBatteryRecorderConfig;", "sceneConfigMap", "", "", "<init>", "(ZZJJLcom/larus/settings/performance/SceneBatteryRecorderConfig;Ljava/util/Map;)V", "getSlardarReportEnabled", "()Z", "getTeaReportEnabled", "getGalvanicAvgMinReportDurationMillis", "()J", "getBatteryPollIntervalMillis", "getSceneDefaultConfig", "()Lcom/larus/settings/performance/SceneBatteryRecorderConfig;", "getSceneConfigMap", "()Ljava/util/Map;", "getSceneConfig", "scene", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SystemBatteryRecorderConfig {

    @SerializedName("battery_poll_interval_millis")
    private final long batteryPollIntervalMillis;

    @SerializedName("galvanic_avg_min_report_duration_millis")
    private final long galvanicAvgMinReportDurationMillis;

    @SerializedName("scene_config_map")
    private final Map<String, SceneBatteryRecorderConfig> sceneConfigMap;

    @SerializedName("scene_default_config")
    private final SceneBatteryRecorderConfig sceneDefaultConfig;

    @SerializedName("slardar_report_enabled")
    private final boolean slardarReportEnabled;

    @SerializedName("tea_report_enabled")
    private final boolean teaReportEnabled;

    public SystemBatteryRecorderConfig() {
        this(false, false, 0, 0, null, null, 63, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ SystemBatteryRecorderConfig copy$default(SystemBatteryRecorderConfig r9, boolean r10, boolean r11, long r12, long r14, SceneBatteryRecorderConfig r16, Map r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = r9.slardarReportEnabled;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r2 = r9.teaReportEnabled;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r3 = r9.galvanicAvgMinReportDurationMillis;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r5 = r9.batteryPollIntervalMillis;
    L19:
        if ((r18 & 16) == 0) goto L21;
        SceneBatteryRecorderConfig r7 = r9.sceneDefaultConfig;
    L23:
        if ((r18 & 32) == 0) goto L25;
        Map r8 = r9.sceneConfigMap;
    L27:
        return r9.copy(r1, r2, r3, r5, r7, r8);
    L25:
        r8 = r17;
        goto L27
    L21:
        r7 = r16;
        goto L23
    L17:
        r5 = r14;
        goto L19
    L13:
        r3 = r12;
        goto L15
    L9:
        r2 = r11;
        goto L11
    L5:
        r1 = r10;
        goto L7
    }

    public final boolean component1() {
        return this.slardarReportEnabled;
    }

    public final boolean component2() {
        return this.teaReportEnabled;
    }

    public final long component3() {
        return this.galvanicAvgMinReportDurationMillis;
    }

    public final long component4() {
        return this.batteryPollIntervalMillis;
    }

    public final SceneBatteryRecorderConfig component5() {
        return this.sceneDefaultConfig;
    }

    public final Map<String, SceneBatteryRecorderConfig> component6() {
        return this.sceneConfigMap;
    }

    public final SystemBatteryRecorderConfig copy(boolean r11, boolean r12, long r13, long r15, SceneBatteryRecorderConfig r17, Map<String, SceneBatteryRecorderConfig> r18) {
        return new SystemBatteryRecorderConfig(r11, r12, r13, r15, r17, r18);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SystemBatteryRecorderConfig) == true) goto L8;
        return false;
    L8:
        SystemBatteryRecorderConfig r9 = (SystemBatteryRecorderConfig) r8;
        if (this.slardarReportEnabled == r9.slardarReportEnabled) goto L12;
        return false;
    L12:
        if (this.teaReportEnabled == r9.teaReportEnabled) goto L15;
        return false;
    L15:
        if (this.galvanicAvgMinReportDurationMillis == r9.galvanicAvgMinReportDurationMillis) goto L18;
        return false;
    L18:
        if (this.batteryPollIntervalMillis == r9.batteryPollIntervalMillis) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.sceneDefaultConfig, r9.sceneDefaultConfig) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.sceneConfigMap, r9.sceneConfigMap) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.slardarReportEnabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.teaReportEnabled == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        long r4 = this.galvanicAvgMinReportDurationMillis;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.batteryPollIntervalMillis;
        int r7 = (r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31;
        SceneBatteryRecorderConfig r8 = this.sceneDefaultConfig;
        int r9 = 0;
        if (r8 != null) goto L13;
        int r10 = 0;
    L14:
        int r11 = (r7 + r10) * 31;
        Map<String, SceneBatteryRecorderConfig> r12 = this.sceneConfigMap;
        if (r12 == null) goto L19;
        r9 = r12.hashCode();
    L19:
        return r11 + r9;
    L13:
        r10 = r8.hashCode();
        goto L14
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "SystemBatteryRecorderConfig(slardarReportEnabled=" + this.slardarReportEnabled + ", teaReportEnabled=" + this.teaReportEnabled + ", galvanicAvgMinReportDurationMillis=" + this.galvanicAvgMinReportDurationMillis + ", batteryPollIntervalMillis=" + this.batteryPollIntervalMillis + ", sceneDefaultConfig=" + this.sceneDefaultConfig + ", sceneConfigMap=" + this.sceneConfigMap + ')';
    }

    public final long getBatteryPollIntervalMillis() {
        return this.batteryPollIntervalMillis;
    }

    public final long getGalvanicAvgMinReportDurationMillis() {
        return this.galvanicAvgMinReportDurationMillis;
    }

    public final Map<String, SceneBatteryRecorderConfig> getSceneConfigMap() {
        return this.sceneConfigMap;
    }

    public final SceneBatteryRecorderConfig getSceneDefaultConfig() {
        return this.sceneDefaultConfig;
    }

    public final boolean getSlardarReportEnabled() {
        return this.slardarReportEnabled;
    }

    public final boolean getTeaReportEnabled() {
        return this.teaReportEnabled;
    }

    public final SceneBatteryRecorderConfig getSceneConfig(String r9) {
        Intrinsics.checkNotNullParameter(r9, "scene");
        Map<String, SceneBatteryRecorderConfig> r0 = this.sceneConfigMap;
        if (r0 == null) goto L6;
        SceneBatteryRecorderConfig r10 = r0.get(r9);
        if (r10 == null) goto L6;
        return r10;
    L6:
        SceneBatteryRecorderConfig r11 = this.sceneDefaultConfig;
        if (r11 == null) goto L9;
        return r11;
    L9:
        return new SceneBatteryRecorderConfig(false, 0, 0, 7, null);
    }

    public SystemBatteryRecorderConfig(boolean r1, boolean r2, long r3, long r5, SceneBatteryRecorderConfig r7, Map<String, SceneBatteryRecorderConfig> r8) {
        this.slardarReportEnabled = r1;
        this.teaReportEnabled = r2;
        this.galvanicAvgMinReportDurationMillis = r3;
        this.batteryPollIntervalMillis = r5;
        this.sceneDefaultConfig = r7;
        this.sceneConfigMap = r8;
    }

    public /* synthetic */ SystemBatteryRecorderConfig(boolean r9, boolean r10, long r11, long r13, SceneBatteryRecorderConfig r15, Map r16, int r17, DefaultConstructorMarker r18) {
        boolean r1 = false;
        if ((r17 & 1) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r17 & 2) != 0) goto L11;
        r1 = r10;
    L11:
        if ((r17 & 4) == 0) goto L13;
        long r2 = 30000;
    L15:
        if ((r17 & 8) == 0) goto L17;
        long r4 = 5000;
    L19:
        if ((r17 & 16) == 0) goto L21;
        SceneBatteryRecorderConfig r6 = null;
    L23:
        if ((r17 & 32) == 0) goto L25;
        Map r7 = MapsKt.emptyMap();
    L26:
        this(r0, r1, r2, r4, r6, r7);
        return;
    L25:
        r7 = r16;
        goto L26
    L21:
        r6 = r15;
        goto L23
    L17:
        r4 = r13;
        goto L19
    L13:
        r2 = r11;
        goto L15
    L5:
        r0 = r9;
        goto L7
    }
}
