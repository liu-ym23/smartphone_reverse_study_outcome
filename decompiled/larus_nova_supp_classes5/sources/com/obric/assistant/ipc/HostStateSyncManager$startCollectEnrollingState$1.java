package com.obric.assistant.ipc;

import com.larus.audio.AudioServiceDelegate;
import com.larus.home.impl.sdk.s;
import com.larus.platform.IFlowSdkDepend;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import kotlin.KotlinNothingValueException;
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
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlowImpl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$startCollectEnrollingState$1", f = "HostStateSyncManager.kt", i = {}, l = {357}, m = "invokeSuspend", n = {}, s = {})
final class HostStateSyncManager$startCollectEnrollingState$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;
    int label;

    public static final class a<T> implements FlowCollector {
        public final /* synthetic */ CoroutineScope a;

        public a(CoroutineScope r1) {
            this.a = r1;
        }

        public final Object emit(Object r4, Continuation r5) {
            boolean r6 = ((Boolean) r4).booleanValue();
            FLogger.a.i("HostStateSyncManager", "enrollingState changed to " + r6);
            Result.Companion r7 = Result.Companion;     // Catch: Throwable -> L14
            if (AudioServiceDelegate.a.isDoraConnected() == false) goto L12;
            IFlowSdkDepend r8 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);     // Catch: Throwable -> L14
            if (r8 == null) goto L12;
            s r9 = r8.s0();     // Catch: Throwable -> L14
            if (r9 == null) goto L12;
            if (r6 == true) goto L11;
            r9.j();     // Catch: Throwable -> L14
            goto L12
        L11:
            r9.g();     // Catch: Throwable -> L14
        L12:
            Object r10 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L14
        L16:
            Throwable r11 = Result.exceptionOrNull-impl(r10);
            if (r11 == null) goto L20;
            FLogger.a.e("HostStateSyncManager", "enrollingState dispatch failed: " + r11.getMessage(), r11);
        L20:
            return Unit.INSTANCE;
        L14:
            th = move-exception;
            Result.Companion r12 = Result.Companion;
            r10 = Result.constructor-impl(ResultKt.createFailure(th));
            goto L16
        }
    }

    public HostStateSyncManager$startCollectEnrollingState$1(Continuation<? super HostStateSyncManager$startCollectEnrollingState$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
        HostStateSyncManager$startCollectEnrollingState$1 r0 = new HostStateSyncManager$startCollectEnrollingState$1(r3);
        r0.L$0 = r2;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r5) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L6;
        ResultKt.throwOnFailure(r5);
    L12:
        throw new KotlinNothingValueException();
    L6:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r5);
        CoroutineScope r6 = (CoroutineScope) this.L$0;
        IpcMessenger.a.getClass();
        StateFlowImpl r2 = IpcMessenger.d;
        a r3 = new a(r6);
        this.label = 1;
        if (r2.collect(r3, this) != r0) goto L12;
        return r0;
    }
}
