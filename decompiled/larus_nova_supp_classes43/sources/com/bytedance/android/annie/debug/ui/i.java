package com.bytedance.android.annie.debug.ui;

import android.content.Context;
import android.net.Uri;
import com.bytedance.mt.protector.impl.UriProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class i extends DialogItem {
    public final Uri g;

    @Override // com.bytedance.android.annie.debug.ui.DialogItem
    public final void a(Context r10) {
        Uri r0 = this.g;
        if (r0 == null) goto L11;
        if (r10 == null) goto L11;
        UrlFormDialog r1 = new UrlFormDialog(r10, r0);
        if (DialogLancet.shouldBlockDialogShow(r1) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r1);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L10:
        DialogLancet.beforeDialogShow(r1);
        r1.show();
        DialogLancet.afterDialogShow(r1);
        return;
    L11:
        super.a(r10);
    }

    public i(String r10, String r11) {
        super(r10, r11, null);
        this.g = UriProtector.parse(r11);
    }
}
