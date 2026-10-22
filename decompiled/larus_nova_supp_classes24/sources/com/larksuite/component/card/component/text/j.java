package com.larksuite.component.card.component.text;

import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public final class j implements com.ss.android.lark.widget.select.m.d {
    public final /* synthetic */ UniversalCardTextLynxUI a;

    public j(UniversalCardTextLynxUI r1) {
        this.a = r1;
    }

    public final void a(com.ss.android.lark.widget.select.g r12) {
        Intrinsics.checkNotNullParameter(r12, "it");
        UniversalCardTextLynxUI r0 = this.a;
        r0.a = r12;
        if (((PopupWindow) r0.d.getValue()).isShowing() == false) goto L5;
        PopupWindow r1 = (PopupWindow) r0.d.getValue();
        PopupWindowLancet.handleDismissBeforeOrigin(r1);
        r1.dismiss();
    L5:
        PopupWindow r2 = (PopupWindow) r0.d.getValue();
        View r8 = r0.getView();
        int r9 = (r12.d + ((UniversalCardLightTextView) r0.getView()).getLeft()) + ((UniversalCardLightTextView) r0.getView()).getPaddingLeft();
        int r13 = r12.b - ((PopupWindow) r0.d.getValue()).getContentView().getMeasuredHeight();
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L9;
        return;
    L9:
        if ((r2 instanceof PopupWindow) == true) goto L11;
    L13:
        OverlaySource r3 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(r2, r8, r3, 0, r9, r13) == true) goto L20;
        r2.showAtLocation(r8, 0, r9, r13);
        PopupWindowLancet.trackAfterShow(r2, r3, r8);
        return;
    L20:
        return;
    L11:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r2) == false) goto L13;
        r2.showAtLocation(r8, 0, r9, r13);
    }
}
