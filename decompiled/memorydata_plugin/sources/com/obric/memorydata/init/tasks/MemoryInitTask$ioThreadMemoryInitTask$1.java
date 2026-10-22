package com.obric.memorydata.init.tasks;

import com.obric.memorydata.database.manager.q;
import com.obric.memorydata.memory.api.MemoryService;
import com.obric.memorydata.memory.ui.list.at;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.au;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.init.tasks.MemoryInitTask$ioThreadMemoryInitTask$1", f = "MemoryInitTask.kt", i = {}, l = {765, 768}, m = "invokeSuspend", n = {}, s = {})
final class MemoryInitTask$ioThreadMemoryInitTask$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ MemoryInitTask this$0;

    MemoryInitTask$ioThreadMemoryInitTask$1(MemoryInitTask r3, Continuation<? super MemoryInitTask$ioThreadMemoryInitTask$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    private static final Unit invokeSuspend$lambda$0() {
        q.f9592a.b();
        com.obric.memorydata.memory.migration.a.f10330a.a();
        at.f11208a.a();
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit lambda$PrBDfPm3LxqjdRNB76DzVCjbczc() {
        return invokeSuspend$lambda$0();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new MemoryInitTask$ioThreadMemoryInitTask$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MemoryInitTask$ioThreadMemoryInitTask$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MemoryInitTask$ioThreadMemoryInitTask$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L16:
        MemoryInitTask.e(this.this$0);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r8);
    L13:
        MemoryService.INSTANCE.runAfterRawMemoryTranslateTask();
        Continuation r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 2;
        if (au.a(20000, r9) != r0) goto L16;
        return r0;
    L10:
        ResultKt.throwOnFailure(r8);
        com.obric.memorydata.sdk.d.a($$Lambda$MemoryInitTask$ioThreadMemoryInitTask$1$PrBDfPm3LxqjdRNB76DzVCjbczc.INSTANCE);
        MemoryInitTask.b(this.this$0);
        MemoryInitTask.c(this.this$0);
        MemoryInitTask.d(this.this$0);
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (au.a(3000, r10) != r0) goto L13;
        return r0;
    }
}
