package com.obric.memorydata.memory.review.provider;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0002¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "emptySuccessResult", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryTraceReportTask extends NativeTask {
    public static final a Companion = null;
    public static final String DEBOUNCE_NAME = "MemoryTraceReportDebounceTask";
    public static final String NAME = "MemoryTraceReportTask";
    private static final String TAG = "MemoryTraceReportTask";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/memory/review/provider/MemoryTraceReportTask$Companion;", "", "<init>", "()V", "NAME", "", "DEBOUNCE_NAME", "TAG", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        Companion = new a(null);
    }

    public MemoryTraceReportTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    private final TaskResult emptySuccessResult() {
        JSONObject r3 = new JSONObject().put("totalCount", 0).put("successCount", 0).put("failureCount", 0);
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return new TaskResult(0, "entry disabled", r3, null, 8, null);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        if (com.obric.memorydata.database.c.b.f8850a.a() == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportTask", "memory trace report task skipped, entry disabled", false, 4, null);
        return emptySuccessResult();
    L6:
        at r0 = new aq(null, null, null, null, 0, 0, 0, 0, 0, 0, null, 2047, null).a();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryTraceReportTask", "memory trace report task finish total=" + r0.a() + " success=" + r0.b() + " failure=" + r0.c(), false, 4, null);
        JSONObject r11 = new JSONObject().put("totalCount", r0.a()).put("successCount", r0.b()).put("failureCount", r0.c());
        Intrinsics.checkNotNullExpressionValue(r11, "put(...)");
        return new TaskResult(0, "success", r11, null, 8, null);
    }
}
