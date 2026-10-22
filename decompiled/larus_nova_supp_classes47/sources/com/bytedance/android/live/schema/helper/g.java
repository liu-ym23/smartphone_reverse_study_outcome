package com.bytedance.android.live.schema.helper;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class g {
    public static String a(Map<String, String> r1, String r2) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r2) == true) goto L15;
        return (String) ((HashMap) r1).get(r2);
    L8:
        th = move-exception;
        com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        return null;
    L15:
        return null;
    }

    public static int b(String r1, int r2) {
        return Color.parseColor(r1);
    L4:
        th = move-exception;
        com.bytedance.android.live.schema.api.utils.a.c("ParsingUriParamHelper", th);
        return r2;
    }
}
