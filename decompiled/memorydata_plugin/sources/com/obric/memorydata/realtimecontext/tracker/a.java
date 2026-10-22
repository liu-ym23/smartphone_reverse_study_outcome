package com.obric.memorydata.realtimecontext.tracker;

import android.content.ComponentName;
import com.bytedance.bdinstall.oaid.OaidModel;
import com.obric.memorydata.constants.DevTrackerEventId;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.ah;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 #2\u00020\u0001:\u0001#B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000e\u001a\u00020\u000fJ:\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00132\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aJ\u001e\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001eJ\u0016\u0010\u001f\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\fJ\u0010\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\fH\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/obric/memorydata/realtimecontext/tracker/OnScreenTracker;", "", "<init>", "()V", "onCaptureRunId", "Ljava/util/concurrent/atomic/AtomicInteger;", "getOnCaptureRunId", "()Ljava/util/concurrent/atomic/AtomicInteger;", "setOnCaptureRunId", "(Ljava/util/concurrent/atomic/AtomicInteger;)V", "onCaptureIdToTrackerData", "", "", "Lcom/obric/memorydata/realtimecontext/tracker/OnScreenTrackerData;", "clearData", "", "updateCaptureStartTime", "onCaptureId", "startTime", "", "captureType", "Lcom/obric/memorydata/realtimecontext/tracker/ScreenMsgCaptureType;", "assistStartTime", "componentName", "Landroid/content/ComponentName;", "linkType", "Lcom/obric/memorydata/realtimecontext/session/RealTimeContextLink;", "updateCaptureEndTime", "endTime", "fromCache", "", "updateQueryTime", OaidModel.KEY_TIME, "type", "uploadIfNeed", "Companion", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final C0665a f12487a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicInteger f12488b;
    private Map<Integer, b> c;

    /* JADX INFO: renamed from: com.obric.memorydata.realtimecontext.tracker.a$a, reason: collision with other inner class name */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/realtimecontext/tracker/OnScreenTracker$Companion;", "", "<init>", "()V", "TAG", "", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class C0665a {
        private C0665a() {
        }

        public /* synthetic */ C0665a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f12487a = new C0665a(null);
    }

    public a() {
        this.f12488b = new AtomicInteger(0);
        this.c = (Map) ZeusTransformUtils.preCheckCast(new LinkedHashMap(), Map.class, "com.obric.memorydata.plugin");
    }

    private final void a(int r18) {
        b r0 = (b) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r18)), b.class, "com.obric.memorydata.plugin");
        if (r0 != null) goto L5;
        return;
    L5:
        long r3 = r0.d() - r0.f();
        long r5 = r0.a() - r0.f();
        long r7 = r0.b() - r0.a();
        if (r0.a() != 0) goto L8;
        return;
    L8:
        if (r0.b() != 0) goto L10;
        return;
    L10:
        if (r0.f() != 0) goto L12;
        return;
    L12:
        if (r0.d() != 0) goto L14;
        return;
    L14:
        if (r3 >= 0) goto L16;
        return;
    L16:
        if (r5 >= 0) goto L18;
        return;
    L18:
        if (r7 >= 0) goto L20;
        return;
    L20:
        if (r0.i() == null) goto L42;
        long r9 = Math.max(r0.b() - r0.d(), 0);
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OnScreenTracker", "upload id: " + r18 + " deltaTime: " + r9 + ", getAssistCost: " + r5 + ", captureCost: " + r7 + ", queryCost: " + r3, false, 4, null);
        DevTrackerEventId r1 = DevTrackerEventId.AWARE_ON_SCREEN_NER_QUERY_DELTA;
        JSONObject r2 = new JSONObject();
        r2.put("capture_type", r0.c().toString());
        r2.put("capture_cost_time", r7);
        r2.put("delta_time", r9);
        r2.put("query_cost", r3);
        r2.put("query_type", r0.e());
        r2.put("assist_data_total_cost", r5);
        r2.put("total_cost", r0.b() - r0.f());
        r2.put("from_cache", r0.g());
        ComponentName r4 = r0.h();
        String r6 = "";
        if (r4 == null) goto L26;
        String r8 = r4.getPackageName();
        if (r8 == null) goto L26;
    L27:
        r2.put("package_name", r8);
        ComponentName r10 = r0.h();
        if (r10 == null) goto L33;
        String r11 = r10.getClassName();
        if (r11 == null) goto L33;
        r6 = r11;
    L33:
        r2.put("activity_name", r6);
        r2.put("realtime_context_link", String.valueOf(r0.i()));
        ah.a(r1, r2);
        return;
    L26:
        r8 = "";
        goto L27
    }

    public final void a() {
        this.c.clear();
    }

    public final void a(long r11, int r13) {
        int r0 = this.f12488b.get();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "OnScreenTracker", "updateQueryTime: id: " + r0 + " endTime: " + r11, false, 4, null);
        b r1 = (b) ZeusTransformUtils.preCheckCast(this.c.get(Integer.valueOf(r0)), b.class, "com.obric.memorydata.plugin");
        if (r1 == null) goto L6;
        r1.a(r11);
        r1.a(r13);
        a(r0);
        return;
    }
}
