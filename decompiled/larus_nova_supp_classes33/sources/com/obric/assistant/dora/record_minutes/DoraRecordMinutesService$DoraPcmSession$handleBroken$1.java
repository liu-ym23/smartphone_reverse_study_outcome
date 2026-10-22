package com.obric.assistant.dora.record_minutes;

import com.larus.avlink.api.IDoraAVLinkService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.dora.record_minutes.DoraRecordMinutesService$DoraPcmSession$handleBroken$1", f = "DoraRecordMinutesService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class DoraRecordMinutesService$DoraPcmSession$handleBroken$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;
    final /* synthetic */ DoraRecordMinutesService.c this$0;

    public DoraRecordMinutesService$DoraPcmSession$handleBroken$1(DoraRecordMinutesService.c r1, String r2, Continuation<? super DoraRecordMinutesService$DoraPcmSession$handleBroken$1> r3) {
        this.this$0 = r1;
        this.$reason = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraRecordMinutesService$DoraPcmSession$handleBroken$1(this.this$0, this.$reason, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r3) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L12;
        ResultKt.throwOnFailure(r3);
        FLogger.a.e("DoraRecordMinutesService", "Dora pcm session broken, sessionId=" + this.this$0.a + ", reason=" + this.$reason);
        if (DoraRecordMinutesService.g != this.this$0) goto L10;
        DoraRecordMinutesService r4 = DoraRecordMinutesService.a;
        DoraRecordMinutesService.g = null;
        DoraRecordMinutesService.c r5 = this.this$0;
        String r0 = this.$reason;
        r5.getClass();
        Intrinsics.checkNotNullParameter(r0, WindowEvent.Params.REASON);
        r5.d.a();
        r5.c.c(r0);
        DoraRecordMinutesService.a.getClass();
        DoraRecordMinutesService.j();
        IDoraAVLinkService r6 = (IDoraAVLinkService) ServiceManager.get().getService(IDoraAVLinkService.class);
        if (r6 == null) goto L10;
        r6.a(this.$reason);
    L10:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
