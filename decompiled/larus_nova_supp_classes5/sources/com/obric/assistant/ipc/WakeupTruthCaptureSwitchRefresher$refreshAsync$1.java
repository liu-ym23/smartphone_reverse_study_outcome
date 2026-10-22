package com.obric.assistant.ipc;

import android.content.Context;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import org.json.JSONObject;
import sna.c;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.WakeupTruthCaptureSwitchRefresher$refreshAsync$1", f = "WakeupTruthCaptureSwitchRefresher.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class WakeupTruthCaptureSwitchRefresher$refreshAsync$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    int label;

    public WakeupTruthCaptureSwitchRefresher$refreshAsync$1(String r1, Continuation<? super WakeupTruthCaptureSwitchRefresher$refreshAsync$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new WakeupTruthCaptureSwitchRefresher$refreshAsync$1(this.$reason, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L27;
        ResultKt.throwOnFailure(r8);
        WakeupTruthCaptureSwitchRefresher r9 = WakeupTruthCaptureSwitchRefresher.a;
        String r0 = this.$reason;
        r9.getClass();
        Intrinsics.checkNotNullParameter(r0, "reason");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L13
        String r2 = t1.a.getObricFlowSettingsJson("obric_wakeup_audio_capture_config");     // Catch: Throwable -> L13
        boolean r3 = false;
        if (StringsKt.isBlank(r2) == false) goto L8;
    L11:
        Object r4 = Result.constructor-impl(Boolean.valueOf(r3));     // Catch: Throwable -> L13
    L15:
        Throwable r5 = Result.exceptionOrNull-impl(r4);
        if (r5 == null) goto L18;
        FLogger.a.e("WakeupTruthCaptureSwitchRefresher", "resolveCloudEnabled failed: " + r5.getMessage());
    L18:
        Boolean r6 = Boolean.FALSE;
        if (Result.isFailure-impl(r4) == false) goto L21;
        r4 = r6;
    L21:
        boolean r7 = ((Boolean) r4).booleanValue();
        boolean r10 = sna.i.a();
        Intrinsics.checkNotNullParameter(r0, "reason");
        Context r11 = sna.f.a;
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        c r12 = sna.f.b();
        r12.getClass();
        Intrinsics.checkNotNullParameter("wakeup_truth_capture_enabled", "key");
        r12.a().storeBoolean("wakeup_truth_capture_enabled", r7);
        if (r10 == r7) goto L24;
        Intrinsics.checkNotNullParameter(r0, "reason");
        IpcMessenger.k(IpcMessenger.a, 10, r7 ? 1 : 0, r0, 4);
    L24:
        FLogger.a.i("WakeupTruthCaptureSwitchRefresher", "refresh enabled=" + r7 + " reason=" + r0);
        return Unit.INSTANCE;
    L8:
        if (Intrinsics.areEqual(r2, "null") == true) goto L11;
        r3 = new JSONObject(r2).optBoolean("enable", false);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r4 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
