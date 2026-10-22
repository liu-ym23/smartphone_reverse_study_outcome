package com.obric.memorydata.task.utils;

import com.bytedance.crash.tracker.ActivityLifecycle;
import com.obric.memorydata.constants.OsTeaTrackerEventId;
import com.obric.memorydata.middleware.api.bdtracker.Tracker;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.settings.SettingsManager;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.TaskInfo;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00050\u0016X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/obric/memorydata/task/utils/TaskExecuteInfoReporter;", "", "<init>", "()V", "TAG", "", "lastReportTime", "Ljava/util/concurrent/ConcurrentHashMap;", "", "REPORT_INTERVAL", "TASK_ID", "TASK_NAME", "TASK_STATE", "TASK_EXECUTE_COST", "TASK_EXECUTE_LOGIC_COST", "TASK_EXECUTE_RESULT", "TASK_EXECUTE_RESULT_INFO", "TASK_EXECUTE_IS_IMMEDIATELY", "TASK_WAIT_QUEUE_COST", "TASK_RETRY_TIMES", "TASK_NAME_WHITE_LIST", "DEFAULT_TASK_NAME_WHITE_LIST", "", "reportTaskExecuteInfo", "", "taskInfo", "Lcom/obric/memorydata/task/impl/TaskInfo;", "reportTaskRun", "reportTaskBlocked", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "isTaskBlockedReportWhiteListed", "", "taskName", "task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f12971a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final ConcurrentHashMap<String, Long> f12972b = null;
    private static final Set<String> c = null;

    static {
        f12971a = new c();
        f12972b = new ConcurrentHashMap();
        c = SetsKt.setOf("ai_proactive_agent");
    }

    private c() {
    }

    private final boolean a(String r8) {
        JSONObject r7 = SettingsManager.INSTANCE.getJson(SettingsManager.KEY_MEMORY_TASK_BLOCKED_REPORT_SETTINGS);
        if (r7 == null) goto L5;
        JSONObject r0 = r7.optJSONObject(SettingsManager.KEY_MEMORY_TASK_BLOCKED_REPORT_SETTINGS);
        if (r0 == null) goto L10;
        r7 = r0;
    L10:
        JSONArray r9 = r7.optJSONArray("task_name_white_list");
        if (r9 == null) goto L5;
        int r1 = r9.length();
        int r2 = 0;
    L14:
        if (r2 >= r1) goto L26;
        Object r3 = r9.opt(r2);
        String r6 = null;
        if (ZeusTransformUtils.instanceOf(r3, String.class) == false) goto L18;
        String r4 = (String) ZeusTransformUtils.preCheckCast(r3, String.class, "com.obric.memorydata.plugin");
    L19:
        if (r4 == null) goto L22;
        r6 = StringsKt.trim((CharSequence) ZeusTransformUtils.preCheckCast(r4, CharSequence.class, "com.obric.memorydata.plugin")).toString();
    L22:
        if (Intrinsics.areEqual(r6, r8) == true) goto L23;
        r2 = r2 + 1;
        goto L14
    L23:
        return true;
    L18:
        r4 = null;
        goto L19
    L26:
        return false;
    L5:
        return c.contains(r8);
    }

    public final void a(AbsTaskRequest r9) {
        Intrinsics.checkNotNullParameter(r9, "taskRequest");
        JSONObject r0 = new JSONObject();
        r0.put("task_id", r9.getTaskInfo().a().toString());
        r0.put(ActivityLifecycle.NAME, r9.getTaskInfo().b());
        r0.put("state", r9.getTaskInfo().c().name());
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskExecuteInfoReporter", "task blocked " + r0, null, 4, null);
        if (a(r9.getTaskInfo().b()) == false) goto L5;
        return;
    L5:
        Tracker.INSTANCE.reportEvent("memory_task_blocked", r0);
    }

    public final void a(TaskInfo r8) {
        Intrinsics.checkNotNullParameter(r8, "taskInfo");
        long r0 = System.currentTimeMillis();
        ConcurrentHashMap<String, Long> r7 = f12972b;
        Long r2 = (Long) ZeusTransformUtils.preCheckCast(r7.get(r8.b()), Long.class, "com.obric.memorydata.plugin");
        if (r2 != null) goto L5;
    L7:
        Long r1 = Long.valueOf(r0);
        ((Map) ZeusTransformUtils.preCheckCast(r7, Map.class, "com.obric.memorydata.plugin")).put(r8.b(), r1);
        JSONObject r9 = new JSONObject();
        r9.put("task_id", r8.a().toString());
        r9.put(ActivityLifecycle.NAME, r8.b());
        r9.put("state", r8.c().name());
        r9.put("execute_result", r8.e().getCode());
        String r3 = r8.e().getMsg().substring(0, Math.min(r8.e().getMsg().length(), 50));
        Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
        r9.put("execute_result_info", r3);
        r9.put("execute_immediately", r8.f());
        r9.put("execute_cost", r8.h());
        r9.put("execute_logic_cost", r8.i());
        r9.put("wait_queue_cost", r8.j());
        r9.put("retry_times", r8.g());
        IRunLog r4 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        String r5 = r9.toString();
        Intrinsics.checkNotNullExpressionValue(r5, "toString(...)");
        IRunLog.a.a(r4, "TaskExecuteInfoReporter", r5, false, 4, null);
        Tracker.INSTANCE.reportEvent(OsTeaTrackerEventId.MEMORY_TASK_EXECUTE_INFO.getValue(), r9);
        return;
    L5:
        if (Math.abs(r0 - r2.longValue()) >= 30000) goto L7;
    }

    public final void b(TaskInfo r7) {
        Intrinsics.checkNotNullParameter(r7, "taskInfo");
        JSONObject r6 = new JSONObject();
        r6.put("task_id", r7.a().toString());
        r6.put(ActivityLifecycle.NAME, r7.b());
        r6.put("state", r7.c().name());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "TaskExecuteInfoReporter", "task run start " + r6, false, 4, null);
        Tracker.INSTANCE.reportEvent("memory_task_execute_start", r6);
    }
}
