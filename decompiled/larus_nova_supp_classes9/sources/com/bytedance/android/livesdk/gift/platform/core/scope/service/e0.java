package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e0 implements y2, com.bytedance.android.scope.o {
    public final ur.a a;

    public final void onStart() {
    }

    public final void onStop() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.core.scope.service.y2
    public final cy0.e getScope() {
        return this.a;
    }

    public e0(ur.a r2) {
        Intrinsics.checkNotNullParameter(r2, "scope");
        this.a = r2;
    }
}
