package com.obric.capabilitykit;

import com.obric.capabilitykit.common.execution.fileaccess.UriFileAccessSession;
import com.obric.capabilitykit.logger.Logger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import wia.y;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\u008a@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$1", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u$b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ y b;

    public u$b(y r1, Continuation<? super u$b> r2) {
        this.b = r1;
        super(2, r2);
    }

    public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        return new u$b(this.b, r3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return a((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.a != 0) goto L15;
        ResultKt.throwOnFailure(r6);
        Logger.INSTANCE.e("UriFileOpener", "return failure to the receiver: " + this.b.c + " ---> URI " + this.b.a);
        y r7 = this.b;
        r7.b.onSessionReady(new UriFileAccessSession(4, "分享方未能开启 URI = " + r7.a, 4));     // Catch: Throwable -> L7
        Object r8 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r9 = Result.exceptionOrNull-impl(r8);
        if (r9 == null) goto L13;
        Logger.INSTANCE.e("UriFileOpener", "cannot notify failure to the receiver; e=" + r9, r9);
    L13:
        return Unit.INSTANCE;
    L7:
        th = move-exception;
        r8 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
