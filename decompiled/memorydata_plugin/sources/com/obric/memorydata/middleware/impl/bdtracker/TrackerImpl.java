package com.obric.memorydata.middleware.impl.bdtracker;

import android.content.ContentProviderClient;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import com.bytedance.applog.AppLog;
import com.bytedance.crash.Ensure;
import com.obric.cae.userAware.WifiScanStateMachine;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.database.entity.PendingMemoryCalendar;
import com.obric.memorydata.middleware.api.DataInterceptor;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.bdtracker.ITracker;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStore;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0000H\u0007J\u0018\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J%\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0012H\u0000¢\u0006\u0002\b\u001cJ\u0018\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u0019H\u0016J$\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020 0\nH\u0016J\u0010\u0010!\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0010H\u0016J\u0010\u0010#\u001a\u00020\u00162\u0006\u0010\"\u001a\u00020\u0010H\u0016J\b\u0010$\u001a\u00020\u0016H\u0016J\u0018\u0010%\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010*\u001a\u00020\u00122\u0006\u0010+\u001a\u00020\u0005H\u0002J\"\u0010,\u001a\u00020\u00162\u0006\u0010+\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010-\u001a\u00020.H\u0002J\u0018\u0010/\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000RP\u0010\u000e\u001aB\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00120\u0012 \u0011* \u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n \u0011*\u0004\u0018\u00010\u00120\u0012\u0018\u00010\u000f0\u000fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/memorydata/middleware/impl/bdtracker/TrackerImpl;", "Lcom/obric/memorydata/middleware/api/bdtracker/ITracker;", "<init>", "()V", PendingMemoryCalendar.TYPE_EVENT, "", "PARAMS", "TAG", "DAILY_REPORT_LAST_TIME_KEY", "EVENT_RATE_LIMIT_CONFIG", "", "", "eventLastReportTime", "Ljava/util/concurrent/ConcurrentHashMap;", "dailyCallbacks", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "Lcom/obric/memorydata/middleware/api/bdtracker/DailyReportCallback;", "kotlin.jvm.PlatformType", "", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "getInst", "reportEvent", "", "event", TrackerImpl.PARAMS, "Lorg/json/JSONObject;", "reportEventAccepted", "ignoreRateLimit", "reportEvent$middleware_impl_obricRelease", "reportDevEvent", "data", "reportWithSystemId", "", "registerDailyReportCallback", "callback", "unregisterDailyReportCallback", "startDailyReport", "registerReportEventRejectedHandler", "handler", "Lcom/obric/memorydata/middleware/api/bdtracker/ReportEventRejectedHandler;", "MEMORY_URI", "Landroid/net/Uri;", "shouldReportEvent", "eventName", "checkParamsSize", "maxSizeInBytes", "", "reportEventRpc", "middleware_impl_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TrackerImpl implements ITracker {
    private static final String DAILY_REPORT_LAST_TIME_KEY = "tracker_daily_report_last_time";
    public static final String EVENT = "event";
    private static final Map<String, Long> EVENT_RATE_LIMIT_CONFIG = null;
    public static final TrackerImpl INSTANCE = null;
    private static final Uri MEMORY_URI = null;
    public static final String PARAMS = "params";
    private static final String TAG = "TrackerImpl";
    private static final ConcurrentHashMap.KeySetView<com.obric.memorydata.middleware.api.bdtracker.a, Boolean> dailyCallbacks = null;
    private static final ConcurrentHashMap<String, Long> eventLastReportTime = null;

    static {
        INSTANCE = new TrackerImpl();
        EVENT_RATE_LIMIT_CONFIG = MapsKt.mapOf(new Pair[]{TuplesKt.to("video_frame_embedding_perf_event", 5000L), TuplesKt.to("image_embedding_perf_event", 5000L), TuplesKt.to("text_embedding_perf_event", 5000L), TuplesKt.to("entity_index_perf_event", 5000L), TuplesKt.to("entity_index_dashboard_latency", 5000L)});
        eventLastReportTime = new ConcurrentHashMap();
        dailyCallbacks = ConcurrentHashMap.newKeySet();
        MEMORY_URI = Uri.parse("content://com.obric.memorydata.personalcontext.EntityProvider");
    }

    private TrackerImpl() {
    }

    private final void checkParamsSize(String r7, JSONObject r8, int r9) {
        String r6 = r8.toString();
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        if (r6.length() >= (r9 / 2)) goto L5;
        return;
    L5:
        byte[] r10 = r6.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(r10, "getBytes(...)");
        int r11 = r10.length;
        if (r11 <= r9) goto L9;
        String r12 = "OOMChecker: Event '" + r7 + "' params size exceeds limit: " + (r11 / 1024) + "KB > " + (r9 / 1024) + "KB, event size: " + r6.length() + " characters";
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "Tracker", r12, null, 4, null);
        Ensure.ensureNotReachHere(new Throwable(r12 + "\n params: " + StringsKt.take(r6, 50)), r12);
        return;
    }

    static /* synthetic */ void checkParamsSize$default(TrackerImpl r0, String r1, JSONObject r2, int r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = 102400;
    L5:
        r0.checkParamsSize(r1, r2, r3);
    }

    @JvmStatic
    public static final TrackerImpl getInst() {
        return INSTANCE;
    }

    public static /* synthetic */ Long lambda$6dE1n87DUpt91NndkV86sIWqZr0(long r0, Ref.BooleanRef r2, long r3, String r5, Long r6) {
        return shouldReportEvent$lambda$5(r0, r2, r3, r5, r6);
    }

    public static /* synthetic */ Unit lambda$C3yYTXqP86gP2IIGjvptQk5aUoo(com.obric.memorydata.middleware.api.bdtracker.a r0) {
        return startDailyReport$lambda$4$lambda$3(r0);
    }

    public static /* synthetic */ Long lambda$SC0vxSvfzp75A_YZKFheEeEKeE4(Function2 r0, Object r1, Object r2) {
        return shouldReportEvent$lambda$6(r0, r1, r2);
    }

    private final void reportEventRpc(String r7, JSONObject r8) {
        Bundle r0 = new Bundle();
        r0.putString("event", r7);
        r0.putString(PARAMS, r8.toString());
        ContentProviderClient r9 = ((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver().acquireUnstableContentProviderClient(MEMORY_URI);
        if (r9 != null) goto L20;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "failed to acquire unstable provider client, skip reportEvent", null, 4, null);
        return;
    L20:
        r9.call("reportEvent", null, r0);     // Catch: Throwable -> L8 Exception -> L10 DeadObjectException -> L13
    L7:
        r9.close();
        return;
    L13:
        e = move-exception;
        RunLog r1 = RunLog.INSTANCE;     // Catch: Throwable -> L8
        String r2 = "unstable provider died during reportEvent";
        Throwable r10 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L12:
        r1.error(TAG, r2, r10);     // Catch: Throwable -> L8
    L10:
        e = move-exception;
        r1 = RunLog.INSTANCE;     // Catch: Throwable -> L8
        r2 = "provider call failed during reportEvent";
        r10 = (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L8
    L8:
        th = move-exception;
        r9.close();
        throw th;
    }

    private final boolean shouldReportEvent(String r9) {
        Long r8 = (Long) ZeusTransformUtils.preCheckCast(EVENT_RATE_LIMIT_CONFIG.get(r9), Long.class, "com.obric.memorydata.plugin");
        if (r8 == null) goto L6;
        final long r4 = r8.longValue();
        final long r1 = System.currentTimeMillis();
        final Ref.BooleanRef r10 = new Ref.BooleanRef();
        ConcurrentHashMap<String, Long> r6 = eventLastReportTime;
        final Function2 r7 = new $$Lambda$TrackerImpl$6dE1n87DUpt91NndkV86sIWqZr0(r1, r10, r4);
        r6.compute(r9, new $$Lambda$TrackerImpl$SC0vxSvfzp75A_YZKFheEeEKeE4(r7));
        return r10.element;
    L6:
        return true;
    }

    private static final Long shouldReportEvent$lambda$5(long r4, Ref.BooleanRef r6, long r7, String r9, Long r10) {
        Intrinsics.checkNotNullParameter(r9, "<unused var>");
        if (r10 == null) goto L5;
        long r11 = r10.longValue();
    L7:
        if (r4 >= r11) goto L11;
    L8:
        r6.element = true;
        return Long.valueOf(r4);
    L11:
        if ((r4 - r11) >= r7) goto L8;
        return Long.valueOf(r11);
    L5:
        r11 = 0;
        goto L7
    }

    private static final Long shouldReportEvent$lambda$6(Function2 r2, Object r3, Object r4) {
        return (Long) ZeusTransformUtils.preCheckCast(((Function2) ZeusTransformUtils.wrapperContextForParams(r2, Function2.class, "com.obric.memorydata.plugin")).invoke(r3, r4), Long.class, "com.obric.memorydata.plugin");
    }

    private static final Unit startDailyReport$lambda$4$lambda$3(com.obric.memorydata.middleware.api.bdtracker.a r2) {
        ((com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin")).a();
        return Unit.INSTANCE;
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void registerDailyReportCallback(com.obric.memorydata.middleware.api.bdtracker.a r2) {
        com.obric.memorydata.middleware.api.bdtracker.a r1 = (com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "callback");
        dailyCallbacks.add(r1);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void registerReportEventRejectedHandler(String r2, com.obric.memorydata.middleware.api.bdtracker.b r3) {
        com.obric.memorydata.middleware.api.bdtracker.b r1 = (com.obric.memorydata.middleware.api.bdtracker.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.middleware.api.bdtracker.b.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r1, "handler");
        d.f11707a.a(r2, r1);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void reportDevEvent(String r3, JSONObject r4) {
        Intrinsics.checkNotNullParameter(r3, "event");
        Intrinsics.checkNotNullParameter(r4, "data");
        JSONObject r1 = new JSONObject();
        r1.put("event", r3);
        r1.put(PARAMS, r4.toString());
        reportEvent(OsTeaTrackerEventId.MEMORY_DEV_EVENT.getValue(), r1);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void reportEvent(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, PARAMS);
        reportEventAccepted(r2, r3);
    }

    public final boolean reportEvent$middleware_impl_obricRelease(String r10, JSONObject r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "event");
        Intrinsics.checkNotNullParameter(r11, PARAMS);
        if (Intrinsics.areEqual(AppContext.INSTANCE.getPackageName(), "com.obric.lifelog") == false) goto L5;
    L43:
        r11.put("source_package_name", AppContext.INSTANCE.getPackageName());
        reportEventRpc(r10, r11);
        return true;
    L5:
        if (Intrinsics.areEqual(AppContext.INSTANCE.getPackageName(), "com.obric.proactive") == true) goto L43;
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L11;
        return true;
    L11:
        if (AppContext.INSTANCE.isDebug() == false) goto L14;
        checkParamsSize$default(this, r10, r11, 0, 4, null);
    L14:
        if (DataInterceptor.INSTANCE.interceptTracker(r10, r11) == false) goto L16;
        return true;
    L16:
        if (r12 == true) goto L36;
        if (Intrinsics.areEqual(r10, "entity_index_perf_event") == true) goto L22;
        if (Intrinsics.areEqual(r10, "entity_index_dashboard_latency") == true) goto L22;
    L26:
        if (shouldReportEvent(r10) == true) goto L36;
        if (d.f11707a.a(r10) == false) goto L34;
        Long r9 = (Long) ZeusTransformUtils.preCheckCast(EVENT_RATE_LIMIT_CONFIG.get(r10), Long.class, "com.obric.memorydata.plugin");
        if (r9 == null) goto L32;
        long r1 = r9.longValue();
    L33:
        d.f11707a.a(r10, r11, r1);
        goto L34
    L32:
        r1 = 0;
    L34:
        return false;
    L22:
        if (d.f11707a.a(r10) == false) goto L26;
        d.f11707a.a(r10, r11, ((Number) ZeusTransformUtils.preCheckCast(MapsKt.getValue(EVENT_RATE_LIMIT_CONFIG, r10), Number.class, "com.obric.memorydata.plugin")).longValue());
        return false;
    L36:
        if (r11.has("source_package_name") == true) goto L38;
        r11.put("source_package_name", AppContext.INSTANCE.getPackageName());
    L38:
        r11.put("rom_ver_info", AppContext.INSTANCE.getRomVersion());
        if (Intrinsics.areEqual(r10, OsTeaTrackerEventId.MEMORY_TASK_EXECUTE_INFO.getValue()) == false) goto L41;
        JSONObject r13 = new JSONObject(r11.toString());
        r13.put("system_os_did", AppContext.INSTANCE.getOsDeviceId(null));
        r11 = r13;
    L41:
        AppLog.onEventV3("obric_memd_" + r10, r11);
        return true;
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public boolean reportEventAccepted(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "event");
        Intrinsics.checkNotNullParameter(r3, PARAMS);
        return reportEvent$middleware_impl_obricRelease(r2, r3, false);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void reportWithSystemId(String r5, Map<String, ? extends Object> r6) {
        Map r4 = (Map) ZeusTransformUtils.wrapperContextForParams(r6, Map.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r5, "event");
        Intrinsics.checkNotNullParameter(r4, "data");
        JSONObject r7 = new JSONObject();
        Iterator r8 = ((Iterable) ZeusTransformUtils.preCheckCast(r4.entrySet(), Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L4:
        if (r8.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) ZeusTransformUtils.preCheckCast(r8.next(), Map.Entry.class, "com.obric.memorydata.plugin");
        r7.put((String) ZeusTransformUtils.preCheckCast(r1.getKey(), String.class, "com.obric.memorydata.plugin"), r1.getValue());
        goto L4
    L6:
        Tracker.INSTANCE.reportEvent(r5, r7);
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void startDailyReport() {
        IStore r13 = IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), UserSettings.REPO_MEMORY_DATA, 0, 2, null);
        long r2 = r13.getLong(DAILY_REPORT_LAST_TIME_KEY, 0);
        long r5 = System.currentTimeMillis();
        if (Math.abs(r5 - r2) >= WifiScanStateMachine.WAKE_LOCK_TIMEOUT_1_DATE_MS) goto L7;
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        boolean r3 = false;
        int r4 = 4;
        Object r6 = null;
        String r1 = TAG;
        String r7 = "skip daily report: not exceed one day";
    L5:
        IRunLog.a.a(r0, r1, r7, r3, r4, r6);
        return;
    L7:
        IRunLog r8 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        StringBuilder r9 = new StringBuilder().append("start daily report callbacks size=");
        ConcurrentHashMap.KeySetView<com.obric.memorydata.middleware.api.bdtracker.a, Boolean> r10 = dailyCallbacks;
        IRunLog.a.a(r8, TAG, r9.append(r10.size()).toString(), false, 4, null);
        Intrinsics.checkNotNullExpressionValue(r10, "dailyCallbacks");
        Iterator r11 = ((Iterable) ZeusTransformUtils.preCheckCast(r10, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L9:
        if (r11.hasNext() == false) goto L11;
        final com.obric.memorydata.middleware.api.bdtracker.a r12 = (com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.preCheckCast(r11.next(), com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin");
        y.a(null, new $$Lambda$TrackerImpl$C3yYTXqP86gP2IIGjvptQk5aUoo(r12), 1, null);
        goto L9
    L11:
        r13.save(DAILY_REPORT_LAST_TIME_KEY, r5);
        r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        r3 = false;
        r4 = 4;
        r6 = null;
        r1 = TAG;
        r7 = "finish daily report";
        goto L5
    }

    @Override // com.obric.memorydata.middleware.api.bdtracker.ITracker
    public void unregisterDailyReportCallback(com.obric.memorydata.middleware.api.bdtracker.a r2) {
        com.obric.memorydata.middleware.api.bdtracker.a r1 = (com.obric.memorydata.middleware.api.bdtracker.a) ZeusTransformUtils.wrapperContextForParams(r2, com.obric.memorydata.middleware.api.bdtracker.a.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "callback");
        dailyCallbacks.remove(r1);
    }
}
