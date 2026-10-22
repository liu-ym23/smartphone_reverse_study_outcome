package com.larus.avlink;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.avlink.activeSummary.SoundPlayManager;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.DoraWakeupSoundController$onWakeupStop$1", f = "DoraWakeupSoundController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class DoraWakeupSoundController$onWakeupStop$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $interrupt;
    final /* synthetic */ int $reason;
    int label;

    public DoraWakeupSoundController$onWakeupStop$1(int r1, boolean r2, Continuation<? super DoraWakeupSoundController$onWakeupStop$1> r3) {
        this.$reason = r1;
        this.$interrupt = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraWakeupSoundController$onWakeupStop$1(this.$reason, this.$interrupt, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L16;
        ResultKt.throwOnFailure(r2);
        n1.d("DoraWakeupSoundController", "onWakeupStop reason=" + this.$reason + ", isPlaying=" + DoraWakeupSoundController.g + ", interrupt=" + this.$interrupt);
        if (this.$interrupt == false) goto L12;
        Lazy r3 = DoraWakeupSoundController.a;
        DoraWakeupSoundController.d = true;
        if (DoraWakeupSoundController.g == false) goto L14;
        Lazy r4 = DoraWakeupSoundController.a;
        ((SoundPlayManager) DoraWakeupSoundController.c.getValue()).h();
        q1 r5 = DoraWakeupSoundController.h;
        if (r5 == null) goto L11;
        r5.b("interrupt");
    L11:
        DoraWakeupSoundController.h = null;
    L14:
        return Unit.INSTANCE;
    L12:
        Lazy r6 = DoraWakeupSoundController.a;
        DoraWakeupSoundController.d = false;
        goto L14
    L16:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
