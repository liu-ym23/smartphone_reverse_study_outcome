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
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$syncReportAccount$1", f = "HostStateSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class HostStateSyncManager$syncReportAccount$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ Bundle $extras;
    final /* synthetic */ String $reason;
    final /* synthetic */ String $userId;
    private /* synthetic */ Object L$0;
    int label;

    public HostStateSyncManager$syncReportAccount$1(Context r1, Bundle r2, String r3, String r4, Continuation<? super HostStateSyncManager$syncReportAccount$1> r5) {
        this.$appContext = r1;
        this.$extras = r2;
        this.$reason = r3;
        this.$userId = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        HostStateSyncManager$syncReportAccount$1 r6 = new HostStateSyncManager$syncReportAccount$1(this.$appContext, this.$extras, this.$reason, this.$userId, r9);
        r6.L$0 = r8;
        return r6;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L15;
        ResultKt.throwOnFailure(r7);
        CoroutineScope r8 = (CoroutineScope) this.L$0;
        Context r9 = this.$appContext;
        Bundle r2 = this.$extras;
        String r3 = this.$reason;
        String r4 = this.$userId;
        Result.Companion r5 = Result.Companion;     // Catch: Throwable -> L7
        l.a(r9.getContentResolver(), "set-report-account", r2);     // Catch: Throwable -> L7
        FLogger.a.i("HostStateSyncManager", "syncReportAccount reason=" + r3 + " userIdLen=" + r4.length());     // Catch: Throwable -> L7
        Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        String r1 = this.$reason;
        Throwable r11 = Result.exceptionOrNull-impl(r10);
        if (r11 == null) goto L13;
        FLogger.a.w("HostStateSyncManager", "syncReportAccount failed reason=" + r1 + ": " + r11.getMessage(), r11);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        Result.Companion r6 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
