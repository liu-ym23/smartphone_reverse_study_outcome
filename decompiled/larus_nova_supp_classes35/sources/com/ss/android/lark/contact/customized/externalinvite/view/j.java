package com.ss.android.lark.contact.customized.externalinvite.view;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.contact.customized.databinding.ContactDbInviteExternalViewFeishuBinding;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class j implements Runnable {
    public final /* synthetic */ OfficeInviteExternalFragment a;

    public j(OfficeInviteExternalFragment r1) {
        this.a = r1;
    }

    public final void a() {
        if (this.a.isAdded() == true) goto L5;
        return;
    L5:
        ContactDbInviteExternalViewFeishuBinding r0 = this.a.e;
        ContactDbInviteExternalViewFeishuBinding r1 = null;
        if (r0 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r0 = null;
    L8:
        r0.b.setVisibility(8);
        ContactDbInviteExternalViewFeishuBinding r2 = this.a.e;
        if (r2 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r2 = null;
    L11:
        r2.o.setVisibility(8);
        ContactDbInviteExternalViewFeishuBinding r3 = this.a.e;
        if (r3 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
        r3 = null;
    L14:
        r3.c.setVisibility(0);
        ContactDbInviteExternalViewFeishuBinding r4 = this.a.e;
        if (r4 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("viewBinding");
    L18:
        r1.d.c.start();
        return;
    L17:
        r1 = r4;
        goto L18
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
