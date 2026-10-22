package com.obric.assistant.interaction.impl.window.helpers;

import android.content.DialogInterface;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
public class DialogFragmentLancet {
    public static volatile Throwable sLastShowStack;

    public DialogFragmentLancet() {
    }

    public void dismiss() {
        Origin.callVoid();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r0 = sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void dismissAllowingStateLoss() {
        Origin.callVoid();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r0 = sLastShowStack;
        if (r0 == null) goto L11;
        com.bytedance.crash.d.d(r0, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public void onStart() {
        Object r0 = This.get();
        if ((r0 instanceof DialogFragment) == false) goto L5;
        DialogFragment r1 = (DialogFragment) r0;
        PopupOrDialogVisibilityTracker.bindDialogFragment(r1);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(r1);
    L5:
        Origin.callVoid();
    }

    public void onDismiss(DialogInterface r3) {
        Object r4 = This.get();
        Origin.callVoid();     // Catch: Throwable -> L8
        if ((r4 instanceof DialogFragment) == false) goto L15;
        DialogFragment r5 = (DialogFragment) r4;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r5.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r5);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r5);
        return;
    L15:
        return;
    L8:
        th = move-exception;
        if ((r4 instanceof DialogFragment) == false) goto L12;
        DialogFragment r6 = (DialogFragment) r4;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(r6.getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(r6);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(r6);
    L12:
        throw th;
    }

    public int show(FragmentTransaction r3, String r4) {
        Object r0 = This.get();
        if ((r0 instanceof Fragment) == false) goto L5;
        Fragment r1 = (Fragment) r0;
    L6:
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_TRANSACTION;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r4, r2);
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r3, r1, r2) == false) goto L14;
        return -1;
    L14:
        sLastShowStack = new Throwable();     // Catch: Exception -> L13
    L12:
        return ((Integer) Origin.call()).intValue();
    L5:
        r1 = null;
        goto L6
    }

    public void showNow(FragmentManager r3, String r4) {
        Object r0 = This.get();
        if ((r0 instanceof Fragment) == false) goto L5;
        Fragment r1 = (Fragment) r0;
    L6:
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r4, r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r1, r2) == false) goto L13;
        return;
    L13:
        sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        Origin.callVoid();
        return;
    L5:
        r1 = null;
        goto L6
    }

    public void show(FragmentManager r3, String r4) {
        Object r0 = This.get();
        if ((r0 instanceof Fragment) == false) goto L5;
        Fragment r1 = (Fragment) r0;
    L6:
        LandscapeRestrictionOperation r2 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;
        LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r1, r4, r2);
        if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r3, r1, r2) == false) goto L13;
        return;
    L13:
        sLastShowStack = new Throwable();     // Catch: Exception -> L12
    L10:
        Origin.callVoid();
        return;
    L5:
        r1 = null;
        goto L6
    }
}
