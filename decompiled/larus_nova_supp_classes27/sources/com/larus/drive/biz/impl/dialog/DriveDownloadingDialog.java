package com.larus.drive.biz.impl.dialog;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.larus.drive.biz.impl.databinding.LarusDialogDriveDownloadingBinding;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \u00172\u00020\u0001:\u0002\u0017\u0018B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J&\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0016J\u0006\u0010\u0014\u001a\u00020\bJ\u0014\u0010\u0015\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/larus/drive/biz/impl/dialog/DriveDownloadingDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusDialogDriveDownloadingBinding;", "onCancelListener", "Lkotlin/Function0;", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupView", "onStart", "dismissSafely", "setOnCancelListener", "listener", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveDownloadingDialog extends DialogFragment {
    public static final /* synthetic */ int f = 0;
    public LarusDialogDriveDownloadingBinding d;
    public Function0<Unit> e;

    public static final class a {
        public Function0<Unit> a;

        public a() {
        }
    }

    public static final class b {
    }

    static {
    }

    public final void S90() {
        FragmentActivity r0 = getActivity();     // Catch: Throwable -> L23
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L29;
        Dialog r3 = getDialog();     // Catch: Throwable -> L23
        if (r3 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L30;
        dismiss();     // Catch: Exception -> L18 Throwable -> L23
    L32:
        return;
    L18:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r4 == null) goto L31;
        d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (r3.isShowing() != true) goto L14;
    L29:
        return;
    L5:
        if (r0.isFinishing() == true) goto L7;
        r2 = true;
    L23:
        th = move-exception;
        FLogger.a.e("DriveDownloadingDialog", "dismissSafely error", th);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        View r2 = r1.getDecorView();
        if (c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == c.a) goto L11;
        c.a(r3, "getDecorView");
    L11:
        WindowInsetsControllerCompat r4 = WindowCompat.getInsetsController(r1, r2);
        boolean r5 = h.a;
        boolean r6 = !h.a(null);
        r4.setAppearanceLightStatusBars(r6);
        r4.setAppearanceLightNavigationBars(r6);
        r1.setLayout(-1, -1);
        r1.clearFlags(2);
        r1.addFlags(Integer.MIN_VALUE);
        r1.addFlags(512);
        return;
    L14:
        return;
    }

    public DriveDownloadingDialog() {
    }

    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        setStyle(2, 2131952391);
        setCancelable(false);
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        View r6 = r3.inflate(2131562062, r4, false);
        int r7 = 2131377274;
        if (((ProgressBar) ViewBindings.findChildViewById(r6, 2131377274)) == null) goto L24;
        r7 = 2131377275;
        ImageView r8 = (ImageView) ViewBindings.findChildViewById(r6, 2131377275);
        if (r8 == null) goto L24;
        r7 = 2131377276;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131377276)) == null) goto L24;
        this.d = new LarusDialogDriveDownloadingBinding((FrameLayout) r6, r8);
        Dialog r9 = getDialog();
        if (r9 == null) goto L13;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L13;
        r10.setBackgroundDrawable(new ColorDrawable(0));
    L13:
        LarusDialogDriveDownloadingBinding r11 = this.d;
        if (r11 == null) goto L18;
        ImageView r12 = r11.b;
        if (r12 == null) goto L18;
        r12.setOnClickListener(new m79.a(this));
    L18:
        LarusDialogDriveDownloadingBinding r13 = this.d;
        if (r13 != null) goto L25;
        return null;
    L25:
        return r13.a;
    L24:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
