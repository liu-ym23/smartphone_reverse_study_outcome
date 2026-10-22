package com.obric.miniapp.request;

import android.os.Bundle;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.event.WindowEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.request.QueryDayTypeRequest$handle$1", f = "QueryDayTypeRequest.kt", i = {0}, l = {44, 69}, m = "invokeSuspend", n = {WindowEvent.Params.RESULT}, s = {"L$0"})
final class QueryDayTypeRequest$handle$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    final /* synthetic */ Bundle $args;
    final /* synthetic */ String $target;
    Object L$0;
    int label;
    final /* synthetic */ g this$0;

    /* JADX INFO: renamed from: com.obric.miniapp.request.QueryDayTypeRequest$handle$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.request.QueryDayTypeRequest$handle$1$1", f = "QueryDayTypeRequest.kt", i = {}, l = {62}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        final /* synthetic */ long $date;
        final /* synthetic */ CompletableDeferred<Bundle> $result;
        final /* synthetic */ String $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ g this$0;

        public AnonymousClass1(String r1, CompletableDeferred<Bundle> r2, g r3, long r4, Continuation<? super AnonymousClass1> r6) {
            this.$target = r1;
            this.$result = r2;
            this.this$0 = r3;
            this.$date = r4;
            super(2, r6);
        }

        public final Continuation<Unit> create(Object r9, Continuation<?> r10) {
            AnonymousClass1 r7 = new AnonymousClass1(this.$target, this.$result, this.this$0, this.$date, r10);
            r7.L$0 = r9;
            return r7;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r18) {
            Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r2 = this.label;
            if (r2 == 0) goto L8;
            if (r2 != 1) goto L7;
            ResultKt.throwOnFailure(r18);
            return r18;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r18);
            final CoroutineScope r5 = (CoroutineScope) this.L$0;
            AppletRuntimeManager r3 = AppletRuntimeManager.INSTANCE;
            String r10 = this.$target;
            final g r6 = this.this$0;
            final long r7 = this.$date;
            final CompletableDeferred<Bundle> r9 = this.$result;
            AppletRuntimeManager.o(r3, r10, "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", null, null, null, new h(r5, r6, r7, r9), 56);
            CompletableDeferred<Bundle> r4 = this.$result;
            this.label = 1;
            Object r8 = r4.await(this);
            if (r8 != r1) goto L12;
            return r1;
        L12:
            return r8;
        }
    }

    public QueryDayTypeRequest$handle$1(Bundle r1, String r2, g r3, Continuation<? super QueryDayTypeRequest$handle$1> r4) {
        this.$args = r1;
        this.$target = r2;
        this.this$0 = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new QueryDayTypeRequest$handle$1(this.$args, this.$target, this.this$0, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [kotlinx.coroutines.CompletableDeferred, kotlinx.coroutines.Deferred, kotlinx.coroutines.Job] */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v7 */
    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r13);
    L24:
        return r13;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CompletableDeferred r2 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r13);     // Catch: TimeoutCancellationException -> L18
        r1 = r2;
    L16:
        return (Bundle) r13;
    L12:
        ResultKt.throwOnFailure(r13);
        CompletableDeferred r3 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        long r9 = this.$args.getLong("date", -1);
        AnonymousClass1 r14 = new AnonymousClass1(this.$target, r3, this.this$0, r9, null);     // Catch: TimeoutCancellationException -> L18
        this.L$0 = r3;     // Catch: TimeoutCancellationException -> L18
        this.label = 1;     // Catch: TimeoutCancellationException -> L18
        r13 = TimeoutKt.b(1500, r14, this);     // Catch: TimeoutCancellationException -> L18
        r1 = r3;
        if (r13 != r0) goto L16;
        return r0;
    L18:
        FLogger.a.e("queryHolidays", "handle request timeout");
        if (r1.isCompleted() == true) goto L21;
        r1.complete(null);
    L21:
        this.L$0 = null;
        this.label = 2;
        r13 = r1.await(this);
        if (r13 != r0) goto L24;
        return r0;
    }
}
