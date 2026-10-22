package com.bytedance.android.live.network;

import java.net.URLEncoder;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final /* synthetic */ class a {
    public static String a(String r1) {
        return URLEncoder.encode(r1, "UTF-8");
    L5:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }
}
