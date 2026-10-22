package com.larus.dora.impl.ota.check;

import com.larus.dora.impl.ota.DoraOTARequest;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTACheckFromNetworkDataSource implements d {
    public DoraOTACheckFromNetworkDataSource() {
    }

    @Override // com.larus.dora.impl.ota.check.d
    public final Object a(String r14, String r15, String r16, String r17, String r18, String r110, String r20, String r21, Continuation<? super Result<e49.a>> r22) {
        if ((r22 instanceof DoraOTACheckFromNetworkDataSource$checkUpdate$1) == false) goto L7;
        DoraOTACheckFromNetworkDataSource$checkUpdate$1 r1 = (DoraOTACheckFromNetworkDataSource$checkUpdate$1) r22;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        DoraOTACheckFromNetworkDataSource$checkUpdate$1 r12 = r1;
        Object r0 = r12.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r12.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        DoraOTARequest r5 = DoraOTARequest.a;
        r12.label = 1;
        Object r6 = r5.a(r14, r15, r16, r17, r18, r110, r20, r21, r12);
        if (r6 != r3) goto L18;
        return r3;
    L18:
        return r6;
    L7:
        r1 = new DoraOTACheckFromNetworkDataSource$checkUpdate$1(this, r22);
        goto L8
    }
}
