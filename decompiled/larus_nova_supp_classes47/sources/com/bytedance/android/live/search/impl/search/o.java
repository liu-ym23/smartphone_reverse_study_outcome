package com.bytedance.android.live.search.impl.search;

import android.view.View;
import android.widget.EditText;
import com.bytedance.android.live.search.impl.search.viewmodel.LiveSearchIntermediateViewModel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class o implements View.OnClickListener {
    public final /* synthetic */ LiveSearchResultFragment a;

    public o(LiveSearchResultFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        LiveSearchResultFragment r5 = this.a;
        int r0 = LiveSearchResultFragment.x;
        r5.Z90(false, true);
        LiveSearchIntermediateView r6 = this.a.d;
        if (r6 == null) goto L7;
        LiveSearchIntermediateViewModel r7 = r6.a;
        if (r7 == null) goto L7;
        r7.hideIntermediate();
    L7:
        EditText r8 = this.a.g;
        if (r8 == null) goto L10;
        r8.setText("");
    L10:
        View r9 = this.a.n;
        if (r9 == null) goto L13;
        r9.setVisibility(8);
    L13:
        int r10 = com.bytedance.android.live.search.impl.search.helper.a.a;
        com.bytedance.android.live.search.impl.search.helper.a.a(this.a.g);
        EditText r12 = this.a.g;
        if (r12 == null) goto L16;
        r12.setCursorVisible(false);
    L16:
        this.a.o = "";
    }
}
