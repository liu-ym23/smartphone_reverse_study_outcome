package com.larus.dorag.widget;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dorag.widget.DoraWidgetEntryManager$launchPreviewUpdate$1", f = "DoraWidgetEntryManager.kt", i = {}, l = {129}, m = "invokeSuspend", n = {}, s = {})
final class DoraWidgetEntryManager$launchPreviewUpdate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $requestGeneration;
    int label;

    public DoraWidgetEntryManager$launchPreviewUpdate$1(long r1, Continuation<? super DoraWidgetEntryManager$launchPreviewUpdate$1> r3) {
        this.$requestGeneration = r1;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new DoraWidgetEntryManager$launchPreviewUpdate$1(this.$requestGeneration, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L13;
        if (r1 != 1) goto L12;
        ResultKt.throwOnFailure(r6);     // Catch: Exception -> L7 CancellationException -> L9
    L21:
    L19:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r6);
        DoraWidgetEntryManager r7 = DoraWidgetEntryManager.a;     // Catch: Exception -> L7 CancellationException -> L9
        long r3 = this.$requestGeneration;     // Catch: Exception -> L7 CancellationException -> L9
        this.label = 1;     // Catch: Exception -> L7 CancellationException -> L9
        if (DoraWidgetEntryManager.a(r7, r3, this) != r0) goto L21;
        return r0;
    L9:
        e = move-exception;
        throw e;
    L7:
        e = move-exception;
        FLogger.a.e("DoraWidgetEntryManager", "updateWidgetPreview failed", e);
        goto L19
    }
}
