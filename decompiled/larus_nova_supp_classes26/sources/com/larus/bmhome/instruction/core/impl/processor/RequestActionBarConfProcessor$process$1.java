package com.larus.bmhome.instruction.core.impl.processor;

import aq8.a;
import com.larus.bmhome.actionbar.model.x0;
import com.larus.im.internal.delegate.c0;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.instruction.core.impl.processor.RequestActionBarConfProcessor$process$1", f = "RequestActionBarConfProcessor.kt", i = {}, l = {54}, m = "invokeSuspend", n = {}, s = {})
final class RequestActionBarConfProcessor$process$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $cvsId;
    final /* synthetic */ aq8.c.f $intent;
    int label;
    final /* synthetic */ f this$0;

    public RequestActionBarConfProcessor$process$1(f r1, String r2, aq8.c.f r3, Continuation<? super RequestActionBarConfProcessor$process$1> r4) {
        this.this$0 = r1;
        this.$cvsId = r2;
        this.$intent = r3;
        super(2, r4);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new RequestActionBarConfProcessor$process$1(this.this$0, this.$cvsId, this.$intent, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r6) {
        Object r1 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = this.label;
        if (r2 == 0) goto L9;
        if (r2 != 1) goto L8;
        ResultKt.throwOnFailure(r6);     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
    L13:
        x0 r7 = (x0) r6;     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
        if (r7 == null) goto L16;
        f.b(this.this$0, this.$cvsId, new a.c(r7));     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
    L26:
        this.this$0.c.remove(this.$cvsId);
        return Unit.INSTANCE;
    L16:
        f.b(this.this$0, this.$cvsId, new a.C0001a(null));     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
        goto L26
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r6);
        f.b(this.this$0, this.$cvsId, a.b.a);
        com.larus.bmhome.instruction.core.impl.repo.a r8 = new com.larus.bmhome.instruction.core.impl.repo.a();     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
        this.$intent.getClass();     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
        this.label = 1;     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
        r6 = com.larus.bmhome.instruction.core.impl.repo.a.a(r8, this);     // Catch: Throwable -> L18 Exception -> L20 CancellationException -> L22
        if (r6 != r1) goto L13;
        return r1;
    L18:
        th = move-exception;
        this.this$0.c.remove(this.$cvsId);
        throw th;
    L22:
        e = move-exception;
        throw e;     // Catch: Throwable -> L18
    L20:
        e = move-exception;
        c0.b.w("RequestActionBarConfProcessor", "requestActionBarConf error: " + e.getMessage());     // Catch: Throwable -> L18
        f.b(this.this$0, this.$cvsId, new a.C0001a(e));     // Catch: Throwable -> L18
        goto L26
    }
}
