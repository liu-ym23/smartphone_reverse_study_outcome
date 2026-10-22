package com.ss.android.lark.contact.customized.externalcontact.view.list;

import android.view.View;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeContactListAdapter;
import com.ss.android.lark.contact.customized.externalcontact.view.OfficeExternalContactFragment$initExternalContactView$actionHandler$1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements OfficeContactListAdapter.a {
    public final /* synthetic */ a.InterfaceC0173a a;

    public i(OfficeExternalContactFragment$initExternalContactView$actionHandler$1 r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.OfficeContactListAdapter.a
    public final void a(String r2) {
        Intrinsics.checkNotNullParameter(r2, "chatterId");
        this.a.a(r2);
    }

    @Override // com.ss.android.lark.contact.customized.externalcontact.view.OfficeContactListAdapter.a
    public final void b(View r2, long r3) {
        Intrinsics.checkNotNullParameter(r2, "anchorView");
        this.a.b(r2, r3);
    }
}
