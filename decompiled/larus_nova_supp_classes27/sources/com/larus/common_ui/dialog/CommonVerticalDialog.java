package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusDialogVerticalBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001%B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J$\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\u001a\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001a2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0016J\b\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/larus/common_ui/dialog/CommonVerticalDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogVerticalBinding;", "mTitle", "", "mMessage", "", "mConfirmText", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mCancelTextColor", "", "Ljava/lang/Integer;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mCanceledOnTouchOutside", "", "backListener", "Lkotlin/Function0;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "", "view", "setupView", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonVerticalDialog extends DialogFragment {
    public LarusDialogVerticalBinding d;
    public String e;
    public CharSequence f;
    public String g;
    public p0 h;
    public String i;
    public u j;
    public Integer k;

    public CommonVerticalDialog() {
        this.e = "";
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        LarusDialogVerticalBinding r5 = this.d;
        LarusDialogVerticalBinding r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L5:
        r5.e.setText(this.e);
        LarusDialogVerticalBinding r7 = this.d;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        r7.d.setText(this.f);
        LarusDialogVerticalBinding r8 = this.d;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L11:
        TextView r9 = r8.c;
        r9.setText(this.g);
        String r1 = this.g;
        if (r1 != null) goto L14;
    L17:
        boolean r2 = true;
    L18:
        if (r2 == false) goto L20;
        Intrinsics.checkNotNull(r9);
        com.larus.utils.e1.o(r9);
    L20:
        r9.setOnClickListener(new n0(this));
        LarusDialogVerticalBinding r10 = this.d;
        if (r10 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L23:
        TextView r11 = r10.b;
        r11.setText(this.i);
        r11.setOnClickListener(new o0(this));
        Integer r12 = this.k;
        if (r12 == null) goto L31;
        int r13 = r12.intValue();
        LarusDialogVerticalBinding r14 = this.d;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L29:
        r6.b.setTextColor(r13);
        return;
    L28:
        r6 = r14;
        goto L29
    L31:
        return;
    L14:
        if (r1.length() == 0) goto L17;
        r2 = false;
        goto L18
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562108, r9, false);
        int r12 = 2131365114;
        TextView r2 = (TextView) ViewBindings.findChildViewById(r11, 2131365114);
        if (r2 == null) goto L27;
        r12 = 2131367639;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131367639);
        if (r3 == null) goto L27;
        r12 = 2131368971;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131368971);
        if (r4 == null) goto L27;
        r12 = 2131368982;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131368982);
        if (r5 == null) goto L27;
        r12 = 2131368985;
        if (ViewBindings.findChildViewById(r11, 2131368985) == null) goto L27;
        r12 = 2131369197;
        View r6 = ViewBindings.findChildViewById(r11, 2131369197);
        if (r6 == null) goto L27;
        this.d = new LarusDialogVerticalBinding((LinearLayout) r11, r2, r3, r4, r5, r6);
        Context r13 = getContext();
        if (r13 == null) goto L21;
        Dialog r14 = getDialog();
        if (r14 == null) goto L21;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L21;
        r15.setBackgroundDrawable(ContextCompat.getDrawable(r13, 2131239539));
    L21:
        LarusDialogVerticalBinding r16 = this.d;
        if (r16 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L25:
        return r16.a;
    L27:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
