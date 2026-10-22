package com.bytedance.android.live.ktv.common.search.view;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ CommonSearchEnterView a;

    public l(CommonSearchEnterView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        CommonSearchEnterView r5 = this.a;
        EditText r0 = CommonSearchEnterView.b(r5);
        if (r0 == null) goto L8;
        Editable r1 = r0.getText();
        if (r1 == null) goto L8;
        String r2 = r1.toString();
        if (r2 == null) goto L8;
    L9:
        r5.h(r2, "ugc", false);
        return;
    L8:
        r2 = "";
        goto L9
    }
}
