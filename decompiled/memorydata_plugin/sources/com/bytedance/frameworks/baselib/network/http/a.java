package com.bytedance.frameworks.baselib.network.http;

import com.bytedance.frameworks.baselib.network.http.parser.MimeType;

/* JADX INFO: loaded from: classes2.dex */
public abstract class a implements d {
    public a() {
    }

    public static String a(String r2) {
    L7:
        e = move-exception;
        e.printStackTrace();
        return "";
    L4:
        if (com.bytedance.common.utility.h.a(r2) == true) goto L12;
        return new MimeType(r2).getBaseType();
    L12:
        return "";
    }
}
