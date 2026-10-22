package com.larus.audio.call.plugins;

import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import com.larus.im.service.audio.cmd.TriggerMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
@DebugMetadata(c = "com.larus.audio.call.plugins.CommonHelloPlugin$createSessionConnStateListener$1$onConnectionStateChanged$1", f = "CommonHelloPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class CommonHelloPlugin$createSessionConnStateListener$1$onConnectionStateChanged$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $helloWaitTime;
    int label;
    final /* synthetic */ CommonHelloPlugin<C> this$0;

    public CommonHelloPlugin$createSessionConnStateListener$1$onConnectionStateChanged$1(CommonHelloPlugin<C> r1, int r2, Continuation<? super CommonHelloPlugin$createSessionConnStateListener$1$onConnectionStateChanged$1> r3) {
        this.this$0 = r1;
        this.$helloWaitTime = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new CommonHelloPlugin$createSessionConnStateListener$1$onConnectionStateChanged$1(this.this$0, this.$helloWaitTime, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L13;
        ResultKt.throwOnFailure(r7);
        this.this$0.getContext().a().t();
        id9.d r8 = this.this$0.getContext().j();
        if (r8 == null) goto L10;
        TriggerMode r0 = TriggerMode.HELLO_NEW;
        com.larus.audio.call.arch.a r1 = this.this$0;
        int r2 = this.$helloWaitTime;
        ouc.e0 r3 = new ouc.e0();
        q68.d.b(r3, "enter_method", r1.getContext().params().p.i);
        String r4 = r1.getContext().params().p.a;
        if ((!StringsKt.isBlank(r4)) == false) goto L9;
        q68.d.b(r3, "message_id", r4);
    L9:
        q68.d.b(r3, "hello_wait_time_sec", String.valueOf(r2));
        Unit r5 = Unit.INSTANCE;
        r8.p(r0, r3.a().toString());
    L10:
        this.this$0.getContext().a().n2(TriggerHello.a);
        this.this$0.C1();
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
