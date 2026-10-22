package kotlinx.coroutines.channels;

import com.obric.sva.sdk.session.IWakeupSessionConstant;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.internal.b0;
import kotlinx.coroutines.t0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes6.dex */
public final class m {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:26:0x007c -> B:28:0x007f). Please report as a decompilation issue!!! */
    public static final Object a(long r6, long r8, SendChannel r10, Continuation r11) {
        if ((r11 instanceof TickerChannelsKt.fixedDelayTicker.1) == false) goto L7;
        TickerChannelsKt.fixedDelayTicker.1 r0 = (TickerChannelsKt.fixedDelayTicker.1) r11;
        int r1 = r0.label;
        if ((r1 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r0.label = r1 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L18;
        if (r3 == 1) goto L17;
        if (r3 == 2) goto L16;
        if (r3 != 3) goto L15;
        r6 = r0.J$0;
        SendChannel r9 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r12);
    L28:
        r10 = r9;
    L21:
        Unit r13 = Unit.INSTANCE;
        r0.L$0 = r10;
        r0.J$0 = r6;
        r0.label = 2;
        if (r10.send(r13, r0) == r2) goto L27;
        r9 = r10;
    L25:
        r0.L$0 = r9;
        r0.J$0 = r6;
        r0.label = 3;
        if (DelayKt.delay(r6, r0) != r2) goto L28;
    L27:
        return r2;
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        r6 = r0.J$0;
        r9 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r12);
        goto L25
    L17:
        r6 = r0.J$0;
        r10 = (SendChannel) r0.L$0;
        ResultKt.throwOnFailure(r12);
        goto L21
    L18:
        ResultKt.throwOnFailure(r12);
        r0.L$0 = r10;
        r0.J$0 = r6;
        r0.label = 1;
        if (DelayKt.delay(r8, r0) != r2) goto L21;
    L7:
        r0 = new TickerChannelsKt.fixedDelayTicker.1(r11);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:34:0x00ce -> B:36:0x00d1). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:38:0x00e7 -> B:36:0x00d1). Please report as a decompilation issue!!! */
    public static final Object b(long r20, long r22, SendChannel r24, Continuation r25) {
        if ((r25 instanceof TickerChannelsKt.fixedPeriodTicker.1) == false) goto L7;
        TickerChannelsKt.fixedPeriodTicker.1 r1 = (TickerChannelsKt.fixedPeriodTicker.1) r25;
        int r2 = r1.label;
        if ((r2 & IWakeupSessionConstant.RC_ERROR) == 0) goto L7;
        r1.label = r2 - IWakeupSessionConstant.RC_ERROR;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        int r5 = 2;
        if (r4 == 0) goto L20;
        if (r4 == 1) goto L19;
        if (r4 == 2) goto L18;
        if (r4 == 3) goto L17;
        if (r4 == 4) goto L17;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L17:
        long r7 = r1.J$1;
        long r9 = r1.J$0;
        SendChannel r6 = (SendChannel) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L36:
        long r18 = r7;
        long r8 = r9;
        long r10 = r18;
        SendChannel r11 = r6;
        r5 = 2;
    L25:
        long r12 = r8 + r10;
        Unit r13 = Unit.INSTANCE;
        r1.L$0 = r11;
        r1.J$0 = r12;
        r1.J$1 = r10;
        r1.label = r5;
        if (r11.send(r13, r1) == r3) goto L39;
        r6 = r11;
        r7 = r10;
        r9 = r12;
    L29:
        long r14 = System.nanoTime();
        long r15 = RangesKt.coerceAtLeast(r9 - r14, 0);
        if (r15 == 0) goto L32;
    L37:
        b0 r16 = t0.a;
        r1.L$0 = r6;
        r1.J$0 = r9;
        r1.J$1 = r7;
        r1.label = 4;
        if (DelayKt.delay(r15 / 1000000, r1) != r3) goto L36;
    L32:
        if (r7 == 0) goto L37;
        long r17 = r7 - ((r14 - r9) % r7);
        r9 = r14 + r17;
        b0 r19 = t0.a;
        r1.L$0 = r6;
        r1.J$0 = r9;
        r1.J$1 = r7;
        r1.label = 3;
        if (DelayKt.delay(r17 / 1000000, r1) != r3) goto L36;
    L39:
        return r3;
    L18:
        r7 = r1.J$1;
        r9 = r1.J$0;
        r6 = (SendChannel) r1.L$0;
        ResultKt.throwOnFailure(r0);
        goto L29
    L19:
        r8 = r1.J$1;
        long r21 = r1.J$0;
        SendChannel r23 = (SendChannel) r1.L$0;
        ResultKt.throwOnFailure(r0);
        r11 = r23;
        long r110 = r21;
    L24:
        r10 = t0.a(r110);
        goto L25
    L20:
        ResultKt.throwOnFailure(r0);
        long r26 = System.nanoTime() + t0.a(r22);
        r11 = r24;
        r1.L$0 = r11;
        r110 = r20;
        r1.J$0 = r110;
        r1.J$1 = r26;
        r1.label = 1;
        if (DelayKt.delay(r22, r1) == r3) goto L39;
        r8 = r26;
    L7:
        r1 = new TickerChannelsKt.fixedPeriodTicker.1(r25);
        goto L8
    }
}
