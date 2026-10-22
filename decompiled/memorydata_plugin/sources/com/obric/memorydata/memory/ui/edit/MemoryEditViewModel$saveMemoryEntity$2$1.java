package com.obric.memorydata.memory.ui.edit;

import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.database.entity.RawMemoryEntity;
import com.obric.memorydata.database.manager.MemoryDbEngine;
import com.obric.memorydata.middleware.api.log.IRunLog;
import com.obric.memorydata.middleware.api.log.RunLog;
import com.obric.memorydata.utils.y;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "Lcom/obric/capabilitykit/entity/memory/MemoryEntity;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.edit.MemoryEditViewModel$saveMemoryEntity$2$1", f = "MemoryEditViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class MemoryEditViewModel$saveMemoryEntity$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Result<? extends MemoryEntity>>, Object> {
    final /* synthetic */ e $this_apply;
    int label;

    MemoryEditViewModel$saveMemoryEntity$2$1(e r3, Continuation<? super MemoryEditViewModel$saveMemoryEntity$2$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_apply = r3;
        super(2, r5);
    }

    private static final Result invokeSuspend$lambda$0(Exception r5) {
        RunLog.INSTANCE.error("MemoryEditViewModel", "saveMemoryEntity error", (Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"));
        Result.Companion r0 = Result.Companion;
        return Result.m1420boximpl(Result.m1421constructorimpl(ResultKt.createFailure((Throwable) ZeusTransformUtils.preCheckCast(r5, Throwable.class, "com.obric.memorydata.plugin"))));
    }

    private static final Result invokeSuspend$lambda$2(e r11) {
        MemoryEntity r0 = r11.b();
        Long r1 = null;
        if (r0 == null) goto L11;
        r0.setLastModifiedTime(System.currentTimeMillis());
        IRunLog.a.a((IRunLog) ZeusTransformUtils.preCheckCast(RunLog.INSTANCE, IRunLog.class, "com.obric.memorydata.plugin"), "MemoryEditViewModel", "update memoryEntity " + r0.getId(), false, 4, null);
        com.obric.memorydata.memory.memoryentity.d.f10317a.update(r0);
        RawMemoryEntity r2 = (RawMemoryEntity) ZeusTransformUtils.preCheckCast(CollectionsKt.firstOrNull(MemoryDbEngine.INSTANCE.getGlobalDbEngine().getRawMemoryEntityDao().queryByEntityId(r11.a().getId(), r11.a().get_packageName())), RawMemoryEntity.class, "com.obric.memorydata.plugin");
        if (r2 == null) goto L7;
        r1 = Long.valueOf(r2.getId());
    L7:
        if (r1 == null) goto L9;
        g.f10904a.a(r1.longValue(), r11.a());
    L9:
        Result.Companion r12 = Result.Companion;
        return Result.m1420boximpl(Result.m1421constructorimpl(r0));
    L11:
        return null;
    }

    public static /* synthetic */ Result lambda$NGwL4wGNvZIQ2BWkX6AtIR0p7Ak(Exception r0) {
        return invokeSuspend$lambda$0(r0);
    }

    public static /* synthetic */ Result lambda$UedyRyIyPsBTEpPxqCfc2XlYcxI(e r0) {
        return invokeSuspend$lambda$2(r0);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryEditViewModel$saveMemoryEntity$2$1(this.$this_apply, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Result<? extends MemoryEntity>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Result<? extends MemoryEntity>> r4) {
        return ((MemoryEditViewModel$saveMemoryEntity$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryEditViewModel$saveMemoryEntity$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        $$Lambda$MemoryEditViewModel$saveMemoryEntity$2$1$NGwL4wGNvZIQ2BWkX6AtIR0p7Ak r3 = $$Lambda$MemoryEditViewModel$saveMemoryEntity$2$1$NGwL4wGNvZIQ2BWkX6AtIR0p7Ak.INSTANCE;
        final e r1 = this.$this_apply;
        return y.a(r3, new $$Lambda$MemoryEditViewModel$saveMemoryEntity$2$1$UedyRyIyPsBTEpPxqCfc2XlYcxI(r1));
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
