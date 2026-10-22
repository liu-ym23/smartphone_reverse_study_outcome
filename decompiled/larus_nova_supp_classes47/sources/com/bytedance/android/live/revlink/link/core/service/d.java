package com.bytedance.android.live.revlink.link.core.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d implements com.bytedance.android.scope.o {
    public final com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h a;

    public static final class a {
    }

    static {
    }

    public final void onStop() {
    }

    public final void onStart() {
        jy0.b.c("AudienceCoreService", String.valueOf(this.a.d.p), null, 4);
    }

    public d(com.bytedance.android.live.revlink.link.infra.lifecontrol.context.h r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this.a = r2;
    }
}
