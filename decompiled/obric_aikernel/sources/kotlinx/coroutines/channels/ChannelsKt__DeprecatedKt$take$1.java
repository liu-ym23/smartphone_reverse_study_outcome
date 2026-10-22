package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$take$1", f = "Deprecated.kt", i = {0, 0, 1, 1}, l = {254, 255}, m = "invokeSuspend", n = {"$this$produce", "remaining", "$this$produce", "remaining"}, s = {"L$0", "I$0", "L$0", "I$0"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$take$1\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,479:1\n1#2:480\n*E\n"})
final class ChannelsKt__DeprecatedKt$take$1<E> extends SuspendLambda implements Function2<l<? super E>, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $n;
    final /* synthetic */ ReceiveChannel<E> $this_take;
    int I$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$take$1(int r10, ReceiveChannel<? extends E> r11, Continuation<? super ChannelsKt__DeprecatedKt$take$1> r12) {
        this.$n = r10;
        this.$this_take = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$take$1 r12 = new ChannelsKt__DeprecatedKt$take$1(this.$n, this.$this_take, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object r10, Continuation<? super Unit> r11) {
        return invoke((l) r10, r11);
    }

    public final Object invoke(l<? super E> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$take$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x0078 -> B:7:0x001b). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r10) {
        Object r11 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L11;
        if (r12 == 1) goto L10;
        if (r12 != 2) goto L9;
        int r13 = this.I$0;
        ChannelIterator<E> r14 = (ChannelIterator) this.L$1;
        l r15 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
    L7:
        l r16 = r15;
        r13 = r13 - 1;
        if (r13 == 0) goto L32;
    L20:
        this.L$0 = r16;
        this.L$1 = r14;
        this.I$0 = r13;
        this.label = 1;
        Object r17 = r14.a(this);
        if (r17 != r11) goto L23;
        return r11;
    L23:
        r15 = r16;
        r10 = r17;
    L25:
        if (((Boolean) r10).booleanValue() == false) goto L34;
        E r18 = r14.next();
        this.L$0 = r15;
        this.L$1 = r14;
        this.I$0 = r13;
        this.label = 2;
        if (r15.H(r18, this) != r11) goto L7;
        return r11;
    L34:
        return Unit.INSTANCE;
    L32:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        r13 = this.I$0;
        r14 = (ChannelIterator) this.L$1;
        r15 = (l) this.L$0;
        ResultKt.throwOnFailure(r10);
        goto L25
    L11:
        ResultKt.throwOnFailure(r10);
        r16 = (l) this.L$0;
        r13 = this.$n;
        if (r13 == 0) goto L14;
        if (r13 < 0) goto L17;
        boolean r19 = true;
    L18:
        if (r19 == false) goto L36;
        r14 = this.$this_take.iterator();
        goto L20
    L36:
        throw new IllegalArgumentException(("Requested element count " + r13 + " is less than zero.").toString());
    L17:
        r19 = false;
        goto L18
    L14:
        return Unit.INSTANCE;
    }
}
