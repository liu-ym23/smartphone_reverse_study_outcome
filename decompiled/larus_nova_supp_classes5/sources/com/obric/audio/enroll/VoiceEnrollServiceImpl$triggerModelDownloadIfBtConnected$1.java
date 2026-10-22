package com.obric.audio.enroll;

import android.app.Application;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.sami.SamiEnrollEngine;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import sia.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.audio.enroll.VoiceEnrollServiceImpl$triggerModelDownloadIfBtConnected$1", f = "VoiceEnrollServiceImpl.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class VoiceEnrollServiceImpl$triggerModelDownloadIfBtConnected$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public VoiceEnrollServiceImpl$triggerModelDownloadIfBtConnected$1(Continuation<? super VoiceEnrollServiceImpl$triggerModelDownloadIfBtConnected$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        VoiceEnrollServiceImpl$triggerModelDownloadIfBtConnected$1 r0 = new VoiceEnrollServiceImpl$triggerModelDownloadIfBtConnected$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L24;
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L16
        b r8 = b.a;     // Catch: Throwable -> L16
        Application r1 = AppHost.a.getApplication();     // Catch: Throwable -> L16
        r8.getClass();     // Catch: Throwable -> L16
        String r9 = b.c(r1);     // Catch: Throwable -> L16
        if (r9 != null) goto L8;
    L11:
        boolean r10 = true;
    L12:
        if (r10 == true) goto L14;
        FLogger.a.i("VoiceEnrollServiceImpl", "triggerModelDownloadIfBtConnected");     // Catch: Throwable -> L16
        SamiEnrollEngine.a.getClass();     // Catch: Throwable -> L16
        SamiEnrollEngine.D("service_init_bt_connected");     // Catch: Throwable -> L16
    L14:
        Object r11 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r12 = Result.exceptionOrNull-impl(r11);
        if (r12 == null) goto L22;
        FLogger.a.e("VoiceEnrollServiceImpl", "triggerModelDownloadIfBtConnected failed: " + r12.getMessage());
    L22:
        return Unit.INSTANCE;
    L8:
        if (StringsKt.isBlank(r9) == true) goto L11;
        r10 = false;
    L16:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        r11 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L18
    L24:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
