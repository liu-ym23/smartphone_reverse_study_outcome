package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import android.os.Build;
import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class l extends DynamicFactor<String> {
    public static final l b = null;

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "device_type";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    static {
        b = new l();
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String b() {
        String r0 = Build.MODEL;
        if (r0 != null) goto L6;
        return "";
    L6:
        return r0;
    }

    public l() {
    }
}
