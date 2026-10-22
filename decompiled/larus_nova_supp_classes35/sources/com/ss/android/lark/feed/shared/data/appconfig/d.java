package com.ss.android.lark.feed.shared.data.appconfig;

import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements mpb.a {
    public d() {
    }

    public final lpb.a a(String r5) {
        b r0 = new b();
        if (TextUtils.isEmpty(r5) == false) goto L12;
        Log.i("FeedLoadCountConfigHelp", "Feed load config is empty, use default value!");
    L11:
        return r0;
    L12:
        JSONObject r6 = JSON.parseObject(r5);     // Catch: Exception -> L9
        r6.getInteger("refresh").intValue();     // Catch: Exception -> L9
        r6.getInteger("refresh_buffer").intValue();     // Catch: Exception -> L9
        r6.getInteger("loadmore").intValue();     // Catch: Exception -> L9
        int r7 = r6.getInteger("buffer").intValue();     // Catch: Exception -> L9
        if (r7 <= 0) goto L11;
        r0.a = r7;     // Catch: Exception -> L9
    L9:
        e = move-exception;
        Log.e("FeedLoadCountConfigHelp", "parse Feed load config fail :" + e.getMessage());
        goto L11
    }
}
