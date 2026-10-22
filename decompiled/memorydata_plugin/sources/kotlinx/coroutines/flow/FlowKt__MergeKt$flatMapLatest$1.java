package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: Add missing generic type declarations: [R, T] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u00042\u0006\u0010\u0005\u001a\u0002H\u0002H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;", "it"}, k = 3, mv = {1, 9, 0}, xi = 176)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1", f = "Merge.kt", i = {}, l = {189, 189}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__MergeKt$flatMapLatest$1<R, T> extends SuspendLambda implements Function3<j<? super R>, T, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<T, Continuation<? super i<? extends R>>, Object> $transform;
    private /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    int label;

    public FlowKt__MergeKt$flatMapLatest$1(Function2<? super T, ? super Continuation<? super i<? extends R>>, ? extends Object> r3, Continuation<? super FlowKt__MergeKt$flatMapLatest$1> r4) {
        Function2<T, Continuation<? super i<? extends R>>, Object> r5 = (Function2) ZeusTransformUtils.wrapperContextForParams(r3, Function2.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$transform = r5;
        super(3, r6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function3
    public /* synthetic */ Object invoke(Object r3, Object r4, Continuation<? super Unit> r5) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), r4, (Continuation) ZeusTransformUtils.preCheckCast(r5, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<? super R> r3, T r4, Continuation<? super Unit> r5) {
        j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin");
        Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__MergeKt$flatMapLatest$1 r0 = new FlowKt__MergeKt$flatMapLatest$1(this.$transform, r7);
        r0.L$0 = r6;
        r0.L$1 = r4;
        return r0.invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1<R, T> for r6v4 'this'  java.lang.Object
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
        java.lang.Object r1 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r1, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j r1 = (kotlinx.coroutines.flow.j) r1;
        kotlin.ResultKt.throwOnFailure(r7);
    L13:
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.i r7 = (kotlinx.coroutines.flow.i) r7;
        java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r6, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3;
        r6.L$0 = null;
        r6.label = 2;
        java.lang.Object r6 = kotlinx.coroutines.flow.k.a(r1, r7, r3);
        if (r6 != r0) goto L16;
        return r0;
    L10:
        kotlin.ResultKt.throwOnFailure(r7);
        java.lang.Object r7 = r6.L$0;
        java.lang.Object r7 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r7, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        r1 = (kotlinx.coroutines.flow.j) r7;
        java.lang.Object r7 = r6.L$1;
        kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>, java.lang.Object> r5 = r6.$transform;
        r6.L$0 = r1;
        r6.label = 1;
        T r7 = (T) r7;
        java.lang.Object r6 = (kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>) r6;
        r7 = r5.invoke(r7, r6);
        if (r7 != r0) goto L13;
        return r0;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't change immutable type java.lang.Object to kotlinx.coroutines.flow.FlowKt__MergeKt$flatMapLatest$1<R, T> for r3v5 'this'  java.lang.Object
        	at jadx.core.dex.instructions.args.SSAVar.setType(SSAVar.java:114)
        	at jadx.core.dex.instructions.args.RegisterArg.setType(RegisterArg.java:52)
        	at jadx.core.dex.visitors.ModVisitor.removeCheckCast(ModVisitor.java:417)
        	at jadx.core.dex.visitors.ModVisitor.replaceStep(ModVisitor.java:152)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:96)
        */
    public final java.lang.Object invokeSuspend$$forInline(java.lang.Object r4) {
        java.lang.Object r4 = r3.L$0;
        java.lang.Object r4 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r4, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.j r4 = (kotlinx.coroutines.flow.j) r4;
        java.lang.Object r0 = r3.L$1;
        kotlin.jvm.functions.Function2<T, kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>, java.lang.Object> r2 = r3.$transform;
        T r0 = (T) r0;
        java.lang.Object r3 = (kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.i<? extends R>>) r3;
        java.lang.Object r0 = r2.invoke(r0, r3);
        java.lang.Object r0 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r0, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.i r0 = (kotlinx.coroutines.flow.i) r0;
        java.lang.Object r3 = com.volcengine.zeus.transform.ZeusTransformUtils.preCheckCast(r3, kotlin.coroutines.Continuation.class, "com.obric.memorydata.plugin");
        kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3;
        kotlin.jvm.internal.InlineMarker.mark(0);
        kotlinx.coroutines.flow.k.a(r4, r0, r3);
        kotlin.jvm.internal.InlineMarker.mark(1);
        kotlin.Unit r3 = kotlin.Unit.INSTANCE;
        return r3;
    }
}
