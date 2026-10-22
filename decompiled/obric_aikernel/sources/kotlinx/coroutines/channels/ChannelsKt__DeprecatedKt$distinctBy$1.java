package kotlinx.coroutines.channels;

import java.util.HashSet;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$distinctBy$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 1, 2, 2, 2}, l = {387, 388, 390}, m = "invokeSuspend", n = {"$this$produce", "keys", "$this$produce", "keys", "e", "$this$produce", "keys", "k"}, s = {"L$0", "L$1", "L$0", "L$1", "L$3", "L$0", "L$1", "L$3"})
final class ChannelsKt__DeprecatedKt$distinctBy$1 extends SuspendLambda implements Function2<l<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $selector;
    final /* synthetic */ ReceiveChannel<Object> $this_distinctBy;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$distinctBy$1(ReceiveChannel<Object> r10, Function2<Object, ? super Continuation<Object>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$distinctBy$1> r12) {
        this.$this_distinctBy = r10;
        this.$selector = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$distinctBy$1 r12 = new ChannelsKt__DeprecatedKt$distinctBy$1(this.$this_distinctBy, this.$selector, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<Object> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$distinctBy$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00a1 -> B:29:0x00ba). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00b4 -> B:28:0x00b6). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r11) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r12 = this.label;
        if (r12 == 0) goto L12;
        if (r12 == 1) goto L11;
        if (r12 == 2) goto L10;
        if (r12 != 3) goto L9;
        Object r13 = this.L$3;
        ChannelIterator<Object> r14 = (ChannelIterator) this.L$2;
        HashSet r15 = (HashSet) this.L$1;
        l r16 = (l) this.L$0;
        ResultKt.throwOnFailure(r11);
    L28:
        r15.add(r13);
        ChannelIterator<Object> r17 = r14;
    L29:
        HashSet r18 = r15;
        l r19 = r16;
    L13:
        this.L$0 = r19;
        this.L$1 = r18;
        this.L$2 = r17;
        this.L$3 = null;
        this.label = 1;
        r11 = r17.a(this);
        if (r11 != r10) goto L17;
        return r10;
    L17:
        if (((Boolean) r11).booleanValue() == false) goto L31;
        Object r110 = r17.next();
        Function2<Object, Continuation<Object>, Object> r20 = this.$selector;
        this.L$0 = r19;
        this.L$1 = r18;
        this.L$2 = r17;
        this.L$3 = r110;
        this.label = 2;
        Object r21 = r20.invoke(r110, this);
        if (r21 != r10) goto L21;
        return r10;
    L21:
        HashSet r22 = r18;
        Object r23 = r110;
        r11 = r21;
        r16 = r19;
        r15 = r22;
    L23:
        if (r15.contains(r11) == true) goto L29;
        this.L$0 = r16;
        this.L$1 = r15;
        this.L$2 = r17;
        this.L$3 = r11;
        this.label = 3;
        if (r16.H(r23, this) != r10) goto L27;
        return r10;
    L27:
        r14 = r17;
        r13 = r11;
        goto L28
    L31:
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Object r24 = this.L$3;
        ChannelIterator<Object> r25 = (ChannelIterator) this.L$2;
        r15 = (HashSet) this.L$1;
        r16 = (l) this.L$0;
        ResultKt.throwOnFailure(r11);
        r23 = r24;
        r17 = r25;
        goto L23
    L11:
        r17 = (ChannelIterator) this.L$2;
        r18 = (HashSet) this.L$1;
        r19 = (l) this.L$0;
        ResultKt.throwOnFailure(r11);
        goto L17
    L12:
        ResultKt.throwOnFailure(r11);
        l r111 = (l) this.L$0;
        HashSet r26 = new HashSet();
        ChannelIterator<Object> r27 = this.$this_distinctBy.iterator();
        r19 = r111;
        r18 = r26;
        r17 = r27;
        goto L13
    }
}
