package com.bytedance.android.livesdk.interactivity.square;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class j extends l52.b {
    public final i h;
    public final c i;
    public final com.bytedance.android.livesdk.interactivity.api.publicscreen.l j;

    public j(k52.a r2, h r3, com.bytedance.android.livesdk.interactivity.api.publicscreen.l r4) {
        Intrinsics.checkNotNullParameter(r2, "pipelineConfig");
        Intrinsics.checkNotNullParameter(r3, "repo");
        Intrinsics.checkNotNullParameter(r4, "publicScreenContext");
        super(r2, r3, r4);
        this.j = r4;
        this.h = new i(this);
        this.i = new c(r2.b);
    }
}
