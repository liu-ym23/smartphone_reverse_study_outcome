package com.obric.capabilitykit;

import android.content.res.AssetFileDescriptor;
import android.os.Process;
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
@DebugMetadata(c = "com.obric.capabilitykit.execution.fileaccess.receiver.UriFileOpener$open$2", f = "UriFileOpener.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class u$c extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public int a;
    public final /* synthetic */ AssetFileDescriptor b;
    public final /* synthetic */ y c;
    public final /* synthetic */ int d;

    public u$c(AssetFileDescriptor r1, y r2, int r3, Continuation<? super u$c> r4) {
        this.b = r1;
        this.c = r2;
        this.d = r3;
        super(2, r4);
    }

    public final Object a(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        return new u$c(this.b, this.c, this.d, r5);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return a((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r8) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.a != 0) goto L27;
        ResultKt.throwOnFailure(r8);
        Logger.INSTANCE.i("UriFileOpener", "returning & closing opened fd/" + this.b.hashCode() + " to the receiver: " + this.c.c + " ---> URI " + this.c.a);
        this.c.b.onSessionReady(new UriFileAccessSession(0, "成功", this.b));     // Catch: Throwable -> L7
        Object r9 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L7
    L9:
        Throwable r10 = Result.exceptionOrNull-impl(r9);
        if (r10 == null) goto L12;
        Logger.INSTANCE.e("UriFileOpener", "cannot notify opened fd to the receiver; e=" + r10, r10);
    L12:
        int r11 = this.d;
        AssetFileDescriptor r2 = this.b;
        y r4 = this.c;
        int r5 = Process.myPid();     // Catch: Throwable -> L19
        if (r11 != r5) goto L16;
        Logger r0 = Logger.INSTANCE;     // Catch: Throwable -> L19
        String r12 = "not closing fd because the sharer/receiver are with the same PID (" + r11 + ").";     // Catch: Throwable -> L19
    L17:
        r0.d("UriFileOpener", r12);     // Catch: Throwable -> L19
        Object r13 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L21:
        AssetFileDescriptor r1 = this.b;
        Throwable r14 = Result.exceptionOrNull-impl(r13);
        if (r14 == null) goto L25;
        Logger.INSTANCE.e("UriFileOpener", "cannot close opened fd/" + r1.hashCode() + "; e=" + r14, r14);
    L25:
        return Unit.INSTANCE;
    L16:
        r2.close();     // Catch: Throwable -> L19
        Logger r3 = Logger.INSTANCE;     // Catch: Throwable -> L19
        r12 = "sharer closed the shared fd/" + r2.hashCode() + " for URI: " + r4.a + "; rcvPid=" + r11 + "; myPid=" + r5 + '.';     // Catch: Throwable -> L19
        r0 = r3;
    L19:
        th = move-exception;
        r13 = Result.constructor-impl(ResultKt.createFailure(th));
    L7:
        th = move-exception;
        r9 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L9
    L27:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
