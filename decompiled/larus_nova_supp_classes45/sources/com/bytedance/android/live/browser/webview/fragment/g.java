package com.bytedance.android.live.browser.webview.fragment;

import android.view.View;
import com.bytedance.android.live.core.utils.LiveResUtil;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class g implements View.OnLayoutChangeListener {
    public final /* synthetic */ AbsHybridFragment a;

    public g(AbsHybridFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View r1, int r2, int r3, int r4, int r5, int r6, int r7, int r8, int r9) {
        if (this.a.d == true) goto L5;
        return;
    L5:
        if (Math.abs(r5 - r9) >= 200) goto L8;
        return;
    L8:
        if (r5 >= (LiveResUtil.getScreenHeight() * 0.75f)) goto L12;
        AbsHybridFragment r11 = this.a;
        if (r11.e == true) goto L17;
        r11.e = true;
        AbsHybridFragment.S90(r11, true);
        return;
    L17:
        return;
    L12:
        AbsHybridFragment r12 = this.a;
        if (r12.e == false) goto L19;
        r12.e = false;
        AbsHybridFragment.S90(r12, false);
        return;
    }
}
