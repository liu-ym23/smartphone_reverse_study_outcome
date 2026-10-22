package kotlinx.coroutines.channels;

import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.l0;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<l0, Continuation<? super g<? extends Unit>>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ n<Object> $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    ChannelsKt__ChannelsKt$trySendBlocking$2(n<Object> r10, Object r11, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> r12) {
        this.$this_trySendBlocking = r10;
        this.$element = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 r12 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l0 r10, Continuation<? super g<? extends Unit>> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l0 r10, Continuation<? super g<Unit>> r11) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L9;
        if (r12 != 1) goto L8;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L15
    L13:
        Object r13 = Result.m32constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L18:
        if (Result.m39isSuccessimpl(r13) == false) goto L20;
        Object r14 = g.f10318b.c(Unit.INSTANCE);
    L22:
        return g.b(r14);
    L20:
        r14 = g.f10318b.a(Result.m35exceptionOrNullimpl(r13));
        goto L22
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r10);
        l0 r15 = (l0) this.L$0;
        n<Object> r16 = this.$this_trySendBlocking;
        Object r17 = this.$element;
        Result.Companion r18 = Result.Companion;     // Catch: Throwable -> L15
        this.label = 1;     // Catch: Throwable -> L15
        if (r16.H(r17, this) != r11) goto L13;
        return r11;
    L15:
        th = move-exception;
        Result.Companion r19 = Result.Companion;
        r13 = Result.m32constructorimpl(ResultKt.createFailure(th));
        goto L18
    }
}
