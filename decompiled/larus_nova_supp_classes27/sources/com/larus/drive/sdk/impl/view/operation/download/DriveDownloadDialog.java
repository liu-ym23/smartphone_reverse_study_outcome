package com.larus.drive.sdk.impl.view.operation.download;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.larus.common_ui.widget.CircleProgressBar;
import com.larus.drive.sdk.impl.databinding.LarusDialogDriveDownloadBinding;
import com.larus.drive.sdk.impl.utils.file.DriveDownloadManager;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J&\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0016J\u000e\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0014J\u0006\u0010\u0015\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/drive/sdk/impl/view/operation/download/DriveDownloadDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogDriveDownloadBinding;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onStart", "onDestroyView", "updateProgress", "progress", "", "dismissSafely", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveDownloadDialog extends DialogFragment {
    public static final /* synthetic */ int e = 0;
    public LarusDialogDriveDownloadBinding d;

    public static final class a {
    }

    static {
    }

    public final void S90() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L13
        if (isAdded() == true) goto L19;
        return;
    L19:
        dismissAllowingStateLoss();     // Catch: Exception -> L7 Throwable -> L13
    L11:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L13
    L15:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L23;
        FLogger.a.e("DriveDownloadDialog", "[dismissSafely] Dismiss dialog error: " + r2.getMessage());
        return;
    L23:
        return;
    L7:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L13
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L13
        if (r3 == null) goto L11;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L15
    }

    public final void onDestroyView() {
        super.onDestroyView();
        CoroutineScope r0 = DriveDownloadManager.a;
        Intrinsics.checkNotNullParameter(this, "dialog");
        WeakReference<DriveDownloadDialog> r1 = DriveDownloadManager.f;
        if (r1 == null) goto L5;
        DriveDownloadDialog r2 = r1.get();
    L6:
        if (r2 != this) goto L8;
        DriveDownloadManager.f = null;
    L8:
        this.d = null;
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setLayout(-2, -2);
        r1.setGravity(17);
        r1.clearFlags(2);
        r1.setDimAmount(0.0f);
    L7:
        Dialog r2 = getDialog();
        if (r2 == null) goto L10;
        r2.setCanceledOnTouchOutside(false);
    L10:
        CoroutineScope r3 = DriveDownloadManager.a;
        Intrinsics.checkNotNullParameter(this, "dialog");
        DriveDownloadManager.f = new WeakReference(this);
        if (DriveDownloadManager.d == false) goto L14;
        T90(DriveDownloadManager.c);
        return;
    }

    public DriveDownloadDialog() {
    }

    public final void T90(int r2) {
        LarusDialogDriveDownloadBinding r0 = this.d;
        if (r0 == null) goto L8;
        CircleProgressBar r1 = r0.c;
        if (r1 == null) goto L9;
        r1.setProgress(r2);
        return;
    L9:
        return;
    }

    public final void onCreate(Bundle r1) {
        super.onCreate(r1);
        setCancelable(true);
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        CardView r7 = r4.inflate(2131562061, r5, false);
        int r8 = 2131370156;
        ImageView r9 = (ImageView) ViewBindings.findChildViewById(r7, 2131370156);
        if (r9 == null) goto L26;
        CardView r10 = r7;
        if (((TextView) ViewBindings.findChildViewById(r7, 2131370191)) == null) goto L24;
        CircleProgressBar r2 = (CircleProgressBar) ViewBindings.findChildViewById(r7, 2131383287);
        if (r2 == null) goto L23;
        this.d = new LarusDialogDriveDownloadBinding(r10, r9, r2);
        Dialog r11 = getDialog();
        if (r11 == null) goto L13;
        Window r12 = r11.getWindow();
        if (r12 == null) goto L13;
        r12.setBackgroundDrawable(new ColorDrawable(0));
    L13:
        LarusDialogDriveDownloadBinding r13 = this.d;
        if (r13 == null) goto L18;
        ImageView r14 = r13.b;
        if (r14 == null) goto L18;
        r14.setOnClickListener(new com.larus.drive.sdk.impl.view.operation.download.a(this));
    L18:
        LarusDialogDriveDownloadBinding r15 = this.d;
        if (r15 != null) goto L27;
        return null;
    L27:
        return r15.a;
    L23:
        r8 = 2131383287;
        goto L26
    L24:
        r8 = 2131370191;
    L26:
        throw new NullPointerException("Missing required view with ID: ".concat(r7.getResources().getResourceName(r8)));
    }
}
