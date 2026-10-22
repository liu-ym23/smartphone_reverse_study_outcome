package com.ss.android.lark.contact.customized.search.view;

import android.view.View;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ OfficeInviteExternalSearchFragment a;

    public i(OfficeInviteExternalSearchFragment r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r4) {
        ContactDbInviteSearchViewLayoutBinding r5 = this.a.d;
        ContactDbInviteSearchViewLayoutBinding r0 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r5 = null;
    L5:
        r5.j.setText(BuildConfig.FLAVOR);
        ContactDbInviteSearchViewLayoutBinding r6 = this.a.d;
        if (r6 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L9:
        r0.i.setVisibility(8);
        return;
    L8:
        r0 = r6;
        goto L9
    }
}
