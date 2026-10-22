package com.larus.chat.gallery.impl.preview.toolbar.action;

import com.larus.chat.gallery.impl.preview.toolbar.PreviewToolbarView;
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
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.chat.gallery.impl.preview.toolbar.action.MarkAction$startLoadingJob$1", f = "MarkAction.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
final class MarkAction$startLoadingJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ l0 $context;
    int label;
    final /* synthetic */ MarkAction this$0;

    public MarkAction$startLoadingJob$1(l0 r1, MarkAction r2, Continuation<? super MarkAction$startLoadingJob$1> r3) {
        this.$context = r1;
        this.this$0 = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new MarkAction$startLoadingJob$1(this.$context, this.this$0, r4);
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
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L7 CancellationException -> L9
    L17:
        PreviewToolbarView r7 = this.$context.f;     // Catch: Throwable -> L7 CancellationException -> L9
        if (r7 == null) goto L23;
        r7.a(this.this$0.e, true);     // Catch: Throwable -> L7 CancellationException -> L9
    L23:
        return Unit.INSTANCE;
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L13:
        ResultKt.throwOnFailure(r6);
        this.label = 1;     // Catch: Throwable -> L7 CancellationException -> L9
        if (DelayKt.delay(500, this) != r0) goto L17;
        return r0;
    L9:
        e = move-exception;
        throw e;
    L7:
        th = move-exception;
        FLogger.a.e("MarkAction", "show mark loading failed", th);
        goto L23
    }
}
