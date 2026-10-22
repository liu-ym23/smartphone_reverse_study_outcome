package com.ss.android.lark.contact.base.contact_search;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements TextView.OnEditorActionListener {
    public final /* synthetic */ s a;

    public g(s r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 4) goto L6;
        this.a.y.performClick();
        return true;
    L6:
        return false;
    }
}
