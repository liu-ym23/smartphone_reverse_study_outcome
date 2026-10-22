package com.bytedance.android.live.lynx;

import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class e {
    public static final String a(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "$this$stacktraceString");
        StringWriter r0 = new StringWriter();
        r2.printStackTrace(new PrintWriter(r0));
        return r0.toString();
    }
}
