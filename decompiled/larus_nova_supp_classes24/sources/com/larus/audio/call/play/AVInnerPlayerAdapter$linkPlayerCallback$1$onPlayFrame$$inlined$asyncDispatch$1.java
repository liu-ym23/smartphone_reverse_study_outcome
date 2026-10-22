package com.larus.audio.call.play;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.im.service.audio.l;
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
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¨\u0006\u0003"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;", "com/larus/audio/call/play/AVInnerPlayerAdapter$asyncDispatch$1"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.play.AVInnerPlayerAdapter$linkPlayerCallback$1$onPlayFrame$$inlined$asyncDispatch$1", f = "AVInnerPlayerAdapter.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class AVInnerPlayerAdapter$linkPlayerCallback$1$onPlayFrame$$inlined$asyncDispatch$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l $frame$inlined;
    int label;
    final /* synthetic */ AVInnerPlayerAdapter this$0;

    public AVInnerPlayerAdapter$linkPlayerCallback$1$onPlayFrame$$inlined$asyncDispatch$1(Continuation r1, AVInnerPlayerAdapter r2, l r3) {
        this.this$0 = r2;
        this.$frame$inlined = r3;
        super(2, r1);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new AVInnerPlayerAdapter$linkPlayerCallback$1$onPlayFrame$$inlined$asyncDispatch$1(r4, this.this$0, this.$frame$inlined);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r6);
        f r7 = this.this$0.d;
        l r1 = this.$frame$inlined;
        r7.d(new h.a(r1.a, r1.d(), this.$frame$inlined.c(), this.$frame$inlined.b()));
        this.this$0.d.g(this.$frame$inlined.a);
        this.this$0.d.i(this.$frame$inlined.a);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
