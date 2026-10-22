package com.bytedance.android.ec.core.utils;

import com.bytedance.ttnet.TTNetInit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class h0 {
    static {
    }

    public static void a(String r10) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        TTNetInit.preconnectUrl(r10);     // Catch: Exception -> L5
        dm.a.a("ECNetHelper").i("url preconnect success, url = " + r10);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        dm.a.a("ECNetHelper").b("url preconnect failed, exception = " + e, null);
    }
}
