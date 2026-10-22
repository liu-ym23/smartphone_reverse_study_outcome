package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import com.ss.android.lark.contact.base.statistics.ContactHitPoint;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d extends rcc.c {
    public final /* synthetic */ OfficeNewContactAdapter a;
    public final /* synthetic */ NewContactView.a b;

    public final void a(View r3) {
        Intrinsics.checkNotNullParameter(r3, "v");
        ContactHitPoint.d("member_avatar");
        OfficeNewContactAdapter.a r4 = this.a.b;
        if (r4 == null) goto L6;
        NewContactView.a r0 = this.b;
        r4.b(r0.b, r0.a);
        return;
    }

    public d(OfficeNewContactAdapter r1, NewContactView.a r2) {
        this.a = r1;
        this.b = r2;
    }
}
