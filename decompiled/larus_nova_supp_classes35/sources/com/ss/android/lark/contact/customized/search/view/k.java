package com.ss.android.lark.contact.customized.search.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ OfficeInviteExternalSearchFragment a;

    public k(OfficeInviteExternalSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OfficeInviteExternalSearchFragment r3 = this.a;
        int r0 = OfficeInviteExternalSearchFragment.h;
        r3.S90().onSearch();
        com.ss.android.lark.inv.export.util.e.a(this.a.getActivity());
        com.ss.android.lark.contact.customized.common.b.b();
    }
}
