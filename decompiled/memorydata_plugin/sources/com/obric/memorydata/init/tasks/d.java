package com.obric.memorydata.init.tasks;

import com.bytedance.apm6.util.constant.CommonConsts;
import com.obric.memorydata.aikernelcore.h;
import com.obric.memorydata.awareness.api.AwarenessManager;
import com.obric.memorydata.middleware.api.app.UserSettings;
import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.task.TaskRegister;
import com.obric.memorydata.task.impl.TaskRequest;
import com.obric.memorydata.task.impl.f;
import com.obric.memorydata.task.impl.g;
import com.obric.memorydata.task.scheduler.impl.ExistingTaskPolicy;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.am;
import kotlinx.coroutines.ba;
import kotlinx.coroutines.i;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\b\u001a\u00020\tJ\u0006\u0010\n\u001a\u00020\tJ\b\u0010\u000b\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/obric/memorydata/init/tasks/PapayaSDK;", "", "<init>", "()V", "TAG", "", "inited", "", CommonConsts.APM_INNER_EVENT_COST_INIT, "", "startAfterUserAgreePrivacy", "enqueueMemoryRecoverIfRegistered", "personal_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f9920a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f9921b;

    static {
        f9920a = new d();
    }

    private d() {
    }

    private final void c() {
        if (TaskRegister.f12863a.b(MemoryRecoverInitTask.NAME, MemoryRecoverInitTask.class) == true) goto L6;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaSDK", "skip MemoryRecoverInitTask: native task not registered", false, 4, null);
        return;
    L6:
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder(MemoryRecoverInitTask.NAME).setPriority(10), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
    }

    public final void a() {
        if (f9921b == false) goto L5;
        return;
    L5:
        f9921b = true;
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaSDK", "SDK init start", false, 4, null);
        i.a(am.a((CoroutineContext) ZeusTransformUtils.preCheckCast(ba.c(), CoroutineContext.class, "com.obric.memorydata.plugin")), null, null, (Function2) ZeusTransformUtils.preCheckCast(new PapayaSDK$init$1(null), Function2.class, "com.obric.memorydata.plugin"), 3, null);
    }

    public final void b() {
        if (UserSettings.INSTANCE.hasAgreePrivacy() == true) goto L6;
        return;
    L6:
        if (AppContext.INSTANCE.isObricFlavor() == false) goto L8;
        AwarenessManager.INSTANCE.updatePackageInfo(true);
        h.f8481a.b();
    L8:
        c();
        ((TaskRequest) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(((TaskRequest.Builder) ZeusTransformUtils.preCheckCast(new TaskRequest.Builder("memory_scene_build").setDelay((g) ZeusTransformUtils.preCheckCast(new f(10), g.class, "com.obric.memorydata.plugin")), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).setExistingTaskPolicy(ExistingTaskPolicy.KEEP_IN_QUEUE), TaskRequest.Builder.class, "com.obric.memorydata.plugin")).build(), TaskRequest.class, "com.obric.memorydata.plugin")).enqueue();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "PapayaSDK", "enqueue memory_scene_build after privacy startup delay 10s", false, 4, null);
    }
}
