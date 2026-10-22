package com.bytedance.android.annie.debug.ui;

import android.view.View;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes43.dex */
public final class f implements View.OnClickListener {
    public final /* synthetic */ UrlFormAdapter a;
    public final /* synthetic */ UrlFormViewHolder b;

    public f(UrlFormAdapter r1, UrlFormViewHolder r10) {
        this.a = r1;
        this.b = r10;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r10) {
        int r11 = this.a.a.size();
        int r0 = this.b.getAdapterPosition();
        boolean r1 = false;
        if (r0 < 0) goto L6;
        if (r0 >= r11) goto L6;
        r1 = true;
    L6:
        if (r1 == false) goto L16;
        g r12 = (g) ListProtector.get(this.a.a, this.b.getAdapterPosition());
        UrlFormDialog r13 = new UrlFormDialog(this.a.b, r12.b);
        if (DialogLancet.shouldBlockDialogShow(r13) == false) goto L14;
        DialogLancet.handleBlockedDialogShow(r13);
        return;
    L14:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L11:
        DialogLancet.beforeDialogShow(r13);
        r13.show();
        DialogLancet.afterDialogShow(r13);
        return;
    }
}
