package com.ss.android.lark.contact.impl.group;

import android.view.View;
import com.suite.lark.component.navroute.forseti.f;
import com.suite.lark.component.navroute.forseti.g;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements View.OnClickListener {
    public final /* synthetic */ ContactsMyGroupView a;

    public c(ContactsMyGroupView r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ContactsMyGroupFragment.a r3 = (ContactsMyGroupFragment.a) this.a.b;
        g r0 = f.b(r3.a);
        if (r0 == null) goto L5;
        r0.g(null);
        return;
    L5:
        r3.a.finish();
    }
}
