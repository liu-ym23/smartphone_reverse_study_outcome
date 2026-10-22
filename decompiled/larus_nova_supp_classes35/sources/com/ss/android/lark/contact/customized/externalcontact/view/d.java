package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class d implements View.OnLongClickListener {
    public final /* synthetic */ OfficeContactListAdapter a;
    public final /* synthetic */ long b;

    public d(OfficeContactListAdapter r1, long r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r4) {
        OfficeContactListAdapter.a r0 = this.a.e;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r4);
        r0.b(r4, this.b);
        return true;
    L7:
        return true;
    }
}
