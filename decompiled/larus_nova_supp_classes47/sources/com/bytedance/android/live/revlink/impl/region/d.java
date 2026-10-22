package com.bytedance.android.live.revlink.impl.region;

import com.bytedance.android.live.revlink.impl.multianchor.ui.UILayout;
import java.util.LinkedHashMap;
import java.util.Map;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class d {
    public final Map<String, pc0.c> a;
    public UILayout b;
    public String c;
    public String d;
    public final com.bytedance.android.livesdk.revenue.service.room.c e;
    public final com.bytedance.android.live.revlink.impl.global.c f;

    public final RevLinkWindowRegionContext a() {
        com.bytedance.android.live.revlink.impl.global.c r0 = this.f;
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.P8();
    }

    public d(com.bytedance.android.livesdk.revenue.service.room.c r1, com.bytedance.android.live.revlink.impl.global.c r2) {
        this.e = r1;
        this.f = r2;
        this.a = new LinkedHashMap();
    }
}
