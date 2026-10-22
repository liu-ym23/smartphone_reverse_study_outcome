package com.larus.bootprotector.activity.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
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
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import bu8.a;
import bu8.b;
import bu8.c;
import com.bytedance.crash.d;
import com.larus.bootprotector.impl.databinding.LarusDialogSpanableBootProtectorBinding;
import com.larus.common_ui.dialog.p0;
import com.larus.common_ui.dialog.u;
import com.larus.common_ui.widget.UrlSpanTextView;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes26.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001*B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u001a\u001a\u00020\u001bH\u0016J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010%\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006+"}, d2 = {"Lcom/larus/bootprotector/activity/dialog/BootProtectorConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/bootprotector/impl/databinding/LarusDialogSpanableBootProtectorBinding;", "mTitle", "", "mShowMessage", "", "mMessage", "", "mConfirmText", "mConfirmTextColor", "", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "mConfirmAutoDismiss", "mCancelText", "mCancelTextColor", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mSpannaleClickListener", "Lcom/larus/common_ui/dialog/SpannaleClickListener;", "backListener", "Lkotlin/Function0;", "onResume", "", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "onDismiss", "dialog", "Landroid/content/DialogInterface;", "setupView", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BootProtectorConfirmDialog extends DialogFragment {
    public static final /* synthetic */ int o = 0;
    public LarusDialogSpanableBootProtectorBinding d;
    public String e;
    public final boolean f;
    public CharSequence g;
    public String h;
    public p0 i;
    public boolean j;
    public String k;
    public int l;
    public u m;
    public Function0<Boolean> n;

    public BootProtectorConfirmDialog() {
        this.e = "";
        this.f = true;
        this.g = "";
        this.j = true;
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
        final Function0<Boolean> r5 = this.n;
        if (r5 == null) goto L16;
        Dialog r6 = getDialog();
        if (r6 == null) goto L17;
        r6.setOnKeyListener(new a(r5));
        return;
    L17:
        return;
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
        d.d(e, "DIALOG_DISMISS_EXCEPTION");     // Catch: Throwable -> L11
        Throwable r1 = DialogLancet.sLastShowStack;     // Catch: Throwable -> L11
        if (r1 == null) goto L17;
        d.d(r1, "DIALOG_SHOW_STACK_TRACE");     // Catch: Throwable -> L11
    L11:
        th = move-exception;
        DialogLancet.afterDialogDismiss(r3);
        throw th;
    L5:
        if (Looper.myLooper() == r0.getLooper()) goto L8;
        r0.post(DialogLancet.createDismissRunnable(r3));
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L5
        super.onDismiss(r2);     // Catch: Throwable -> L5
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        return;
    L5:
        th = move-exception;
        LandscapeChildDialogBoundsAdapter.onDialogDismissed(getDialog());
        PopupOrDialogVisibilityTracker.onDialogFragmentDismissed(this);
        LandscapeRestrictionGuard.clearAllowedDialogFragment(this);
        throw th;
    }

    public final void onViewCreated(View r6, Bundle r7) {
        Intrinsics.checkNotNullParameter(r6, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r6, r7);
        LarusDialogSpanableBootProtectorBinding r8 = this.d;
        LarusDialogSpanableBootProtectorBinding r9 = null;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r8 = null;
    L5:
        r8.e.setText(this.e);
        LarusDialogSpanableBootProtectorBinding r10 = this.d;
        if (r10 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L8:
        UrlSpanTextView r11 = r10.d;
        if (this.f == false) goto L11;
        int r1 = 0;
    L12:
        r11.setVisibility(r1);
        LarusDialogSpanableBootProtectorBinding r12 = this.d;
        if (r12 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L15:
        r12.d.setUrlSpannedText(String.valueOf(this.g));
        if ((this.g instanceof SpannableString) == false) goto L24;
        LarusDialogSpanableBootProtectorBinding r13 = this.d;
        if (r13 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L20:
        r13.d.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogSpanableBootProtectorBinding r14 = this.d;
        if (r14 != null) goto L23;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L23:
        r14.d.setHighlightColor(0);
    L24:
        String r15 = this.h;
        boolean r2 = true;
        if (r15 != null) goto L27;
    L30:
        boolean r16 = true;
    L31:
        if (r16 == true) goto L37;
        LarusDialogSpanableBootProtectorBinding r17 = this.d;
        if (r17 != null) goto L35;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L35:
        r17.c.setText(this.h);
    L37:
        if (this.l != 0) goto L44;
        Context r18 = getContext();
        if (r18 == null) goto L48;
        LarusDialogSpanableBootProtectorBinding r3 = this.d;
        if (r3 != null) goto L43;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r3 = null;
    L43:
        r3.b.setTextColor(ContextCompat.getColor(r18, 2131103203));
    L48:
        LarusDialogSpanableBootProtectorBinding r19 = this.d;
        if (r19 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r19 = null;
    L51:
        r19.c.setOnClickListener(new b(this));
        String r20 = this.k;
        if (r20 != null) goto L54;
    L57:
        if (r2 == true) goto L62;
        LarusDialogSpanableBootProtectorBinding r21 = this.d;
        if (r21 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L61:
        r21.b.setText(this.k);
    L62:
        LarusDialogSpanableBootProtectorBinding r22 = this.d;
        if (r22 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L66:
        r9.b.setOnClickListener(new c(this));
        Dialog r23 = getDialog();
        if (r23 == null) goto L70;
        r23.setCanceledOnTouchOutside(false);
        return;
    L70:
        return;
    L65:
        r9 = r22;
        goto L66
    L54:
        if (r20.length() == 0) goto L57;
        r2 = false;
        goto L57
    L44:
        LarusDialogSpanableBootProtectorBinding r24 = this.d;
        if (r24 != null) goto L47;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r24 = null;
    L47:
        r24.b.setTextColor(this.l);
        goto L48
    L27:
        if (r15.length() == 0) goto L30;
        r16 = false;
        goto L31
    L11:
        r1 = 8;
        goto L12
    }

    public final View onCreateView(LayoutInflater r8, ViewGroup r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r8, "inflater");
        View r11 = r8.inflate(2131562105, r9, false);
        int r12 = 2131365114;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r11, 2131365114);
        if (r3 == null) goto L21;
        r12 = 2131367639;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r11, 2131367639);
        if (r4 == null) goto L21;
        r12 = 2131368971;
        UrlSpanTextView r5 = ViewBindings.findChildViewById(r11, 2131368971);
        if (r5 == null) goto L21;
        r12 = 2131368982;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r11, 2131368982);
        if (r6 == null) goto L21;
        this.d = new LarusDialogSpanableBootProtectorBinding((FrameLayout) r11, r3, r4, r5, r6);
        Dialog r13 = getDialog();
        if (r13 == null) goto L15;
        Window r14 = r13.getWindow();
        if (r14 == null) goto L15;
        r14.setBackgroundDrawable(new ColorDrawable(0));
    L15:
        LarusDialogSpanableBootProtectorBinding r15 = this.d;
        if (r15 != null) goto L19;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L19:
        return r15.a;
    L21:
        throw new NullPointerException("Missing required view with ID: ".concat(r11.getResources().getResourceName(r12)));
    }
}
