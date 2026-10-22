package com.bytedance.android.live.search.impl.search;

import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.search.impl.search.adapter.LiveSearchHistoryAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ LiveSearchResultFragment a;

    public n(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        EditText r3 = this.a.g;
        if (r3 == null) goto L5;
        r3.setText("");
    L5:
        EditText r4 = this.a.g;
        if (r4 == null) goto L8;
        r4.setCursorVisible(true);
    L8:
        int r5 = com.bytedance.android.live.search.impl.search.helper.a.a;
        com.bytedance.android.live.search.impl.search.helper.a.b(this.a.g);
        LiveSearchIntermediateView r6 = this.a.d;
        if (r6 == null) goto L16;
        LiveSearchIntermediateFragment r7 = r6.d;
        if (r7 == null) goto L17;
        LiveSearchHistoryAdapter r8 = r7.f;
        if (r8 == null) goto L18;
        r8.d = false;
        return;
    L18:
        return;
    L17:
        return;
    }
}
