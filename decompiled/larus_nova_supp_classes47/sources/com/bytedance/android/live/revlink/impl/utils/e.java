package com.bytedance.android.live.revlink.impl.utils;

import android.text.TextUtils;
import com.bytedance.android.live.GsonHelper;
import com.google.gson.JsonParseException;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class e {
    public static String b(Object r1) throws JsonParseException {
        if (r1 != null) goto L10;
        return "";
    L10:
        return GsonHelper.get().toJson(r1);
    L7:
        th = move-exception;
        throw new JsonParseException(th);
    }

    public static <T> T a(String r1, Class<T> r2) throws JsonParseException {
        if (TextUtils.isEmpty(r1) == false) goto L11;
        return null;
    L11:
        return (T) GsonHelper.get().fromJson(r1, r2);
    L8:
        th = move-exception;
        throw new JsonParseException(th);
    }
}
