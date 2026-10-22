package com.obric.assistant.ipc;

import com.larus.platform.service.o;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
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
import rna.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes5.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.ipc.HostStateSyncManager$refreshVoiceWakeupHostStateCache$1", f = "HostStateSyncManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
final class HostStateSyncManager$refreshVoiceWakeupHostStateCache$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $reason;
    private /* synthetic */ Object L$0;
    int label;

    public HostStateSyncManager$refreshVoiceWakeupHostStateCache$1(String r1, Continuation<? super HostStateSyncManager$refreshVoiceWakeupHostStateCache$1> r2) {
        this.$reason = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        HostStateSyncManager$refreshVoiceWakeupHostStateCache$1 r0 = new HostStateSyncManager$refreshVoiceWakeupHostStateCache$1(this.$reason, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L28;
        ResultKt.throwOnFailure(r13);
        CoroutineScope r14 = (CoroutineScope) this.L$0;
        String r15 = this.$reason;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L20
        String r4 = t1.a.p();     // Catch: Throwable -> L20
        b.c(r4);     // Catch: Throwable -> L20
        String r5 = t9a.b.b().b().a();     // Catch: Throwable -> L20
        if (r5 != null) goto L8;
        r5 = "";
    L8:
        boolean r6 = b.b(r5);     // Catch: Throwable -> L20
        o r7 = o.a;     // Catch: Throwable -> L20
        String r8 = r7.getDeviceId();     // Catch: Throwable -> L20
        boolean r9 = b.a(r8);     // Catch: Throwable -> L20
        boolean r10 = true;
        if (r9 == true) goto L14;
        HostStateSyncManager.a.getClass();     // Catch: Throwable -> L20
        if (HostStateSyncManager.f.compareAndSet(false, true) == false) goto L14;
        r7.e(new d());     // Catch: Throwable -> L20
    L14:
        FLogger r11 = FLogger.a;     // Catch: Throwable -> L20
        StringBuilder r12 = new StringBuilder("refreshVoiceWakeupHostStateCache reason=");     // Catch: Throwable -> L20
        r12.append(r15);     // Catch: Throwable -> L20
        r12.append(" thresholdSaved=true configLength=");     // Catch: Throwable -> L20
        r12.append(r4.length());     // Catch: Throwable -> L20
        r12.append(" osDeviceIdSaved=");     // Catch: Throwable -> L20
        if (r6 == true) goto L18;
        r10 = false;
    L18:
        r12.append(r10);     // Catch: Throwable -> L20
        r12.append(" osDeviceIdLength=");     // Catch: Throwable -> L20
        r12.append(r5.length());     // Catch: Throwable -> L20
        r12.append(" doubaoDidSaved=");     // Catch: Throwable -> L20
        r12.append(r9);     // Catch: Throwable -> L20
        r12.append(" doubaoDidLength=");     // Catch: Throwable -> L20
        r12.append(r8.length());     // Catch: Throwable -> L20
        r11.i("HostStateSyncManager", r12.toString());     // Catch: Throwable -> L20
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L20
    L22:
        String r0 = this.$reason;
        Throwable r17 = Result.exceptionOrNull-impl(r16);
        if (r17 == null) goto L26;
        FLogger.a.e("HostStateSyncManager", "refreshVoiceWakeupHostStateCache failed reason=" + r0 + ": " + r17.getMessage(), r17);
    L26:
        return Unit.INSTANCE;
    L20:
        th = move-exception;
        Result.Companion r1 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L28:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
