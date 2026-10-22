package com.obric.memorydata.init.tasks;

import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.middleware.api.store.IStoreManager;
import com.obric.memorydata.middleware.api.store.StoreManager;
import com.obric.memorydata.personalcontext.task.EntityConsistencyCheckTask;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.f;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0002¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/init/tasks/MemoryRecoverInitTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "buildRawObservationImageUploadConditions", "", "Lcom/obric/memorydata/task/condition/Condition;", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class MemoryRecoverInitTask extends NativeTask {
    public static final a Companion = null;
    public static final String NAME = "MemoryRecoverInitTask";

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/init/tasks/MemoryRecoverInitTask$Companion;", "", "<init>", "()V", "NAME", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
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

    public MemoryRecoverInitTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    private final List<Condition> buildRawObservationImageUploadConditions() {
        List<Condition> r5 = CollectionsKt.mutableListOf(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.COMMON_POWER_CONTROL, Condition.SCREEN_ON_OR_CHARGE});
        if (IStoreManager.DefaultImpls.getStore$default((IStoreManager) ZeusTransformUtils.preCheckCast(StoreManager.INSTANCE, IStoreManager.class, "com.obric.memorydata.plugin"), "recommend_store", 0, 2, null).getBoolean("recommend_cellular_enabled", false) == true) goto L5;
        r5.add(Condition.WIFI_CONNECTED);
    L5:
        return r5;
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        RunLog.INSTANCE.debug(NAME, "run MemoryRecoverInitTask");
        TaskRequest r0 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("SearchPackageModelCheckTask").setDelay((g) ZeusTransformUtils.preCheckCast(new f(10), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        TaskRequest r1 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("SearchPackageModelCheckTask").setInterval((g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.b(1), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.WIFI_CONNECTED, Condition.NETWORK_WINDOW}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        EntityConsistencyCheckTask.Companion.init();
        TaskRequest r5 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(com.obric.memorydata.database.entity.d.FAST_INDEX_TASK_NAME).setConditions(new Condition[]{Condition.LIGHT_POWER_CONTROL}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((g) ZeusTransformUtils.preCheckCast(new f(10), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        TaskRequest r7 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(PreloadPackageTask.NAME).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay(new g(5, TimeUnit.SECONDS)), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        TaskRequest r10 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(SlowEntityIndexInitTask.NAME).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((g) ZeusTransformUtils.preCheckCast(new f(10), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        TaskRequest r11 = (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("memory_scene_build").setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((g) ZeusTransformUtils.preCheckCast(new f(10), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), NAME, "enqueue memory_scene_build after 10s for default scene seed", false, 4, null);
        return new TaskResult(0, null, null, CollectionsKt.listOf(new TaskRequest[]{r0, r1, r5, r10, r11, r7, (TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("raw_observation_image_upload").setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(buildRawObservationImageUploadConditions()), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((g) ZeusTransformUtils.preCheckCast(new f(10), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")}), 6, null);
    }
}
