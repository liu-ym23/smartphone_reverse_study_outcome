package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.BroadcastKt$broadcast$2", f = "Broadcast.kt", i = {0, 1}, l = {56, 57}, m = "invokeSuspend", n = {"$this$broadcast", "$this$broadcast"}, s = {"L$0", "L$0"})
final class BroadcastKt$broadcast$2 extends SuspendLambda implements Function2<l<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $channel;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    BroadcastKt$broadcast$2(ReceiveChannel<Object> r10, Continuation<? super BroadcastKt$broadcast$2> r11) {
        this.$channel = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        BroadcastKt$broadcast$2 r12 = new BroadcastKt$broadcast$2(this.$channel, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<Object> r10, Continuation<? super Unit> r11) {
        return ((BroadcastKt$broadcast$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0062 -> B:7:0x0019). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L9;
        ChannelIterator<Object> r13 = (ChannelIterator) this.L$1;
        l r14 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
    L7:
        l r15 = r14;
    L12:
        this.L$0 = r15;
        this.L$1 = r13;
        this.label = 1;
        Object r16 = r13.a(this);
        if (r16 != r11) goto L15;
        return r11;
    L15:
        r14 = r15;
        r10 = r16;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L22;
        Object r17 = r13.next();
        this.L$0 = r14;
        this.L$1 = r13;
        this.label = 2;
        if (r14.H(r17, this) != r11) goto L7;
        return r11;
    L22:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = (ChannelIterator) this.L$1;
        r14 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        goto L17
    L11:
        ResultKt.throwOnFailure(r10);
        r15 = (l) this.L$0;
        r13 = this.$channel.iterator();
        goto L12
    }
}
