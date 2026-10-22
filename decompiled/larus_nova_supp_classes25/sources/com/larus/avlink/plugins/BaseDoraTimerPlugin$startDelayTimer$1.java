package com.larus.avlink.plugins;

import com.larus.avlink.api.model.DoraEvent;
import com.larus.avlink.model.TimerScene;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.BaseDoraTimerPlugin$startDelayTimer$1", f = "BaseDoraTimerPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class BaseDoraTimerPlugin$startDelayTimer$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ TimerScene $scene;
    final /* synthetic */ long $time;
    int label;
    final /* synthetic */ BaseDoraTimerPlugin this$0;

    public BaseDoraTimerPlugin$startDelayTimer$1(BaseDoraTimerPlugin r1, TimerScene r2, long r3, Continuation<? super BaseDoraTimerPlugin$startDelayTimer$1> r5) {
        this.this$0 = r1;
        this.$scene = r2;
        this.$time = r3;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new BaseDoraTimerPlugin$startDelayTimer$1(this.this$0, this.$scene, this.$time, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L14;
        ResultKt.throwOnFailure(r7);
        this.this$0.getClass();
        StringBuilder r8 = new StringBuilder("startDelayTimer:scene: ");
        TimerScene r0 = this.$scene;
        if (r0 == null) goto L7;
        String r1 = r0.name();
    L8:
        r8.append(r1);
        com.larus.avlink.n1.d("DoraTimerPlugin", r8.toString());
        Map<Function1<Boolean, Unit>, k4> r9 = x2.a;
        x2.i(new byte[]{1, 8}, 6);
        Lazy r10 = ia8.m.a;
        ia8.m.b(DoraEvent.VUIReset);
        this.this$0.g1("before start");
        final BaseDoraTimerPlugin r11 = this.this$0;
        final long r2 = this.$time;
        final TimerScene r4 = this.$scene;
        r11.h = new com.larus.audio.call.o(r2, new g(r11, r4, r2));
        this.this$0.getClass();
        com.larus.avlink.n1.d("DoraTimerPlugin", "start time: " + this.$time + " timeout");
        com.larus.audio.call.o r12 = this.this$0.h;
        if (r12 == null) goto L11;
        r12.d();
    L11:
        this.this$0.n3(this.$time, this.$scene);
        return Unit.INSTANCE;
    L7:
        r1 = null;
        goto L8
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
