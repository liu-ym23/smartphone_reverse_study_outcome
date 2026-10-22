package com.obric.assistant.interaction.impl.window.helpers;

import android.os.IBinder;
import android.view.View;
import android.widget.PopupWindow;
import androidx.fragment.app.FragmentActivity;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildPopupWindowBoundsAdapter;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class PopupWindowLancet {
    public PopupWindowLancet() {
    }

    public void dismiss() {
        handleDismissBeforeOrigin(This.get());
        Origin.callVoid();
    }

    public void update() {
        Origin.callVoid();
    }

    public static void handleDismissBeforeOrigin(Object r1) {
        if ((r1 instanceof PopupWindow) == false) goto L6;
        PopupWindow r2 = (PopupWindow) r1;
        PopupOrDialogVisibilityTracker.onPopupDismiss(r2);
        LandscapeChildPopupWindowBoundsAdapter.clearDirectCenterManaged(r2);
        return;
    }

    public static boolean hasSubWindowToken(View r1) {
        if (r1 != null) goto L6;
        return false;
    L6:
        return hasSubWindowToken(r1.getWindowToken(), r1.getApplicationWindowToken());
    }

    public static OverlaySource resolveSource(View r3) {
        if (r3 != null) goto L5;
        return null;
    L5:
        boolean r1 = ChatWindowServiceDelegate.b.d(r3.getContext());
        if (r1 == false) goto L8;
    L10:
        boolean r4 = false;
    L11:
        if (r1 == true) goto L13;
        if (r4 == true) goto L16;
        return null;
    L16:
        return OverlaySource.ACTIVITY;
    L13:
        return OverlaySource.WINDOW;
    L8:
        if (WindowUtils.INSTANCE.isChatActivityPopup(r3) == false) goto L10;
        r4 = true;
        goto L11
    }

    public void showAsDropDown(View r4) {
        Object r0 = This.get();
        OverlaySource r1 = resolveSource(r4);
        if (rewriteShowAsDropDownIfNeeded(r0, r4, r1) == false) goto L5;
        return;
    L5:
        Origin.callVoid();
        trackAfterShow(r0, r1, r4);
    }

    public static boolean hasSubWindowToken(IBinder r0, IBinder r1) {
        if (r0 == null) goto L7;
        if (r1 == null) goto L7;
        if (r0.equals(r1) == true) goto L7;
        return true;
    L7:
        return false;
    }

    public void update(int r1, int r2) {
        Origin.callVoid();
    }

    public static boolean rewriteShowAsDropDownIfNeeded(Object r2, View r3, OverlaySource r4) {
        if ((r2 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r5 = (PopupWindow) r2;
        LandscapeChildPopupWindowBoundsAdapter.RewriteDecision r6 = LandscapeChildPopupWindowBoundsAdapter.resolveRewriteDecision(r5, r3, r4);
        if (r6 != null) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginShowAtLocationBypass(r5);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(r5, r6.getParent(), r6.getGravity(), r6.getX(), r6.getY());     // Catch: Throwable -> L15
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r5);
        if (r5.isShowing() == false) goto L20;
        LandscapeChildPopupWindowBoundsAdapter.markRewriteSucceeded(r5);
        PopupOrDialogVisibilityTracker.onPopupShow(r5, OverlaySource.WINDOW, null);
        return true;
    L20:
        return true;
    L15:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r5);
        throw th;
    }

    public static void trackAfterShow(Object r1, OverlaySource r2, View r3) {
        if ((r1 instanceof PopupWindow) == false) goto L12;
        if (r2 == null) goto L13;
        PopupWindow r4 = (PopupWindow) r1;
        if (r2 != OverlaySource.ACTIVITY) goto L9;
        FragmentActivity r5 = WindowUtils.INSTANCE.resolveChatActivityPopup(r3);
    L10:
        PopupOrDialogVisibilityTracker.onPopupShow(r4, r2, r5);
        return;
    L9:
        r5 = null;
        goto L10
    L13:
        return;
    }

    public void showAsDropDown(View r2, int r3, int r4) {
        Object r5 = This.get();
        OverlaySource r6 = resolveSource(r2);
        if (rewriteShowAsDropDownIfNeeded(r5, r2, r6) == false) goto L5;
        return;
    L5:
        Origin.callVoid();
        trackAfterShow(r5, r6, r2);
    }

    public void update(View r3, int r4, int r5) {
        Object r0 = This.get();
        if ((r0 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r0) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r0, r3, r4, r5) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r1, View r2, int r3, int r4) {
        if ((r1 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r5 = (PopupWindow) r1;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r5) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r5);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r5, 0, 0, r3, r4);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r5);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r5);
        throw th;
    }

    public void showAsDropDown(View r1, int r2, int r3, int r4) {
        Object r5 = This.get();
        OverlaySource r6 = resolveSource(r1);
        if (rewriteShowAsDropDownIfNeeded(r5, r1, r6) == false) goto L5;
        return;
    L5:
        Origin.callVoid();
        trackAfterShow(r5, r6, r1);
    }

    public void showAtLocation(View r9, int r10, int r11, int r12) {
        if (hasSubWindowToken(r9) == false) goto L5;
        return;
    L5:
        Object r0 = This.get();
        if ((r0 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r7 = resolveSource(r9);
        if (rewriteDirectShowAtLocationIfNeeded(r0, r9, r7, r10, r11, r12) == false) goto L14;
        return;
    L14:
        Origin.callVoid();
        trackAfterShow(r0, r7, r9);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget((PopupWindow) r0) == false) goto L11;
        Origin.callVoid();
    }

    public void update(int r3, int r4, int r5, int r6) {
        Object r0 = This.get();
        if ((r0 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r0) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r0, r3, r4, r5, r6) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(PopupWindow r7, View r8, int r9, int r10, int r11) {
        if (hasSubWindowToken(r8) == false) goto L6;
        return;
    L6:
        if ((r7 instanceof PopupWindow) == true) goto L8;
    L11:
        OverlaySource r0 = resolveSource(r8);
        if (rewriteDirectShowAtLocationIfNeeded(r7, r8, r0, r9, r10, r11) == false) goto L14;
        return;
    L14:
        r7.showAtLocation(r8, r9, r10, r11);
        trackAfterShow(r7, r0, r8);
        return;
    L8:
        if (LandscapeChildPopupWindowBoundsAdapter.isShowAtLocationBypassTarget(r7) == false) goto L11;
        r7.showAtLocation(r8, r9, r10, r11);
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r1, int r2, int r3, int r4, int r5) {
        if ((r1 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r1) == false) goto L9;
        r1.update(r2, r3, r4, r5);
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r1, r2, r3, r4, r5) == false) goto L11;
        return;
    L11:
        r1.update(r2, r3, r4, r5);
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r0, int r1, int r2, int r3, int r4) {
        if ((r0 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r5 = (PopupWindow) r0;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r5) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r5);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r5, 0, 0, r3, r4);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r5);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r5);
        throw th;
    }

    public void update(int r7, int r8, int r9, int r10, boolean r11) {
        Object r0 = This.get();
        if ((r0 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r0) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r0, r7, r8, r9, r10, r11) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public void update(View r7, int r8, int r9, int r10, int r11) {
        Object r0 = This.get();
        if ((r0 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget((PopupWindow) r0) == false) goto L9;
        Origin.callVoid();
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r0, r7, r8, r9, r10, r11) == false) goto L11;
        return;
    L11:
        Origin.callVoid();
    }

    public static void INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(PopupWindow r1, int r2, int r3, int r4, int r5, boolean r6) {
        if ((r1 instanceof PopupWindow) == false) goto L9;
        if (LandscapeChildPopupWindowBoundsAdapter.isDirectUpdateBypassTarget(r1) == false) goto L9;
        r1.update(r2, r3, r4, r5, r6);
        return;
    L9:
        if (rewriteDirectUpdateIfNeeded(r1, r2, r3, r4, r5, r6) == false) goto L11;
        return;
    L11:
        r1.update(r2, r3, r4, r5, r6);
    }

    public static boolean rewriteDirectShowAtLocationIfNeeded(Object r0, View r1, OverlaySource r2, int r3, int r4, int r5) {
        if ((r0 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r6 = (PopupWindow) r0;
        LandscapeChildPopupWindowBoundsAdapter.RewriteDecision r7 = LandscapeChildPopupWindowBoundsAdapter.resolveDirectShowAtLocationDecision(r6, r1, r2);
        if (r7 != null) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginShowAtLocationBypass(r6);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_showAtLocation(r6, r7.getParent(), 17, 0, 0);     // Catch: Throwable -> L15
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r6);
        if (r6.isShowing() == false) goto L20;
        LandscapeChildPopupWindowBoundsAdapter.markDirectCenterManaged(r6);
        PopupOrDialogVisibilityTracker.onPopupShow(r6, OverlaySource.WINDOW, null);
        return true;
    L20:
        return true;
    L15:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endShowAtLocationBypass(r6);
        throw th;
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r6, int r7, int r8, int r9, int r10, boolean r11) {
        if ((r6 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r12 = (PopupWindow) r6;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r12) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r12);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r12, 0, 0, r9, r10, r11);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r12);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r12);
        throw th;
    }

    public static boolean rewriteDirectUpdateIfNeeded(Object r0, View r1, int r2, int r3, int r4, int r5) {
        if ((r0 instanceof PopupWindow) == true) goto L5;
        return false;
    L5:
        PopupWindow r6 = (PopupWindow) r0;
        if (LandscapeChildPopupWindowBoundsAdapter.shouldRewriteDirectCenteredUpdate(r6) == true) goto L8;
        return false;
    L8:
        LandscapeChildPopupWindowBoundsAdapter.beginDirectUpdateBypass(r6);
        INVOKEVIRTUAL_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_com_obric_assistant_interaction_impl_window_helpers_PopupWindowLancet_update(r6, 0, 0, r4, r5);     // Catch: Throwable -> L12
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r6);
        return true;
    L12:
        th = move-exception;
        LandscapeChildPopupWindowBoundsAdapter.endDirectUpdateBypass(r6);
        throw th;
    }
}
