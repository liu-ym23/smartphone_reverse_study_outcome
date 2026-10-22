package com.ss.android.lark.contact.base.contact_search;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class r implements View.OnFocusChangeListener {
    public final /* synthetic */ s a;

    public r(s r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View r1, boolean r2) {
        if (r2 == false) goto L9;
        s r3 = this.a;
        if (r3.v.getText().length() == 0) goto L6;
        boolean r4 = true;
    L7:
        r3.m(Boolean.valueOf(r4));
        return;
    L6:
        r4 = false;
        goto L7
    }
}
