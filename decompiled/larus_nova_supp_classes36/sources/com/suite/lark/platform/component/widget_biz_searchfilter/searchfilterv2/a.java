package com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
public final class a implements SearchFilterViewV2.a {
    public final /* synthetic */ FilterAdapterV2 a;
    public final /* synthetic */ cpc.a b;

    public a(FilterAdapterV2 r1, cpc.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.suite.lark.platform.component.widget_biz_searchfilter.searchfilterv2.SearchFilterViewV2.a
    public final void onClick() {
        FilterViewV2.c r0 = this.a.h;
        if (r0 == null) goto L6;
        r0.b(this.b);
        return;
    }
}
