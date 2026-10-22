package com.obric.assistant.ipc;

import android.os.Message;
import com.larus.utils.logger.FLogger;
import com.obric.sva.proxy.utils.InteractConst;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.IpcMessenger$3", f = "IpcMessenger.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
public final class IpcMessenger$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;

    public static final class a<T> implements FlowCollector {
        public static final a<T> a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final Object emit(Object r4, Continuation r5) {
            Message r6 = (Message) r4;
            FLogger.a.e("IpcMessenger", "SvaSdkIPC collecting message :" + r6 + " -- hashCode " + r6.hashCode() + " -- thread " + ThreadMethodProxy.currentThread() + " - threadhash:" + ThreadMethodProxy.currentThread().hashCode() + ' ');
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L5
            Object r8 = Result.constructor-impl(Boxing.boxBoolean(IpcMessenger.i.sendMessage(r6)));     // Catch: Throwable -> L5
        L7:
            Throwable r9 = Result.exceptionOrNull-impl(r8);
            if (r9 == null) goto L11;
            FLogger.a.e("IpcMessenger", "SvaSdkIPC onFailure :" + r9);
        L11:
            return Unit.INSTANCE;
        L5:
            th = move-exception;
            Result.Companion r10 = Result.Companion;
            r8 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L7
        }
    }

    public IpcMessenger$3(Continuation<? super IpcMessenger$3> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new IpcMessenger$3(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r4) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r4);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r4);
        InteractConst.a.getClass();
        MutableSharedFlow r5 = InteractConst.a();
        FlowCollector r2 = a.a;
        this.label = 1;
        if (r5.collect(r2, this) != r0) goto L12;
        return r0;
    }
}
