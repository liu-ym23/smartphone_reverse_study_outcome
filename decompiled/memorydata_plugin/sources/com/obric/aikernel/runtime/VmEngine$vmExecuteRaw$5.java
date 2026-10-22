package com.obric.aikernel.runtime;

import android.os.Bundle;
import com.obric.aikernel.sdk.ext.BundleExtKt;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;
import kotlinx.coroutines.bx;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$5", f = "VmEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$vmExecuteRaw$5 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ bx $inrWatchDog;
    final /* synthetic */ com.obric.aee.res.b $pkg;
    final /* synthetic */ AIInferRuntime.g $pkgWrapper;
    final /* synthetic */ Bundle $ret;
    int label;
    final /* synthetic */ e this$0;

    VmEngine$vmExecuteRaw$5(bx r3, Bundle r4, AIInferRuntime.g r5, e r6, com.obric.aee.res.b r7, Continuation<? super VmEngine$vmExecuteRaw$5> r8) {
        bx r9 = (bx) ZeusTransformUtils.wrapperContextForParams(r3, bx.class, "com.obric.memorydata.plugin");
        Continuation r10 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r8, Continuation.class, "com.obric.memorydata.plugin");
        this.$inrWatchDog = r9;
        this.$ret = r4;
        this.$pkgWrapper = r5;
        this.this$0 = r6;
        this.$pkg = r7;
        super(2, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r10, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new VmEngine$vmExecuteRaw$5(this.$inrWatchDog, this.$ret, this.$pkgWrapper, this.this$0, this.$pkg, r7), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((VmEngine$vmExecuteRaw$5) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), VmEngine$vmExecuteRaw$5.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r5);
        bx r6 = this.$inrWatchDog;
        if (r6 == null) goto L7;
        r6.a(new CancellationException("vm execute " + BundleExtKt.isSuccess(this.$ret)));
    L7:
        AIInferRuntime.g r7 = this.$pkgWrapper;
        if (r7 == null) goto L20;
        Bundle r0 = this.$ret;
        e r1 = this.this$0;
        com.obric.aee.res.b r2 = this.$pkg;
        int r3 = BundleExtKt.getErrorCode(r0);
        if (r3 != 0) goto L13;
        e.c(r1).b(r7);
        goto L20
    L13:
        if (r3 != 500) goto L16;
    L14:
        e.c(r1).a(r7);
        goto L20
    L16:
        if (r3 != 2300) goto L20;
        if (com.obric.aikernel.res.metadata.c.f6058a.a(r2.a()) == true) goto L14;
    L20:
        AIInferRuntime.g r8 = this.$pkgWrapper;
        if (r8 == null) goto L24;
        e.a(this.this$0, r8);
    L24:
        return Unit.INSTANCE;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
