package com.obric.memorydata.memory.contextsync;

import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextAlignmentTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryContextAlignmentTask extends NativeTask {
    public static final a Companion = null;
    public static final String NAME = "MemoryContextAlignmentTask";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/memory/contextsync/MemoryContextAlignmentTask$Companion;", "", "<init>", "()V", "NAME", "", "memory_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public MemoryContextAlignmentTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    public static /* synthetic */ TaskResult lambda$BO00cuZ8Fgjn5PGFcx0uTOIe2og(MemoryContextAlignmentTask r0, MemoryContextAlignmentSource r1) {
        return run$lambda$0(r0, r1);
    }

    private static final TaskResult run$lambda$0(MemoryContextAlignmentTask r6, MemoryContextAlignmentSource r7) {
        return h.f10105a.a((NativeTask) ZeusTransformUtils.preCheckCast(r6, NativeTask.class, "com.obric.memorydata.plugin"), r7, f.f10102a.b(r6.getTaskRequest()), f.f10102a.c(r6.getTaskRequest()));
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        final MemoryContextAlignmentSource r0 = f.f10102a.a(getTaskRequest());
        if (r0 != null) goto L7;
        return new TaskResult(1, "invalid alignment source", null, null, 12, null);
    L7:
        return (TaskResult) ZeusTransformUtils.preCheckCast(c.f10095a.a(new $$Lambda$MemoryContextAlignmentTask$BO00cuZ8Fgjn5PGFcx0uTOIe2og(this, r0)), TaskResult.class, "com.obric.memorydata.plugin");
    }
}
