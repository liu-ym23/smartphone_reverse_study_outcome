package com.bytedance.android.live.ktv.common.search.view;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class k implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ CommonSearchContainer a;
    public final /* synthetic */ Long b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        CommonSearchResultView r0 = CommonSearchContainer.b(this.a);
        if (r0 == null) goto L7;
        ViewTreeObserver r1 = r0.getViewTreeObserver();
        if (r1 == null) goto L7;
        r1.removeOnGlobalLayoutListener(this);
    L7:
        mb0.c r2 = mb0.d.a;
        mb0.d.f("search_music", System.currentTimeMillis() - this.b.longValue());
        CommonSearchEnterView r3 = CommonSearchContainer.c(this.a);
        if (r3 == null) goto L11;
        r3.d = 0;
        return;
    }

    public k(CommonSearchContainer r1, Long r2) {
        this.a = r1;
        this.b = r2;
    }
}
