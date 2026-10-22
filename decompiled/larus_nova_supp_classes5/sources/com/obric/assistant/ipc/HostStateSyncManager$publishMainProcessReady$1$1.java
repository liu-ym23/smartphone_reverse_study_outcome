package com.obric.assistant.ipc;

import android.content.Context;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
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
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$publishMainProcessReady$1$1", f = "HostStateSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HostStateSyncManager$publishMainProcessReady$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ long $generation;
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public HostStateSyncManager$publishMainProcessReady$1$1(Context r1, Bundle r2, String r3, long r4, Continuation<? super HostStateSyncManager$publishMainProcessReady$1$1> r6) {
        this.$appContext = r1;
        this.$extras = r2;
        this.$reason = r3;
        this.$generation = r4;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
        HostStateSyncManager$publishMainProcessReady$1$1 r7 = new HostStateSyncManager$publishMainProcessReady$1$1(this.$appContext, this.$extras, this.$reason, this.$generation, r10);
        r7.L$0 = r9;
        return r7;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r9);
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        Context r11 = this.$appContext;
        Bundle r3 = this.$extras;
        String r4 = this.$reason;
        long r5 = this.$generation;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L7
        l.a(r11.getContentResolver(), "set-main-process-ready-binder", r3);     // Catch: Throwable -> L7
        FLogger.a.i("HostStateSyncManager", "main_process_ready_publish_success: reason=" + r4 + " generation=" + r5);     // Catch: Throwable -> L7
        Object r12 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r2 = this.$reason;
        long r6 = this.$generation;
        Throwable r13 = Result.exceptionOrNull-impl(r12);
        if (r13 == null) goto L13;
        FLogger.a.w("HostStateSyncManager", "main_process_ready_publish_failed: reason=" + r2 + " generation=" + r6 + " message=" + r13.getMessage(), r13);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r12 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
