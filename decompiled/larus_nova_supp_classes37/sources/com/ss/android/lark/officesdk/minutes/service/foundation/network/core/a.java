package com.ss.android.lark.officesdk.minutes.service.foundation.network.core;

import com.google.gson.reflect.TypeToken;
import com.ss.android.lark.officesdk.minutes.service.foundation.network.core.httptypes.MmHttpBaseResp;
import com.ss.android.lark.utils.e0;
import java.lang.reflect.Type;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class a {
    static {
    }

    public static Object a(String r4, Class r5) {
        Intrinsics.checkNotNullParameter(r4, "body");
        Intrinsics.checkNotNullParameter(r5, "respType");
        boolean r1 = true;
        MmHttpBaseResp r0 = (MmHttpBaseResp) e0.b(r4, TypeToken.getParameterized(MmHttpBaseResp.class, new Type[]{r5}).getType());
        if (r0 != null) goto L5;
        Object r6 = new JSONObject(r4).opt("data");
        if ((r6 instanceof String) == false) goto L17;
        String r7 = StringsKt.trim((String) r6).toString();
        if (r7.length() == 0) goto L13;
        r1 = false;
    L13:
        if (r1 == false) goto L16;
        r7 = "{}";
    L16:
        if (Intrinsics.areEqual(r7, "null") == true) goto L17;
        return e0.a(r7, r5);
    L17:
        return null;
    L5:
        return r0.getData();
    }
}
