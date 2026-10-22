package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import com.ss.android.lark.contact.base.contact_new.page.NewContactFragment;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k implements View.OnClickListener {
    public final /* synthetic */ NewContactView a;

    public k(NewContactView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        NewContactFragment.a r3 = (NewContactFragment.a) this.a.c;
        com.suite.lark.component.navroute.forseti.g r0 = com.suite.lark.component.navroute.forseti.f.b(r3.a);
        if (r0 == null) goto L5;
        r0.g(null);
        return;
    L5:
        r3.a.finish();
    }
}
