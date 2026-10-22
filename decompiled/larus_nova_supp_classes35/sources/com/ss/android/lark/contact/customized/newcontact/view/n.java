package com.ss.android.lark.contact.customized.newcontact.view;

import android.content.Context;
import android.view.View;
import com.larksuite.component.universe_design.dialog.UDDialog;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.ss.android.lark.contact.base.contact_new.mvp.NewContactView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class n implements OfficeNewContactAdapter.a {
    public final /* synthetic */ l a;

    public n(l r1) {
        this.a = r1;
    }

    @Override // com.ss.android.lark.contact.customized.newcontact.view.OfficeNewContactAdapter.a
    public final void a(View r5, final NewContactView.a r6) {
        Intrinsics.checkNotNullParameter(r5, "anchorView");
        Intrinsics.checkNotNullParameter(r6, "viewData");
        final l r0 = this.a;
        Context r1 = r0.e;
        if (r1 == null) goto L13;
        UDDialog r7 = new NewContactDeleteDialogBuilder(r1, r5, new OfficeNewContactView$showDeleteChatApplicationDialog$1$1(r0, r6)).a();
        if (DialogLancet.shouldBlockDialogShow(r7) == false) goto L11;
        DialogLancet.handleBlockedDialogShow(r7);
        return;
    L11:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
    L8:
        DialogLancet.beforeDialogShow(r7);
        r7.show();
        DialogLancet.afterDialogShow(r7);
        return;
    }

    @Override // com.ss.android.lark.contact.customized.newcontact.view.OfficeNewContactAdapter.a
    public final void b(String r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "userId");
        Intrinsics.checkNotNullParameter(r3, "friendRequestId");
        l.a r0 = this.a.c;
        if (r0 == null) goto L6;
        r0.t0(r2, r3);
        return;
    }
}
