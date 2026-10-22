package com.obric.aikernel.service.res;

import com.bytedance.crash.Ensure;
import java.util.Map;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$inferRuntime$1$3$8$onVmException$2", f = "PythonRuntimeService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class PythonRuntimeService$inferRuntime$1$3$8$onVmException$2 extends SuspendLambda implements Function2<l0, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $code;
    final /* synthetic */ Map<String, String> $extraInfo;
    final /* synthetic */ String $javaStack;
    final /* synthetic */ String $msg;
    final /* synthetic */ y6.b $pkg;
    final /* synthetic */ String $trace;
    final /* synthetic */ String $type;
    int label;
    final /* synthetic */ PythonRuntimeService this$0;

    PythonRuntimeService$inferRuntime$1$3$8$onVmException$2(String r10, int r11, String r12, PythonRuntimeService r13, String r14, String r15, y6.b r16, Map<String, String> r17, Continuation<? super PythonRuntimeService$inferRuntime$1$3$8$onVmException$2> r18) {
        this.$type = r10;
        this.$code = r11;
        this.$msg = r12;
        this.this$0 = r13;
        this.$trace = r14;
        this.$javaStack = r15;
        this.$pkg = r16;
        this.$extraInfo = r17;
        super(2, r18);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new PythonRuntimeService$inferRuntime$1$3$8$onVmException$2(this.$type, this.$code, this.$msg, this.this$0, this.$trace, this.$javaStack, this.$pkg, this.$extraInfo, r12);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super Unit> r11) {
        return ((PythonRuntimeService$inferRuntime$1$3$8$onVmException$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        Ensure.ensureNativeStack("Signal 1024(" + this.$type + "), code: " + this.$code + ", " + this.$msg + '\n' + PythonRuntimeService.d(this.this$0, this.$trace), this.$javaStack, "Aee-" + this.$pkg.c() + '@' + this.$pkg.h(), this.$type + '(' + this.$code + "): " + this.$msg, this.$extraInfo);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
