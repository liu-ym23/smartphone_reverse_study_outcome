package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1", f = "Merge.kt", i = {}, l = {217, 217}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__MergeKt$mapLatest$1<R, T> extends SuspendLambda implements Function3<d<? super R>, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__MergeKt$mapLatest$1(Function2<? super T, ? super Continuation<? super R>, ? extends Object> r10, Continuation<? super FlowKt__MergeKt$mapLatest$1> r11) {
        this.$transform = r10;
        super(3, r11);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Object r11, Continuation<? super Unit> r12) {
        return invoke((d) r10, r11, r12);
    }

    public final Object invoke(d<? super R> r10, T r11, Continuation<? super Unit> r12) {
        FlowKt__MergeKt$mapLatest$1 r13 = new FlowKt__MergeKt$mapLatest$1(this.$transform, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__MergeKt$mapLatest$1<R, T> for r5v4 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r5.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        kotlin.ResultKt.throwOnFailure(r6);
    L16:
        kotlin.Unit r5 = kotlin.Unit.INSTANCE;
        return r5;
    L7:
        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r5;
    L9:
        java.lang.Object r1 = r5.L$0;
        kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1;
        kotlin.ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.flow.d r1 = r1;
    L13:
        r5.L$0 = null;
        r5.label = 2;
        java.lang.Object r5 = r1.emit(r6, r5);
        if (r5 != r0) goto L16;
        return r0;
    L10:
        kotlin.ResultKt.throwOnFailure(r6);
        java.lang.Object r6 = r5.L$0;
        kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r6;
        java.lang.Object r6 = r5.L$1;
        kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r5.$transform;
        r5.L$0 = r1;
        r5.label = 1;
        T r6 = (T) r6;
        java.lang.Object r5 = (kotlin.coroutines.Continuation<? super R>) r5;
        r6 = r4.invoke(r6, r5);
        r1 = r1;
        if (r6 != r0) goto L13;
        return r0;
    }
}
