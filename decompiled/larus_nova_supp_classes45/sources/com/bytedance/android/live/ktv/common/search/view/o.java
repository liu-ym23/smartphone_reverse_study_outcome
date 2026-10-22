package com.bytedance.android.live.ktv.common.search.view;

import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class o implements View.OnTouchListener {
    public final /* synthetic */ CommonSearchEnterView a;

    public o(CommonSearchEnterView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View r2, MotionEvent r3) {
        if (r3 != null) goto L5;
    L15:
        if (r3 != null) goto L17;
        return false;
    L17:
        if (r3.getAction() != 0) goto L26;
        EditText r4 = CommonSearchEnterView.b(this.a);
        if (r4 == null) goto L27;
        r4.setCursorVisible(true);
        return false;
    L27:
        return false;
    L26:
        return false;
    L5:
        if (r3.getAction() != 1) goto L15;
        CommonSearchEnterView r5 = this.a;
        int r0 = CommonSearchEnterView.v;
        if (r5.c == 1) goto L9;
        r5.i(1);
    L9:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r6 = r5.q;
        if (r6 == null) goto L12;
        r6.syncHotWords();
    L12:
        com.bytedance.android.live.ktv.common.search.viewmodel.a r7 = r5.q;
        if (r7 == null) goto L23;
        r7.loadSearchHistory();
        return false;
    L23:
        return false;
    }
}
