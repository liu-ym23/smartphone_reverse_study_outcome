package com.bytedance.android.livesdk.gift.platform.business.effect.assets.policy;

import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class c implements Action {
    public final /* synthetic */ AssetsDefaultDownloadPolicy a;
    public final /* synthetic */ com.bytedance.android.live.core.resources.e b;
    public final /* synthetic */ int c;
    public final /* synthetic */ long d;

    public c(AssetsDefaultDownloadPolicy r1, com.bytedance.android.live.core.resources.e r2, int r3, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    public final void run() {
        boolean r0 = this.a.h.Re(this.b, this.c);
        this.a.a.put(Long.valueOf(this.b.getId()), Long.valueOf(this.d));
        this.a.b(this.b, r0);
    }
}
