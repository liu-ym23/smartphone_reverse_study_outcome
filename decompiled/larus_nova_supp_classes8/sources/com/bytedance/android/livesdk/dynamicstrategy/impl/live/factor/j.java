package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Build;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class j extends DynamicFactor<String> {
    public static final j b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "device_brand";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        b = new j();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String b() {
        String r0 = Build.BRAND;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public j() {
    }
}
