package com.larus.uaigc.api;

import com.larus.network.FlowHttpConnection;
import com.larus.utils.logger.FLogger;
import dm9.a;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
public final class SuggestClickRepo {
    public static final SuggestClickRepo a = null;

    static {
        a = new SuggestClickRepo();
    }

    public SuggestClickRepo() {
    }

    public final Object a(String r11, String r12, Continuation<? super Unit> r13) {
        if ((r13 instanceof SuggestClickRepo$reportSugClick$1) == false) goto L7;
        SuggestClickRepo$reportSugClick$1 r0 = (SuggestClickRepo$reportSugClick$1) r13;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        SuggestClickRepo$reportSugClick$1 r8 = r0;
        Object r14 = r8.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r8.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        ResultKt.throwOnFailure(r14);
    L17:
        a.a r15 = (a) r14;
        if ((r15 instanceof a.b) == false) goto L21;
        FLogger.a.i("SuggestClickRepo", "creativity sug click successfully");
    L24:
        return Unit.INSTANCE;
    L21:
        if ((r15 instanceof a.a) == false) goto L24;
        FLogger.a.e("SuggestClickRepo", "creativity sug click failed: " + r15.c);
        goto L24
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r14);
        SugClickApi.a r16 = SugClickApi.a;
        SuggestClickRepo$reportSugClick$result$1 r4 = new SuggestClickRepo$reportSugClick$result$1(r11, r12, null);
        r8.label = 1;
        r16.getClass();
        FlowHttpConnection r17 = FlowHttpConnection.a;
        r14 = FlowHttpConnection.g("Social", SugClickApi.class, r4, false, null, null, null, r8, 248);
        if (r14 != r2) goto L17;
        return r2;
    L7:
        r0 = new SuggestClickRepo$reportSugClick$1(this, r13);
        goto L8
    }
}
