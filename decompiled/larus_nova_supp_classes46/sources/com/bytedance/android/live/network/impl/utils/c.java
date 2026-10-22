package com.bytedance.android.live.network.impl.utils;

import com.bytedance.android.live.base.exception.ApiException;
import com.bytedance.android.live.base.exception.ApiServerException;
import com.bytedance.android.live.base.model.exception.NetworkErrorException;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class c {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(Throwable r9) {
        boolean r0 = r9 instanceof ApiServerException;
        int r1 = 0;
        if (r0 == false) goto L6;
        int r2 = ((ApiServerException) r9).getErrorCode();
    L12:
        if (r0 == false) goto L15;
        String r10 = ((ApiServerException) r9).getErrorMsg();
    L21:
        if (r2 != 0) goto L35;
        if (r10 == null) goto L32;
        Result.Companion r3 = Result.Companion;     // Catch: Throwable -> L26
        int r4 = StringsKt.lastIndexOf$default(r10, "InternalErrorCode=", 0, false, 6, null);     // Catch: Throwable -> L26
        r1 = CastIntegerProtector.parseInt(r10.substring(r4 + 18, StringsKt.indexOf$default(r10, ',', r4, false, 4, null)));     // Catch: Throwable -> L26
    L26:
        th = move-exception;
        Result.Companion r5 = Result.Companion;
        Object r11 = Result.constructor-impl(ResultKt.createFailure(th));
        if (Result.isFailure-impl(r11) == false) goto L30;
        r11 = 0;
    L30:
        r1 = ((Number) r11).intValue();
    L32:
        return r1;
    L35:
        return r2;
    L15:
        if ((r9 instanceof NetworkErrorException) == false) goto L18;
        r10 = r9.getMessage();
        goto L21
    L18:
        if ((r9 instanceof Exception) == false) goto L20;
        r10 = r9.getMessage();
        goto L21
    L20:
        r10 = null;
        goto L21
    L6:
        if ((r9 instanceof NetworkErrorException) == false) goto L9;
        r2 = ((NetworkErrorException) r9).statusCode;
        goto L12
    L9:
        if ((r9 instanceof ApiException) == false) goto L11;
        r2 = ((ApiException) r9).getErrorCode();
        goto L12
    L11:
        r2 = 0;
        goto L12
    }
}
