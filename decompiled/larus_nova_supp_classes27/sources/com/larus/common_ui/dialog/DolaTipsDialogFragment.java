package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.keva.Keva;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.larus.common_res.common_ui.databinding.PageDolaTipsBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u001a\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u0015\u001a\u00020\u000fH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/larus/common_ui/dialog/DolaTipsDialogFragment;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/PageDolaTipsBinding;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "safeDismiss", "", "initViews", "getTheme", "", "onViewCreated", "view", "setupLandscape", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DolaTipsDialogFragment extends BottomSheetDialogFragment {
    public static final Companion e = null;
    public static final Lazy<Keva> f = null;
    public PageDolaTipsBinding d;

    public static final class Companion {
        public Companion() {
        }

        public final Object a(FragmentActivity r7, Continuation<? super Unit> r8) {
            if ((r8 instanceof DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1) == false) goto L7;
            DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1 r1 = (DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1) r8;
            int r2 = r1.label;
            if ((r2 & Integer.MIN_VALUE) == 0) goto L7;
            r1.label = r2 - Integer.MIN_VALUE;
        L8:
            Object r9 = r1.result;
            Object r3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r4 = r1.label;
            if (r4 == 0) goto L15;
            if (r4 != 1) goto L14;
            ResultKt.throwOnFailure(r9);     // Catch: Exception -> L23
        L26:
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L15:
            ResultKt.throwOnFailure(r9);
            Lazy<Keva> r10 = DolaTipsDialogFragment.f;     // Catch: Exception -> L23
            if (((Keva) r10.getValue()).getBoolean("default", false) == true) goto L19;
            ((Keva) r10.getValue()).storeBoolean("default", true);     // Catch: Exception -> L23
            DolaTipsDialogFragment r11 = new DolaTipsDialogFragment();     // Catch: Exception -> L23
            MainCoroutineDispatcher r0 = Dispatchers.getMain();     // Catch: Exception -> L23
            DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$2 r5 = new DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$2(r11, r7, null);     // Catch: Exception -> L23
            r1.label = 1;     // Catch: Exception -> L23
            if (BuildersKt.withContext(r0, r5, r1) != r3) goto L26;
            return r3;
        L19:
            return Unit.INSTANCE;
        L23:
            e = move-exception;
            FLogger.a.e("DolaTipsDialogFragment", "find MinorTipsDialogFragment exception: " + e);
        L7:
            r1 = new DolaTipsDialogFragment$Companion$showDolaTipsDialogFragment$1(this, r8);
            goto L8
        }
    }

    public final int getTheme() {
        return 2131951931;
    }

    static {
        e = new Companion();
        f = LazyKt.lazy(new w0());
    }

    public final void S90() {
        FragmentActivity r0 = getActivity();     // Catch: Exception -> L22
        boolean r1 = false;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L29;
        Dialog r3 = getDialog();     // Catch: Exception -> L22
        if (r3 != null) goto L12;
    L14:
        if (r1 == false) goto L30;
        dismiss();     // Catch: Exception -> L17
    L32:
        return;
    L17:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Exception -> L22
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Exception -> L22
        if (r4 == null) goto L31;
        com.bytedance.crash.d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Exception -> L22
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (r3.isShowing() != true) goto L14;
        r1 = true;
        goto L14
    L29:
        return;
    L5:
        if (r0.isFinishing() == true) goto L7;
        r2 = true;
    L22:
        e = move-exception;
        FLogger.a.e("safeDismiss", "commonLoadDialog dismiss crash because: " + e.getMessage(), e);
    }

    public DolaTipsDialogFragment() {
    }

    public final void onViewCreated(View r2, Bundle r3) {
        Intrinsics.checkNotNullParameter(r2, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r2, r3);
        BottomSheetDialog r4 = getDialog();
        final View r0 = null;
        if ((r4 instanceof BottomSheetDialog) == false) goto L5;
        BottomSheetDialog r5 = r4;
    L6:
        if (r5 == null) goto L8;
        r0 = r5.findViewById(2131368870);
    L8:
        Dialog r6 = getDialog();
        if (r6 == null) goto L12;
        r6.setOnShowListener(new x0(r0));
        return;
    L12:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final View onCreateView(LayoutInflater r3, ViewGroup r4, Bundle r5) {
        Intrinsics.checkNotNullParameter(r3, "inflater");
        ConstraintLayout r6 = r3.inflate(2131564160, r4, false);
        int r7 = 2131366984;
        AppCompatImageView r8 = ViewBindings.findChildViewById(r6, 2131366984);
        if (r8 == null) goto L19;
        r7 = 2131369393;
        if (((ImageView) ViewBindings.findChildViewById(r6, 2131369393)) == null) goto L19;
        r7 = 2131369394;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131369394)) == null) goto L19;
        r7 = 2131369395;
        if (((TextView) ViewBindings.findChildViewById(r6, 2131369395)) == null) goto L19;
        ConstraintLayout r9 = r6;
        TextView r1 = (TextView) ViewBindings.findChildViewById(r6, 2131387243);
        if (r1 == null) goto L17;
        this.d = new PageDolaTipsBinding(r9, r8, r9, r1);
        com.larus.utils.e1.d(r8, new u0(this));
        com.larus.utils.e1.d(r1, new v0(this));
        PageDolaTipsBinding r10 = this.d;
        if (r10 != null) goto L20;
        return null;
    L20:
        return r10.b;
    L17:
        r7 = 2131387243;
    L19:
        throw new NullPointerException("Missing required view with ID: ".concat(r6.getResources().getResourceName(r7)));
    }
}
