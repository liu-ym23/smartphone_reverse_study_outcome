package kotlinx.coroutines.flow;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {33, 33}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements Function3<d<? super R>, Object[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    FlowKt__ZipKt$combine$1$1(Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r10, Continuation<? super FlowKt__ZipKt$combine$1$1> r11) {
        this.$transform = r10;
        super(3, r11);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Object[] r11, Continuation<? super Unit> r12) {
        return invoke((d) r10, r11, r12);
    }

    public final Object invoke(d<? super R> r10, Object[] r11, Continuation<? super Unit> r12) {
        FlowKt__ZipKt$combine$1$1 r13 = new FlowKt__ZipKt$combine$1$1(this.$transform, r12);
        r13.L$0 = r10;
        r13.L$1 = r11;
        return r13.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1<R> for r6v4 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r6.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        kotlin.ResultKt.throwOnFailure(r7);
    L16:
        kotlin.Unit r6 = kotlin.Unit.INSTANCE;
        return r6;
    L7:
        java.lang.IllegalStateException r6 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r6;
    L9:
        java.lang.Object r1 = r6.L$0;
        kotlinx.coroutines.flow.d r1 = (kotlinx.coroutines.flow.d) r1;
        kotlin.ResultKt.throwOnFailure(r7);
    L13:
        r6.L$0 = null;
        r6.label = 2;
        java.lang.Object r6 = r1.emit(r7, r6);
        if (r6 != r0) goto L16;
        return r0;
    L10:
        kotlin.ResultKt.throwOnFailure(r7);
        java.lang.Object r7 = r6.L$0;
        r1 = (kotlinx.coroutines.flow.d) r7;
        java.lang.Object r7 = r6.L$1;
        java.lang.Object[] r7 = (java.lang.Object[]) r7;
        kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r6.$transform;
        java.lang.Object r5 = r7[0];
        java.lang.Object r7 = r7[1];
        r6.L$0 = r1;
        r6.label = 1;
        T1 r5 = (T1) r5;
        T2 r7 = (T2) r7;
        java.lang.Object r6 = (kotlin.coroutines.Continuation<? super R>) r6;
        r7 = r4.invoke(r5, r7, r6);
        if (r7 != r0) goto L13;
        return r0;
    }
}
