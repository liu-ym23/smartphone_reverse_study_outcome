package com.larus.bmhome.chat.component.bottom.voice;

import android.view.MotionEvent;
import android.view.View;
import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.bmhome.chat.component.bottom.voice.VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$4$1", f = "VoiceMixInputComponent.kt", i = {}, l = {346}, m = "invokeSuspend", n = {}, s = {})
public final class VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MotionEvent $event;
    final /* synthetic */ View $view;
    int label;
    final /* synthetic */ VoiceMixInputComponent this$0;

    public VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$4$1(VoiceMixInputComponent r1, View r2, MotionEvent r3, Continuation<? super VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$4$1> r4) {
        this.this$0 = r1;
        this.$view = r2;
        this.$event = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new VoiceMixInputComponent$buildNonStreamVoiceMixInputTouchListener$4$1(this.this$0, this.$view, this.$event, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        VoiceMixInputComponent r7 = this.this$0;
        View r2 = this.$view;
        MotionEvent r3 = this.$event;
        List<Integer> r4 = VoiceMixInputComponent.x;
        r7.D3(r2, r3, -1);
        this.this$0.C3().f();
        z0<com.larus.bmhome.chat.component.bottom.voice.service.d> r8 = this.this$0.p3();
        com.larus.bmhome.chat.component.bottom.voice.service.d.f r5 = com.larus.bmhome.chat.component.bottom.voice.service.d.f.a;
        this.label = 1;
        if (r8.emit(r5, this) != r0) goto L12;
        return r0;
    }
}
