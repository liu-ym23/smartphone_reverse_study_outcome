package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.ViewTreeObserver;
import com.ss.android.lark.flow.chat.page.flow.plugin.FlowRelationshipBanner;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ BaseBannerComponent a;
    public final /* synthetic */ int b;
    public final /* synthetic */ wya.c c;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.E0().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        a r0 = this.a.n;
        if (r0 == null) goto L6;
        r0.b(this.b, this.c);
        return;
    }

    public g(BaseBannerComponent r1, FlowRelationshipBanner.d r2) {
        this.a = r1;
        this.b = 2048;
        this.c = r2;
    }
}
