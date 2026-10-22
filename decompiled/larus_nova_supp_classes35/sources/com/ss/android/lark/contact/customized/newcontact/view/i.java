package com.ss.android.lark.contact.customized.newcontact.view;

import androidx.lifecycle.Observer;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class i<T> implements Observer {
    public final /* synthetic */ OfficeNewContactFragment a;

    public i(OfficeNewContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r2) {
        if (Intrinsics.areEqual((Boolean) r2, Boolean.TRUE) == false) goto L9;
        l r3 = this.a.e;
        if (r3 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r3 = null;
    L7:
        r3.a.c.refreshComplete();
        return;
    }
}
