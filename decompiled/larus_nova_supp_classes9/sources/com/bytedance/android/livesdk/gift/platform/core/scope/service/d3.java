package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class d3 implements y2, com.bytedance.android.scope.o {
    public final cy0.f a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.y2
    public final cy0.e getScope() {
        return this.a;
    }

    public d3(cy0.f r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }
}
