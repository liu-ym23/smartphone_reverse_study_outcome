package com.larus.avlink;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.avlink.BaseDoraCallLLMController$onVoiceWakeUp$1", f = "BaseDoraCallLLMController.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BaseDoraCallLLMController$onVoiceWakeUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $extra;
    final /* synthetic */ String $kw;
    final /* synthetic */ int $mode;
    final /* synthetic */ int $query;
    final /* synthetic */ int $side;
    final /* synthetic */ int $state;
    final /* synthetic */ int $vuiId;
    int label;
    final /* synthetic */ o this$0;

    public BaseDoraCallLLMController$onVoiceWakeUp$1(o r1, int r2, int r3, int r4, int r5, int r6, String r7, String r8, Continuation<? super BaseDoraCallLLMController$onVoiceWakeUp$1> r9) {
        this.this$0 = r1;
        this.$state = r2;
        this.$mode = r3;
        this.$query = r4;
        this.$side = r5;
        this.$vuiId = r6;
        this.$kw = r7;
        this.$extra = r8;
        super(2, r9);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        return new BaseDoraCallLLMController$onVoiceWakeUp$1(this.this$0, this.$state, this.$mode, this.$query, this.$side, this.$vuiId, this.$kw, this.$extra, r12);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r10);
        o r11 = this.this$0;
        final int r1 = this.$state;
        final int r2 = this.$mode;
        final int r3 = this.$query;
        final int r4 = this.$side;
        final int r5 = this.$vuiId;
        final String r6 = this.$kw;
        final String r7 = this.$extra;
        Function1 r8 = new p(r1, r2, r3, r4, r5, r6, r7);
        int r0 = o.E;
        r11.W(r8);
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
