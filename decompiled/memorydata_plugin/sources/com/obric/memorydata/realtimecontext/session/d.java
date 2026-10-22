package com.obric.memorydata.realtimecontext.session;

import com.obric.memorydata.middleware.api.appcontext.AppContext;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.realtimecontext.RealTimeContextService;
import com.obric.memorydata.sdk.realtime.ActionContext;
import com.obric.memorydata.sdk.realtime.RealTimeContext;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/obric/memorydata/realtimecontext/session/RealTimeDataForCloud;", "Lcom/obric/memorydata/realtimecontext/session/RealTimeData;", "<init>", "()V", "callback", "Lcom/obric/memorydata/sdk/realtime/IRealTimeContextCallback;", "updateCallback", "", "commit", "flag", "", "commitReal", "isFinish", "", "commitAction", "actionContext", "Lcom/obric/memorydata/sdk/realtime/ActionContext;", "clear", "realtime_context_obricRelease"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class d extends c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.obric.memorydata.sdk.realtime.a f12485b;

    public d() {
    }

    private final void a(boolean r12) {
        if (this.f12485b == null) goto L18;
        RealTimeContext r1 = new RealTimeContext(a(), b(), CollectionsKt.emptyList(), CollectionsKt.emptyList(), d(), e(), c());     // Catch: Throwable -> L13
        if (AppContext.INSTANCE.isDebug() == false) goto L8;
        RunLog.INSTANCE.debug(RealTimeContextService.TAG, "commit, isFinish: " + r12 + ", flag: " + f() + ", realTimeContext: " + r1);     // Catch: Throwable -> L13
    L9:
        com.obric.memorydata.sdk.realtime.a r11 = this.f12485b;     // Catch: Throwable -> L13
        if (r11 == null) goto L19;
        r11.a(r1, r12);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L8:
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "commit, isFinish: " + r12 + ", flag: " + f(), false, 4, null);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "commitReal, error: " + th.getMessage(), null, 4, null);
        return;
    }

    @Override // com.obric.memorydata.realtimecontext.session.c
    public void a(int r1) {
        super.a(r1);
        a(g());
    }

    @Override // com.obric.memorydata.realtimecontext.session.c
    public void a(ActionContext r10) {
        Intrinsics.checkNotNullParameter(r10, "actionContext");
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "commitAction, actionContext: " + r10.getType(), false, 4, null);
        com.obric.memorydata.sdk.realtime.a r9 = this.f12485b;
        if (r9 == null) goto L12;
        if (r9 == null) goto L13;
        r9.a(r10);     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        IRunLog.a.b((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), RealTimeContextService.TAG, "commitAction, error: " + e.getMessage(), null, 4, null);
        return;
    L13:
        return;
    }

    public final void a(com.obric.memorydata.sdk.realtime.a r3) {
        this.f12485b = (com.obric.memorydata.sdk.realtime.a) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.memorydata.sdk.realtime.a.class, "com.obric.memorydata.plugin");
    }

    @Override // com.obric.memorydata.realtimecontext.session.c
    public void j() {
        super.j();
        this.f12485b = null;
    }
}
