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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$requireNoNulls$1", f = "Deprecated.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ChannelsKt__DeprecatedKt$requireNoNulls$1<E> extends SuspendLambda implements Function2<E, Continuation<? super E>, Object> {
    final /* synthetic */ ReceiveChannel<E> $this_requireNoNulls;
    /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$requireNoNulls$1(ReceiveChannel<? extends E> r10, Continuation<? super ChannelsKt__DeprecatedKt$requireNoNulls$1> r11) {
        this.$this_requireNoNulls = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$requireNoNulls$1 r12 = new ChannelsKt__DeprecatedKt$requireNoNulls$1(this.$this_requireNoNulls, r11);
        r12.L$0 = r10;
        return r12;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Object r11) {
        return invoke(r10, (Continuation) r11);
    }

    public final Object invoke(E r10, Continuation<? super E> r11) {
        return ((ChannelsKt__DeprecatedKt$requireNoNulls$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L10;
        ResultKt.throwOnFailure(r10);
        Object r11 = this.L$0;
        if (r11 == null) goto L8;
        return r11;
    L8:
        throw new IllegalArgumentException("null element found in " + this.$this_requireNoNulls + '.');
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
