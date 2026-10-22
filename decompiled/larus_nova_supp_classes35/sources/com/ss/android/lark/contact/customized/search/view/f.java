package com.ss.android.lark.contact.customized.search.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteSearchViewLayoutBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class f implements Runnable {
    public final /* synthetic */ OfficeInviteExternalSearchFragment a;

    public f(OfficeInviteExternalSearchFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ContactDbInviteSearchViewLayoutBinding r0 = this.a.d;     // Catch: Throwable -> L7
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");     // Catch: Throwable -> L7
        r0 = null;
    L5:
        com.ss.android.lark.inv.export.util.e.b(r0.j);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L11;
        return;
    L11:
        throw th;
    }
}
