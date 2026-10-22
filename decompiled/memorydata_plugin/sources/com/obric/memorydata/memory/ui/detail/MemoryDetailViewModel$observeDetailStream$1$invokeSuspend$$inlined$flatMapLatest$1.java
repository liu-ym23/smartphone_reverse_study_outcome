package com.obric.memorydata.memory.ui.detail;

import androidx.exifinterface.media.ExifInterface;
import com.obric.capabilitykit.entity.memory.MemoryEntity;
import com.obric.memorydata.memory.llm.SessionStatus;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.flow.ar;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@¨\u0006\u0006"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "kotlinx/coroutines/flow/FlowKt__MergeKt$flatMapLatest$1"}, k = 3, mv = {2, 0, 0}, xi = 48)
@DebugMetadata(c = "com.obric.memorydata.memory.ui.detail.MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$$inlined$flatMapLatest$1", f = "MemoryDetailViewModel.kt", i = {}, l = {189}, m = "invokeSuspend", n = {}, s = {})
public final class MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$$inlined$flatMapLatest$1 extends SuspendLambda implements Function3<kotlinx.coroutines.flow.j<? super MemoryDetailViewModel.b>, com.obric.memorydata.memory.ui.data.a.e, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$$inlined$flatMapLatest$1(Continuation r3) {
        super(3, (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin"));
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(kotlinx.coroutines.flow.j<? super MemoryDetailViewModel.b> r3, com.obric.memorydata.memory.ui.data.a.e r4, Continuation<? super Unit> r5) {
        return invoke((kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(kotlinx.coroutines.flow.j<? super MemoryDetailViewModel.b> r2, com.obric.memorydata.memory.ui.data.a.e r3, Continuation<? super Unit> r4) {
        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.wrapperContextForParams(r2, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$$inlined$flatMapLatest$1 r5 = new MemoryDetailViewModel$observeDetailStream$1$invokeSuspend$$inlined$flatMapLatest$1((Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin"));
        r5.L$0 = r1;
        r5.L$1 = r3;
        return r5.invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L24:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        kotlinx.coroutines.flow.j r14 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Object r2 = this.L$1;
        Continuation r4 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        MemoryEntity r7 = ((com.obric.memorydata.memory.ui.data.a.e) ZeusTransformUtils.preCheckCast(r2, com.obric.memorydata.memory.ui.data.a.e.class, "com.obric.memorydata.plugin")).b();
        com.obric.memorydata.memory.llm.j r8 = com.obric.memorydata.memory.llm.k.f10296a.a(r7);
        ar<SessionStatus> r3 = null;
        if (r8 == null) goto L11;
        ar<String> r5 = r8.c();
    L12:
        if (r8 == null) goto L14;
        r3 = r8.d();
    L14:
        ar<SessionStatus> r6 = r3;
        if (r5 == null) goto L19;
        if (r6 == null) goto L19;
        kotlinx.coroutines.flow.i r9 = kotlinx.coroutines.flow.k.b((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel.C11471.a((kotlinx.coroutines.flow.i) ZeusTransformUtils.preCheckCast(r6, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), r5, r7, r8), kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin"), (Function2) ZeusTransformUtils.preCheckCast(new MemoryDetailViewModel.C11471.C05501.AnonymousClass2(r5, r6, r7, r8, null), Function2.class, "com.obric.memorydata.plugin"));
    L20:
        Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (kotlinx.coroutines.flow.k.a(r14, r9, r10) != r0) goto L24;
        return r0;
    L19:
        r9 = kotlinx.coroutines.flow.k.a(new MemoryDetailViewModel.b(null, null, null, null, null, 31, null));
        goto L20
    L11:
        r5 = null;
        goto L12
    }
}
