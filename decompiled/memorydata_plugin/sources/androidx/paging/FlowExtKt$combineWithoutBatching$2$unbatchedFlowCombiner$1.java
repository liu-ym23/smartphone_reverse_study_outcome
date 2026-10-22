package androidx.paging;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function4;

/* JADX INFO: Add missing generic type declarations: [T1, T2] */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u00022\u0006\u0010\u0006\u001a\u0002H\u00032\u0006\u0010\u0007\u001a\u00020\bH\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "t1", "t2", "updateFrom", "Landroidx/paging/CombineSource;"}, k = 3, mv = {1, 8, 0}, xi = 176)
@DebugMetadata(c = "androidx.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1", f = "FlowExt.kt", i = {}, l = {142, 142}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1<T1, T2> extends SuspendLambda implements Function4<T1, T2, CombineSource, Continuation<? super Unit>, Object> {
    final /* synthetic */ SimpleProducerScope<R> $$this$simpleChannelFlow;
    final /* synthetic */ Function4<T1, T2, CombineSource, Continuation<? super R>, Object> $transform;
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    int label;

    public FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(SimpleProducerScope<R> r3, Function4<? super T1, ? super T2, ? super CombineSource, ? super Continuation<? super R>, ? extends Object> r4, Continuation<? super FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1> r5) {
        SimpleProducerScope<R> r6 = (SimpleProducerScope) ZeusTransformUtils.wrapperContextForParams(r3, SimpleProducerScope.class, "com.obric.memorydata.plugin");
        Function4<T1, T2, CombineSource, Continuation<? super R>, Object> r7 = (Function4) ZeusTransformUtils.wrapperContextForParams(r4, Function4.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$$this$simpleChannelFlow = r6;
        this.$transform = r7;
        super(4, r8);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(T1 r3, T2 r4, CombineSource r5, Continuation<? super Unit> r6) {
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1 r0 = new FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1(this.$$this$simpleChannelFlow, this.$transform, r7);
        r0.L$0 = r3;
        r0.L$1 = r4;
        r0.L$2 = r5;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function4
    public /* synthetic */ Object invoke(Object r3, Object r4, CombineSource r5, Continuation<? super Unit> r6) {
        return invoke2(r3, r4, (CombineSource) ZeusTransformUtils.preCheckCast(r5, CombineSource.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r6, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1<T1, T2> for r9v4 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final java.lang.Object invokeSuspend(java.lang.Object r10) {
        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = r9.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L7;
        kotlin.ResultKt.throwOnFailure(r10);
    L17:
        kotlin.Unit r9 = kotlin.Unit.INSTANCE;
        return r9;
    L7:
        java.lang.IllegalStateException r9 = new java.lang.IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        throw r9;
    L9:
        java.lang.Object r1 = r9.L$0;
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, androidx.paging.SimpleProducerScope.class, "com.obric.memorydata.plugin");
        androidx.paging.SimpleProducerScope r1 = (androidx.paging.SimpleProducerScope) r1;
        kotlin.ResultKt.throwOnFailure(r10);
    L14:
        java.lang.Object r4 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r9, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation<? super kotlin.Unit> r4 = (kotlin.coroutines.Continuation) r4;
        r9.L$0 = null;
        r9.label = 2;
        java.lang.Object r9 = r1.send(r10, r4);
        if (r9 != r0) goto L17;
        return r0;
    L10:
        kotlin.ResultKt.throwOnFailure(r10);
        java.lang.Object r10 = r9.L$0;
        java.lang.Object r1 = r9.L$1;
        java.lang.Object r6 = r9.L$2;
        java.lang.Object r6 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, androidx.paging.CombineSource.class, "com.obric.memorydata.plugin");
        androidx.paging.CombineSource r6 = (androidx.paging.CombineSource) r6;
        androidx.paging.SimpleProducerScope r7 = r9.$$this$simpleChannelFlow;
        kotlin.jvm.functions.Function4<T1, T2, androidx.paging.CombineSource, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r8 = r9.$transform;
        r9.L$0 = r7;
        r9.L$1 = null;
        r9.label = 1;
        T1 r10 = (T1) r10;
        T2 r1 = (T2) r1;
        java.lang.Object r9 = (kotlin.coroutines.Continuation<? super R>) r9;
        r10 = r8.invoke(r10, r1, r6, r9);
        if (r10 != r0) goto L13;
        return r0;
    L13:
        r1 = r7;
        goto L14
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to androidx.paging.FlowExtKt$combineWithoutBatching$2$unbatchedFlowCombiner$1<T1, T2> for r5v6 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r6) {
        java.lang.Object r6 = r5.L$0;
        java.lang.Object r0 = r5.L$1;
        java.lang.Object r1 = r5.L$2;
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, androidx.paging.CombineSource.class, "com.obric.memorydata.plugin");
        androidx.paging.CombineSource r1 = (androidx.paging.CombineSource) r1;
        androidx.paging.SimpleProducerScope<R> r2 = r5.$$this$simpleChannelFlow;
        kotlin.jvm.functions.Function4<T1, T2, androidx.paging.CombineSource, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r4 = r5.$transform;
        T1 r6 = (T1) r6;
        T2 r0 = (T2) r0;
        java.lang.Object r5 = (kotlin.coroutines.Continuation<? super R>) r5;
        java.lang.Object r6 = r4.invoke(r6, r0, r1, r5);
        java.lang.Object r5 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r5, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation<? super kotlin.Unit> r5 = (kotlin.coroutines.Continuation) r5;
        kotlin.jvm.internal.InlineMarker.mark(0);
        kotlin.coroutines.Continuation<? super kotlin.Unit> r5 = (kotlin.coroutines.Continuation<? super kotlin.Unit>) r5;
        r2.send(r6, r5);
        kotlin.jvm.internal.InlineMarker.mark(1);
        kotlin.Unit r5 = kotlin.Unit.INSTANCE;
        return r5;
    }
}
