package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class r extends b7.a {
    public final /* synthetic */ WebDialogFragmentForAnnie a;

    public r(WebDialogFragmentForAnnie r1) {
        this.a = r1;
    }

    public final void onLoadSuccess(View r4) {
        super.onLoadSuccess(r4);
        gf1.a r5 = this.a.i;
        if (r5 == null) goto L6;
        r5.a(1, 0, "");
        return;
    }

    public final boolean onFallback(int r1, String r2) {
        Intrinsics.checkNotNullParameter(r2, "errorMessage");
        this.a.getClass();
        return false;
    }

    public final void onLoadStart(View r2, boolean r3) {
        super.onLoadStart(r2, r3);
        gf1.a r4 = this.a.i;
        if (r4 == null) goto L6;
        r4.a(0, 0, "");
        return;
    }

    public final void onLoadFail(View r2, String r3, String r4) {
        super.onLoadFail(r2, r3, r4);
        gf1.a r5 = this.a.i;
        if (r5 == null) goto L6;
        r5.a(2, -1, r4);
        return;
    }
}
