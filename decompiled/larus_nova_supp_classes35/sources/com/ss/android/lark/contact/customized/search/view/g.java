package com.ss.android.lark.contact.customized.search.view;

import android.text.Editable;
import android.widget.ImageView;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import com.ss.android.lark.utils.q0;
import com.tencent.qqmusic.third.api.contract.BuildConfig;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class g extends q0 {
    public final /* synthetic */ OfficeInviteExternalSearchFragment a;

    public g(OfficeInviteExternalSearchFragment r1) {
        this.a = r1;
    }

    public final void afterTextChanged(Editable r8) {
        Intrinsics.checkNotNullParameter(r8, "s");
        String r9 = StringsKt.replace$default(r8.toString(), " ", BuildConfig.FLAVOR, false, 4, null);
        ContactDbInviteSearchViewLayoutBinding r0 = this.a.d;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L5:
        ImageView r1 = r0.i;
        boolean r2 = true;
        if (r9.length() != 0) goto L8;
        boolean r3 = true;
    L9:
        if (r3 == false) goto L11;
        int r4 = 8;
    L12:
        r1.setVisibility(r4);
        OfficeInviteExternalSearchAdapter r5 = this.a.e;
        if (r5 == null) goto L15;
        Intrinsics.checkNotNullParameter(r9, "query");
        r5.d = r9;
    L15:
        this.a.S90().onQueryChanged(r9);
        this.a.S90().updateQuery(r9);
        if (r9.length() == 0) goto L19;
        r2 = false;
    L19:
        if (r2 == false) goto L21;
        this.a.U90();
        return;
    L21:
        this.a.T90(r9);
        return;
    L11:
        r4 = 0;
        goto L12
    L8:
        r3 = false;
        goto L9
    }
}
