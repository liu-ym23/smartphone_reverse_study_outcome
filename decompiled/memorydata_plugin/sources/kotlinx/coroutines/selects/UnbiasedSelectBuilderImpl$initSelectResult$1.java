package kotlinx.coroutines.selects;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.al;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", "R", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.selects.UnbiasedSelectBuilderImpl$initSelectResult$1", f = "SelectOld.kt", i = {}, l = {67}, m = "invokeSuspend", n = {}, s = {})
final class UnbiasedSelectBuilderImpl$initSelectResult$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ q<R> this$0;

    UnbiasedSelectBuilderImpl$initSelectResult$1(q<R> r3, Continuation<? super UnbiasedSelectBuilderImpl$initSelectResult$1> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.this$0 = r3;
        super(2, r5);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        Continuation r4 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r3, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new UnbiasedSelectBuilderImpl$initSelectResult$1(this.this$0, r4), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((UnbiasedSelectBuilderImpl$initSelectResult$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), UnbiasedSelectBuilderImpl$initSelectResult$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [kotlinx.coroutines.n] */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L11;
        if (r1 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L15:
        UnbiasedSelectBuilderImpl$initSelectResult$1 this = (kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(q.a(this.this$0), kotlinx.coroutines.n.class, "com.obric.memorydata.plugin");
        p.a(this, r5);
    L17:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        q<R> r6 = this.this$0;     // Catch: Throwable -> L7
        Continuation r2 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        r5 = r6.a((Continuation<? super R>) r2);     // Catch: Throwable -> L7
        if (r5 != r0) goto L15;
        return r0;
    L7:
        th = move-exception;
        p.a((kotlinx.coroutines.n) ZeusTransformUtils.preCheckCast(q.a(this.this$0), kotlinx.coroutines.n.class, "com.obric.memorydata.plugin"), th);
        goto L17
    }
}
