package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nChannels.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n*L\n1#1,176:1\n107#2:177\n*S KotlinDebug\n*F\n+ 1 Channels.kt\nkotlinx/coroutines/flow/FlowKt__ChannelsKt\n*L\n153#1:177\n*E\n"})
final /* synthetic */ class FlowKt__ChannelsKt {
    public static final /* synthetic */ Object a(d r10, ReceiveChannel r11, boolean r12, Continuation r13) {
        return c(r10, r11, r12, r13);
    }

    public static final <T> Object b(d<? super T> r10, ReceiveChannel<? extends T> r11, Continuation<? super Unit> r12) {
        Object r13 = c(r10, r11, true, r12);
        if (r13 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
        return r13;
    L6:
        return Unit.INSTANCE;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x0090 -> B:14:0x0039). Please report as a decompilation issue!!! */
    private static final <T> Object c(d<? super T> r10, ReceiveChannel<? extends T> r11, boolean r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r14 = (FlowKt__ChannelsKt$emitAllImpl$1) r13;
        int r15 = r14.label;
        if ((r15 & Integer.MIN_VALUE) == 0) goto L7;
        r14.label = r15 - Integer.MIN_VALUE;
    L8:
        Object r16 = r14.result;
        Object r17 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r18 = r14.label;
        if (r18 == 0) goto L20;
        if (r18 == 1) goto L17;
        if (r18 != 2) goto L16;
        r12 = r14.Z$0;
        ChannelIterator<? extends T> r19 = (ChannelIterator) r14.L$2;
        r11 = (ReceiveChannel) r14.L$1;
        d<? super T> r20 = (d) r14.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L35
    L14:
        ChannelIterator<? extends T> r110 = r19;
        r10 = r20;
    L22:
        r14.L$0 = r10;     // Catch: Throwable -> L35
        r14.L$1 = r11;     // Catch: Throwable -> L35
        r14.L$2 = r110;     // Catch: Throwable -> L35
        r14.Z$0 = r12;     // Catch: Throwable -> L35
        r14.label = 1;     // Catch: Throwable -> L35
        Object r21 = r110.a(r14);     // Catch: Throwable -> L35
        if (r21 != r17) goto L25;
        return r17;
    L25:
        r20 = r10;
        r19 = r110;
        r16 = r21;
    L27:
        if (((Boolean) r16).booleanValue() == false) goto L31;
        T r111 = r19.next();     // Catch: Throwable -> L35
        r14.L$0 = r20;     // Catch: Throwable -> L35
        r14.L$1 = r11;     // Catch: Throwable -> L35
        r14.L$2 = r19;     // Catch: Throwable -> L35
        r14.Z$0 = r12;     // Catch: Throwable -> L35
        r14.label = 2;     // Catch: Throwable -> L35
        if (r20.emit(r111, r14) != r17) goto L14;
        return r17;
    L31:
        if (r12 == false) goto L34;
        kotlinx.coroutines.channels.i.b(r11, null);
    L34:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r12 = r14.Z$0;
        r19 = (ChannelIterator) r14.L$2;
        r11 = (ReceiveChannel) r14.L$1;
        r20 = (d) r14.L$0;
        ResultKt.throwOnFailure(r16);     // Catch: Throwable -> L35
        goto L27
    L20:
        ResultKt.throwOnFailure(r16);
        e.o(r10);
        r110 = r11.iterator();     // Catch: Throwable -> L35
    L35:
        th = move-exception;
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        if (r12 == false) goto L40;
        kotlinx.coroutines.channels.i.b(r11, th);
    L40:
        throw th;
    L7:
        r14 = new FlowKt__ChannelsKt$emitAllImpl$1(r13);
        goto L8
    }

    public static final <T> ReceiveChannel<T> d(c<? extends T> r10, kotlinx.coroutines.l0 r11) {
        return kotlinx.coroutines.flow.internal.d.b(r10).l(r11);
    }
}
