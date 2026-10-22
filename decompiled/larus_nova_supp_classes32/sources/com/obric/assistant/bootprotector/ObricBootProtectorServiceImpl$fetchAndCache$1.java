package com.obric.assistant.bootprotector;

import com.larus.utils.logger.FLogger;
import com.obric.aivoice.core.data.NameKeys;
import com.obric.assistant.AutoEndConversationTime;
import com.obric.update.api.v2.IObricUpdateService;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes32.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", NameKeys.UnloadStrategy_No_Strategy, "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.bootprotector.ObricBootProtectorServiceImpl$fetchAndCache$1", f = "ObricBootProtectorServiceImpl.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
public final class ObricBootProtectorServiceImpl$fetchAndCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    final /* synthetic */ IObricUpdateService $updateService;
    Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ ObricBootProtectorServiceImpl this$0;

    public ObricBootProtectorServiceImpl$fetchAndCache$1(ObricBootProtectorServiceImpl r1, String r2, IObricUpdateService r3, Continuation<? super ObricBootProtectorServiceImpl$fetchAndCache$1> r4) {
        this.this$0 = r1;
        this.$reason = r2;
        this.$updateService = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new ObricBootProtectorServiceImpl$fetchAndCache$1(this.this$0, this.$reason, this.$updateService, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = this.label;
        if (r3 == 0) goto L10;
        if (r3 != 1) goto L9;
        ObricBootProtectorServiceImpl r1 = (ObricBootProtectorServiceImpl) this.L$1;
        String r4 = (String) this.L$0;
        ResultKt.throwOnFailure(r10);     // Catch: Throwable -> L20
    L15:
        String r11 = (String) r10;     // Catch: Throwable -> L20
        r1.b.set(r11);     // Catch: Throwable -> L20
        FLogger.a.i("ObricBootProtectorService", "fetchAndCache end(" + r4 + "), hasValidUrl=" + ObricBootProtectorServiceImpl.i(r11));     // Catch: Throwable -> L20
        if (ObricBootProtectorServiceImpl.i(r11) == false) goto L18;
        r1.a();     // Catch: Throwable -> L20
    L18:
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        String r0 = this.$reason;
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L25;
        FLogger.a.e("ObricBootProtectorService", "fetchAndCache failed(" + r0 + "): " + r13);
    L25:
        this.this$0.c = 0;
        return Unit.INSTANCE;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        ResultKt.throwOnFailure(r10);
        String r14 = this.$reason;
        ObricBootProtectorServiceImpl r5 = this.this$0;
        IObricUpdateService r6 = this.$updateService;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L20
        FLogger.a.i("ObricBootProtectorService", "fetchAndCache start(" + r14 + ')');     // Catch: Throwable -> L20
        ObricBootProtectorServiceImpl$fetchAndCache$1$1$url$1 r8 = new ObricBootProtectorServiceImpl$fetchAndCache$1$1$url$1(r6, null);     // Catch: Throwable -> L20
        this.L$0 = r14;     // Catch: Throwable -> L20
        this.L$1 = r5;     // Catch: Throwable -> L20
        this.label = 1;     // Catch: Throwable -> L20
        Object r9 = TimeoutKt.c(AutoEndConversationTime.AFTER_60_SECONDS, r8, this);     // Catch: Throwable -> L20
        if (r9 != r2) goto L14;
        return r2;
    L14:
        r4 = r14;
        r10 = r9;
        r1 = r5;
    L20:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    }
}
