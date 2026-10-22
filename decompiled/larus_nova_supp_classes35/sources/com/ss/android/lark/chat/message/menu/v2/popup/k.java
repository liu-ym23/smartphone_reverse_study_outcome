package com.ss.android.lark.chat.message.menu.v2.popup;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ PopupMenuMainContent a;

    public k(PopupMenuMainContent r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        PopupMenuMainContent r3 = this.a;
        if (r3.e == false) goto L10;
        d r4 = r3.getMenuContext();
        if (r4 == null) goto L11;
        a r5 = r4.a();
        if (r5 == null) goto L12;
        r5.e();
        return;
    L12:
        return;
    L11:
        return;
    }
}
