package com.larus.drive.biz.impl.dialog;

import android.animation.ValueAnimator;
import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBindings;
import com.bytedance.crash.d;
import com.larus.drive.biz.impl.databinding.LarusDialogDriveInputConfirmBinding;
import com.larus.home.impl.utils.c;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import m79.e;
import m79.f;
import m79.g;
import v19.h;
import v19.l5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u000201B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J&\u0010\u0017\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001d\u001a\u00020\u0014H\u0016J\b\u0010\u001e\u001a\u00020\u0014H\u0002J\b\u0010\u001f\u001a\u00020\u0014H\u0016J\b\u0010 \u001a\u00020\u0014H\u0002J\u0010\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0002J\u0018\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020\u00142\u0006\u0010)\u001a\u00020*H\u0016J\b\u0010+\u001a\u00020\u0014H\u0002J\u0012\u0010,\u001a\u00020\u00142\b\u0010%\u001a\u0004\u0018\u00010\u0018H\u0002J\u000e\u0010-\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010.\u001a\u00020\u00142\b\u0010/\u001a\u0004\u0018\u00010\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/larus/drive/biz/impl/dialog/DriveInputConfirmDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/drive/biz/impl/databinding/LarusDialogDriveInputConfirmBinding;", "titleText", "", "defaultInput", "hintText", "confirmText", "cancelText", "emptyInputWarningText", "callback", "Lcom/larus/drive/biz/impl/dialog/IDriveInputConfirmDialogCallback;", "translationAnimator", "Landroid/animation/ValueAnimator;", "isResettingText", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "setupView", "onStart", "setupKeyboardAdjust", "adjustForIme", "insets", "Landroidx/core/view/WindowInsetsCompat;", "animateTranslationY", "view", "to", "", "onCancel", "dialog", "Landroid/content/DialogInterface;", "dismissSafely", "showKeyboard", "setCallback", "setHint", "value", "Companion", "Builder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DriveInputConfirmDialog extends DialogFragment {
    public static final /* synthetic */ int n = 0;
    public LarusDialogDriveInputConfirmBinding d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public g k;
    public ValueAnimator l;
    public boolean m;

    public static final class a {
        public String a;
        public String b;
        public String c;
        public String d;
        public String e;
        public String f;
        public g g;

        public a() {
        }

        public final DriveInputConfirmDialog a() {
            DriveInputConfirmDialog r0 = new DriveInputConfirmDialog();
            Bundle r1 = new Bundle();
            r1.putString("arg_title", this.a);
            r1.putString("arg_default", this.b);
            r1.putString("arg_hint", this.c);
            r1.putString("arg_confirm", this.d);
            r1.putString("arg_cancel", this.e);
            r1.putString("arg_empty_input_warning", this.f);
            r0.setArguments(r1);
            g r2 = this.g;
            if (r2 == null) goto L5;
            Intrinsics.checkNotNullParameter(r2, "callback");
            r0.k = r2;
        L5:
            return r0;
        }
    }

    public static final class b {
    }

    static {
    }

    public final void T90() {
        FragmentActivity r0 = getActivity();     // Catch: Throwable -> L23
        boolean r1 = true;
        if (r0 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        if (r2 == false) goto L29;
        Dialog r3 = getDialog();     // Catch: Throwable -> L23
        if (r3 != null) goto L12;
    L14:
        r1 = false;
    L15:
        if (r1 == false) goto L30;
        dismiss();     // Catch: Exception -> L18 Throwable -> L23
    L32:
        return;
    L18:
        e = move-exception;
        d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");     // Catch: Throwable -> L23
        Throwable r4 = DialogFragmentLancet.sLastShowStack;     // Catch: Throwable -> L23
        if (r4 == null) goto L31;
        d.d(r4, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");     // Catch: Throwable -> L23
        return;
    L31:
        return;
    L30:
        return;
    L12:
        if (r3.isShowing() != true) goto L14;
    L29:
        return;
    L5:
        if (r0.isFinishing() == true) goto L7;
        r2 = true;
    L23:
        th = move-exception;
        FLogger.a.e("DriveInputConfirmDialog", "dismissSafely error", th);
    }

    public final void onDestroy() {
        super/*androidx.fragment.app.Fragment*/.onDestroy();
        ValueAnimator r0 = this.l;
        if (r0 == null) goto L6;
        r0.cancel();
        return;
    }

    public final void onStart() {
        PopupOrDialogVisibilityTracker.bindDialogFragment(this);
        LandscapeRestrictionGuard.bindDialogForAllowedDialogFragment(this);
        super.onStart();
        Dialog r0 = getDialog();
        if (r0 == null) goto L13;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L14;
        View r2 = r1.getDecorView();
        if (c.e == false) goto L11;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r3 = ThreadMethodProxy.currentThread();
        if (r3 == c.a) goto L11;
        c.a(r3, "getDecorView");
    L11:
        WindowInsetsControllerCompat r4 = WindowCompat.getInsetsController(r1, r2);
        boolean r5 = h.a;
        boolean r6 = !h.a(null);
        r4.setAppearanceLightStatusBars(r6);
        r4.setAppearanceLightNavigationBars(r6);
        r1.setLayout(-1, -1);
        r1.clearFlags(2);
        r1.addFlags(Integer.MIN_VALUE);
        r1.addFlags(512);
        return;
    L14:
        return;
    }

    public DriveInputConfirmDialog() {
    }

    public final void onCancel(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");
        super.onCancel(r2);
        g r3 = this.k;
        if (r3 == null) goto L6;
        r3.d();
        return;
    }

    public final void onCreate(Bundle r3) {
        super.onCreate(r3);
        setStyle(2, 2131952391);
        Bundle r4 = getArguments();
        String r0 = null;
        if (r4 == null) goto L5;
        String r1 = r4.getString("arg_title");
    L6:
        this.e = r1;
        if (r4 == null) goto L9;
        String r2 = r4.getString("arg_default");
    L10:
        this.f = r2;
        if (r4 == null) goto L13;
        String r5 = r4.getString("arg_hint");
    L14:
        this.g = r5;
        if (r4 == null) goto L17;
        String r6 = r4.getString("arg_confirm");
    L18:
        this.h = r6;
        if (r4 == null) goto L21;
        String r7 = r4.getString("arg_cancel");
    L22:
        this.i = r7;
        if (r4 == null) goto L25;
        r0 = r4.getString("arg_empty_input_warning");
    L25:
        this.j = r0;
        setCancelable(false);
        return;
    L21:
        r7 = null;
        goto L22
    L17:
        r6 = null;
        goto L18
    L13:
        r5 = null;
        goto L14
    L9:
        r2 = null;
        goto L10
    L5:
        r1 = null;
        goto L6
    }

    public final void S90(final View r4, float r5) {
        float r0 = r4.getTranslationY();
        if (Math.abs(r0 - r5) >= 1.0f) goto L6;
        r4.setTranslationY(r5);
        return;
    L6:
        ValueAnimator r1 = this.l;
        if (r1 == null) goto L9;
        r1.cancel();
    L9:
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{r0, r5});
        r6.setDuration(200);
        r6.setInterpolator(new l5());
        r6.addUpdateListener(new e(r4));
        r6.start();
        this.l = r6;
    }

    public final View onCreateView(LayoutInflater r9, ViewGroup r10, Bundle r11) {
        Intrinsics.checkNotNullParameter(r9, "inflater");
        View r12 = r9.inflate(2131562064, r10, false);
        int r13 = 2131377269;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r12, 2131377269);
        if (r3 == null) goto L105;
        r13 = 2131377270;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r12, 2131377270);
        if (r4 == null) goto L105;
        r13 = 2131377271;
        LinearLayout r5 = (LinearLayout) ViewBindings.findChildViewById(r12, 2131377271);
        if (r5 == null) goto L105;
        r13 = 2131377272;
        EditText r6 = (EditText) ViewBindings.findChildViewById(r12, 2131377272);
        if (r6 == null) goto L105;
        r13 = 2131377273;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r12, 2131377273);
        if (r7 == null) goto L105;
        this.d = new LarusDialogDriveInputConfirmBinding((FrameLayout) r12, r3, r4, r5, r6, r7);
        Dialog r14 = getDialog();
        if (r14 == null) goto L17;
        Window r15 = r14.getWindow();
        if (r15 == null) goto L17;
        r15.setBackgroundDrawable(new ColorDrawable(0));
        WindowCompat.setDecorFitsSystemWindows(r15, false);
    L17:
        String r16 = this.e;
        if (r16 == null) goto L24;
        LarusDialogDriveInputConfirmBinding r17 = this.d;
        if (r17 == null) goto L24;
        TextView r18 = r17.f;
        if (r18 == null) goto L24;
        r18.setText(r16);
    L24:
        String r20 = this.h;
        if (r20 == null) goto L31;
        LarusDialogDriveInputConfirmBinding r110 = this.d;
        if (r110 == null) goto L31;
        TextView r111 = r110.c;
        if (r111 == null) goto L31;
        r111.setText(r20);
    L31:
        String r21 = this.i;
        if (r21 == null) goto L38;
        LarusDialogDriveInputConfirmBinding r112 = this.d;
        if (r112 == null) goto L38;
        TextView r113 = r112.b;
        if (r113 == null) goto L38;
        r113.setText(r21);
    L38:
        String r22 = this.f;
        if (r22 == null) goto L45;
        LarusDialogDriveInputConfirmBinding r114 = this.d;
        if (r114 == null) goto L45;
        EditText r115 = r114.e;
        if (r115 == null) goto L45;
        r115.setText(r22);
    L45:
        String r23 = this.g;
        if (r23 == null) goto L52;
        LarusDialogDriveInputConfirmBinding r116 = this.d;
        if (r116 == null) goto L52;
        EditText r117 = r116.e;
        if (r117 == null) goto L52;
        r117.setHint(r23);
    L52:
        LarusDialogDriveInputConfirmBinding r24 = this.d;
        if (r24 == null) goto L57;
        EditText r25 = r24.e;
        if (r25 == null) goto L57;
        r25.addTextChangedListener(new f(this));
    L57:
        LarusDialogDriveInputConfirmBinding r26 = this.d;
        if (r26 == null) goto L62;
        TextView r27 = r26.b;
        if (r27 == null) goto L62;
        r27.setOnClickListener(new m79.b(this));
    L62:
        LarusDialogDriveInputConfirmBinding r28 = this.d;
        if (r28 == null) goto L67;
        TextView r30 = r28.c;
        if (r30 == null) goto L67;
        r30.setOnClickListener(new m79.c(this));
    L67:
        LarusDialogDriveInputConfirmBinding r31 = this.d;
        if (r31 == null) goto L72;
        LinearLayout r32 = r31.d;
        if (r32 == null) goto L72;
        r32.setClickable(true);
    L72:
        LarusDialogDriveInputConfirmBinding r33 = this.d;
        if (r33 == null) goto L77;
        EditText r34 = r33.e;
        if (r34 == null) goto L77;
        r34.requestFocus();
    L77:
        Dialog r35 = getDialog();
        if (r35 == null) goto L82;
        Window r36 = r35.getWindow();
        if (r36 == null) goto L82;
        r36.setSoftInputMode(5);
    L82:
        LarusDialogDriveInputConfirmBinding r37 = this.d;
        if (r37 == null) goto L85;
        EditText r38 = r37.e;
    L86:
        if (r38 != null) goto L106;
    L94:
        LarusDialogDriveInputConfirmBinding r40 = this.d;
        if (r40 == null) goto L100;
        FrameLayout r41 = r40.a;
        if (r41 == null) goto L100;
        ViewCompat.setOnApplyWindowInsetsListener(r41, new m79.d(this));
    L100:
        LarusDialogDriveInputConfirmBinding r42 = this.d;
        if (r42 != null) goto L103;
        return null;
    L103:
        return r42.a;
    L106:
        InputMethodManager r0 = (InputMethodManager) ContextCompat.getSystemService(requireContext(), InputMethodManager.class);     // Catch: Throwable -> L92
        if (r0 == null) goto L94;
        r0.showSoftInput(r38, 1);     // Catch: Throwable -> L92
    L92:
        th = move-exception;
        FLogger.a.e("DriveInputConfirmDialog", "showKeyboard error", th);
        goto L94
    L85:
        r38 = null;
    L105:
        throw new NullPointerException("Missing required view with ID: ".concat(r12.getResources().getResourceName(r13)));
    }
}
