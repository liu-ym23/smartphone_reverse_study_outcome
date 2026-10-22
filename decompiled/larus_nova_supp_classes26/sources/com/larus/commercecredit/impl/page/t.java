package com.larus.commercecredit.impl.page;

import android.webkit.WebView;
import com.larus.utils.logger.FLogger;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
public final class t implements zt8.c {
    public final /* synthetic */ CommerceCreditWebFragment a;

    public t(CommerceCreditWebFragment r1) {
        this.a = r1;
    }

    @Override // zt8.c
    public final void c(WebView r4) {
        this.a.g = r4;
        FLogger r0 = FLogger.a;
        StringBuilder r1 = new StringBuilder("onViewCreated webView=");
        if (r4 == null) goto L5;
        boolean r5 = true;
    L6:
        r1.append(r5);
        r0.d("CommerceCreditWebFragment", r1.toString());
        return;
    L5:
        r5 = false;
        goto L6
    }

    @Override // zt8.c
    public final void a(int r4, int r5, boolean r6, boolean r7) {
        FLogger.a.d("CommerceCreditWebFragment", "onOverScrolled scrollX=" + r4 + " scrollY=" + r5 + " clampedX=" + r6 + " clampedY=" + r7);
    }

    @Override // zt8.c
    public final void onScrollChanged(int r4, int r5, int r6, int r7) {
        FLogger.a.d("CommerceCreditWebFragment", "onScrollChanged l=" + r4 + " t=" + r5 + " oldl=" + r6 + " oldt=" + r7);
    }

    @Override // zt8.c
    public final void b(int r4, int r5, int r6, int r7, int r8, int r9, int r10, int r11) {
        if (r4 != 0) goto L7;
        if (r5 >= 0) goto L7;
        WebView r0 = this.a.g;
        if (r0 == null) goto L7;
        r0.setTag(2131388155, Boolean.TRUE);
    L7:
        FLogger.a.d("CommerceCreditWebFragment", "overScrollBy deltaX=" + r4 + " deltaY=" + r5 + " scrollX=" + r6 + " scrollY=" + r7 + " scrollRangeX=" + r8 + " scrollRangeY=" + r9 + " maxOverScrollX=" + r10 + " maxOverScrollY=" + r11);
    }
}
