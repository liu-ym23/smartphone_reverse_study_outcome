package com.bytedance.android.live.revenue.platform.hybrid.impl.component;

import android.webkit.WebView;
import com.bytedance.android.annie.card.base.BaseHybridComponent;
import com.bytedance.android.live.revenue.platform.hybrid.api.HybridType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class f extends d<WebView> {
    @Override // com.bytedance.android.live.revenue.platform.hybrid.impl.component.b, xy0.a
    public final HybridType o() {
        return HybridType.H5;
    }

    public f(BaseHybridComponent r2) {
        Intrinsics.checkNotNullParameter(r2, "originalComponent");
        super(r2);
    }
}
