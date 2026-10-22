package com.ss.android.lark.im.sdk.message.resend;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class i extends jkb.a<h> {

    public static final class a {
    }

    static {
    }

    public i() {
    }

    @Override // jkb.a
    public final void b(jkb.d r2, jkb.b r3, jkb.e r4) {
        Intrinsics.checkNotNullParameter(r2, "pipelineStep");
        Intrinsics.checkNotNullParameter((h) r3, "pipelineContext");
        Intrinsics.checkNotNullParameter(r4, "reason");
        int r5 = com.ss.android.lark.im.sdk.a.a;
        com.ss.android.lark.im.sdk.a.a("ImSdkResendPipeline", "Resend message pipeline terminated terminated in " + r2.getName() + ", reason is " + r4);
    }
}
