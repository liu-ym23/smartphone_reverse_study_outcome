package com.ss.android.lark.chat.chatwindow.chat.message.cellv2.block.text;

import android.view.ViewTreeObserver;
import com.larksuite.framework.ui.BasePopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes35.dex */
public final class c implements ViewTreeObserver.OnScrollChangedListener {
    public final /* synthetic */ g7b.a a;
    public final /* synthetic */ TextClickListenerProviderV2 b;

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final void onScrollChanged() {
        BasePopupWindow r0 = this.a.e;
        if (r0 == null) goto L5;
        PopupWindowLancet.handleDismissBeforeOrigin(r0);
        r0.dismiss();
    L5:
        this.b.b.getViewTreeObserver().removeOnScrollChangedListener(this);
    }

    public c(g7b.a r1, TextClickListenerProviderV2 r2) {
        this.a = r1;
        this.b = r2;
    }
}
