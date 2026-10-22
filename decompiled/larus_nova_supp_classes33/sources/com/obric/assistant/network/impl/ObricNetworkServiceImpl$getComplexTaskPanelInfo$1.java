package com.obric.assistant.network.impl;

import com.larus.utils.logger.FLogger;
import dm9.a;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
@DebugMetadata(c = "com.obric.assistant.network.impl.ObricNetworkServiceImpl", f = "ObricNetworkServiceImpl.kt", i = {}, l = {776}, m = "getComplexTaskPanelInfo", n = {}, s = {})
final class ObricNetworkServiceImpl$getComplexTaskPanelInfo$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ObricNetworkServiceImpl this$0;

    public ObricNetworkServiceImpl$getComplexTaskPanelInfo$1(ObricNetworkServiceImpl r1, Continuation<? super ObricNetworkServiceImpl$getComplexTaskPanelInfo$1> r2) {
        this.this$0 = r1;
        super(r2);
    }

    public final Object invokeSuspend(Object r15) {
        this.result = r15;
        this.label |= Integer.MIN_VALUE;
        ObricNetworkServiceImpl r16 = this.this$0;
        r16.getClass();
        int r1 = this.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L5;
        this.label = r1 - Integer.MIN_VALUE;
        ObricNetworkServiceImpl$getComplexTaskPanelInfo$1 r0 = this;
    L6:
        Object r17 = r0.result;
        Object r10 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        if (r2 == 0) goto L12;
        if (r2 != 1) goto L11;
        ResultKt.throwOnFailure(r17);
    L15:
        a.b r18 = (a) r17;
        if ((r18 instanceof a.b) == false) goto L20;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getComplexTaskPanelInfo success");
        vea.e r19 = (vea.e) r18.a.getData();
    L22:
        return r19;
    L20:
        if ((r18 instanceof a.a) == false) goto L24;
        FLogger.a.i("[ObricNetworkServiceImpl]", "getComplexTaskPanelInfo error");
        r19 = null;
        goto L22
    L24:
        throw new NoWhenBranchMatchedException();
    L11:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L12:
        ResultKt.throwOnFailure(r17);
        FLogger.a.i("[ObricNetworkServiceImpl]", "getComplexTaskPanelInfo");
        ObricProtocolApi.a r110 = ObricProtocolApi.a;
        ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1 r13 = new ObricNetworkServiceImpl$getComplexTaskPanelInfo$response$1(null, 0, 0, 0, null);
        r0.label = 1;
        r110.getClass();
        r17 = ObricProtocolApi.a.a(r13, r0);
        if (r17 != r10) goto L15;
        return r10;
    L5:
        r0 = new ObricNetworkServiceImpl$getComplexTaskPanelInfo$1(r16, this);
        goto L6
    }
}
