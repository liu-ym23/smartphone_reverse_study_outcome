package hq9;

import com.google.gson.annotations.SerializedName;
import com.tencent.open.log.TraceLevel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\bL\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B÷\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0017\u0010\u0018J\u0006\u0010\u0015\u001a\u00020\u0003J\u0006\u0010\u0016\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0003J\u0010\u00107\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00108\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u00109\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010:\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010;\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010<\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010=\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010>\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010?\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010@\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010A\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010B\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010C\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010D\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010E\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010F\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010G\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010H\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010I\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJ\u0010\u0010J\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001aJþ\u0001\u0010K\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010LJ\u0013\u0010M\u001a\u00020\u00032\b\u0010N\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010O\u001a\u00020PHÖ\u0001J\t\u0010Q\u001a\u00020RHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\"\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b \u0010\u001a\"\u0004\b!\u0010\u001cR\"\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\"\u0010\u001a\"\u0004\b#\u0010\u001cR\"\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010\u001cR\"\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b&\u0010\u001a\"\u0004\b'\u0010\u001cR\"\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b(\u0010\u001a\"\u0004\b)\u0010\u001cR\u001a\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b*\u0010\u001aR\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b+\u0010\u001aR\u001a\u0010\f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b,\u0010\u001aR\u001a\u0010\r\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b-\u0010\u001aR\u001a\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b.\u0010\u001aR\u001a\u0010\u000f\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b/\u0010\u001aR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b0\u0010\u001aR\u001a\u0010\u0011\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b1\u0010\u001aR\u001a\u0010\u0012\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b2\u0010\u001aR\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b3\u0010\u001aR\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b4\u0010\u001aR\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b5\u0010\u001aR\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b6\u0010\u001a¨\u0006S"}, d2 = {"Lcom/larus/platform/model/AppLaunchOptV3;", "", "enable", "", "asyncInitMSSDKAfterFeed", "asyncPreInstallReport", "asyncStartPushAfterFeed", "asyncInitLocationAfterFeed", "asyncInitMiddleTabAfterFeed", "asyncInitShareAfterFeed", "asyncInitZLinkAfterFeed", "asyncReportDoraState", "asyncInitAppletAfterFeed", "asyncInitTimon", "optScheduler", "optGLES", "boostRenderThread", "boostCpuAndGpuThread", "canBindBigCore", "optNitaPreload", "enableResourcePreheating", "enableFirstFeedDelayLoad", "optPreloadPipeline", "<init>", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getEnable", "()Ljava/lang/Boolean;", "setEnable", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getAsyncInitMSSDKAfterFeed", "setAsyncInitMSSDKAfterFeed", "getAsyncPreInstallReport", "setAsyncPreInstallReport", "getAsyncStartPushAfterFeed", "setAsyncStartPushAfterFeed", "getAsyncInitLocationAfterFeed", "setAsyncInitLocationAfterFeed", "getAsyncInitMiddleTabAfterFeed", "setAsyncInitMiddleTabAfterFeed", "getAsyncInitShareAfterFeed", "setAsyncInitShareAfterFeed", "getAsyncInitZLinkAfterFeed", "getAsyncReportDoraState", "getAsyncInitAppletAfterFeed", "getAsyncInitTimon", "getOptScheduler", "getOptGLES", "getBoostRenderThread", "getBoostCpuAndGpuThread", "getCanBindBigCore", "getOptNitaPreload", "getEnableResourcePreheating", "getEnableFirstFeedDelayLoad", "getOptPreloadPipeline", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component20", "copy", "(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)Lcom/larus/platform/model/AppLaunchOptV3;", "equals", "other", "hashCode", "", "toString", "", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class i {

    @SerializedName("async_init_applet_after_feed")
    private final Boolean asyncInitAppletAfterFeed;

    @SerializedName("async_init_location_after_feed")
    private Boolean asyncInitLocationAfterFeed;

    @SerializedName("async_init_mssdk_after_feed")
    private Boolean asyncInitMSSDKAfterFeed;

    @SerializedName("async_init_middle_tab_after_feed")
    private Boolean asyncInitMiddleTabAfterFeed;

    @SerializedName("async_init_share_after_feed")
    private Boolean asyncInitShareAfterFeed;

    @SerializedName("async_init_Timon")
    private final Boolean asyncInitTimon;

    @SerializedName("async_init_zlink_after_feed")
    private final Boolean asyncInitZLinkAfterFeed;

    @SerializedName("async_pre_install_report")
    private Boolean asyncPreInstallReport;

    @SerializedName("async_report_dora_state")
    private final Boolean asyncReportDoraState;

    @SerializedName("async_start_push_after_feed")
    private Boolean asyncStartPushAfterFeed;

    @SerializedName("opt_cpu_and_gpu_thread")
    private final Boolean boostCpuAndGpuThread;

    @SerializedName("opt_render_thread")
    private final Boolean boostRenderThread;

    @SerializedName("can_bind_big_core")
    private final Boolean canBindBigCore;

    @SerializedName("enable")
    private Boolean enable;

    @SerializedName("enable_first_feed_delay_load")
    private final Boolean enableFirstFeedDelayLoad;

    @SerializedName("enable_resource_preheating")
    private final Boolean enableResourcePreheating;

    @SerializedName("opt_gles")
    private final Boolean optGLES;

    @SerializedName("opt_nita_preload")
    private final Boolean optNitaPreload;

    @SerializedName("opt_preload_pipeline")
    private final Boolean optPreloadPipeline;

    @SerializedName("opt_scheduler")
    private final Boolean optScheduler;

    public final boolean equals(Object r5) {
        if (this != r5) goto L6;
        return true;
    L6:
        if ((r5 instanceof i) == true) goto L8;
        return false;
    L8:
        i r6 = (i) r5;
        if (Intrinsics.areEqual(this.enable, r6.enable) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.asyncInitMSSDKAfterFeed, r6.asyncInitMSSDKAfterFeed) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.asyncPreInstallReport, r6.asyncPreInstallReport) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.asyncStartPushAfterFeed, r6.asyncStartPushAfterFeed) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.asyncInitLocationAfterFeed, r6.asyncInitLocationAfterFeed) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.asyncInitMiddleTabAfterFeed, r6.asyncInitMiddleTabAfterFeed) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.asyncInitShareAfterFeed, r6.asyncInitShareAfterFeed) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.asyncInitZLinkAfterFeed, r6.asyncInitZLinkAfterFeed) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.asyncReportDoraState, r6.asyncReportDoraState) == true) goto L36;
        return false;
    L36:
        if (Intrinsics.areEqual(this.asyncInitAppletAfterFeed, r6.asyncInitAppletAfterFeed) == true) goto L39;
        return false;
    L39:
        if (Intrinsics.areEqual(this.asyncInitTimon, r6.asyncInitTimon) == true) goto L42;
        return false;
    L42:
        if (Intrinsics.areEqual(this.optScheduler, r6.optScheduler) == true) goto L45;
        return false;
    L45:
        if (Intrinsics.areEqual(this.optGLES, r6.optGLES) == true) goto L48;
        return false;
    L48:
        if (Intrinsics.areEqual(this.boostRenderThread, r6.boostRenderThread) == true) goto L51;
        return false;
    L51:
        if (Intrinsics.areEqual(this.boostCpuAndGpuThread, r6.boostCpuAndGpuThread) == true) goto L54;
        return false;
    L54:
        if (Intrinsics.areEqual(this.canBindBigCore, r6.canBindBigCore) == true) goto L57;
        return false;
    L57:
        if (Intrinsics.areEqual(this.optNitaPreload, r6.optNitaPreload) == true) goto L60;
        return false;
    L60:
        if (Intrinsics.areEqual(this.enableResourcePreheating, r6.enableResourcePreheating) == true) goto L63;
        return false;
    L63:
        if (Intrinsics.areEqual(this.enableFirstFeedDelayLoad, r6.enableFirstFeedDelayLoad) == true) goto L66;
        return false;
    L66:
        if (Intrinsics.areEqual(this.optPreloadPipeline, r6.optPreloadPipeline) == true) goto L68;
        return false;
    L68:
        return true;
    }

    public final int hashCode() {
        Boolean r0 = this.enable;
        int r1 = 0;
        if (r0 != null) goto L5;
        int r2 = 0;
    L6:
        int r3 = r2 * 31;
        Boolean r4 = this.asyncInitMSSDKAfterFeed;
        if (r4 != null) goto L9;
        int r5 = 0;
    L10:
        int r6 = (r3 + r5) * 31;
        Boolean r7 = this.asyncPreInstallReport;
        if (r7 != null) goto L13;
        int r8 = 0;
    L14:
        int r9 = (r6 + r8) * 31;
        Boolean r10 = this.asyncStartPushAfterFeed;
        if (r10 != null) goto L17;
        int r11 = 0;
    L18:
        int r12 = (r9 + r11) * 31;
        Boolean r13 = this.asyncInitLocationAfterFeed;
        if (r13 != null) goto L21;
        int r14 = 0;
    L22:
        int r15 = (r12 + r14) * 31;
        Boolean r16 = this.asyncInitMiddleTabAfterFeed;
        if (r16 != null) goto L25;
        int r17 = 0;
    L26:
        int r18 = (r15 + r17) * 31;
        Boolean r19 = this.asyncInitShareAfterFeed;
        if (r19 != null) goto L29;
        int r20 = 0;
    L30:
        int r21 = (r18 + r20) * 31;
        Boolean r22 = this.asyncInitZLinkAfterFeed;
        if (r22 != null) goto L33;
        int r23 = 0;
    L34:
        int r24 = (r21 + r23) * 31;
        Boolean r25 = this.asyncReportDoraState;
        if (r25 != null) goto L37;
        int r26 = 0;
    L38:
        int r27 = (r24 + r26) * 31;
        Boolean r28 = this.asyncInitAppletAfterFeed;
        if (r28 != null) goto L41;
        int r29 = 0;
    L42:
        int r30 = (r27 + r29) * 31;
        Boolean r31 = this.asyncInitTimon;
        if (r31 != null) goto L45;
        int r32 = 0;
    L46:
        int r33 = (r30 + r32) * 31;
        Boolean r34 = this.optScheduler;
        if (r34 != null) goto L49;
        int r35 = 0;
    L50:
        int r36 = (r33 + r35) * 31;
        Boolean r37 = this.optGLES;
        if (r37 != null) goto L53;
        int r38 = 0;
    L54:
        int r39 = (r36 + r38) * 31;
        Boolean r40 = this.boostRenderThread;
        if (r40 != null) goto L57;
        int r41 = 0;
    L58:
        int r42 = (r39 + r41) * 31;
        Boolean r43 = this.boostCpuAndGpuThread;
        if (r43 != null) goto L61;
        int r44 = 0;
    L62:
        int r45 = (r42 + r44) * 31;
        Boolean r46 = this.canBindBigCore;
        if (r46 != null) goto L65;
        int r47 = 0;
    L66:
        int r48 = (r45 + r47) * 31;
        Boolean r49 = this.optNitaPreload;
        if (r49 != null) goto L69;
        int r50 = 0;
    L70:
        int r51 = (r48 + r50) * 31;
        Boolean r52 = this.enableResourcePreheating;
        if (r52 != null) goto L73;
        int r53 = 0;
    L74:
        int r54 = (r51 + r53) * 31;
        Boolean r55 = this.enableFirstFeedDelayLoad;
        if (r55 != null) goto L77;
        int r56 = 0;
    L78:
        int r57 = (r54 + r56) * 31;
        Boolean r58 = this.optPreloadPipeline;
        if (r58 == null) goto L83;
        r1 = r58.hashCode();
    L83:
        return r57 + r1;
    L77:
        r56 = r55.hashCode();
        goto L78
    L73:
        r53 = r52.hashCode();
        goto L74
    L69:
        r50 = r49.hashCode();
        goto L70
    L65:
        r47 = r46.hashCode();
        goto L66
    L61:
        r44 = r43.hashCode();
        goto L62
    L57:
        r41 = r40.hashCode();
        goto L58
    L53:
        r38 = r37.hashCode();
        goto L54
    L49:
        r35 = r34.hashCode();
        goto L50
    L45:
        r32 = r31.hashCode();
        goto L46
    L41:
        r29 = r28.hashCode();
        goto L42
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

    public final String toString() {
        return "AppLaunchOptV3(enable=" + this.enable + ", asyncInitMSSDKAfterFeed=" + this.asyncInitMSSDKAfterFeed + ", asyncPreInstallReport=" + this.asyncPreInstallReport + ", asyncStartPushAfterFeed=" + this.asyncStartPushAfterFeed + ", asyncInitLocationAfterFeed=" + this.asyncInitLocationAfterFeed + ", asyncInitMiddleTabAfterFeed=" + this.asyncInitMiddleTabAfterFeed + ", asyncInitShareAfterFeed=" + this.asyncInitShareAfterFeed + ", asyncInitZLinkAfterFeed=" + this.asyncInitZLinkAfterFeed + ", asyncReportDoraState=" + this.asyncReportDoraState + ", asyncInitAppletAfterFeed=" + this.asyncInitAppletAfterFeed + ", asyncInitTimon=" + this.asyncInitTimon + ", optScheduler=" + this.optScheduler + ", optGLES=" + this.optGLES + ", boostRenderThread=" + this.boostRenderThread + ", boostCpuAndGpuThread=" + this.boostCpuAndGpuThread + ", canBindBigCore=" + this.canBindBigCore + ", optNitaPreload=" + this.optNitaPreload + ", enableResourcePreheating=" + this.enableResourcePreheating + ", enableFirstFeedDelayLoad=" + this.enableFirstFeedDelayLoad + ", optPreloadPipeline=" + this.optPreloadPipeline + ')';
    }

    public i() {
        Boolean r0 = Boolean.FALSE;
        this.enable = r0;
        this.asyncInitMSSDKAfterFeed = r0;
        this.asyncPreInstallReport = r0;
        this.asyncStartPushAfterFeed = r0;
        this.asyncInitLocationAfterFeed = r0;
        this.asyncInitMiddleTabAfterFeed = r0;
        this.asyncInitShareAfterFeed = r0;
        this.asyncInitZLinkAfterFeed = r0;
        this.asyncReportDoraState = r0;
        this.asyncInitAppletAfterFeed = r0;
        this.asyncInitTimon = r0;
        this.optScheduler = r0;
        this.optGLES = r0;
        this.boostRenderThread = r0;
        this.boostCpuAndGpuThread = r0;
        this.canBindBigCore = r0;
        this.optNitaPreload = r0;
        this.enableResourcePreheating = r0;
        this.enableFirstFeedDelayLoad = r0;
        this.optPreloadPipeline = r0;
    }
}
