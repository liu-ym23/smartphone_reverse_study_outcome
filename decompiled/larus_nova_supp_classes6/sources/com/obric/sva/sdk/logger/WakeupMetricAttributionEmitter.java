package com.obric.sva.sdk.logger;

import com.ixigua.lib.track.TrackParams;
import com.obric.eventkit.eventstaskmanager.ITaskManager;
import com.obric.sva.sdk.utils.LogUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001^B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020'2\u0006\u00104\u001a\u000205J\u000e\u00106\u001a\u0002022\u0006\u00107\u001a\u00020\u0005J\u0010\u00108\u001a\u0002022\u0006\u00104\u001a\u000205H\u0002J\u0010\u00109\u001a\u0002022\u0006\u00104\u001a\u000205H\u0002J*\u00106\u001a\u0002022\u0006\u0010:\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010<\u001a\u00020\u00052\b\b\u0002\u0010=\u001a\u00020\nH\u0002J\u0010\u0010>\u001a\u0002022\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010?\u001a\u00020@2\u0006\u00104\u001a\u000205H\u0002J\u0010\u0010A\u001a\u00020@2\u0006\u00104\u001a\u000205H\u0002J\u0014\u0010B\u001a\u000200*\u0002052\u0006\u0010C\u001a\u00020\u0005H\u0002J\u0018\u0010D\u001a\u00020\u00052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\nH\u0002J\u001c\u0010F\u001a\u00020\u0005*\u0002052\u0006\u0010C\u001a\u00020\u00052\u0006\u0010E\u001a\u00020\nH\u0002J\u0010\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\nH\u0002J\u0016\u0010I\u001a\b\u0012\u0004\u0012\u0002000J2\u0006\u0010H\u001a\u00020\nH\u0002J\u0016\u0010K\u001a\b\u0012\u0004\u0012\u0002050J2\u0006\u0010H\u001a\u00020\nH\u0002J\u0016\u0010L\u001a\u0002022\f\u0010M\u001a\b\u0012\u0004\u0012\u0002000JH\u0002J6\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u00052\n\b\u0002\u0010P\u001a\u0004\u0018\u0001002\u000e\b\u0002\u0010Q\u001a\b\u0012\u0004\u0012\u0002000J2\b\b\u0002\u0010R\u001a\u000205H\u0002J\u0010\u0010S\u001a\u0002022\u0006\u00104\u001a\u000205H\u0002J\f\u0010T\u001a\u00020\u0005*\u000205H\u0002J\f\u0010U\u001a\u00020\u0005*\u000205H\u0002J\u0010\u0010V\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u0005H\u0002J\u0016\u0010W\u001a\u000202*\u0002052\b\u0010X\u001a\u0004\u0018\u000105H\u0002J\u001c\u0010Y\u001a\u000202*\u0002052\u0006\u0010Z\u001a\u00020\u00052\u0006\u0010X\u001a\u000205H\u0002J$\u0010Y\u001a\u000202*\u0002052\u0006\u0010[\u001a\u00020\u00052\u0006\u0010X\u001a\u0002052\u0006\u0010\\\u001a\u00020\u0005H\u0002J(\u0010]\u001a\u00020\u00052\u0006\u0010O\u001a\u00020\u00052\f\u0010Q\u001a\b\u0012\u0004\u0012\u0002000J2\b\u0010P\u001a\u0004\u0018\u000100H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010.\u001a\b\u0012\u0004\u0012\u0002000/X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006_"}, d2 = {"Lcom/obric/sva/sdk/logger/WakeupMetricAttributionEmitter;", "", "<init>", "()V", "TAG", "", "EVENT_WAKEUP_METRIC_RESULT", "EVENT_BUTTON_WAKEUP", "METRIC_VERSION", "LOOKBACK_MS", "", "CACHE_KEEP_MS", "TYPE_SECONDARY_FAIL", "TYPE_SECONDARY_SUCCESS", "TYPE_BUTTON_WAKEUP", "METRIC_A", "METRIC_B", "METRIC_C", "METRIC_D", "METRIC_NAME_A", "METRIC_NAME_B", "METRIC_NAME_C", "METRIC_NAME_D", "KEY_TIMESTAMP", "KEY_SESSION_TYPE", "KEY_WAKE_SESSION_TYPE", "KEY_WAKE_SESSION_ID", "KEY_UNIQUE_WAKEUP_ID", "KEY_DUMP_AUDIO_FILE_ID", "KEY_REJECT_TYPE", "KEY_SCENE", "KEY_WAKEUP_SCENE", "KEY_PRESS_TYPE", "KEY_WAKEUP_FROM", "KEY_LAUNCH_SERVICE", "KEY_TRIGGER_TIME", "KEY_EVENT_ID", "KEY_WAKEUP_VOICE_FAIL_COUNT", "REJECT_TYPE_WAKEWORD_PASSED_OTHER_FAILED", "", "SESSION_TYPE_BREATH", "scope", "Lkotlinx/coroutines/CoroutineScope;", "sequence", "Ljava/util/concurrent/atomic/AtomicLong;", "lock", "cache", "", "Lcom/obric/sva/sdk/logger/WakeupMetricAttributionEmitter$WakeupCacheEvent;", "onSecondaryWakeup", "", "trackID", "payload", "Lorg/json/JSONObject;", "onButtonWakeup", "data", "onSecondaryWakeupSuccess", "onSecondaryWakeupFail", "pressType", "wakeupFrom", "launchService", "triggerTimestampMs", "reportButtonWakeupToTea", "shouldIgnoreSecondaryEvent", "", "isWakewordPassedOtherFailedReject", "toCacheEvent", "type", "nextEventId", "timestampMs", "stableEventId", "pruneExpiredLocked", "now", "findRecentFailsLocked", "", "settleTimeoutFailsLocked", "consumeLocked", "events", "buildMetricPayloadLocked", "metricType", "currentEvent", "relatedEvents", "extra", "reportMetricToTea", "buttonWakeupLogSummary", "metricResultLogSummary", "metricName", "mergeRepresentativeFields", "source", "putIfPresent", "key", "targetKey", "sourceKey", "buildIdempotentKey", "WakeupCacheEvent", "libs_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = ITaskManager.Stub.TRANSACTION_getEventTasksByType)
public final class WakeupMetricAttributionEmitter {
    private static final long CACHE_KEEP_MS = 30000;
    private static final String EVENT_BUTTON_WAKEUP = "button_wakeup";
    private static final String EVENT_WAKEUP_METRIC_RESULT = "wakeup_metric_result";
    public static final WakeupMetricAttributionEmitter INSTANCE = null;
    private static final String KEY_DUMP_AUDIO_FILE_ID = "dump_audio_file_id";
    private static final String KEY_EVENT_ID = "event_id";
    private static final String KEY_LAUNCH_SERVICE = "launch_service";
    private static final String KEY_PRESS_TYPE = "press_type";
    private static final String KEY_REJECT_TYPE = "rejectType";
    private static final String KEY_SCENE = "scene";
    private static final String KEY_SESSION_TYPE = "session_type";
    private static final String KEY_TIMESTAMP = "timestamp";
    private static final String KEY_TRIGGER_TIME = "trigger_timestamp_ms";
    private static final String KEY_UNIQUE_WAKEUP_ID = "unique_wakeup_id";
    private static final String KEY_WAKEUP_FROM = "wakeup_from";
    private static final String KEY_WAKEUP_SCENE = "wakeup_scene";
    private static final String KEY_WAKEUP_VOICE_FAIL_COUNT = "wakeup_voice_fail_count";
    private static final String KEY_WAKE_SESSION_ID = "wake_session_id";
    private static final String KEY_WAKE_SESSION_TYPE = "wake_session_type";
    private static final long LOOKBACK_MS = 5000;
    private static final String METRIC_A = "A";
    private static final String METRIC_B = "B";
    private static final String METRIC_C = "C";
    private static final String METRIC_D = "D";
    private static final String METRIC_NAME_A = "first_try_wakeup_success";
    private static final String METRIC_NAME_B = "retry_wakeup_success";
    private static final String METRIC_NAME_C = "wakeup_unrecovered_failure";
    private static final String METRIC_NAME_D = "method_switch_wakeup_success";
    private static final String METRIC_VERSION = "v1";
    private static final int REJECT_TYPE_WAKEWORD_PASSED_OTHER_FAILED = 2;
    private static final String SESSION_TYPE_BREATH = "BREATH";
    private static final String TAG = "WakeupMetricAttribution";
    private static final String TYPE_BUTTON_WAKEUP = "button_wakeup";
    private static final String TYPE_SECONDARY_FAIL = "secondary_fail";
    private static final String TYPE_SECONDARY_SUCCESS = "secondary_success";
    private static final List<WakeupCacheEvent> cache = null;
    private static final Object lock = null;
    private static final CoroutineScope scope = null;
    private static final AtomicLong sequence = null;

