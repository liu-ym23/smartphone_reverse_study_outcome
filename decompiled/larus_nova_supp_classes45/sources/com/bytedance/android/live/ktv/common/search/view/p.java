package com.bytedance.android.live.ktv.common.search.view;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class p implements TextView.OnEditorActionListener {
    public final /* synthetic */ CommonSearchEnterView a;

    public p(CommonSearchEnterView r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        return CommonSearchEnterView.c(this.a, r2);
    }
}
