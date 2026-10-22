package com.obric.memorydata.recommend.screenshotupload.sampling;

import android.content.Context;
import com.bytedance.apm6.util.constant.CommonConsts;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotContextData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotInputData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotOutputData;
import com.obric.memorydata.recommend.screenshotupload.i;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.sdk.screencapture.ScreenCaptureManager;
import com.obric.memorydata.sdk.screencapture.ScreenData;
import com.obric.memorydata.sdk.screencapture.TaskOptions;
import com.obric.memorydata.sdk.screencapture.rule.ScreenshotOption;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 22\u00020\u0001:\u00012B\u0096\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012_\b\u0002\u0010\b\u001aY\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\tj\u0002`\u0014\u0012\u0014\b\u0002\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\u0004\b\u0017\u0010\u0018J`\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010 \u001a\u00020!2\u0018\u0010\"\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0$0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020&0#2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u000eH\u0016JD\u0010+\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020(2\u0006\u0010 \u001a\u00020!2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0$2\u0006\u0010.\u001a\u00020&H\u0002J\f\u0010/\u001a\u000200*\u00020\u0011H\u0002J\f\u00101\u001a\u000200*\u00020&H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000Re\u0010\b\u001aY\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u0012!\u0012\u001f\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0012\u0004\u0012\u00020\u00120\u0010¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00120\tj\u0002`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampler;", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampling;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "coordinator", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingCoordinator;", "gate", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingGate;", "captureCurrent", "Lkotlin/Function3;", "Lcom/obric/memorydata/sdk/screencapture/TaskOptions;", "Lkotlin/ParameterName;", ActivityLifecycle.NAME, "taskOptions", "", "targetPackage", "Lkotlin/Function1;", "Lcom/obric/memorydata/sdk/screencapture/ScreenData;", "", "callback", "Lcom/obric/memorydata/recommend/screenshotupload/sampling/CaptureCurrent;", "processScreenshotData", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "<init>", "(Lkotlinx/coroutines/CoroutineScope;Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingCoordinator;Lcom/obric/memorydata/recommend/screenshotupload/sampling/ScreenshotSamplingGate;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function1;)V", "jobs", "Ljava/util/concurrent/ConcurrentHashMap;", "Lkotlinx/coroutines/Job;", CommonConsts.APM_INNER_EVENT_COST_START, "key", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "triggerType", "Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "extraMetaProvider", "Lkotlin/Function0;", "", "screenshotOptionProvider", "Lcom/obric/memorydata/sdk/screencapture/rule/ScreenshotOption;", "initialDelayMs", "", "intervalMs", "stop", "captureOnce", "timestamp", "extraMeta", "screenshotOption", "hasProcessableScreenshotResult", "", "isSafeForPeriodicTransport", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final a f12584a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final al f12585b;
    private final e c;
    private final g d;
    private final Function3<TaskOptions, String, Function1<? super ScreenData, Unit>, Unit> e;
    private final Function1<ScreenshotData, Unit> f;
    private final ConcurrentHashMap<String, bx> g;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/sampling/PeriodicScreenshotSampler$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12584a = new a(null);
    }

    public b(al r3, e r4, g r5, Function3<? super TaskOptions, ? super String, ? super Function1<? super ScreenData, Unit>, Unit> r6, Function1<? super ScreenshotData, Unit> r7) {
        al r8 = (al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin");
        Function3<TaskOptions, String, Function1<? super ScreenData, Unit>, Unit> r9 = (Function3) ZeusTransformUtils.wrapperContextForParams(r6, Function3.class, "com.obric.memorydata.plugin");
        Function1<ScreenshotData, Unit> r10 = (Function1) ZeusTransformUtils.wrapperContextForParams(r7, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r8, "scope");
        Intrinsics.checkNotNullParameter(r4, "coordinator");
        Intrinsics.checkNotNullParameter(r5, "gate");
        Intrinsics.checkNotNullParameter(r9, "captureCurrent");
        Intrinsics.checkNotNullParameter(r10, "processScreenshotData");
        this.f12585b = r8;
        this.c = r4;
        this.d = r5;
        this.e = r9;
        this.f = r10;
        this.g = new ConcurrentHashMap();
    }

    public /* synthetic */ b(al r8, e r9, g r10, Function3 r11, Function1 r12, int r13, DefaultConstructorMarker r14) {
        al r2 = (al) ZeusTransformUtils.wrapperContextForParams(r8, al.class, "com.obric.memorydata.plugin");
        Function3 r15 = (Function3) ZeusTransformUtils.wrapperContextForParams(r11, Function3.class, "com.obric.memorydata.plugin");
        Function1 r16 = (Function1) ZeusTransformUtils.wrapperContextForParams(r12, Function1.class, "com.obric.memorydata.plugin");
        if ((r13 & 8) == 0) goto L5;
        r15 = $$Lambda$b$UfiVDGTXCPNDWvlgK8Cx4RiWdA.INSTANCE;
    L5:
        Function3 r5 = r15;
        if ((r13 & 16) == 0) goto L8;
        Function1 r6 = $$Lambda$b$SFUCZxEo2id36S5mUk0bZLAvew.INSTANCE;
    L9:
        this(r2, r9, r10, r5, r6);
        return;
    L8:
        r6 = r16;
        goto L9
    }

    public static final /* synthetic */ g a(b r0) {
        return r0.d;
    }

    private static final Unit a(ScreenshotData r1) {
        Intrinsics.checkNotNullParameter(r1, "screenshotData");
        i.f12559a.a(r1);
        return Unit.INSTANCE;
    }

    private static final Unit a(TaskOptions r4, String r5, Function1 r6) {
        Function1<? super ScreenData, Unit> r7 = (Function1) ZeusTransformUtils.wrapperContextForParams(r6, Function1.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r4, "taskOptions");
        Intrinsics.checkNotNullParameter(r5, "targetPackage");
        Intrinsics.checkNotNullParameter(r7, "callback");
        ScreenCaptureManager.INSTANCE.captureCurrent((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"), r4, r5, r7);
        return Unit.INSTANCE;
    }

    private static final Unit a(String r22, b r23, String r24, long r25, TriggerUploadType r27, Map r28, ScreenData r29) {
        Map r16 = (Map) ZeusTransformUtils.wrapperContextForParams(r28, Map.class, "com.obric.memorydata.plugin");
        if (r29 != null) goto L10;
        IRunLog r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r3 = new StringBuilder();
    L5:
        String r0 = r3.append("capture skip reason=empty_result pkg=").append(r22).toString();
        Throwable r2 = null;
        int r4 = 4;
        Object r5 = null;
        IRunLog r26 = r1;
        String r210 = "PeriodicScreenshotSampler";
        String r211 = r0;
    L6:
        IRunLog.a.a(r26, r210, r211, r2, r4, r5);
    L8:
        return Unit.INSTANCE;
    L10:
        if (r29.getScreenshot() == null) goto L13;
        String r6 = "capture skip reason=bitmap_result pkg=" + r22;
        r2 = null;
        r4 = 4;
        r5 = null;
        r26 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r210 = "PeriodicScreenshotSampler";
        r211 = r6;
        goto L6
    L13:
        if (r23.a(r29) == true) goto L15;
        r1 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = new StringBuilder();
        goto L5
    L15:
        kotlinx.coroutines.i.a(r23.f12585b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PeriodicScreenshotSampler$captureOnce$1$1(r23, new ScreenshotData(new ScreenshotInputData(r24, r22, r25, r27, r29.getScreenshot(), r29.getHeifScreenshotPath(), null, null, r29.getHardwareBuffer(), null, null, null, null, r29.isVertical(), r16, 7872, null), new ScreenshotOutputData(null, new ScreenshotContextData(r25, com.obric.memorydata.recommend.context.b.a()), null, 5, null)), null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
        goto L8
    }

    private static final bx a(b r17, String r18, String r19, long r20, long r22, TriggerUploadType r24, String r25, Function0 r26, Function0 r27, String r28) {
        Function0 r12 = (Function0) ZeusTransformUtils.wrapperContextForParams(r26, Function0.class, "com.obric.memorydata.plugin");
        Function0 r13 = (Function0) ZeusTransformUtils.wrapperContextForParams(r27, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r28, "it");
        return kotlinx.coroutines.i.a(r17.f12585b, null, null, (Function2) ZeusTransformUtils.preCheckCast(new PeriodicScreenshotSampler$start$1$1(r18, r19, r20, r22, r17, r24, r25, r12, r13, null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    private static final bx a(Function1 r2, Object r3) {
        return (bx) ZeusTransformUtils.preCheckCast(((Function1) ZeusTransformUtils.wrapperContextForParams(r2, Function1.class, "com.obric.memorydata.plugin")).invoke(r3), bx.class, "com.obric.memorydata.plugin");
    }

    public static final /* synthetic */ void a(b r8, String r9, String r10, long r11, TriggerUploadType r13, Map r14, ScreenshotOption r15) {
        r8.a(r9, r10, r11, r13, (Map) ZeusTransformUtils.wrapperContextForParams(r14, Map.class, "com.obric.memorydata.plugin"), r15);
    }

    private final void a(final String r16, final String r17, final long r18, final TriggerUploadType r20, Map<String, String> r21, ScreenshotOption r22) {
        final Map r7 = (Map) ZeusTransformUtils.wrapperContextForParams(r21, Map.class, "com.obric.memorydata.plugin");
        if (a(r22) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PeriodicScreenshotSampler", "capture skip reason=unsafe_screenshot_option pkg=" + r17, null, 4, null);
        return;
    L6:
        IRunLog r9 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r1 = new StringBuilder().append("capture start reason=");
        String r3 = (String) ZeusTransformUtils.preCheckCast(r7.get("capture_reason"), String.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L9;
        r3 = "";
    L9:
        IRunLog.a.a(r9, "PeriodicScreenshotSampler", r1.append(r3).append(" pkg=").append(r17).toString(), false, 4, null);
        this.e.invoke(new TaskOptions(r22, null), r17, new $$Lambda$b$E7nHkVVLR1psmqHswmydJHuddE4(r17, this, r16, r18, r20, r7));
    }

    private final boolean a(ScreenData r4) {
        if (r4.getHardwareBuffer() != null) goto L13;
        CharSequence r3 = (CharSequence) ZeusTransformUtils.preCheckCast(r4.getHeifScreenshotPath(), CharSequence.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L7;
    L10:
        boolean r5 = true;
    L11:
        if (r5 == false) goto L13;
        return false;
    L7:
        if (StringsKt.isBlank(r3) == true) goto L10;
        r5 = false;
    L13:
        return true;
    }

    private final boolean a(ScreenshotOption r4) {
        if (r4.getHeifOutput() == null) goto L6;
        return true;
    L6:
        if (r4.getUseHardwareBuffer() == false) goto L19;
        if (r4.getOnlyAppWindow() == true) goto L19;
        Collection r3 = (Collection) ZeusTransformUtils.preCheckCast(r4.getExcludeLayerPackages(), Collection.class, "com.obric.memorydata.plugin");
        if (r3 != null) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L19;
        return true;
    L12:
        if (r3.isEmpty() == true) goto L15;
        r5 = false;
    L19:
        return false;
    }

    public static final /* synthetic */ e b(b r0) {
        return r0.c;
    }

    public static final /* synthetic */ Function1 c(b r0) {
        return r0.f;
    }

    public static /* synthetic */ Unit lambda$E7nHkVVLR1psmqHswmydJHuddE4(String r0, b r1, String r2, long r3, TriggerUploadType r5, Map r6, ScreenData r7) {
        return a(r0, r1, r2, r3, r5, r6, r7);
    }

    /* JADX INFO: renamed from: lambda$SFUCZxEo2id36S5mU-k0bZLAvew, reason: not valid java name */
    public static /* synthetic */ Unit m1126lambda$SFUCZxEo2id36S5mUk0bZLAvew(ScreenshotData r0) {
        return a(r0);
    }

    public static /* synthetic */ bx lambda$TyzbB6XUqqSNlZNKETIipdLOclc(Function1 r0, Object r1) {
        return a(r0, r1);
    }

    /* JADX INFO: renamed from: lambda$UfiVDGTXCP-NDWvlgK8Cx4RiWdA, reason: not valid java name */
    public static /* synthetic */ Unit m1127lambda$UfiVDGTXCPNDWvlgK8Cx4RiWdA(TaskOptions r0, String r1, Function1 r2) {
        return a(r0, r1, r2);
    }

    public static /* synthetic */ bx lambda$phwUnF7qKaDdwFFJKK27k0e_6oM(b r0, String r1, String r2, long r3, long r5, TriggerUploadType r7, String r8, Function0 r9, Function0 r10, String r11) {
        return a(r0, r1, r2, r3, r5, r7, r8, r9, r10, r11);
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.sampling.c
    public void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "key");
        bx r1 = (bx) ZeusTransformUtils.preCheckCast(this.g.remove(r2), bx.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        bx.a.a(r1, null, 1, null);
        return;
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.sampling.c
    public void a(final String r16, final String r17, final String r18, final TriggerUploadType r19, Function0<? extends Map<String, String>> r20, Function0<ScreenshotOption> r21, final long r22, final long r24) {
        final Function0 r10 = (Function0) ZeusTransformUtils.wrapperContextForParams(r20, Function0.class, "com.obric.memorydata.plugin");
        final Function0 r11 = (Function0) ZeusTransformUtils.wrapperContextForParams(r21, Function0.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r16, "key");
        Intrinsics.checkNotNullParameter(r17, "appName");
        Intrinsics.checkNotNullParameter(r18, ObricMemoryConstants.KEY_PACKAGE_NAME);
        Intrinsics.checkNotNullParameter(r19, "triggerType");
        Intrinsics.checkNotNullParameter(r10, "extraMetaProvider");
        Intrinsics.checkNotNullParameter(r11, "screenshotOptionProvider");
        ConcurrentHashMap<String, bx> r13 = this.g;
        final Function1 r14 = new $$Lambda$b$phwUnF7qKaDdwFFJKK27k0e_6oM(this, r16, r18, r24, r22, r19, r17, r10, r11);
        r13.computeIfAbsent(r16, new $$Lambda$b$TyzbB6XUqqSNlZNKETIipdLOclc(r14));
    }
}
