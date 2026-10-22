package com.obric.memorydata.init.tasks;

import android.content.Context;
import android.provider.Settings;
import com.bytedance.lego.init.model.IInitTask;
import com.obric.memorydata.datatransport.api.DataTransportManagerApi;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.recommend.context.task.PendingAppTypeCheckTask;
import com.obric.memorydata.recommend.feature.ScreenObservationRestoreTask;
import com.obric.memorydata.recommend.settings.t;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.utils.threadpool.ThreadPoolContainer;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0005H\u0002¨\u0006\b"}, d2 = {"Lcom/obric/memorydata/init/tasks/RecommendInitTask;", "Lcom/bytedance/lego/init/model/IInitTask;", "<init>", "()V", "run", "", "setupTask", "Companion", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class RecommendInitTask extends IInitTask {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f9910a = null;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/memorydata/init/tasks/RecommendInitTask$Companion;", "", "<init>", "()V", "TAG", "", "PROACTIVE_PACKAGE_NAME", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/obric/memorydata/init/tasks/RecommendInitTask$run$1", "Lcom/obric/memorydata/recommend/screenshotupload/MemoryRuleObserver$MemoryRuleListener;", "onMemoryRuleAppsChanged", "", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class b implements com.obric.memorydata.recommend.screenshotupload.b.a {
        b() {
        }

        @Override // com.obric.memorydata.recommend.screenshotupload.b.a
        public void a() {
            List<String> r7 = CollectionsKt.sorted((Iterable) ZeusTransformUtils.preCheckCast(com.obric.memorydata.recommend.screenshotupload.b.f12542a.b(), Iterable.class, "com.obric.memorydata.plugin"));
            MemoryService.INSTANCE.updateInAppSignalCollectionPackages(r7);
            IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendInitTask", "update in-app signal packages, count=" + r7.size() + ", packages=" + r7, false, 4, null);
        }
    }

    @Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0016J\u000e\u0010\u0004\u001a\u00020\u0005H\u0096@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"com/obric/memorydata/init/tasks/RecommendInitTask$run$3", "Lcom/obric/memorydata/datatransport/api/DataTransportExtension;", "getExportPath", "", "cleanData", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recommend_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class c implements com.obric.memorydata.datatransport.api.b {
        c() {
        }

        @Override // com.obric.memorydata.datatransport.api.b
        public Object a(Continuation<? super Boolean> r2) {
            Continuation r1 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin");
            return Boxing.boxBoolean(true);
        }

        @Override // com.obric.memorydata.datatransport.api.b
        public String a() {
            return new File(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getFilesDir(), "Screenshots").getAbsolutePath();
        }
    }

    static {
        f9910a = new a(null);
    }

    public RecommendInitTask() {
    }

    private final void a() {
        TaskRegister.f12863a.a(ScreenObservationRestoreTask.TASK_NAME, ScreenObservationRestoreTask.class);
        TaskRegister.f12863a.a(PendingAppTypeCheckTask.NAME, PendingAppTypeCheckTask.class);
    }

    private static final void b() {
        boolean r1 = ((Boolean) ZeusTransformUtils.preCheckCast(t.f12630a.e().c(), Boolean.class, "com.obric.memorydata.plugin")).booleanValue();
    L7:
        e = move-exception;
        String r2 = "com.obric.memorydata.screen_memory_enabled write " + (r1 ? 1 : 0) + " failed";
        RunLog.INSTANCE.warn("RecommendInitTask", r2, (Throwable) ZeusTransformUtils.preCheckCast(e, Throwable.class, "com.obric.memorydata.plugin"));
        com.bytedance.services.apm.api.a.a(r2);
        return;
    L4:
        if (Settings.System.getInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "com.obric.memorydata.screen_memory_enabled", 0) == r1) goto L12;
        Settings.System.putInt(((Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(AppContext.INSTANCE.getContext(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin")).getContentResolver(), "com.obric.memorydata.screen_memory_enabled", r1 ? 1 : 0);     // Catch: Exception -> L7
        return;
    }

    public static /* synthetic */ void lambda$iM0KqoH3aifbDh3i1WdcFtpvG2M() {
        b();
    }

    @Override // java.lang.Runnable
    public void run() {
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "RecommendInitTask", "RecommendInitTask run", false, 4, null);
        a();
        ((TaskRequest) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("recommend_settings").build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        com.obric.memorydata.recommend.screenshotupload.b.f12542a.a();
        com.obric.memorydata.recommend.screenshotupload.b.f12542a.a((com.obric.memorydata.recommend.screenshotupload.b.a) ZeusTransformUtils.preCheckCast(new b(), com.obric.memorydata.recommend.screenshotupload.b.a.class, "com.obric.memorydata.plugin"));
        com.obric.memorydata.recommend.useraction.recommend.b.f12763a.a();
        ThreadPoolContainer.Companion.getInstance().execute($$Lambda$RecommendInitTask$iM0KqoH3aifbDh3i1WdcFtpvG2M.INSTANCE);
        com.obric.memorydata.recommend.statusbar.a.f12632a.a();
        DataTransportManagerApi r9 = com.obric.memorydata.datatransport.api.c.a();
        if (r9 == null) goto L6;
        r9.register((com.obric.memorydata.datatransport.api.b) ZeusTransformUtils.preCheckCast(new c(), com.obric.memorydata.datatransport.api.b.class, "com.obric.memorydata.plugin"));
        return;
    }
}
