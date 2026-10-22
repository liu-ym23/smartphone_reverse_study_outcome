package com.obric.memorydata.task.cron;

import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.logging.b;
import com.obric.memorydata.middleware.api.logging.e;
import com.obric.memorydata.middleware.api.logging.g;
import com.obric.memorydata.middleware.api.logging.o;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.obric.memorydata.utils.aa;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\u0018\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0017H\u0002¨\u0006\u0019"}, d2 = {"Lcom/obric/memorydata/task/cron/CronJobRunnerTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "shouldEnqueueTargetTask", "", "targetTask", "", "targetDedupeKey", "fireTimeMillis", "", "cleanupRecentTargetFireKeys", "", "parseConditions", "", "Lcom/obric/memorydata/task/condition/Condition;", "raw", "", "applyTargetOptionsFromRunnerParams", "Lcom/obric/memorydata/task/impl/TaskRequest$Builder;", "Companion", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class CronJobRunnerTask extends NativeTask {
    public static final a Companion = null;
    public static final String KEY_CRON = "cron";
    public static final String KEY_CRON_FIRE_TIME_MILLIS = "cron_fire_time_millis";
    public static final String KEY_PAYLOAD = "payload";
    public static final String KEY_TARGET_CONDITIONS = "target_conditions";
    public static final String KEY_TARGET_DEDUPE_KEY = "target_dedupe_key";
    public static final String KEY_TARGET_EXECUTE_IMMEDIATELY = "target_execute_immediately";
    public static final String KEY_TARGET_EXISTING_TASK_POLICY = "target_existing_task_policy";
    public static final String KEY_TARGET_TASK = "target_task";
    public static final String KEY_TIME_MS = "time_ms";
    public static final String KEY_TRIGGER_SOURCE_VALUE = "cron_timer";
    private static final String TAG = "CronJobRunnerTask";
    private static final long TARGET_DEDUPE_RETENTION_MS = 600000;
    public static final String TASK_NAME_PREFIX = "cron_job_runner:";
    private static final LinkedHashMap<String, Long> recentTargetFireKeys = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082T¢\u0006\u0002\n\u0000R*\u0010\u0013\u001a\u001e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00120\u0014j\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0012`\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/memorydata/task/cron/CronJobRunnerTask$Companion;", "", "<init>", "()V", "TAG", "", "TASK_NAME_PREFIX", "KEY_TARGET_TASK", "KEY_CRON", "KEY_PAYLOAD", "KEY_TARGET_CONDITIONS", "KEY_TARGET_EXISTING_TASK_POLICY", "KEY_TARGET_EXECUTE_IMMEDIATELY", "KEY_TARGET_DEDUPE_KEY", "KEY_TRIGGER_SOURCE_VALUE", "KEY_CRON_FIRE_TIME_MILLIS", "KEY_TIME_MS", "TARGET_DEDUPE_RETENTION_MS", "", "recentTargetFireKeys", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
        recentTargetFireKeys = new LinkedHashMap();
    }

    public CronJobRunnerTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    private final TaskRequest.Builder applyTargetOptionsFromRunnerParams(TaskRequest.Builder r5) {
        List<Condition> r0 = parseConditions(getTaskParameter().getInputParams().opt(KEY_TARGET_CONDITIONS));
        if ((!((Collection) ZeusTransformUtils.preCheckCast(r0, Collection.class, "com.obric.memorydata.plugin")).isEmpty()) == false) goto L5;
        r5.setConditions(r0);
    L5:
        ExistingTaskPolicy.a r1 = ExistingTaskPolicy.Companion;
        String r2 = getTaskParameter().getInputParams().optString(KEY_TARGET_EXISTING_TASK_POLICY);
        Intrinsics.checkNotNullExpressionValue(r2, "optString(...)");
        ExistingTaskPolicy r3 = r1.a(r2);
        if (r3 == null) goto L9;
        r5.setExistingTaskPolicy(r3);
    L9:
        if (getTaskParameter().getInputParams().optBoolean(KEY_TARGET_EXECUTE_IMMEDIATELY, false) == false) goto L11;
        r5.setExecuteImmediately(true);
    L11:
        return r5;
    }

    private final void cleanupRecentTargetFireKeys() {
        long r0 = System.currentTimeMillis() - 600000;
        Iterator<Map.Entry<String, Long>> r5 = recentTargetFireKeys.entrySet().iterator();
    L4:
        if (r5.hasNext() == false) goto L8;
        if (((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r5.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Number.class, "com.obric.memorydata.plugin")).longValue() >= r0) goto L4;
        r5.remove();
        goto L4
    }

    private final List<Condition> parseConditions(Object r6) {
        ArrayList r5 = new ArrayList();
        if (ZeusTransformUtils.instanceOf(r6, JSONArray.class) == false) goto L13;
        int r0 = 0;
        int r2 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).length();
    L5:
        if (r0 >= r2) goto L29;
        String r3 = ((JSONArray) ZeusTransformUtils.preCheckCast(r6, JSONArray.class, "com.obric.memorydata.plugin")).optString(r0);
        Intrinsics.checkNotNull(r3);
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r3, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L11;
        Condition r4 = Condition.Companion.a(r3);
        if (r4 == null) goto L11;
        r5.add(r4);
    L11:
        r0 = r0 + 1;
    L29:
        return (List) ZeusTransformUtils.preCheckCast(r5, List.class, "com.obric.memorydata.plugin");
    L13:
        if (ZeusTransformUtils.instanceOf(r6, List.class) == false) goto L29;
        Iterator r7 = ((Iterable) ZeusTransformUtils.preCheckCast(r6, Iterable.class, "com.obric.memorydata.plugin")).iterator();
    L16:
        if (r7.hasNext() == false) goto L29;
        Object r1 = r7.next();
        if (ZeusTransformUtils.instanceOf(r1, String.class) == false) goto L20;
        String r8 = (String) ZeusTransformUtils.preCheckCast(r1, String.class, "com.obric.memorydata.plugin");
    L21:
        if (r8 == null) goto L16;
        if ((!StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r8, CharSequence.class, "com.obric.memorydata.plugin"))) == false) goto L16;
        Condition r9 = Condition.Companion.a(r8);
        if (r9 == null) goto L16;
        r5.add(r9);
        goto L16
    L20:
        r8 = null;
        goto L21
    }

    private final boolean shouldEnqueueTargetTask(String r3, String r4, long r5) {
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == false) goto L5;
        return true;
    L5:
        LinkedHashMap<String, Long> r0 = recentTargetFireKeys;
        monitor-enter(r0);
        cleanupRecentTargetFireKeys();     // Catch: Throwable -> L15
        String r2 = r3 + '|' + r4 + '|' + r5;     // Catch: Throwable -> L15
        if (r0.containsKey(r2) == true) goto L10;
        ((Map) ZeusTransformUtils.preCheckCast(r0, Map.class, "com.obric.memorydata.plugin")).put(r2, Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L15
        monitor-exit(r0);
        return true;
    L10:
        monitor-exit(r0);
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        String r4 = getTaskParameter().getInputParams().optString(KEY_CRON);
        String r1 = getTaskParameter().getInputParams().optString(KEY_TARGET_TASK);
        Intrinsics.checkNotNull(r4);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L34;
        Intrinsics.checkNotNull(r1);
        if (StringsKt.isBlank((CharSequence) ZeusTransformUtils.preCheckCast(r1, CharSequence.class, "com.obric.memorydata.plugin")) == true) goto L34;
        if (AwarenessManager.INSTANCE.isPackageAutoTriggerEnabled(r1) == true) goto L14;
        o r0 = (o) ZeusTransformUtils.preCheckCast(b.f11611a, o.class, "com.obric.memorydata.plugin");
        e r8 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L13;
        g r2 = new g();
        r2.a("package_name", r1);
        Unit r3 = Unit.INSTANCE;
        r0.a("Cron 自动触发任务已被 Feature 开关拦截", r8, r2.a());
    L13:
        return new TaskResult(0, null, null, null, 14, null);
    L14:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run taskName=" + getTaskParameter().getName() + " cron=" + r4 + " target=" + r1, false, 4, null);
        JSONObject r5 = aa.a(getTaskParameter().getInputParams().optJSONObject("payload"));
        if (r5.has("trigger_source") == true) goto L17;
        r5.put("trigger_source", KEY_TRIGGER_SOURCE_VALUE);
    L17:
        long r6 = getTaskParameter().getInputParams().optLong(KEY_CRON_FIRE_TIME_MILLIS, System.currentTimeMillis());
        r5.put(KEY_TIME_MS, r6);
        String r7 = getTaskParameter().getInputParams().optString(KEY_TARGET_DEDUPE_KEY);
        Intrinsics.checkNotNull(r7);
        if (shouldEnqueueTargetTask(r1, r7, r6) == false) goto L20;
        ((TaskRequest) ZeusTransformUtils.preCheckCast(applyTargetOptionsFromRunnerParams((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(r1).setInputParam(r5), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    L21:
        Long r9 = com.obric.memorydata.utils.b.a.a(com.obric.memorydata.utils.b.a.f13191a, r4, r6, null, 4, null);
        if (r9 == null) goto L33;
        long r10 = r9.longValue();
        long r11 = RangesKt.coerceAtLeast(r10 - System.currentTimeMillis(), 0);
        JSONObject r12 = aa.a(getTaskParameter().getInputParams());
        r12.put(KEY_CRON_FIRE_TIME_MILLIS, r10);
        if (AwarenessManager.INSTANCE.isPackageAutoTriggerEnabled(r1) == true) goto L30;
        o r13 = (o) ZeusTransformUtils.preCheckCast(b.f11611a, o.class, "com.obric.memorydata.plugin");
        e r14 = new e(null, null, null, 7, null);
        if (AppContext.INSTANCE.isDebug() == false) goto L29;
        g r15 = new g();
        r15.a("package_name", r1);
        Unit r16 = Unit.INSTANCE;
        r13.a("Cron 自动触发续期已取消", r14, r15.a());
    L29:
        return new TaskResult(0, null, null, null, 14, null);
    L30:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(getTaskParameter().getName()).setInputParam(r12), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay(new com.obric.memorydata.task.impl.g(r11, TimeUnit.MILLISECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setTriggerExactly(getTaskParameter().getTriggerExactly()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.CANCEL_EXISTING), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        RunLog.INSTANCE.debug(TAG, "reschedule taskName=" + getTaskParameter().getName() + " delayMs=" + r11);
        return new TaskResult(0, null, null, null, 14, null);
    L33:
        return new TaskResult(0, null, null, null, 14, null);
    L20:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "skip duplicate target fire target=" + r1 + " dedupeKey=" + r7 + " fireTimeMillis=" + r6 + " cron=" + r4, false, 4, null);
    L34:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "invalid params taskName=" + getTaskParameter().getName() + " cron=" + r4 + " target=" + r1, null, 4, null);
        return new TaskResult(1, "invalid cron job runner params", null, null, 12, null);
    }
}
