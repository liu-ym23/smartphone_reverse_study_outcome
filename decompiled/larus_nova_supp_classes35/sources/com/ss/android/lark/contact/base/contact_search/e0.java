package com.ss.android.lark.contact.base.contact_search;

import android.view.View;
import com.ss.android.lark.contact.base.statistics.InvHitPoint;
import com.ss.android.lark.statistics.Statistics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e0 implements View.OnClickListener {
    public final /* synthetic */ b0 a;

    public e0(b0 r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        this.a.getClass();
        Statistics.sendEvent("invite_people_external_search_nomatch_invite", InvHitPoint.b(null));
        this.a.b.H4();
    }
}
