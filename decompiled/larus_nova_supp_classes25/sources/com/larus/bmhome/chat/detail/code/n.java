package com.larus.bmhome.chat.detail.code;

import android.view.View;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes25.dex */
public final /* synthetic */ class n implements Runnable {
    public final /* synthetic */ NestedScrollView a;

    public /* synthetic */ n(NestedScrollView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        NestedScrollView r0 = this.a;
        int r1 = CodeBlockDetailFragment.k0;
        View r2 = r0.getChildAt(0);
        if (r2 == null) goto L6;
        r0.smoothScrollTo(0, r2.getHeight() - r0.getHeight());
        return;
    }
}
