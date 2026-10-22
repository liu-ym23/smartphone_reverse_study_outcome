package com.obric.memorydata.recommend.screenshotupload.b;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.bytedance.bdinstall.Api;
import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.aiagent.product.platform.api.memory.ObricMemoryConstants;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.observation.api.ObservationIngestService;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotInputData;
import com.obric.memorydata.recommend.screenshotupload.data.ScreenshotOutputData;
import com.obric.memorydata.recommend.screenshotupload.e;
import com.obric.memorydata.recommend.screenshotupload.f;
import com.obric.memorydata.recommend.settings.p;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.utils.n;
import com.obric.memorydata.utils.o;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000 \u00132\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0016J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0006H\u0002R\u0014\u0010\u0005\u001a\u00020\u0006X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/SaveDatabasePipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/Pipeline;", "Lcom/obric/memorydata/recommend/screenshotupload/data/ScreenshotData;", "<init>", "()V", ActivityLifecycle.NAME, "", "getName", "()Ljava/lang/String;", "process", "", "input", "Lcom/obric/memorydata/recommend/screenshotupload/RequestData;", "reportCollectScreenshotEvent", "", "appName", ObricMemoryConstants.KEY_PACKAGE_NAME, "triggerType", TypedValues.AttributesType.S_TARGET, "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class b extends com.obric.memorydata.recommend.screenshotupload.c<ScreenshotData> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12548a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f12549b;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/recommend/screenshotupload/pipeline/SaveDatabasePipeline$Companion;", "", "<init>", "()V", "TAG", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12548a = new a(null);
    }

    public b() {
        this.f12549b = "SaveDatabase";
    }

    private final void a(String r4, String r5, String r6, String r7) {
        Tracker r3 = Tracker.INSTANCE;
        String r0 = OsTeaTrackerEventId.MEMORY_COLLECT_SCREENSHOT_DATA_EVENT.getValue();
        JSONObject r1 = new JSONObject();
        r1.put(Api.KEY_APP_NAME, r4);
        r1.put("package_name", r5);
        r1.put("trigger_timing", r6);
        r1.put(TypedValues.AttributesType.S_TARGET, r7);
        Unit r8 = Unit.INSTANCE;
        r3.reportEvent(r0, r1);
    }

    @Override // com.obric.memorydata.recommend.screenshotupload.c
    public boolean a(f<ScreenshotData> r40) {
        Intrinsics.checkNotNullParameter(r40, "input");
        RunLog.INSTANCE.debug("SaveDatabasePipeline", "SaveDatabasePipeline Run");
        ScreenshotInputData r0 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r40.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getInputData();
        ScreenshotOutputData r1 = ((ScreenshotData) ZeusTransformUtils.preCheckCast(r40.a(), ScreenshotData.class, "com.obric.memorydata.plugin")).getOutputData();
        if (com.obric.memorydata.recommend.screenshotupload.b.f12542a.b(r0.getPackageName()) == false) goto L58;
        String r7 = null;
        com.obric.memorydata.utils.c.a r2 = com.obric.memorydata.utils.c.a(com.obric.memorydata.utils.c.f13193a, r0.getPackageName(), null, 2, null);
        if (r2 == null) goto L13;
        String r5 = r2.a();
        if (r5 == null) goto L13;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r5, CharSequence.class, "com.obric.memorydata.plugin"))) == true) goto L12;
        r5 = null;
    L12:
        if (r5 == null) goto L13;
    L14:
        String r12 = r5;
        o r6 = n.f13250a.a();
        ObservationIngestService r8 = ObservationIngestService.INSTANCE;
        long r9 = r0.getTimestamp();
        String r11 = r1.getContextData().getTriggerType();
        String r13 = r0.getPackageName();
        String r14 = r1.getScreenshotPath();
        String r10 = r1.getContextData().getLocation();
        if (r6.a() == true) goto L19;
        r10 = null;
    L19:
        if (r10 != null) goto L21;
        String r16 = "";
    L22:
        String r15 = r1.getContextData().getLocationState();
        if (r6.a() == true) goto L26;
        r15 = null;
    L26:
        if (r15 != null) goto L28;
        String r17 = "";
    L29:
        String r18 = r1.getContextData().getMovementState();
        if (r6.b() == true) goto L33;
        r18 = null;
    L33:
        if (r18 != null) goto L35;
        String r19 = "";
    L36:
        String r110 = r1.getContextData().getClickDetail();
        String r20 = r1.getContextData().getScrollDetail();
        String r21 = r0.getViewTreePath();
        if (r21 != null) goto L39;
        String r22 = "";
    L40:
        Map<String, String> r23 = r1.getContextData().getExtraMeta();
        if (r2 == null) goto L43;
        r7 = r2.c();
    L43:
        if (r7 != null) goto L45;
        String r24 = "";
    L47:
        if (r2 == null) goto L49;
        long r25 = r2.b();
    L50:
        long r26 = r8.writeScreenshot(new com.obric.memorydata.observation.api.b(r9, r11, r12, r13, r14, "", r16, r17, r19, r110, r20, "", r22, r23, r24, r25));
        if (r26 <= 0) goto L57;
        MemoryService r30 = MemoryService.INSTANCE;
        long r33 = r0.getTimestamp();
        String r35 = r0.getPackageName();
        String r36 = r1.getScreenshotPath();
        String r3 = r0.getViewTreePath();
        if (r3 != null) goto L55;
        String r37 = "";
    L56:
        r30.associateInAppTraceWithScreenshot(r26, r33, r35, r36, r37, r1.getInAppSignalFlushRequestId());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "SaveDatabasePipeline", "in-app trace association scheduled observationId=" + r26 + " screenshotTimestamp=" + r0.getTimestamp(), false, 4, null);
        goto L57
    L55:
        r37 = r3;
    L57:
        com.obric.memorydata.recommend.screenshotupload.sampling.f.f12589a.a().a(r0.getPackageName(), r0.getTimestamp());
        a(r0.getAppName(), r0.getPackageName(), r1.getContextData().getTriggerType(), "screenObservation");
        e.f12556a.a(t.f12630a.n(), p.f12618a.a()).a();
        goto L58
    L49:
        r25 = 0;
        goto L50
    L45:
        r24 = r7;
        goto L47
    L39:
        r22 = r21;
        goto L40
    L35:
        r19 = r18;
        goto L36
    L28:
        r17 = r15;
        goto L29
    L21:
        r16 = r10;
    L13:
        r5 = r0.getAppName();
    L58:
        return true;
    }
}
