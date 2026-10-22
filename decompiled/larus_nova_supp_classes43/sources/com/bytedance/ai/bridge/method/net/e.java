package com.bytedance.ai.bridge.method.net;

import android.content.Context;
import com.bytedance.common.utility.NetworkUtils;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class e {
    static {
    }

    public static f a(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        int r11 = s4.b.a;
        Intrinsics.checkNotNullParameter(r10, "context");
        String r0 = s4.b.a(NetworkUtils.getNetworkTypeFast(r10));
        if (Intrinsics.areEqual(r0, "mobile") == false) goto L6;
        r0 = "unknown";
    L6:
        return new f(r0, NetworkUtils.isNetworkAvailable(r10));
    }
}
