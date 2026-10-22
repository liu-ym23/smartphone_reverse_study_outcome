package com.larus.dora.impl.util;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.List;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
public final class g0 {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static int a(String r11, String r12) {
        Intrinsics.checkNotNullParameter(r11, "version1");
        Intrinsics.checkNotNullParameter(r12, "version2");
        List r13 = StringsKt.split$default(r11, new String[]{"."}, false, 0, 6, null);
        List r14 = StringsKt.split$default(r12, new String[]{"."}, false, 0, 6, null);
        int r0 = Math.max(r13.size(), r14.size());
        int r3 = 0;
    L3:
        if (r3 >= r0) goto L33;
        if (r3 < r13.size()) goto L36;
        int r4 = 0;
    L16:
        if (r3 < r14.size()) goto L34;
        int r5 = 0;
    L26:
        if (r4 > r5) goto L27;
        if (r4 < r5) goto L30;
        r3 = r3 + 1;
        goto L3
    L30:
        return -1;
    L27:
        return 1;
    L34:
        Result.Companion r6 = Result.Companion;     // Catch: Throwable -> L19
        Object r7 = Result.constructor-impl(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r14, r3))));     // Catch: Throwable -> L19
    L22:
        if (Result.isFailure-impl(r7) == false) goto L24;
        r7 = 0;
    L24:
        r5 = ((Number) r7).intValue();
    L19:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r7 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L22
    L36:
        Result.Companion r9 = Result.Companion;     // Catch: Throwable -> L8
        Object r10 = Result.constructor-impl(Integer.valueOf(CastIntegerProtector.parseInt((String) ListProtector.get(r13, r3))));     // Catch: Throwable -> L8
    L11:
        if (Result.isFailure-impl(r10) == false) goto L13;
        r10 = 0;
    L13:
        r4 = ((Number) r10).intValue();
    L8:
        th = move-exception;
        Result.Companion r15 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L11
    L33:
        return 0;
    }
}
