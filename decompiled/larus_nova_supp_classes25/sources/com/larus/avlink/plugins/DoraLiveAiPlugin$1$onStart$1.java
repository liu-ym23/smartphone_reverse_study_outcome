package com.larus.avlink.plugins;

import com.larus.bmhome.chat.cell.MessageCellStateTransformerType;
import com.larus.dora.api.DoraByteCastManagerDelegate;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = MessageCellStateTransformerType.Z_LOTTERY_GUIDE_CELL)
@DebugMetadata(c = "com.larus.avlink.plugins.DoraLiveAiPlugin$1$onStart$1", f = "DoraLiveAiPlugin.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraLiveAiPlugin$1$onStart$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ c2 this$0;

    public DoraLiveAiPlugin$1$onStart$1(c2 r1, Continuation<? super DoraLiveAiPlugin$1$onStart$1> r2) {
        this.this$0 = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraLiveAiPlugin$1$onStart$1(this.this$0, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L21;
        ResultKt.throwOnFailure(r5);
        c2 r6 = this.this$0;
        boolean r0 = c2.m;
        r6.getClass();
        if (ia8.o.a() == true) goto L8;
    L10:
        int r7 = 6;
    L12:
        IDoraService r1 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r1 == null) goto L17;
        SessionService r2 = r1.d();
        if (r2 == null) goto L17;
        Integer r3 = Boxing.boxInt(r2.o(500, r7));
    L18:
        this.this$0.getClass();
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "startVUI with resolved mode: " + r7 + ", result: " + r3);
        return Unit.INSTANCE;
    L17:
        r3 = null;
        goto L18
    L8:
        if (DoraByteCastManagerDelegate.b.a() == true) goto L11;
        com.larus.avlink.n1.d("DoraLiveAiPlugin", "resolveLiveAIStartWakeMode: byteCast not ready, downgrade to LIVE_AI_VOICE");
        goto L10
    L11:
        r7 = 32;
        goto L12
    L21:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
