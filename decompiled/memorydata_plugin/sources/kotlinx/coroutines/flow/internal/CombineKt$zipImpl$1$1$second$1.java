package kotlinx.coroutines.flow.internal;

import com.bytedance.crash.entity.EventBody;
import com.ss.bduploader.BDVideoUploaderBase;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.z;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u00020\u00060\u0005H\u008a@"}, d2 = {"<anonymous>", "", "T1", "T2", "R", "Lkotlinx/coroutines/channels/ProducerScope;", ""}, k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1", f = "Combine.kt", i = {}, l = {BDVideoUploaderBase.KeyIsEnableLogicalPart}, m = "invokeSuspend", n = {}, s = {})
final class CombineKt$zipImpl$1$1$second$1 extends SuspendLambda implements Function2<kotlinx.coroutines.channels.w<? super Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ kotlinx.coroutines.flow.i<T2> $flow2;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: kotlinx.coroutines.flow.internal.CombineKt$zipImpl$1$1$second$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u0004\b\u0002\u0010\u00042\u0006\u0010\u0005\u001a\u0002H\u0003H\u008a@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T1", "T2", "R", EventBody.KEY_VALUE, "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    static final class AnonymousClass1<T> implements kotlinx.coroutines.flow.j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ kotlinx.coroutines.channels.w<Object> f17449a;

        AnonymousClass1(kotlinx.coroutines.channels.w<Object> r3) {
            this.f17449a = (kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        }

        @Override // kotlinx.coroutines.flow.j
        public final Object emit(T2 r5, Continuation<? super Unit> r6) {
            Continuation r7 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r6, Continuation.class, "com.obric.memorydata.plugin");
            if (ZeusTransformUtils.instanceOf(r7, CombineKt$zipImpl$1$1$second$1$1$emit$1.class) == false) goto L7;
            CombineKt$zipImpl$1$1$second$1$1$emit$1 r0 = (CombineKt$zipImpl$1$1$second$1$1$emit$1) ZeusTransformUtils.preCheckCast(r7, CombineKt$zipImpl$1$1$second$1$1$emit$1.class, "com.obric.memorydata.plugin");
            if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
            r0.label -= Integer.MIN_VALUE;
        L8:
            Object r8 = r0.result;
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = r0.label;
            if (r2 == 0) goto L14;
            if (r2 != 1) goto L13;
            ResultKt.throwOnFailure(r8);
        L21:
            return Unit.INSTANCE;
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            ResultKt.throwOnFailure(r8);
            z<Object> r4 = this.f17449a.u();
            Object r9 = r5;
            if (r5 != 0) goto L17;
            r9 = s.f17463a;
        L17:
            r0.label = 1;
            if (r4.send(r9, r0) != r1) goto L21;
            return r1;
        L7:
            r0 = new CombineKt$zipImpl$1$1$second$1$1$emit$1(this, r7);
            goto L8
        }
    }

    CombineKt$zipImpl$1$1$second$1(kotlinx.coroutines.flow.i<? extends T2> r3, Continuation<? super CombineKt$zipImpl$1$1$second$1> r4) {
        kotlinx.coroutines.flow.i<T2> r5 = (kotlinx.coroutines.flow.i) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.flow.i.class, "com.obric.memorydata.plugin");
        Continuation r6 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        this.$flow2 = r5;
        super(2, r6);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        Continuation r5 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin");
        CombineKt$zipImpl$1$1$second$1 r0 = new CombineKt$zipImpl$1$1$second$1(this.$flow2, r5);
        r0.L$0 = r3;
        return (Continuation) ZeusTransformUtils.preCheckCast(r0, Continuation.class, "com.obric.memorydata.plugin");
    }

    @Override // kotlin.jvm.functions.Function2
    public /* synthetic */ Object invoke(kotlinx.coroutines.channels.w<? super Object> r3, Continuation<? super Unit> r4) {
        return invoke2((kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.preCheckCast(r4, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(kotlinx.coroutines.channels.w<Object> r3, Continuation<? super Unit> r4) {
        return ((CombineKt$zipImpl$1$1$second$1) ZeusTransformUtils.preCheckCast(create((kotlinx.coroutines.channels.w) ZeusTransformUtils.wrapperContextForParams(r3, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r4, Continuation.class, "com.obric.memorydata.plugin")), CombineKt$zipImpl$1$1$second$1.class, "com.obric.memorydata.plugin")).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        kotlinx.coroutines.channels.w r7 = (kotlinx.coroutines.channels.w) ZeusTransformUtils.preCheckCast(this.L$0, kotlinx.coroutines.channels.w.class, "com.obric.memorydata.plugin");
        kotlinx.coroutines.flow.i<T2> r2 = this.$flow2;
        kotlinx.coroutines.flow.j r8 = (kotlinx.coroutines.flow.j) ZeusTransformUtils.preCheckCast(new AnonymousClass1(r7), kotlinx.coroutines.flow.j.class, "com.obric.memorydata.plugin");
        Continuation<? super Unit> r3 = (Continuation) ZeusTransformUtils.preCheckCast(this, Continuation.class, "com.obric.memorydata.plugin");
        this.label = 1;
        if (r2.collect((kotlinx.coroutines.flow.j<? super T2>) r8, r3) != r0) goto L12;
        return r0;
    }
}
