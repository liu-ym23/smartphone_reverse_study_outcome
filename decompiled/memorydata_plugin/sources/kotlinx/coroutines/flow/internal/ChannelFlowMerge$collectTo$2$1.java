package kotlinx.coroutines.flow.internal;

import androidx.exifinterface.media.ExifInterface;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\u008a@"}, d2 = {"<anonymous>", "", ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.ChannelFlowMerge$collectTo$2$1", f = "Merge.kt", i = {}, l = {65}, m = "invokeSuspend", n = {}, s = {})
final class ChannelFlowMerge$collectTo$2$1 extends SuspendLambda implements Function2<al, Continuation<? super Unit>, Object> {
    final /* synthetic */ v<T> $collector;
    final /* synthetic */ kotlinx.coroutines.flow.i<T> $inner;
    final /* synthetic */ kotlinx.coroutines.sync.d $semaphore;
    int label;

    ChannelFlowMerge$collectTo$2$1(kotlinx.coroutines.flow.i<? extends T> r3, v<T> r4, kotlinx.coroutines.sync.d r5, Continuation<? super ChannelFlowMerge$collectTo$2$1> r6) {
        kotlinx.coroutines.flow.i<T> r7 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.sync.d r8 = (kotlinx.coroutines.sync.d) ZeusTransformUtils.wrapperContextForParams(r5, kotlinx.coroutines.sync.d.class, "com.obric.memorydata.plugin");
        Continuation r9 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
        this.$inner = r7;
        this.$collector = r4;
        this.$semaphore = r8;
        super(2, r9);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r5, Continuation.class, "com.obric.memorydata.plugin");
        return (Continuation) ZeusTransformUtils.preCheckCast(new ChannelFlowMerge$collectTo$2$1(this.$inner, this.$collector, this.$semaphore, r6), Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(al r3, Continuation<? super Unit> r4) {
        return invoke2((al) ZeusTransformUtils.preCheckCast(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(al r3, Continuation<? super Unit> r4) {
        return ((ChannelFlowMerge$collectTo$2$1) ZeusTransformUtils.preCheckCast(create((al) ZeusTransformUtils.wrapperContextForParams(r3, al.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), ChannelFlowMerge$collectTo$2$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L11;
        if (r2 != 1) goto L10;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7
    L15:
        this.$semaphore.c();
        ChannelFlowMerge$collectTo$2$1 this = Unit.INSTANCE;
        return this;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.flow.i<T> r7 = this.$inner;     // Catch: Throwable -> L7
        kotlinx.coroutines.flow.j r3 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(this.$collector, kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        Continuation<? super Unit> r0 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r7.collect((kotlinx.coroutines.flow.j<? super T>) r3, r0) != r1) goto L15;
        return r1;
    L7:
        th = move-exception;
        this.$semaphore.c();
        throw th;
    }
}
