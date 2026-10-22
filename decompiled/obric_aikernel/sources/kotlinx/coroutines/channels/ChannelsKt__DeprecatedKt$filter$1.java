package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$filter$1", f = "Deprecated.kt", i = {0, 1, 1, 2}, l = {198, 199, 199}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "e", "$this$produce"}, s = {"L$0", "L$0", "L$2", "L$0"})
final class ChannelsKt__DeprecatedKt$filter$1 extends SuspendLambda implements Function2<l<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<? super Boolean>, Object> $predicate;
    final /* synthetic */ ReceiveChannel<Object> $this_filter;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$filter$1(ReceiveChannel<Object> r10, Function2<Object, ? super Continuation<? super Boolean>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$filter$1> r12) {
        this.$this_filter = r10;
        this.$predicate = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$filter$1 r12 = new ChannelsKt__DeprecatedKt$filter$1(this.$this_filter, this.$predicate, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<Object> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$filter$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        ChannelIterator<Object> r13 = (ChannelIterator) this.L$1;
        l r14 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
    L13:
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = null;
        this.label = 1;
        r10 = r13.a(this);
        if (r10 != r11) goto L17;
        return r11;
    L17:
        if (((Boolean) r10).booleanValue() == false) goto L29;
        Object r15 = r13.next();
        Function2<Object, Continuation<? super Boolean>, Object> r16 = this.$predicate;
        this.L$0 = r14;
        this.L$1 = r13;
        this.L$2 = r15;
        this.label = 2;
        Object r17 = r16.invoke(r15, this);
        if (r17 != r11) goto L21;
        return r11;
    L21:
        l r18 = r14;
        Object r19 = r15;
        r10 = r17;
        l r20 = r18;
    L23:
        if (((Boolean) r10).booleanValue() == false) goto L27;
        this.L$0 = r20;
        this.L$1 = r13;
        this.L$2 = null;
        this.label = 3;
        if (r20.H(r19, this) != r11) goto L27;
        return r11;
    L27:
        r14 = r20;
        goto L13
    L30:
        r14 = r20;
        goto L13
    L29:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Object r21 = this.L$2;
        ChannelIterator<Object> r22 = (ChannelIterator) this.L$1;
        r20 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        r19 = r21;
        r13 = r22;
        goto L23
    L11:
        r13 = (ChannelIterator) this.L$1;
        r14 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        goto L17
    L12:
        ResultKt.throwOnFailure(r10);
        l r110 = (l) this.L$0;
        r13 = this.$this_filter.iterator();
        r14 = r110;
        goto L13
    }
}
