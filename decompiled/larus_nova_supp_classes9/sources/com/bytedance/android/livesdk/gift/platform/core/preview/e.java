package com.bytedance.android.livesdk.gift.platform.core.preview;

import com.bytedance.bdlocation.BuildConfig;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes9.dex */
public final class e implements yp2.b {
    public final /* synthetic */ d a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public final String a() {
        return "effect_gift";
    }

    public final String b() {
        String r0 = this.a.a.H0(this.c);
        if (r0 != null) goto L6;
        return BuildConfig.FLAVOR;
    L6:
        return r0;
    }

    public final boolean c() {
        com.bytedance.android.live.core.resources.e r0 = this.a.a.G1(this.c);
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isHighCostAsset();
    }

    public final long getId() {
        return this.b;
    }

    public e(d r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
    }
}
