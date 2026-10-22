package com.obric.assistant.ipc;

import android.content.Context;
import android.os.Bundle;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
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
@DebugMetadata(c = "com.obric.assistant.ipc.BypassAdaptiveSidPusher$push$1", f = "SvaSdkIPCService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class BypassAdaptiveSidPusher$push$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $appContext;
    final /* synthetic */ String $from;
    int label;

    public BypassAdaptiveSidPusher$push$1(Context r1, String r2, Continuation<? super BypassAdaptiveSidPusher$push$1> r3) {
        this.$appContext = r1;
        this.$from = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new BypassAdaptiveSidPusher$push$1(this.$appContext, this.$from, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r10) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L22;
        ResultKt.throwOnFailure(r10);
        Context r11 = this.$appContext;
        String r2 = this.$from;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L14
        boolean r4 = t1.a.isBypassAdaptiveSid();     // Catch: Throwable -> L14
        Bundle r5 = new Bundle();     // Catch: Throwable -> L14
        boolean r6 = false;
        if (r4 == false) goto L8;
        boolean r8 = true;
    L9:
        r5.putBoolean("status", r8);     // Catch: Throwable -> L14
        l.a(r11.getContentResolver(), "set-bypass-adaptive-sid", r5);     // Catch: Throwable -> L14
        FLogger r12 = FLogger.a;     // Catch: Throwable -> L14
        StringBuilder r7 = new StringBuilder("push from=");     // Catch: Throwable -> L14
        r7.append(r2);     // Catch: Throwable -> L14
        r7.append(" bypass=");     // Catch: Throwable -> L14
        if (r4 == false) goto L12;
        r6 = true;
    L12:
        r7.append(r6);     // Catch: Throwable -> L14
        r12.i("BypassAdaptiveSidPusher", r7.toString());     // Catch: Throwable -> L14
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
    L16:
        String r1 = this.$from;
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L20;
        FLogger.a.e("BypassAdaptiveSidPusher", "push failed from=" + r1 + ": " + r14.getMessage());
    L20:
        return Unit.INSTANCE;
    L8:
        r8 = false;
    L14:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L16
    L22:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
