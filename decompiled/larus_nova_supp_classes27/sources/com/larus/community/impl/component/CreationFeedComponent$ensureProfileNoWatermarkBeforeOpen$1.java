package com.larus.community.impl.component;

import com.larus.platform.api.creation.UserCreation;
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
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.community.impl.component.CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1", f = "CreationFeedComponent.kt", i = {}, l = {912}, m = "invokeSuspend", n = {}, s = {})
final class CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $clickEnterMethod;
    final /* synthetic */ UserCreation $data;
    final /* synthetic */ int $position;
    final /* synthetic */ String $requestKey;
    int label;
    final /* synthetic */ CreationFeedComponent this$0;

    public CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1(UserCreation r1, CreationFeedComponent r2, String r3, int r4, String r5, Continuation<? super CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1> r6) {
        this.$data = r1;
        this.this$0 = r2;
        this.$requestKey = r3;
        this.$position = r4;
        this.$clickEnterMethod = r5;
        super(2, r6);
    }

    public final Continuation<Unit> create(Object r8, Continuation<?> r9) {
        return new CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1(this.$data, this.this$0, this.$requestKey, this.$position, this.$clickEnterMethod, r9);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r8) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L15;
        if (r2 != 1) goto L14;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
    L19:
        UserCreation r9 = (UserCreation) r8;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        CreationFeedComponent r0 = this.this$0;
    L21:
        r0.r.remove(this.$requestKey);
        CreationFeedComponent r3 = this.this$0;
        int r4 = this.$position;
        String r5 = this.$clickEnterMethod;
        int r6 = CreationFeedComponent.K;
        r3.D3(r4, r5, r9);
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r8);
        CoroutineDispatcher r10 = Dispatchers.getIO();     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1$selectedData$1 r7 = new CreationFeedComponent$ensureProfileNoWatermarkBeforeOpen$1$selectedData$1(this.$data, this.this$0, null);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        this.label = 1;     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        r8 = BuildersKt.withContext(r10, r7, this);     // Catch: Throwable -> L7 Exception -> L9 CancellationException -> L11
        if (r8 != r1) goto L19;
        return r1;
    L7:
        th = move-exception;
        this.this$0.r.remove(this.$requestKey);
        throw th;
    L9:
        e = move-exception;
        FLogger.a.w("CreationFeedComponent", "ensure profile detail no watermark failed, msg=" + e.getMessage());     // Catch: Throwable -> L7
        r9 = this.$data;     // Catch: Throwable -> L7
        r0 = this.this$0;
    L11:
        e = move-exception;
        throw e;     // Catch: Throwable -> L7
    }
}
