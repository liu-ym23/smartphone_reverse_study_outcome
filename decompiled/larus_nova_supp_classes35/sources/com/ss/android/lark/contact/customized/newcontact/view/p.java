package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class p implements View.OnClickListener {
    public final /* synthetic */ l a;

    public p(l r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        ContactHitPoint.d("add_external");
        this.a.b.z();
    }
}
