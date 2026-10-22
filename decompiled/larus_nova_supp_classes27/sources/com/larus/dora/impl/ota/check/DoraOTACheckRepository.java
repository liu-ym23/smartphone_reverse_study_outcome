package com.larus.dora.impl.ota.check;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class DoraOTACheckRepository {
    public static final DoraOTACheckRepository a = null;
    public static final Lazy b = null;
    public static final Lazy c = null;

    public DoraOTACheckRepository() {
    }

    static {
        a = new DoraOTACheckRepository();
        b = LazyKt.lazy(new b());
        c = LazyKt.lazy(new c());
    }

    public final Object b(String r16, String r17, String r18, String r110, String r20, String r21, String r22, String r23, boolean r24, Continuation<? super Result<e49.a>> r25) {
        if ((r25 instanceof DoraOTACheckRepository$checkUpdate$1) == false) goto L7;
        DoraOTACheckRepository$checkUpdate$1 r1 = (DoraOTACheckRepository$checkUpdate$1) r25;
        int r2 = r1.label;
        if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
        r1.label = r2 - Integer.MIN_VALUE;
    L8:
        DoraOTACheckRepository$checkUpdate$1 r13 = r1;
        Object r0 = r13.result;
        Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r4 = r13.label;
        if (r4 == 0) goto L14;
        if (r4 != 1) goto L13;
        ResultKt.throwOnFailure(r0);
        return ((Result) r0).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r0);
        r13.label = 1;
        Object r5 = a(r16, r17, r18, r110, r20, r21, r22, r23, r24, true, r13);
        if (r5 != r3) goto L18;
        return r3;
    L18:
        return r5;
    L7:
        r1 = new DoraOTACheckRepository$checkUpdate$1(this, r25);
        goto L8
    }

    public final Object a(String r20, String r21, String r22, String r23, String r24, String r25, String r26, String r27, boolean r28, boolean r210, Continuation<? super Result<e49.a>> r30) {
        if ((r30 instanceof DoraOTACheckRepository$checkUpdate$2) == false) goto L7;
        DoraOTACheckRepository$checkUpdate$2 r2 = (DoraOTACheckRepository$checkUpdate$2) r30;
        int r3 = r2.label;
        if ((r3 & Integer.MIN_VALUE) == 0) goto L7;
        r2.label = r3 - Integer.MIN_VALUE;
    L8:
        Object r1 = r2.result;
        Object r4 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r5 = r2.label;
        if (r5 == 0) goto L14;
        if (r5 != 1) goto L13;
        ResultKt.throwOnFailure(r1);
    L22:
        return ((Result) r1).unbox-impl();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r1);
        g49.d.d("DoraOTACheckRepository", "checkUpdate: start isDebug=" + r28);
        if (r28 == false) goto L17;
        d r0 = (a) b.getValue();
    L18:
        DoraOTACheckRepository$checkUpdate$3 r6 = new DoraOTACheckRepository$checkUpdate$3(r210, r0, r20, r21, r22, r23, r24, r25, r26, r27, null);
        r2.label = 1;
        r1 = CoroutineScopeKt.coroutineScope(r6, r2);
        if (r1 != r4) goto L22;
        return r4;
    L17:
        r0 = (DoraOTACheckFromNetworkDataSource) c.getValue();
    L7:
        r2 = new DoraOTACheckRepository$checkUpdate$2(this, r30);
        goto L8
    }
}
