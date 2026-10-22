package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public final class a {
    public static final a a = null;

    static {
        a = new a();
    }

    public a() {
    }

    public static String a(JSONObject r0, String r1) {
        String r2 = r0.optString(r1);
        Intrinsics.checkNotNull(r2);
        if ((!StringsKt.isBlank(r2)) == true) goto L6;
        r2 = null;
    L6:
        if (r2 != null) goto L9;
        return "";
    L9:
        return r2;
    }
}
