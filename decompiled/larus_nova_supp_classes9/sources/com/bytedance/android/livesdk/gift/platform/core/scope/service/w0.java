package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class w0 implements com.bytedance.android.scope.o {
    public final String a;
    public final yz0.g b;

    public final void onStart() {
    }

    public final void onStop() {
    }

    public w0(yz0.g r4) {
        Intrinsics.checkNotNullParameter(r4, "roomDataService");
        this.b = r4;
        this.a = r4.getUser().getIdString() + com.bytedance.live.kmp.util.e.b();
    }
}
