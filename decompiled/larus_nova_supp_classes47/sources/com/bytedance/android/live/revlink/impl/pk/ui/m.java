package com.bytedance.android.live.revlink.impl.pk.ui;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes47.dex */
public final class m implements View.OnClickListener {
    public final /* synthetic */ PKRivalsSearchHistoryView a;

    public m(PKRivalsSearchHistoryView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        PKRivalsSearchHistoryView r0 = this.a;
        Object r3 = r2.getTag();
        if (r3 == null) goto L9;
        String r4 = (String) r3;
        PKRivalsSearchHistoryView.a r1 = r0.c;
        if (r1 == null) goto L10;
        r1.v8(r4);
        return;
    L10:
        return;
    L9:
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }
}
