package com.bytedance.android.annie.resource;

import com.bytedance.android.annie.api.card.IHybridComponent;
import com.bytedance.android.annie.service.setting.AnnieConfigSettingKeys;
import com.bytedance.forest.chain.fetchers.GeckoXAdapter;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class a implements p9.h {
    public a() {
    }

    @Override // p9.h
    public final Map a(String r10, IHybridComponent.HybridType r11, String r12) {
        Intrinsics.checkNotNullParameter(r10, com.bytedance.android.ec.core.event.a.KEY_URL);
        if (r11 != IHybridComponent.HybridType.H5) goto L12;
        if (AnnieConfigSettingKeys.DISABLE_MULTI_VERSION_QUERY.a().booleanValue() == true) goto L12;
        if (n.j(r10, r11, r12) == true) goto L12;
        GeckoXAdapter.Companion r13 = GeckoXAdapter.Companion;
        if (r13.isCDNMultiVersionResource(r10) == false) goto L12;
        return r13.getCDNMultiVersionCommonParams();
    L12:
        return new LinkedHashMap();
    }
}
