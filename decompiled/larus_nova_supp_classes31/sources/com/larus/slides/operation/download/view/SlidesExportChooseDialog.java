package com.larus.slides.operation.download.view;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.WindowCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_ui.view.FileExportType;
import com.larus.common_ui.view.FileExportTypeItemView;
import com.larus.slides.biz.impl.databinding.LarusPageSlidesExportChooseDialogBinding;
import com.larus.slides.sdk.api.ISlidesSdkServiceV2;
import com.larus.utils.e1;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.tencent.open.log.TraceLevel;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kw9.h;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes31.dex */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 22\u00020\u0001:\u00012B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\"\u001a\u00020\u0019H\u0002J\u001a\u0010#\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u001d2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010%\u001a\u00020\u0019H\u0016J\u0010\u0010&\u001a\u00020\u00192\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u0019H\u0002J\b\u0010*\u001a\u00020\u0019H\u0002J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020\u0007H\u0002J\b\u0010-\u001a\u00020.H\u0002J\u0010\u0010/\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u00100J\b\u00101\u001a\u00020\u0019H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00063"}, d2 = {"Lcom/larus/slides/operation/download/view/SlidesExportChooseDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/slides/biz/impl/databinding/LarusPageSlidesExportChooseDialogBinding;", "exportType", "Lcom/larus/common_ui/view/FileExportType;", "token", "", "activeExportToken", "fileName", "hasCancel", "", "exportStartTime", "", "downloadParams", "Lcom/larus/share/bean/SlideDownloadParams;", "getTheme", "", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "preSyncSystemBarsWithHost", "", "window", "Landroid/view/Window;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "setupLandscape", "onViewCreated", "view", "onStart", "onConfigurationChanged", "newConfig", "Landroid/content/res/Configuration;", "applyWindowHorizontalPadding", "parseArgument", "onFileTypeChange", "type", "newExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "resolveExportToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDestroyView", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = TraceLevel.ABOVE_WARN)
public final class SlidesExportChooseDialog extends BottomSheetDialogFragment {
    public static final /* synthetic */ int k = 0;
    public LarusPageSlidesExportChooseDialogBinding d;
    public FileExportType e;
    public String f;
    public String g;
    public String h;
    public boolean i;
    public h j;

    public static final class a {
        public static void a(SlidesExportChooseDialog r3) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            r3.dismiss();     // Catch: Throwable -> L5 Exception -> L7
        L18:
            return;
        L7:
            e = move-exception;
            com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L5
            Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L5
            if (r4 == null) goto L17;
            com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L5
            return;
        L17:
            return;
        L5:
            th = move-exception;
            FLogger.a.e("SlidesExportChooseDialog", "dialog dismiss error: " + th);
        }

