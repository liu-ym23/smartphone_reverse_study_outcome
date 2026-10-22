package com.obric.aikernel.service.res;

import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: classes2.dex */
@DebugMetadata(c = "com.obric.aikernel.service.res.PythonRuntimeService$5$1", f = "PythonRuntimeService.kt", i = {0, 0, 0}, l = {549}, m = "emit", n = {"this", "it", "shouldRecheckAutoUpdate"}, s = {"L$0", "L$1", "Z$0"})
final class PythonRuntimeService$5$1$emit$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    boolean Z$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ PythonRuntimeService.AnonymousClass5.AnonymousClass1<T> this$0;

    /* JADX WARN: Multi-variable type inference failed */
    PythonRuntimeService$5$1$emit$1(PythonRuntimeService.AnonymousClass5.AnonymousClass1<? super T> r10, Continuation<? super PythonRuntimeService$5$1$emit$1> r11) {
        this.this$0 = r10;
        super(r11);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type kotlin.coroutines.Continuation to com.obric.aikernel.service.res.PythonRuntimeService$5$1$emit$1 for r1v2 'this'  kotlin.coroutines.Continuation
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r2) {
        r1.result = r2;
        int r2 = r1.label;
        int r2 = r2 | Integer.MIN_VALUE;
        r1.label = r2;
        com.obric.aikernel.service.res.PythonRuntimeService.AnonymousClass5.AnonymousClass1<T> r2 = r1.this$0;
        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r1;
        java.lang.Object r1 = r2.a(null, r1);
        return r1;
    }
}
