package com.larus.settings.performance;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/larus/settings/performance/SceneBatteryRecorderConfig;", "", "enableReport", "", "smoothDurationMillis", "", "reportIntervalMillis", "<init>", "(ZJJ)V", "getEnableReport", "()Z", "getSmoothDurationMillis", "()J", "getReportIntervalMillis", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SceneBatteryRecorderConfig {

    @SerializedName("enable_report")
    private final boolean enableReport;

    @SerializedName("report_interval_millis")
    private final long reportIntervalMillis;

    @SerializedName("smooth_duration_millis")
    private final long smoothDurationMillis;

    public SceneBatteryRecorderConfig() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ SceneBatteryRecorderConfig copy$default(SceneBatteryRecorderConfig r2, boolean r3, long r4, long r6, int r8, Object r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = r2.enableReport;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = r2.smoothDurationMillis;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = r2.reportIntervalMillis;
    L11:
        boolean r5 = r3;
        return r2.copy(r5, r0, r6);
    }

    public final boolean component1() {
        return this.enableReport;
    }

    public final long component2() {
        return this.smoothDurationMillis;
    }

    public final long component3() {
        return this.reportIntervalMillis;
    }

    public final SceneBatteryRecorderConfig copy(boolean r8, long r9, long r11) {
        return new SceneBatteryRecorderConfig(r8, r9, r11);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof SceneBatteryRecorderConfig) == true) goto L8;
        return false;
    L8:
        SceneBatteryRecorderConfig r9 = (SceneBatteryRecorderConfig) r8;
        if (this.enableReport == r9.enableReport) goto L12;
        return false;
    L12:
        if (this.smoothDurationMillis == r9.smoothDurationMillis) goto L15;
        return false;
    L15:
        if (this.reportIntervalMillis == r9.reportIntervalMillis) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enableReport == false) goto L5;
        int r0 = 1231;
    L6:
        long r1 = this.smoothDurationMillis;
        int r2 = ((r0 * 31) + ((int) (r1 ^ (r1 >>> 32)))) * 31;
        long r3 = this.reportIntervalMillis;
        return r2 + ((int) (r3 ^ (r3 >>> 32)));
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "SceneBatteryRecorderConfig(enableReport=" + this.enableReport + ", smoothDurationMillis=" + this.smoothDurationMillis + ", reportIntervalMillis=" + this.reportIntervalMillis + ')';
    }

    public final boolean getEnableReport() {
        return this.enableReport;
    }

    public final long getReportIntervalMillis() {
        return this.reportIntervalMillis;
    }

    public final long getSmoothDurationMillis() {
        return this.smoothDurationMillis;
    }

    public SceneBatteryRecorderConfig(boolean r1, long r2, long r4) {
        this.enableReport = r1;
        this.smoothDurationMillis = r2;
        this.reportIntervalMillis = r4;
    }

    public /* synthetic */ SceneBatteryRecorderConfig(boolean r3, long r4, long r6, int r8, DefaultConstructorMarker r9) {
        if ((r8 & 1) == 0) goto L6;
        r3 = true;
    L6:
        if ((r8 & 2) == 0) goto L8;
        r4 = 5000;
    L8:
        long r0 = r4;
        if ((r8 & 4) == 0) goto L11;
        r6 = 3600000;
    L11:
        boolean r5 = r3;
        this(r5, r0, r6);
    }
}
