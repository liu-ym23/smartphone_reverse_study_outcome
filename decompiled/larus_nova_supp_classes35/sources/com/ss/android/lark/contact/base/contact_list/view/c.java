package com.ss.android.lark.contact.base.contact_list.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_list.mvp.f;
import com.ss.android.lark.contact.base.contact_list.mvp.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ w8b.a a;
    public final /* synthetic */ ExternalContactAdapter2 b;

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        ExternalContactAdapter2.a r4 = this.b.e;
        if (r4 == null) goto L6;
        g r5 = (g) r4;
        qqb.c.c(new f(r5, this.a));
        return;
    }

    public c(ExternalContactAdapter2 r1, w8b.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
