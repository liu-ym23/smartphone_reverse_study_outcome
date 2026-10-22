package com.larus.dispatcher.api;

import android.os.SystemClock;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo$requestAllDevicesWithTimeControl$deferred$1$2", f = "GetAllDevicesRepo.kt", i = {}, l = {343, 346}, m = "invokeSuspend", n = {}, s = {})
public final class GetAllDevicesRepo$requestAllDevicesWithTimeControl$deferred$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AllDeviceResponse>, Object> {
    final /* synthetic */ String $caller;
    final /* synthetic */ int $requestIntervalInSecond;
    int label;

    public GetAllDevicesRepo$requestAllDevicesWithTimeControl$deferred$1$2(int r1, String r2, Continuation<? super GetAllDevicesRepo$requestAllDevicesWithTimeControl$deferred$1$2> r3) {
        this.$requestIntervalInSecond = r1;
        this.$caller = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
        return new GetAllDevicesRepo$requestAllDevicesWithTimeControl$deferred$1$2(this.$requestIntervalInSecond, this.$caller, r4);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AllDeviceResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r11) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L10;
        if (r1 == 1) goto L9;
        if (r1 != 2) goto L8;
        ResultKt.throwOnFailure(r11);
    L22:
        return r11;
    L8:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L9:
        ResultKt.throwOnFailure(r11);
    L19:
        GetAllDevicesRepo r12 = GetAllDevicesRepo.a;
        String r13 = this.$caller;
        this.label = 2;
        r11 = GetAllDevicesRepo.e(r13, this);
        if (r11 != r0) goto L22;
        return r0;
    L10:
        ResultKt.throwOnFailure(r11);
        long r4 = ((long) RangesKt.coerceAtLeast(this.$requestIntervalInSecond, 0)) * 1000;
        if (GetAllDevicesRepo.n <= 0) goto L13;
        long r5 = RangesKt.coerceAtLeast((GetAllDevicesRepo.n + r4) - SystemClock.elapsedRealtime(), 0);
    L15:
        if (r5 <= 0) goto L19;
        FLogger.a.i("GetAllDevicesRepo", "[requestAllDevicesWithTimeControl][" + this.$caller + "] pending " + r5 + "ms");
        this.label = 1;
        if (DelayKt.delay(r5, this) != r0) goto L19;
        return r0;
    L13:
        r5 = 0;
        goto L15
    }
}
