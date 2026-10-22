package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lkotlinx/coroutines/channels/n;", "", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)Lkotlinx/coroutines/channels/n;"}, k = 3, mv = {2, 0, 0})
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__ChannelsKt$trySendBlocking$2", f = "Channels.kt", i = {}, l = {39}, m = "invokeSuspend", n = {}, s = {})
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/channels/ChannelsKt__ChannelsKt$trySendBlocking$2\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,61:1\n1#2:62\n*E\n"})
final class ChannelsKt__ChannelsKt$trySendBlocking$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super n>, Object> {
    final /* synthetic */ Object $element;
    final /* synthetic */ x $this_trySendBlocking;
    private /* synthetic */ Object L$0;
    int label;

    public ChannelsKt__ChannelsKt$trySendBlocking$2(x r5, Object r10, Continuation<? super ChannelsKt__ChannelsKt$trySendBlocking$2> r11) {
        this.$this_trySendBlocking = r5;
        this.$element = r10;
        super(2, r11);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r5, Continuation<?> r10) {
        ChannelsKt__ChannelsKt$trySendBlocking$2 r11 = new ChannelsKt__ChannelsKt$trySendBlocking$2(this.$this_trySendBlocking, this.$element, r10);
        r11.L$0 = r5;
        return r11;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2invoke(CoroutineScope r5, Continuation<? super n> r10) {
        return invoke2(r5, r10);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r5) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L11;
        if (r11 != 1) goto L10;
        ResultKt.throwOnFailure(r5);     // Catch: Throwable -> L7
    L15:
        Object r12 = Result.m124constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L19:
        if (Result.m131isSuccessimpl(r12) == false) goto L21;
        Object r13 = Unit.INSTANCE;
    L23:
        return new n(r13);
    L21:
        r13 = new l(Result.m127exceptionOrNullimpl(r12));
        goto L23
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        x r15 = this.$this_trySendBlocking;
        Object r16 = this.$element;
        Result.Companion r17 = Result.Companion;     // Catch: Throwable -> L7
        this.label = 1;     // Catch: Throwable -> L7
        if (r15.r(r16, this) != r10) goto L15;
        return r10;
    L7:
        th = move-exception;
        Result.Companion r18 = Result.Companion;
        r12 = Result.m124constructorimpl(ResultKt.createFailure(th));
        goto L19
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope r5, Continuation<? super n> r10) {
        return ((ChannelsKt__ChannelsKt$trySendBlocking$2) create(r5, r10)).invokeSuspend(Unit.INSTANCE);
    }
}
