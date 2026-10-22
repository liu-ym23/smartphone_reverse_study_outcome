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

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filterIndexed$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2}, l = {211, 212, 212}, m = "invokeSuspend", n = {"$this$produce", "index", "$this$produce", "e", "index", "$this$produce", "index"}, s = {"L$0", "I$0", "L$0", "L$2", "I$0", "L$0", "I$0"})
final class ChannelsKt__DeprecatedKt$filterIndexed$1<E> extends SuspendLambda implements Function2<l<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function3<Integer, E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_filterIndexed;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$filterIndexed$1(ReceiveChannel<? extends E> r10, Function3<? super Integer, ? super E, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$filterIndexed$1> r12) {
        this.$this_filterIndexed = r10;
        this.$predicate = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$filterIndexed$1 r12 = new ChannelsKt__DeprecatedKt$filterIndexed$1(this.$this_filterIndexed, this.$predicate, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
        return invoke((l) r10, r11);
    }

    public final Object invoke(l<? super E> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$filterIndexed$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v13, types: [kotlinx.coroutines.channels.l] */
    /* JADX WARN: Type inference failed for: r7v14 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v2 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [java.lang.Object, kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v5 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L12;
        if (r11 == 1) goto L11;
        if (r11 == 2) goto L10;
        if (r11 != 3) goto L9;
        int r13 = this.I$0;
        ChannelIterator<E> r14 = (ChannelIterator) this.L$1;
        ?? r15 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
    L13:
        this.L$0 = r15;
        this.L$1 = r14;
        this.L$2 = null;
        this.I$0 = r13;
        this.label = 1;
        r12 = r14.a(this);
        ?? r16 = r15;
        if (r12 != r10) goto L17;
        return r10;
    L17:
        if (((Boolean) r12).booleanValue() == false) goto L29;
        E r17 = r14.next();
        Function3<Integer, E, Continuation<? super Boolean>, Object> r18 = this.$predicate;
        int r19 = r13 + 1;
        Integer r20 = Boxing.boxInt(r13);
        this.L$0 = r16;
        this.L$1 = r14;
        this.L$2 = r17;
        this.I$0 = r19;
        this.label = 2;
        Object r21 = r18.invoke(r20, r17, this);
        if (r21 != r10) goto L21;
        return r10;
    L21:
        ?? r22 = r16;
        Object r23 = r17;
        r12 = r21;
        r13 = r19;
    L23:
        if (((Boolean) r12).booleanValue() == false) goto L27;
        this.L$0 = r22;
        this.L$1 = r14;
        this.L$2 = null;
        this.I$0 = r13;
        this.label = 3;
        if (r22.H(r23, this) != r10) goto L27;
        return r10;
    L27:
        r15 = r22;
        goto L13
    L30:
        r15 = r22;
        goto L13
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = this.I$0;
        Object r24 = this.L$2;
        ChannelIterator<E> r25 = (ChannelIterator) this.L$1;
        l r26 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
        r23 = r24;
        r14 = r25;
        r22 = r26;
        goto L23
    L11:
        r13 = this.I$0;
        r14 = (ChannelIterator) this.L$1;
        l r27 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
        r16 = r27;
        goto L17
    L12:
        ResultKt.throwOnFailure(r12);
        l r110 = (l) this.L$0;
        r13 = 0;
        r14 = this.$this_filterIndexed.iterator();
        r15 = r110;
        goto L13
    }
}
