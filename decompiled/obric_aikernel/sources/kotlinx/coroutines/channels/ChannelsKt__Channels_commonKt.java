package kotlinx.coroutines.channels;

import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.SourceDebugExtension;
import kotlinx.coroutines.k1;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nChannels.common.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,141:1\n82#1,11:142\n105#1:153\n82#1,6:154\n106#1,2:160\n92#1:162\n88#1,3:163\n33#1,5:166\n*S KotlinDebug\n*F\n+ 1 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n105#1:142,11\n116#1:153\n116#1:154,6\n116#1:160,2\n116#1:162\n116#1:163,3\n129#1:166,5\n*E\n"})
final /* synthetic */ class ChannelsKt__Channels_commonKt {
    @PublishedApi
    public static final void a(ReceiveChannel<?> r10, Throwable r11) {
        CancellationException r12 = null;
        if (r11 != null) goto L5;
    L9:
        r10.c(r12);
        return;
    L5:
        if ((r11 instanceof CancellationException) == false) goto L7;
        r12 = (CancellationException) r11;
    L7:
        if (r12 != null) goto L9;
        r12 = k1.a("Channel was consumed, consumer had failed", r11);
        goto L9
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0062 -> B:14:0x0038). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.WARNING, message = "BroadcastChannel is deprecated in the favour of SharedFlow and is no longer supported")
    public static final <E> Object b(b<E> r10, Function1<? super E, Unit> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof ChannelsKt__Channels_commonKt$consumeEach$3) == false) goto L7;
        ChannelsKt__Channels_commonKt$consumeEach$3 r13 = (ChannelsKt__Channels_commonKt$consumeEach$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L19;
        if (r17 != 1) goto L18;
        ChannelIterator r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel<E> r19 = (ReceiveChannel) r13.L$1;
        Function1<? super E, Unit> r20 = (Function1) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L15
        ChannelsKt__Channels_commonKt$consumeEach$3 r21 = r13;
        ReceiveChannel<E> r22 = r19;
        r11 = r20;
    L14:
        Object r23 = r16;
        ChannelsKt__Channels_commonKt$consumeEach$3 r24 = r21;
    L32:
        Throwable th = th;
        r19 = r22;
    L38:
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.a(r19, null, 1, null);
        InlineMarker.finallyEnd(1);
        throw th;
    L27:
        if (((Boolean) r15).booleanValue() == false) goto L29;
        r11.invoke((Object) r18.next());     // Catch: Throwable -> L32
        ReceiveChannel<E> r25 = r22;
        r13 = r24;
        r16 = r23;
    L42:
        r13.L$0 = r11;     // Catch: Throwable -> L34
        r13.L$1 = r25;     // Catch: Throwable -> L34
        r13.L$2 = r18;     // Catch: Throwable -> L34
        r13.label = 1;     // Catch: Throwable -> L34
        Object r26 = r18.a(r13);     // Catch: Throwable -> L34
        if (r26 != r16) goto L25;
        return r16;
    L25:
        r21 = r13;
        r22 = r25;
        r15 = r26;
    L34:
        th = th;
        r19 = r25;
        goto L38
    L29:
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L32
        InlineMarker.finallyStart(1);
        ReceiveChannel.DefaultImpls.a(r22, null, 1, null);
        InlineMarker.finallyEnd(1);
        return r27;
    L15:
        th = th;
        goto L38
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ResultKt.throwOnFailure(r15);
        ReceiveChannel<E> r28 = r10.x();
        r25 = r28;
        r18 = r28.iterator();     // Catch: Throwable -> L36
    L36:
        th = move-exception;
        r19 = r28;
        th = th;
    L7:
        r13 = new ChannelsKt__Channels_commonKt$consumeEach$3(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    public static final <E> Object c(ReceiveChannel<? extends E> r10, Function1<? super E, Unit> r11, Continuation<? super Unit> r12) {
        if ((r12 instanceof ChannelsKt__Channels_commonKt$consumeEach$1) == false) goto L7;
        ChannelsKt__Channels_commonKt$consumeEach$1 r13 = (ChannelsKt__Channels_commonKt$consumeEach$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        ChannelIterator r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel<? extends E> r19 = (ReceiveChannel) r13.L$1;
        Function1<? super E, Unit> r20 = (Function1) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L28;
        r20.invoke((Object) r18.next());     // Catch: Throwable -> L14
        Function1<? super E, Unit> r21 = r20;
    L21:
        r13.L$0 = r21;     // Catch: Throwable -> L14
        r13.L$1 = r19;     // Catch: Throwable -> L14
        r13.L$2 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r22 = r18.a(r13);     // Catch: Throwable -> L14
        if (r22 != r16) goto L24;
        return r16;
    L24:
        r20 = r21;
        r15 = r22;
        goto L26
    L28:
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L14
        InlineMarker.finallyStart(1);
        i.b(r19, null);
        InlineMarker.finallyEnd(1);
        return r23;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        InlineMarker.finallyStart(1);
        i.b(r19, th);
        InlineMarker.finallyEnd(1);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L31
        r21 = r11;
    L31:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__Channels_commonKt$consumeEach$1(r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please report as a decompilation issue!!! */
    public static final <E> Object d(ReceiveChannel<? extends E> r10, Continuation<? super List<? extends E>> r11) {
        if ((r11 instanceof ChannelsKt__Channels_commonKt$toList$1) == false) goto L7;
        ChannelsKt__Channels_commonKt$toList$1 r12 = (ChannelsKt__Channels_commonKt$toList$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$3;
        ReceiveChannel<? extends E> r18 = (ReceiveChannel) r12.L$2;
        List r19 = (List) r12.L$1;
        List r20 = (List) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
        ?? r21 = r19;
        List r22 = r20;
    L27:
        if (((Boolean) r14).booleanValue() == false) goto L29;
        r21.add(r17.next());     // Catch: Throwable -> L14
        ReceiveChannel<? extends E> r23 = r18;
        ?? r24 = r21;
        List r25 = r22;
    L40:
        r12.L$0 = r25;     // Catch: Throwable -> L32
        r12.L$1 = r24;     // Catch: Throwable -> L32
        r12.L$2 = r23;     // Catch: Throwable -> L32
        r12.L$3 = r17;     // Catch: Throwable -> L32
        r12.label = 1;     // Catch: Throwable -> L32
        Object r26 = r17.a(r12);     // Catch: Throwable -> L32
        if (r26 != r15) goto L24;
        return r15;
    L24:
        r18 = r23;
        r14 = r26;
        r21 = r24;
        r22 = r25;
    L32:
        Throwable th = th;
    L46:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        i.b(r23, th);
        throw th;
    L29:
        Unit r27 = Unit.INSTANCE;     // Catch: Throwable -> L14
        i.b(r18, null);
        return CollectionsKt.build(r22);
    L14:
        th = th;
        r23 = r18;
        goto L46
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        List r28 = CollectionsKt.createListBuilder();
        List r29 = r28;
        r25 = r29;
        r23 = r10;
        r17 = r10.iterator();     // Catch: Throwable -> L34
        r24 = r29;
    L34:
        th = move-exception;
        r23 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__Channels_commonKt$toList$1(r11);
        goto L8
    }
}
