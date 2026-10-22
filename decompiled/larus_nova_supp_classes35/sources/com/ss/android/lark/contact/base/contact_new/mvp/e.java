package com.ss.android.lark.contact.base.contact_new.mvp;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e extends rcc.c {
    public final /* synthetic */ NewContactView.a a;
    public final /* synthetic */ NewContactAdapter b;

    public final void a(View r3) {
        ContactHitPoint.d("member_avatar");
        NewContactAdapter.a r4 = this.b.b;
        if (r4 == null) goto L6;
        NewContactView.a r0 = this.a;
        String r1 = r0.b;
        String r2 = r0.a;
        ((m) r4).a.b.t0(r1, r2);
        return;
    }

    public e(NewContactAdapter r1, NewContactView.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
