package com.ss.android.lark.contact.customized.externalinvite.view;

import android.content.Context;
import android.view.View;
import com.ss.android.lark.contact.customized.OfficeContactPageUtils;
import com.ss.android.lark.contact.customized.myqrcode.OfficeMyQrCodeActivity;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class h implements View.OnClickListener {
    public static final h a = null;

    static {
        a = new h();
    }

    public h() {
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r3) {
        Lazy r0 = OfficeContactPageUtils.a;
        Context r4 = r3.getContext();
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter("invite", "from");
        int r1 = OfficeMyQrCodeActivity.a;
        OfficeMyQrCodeActivity.a.a(r4, "invite");
    }
}