    private WakeupMetricAttributionEmitter() {
    }

    public static /* synthetic */ boolean a(WakeupCacheEvent r0) {
        return consumeLocked$lambda$19(r0);
    }

    public static /* synthetic */ boolean b(long r0, WakeupCacheEvent r2) {
        return pruneExpiredLocked$lambda$14(r0, r2);
    }

    public static /* synthetic */ CharSequence c(WakeupCacheEvent r0) {
        return buildIdempotentKey$lambda$34(r0);
    }

    static {
        INSTANCE = new WakeupMetricAttributionEmitter();
        scope = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        sequence = new AtomicLong(0);
        lock = new Object();
        cache = new ArrayList();
    }

    public static final /* synthetic */ Object access$getLock$p() {
        return lock;
    }

    private static final CharSequence buildIdempotentKey$lambda$34(WakeupCacheEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getId();
    }

    private final String buttonWakeupLogSummary(JSONObject r4) {
        return "event_id=" + r4.optString(KEY_EVENT_ID) + ", timestamp=" + r4.optLong(KEY_TIMESTAMP) + ", press_type=" + r4.optString(KEY_PRESS_TYPE) + ", wakeup_from=" + r4.optString(KEY_WAKEUP_FROM) + ", launch_service=" + r4.optString(KEY_LAUNCH_SERVICE) + ", wakeup_voice_fail_count=" + r4.optInt(KEY_WAKEUP_VOICE_FAIL_COUNT) + ", trigger_timestamp_ms=" + r4.optLong(KEY_TRIGGER_TIME);
    }

