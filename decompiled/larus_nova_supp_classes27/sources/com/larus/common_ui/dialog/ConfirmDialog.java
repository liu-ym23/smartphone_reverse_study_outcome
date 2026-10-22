package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.larus.common_res.common_ui.databinding.LarusDialogConfimBinding;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u00010B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001f\u001a\u00020 H\u0016J$\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u001a\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\"2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\u0010\u0010+\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016J\u0010\u0010.\u001a\u00020 2\u0006\u0010,\u001a\u00020-H\u0016J\b\u0010/\u001a\u00020 H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/larus/common_ui/dialog/ConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogConfimBinding;", "mTitle", "", "mShowMessage", "", "mMessage", "", "mMessageColor", "", "Ljava/lang/Integer;", "mConfirmText", "mConfirmTextColor", "mConfirmBold", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mWhiteClickListener", "Lcom/larus/common_ui/dialog/WhiteClickListener;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mButtonTrim", "mCanceledOnTouchOutside", "backListener", "Lkotlin/Function0;", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "setupView", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ConfirmDialog extends DialogFragment {
    public static final /* synthetic */ int s = 0;
    public LarusDialogConfimBinding d;
    public String e;
    public final boolean f;
    public CharSequence g;
    public Integer h;
    public String i;
    public boolean j;
    public p0 k;
    public String l;
    public u m;
    public l1 n;
    public DialogInterface.OnDismissListener o;
    public boolean p;
    public boolean q;
    public Function0<Boolean> r;

    public ConfirmDialog() {
        this.e = "";
        this.f = true;
        this.g = "";
        this.q = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L7;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L7;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        r2.width = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (i5.r0() * 2);
        r1.setAttributes(r2);
    L7:
        final Function0<Boolean> r4 = this.r;
        if (r4 == null) goto L13;
        Dialog r5 = getDialog();
        if (r5 == null) goto L14;
        r5.setOnKeyListener(new r0(r4));
        return;
    L14:
        return;
    }

    public static void S90(ConfirmDialog r1) {
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

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        DialogInterface.OnDismissListener r0 = this.o;     // Catch: Throwable -> L7
        if (r0 == null) goto L5;
        r0.onDismiss(r2);     // Catch: Throwable -> L7
    L5:
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L7:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r7, Bundle r8) {
        Intrinsics.checkNotNullParameter(r7, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r7, r8);
        LarusDialogConfimBinding r9 = this.d;
        LarusDialogConfimBinding r10 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L5:
        r9.e.setText(this.e);
        LarusDialogConfimBinding r11 = this.d;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L8:
        TextView r12 = r11.d;
        boolean r3 = false;
        if (this.f == false) goto L11;
        int r1 = 0;
    L12:
        r12.setVisibility(r1);
        LarusDialogConfimBinding r13 = this.d;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L15:
        r13.d.setText(this.g);
        String r14 = this.e;
        if (r14 != null) goto L18;
    L21:
        boolean r15 = true;
    L22:
        if (r15 == false) goto L31;
        LarusDialogConfimBinding r16 = this.d;
        if (r16 != null) goto L26;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L26:
        r16.e.setVisibility(8);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-1, -2);
        r17.topMargin = i5.E();
        r17.leftMargin = i5.A();
        r17.rightMargin = i5.A();
        LarusDialogConfimBinding r4 = this.d;
        if (r4 != null) goto L29;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L29:
        r4.d.setLayoutParams(r17);
    L31:
        if ((this.g instanceof SpannableString) == false) goto L39;
        LarusDialogConfimBinding r18 = this.d;
        if (r18 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L35:
        r18.d.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogConfimBinding r20 = this.d;
        if (r20 != null) goto L38;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L38:
        r20.d.setHighlightColor(0);
    L39:
        Integer r21 = this.h;
        if (r21 == null) goto L45;
        int r22 = r21.intValue();
        LarusDialogConfimBinding r5 = this.d;
        if (r5 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L44:
        r5.d.setTextColor(r22);
    L45:
        String r23 = this.i;
        if (r23 != null) goto L48;
    L51:
        boolean r24 = true;
    L52:
        if (r24 == true) goto L58;
        LarusDialogConfimBinding r25 = this.d;
        if (r25 != null) goto L56;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L56:
        r25.c.setText(this.i);
    L58:
        if (this.j == false) goto L63;
        LarusDialogConfimBinding r26 = this.d;
        if (r26 != null) goto L62;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r26 = null;
    L62:
        r26.c.setTypeface(Typeface.DEFAULT_BOLD);
    L63:
        LarusDialogConfimBinding r27 = this.d;
        if (r27 != null) goto L66;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L66:
        r27.c.setOnClickListener(new s0(this));
        String r28 = this.l;
        if (r28 != null) goto L69;
    L72:
        boolean r30 = true;
    L73:
        if (r30 == true) goto L78;
        LarusDialogConfimBinding r31 = this.d;
        if (r31 != null) goto L77;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L77:
        r31.b.setText(this.l);
    L78:
        LarusDialogConfimBinding r32 = this.d;
        if (r32 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L81:
        r32.b.setOnClickListener(new t0(this));
        if (this.p == false) goto L122;
        String r33 = this.i;
        if (r33 != null) goto L86;
    L89:
        boolean r34 = true;
    L90:
        if (r34 == true) goto L99;
        String r35 = this.l;
        if (r35 != null) goto L94;
    L97:
        boolean r36 = true;
    L98:
        if (r36 == false) goto L122;
    L94:
        if (r35.length() == 0) goto L97;
        r36 = false;
    L99:
        String r37 = this.i;
        if (r37 != null) goto L102;
    L105:
        boolean r38 = true;
    L106:
        if (r38 == false) goto L111;
        LarusDialogConfimBinding r40 = this.d;
        if (r40 != null) goto L110;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r40 = null;
    L110:
        r40.c.setVisibility(8);
    L111:
        String r41 = this.l;
        if (r41 != null) goto L114;
    L115:
        r3 = true;
    L116:
        if (r3 == false) goto L122;
        LarusDialogConfimBinding r42 = this.d;
        if (r42 != null) goto L120;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L121:
        r10.b.setVisibility(8);
        goto L122
    L120:
        r10 = r42;
        goto L121
    L114:
        if (r41.length() != 0) goto L116;
    L102:
        if (r37.length() == 0) goto L105;
        r38 = false;
        goto L106
    L86:
        if (r33.length() == 0) goto L89;
        r34 = false;
    L122:
        Dialog r43 = getDialog();
        if (r43 == null) goto L125;
        r43.setCanceledOnTouchOutside(this.q);
    L125:
        Dialog r44 = getDialog();
        if (r44 == null) goto L137;
        Window r45 = r44.getWindow();
        if (r45 == null) goto L138;
        View r46 = r45.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L134;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r47 = ThreadMethodProxy.currentThread();
        if (r47 == com.larus.home.impl.utils.c.a) goto L134;
        com.larus.home.impl.utils.c.a(r47, "getDecorView");
    L134:
        if (r46 == null) goto L139;
        r46.setOnTouchListener(new q0(this));
        return;
    L139:
        return;
    L138:
        return;
    L137:
        return;
    L69:
        if (r28.length() == 0) goto L72;
        r30 = false;
        goto L73
    L48:
        if (r23.length() == 0) goto L51;
        r24 = false;
        goto L52
    L18:
        if (r14.length() == 0) goto L21;
        r15 = false;
        goto L22
    L11:
        r1 = 8;
        goto L12
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562051, r9, false);
        int r12 = 2131365114;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131365114);
        if (r3 == null) goto L21;
        r12 = 2131367639;
        Button r4 = (Button) ViewBindings.findChildViewById(r11, 2131367639);
        if (r4 == null) goto L21;
        r12 = 2131368971;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r11, 2131368971);
        if (r5 == null) goto L21;
        r12 = 2131368982;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131368982);
        if (r6 == null) goto L21;
        this.d = new LarusDialogConfimBinding((LinearLayout) r11, r3, r4, r5, r6);
        Dialog r13 = getDialog();
        if (r13 == null) goto L15;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L15;
        r14.setBackgroundDrawable(new ColorDrawable(0));
    L15:
        LarusDialogConfimBinding r15 = this.d;
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L19:
        return r15.a;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
