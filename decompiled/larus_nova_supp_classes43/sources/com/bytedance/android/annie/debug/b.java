package com.bytedance.android.annie.debug;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import p9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class b implements h {
    public b() {
    }

    @Override // p9.h
    public final Map a(String r1, IHybridComponent.HybridType r10, String r11) {
        Intrinsics.checkNotNullParameter(r1, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (GeckoXAdapter.Companion.isCDNMultiVersionResource(r1) == true) goto L9;
        if (AnnieConfigSettingKeys.ADDING_ENV_TO_ALL_REQ.a().booleanValue() == true) goto L9;
        return MapsKt.emptyMap();
    L9:
        return d.a();
    }
}
