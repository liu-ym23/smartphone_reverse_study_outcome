package com.obric.memorydata.memory.island.gr;

import android.app.NotificationManager;
import android.content.Context;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandNotificationManager$destroyAllSessions$1", f = "IslandNotificationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IslandNotificationManager$destroyAllSessions$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    int label;

    IslandNotificationManager$destroyAllSessions$1(Continuation<? super IslandNotificationManager$destroyAllSessions$1> r3) {
        super(1, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r2) {
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandNotificationManager$destroyAllSessions$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r2, Continuation.class, "com.obric.memorydata.plugin")), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((IslandNotificationManager$destroyAllSessions$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), IslandNotificationManager$destroyAllSessions$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L11;
        ResultKt.throwOnFailure(r7);
        NotificationManager r6 = e.a(e.f10211a, (Context) ZeusTransformUtils.preCheckCast(ZeusTransformUtils.wrapperContext(e.f10211a.b(), "com.obric.memorydata.plugin"), Context.class, "com.obric.memorydata.plugin"));
        Iterator r0 = ((Map) ZeusTransformUtils.preCheckCast(e.f10211a.a(), Map.class, "com.obric.memorydata.plugin")).entrySet().iterator();
    L6:
        if (r0.hasNext() == false) goto L8;
        long r1 = ((Number) ZeusTransformUtils.preCheckCast(((Map.Entry) ZeusTransformUtils.preCheckCast(r0.next(), Map.Entry.class, "com.obric.memorydata.plugin")).getValue(), Number.class, "com.obric.memorydata.plugin")).longValue();
        RunLog.INSTANCE.debug("IslandNotifMgr", "destroyAllSessions: cancelling taskId=" + r1);
        r6.cancel((int) r1);
        goto L6
    L8:
        e.f10211a.a().clear();
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "IslandNotifMgr", "destroyAllSessions: done", false, 4, null);
        return Unit.INSTANCE;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