    private final void consumeLocked(List<WakeupCacheEvent> r3) {
        Iterator<T> r4 = r3.iterator();
    L4:
        if (r4.hasNext() == false) goto L6;
        ((WakeupCacheEvent) r4.next()).setConsumed(true);
        goto L4
    L6:
        CollectionsKt.removeAll(cache, new f());
    }

    private static final boolean consumeLocked$lambda$19(WakeupCacheEvent r1) {
        Intrinsics.checkNotNullParameter(r1, "it");
        return r1.getConsumed();
    }

    private final List<WakeupCacheEvent> findRecentFailsLocked(long r11) {
        long r0 = r11 - LOOKBACK_MS;
        List<WakeupCacheEvent> r2 = cache;
        ArrayList r3 = new ArrayList();
        Iterator<T> r4 = r2.iterator();
    L4:
        if (r4.hasNext() == false) goto L19;
        Object r5 = r4.next();
        WakeupCacheEvent r6 = (WakeupCacheEvent) r5;
        boolean r7 = false;
        if (r6.getConsumed() == false) goto L8;
    L17:
        if (r7 == false) goto L4;
        r3.add(r5);
        goto L4
    L8:
        if (Intrinsics.areEqual(r6.getType(), TYPE_SECONDARY_FAIL) == false) goto L17;
        long r8 = r6.getTimestampMs();
        if (r0 <= r8) goto L12;
    L14:
        boolean r9 = false;
    L15:
        if (r9 == false) goto L17;
        r7 = true;
        goto L17
    L12:
        if (r8 > r11) goto L14;
        r9 = true;
        goto L15
    L19:
        return r3;
    }

    private final boolean isWakewordPassedOtherFailedReject(JSONObject r2) {
        if (r2.optInt(KEY_REJECT_TYPE) != 2) goto L5;
        return true;
    L5:
        return false;
    }

