package com.obric.memorydata.init.tasks;

import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.database.index.RefreshVectorDataUpdateStatusTask;
import com.obric.memorydata.middleware.api.aikernel.PapayaAPI;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.controller.NetworkController;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.personalcontext.EntityManager;
import com.obric.memorydata.personalcontext.o;
import com.obric.memorydata.personalcontext.task.EntityConsistencyCheckTask;
import com.obric.memorydata.personalcontext.task.PapayaUpdateTask;
import com.obric.memorydata.personalcontext.task.SearchPackageModelCheckTask;
import com.obric.memorydata.personalcontext.util.k;
import com.obric.memorydata.personalcontext.vectordb.PersonalVectorDbFileMigrator;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.condition.Condition;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\b\u0010\u0007\u001a\u00020\u0005H\u0002J\b\u0010\b\u001a\u00020\u0005H\u0002¨\u0006\n"}, d2 = {"Lcom/obric/memorydata/init/tasks/PCModelInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "registerTask", "scheduleUpdateTask", "registerReportEventRejectedHandler", "Companion", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class PCModelInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9905a = null;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/obric/memorydata/init/tasks/PCModelInitTask$Companion;", "", "<init>", "()V", "TASK_ID", "", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f9905a = new a(null);
    }

    public PCModelInitTask() {
    }

    private final void a() {
        TaskRegister.f12863a.a(PapayaUpdateTask.NAME, PapayaUpdateTask.class);
        TaskRegister.f12863a.a(MemoryRecoverInitTask.NAME, MemoryRecoverInitTask.class);
        TaskRegister.f12863a.a("SearchPackageModelCheckTask", SearchPackageModelCheckTask.class);
        TaskRegister.f12863a.a("EntityConsistencyCheckTask", EntityConsistencyCheckTask.class);
        TaskRegister.f12863a.a(EntityConsistencyCheckTask.RECOVERY_TASK_NAME, EntityConsistencyCheckTask.class);
        TaskRegister.f12863a.a(SlowEntityIndexInitTask.NAME, SlowEntityIndexInitTask.class);
        TaskRegister.f12863a.a(PreloadPackageTask.NAME, PreloadPackageTask.class);
        TaskRegister.f12863a.a(RefreshVectorDataUpdateStatusTask.TASK_NAME, RefreshVectorDataUpdateStatusTask.class);
    }

    private final void b() {
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(PapayaUpdateTask.NAME).setDelay((g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.b(1), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setInterval((g) ZeusTransformUtils.preCheckCast(new com.obric.memorydata.task.impl.b(1), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.REPLACE_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setConditions(new Condition[]{Condition.NETWORK_AVAILABLE, Condition.SCREEN_ON}), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    private final void c() {
        com.obric.memorydata.database.util.b.f9624a.b();
    }

    @Override // java.lang.Runnable
    public void run() {
        RunLog.INSTANCE.debug("PCModelInitTask", "PCModelInitTask run");
        com.obric.memorydata.task.utils.b.f12969a.a();
        NetworkController.INSTANCE.init();
        a();
        PersonalVectorDbFileMigrator.f12393a.a();
        com.obric.memorydata.personalcontext.vectordb.g.f12413a.a();
        c();
        EntityManager.INSTANCE.checkIfReDonateEntityWhenLaunch();
        k.f12380a.a();
        if (AppContext.INSTANCE.isObricFlavor() == false) goto L5;
        o.f12238a.a();
    L5:
        com.obric.memorydata.personalcontext.d.f12081a.a();
        b();
        if (PapayaAPI.INSTANCE.isInit() == false) goto L9;
        d.f9920a.b();
        return;
    }
}
