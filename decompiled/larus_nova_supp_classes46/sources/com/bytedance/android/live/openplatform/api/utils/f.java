package com.bytedance.android.live.openplatform.api.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class f {
    public static final void a(kjc.c r1, Function0 r2) {
        Intrinsics.checkNotNullParameter(r1, "$this$onSaaS");
        Intrinsics.checkNotNullParameter(r2, "block");
        kjc.b r0 = r1.a;
        r0.a = r2.invoke();
        r1.b = true;
    }
}
