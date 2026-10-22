package com.larus.settings.provider.perf;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\b\u0087\b\u0018\u00002\u00020\u0001B\u0097\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f\u0012\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\"\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010$\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0014J\u0010\u0010%\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010&\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010'\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010(\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010\u0019J\u0013\u0010)\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u0013\u0010*\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\fHÆ\u0003J\u0013\u0010+\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0003J\u009e\u0001\u0010,\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\u0012\b\u0002\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f2\u0012\b\u0002\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f2\u0012\b\u0002\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\fHÆ\u0001¢\u0006\u0002\u0010-J\u0013\u0010.\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u00020\u0007HÖ\u0001J\t\u00101\u001a\u00020\rHÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0016\u0010\u0014R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001b\u0010\u0019R\u001a\u0010\t\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001c\u0010\u0019R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u001d\u0010\u0019R \u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR \u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR \u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\r\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001f¨\u00062"}, d2 = {"Lcom/larus/settings/provider/perf/CoroutinesMonitorConfig;", "", "enableReportApm", "", "enableStackTrace", "enableClipStack", "waitThresholdMS", "", "mainExecThresholdMS", "ioExecThresholdMS", "calculatePeriodMS", "monitorThreadList", "", "", "monitorThreadThreshold", "Lcom/larus/settings/provider/perf/MonitorThreadThreshold;", "calcBlackList", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEnableReportApm", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEnableStackTrace", "getEnableClipStack", "getWaitThresholdMS", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMainExecThresholdMS", "getIoExecThresholdMS", "getCalculatePeriodMS", "getMonitorThreadList", "()Ljava/util/List;", "getMonitorThreadThreshold", "getCalcBlackList", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/util/List;Ljava/util/List;Ljava/util/List;)Lcom/larus/settings/provider/perf/CoroutinesMonitorConfig;", "equals", "other", "hashCode", "toString", "settings_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class CoroutinesMonitorConfig {

    @SerializedName("calculate_black_list")
    private final List<String> calcBlackList;

    @SerializedName("calculate_period_ms")
    private final Integer calculatePeriodMS;

    @SerializedName("enable_clip_stack")
    private final Boolean enableClipStack;

    @SerializedName("enable_report_apm")
    private final Boolean enableReportApm;

    @SerializedName("enable_stack_trace")
    private final Boolean enableStackTrace;

    @SerializedName("io_exec_threshold_ms")
    private final Integer ioExecThresholdMS;

    @SerializedName("main_exec_threshold_ms")
    private final Integer mainExecThresholdMS;

    @SerializedName("monitor_thread_list")
    private final List<String> monitorThreadList;

    @SerializedName("monitor_thread_threshold_config")
    private final List<MonitorThreadThreshold> monitorThreadThreshold;

    @SerializedName("wait_threshold_ms")
    private final Integer waitThresholdMS;

    public CoroutinesMonitorConfig() {
        this(null, null, null, null, null, null, null, null, null, null, 1023, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CoroutinesMonitorConfig copy$default(CoroutinesMonitorConfig r11, Boolean r12, Boolean r13, Boolean r14, Integer r15, Integer r16, Integer r17, Integer r18, List r19, List r20, List r21, int r22, Object r23) {
        if ((r22 & 1) == 0) goto L5;
        Boolean r2 = r11.enableReportApm;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Boolean r3 = r11.enableStackTrace;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Boolean r4 = r11.enableClipStack;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Integer r5 = r11.waitThresholdMS;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Integer r6 = r11.mainExecThresholdMS;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Integer r7 = r11.ioExecThresholdMS;
    L27:
        if ((r22 & 64) == 0) goto L29;
        Integer r8 = r11.calculatePeriodMS;
    L31:
        if ((r22 & 128) == 0) goto L33;
        List r9 = r11.monitorThreadList;
    L35:
        if ((r22 & 256) == 0) goto L37;
        List r10 = r11.monitorThreadThreshold;
    L39:
        if ((r22 & 512) == 0) goto L41;
        List r1 = r11.calcBlackList;
    L43:
        return r11.copy(r2, r3, r4, r5, r6, r7, r8, r9, r10, r1);
    L41:
        r1 = r21;
        goto L43
    L37:
        r10 = r20;
        goto L39
    L33:
        r9 = r19;
        goto L35
    L29:
        r8 = r18;
        goto L31
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r5 = r15;
        goto L19
    L13:
        r4 = r14;
        goto L15
    L9:
        r3 = r13;
        goto L11
    L5:
        r2 = r12;
        goto L7
    }

    public final Boolean component1() {
        return this.enableReportApm;
    }

    public final List<String> component10() {
        return this.calcBlackList;
    }

    public final Boolean component2() {
        return this.enableStackTrace;
    }

    public final Boolean component3() {
        return this.enableClipStack;
    }

    public final Integer component4() {
        return this.waitThresholdMS;
    }

    public final Integer component5() {
        return this.mainExecThresholdMS;
    }

    public final Integer component6() {
        return this.ioExecThresholdMS;
    }

    public final Integer component7() {
        return this.calculatePeriodMS;
    }

    public final List<String> component8() {
        return this.monitorThreadList;
    }

    public final List<MonitorThreadThreshold> component9() {
        return this.monitorThreadThreshold;
    }

    public final CoroutinesMonitorConfig copy(Boolean r13, Boolean r14, Boolean r15, Integer r16, Integer r17, Integer r18, Integer r19, List<String> r20, List<MonitorThreadThreshold> r21, List<String> r22) {
        return new CoroutinesMonitorConfig(r13, r14, r15, r16, r17, r18, r19, r20, r21, r22);
    }

    public boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof CoroutinesMonitorConfig) == true) goto L8;
        return false;
    L8:
        CoroutinesMonitorConfig r6 = (CoroutinesMonitorConfig) r5;
        if (Intrinsics.areEqual(this.enableReportApm, r6.enableReportApm) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.enableStackTrace, r6.enableStackTrace) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.enableClipStack, r6.enableClipStack) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.waitThresholdMS, r6.waitThresholdMS) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.mainExecThresholdMS, r6.mainExecThresholdMS) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.ioExecThresholdMS, r6.ioExecThresholdMS) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.calculatePeriodMS, r6.calculatePeriodMS) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.monitorThreadList, r6.monitorThreadList) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.monitorThreadThreshold, r6.monitorThreadThreshold) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.calcBlackList, r6.calcBlackList) == true) goto L38;
        return false;
    L38:
        return true;
    }

    public int hashCode() {
        Boolean r0 = this.enableReportApm;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.enableStackTrace;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.enableClipStack;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Integer r10 = this.waitThresholdMS;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Integer r13 = this.mainExecThresholdMS;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Integer r16 = this.ioExecThresholdMS;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Integer r19 = this.calculatePeriodMS;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        List<String> r22 = this.monitorThreadList;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        List<MonitorThreadThreshold> r25 = this.monitorThreadThreshold;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        List<String> r28 = this.calcBlackList;
        if (r28 == null) goto L43;
        r1 = r28.hashCode();
    L43:
        return r27 + r1;
    L37:
        r26 = r25.hashCode();
        goto L38
    L33:
        r23 = r22.hashCode();
        goto L34
    L29:
        r20 = r19.hashCode();
        goto L30
    L25:
        r17 = r16.hashCode();
        goto L26
    L21:
        r14 = r13.hashCode();
        goto L22
    L17:
        r11 = r10.hashCode();
        goto L18
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
        return "CoroutinesMonitorConfig(enableReportApm=" + this.enableReportApm + ", enableStackTrace=" + this.enableStackTrace + ", enableClipStack=" + this.enableClipStack + ", waitThresholdMS=" + this.waitThresholdMS + ", mainExecThresholdMS=" + this.mainExecThresholdMS + ", ioExecThresholdMS=" + this.ioExecThresholdMS + ", calculatePeriodMS=" + this.calculatePeriodMS + ", monitorThreadList=" + this.monitorThreadList + ", monitorThreadThreshold=" + this.monitorThreadThreshold + ", calcBlackList=" + this.calcBlackList + ')';
    }

    public final List<String> getCalcBlackList() {
        return this.calcBlackList;
    }

    public final Integer getCalculatePeriodMS() {
        return this.calculatePeriodMS;
    }

    public final Boolean getEnableClipStack() {
        return this.enableClipStack;
    }

    public final Boolean getEnableReportApm() {
        return this.enableReportApm;
    }

    public final Boolean getEnableStackTrace() {
        return this.enableStackTrace;
    }

    public final Integer getIoExecThresholdMS() {
        return this.ioExecThresholdMS;
    }

    public final Integer getMainExecThresholdMS() {
        return this.mainExecThresholdMS;
    }

    public final List<String> getMonitorThreadList() {
        return this.monitorThreadList;
    }

    public final List<MonitorThreadThreshold> getMonitorThreadThreshold() {
        return this.monitorThreadThreshold;
    }

    public final Integer getWaitThresholdMS() {
        return this.waitThresholdMS;
    }

    public CoroutinesMonitorConfig(Boolean r1, Boolean r2, Boolean r3, Integer r4, Integer r5, Integer r6, Integer r7, List<String> r8, List<MonitorThreadThreshold> r9, List<String> r10) {
        this.enableReportApm = r1;
        this.enableStackTrace = r2;
        this.enableClipStack = r3;
        this.waitThresholdMS = r4;
        this.mainExecThresholdMS = r5;
        this.ioExecThresholdMS = r6;
        this.calculatePeriodMS = r7;
        this.monitorThreadList = r8;
        this.monitorThreadThreshold = r9;
        this.calcBlackList = r10;
    }

    public /* synthetic */ CoroutinesMonitorConfig(Boolean r12, Boolean r13, Boolean r14, Integer r15, Integer r16, Integer r17, Integer r18, List r19, List r20, List r21, int r22, DefaultConstructorMarker r23) {
        if ((r22 & 1) == 0) goto L5;
        Boolean r1 = Boolean.FALSE;
    L7:
        if ((r22 & 2) == 0) goto L9;
        Boolean r2 = Boolean.FALSE;
    L11:
        if ((r22 & 4) == 0) goto L13;
        Boolean r3 = Boolean.FALSE;
    L15:
        if ((r22 & 8) == 0) goto L17;
        Integer r4 = 0;
    L19:
        if ((r22 & 16) == 0) goto L21;
        Integer r6 = 0;
    L23:
        if ((r22 & 32) == 0) goto L25;
        Integer r7 = 0;
    L27:
        if ((r22 & 64) == 0) goto L29;
        Integer r5 = 0;
    L30:
        List r9 = null;
        if ((r22 & 128) == 0) goto L33;
        List r8 = null;
    L35:
        if ((r22 & 256) == 0) goto L37;
        List r10 = null;
    L39:
        if ((r22 & 512) != 0) goto L42;
        r9 = r21;
    L42:
        this(r1, r2, r3, r4, r6, r7, r5, r8, r10, r9);
        return;
    L37:
        r10 = r20;
        goto L39
    L33:
        r8 = r19;
        goto L35
    L29:
        r5 = r18;
        goto L30
    L25:
        r7 = r17;
        goto L27
    L21:
        r6 = r16;
        goto L23
    L17:
        r4 = r15;
        goto L19
    L13:
        r3 = r14;
        goto L15
    L9:
        r2 = r13;
        goto L11
    L5:
        r1 = r12;
        goto L7
    }
}
