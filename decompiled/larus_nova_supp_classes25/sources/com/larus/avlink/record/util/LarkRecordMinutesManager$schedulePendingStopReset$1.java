package com.larus.avlink.record.util;

import com.larus.avlink.n1;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$schedulePendingStopReset$1", f = "LarkRecordMinutesManager.kt", i = {0}, l = {363}, m = "invokeSuspend", n = {"waitedMs"}, s = {"J$0"})
public final class LarkRecordMinutesManager$schedulePendingStopReset$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    long J$0;
    int label;

    public LarkRecordMinutesManager$schedulePendingStopReset$1(Continuation<? super LarkRecordMinutesManager$schedulePendingStopReset$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new LarkRecordMinutesManager$schedulePendingStopReset$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0030 -> B:14:0x0033). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r5 = this.J$0;
        ResultKt.throwOnFailure(r14);
        LarkRecordMinutesManager$schedulePendingStopReset$1 r15 = this;
    L14:
        r5 = r5 + 500;
        Object r2 = LarkRecordMinutesManager.d;
        monitor-enter(r2);
        LarkRecordMinutesManager.RecordingLifecycle r7 = LarkRecordMinutesManager.e;     // Catch: Throwable -> L35
        LarkRecordMinutesManager.RecordingLifecycle r8 = LarkRecordMinutesManager.RecordingLifecycle.STOP_PENDING;     // Catch: Throwable -> L35
        if (r7 == r8) goto L19;
    L26:
        boolean r9 = false;
    L27:
        monitor-exit(r2);
        if (r9 == false) goto L32;
        n1.d("LarkRecordMinutesManager", "GRecord pending stop settled after " + r5 + "ms");
        LarkRecordMinutesManager.a.getClass();
        LarkRecordMinutesManager.g();
        return Unit.INSTANCE;
    L32:
        if (LarkRecordMinutesManager.e != r8) goto L34;
    L10:
        if (r5 >= 15000) goto L38;
        r15.J$0 = r5;
        r15.label = 1;
        if (DelayKt.delay(500, r15) != r0) goto L14;
        return r0;
    L38:
        n1.e("LarkRecordMinutesManager", "GRecord force reset pending stop after timeout");
        LarkRecordMinutesManager.a.getClass();
        LarkRecordMinutesManager.g();
        return Unit.INSTANCE;
    L34:
        return Unit.INSTANCE;
    L19:
        if (LarkRecordMinutesManager.f == true) goto L26;
        if (LarkRecordMinutesManager.g == true) goto L26;
        if (System.currentTimeMillis() < LarkRecordMinutesManager.i) goto L26;
        r9 = true;
    L35:
        th = move-exception;
        throw th;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r14);
        r5 = 0;
        r15 = this;
        goto L10
    }
}
