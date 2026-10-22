package kotlinx.coroutines.channels;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$zip$2", f = "Deprecated.kt", i = {0, 0, 0, 1, 1, 1, 1, 2, 2, 2}, l = {487, 469, 471}, m = "invokeSuspend", n = {"$this$produce", "otherIterator", "$this$consume$iv$iv", "$this$produce", "otherIterator", "$this$consume$iv$iv", "element1", "$this$produce", "otherIterator", "$this$consume$iv$iv"}, s = {"L$0", "L$1", "L$3", "L$0", "L$1", "L$3", "L$5", "L$0", "L$1", "L$3"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$zip$2\n*L\n468#1:480\n468#1:481,6\n468#1:487,2\n468#1:489\n468#1:490,3\n*E\n"})
final class ChannelsKt__DeprecatedKt$zip$2 extends SuspendLambda implements Function2<l<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $other;
    final /* synthetic */ ReceiveChannel<Object> $this_zip;
    final /* synthetic */ Function2<Object, Object, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;

    ChannelsKt__DeprecatedKt$zip$2(ReceiveChannel<Object> r10, ReceiveChannel<Object> r11, Function2<Object, Object, Object> r12, Continuation<? super ChannelsKt__DeprecatedKt$zip$2> r13) {
        this.$other = r10;
        this.$this_zip = r11;
        this.$transform = r12;
        super(2, r13);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$zip$2 r12 = new ChannelsKt__DeprecatedKt$zip$2(this.$other, this.$this_zip, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<Object> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$zip$2) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r13) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L20;
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L12;
        if (r11 != 3) goto L11;
        ChannelIterator<Object> r12 = (ChannelIterator) this.L$4;
        ReceiveChannel<Object> r14 = (ReceiveChannel) this.L$3;
        Function2<Object, Object, Object> r15 = (Function2) this.L$2;
        ChannelIterator<Object> r16 = (ChannelIterator) this.L$1;
        l r17 = (l) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L40
    L22:
        this.L$0 = r17;     // Catch: Throwable -> L40
        this.L$1 = r16;     // Catch: Throwable -> L40
        this.L$2 = r15;     // Catch: Throwable -> L40
        this.L$3 = r14;     // Catch: Throwable -> L40
        this.L$4 = r12;     // Catch: Throwable -> L40
        this.L$5 = null;     // Catch: Throwable -> L40
        this.label = 1;     // Catch: Throwable -> L40
        r13 = r12.a(this);     // Catch: Throwable -> L40
        if (r13 != r10) goto L26;
        return r10;
    L26:
        if (((Boolean) r13).booleanValue() == false) goto L37;
        Object r18 = r12.next();     // Catch: Throwable -> L40
        this.L$0 = r17;     // Catch: Throwable -> L40
        this.L$1 = r16;     // Catch: Throwable -> L40
        this.L$2 = r15;     // Catch: Throwable -> L40
        this.L$3 = r14;     // Catch: Throwable -> L40
        this.L$4 = r12;     // Catch: Throwable -> L40
        this.L$5 = r18;     // Catch: Throwable -> L40
        this.label = 2;     // Catch: Throwable -> L40
        Object r19 = r16.a(this);     // Catch: Throwable -> L40
        if (r19 != r10) goto L30;
        return r10;
    L30:
        ReceiveChannel<Object> r110 = r14;
        Object r20 = r18;
        r13 = r19;
        l r111 = r17;
        ChannelIterator<Object> r21 = r16;
        Function2<Object, Object, Object> r22 = r15;
        ReceiveChannel<Object> r23 = r110;
    L31:
        if (((Boolean) r13).booleanValue() == false) goto L36;
        Object r112 = r22.invoke(r20, r21.next());     // Catch: Throwable -> L15
        this.L$0 = r111;     // Catch: Throwable -> L15
        this.L$1 = r21;     // Catch: Throwable -> L15
        this.L$2 = r22;     // Catch: Throwable -> L15
        this.L$3 = r23;     // Catch: Throwable -> L15
        this.L$4 = r12;     // Catch: Throwable -> L15
        this.L$5 = null;     // Catch: Throwable -> L15
        this.label = 3;     // Catch: Throwable -> L15
        if (r111.H(r112, this) != r10) goto L36;
        return r10;
    L36:
        r14 = r23;
        r15 = r22;
        r16 = r21;
        r17 = r111;
        goto L22
    L51:
        r14 = r23;
        r15 = r22;
        r16 = r21;
        r17 = r111;
    L15:
        th = th;
        r14 = r23;
    L49:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        i.b(r14, th);
        throw th;
    L37:
        Unit r113 = Unit.INSTANCE;     // Catch: Throwable -> L40
        i.b(r14, null);
        return r113;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        Object r24 = this.L$5;
        ChannelIterator<Object> r25 = (ChannelIterator) this.L$4;
        r23 = (ReceiveChannel) this.L$3;
        r22 = (Function2) this.L$2;
        r21 = (ChannelIterator) this.L$1;
        r111 = (l) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L15
        r20 = r24;
        r12 = r25;
        goto L31
    L17:
        r12 = (ChannelIterator) this.L$4;
        r14 = (ReceiveChannel) this.L$3;
        r15 = (Function2) this.L$2;
        r16 = (ChannelIterator) this.L$1;
        r17 = (l) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: Throwable -> L40
        goto L26
    L20:
        ResultKt.throwOnFailure(r13);
        l r114 = (l) this.L$0;
        ChannelIterator<Object> r26 = this.$other.iterator();
        r14 = this.$this_zip;
        r15 = this.$transform;
        r17 = r114;
        r16 = r26;
        r12 = r14.iterator();     // Catch: Throwable -> L40
    L40:
        th = th;
        goto L49
    }
}
