package kotlinx.coroutines.channels;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Pair;
import kotlin.PublishedApi;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.SourceDebugExtension;

/* JADX INFO: loaded from: classes3.dex */
@SourceDebugExtension({"SMAP\nDeprecated.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n+ 2 Channels.common.kt\nkotlinx/coroutines/channels/ChannelsKt__Channels_commonKt\n*L\n1#1,479:1\n82#2,11:480\n82#2,11:491\n82#2,11:502\n82#2,11:513\n105#2:524\n82#2,6:525\n106#2:531\n92#2:532\n107#2:533\n88#2,3:534\n82#2,11:537\n105#2:548\n82#2,6:549\n106#2,2:555\n92#2:557\n88#2,3:558\n82#2,11:561\n82#2,11:572\n82#2,11:583\n105#2:594\n82#2,6:595\n106#2,2:601\n92#2:603\n88#2,3:604\n105#2:607\n82#2,6:608\n106#2,2:614\n92#2:616\n88#2,3:617\n105#2:620\n82#2,6:621\n106#2,2:627\n92#2:629\n88#2,3:630\n105#2:633\n82#2,6:634\n106#2,2:640\n92#2:642\n88#2,3:643\n105#2:646\n82#2,6:647\n106#2,2:653\n92#2:655\n88#2,3:656\n82#2,11:659\n105#2:670\n82#2,6:671\n106#2,2:677\n92#2:679\n88#2,3:680\n82#2,11:683\n82#2,11:694\n82#2,11:705\n*S KotlinDebug\n*F\n+ 1 Deprecated.kt\nkotlinx/coroutines/channels/ChannelsKt__DeprecatedKt\n*L\n34#1:480,11\n49#1:491,11\n63#1:502,11\n73#1:513,11\n84#1:524\n84#1:525,6\n84#1:531\n84#1:532\n84#1:533\n84#1:534,3\n95#1:537,11\n110#1:548\n110#1:549,6\n110#1:555,2\n110#1:557\n110#1:558,3\n121#1:561,11\n134#1:572,11\n147#1:583,11\n232#1:594\n232#1:595,6\n232#1:601,2\n232#1:603\n232#1:604,3\n241#1:607\n241#1:608,6\n241#1:614,2\n241#1:616\n241#1:617,3\n277#1:620\n277#1:621,6\n277#1:627,2\n277#1:629\n277#1:630,3\n285#1:633\n285#1:634,6\n285#1:640,2\n285#1:642\n285#1:643,3\n298#1:646\n298#1:647,6\n298#1:653,2\n298#1:655\n298#1:656,3\n403#1:659,11\n411#1:670\n411#1:671,6\n411#1:677,2\n411#1:679\n411#1:680,3\n418#1:683,11\n432#1:694,11\n446#1:705,11\n*E\n"})
final /* synthetic */ class ChannelsKt__DeprecatedKt {
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object a(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$any$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$any$1 r12 = (ChannelsKt__DeprecatedKt$any$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L16;
        if (r16 != 1) goto L15;
        r10 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L20:
        i.b(r10, null);
        return r14;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r17 = r10.iterator();     // Catch: Throwable -> L22
        r12.L$0 = r10;     // Catch: Throwable -> L22
        r12.label = 1;     // Catch: Throwable -> L22
        r14 = r17.a(r12);     // Catch: Throwable -> L22
        if (r14 != r15) goto L20;
        return r15;
    L22:
        th = move-exception;
        throw th;     // Catch: Throwable -> L24
    L24:
        th = move-exception;
        i.b(r10, th);
        throw th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$any$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x005d -> B:25:0x0060). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object b(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$count$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$count$1 r12 = (ChannelsKt__DeprecatedKt$count$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$2;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$1;
        Ref.IntRef r19 = (Ref.IntRef) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L27:
        if (((Boolean) r14).booleanValue() == false) goto L29;
        r17.next();     // Catch: Throwable -> L14
        r19.element++;     // Catch: Throwable -> L14
        ReceiveChannel r20 = r18;
    L46:
        r12.L$0 = r19;     // Catch: Throwable -> L32
        r12.L$1 = r20;     // Catch: Throwable -> L32
        r12.L$2 = r17;     // Catch: Throwable -> L32
        r12.label = 1;     // Catch: Throwable -> L32
        Object r21 = r17.a(r12);     // Catch: Throwable -> L32
        if (r21 != r15) goto L24;
        return r15;
    L24:
        r18 = r20;
        r14 = r21;
    L32:
        Throwable th = th;
        r18 = r20;
    L44:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        i.b(r18, th);
        throw th;
    L29:
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L14
        i.b(r18, null);
        return Boxing.boxInt(r19.element);
    L14:
        th = th;
        goto L44
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        r19 = new Ref.IntRef();
        r20 = r10;
        r17 = r10.iterator();     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        r18 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$count$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x005f -> B:26:0x0063). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object c(ReceiveChannel r10, int r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$elementAt$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAt$1 r13 = (ChannelsKt__DeprecatedKt$elementAt$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        int r18 = r13.I$1;
        r11 = r13.I$0;
        ChannelIterator r19 = (ChannelIterator) r13.L$1;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L28:
        if (((Boolean) r15).booleanValue() == false) goto L36;
        Object r110 = r19.next();     // Catch: Throwable -> L14
        int r21 = r18 + 1;
        if (r11 != r18) goto L34;
        i.b(r20, null);
        return r110;
    L34:
        r10 = r20;
        int r111 = r21;
    L22:
        r13.L$0 = r10;     // Catch: Throwable -> L37
        r13.L$1 = r19;     // Catch: Throwable -> L37
        r13.I$0 = r11;     // Catch: Throwable -> L37
        r13.I$1 = r111;     // Catch: Throwable -> L37
        r13.label = 1;     // Catch: Throwable -> L37
        Object r22 = r19.a(r13);     // Catch: Throwable -> L37
        if (r22 != r16) goto L25;
        return r16;
    L25:
        r20 = r10;
        r18 = r111;
        r15 = r22;
        goto L28
    L36:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r11 + '.');     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        i.b(r20, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        if (r11 < 0) goto L40;
        r111 = 0;
        r19 = r10.iterator();     // Catch: Throwable -> L37
        goto L22
    L40:
        throw new IndexOutOfBoundsException("ReceiveChannel doesn't contain element at index " + r11 + '.');     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        r20 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$elementAt$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0060 -> B:27:0x0063). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object d(ReceiveChannel r10, int r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$elementAtOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$elementAtOrNull$1 r13 = (ChannelsKt__DeprecatedKt$elementAtOrNull$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        int r18 = r13.I$1;
        r11 = r13.I$0;
        ChannelIterator r19 = (ChannelIterator) r13.L$1;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
        int r110 = r18;
        r10 = r20;
        Object r21 = r15;
    L27:
        if (((Boolean) r21).booleanValue() == false) goto L35;
        Object r22 = r19.next();     // Catch: Throwable -> L37
        int r23 = r110 + 1;
        if (r11 != r110) goto L34;
        i.b(r10, null);
        return r22;
    L34:
        r110 = r23;
    L24:
        r13.L$0 = r10;     // Catch: Throwable -> L37
        r13.L$1 = r19;     // Catch: Throwable -> L37
        r13.I$0 = r11;     // Catch: Throwable -> L37
        r13.I$1 = r110;     // Catch: Throwable -> L37
        r13.label = 1;     // Catch: Throwable -> L37
        r21 = r19.a(r13);     // Catch: Throwable -> L37
        if (r21 != r16) goto L27;
        return r16;
    L35:
        i.b(r10, null);
        return null;
    L37:
        th = move-exception;
        r20 = r10;
        Throwable th = th;
    L43:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        i.b(r20, th);
        throw th;
    L14:
        th = th;
        goto L43
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        if (r11 >= 0) goto L22;
        i.b(r10, null);
        return null;
    L22:
        r110 = 0;
        r19 = r10.iterator();     // Catch: Throwable -> L37
    L7:
        r13 = new ChannelsKt__DeprecatedKt$elementAtOrNull$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object e(ReceiveChannel r10, Collection r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$1 r13 = (ChannelsKt__DeprecatedKt$filterNotNullTo$1) r12;
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
        ReceiveChannel r19 = (ReceiveChannel) r13.L$1;
        Collection r20 = (Collection) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L31;
        Object r21 = r18.next();     // Catch: Throwable -> L14
        if (r21 == null) goto L30;
        r20.add(r21);     // Catch: Throwable -> L14
    L30:
        Collection r22 = r20;
    L21:
        r13.L$0 = r22;     // Catch: Throwable -> L14
        r13.L$1 = r19;     // Catch: Throwable -> L14
        r13.L$2 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r23 = r18.a(r13);     // Catch: Throwable -> L14
        if (r23 != r16) goto L24;
        return r16;
    L24:
        r20 = r22;
        r15 = r23;
        goto L26
    L31:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L14
        i.b(r19, null);
        return r20;
    L14:
        Throwable th = th;
    L44:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        i.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L34
        r22 = r11;
    L34:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$filterNotNullTo$1(r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r7v10 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v3 */
    /* JADX WARN: Type inference failed for: r7v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v0, types: [kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v15 */
    /* JADX WARN: Type inference failed for: r8v16 */
    /* JADX WARN: Type inference failed for: r8v17 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v19 */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v7 */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Type inference failed for: r8v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x007a -> B:36:0x008b). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x0088 -> B:36:0x008b). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object f(ReceiveChannel r10, n r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$filterNotNullTo$3) == false) goto L7;
        ChannelsKt__DeprecatedKt$filterNotNullTo$3 r13 = (ChannelsKt__DeprecatedKt$filterNotNullTo$3) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L22;
        if (r17 == 1) goto L17;
        if (r17 != 2) goto L16;
        ChannelIterator r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$1;
        n r20 = (n) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        ?? r21 = r20;
        ?? r22 = r19;
    L36:
        ChannelIterator r23 = r18;
        r10 = r22;
        ?? r24 = r21;
    L24:
        r13.L$0 = r24;     // Catch: Throwable -> L40
        r13.L$1 = r10;     // Catch: Throwable -> L40
        r13.L$2 = r23;     // Catch: Throwable -> L40
        r13.label = 1;     // Catch: Throwable -> L40
        Object r25 = r23.a(r13);     // Catch: Throwable -> L40
        if (r25 != r16) goto L27;
        return r16;
    L27:
        ?? r26 = r24;
        r11 = r10;
        r18 = r23;
        r15 = r25;
        ?? r27 = r26;
    L30:
        if (((Boolean) r15).booleanValue() == false) goto L37;
        Object r28 = r18.next();     // Catch: Throwable -> L20
        r21 = r27;
        r22 = r11;
        if (r28 == null) goto L36;
        r13.L$0 = r27;     // Catch: Throwable -> L20
        r13.L$1 = r11;     // Catch: Throwable -> L20
        r13.L$2 = r18;     // Catch: Throwable -> L20
        r13.label = 2;     // Catch: Throwable -> L20
        Object r29 = r27.H(r28, r13);     // Catch: Throwable -> L20
        r21 = r27;
        r22 = r11;
        if (r29 != r16) goto L36;
        return r16;
    L37:
        Unit r30 = Unit.INSTANCE;     // Catch: Throwable -> L20
        i.b(r11, null);
        return r27;
    L40:
        th = move-exception;
        r11 = r10;
        th = th;
    L50:
        throw th;     // Catch: Throwable -> L43
    L43:
        th = move-exception;
        i.b(r11, th);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r18 = (ChannelIterator) r13.L$2;
        ReceiveChannel r31 = (ReceiveChannel) r13.L$1;
        n r32 = (n) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        r27 = r32;
        r11 = r31;
        goto L30
    L22:
        ResultKt.throwOnFailure(r15);
        r23 = r10.iterator();     // Catch: Throwable -> L40
        r10 = r10;
        r24 = r11;
    L20:
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$filterNotNullTo$3(r12);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object g(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$first$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$first$1 r12 = (ChannelsKt__DeprecatedKt$first$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L25:
        if (((Boolean) r14).booleanValue() == false) goto L30;
        Object r19 = r17.next();     // Catch: Throwable -> L14
        i.b(r18, null);
        return r19;
    L30:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L14
    L14:
        Throwable th = th;
    L37:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        i.b(r18, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r20 = r10.iterator();     // Catch: Throwable -> L31
        r12.L$0 = r10;     // Catch: Throwable -> L31
        r12.L$1 = r20;     // Catch: Throwable -> L31
        r12.label = 1;     // Catch: Throwable -> L31
        Object r21 = r20.a(r12);     // Catch: Throwable -> L31
        if (r21 != r15) goto L22;
        return r15;
    L22:
        r18 = r10;
        r17 = r20;
        r14 = r21;
    L31:
        th = move-exception;
        r18 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$first$1(r11);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object h(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$firstOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$firstOrNull$1 r12 = (ChannelsKt__DeprecatedKt$firstOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L18;
        if (r16 != 1) goto L17;
        ChannelIterator r17 = (ChannelIterator) r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L14
    L25:
        if (((Boolean) r14).booleanValue() == true) goto L28;
        i.b(r18, null);
        return null;
    L28:
        Object r19 = r17.next();     // Catch: Throwable -> L14
        i.b(r18, null);
        return r19;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        i.b(r18, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r20 = r10.iterator();     // Catch: Throwable -> L31
        r12.L$0 = r10;     // Catch: Throwable -> L31
        r12.L$1 = r20;     // Catch: Throwable -> L31
        r12.label = 1;     // Catch: Throwable -> L31
        Object r21 = r20.a(r12);     // Catch: Throwable -> L31
        if (r21 != r15) goto L22;
        return r15;
    L22:
        r18 = r10;
        r17 = r20;
        r14 = r21;
    L31:
        th = move-exception;
        r18 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$firstOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0064 -> B:25:0x0067). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object i(ReceiveChannel r10, Object r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$indexOf$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$indexOf$1 r13 = (ChannelsKt__DeprecatedKt$indexOf$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        ChannelIterator r18 = (ChannelIterator) r13.L$3;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$2;
        Ref.IntRef r20 = (Ref.IntRef) r13.L$1;
        Object r21 = r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == true) goto L28;
        Unit r22 = Unit.INSTANCE;     // Catch: Throwable -> L14
        i.b(r19, null);
        return Boxing.boxInt(-1);
    L28:
        if (Intrinsics.areEqual(r21, r18.next()) == false) goto L32;
        Integer r23 = Boxing.boxInt(r20.element);     // Catch: Throwable -> L14
        i.b(r19, null);
        return r23;
    L32:
        r20.element++;     // Catch: Throwable -> L14
        Object r24 = r21;
    L21:
        r13.L$0 = r24;     // Catch: Throwable -> L14
        r13.L$1 = r20;     // Catch: Throwable -> L14
        r13.L$2 = r19;     // Catch: Throwable -> L14
        r13.L$3 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r25 = r18.a(r13);     // Catch: Throwable -> L14
        if (r25 != r16) goto L24;
        return r16;
    L24:
        r21 = r24;
        r15 = r25;
    L14:
        Throwable th = th;
    L45:
        throw th;     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        i.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        Ref.IntRef r26 = new Ref.IntRef();
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L36
        r20 = r26;
        r24 = r11;
    L36:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$indexOf$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:36:0x0086 -> B:37:0x008a). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object j(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$last$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$last$1 r12 = (ChannelsKt__DeprecatedKt$last$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$2;
        ChannelIterator r18 = (ChannelIterator) r12.L$1;
        ReceiveChannel r19 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L38:
        if (((Boolean) r14).booleanValue() == false) goto L42;
        Object r20 = r18.next();     // Catch: Throwable -> L15
        r10 = r19;
    L33:
        r12.L$0 = r10;     // Catch: Throwable -> L46
        r12.L$1 = r18;     // Catch: Throwable -> L46
        r12.L$2 = r20;     // Catch: Throwable -> L46
        r12.label = 2;     // Catch: Throwable -> L46
        Object r21 = r18.a(r12);     // Catch: Throwable -> L46
        if (r21 != r15) goto L36;
        return r15;
    L36:
        r19 = r10;
        r17 = r20;
        r14 = r21;
    L46:
        th = move-exception;
        ReceiveChannel r22 = r10;
        th = th;
    L56:
        throw th;     // Catch: Throwable -> L49
    L49:
        th = move-exception;
        i.b(r22, th);
        throw th;
    L42:
        i.b(r19, null);
        return r17;
    L15:
        th = th;
        r22 = r19;
        goto L56
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r23 = (ChannelIterator) r12.L$1;
        r22 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == false) goto L45;
        r20 = r23.next();     // Catch: Throwable -> L22
        ReceiveChannel r24 = r22;
        r18 = r23;
        r10 = r24;
        goto L33
    L45:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L56
    L24:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r25 = r10.iterator();     // Catch: Throwable -> L46
        r12.L$0 = r10;     // Catch: Throwable -> L46
        r12.L$1 = r25;     // Catch: Throwable -> L46
        r12.label = 1;     // Catch: Throwable -> L46
        Object r26 = r25.a(r12);     // Catch: Throwable -> L46
        if (r26 != r15) goto L28;
        return r15;
    L28:
        r22 = r10;
        r23 = r25;
        r14 = r26;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$last$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0072 -> B:25:0x0075). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object k(ReceiveChannel r10, Object r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$lastIndexOf$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastIndexOf$1 r13 = (ChannelsKt__DeprecatedKt$lastIndexOf$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L18;
        if (r17 != 1) goto L17;
        ChannelIterator r18 = (ChannelIterator) r13.L$4;
        ReceiveChannel r19 = (ReceiveChannel) r13.L$3;
        Ref.IntRef r20 = (Ref.IntRef) r13.L$2;
        Ref.IntRef r21 = (Ref.IntRef) r13.L$1;
        Object r22 = r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
    L26:
        if (((Boolean) r15).booleanValue() == true) goto L28;
        Unit r23 = Unit.INSTANCE;     // Catch: Throwable -> L14
        i.b(r19, null);
        return Boxing.boxInt(r21.element);
    L28:
        if (Intrinsics.areEqual(r22, r18.next()) == false) goto L30;
        r21.element = r20.element;     // Catch: Throwable -> L14
    L30:
        r20.element++;     // Catch: Throwable -> L14
        Object r110 = r22;
    L21:
        r13.L$0 = r110;     // Catch: Throwable -> L14
        r13.L$1 = r21;     // Catch: Throwable -> L14
        r13.L$2 = r20;     // Catch: Throwable -> L14
        r13.L$3 = r19;     // Catch: Throwable -> L14
        r13.L$4 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r24 = r18.a(r13);     // Catch: Throwable -> L14
        if (r24 != r16) goto L24;
        return r16;
    L24:
        r22 = r110;
        r15 = r24;
    L14:
        Throwable th = th;
    L40:
        throw th;     // Catch: Throwable -> L37
    L37:
        th = move-exception;
        i.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        Ref.IntRef r111 = new Ref.IntRef();
        r111.element = -1;
        r20 = new Ref.IntRef();
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L34
        r21 = r111;
        r110 = r11;
    L34:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$lastIndexOf$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x008b -> B:39:0x008f). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object l(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$lastOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$lastOrNull$1 r12 = (ChannelsKt__DeprecatedKt$lastOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$2;
        ChannelIterator r18 = (ChannelIterator) r12.L$1;
        ReceiveChannel r19 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L39:
        if (((Boolean) r14).booleanValue() == false) goto L43;
        Object r20 = r18.next();     // Catch: Throwable -> L15
        r10 = r19;
    L35:
        r12.L$0 = r10;     // Catch: Throwable -> L45
        r12.L$1 = r18;     // Catch: Throwable -> L45
        r12.L$2 = r20;     // Catch: Throwable -> L45
        r12.label = 2;     // Catch: Throwable -> L45
        Object r21 = r18.a(r12);     // Catch: Throwable -> L45
        if (r21 != r15) goto L38;
        return r15;
    L38:
        r19 = r10;
        r17 = r20;
        r14 = r21;
    L45:
        th = move-exception;
        ReceiveChannel r22 = r10;
        th = th;
    L53:
        throw th;     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        i.b(r22, th);
        throw th;
    L43:
        i.b(r19, null);
        return r17;
    L15:
        th = th;
        r22 = r19;
        goto L53
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r23 = (ChannelIterator) r12.L$1;
        r22 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == true) goto L33;
        i.b(r22, null);
        return null;
    L33:
        r20 = r23.next();     // Catch: Throwable -> L22
        ReceiveChannel r24 = r22;
        r18 = r23;
        r10 = r24;
    L22:
        th = th;
        goto L53
    L24:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r25 = r10.iterator();     // Catch: Throwable -> L45
        r12.L$0 = r10;     // Catch: Throwable -> L45
        r12.L$1 = r25;     // Catch: Throwable -> L45
        r12.label = 1;     // Catch: Throwable -> L45
        Object r26 = r25.a(r12);     // Catch: Throwable -> L45
        if (r26 != r15) goto L28;
        return r15;
    L28:
        r22 = r10;
        r23 = r25;
        r14 = r26;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$lastOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a0 -> B:15:0x003d). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object m(ReceiveChannel r10, Comparator r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$maxWith$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$maxWith$1 r13 = (ChannelsKt__DeprecatedKt$maxWith$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L25;
        if (r17 == 1) goto L20;
        if (r17 != 2) goto L19;
        Object r18 = r13.L$3;
        ChannelIterator r19 = (ChannelIterator) r13.L$2;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$1;
        Comparator r21 = (Comparator) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L16
        ChannelsKt__DeprecatedKt$maxWith$1 r22 = r13;
        Object r23 = r18;
        r10 = r20;
    L15:
        Object r24 = r16;
        ChannelsKt__DeprecatedKt$maxWith$1 r25 = r22;
        if (((Boolean) r15).booleanValue() == false) goto L47;
        Object r110 = r19.next();     // Catch: Throwable -> L49
        if (r21.compare(r23, r110) < 0) goto L46;
        r110 = r23;
    L46:
        r13 = r25;
        r16 = r24;
    L36:
        r13.L$0 = r21;     // Catch: Throwable -> L49
        r13.L$1 = r10;     // Catch: Throwable -> L49
        r13.L$2 = r19;     // Catch: Throwable -> L49
        r13.L$3 = r110;     // Catch: Throwable -> L49
        r13.label = 2;     // Catch: Throwable -> L49
        Object r26 = r19.a(r13);     // Catch: Throwable -> L49
        if (r26 != r16) goto L39;
        return r16;
    L39:
        r22 = r13;
        r23 = r110;
        r15 = r26;
        goto L15
    L47:
        i.b(r10, null);
        return r23;
    L49:
        th = move-exception;
        ReceiveChannel r27 = r10;
        th = th;
    L57:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        i.b(r27, th);
        throw th;
    L16:
        th = th;
        r27 = r20;
        goto L57
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r28 = (ChannelIterator) r13.L$2;
        r27 = (ReceiveChannel) r13.L$1;
        Comparator r29 = (Comparator) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r15).booleanValue() == true) goto L34;
        i.b(r27, null);
        return null;
    L34:
        r110 = r28.next();     // Catch: Throwable -> L23
        r21 = r29;
        ReceiveChannel r30 = r27;
        r19 = r28;
        r10 = r30;
    L23:
        th = th;
        goto L57
    L25:
        ResultKt.throwOnFailure(r15);
        ChannelIterator r111 = r10.iterator();     // Catch: Throwable -> L49
        r13.L$0 = r11;     // Catch: Throwable -> L49
        r13.L$1 = r10;     // Catch: Throwable -> L49
        r13.L$2 = r111;     // Catch: Throwable -> L49
        r13.label = 1;     // Catch: Throwable -> L49
        Object r31 = r111.a(r13);     // Catch: Throwable -> L49
        if (r31 != r16) goto L29;
        return r16;
    L29:
        r27 = r10;
        r28 = r111;
        r15 = r31;
        r29 = r11;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$maxWith$1(r12);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:39:0x00a0 -> B:15:0x003d). Please report as a decompilation issue!!! */
    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object n(ReceiveChannel r10, Comparator r11, Continuation r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$minWith$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$minWith$1 r13 = (ChannelsKt__DeprecatedKt$minWith$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L25;
        if (r17 == 1) goto L20;
        if (r17 != 2) goto L19;
        Object r18 = r13.L$3;
        ChannelIterator r19 = (ChannelIterator) r13.L$2;
        ReceiveChannel r20 = (ReceiveChannel) r13.L$1;
        Comparator r21 = (Comparator) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L16
        ChannelsKt__DeprecatedKt$minWith$1 r22 = r13;
        Object r23 = r18;
        r10 = r20;
    L15:
        Object r24 = r16;
        ChannelsKt__DeprecatedKt$minWith$1 r25 = r22;
        if (((Boolean) r15).booleanValue() == false) goto L47;
        Object r110 = r19.next();     // Catch: Throwable -> L49
        if (r21.compare(r23, r110) > 0) goto L46;
        r110 = r23;
    L46:
        r13 = r25;
        r16 = r24;
    L36:
        r13.L$0 = r21;     // Catch: Throwable -> L49
        r13.L$1 = r10;     // Catch: Throwable -> L49
        r13.L$2 = r19;     // Catch: Throwable -> L49
        r13.L$3 = r110;     // Catch: Throwable -> L49
        r13.label = 2;     // Catch: Throwable -> L49
        Object r26 = r19.a(r13);     // Catch: Throwable -> L49
        if (r26 != r16) goto L39;
        return r16;
    L39:
        r22 = r13;
        r23 = r110;
        r15 = r26;
        goto L15
    L47:
        i.b(r10, null);
        return r23;
    L49:
        th = move-exception;
        ReceiveChannel r27 = r10;
        th = th;
    L57:
        throw th;     // Catch: Throwable -> L52
    L52:
        th = move-exception;
        i.b(r27, th);
        throw th;
    L16:
        th = th;
        r27 = r20;
        goto L57
    L19:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L20:
        ChannelIterator r28 = (ChannelIterator) r13.L$2;
        r27 = (ReceiveChannel) r13.L$1;
        Comparator r29 = (Comparator) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L23
    L31:
        if (((Boolean) r15).booleanValue() == true) goto L34;
        i.b(r27, null);
        return null;
    L34:
        r110 = r28.next();     // Catch: Throwable -> L23
        r21 = r29;
        ReceiveChannel r30 = r27;
        r19 = r28;
        r10 = r30;
    L23:
        th = th;
        goto L57
    L25:
        ResultKt.throwOnFailure(r15);
        ChannelIterator r111 = r10.iterator();     // Catch: Throwable -> L49
        r13.L$0 = r11;     // Catch: Throwable -> L49
        r13.L$1 = r10;     // Catch: Throwable -> L49
        r13.L$2 = r111;     // Catch: Throwable -> L49
        r13.label = 1;     // Catch: Throwable -> L49
        Object r31 = r111.a(r13);     // Catch: Throwable -> L49
        if (r31 != r16) goto L29;
        return r16;
    L29:
        r27 = r10;
        r28 = r111;
        r15 = r31;
        r29 = r11;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$minWith$1(r12);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object o(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$none$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$none$1 r12 = (ChannelsKt__DeprecatedKt$none$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        boolean r17 = true;
        if (r16 == 0) goto L16;
        if (r16 != 1) goto L15;
        r10 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L27
    L21:
        if (((Boolean) r14).booleanValue() == false) goto L24;
        r17 = false;
    L24:
        Boolean r18 = Boxing.boxBoolean(r17);     // Catch: Throwable -> L27
        i.b(r10, null);
        return r18;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r19 = r10.iterator();     // Catch: Throwable -> L27
        r12.L$0 = r10;     // Catch: Throwable -> L27
        r12.label = 1;     // Catch: Throwable -> L27
        r14 = r19.a(r12);     // Catch: Throwable -> L27
        if (r14 != r15) goto L21;
        return r15;
    L27:
        th = move-exception;
        throw th;     // Catch: Throwable -> L29
    L29:
        th = move-exception;
        i.b(r10, th);
        throw th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$none$1(r11);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object p(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$single$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$single$1 r12 = (ChannelsKt__DeprecatedKt$single$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L37:
        if (((Boolean) r14).booleanValue() == true) goto L41;
        i.b(r18, null);
        return r17;
    L41:
        throw new IllegalArgumentException("ReceiveChannel has more than one element.");     // Catch: Throwable -> L15
    L15:
        Throwable th = th;
        ReceiveChannel r19 = r18;
    L50:
        throw th;     // Catch: Throwable -> L47
    L47:
        th = move-exception;
        i.b(r19, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r20 = (ChannelIterator) r12.L$1;
        r19 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == false) goto L43;
        Object r21 = r20.next();     // Catch: Throwable -> L22
        r12.L$0 = r19;     // Catch: Throwable -> L22
        r12.L$1 = r21;     // Catch: Throwable -> L22
        r12.label = 2;     // Catch: Throwable -> L22
        Object r22 = r20.a(r12);     // Catch: Throwable -> L22
        if (r22 != r15) goto L34;
        return r15;
    L34:
        r18 = r19;
        r14 = r22;
        r17 = r21;
        goto L37
    L43:
        throw new NoSuchElementException("ReceiveChannel is empty.");     // Catch: Throwable -> L22
    L22:
        th = th;
        goto L50
    L24:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r23 = r10.iterator();     // Catch: Throwable -> L44
        r12.L$0 = r10;     // Catch: Throwable -> L44
        r12.L$1 = r23;     // Catch: Throwable -> L44
        r12.label = 1;     // Catch: Throwable -> L44
        Object r24 = r23.a(r12);     // Catch: Throwable -> L44
        if (r24 != r15) goto L28;
        return r15;
    L28:
        r19 = r10;
        r20 = r23;
        r14 = r24;
    L44:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$single$1(r11);
        goto L8
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Binary compatibility")
    public static final /* synthetic */ Object q(ReceiveChannel r10, Continuation r11) {
        if ((r11 instanceof ChannelsKt__DeprecatedKt$singleOrNull$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$singleOrNull$1 r12 = (ChannelsKt__DeprecatedKt$singleOrNull$1) r11;
        int r13 = r12.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r12.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r12.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r12.label;
        if (r16 == 0) goto L24;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        Object r17 = r12.L$1;
        ReceiveChannel r18 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
    L37:
        boolean r19 = ((Boolean) r14).booleanValue();     // Catch: Throwable -> L15
        i.b(r18, null);
        if (r19 == false) goto L41;
        return null;
    L41:
        return r17;
    L15:
        Throwable th = th;
        ReceiveChannel r20 = r18;
    L52:
        throw th;     // Catch: Throwable -> L45
    L45:
        th = move-exception;
        i.b(r20, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        ChannelIterator r21 = (ChannelIterator) r12.L$1;
        r20 = (ReceiveChannel) r12.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L22
    L30:
        if (((Boolean) r14).booleanValue() == true) goto L33;
        i.b(r20, null);
        return null;
    L33:
        Object r22 = r21.next();     // Catch: Throwable -> L22
        r12.L$0 = r20;     // Catch: Throwable -> L22
        r12.L$1 = r22;     // Catch: Throwable -> L22
        r12.label = 2;     // Catch: Throwable -> L22
        Object r23 = r21.a(r12);     // Catch: Throwable -> L22
        if (r23 != r15) goto L36;
        return r15;
    L36:
        r18 = r20;
        r14 = r23;
        r17 = r22;
    L22:
        th = th;
        goto L52
    L24:
        ResultKt.throwOnFailure(r14);
        ChannelIterator r24 = r10.iterator();     // Catch: Throwable -> L42
        r12.L$0 = r10;     // Catch: Throwable -> L42
        r12.L$1 = r24;     // Catch: Throwable -> L42
        r12.label = 1;     // Catch: Throwable -> L42
        Object r25 = r24.a(r12);     // Catch: Throwable -> L42
        if (r25 != r15) goto L28;
        return r15;
    L28:
        r20 = r10;
        r21 = r24;
        r14 = r25;
    L42:
        th = move-exception;
        r20 = r10;
        th = th;
    L7:
        r12 = new ChannelsKt__DeprecatedKt$singleOrNull$1(r11);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.n] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r8v0, types: [C extends kotlinx.coroutines.channels.n<? super E>] */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v18 */
    /* JADX WARN: Type inference failed for: r8v2, types: [kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v21 */
    /* JADX WARN: Type inference failed for: r8v22 */
    /* JADX WARN: Type inference failed for: r8v23 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v25 */
    /* JADX WARN: Type inference failed for: r8v26 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object, kotlinx.coroutines.channels.ReceiveChannel] */
    /* JADX WARN: Type inference failed for: r8v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r8v8 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:32:0x0089 -> B:14:0x0037). Please report as a decompilation issue!!! */
    @PublishedApi
    public static final <E, C extends n<? super E>> Object r(ReceiveChannel<? extends E> r10, C r11, Continuation<? super C> r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$toChannel$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$toChannel$1 r13 = (ChannelsKt__DeprecatedKt$toChannel$1) r12;
        int r14 = r13.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r13.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r13.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r13.label;
        if (r17 == 0) goto L22;
        if (r17 == 1) goto L17;
        if (r17 != 2) goto L16;
        ChannelIterator<? extends E> r18 = (ChannelIterator) r13.L$2;
        boolean r19 = (C) ((ReceiveChannel) r13.L$1);
        n r20 = (n) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        ?? r21 = r20;
        ?? r22 = r19;
    L14:
        ChannelIterator<? extends E> r23 = r18;
        r10 = (ReceiveChannel<? extends E>) r22;
        ?? r24 = (C) r21;
    L24:
        r13.L$0 = r24;     // Catch: Throwable -> L37
        r13.L$1 = r10;     // Catch: Throwable -> L37
        r13.L$2 = r23;     // Catch: Throwable -> L37
        r13.label = 1;     // Catch: Throwable -> L37
        Object r25 = r23.a(r13);     // Catch: Throwable -> L37
        if (r25 != r16) goto L27;
        return r16;
    L27:
        ?? r26 = r24;
        boolean r27 = (C) r10;
        r18 = r23;
        r15 = r25;
        ?? r28 = r26;
        r11 = r27;
    L30:
        if (((Boolean) r15).booleanValue() == false) goto L34;
        E r29 = r18.next();     // Catch: Throwable -> L20
        r13.L$0 = r28;     // Catch: Throwable -> L20
        r13.L$1 = (Object) r11;     // Catch: Throwable -> L20
        r13.L$2 = r18;     // Catch: Throwable -> L20
        r13.label = 2;     // Catch: Throwable -> L20
        Object r30 = r28.H(r29, r13);     // Catch: Throwable -> L20
        r21 = r28;
        r22 = r11;
        if (r30 != r16) goto L14;
        return r16;
    L34:
        Unit r31 = Unit.INSTANCE;     // Catch: Throwable -> L20
        i.b((ReceiveChannel) r11, null);
        return r28;
    L37:
        th = move-exception;
        r11 = r10;
        th = th;
    L47:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        i.b(r11, th);
        throw th;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r18 = (ChannelIterator) r13.L$2;
        boolean r32 = (C) ((ReceiveChannel) r13.L$1);
        n r33 = (n) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L20
        r28 = r33;
        r11 = r32;
        goto L30
    L22:
        ResultKt.throwOnFailure(r15);
        r23 = r10.iterator();     // Catch: Throwable -> L37
        r24 = r11;
    L20:
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$toChannel$1(r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Collection] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    @PublishedApi
    public static final <E, C extends Collection<? super E>> Object s(ReceiveChannel<? extends E> r10, C r11, Continuation<? super C> r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$toCollection$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$toCollection$1 r13 = (ChannelsKt__DeprecatedKt$toCollection$1) r12;
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
        Collection r20 = (Collection) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
        ?? r21 = r20;
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L28;
        r21.add(r18.next());     // Catch: Throwable -> L14
        ?? r22 = r21;
    L21:
        r13.L$0 = r22;     // Catch: Throwable -> L14
        r13.L$1 = r19;     // Catch: Throwable -> L14
        r13.L$2 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r23 = r18.a(r13);     // Catch: Throwable -> L14
        if (r23 != r16) goto L24;
        return r16;
    L24:
        r21 = r22;
        r15 = r23;
        goto L26
    L28:
        Unit r24 = Unit.INSTANCE;     // Catch: Throwable -> L14
        i.b(r19, null);
        return r21;
    L14:
        Throwable th = th;
    L41:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        i.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L31
        r22 = r11;
    L31:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$toCollection$1(r12);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3, types: [java.lang.Object, java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r8v13 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v5, types: [java.lang.Object] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x0059 -> B:25:0x005c). Please report as a decompilation issue!!! */
    @PublishedApi
    public static final <K, V, M extends Map<? super K, ? super V>> Object t(ReceiveChannel<? extends Pair<? extends K, ? extends V>> r10, M r11, Continuation<? super M> r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$toMap$2) == false) goto L7;
        ChannelsKt__DeprecatedKt$toMap$2 r13 = (ChannelsKt__DeprecatedKt$toMap$2) r12;
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
        ReceiveChannel<? extends Pair<? extends K, ? extends V>> r19 = (ReceiveChannel) r13.L$1;
        Map r20 = (Map) r13.L$0;
        ResultKt.throwOnFailure(r15);     // Catch: Throwable -> L14
        ?? r21 = r20;
    L26:
        if (((Boolean) r15).booleanValue() == false) goto L28;
        Pair r22 = (Pair) r18.next();     // Catch: Throwable -> L14
        r21.put(r22.getFirst(), r22.getSecond());     // Catch: Throwable -> L14
        ?? r23 = r21;
    L21:
        r13.L$0 = r23;     // Catch: Throwable -> L14
        r13.L$1 = r19;     // Catch: Throwable -> L14
        r13.L$2 = r18;     // Catch: Throwable -> L14
        r13.label = 1;     // Catch: Throwable -> L14
        Object r24 = r18.a(r13);     // Catch: Throwable -> L14
        if (r24 != r16) goto L24;
        return r16;
    L24:
        r21 = r23;
        r15 = r24;
        goto L26
    L28:
        Unit r25 = Unit.INSTANCE;     // Catch: Throwable -> L14
        i.b(r19, null);
        return r21;
    L14:
        Throwable th = th;
    L37:
        throw th;     // Catch: Throwable -> L34
    L34:
        th = move-exception;
        i.b(r19, th);
        throw th;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r15);
        r19 = r10;
        r18 = r10.iterator();     // Catch: Throwable -> L31
        r23 = r11;
    L31:
        th = move-exception;
        r19 = r10;
        th = th;
    L7:
        r13 = new ChannelsKt__DeprecatedKt$toMap$2(r12);
        goto L8
    }
}
