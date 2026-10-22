package com.ss.android.lark.contact.customized.externalcontact.view;

import androidx.lifecycle.Observer;
import com.ss.android.lark.contact.base.dependency.ContactBaseModuleDependency;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ OfficeExternalContactFragment a;

    public i(OfficeExternalContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        String r5 = (String) r4;
        if (r5 == null) goto L6;
        ContactBaseModuleDependency.b.jumpProfilePage(OfficeExternalContactFragment.U90(this.a), r5, 17);
        return;
    }
}
