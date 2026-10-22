package com.ss.android.lark.contact.customized.search.view;

import android.view.KeyEvent;
import android.widget.TextView;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements TextView.OnEditorActionListener {
    public final /* synthetic */ OfficeInviteExternalSearchFragment a;

    public h(OfficeInviteExternalSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.widget.TextView.OnEditorActionListener
    public final boolean onEditorAction(TextView r1, int r2, KeyEvent r3) {
        if (r2 != 3) goto L6;
        OfficeInviteExternalSearchFragment r4 = this.a;
        int r5 = OfficeInviteExternalSearchFragment.h;
        r4.S90().onSearch();
        com.ss.android.lark.inv.export.util.e.a(this.a.getActivity());
        com.ss.android.lark.contact.customized.common.b.b();
        return true;
    L6:
        return false;
    }
}
