package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ CommonSearchEnterView a;

    public m(CommonSearchEnterView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        EditText r3 = CommonSearchEnterView.b(this.a);
        if (r3 == null) goto L5;
        r3.setText(null);
    L5:
        EditText r4 = CommonSearchEnterView.b(this.a);
        if (r4 == null) goto L8;
        r4.setCursorVisible(true);
    L8:
        this.a.f();
        this.a.i(1);
    }
}
