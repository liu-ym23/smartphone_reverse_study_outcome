package com.larksuite.framework.ui;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import com.obric.assistant.interaction.impl.window.helpers.OverlaySource;
import com.obric.assistant.interaction.impl.window.helpers.PopupWindowLancet;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public class BasePopupWindow extends PopupWindow {
    public Context a;

    @Override // android.widget.PopupWindow
    public void dismiss() {
        Context r0 = this.a;
        if (r0 != null) goto L5;
    L9:
        boolean r1 = true;
    L10:
        if (r1 == false) goto L13;
        PopupWindowLancet.handleDismissBeforeOrigin(this);
        super.dismiss();
        return;
    L13:
        return;
    L5:
        if ((r0 instanceof Activity) == false) goto L9;
        if (c.a((Activity) r0) == true) goto L9;
        r1 = false;
        goto L10
    }

    public BasePopupWindow() {
    }

    public BasePopupWindow(Context r1) {
        super(r1);
        this.a = r1;
    }

    public static boolean a(View r4) {
        if (r4 != null) goto L5;
    L24:
        return false;
    L5:
        if (r4.getWindowToken() == null) goto L24;
        Context r1 = r4.getContext();
        if (r1 != null) goto L11;
        return false;
    L11:
        if ((r1 instanceof Activity) == true) goto L19;
        View r5 = r4.findViewById(R.id.content);
        if (r5 != null) goto L15;
        return true;
    L15:
        r1 = r5.getContext();
        if (r1 != null) goto L19;
        return false;
    L19:
        if ((r1 instanceof Activity) == true) goto L21;
    L23:
        return true;
    L21:
        if (c.a((Activity) r1) == true) goto L23;
        return false;
    }

    @Override // android.widget.PopupWindow
    public final void setContentView(View r1) {
        super.setContentView(r1);
        if (r1 == null) goto L6;
        this.a = r1.getContext();
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r3) {
        if (a(r3) == false) goto L9;
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r3, r0) == true) goto L10;
        super.showAsDropDown(r3);
        PopupWindowLancet.trackAfterShow(this, r0, r3);
        return;
    L10:
        return;
    }

    public BasePopupWindow(Context r1, AttributeSet r2) {
        super(r1, r2);
        this.a = r1;
    }

    public BasePopupWindow(View r1, int r2, int r3) {
        super(r1, r2, r3);
        this.a = r1.getContext();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r3, int r4, int r5) {
        if (a(r3) == false) goto L9;
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r3, r0) == true) goto L10;
        super.showAsDropDown(r3, r4, r5);
        PopupWindowLancet.trackAfterShow(this, r0, r3);
        return;
    L10:
        return;
    }

    public BasePopupWindow(Context r1, AttributeSet r2, int r3) {
        super(r1, r2, r3);
        this.a = r1;
    }

    public BasePopupWindow(View r1, int r2, int r3, boolean r4) {
        super(r1, r2, r3, r4);
        this.a = r1.getContext();
    }

    @Override // android.widget.PopupWindow
    public final void showAsDropDown(View r3, int r4, int r5, int r6) {
        if (a(r3) == false) goto L9;
        OverlaySource r0 = PopupWindowLancet.resolveSource(r3);
        if (PopupWindowLancet.rewriteShowAsDropDownIfNeeded(this, r3, r0) == true) goto L10;
        super.showAsDropDown(r3, r4, r5, r6);
        PopupWindowLancet.trackAfterShow(this, r0, r3);
        return;
    L10:
        return;
    }

    @Override // android.widget.PopupWindow
    public final void showAtLocation(View r8, int r9, int r10, int r11) {
        if (a(r8) == true) goto L5;
        return;
    L5:
        if (PopupWindowLancet.hasSubWindowToken(r8) == false) goto L8;
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(this) == false) goto L10;
        super.showAtLocation(r8, r9, r10, r11);
        return;
    L10:
        OverlaySource r0 = PopupWindowLancet.resolveSource(r8);
        if (PopupWindowLancet.rewriteDirectShowAtLocationIfNeeded(this, r8, r0, r9, r10, r11) == true) goto L18;
        super.showAtLocation(r8, r9, r10, r11);
        PopupWindowLancet.trackAfterShow(this, r0, r8);
        return;
    }
}
