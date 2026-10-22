package com.obric.assistant.live.service;

import com.larus.utils.logger.FLogger;
import com.obric.assistant.live.event.Event;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.Channel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.live.service.ObricLiveService$sendEvent$1", f = "ObricLiveService.kt", i = {}, l = {868}, m = "invokeSuspend", n = {}, s = {})
public final class ObricLiveService$sendEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $info;
    final /* synthetic */ Event $this_sendEvent;
    int label;
    final /* synthetic */ ObricLiveService this$0;

    public ObricLiveService$sendEvent$1(Event r1, String r2, ObricLiveService r3, Continuation<? super ObricLiveService$sendEvent$1> r4) {
        this.$this_sendEvent = r1;
        this.$info = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricLiveService$sendEvent$1(this.$this_sendEvent, this.$info, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r5);
    L12:
        return Unit.INSTANCE;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        FLogger.a.i("ObricLiveService", "send event:" + this.$this_sendEvent + " and info:" + this.$info);
        Channel r6 = this.this$0.d;
        Event r2 = this.$this_sendEvent;
        this.label = 1;
        if (r6.send(r2, this) != r0) goto L12;
        return r0;
    }
}
