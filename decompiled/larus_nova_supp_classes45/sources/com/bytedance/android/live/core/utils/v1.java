package com.bytedance.android.live.core.utils;

import android.util.Base64;
import com.bytedance.android.livesdk.config.k7;
import java.io.File;
import java.io.IOException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class v1 {
    public static final com.bytedance.android.tools.superkv.e a(String r7) {
        Intrinsics.checkNotNullParameter(r7, "key");
        if (((Boolean) k7.a.getValue()).booleanValue() == false) goto L7;
        return new u1(s1.getContext(), r7);
    L7:
        if (com.bytedance.android.tools.superkv.i.b == false) goto L23;
        com.bytedance.android.tools.superkv.i.a r0 = com.bytedance.android.tools.superkv.i.a;
        com.bytedance.android.tools.superkv.d r1 = (com.bytedance.android.tools.superkv.d) r0.a.get(r7);
        if (r1 != null) goto L11;
    L24:
        r1 = new com.bytedance.android.tools.superkv.d(r0.b + File.separator + new String(Base64.encode(r7.getBytes(), 2)), r0.c);     // Catch: IOException -> L16
    L18:
        if (r1 == null) goto L21;
        r0.a.put(r7, r1);
        return r1;
    L21:
        return new com.bytedance.android.tools.superkv.d();
    L16:
        e = move-exception;
        com.bytedance.android.tools.superkv.b.e(new IllegalStateException("Failed to create DataStore: " + r7, e));
        goto L18
    L11:
        if (r1.a == false) goto L27;
        r1.b.release();
        goto L24
    L27:
        return r1;
    L23:
        throw new IllegalStateException("SuperKV must be initialized before using.");
    }
}
