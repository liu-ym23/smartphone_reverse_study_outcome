package com.ss.android.lark.contact.customized.externalinvite.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ OfficeInviteExternalFragment a;

    public c(OfficeInviteExternalFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OfficeInviteExternalFragment r3 = this.a;
        int r0 = OfficeInviteExternalFragment.i;
        r3.U90().requestFinish(this.a);
    }
}
