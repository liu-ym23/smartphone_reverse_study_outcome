package com.larus.bmhome.chat.component.bottom.voice.service;

import android.animation.ValueAnimator;
import com.larus.avlink.model.DoraCallStateCode;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.bmhome.chat.component.bottom.voice.d0;
import com.larus.bmhome.utils.a4;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.service.VoiceMixInputService$stopVoiceMixInput$1", f = "VoiceMixInputService.kt", i = {}, l = {DoraCallStateCode.DOUBAO_STOP_RECORD_BY_IM, 182}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceMixInputService$stopVoiceMixInput$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Function1<Continuation<? super Unit>, Object> $onBeforeStop;
    int label;
    final /* synthetic */ VoiceMixInputService this$0;

    public VoiceMixInputService$stopVoiceMixInput$1(VoiceMixInputService r1, Function1<? super Continuation<? super Unit>, ? extends Object> r2, Continuation<? super VoiceMixInputService$stopVoiceMixInput$1> r3) {
        this.this$0 = r1;
        this.$onBeforeStop = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new VoiceMixInputService$stopVoiceMixInput$1(this.this$0, this.$onBeforeStop, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L28:
        int r12 = d0.d;
        d0.a.a("real stopVoiceMixInput");
        return Unit.INSTANCE;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L22:
        VoiceMixInputManager.TextStreamWrapper r13 = this.this$0.e();
        r13.getClass();
        int r2 = d0.d;
        d0.a.a("stopUpdateTextStream");
        ValueAnimator r3 = r13.d;
        if (r3 == null) goto L25;
        r3.cancel();
    L25:
        r13.e = "";
        r13.h = false;
        ((VoiceMixInputManager) this.this$0.b.getValue()).b();
        VoiceMixInputManager.Timer r14 = this.this$0.f();
        BuildersKt.launch$default(r14.a, null, null, new VoiceMixInputManager$Timer$stopTimer$1(r14, null), 3, null);
        a4.a.getClass();
        a4.a(a4.b);
        z0<g> r15 = this.this$0.c();
        this.this$0.getClass();
        g r4 = new g(false, VoiceMixInputService.d());
        this.label = 2;
        if (r15.emit(r4, this) != r0) goto L28;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        g r16 = (g) this.this$0.c().getValue();
        if (r16 != null) goto L13;
    L15:
        boolean r17 = false;
    L16:
        if (r17 == false) goto L18;
        Function1<Continuation<? super Unit>, Object> r18 = this.$onBeforeStop;
        this.label = 1;
        if (r18.invoke(this) != r0) goto L22;
        return r0;
    L18:
        return Unit.INSTANCE;
    L13:
        if (r16.a != true) goto L15;
        r17 = true;
        goto L16
    }
}
