package com.larus.audio.call.plugins;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
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
@DebugMetadata(c = "com.larus.audio.call.plugins.CommonVideoAutoTestPlugin$onExitCallVideo$1", f = "CommonVideoAutoTestPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CommonVideoAutoTestPlugin$onExitCallVideo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ CommonVideoAutoTestPlugin this$0;

    public CommonVideoAutoTestPlugin$onExitCallVideo$1(CommonVideoAutoTestPlugin r1, Continuation<? super CommonVideoAutoTestPlugin$onExitCallVideo$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new CommonVideoAutoTestPlugin$onExitCallVideo$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r3);
        com.larus.audio.call.l r4 = (com.larus.audio.call.l) this.this$0.f.getValue();
        r4.getClass();
        com.larus.audio.call.util.e.a.i(r4.b, "[release]");
        int r5 = com.larus.im.a.a;
        gd9.o r6 = com.larus.im.internal.d.a;
        com.larus.im.internal.audio.u.c.getClass();
        com.larus.im.internal.utils.x r7 = com.larus.im.internal.utils.x.a;
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
