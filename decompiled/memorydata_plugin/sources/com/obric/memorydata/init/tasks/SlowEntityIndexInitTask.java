package com.obric.memorydata.init.tasks;

import com.obric.memorydata.ability.data.h;
import com.obric.memorydata.ability.data.p;
import com.obric.memorydata.ability.k;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.AbsTaskRequest;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.NativeTask;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.TaskResult;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.tom_roush.pdfbox.pdmodel.a.d.f;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\t"}, d2 = {"Lcom/obric/memorydata/init/tasks/SlowEntityIndexInitTask;", "Lcom/obric/memorydata/task/impl/NativeTask;", "taskRequest", "Lcom/obric/memorydata/task/AbsTaskRequest;", "<init>", "(Lcom/obric/memorydata/task/AbsTaskRequest;)V", "run", "Lcom/obric/memorydata/task/impl/TaskResult;", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class SlowEntityIndexInitTask extends NativeTask {
    public static final a Companion = null;
    public static final String NAME = "SlowEntityIndexTask";
    private static final com.obric.memorydata.ability.d abilityManager = null;
    private static final AtomicBoolean isRegisterSlowIndexTrigger = null;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u000bR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/init/tasks/SlowEntityIndexInitTask$Companion;", "", "<init>", "()V", "NAME", "", "isRegisterSlowIndexTrigger", "Ljava/util/concurrent/atomic/AtomicBoolean;", "abilityManager", "Lcom/obric/memorydata/ability/AbilityManager;", "registerSlowIndexTrigger", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {

        /* JADX INFO: renamed from: com.obric.memorydata.init.tasks.SlowEntityIndexInitTask$a$a, reason: collision with other inner class name */
        @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/obric/memorydata/init/tasks/SlowEntityIndexInitTask$Companion$registerSlowIndexTrigger$1", "Lcom/obric/memorydata/ability/IAbilityDataReceiver;", "onDataReceive", "", "data", "Lcom/obric/memorydata/ability/data/IStandardData;", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
        public static final class C0476a implements k {
            C0476a() {
            }

            @Override // com.obric.memorydata.ability.k
            public void a(h r4) {
                h r3 = (h) ZeusTransformUtils.wrapperContextForParams(r4, h.class, "com.obric.memorydata.plugin");
                Intrinsics.checkNotNullParameter(r3, "data");
                if (ZeusTransformUtils.instanceOf(r3, p.class) == true) goto L5;
                return;
            L5:
                if (Intrinsics.areEqual(((p) ZeusTransformUtils.preCheckCast(r3, p.class, "com.obric.memorydata.plugin")).a(), f.g) == false) goto L9;
                ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME).setConditions(new Condition[]{Condition.STRICTLY_POWER_CONTROL}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
                return;
            }

            @Override // com.obric.memorydata.ability.k
            public String g_() {
                return k.a.a(this);
            }
        }

        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        public final void a() {
            if (SlowEntityIndexInitTask.access$isRegisterSlowIndexTrigger$cp().compareAndSet(false, true) == true) goto L5;
            return;
        L5:
            SlowEntityIndexInitTask.access$getAbilityManager$cp().a(new com.obric.memorydata.ability.f(100000005, MapsKt.emptyMap()), (k) ZeusTransformUtils.preCheckCast(new C0476a(), k.class, "com.obric.memorydata.plugin"));
        }
    }

    static {
        Companion = new a(null);
        isRegisterSlowIndexTrigger = new AtomicBoolean(false);
        abilityManager = new com.obric.memorydata.ability.d();
    }

    public SlowEntityIndexInitTask(AbsTaskRequest r2) {
        Intrinsics.checkNotNullParameter(r2, "taskRequest");
        super(r2);
    }

    public static final /* synthetic */ com.obric.memorydata.ability.d access$getAbilityManager$cp() {
        return abilityManager;
    }

    public static final /* synthetic */ AtomicBoolean access$isRegisterSlowIndexTrigger$cp() {
        return isRegisterSlowIndexTrigger;
    }

    @Override // com.obric.memorydata.task.AbsTask
    public TaskResult run() {
        RunLog.INSTANCE.debug(NAME, "start SlowEntityIndexInitTask");
        Companion.a();
        return new TaskResult(0, null, null, CollectionsKt.listOf((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(com.obric.memorydata.database.entity.d.SLOW_INDEX_TASK_NAME).setConditions(new Condition[]{Condition.STRICTLY_POWER_CONTROL}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setDelay((g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.f(10), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")), 6, null);
    }
}
