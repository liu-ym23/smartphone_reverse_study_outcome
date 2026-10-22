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
@DebugMetadata(c = "kotlinx.coroutines.channels.ChannelsKt__DeprecatedKt$map$1", f = "Deprecated.kt", i = {0, 0, 1, 1, 2, 2}, l = {487, 333, 333}, m = "invokeSuspend", n = {"$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv", "$this$produce", "$this$consume$iv$iv"}, s = {"L$0", "L$2", "L$0", "L$2", "L$0", "L$2"})
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n105#2:480\n82#2,6:481\n106#2,2:487\n92#2:489\n88#2,3:490\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt$map$1\n*L\n332#1:480\n332#1:481,6\n332#1:487,2\n332#1:489\n332#1:490,3\n*E\n"})
final class ChannelsKt__DeprecatedKt$map$1 extends SuspendLambda implements Function2<l<Object>, Continuation<? super Unit>, Object> {
    final /* synthetic */ ReceiveChannel<Object> $this_map;
    final /* synthetic */ Function2<Object, Continuation<Object>, Object> $transform;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    int label;

    /* JADX WARN: Multi-variable type inference failed */
    ChannelsKt__DeprecatedKt$map$1(ReceiveChannel<Object> r10, Function2<Object, ? super Continuation<Object>, ? extends Object> r11, Continuation<? super ChannelsKt__DeprecatedKt$map$1> r12) {
        this.$this_map = r10;
        this.$transform = r11;
        super(2, r12);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object r10, Continuation<?> r11) {
        ChannelsKt__DeprecatedKt$map$1 r12 = new ChannelsKt__DeprecatedKt$map$1(this.$this_map, this.$transform, r11);
        r12.L$0 = r10;
        return r12;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(l<Object> r10, Continuation<? super Unit> r11) {
        return invoke2(r10, r11);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(l<Object> r10, Continuation<? super Unit> r11) {
        return ((ChannelsKt__DeprecatedKt$map$1) create(r10, r11)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x00bd -> B:22:0x0072). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object r12) {
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r11 = this.label;
        if (r11 == 0) goto L20;
        if (r11 == 1) goto L17;
        if (r11 == 2) goto L12;
        if (r11 != 3) goto L11;
        ChannelIterator<Object> r13 = (ChannelIterator) this.L$3;
        ReceiveChannel<Object> r14 = (ReceiveChannel) this.L$2;
        Function2<Object, Continuation<Object>, Object> r15 = (Function2) this.L$1;
        l r16 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L39
        l r17 = r16;
    L22:
        this.L$0 = r17;     // Catch: Throwable -> L39
        this.L$1 = r15;     // Catch: Throwable -> L39
        this.L$2 = r14;     // Catch: Throwable -> L39
        this.L$3 = r13;     // Catch: Throwable -> L39
        this.label = 1;     // Catch: Throwable -> L39
        Object r18 = r13.a(this);     // Catch: Throwable -> L39
        if (r18 != r10) goto L25;
        return r10;
    L25:
        l r19 = r17;
        r12 = r18;
    L27:
        if (((Boolean) r12).booleanValue() == false) goto L36;
        Object r110 = r13.next();     // Catch: Throwable -> L39
        this.L$0 = r19;     // Catch: Throwable -> L39
        this.L$1 = r15;     // Catch: Throwable -> L39
        this.L$2 = r14;     // Catch: Throwable -> L39
        this.L$3 = r13;     // Catch: Throwable -> L39
        this.L$4 = r19;     // Catch: Throwable -> L39
        this.label = 2;     // Catch: Throwable -> L39
        r12 = r15.invoke(r110, this);     // Catch: Throwable -> L39
        if (r12 != r10) goto L31;
        return r10;
    L31:
        l r20 = r19;
        Function2<Object, Continuation<Object>, Object> r21 = r15;
        ReceiveChannel<Object> r22 = r14;
        ChannelIterator<Object> r23 = r13;
        l r24 = r20;
    L32:
        this.L$0 = r20;     // Catch: Throwable -> L15
        this.L$1 = r21;     // Catch: Throwable -> L15
        this.L$2 = r22;     // Catch: Throwable -> L15
        this.L$3 = r23;     // Catch: Throwable -> L15
        this.L$4 = null;     // Catch: Throwable -> L15
        this.label = 3;     // Catch: Throwable -> L15
        if (r24.H(r12, this) != r10) goto L35;
        return r10;
    L35:
        r13 = r23;
        r14 = r22;
        r15 = r21;
        r17 = r20;
    L15:
        th = th;
        r14 = r22;
    L48:
        throw th;     // Catch: Throwable -> L41
    L41:
        th = move-exception;
        i.b(r14, th);
        throw th;
    L36:
        Unit r111 = Unit.INSTANCE;     // Catch: Throwable -> L39
        i.b(r14, null);
        return r111;
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        r24 = (l) this.L$4;
        r23 = (ChannelIterator) this.L$3;
        r22 = (ReceiveChannel) this.L$2;
        r21 = (Function2) this.L$1;
        r20 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L15
        goto L32
    L17:
        r13 = (ChannelIterator) this.L$3;
        r14 = (ReceiveChannel) this.L$2;
        r15 = (Function2) this.L$1;
        r19 = (l) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: Throwable -> L39
        goto L27
    L20:
        ResultKt.throwOnFailure(r12);
        r17 = (l) this.L$0;
        r14 = this.$this_map;
        Function2<Object, Continuation<Object>, Object> r25 = this.$transform;
        r15 = r25;
        r13 = r14.iterator();     // Catch: Throwable -> L39
    L39:
        th = th;
        goto L48
    }
}
