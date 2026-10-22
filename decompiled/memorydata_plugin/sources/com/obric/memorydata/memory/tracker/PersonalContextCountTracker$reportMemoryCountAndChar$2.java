package com.obric.memorydata.memory.tracker;

import com.obric.memorydata.middleware.api.log.RunLog;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lkotlin/Result;", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.tracker.PersonalContextCountTracker$reportMemoryCountAndChar$2", f = "PersonalContextCountTracker.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PersonalContextCountTracker$reportMemoryCountAndChar$2 extends SuspendLambda implements Function2<al, Continuation<? super Result<? extends Unit>>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    PersonalContextCountTracker$reportMemoryCountAndChar$2(Continuation<? super PersonalContextCountTracker$reportMemoryCountAndChar$2> r3) {
        super(2, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        PersonalContextCountTracker$reportMemoryCountAndChar$2 r4 = new PersonalContextCountTracker$reportMemoryCountAndChar$2((Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
        r4.L$0 = r2;
        return (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Result<? extends Unit>> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Result<Unit>> r4) {
        return ((PersonalContextCountTracker$reportMemoryCountAndChar$2) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), PersonalContextCountTracker$reportMemoryCountAndChar$2.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r4) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r4);
        al r3 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        h.k(h.f10547a);     // Catch: Throwable -> L7
        Object r6 = Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r7 = Result.m1424exceptionOrNullimpl(r6);
        if (r7 == null) goto L13;
        RunLog.INSTANCE.error("PersonalContextCountTracker", "reportMemoryCountAndChar failed", r7);
    L13:
        return Result.m1420boximpl(r6);
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
