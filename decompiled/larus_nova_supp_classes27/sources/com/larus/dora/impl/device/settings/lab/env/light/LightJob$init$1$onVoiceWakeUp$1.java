package com.larus.dora.impl.device.settings.lab.env.light;

import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.r;
import g49.d;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.env.light.LightJob$init$1$onVoiceWakeUp$1", f = "LightJob.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class LightJob$init$1$onVoiceWakeUp$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ c this$0;

    public LightJob$init$1$onVoiceWakeUp$1(c r1, Continuation<? super LightJob$init$1$onVoiceWakeUp$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new LightJob$init$1$onVoiceWakeUp$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r2);
        d.d("LightJob", "try update env observe light on");
        c r3 = this.this$0;
        c.a r0 = c.c;
        IDoraService r4 = (IDoraService) r3.a.getValue();
        if (r4 == null) goto L10;
        r r5 = r4.g1();
        if (r5 == null) goto L10;
        Boxing.boxInt(r5.e(1));
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
