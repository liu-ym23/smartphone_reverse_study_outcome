package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$mapIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {344, 345, 345}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$mapIndexed$1 extends SuspendLambda implements Function2<l<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_mapIndexed;
    final /* synthetic */ Function3<Integer, Object, Continuation<Object>, Object> $transform;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$mapIndexed$1(ReceiveChannel<Object> r10, Function3<? super Integer, Object, ? super Continuation<Object>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$mapIndexed$1> r12) {
        this.$this_mapIndexed = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$mapIndexed$1 r12 = new ChannelsKt__DeprecatedKt$mapIndexed$1(this.$this_mapIndexed, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<Object> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$mapIndexed$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x00a3 -> B:13:0x0056). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        int r13 = this.I$0;
        ChannelIterator<Object> r14 = (ChannelIterator) this.L$1;
        l r15 = (l) this.L$0;
        ResultKt.throwOnFailure(r11);
        l r16 = r15;
    L13:
        this.L$0 = r16;
        this.L$1 = r14;
        this.I$0 = r13;
        this.label = 1;
        Object r17 = r14.a(this);
        if (r17 != r10) goto L16;
        return r10;
    L16:
        l r18 = r16;
        r11 = r17;
    L18:
        if (((Boolean) r11).booleanValue() == false) goto L28;
        Object r19 = r14.next();
        Function3<Integer, Object, Continuation<Object>, Object> r20 = this.$transform;
        int r21 = r13 + 1;
        Integer r22 = Boxing.boxInt(r13);
        this.L$0 = r18;
        this.L$1 = r14;
        this.L$2 = r18;
        this.I$0 = r21;
        this.label = 2;
        r11 = r20.invoke(r22, r19, this);
        if (r11 != r10) goto L22;
        return r10;
    L22:
        l r23 = r18;
        r13 = r21;
        ChannelIterator<Object> r24 = r14;
        l r25 = r23;
    L23:
        this.L$0 = r23;
        this.L$1 = r24;
        this.L$2 = null;
        this.I$0 = r13;
        this.label = 3;
        if (r25.H(r11, this) != r10) goto L26;
        return r10;
    L26:
        r14 = r24;
        r16 = r23;
        goto L13
    L28:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = this.I$0;
        r25 = (l) this.L$2;
        r24 = (ChannelIterator) this.L$1;
        r23 = (l) this.L$0;
        ResultKt.throwOnFailure(r11);
        goto L23
    L11:
        r13 = this.I$0;
        r14 = (ChannelIterator) this.L$1;
        r18 = (l) this.L$0;
        ResultKt.throwOnFailure(r11);
        goto L18
    L12:
        ResultKt.throwOnFailure(r11);
        r16 = (l) this.L$0;
        r13 = 0;
        r14 = this.$this_mapIndexed.iterator();
        goto L13
    }
}
