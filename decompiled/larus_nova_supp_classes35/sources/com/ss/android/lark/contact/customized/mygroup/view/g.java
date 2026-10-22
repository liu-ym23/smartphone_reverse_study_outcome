package com.ss.android.lark.contact.customized.mygroup.view;

import android.view.View;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g implements View.OnClickListener {
    public final /* synthetic */ OfficeMyJoinGroupFragment a;

    public g(OfficeMyJoinGroupFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        OfficeMyJoinGroupFragment r3 = this.a;
        int r0 = OfficeMyJoinGroupFragment.i;
        r3.S90().loadInitial();
    }
}
