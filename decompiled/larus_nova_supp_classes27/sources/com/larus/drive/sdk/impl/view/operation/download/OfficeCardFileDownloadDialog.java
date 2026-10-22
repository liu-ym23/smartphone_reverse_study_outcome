package com.larus.drive.sdk.impl.view.operation.download;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.drive.sdk.impl.databinding.LarusDialogOfficeCardFileDownloadBinding;
import com.larus.drive.sdk.impl.service.t;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0001.B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J$\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001a\u0010\u001b\u001a\u00020\u00102\u0006\u0010\u001c\u001a\u00020\u00162\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u001d\u001a\u00020\u0010H\u0016J\u0010\u0010\u001e\u001a\u00020\u00102\u0006\u0010\u001f\u001a\u00020 H\u0016J\b\u0010!\u001a\u00020\u0010H\u0016J\b\u0010\"\u001a\u00020\u0010H\u0002J\u0010\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0007H\u0002J\b\u0010%\u001a\u00020\u0010H\u0002J\b\u0010&\u001a\u00020\u0010H\u0002J\b\u0010'\u001a\u00020\u0010H\u0002J\b\u0010(\u001a\u00020\u0010H\u0002J\u0010\u0010)\u001a\u00020\u00102\u0006\u0010*\u001a\u00020+H\u0002J\b\u0010,\u001a\u00020\u0010H\u0002J\b\u0010-\u001a\u00020\u0010H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"Lcom/larus/drive/sdk/impl/view/operation/download/OfficeCardFileDownloadDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/sdk/impl/databinding/LarusDialogOfficeCardFileDownloadBinding;", "taskId", "", "fileToken", "hasCancelled", "", "hasCompleted", "downloadedFilePath", "getTheme", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onViewCreated", "view", "onStart", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "onDestroyView", "startDownload", "shareDownloadedFile", "fileName", "cancelDownloadAndDismiss", "cancelActiveTask", "showFailureAndDismiss", "setupLandscape", "preSyncSystemBarsWithHost", "window", "Landroid/view/Window;", "applyWindowHorizontalPadding", "dismissSafely", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class OfficeCardFileDownloadDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int j = 0;
    public LarusDialogOfficeCardFileDownloadBinding d;
    public String e;
    public String f;
    public boolean g;
    public boolean h;
    public String i;

    public static final class a {
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void T90() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L15
        Unit r2 = null;
        if (requireContext().getResources().getConfiguration().orientation != 2) goto L5;
        int r1 = getResources().getDimensionPixelSize(v19.c.b(2130971166, null, 2131166701));     // Catch: Throwable -> L15
    L6:
        Dialog r3 = getDialog();     // Catch: Throwable -> L15
        if (r3 == null) goto L13;
        Window r4 = r3.getWindow();     // Catch: Throwable -> L15
        if (r4 == null) goto L13;
        View r5 = S90(r4);     // Catch: Throwable -> L15
        if (r5 == null) goto L13;
        r5.setPadding(r1, r5.getPaddingTop(), r1, r5.getPaddingBottom());     // Catch: Throwable -> L15
        r2 = Unit.INSTANCE;     // Catch: Throwable -> L15
    L13:
        Object r6 = Result.constructor-impl(r2);     // Catch: Throwable -> L15
    L17:
        Throwable r7 = Result.exceptionOrNull-impl(r6);
        if (r7 == null) goto L23;
        FLogger.a.e("OfficeCardFileDownloadDialog", "[applyWindowHorizontalPadding] Failed", r7);
        return;
    L23:
        return;
    L5:
        r1 = 0;
    L15:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        r6 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L17
    }

    public final void U90() {
        String r0 = this.e;
        if (r0 != null) goto L5;
        return;
    L5:
        if ((!StringsKt.isBlank(r0)) == true) goto L8;
        r0 = null;
    L8:
        if (r0 == null) goto L13;
        t.a().g(CollectionsKt.listOf(r0));
        return;
    }

    public final void V90() {
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L11
        dismissAllowingStateLoss();     // Catch: Exception -> L5 Throwable -> L11
    L9:
        Object r1 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L11
    L13:
        Throwable r2 = Result.exceptionOrNull-impl(r1);
        if (r2 == null) goto L21;
        FLogger.a.e("OfficeCardFileDownloadDialog", "[dismissSafely] Failed", r2);
        return;
    L21:
        return;
    L5:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r3 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r3 == null) goto L9;
        d.d(r3, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        Result.Companion r4 = Result.Companion;
        r1 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L13
    }

    public final void onDestroyView() {
        if (this.h == true) goto L5;
        this.g = true;
        U90();
    L5:
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public OfficeCardFileDownloadDialog() {
        this.f = "";
    }

    public final void W90() {
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new OfficeCardFileDownloadDialog$showFailureAndDismiss$1(this, null), 3, null);
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super/*androidx.fragment.app.DialogFragment*/.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setLayout(-1, -1);
    L7:
        BottomSheetDialog r2 = getDialog();
        if ((r2 instanceof BottomSheetDialog) == false) goto L10;
        BottomSheetDialog r3 = r2;
    L11:
        if (r3 == null) goto L15;
        View r4 = r3.findViewById(2131368870);
        if (r4 == null) goto L15;
        r4.setBackground(new ColorDrawable(0));
    L15:
        T90();
        return;
    L10:
        r3 = null;
        goto L11
    }

    public static View S90(Window r3) {
        View r4 = r3.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L7;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r0 = ThreadMethodProxy.currentThread();
        if (r0 == com.larus.home.impl.utils.c.a) goto L7;
        com.larus.home.impl.utils.c.a(r0, "getDecorView");
    L7:
        return r4;
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        T90();
    }

    public final void onCreate(Bundle r2) {
        super/*androidx.fragment.app.DialogFragment*/.onCreate(r2);
        Bundle r3 = getArguments();
        if (r3 == null) goto L5;
        String r4 = r3.getString("file_token");
    L6:
        if (r4 != null) goto L8;
        r4 = "";
    L8:
        this.f = r4;
        return;
    L5:
        r4 = null;
        goto L6
    }

    public final Dialog onCreateDialog(Bundle r6) {
        Dialog r7 = super.onCreateDialog(r6);
        setCancelable(false);
        r7.setCanceledOnTouchOutside(false);
        Window r1 = r7.getWindow();
        if (r1 == null) goto L16;
        r1.setBackgroundDrawable(new ColorDrawable(0));
        r1.addFlags(8);
        r1.setDimAmount(0.0f);
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L16;
        Window r3 = r2.getWindow();
        if (r3 == null) goto L16;
        WindowCompat.setDecorFitsSystemWindows(r1, false);
        r1.addFlags(Integer.MIN_VALUE);
        r1.clearFlags(134217728);
        int r4 = Build.VERSION.SDK_INT;
        if (r4 < 29) goto L13;
        r1.setNavigationBarContrastEnforced(false);
    L13:
        if (r4 < 28) goto L15;
        WindowManager.LayoutParams r5 = r1.getAttributes();
        r5.layoutInDisplayCutoutMode = 1;
        r1.setAttributes(r5);
    L15:
        S90(r1).setSystemUiVisibility(((S90(r3).getSystemUiVisibility() | 1024) | 512) | 256);
        r1.setStatusBarColor(r3.getStatusBarColor());
        r1.setNavigationBarColor(0);
    L16:
        return r7;
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        BottomSheetDialog r10 = getDialog();
        if ((r10 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r11 = r10;
    L6:
        if (r11 == null) goto L8;
        final View r12 = r11.findViewById(2131368870);
    L9:
        if (r12 == null) goto L11;
        r12.setBackgroundColor(0);
    L11:
        Dialog r13 = getDialog();
        if (r13 == null) goto L14;
        r13.setOnShowListener(new c(r12, this));
    L14:
        LarusDialogOfficeCardFileDownloadBinding r14 = this.d;
        if (r14 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L17:
        e1.d(r14.b, new b(this));
        if (StringsKt.isBlank(this.f) == false) goto L20;
        W90();
    L24:
        Context r15 = getContext();
        if (r15 == null) goto L32;
        Dialog r16 = getDialog();
        if (r16 == null) goto L33;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L34;
        r17.setNavigationBarColor(ContextCompat.getColor(r15, v19.c.b(2130970534, r15, 2131102545)));
        return;
    L34:
        return;
    L33:
        return;
    L32:
        return;
    L20:
        Context r18 = getContext();
        if (r18 == null) goto L24;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new OfficeCardFileDownloadDialog$startDownload$1(this, r18, null), 3, null);
        goto L24
    L8:
        r12 = null;
        goto L9
    L5:
        r11 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        View r5 = r2.inflate(2131562089, r3, false);
        int r6 = 2131365114;
        ImageView r7 = (ImageView) ViewBindings.findChildViewById(r5, 2131365114);
        if (r7 == null) goto L13;
        r6 = 2131370166;
        if (ViewBindings.findChildViewById(r5, 2131370166) == null) goto L13;
        r6 = 2131370190;
        if (((ProgressBar) ViewBindings.findChildViewById(r5, 2131370190)) == null) goto L13;
        r6 = 2131370191;
        if (((TextView) ViewBindings.findChildViewById(r5, 2131370191)) == null) goto L13;
        FrameLayout r8 = (FrameLayout) r5;
        this.d = new LarusDialogOfficeCardFileDownloadBinding(r8, r7);
        return r8;
    L13:
        throw new NullPointerException("Missing required view with ID: ".concat(r5.getResources().getResourceName(r6)));
    }
}
