package com.ss.android.lark.forwardv3.dialogfragment;

import android.app.Dialog;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatDialogFragment;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowManagerLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.lark.forsetiutils.ForsetiConfig;
import com.ss.android.lark.guide.ui.common.popup.AnchorFit;
import com.ss.android.lark.log.Log;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes36.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J\b\u0010\u000f\u001a\u00020\u000eH\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0011"}, d2 = {"Lcom/ss/android/lark/forwardv3/dialogfragment/ForwardDialogFragment;", "Landroidx/appcompat/app/AppCompatDialogFragment;", "<init>", "()V", "lazydialog", "Landroid/app/Dialog;", "getLazydialog", "()Landroid/app/Dialog;", "setLazydialog", "(Landroid/app/Dialog;)V", "onCreateDialog", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "", "onStart", "Companion", "forward-new_release"}, k = 1, mv = {2, 1, 0}, xi = AnchorFit.END)
public final class ForwardDialogFragment extends AppCompatDialogFragment {
    public Dialog d;

    public static final class a {
    }

    static {
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        if (ForsetiConfig.b() == false) goto L23;
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        WindowManager.LayoutParams r2 = r1.getAttributes();
        if (r2 == null) goto L11;
        IBinder r3 = r2.token;
    L12:
        Dialog r4 = getDialog();
        if (r4 == null) goto L23;
        Window r5 = r4.getWindow();
        if (r5 == null) goto L23;
        if (r3 == null) goto L23;
    L21:
        e = move-exception;
        Log.e("ForwardDialogFragment", "addView failed (safe)", e);
        goto L23
    L18:
        if (S90(r5).isAttachedToWindow() == true) goto L23;
        Log.i("ForwardDialogFragment", "addView");     // Catch: IllegalArgumentException -> L21
        WindowManager r6 = r5.getWindowManager();     // Catch: IllegalArgumentException -> L21
        View r7 = S90(r5);     // Catch: IllegalArgumentException -> L21
        WindowManager.LayoutParams r8 = r5.getAttributes();     // Catch: IllegalArgumentException -> L21
        WindowManagerLancet.bindToAssistantWindowIfNeeded(r7, r8);     // Catch: IllegalArgumentException -> L21
        r6.addView(r7, r8);     // Catch: IllegalArgumentException -> L21
    L11:
        r3 = null;
    L23:
        Log.i("ForwardDialogFragment", "onStart");
        super/*androidx.fragment.app.DialogFragment*/.onStart();
    }

    public final void onStop() {
        if (ForsetiConfig.b() == false) goto L14;
        Dialog r0 = getDialog();
        if (r0 == null) goto L14;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
    L12:
        e = move-exception;
        Log.e("ForwardDialogFragment", "removeView failed (safe)", e);
        goto L14
    L9:
        if (S90(r1).isAttachedToWindow() == false) goto L14;
        Log.i("ForwardDialogFragment", "removeView");     // Catch: IllegalArgumentException -> L12
        r1.getWindowManager().removeView(S90(r1));     // Catch: IllegalArgumentException -> L12
    L14:
        Log.i("ForwardDialogFragment", "onStop");
        super/*androidx.fragment.app.DialogFragment*/.onStop();
    }

    public ForwardDialogFragment() {
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == c.a) goto L7;
        c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final Dialog onCreateDialog(Bundle r2) {
        Dialog r3 = this.d;
        if (r3 == null) goto L5;
        return r3;
    L5:
        return new Dialog(requireContext());
    }
}
