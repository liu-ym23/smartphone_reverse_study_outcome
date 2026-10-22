package com.larus.suggest.impl.wcb.request;

import com.larus.utils.logger.FLogger;
import com.tencent.open.log.TraceLevel;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/suggest/impl/wcb/request/WcbRequestResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
@DebugMetadata(c = "com.larus.suggest.impl.wcb.request.WcbNetworkRequester$request$task$1", f = "WcbNetworkRequester.kt", i = {}, l = {51}, m = "invokeSuspend", n = {}, s = {})
final class WcbNetworkRequester$request$task$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super e>, Object> {
    final /* synthetic */ long $apiStartTime;
    final /* synthetic */ b.a $key;
    final /* synthetic */ f $snapshot;
    int label;

    public WcbNetworkRequester$request$task$1(f r1, long r2, b.a r4, Continuation<? super WcbNetworkRequester$request$task$1> r5) {
        this.$snapshot = r1;
        this.$apiStartTime = r2;
        this.$key = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new WcbNetworkRequester$request$task$1(this.$snapshot, this.$apiStartTime, this.$key, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super e> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r7) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r7);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
    L13:
        b.b(this.$snapshot, (e) r7);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        e r8 = (e) r7;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        b.c.remove(this.$key);
        return r8;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r7);
        b r9 = b.a;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        f r3 = this.$snapshot;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        long r4 = this.$apiStartTime;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        this.label = 1;     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        r7 = b.a(r9, r3, r4, this);     // Catch: Throwable -> L16 Exception -> L18 CancellationException -> L21
        if (r7 != r1) goto L13;
        return r1;
    L16:
        th = move-exception;
        b.c.remove(this.$key);
        throw th;
    L21:
        e = move-exception;
        throw e;     // Catch: Throwable -> L16
    L18:
        e = move-exception;
        FLogger.a.e("WcbLog", "[network] failed exec=" + this.$snapshot.e + " error=" + e);     // Catch: Throwable -> L16
        throw e;     // Catch: Throwable -> L16
    }
}
