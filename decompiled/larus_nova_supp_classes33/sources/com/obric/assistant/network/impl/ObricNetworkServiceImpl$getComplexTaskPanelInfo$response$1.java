package com.obric.assistant.network.impl;

import com.larus.network.bean.BizResponse;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import vea.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u0003H\n"}, d2 = {"<anonymous>", "Lcom/larus/network/bean/BizResponse;", "Lcom/obric/assistant/network/api/bean/ObricComplexTaskData;", "Lcom/obric/assistant/network/impl/ObricProtocolApi;"}, k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1", f = "ObricNetworkServiceImpl.kt", i = {}, l = {777}, m = "invokeSuspend", n = {}, s = {})
final class ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1 extends SuspendLambda implements Function2<ObricProtocolApi, Continuation<? super BizResponse<vea.e>>, Object> {
    final /* synthetic */ long $did;
    final /* synthetic */ String $infoType;
    final /* synthetic */ long $uid;
    final /* synthetic */ long $updateVersionCode;
    private /* synthetic */ Object L$0;
    int label;

    public ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1(String r1, long r2, long r4, long r6, Continuation<? super ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1> r8) {
        this.$infoType = r1;
        this.$uid = r2;
        this.$did = r4;
        this.$updateVersionCode = r6;
        super(2, r8);
    }

    public final Continuation<Unit> create(Object r11, Continuation<?> r12) {
        ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1 r9 = new ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1(this.$infoType, this.$uid, this.$did, this.$updateVersionCode, r12);
        r9.L$0 = r11;
        return r9;
    }

    public final Object invoke(ObricProtocolApi r1, Continuation<? super BizResponse<vea.e>> r2) {
        return create(r1, r2).invokeSuspend(Unit.INSTANCE);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object r1, Object r2) {
        return invoke((ObricProtocolApi) r1, (Continuation) r2);
    }

    public final Object invokeSuspend(Object r10) {
        Object r0 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r1 = this.label;
        if (r1 == 0) goto L8;
        if (r1 != 1) goto L7;
        ResultKt.throwOnFailure(r10);
    L11:
        return r10;
    L7:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L8:
        ResultKt.throwOnFailure(r10);
        ObricProtocolApi r11 = (ObricProtocolApi) this.L$0;
        vea.g r2 = new vea.g(this.$infoType, new a(Boxing.boxLong(this.$uid), Boxing.boxLong(this.$did), Boxing.boxLong(this.$updateVersionCode)));
        this.label = 1;
        r10 = r11.getComplexTaskPanelInfo(r2, this);
        if (r10 != r0) goto L11;
        return r0;
    }
}
