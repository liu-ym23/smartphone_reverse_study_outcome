package com.bytedance.android.livesdk.gift.platform.core.scope.service;

import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class o implements com.bytedance.android.livesdk.gift.platform.business.effect.assets.f {
    public final /* synthetic */ p a;

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void a(long r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void b(boolean r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onFailed(Throwable r2) {
        Intrinsics.checkNotNullParameter(r2, "t");
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void onProgress(int r1) {
    }

    public o(p r1) {
        this.a = r1;
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public final void c(long r2, String r4) {
        Intrinsics.checkNotNullParameter(r4, "path");
        Map<Long, Integer> r5 = this.a.a;
        HashMap r6 = (HashMap) r5;
        r6.remove(Long.valueOf(r2));
    }
}
