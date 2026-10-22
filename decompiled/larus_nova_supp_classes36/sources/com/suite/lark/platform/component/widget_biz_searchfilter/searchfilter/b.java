package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class b implements FilterView.b {
    public final /* synthetic */ FilterView a;

    public b(FilterView r1) {
        this.a = r1;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilter.FilterView.b
    public final void a(cpc.a r2) {
        Intrinsics.checkNotNullParameter(r2, "data");
        FilterView.b r0 = this.a.e;
        if (r0 == null) goto L6;
        r0.a(r2);
        return;
    }
}
