package com.bytedance.android.live.search.impl.search;

import android.view.MotionEvent;
import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements View.OnTouchListener {
    public final /* synthetic */ LiveSearchResultFragment a;

    public m(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        if (r3.getAction() != 1) goto L5;
        LiveSearchResultFragment r4 = this.a;
        int r5 = LiveSearchResultFragment.x;
        r4.T90(false);
    L5:
        return false;
    }
}
