package com.obric.aikernel.service.res;

import com.obric.aikernel.runtime.AIInferRuntime;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;
import kotlinx.coroutines.r0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$dump$2", f = "PythonRuntimeService.kt", i = {}, l = {442}, m = "invokeSuspend", n = {}, s = {})
final class PythonRuntimeService$dump$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<String> $args;
    final /* synthetic */ FileDescriptor $fd;
    final /* synthetic */ PrintWriter $fout;
    int label;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$dump$2(PythonRuntimeService r10, FileDescriptor r11, PrintWriter r12, List<String> r13, Continuation<? super PythonRuntimeService$dump$2> r14) {
        this.this$0 = r10;
        this.$fd = r11;
        this.$fout = r12;
        this.$args = r13;
        super(2, r14);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        return new PythonRuntimeService$dump$2(this.this$0, this.$fd, this.$fout, this.$args, r11);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PythonRuntimeService$dump$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L8;
        if (r12 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        ((AIInferRuntime) r10).M(this.$fd, this.$fout, this.$args);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        r0 r13 = PythonRuntimeService.j(this.this$0);
        this.label = 1;
        r10 = r13.r(this);
        if (r10 != r11) goto L11;
        return r11;
    }
}
