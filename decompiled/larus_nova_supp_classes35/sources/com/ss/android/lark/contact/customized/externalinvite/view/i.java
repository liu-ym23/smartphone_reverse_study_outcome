package com.ss.android.lark.contact.customized.externalinvite.view;

import android.view.View;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ OfficeInviteExternalFragment a;

    public i(OfficeInviteExternalFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r2) {
        ContactDbInviteExternalViewFeishuBinding r3 = this.a.e;
        if (r3 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L5:
        r3.b.setVisibility(8);
        this.a.U90().fetchContactToken();
    }
}
