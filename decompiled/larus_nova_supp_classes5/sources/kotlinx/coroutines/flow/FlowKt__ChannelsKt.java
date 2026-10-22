package kotlinx.coroutines.flow;

import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlinx.coroutines.channels.ChannelIterator;
import kotlinx.coroutines.channels.ChannelsKt;
import kotlinx.coroutines.channels.ReceiveChannel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
public final /* synthetic */ class FlowKt__ChannelsKt {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x0090 -> B:14:0x0039). Please report as a decompilation issue!!! */
    public static final <T> Object a(FlowCollector<? super T> r6, ReceiveChannel<? extends T> r7, boolean r8, Continuation<? super Unit> r9) {
        if ((r9 instanceof FlowKt__ChannelsKt$emitAllImpl$1) == false) goto L7;
        FlowKt__ChannelsKt$emitAllImpl$1 r0 = (FlowKt__ChannelsKt$emitAllImpl$1) r9;
        int r1 = r0.label;
        if ((r1 & IntCompanionObject.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - IntCompanionObject.MIN_VALUE;
    L8:
        Object r10 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L20;
        if (r3 == 1) goto L17;
        if (r3 != 2) goto L16;
        r8 = r0.Z$0;
        ChannelIterator<? extends T> r11 = (ChannelIterator) r0.L$2;
        r7 = (ReceiveChannel) r0.L$1;
        FlowCollector<? super T> r4 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L36
    L14:
        ChannelIterator<? extends T> r12 = r11;
        r6 = r4;
    L23:
        r0.L$0 = r6;     // Catch: Throwable -> L36
        r0.L$1 = r7;     // Catch: Throwable -> L36
        r0.L$2 = r12;     // Catch: Throwable -> L36
        r0.Z$0 = r8;     // Catch: Throwable -> L36
        r0.label = 1;     // Catch: Throwable -> L36
        Object r5 = r12.hasNext(r0);     // Catch: Throwable -> L36
        if (r5 != r2) goto L26;
        return r2;
    L26:
        r4 = r6;
        r11 = r12;
        r10 = r5;
    L28:
        if (((Boolean) r10).booleanValue() == false) goto L32;
        T r13 = r11.next();     // Catch: Throwable -> L36
        r0.L$0 = r4;     // Catch: Throwable -> L36
        r0.L$1 = r7;     // Catch: Throwable -> L36
        r0.L$2 = r11;     // Catch: Throwable -> L36
        r0.Z$0 = r8;     // Catch: Throwable -> L36
        r0.label = 2;     // Catch: Throwable -> L36
        if (r4.emit(r13, r0) != r2) goto L14;
        return r2;
    L32:
        if (r8 == false) goto L35;
        ChannelsKt.cancelConsumed(r7, null);
    L35:
        return Unit.INSTANCE;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r8 = r0.Z$0;
        r11 = (ChannelIterator) r0.L$2;
        r7 = (ReceiveChannel) r0.L$1;
        r4 = (FlowCollector) r0.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L36
        goto L28
    L20:
        ResultKt.throwOnFailure(r10);
        if ((r6 instanceof l1) == true) goto L43;
        r12 = r7.iterator();     // Catch: Throwable -> L36
        goto L23
    L43:
        throw ((l1) r6).a;
    L36:
        th = move-exception;
        throw th;     // Catch: Throwable -> L38
    L38:
        th = move-exception;
        if (r8 == false) goto L41;
        ChannelsKt.cancelConsumed(r7, th);
    L41:
        throw th;
    L7:
        r0 = new FlowKt__ChannelsKt$emitAllImpl$1(r9);
        goto L8
    }
}
