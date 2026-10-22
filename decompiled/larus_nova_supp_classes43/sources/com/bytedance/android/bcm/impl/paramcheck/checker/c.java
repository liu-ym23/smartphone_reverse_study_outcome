package com.bytedance.android.bcm.impl.paramcheck.checker;

import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class c {
    public static final a.b a(String r10, BcmCheckErrorType r11, Object r12, Object r13) {
        Map r0 = MapsKt.mutableMapOf(new Pair[]{TuplesKt.to("param_name", r10), TuplesKt.to(com.bytedance.android.ec.core.event.a.KEY_ERROR_TYPE, r11.getValue())});
        if (r12 == null) goto L5;
        r0.put("expect_value", r12);
    L5:
        if (r13 == null) goto L8;
        r0.put("actual_value", r13);
    L8:
        return new a.b(r10, r11, r0);
    }
}
