package com.larus.avlink.record.util;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.record.util.LarkRecordMinutesManager$startObserveExternalRecordingDuration$1", f = "LarkRecordMinutesManager.kt", i = {}, l = {610}, m = "invokeSuspend", n = {}, s = {})
final class LarkRecordMinutesManager$startObserveExternalRecordingDuration$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public LarkRecordMinutesManager$startObserveExternalRecordingDuration$1(Continuation<? super LarkRecordMinutesManager$startObserveExternalRecordingDuration$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new LarkRecordMinutesManager$startObserveExternalRecordingDuration$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
    L10:
        if (LarkRecordMinutesManager.B == false) goto L23;
        Iterator<Function1<Integer, Unit>> r11 = LarkRecordMinutesManager.r.iterator();
    L13:
        if (r11.hasNext() == false) goto L19;
        Function1<Integer, Unit> r2 = r11.next();
        LarkRecordMinutesManager.a.getClass();
        long r3 = LarkRecordMinutesManager.o;
        int r7 = 0;
        if (r3 <= 0) goto L18;
        r7 = RangesKt.coerceAtLeast((int) ((System.currentTimeMillis() - r3) / ((long) 1000)), 0);
    L18:
        r2.invoke(Boxing.boxInt(r7));
        goto L13
    L19:
        this.label = 1;
        if (DelayKt.delay(1000, this) != r0) goto L10;
        return r0;
    L23:
        return Unit.INSTANCE;
    }
}
