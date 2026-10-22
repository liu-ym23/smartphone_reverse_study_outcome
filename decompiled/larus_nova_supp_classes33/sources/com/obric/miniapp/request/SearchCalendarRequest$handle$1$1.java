package com.obric.miniapp.request;

import android.os.Bundle;
import com.bytedance.ai.model.AppletRuntimeManager;
import com.google.gson.JsonObject;
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
@DebugMetadata(c = "com.obric.miniapp.request.SearchCalendarRequest$handle$1$1", f = "SearchCalendarRequest.kt", i = {0}, l = {67, 92}, m = "invokeSuspend", n = {WindowEvent.Params.RESULT}, s = {"L$0"})
public final class SearchCalendarRequest$handle$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    final /* synthetic */ JsonObject $params;
    Object L$0;
    int label;
    final /* synthetic */ SearchCalendarRequest this$0;

    /* JADX INFO: renamed from: com.obric.miniapp.request.SearchCalendarRequest$handle$1$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.request.SearchCalendarRequest$handle$1$1$1", f = "SearchCalendarRequest.kt", i = {}, l = {85}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        final /* synthetic */ JsonObject $params;
        final /* synthetic */ CompletableDeferred<Bundle> $result;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ SearchCalendarRequest this$0;

        public AnonymousClass1(CompletableDeferred<Bundle> r1, SearchCalendarRequest r2, JsonObject r3, Continuation<? super AnonymousClass1> r4) {
            this.$result = r1;
            this.this$0 = r2;
            this.$params = r3;
            super(2, r4);
        }

        public final Continuation<Unit> create(Object r5, Continuation<?> r6) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$result, this.this$0, this.$params, r6);
            r0.L$0 = r5;
            return r0;
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((CoroutineScope) r1, (Continuation) r2);
        }

        public final Object invoke(CoroutineScope r1, Continuation<? super Bundle> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public final Object invokeSuspend(Object r14) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r14);
        L11:
            return r14;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r14);
            final CoroutineScope r15 = (CoroutineScope) this.L$0;
            AppletRuntimeManager r3 = AppletRuntimeManager.INSTANCE;
            final SearchCalendarRequest r2 = this.this$0;
            final JsonObject r10 = this.$params;
            final CompletableDeferred<Bundle> r11 = this.$result;
            AppletRuntimeManager.o(r3, "com.flow.calendar", "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", null, null, null, new k(r15, r2, r10, r11), 56);
            CompletableDeferred<Bundle> r16 = this.$result;
            this.label = 1;
            r14 = r16.await(this);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    public SearchCalendarRequest$handle$1$1(SearchCalendarRequest r1, JsonObject r2, Continuation<? super SearchCalendarRequest$handle$1$1> r3) {
        this.this$0 = r1;
        this.$params = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new SearchCalendarRequest$handle$1$1(this.this$0, this.$params, r4);
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
    public final Object invokeSuspend(Object r8) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r8);
    L24:
        return r8;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CompletableDeferred r2 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r8);     // Catch: TimeoutCancellationException -> L18
        r1 = r2;
    L16:
        return (Bundle) r8;
    L12:
        ResultKt.throwOnFailure(r8);
        CompletableDeferred r3 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        AnonymousClass1 r9 = new AnonymousClass1(r3, this.this$0, this.$params, null);     // Catch: TimeoutCancellationException -> L18
        this.L$0 = r3;     // Catch: TimeoutCancellationException -> L18
        this.label = 1;     // Catch: TimeoutCancellationException -> L18
        r8 = TimeoutKt.b(1500, r9, this);     // Catch: TimeoutCancellationException -> L18
        r1 = r3;
        if (r8 != r0) goto L16;
        return r0;
    L18:
        FLogger.a.e("SearchCalendarRequest", "handle request timeout");
        if (r1.isCompleted() == true) goto L21;
        r1.complete(null);
    L21:
        this.L$0 = null;
        this.label = 2;
        r8 = r1.await(this);
        if (r8 != r0) goto L24;
        return r0;
    }
}
