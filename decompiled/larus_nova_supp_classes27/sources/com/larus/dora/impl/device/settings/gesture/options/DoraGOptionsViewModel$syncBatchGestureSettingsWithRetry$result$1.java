package com.larus.dora.impl.device.settings.gesture.options;

import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.device.settings.gesture.DoraGGestureSettings;
import java.util.List;
import java.util.concurrent.CancellationException;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dora.impl.device.settings.gesture.options.DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$result$1", f = "DoraGOptionsViewModel.kt", i = {}, l = {403}, m = "invokeSuspend", n = {}, s = {})
public final class DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ List<DoraGGestureSettings> $settings;
    int label;

    public DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$result$1(List<DoraGGestureSettings> r1, Continuation<? super DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$result$1> r2) {
        this.$settings = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new DoraGOptionsViewModel$syncBatchGestureSettingsWithRetry$result$1(this.$settings, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Integer> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L9;
        if (r1 != 1) goto L8;
        ResultKt.throwOnFailure(r4);     // Catch: Exception -> L15 CancellationException -> L19
    L13:
        int r5 = ((Number) r4).intValue();     // Catch: Exception -> L15 CancellationException -> L19
    L18:
        return Boxing.boxInt(r5);
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r4);
        kj4.a r6 = kj4.a.g();     // Catch: Exception -> L15 CancellationException -> L19
        List<DoraGGestureSettings> r2 = this.$settings;     // Catch: Exception -> L15 CancellationException -> L19
        this.label = 1;     // Catch: Exception -> L15 CancellationException -> L19
        r4 = DoraAdapterExtKt.J(r6, r2);     // Catch: Exception -> L15 CancellationException -> L19
        if (r4 != r0) goto L13;
        return r0;
    L19:
        e = move-exception;
        throw e;
    L15:
        e = move-exception;
        g49.d.c("DoraGOptionsViewModel", "setDoraGGestureSettings failed: settings=" + this.$settings, e);
        r5 = -1;
        goto L18
    }
}
