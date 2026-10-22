package com.larus.avlink.rtc;

import java.util.Map;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.g0;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final class d {
    public static final d a = null;

    static {
        a = new d();
    }

    public d() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static Boolean a(Object r5) {
        boolean r1 = false;
        if ((r5 instanceof Map) == false) goto L11;
        Map r6 = (Map) r5;
        Boolean r0 = c(r6.get("trans_mode"));
        if (r0 != null) goto L7;
        r0 = b(r6.get("enable_rtc_video_stream"));
    L7:
        if (r0 == null) goto L38;
        r1 = r0.booleanValue();
    L38:
        return Boolean.valueOf(r1);
    L11:
        if ((r5 instanceof String) == false) goto L35;
        String r7 = (String) r5;
        Object r4 = null;
        if (StringsKt.isBlank(r7) == true) goto L39;
        Result.Companion r2 = Result.Companion;     // Catch: Throwable -> L27
        d0 r8 = k.n(ouc.a.d.e(r7));     // Catch: Throwable -> L27
        i r3 = (i) r8.get("trans_mode");     // Catch: Throwable -> L27
        if (r3 == null) goto L18;
        Boolean r9 = c(r3);     // Catch: Throwable -> L27
    L25:
        Object r10 = Result.constructor-impl(r9);     // Catch: Throwable -> L27
    L30:
        if (Result.isFailure-impl(r10) == true) goto L33;
        r4 = r10;
    L33:
        r4 = (Boolean) r4;
        goto L39
    L18:
        i r11 = (i) r8.get("enable_rtc_video_stream");     // Catch: Throwable -> L27
        if (r11 == null) goto L24;
        Boolean r12 = b(r11);     // Catch: Throwable -> L27
        if (r12 == null) goto L23;
        r1 = r12.booleanValue();     // Catch: Throwable -> L27
    L23:
        r9 = Boolean.valueOf(r1);     // Catch: Throwable -> L27
        goto L25
    L24:
        r9 = null;
    L27:
        th = move-exception;
        Result.Companion r13 = Result.Companion;
        r10 = Result.constructor-impl(ResultKt.createFailure(th));
    L39:
        return r4;
    L35:
        return b(r5);
    }

    public static Boolean b(Object r2) {
        if ((r2 instanceof Number) == false) goto L6;
        Integer r3 = Integer.valueOf(((Number) r2).intValue());
    L14:
        if (r3 == null) goto L21;
        boolean r0 = true;
        if (r3.intValue() == 1) goto L20;
        r0 = false;
    L20:
        return Boolean.valueOf(r0);
    L21:
        return null;
    L6:
        if ((r2 instanceof String) == false) goto L9;
        r3 = StringsKt.toIntOrNull((String) r2);
        goto L14
    L9:
        if ((r2 instanceof g0) == false) goto L13;
        String r4 = k.g((g0) r2);
        if (r4 == null) goto L13;
        r3 = StringsKt.toIntOrNull(r4);
    L13:
        r3 = null;
        goto L14
    }

    public static Boolean c(Object r2) {
        if ((r2 instanceof String) == false) goto L6;
        String r3 = (String) r2;
    L10:
        if (Intrinsics.areEqual(r3, "video") == false) goto L13;
        return Boolean.TRUE;
    L13:
        if (Intrinsics.areEqual(r3, "image") == true) goto L15;
        return null;
    L15:
        return Boolean.FALSE;
    L6:
        if ((r2 instanceof g0) == false) goto L8;
        r3 = k.g(k.o((i) r2));
        goto L10
    L8:
        r3 = null;
        goto L10
    }
}
