package com.obric.aikernel.runtime;

import android.os.Bundle;
import com.obric.aikernel.core.data.IdlKeys;
import com.obric.aikernel.sdk.ExtsKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.al;
import kotlinx.coroutines.n;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$runAsFlow$2$job$1", f = "VmEngine.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$runAsFlow$2$job$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ n<Bundle> $cont;
    final /* synthetic */ Bundle $contextExtra;
    final /* synthetic */ String $event;
    final /* synthetic */ com.obric.aee.res.b $pkg;
    final /* synthetic */ Function2<Bundle, Boolean, Unit> $vmCallback;
    final /* synthetic */ Bundle $vmContext;
    int label;
    final /* synthetic */ e this$0;

    VmEngine$runAsFlow$2$job$1(com.obric.aee.res.b r3, Bundle r4, Function2<? super Bundle, ? super Boolean, Unit> r5, String r6, Bundle r7, n<? super Bundle> r8, e r9, Bundle r10, Continuation<? super VmEngine$runAsFlow$2$job$1> r11) {
        Function2<Bundle, Boolean, Unit> r12 = (Function2) ZeusTransformUtils.wrapperContextForParams(r5, Function2.class, "com.obric.memorydata.plugin");
        n<Bundle> r13 = (n) ZeusTransformUtils.wrapperContextForParams(r8, n.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r11, Continuation.class, "com.obric.memorydata.plugin");
        this.$pkg = r3;
        this.$args = r4;
        this.$vmCallback = r12;
        this.$event = r6;
        this.$vmContext = r7;
        this.$cont = r13;
        this.this$0 = r9;
        this.$contextExtra = r10;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r12, Continuation<?> r13) {
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new VmEngine$runAsFlow$2$job$1(this.$pkg, this.$args, this.$vmCallback, this.$event, this.$vmContext, this.$cont, this.this$0, this.$contextExtra, r10), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((VmEngine$runAsFlow$2$job$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), VmEngine$runAsFlow$2$job$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r11);     // Catch: Throwable -> L7
        VmEngine$runAsFlow$2$job$1 this = this;
    L18:
    L17:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r11);
        com.obric.aee.b r12 = com.obric.aee.b.f5869a;     // Catch: Throwable -> L7
        com.obric.aee.res.b r4 = this.$pkg;     // Catch: Throwable -> L7
        Bundle r5 = this.$args;     // Catch: Throwable -> L7
        Function2<Bundle, Boolean, Unit> r6 = this.$vmCallback;     // Catch: Throwable -> L7
        String r7 = this.$event;     // Catch: Throwable -> L7
        Bundle r8 = this.$vmContext;     // Catch: Throwable -> L7
        Continuation<? super Unit> r9 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        Object r10 = r12.a(r4, r5, r6, r7, r8, r9);     // Catch: Throwable -> L7
        this = r10;
        if (r10 != r0) goto L18;
        return r0;
    L7:
        th = move-exception;
        Continuation r13 = (Continuation) ZeusTransformUtils.preCheckCast(this.$cont, Continuation.class, "com.obric.memorydata.plugin");
        e r3 = this.this$0;
        Bundle r14 = this.$contextExtra;
        com.obric.aee.res.b r15 = this.$pkg;
        String r16 = this.$vmContext.getString(IdlKeys.Args_PackageName, "");
        Intrinsics.checkNotNullExpressionValue(r16, "vmContext.getString(IdlKeys.Args_PackageName, \"\")");
        ExtsKt.resume(r13, e.a(r3, th, r14, "runPackageStreaming", r15, r16));
        goto L17
    }
}
