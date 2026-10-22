package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class l implements View.OnClickListener {
    public final /* synthetic */ OfficeExternalContactFragment a;

    public l(OfficeExternalContactFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OfficeExternalContactFragment r3 = this.a;
        int r0 = OfficeExternalContactFragment.r;
        r3.X90().fetchData(this.a.W90());
    }
}