    private final String metricName(String r2) {
        switch(r2.hashCode()) {
            case 65: goto L18;
            case 66: goto L14;
            case 67: goto L10;
            case 68: goto L6;
            default: goto L25;
        };
    L25:
        return r2;
    L6:
        if (r2.equals(METRIC_D) == false) goto L26;
        return METRIC_NAME_D;
    L26:
        return r2;
    L10:
        if (r2.equals(METRIC_C) == false) goto L27;
        return METRIC_NAME_C;
    L27:
        return r2;
    L14:
        if (r2.equals(METRIC_B) == false) goto L28;
        return METRIC_NAME_B;
    L28:
        return r2;
    L18:
        if (r2.equals(METRIC_A) == false) goto L29;
        return METRIC_NAME_A;
    L29:
        return r2;
    }

    private final String metricResultLogSummary(JSONObject r4) {
        return "metric_type=" + r4.optString("metric_type") + ", metric_name=" + r4.optString("metric_name") + ", current_event_type=" + r4.optString("current_event_type") + ", wakeup_voice_fail_count=" + r4.optInt(KEY_WAKEUP_VOICE_FAIL_COUNT) + ", press_type=" + r4.optString(KEY_PRESS_TYPE) + ", wakeup_from=" + r4.optString(KEY_WAKEUP_FROM) + ", launch_service=" + r4.optString(KEY_LAUNCH_SERVICE) + ", local_timestamp_ms=" + r4.optLong("local_timestamp_ms");
    }

    private final void onSecondaryWakeupFail(JSONObject r8) {
        if (shouldIgnoreSecondaryEvent(r8) == false) goto L6;
        return;
    L6:
        if (isWakewordPassedOtherFailedReject(r8) == true) goto L8;
        return;
    L8:
        WakeupCacheEvent r9 = toCacheEvent(r8, TYPE_SECONDARY_FAIL);
        Object r0 = lock;
        monitor-enter(r0);
        WakeupMetricAttributionEmitter r1 = INSTANCE;     // Catch: Throwable -> L18
        r1.pruneExpiredLocked(r9.getTimestampMs());     // Catch: Throwable -> L18
        List r2 = CollectionsKt.toMutableList(r1.settleTimeoutFailsLocked(r9.getTimestampMs()));     // Catch: Throwable -> L18
        cache.add(r9);     // Catch: Throwable -> L18
        monitor-exit(r0);
        Iterator r10 = r2.iterator();
    L14:
        if (r10.hasNext() == false) goto L16;
        reportMetricToTea((JSONObject) r10.next());
        goto L14
    L16:
        BuildersKt.launch$default(scope, null, null, new onSecondaryWakeupFail.2(null), 3, null);
        return;
    L18:
        th = move-exception;
        throw th;
    }

    private final void onSecondaryWakeupSuccess(JSONObject r12) {
        if (shouldIgnoreSecondaryEvent(r12) == false) goto L5;
        return;
    L5:
        WakeupCacheEvent r13 = toCacheEvent(r12, TYPE_SECONDARY_SUCCESS);
        Object r0 = lock;
        monitor-enter(r0);
        ArrayList r8 = new ArrayList();     // Catch: Throwable -> L18
        WakeupMetricAttributionEmitter r9 = INSTANCE;     // Catch: Throwable -> L18
        r9.pruneExpiredLocked(r13.getTimestampMs());     // Catch: Throwable -> L18
        List<WakeupCacheEvent> r10 = r9.findRecentFailsLocked(r13.getTimestampMs());     // Catch: Throwable -> L18
        if (r10.isEmpty() == false) goto L10;
        r8.add(buildMetricPayloadLocked$default(r9, METRIC_A, r13, null, null, 12, null));     // Catch: Throwable -> L18
    L11:
        r9.consumeLocked(CollectionsKt.plus(r10, r13));     // Catch: Throwable -> L18
        r8.addAll(r9.settleTimeoutFailsLocked(r13.getTimestampMs()));     // Catch: Throwable -> L18
        monitor-exit(r0);
        Iterator r14 = r8.iterator();
    L15:
        if (r14.hasNext() == false) goto L17;
        reportMetricToTea((JSONObject) r14.next());
        goto L15
    L17:
        return;
    L10:
        r8.add(r9.buildMetricPayloadLocked(METRIC_B, r13, r10, new JSONObject().put("fail_count_before_success", r10.size())));     // Catch: Throwable -> L18
    L18:
        th = move-exception;
        throw th;
    }

