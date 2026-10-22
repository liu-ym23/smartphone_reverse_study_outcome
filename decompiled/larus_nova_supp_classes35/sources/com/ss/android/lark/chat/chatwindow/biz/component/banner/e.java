package com.ss.android.lark.chat.chatwindow.biz.component.banner;

import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements ViewTreeObserver.OnGlobalLayoutListener {
    public final /* synthetic */ BaseBannerComponent a;
    public final /* synthetic */ int b;

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.a.E0().getViewTreeObserver().removeOnGlobalLayoutListener(this);
        a r0 = this.a.n;
        if (r0 == null) goto L6;
        r0.a(this.b);
        return;
    }

    public e(BaseBannerComponent r1) {
        this.a = r1;
        this.b = 2048;
    }
}
