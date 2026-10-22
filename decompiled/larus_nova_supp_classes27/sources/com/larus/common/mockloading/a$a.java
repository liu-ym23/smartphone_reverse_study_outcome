package com.larus.common.mockloading;

import com.larus.utils.logger.FLogger;
import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class a$a {
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x01a7 -> B:53:0x01ad). Please report as a decompilation issue!!! */
    public static Object a(a r20, String r21, long r22, double r24, Continuation r26) {
        if ((r26 instanceof IMessageLoadingProgressMocker$startProgress$1) == false) goto L7;
        IMessageLoadingProgressMocker$startProgress$1 r1 = (IMessageLoadingProgressMocker$startProgress$1) r26;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        Object r0 = r1.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r1.label;
        double r5 = 1.0d;
        if (r4 == 0) goto L16;
        if (r4 == 1) goto L15;
        if (r4 != 2) goto L14;
        double r10 = r1.D$1;
        double r12 = r1.D$0;
        Ref.IntRef r6 = (Ref.IntRef) r1.L$2;
        String r14 = (String) r1.L$1;
        a r15 = (a) r1.L$0;
        ResultKt.throwOnFailure(r0);
        double r7 = r10;
        a r8 = r15;
    L53:
        r5 = 1.0d;
    L39:
        Integer r9 = (Integer) r8.getProgressMap().get(r14);
        if (r9 == null) goto L42;
        int r11 = r9.intValue();
    L44:
        if (r11 >= 99) goto L55;
        IMessageLoadingProgressMocker$startProgress$1 r13 = r1;
        Object r23 = r3;
        int r16 = (int) Math.floor(Math.pow(r5 - (r5 / ((r7 * 2.0d) + r5)), 2.0d) * 100.0d);
        Map r17 = MapsKt.toMutableMap(r8.getProgressMap());
        if (r16 < r6.element) goto L48;
        r17.put(r14, Boxing.boxInt(r16));
        r8.setProgressMap(MapsKt.toMap(r17));
        r6.element = r16;
        FLogger.a.i("ILoadingProgressMocker", r8.hashCode() + " loadingTaskId-" + r14 + " update: Duration: " + r7 + ", Progress: " + r8.getProgressMap().get(r14) + ", New Progress: " + r16);
    L49:
        double r18 = r7 + r12;
        r13.L$0 = r8;
        r13.L$1 = r14;
        r13.L$2 = r6;
        r13.D$0 = r12;
        r13.D$1 = r18;
        r13.label = 2;
        if (DelayKt.delay(100, r13) != r23) goto L52;
        return r23;
    L52:
        r1 = r13;
        r3 = r23;
        r7 = r18;
        goto L53
    L48:
        FLogger.a.i("ILoadingProgressMocker", "skipped update: Duration: " + r7 + ", Progress: " + r8.getProgressMap().get(r14) + ", New Progress: " + r16);
        goto L49
    L55:
        return Unit.INSTANCE;
    L42:
        r11 = 0;
        goto L44
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        double r110 = r1.D$0;
        String r25 = (String) r1.L$1;
        a r111 = (a) r1.L$0;
        ResultKt.throwOnFailure(r0);
    L20:
        Ref.IntRef r112 = new Ref.IntRef();
        Integer r27 = (Integer) r111.getProgressMap().get(r25);
        if (r27 == null) goto L23;
        int r28 = r27.intValue();
    L24:
        r112.element = r28;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L31
        double r210 = r110;
        Object r30 = Result.constructor-impl(Boxing.boxDouble(((1.0d / (1.0d - Math.sqrt(((double) r28) / 100.0d))) - ((double) 1)) * 0.5d));     // Catch: Throwable -> L29
    L35:
        if (Result.exceptionOrNull-impl(r30) == null) goto L38;
        r30 = Boxing.boxDouble(0.0d);
    L38:
        r7 = ((Number) r30).doubleValue();
        r8 = r111;
        r12 = r210;
        r14 = r25;
        r6 = r112;
    L29:
        th = th;
    L33:
        Result.Companion r31 = Result.Companion;
        r30 = Result.constructor-impl(ResultKt.createFailure(th));
    L31:
        th = th;
        r210 = r110;
        goto L33
    L23:
        r28 = 0;
        goto L24
    L16:
        ResultKt.throwOnFailure(r0);
        r1.L$0 = r20;
        r25 = r21;
        r1.L$1 = r25;
        r110 = r24;
        r1.D$0 = r110;
        r1.label = 1;
        if (DelayKt.delay(r22, r1) != r3) goto L19;
        return r3;
    L19:
        r111 = r20;
    L7:
        r1 = new IMessageLoadingProgressMocker$startProgress$1(r26);
        goto L8
    }
}
