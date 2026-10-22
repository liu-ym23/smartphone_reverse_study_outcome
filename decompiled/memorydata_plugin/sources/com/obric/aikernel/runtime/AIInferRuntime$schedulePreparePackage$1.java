package com.obric.aikernel.runtime;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.List;
import kotlin.ExceptionsKt;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$schedulePreparePackage$1", f = "AIInferRuntime.kt", i = {0}, l = {1286}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
final class AIInferRuntime$schedulePreparePackage$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $biz;
    final /* synthetic */ AIInferRuntime.h $state;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$schedulePreparePackage$1(AIInferRuntime.h r3, String r4, AIInferRuntime r5, Continuation<? super AIInferRuntime$schedulePreparePackage$1> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$state = r3;
        this.$biz = r4;
        this.this$0 = r5;
        super(2, r7);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        AIInferRuntime$schedulePreparePackage$1 r0 = new AIInferRuntime$schedulePreparePackage$1(this.$state, this.$biz, this.this$0, r7);
        r0.L$0 = r5;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AIInferRuntime$schedulePreparePackage$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$schedulePreparePackage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:15:0x004a -> B:17:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        al r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L8
    L17:
        Object r13 = Result.m1421constructorimpl((List) ZeusTransformUtils.preCheckCast(r12, List.class, "com.obric.memorydata.plugin"));     // Catch: Throwable -> L8
    L20:
        String r3 = this.$biz;
        Throwable r14 = Result.m1424exceptionOrNullimpl(r13);
        if (r14 == null) goto L23;
        com.obric.aikernel.runtime.utils.d.f6216a.g("AIInferRuntime", "schedulePreparePackage failed " + r3 + ' ' + ExceptionsKt.stackTraceToString(r14));
    L23:
        AIInferRuntime.h r15 = this.$state;
        AIInferRuntime r4 = this.this$0;
        String r5 = this.$biz;
        monitor-enter(r15);
        boolean r6 = false;
        if (r15.b() == false) goto L28;
        r15.b(false);     // Catch: Throwable -> L34
        r6 = true;
    L29:
        monitor-exit(r15);
        if (r6 == false) goto L32;
        com.obric.aikernel.runtime.utils.d.f6216a.e("AIInferRuntime", "schedulePreparePackage rerun " + this.$biz + " due to pending update");
    L13:
        AIInferRuntime r7 = this.this$0;
        String r8 = this.$biz;
        Result.Companion r16 = Result.Companion;     // Catch: Throwable -> L8
        this.L$0 = r2;     // Catch: Throwable -> L8
        this.label = 1;     // Catch: Throwable -> L8
        r12 = AIInferRuntime.a(r7, r8, null, false, null, this, 14, null);     // Catch: Throwable -> L8
        if (r12 != r0) goto L17;
        return r0;
    L32:
        return Unit.INSTANCE;
    L28:
        r15.a(false);     // Catch: Throwable -> L34
        AIInferRuntime.c(r4).remove(r5, r15);     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        throw th;
    L8:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r13 = Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r12);
        r2 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        goto L13
    }
}
