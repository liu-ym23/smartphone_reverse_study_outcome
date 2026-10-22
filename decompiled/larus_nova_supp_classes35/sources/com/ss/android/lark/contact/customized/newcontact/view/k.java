package com.ss.android.lark.contact.customized.newcontact.view;

import androidx.lifecycle.Observer;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class k<T> implements Observer {
    public final /* synthetic */ OfficeNewContactFragment a;

    public k(OfficeNewContactFragment r1) {
        this.a = r1;
    }

    public final void onChanged(Object r4) {
        Pair r5 = (Pair) r4;
        if (r5 == null) goto L9;
        l r0 = this.a.e;
        if (r0 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("newContactView");
        r0 = null;
    L7:
        String r1 = (String) r5.getFirst();
        String r6 = (String) r5.getSecond();
        r0.getClass();
        Intrinsics.checkNotNullParameter(r1, "userId");
        Intrinsics.checkNotNullParameter(r6, "friendRequestId");
        r0.b.J(r1, r6);
        return;
    }
}
