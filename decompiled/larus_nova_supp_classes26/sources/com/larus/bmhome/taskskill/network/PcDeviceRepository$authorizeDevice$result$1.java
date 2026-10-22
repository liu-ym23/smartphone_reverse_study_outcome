package com.larus.bmhome.taskskill.network;

import com.larus.dispatcher.api.AllDeviceResponse;
import com.larus.dispatcher.api.AuthorizeDeviceRequest;
import com.larus.dispatcher.api.GetAllDevicesApi;
import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u0001\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "Lcom/larus/dispatcher/api/GetAllDevicesApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.bmhome.taskskill.network.PcDeviceRepository$authorizeDevice$result$1", f = "PcDeviceRepository.kt", i = {}, l = {56}, m = "invokeSuspend", n = {}, s = {})
public final class PcDeviceRepository$authorizeDevice$result$1 extends SuspendLambda implements Function2<GetAllDevicesApi, Continuation<? super BizResponse<BizResponse<AllDeviceResponse>>>, Object> {
    final /* synthetic */ String $authTicket;
    final /* synthetic */ String $targetDeviceId;
    private /* synthetic */ Object L$0;
    int label;

    public PcDeviceRepository$authorizeDevice$result$1(String r1, String r2, Continuation<? super PcDeviceRepository$authorizeDevice$result$1> r3) {
        this.$targetDeviceId = r1;
        this.$authTicket = r2;
        super(2, r3);
    }

    public final Continuation<Unit> create(Object r4, Continuation<?> r5) {
        PcDeviceRepository$authorizeDevice$result$1 r0 = new PcDeviceRepository$authorizeDevice$result$1(this.$targetDeviceId, this.$authTicket, r5);
        r0.L$0 = r4;
        return r0;
    }

    public final Object invoke(GetAllDevicesApi r1, Continuation<? super BizResponse<BizResponse<AllDeviceResponse>>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((GetAllDevicesApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r6) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r6);
    L11:
        return r6;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r6);
        GetAllDevicesApi r7 = (GetAllDevicesApi) this.L$0;
        AuthorizeDeviceRequest r2 = new AuthorizeDeviceRequest(this.$targetDeviceId, this.$authTicket);
        this.label = 1;
        r6 = r7.authorizeDevice(r2, this);
        if (r6 != r0) goto L11;
        return r0;
    }
}
