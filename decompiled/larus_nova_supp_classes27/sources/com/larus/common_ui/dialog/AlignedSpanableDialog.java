package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusDialogSpanableAlignedBinding;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u001cH\u0016J$\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$2\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\u001a\u0010'\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u00072\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010)\u001a\u00020\u001cH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001a¨\u0006+"}, d2 = {"Lcom/larus/common_ui/dialog/AlignedSpanableDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogSpanableAlignedBinding;", "dialogView", "Landroid/view/View;", "title", "", "message", "", "bottomIndividualText", "scrollViewHeight", "", "confirmText", "confirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "cancelText", "cancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "spannaleClickListener", "Lcom/larus/common_ui/dialog/SpannaleClickListener;", "alignTargetViewRef", "Ljava/lang/ref/WeakReference;", "linkTextColor", "Ljava/lang/Integer;", "onAttach", "", "context", "Landroid/content/Context;", "onResume", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setupView", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AlignedSpanableDialog extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public LarusDialogSpanableAlignedBinding d;
    public String e;
    public CharSequence f;
    public CharSequence g;
    public int h;
    public String i;
    public p0 j;
    public String k;
    public u l;
    public k1 m;
    public Integer n;

    public AlignedSpanableDialog() {
        this.e = "";
        this.f = "";
        this.g = "";
        this.h = -1;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L5;
        Window r1 = r0.getWindow();
    L6:
        if (r1 == null) goto L11;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (i5.Q() * 2);
        r2.width = r4;
        if (r4 <= i5.a0()) goto L10;
        r2.width = i5.a0();
    L10:
        r2.gravity = 17;
        r1.setAttributes(r2);
    L11:
        Dialog r5 = getDialog();
        if (r5 == null) goto L15;
        r5.setOnKeyListener(new k());
        return;
    L15:
        return;
    L5:
        r1 = null;
        goto L6
    }

    public static void S90(Dialog r3) {
        Handler r0 = DialogLancet.resolveDialogHandler(r3);
        if (r0 != null) goto L5;
    L8:
        DialogLancet.beforeDialogDismiss(r3);
        r3.dismiss();     // Catch: Throwable -> L11 Exception -> L13
    L17:
        DialogLancet.afterDialogDismiss(r3);
        return;
    L13:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        com.bytedance.crash.d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
    }

    public final void onViewCreated(View r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r5, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r5, r6);
        LarusDialogSpanableAlignedBinding r7 = this.d;
        LarusDialogSpanableAlignedBinding r8 = null;
        if (r7 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L5:
        r7.f.setText(this.e);
        Integer r9 = this.n;
        if (r9 == null) goto L11;
        int r10 = r9.intValue();
        LarusDialogSpanableAlignedBinding r1 = this.d;
        if (r1 != null) goto L10;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L10:
        r1.e.setUrlTextColor(ColorStateList.valueOf(r10));
    L11:
        LarusDialogSpanableAlignedBinding r11 = this.d;
        if (r11 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L14:
        r11.e.setUrlSpannedText(String.valueOf(this.f));
        LarusDialogSpanableAlignedBinding r12 = this.d;
        if (r12 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L17:
        r12.e.setOnClickListener(new n(this));
        if (this.h <= 0) goto L24;
        LarusDialogSpanableAlignedBinding r13 = this.d;
        if (r13 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L22:
        r13.g.getLayoutParams().height = this.h;
    L24:
        if ((this.f instanceof SpannableString) == false) goto L32;
        LarusDialogSpanableAlignedBinding r14 = this.d;
        if (r14 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L28:
        r14.e.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableAlignedBinding r15 = this.d;
        if (r15 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L31:
        r15.e.setHighlightColor(0);
    L32:
        String r16 = this.i;
        boolean r2 = true;
        if (r16 != null) goto L35;
    L38:
        boolean r17 = true;
    L39:
        if (r17 == true) goto L44;
        LarusDialogSpanableAlignedBinding r18 = this.d;
        if (r18 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L43:
        r18.d.setText(this.i);
    L44:
        LarusDialogSpanableAlignedBinding r20 = this.d;
        if (r20 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L47:
        r20.d.setOnClickListener(new l(this));
        String r21 = this.k;
        if (r21 != null) goto L50;
    L53:
        boolean r22 = true;
    L54:
        if (r22 == true) goto L59;
        LarusDialogSpanableAlignedBinding r23 = this.d;
        if (r23 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r23 = null;
    L58:
        r23.c.setText(this.k);
    L59:
        LarusDialogSpanableAlignedBinding r24 = this.d;
        if (r24 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L62:
        r24.c.setOnClickListener(new m(this));
        CharSequence r25 = this.g;
        if (r25 != null) goto L65;
    L68:
        if (r2 == true) goto L92;
        LarusDialogSpanableAlignedBinding r26 = this.d;
        if (r26 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L72:
        r26.b.setVisibility(0);
        Integer r27 = this.n;
        if (r27 == null) goto L78;
        int r28 = r27.intValue();
        LarusDialogSpanableAlignedBinding r3 = this.d;
        if (r3 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L77:
        r3.b.setUrlTextColor(ColorStateList.valueOf(r28));
    L78:
        LarusDialogSpanableAlignedBinding r30 = this.d;
        if (r30 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L81:
        r30.b.setUrlSpannedText(String.valueOf(this.g));
        LarusDialogSpanableAlignedBinding r31 = this.d;
        if (r31 != null) goto L84;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L84:
        r31.b.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableAlignedBinding r32 = this.d;
        if (r32 != null) goto L87;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L87:
        r32.b.setHighlightColor(0);
        LarusDialogSpanableAlignedBinding r33 = this.d;
        if (r33 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L91:
        r8.b.setOnClickListener(new o(this));
    L97:
        Dialog r34 = getDialog();
        if (r34 == null) goto L101;
        r34.setCanceledOnTouchOutside(false);
        return;
    L101:
        return;
    L90:
        r8 = r33;
        goto L91
    L92:
        LarusDialogSpanableAlignedBinding r35 = this.d;
        if (r35 != null) goto L95;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L96:
        r8.b.setVisibility(8);
        goto L97
    L95:
        r8 = r35;
        goto L96
    L65:
        if (r25.length() == 0) goto L68;
        r2 = false;
        goto L68
    L50:
        if (r21.length() == 0) goto L53;
        r22 = false;
        goto L54
    L35:
        if (r16.length() == 0) goto L38;
        r17 = false;
        goto L39
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131562104, r11, false);
        int r14 = 2131364471;
        UrlSpanTextView r3 = (UrlSpanTextView) ViewBindings.findChildViewById(r13, 2131364471);
        if (r3 == null) goto L29;
        r14 = 2131365114;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131365114);
        if (r4 == null) goto L29;
        r14 = 2131367639;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, 2131367639);
        if (r5 == null) goto L29;
        r14 = 2131368971;
        UrlSpanTextView r6 = (UrlSpanTextView) ViewBindings.findChildViewById(r13, 2131368971);
        if (r6 == null) goto L29;
        r14 = 2131368982;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r13, 2131368982);
        if (r7 == null) goto L29;
        r14 = 2131385224;
        ScrollView r8 = (ScrollView) ViewBindings.findChildViewById(r13, 2131385224);
        if (r8 == null) goto L29;
        this.d = new LarusDialogSpanableAlignedBinding(r13, r3, r4, r5, r6, r7, r8);
        Dialog r15 = getDialog();
        if (r15 == null) goto L19;
        Window r16 = r15.getWindow();
        if (r16 == null) goto L19;
        r16.setBackgroundDrawable(new ColorDrawable(0));
    L19:
        LarusDialogSpanableAlignedBinding r17 = this.d;
        LarusDialogSpanableAlignedBinding r18 = null;
        if (r17 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L22:
        ConstraintLayout r110 = r17.a;
        LarusDialogSpanableAlignedBinding r111 = this.d;
        if (r111 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L27:
        return r18.a;
    L25:
        r18 = r111;
    L29:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
