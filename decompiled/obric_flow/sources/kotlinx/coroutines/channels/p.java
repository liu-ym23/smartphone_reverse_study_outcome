package kotlinx.coroutines.channels;

import java.util.concurrent.CancellationException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.j0;

/* JADX INFO: loaded from: classes3.dex */
public abstract class p {
    public static f a(int r5, int r10, BufferOverflow r11) {
        if ((r10 & 1) == 0) goto L6;
        r5 = 0;
    L6:
        if ((r10 & 2) == 0) goto L9;
        r11 = BufferOverflow.SUSPEND;
    L9:
        if (r5 == (-2)) goto L31;
        if (r5 == (-1)) goto L26;
        if (r5 == 0) goto L22;
        if (r5 != Integer.MAX_VALUE) goto L16;
        f r12 = new f(Integer.MAX_VALUE, null);
    L36:
        return r12;
    L16:
        if (r11 != BufferOverflow.SUSPEND) goto L35;
        return new f(r5, null);
    L35:
        return new q(r5, r11, null);
    L22:
        if (r11 != BufferOverflow.SUSPEND) goto L24;
        r12 = new f(0, null);
        goto L36
    L24:
        r12 = new q(1, r11, null);
        goto L36
    L26:
        if (r11 != BufferOverflow.SUSPEND) goto L29;
        return new q(1, BufferOverflow.DROP_OLDEST, null);
    L29:
        throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow");
    L31:
        if (r11 != BufferOverflow.SUSPEND) goto L33;
        i.h1.getClass();
        r12 = new f(h.f18812b, null);
        goto L36
    L33:
        r12 = new q(1, r11, null);
        goto L36
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x007d -> B:14:0x0034). Please report as a decompilation issue!!! */
    public static final Object b(long r10, long r11, x r12, ContinuationImpl r13) {
        if ((r13 instanceof TickerChannelsKt$fixedDelayTicker$1) == false) goto L7;
        TickerChannelsKt$fixedDelayTicker$1 r5 = (TickerChannelsKt$fixedDelayTicker$1) r13;
        int r14 = r5.label;
        if ((r14 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r14 - Integer.MIN_VALUE;
    L8:
        Object r15 = r5.result;
        Object r16 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r17 = r5.label;
        if (r17 == 0) goto L19;
        if (r17 == 1) goto L18;
        if (r17 == 2) goto L17;
        if (r17 != 3) goto L16;
        r10 = r5.J$0;
        x r18 = (x) r5.L$0;
        ResultKt.throwOnFailure(r15);
    L14:
        r12 = r18;
    L22:
        Unit r19 = Unit.INSTANCE;
        r5.L$0 = r12;
        r5.J$0 = r10;
        r5.label = 2;
        if (r12.r(r19, r5) == r16) goto L28;
        r18 = r12;
    L26:
        r5.L$0 = r18;
        r5.J$0 = r10;
        r5.label = 3;
        if (DelayKt.delay(r10, r5) != r16) goto L14;
    L28:
        return r16;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r10 = r5.J$0;
        r18 = (x) r5.L$0;
        ResultKt.throwOnFailure(r15);
        goto L26
    L18:
        r10 = r5.J$0;
        r12 = (x) r5.L$0;
        ResultKt.throwOnFailure(r15);
        goto L22
    L19:
        ResultKt.throwOnFailure(r15);
        r5.L$0 = r12;
        r5.J$0 = r10;
        r5.label = 1;
        if (DelayKt.delay(r11, r5) != r16) goto L22;
    L7:
        r5 = new TickerChannelsKt$fixedDelayTicker$1(r13);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e6 -> B:27:0x009e). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x00fa -> B:15:0x003c). Please report as a decompilation issue!!! */
    public static final Object c(long r20, long r22, x r24, ContinuationImpl r25) {
        if ((r25 instanceof TickerChannelsKt$fixedPeriodTicker$1) == false) goto L7;
        TickerChannelsKt$fixedPeriodTicker$1 r5 = (TickerChannelsKt$fixedPeriodTicker$1) r25;
        int r10 = r5.label;
        if ((r10 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r10 - Integer.MIN_VALUE;
    L8:
        Object r11 = r5.result;
        Object r12 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r13 = r5.label;
        if (r13 == 0) goto L22;
        if (r13 == 1) goto L21;
        if (r13 == 2) goto L20;
        if (r13 == 3) goto L18;
        if (r13 != 4) goto L17;
        long r14 = r5.J$1;
        long r15 = r5.J$0;
        x r16 = (x) r5.L$0;
        ResultKt.throwOnFailure(r11);
        char r17 = 3;
    L15:
        long r18 = r14;
        long r19 = r15;
        long r21 = r18;
        x r23 = r16;
    L27:
        long r26 = r19 + r21;
        Unit r27 = Unit.INSTANCE;
        r5.L$0 = r23;
        r5.J$0 = r26;
        r5.J$1 = r21;
        r5.label = 2;
        if (r23.r(r27, r5) == r12) goto L41;
        r16 = r23;
        r14 = r21;
        r15 = r26;
    L31:
        long r110 = System.nanoTime();
        long r111 = RangesKt.coerceAtLeast(r15 - r110, 0);
        if (r111 == 0) goto L34;
    L39:
        r17 = 3;
        r5.L$0 = r16;
        r5.J$0 = r15;
        r5.J$1 = r14;
        r5.label = 4;
        if (DelayKt.delay(r111 / 1000000, r5) != r12) goto L15;
    L34:
        if (r14 == 0) goto L39;
        long r28 = r14 - ((r110 - r15) % r14);
        long r29 = r110 + r28;
        r5.L$0 = r16;
        r5.J$0 = r29;
        r5.J$1 = r14;
        char r30 = 3;
        r5.label = 3;
        if (DelayKt.delay(r28 / 1000000, r5) == r12) goto L41;
    L19:
        long r112 = r14;
        r19 = r29;
        r21 = r112;
        r23 = r16;
    L41:
        return r12;
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r14 = r5.J$1;
        r29 = r5.J$0;
        r16 = (x) r5.L$0;
        ResultKt.throwOnFailure(r11);
        r30 = 3;
        goto L19
    L20:
        r14 = r5.J$1;
        r15 = r5.J$0;
        r16 = (x) r5.L$0;
        ResultKt.throwOnFailure(r11);
        goto L31
    L21:
        r19 = r5.J$1;
        long r31 = r5.J$0;
        x r32 = (x) r5.L$0;
        ResultKt.throwOnFailure(r11);
        r23 = r32;
        long r113 = r31;
    L26:
        r21 = j0.d(r113);
        goto L27
    L22:
        ResultKt.throwOnFailure(r11);
        long r33 = System.nanoTime() + j0.d(r22);
        r23 = r24;
        r5.L$0 = r23;
        r113 = r20;
        r5.J$0 = r113;
        r5.J$1 = r33;
        r5.label = 1;
        if (DelayKt.delay(r22, r5) == r12) goto L41;
        r19 = r33;
    L7:
        r5 = new TickerChannelsKt$fixedPeriodTicker$1(r25);
        goto L8
    }

    public static final void d(w r5, Throwable r10) {
        if ((r10 instanceof CancellationException) == false) goto L5;
        CancellationException r11 = (CancellationException) r10;
    L6:
        if (r11 != null) goto L8;
        r11 = new CancellationException("Channel was consumed, consumer had failed");
        r11.initCause(r10);
    L8:
        r5.cancel(r11);
        return;
    L5:
        r11 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v1, types: [java.lang.Object, kotlinx.coroutines.channels.x] */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r6v0, types: [kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v20 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v9, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v0, types: [kotlinx.coroutines.channels.u] */
    /* JADX WARN: Type inference failed for: r7v1 */
    /* JADX WARN: Type inference failed for: r7v15 */
    /* JADX WARN: Type inference failed for: r7v16 */
    /* JADX WARN: Type inference failed for: r7v17 */
    /* JADX WARN: Type inference failed for: r7v18 */
    /* JADX WARN: Type inference failed for: r7v2, types: [kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r7v4 */
    /* JADX WARN: Type inference failed for: r7v5, types: [java.lang.Object, kotlinx.coroutines.channels.w] */
    /* JADX WARN: Type inference failed for: r7v6, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r7v7 */
    /* JADX WARN: Type inference failed for: r7v8 */
    /* JADX WARN: Type inference failed for: r7v9 */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x008d -> B:14:0x0037). Please report as a decompilation issue!!! */
    public static final Object e(w r10, u r11, ContinuationImpl r12) {
        if ((r12 instanceof ChannelsKt__DeprecatedKt$toChannel$1) == false) goto L7;
        ChannelsKt__DeprecatedKt$toChannel$1 r5 = (ChannelsKt__DeprecatedKt$toChannel$1) r12;
        int r13 = r5.label;
        if ((r13 & Integer.MIN_VALUE) == 0) goto L7;
        r5.label = r13 - Integer.MIN_VALUE;
    L8:
        Object r14 = r5.result;
        Object r15 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r16 = r5.label;
        if (r16 == 0) goto L22;
        if (r16 == 1) goto L19;
        if (r16 != 2) goto L18;
        k r17 = (k) r5.L$2;
        w r18 = (w) r5.L$1;
        x r19 = (x) r5.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
        ?? r20 = r19;
        k r21 = r17;
        ?? r22 = r18;
    L14:
        k r23 = r21;
        r10 = r22;
        ?? r24 = r20;
    L24:
        r5.L$0 = r24;     // Catch: Throwable -> L37
        r5.L$1 = r10;     // Catch: Throwable -> L37
        r5.L$2 = r23;     // Catch: Throwable -> L37
        r5.label = 1;     // Catch: Throwable -> L37
        e r25 = (e) r23;     // Catch: Throwable -> L37
        Object r26 = r25.c(r5);     // Catch: Throwable -> L37
        if (r26 == r15) goto L50;
        ?? r27 = r24;
        r11 = r10;
        k r28 = r25;
        r14 = r26;
        ?? r29 = r27;
    L29:
        if (((Boolean) r14).booleanValue() == false) goto L33;
        e r30 = (e) r28;     // Catch: Throwable -> L15
        Object r31 = r30.d();     // Catch: Throwable -> L15
        r5.L$0 = r29;     // Catch: Throwable -> L15
        r5.L$1 = r11;     // Catch: Throwable -> L15
        r5.L$2 = r30;     // Catch: Throwable -> L15
        r5.label = 2;     // Catch: Throwable -> L15
        Object r32 = r29.r(r31, r5);     // Catch: Throwable -> L15
        r20 = r29;
        r21 = r30;
        r22 = r11;
        if (r32 != r15) goto L14;
        return r15;
    L33:
        Unit r33 = Unit.INSTANCE;     // Catch: Throwable -> L15
        r11.cancel(null);
        return r29;
    L50:
        return r15;
    L37:
        th = move-exception;
        r11 = r10;
        th = th;
    L47:
        throw th;     // Catch: Throwable -> L40
    L40:
        th = move-exception;
        d(r11, th);
        throw th;
    L18:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L19:
        r28 = (k) r5.L$2;
        w r34 = (w) r5.L$1;
        x r35 = (x) r5.L$0;
        ResultKt.throwOnFailure(r14);     // Catch: Throwable -> L15
        r29 = r35;
        r11 = r34;
        goto L29
    L22:
        ResultKt.throwOnFailure(r14);
        k r36 = r10.iterator();     // Catch: Throwable -> L37
        r10 = r10;
        r24 = r11;
        r23 = r36;
    L15:
        th = th;
    L7:
        r5 = new ChannelsKt__DeprecatedKt$toChannel$1(r12);
        goto L8
    }
}
