package com.larus.dispatcher.api;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo$getOrRequestAllDevices$2", f = "GetAllDevicesRepo.kt", i = {0, 0, 1, 2, 2}, l = {581, 377, 591}, m = "invokeSuspend", n = {"$this$coroutineScope", "$this$withLock_u24default$iv", "deferred", "deferred", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$0", "L$2"})
public final class GetAllDevicesRepo$getOrRequestAllDevices$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AllDeviceResponse>, Object> {
    final /* synthetic */ String $caller;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public GetAllDevicesRepo$getOrRequestAllDevices$2(String r1, Continuation<? super GetAllDevicesRepo$getOrRequestAllDevices$2> r2) {
        this.$caller = r1;
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        GetAllDevicesRepo$getOrRequestAllDevices$2 r0 = new GetAllDevicesRepo$getOrRequestAllDevices$2(this.$caller, r4);
        r0.L$0 = r3;
        return r0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AllDeviceResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r14) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L12;
        if (r1 == 1) goto L11;
        if (r1 == 2) goto L10;
        if (r1 != 3) goto L9;
        kotlinx.coroutines.sync.a r2 = (kotlinx.coroutines.sync.a) this.L$2;
        Object r3 = this.L$1;
        Deferred<AllDeviceResponse> r4 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r14);
    L44:
    L38:
        th = move-exception;
        r2.unlock(null);
        throw th;
    L33:
        if (GetAllDevicesRepo.i != r4) goto L35;
        GetAllDevicesRepo.i = null;     // Catch: Throwable -> L38
    L35:
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L38
        r2.unlock(null);
        return r3;
    L9:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L10:
        Deferred<AllDeviceResponse> r5 = (Deferred) this.L$0;
        ResultKt.throwOnFailure(r14);
    L28:
        AllDeviceResponse r6 = (AllDeviceResponse) r14;
        kotlinx.coroutines.sync.a r7 = GetAllDevicesRepo.c;
        this.L$0 = r5;
        this.L$1 = r14;
        this.L$2 = r7;
        this.label = 3;
        if (r7.a(null, this) != r0) goto L31;
        return r0;
    L31:
        r4 = r5;
        r2 = r7;
        r3 = r14;
        goto L44
    L11:
        String r8 = (String) this.L$2;
        kotlinx.coroutines.sync.a r9 = (kotlinx.coroutines.sync.a) this.L$1;
        CoroutineScope r10 = (CoroutineScope) this.L$0;
        ResultKt.throwOnFailure(r14);
    L46:
        Deferred<AllDeviceResponse> r16 = GetAllDevicesRepo.i;     // Catch: Throwable -> L41
        if (r16 != null) goto L19;
    L23:
        r16 = BuildersKt.async$default(r10, null, null, new GetAllDevicesRepo$getOrRequestAllDevices$2$deferred$1$2(r8, null), 3, null);     // Catch: Throwable -> L41
        GetAllDevicesRepo.i = r16;     // Catch: Throwable -> L41
    L24:
        r9.unlock(null);
        this.L$0 = r16;
        this.L$1 = null;
        this.L$2 = null;
        this.label = 2;
        Object r11 = r16.await(this);
        if (r11 != r0) goto L27;
        return r0;
    L27:
        r5 = r16;
        r14 = r11;
        goto L28
    L19:
        if (r16.isActive() == true) goto L22;
        r16 = null;
    L22:
        if (r16 != null) goto L24;
    L41:
        th = move-exception;
        r9.unlock(null);
        throw th;
    L12:
        ResultKt.throwOnFailure(r14);
        r10 = (CoroutineScope) this.L$0;
        kotlinx.coroutines.sync.a r17 = GetAllDevicesRepo.c;
        r8 = this.$caller;
        this.L$0 = r10;
        this.L$1 = r17;
        this.L$2 = r8;
        this.label = 1;
        if (r17.a(null, this) != r0) goto L15;
        return r0;
    L15:
        r9 = r17;
        goto L46
    }
}
