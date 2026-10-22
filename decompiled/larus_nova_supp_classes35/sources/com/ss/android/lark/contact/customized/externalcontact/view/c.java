package com.ss.android.lark.contact.customized.externalcontact.view;

import android.view.View;
import com.ss.android.lark.widget.listener.OnSingleClickListener;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c extends OnSingleClickListener {
    public final /* synthetic */ OfficeContactListAdapter a;
    public final /* synthetic */ String b;

    public final void onSingleClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "v");
        OfficeContactListAdapter.a r3 = this.a.e;
        if (r3 == null) goto L6;
        r3.a(this.b);
        return;
    }

    public c(OfficeContactListAdapter r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
