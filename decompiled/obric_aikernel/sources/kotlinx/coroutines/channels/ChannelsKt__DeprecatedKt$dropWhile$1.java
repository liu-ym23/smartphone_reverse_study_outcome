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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$dropWhile$1", f = "Deprecated.kt", i = {0, 1, 1, 2, 3, 4}, l = {181, 182, 183, 187, 188}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0", "L$0", "L$0"})
final class ChannelsKt__DeprecatedKt$dropWhile$1<E> extends SuspendLambda implements Function2<l<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<E, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<E> $this_dropWhile;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$dropWhile$1(ReceiveChannel<? extends E> r10, Function2<? super E, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$dropWhile$1> r12) {
        this.$this_dropWhile = r10;
        this.$predicate = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$dropWhile$1 r12 = new ChannelsKt__DeprecatedKt$dropWhile$1(this.$this_dropWhile, this.$predicate, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
        return invoke((l) r10, r11);
    }

    public final Object invoke(l<? super E> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$dropWhile$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r1v10, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v25 */
    /* JADX WARN: Type inference failed for: r1v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object, kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v4, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v6 */
    /* JADX WARN: Type inference failed for: r9v2 */
    /* JADX WARN: Type inference failed for: r9v3, types: [java.lang.Object, kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r9v6 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:28:0x009f -> B:16:0x0054). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:44:0x00ec -> B:10:0x0023). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L19;
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L15;
        if (r11 == 3) goto L14;
        if (r11 == 4) goto L13;
        if (r11 != 5) goto L12;
        ChannelIterator<E> r13 = (ChannelIterator) this.L$1;
        l r14 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
        ?? r15 = r14;
    L10:
        ChannelIterator<E> r16 = r13;
        ?? r17 = r15;
    L37:
        this.L$0 = r17;
        this.L$1 = r16;
        this.label = 4;
        Object r18 = r16.a(this);
        if (r18 != r10) goto L40;
        return r10;
    L40:
        ?? r19 = r17;
        r13 = r16;
        r12 = r18;
        ?? r20 = r19;
    L42:
        if (((Boolean) r12).booleanValue() == false) goto L47;
        E r110 = r13.next();
        this.L$0 = r20;
        this.L$1 = r13;
        this.label = 5;
        Object r111 = r20.H(r110, this);
        r15 = r20;
        if (r111 != r10) goto L10;
        return r10;
    L47:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        r13 = (ChannelIterator) this.L$1;
        l r21 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
        r20 = r21;
        goto L42
    L14:
        l r22 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
        ?? r23 = r22;
    L36:
        r16 = this.$this_dropWhile.iterator();
        r17 = r23;
        goto L37
    L15:
        Object r24 = this.L$2;
        ChannelIterator<E> r25 = (ChannelIterator) this.L$1;
        l r26 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
        ChannelIterator<E> r112 = r25;
        Object r27 = r24;
        ?? r28 = r26;
    L16:
        ChannelIterator<E> r29 = r112;
        if (((Boolean) r12).booleanValue() == true) goto L35;
        this.L$0 = r28;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 3;
        if (r28.H(r27, this) != r10) goto L34;
        return r10;
    L34:
        r23 = r28;
        goto L36
    L35:
        ?? r30 = r28;
    L20:
        this.L$0 = r30;
        this.L$1 = r29;
        this.L$2 = null;
        this.label = 1;
        r12 = r29.a(this);
        ?? r31 = r30;
        if (r12 == r10) goto L22;
    L18:
        ?? r113 = r31;
        ChannelIterator<E> r32 = r29;
        ?? r33 = r113;
        r23 = r33;
        if (((Boolean) r12).booleanValue() == false) goto L36;
        E r114 = r32.next();
        Function2<E, Continuation<? super Boolean>, Object> r34 = this.$predicate;
        this.L$0 = r33;
        this.L$1 = r32;
        this.L$2 = r114;
        this.label = 2;
        Object r35 = r34.invoke(r114, this);
        if (r35 != r10) goto L28;
        return r10;
    L28:
        r112 = r32;
        r27 = r114;
        r12 = r35;
        r28 = r33;
        goto L16
    L22:
        return r10;
    L17:
        r29 = (ChannelIterator) this.L$1;
        l r36 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);
        r31 = r36;
        goto L18
    L19:
        ResultKt.throwOnFailure(r12);
        l r115 = (l) this.L$0;
        r29 = this.$this_dropWhile.iterator();
        r30 = r115;
        goto L20
    }
}
