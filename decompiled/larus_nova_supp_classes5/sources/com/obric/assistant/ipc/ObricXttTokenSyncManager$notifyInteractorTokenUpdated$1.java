package com.obric.assistant.ipc;

import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1", f = "ObricXttTokenSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1(String r1, Continuation<? super ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1 r0 = new ObricXttTokenSyncManager$notifyInteractorTokenUpdated$1(this.$reason, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r8);
        CoroutineScope r9 = (CoroutineScope) this.L$0;
        String r10 = this.$reason;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L7
        l.a(AppHost.a.getApplication().getApplicationContext().getContentResolver(), "notify-xtt-token-updated", com.larus.utils.f.c(new Pair[]{TuplesKt.to("reason", r10)}));     // Catch: Throwable -> L7
        FLogger.a.i("ObricXttTokenSyncManager", "notifyInteractorTokenUpdated reason=" + r10);     // Catch: Throwable -> L7
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r1 = this.$reason;
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L13;
        FLogger.a.w("ObricXttTokenSyncManager", "notifyInteractorTokenUpdated failed reason=" + r1 + ": " + r12.getMessage(), r12);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r3 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
