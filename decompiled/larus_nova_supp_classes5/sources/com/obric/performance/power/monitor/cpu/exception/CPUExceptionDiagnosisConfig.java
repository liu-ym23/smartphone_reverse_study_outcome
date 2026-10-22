package com.obric.performance.power.monitor.cpu.exception;

import com.google.gson.annotations.SerializedName;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import lna.i;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b/\b\u0087\b\u0018\u00002\u00020\u0001B¯\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0010\u001a\u00020\t\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013\u0012\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0017\u0010\u0018J\u000e\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0006HÆ\u0003J\t\u00102\u001a\u00020\u0006HÆ\u0003J\t\u00103\u001a\u00020\tHÆ\u0003J\t\u00104\u001a\u00020\tHÆ\u0003J\t\u00105\u001a\u00020\u0006HÆ\u0003J\t\u00106\u001a\u00020\u0006HÆ\u0003J\t\u00107\u001a\u00020\u000eHÆ\u0003J\t\u00108\u001a\u00020\u000eHÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\t\u0010:\u001a\u00020\u0003HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J\u000f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0003J±\u0001\u0010>\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\b\b\u0002\u0010\f\u001a\u00020\u00062\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u000e2\b\b\u0002\u0010\u0010\u001a\u00020\t2\b\b\u0002\u0010\u0011\u001a\u00020\u00032\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u000e\b\u0002\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013HÆ\u0001J\u0013\u0010?\u001a\u00020\u00032\b\u0010@\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010A\u001a\u00020\u000eHÖ\u0001J\t\u0010B\u001a\u00020\u0014HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001aR\u0016\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0007\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001dR\u0016\u0010\b\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0016\u0010\n\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010 R\u0016\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001dR\u0016\u0010\f\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001dR\u0016\u0010\r\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0016\u0010\u000f\u001a\u00020\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0016\u0010\u0010\u001a\u00020\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010 R\u0016\u0010\u0011\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001aR\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u001c\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010*R\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010*¨\u0006C"}, d2 = {"Lcom/obric/performance/power/monitor/cpu/exception/CPUExceptionDiagnosisConfig;", "", "enable", "", "aiagentEnable", "frontSampledRate", "", "backgroundSampledRate", "periodInterval", "", "measureCpuTime", "frontExceptionRatio", "backgroundExceptionRatio", "topDumpCount", "", "threadStackSleepMaxRetry", "dumpIntervalMillis", "stackFramePromotionEnabled", "stackFrameSkipClassPrefixes", "", "", "threadFilterExactNames", "threadFilterNamePrefixes", "<init>", "(ZZFFJJFFIIJZLjava/util/List;Ljava/util/List;Ljava/util/List;)V", "getEnable", "()Z", "getAiagentEnable", "getFrontSampledRate", "()F", "getBackgroundSampledRate", "getPeriodInterval", "()J", "getMeasureCpuTime", "getFrontExceptionRatio", "getBackgroundExceptionRatio", "getTopDumpCount", "()I", "getThreadStackSleepMaxRetry", "getDumpIntervalMillis", "getStackFramePromotionEnabled", "getStackFrameSkipClassPrefixes", "()Ljava/util/List;", "getThreadFilterExactNames", "getThreadFilterNamePrefixes", "cpuExceptionTime", "isBackground", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", IInteractionStateService.WAKE_UP_SOURCE_OTHER, "hashCode", "toString", "performance-power_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CPUExceptionDiagnosisConfig {

    @SerializedName("aiagent_enable")
    private final boolean aiagentEnable;

    @SerializedName("background_exception_ratio")
    private final float backgroundExceptionRatio;

    @SerializedName("background_sampled_rate")
    private final float backgroundSampledRate;

    @SerializedName("dump_interval_millis")
    private final long dumpIntervalMillis;

    @SerializedName("enable")
    private final boolean enable;

    @SerializedName("front_exception_ratio")
    private final float frontExceptionRatio;

    @SerializedName("front_sampled_rate")
    private final float frontSampledRate;

    @SerializedName("measure_cpu_time_millis")
    private final long measureCpuTime;

    @SerializedName("period_interval_millis")
    private final long periodInterval;

    @SerializedName("stack_frame_promotion_enabled")
    private final boolean stackFramePromotionEnabled;

    @SerializedName("stack_frame_skip_class_prefixes")
    private final List<String> stackFrameSkipClassPrefixes;

    @SerializedName("thread_filter_exact_names")
    private final List<String> threadFilterExactNames;

    @SerializedName("thread_filter_name_prefixes")
    private final List<String> threadFilterNamePrefixes;

    @SerializedName("thread_stack_sleep_max_retry")
    private final int threadStackSleepMaxRetry;

    @SerializedName("top_dump_count")
    private final int topDumpCount;

    public CPUExceptionDiagnosisConfig() {
        this(false, false, 0.0f, 0.0f, 0, 0, 0.0f, 0.0f, 0, 0, 0, false, null, null, null, 32767, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ CPUExceptionDiagnosisConfig copy$default(CPUExceptionDiagnosisConfig r16, boolean r17, boolean r18, float r19, float r20, long r21, long r23, float r25, float r26, int r27, int r28, long r29, boolean r31, List r32, List r33, List r34, int r35, Object r36) {
        if ((r35 & 1) == 0) goto L5;
        boolean r2 = r16.enable;
    L7:
        if ((r35 & 2) == 0) goto L9;
        boolean r3 = r16.aiagentEnable;
    L11:
        if ((r35 & 4) == 0) goto L13;
        float r4 = r16.frontSampledRate;
    L15:
        if ((r35 & 8) == 0) goto L17;
        float r5 = r16.backgroundSampledRate;
    L19:
        if ((r35 & 16) == 0) goto L21;
        long r6 = r16.periodInterval;
    L23:
        if ((r35 & 32) == 0) goto L25;
        long r8 = r16.measureCpuTime;
    L27:
        if ((r35 & 64) == 0) goto L29;
        float r10 = r16.frontExceptionRatio;
    L31:
        if ((r35 & 128) == 0) goto L33;
        float r11 = r16.backgroundExceptionRatio;
    L35:
        if ((r35 & 256) == 0) goto L37;
        int r12 = r16.topDumpCount;
    L39:
        if ((r35 & 512) == 0) goto L41;
        int r13 = r16.threadStackSleepMaxRetry;
    L43:
        if ((r35 & 1024) == 0) goto L45;
        long r14 = r16.dumpIntervalMillis;
    L46:
        long r210 = r14;
        if ((r35 & 2048) == 0) goto L49;
        boolean r15 = r16.stackFramePromotionEnabled;
    L51:
        if ((r35 & 4096) == 0) goto L53;
        List r110 = r16.stackFrameSkipClassPrefixes;
    L54:
        List r37 = r110;
        if ((r35 & 8192) == 0) goto L57;
        List r111 = r16.threadFilterExactNames;
    L59:
        if ((r35 & 16384) == 0) goto L61;
        List r1 = r16.threadFilterNamePrefixes;
    L63:
        return r16.copy(r2, r3, r4, r5, r6, r8, r10, r11, r12, r13, r210, r15, r37, r111, r1);
    L61:
        r1 = r34;
        goto L63
    L57:
        r111 = r33;
        goto L59
    L53:
        r110 = r32;
        goto L54
    L49:
        r15 = r31;
        goto L51
    L45:
        r14 = r29;
        goto L46
    L41:
        r13 = r28;
        goto L43
    L37:
        r12 = r27;
        goto L39
    L33:
        r11 = r26;
        goto L35
    L29:
        r10 = r25;
        goto L31
    L25:
        r8 = r23;
        goto L27
    L21:
        r6 = r21;
        goto L23
    L17:
        r5 = r20;
        goto L19
    L13:
        r4 = r19;
        goto L15
    L9:
        r3 = r18;
        goto L11
    L5:
        r2 = r17;
        goto L7
    }

    public final boolean component1() {
        return this.enable;
    }

    public final int component10() {
        return this.threadStackSleepMaxRetry;
    }

    public final long component11() {
        return this.dumpIntervalMillis;
    }

    public final boolean component12() {
        return this.stackFramePromotionEnabled;
    }

    public final List<String> component13() {
        return this.stackFrameSkipClassPrefixes;
    }

    public final List<String> component14() {
        return this.threadFilterExactNames;
    }

    public final List<String> component15() {
        return this.threadFilterNamePrefixes;
    }

    public final boolean component2() {
        return this.aiagentEnable;
    }

    public final float component3() {
        return this.frontSampledRate;
    }

    public final float component4() {
        return this.backgroundSampledRate;
    }

    public final long component5() {
        return this.periodInterval;
    }

    public final long component6() {
        return this.measureCpuTime;
    }

    public final float component7() {
        return this.frontExceptionRatio;
    }

    public final float component8() {
        return this.backgroundExceptionRatio;
    }

    public final int component9() {
        return this.topDumpCount;
    }

    public final CPUExceptionDiagnosisConfig copy(boolean r21, boolean r22, float r23, float r24, long r25, long r27, float r29, float r30, int r31, int r32, long r33, boolean r35, List<String> r36, List<String> r37, List<String> r38) {
        Intrinsics.checkNotNullParameter(r36, "stackFrameSkipClassPrefixes");
        Intrinsics.checkNotNullParameter(r37, "threadFilterExactNames");
        Intrinsics.checkNotNullParameter(r38, "threadFilterNamePrefixes");
        return new CPUExceptionDiagnosisConfig(r21, r22, r23, r24, r25, r27, r29, r30, r31, r32, r33, r35, r36, r37, r38);
    }

    public boolean equals(Object r8) {
        if (this != r8) goto L6;
        return true;
    L6:
        if ((r8 instanceof CPUExceptionDiagnosisConfig) == true) goto L8;
        return false;
    L8:
        CPUExceptionDiagnosisConfig r9 = (CPUExceptionDiagnosisConfig) r8;
        if (this.enable == r9.enable) goto L12;
        return false;
    L12:
        if (this.aiagentEnable == r9.aiagentEnable) goto L15;
        return false;
    L15:
        if (Float.compare(this.frontSampledRate, r9.frontSampledRate) == 0) goto L18;
        return false;
    L18:
        if (Float.compare(this.backgroundSampledRate, r9.backgroundSampledRate) == 0) goto L21;
        return false;
    L21:
        if (this.periodInterval == r9.periodInterval) goto L24;
        return false;
    L24:
        if (this.measureCpuTime == r9.measureCpuTime) goto L27;
        return false;
    L27:
        if (Float.compare(this.frontExceptionRatio, r9.frontExceptionRatio) == 0) goto L30;
        return false;
    L30:
        if (Float.compare(this.backgroundExceptionRatio, r9.backgroundExceptionRatio) == 0) goto L33;
        return false;
    L33:
        if (this.topDumpCount == r9.topDumpCount) goto L36;
        return false;
    L36:
        if (this.threadStackSleepMaxRetry == r9.threadStackSleepMaxRetry) goto L39;
        return false;
    L39:
        if (this.dumpIntervalMillis == r9.dumpIntervalMillis) goto L42;
        return false;
    L42:
        if (this.stackFramePromotionEnabled == r9.stackFramePromotionEnabled) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.stackFrameSkipClassPrefixes, r9.stackFrameSkipClassPrefixes) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.threadFilterExactNames, r9.threadFilterExactNames) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.threadFilterNamePrefixes, r9.threadFilterNamePrefixes) == true) goto L53;
        return false;
    L53:
        return true;
    }

    public int hashCode() {
        int r1 = 1231;
        if (this.enable == false) goto L5;
        int r0 = 1231;
    L6:
        int r2 = r0 * 31;
        if (this.aiagentEnable == false) goto L9;
        int r3 = 1231;
    L10:
        int r4 = (((((r2 + r3) * 31) + Float.floatToIntBits(this.frontSampledRate)) * 31) + Float.floatToIntBits(this.backgroundSampledRate)) * 31;
        long r5 = this.periodInterval;
        int r6 = (r4 + ((int) (r5 ^ (r5 >>> 32)))) * 31;
        long r7 = this.measureCpuTime;
        int r8 = (((((((((r6 + ((int) (r7 ^ (r7 >>> 32)))) * 31) + Float.floatToIntBits(this.frontExceptionRatio)) * 31) + Float.floatToIntBits(this.backgroundExceptionRatio)) * 31) + this.topDumpCount) * 31) + this.threadStackSleepMaxRetry) * 31;
        long r9 = this.dumpIntervalMillis;
        int r10 = (r8 + ((int) (r9 ^ (r9 >>> 32)))) * 31;
        if (this.stackFramePromotionEnabled == true) goto L15;
        r1 = 1237;
    L15:
        return ((((((r10 + r1) * 31) + this.stackFrameSkipClassPrefixes.hashCode()) * 31) + this.threadFilterExactNames.hashCode()) * 31) + this.threadFilterNamePrefixes.hashCode();
    L9:
        r3 = 1237;
        goto L10
    L5:
        r0 = 1237;
        goto L6
    }

    public String toString() {
        return "CPUExceptionDiagnosisConfig(enable=" + this.enable + ", aiagentEnable=" + this.aiagentEnable + ", frontSampledRate=" + this.frontSampledRate + ", backgroundSampledRate=" + this.backgroundSampledRate + ", periodInterval=" + this.periodInterval + ", measureCpuTime=" + this.measureCpuTime + ", frontExceptionRatio=" + this.frontExceptionRatio + ", backgroundExceptionRatio=" + this.backgroundExceptionRatio + ", topDumpCount=" + this.topDumpCount + ", threadStackSleepMaxRetry=" + this.threadStackSleepMaxRetry + ", dumpIntervalMillis=" + this.dumpIntervalMillis + ", stackFramePromotionEnabled=" + this.stackFramePromotionEnabled + ", stackFrameSkipClassPrefixes=" + this.stackFrameSkipClassPrefixes + ", threadFilterExactNames=" + this.threadFilterExactNames + ", threadFilterNamePrefixes=" + this.threadFilterNamePrefixes + ')';
    }

    public final boolean getAiagentEnable() {
        return this.aiagentEnable;
    }

    public final float getBackgroundExceptionRatio() {
        return this.backgroundExceptionRatio;
    }

    public final float getBackgroundSampledRate() {
        return this.backgroundSampledRate;
    }

    public final long getDumpIntervalMillis() {
        return this.dumpIntervalMillis;
    }

    public final boolean getEnable() {
        return this.enable;
    }

    public final float getFrontExceptionRatio() {
        return this.frontExceptionRatio;
    }

    public final float getFrontSampledRate() {
        return this.frontSampledRate;
    }

    public final long getMeasureCpuTime() {
        return this.measureCpuTime;
    }

    public final long getPeriodInterval() {
        return this.periodInterval;
    }

    public final boolean getStackFramePromotionEnabled() {
        return this.stackFramePromotionEnabled;
    }

    public final List<String> getStackFrameSkipClassPrefixes() {
        return this.stackFrameSkipClassPrefixes;
    }

    public final List<String> getThreadFilterExactNames() {
        return this.threadFilterExactNames;
    }

    public final List<String> getThreadFilterNamePrefixes() {
        return this.threadFilterNamePrefixes;
    }

    public final int getThreadStackSleepMaxRetry() {
        return this.threadStackSleepMaxRetry;
    }

    public final int getTopDumpCount() {
        return this.topDumpCount;
    }

    public final long cpuExceptionTime(boolean r3) {
        if (r3 == false) goto L4;
        float r4 = this.backgroundExceptionRatio;
    L6:
        return (long) (this.measureCpuTime * RangesKt.coerceIn(r4, 0.0f, 1.0f));
    L4:
        r4 = this.frontExceptionRatio;
        goto L6
    }

    public CPUExceptionDiagnosisConfig(boolean r7, boolean r8, float r9, float r10, long r11, long r13, float r15, float r16, int r17, int r18, long r19, boolean r21, List<String> r22, List<String> r23, List<String> r24) {
        Intrinsics.checkNotNullParameter(r22, "stackFrameSkipClassPrefixes");
        Intrinsics.checkNotNullParameter(r23, "threadFilterExactNames");
        Intrinsics.checkNotNullParameter(r24, "threadFilterNamePrefixes");
        this.enable = r7;
        this.aiagentEnable = r8;
        this.frontSampledRate = r9;
        this.backgroundSampledRate = r10;
        this.periodInterval = r11;
        this.measureCpuTime = r13;
        this.frontExceptionRatio = r15;
        this.backgroundExceptionRatio = r16;
        this.topDumpCount = r17;
        this.threadStackSleepMaxRetry = r18;
        this.dumpIntervalMillis = r19;
        this.stackFramePromotionEnabled = r21;
        this.stackFrameSkipClassPrefixes = r22;
        this.threadFilterExactNames = r23;
        this.threadFilterNamePrefixes = r24;
    }

    public CPUExceptionDiagnosisConfig(boolean r18, boolean r19, float r20, float r21, long r22, long r24, float r26, float r27, int r28, int r29, long r30, boolean r32, List r33, List r34, List r35, int r36, DefaultConstructorMarker r37) {
        boolean r2 = false;
        if ((r36 & 1) == 0) goto L5;
        boolean r1 = false;
    L7:
        if ((r36 & 2) != 0) goto L10;
        r2 = r19;
    L10:
        float r4 = 0.0f;
        if ((r36 & 4) == 0) goto L13;
        float r3 = 0.0f;
    L15:
        if ((r36 & 8) != 0) goto L19;
        r4 = r21;
    L19:
        if ((r36 & 16) == 0) goto L21;
        long r5 = 30000;
    L23:
        if ((r36 & 32) == 0) goto L25;
        long r7 = 2000;
    L27:
        if ((r36 & 64) == 0) goto L29;
        float r9 = 0.03f;
    L31:
        if ((r36 & 128) == 0) goto L33;
        float r10 = 0.01f;
    L34:
        int r12 = 5;
        if ((r36 & 256) == 0) goto L37;
        int r11 = 5;
    L39:
        if ((r36 & 512) != 0) goto L43;
        r12 = r29;
    L43:
        if ((r36 & 1024) == 0) goto L45;
        long r13 = 20;
    L47:
        if ((r36 & 2048) == 0) goto L49;
        boolean r15 = true;
    L50:
        boolean r38 = r15;
        if ((r36 & 4096) == 0) goto L53;
        List r16 = i.a;
    L54:
        List r17 = r16;
        if ((r36 & 8192) == 0) goto L57;
        List r110 = i.b;
    L59:
        if ((r36 & 16384) == 0) goto L61;
        List r0 = i.c;
    L62:
        this(r1, r2, r3, r4, r5, r7, r9, r10, r11, r12, r13, r38, r17, r110, r0);
        return;
    L61:
        r0 = r35;
        goto L62
    L57:
        r110 = r34;
        goto L59
    L53:
        r16 = r33;
        goto L54
    L49:
        r15 = r32;
        goto L50
    L45:
        r13 = r30;
        goto L47
    L37:
        r11 = r28;
        goto L39
    L33:
        r10 = r27;
        goto L34
    L29:
        r9 = r26;
        goto L31
    L25:
        r7 = r24;
        goto L27
    L21:
        r5 = r22;
        goto L23
    L13:
        r3 = r20;
        goto L15
    L5:
        r1 = r18;
        goto L7
    }
}
