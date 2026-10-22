package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.common_res.common_ui.databinding.LarusDialogInputBinding;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001)B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u001a\u0010#\u001a\u00020\u001a2\u0006\u0010$\u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\u0010\u0010%\u001a\u00020\u001a2\u0006\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020\u001aH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/larus/common_ui/dialog/InputDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogInputBinding;", "mCheckInputNull", "", "Ljava/lang/Boolean;", "mTitle", "", "mText", "", "mMaxInputLength", "", "mInputFilters", "", "Landroid/text/InputFilter;", "mConfirmOnEditorAction", "mConfirmText", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/InputConfirmClickListener;", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "setupView", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class InputDialog extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public LarusDialogInputBinding d;
    public Boolean e;
    public CharSequence f;
    public String g;
    public int h;
    public List<? extends InputFilter> i;
    public boolean j;
    public String k;
    public y0 l;
    public String m;
    public u n;

    public InputDialog() {
        this.e = Boolean.FALSE;
        this.g = "";
        this.i = CollectionsKt.emptyList();
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L12;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r2.width = r4;
        if (r4 <= i5.L()) goto L9;
        r2.width = i5.L();
    L9:
        r1.setAttributes(r2);
        return;
    L12:
        return;
    }

    public static void S90(InputDialog r1) {
        r1.dismissAllowingStateLoss();     // Catch: Exception -> L4
        return;
    L4:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_ALLOWING_STATE_LOSS_EXCEPTION");
        Throwable r2 = DialogFragmentLancet.sLastShowStack;
        if (r2 == null) goto L11;
        com.bytedance.crash.d.d(r2, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
        return;
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        S90(this);
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        LarusDialogInputBinding r8 = null;
        if (Intrinsics.areEqual(this.e, Boolean.TRUE) == false) goto L8;
        LarusDialogInputBinding r9 = this.d;
        if (r9 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L7:
        r9.d.addTextChangedListener(new c1(this));
    L8:
        List r10 = CollectionsKt.toMutableList(this.i);
        boolean r2 = false;
        if (this.h <= 0) goto L11;
        ListProtector.add(r10, 0, new InputFilter.LengthFilter(this.h));
    L11:
        List r11 = r10;
        if ((!r11.isEmpty()) == false) goto L17;
        LarusDialogInputBinding r1 = this.d;
        if (r1 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L16:
        r1.d.setFilters((InputFilter[]) r11.toArray(new InputFilter[0]));
    L17:
        LarusDialogInputBinding r12 = this.d;
        if (r12 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L20:
        r12.e.setText(this.f);
        LarusDialogInputBinding r13 = this.d;
        if (r13 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L23:
        r13.d.setText(this.g);
        LarusDialogInputBinding r14 = this.d;
        if (r14 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L26:
        r14.d.requestFocus();
        Dialog r15 = getDialog();
        if (r15 == null) goto L31;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L31;
        r16.setSoftInputMode(5);
    L31:
        String r17 = this.k;
        if (r17 != null) goto L34;
    L37:
        boolean r18 = true;
    L38:
        if (r18 == true) goto L43;
        LarusDialogInputBinding r20 = this.d;
        if (r20 != null) goto L42;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L42:
        r20.c.setText(this.k);
    L43:
        LarusDialogInputBinding r21 = this.d;
        if (r21 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L46:
        r21.c.setOnClickListener(new z0(this));
        if (this.j == false) goto L55;
        LarusDialogInputBinding r22 = this.d;
        if (r22 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L51:
        r22.d.setImeOptions(6);
        LarusDialogInputBinding r23 = this.d;
        if (r23 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L54:
        r23.d.setOnEditorActionListener(new a1(this));
    L55:
        String r24 = this.m;
        if (r24 != null) goto L58;
    L59:
        r2 = true;
    L60:
        if (r2 == true) goto L65;
        LarusDialogInputBinding r25 = this.d;
        if (r25 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L64:
        r25.b.setText(this.m);
    L65:
        LarusDialogInputBinding r26 = this.d;
        if (r26 != null) goto L68;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L69:
        r8.b.setOnClickListener(new b1(this));
        Dialog r27 = getDialog();
        if (r27 == null) goto L73;
        r27.setCanceledOnTouchOutside(true);
        return;
    L73:
        return;
    L68:
        r8 = r26;
        goto L69
    L58:
        if (r24.length() != 0) goto L60;
    L34:
        if (r17.length() == 0) goto L37;
        r18 = false;
        goto L38
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562080, r9, false);
        int r12 = 2131365114;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131365114);
        if (r3 == null) goto L21;
        r12 = 2131367639;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131367639);
        if (r4 == null) goto L21;
        r12 = 2131368970;
        EditText r5 = (EditText) ViewBindings.findChildViewById(r11, 2131368970);
        if (r5 == null) goto L21;
        r12 = 2131368982;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131368982);
        if (r6 == null) goto L21;
        this.d = new LarusDialogInputBinding((LinearLayout) r11, r3, r4, r5, r6);
        Dialog r13 = getDialog();
        if (r13 == null) goto L15;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L15;
        r14.setBackgroundDrawable(new ColorDrawable(0));
    L15:
        LarusDialogInputBinding r15 = this.d;
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L19:
        return r15.a;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