    private final void pruneExpiredLocked(long r3) {
        CollectionsKt.removeAll(cache, new g(r3));
    }

    private final void reportButtonWakeupToTea(JSONObject r7) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        by7.a r4 = new by7.a("button_wakeup");     // Catch: Throwable -> L5
        r4.a.merge(new TrackParams().merge(r7));     // Catch: Throwable -> L5
        r4.b();     // Catch: Throwable -> L5
        LogUtils.i(TAG, "report button_wakeup " + buttonWakeupLogSummary(r7), new Object[0]);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L13;
        LogUtils.e(TAG, "report button_wakeup failed: " + r9.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final void reportMetricToTea(JSONObject r7) {
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        by7.a r4 = new by7.a(EVENT_WAKEUP_METRIC_RESULT);     // Catch: Throwable -> L5
        r4.a.merge(new TrackParams().merge(r7));     // Catch: Throwable -> L5
        r4.b();     // Catch: Throwable -> L5
        LogUtils.i(TAG, "report wakeup_metric_result " + metricResultLogSummary(r7), new Object[0]);     // Catch: Throwable -> L5
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
    L7:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L13;
        LogUtils.e(TAG, "report wakeup_metric_result failed: " + r9.getMessage(), new Object[0]);
        return;
    L13:
        return;
    L5:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    private final List<JSONObject> settleTimeoutFailsLocked(long r10) {
        List<WakeupCacheEvent> r0 = cache;
        ArrayList r8 = new ArrayList();
        Iterator<T> r1 = r0.iterator();
    L4:
        if (r1.hasNext() == false) goto L14;
        Object r2 = r1.next();
        WakeupCacheEvent r3 = (WakeupCacheEvent) r2;
        if (r3.getConsumed() == false) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r4 == false) goto L4;
        r8.add(r2);
        goto L4
    L8:
        if (Intrinsics.areEqual(r3.getType(), TYPE_SECONDARY_FAIL) == false) goto L10;
        r4 = true;
        goto L11
    L14:
        if (r8.isEmpty() == true) goto L16;
        Iterator r5 = r8.iterator();
        if (r5.hasNext() == false) goto L32;
        long r6 = ((WakeupCacheEvent) r5.next()).getTimestampMs();
    L21:
        if (r5.hasNext() == false) goto L26;
        long r7 = ((WakeupCacheEvent) r5.next()).getTimestampMs();
        if (r6 >= r7) goto L21;
        r6 = r7;
        goto L21
    L26:
        if ((r10 - r6) <= LOOKBACK_MS) goto L28;
        JSONObject r11 = buildMetricPayloadLocked$default(this, METRIC_C, null, r8, new JSONObject().put(KEY_WAKEUP_VOICE_FAIL_COUNT, r8.size()), 2, null);
        consumeLocked(r8);
        return CollectionsKt.listOf(r11);
    L28:
        return CollectionsKt.emptyList();
    L32:
        throw new NoSuchElementException();
    L16:
        return CollectionsKt.emptyList();
    }

    private final boolean shouldIgnoreSecondaryEvent(JSONObject r3) {
        return StringsKt.equals(r3.optString(KEY_SESSION_TYPE), SESSION_TYPE_BREATH, true);
    }

    public final void onButtonWakeup(String r8) {
        Intrinsics.checkNotNullParameter(r8, "data");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        Object r9 = Result.constructor-impl(new JSONObject(r8));     // Catch: Throwable -> L5
    L7:
        JSONObject r1 = new JSONObject();
        if (Result.isFailure-impl(r9) == false) goto L10;
        r9 = r1;
    L10:
        JSONObject r10 = (JSONObject) r9;
        onButtonWakeup(r10.optString(KEY_PRESS_TYPE), r10.optString(KEY_WAKEUP_FROM), r10.optString(KEY_LAUNCH_SERVICE), r10.optLong(KEY_TRIGGER_TIME, 0));
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }

    public static final /* synthetic */ void access$reportMetricToTea(WakeupMetricAttributionEmitter r0, JSONObject r1) {
        r0.reportMetricToTea(r1);
    }

    public static final /* synthetic */ List access$settleTimeoutFailsLocked(WakeupMetricAttributionEmitter r0, long r1) {
        return r0.settleTimeoutFailsLocked(r1);
    }

    private final void mergeRepresentativeFields(JSONObject r4, JSONObject r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        putIfPresent(r4, KEY_WAKE_SESSION_TYPE, r5, KEY_SESSION_TYPE);
        putIfPresent(r4, KEY_WAKEUP_SCENE, r5, KEY_SCENE);
        putIfPresent(r4, KEY_WAKEUP_FROM, r5);
        putIfPresent(r4, KEY_LAUNCH_SERVICE, r5);
        putIfPresent(r4, KEY_PRESS_TYPE, r5);
        putIfPresent(r4, KEY_REJECT_TYPE, r5);
        String r1 = r5.optString(KEY_WAKE_SESSION_ID);
        if (StringsKt.isBlank(r1) == false) goto L8;
        r1 = r5.optString(KEY_UNIQUE_WAKEUP_ID);
    L8:
        if (StringsKt.isBlank(r1) == false) goto L10;
        r1 = r5.optString(KEY_DUMP_AUDIO_FILE_ID);
    L10:
        Intrinsics.checkNotNull(r1);
        if ((!StringsKt.isBlank(r1)) == false) goto L14;
        r4.put(KEY_WAKE_SESSION_ID, r1);
        return;
    }

    private final String nextEventId(String r2, long r3) {
        return r2 + '-' + r3 + '-' + sequence.incrementAndGet();
    }

    private static final boolean pruneExpiredLocked$lambda$14(long r2, WakeupCacheEvent r4) {
        Intrinsics.checkNotNullParameter(r4, "it");
        if (r4.getConsumed() == false) goto L5;
    L8:
        return true;
    L5:
        if ((r2 - r4.getTimestampMs()) > CACHE_KEEP_MS) goto L8;
        return false;
    }

    private final WakeupCacheEvent toCacheEvent(JSONObject r12, String r13) {
        Long r0 = Long.valueOf(r12.optLong(KEY_TIMESTAMP, 0));
        if (r0.longValue() <= 0) goto L5;
        boolean r1 = true;
    L6:
        if (r1 == true) goto L9;
        r0 = null;
    L9:
        if (r0 == null) goto L11;
        long r2 = r0.longValue();
    L12:
        long r5 = r2;
        return new WakeupCacheEvent(stableEventId(r12, r13, r5), r13, r5, new JSONObject(r12.toString()), false, 16, null);
    L11:
        r2 = System.currentTimeMillis();
        goto L12
    L5:
        r1 = false;
        goto L6
    }

    public final void onSecondaryWakeup(int r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r3, "payload");
        if (r2 != 200) goto L5;
        onSecondaryWakeupSuccess(r3);
        return;
    L5:
        if (r2 != 201) goto L11;
        onSecondaryWakeupFail(r3);
        return;
    }