        public static void b(SlidesExportChooseDialog r3, FragmentManager r4) {
            Intrinsics.checkNotNullParameter(r3, "<this>");
            Intrinsics.checkNotNullParameter(r4, "manager");
            LandscapeRestrictionOperation r1 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW;     // Catch: Exception -> L9
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r3, "SlidesExportChooseDialog", r1);     // Catch: Exception -> L9
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r4, r3, r1) == true) goto L17;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L12
        L7:
            r3.show(r4, "SlidesExportChooseDialog");     // Catch: Exception -> L9
            return;
        L17:
            return;
        L9:
            e = move-exception;
            FLogger.a.e("SlidesExportChooseDialog", "dialog show error: " + e);
        }
    }

    static {
    }

    public final int getTheme() {
        return 2131951931;
    }

    public final void onDestroyView() {
        FLogger r0 = FLogger.a;
        r0.i("SlidesExportChooseDialog", "onDestroyView: token:" + this.f);
        this.i = true;
        boolean r1 = com.larus.slides.operation.download.c.a;
        String r2 = this.g;
        if (StringsKt.isBlank(r2) == false) goto L5;
        r2 = this.f;
    L5:
        Intrinsics.checkNotNullParameter(r2, "token");
        r0.i("SlidesDownloader", "cancelDownload: token:" + r2);
        ISlidesSdkServiceV2 r3 = (ISlidesSdkServiceV2) ServiceManager.get().getService(ISlidesSdkServiceV2.class);
        if (r3 == null) goto L8;
        r3.cancelDocExport();
    L8:
        com.larus.slides.operation.download.c.a = false;
        super/*androidx.fragment.app.DialogFragment*/.onDestroyView();
    }

    public SlidesExportChooseDialog() {
        this.e = FileExportType.pptx;
        this.f = "";
        this.g = "";
        this.h = "";
    }

    public final void T90() {
        int r2 = 0;
        if (requireContext().getResources().getConfiguration().orientation != 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L8;
        r2 = getResources().getDimensionPixelSize(v19.c.b(2130971166, null, 2131166701));
    L8:
        Dialog r1 = getDialog();
        if (r1 == null) goto L17;
        Window r3 = r1.getWindow();
        if (r3 == null) goto L18;
        View r4 = S90(r3);
        if (r4 == null) goto L19;
        r4.setPadding(r2, r4.getPaddingTop(), r2, r4.getPaddingBottom());
        return;
    L19:
        return;
    L18:
        return;
    L17:
        return;
    L5:
        r0 = false;
        goto L6
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
        T90();
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

    public final void U90(FileExportType r6) {
        this.e = r6;
        FileExportTypeItemView[] r0 = new FileExportTypeItemView[2];
        LarusPageSlidesExportChooseDialogBinding r1 = this.d;
        LarusPageSlidesExportChooseDialogBinding r2 = null;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L5:
        r0[0] = r1.e;
        LarusPageSlidesExportChooseDialogBinding r3 = this.d;
        if (r3 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L9:
        r0[1] = r2.f;
        Iterator r4 = CollectionsKt.listOf(r0).iterator();
    L11:
        if (r4.hasNext() == false) goto L17;
        FileExportTypeItemView r5 = (FileExportTypeItemView) r4.next();
        if (r5.getFileType() != r6) goto L15;
        boolean r7 = true;
    L16:
        r5.setSelected(r7);
        goto L11
    L15:
        r7 = false;
        goto L16
    L17:
        return;
    L8:
        r2 = r3;
        goto L9
    }

    public final void onConfigurationChanged(Configuration r2) {
        Intrinsics.checkNotNullParameter(r2, "newConfig");
        super/*androidx.fragment.app.Fragment*/.onConfigurationChanged(r2);
        T90();
    }

    public final Dialog onCreateDialog(Bundle r8) {
        Dialog r9 = super.onCreateDialog(r8);
        Window r0 = r9.getWindow();
        if (r0 == null) goto L14;
        r0.addFlags(8);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L14;
        Window r2 = r1.getWindow();
        View r3 = S90(r2);
        View r4 = S90(r0);
        WindowCompat.setDecorFitsSystemWindows(r0, false);
        r0.addFlags(Integer.MIN_VALUE);
        r0.clearFlags(134217728);
        int r5 = Build.VERSION.SDK_INT;
        if (r5 < 29) goto L11;
        r0.setNavigationBarContrastEnforced(false);
    L11:
        if (r5 < 28) goto L13;
        WindowManager.LayoutParams r6 = r0.getAttributes();
        r6.layoutInDisplayCutoutMode = 1;
        r0.setAttributes(r6);
    L13:
        r4.setSystemUiVisibility(((r3.getSystemUiVisibility() | 1024) | 512) | 256);
        r0.setStatusBarColor(r2.getStatusBarColor());
        r0.setNavigationBarColor(0);
    L14:
        return r9;
    }

    public final void onViewCreated(View r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r4, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r4, r5);
        Bundle r6 = getArguments();
        LarusPageSlidesExportChooseDialogBinding r7 = null;
        String r0 = "";
        if (r6 == null) goto L5;
        String r8 = r6.getString("slides_name", "");
    L6:
        if (r8 == null) goto L9;
        r0 = r8;
    L9:
        this.h = r0;
        BottomSheetDialog r9 = getDialog();
        if ((r9 instanceof BottomSheetDialog) == false) goto L12;
        BottomSheetDialog r10 = r9;
    L13:
        if (r10 == null) goto L15;
        final View r11 = r10.findViewById(2131368870);
    L16:
        if (r11 == null) goto L18;
        r11.setBackgroundResource(2131239066);
    L18:
        Dialog r1 = getDialog();
        if (r1 == null) goto L21;
        r1.setOnShowListener(new d(r11, this));
    L21:
        LarusPageSlidesExportChooseDialogBinding r12 = this.d;
        if (r12 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L24:
        r12.f.setItemType(FileExportType.pptx);
        LarusPageSlidesExportChooseDialogBinding r13 = this.d;
        if (r13 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L27:
        r13.e.setItemType(FileExportType.pdf);
        FileExportTypeItemView[] r14 = new FileExportTypeItemView[2];
        LarusPageSlidesExportChooseDialogBinding r2 = this.d;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L30:
        r14[0] = r2.f;
        LarusPageSlidesExportChooseDialogBinding r3 = this.d;
        if (r3 != null) goto L33;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L33:
        r14[1] = r3.e;
        Iterator r15 = CollectionsKt.listOf(r14).iterator();
    L35:
        if (r15.hasNext() == false) goto L37;
        e1.d((FileExportTypeItemView) r15.next(), new com.larus.slides.operation.download.view.a(this));
        goto L35
    L37:
        U90(FileExportType.pptx);
        LarusPageSlidesExportChooseDialogBinding r16 = this.d;
        if (r16 != null) goto L40;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L40:
        e1.d(r16.b, new b(this));
        LarusPageSlidesExportChooseDialogBinding r17 = this.d;
        if (r17 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L44:
        e1.d(r7.g, new c(this));
        Context r18 = getContext();
        if (r18 == null) goto L53;
        Dialog r19 = getDialog();
        if (r19 == null) goto L54;
        Window r20 = r19.getWindow();
        if (r20 == null) goto L55;
        r20.setNavigationBarColor(v19.c.b(2130970534, r18, 2131102545));
        return;
    L55:
        return;
    L54:
        return;
    L53:
        return;
    L43:
        r7 = r17;
        goto L44
    L15:
        r11 = null;
        goto L16
    L12:
        r10 = null;
        goto L13
    L5:
        r8 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        ConstraintLayout r12 = r9.inflate(2131563073, r10, false);
        int r13 = 2131365114;
        ImageView r2 = (ImageView) ViewBindings.findChildViewById(r12, 2131365114);
        if (r2 == null) goto L19;
        r13 = 2131370185;
        ProgressBar r3 = (ProgressBar) ViewBindings.findChildViewById(r12, 2131370185);
        if (r3 == null) goto L19;
        r13 = 2131370186;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131370186);
        if (r4 == null) goto L19;
        r13 = 2131382085;
        FileExportTypeItemView r5 = ViewBindings.findChildViewById(r12, 2131382085);
        if (r5 == null) goto L19;
        r13 = 2131382831;
        FileExportTypeItemView r6 = ViewBindings.findChildViewById(r12, 2131382831);
        if (r6 == null) goto L19;
        r13 = 2131382890;
        LinearLayout r7 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131382890);
        if (r7 == null) goto L19;
        r13 = 2131388772;
        if (((TextView) ViewBindings.findChildViewById(r12, 2131388772)) == null) goto L19;
        ConstraintLayout r14 = r12;
        this.d = new LarusPageSlidesExportChooseDialogBinding(r14, r2, r3, r4, r5, r6, r7);
        return r14;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
