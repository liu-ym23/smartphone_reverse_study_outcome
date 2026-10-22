package com.obric.aikernel.runtime;

import com.google.gson.JsonObject;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.io.PrintWriter;
import kotlin.Metadata;
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
@DebugMetadata(c = "com.obric.aikernel.runtime.AIInferRuntime$dump$1$3", f = "AIInferRuntime.kt", i = {}, l = {333}, m = "invokeSuspend", n = {}, s = {})
final class AIInferRuntime$dump$1$3 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $command;
    final /* synthetic */ PrintWriter $fout;
    Object L$0;
    int label;
    final /* synthetic */ AIInferRuntime this$0;

    AIInferRuntime$dump$1$3(PrintWriter r3, AIInferRuntime r4, b r5, Continuation<? super AIInferRuntime$dump$1$3> r6) {
        b r7 = (b) ZeusTransformUtils.wrapperContextForParams(r5, b.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$fout = r3;
        this.this$0 = r4;
        this.$command = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new AIInferRuntime$dump$1$3(this.$fout, this.this$0, this.$command, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((AIInferRuntime$dump$1$3) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), AIInferRuntime$dump$1$3.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        PrintWriter r8 = (PrintWriter) ZeusTransformUtils.preCheckCast(this.L$0, PrintWriter.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r9);
    L12:
        r8.println(((JsonObject) ZeusTransformUtils.preCheckCast(r9, JsonObject.class, "com.obric.memorydata.plugin")).toString());
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        PrintWriter r10 = this.$fout;
        AIInferRuntime r2 = this.this$0;
        String r4 = ((b.a) ZeusTransformUtils.preCheckCast(this.$command, b.a.class, "com.obric.memorydata.plugin")).a();
        String r5 = ((b.a) ZeusTransformUtils.preCheckCast(this.$command, b.a.class, "com.obric.memorydata.plugin")).b();
        Continuation r6 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.L$0 = r10;
        this.label = 1;
        Object r11 = AIInferRuntime.a(r2, r4, r5, r6);
        if (r11 != r0) goto L11;
        return r0;
    L11:
        r9 = r11;
        r8 = r10;
        goto L12
    }
}
