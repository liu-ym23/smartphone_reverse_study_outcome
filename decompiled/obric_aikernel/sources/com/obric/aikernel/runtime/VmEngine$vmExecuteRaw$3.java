package com.obric.aikernel.runtime;

import android.os.Bundle;
import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.v1;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.runtime.VmEngine$vmExecuteRaw$3", f = "VmEngine.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VmEngine$vmExecuteRaw$3 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ v1 $inrWatchDog;
    final /* synthetic */ y6.b $pkg;
    final /* synthetic */ AIInferRuntime.PackageWrapper $pkgWrapper;
    final /* synthetic */ Bundle $ret;
    int label;
    final /* synthetic */ VmEngine this$0;

    VmEngine$vmExecuteRaw$3(v1 r10, Bundle r11, AIInferRuntime.PackageWrapper r12, VmEngine r13, y6.b r14, Continuation<? super VmEngine$vmExecuteRaw$3> r15) {
        this.$inrWatchDog = r10;
        this.$ret = r11;
        this.$pkgWrapper = r12;
        this.this$0 = r13;
        this.$pkg = r14;
        super(2, r15);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new VmEngine$vmExecuteRaw$3(this.$inrWatchDog, this.$ret, this.$pkgWrapper, this.this$0, this.$pkg, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((VmEngine$vmExecuteRaw$3) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L26;
        ResultKt.throwOnFailure(r10);
        v1 r11 = this.$inrWatchDog;
        if (r11 == null) goto L7;
        r11.c(new CancellationException("vm execute " + e8.a.n(this.$ret)));
    L7:
        AIInferRuntime.PackageWrapper r12 = this.$pkgWrapper;
        if (r12 == null) goto L20;
        Bundle r13 = this.$ret;
        VmEngine r14 = this.this$0;
        y6.b r15 = this.$pkg;
        int r16 = e8.a.f(r13);
        if (r16 != 0) goto L13;
        VmEngine.c(r14).d(r12);
        goto L20
    L13:
        if (r16 != 500) goto L16;
    L14:
        VmEngine.c(r14).c(r12);
        goto L20
    L16:
        if (r16 != 2300) goto L20;
        if (com.obric.aikernel.res.metadata.d.f5055a.b(r15.c()) == true) goto L14;
    L20:
        AIInferRuntime.PackageWrapper r17 = this.$pkgWrapper;
        if (r17 == null) goto L24;
        VmEngine.e(this.this$0, r17);
    L24:
        return Unit.INSTANCE;
    L26:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
