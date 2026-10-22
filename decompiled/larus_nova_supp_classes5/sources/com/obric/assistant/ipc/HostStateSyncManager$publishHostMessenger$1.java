package com.obric.assistant.ipc;

import android.content.Context;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.voice.c;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$publishHostMessenger$1", f = "HostStateSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HostStateSyncManager$publishHostMessenger$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public HostStateSyncManager$publishHostMessenger$1(Context r1, Bundle r2, String r3, Continuation<? super HostStateSyncManager$publishHostMessenger$1> r4) {
        this.$appContext = r1;
        this.$extras = r2;
        this.$reason = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
        HostStateSyncManager$publishHostMessenger$1 r0 = new HostStateSyncManager$publishHostMessenger$1(this.$appContext, this.$extras, this.$reason, r6);
        r0.L$0 = r5;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r6);
        CoroutineScope r7 = (CoroutineScope) this.L$0;
        Context r8 = this.$appContext;
        Bundle r2 = this.$extras;
        String r3 = this.$reason;
        Result.Companion r4 = Result.Companion;     // Catch: Throwable -> L7
        l.a(r8.getContentResolver(), "set-tracker-messenger", r2);     // Catch: Throwable -> L7
        FLogger.a.i("HostStateSyncManager", "publishHostMessenger reason=" + r3 + " generation=" + c.b);     // Catch: Throwable -> L7
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r1 = this.$reason;
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L13;
        FLogger.a.w("HostStateSyncManager", "publishHostMessenger failed reason=" + r1 + ": " + r10.getMessage(), r10);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
