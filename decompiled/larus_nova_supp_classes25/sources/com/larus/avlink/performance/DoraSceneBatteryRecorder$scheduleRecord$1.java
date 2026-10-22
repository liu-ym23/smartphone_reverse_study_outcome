package com.larus.avlink.performance;

import com.flow.performance.thermal.SystemBatteryRecoder;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.utils.logger.FLogger;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.performance.DoraSceneBatteryRecorder$scheduleRecord$1", f = "DoraSceneBatteryRecorder.kt", i = {}, l = {247}, m = "invokeSuspend", n = {}, s = {})
final class DoraSceneBatteryRecorder$scheduleRecord$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ b $event;
    final /* synthetic */ long $version;
    int label;

    public DoraSceneBatteryRecorder$scheduleRecord$1(b r1, long r2, Continuation<? super DoraSceneBatteryRecorder$scheduleRecord$1> r4) {
        this.$event = r1;
        this.$version = r2;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new DoraSceneBatteryRecorder$scheduleRecord$1(this.$event, this.$version, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r8);
    L12:
        if (this.$version != h.d) goto L14;
        Integer r9 = this.$event.c;
        if (r9 == null) goto L21;
        List r2 = b98.b.a;
        if (b98.b.a(r9.intValue()) == 1) goto L21;
        FLogger.a.d("DoraSceneBatteryRecorder", "skip unstable dora scene battery record, scene:" + this.$event.c);
        return Unit.INSTANCE;
    L21:
        SystemBatteryRecoder.a.h("Dora", this.$event.a);
        return Unit.INSTANCE;
    L14:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r8);
        h r10 = h.a;
        long r3 = RangesKt.coerceAtLeast(com.larus.settings.performance.e.a.a().getSceneConfig(this.$event.a).getSmoothDurationMillis(), 0);
        this.label = 1;
        if (DelayKt.delay(r3, this) != r0) goto L12;
        return r0;
    }
}
