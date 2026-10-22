package com.bytedance.ai.bridge.method.router;

import com.bytedance.ai.bridge.service.IHostStyleUIDepend;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class t {
    static {
    }

    public static f3.a a(Throwable r1) {
        Intrinsics.checkNotNullParameter(r1, IHostStyleUIDepend.TOAST_TYPE_ERROR);
        if ((r1 instanceof IllegalArgumentException) == false) goto L6;
        return f3.a.h;
    L6:
        return f3.a.f;
    }
}
