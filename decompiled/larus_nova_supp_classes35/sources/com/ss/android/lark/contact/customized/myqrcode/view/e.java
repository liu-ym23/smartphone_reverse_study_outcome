package com.ss.android.lark.contact.customized.myqrcode.view;

import android.view.View;
import com.ss.android.lark.contact.customized.databinding.ContactDbActivityMyQrcodeBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class e implements View.OnClickListener {
    public final /* synthetic */ OfficeMyQrCodeFragment a;

    public e(OfficeMyQrCodeFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ContactDbActivityMyQrcodeBinding r5 = this.a.d;
        ContactDbActivityMyQrcodeBinding r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L5:
        r5.b.setVisibility(8);
        ContactDbActivityMyQrcodeBinding r6 = this.a.d;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r6 = null;
    L8:
        r6.d.a();
        ContactDbActivityMyQrcodeBinding r7 = this.a.d;
        if (r7 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L12:
        r0.c.setVisibility(8);
        this.a.T90().fetchContactToken();
        return;
    L11:
        r0 = r7;
        goto L12
    }
}
