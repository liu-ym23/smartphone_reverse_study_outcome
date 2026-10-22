package com.bytedance.android.livesdk.dslservice.util;

import com.bytedance.android.livesdk.dsl.util.DSLActionEnum;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class g implements yt1.h {
    public g() {
    }

    @Override // yt1.h
    public final String a() {
        int r0 = j.a;
        return "card_data_update";
    }

    @Override // yt1.h
    public final DSLActionEnum getName() {
        return DSLActionEnum.CardUpdate;
    }

    @Override // yt1.h
    public final void b(Map r3, yt1.j r4) {
        if (r3 == null) goto L12;
        int r0 = j.a;
        Object r1 = r3.get("merge_type");
        if (r1 == null) goto L12;
        int r2 = com.bytedance.android.livesdk.dsl.util.c.a;
        if ((r1 instanceof Number) == false) goto L9;
        int r5 = ((Number) r1).intValue();
    L13:
        if (r4 == null) goto L19;
        r4.c(r3, r5);
        return;
    L19:
        return;
    L9:
        if ((r1 instanceof String) == false) goto L12;
        r5 = CastIntegerProtector.parseInt((String) r1);     // Catch: Exception -> L16
    L12:
        r5 = 1;
        goto L13
    }
}
