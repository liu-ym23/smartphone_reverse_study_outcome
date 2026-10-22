package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.IndexedValue;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$withIndex$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {370, 371}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$withIndex$1<E> extends SuspendLambda implements Function2<l<? super IndexedValue<? extends E>>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_withIndex;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$withIndex$1(ReceiveChannel<? extends E> r10, Continuation<? super ChannelsKt__DeprecatedKt$withIndex$1> r11) {
        this.$this_withIndex = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$withIndex$1 r12 = new ChannelsKt__DeprecatedKt$withIndex$1(this.$this_withIndex, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
        return invoke((l) r10, r11);
    }

    public final Object invoke(l<? super IndexedValue<? extends E>> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$withIndex$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x0075 -> B:11:0x0041). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L10;
        if (r12 == 1) goto L9;
        if (r12 != 2) goto L8;
        int r13 = this.I$0;
        ChannelIterator<E> r14 = (ChannelIterator) this.L$1;
        l r15 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        l r16 = r15;
    L11:
        this.L$0 = r16;
        this.L$1 = r14;
        this.I$0 = r13;
        this.label = 1;
        Object r17 = r14.a(this);
        if (r17 != r11) goto L14;
        return r11;
    L14:
        l r18 = r16;
        r10 = r17;
    L16:
        if (((Boolean) r10).booleanValue() == false) goto L22;
        int r19 = r13 + 1;
        IndexedValue r20 = new IndexedValue(r13, r14.next());
        this.L$0 = r18;
        this.L$1 = r14;
        this.I$0 = r19;
        this.label = 2;
        if (r18.H(r20, this) != r11) goto L20;
        return r11;
    L20:
        r16 = r18;
        r13 = r19;
        goto L11
    L22:
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        r13 = this.I$0;
        r14 = (ChannelIterator) this.L$1;
        r18 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        goto L16
    L10:
        ResultKt.throwOnFailure(r10);
        r16 = (l) this.L$0;
        r13 = 0;
        r14 = this.$this_withIndex.iterator();
        goto L11
    }
}
