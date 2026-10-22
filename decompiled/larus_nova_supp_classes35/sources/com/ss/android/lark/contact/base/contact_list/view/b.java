package com.ss.android.lark.contact.base.contact_list.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_list.mvp.g;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import rcc.e;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class b extends OnSingleClickListener {
    public final /* synthetic */ w8b.a a;
    public final /* synthetic */ ExternalContactAdapter2 b;

    public final void onSingleClick(View r3) {
        ContactHitPoint.b("member_avatar");
        e.a.a.getClass();
        r3.getLocationInWindow(new int[2]);
        r3.getTop();
        r3.getRight();
        r3.getWidth();
        r3.getHeight();
        r3.getLocationOnScreen(new int[2]);
        ExternalContactAdapter2.a r4 = this.b.e;
        if (r4 == null) goto L6;
        final String r0 = this.a.e;
        final g r5 = (g) r4;
        qqb.c.c(new com.ss.android.lark.contact.base.contact_list.mvp.e(r5, r0));
        return;
    }

    public b(ExternalContactAdapter2 r1, w8b.a r2) {
        this.b = r1;
        this.a = r2;
    }
}
