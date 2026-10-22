package kotlinx.coroutines.flow;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1", f = "Zip.kt", i = {}, l = {29, 29}, m = "invokeSuspend", n = {}, s = {})
final class FlowKt__ZipKt$combine$1$1<R> extends SuspendLambda implements Function3<j<? super R>, Object[], Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<T1, T2, Continuation<? super R>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    FlowKt__ZipKt$combine$1$1(Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> r3, Continuation<? super FlowKt__ZipKt$combine$1$1> r4) {
        Function3<T1, T2, Continuation<? super R>, Object> r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$transform = r5;
        super(3, r6);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Object r3, Object[] r4, Continuation<? super Unit> r5) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Object[]) ZeusTransformUtils.preCheckCast(r4, Object[].class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<? super R> r3, Object[] r4, Continuation<? super Unit> r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__ZipKt$combine$1$1 r0 = new FlowKt__ZipKt$combine$1$1(this.$transform, r7);
        r0.L$0 = r6;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__ZipKt$combine$1$1<R> for r7v4 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r7.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        kotlin.ResultKt.throwOnFailure(r8);
    L16:
        kotlin.Unit r7 = kotlin.Unit.INSTANCE;
        return r7;
    L7:
        java.lang.IllegalStateException r7 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r7;
    L9:
        java.lang.Object r1 = r7.L$0;
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1;
        kotlin.ResultKt.throwOnFailure(r8);
    L13:
        java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation<? super kotlin.Unit> r3 = (kotlin.coroutines.Continuation) r3;
        r7.L$0 = null;
        r7.label = 2;
        java.lang.Object r7 = r1.emit(r8, r3);
        if (r7 != r0) goto L16;
        return r0;
    L10:
        kotlin.ResultKt.throwOnFailure(r8);
        java.lang.Object r8 = r7.L$0;
        java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r1 = (kotlinx.coroutines.flow.j) r8;
        java.lang.Object r8 = r7.L$1;
        java.lang.Object r8 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r8, java.lang.Object[].class, "com.obric.memorydata.plugin");
        java.lang.Object[] r8 = (java.lang.Object[]) r8;
        kotlin.jvm.functions.Function3<T1, T2, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r7.$transform;
        java.lang.Object r6 = r8[0];
        java.lang.Object r8 = r8[1];
        r7.L$0 = r1;
        r7.label = 1;
        T1 r6 = (T1) r6;
        T2 r8 = (T2) r8;
        java.lang.Object r7 = (kotlin.coroutines.Continuation<? super R>) r7;
        r8 = r5.invoke(r6, r8, r7);
        if (r8 != r0) goto L13;
        return r0;
    }
}
