package com.obric.memorydata.memory.ui.settings.contextawareness;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "<unused var>", ""}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.settings.contextawareness.ContextAwarenessSettingsStateOwner$authorityChanges$2", f = "ContextAwarenessSettingsGateway.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ContextAwarenessSettingsStateOwner$authorityChanges$2 extends SuspendLambda implements Function4<Unit, Boolean, Boolean, Continuation<? super Unit>, Object> {
    int label;

    ContextAwarenessSettingsStateOwner$authorityChanges$2(Continuation<? super ContextAwarenessSettingsStateOwner$authorityChanges$2> r3) {
        super(4, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function4
    public /* synthetic */ Object invoke(Unit r3, Boolean r4, Boolean r5, Continuation<? super Unit> r6) {
        return invoke((Unit) ZeusTransformUtils.preCheckCast(r3, Unit.class, "com.obric.memorydata.plugin"), ((Boolean) ZeusTransformUtils.preCheckCast(r4, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), ((Boolean) ZeusTransformUtils.preCheckCast(r5, Boolean.class, "com.obric.memorydata.plugin")).booleanValue(), (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(Unit r1, boolean r2, boolean r3, Continuation<? super Unit> r4) {
        return new ContextAwarenessSettingsStateOwner$authorityChanges$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r1) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r1);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
