package com.bytedance.android.livesdk.gift.platform.business.effect.assets;

import com.bytedance.android.live.core.log.ALogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public class o implements f {
    public o() {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void a(long r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void b(boolean r1) {
    }

    public String d() {
        return "SimpleGetResourceResult";
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void onFailed(Throwable r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void onProgress(int r1) {
    }

    @Override // com.bytedance.android.livesdk.gift.platform.business.effect.assets.f
    public void c(long r1, String r3) {
        boolean r2 = com.bytedance.android.live.revenue.core.util.h.a;
        com.bytedance.android.live.revenue.core.util.h.d(ca0.j.class).getAssetsManager().cb(r3);
        ALogger.d("SimpleGetResourceResult", "file " + r3 + " update in env: " + d());
    }
}
