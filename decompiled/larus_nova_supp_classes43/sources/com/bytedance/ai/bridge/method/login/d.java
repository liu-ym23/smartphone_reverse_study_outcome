package com.bytedance.ai.bridge.method.login;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class d {
    static {
    }

    public static f3.a a(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, IHostStyleUIDepend.TOAST_TYPE_ERROR);
        if ((r1 instanceof LoginOperationTimeoutException) == true) goto L7;
        int r0 = com.bytedance.ai.bridge.remote.b.a;
        return com.bytedance.ai.bridge.remote.b.a(r1, f3.a.i);
    L7:
        return f3.a.p;
    }
}
