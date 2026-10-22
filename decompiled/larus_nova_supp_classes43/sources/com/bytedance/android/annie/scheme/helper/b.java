package com.bytedance.android.annie.scheme.helper;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b {
    public static String a(Uri r1, String r10) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        return UriProtector.getQueryParameter(r1, r10);
    L8:
        th = move-exception;
        int r11 = x8.a.a;
        x8.a.c("ParsingUriParamHelper", th, true);
        return null;
    L15:
        return null;
    }

    public static String b(Map<String, String> r1, String r10) {
        if (r1 != null) goto L4;
        return null;
    L4:
        if (TextUtils.isEmpty(r10) == true) goto L15;
        return (String) ((HashMap) r1).get(r10);
    L8:
        th = move-exception;
        x8.a.c("ParsingUriParamHelper", th, true);
        return null;
    L15:
        return null;
    }
}
