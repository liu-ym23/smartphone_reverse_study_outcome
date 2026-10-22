package com.ss.android.lark.contact.customized.externalinvite.view;

import android.view.View;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnLongClickListener {
    public final /* synthetic */ OfficeInviteExternalFragment a;

    public e(OfficeInviteExternalFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View r3) {
        OfficeInviteExternalFragment r4 = this.a;
        int r0 = OfficeInviteExternalFragment.i;
        OfficeInviteExternalViewModel r5 = r4.U90();
        OfficeInviteExternalFragment r1 = this.a;
        ContactDbInviteExternalViewFeishuBinding r2 = r1.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L5:
        r5.onClickSearchPhoneOrEmail(r1, r2.n);
        return true;
    }
}