    private final String buildIdempotentKey(String r10, List<WakeupCacheEvent> r11, WakeupCacheEvent r12) {
        List<WakeupCacheEvent> r13 = r11;
        if (r13.isEmpty() == false) goto L9;
        if (r12 == null) goto L7;
        r13 = CollectionsKt.listOf(r12);
        if (r13 != null) goto L9;
    L7:
        r13 = CollectionsKt.emptyList();
    L9:
        return "v1-" + r10 + '-' + CollectionsKt.joinToString$default(r13, "_", null, null, 0, null, new h(), 30, null);
    }

    private final void putIfPresent(JSONObject r2, String r3, JSONObject r4) {
        if (r4.has(r3) == false) goto L6;
        r2.put(r3, r4.opt(r3));
        return;
    }

    private final String stableEventId(JSONObject r3, String r4, long r5) {
        String r0 = r3.optString(KEY_WAKE_SESSION_ID);
        if (StringsKt.isBlank(r0) == false) goto L6;
        r0 = r3.optString(KEY_UNIQUE_WAKEUP_ID);
    L6:
        if (StringsKt.isBlank(r0) == false) goto L8;
        r0 = r3.optString(KEY_DUMP_AUDIO_FILE_ID);
    L8:
        Intrinsics.checkNotNull(r0);
        if ((!StringsKt.isBlank(r0)) == false) goto L12;
        return r4 + '-' + r0 + '-' + r5;
    L12:
        return nextEventId(r4, r5);
    }

