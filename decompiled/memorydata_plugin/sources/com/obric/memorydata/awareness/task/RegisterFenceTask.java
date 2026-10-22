package com.obric.memorydata.awareness.task;

import com.obric.memorydata.awareness.api.FeatureManager;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\tH\u0002¨\u0006\u000b"}, d2 = {"Lcom/obric/memorydata/awareness/task/RegisterFenceTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskParameter", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "refreshCommuteProfile", "", "Companion", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RegisterFenceTask extends NativeTask {
    public static final a Companion = null;
    private static final String TAG = "RegisterFenceTask";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/awareness/task/RegisterFenceTask$Companion;", "", "<init>", "()V", "TAG", "", "awareness_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public RegisterFenceTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskParameter");
        super(r2);
    }

    public static /* synthetic */ void lambda$QAaJvNiZWku1WjRr1MWdiK5dThw(RegisterFenceTask r0) {
        run$lambda$0(r0);
    }

    private final void refreshCommuteProfile() {
        Object r4 = FeatureManager.INSTANCE.getFeature("location_home_gps");
        if (r4 != null) goto L5;
        return;
    L5:
        if (ZeusTransformUtils.instanceOf(r4, List.class) == true) goto L7;
        return;
    L7:
        if (((Collection) ZeusTransformUtils.preCheckCast(r4, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L22;
        Object r5 = FeatureManager.INSTANCE.getFeature("location_company_gps");
        if (r5 != null) goto L12;
        return;
    L12:
        if (ZeusTransformUtils.instanceOf(r5, List.class) == true) goto L14;
        return;
    L14:
        if (((Collection) ZeusTransformUtils.preCheckCast(r5, Collection.class, "com.obric.memorydata.plugin")).size() != 2) goto L23;
        TaskRequest.Builder r6 = new TaskRequest.Builder("commute_track_and_check");
        JSONObject r0 = new JSONObject();
        r0.put("taskName", "longTerm");
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(r6.setInputParam(r0), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).execute();
        return;
    L23:
        return;
    }

    private static final void run$lambda$0(RegisterFenceTask r0) {
        r0.refreshCommuteProfile();
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), TAG, "run RegisterFenceTask", false, 4, null);
        ThreadPoolContainer.Companion.getInstance().execute(new $$Lambda$RegisterFenceTask$QAaJvNiZWku1WjRr1MWdiK5dThw(this));
        return new TaskResult(0, null, null, null, 14, null);
    }
}
