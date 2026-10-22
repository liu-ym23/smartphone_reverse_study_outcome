package com.ss.android.lark.chat.cot.detail;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ c a;

    public d(c r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        com.ss.android.lark.biz.im.extension.panel.drag.i r2 = this.a.f;
        if (r2 == null) goto L6;
        r2.dismiss();
        return;
    }
}
