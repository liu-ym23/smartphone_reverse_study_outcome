package com.ss.android.lark.contact.customized.newcontact.view;

import android.view.View;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class a implements View.OnClickListener {
    public final /* synthetic */ NewContactDeleteDialogBuilder a;

    public a(NewContactDeleteDialogBuilder r1) {
        this.a = r1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        Function0<Unit> r2 = this.a.e;
        if (r2 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("dismiss");
        r2 = null;
    L5:
        r2.invoke();
    }
}
