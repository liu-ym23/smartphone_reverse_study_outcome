package com.obric.assistant.interaction.impl;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.interaction.impl.ObricApmServiceImpl$monitorEventForSlardar$1", f = "ObricApmServiceImpl.kt", i = {0}, l = {90}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
public final class ObricApmServiceImpl$monitorEventForSlardar$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ JSONObject $category;
    final /* synthetic */ String $event;
    final /* synthetic */ JSONObject $extraLog;
    final /* synthetic */ JSONObject $metric;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    int label;
    final /* synthetic */ ObricApmServiceImpl this$0;

    public ObricApmServiceImpl$monitorEventForSlardar$1(ObricApmServiceImpl r1, String r2, JSONObject r3, JSONObject r4, JSONObject r5, Continuation<? super ObricApmServiceImpl$monitorEventForSlardar$1> r6) {
        this.this$0 = r1;
        this.$event = r2;
        this.$category = r3;
        this.$metric = r4;
        this.$extraLog = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new ObricApmServiceImpl$monitorEventForSlardar$1(this.this$0, this.$event, this.$category, this.$metric, this.$extraLog, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        JSONObject r2 = (JSONObject) this.L$5;
        JSONObject r3 = (JSONObject) this.L$4;
        JSONObject r4 = (JSONObject) this.L$3;
        String r5 = (String) this.L$2;
        ObricApmServiceImpl r6 = (ObricApmServiceImpl) this.L$1;
        kotlinx.coroutines.sync.a r7 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r9);
    L22:
    L19:
        th = move-exception;
        r7.unlock(null);
        throw th;
    L13:
        if (ObricApmServiceImpl.access$isReady$p(r6).get() == false) goto L15;
        ObricApmServiceImpl.access$reportEventForSlardar(r6, r5, r4, r3, r2);     // Catch: Throwable -> L19
    L16:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L19
        r7.unlock(null);
        return Unit.INSTANCE;
    L15:
        Boxing.boxBoolean(ObricApmServiceImpl.access$getPendingSlardarEvents$p(r6).add(new ObricApmServiceImpl$SlardarEventParams(r5, r4, r3, r2)));     // Catch: Throwable -> L19
        goto L16
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r7 = ObricApmServiceImpl.access$getLock$p(this.this$0);
        r6 = this.this$0;
        r5 = this.$event;
        JSONObject r11 = this.$category;
        r3 = this.$metric;
        JSONObject r8 = this.$extraLog;
        this.L$0 = r7;
        this.L$1 = r6;
        this.L$2 = r5;
        this.L$3 = r11;
        this.L$4 = r3;
        this.L$5 = r8;
        this.label = 1;
        if (r7.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r4 = r11;
        r2 = r8;
        goto L22
    }
}
