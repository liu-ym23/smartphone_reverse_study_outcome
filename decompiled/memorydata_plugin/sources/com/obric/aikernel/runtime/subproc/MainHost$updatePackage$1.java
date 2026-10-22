package com.obric.aikernel.runtime.subproc;

import com.obric.aikernel.runtime.AIInferRuntime;
import com.obric.aikernel.sdk.ext.BundleExtKt;
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

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.subproc.MainHost$updatePackage$1", f = "MainHost.kt", i = {}, l = {63}, m = "invokeSuspend", n = {}, s = {})
final class MainHost$updatePackage$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ com.obric.aikernel.b $callback;
    final /* synthetic */ String $caller;
    final /* synthetic */ String $lora;
    final /* synthetic */ String $name;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ a this$0;

    MainHost$updatePackage$1(com.obric.aikernel.b r3, a r4, String r5, String r6, String r7, Continuation<? super MainHost$updatePackage$1> r8) {
        com.obric.aikernel.b r9 = (com.obric.aikernel.b) ZeusTransformUtils.wrapperContextForParams(r3, com.obric.aikernel.b.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$callback = r9;
        this.this$0 = r4;
        this.$name = r5;
        this.$caller = r6;
        this.$lora = r7;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        MainHost$updatePackage$1 r12 = new MainHost$updatePackage$1(this.$callback, this.this$0, this.$name, this.$caller, this.$lora, r8);
        r12.L$0 = r10;
        return (Continuation) ZeusTransformUtils.preCheckCast(r12, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((MainHost$updatePackage$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), MainHost$updatePackage$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L15
    L13:
        Result.m1421constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        BundleExtKt.safeOnResult$default(this.$callback, null, 1, null);
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        al r8 = (al) ZeusTransformUtils.preCheckCast(this.L$0, al.class, "com.obric.memorydata.plugin");
        a r9 = this.this$0;
        String r2 = this.$name;
        String r3 = this.$caller;
        String r4 = this.$lora;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L15
        AIInferRuntime r10 = r9.a();     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r10.a(r2, r3, r4, this) != r0) goto L13;
        return r0;
    L15:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        Result.m1421constructorimpl(ResultKt.createFailure(th));
        goto L17
    }
}
