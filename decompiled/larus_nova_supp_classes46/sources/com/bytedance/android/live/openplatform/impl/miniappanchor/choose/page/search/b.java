package com.bytedance.android.live.openplatform.impl.miniappanchor.choose.page.search;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes46.dex */
public final class b implements TextView.OnEditorActionListener {
    public final /* synthetic */ MiniAppChooseSearchFragment a;

    public b(MiniAppChooseSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L5;
        MiniAppChooseSearchFragment.T90(this.a);
    L5:
        return true;
    }
}
