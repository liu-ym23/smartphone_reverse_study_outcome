package com.obric.miniapp.alarm;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.performance.WindowAnimationBoostCoordinator;
import com.obric.memorydata.sdk.entity.search.SearchError;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.alarm.AlarmManager$triggerAlarms$1", f = "AlarmManager.kt", i = {1, 2}, l = {382, WindowAnimationBoostCoordinator.DEFAULT_WINDOW_ANIMATION_DURATION_MS, 407, 416}, m = "invokeSuspend", n = {"alarm", "alarm"}, s = {"L$1", "L$1"})
final class AlarmManager$triggerAlarms$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    Object L$0;
    Object L$1;
    int label;

    public AlarmManager$triggerAlarms$1(Continuation<? super AlarmManager$triggerAlarms$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new AlarmManager$triggerAlarms$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0181 -> B:48:0x0182). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r17) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        ResultKt.throwOnFailure(r17);
    L56:
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        a r3 = (a) this.L$1;
        Iterator r9 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r17);
        AlarmManager$triggerAlarms$1 r15 = this;
        a r4 = r3;
        Object r5 = r0;
        Object r1 = r17;
    L49:
        if (((Number) r1).intValue() != 0) goto L19;
        FLogger.a.w("AlarmManager", "Delete id=" + r4.a + " failed; probably because of a conflict");
    L19:
        if (r9.hasNext() == false) goto L52;
        a r14 = (a) r9.next();
    L28:
        e = move-exception;
    L29:
        FLogger.a.e("AlarmManager", "Exception occurred when triggering alarm id=" + r14.a, e);
    L30:
        boolean r6 = false;
    L31:
        if (r6 == false) goto L44;
        w r7 = r14.d;
        long r10 = r14.e;
        if (w.c == false) goto L35;
        r7.getClass();
        Object r8 = r7.a;
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type java.time.Instant");
        w r12 = new w(((Instant) r8).plus(Duration.ofMinutes(r10)));
    L36:
        int r13 = r14.g + 1;
        AlarmManager.a.getClass();
        b r11 = AlarmManager.i();
        String r16 = r14.a;
        String r18 = r14.l;
        r15.L$0 = r9;
        r15.L$1 = r14;
        r15.label = 2;
        a r19 = r14;
        AlarmManager$triggerAlarms$1 r20 = r15;
        Object r21 = r11.update(r16, r12, r13, r18, r15);
        if (r21 != r5) goto L39;
        return r5;
    L39:
        r15 = r20;
    L41:
        if (((Number) r21).intValue() != 0) goto L43;
        FLogger.a.w("AlarmManager", "Update id=" + r19.a + " failed; probably because of a conflict");
        goto L19
    L35:
        Object r22 = r7.a;
        Intrinsics.checkNotNull(r22, "null cannot be cast to non-null type java.util.Date");
        r12 = w.a.b(((Date) r22).getTime() + ((r10 * ((long) 60)) * ((long) SearchError.ERR_UNKNOWN)));
        goto L36
    L44:
        r4 = r14;
        AlarmManager$triggerAlarms$1 r23 = r15;
        AlarmManager.a.getClass();
        b r24 = AlarmManager.i();
        String r110 = r4.a;
        String r111 = r4.l;
        r23.L$0 = r9;
        r23.L$1 = r4;
        r23.label = 3;
        r1 = r24.delete(r110, r111, r23);
        if (r1 != r5) goto L47;
        return r5;
    L47:
        r15 = r23;
        goto L49
    L22:
        if (r14.k == true) goto L30;
        b0.a.getClass();     // Catch: Exception -> L28
        b0.a.a().a(r14);     // Catch: Exception -> L28
        if (r14.e <= 0) goto L30;
        if (r14.g >= r14.f) goto L30;
        r6 = true;
        goto L31
    L52:
        AlarmManager$triggerAlarms$1 r25 = r15;
        AlarmManager r26 = AlarmManager.a;
        r25.L$0 = null;
        r25.L$1 = null;
        r25.label = 4;
        if (r26.m(r25) != r5) goto L56;
        return r5;
    L12:
        a r27 = (a) this.L$1;
        r9 = (Iterator) this.L$0;
        ResultKt.throwOnFailure(r17);
        r15 = this;
        r19 = r27;
        r5 = r0;
        r21 = r17;
        goto L41
    L13:
        ResultKt.throwOnFailure(r17);
        Object r28 = r17;
    L17:
        List r29 = (List) r28;
        FLogger.a.i("AlarmManager", "Collect " + r29.size() + " alarms.");
        r15 = this;
        r9 = r29.iterator();
        r5 = r0;
        goto L19
    L14:
        ResultKt.throwOnFailure(r17);
        FLogger.a.i("AlarmManager", "Triggering alarms...");
        boolean r30 = w.b;
        w r31 = w.a.a();
        AlarmManager.a.getClass();
        b r32 = AlarmManager.i();
        this.label = 1;
        r28 = r32.b(r31, this);
        if (r28 != r0) goto L17;
        return r0;
    }
}
