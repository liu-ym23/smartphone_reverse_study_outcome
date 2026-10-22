package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$takeWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {269, 270, 271}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$takeWhile$1<E> extends SuspendLambda implements Function2<l<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_takeWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$takeWhile$1(ReceiveChannel<? extends E> r10, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$takeWhile$1> r12) {
        this.$this_takeWhile = r10;
        this.$predicate = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$takeWhile$1 r12 = new ChannelsKt__DeprecatedKt$takeWhile$1(this.$this_takeWhile, this.$predicate, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
        return invoke((l) r10, r11);
    }

    public final Object invoke(l<? super E> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$takeWhile$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v0, types: [java.lang.Object, kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0097 -> B:13:0x004d). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        ChannelIterator<E> r13 = (ChannelIterator) this.L$1;
        l r14 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        ?? r15 = r14;
    L13:
        this.L$0 = r15;
        this.L$1 = r13;
        this.label = 1;
        r10 = r13.a(this);
        ?? r16 = r15;
        if (r10 != r11) goto L17;
        return r11;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L31;
        E r17 = r13.next();
        Function2<E, Continuation<? super Boolean>, Object> r18 = this.$predicate;
        this.L$0 = r16;
        this.L$1 = r13;
        this.L$2 = r17;
        this.label = 2;
        Object r19 = r18.invoke(r17, this);
        if (r19 != r11) goto L21;
        return r11;
    L21:
        ChannelIterator<E> r20 = r13;
        Object r21 = r17;
        r10 = r19;
        ?? r22 = r16;
        ChannelIterator<E> r23 = r20;
    L23:
        if (((Boolean) r10).booleanValue() == false) goto L25;
        this.L$0 = r22;
        this.L$1 = r23;
        this.L$2 = null;
        this.label = 3;
        if (r22.H(r21, this) != r11) goto L29;
        return r11;
    L29:
        r13 = r23;
        r15 = r22;
        goto L13
    L25:
        return Unit.INSTANCE;
    L31:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r21 = this.L$2;
        r23 = (ChannelIterator) this.L$1;
        l r24 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        r22 = r24;
        goto L23
    L11:
        r13 = (ChannelIterator) this.L$1;
        l r25 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        r16 = r25;
        goto L17
    L12:
        ResultKt.throwOnFailure(r10);
        l r26 = (l) this.L$0;
        r13 = this.$this_takeWhile.iterator();
        r15 = r26;
        goto L13
    }
}
