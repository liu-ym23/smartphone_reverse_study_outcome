package com.obric.memorydata.memory.island.gr;

import android.content.Context;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.island.gr.IslandNotificationManager$createSession$1", f = "IslandNotificationManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class IslandNotificationManager$createSession$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ IslandSession $session;
    int label;

    IslandNotificationManager$createSession$1(IslandSession r3, Context r4, Continuation<? super IslandNotificationManager$createSession$1> r5) {
        Context r6 = (Context) ZeusTransformUtils.wrapperContextForParams(r4, Context.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$session = r3;
        this.$context = ZeusTransformUtils.wrapperContext(r6, "com.obric.memorydata.plugin");
        super(1, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new IslandNotificationManager$createSession$1(this.$session, this.$context, r5), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function1
    public /* synthetic */ Object invoke(Continuation<? super Unit> r3) {
        return invoke2((Continuation) ZeusTransformUtils.preCheckCast(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Continuation<? super Unit> r3) {
        return ((IslandNotificationManager$createSession$1) ZeusTransformUtils.preCheckCast(create((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin")), IslandNotificationManager$createSession$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r4);
        this.$session.setTaskId(System.currentTimeMillis());
        Map r5 = (Map) ZeusTransformUtils.preCheckCast(e.f10211a.a(), Map.class, "com.obric.memorydata.plugin");
        IslandSession r0 = this.$session;
        r5.put(r0, Boxing.boxLong(r0.getTaskId()));
        RunLog.INSTANCE.debug("IslandNotifMgr", "createSession: taskId=" + this.$session.getTaskId());
        e.a(e.f10211a, this.$session, this.$context);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
