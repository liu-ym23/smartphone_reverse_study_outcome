package com.ss.android.lark.log.trace;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b {
    public final String a;

    public static final class a {
    }

    static {
    }

    public b() {
        Intrinsics.checkNotNullParameter("user_flow", "eventName");
        this.a = "user_flow";
    }

    public final StepTrace a(String r3) {
        Intrinsics.checkNotNullParameter(r3, "stepName");
        return new StepTrace(this.a, r3);
    }
}
