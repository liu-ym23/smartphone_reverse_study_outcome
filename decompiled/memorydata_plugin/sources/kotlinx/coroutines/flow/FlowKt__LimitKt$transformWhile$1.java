package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.bytedance.crash.entity.EventBody;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.InlineMarker;
import kotlinx.coroutines.flow.internal.AbortFlowException;

/* JADX INFO: Add missing generic type declarations: [R] */
/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__LimitKt$transformWhile$1", f = "Limit.kt", i = {0}, l = {149}, m = "invokeSuspend", n = {"collector$iv"}, s = {"L$0"})
final class FlowKt__LimitKt$transformWhile$1<R> extends SuspendLambda implements Function2<j<? super R>, Continuation<? super Unit>, Object> {
    final /* synthetic */ i<T> $this_transformWhile;
    final /* synthetic */ Function3<j<? super R>, T, Continuation<? super Boolean>, Object> $transform;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\u0005¨\u0006\u0006¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__LimitKt$collectWhile$collector$1", "Lkotlinx/coroutines/flow/FlowCollector;", "emit", "", EventBody.KEY_VALUE, "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class a<T> implements j<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Function3 f17349a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ j f17350b;

        public a(Function3 r3, j r4) {
            Function3 r5 = (Function3) ZeusTransformUtils.wrapperContextForParams(r3, Function3.class, "com.obric.memorydata.plugin");
            j r6 = (j) ZeusTransformUtils.wrapperContextForParams(r4, j.class, "com.obric.memorydata.plugin");
            this.f17349a = r5;
            this.f17350b = r6;
        }

        @Override // kotlinx.coroutines.flow.j
        public Object emit(T r6, Continuation<? super Unit> r7) {
            Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r7, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r8, FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1.class) == false) goto L7;
            FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1 r0 = (FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1) ZeusTransformUtils.preCheckCast(r8, FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r9 = r0.result;
            Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r3 = r0.label;
            if (r3 == 0) goto L14;
            if (r3 != 1) goto L13;
            a<T> this = (a) ZeusTransformUtils.preCheckCast(r0.L$0, a.class, "com.obric.memorydata.plugin");
            ResultKt.throwOnFailure(r9);
        L18:
            if (((Boolean) ZeusTransformUtils.preCheckCast(r9, Boolean.class, "com.obric.memorydata.plugin")).booleanValue() == false) goto L22;
            return Unit.INSTANCE;
        L22:
            throw new AbortFlowException(this);
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r9);
            Continuation r10 = (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
            Function3 r11 = this.f17349a;
            j r4 = this.f17350b;
            r0.L$0 = this;
            r0.label = 1;
            InlineMarker.mark(6);
            r9 = r11.invoke(r4, r6, r0);
            InlineMarker.mark(7);
            if (r9 != r2) goto L18;
            return r2;
        L7:
            r0 = new FlowKt__LimitKt$transformWhile$1$invokeSuspend$$inlined$collectWhile$1$1(this, r8);
            goto L8
        }
    }

    FlowKt__LimitKt$transformWhile$1(i<? extends T> r3, Function3<? super j<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> r4, Continuation<? super FlowKt__LimitKt$transformWhile$1> r5) {
        i<T> r6 = (i) ZeusTransformUtils.wrapperContextForParams(r3, i.class, "com.obric.memorydata.plugin");
        Function3<j<? super R>, T, Continuation<? super Boolean>, Object> r7 = (Function3) ZeusTransformUtils.wrapperContextForParams(r4, Function3.class, "com.obric.memorydata.plugin");
        Continuation r8 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        this.$this_transformWhile = r6;
        this.$transform = r7;
        super(2, r8);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        FlowKt__LimitKt$transformWhile$1 r0 = new FlowKt__LimitKt$transformWhile$1(this.$this_transformWhile, this.$transform, r6);
        r0.L$0 = r4;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(Object r3, Continuation<? super Unit> r4) {
        return invoke((j) ZeusTransformUtils.preCheckCast(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public final Object invoke(j<? super R> r3, Continuation<? super Unit> r4) {
        return ((FlowKt__LimitKt$transformWhile$1) ZeusTransformUtils.preCheckCast(create((j) ZeusTransformUtils.wrapperContextForParams(r3, j.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), FlowKt__LimitKt$transformWhile$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r7) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 != 1) goto L11;
        a r6 = (a) ZeusTransformUtils.preCheckCast(this.L$0, a.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r7);     // Catch: AbortFlowException -> L8
    L20:
        return Unit.INSTANCE;
    L8:
        e = e;
    L18:
        kotlinx.coroutines.flow.internal.o.a(e, r6);
        goto L20
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r7);
        j r8 = (j) ZeusTransformUtils.preCheckCast(this.L$0, j.class, "com.obric.memorydata.plugin");
        i<T> r2 = this.$this_transformWhile;
        a r5 = new a(this.$transform, r8);
        j r9 = (j) ZeusTransformUtils.preCheckCast(r5, j.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L16
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: AbortFlowException -> L16
        this.L$0 = r5;     // Catch: AbortFlowException -> L16
        this.label = 1;     // Catch: AbortFlowException -> L16
        if (r2.collect((j<? super T>) r9, r3) != r0) goto L20;
        return r0;
    L16:
        e = e;
        r6 = r5;
        goto L18
    }
}
