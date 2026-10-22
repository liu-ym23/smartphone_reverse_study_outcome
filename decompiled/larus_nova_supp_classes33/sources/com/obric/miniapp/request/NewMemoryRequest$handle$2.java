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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.miniapp.request.NewMemoryRequest$handle$2", f = "NewMemoryRequest.kt", i = {0}, l = {59, 90}, m = "invokeSuspend", n = {WindowEvent.Params.RESULT}, s = {"L$0"})
final class NewMemoryRequest$handle$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
    final /* synthetic */ String $payload;
    final /* synthetic */ String $target;
    Object L$0;
    int label;
    final /* synthetic */ c this$0;

    /* JADX INFO: renamed from: com.obric.miniapp.request.NewMemoryRequest$handle$2$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Landroid/os/Bundle;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.miniapp.request.NewMemoryRequest$handle$2$1", f = "NewMemoryRequest.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Bundle>, Object> {
        final /* synthetic */ String $payload;
        final /* synthetic */ CompletableDeferred<Bundle> $result;
        final /* synthetic */ String $target;
        private /* synthetic */ Object L$0;
        int label;
        final /* synthetic */ c this$0;

        public AnonymousClass1(String r1, CompletableDeferred<Bundle> r2, c r3, String r4, Continuation<? super AnonymousClass1> r5) {
            this.$target = r1;
            this.$result = r2;
            this.this$0 = r3;
            this.$payload = r4;
            super(2, r5);
        }

        public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
            AnonymousClass1 r6 = new AnonymousClass1(this.$target, this.$result, this.this$0, this.$payload, r9);
            r6.L$0 = r8;
            return r6;
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
            String r4 = this.$target;
            final c r2 = this.this$0;
            final String r10 = this.$payload;
            final CompletableDeferred<Bundle> r11 = this.$result;
            AppletRuntimeManager.o(r3, r4, "SYSTEM_CVS_ID", "SYSTEM_CVS_ID", null, null, null, new d(r15, r2, r10, r11), 56);
            CompletableDeferred<Bundle> r16 = this.$result;
            this.label = 1;
            r14 = r16.await(this);
            if (r14 != r0) goto L11;
            return r0;
        }
    }

    public NewMemoryRequest$handle$2(String r1, c r2, String r3, Continuation<? super NewMemoryRequest$handle$2> r4) {
        this.$target = r1;
        this.this$0 = r2;
        this.$payload = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new NewMemoryRequest$handle$2(this.$target, this.this$0, this.$payload, r5);
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
    public final Object invokeSuspend(Object r12) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        ?? r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r12);
    L24:
        return r12;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        CompletableDeferred r2 = (CompletableDeferred) this.L$0;
        ResultKt.throwOnFailure(r12);     // Catch: TimeoutCancellationException -> L18
        r1 = r2;
    L16:
        return (Bundle) r12;
    L12:
        ResultKt.throwOnFailure(r12);
        CompletableDeferred r3 = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
        AnonymousClass1 r13 = new AnonymousClass1(this.$target, r3, this.this$0, this.$payload, null);     // Catch: TimeoutCancellationException -> L18
        this.L$0 = r3;     // Catch: TimeoutCancellationException -> L18
        this.label = 1;     // Catch: TimeoutCancellationException -> L18
        r12 = TimeoutKt.b(1500, r13, this);     // Catch: TimeoutCancellationException -> L18
        r1 = r3;
        if (r12 != r0) goto L16;
        return r0;
    L18:
        FLogger.a.e("NewMemoryRequest", "handle request timeout");
        if (r1.isCompleted() == true) goto L21;
        Bundle r14 = new Bundle();
        r14.putInt(WindowEvent.Params.RESULT, 0);
        r1.complete(r14);
    L21:
        this.L$0 = null;
        this.label = 2;
        r12 = r1.await(this);
        if (r12 != r0) goto L24;
        return r0;
    }
}
