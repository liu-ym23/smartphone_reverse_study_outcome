package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnLongClickListener {
    public final /* synthetic */ OfficeNewContactAdapter a;
    public final /* synthetic */ NewContactView.a b;

    public e(OfficeNewContactAdapter r1, NewContactView.a r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        OfficeNewContactAdapter.a r0 = this.a.b;
        if (r0 == null) goto L7;
        Intrinsics.checkNotNull(r3);
        r0.a(r3, this.b);
        return true;
    L7:
        return true;
    }
}
