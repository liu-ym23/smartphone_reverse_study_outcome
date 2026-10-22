package com.bytedance.android.livesdk.gift.platform.business.giftwall;

import com.bytedance.android.livesdk.gift.platform.core.giftlist.RevenueImageUrlService;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class f {
    public static final f a = null;

    public f() {
    }

    static {
        a = new f();
    }

    public static void b(Function0 r1) {
        Intrinsics.checkNotNullParameter(r1, "action");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L5
        r1.invoke();     // Catch: Throwable -> L5
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        Result.Companion r2 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }

    public static final void a(f r8, JSONObject r9, String r10) {
        r8.getClass();
        JSONArray r0 = JSONObjectProtectorUtils.getJSONArray(r9, "url_list");
        JSONArray r1 = new JSONArray();
        int r2 = r0.length();
        int r4 = 0;
    L3:
        if (r4 >= r2) goto L18;
        String r5 = JSONArrayProtectorUtils.getString(r0, r4);
        String r7 = null;
        if (StringsKt.endsWith$default(r5, r10, false, 2, null) == false) goto L16;
        int r6 = RevenueImageUrlService.c;
        String r11 = RevenueImageUrlService.a.c(r5, r10, 4);
        if (r11 == null) goto L16;
        if (r11.length() <= 0) goto L11;
        boolean r13 = true;
    L12:
        if (r13 == false) goto L14;
        r7 = r11;
    L14:
        if (r7 == null) goto L16;
        r1.put(r7);
        goto L16
    L11:
        r13 = false;
    L16:
        r4 = r4 + 1;
        goto L3
    L18:
        if (r1.length() <= 0) goto L26;
        r9.put("url_list", r1);
        return;
    }
}
