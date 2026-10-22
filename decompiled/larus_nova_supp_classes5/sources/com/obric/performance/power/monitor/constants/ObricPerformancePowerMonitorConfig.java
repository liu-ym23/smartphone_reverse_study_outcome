package com.obric.performance.power.monitor.constants;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001a\u001a\u00020\tHÆ\u0003J\t\u0010\u001b\u001a\u00020\tHÆ\u0003JE\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\tHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00032\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020 HÖ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014¨\u0006#"}, d2 = {"Lcom/obric/performance/power/monitor/constants/ObricPerformancePowerMonitorConfig;", "", "enabled", "", "aiagentEnabled", "reportIntervalMillis", "", "collectCurrentIntervalMillis", "frontSampledRate", "", "backgroundSampledRate", "<init>", "(ZZJJFF)V", "getEnabled", "()Z", "getAiagentEnabled", "getReportIntervalMillis", "()J", "getCollectCurrentIntervalMillis", "getFrontSampledRate", "()F", "getBackgroundSampledRate", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "hashCode", "", "toString", "", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricPerformancePowerMonitorConfig {

    @SerializedName("aiagent_enable")
    private final boolean aiagentEnabled;

    @SerializedName("background_sampled_rate")
    private final float backgroundSampledRate;

    @SerializedName("collect_current_interval_millis")
    private final long collectCurrentIntervalMillis;

    @SerializedName("enable")
    private final boolean enabled;

    @SerializedName("front_sampled_rate")
    private final float frontSampledRate;

    @SerializedName("report_interval_millis")
    private final long reportIntervalMillis;

    public ObricPerformancePowerMonitorConfig() {
        this(false, false, 0, 0, 0.0f, 0.0f, 63, null);
    }

    public static /* synthetic */ ObricPerformancePowerMonitorConfig copy$default(ObricPerformancePowerMonitorConfig r9, boolean r10, boolean r11, long r12, long r14, float r16, float r17, int r18, Object r19) {
        if ((r18 & 1) == 0) goto L5;
        boolean r1 = r9.enabled;
    L7:
        if ((r18 & 2) == 0) goto L9;
        boolean r2 = r9.aiagentEnabled;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r3 = r9.reportIntervalMillis;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r5 = r9.collectCurrentIntervalMillis;
    L19:
        if ((r18 & 16) == 0) goto L21;
        float r7 = r9.frontSampledRate;
    L23:
        if ((r18 & 32) == 0) goto L25;
        float r8 = r9.backgroundSampledRate;
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
        return this.enabled;
    }

    public final boolean component2() {
        return this.aiagentEnabled;
    }

    public final long component3() {
        return this.reportIntervalMillis;
    }

    public final long component4() {
        return this.collectCurrentIntervalMillis;
    }

    public final float component5() {
        return this.frontSampledRate;
    }

    public final float component6() {
        return this.backgroundSampledRate;
    }

    public final ObricPerformancePowerMonitorConfig copy(boolean r11, boolean r12, long r13, long r15, float r17, float r18) {
        return new ObricPerformancePowerMonitorConfig(r11, r12, r13, r15, r17, r18);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof ObricPerformancePowerMonitorConfig) == true) goto L8;
        return false;
    L8:
        ObricPerformancePowerMonitorConfig r9 = (ObricPerformancePowerMonitorConfig) r8;
        if (this.enabled == r9.enabled) goto L12;
        return false;
    L12:
        if (this.aiagentEnabled == r9.aiagentEnabled) goto L15;
        return false;
    L15:
        if (this.reportIntervalMillis == r9.reportIntervalMillis) goto L18;
        return false;
    L18:
        if (this.collectCurrentIntervalMillis == r9.collectCurrentIntervalMillis) goto L21;
        return false;
    L21:
        if (Float.compare(this.frontSampledRate, r9.frontSampledRate) == 0) goto L24;
        return false;
    L24:
        if (Float.compare(this.backgroundSampledRate, r9.backgroundSampledRate) == 0) goto L26;
        return false;
    L26:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enabled == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.aiagentEnabled == true) goto L10;
        r1 = 1237;
    L10:
        int r3 = (r2 + r1) * 31;
        long r4 = this.reportIntervalMillis;
        int r5 = (r3 + ((int) (r4 ^ (r4 >>> 32)))) * 31;
        long r6 = this.collectCurrentIntervalMillis;
        return ((((r5 + ((int) (r6 ^ (r6 >>> 32)))) * 31) + Float.floatToIntBits(this.frontSampledRate)) * 31) + Float.floatToIntBits(this.backgroundSampledRate);
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "ObricPerformancePowerMonitorConfig(enabled=" + this.enabled + ", aiagentEnabled=" + this.aiagentEnabled + ", reportIntervalMillis=" + this.reportIntervalMillis + ", collectCurrentIntervalMillis=" + this.collectCurrentIntervalMillis + ", frontSampledRate=" + this.frontSampledRate + ", backgroundSampledRate=" + this.backgroundSampledRate + ')';
    }

    public final boolean getAiagentEnabled() {
        return this.aiagentEnabled;
    }

    public final float getBackgroundSampledRate() {
        return this.backgroundSampledRate;
    }

    public final long getCollectCurrentIntervalMillis() {
        return this.collectCurrentIntervalMillis;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    public final float getFrontSampledRate() {
        return this.frontSampledRate;
    }

    public final long getReportIntervalMillis() {
        return this.reportIntervalMillis;
    }

    public ObricPerformancePowerMonitorConfig(boolean r1, boolean r2, long r3, long r5, float r7, float r8) {
        this.enabled = r1;
        this.aiagentEnabled = r2;
        this.reportIntervalMillis = r3;
        this.collectCurrentIntervalMillis = r5;
        this.frontSampledRate = r7;
        this.backgroundSampledRate = r8;
    }

    public /* synthetic */ ObricPerformancePowerMonitorConfig(boolean r10, boolean r11, long r12, long r14, float r16, float r17, int r18, DefaultConstructorMarker r19) {
        boolean r1 = false;
        if ((r18 & 1) == 0) goto L5;
        boolean r0 = false;
    L7:
        if ((r18 & 2) != 0) goto L11;
        r1 = r11;
    L11:
        if ((r18 & 4) == 0) goto L13;
        long r2 = 30000;
    L15:
        if ((r18 & 8) == 0) goto L17;
        long r4 = 3000;
    L18:
        float r7 = 0.0f;
        if ((r18 & 16) == 0) goto L21;
        float r6 = 0.0f;
    L23:
        if ((r18 & 32) != 0) goto L26;
        r7 = r17;
    L26:
        this(r0, r1, r2, r4, r6, r7);
        return;
    L21:
        r6 = r16;
        goto L23
    L17:
        r4 = r14;
        goto L18
    L13:
        r2 = r12;
        goto L15
    L5:
        r0 = r10;
        goto L7
    }
}
