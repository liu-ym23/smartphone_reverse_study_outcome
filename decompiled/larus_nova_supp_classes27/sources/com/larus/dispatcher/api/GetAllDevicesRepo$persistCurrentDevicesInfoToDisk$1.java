package com.larus.dispatcher.api;

import com.bytedance.keva.Keva;
import com.larus.network.http.HttpExtKt;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo$persistCurrentDevicesInfoToDisk$1", f = "GetAllDevicesRepo.kt", i = {0}, l = {581}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
final class GetAllDevicesRepo$persistCurrentDevicesInfoToDisk$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $cacheVersion;
    final /* synthetic */ AllDeviceResponse $devicesInfo;
    final /* synthetic */ String $uid;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;

    public GetAllDevicesRepo$persistCurrentDevicesInfoToDisk$1(long r1, String r3, AllDeviceResponse r4, Continuation<? super GetAllDevicesRepo$persistCurrentDevicesInfoToDisk$1> r5) {
        this.$cacheVersion = r1;
        this.$uid = r3;
        this.$devicesInfo = r4;
        super(2, r5);
    }

    public final Continuation<Unit> create(Object r7, Continuation<?> r8) {
        return new GetAllDevicesRepo$persistCurrentDevicesInfoToDisk$1(this.$cacheVersion, this.$uid, this.$devicesInfo, r8);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r9) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        long r2 = this.J$0;
        AllDeviceResponse r3 = (AllDeviceResponse) this.L$2;
        String r4 = (String) this.L$1;
        kotlinx.coroutines.sync.a r5 = (kotlinx.coroutines.sync.a) this.L$0;
        ResultKt.throwOnFailure(r9);
    L28:
    L23:
        th = move-exception;
        r5.unlock(null);
        throw th;
    L14:
        if (GetAllDevicesRepo.g.get() == r2) goto L26;
    L20:
        Unit r10 = Unit.INSTANCE;     // Catch: Throwable -> L23
        r5.unlock(null);
        return Unit.INSTANCE;
    L26:
        GetAllDevicesRepo r11 = GetAllDevicesRepo.a;     // Catch: Exception -> L18 Throwable -> L23
        ((Keva) GetAllDevicesRepo.h.getValue()).storeString(r4, HttpExtKt.f.toJson(d.b(r3)));     // Catch: Exception -> L18 Throwable -> L23
    L18:
        e = move-exception;
        FLogger.a.e("GetAllDevicesRepo", "[persistCurrentDevicesInfoToDisk] write cache failed", e);     // Catch: Throwable -> L23
        goto L20
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r9);
        r5 = GetAllDevicesRepo.d;
        long r6 = this.$cacheVersion;
        r4 = this.$uid;
        AllDeviceResponse r12 = this.$devicesInfo;
        this.L$0 = r5;
        this.L$1 = r4;
        this.L$2 = r12;
        this.J$0 = r6;
        this.label = 1;
        if (r5.a(null, this) != r0) goto L11;
        return r0;
    L11:
        r3 = r12;
        r2 = r6;
        goto L28
    }
}
