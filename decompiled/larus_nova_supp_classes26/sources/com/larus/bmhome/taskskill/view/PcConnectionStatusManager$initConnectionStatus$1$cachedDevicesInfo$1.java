package com.larus.bmhome.taskskill.view;

import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.GetAllDevicesRepo;
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
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.view.PcConnectionStatusManager$initConnectionStatus$1$cachedDevicesInfo$1", f = "PcConnectionStatusManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class PcConnectionStatusManager$initConnectionStatus$1$cachedDevicesInfo$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AllDeviceResponse>, Object> {
    int label;

    public PcConnectionStatusManager$initConnectionStatus$1$cachedDevicesInfo$1(Continuation<? super PcConnectionStatusManager$initConnectionStatus$1$cachedDevicesInfo$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new PcConnectionStatusManager$initConnectionStatus$1$cachedDevicesInfo$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super AllDeviceResponse> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r2) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) goto L7;
        ResultKt.throwOnFailure(r2);
        GetAllDevicesRepo r3 = GetAllDevicesRepo.a;
        return GetAllDevicesRepo.d();
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
