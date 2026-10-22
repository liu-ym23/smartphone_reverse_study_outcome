package com.ss.android.lark.contact.customized.mygroup.view;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ OfficeMyJoinGroupFragment a;

    public f(OfficeMyJoinGroupFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Context r2 = this.a.getContext();
        if (r2 == null) goto L6;
        OfficeContactPageUtils.a(r2);
        return;
    }
}
