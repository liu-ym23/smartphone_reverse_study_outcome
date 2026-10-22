package com.ss.android.lark.contact.base.contact_search;

import com.ss.android.lark.contact.base.statistics.InvHitPoint;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class z implements s.a {
    public final /* synthetic */ String a;
    public final /* synthetic */ b0 b;

    public z(b0 r1, String r2) {
        this.b = r1;
        this.a = r2;
    }

    @Override // com.ss.android.lark.contact.base.contact_search.s.a
    public final void a(String r2, boolean r3, boolean r4) {
        this.b.b.v3(r2, r3);
        InvHitPoint.e(r4);
        b0 r5 = this.b;
        String r6 = this.a;
        r5.getClass();
        if (r6.contains("@") == false) goto L5;
        InvHitPoint.c(InvHitPoint.ShareMethod.INVITE_EMAIL, r5.b.getUniqueId());
        return;
    L5:
        InvHitPoint.c(InvHitPoint.ShareMethod.INVITE_MESSAGE, r5.b.getUniqueId());
    }
}
