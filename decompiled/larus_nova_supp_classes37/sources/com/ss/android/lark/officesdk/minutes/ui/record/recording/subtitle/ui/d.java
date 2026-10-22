package com.ss.android.lark.officesdk.minutes.ui.record.recording.subtitle.ui;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes37.dex */
public final class d implements View.OnClickListener {
    public final /* synthetic */ boolean a;
    public final /* synthetic */ c b;

    public d(boolean r1, c r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r1) {
        if (this.a == false) goto L5;
        this.b.b.b();
    L6:
        PopupWindow r2 = this.b.h;
        PopupWindowLancet.handleDismissBeforeOrigin(r2);
        r2.dismiss();
        return;
    L5:
        this.b.b.c();
        goto L6
    }
}
