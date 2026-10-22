package kotlinx.coroutines.channels;

import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.au;
import kotlinx.coroutines.bk;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a,\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a,\u0010\b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u0006H\u0082@¢\u0006\u0002\u0010\u0007\u001a4\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007¨\u0006\u000f"}, d2 = {"fixedDelayTicker", "", "delayMillis", "", "initialDelayMillis", "channel", "Lkotlinx/coroutines/channels/SendChannel;", "(JJLkotlinx/coroutines/channels/SendChannel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "fixedPeriodTicker", "ticker", "Lkotlinx/coroutines/channels/ReceiveChannel;", "context", "Lkotlin/coroutines/CoroutineContext;", "mode", "Lkotlinx/coroutines/channels/TickerMode;", "kotlinx-coroutines-core"}, k = 2, mv = {1, 9, 0}, xi = 48)
public final class aa {
    public static final /* synthetic */ Object a(long r8, long r10, z r12, Continuation r13) {
        return c(r8, r10, (z) ZeusTransformUtils.wrapperContextForParams(r12, z.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    public static final /* synthetic */ Object b(long r8, long r10, z r12, Continuation r13) {
        return d(r8, r10, (z) ZeusTransformUtils.wrapperContextForParams(r12, z.class, "com.obric.memorydata.plugin"), (Continuation) ZeusTransformUtils.wrapperContextForParams(r13, Continuation.class, "com.obric.memorydata.plugin"));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:45:0x0120 -> B:30:0x00d3). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0135 -> B:15:0x0060). Please report as a decompilation issue!!! */
    private static final Object c(long r15, long r17, z<? super Unit> r19, Continuation<? super Unit> r20) {
        z r0 = (z) ZeusTransformUtils.wrapperContextForParams(r19, z.class, "com.obric.memorydata.plugin");
        Continuation r2 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r20, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r2, TickerChannelsKt$fixedPeriodTicker$1.class) == false) goto L7;
        TickerChannelsKt$fixedPeriodTicker$1 r3 = (TickerChannelsKt$fixedPeriodTicker$1) ZeusTransformUtils.preCheckCast(r2, TickerChannelsKt$fixedPeriodTicker$1.class, "com.obric.memorydata.plugin");
        if ((r3.label & Integer.MIN_VALUE) == 0) goto L7;
        r3.label -= Integer.MIN_VALUE;
    L8:
        Object r4 = r3.result;
        Object r5 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r6 = r3.label;
        if (r6 == 0) goto L22;
        if (r6 == 1) goto L21;
        if (r6 == 2) goto L20;
        if (r6 == 3) goto L18;
        if (r6 != 4) goto L17;
        long r9 = r3.J$1;
        long r11 = r3.J$0;
        r0 = (z) ZeusTransformUtils.preCheckCast(r3.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        char r7 = 3;
    L15:
        long r1 = r11;
    L30:
        long r8 = r1 + r9;
        Unit r10 = Unit.INSTANCE;
        r3.L$0 = r0;
        r3.J$0 = r8;
        r3.J$1 = r9;
        r3.label = 2;
        if (r0.send(r10, r3) != r5) goto L33;
        return r5;
    L33:
        r11 = r8;
    L34:
        kotlinx.coroutines.b r12 = kotlinx.coroutines.c.a();
        if (r12 == null) goto L37;
        long r13 = r12.a();
    L38:
        long r14 = RangesKt.coerceAtLeast(r11 - r13, 0);
        if (r14 == 0) goto L41;
    L46:
        r7 = 3;
        long r16 = bk.b(r14);
        r3.L$0 = r0;
        r3.J$0 = r11;
        r3.J$1 = r9;
        r3.label = 4;
        if (au.a(r16, r3) != r5) goto L15;
        return r5;
    L41:
        if (r9 == 0) goto L46;
        long r18 = r9 - ((r13 - r11) % r9);
        long r110 = r13 + r18;
        long r21 = bk.b(r18);
        r3.L$0 = r0;
        r3.J$0 = r110;
        r3.J$1 = r9;
        char r22 = 3;
        r3.label = 3;
        if (au.a(r21, r3) == r5) goto L44;
    L19:
        r1 = r110;
        goto L30
    L44:
        return r5;
    L37:
        r13 = System.nanoTime();
        goto L38
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        r9 = r3.J$1;
        r110 = r3.J$0;
        r0 = (z) ZeusTransformUtils.preCheckCast(r3.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r22 = 3;
        goto L19
    L20:
        r9 = r3.J$1;
        r11 = r3.J$0;
        r0 = (z) ZeusTransformUtils.preCheckCast(r3.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        goto L34
    L21:
        long r23 = r3.J$1;
        long r111 = r3.J$0;
        r0 = (z) ZeusTransformUtils.preCheckCast(r3.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r4);
        r1 = r23;
        long r112 = r111;
    L29:
        r9 = bk.a(r112);
        goto L30
    L22:
        ResultKt.throwOnFailure(r4);
        kotlinx.coroutines.b r24 = kotlinx.coroutines.c.a();
        if (r24 == null) goto L25;
        long r25 = r24.a();
    L26:
        r1 = r25 + bk.a(r17);
        r3.L$0 = r0;
        r112 = r15;
        r3.J$0 = r112;
        r3.J$1 = r1;
        r3.label = 1;
        if (au.a(r17, r3) != r5) goto L29;
        return r5;
    L25:
        r25 = System.nanoTime();
    L7:
        r3 = new TickerChannelsKt$fixedPeriodTicker$1(r2);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:27:0x00ab -> B:14:0x0056). Please report as a decompilation issue!!! */
    private static final Object d(long r7, long r9, z<? super Unit> r11, Continuation<? super Unit> r12) {
        z r13 = (z) ZeusTransformUtils.wrapperContextForParams(r11, z.class, "com.obric.memorydata.plugin");
        Continuation r14 = (Continuation) ZeusTransformUtils.wrapperContextForParams(r12, Continuation.class, "com.obric.memorydata.plugin");
        if (ZeusTransformUtils.instanceOf(r14, TickerChannelsKt$fixedDelayTicker$1.class) == false) goto L7;
        TickerChannelsKt$fixedDelayTicker$1 r0 = (TickerChannelsKt$fixedDelayTicker$1) ZeusTransformUtils.preCheckCast(r14, TickerChannelsKt$fixedDelayTicker$1.class, "com.obric.memorydata.plugin");
        if ((r0.label & Integer.MIN_VALUE) == 0) goto L7;
        r0.label -= Integer.MIN_VALUE;
    L8:
        Object r15 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L19;
        if (r3 == 1) goto L18;
        if (r3 == 2) goto L17;
        if (r3 != 3) goto L16;
        r7 = r0.J$0;
        z r10 = (z) ZeusTransformUtils.preCheckCast(r0.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
    L14:
        r13 = r10;
    L22:
        Unit r16 = Unit.INSTANCE;
        r0.L$0 = r13;
        r0.J$0 = r7;
        r0.label = 2;
        if (r13.send(r16, r0) != r2) goto L25;
        return r2;
    L25:
        r10 = r13;
    L26:
        r0.L$0 = r10;
        r0.J$0 = r7;
        r0.label = 3;
        if (au.a(r7, r0) != r2) goto L14;
        return r2;
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        r7 = r0.J$0;
        r10 = (z) ZeusTransformUtils.preCheckCast(r0.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        goto L26
    L18:
        r7 = r0.J$0;
        r13 = (z) ZeusTransformUtils.preCheckCast(r0.L$0, z.class, "com.obric.memorydata.plugin");
        ResultKt.throwOnFailure(r15);
        goto L22
    L19:
        ResultKt.throwOnFailure(r15);
        r0.L$0 = r13;
        r0.J$0 = r7;
        r0.label = 1;
        if (au.a(r9, r0) != r2) goto L22;
        return r2;
    L7:
        r0 = new TickerChannelsKt$fixedDelayTicker$1(r14);
        goto L8
    }
}
