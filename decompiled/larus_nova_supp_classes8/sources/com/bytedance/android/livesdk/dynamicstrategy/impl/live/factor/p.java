package com.bytedance.android.livesdk.dynamicstrategy.impl.live.factor;

import com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes8.dex */
public final class p extends DynamicFactor<Integer> {
    public final DataCenter b;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final String c() {
        return "live_enter_type";
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void d() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final void e() {
    }

    @Override // com.bytedance.android.livesdk.dynamicstrategy.api.DynamicFactor
    public final Integer b() {
        String r0 = (String) this.b.get("data_live_enter_type_correct", "");
        if (r0 == null) goto L16;
        int r1 = r0.hashCode();
        if (r1 == 3091780) goto L14;
        if (r1 != 94750088) goto L16;
        if (r0.equals("click") == false) goto L16;
        int r2 = 1;
    L18:
        return Integer.valueOf(r2);
    L14:
        if (r0.equals("draw") == false) goto L16;
        r2 = 2;
    L16:
        r2 = 0;
        goto L18
    }

    public p(DataCenter r2) {
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        this.b = r2;
    }
}
