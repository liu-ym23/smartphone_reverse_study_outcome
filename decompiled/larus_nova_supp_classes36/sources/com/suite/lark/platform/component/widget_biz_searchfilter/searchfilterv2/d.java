package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class d implements FilterViewV2.b {
    public final /* synthetic */ FilterViewV2 a;

    public d(FilterViewV2 r1) {
        this.a = r1;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.b
    public final void a(cpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        FilterViewV2.b r0 = this.a.g;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