    private final JSONObject buildMetricPayloadLocked(String r9, WakeupCacheEvent r10, List<WakeupCacheEvent> r11, JSONObject r12) {
        if (r10 == null) goto L6;
        List<WakeupCacheEvent> r0 = r11;
        if ((!r0.isEmpty()) == false) goto L6;
        List<WakeupCacheEvent> r1 = CollectionsKt.plus(r0, r10);
    L13:
        long r2 = System.currentTimeMillis();
        String r3 = UUID.randomUUID().toString();
        JSONObject r4 = new JSONObject();
        r4.put("metric_type", r9);
        WakeupMetricAttributionEmitter r5 = INSTANCE;
        r4.put("metric_name", r5.metricName(r9));
        r4.put("metric_version", METRIC_VERSION);
        r4.put("trace_id", r3);
        r4.put("local_timestamp_ms", r2);
        r4.put("idempotent_key", r5.buildIdempotentKey(r9, r1, r10));
        JSONArray r13 = new JSONArray();
        Iterator<T> r6 = r1.iterator();
    L15:
        if (r6.hasNext() == false) goto L17;
        r13.put(((WakeupCacheEvent) r6.next()).getId());
        goto L15
    L17:
        Unit r7 = Unit.INSTANCE;
        r4.put("related_event_ids", r13);
        if (r10 == null) goto L21;
        r4.put("current_event_id", r10.getId());
        r4.put("current_event_type", r10.getType());
    L21:
        if (r12.has(KEY_WAKEUP_VOICE_FAIL_COUNT) == true) goto L36;
        List<WakeupCacheEvent> r14 = r11;
        int r8 = 0;
        if ((r14 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r15 = r14.iterator();
    L29:
        if (r15.hasNext() == false) goto L35;
        if (Intrinsics.areEqual(((WakeupCacheEvent) r15.next()).getType(), TYPE_SECONDARY_FAIL) == false) goto L29;
        r8 = r8 + 1;
        if (r8 >= 0) goto L29;
        CollectionsKt.throwCountOverflow();
    L35:
        r4.put(KEY_WAKEUP_VOICE_FAIL_COUNT, r8);
        goto L36
    L25:
        if (r14.isEmpty() == false) goto L27;
    L36:
        WakeupMetricAttributionEmitter r16 = INSTANCE;
        WakeupCacheEvent r17 = (WakeupCacheEvent) CollectionsKt.firstOrNull(r1);
        if (r17 == null) goto L40;
        JSONObject r18 = r17.getPayload();
        if (r18 == null) goto L40;
    L43:
        r16.mergeRepresentativeFields(r4, r18);
        Iterator<String> r19 = r12.keys();
    L45:
        if (r19.hasNext() == false) goto L47;
        String r110 = r19.next();
        r4.put(r110, r12.opt(r110));
        goto L45
    L47:
        return r4;
    L40:
        if (r10 == null) goto L42;
        r18 = r10.getPayload();
        goto L43
    L42:
        r18 = null;
    L6:
        List<WakeupCacheEvent> r20 = r11;
        if (r20.isEmpty() == false) goto L12;
        if (r10 == null) goto L11;
        r20 = CollectionsKt.listOf(r10);
        if (r20 != null) goto L12;
    L11:
        r20 = CollectionsKt.emptyList();
    L12:
        r1 = r20;
        goto L13
    }

    private final void onButtonWakeup(String r25, String r26, String r27, long r28) {
        long r6 = System.currentTimeMillis();
        Long r8 = Long.valueOf(r28);
        long r9 = r8.longValue();
        boolean r13 = false;
        if ((r6 - CACHE_KEEP_MS) <= r9) goto L5;
    L7:
        if (r13 == true) goto L10;
        r8 = null;
    L10:
        if (r8 == null) goto L12;
        long r10 = r8.longValue();
    L13:
        String r16 = nextEventId("button_wakeup", r10);
        JSONObject r11 = new JSONObject();
        r11.put(KEY_TIMESTAMP, r6);
        r11.put(KEY_PRESS_TYPE, r25);
        r11.put(KEY_WAKEUP_FROM, r26);
        r11.put(KEY_LAUNCH_SERVICE, r27);
        r11.put(KEY_WAKEUP_SCENE, "button_wakeup");
        if (r28 <= 0) goto L16;
        r11.put(KEY_TRIGGER_TIME, r28);
    L16:
        Unit r4 = Unit.INSTANCE;
        WakeupCacheEvent r5 = new WakeupCacheEvent(r16, "button_wakeup", r10, r11, false, 16, null);
        r5.getPayload().put(KEY_EVENT_ID, r5.getId());
        Object r7 = lock;
        monitor-enter(r7);
        ArrayList r12 = new ArrayList();     // Catch: Throwable -> L37
        WakeupMetricAttributionEmitter r14 = INSTANCE;     // Catch: Throwable -> L37
        r14.pruneExpiredLocked(r5.getTimestampMs());     // Catch: Throwable -> L37
        List<WakeupCacheEvent> r15 = r14.findRecentFailsLocked(r5.getTimestampMs());     // Catch: Throwable -> L37
        r5.getPayload().put(KEY_WAKEUP_VOICE_FAIL_COUNT, r15.size());     // Catch: Throwable -> L37
        if ((!r15.isEmpty()) == false) goto L30;
        JSONObject r17 = new JSONObject();     // Catch: Throwable -> L37
        r17.put(KEY_WAKEUP_SCENE, "button_wakeup");     // Catch: Throwable -> L37
        if ((!StringsKt.isBlank(r26)) == false) goto L24;
        r17.put(KEY_WAKEUP_FROM, r26);     // Catch: Throwable -> L37
    L24:
        if ((!StringsKt.isBlank(r27)) == false) goto L27;
        r17.put(KEY_LAUNCH_SERVICE, r27);     // Catch: Throwable -> L37
    L27:
        if ((!StringsKt.isBlank(r25)) == false) goto L29;
        r17.put(KEY_PRESS_TYPE, r25);     // Catch: Throwable -> L37
    L29:
        r12.add(r14.buildMetricPayloadLocked(METRIC_D, r5, r15, r17));     // Catch: Throwable -> L37
        r14.consumeLocked(CollectionsKt.plus(r15, r5));     // Catch: Throwable -> L37
    L30:
        r12.addAll(r14.settleTimeoutFailsLocked(r5.getTimestampMs()));     // Catch: Throwable -> L37
        monitor-exit(r7);
        reportButtonWakeupToTea(r5.getPayload());
        Iterator r0 = r12.iterator();
    L34:
        if (r0.hasNext() == false) goto L36;
        reportMetricToTea((JSONObject) r0.next());
        goto L34
    L36:
        return;
    L37:
        th = move-exception;
        throw th;
    L12:
        r10 = r6;
        goto L13
    L5:
        if (r9 > r6) goto L7;
        r13 = true;
        goto L7
    }

    private final void putIfPresent(JSONObject r2, String r3, JSONObject r4, String r5) {
        if (r4.has(r5) == false) goto L6;
        r2.put(r3, r4.opt(r5));
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONObject buildMetricPayloadLocked$default(WakeupMetricAttributionEmitter r0, String r1, WakeupCacheEvent r2, List r3, JSONObject r4, int r5, Object r6) {
        if ((r5 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 4) == 0) goto L9;
        r3 = CollectionsKt.emptyList();
    L9:
        if ((r5 & 8) == 0) goto L12;
        r4 = new JSONObject();
    L12:
        return r0.buildMetricPayloadLocked(r1, r2, r3, r4);
    }

    public static /* synthetic */ void onButtonWakeup$default(WakeupMetricAttributionEmitter r6, String r7, String r8, String r9, long r10, int r12, Object r13) {
        if ((r12 & 8) == 0) goto L5;
        r10 = 0;
    L5:
        r6.onButtonWakeup(r7, r8, r9, r10);
    }
}
