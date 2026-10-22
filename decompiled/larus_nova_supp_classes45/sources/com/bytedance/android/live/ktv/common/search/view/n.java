package com.bytedance.android.live.ktv.common.search.view;

import android.view.View;
import android.widget.EditText;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes45.dex */
public final class n implements View.OnClickListener {
    public final /* synthetic */ CommonSearchEnterView a;

    public n(CommonSearchEnterView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        EditText r3 = CommonSearchEnterView.b(this.a);
        if (r3 == null) goto L5;
        r3.setText(null);
    L5:
        this.a.e();
        Function0<Unit> r4 = this.a.t;
        if (r4 == null) goto L9;
        Unit r5 = (Unit) r4.invoke();
        return;
    }
}
