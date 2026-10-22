package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.Size;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_res.common_ui.databinding.LarusAccessibilityDialogCommonBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00106\u001a\u000207H\u0016J$\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010?\u001a\u0002072\u0006\u0010@\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010A\u001a\u000207H\u0002J\u0018\u0010B\u001a\u0002072\u0006\u0010C\u001a\u00020D2\b\u0010E\u001a\u0004\u0018\u00010\u0007J\b\u0010F\u001a\u000207H\u0002J\b\u0010G\u001a\u000207H\u0002J\u0010\u0010H\u001a\u0002072\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u0002072\u0006\u0010I\u001a\u00020JH\u0016J\b\u0010L\u001a\u000207H\u0002J\b\u0010M\u001a\u000207H\u0002J\u0018\u0010N\u001a\u0002072\u0006\u0010@\u001a\u0002052\u0006\u0010O\u001a\u00020\rH\u0002J\b\u0010P\u001a\u000207H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u0018R\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010%\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u000e\u00103\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/common_ui/dialog/AccessibilityCommonDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusAccessibilityDialogCommonBinding;", "mTitle", "", "mShowMessage", "", "mMessage", "", "mMessageColor", "", "Ljava/lang/Integer;", "mConfirmText", "mConfirmTextColor", "mConfirmBold", "mCancelBold", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "getMConfirmClickListener", "()Lcom/larus/common_ui/dialog/ConfirmClickListener;", "setMConfirmClickListener", "(Lcom/larus/common_ui/dialog/ConfirmClickListener;)V", "mEarlyConfirmClickListener", "getMEarlyConfirmClickListener", "setMEarlyConfirmClickListener", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mWhiteClickListener", "Lcom/larus/common_ui/dialog/WhiteClickListener;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mButtonTrim", "mCanceledOnTouchOutside", "backListener", "Lkotlin/Function0;", "mMessageTestStyle", "Lcom/larus/common_ui/dialog/CommonDialogTextStyleConfig;", "mConfirmTextStyle", "mCancelTextStyle", "needSetWindowTransparent", "mTopImageUrl", "Landroid/net/Uri;", "mTopImageSize", "Landroid/util/Size;", "mTopImageRadius", "", "Ljava/lang/Float;", "needResumeVisible", "dialogView", "Landroid/view/View;", "onResume", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpMessageTextStyle", "showAllowingStateLoss", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "setUpConfirmTextStyle", "setUpCancelTextStyle", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "setupView", "setupAccessibility", "updateBottomButtonVisibility", "visibility", "setTopImage", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AccessibilityCommonDialog extends DialogFragment {
    public static final /* synthetic */ int E = 0;
    public Size A;
    public Float B;
    public boolean C;
    public ConstraintLayout D;
    public LarusAccessibilityDialogCommonBinding d;
    public String e;
    public boolean f;
    public CharSequence g;
    public Integer h;
    public String i;
    public int j;
    public boolean k;
    public boolean l;
    public p0 m;
    public p0 n;
    public String o;
    public u p;
    public l1 q;
    public DialogInterface.OnDismissListener r;
    public boolean s;
    public boolean t;
    public Function0<Boolean> u;
    public f0 v;
    public f0 w;
    public f0 x;
    public boolean y;
    public Uri z;

    public AccessibilityCommonDialog() {
        this.e = "";
        this.f = true;
        this.g = "";
        this.t = true;
        this.y = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L8;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L8;
        r1.setLayout(-1, -1);
    L8:
        if (this.C == false) goto L12;
        ConstraintLayout r2 = this.D;
        if (r2 == null) goto L12;
        com.larus.utils.e1.x(r2);
    L12:
        final Function0<Boolean> r3 = this.u;
        if (r3 == null) goto L18;
        Dialog r4 = getDialog();
        if (r4 == null) goto L19;
        r4.setOnKeyListener(new b(r3));
        return;
    L19:
        return;
    }

    public static void S90(AccessibilityCommonDialog r1) {
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

    public final void T90(View r5) {
        r5.setVisibility(8);
        LarusAccessibilityDialogCommonBinding r6 = this.d;
        if (r6 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L6:
        if (r6.c.getVisibility() != 8) goto L11;
        r6.g.setVisibility(8);
        TextView r7 = r6.b;
        if (r7 == null) goto L22;
        r7.setBackgroundResource(v19.c.b(2130970660, r7.getContext(), 2131239031));
        return;
    L22:
        return;
    L11:
        if (r6.b.getVisibility() != 8) goto L15;
        r6.g.setVisibility(8);
        TextView r8 = r6.c;
        if (r8 == null) goto L24;
        r8.setBackgroundResource(v19.c.b(2130970660, r8.getContext(), 2131239031));
        return;
    L24:
        return;
    L15:
        r6.g.setVisibility(0);
        TextView r0 = r6.c;
        if (r0 == null) goto L18;
        r0.setBackgroundResource(v19.c.b(2130970713, r0.getContext(), 2131239234));
    L18:
        TextView r9 = r6.b;
        if (r9 == null) goto L26;
        r9.setBackgroundResource(v19.c.b(2130970788, r9.getContext(), 2131239536));
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
        DialogInterface.OnDismissListener r0 = this.r;     // Catch: Throwable -> L7
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
        LarusAccessibilityDialogCommonBinding r9 = this.d;
        LarusAccessibilityDialogCommonBinding r10 = null;
        if (r9 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r9 = null;
    L5:
        r9.e.setText(this.e);
        LarusAccessibilityDialogCommonBinding r11 = this.d;
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
        LarusAccessibilityDialogCommonBinding r13 = this.d;
        if (r13 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L15:
        r13.d.setText(this.g);
        String r14 = this.e;
        if (r14 != null) goto L18;
    L21:
        boolean r15 = true;
    L23:
        if (r15 == false) goto L32;
        LarusAccessibilityDialogCommonBinding r16 = this.d;
        if (r16 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r16 = null;
    L27:
        r16.e.setVisibility(8);
        LinearLayout.LayoutParams r17 = new LinearLayout.LayoutParams(-1, -2);
        r17.topMargin = i5.E();
        r17.leftMargin = i5.A();
        r17.rightMargin = i5.A();
        LarusAccessibilityDialogCommonBinding r2 = this.d;
        if (r2 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r2 = null;
    L30:
        r2.d.setLayoutParams(r17);
    L32:
        if ((this.g instanceof SpannableString) == false) goto L40;
        LarusAccessibilityDialogCommonBinding r18 = this.d;
        if (r18 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L36:
        r18.d.setMovementMethod(LinkMovementMethod.getInstance());
        LarusAccessibilityDialogCommonBinding r20 = this.d;
        if (r20 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L39:
        r20.d.setHighlightColor(0);
    L40:
        Integer r21 = this.h;
        if (r21 == null) goto L46;
        int r22 = r21.intValue();
        LarusAccessibilityDialogCommonBinding r4 = this.d;
        if (r4 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L45:
        r4.d.setTextColor(r22);
    L46:
        String r23 = this.i;
        if (r23 != null) goto L49;
    L52:
        boolean r24 = true;
    L53:
        if (r24 == true) goto L59;
        LarusAccessibilityDialogCommonBinding r25 = this.d;
        if (r25 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r25 = null;
    L57:
        r25.c.setText(this.i);
    L59:
        if (this.j != 0) goto L66;
        Context r26 = getContext();
        if (r26 == null) goto L71;
        LarusAccessibilityDialogCommonBinding r5 = this.d;
        if (r5 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L65:
        r5.c.setTextColor(ContextCompat.getColor(r26, 2131102650));
    L71:
        if (this.k == false) goto L77;
        LarusAccessibilityDialogCommonBinding r27 = this.d;
        if (r27 != null) goto L75;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L75:
        r27.c.setTypeface(Typeface.DEFAULT_BOLD);
    L77:
        if (this.l == false) goto L82;
        LarusAccessibilityDialogCommonBinding r28 = this.d;
        if (r28 != null) goto L81;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L81:
        r28.b.setTypeface(Typeface.DEFAULT_BOLD);
    L82:
        LarusAccessibilityDialogCommonBinding r30 = this.d;
        if (r30 != null) goto L85;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r30 = null;
    L85:
        r30.c.setOnClickListener(new c(this));
        if (this.p != null) goto L91;
        LarusAccessibilityDialogCommonBinding r31 = this.d;
        if (r31 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L90:
        T90(r31.b);
    L108:
        if (this.s == false) goto L147;
        String r32 = this.i;
        if (r32 != null) goto L112;
    L115:
        boolean r33 = true;
    L116:
        if (r33 == true) goto L125;
        String r34 = this.o;
        if (r34 != null) goto L120;
    L123:
        boolean r35 = true;
    L124:
        if (r35 == false) goto L147;
    L120:
        if (r34.length() == 0) goto L123;
        r35 = false;
    L125:
        String r36 = this.i;
        if (r36 != null) goto L128;
    L131:
        boolean r37 = true;
    L132:
        if (r37 == false) goto L137;
        LarusAccessibilityDialogCommonBinding r38 = this.d;
        if (r38 != null) goto L136;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r38 = null;
    L136:
        T90(r38.c);
    L137:
        String r40 = this.o;
        if (r40 != null) goto L140;
    L141:
        r3 = true;
    L142:
        if (r3 == false) goto L147;
        LarusAccessibilityDialogCommonBinding r41 = this.d;
        if (r41 != null) goto L146;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r41 = null;
    L146:
        T90(r41.b);
        goto L147
    L140:
        if (r40.length() != 0) goto L142;
    L128:
        if (r36.length() == 0) goto L131;
        r37 = false;
        goto L132
    L112:
        if (r32.length() == 0) goto L115;
        r33 = false;
    L147:
        f0 r42 = this.v;
        if (r42 == null) goto L167;
        Integer r6 = r42.a;
        if (r6 == null) goto L155;
        int r43 = r6.intValue();
        LarusAccessibilityDialogCommonBinding r44 = this.d;
        if (r44 != null) goto L154;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r44 = null;
    L154:
        r44.d.setTextSize(r43);
    L155:
        Integer r45 = r42.b;
        if (r45 == null) goto L161;
        int r46 = r45.intValue();
        LarusAccessibilityDialogCommonBinding r47 = this.d;
        if (r47 != null) goto L160;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r47 = null;
    L160:
        r47.d.setTextColor(r46);
    L161:
        Typeface r48 = r42.c;
        if (r48 == null) goto L167;
        LarusAccessibilityDialogCommonBinding r50 = this.d;
        if (r50 != null) goto L166;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r50 = null;
    L166:
        r50.d.setTypeface(r48);
    L167:
        f0 r51 = this.w;
        if (r51 == null) goto L187;
        Integer r52 = r51.a;
        if (r52 == null) goto L175;
        int r53 = r52.intValue();
        LarusAccessibilityDialogCommonBinding r54 = this.d;
        if (r54 != null) goto L174;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r54 = null;
    L174:
        r54.c.setTextSize(r53);
    L175:
        Integer r55 = r51.b;
        if (r55 == null) goto L181;
        int r56 = r55.intValue();
        LarusAccessibilityDialogCommonBinding r57 = this.d;
        if (r57 != null) goto L180;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r57 = null;
    L180:
        r57.c.setTextColor(r56);
    L181:
        Typeface r58 = r51.c;
        if (r58 == null) goto L187;
        LarusAccessibilityDialogCommonBinding r60 = this.d;
        if (r60 != null) goto L186;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r60 = null;
    L186:
        r60.c.setTypeface(r58);
    L187:
        f0 r61 = this.x;
        if (r61 == null) goto L208;
        Integer r62 = r61.a;
        if (r62 == null) goto L195;
        int r63 = r62.intValue();
        LarusAccessibilityDialogCommonBinding r64 = this.d;
        if (r64 != null) goto L194;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r64 = null;
    L194:
        r64.b.setTextSize(r63);
    L195:
        Integer r65 = r61.b;
        if (r65 == null) goto L201;
        int r66 = r65.intValue();
        LarusAccessibilityDialogCommonBinding r67 = this.d;
        if (r67 != null) goto L200;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r67 = null;
    L200:
        r67.b.setTextColor(r66);
    L201:
        Typeface r68 = r61.c;
        if (r68 == null) goto L208;
        LarusAccessibilityDialogCommonBinding r70 = this.d;
        if (r70 != null) goto L206;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r70 = null;
    L206:
        r70.b.setTypeface(r68);
    L208:
        if (this.z == null) goto L237;
        LarusAccessibilityDialogCommonBinding r71 = this.d;
        if (r71 != null) goto L212;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r71 = null;
    L212:
        com.larus.utils.e1.x(r71.f);
        LarusAccessibilityDialogCommonBinding r72 = this.d;
        if (r72 != null) goto L215;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r72 = null;
    L215:
        SimpleDraweeView r73 = r72.f;
        if (this.A != null) goto L218;
        LinearLayout.LayoutParams r74 = new LinearLayout.LayoutParams(-2, -2);
    L227:
        r74.topMargin = c7.b(25);
        r73.setLayoutParams(r74);
        if (this.z == null) goto L237;
        LarusAccessibilityDialogCommonBinding r75 = this.d;
        if (r75 != null) goto L232;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r75 = null;
    L232:
        ImageLoaderKt.s(r75.f, this.z, null);
        Float r76 = this.B;
        if (r76 == null) goto L235;
        float r77 = r76.floatValue();
    L236:
        r73.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r77));
        goto L237
    L235:
        r77 = 0.0f;
        goto L236
    L218:
        Size r78 = this.A;
        if (r78 == null) goto L221;
        Integer r80 = Integer.valueOf(r78.getWidth());
    L222:
        Intrinsics.checkNotNull(r80);
        int r81 = r80.intValue();
        Size r82 = this.A;
        if (r82 == null) goto L225;
        Integer r83 = Integer.valueOf(r82.getHeight());
    L226:
        Intrinsics.checkNotNull(r83);
        r74 = new LinearLayout.LayoutParams(r81, r83.intValue());
        goto L227
    L225:
        r83 = null;
        goto L226
    L221:
        r80 = null;
    L237:
        LarusAccessibilityDialogCommonBinding r84 = this.d;
        if (r84 != null) goto L240;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L241:
        ConstraintLayout r85 = r10.a;
        if (r85 == null) goto L250;
        Context r86 = r85.getContext();
        if (r86 == null) goto L248;
        String r87 = r86.getString(2131898809);
        if (r87 == null) goto L248;
    L249:
        r85.setContentDescription(r87);
        com.larus.utils.e1.d(r85, new e(this));
    L248:
        r87 = "";
    L250:
        Dialog r88 = getDialog();
        if (r88 == null) goto L253;
        r88.setCanceledOnTouchOutside(this.t);
    L253:
        Dialog r90 = getDialog();
        if (r90 == null) goto L265;
        Window r91 = r90.getWindow();
        if (r91 == null) goto L266;
        View r92 = r91.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L262;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r93 = ThreadMethodProxy.currentThread();
        if (r93 == com.larus.home.impl.utils.c.a) goto L262;
        com.larus.home.impl.utils.c.a(r93, "getDecorView");
    L262:
        if (r92 == null) goto L267;
        r92.setOnTouchListener(new a(this));
        return;
    L267:
        return;
    L266:
        return;
    L265:
        return;
    L240:
        r10 = r84;
        goto L241
    L91:
        String r94 = this.o;
        if (r94 != null) goto L94;
    L97:
        boolean r95 = true;
    L98:
        if (r95 == true) goto L103;
        LarusAccessibilityDialogCommonBinding r96 = this.d;
        if (r96 != null) goto L102;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r96 = null;
    L102:
        r96.b.setText(this.o);
    L103:
        LarusAccessibilityDialogCommonBinding r97 = this.d;
        if (r97 != null) goto L106;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r97 = null;
    L106:
        r97.b.setOnClickListener(new d(this));
        goto L108
    L94:
        if (r94.length() == 0) goto L97;
        r95 = false;
        goto L98
    L66:
        LarusAccessibilityDialogCommonBinding r98 = this.d;
        if (r98 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r98 = null;
    L69:
        r98.c.setTextColor(this.j);
        goto L71
    L49:
        if (r23.length() == 0) goto L52;
        r24 = false;
        goto L53
    L18:
        if (r14.length() == 0) goto L21;
        r15 = false;
        goto L23
    L11:
        r1 = 8;
        goto L12
    }

    public final View onCreateView(LayoutInflater r10, ViewGroup r11, Bundle r12) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        ConstraintLayout r13 = r10.inflate(2131561760, r11, false);
        int r14 = 2131365114;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r13, 2131365114);
        if (r3 == null) goto L34;
        r14 = 2131367639;
        TextView r4 = (TextView) ViewBindings.findChildViewById(r13, 2131367639);
        if (r4 == null) goto L34;
        r14 = 2131368971;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r13, 2131368971);
        if (r5 == null) goto L34;
        r14 = 2131368982;
        TextView r6 = (TextView) ViewBindings.findChildViewById(r13, 2131368982);
        if (r6 == null) goto L34;
        r14 = 2131368985;
        SimpleDraweeView r7 = ViewBindings.findChildViewById(r13, 2131368985);
        if (r7 == null) goto L34;
        r14 = 2131369197;
        View r8 = ViewBindings.findChildViewById(r13, 2131369197);
        if (r8 == null) goto L34;
        ConstraintLayout r15 = r13;
        this.d = new LarusAccessibilityDialogCommonBinding(r15, r3, r4, r5, r6, r7, r8);
        if (this.y == false) goto L21;
        Dialog r16 = getDialog();
        if (r16 == null) goto L28;
        Window r17 = r16.getWindow();
        if (r17 == null) goto L28;
        r17.setBackgroundDrawable(new ColorDrawable(0));
    L28:
        this.D = r15;
        if (this.C == false) goto L32;
        if (r15 == null) goto L32;
        com.larus.utils.e1.o(r15);
    L32:
        return r15;
    L21:
        Context r18 = getContext();
        if (r18 == null) goto L28;
        Dialog r110 = getDialog();
        if (r110 == null) goto L28;
        Window r111 = r110.getWindow();
        if (r111 == null) goto L28;
        r111.setBackgroundDrawable(ContextCompat.getDrawable(r18, v19.c.b(2130970789, getContext(), 2131239539)));
    L34:
        throw new NullPointerException("Missing required view with ID: ".concat(r13.getResources().getResourceName(r14)));
    }
}
