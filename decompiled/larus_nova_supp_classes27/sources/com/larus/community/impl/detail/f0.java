package com.larus.community.impl.detail;

import android.content.Context;
import com.larus.utils.i0;
import com.larus.utils.logger.FLogger;
import com.larus.utils.m0;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class f0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Context r4, float r5) {
        Intrinsics.checkNotNullParameter(r4, "context");
        int r0 = m0.a(r4) - com.larus.utils.i.e(r4);
        i0.a.getClass();
        int r1 = ((r0 - i0.e()) - i5.y0(v19.c.b(2130971490, null, 2131167350))) - i5.y0(v19.c.b(2130971541, null, 2131167451));
        int r2 = i5.y0(v19.c.b(2130971537, null, 2131167442));
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L5
        Object r6 = Result.constructor-impl(Integer.valueOf((int) (m0.b(r4) / r5)));     // Catch: Throwable -> L5
    L7:
        Integer r7 = Integer.valueOf(r2);
        if (Result.isFailure-impl(r6) == false) goto L10;
        r6 = r7;
    L10:
        int r8 = ((Number) r6).intValue();
        FLogger.a.d("CreationDetailSizeUtils", r1 + "  " + r2 + "  " + r8);
        return RangesKt.coerceAtMost(RangesKt.coerceAtMost(r1, r2), r8);
    L5:
        th = move-exception;
        Result.Companion r9 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L7
    }
}
