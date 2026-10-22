package com.larus.common.location.impl;

import com.larus.api.CoordinateType;
import com.larus.platform.model.LocateScene;
import com.larus.platform.model.LocationResult;
import com.larus.utils.logger.FLogger;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.common.location.impl.FlowLocationScheduler$startPoll$1", f = "FlowLocationScheduler.kt", i = {0, 1, 2, 3}, l = {68, 69, 88, 89}, m = "invokeSuspend", n = {"i", "i", "i", "i"}, s = {"I$0", "I$0", "I$0", "I$0"})
final class FlowLocationScheduler$startPoll$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CoordinateType $coordinateType;
    final /* synthetic */ LocateScene $scene;
    int I$0;
    int label;
    final /* synthetic */ FlowLocationScheduler this$0;

    public FlowLocationScheduler$startPoll$1(LocateScene r1, FlowLocationScheduler r2, CoordinateType r3, Continuation<? super FlowLocationScheduler$startPoll$1> r4) {
        this.$scene = r1;
        this.this$0 = r2;
        this.$coordinateType = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new FlowLocationScheduler$startPoll$1(this.$scene, this.this$0, this.$coordinateType, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x00e3 -> B:32:0x00e6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:40:0x0147 -> B:39:0x0141). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x01b4 -> B:49:0x01b7). Please report as a decompilation issue!!! */
    public final Object invokeSuspend(Object r17) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        long r4 = 0;
        if (r2 == 0) goto L14;
        if (r2 == 1) goto L13;
        if (r2 == 2) goto L12;
        if (r2 == 3) goto L11;
        if (r2 != 4) goto L10;
        int r3 = this.I$0;
        ResultKt.throwOnFailure(r17);
        Object r8 = r17;
        FlowLocationScheduler$startPoll$1 r11 = this;
    L49:
        LocationResult r9 = (LocationResult) r8;
        if (r9 != LocationResult.SUCCESS) goto L52;
    L55:
        FLogger.a.d("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] loc result: " + r9.name());
        r4 = 0;
    L41:
        r3 = r3 + 1;
        long r10 = FlowLocationScheduler.a(r11.this$0, r11.$scene, FlowLocationScheduler.FrequencyLevel.REDUCE_FREQUENCY);
        FLogger r12 = FLogger.a;
        r12.d("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] delay: " + r10);
        if (r10 <= r4) goto L57;
        r11.I$0 = r3;
        r11.label = 3;
        if (DelayKt.delay(r10, r11) != r1) goto L46;
        return r1;
    L46:
        FlowLocationScheduler r13 = r11.this$0;
        LocateScene r14 = r11.$scene;
        CoordinateType r15 = r11.$coordinateType;
        r11.I$0 = r3;
        r11.label = 4;
        r8 = FlowLocationScheduler.b(r13, r14, r15, r11);
        if (r8 != r1) goto L49;
        return r1;
    L57:
        r12.d("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] skip");
        return Unit.INSTANCE;
    L52:
        if (r9 != LocationResult.STOP_POLL_IN_BACKGROUND) goto L55;
        FLogger.a.i("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] loc result: " + r9.name());
        return Unit.INSTANCE;
    L10:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L11:
        r3 = this.I$0;
        ResultKt.throwOnFailure(r17);
        r11 = this;
        goto L46
    L12:
        r3 = this.I$0;
        ResultKt.throwOnFailure(r17);
        Object r7 = r17;
        r11 = this;
    L32:
        LocationResult r16 = (LocationResult) r7;
        if (r16 != LocationResult.SUCCESS) goto L35;
    L38:
        FLogger.a.d("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] loc result: " + r16.name());
    L15:
        if (r3 < 0) goto L22;
        Integer r18 = r11.this$0.b.g();
        if (r18 == null) goto L19;
        int r110 = r18.intValue();
    L20:
        if (r3 >= r110) goto L22;
        boolean r111 = true;
    L23:
        if (r111 == false) goto L41;
        r3 = r3 + 1;
        long r20 = FlowLocationScheduler.a(r11.this$0, r11.$scene, FlowLocationScheduler.FrequencyLevel.NORMAL);
        FLogger r112 = FLogger.a;
        r112.d("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] delay: " + r20);
        if (r20 <= 0) goto L40;
        r11.I$0 = r3;
        r11.label = 1;
        if (DelayKt.delay(r20, r11) != r1) goto L29;
        return r1;
    L29:
        FlowLocationScheduler r21 = r11.this$0;
        LocateScene r22 = r11.$scene;
        CoordinateType r23 = r11.$coordinateType;
        r11.I$0 = r3;
        r11.label = 2;
        r7 = FlowLocationScheduler.b(r21, r22, r23, r11);
        if (r7 != r1) goto L32;
        return r1;
    L40:
        r112.d("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] skip");
        goto L15
    L19:
        r110 = 0;
    L22:
        r111 = false;
        goto L23
    L35:
        if (r16 != LocationResult.STOP_POLL_IN_BACKGROUND) goto L38;
        FLogger.a.i("loc_poll", r11.$scene.name() + ";poll[" + r3 + "] loc result: " + r16.name());
        return Unit.INSTANCE;
    L13:
        r3 = this.I$0;
        ResultKt.throwOnFailure(r17);
        r11 = this;
        goto L29
    L14:
        ResultKt.throwOnFailure(r17);
        FLogger.a.d("loc_poll", "[" + this.$scene.name() + "] start schedule, config:" + this.this$0.b);
        r11 = this;
        r3 = 0;
        goto L15
    }
}
