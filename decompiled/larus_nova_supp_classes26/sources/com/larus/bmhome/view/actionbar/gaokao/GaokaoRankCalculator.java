package com.larus.bmhome.view.actionbar.gaokao;

import android.content.Context;
import com.larus.bmhome.view.actionbar.gaokao.network.GaokaoProvinceZhiyuanResponse;
import com.larus.utils.o0;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class GaokaoRankCalculator {
    public GaokaoRankCalculator() {
    }

    public final Object a(Context r6, String r7, String r8, String r9, Continuation<? super String> r10) {
        if ((r10 instanceof GaokaoRankCalculator$calculateRank$1) == false) goto L7;
        GaokaoRankCalculator$calculateRank$1 r0 = (GaokaoRankCalculator$calculateRank$1) r10;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r11 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        r6 = (Context) r0.L$0;
        ResultKt.throwOnFailure(r11);
    L21:
        dm9.a.b r12 = (dm9.a) r11;
        if ((r12 instanceof dm9.a.b) == false) goto L30;
        GaokaoProvinceZhiyuanResponse r13 = (GaokaoProvinceZhiyuanResponse) r12.a.getData();
        if (r13 == null) goto L26;
        String r14 = r13.getRank();
    L28:
        if (o0.d(r14) == false) goto L31;
        return r14;
    L31:
        return null;
    L26:
        r14 = null;
        goto L28
    L30:
        t19.s.a.g(r6, 2131900505, false);
        goto L31
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r11);
        if (r9 != null) goto L18;
        return "";
    L18:
        CoroutineDispatcher r15 = Dispatchers.getIO();
        GaokaoRankCalculator$calculateRank$result$1 r4 = new GaokaoRankCalculator$calculateRank$result$1(r7, r8, r9, null);
        r0.L$0 = r6;
        r0.label = 1;
        r11 = BuildersKt.withContext(r15, r4, r0);
        if (r11 != r2) goto L21;
        return r2;
    L7:
        r0 = new GaokaoRankCalculator$calculateRank$1(this, r10);
        goto L8
    }
}
