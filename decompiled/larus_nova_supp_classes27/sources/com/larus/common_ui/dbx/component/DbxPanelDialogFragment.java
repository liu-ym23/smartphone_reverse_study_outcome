package com.larus.common_ui.dbx.component;

import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 E2\u00020\u0001:\u0001EB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u0017\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u001a\u0010\u001f\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H&J\u001a\u0010&\u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016JX\u0010'\u001a\u00020\u00002\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020\u00162\b\b\u0002\u0010.\u001a\u00020\u00162\b\b\u0002\u0010/\u001a\u00020\u00162\b\b\u0002\u00100\u001a\u00020\u00162\b\b\u0002\u00101\u001a\u000202H\u0007J\u0012\u00103\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\u0016H\u0007J\u001c\u00105\u001a\u00020\u00072\b\b\u0002\u00104\u001a\u00020\u00162\b\b\u0002\u00106\u001a\u00020\u0006H\u0007J\u0012\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\u0010\u0010;\u001a\u00020\u00072\u0006\u0010<\u001a\u00020=H\u0016J\b\u0010>\u001a\u00020\u0007H\u0016J \u0010?\u001a\u00020\u00072\u0006\u0010$\u001a\u00020@2\u0006\u0010A\u001a\u00020!2\u0006\u0010B\u001a\u00020\u0016H\u0002J\u0012\u0010C\u001a\u00020,2\b\u0010D\u001a\u0004\u0018\u00010\u001bH\u0002R(\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\"\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006F"}, d2 = {"Lcom/larus/common_ui/dbx/component/DbxPanelDialogFragment;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "onPanelDismiss", "Lkotlin/Function1;", "Lcom/larus/common_ui/dbx/component/DbxPanelDismissReason;", "", "getOnPanelDismiss", "()Lkotlin/jvm/functions/Function1;", "setOnPanelDismiss", "(Lkotlin/jvm/functions/Function1;)V", "value", "Lcom/larus/common_ui/dbx/component/DbxPanelPresentationDialog;", "presentationDialog", "getPresentationDialog", "()Lcom/larus/common_ui/dbx/component/DbxPanelPresentationDialog;", "panelView", "Lcom/larus/common_ui/dbx/component/DbxPanelView;", "getPanelView", "()Lcom/larus/common_ui/dbx/component/DbxPanelView;", "hasRequestedShow", "", "show", "manager", "Landroidx/fragment/app/FragmentManager;", "tag", "", "", "transaction", "Landroidx/fragment/app/FragmentTransaction;", "showNow", "onCreatePanelContent", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onCreatePanelFooter", "withPanelConfig", "closeAccessibilityLabel", "", "title", "initialDetent", "Lcom/larus/common_ui/dbx/component/DbxPanelDetent;", "showsCloseButton", "isHeightResizable", "dismissesOnBackdropTap", "wrapsContentHeight", "contentInsets", "Landroid/graphics/Rect;", "invalidatePanelHeight", "animated", "dismissPanel", "reason", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "onDestroyView", "addSectionChild", "Landroid/widget/FrameLayout;", "child", "fillsHeight", "restoreDetent", "name", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class DbxPanelDialogFragment extends DialogFragment {
    public static final /* synthetic */ int e = 0;
    public DbxPanelPresentationDialog d;

    public static final class a {
    }

    static {
    }

    public abstract View S90();

    public final void onDestroyView() {
        DbxPanelPresentationDialog r0 = this.d;
        if (r0 == null) goto L5;
        r0.c = null;
    L5:
        if (r0 == null) goto L7;
        DbxPanelPresentationDialog.h();
        r0.A = true;
    L7:
        super.onDestroyView();
        if (r0 == null) goto L10;
        DbxPanelPresentationDialog.l(r0, null, 6);
    L10:
        this.d = null;
    }

    public DbxPanelDialogFragment() {
    }

    public final Dialog onCreateDialog(Bundle r13) {
        Bundle r14 = getArguments();
        DbxPanelDetent r0 = null;
        if (r14 == null) goto L5;
        CharSequence r1 = r14.getCharSequence("dbx_panel_close_label");
    L6:
        int r2 = 0;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L14:
        if ((!r4) == false) goto L48;
        FragmentActivity r5 = requireActivity();
        boolean r6 = r14.getBoolean("dbx_panel_wraps_content", false);
        v r7 = new v(r5, r1, r14.getCharSequence("dbx_panel_title"), r14.getBoolean("dbx_panel_height_resizable", false));
        r7.setShowsCloseButton(r14.getBoolean("dbx_panel_shows_close", true));
        r7.setWrapsContentHeight(r6);
        int[] r3 = r14.getIntArray("dbx_panel_content_insets");
        if (r3 != null) goto L18;
    L26:
        LayoutInflater r8 = LayoutInflater.from(r5);
        FrameLayout r9 = r7.getContentView();
        Intrinsics.checkNotNull(r8);
        r7.getContentView();
        View r10 = S90();
        boolean r11 = !r6;
        if (r10.getLayoutParams() == null) goto L30;
        r9.addView(r10);
    L34:
        FrameLayout r12 = r7.getFooterView();
        Intrinsics.checkNotNullParameter(r8, "inflater");
        Intrinsics.checkNotNullParameter(r12, "container");
        String r15 = r14.getString("dbx_panel_initial_detent");
        if (r15 != null) goto L37;
        r0 = DbxPanelDetent.MINIMUM;
    L45:
        DbxPanelPresentationDialog r16 = new DbxPanelPresentationDialog(r5, r7, r0, r14.getBoolean("dbx_panel_dismiss_on_backdrop", true));
        r16.c = new e(this);
        this.d = r16;
        return r16;
    L37:
        DbxPanelDetent[] r17 = DbxPanelDetent.values();
        int r18 = r17.length;
    L38:
        if (r2 >= r18) goto L43;
        DbxPanelDetent r20 = r17[r2];
        if (Intrinsics.areEqual(r20.name(), r15) == true) goto L41;
        r2 = r2 + 1;
        goto L38
    L41:
        r0 = r20;
    L43:
        if (r0 != null) goto L45;
        r0 = DbxPanelDetent.MINIMUM;
        goto L45
    L30:
        if (r11 == false) goto L32;
        int r21 = -1;
    L33:
        r9.addView(r10, new FrameLayout.LayoutParams(-1, r21));
        goto L34
    L32:
        r21 = -2;
        goto L33
    L18:
        if (r3.length != 4) goto L20;
        boolean r22 = true;
    L21:
        if (r22 == true) goto L24;
        r3 = null;
    L24:
        if (r3 == null) goto L26;
        r7.setContentInsets(new Rect(r3[0], r3[1], r3[2], r3[3]));
        goto L26
    L20:
        r22 = false;
        goto L21
    L48:
        throw new IllegalArgumentException("DbxPanelDialogFragment 必须先调用 withPanelConfig 提供非空无障碍文案".toString());
    L9:
        if (StringsKt.isBlank(r1) == true) goto L12;
        r4 = false;
        goto L14
    L5:
        r1 = null;
        goto L6
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        this.d = null;     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final int show(FragmentTransaction r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "transaction");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r2, this, r0) == false) goto L9;
        return -1;
    L9:
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L7:
        return super.show(r2, r3);
    }

    public final void showNow(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.showNow(r2, r3);
        return;
    }

    public final void show(FragmentManager r2, String r3) {
        Intrinsics.checkNotNullParameter(r2, "manager");
        LandscapeRestrictionOperation r0 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(this, r3, r0);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r2, this, r0) == true) goto L11;
        DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L8
    L6:
        super.show(r2, r3);
        return;
    }
}
