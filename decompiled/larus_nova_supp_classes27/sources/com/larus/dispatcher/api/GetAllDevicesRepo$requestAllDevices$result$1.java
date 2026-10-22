package com.larus.dispatcher.api;

import com.larus.common.baidunavi.api.bean.consts.BaiduNaviStatus;
import com.larus.network.FlowHttpConnection;
import com.larus.network.bean.BizResponse;
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
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/HttpDataResult;", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo$requestAllDevices$result$1", f = "GetAllDevicesRepo.kt", i = {}, l = {390}, m = "invokeSuspend", n = {}, s = {})
final class GetAllDevicesRepo$requestAllDevices$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super dm9.a<? extends AllDeviceResponse>>, Object> {
    int label;

    /* JADX INFO: renamed from: com.larus.dispatcher.api.GetAllDevicesRepo$requestAllDevices$result$1$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/larus/dispatcher/api/AllDeviceResponse;", "Lcom/larus/dispatcher/api/GetAllDevicesApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dispatcher.api.GetAllDevicesRepo$requestAllDevices$result$1$1", f = "GetAllDevicesRepo.kt", i = {}, l = {391}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<GetAllDevicesApi, Continuation<? super BizResponse<AllDeviceResponse>>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r2) {
            super(2, r2);
        }

        public final Continuation<Unit> create(Object r2, Continuation<?> r3) {
            AnonymousClass1 r0 = new AnonymousClass1(r3);
            r0.L$0 = r2;
            return r0;
        }

        public final Object invoke(GetAllDevicesApi r1, Continuation<? super BizResponse<AllDeviceResponse>> r2) {
            return create(r1, r2).invokeSuspend(Unit.INSTANCE);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
            return invoke((GetAllDevicesApi) r1, (Continuation) r2);
        }

        public final Object invokeSuspend(Object r4) {
            Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r1 = this.label;
            if (r1 == 0) goto L8;
            if (r1 != 1) goto L7;
            ResultKt.throwOnFailure(r4);
        L11:
            return r4;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r4);
            GetAllDevicesApi r5 = (GetAllDevicesApi) this.L$0;
            this.label = 1;
            r4 = r5.requestDispatchAllDevices(this);
            if (r4 != r0) goto L11;
            return r0;
        }
    }

    public GetAllDevicesRepo$requestAllDevices$result$1(Continuation<? super GetAllDevicesRepo$requestAllDevices$result$1> r2) {
        super(2, r2);
    }

    public final Continuation<Unit> create(Object r1, Continuation<?> r2) {
        return new GetAllDevicesRepo$requestAllDevices$result$1(r2);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((CoroutineScope) r1, (Continuation) r2);
    }

    public final Object invoke(CoroutineScope r1, Continuation<? super dm9.a<AllDeviceResponse>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object r13) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r13);
    L11:
        return r13;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r13);
        GetAllDevicesApi.a r14 = GetAllDevicesApi.a;
        AnonymousClass1 r5 = new AnonymousClass1(null);
        this.label = 1;
        r14.getClass();
        FlowHttpConnection r15 = FlowHttpConnection.a;
        r13 = FlowHttpConnection.g("MainBot", GetAllDevicesApi.class, r5, true, null, null, null, this, BaiduNaviStatus.NO_PERMISSION);
        if (r13 != r0) goto L11;
        return r0;
    }
}
