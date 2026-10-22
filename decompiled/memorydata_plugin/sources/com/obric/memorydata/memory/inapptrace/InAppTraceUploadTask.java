package com.obric.memorydata.memory.inapptrace;

import com.bytedance.crash.entity.EventBody;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u000e"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceUploadTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "result", "message", "", EventBody.KEY_VALUE, "Lcom/obric/memorydata/memory/inapptrace/InAppTraceUploadRunResult;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class InAppTraceUploadTask extends NativeTask {
    public static final a Companion = null;
    public static final String NAME = "InAppTraceUploadTask";
    private static final String TAG = "InAppTraceUploadTask";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/memory/inapptrace/InAppTraceUploadTask$Companion;", "", "<init>", "()V", "NAME", "", "TAG", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public InAppTraceUploadTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    private final TaskResult result(String r8, j r9) {
        JSONObject r3 = new JSONObject().put("totalCount", r9.a()).put("successCount", r9.b()).put("failureCount", r9.c());
        Intrinsics.checkNotNullExpressionValue(r3, "put(...)");
        return new TaskResult(0, r8, r3, null, 8, null);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        j r0 = i.f10176a.a();
        RunLog.INSTANCE.info("InAppTraceUploadTask", "trace upload task finish total=" + r0.a() + " success=" + r0.b() + " failure=" + r0.c(), true);
        return result("success", r0);
    }
}
