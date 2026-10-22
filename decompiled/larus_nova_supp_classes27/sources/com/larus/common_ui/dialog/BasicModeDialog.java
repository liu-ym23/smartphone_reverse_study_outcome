package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusDialogBasicModeShowBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\f\u001a\u00020\rH\u0016J$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\u001a\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0002J\u000e\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\tJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\tJ\u000e\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\tJ\u000e\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/larus/common_ui/dialog/BasicModeDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogBasicModeShowBinding;", "msgListener", "Lcom/larus/common_ui/dialog/SpannaleClickListener;", "exitListener", "Landroid/view/View$OnClickListener;", "agreeListener", "basicModeListener", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupView", "setExitAppClick", "exit", "setAgreeClick", "agree", "setBasicModeClick", "enterBasic", "setUrlClick", "urlClickListener", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BasicModeDialog extends DialogFragment {
    public LarusDialogBasicModeShowBinding d;
    public k1 e;
    public View.OnClickListener f;
    public View.OnClickListener g;
    public View.OnClickListener h;

    public static final class a implements DialogInterface.OnKeyListener {
        public a() {
        }

        @Override // android.content.DialogInterface.OnKeyListener
        public final boolean onKey(DialogInterface r1, int r2, KeyEvent r3) {
            if (r2 != 4) goto L6;
            return true;
        L6:
            return false;
        }
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L10;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L10;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r2.width = r4;
        if (r4 <= i5.L()) goto L9;
        r2.width = i5.L();
    L9:
        r1.setAttributes(r2);
    L10:
        Dialog r5 = getDialog();
        if (r5 == null) goto L14;
        r5.setOnKeyListener(new a());
        return;
    }

    public BasicModeDialog() {
    }

    public final void onViewCreated(View r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r3, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r3, r4);
        LarusDialogBasicModeShowBinding r5 = this.d;
        LarusDialogBasicModeShowBinding r6 = null;
        if (r5 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L5:
        r5.e.setOnClickListener(this.f);
        LarusDialogBasicModeShowBinding r7 = this.d;
        if (r7 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L8:
        r7.d.setOnClickListener(this.h);
        LarusDialogBasicModeShowBinding r8 = this.d;
        if (r8 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L11:
        r8.b.setOnClickListener(this.g);
        LarusDialogBasicModeShowBinding r9 = this.d;
        if (r9 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L14:
        r9.c.setUrlSpannedText(getString(2131908424));
        LarusDialogBasicModeShowBinding r10 = this.d;
        if (r10 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L18:
        r6.c.setOnClickListener(new s(this));
        Dialog r11 = getDialog();
        if (r11 == null) goto L22;
        r11.setCanceledOnTouchOutside(false);
        return;
    L22:
        return;
    L17:
        r6 = r10;
        goto L18
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        ConstraintLayout r11 = r8.inflate(2131562034, r9, false);
        int r12 = 2131362315;
        RelativeLayout r3 = (RelativeLayout) ViewBindings.findChildViewById(r11, 2131362315);
        if (r3 == null) goto L23;
        r12 = 2131368971;
        UrlSpanTextView r4 = (UrlSpanTextView) ViewBindings.findChildViewById(r11, 2131368971);
        if (r4 == null) goto L23;
        r12 = 2131368982;
        if (((TextView) ViewBindings.findChildViewById(r11, 2131368982)) == null) goto L23;
        r12 = 2131371685;
        AppCompatTextView r5 = ViewBindings.findChildViewById(r11, 2131371685);
        if (r5 == null) goto L23;
        r12 = 2131371853;
        AppCompatTextView r6 = ViewBindings.findChildViewById(r11, 2131371853);
        if (r6 == null) goto L23;
        this.d = new LarusDialogBasicModeShowBinding(r11, r3, r4, r5, r6);
        Dialog r13 = getDialog();
        if (r13 == null) goto L17;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L17;
        r14.setBackgroundDrawable(new ColorDrawable(0));
    L17:
        LarusDialogBasicModeShowBinding r15 = this.d;
        if (r15 != null) goto L21;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L21:
        return r15.a;
    L23:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
