package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class c implements FilterViewV2.c {
    public final /* synthetic */ FilterViewV2 a;

    public c(FilterViewV2 r1) {
        this.a = r1;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.c
    public final void a(cpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        FilterViewV2.c r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.FilterViewV2.c
    public final void b(cpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        FilterViewV2.c r0 = this.a.f;
        if (r0 == null) goto L6;
        r0.b(r2);
        return;
    }
}
