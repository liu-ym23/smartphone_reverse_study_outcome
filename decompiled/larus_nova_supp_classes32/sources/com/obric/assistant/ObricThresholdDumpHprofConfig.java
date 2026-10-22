package com.obric.assistant;

import com.google.gson.annotations.SerializedName;
import com.obric.aivoice.core.data.NameKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00032\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/obric/assistant/ObricThresholdDumpHprofConfig;", NameKeys.UnloadStrategy_No_Strategy, "enableHprofDump", NameKeys.UnloadStrategy_No_Strategy, "hprofDumpInterval", NameKeys.UnloadStrategy_No_Strategy, "hprofDumpThreshold", "<init>", "(ZII)V", "getEnableHprofDump", "()Z", "getHprofDumpInterval", "()I", "getHprofDumpThreshold", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", NameKeys.UnloadStrategy_No_Strategy, "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricThresholdDumpHprofConfig {

    @SerializedName("enable_hprof_dump")
    private final boolean enableHprofDump;

    @SerializedName("hprof_dump_interval")
    private final int hprofDumpInterval;

    @SerializedName("hprof_dump_threshold")
    private final int hprofDumpThreshold;

    public ObricThresholdDumpHprofConfig() {
        this(false, 0, 0, 7, null);
    }

    public static /* synthetic */ ObricThresholdDumpHprofConfig copy$default(ObricThresholdDumpHprofConfig r0, boolean r1, int r2, int r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.enableHprofDump;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.hprofDumpInterval;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.hprofDumpThreshold;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final boolean component1() {
        return this.enableHprofDump;
    }

    public final int component2() {
        return this.hprofDumpInterval;
    }

    public final int component3() {
        return this.hprofDumpThreshold;
    }

    public final ObricThresholdDumpHprofConfig copy(boolean r2, int r3, int r4) {
        return new ObricThresholdDumpHprofConfig(r2, r3, r4);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof ObricThresholdDumpHprofConfig) == true) goto L8;
        return false;
    L8:
        ObricThresholdDumpHprofConfig r6 = (ObricThresholdDumpHprofConfig) r5;
        if (this.enableHprofDump == r6.enableHprofDump) goto L12;
        return false;
    L12:
        if (this.hprofDumpInterval == r6.hprofDumpInterval) goto L15;
        return false;
    L15:
        if (this.hprofDumpThreshold == r6.hprofDumpThreshold) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        if (this.enableHprofDump == false) goto L5;
        int r0 = 1231;
    L7:
        return (((r0 * 31) + this.hprofDumpInterval) * 31) + this.hprofDumpThreshold;
    L5:
        r0 = 1237;
        goto L7
    }

    public String toString() {
        return "ObricThresholdDumpHprofConfig(enableHprofDump=" + this.enableHprofDump + ", hprofDumpInterval=" + this.hprofDumpInterval + ", hprofDumpThreshold=" + this.hprofDumpThreshold + ')';
    }

    public final boolean getEnableHprofDump() {
        return this.enableHprofDump;
    }

    public final int getHprofDumpInterval() {
        return this.hprofDumpInterval;
    }

    public final int getHprofDumpThreshold() {
        return this.hprofDumpThreshold;
    }

    public ObricThresholdDumpHprofConfig(boolean r1, int r2, int r3) {
        this.enableHprofDump = r1;
        this.hprofDumpInterval = r2;
        this.hprofDumpThreshold = r3;
    }

    public /* synthetic */ ObricThresholdDumpHprofConfig(boolean r1, int r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = true;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = 30;
    L9:
        if ((r4 & 4) == 0) goto L11;
        r3 = 80;
    L11:
        this(r1, r2, r3);
    }
}
