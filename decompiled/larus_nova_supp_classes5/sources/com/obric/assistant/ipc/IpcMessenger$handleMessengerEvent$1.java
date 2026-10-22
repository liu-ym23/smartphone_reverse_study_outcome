package com.obric.assistant.ipc;

import com.larus.utils.logger.FLogger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.IpcMessenger$handleMessengerEvent$1", f = "IpcMessenger.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
final class IpcMessenger$handleMessengerEvent$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public IpcMessenger$handleMessengerEvent$1(Continuation<? super IpcMessenger$handleMessengerEvent$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new IpcMessenger$handleMessengerEvent$1(r2);
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
        if (r1 == 0) goto L8;
        if (r1 == 1) goto L8;
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
    L9:
        ArrayBlockingQueue r7 = IpcMessenger.m;
        if ((!r7.isEmpty()) == false) goto L19;
        IpcMessenger.a r8 = (IpcMessenger.a) r7.poll(1, TimeUnit.SECONDS);
        FLogger.a.e("IpcMessenger", "SvaSdkIPC onSendEventToInteractor ..the binder is connected , so need send the cached event " + r8);
        if (r8 == null) goto L9;
        IpcMessenger.a.getClass();
        if (IpcMessenger.g(r8) == true) goto L9;
        IpcMessenger.e(r8);
        this.label = 1;
        if (DelayKt.delay(5000, this) != r0) goto L9;
        return r0;
    L19:
        return Unit.INSTANCE;
    }
}
