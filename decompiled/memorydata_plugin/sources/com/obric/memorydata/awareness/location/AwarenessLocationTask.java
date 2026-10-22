package com.obric.memorydata.awareness.location;

import com.obric.memorydata.awareness.api.ILocationSnapshot;
import com.obric.memorydata.awareness.api.LocationSnapshot;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskResult;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/awareness/location/AwarenessLocationTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskParameter", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class AwarenessLocationTask extends NativeTask {
    public static final a Companion = null;
    public static final String NAME = "AwarenessLocationTask";
    private static final String TAG = "AwarenessLocationTask";

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/awareness/location/AwarenessLocationTask$Companion;", "", "<init>", "()V", "NAME", "", "TAG", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public AwarenessLocationTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskParameter");
        super(r2);
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        RunLog.INSTANCE.info("AwarenessLocationTask", "invoke AwarenessLocationTask", true);
        ILocationSnapshot.a.a((ILocationSnapshot) ZeusTransformUtils.preCheckCast(LocationSnapshot.INSTANCE, ILocationSnapshot.class, "com.obric.memorydata.plugin"), 0, 1, null);
        return new TaskResult(0, null, null, null, 14, null);
    }
}
