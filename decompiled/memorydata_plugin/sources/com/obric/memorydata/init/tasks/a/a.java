package com.obric.memorydata.init.tasks.a;

import androidx.core.app.NotificationCompat;
import com.bytedance.bdlocation.monitor.LocationMonitorConst;
import com.obric.aiagent.platform.a.d;
import com.obric.memorydata.memory.ui.automemory.settings.MemoryInfoSectionEditActivity;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.ttnet.org.chromium.base.BaseSwitches;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\t\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\u001a\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016J$\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J2\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u00072 \u0010\u0014\u001a\u001c\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0015H\u0016¨\u0006\u0017"}, d2 = {"Lcom/obric/memorydata/init/tasks/platform/ALogDependImpl;", "Lcom/obric/aiagent/platform/depend/ILogDepend;", "<init>", "()V", BaseSwitches.V, "", LocationMonitorConst.TAG, "", NotificationCompat.CATEGORY_MESSAGE, "d", "i", "w", "tr", "", "e", "isDebug", "", "getDirPath", "uploadAllLog", MemoryInfoSectionEditActivity.KIND_SCENE, "callback", "Lkotlin/Function3;", "", "init_task_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class a implements d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f9913b = null;

    static {
        f9913b = new a();
    }

    private a() {
    }

    @Override // com.obric.aiagent.platform.a.d
    public void a(String r1, String r2) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        RunLog r0 = RunLog.INSTANCE;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        r0.debug(r1, r2);
    }

    @Override // com.obric.aiagent.platform.a.d
    public void a(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        RunLog r0 = RunLog.INSTANCE;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        if (r3 != null) goto L7;
        r3 = new Throwable();
    L7:
        r0.warn(r1, r2, r3);
    }

    @Override // com.obric.aiagent.platform.a.d
    public void b(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        IRunLog.a.a(r0, r7, r8, false, 4, null);
    }

    @Override // com.obric.aiagent.platform.a.d
    public void b(String r1, String r2, Throwable r3) {
        Intrinsics.checkNotNullParameter(r1, LocationMonitorConst.TAG);
        RunLog r0 = RunLog.INSTANCE;
        if (r2 != null) goto L5;
        r2 = "";
    L5:
        if (r3 != null) goto L7;
        r3 = new Throwable();
    L7:
        r0.error(r1, r2, r3);
    }

    @Override // com.obric.aiagent.platform.a.d
    public void c(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        IRunLog.a.a(r0, r7, r8, null, 4, null);
    }

    @Override // com.obric.aiagent.platform.a.d
    public void d(String r7, String r8) {
        Intrinsics.checkNotNullParameter(r7, LocationMonitorConst.TAG);
        IRunLog r0 = (IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin");
        if (r8 != null) goto L5;
        r8 = "";
    L5:
        IRunLog.a.b(r0, r7, r8, null, 4, null);
    }
}
