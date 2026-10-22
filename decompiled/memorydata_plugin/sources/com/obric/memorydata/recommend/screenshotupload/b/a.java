package com.obric.memorydata.recommend.screenshotupload.b;

import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.device.DeviceInfoState;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.middleware.api.logging.r;
import com.obric.memorydata.middleware.api.logging.s;
import com.obric.memorydata.recommend.context.ContextManager;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotContextData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotInputData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotOutputData;
import com.obric.memorydata.recommend.screenshotupload.f;
import com.obric.memorydata.recommend.useraction.recommend.TriggerUploadType;
import com.obric.memorydata.sdk.screencapture.event.ScreenTouchEvent;
import com.obric.memorydata.utils.n;
import com.obric.memorydata.utils.u;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 $2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0016J\u001a\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0002J\u0016\u0010\u001c\u001a\u00020\u001d2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00020\u0016H\u0002J\u001c\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00062\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0014\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002J\u001c\u0010\"\u001a\u00020\u001d2\u0012\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0002R'\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR'\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000b\u001a\u0004\b\r\u0010\tR\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/FillScreenshotContextPipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/Pipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "<init>", "()V", "portraitScreenSize", "Lkotlin/Pair;", "", "getPortraitScreenSize", "()Lkotlin/Pair;", "portraitScreenSize$delegate", "Lkotlin/Lazy;", "landscapeScreenSize", "getLandscapeScreenSize", "landscapeScreenSize$delegate", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "process", "", "input", "Lcom/obric/memorydata/recommend/screenshotupload/RequestData;", "getTriggerTiming", "triggerUploadType", "Lcom/obric/memorydata/recommend/useraction/recommend/TriggerUploadType;", "touchAction", "Lcom/obric/memorydata/sdk/screencapture/event/ScreenTouchEvent$TouchAction;", "setupAction", "", "getScreenSize", "inputData", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotInputData;", "readPortraitScreenSize", "reportScreenSizeMismatch", "size", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a extends com.obric.memorydata.recommend.screenshotupload.c<ScreenshotData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0678a f12544a = null;
    private static final Pair<Integer, Integer> d = null;
    private static final AtomicBoolean e = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Lazy f12545b;
    private final Lazy c;

    /* JADX INFO: renamed from: com.obric.memorydata.recommend.screenshotupload.b.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/FillScreenshotContextPipeline$Companion;", "", "<init>", "()V", "TAG", "", "fallbackScreenSize", "Lkotlin/Pair;", "", "screenSizeMismatchReportAttempted", "Ljava/util/concurrent/atomic/AtomicBoolean;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0678a {
        private C0678a() {
        }

        public /* synthetic */ C0678a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f12546a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ int[] f12547b = null;

        static {
            int[] r0 = new int[ScreenTouchEvent.TouchAction.values().length];
            r0[ScreenTouchEvent.TouchAction.TAP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L23
        L43:
            r0[ScreenTouchEvent.TouchAction.DOUBLE_TAP.ordinal()] = 2;     // Catch: NoSuchFieldError -> L24
        L57:
            r0[ScreenTouchEvent.TouchAction.LONG_PRESS.ordinal()] = 3;     // Catch: NoSuchFieldError -> L25
        L45:
            r0[ScreenTouchEvent.TouchAction.SCROLL_START.ordinal()] = 4;     // Catch: NoSuchFieldError -> L26
        L47:
            r0[ScreenTouchEvent.TouchAction.SCROLLED.ordinal()] = 5;     // Catch: NoSuchFieldError -> L27
        L35:
            r0[ScreenTouchEvent.TouchAction.BACK_KEY.ordinal()] = 6;     // Catch: NoSuchFieldError -> L28
        L14:
            f12546a = r0;
            int[] r1 = new int[TriggerUploadType.values().length];
            r1[TriggerUploadType.AppOpen.ordinal()] = 1;     // Catch: NoSuchFieldError -> L29
        L53:
            r1[TriggerUploadType.AppClose.ordinal()] = 2;     // Catch: NoSuchFieldError -> L30
        L39:
            r1[TriggerUploadType.ImeHide.ordinal()] = 3;     // Catch: NoSuchFieldError -> L31
        L51:
            r1[TriggerUploadType.Action.ordinal()] = 4;     // Catch: NoSuchFieldError -> L32
        L37:
            r1[TriggerUploadType.CameraForegroundSample.ordinal()] = 5;     // Catch: NoSuchFieldError -> L33
        L49:
            r1[TriggerUploadType.VideoPlaybackSample.ordinal()] = 6;     // Catch: NoSuchFieldError -> L34
        L21:
            f12547b = r1;
        }
    }

    static {
        f12544a = new C0678a(null);
        d = TuplesKt.to(1264, 2800);
        e = new AtomicBoolean(false);
    }

    public a() {
        this.f12545b = LazyKt.lazy(new $$Lambda$a$RZn_mHPvug4YRTEx_rbSExbPrnk(this));
        this.c = LazyKt.lazy(new $$Lambda$a$EfSxWpJrtqrOX8yatzS_KqgtvEg(this));
    }

    private final String a(TriggerUploadType r1, ScreenTouchEvent.TouchAction r2) {
        switch(b.f12547b[r1.ordinal()]) {
            case 1: goto L25;
            case 2: goto L23;
            case 3: goto L21;
            case 4: goto L9;
            case 5: goto L7;
            case 6: goto L5;
            default: goto L4;
        };
    L4:
        return "";
    L5:
        return "video_playback_sample";
    L7:
        return "camera_foreground_sample";
    L9:
        if (r2 != null) goto L11;
        return "";
    L11:
        switch(b.f12546a[r2.ordinal()]) {
            case 1: goto L18;
            case 2: goto L17;
            case 3: goto L16;
            case 4: goto L15;
            case 5: goto L15;
            case 6: goto L14;
            default: goto L13;
        };
    L14:
        return "back_gesture";
    L15:
        return "scroll_screen";
    L16:
        return "long_press_screen";
    L17:
        return "double_tap_screen";
    L18:
        return "tap_screen";
    L13:
        throw new NoWhenBranchMatchedException();
    L21:
        return "close_keyboard";
    L23:
        return "app_close";
    L25:
        return "app_open";
    }

    private final Pair<Integer, Integer> a() {
        return (Pair) ZeusTransformUtils.preCheckCast(this.f12545b.getValue(), Pair.class, "com.obric.memorydata.plugin");
    }

    private static final Pair a(a r0) {
        return r0.c();
    }

    private final Pair<Integer, Integer> a(ScreenshotInputData r1) {
        if (r1.isVertical() == false) goto L6;
        return a();
    L6:
        return b();
    }

    private final void a(Pair<Integer, Integer> r7) {
        String r0 = DeviceInfoState.INSTANCE.getDeviceModel();     // Catch: RuntimeException -> L16
        if (com.obric.memorydata.utils.b.a(r0) == true) goto L8;
        if (com.obric.memorydata.utils.b.c(r0) == true) goto L8;
        return;
    L8:
        if (e.compareAndSet(false, true) == true) goto L11;
        return;
    L11:
        if (com.obric.memorydata.utils.b.a(r0) == false) goto L13;
        String r1 = "pacific";
    L14:
        com.bytedance.services.apm.api.a.a("screen_size_mismatch device_category=" + r1 + " expected_width=1264 expected_height=2800 actual_width=" + ((Number) ZeusTransformUtils.preCheckCast(r7.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue() + " actual_height=" + ((Number) ZeusTransformUtils.preCheckCast(r7.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue());     // Catch: RuntimeException -> L16
        return;
    L13:
        r1 = "n1";
    L16:
        ((o) ZeusTransformUtils.preCheckCast(s.f11634a, o.class, "com.obric.memorydata.plugin")).a("screen_size_report_failed", "屏幕尺寸异常上报失败，继续使用实际尺寸", new e(null, null, null, 7, null), new g().a());
    }

    private final Pair<Integer, Integer> b() {
        return (Pair) ZeusTransformUtils.preCheckCast(this.c.getValue(), Pair.class, "com.obric.memorydata.plugin");
    }

    private static final Pair b(a r3) {
        Pair<Integer, Integer> r4 = r3.a();
        int r0 = ((Number) ZeusTransformUtils.preCheckCast(r4.component1(), Number.class, "com.obric.memorydata.plugin")).intValue();
        return TuplesKt.to(Integer.valueOf(((Number) ZeusTransformUtils.preCheckCast(r4.component2(), Number.class, "com.obric.memorydata.plugin")).intValue()), Integer.valueOf(r0));
    }

    private final void b(f<ScreenshotData> r7) {
        ScreenshotInputData r0 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r7.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getInputData();
        ScreenshotOutputData r1 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r7.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getOutputData();
        ScreenTouchEvent.TouchAction r3 = r0.getTouchAction();
        if (r3 == null) goto L6;
        ((ScreenshotData) ZeusTransformUtils.preCheckCast(r7.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getOutputData().getContextData().setTouchAction(r3.toString());
    L6:
        if (r0.getTouchAction() != ScreenTouchEvent.TouchAction.TAP) goto L8;
    L32:
        com.obric.memorydata.recommend.useraction.recommend.a r8 = r0.getActionPosition();
        if (r8 == null) goto L39;
        Pair<Integer, Integer> r6 = a(r0);
        int r2 = ((Number) ZeusTransformUtils.preCheckCast(r6.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r9 = ((Number) ZeusTransformUtils.preCheckCast(r6.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue();
        ScreenshotContextData r4 = r1.getContextData();
        JSONObject r5 = new JSONObject();
        r5.put("x", Float.valueOf(r8.a() / r2));
        r5.put("y", Float.valueOf(r8.b() / r9));
        r4.setClickDetail(u.a(r5));
        return;
    L39:
        return;
    L8:
        if (r0.getTouchAction() == ScreenTouchEvent.TouchAction.DOUBLE_TAP) goto L32;
        if (r0.getTouchAction() == ScreenTouchEvent.TouchAction.LONG_PRESS) goto L32;
        if (r0.getTouchAction() != ScreenTouchEvent.TouchAction.SCROLLED) goto L36;
        Pair<Integer, Integer> r10 = a(r0);
        int r11 = ((Number) ZeusTransformUtils.preCheckCast(r10.getFirst(), Number.class, "com.obric.memorydata.plugin")).intValue();
        int r12 = ((Number) ZeusTransformUtils.preCheckCast(r10.getSecond(), Number.class, "com.obric.memorydata.plugin")).intValue();
        ScreenTouchEvent.ScrollDirection r13 = r0.getScrollDirection();
        if (r13 == null) goto L37;
        ScreenshotContextData r14 = r1.getContextData();
        JSONObject r15 = new JSONObject();
        r15.put("scrollDirection", r13.toString());
        com.obric.memorydata.recommend.useraction.recommend.a r16 = r0.getActionPosition();
        float r17 = 0.0f;
        if (r16 == null) goto L19;
        float r18 = r16.a();
    L20:
        float r19 = r11;
        r15.put("beginX", Float.valueOf(r18 / r19));
        com.obric.memorydata.recommend.useraction.recommend.a r20 = r0.getActionPosition();
        if (r20 == null) goto L23;
        float r21 = r20.b();
    L24:
        float r22 = r12;
        r15.put("beginY", Float.valueOf(r21 / r22));
        com.obric.memorydata.recommend.useraction.recommend.a r23 = r0.getActionEndPosition();
        if (r23 == null) goto L27;
        float r24 = r23.a();
    L28:
        r15.put("endX", Float.valueOf(r24 / r19));
        com.obric.memorydata.recommend.useraction.recommend.a r25 = r0.getActionEndPosition();
        if (r25 == null) goto L31;
        r17 = r25.b();
    L31:
        r15.put("endY", Float.valueOf(r17 / r22));
        r14.setScrollDetail(u.a(r15));
        return;
    L27:
        r24 = 0.0f;
        goto L28
    L23:
        r21 = 0.0f;
        goto L24
    L19:
        r18 = 0.0f;
        goto L20
    L37:
        return;
    }

    private final Pair<Integer, Integer> c() {
        Pair<Integer, Integer> r0 = com.obric.memorydata.utils.e.a.f13206a.c();
        if (r0 != null) goto L7;
        ((o) ZeusTransformUtils.preCheckCast(r.f11633a, o.class, "com.obric.memorydata.plugin")).a("screen_size_unavailable", "屏幕尺寸不可用，使用默认尺寸", new e(null, null, null, 7, null), new g().a());
        return d;
    L7:
        if (Intrinsics.areEqual(r0, d) == true) goto L9;
        a(r0);
    L9:
        return r0;
    }

    public static /* synthetic */ Pair lambda$EfSxWpJrtqrOX8yatzS_KqgtvEg(a r0) {
        return b(r0);
    }

    public static /* synthetic */ Pair lambda$RZn_mHPvug4YRTEx_rbSExbPrnk(a r0) {
        return a(r0);
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.c
    public boolean a(f<ScreenshotData> r19) {
        Intrinsics.checkNotNullParameter(r19, "input");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FillScreenshotPipeline", "FillScreenshotContextPipeline Run", false, 4, null);
        ScreenshotInputData r0 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r19.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getInputData();
        ScreenshotOutputData r2 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r19.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getOutputData();
        r2.getContextData().setAppName(r0.getAppName());
        ScreenshotContextData r4 = r2.getContextData();
        if (ContextManager.INSTANCE.isWorkingDay(System.currentTimeMillis()) == false) goto L5;
        String r5 = "工作日";
    L6:
        r4.setDayType(r5);
        com.obric.memorydata.utils.o r6 = n.f13250a.a();
        ScreenshotContextData r7 = r2.getContextData();
        r7.setLocation("");
        r7.setLocationState("");
        r7.setLongitude(0.0d);
        r7.setLatitude(0.0d);
        r7.setMovementState("");
        if (r6.b() == false) goto L13;
        Object r8 = FeatureManager.INSTANCE.getFeature("har_activity_state");
        if (r8 == null) goto L13;
        if (ZeusTransformUtils.instanceOf(r8, Integer.class) == false) goto L13;
        r2.getContextData().setMovementState(com.obric.memorydata.sdk.awareness.b.f12819a.a((Integer) ZeusTransformUtils.preCheckCast(r8, Integer.class, "com.obric.memorydata.plugin")));
    L13:
        boolean r9 = false;
        if (r6.a() == false) goto L28;
        Object r10 = FeatureManager.INSTANCE.getFeature("commute_state");
        if (r10 != null) goto L18;
    L25:
        com.obric.memorydata.recommend.screenshotupload.a.a r11 = com.obric.memorydata.recommend.screenshotupload.a.b.f12540a.b();
        if (r11 == null) goto L28;
        r2.getContextData().setLocation(r11.c());
        r2.getContextData().setLongitude(r11.a());
        r2.getContextData().setLatitude(r11.b());
        goto L28
    L18:
        if (ZeusTransformUtils.instanceOf(r10, String.class) == false) goto L25;
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L22;
        boolean r12 = true;
    L23:
        if (r12 == false) goto L25;
        r2.getContextData().setLocationState(com.obric.memorydata.sdk.awareness.b.f12819a.a((String) ZeusTransformUtils.preCheckCast(r10, String.class, "com.obric.memorydata.plugin")));
        goto L25
    L22:
        r12 = false;
    L28:
        Tracker r13 = Tracker.INSTANCE;
        String r14 = OsTeaTrackerEventId.MEMORY_HAR_AND_LOCATION_STATE_EVENT.getValue();
        JSONObject r15 = new JSONObject();
        r15.put(Api.KEY_APP_NAME, r0.getAppName());
        r15.put("package_name", r0.getPackageName());
        r15.put("har_state", r2.getContextData().getMovementState());
        r15.put("location_state", r2.getContextData().getLocationState());
        Unit r16 = Unit.INSTANCE;
        r13.reportEvent(r14, r15);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "FillScreenshotPipeline", "===>Har state: " + r2.getContextData().getMovementState() + " location State: " + r2.getContextData().getLocationState(), false, 4, null);
        b(r19);
        r2.getContextData().setExtraMeta(r0.getExtraMeta());
        String r1 = a(r0.getTriggerUploadType(), r0.getTouchAction());
        if (((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")).length() <= 0) goto L31;
        r9 = true;
    L31:
        if (r9 == false) goto L33;
        r2.getContextData().setTriggerType(r1);
        Tracker r3 = Tracker.INSTANCE;
        JSONObject r17 = new JSONObject();
        r17.put("execute_type", "screenshot");
        r17.put("trigger_timing", r1);
        r17.put(Api.KEY_APP_NAME, ((ScreenshotData) ZeusTransformUtils.preCheckCast(r19.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getInputData().getAppName());
        r17.put("package_name", ((ScreenshotData) ZeusTransformUtils.preCheckCast(r19.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getInputData().getPackageName());
        Unit r18 = Unit.INSTANCE;
        r3.reportEvent("proactive_collect_data", r17);
    L33:
        return true;
    L5:
        r5 = "节假日";
        goto L6
    }
}
