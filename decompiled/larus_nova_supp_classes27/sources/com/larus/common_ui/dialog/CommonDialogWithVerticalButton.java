package com.larus.common_ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
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
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.viewbinding.ViewBindings;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_res.common_ui.databinding.LarusDialogWithVerticalButtonBinding;
import com.larus.image.loader.ImageLoaderKt;
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
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000\u0090\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001LB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00106\u001a\u000207H\u0016J$\u00108\u001a\u0002052\u0006\u00109\u001a\u00020:2\b\u0010;\u001a\u0004\u0018\u00010<2\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\u001a\u0010?\u001a\u0002072\u0006\u0010@\u001a\u0002052\b\u0010=\u001a\u0004\u0018\u00010>H\u0016J\b\u0010A\u001a\u000207H\u0002J\b\u0010B\u001a\u000207H\u0002J\b\u0010C\u001a\u000207H\u0002J\b\u0010D\u001a\u000207H\u0002J\u0010\u0010E\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010H\u001a\u0002072\u0006\u0010F\u001a\u00020GH\u0016J\b\u0010I\u001a\u000207H\u0002J\b\u0010J\u001a\u000207H\u0002J\b\u0010K\u001a\u000207H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001c\u0010\u001c\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010'\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010/X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00100\u001a\u0004\u0018\u000101X\u0082\u000e¢\u0006\u0004\n\u0002\u00102R\u000e\u00103\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M"}, d2 = {"Lcom/larus/common_ui/dialog/CommonDialogWithVerticalButton;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogWithVerticalButtonBinding;", "mTitle", "", "mShowMessage", "", "mMessage", "", "mMessageColor", "", "Ljava/lang/Integer;", "mButton1Text", "mButton1TextStyle", "Lcom/larus/common_ui/dialog/CommonDialogTextStyleConfig;", "mButton2Text", "mButton2TextStyle", "mButton3Text", "mButton3TextStyle", "mButton1ClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "getMButton1ClickListener", "()Lcom/larus/common_ui/dialog/ConfirmClickListener;", "setMButton1ClickListener", "(Lcom/larus/common_ui/dialog/ConfirmClickListener;)V", "mButton2ClickListener", "getMButton2ClickListener", "setMButton2ClickListener", "mButton3ClickListener", "getMButton3ClickListener", "setMButton3ClickListener", "mWhiteClickListener", "Lcom/larus/common_ui/dialog/WhiteClickListener;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mCanceledOnTouchOutside", "backListener", "Lkotlin/Function0;", "mMessageTestStyle", "needSetWindowTransparent", "useShadow", "mTopImageUrl", "Landroid/net/Uri;", "mTopImageSize", "Landroid/util/Size;", "mTopImageRadius", "", "Ljava/lang/Float;", "needResumeVisible", "dialogView", "Landroid/view/View;", "onResume", "", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "setUpMessageTextStyle", "setUpButton1TextStyle", "setUpButton2TextStyle", "setUpButton3TextStyle", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "setupView", "updateBottomButtonVisibility", "setTopImage", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonDialogWithVerticalButton extends DialogFragment {
    public static final /* synthetic */ int C = 0;
    public boolean A;
    public View B;
    public LarusDialogWithVerticalButtonBinding d;
    public String e;
    public boolean f;
    public CharSequence g;
    public Integer h;
    public String i;
    public f0 j;
    public String k;
    public f0 l;
    public String m;
    public f0 n;
    public p0 o;
    public p0 p;
    public p0 q;
    public l1 r;
    public DialogInterface.OnDismissListener s;
    public boolean t;
    public Function0<Boolean> u;
    public f0 v;
    public boolean w;
    public Uri x;
    public Size y;
    public Float z;

    public static final class a {
        public String a;
        public boolean b;
        public CharSequence c;
        public String d;
        public f0 e;
        public p0 f;
        public String g;
        public f0 h;
        public p0 i;
        public String j;
        public f0 k;
        public p0 l;
        public boolean m;

        public final CommonDialogWithVerticalButton a() {
            CommonDialogWithVerticalButton r0 = new CommonDialogWithVerticalButton();
            r0.e = this.a;
            r0.g = this.c;
            r0.h = null;
            r0.i = this.d;
            r0.j = this.e;
            r0.o = this.f;
            r0.k = this.g;
            r0.l = this.h;
            r0.p = this.i;
            r0.m = this.j;
            r0.n = this.k;
            r0.q = this.l;
            r0.r = null;
            r0.s = null;
            r0.t = this.m;
            r0.u = null;
            r0.v = null;
            r0.w = true;
            r0.x = null;
            r0.y = null;
            r0.z = null;
            r0.A = false;
            r0.f = this.b;
            return r0;
        }

        public a() {
            this.a = "";
            this.b = true;
            this.m = true;
        }
    }

    public CommonDialogWithVerticalButton() {
        this.e = "";
        this.f = true;
        this.g = "";
        this.t = true;
        this.w = true;
    }

    public final void onResume() {
        super/*androidx.fragment.app.Fragment*/.onResume();
        Dialog r0 = getDialog();
        if (r0 == null) goto L11;
        Window r1 = r0.getWindow();
        if (r1 == null) goto L11;
        r1.setLayout(-1, -2);
        WindowManager.LayoutParams r2 = r1.getAttributes();
        Resources r3 = r1.getWindowStyle().getResources();
        int r4 = WindowDisplayMetricsOverride.apply(r3, r3.getDisplayMetrics()).widthPixels - (i5.d0() * 2);
        r2.width = r4;
        if (r4 <= i5.L()) goto L9;
        r2.width = i5.L();
    L9:
        r1.setAttributes(r2);
    L11:
        if (this.A == false) goto L15;
        View r5 = this.B;
        if (r5 == null) goto L15;
        com.larus.utils.e1.x(r5);
    L15:
        final Function0<Boolean> r6 = this.u;
        if (r6 == null) goto L21;
        Dialog r7 = getDialog();
        if (r7 == null) goto L22;
        r7.setOnKeyListener(new h0(r6));
        return;
    L22:
        return;
    }

    public static void S90(CommonDialogWithVerticalButton r1) {
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
        DialogInterface.OnDismissListener r0 = this.s;     // Catch: Throwable -> L7
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

    public final void onViewCreated(View r9, Bundle r10) {
        Intrinsics.checkNotNullParameter(r9, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r9, r10);
        LarusDialogWithVerticalButtonBinding r11 = this.d;
        LarusDialogWithVerticalButtonBinding r12 = null;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r11 = null;
    L5:
        r11.i.setText(this.e);
        LarusDialogWithVerticalButtonBinding r13 = this.d;
        if (r13 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r13 = null;
    L8:
        TextView r14 = r13.h;
        if (this.f == false) goto L11;
        int r1 = 0;
    L12:
        r14.setVisibility(r1);
        LarusDialogWithVerticalButtonBinding r15 = this.d;
        if (r15 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r15 = null;
    L15:
        r15.h.setText(this.g);
        String r16 = this.e;
        boolean r2 = true;
        if (r16 != null) goto L18;
    L21:
        boolean r17 = true;
    L23:
        if (r17 == false) goto L32;
        LarusDialogWithVerticalButtonBinding r18 = this.d;
        if (r18 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r18 = null;
    L27:
        r18.i.setVisibility(8);
        LinearLayout.LayoutParams r20 = new LinearLayout.LayoutParams(-1, -2);
        r20.topMargin = i5.E();
        r20.leftMargin = i5.A();
        r20.rightMargin = i5.A();
        LarusDialogWithVerticalButtonBinding r5 = this.d;
        if (r5 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L30:
        r5.h.setLayoutParams(r20);
    L32:
        if ((this.g instanceof SpannableString) == false) goto L40;
        LarusDialogWithVerticalButtonBinding r21 = this.d;
        if (r21 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L36:
        r21.h.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogWithVerticalButtonBinding r22 = this.d;
        if (r22 != null) goto L39;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r22 = null;
    L39:
        r22.h.setHighlightColor(0);
    L40:
        Integer r23 = this.h;
        if (r23 == null) goto L46;
        int r24 = r23.intValue();
        LarusDialogWithVerticalButtonBinding r6 = this.d;
        if (r6 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L45:
        r6.h.setTextColor(r24);
    L46:
        String r25 = this.i;
        if (r25 != null) goto L49;
    L52:
        boolean r26 = true;
    L53:
        if (r26 == true) goto L58;
        LarusDialogWithVerticalButtonBinding r27 = this.d;
        if (r27 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r27 = null;
    L57:
        r27.b.setText(this.i);
    L58:
        LarusDialogWithVerticalButtonBinding r28 = this.d;
        if (r28 != null) goto L61;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L61:
        r28.b.setOnClickListener(new i0(this));
        String r30 = this.k;
        if (r30 != null) goto L64;
    L67:
        boolean r31 = true;
    L68:
        if (r31 == true) goto L73;
        LarusDialogWithVerticalButtonBinding r32 = this.d;
        if (r32 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r32 = null;
    L72:
        r32.d.setText(this.k);
    L73:
        LarusDialogWithVerticalButtonBinding r33 = this.d;
        if (r33 != null) goto L76;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L76:
        r33.d.setOnClickListener(new j0(this));
        String r34 = this.m;
        if (r34 != null) goto L79;
    L82:
        if (r2 == true) goto L87;
        LarusDialogWithVerticalButtonBinding r35 = this.d;
        if (r35 != null) goto L86;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L86:
        r35.f.setText(this.m);
    L87:
        LarusDialogWithVerticalButtonBinding r36 = this.d;
        if (r36 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r36 = null;
    L90:
        r36.f.setOnClickListener(new k0(this));
        f0 r37 = this.v;
        if (r37 == null) goto L110;
        Integer r3 = r37.a;
        if (r3 == null) goto L98;
        int r4 = r3.intValue();
        LarusDialogWithVerticalButtonBinding r7 = this.d;
        if (r7 != null) goto L97;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L97:
        r7.h.setTextSize(r4);
    L98:
        Integer r8 = r37.b;
        if (r8 == null) goto L104;
        int r38 = r8.intValue();
        LarusDialogWithVerticalButtonBinding r40 = this.d;
        if (r40 != null) goto L103;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r40 = null;
    L103:
        r40.h.setTextColor(r38);
    L104:
        Typeface r41 = r37.c;
        if (r41 == null) goto L110;
        LarusDialogWithVerticalButtonBinding r42 = this.d;
        if (r42 != null) goto L109;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r42 = null;
    L109:
        r42.h.setTypeface(r41);
    L110:
        f0 r43 = this.j;
        if (r43 == null) goto L130;
        Integer r44 = r43.a;
        if (r44 == null) goto L118;
        int r45 = r44.intValue();
        LarusDialogWithVerticalButtonBinding r46 = this.d;
        if (r46 != null) goto L117;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r46 = null;
    L117:
        r46.b.setTextSize(r45);
    L118:
        Integer r47 = r43.b;
        if (r47 == null) goto L124;
        int r48 = r47.intValue();
        LarusDialogWithVerticalButtonBinding r50 = this.d;
        if (r50 != null) goto L123;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r50 = null;
    L123:
        r50.b.setTextColor(r48);
    L124:
        Typeface r51 = r43.c;
        if (r51 == null) goto L130;
        LarusDialogWithVerticalButtonBinding r52 = this.d;
        if (r52 != null) goto L129;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r52 = null;
    L129:
        r52.b.setTypeface(r51);
    L130:
        f0 r53 = this.l;
        if (r53 == null) goto L150;
        Integer r54 = r53.a;
        if (r54 == null) goto L138;
        int r55 = r54.intValue();
        LarusDialogWithVerticalButtonBinding r56 = this.d;
        if (r56 != null) goto L137;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r56 = null;
    L137:
        r56.d.setTextSize(r55);
    L138:
        Integer r57 = r53.b;
        if (r57 == null) goto L144;
        int r58 = r57.intValue();
        LarusDialogWithVerticalButtonBinding r60 = this.d;
        if (r60 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r60 = null;
    L143:
        r60.d.setTextColor(r58);
    L144:
        Typeface r61 = r53.c;
        if (r61 == null) goto L150;
        LarusDialogWithVerticalButtonBinding r62 = this.d;
        if (r62 != null) goto L149;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r62 = null;
    L149:
        r62.d.setTypeface(r61);
    L150:
        f0 r63 = this.n;
        if (r63 == null) goto L171;
        Integer r64 = r63.a;
        if (r64 == null) goto L158;
        int r65 = r64.intValue();
        LarusDialogWithVerticalButtonBinding r66 = this.d;
        if (r66 != null) goto L157;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r66 = null;
    L157:
        r66.f.setTextSize(r65);
    L158:
        Integer r67 = r63.b;
        if (r67 == null) goto L164;
        int r68 = r67.intValue();
        LarusDialogWithVerticalButtonBinding r70 = this.d;
        if (r70 != null) goto L163;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r70 = null;
    L163:
        r70.f.setTextColor(r68);
    L164:
        Typeface r71 = r63.c;
        if (r71 == null) goto L171;
        LarusDialogWithVerticalButtonBinding r72 = this.d;
        if (r72 != null) goto L169;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r72 = null;
    L169:
        r72.f.setTypeface(r71);
    L171:
        if (this.x == null) goto L200;
        LarusDialogWithVerticalButtonBinding r73 = this.d;
        if (r73 != null) goto L175;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r73 = null;
    L175:
        com.larus.utils.e1.x(r73.j);
        LarusDialogWithVerticalButtonBinding r74 = this.d;
        if (r74 != null) goto L178;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r74 = null;
    L178:
        SimpleDraweeView r75 = r74.j;
        if (this.y != null) goto L181;
        LinearLayout.LayoutParams r76 = new LinearLayout.LayoutParams(-2, -2);
    L190:
        r76.topMargin = c7.b(25);
        r75.setLayoutParams(r76);
        if (this.x == null) goto L200;
        LarusDialogWithVerticalButtonBinding r77 = this.d;
        if (r77 != null) goto L195;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r77 = null;
    L195:
        ImageLoaderKt.s(r77.j, this.x, null);
        Float r78 = this.z;
        if (r78 == null) goto L198;
        float r80 = r78.floatValue();
    L199:
        r75.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r80));
        goto L200
    L198:
        r80 = 0.0f;
        goto L199
    L181:
        Size r81 = this.y;
        if (r81 == null) goto L184;
        Integer r82 = Integer.valueOf(r81.getWidth());
    L185:
        Intrinsics.checkNotNull(r82);
        int r83 = r82.intValue();
        Size r84 = this.y;
        if (r84 == null) goto L188;
        Integer r85 = Integer.valueOf(r84.getHeight());
    L189:
        Intrinsics.checkNotNull(r85);
        r76 = new LinearLayout.LayoutParams(r83, r85.intValue());
        goto L190
    L188:
        r85 = null;
        goto L189
    L184:
        r82 = null;
    L200:
        LarusDialogWithVerticalButtonBinding r86 = this.d;
        if (r86 != null) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
    L205:
        if (com.larus.utils.o0.d(this.i) == false) goto L215;
        r12.b.setVisibility(0);
        r12.c.setVisibility(0);
        Context r87 = getContext();
        if (r87 == null) goto L217;
        if (com.larus.utils.o0.d(this.k) == false) goto L211;
    L214:
        r12.b.setBackground(ContextCompat.getDrawable(r87, v19.c.b(2130970621, r87, 2131238859)));
        goto L217
    L211:
        if (com.larus.utils.o0.d(this.m) == true) goto L214;
        r12.b.setBackground(ContextCompat.getDrawable(r87, v19.c.b(2130970618, r87, 2131238849)));
    L217:
        if (com.larus.utils.o0.d(this.k) == false) goto L224;
        r12.d.setVisibility(0);
        r12.e.setVisibility(0);
        Context r88 = getContext();
        if (r88 == null) goto L226;
        if (com.larus.utils.o0.d(this.m) == false) goto L223;
        r12.d.setBackground(ContextCompat.getDrawable(r88, v19.c.b(2130970621, r88, 2131238859)));
        goto L226
    L223:
        r12.d.setBackground(ContextCompat.getDrawable(r88, v19.c.b(2130970618, r88, 2131238849)));
    L226:
        if (com.larus.utils.o0.d(this.m) == false) goto L230;
        r12.f.setVisibility(0);
        r12.g.setVisibility(0);
        Context r90 = getContext();
        if (r90 == null) goto L231;
        r12.f.setBackground(ContextCompat.getDrawable(r90, v19.c.b(2130970618, r90, 2131238849)));
    L231:
        Dialog r91 = getDialog();
        if (r91 == null) goto L234;
        r91.setCanceledOnTouchOutside(this.t);
    L234:
        Dialog r92 = getDialog();
        if (r92 == null) goto L246;
        Window r93 = r92.getWindow();
        if (r93 == null) goto L247;
        View r94 = r93.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L243;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r110 = ThreadMethodProxy.currentThread();
        if (r110 == com.larus.home.impl.utils.c.a) goto L243;
        com.larus.home.impl.utils.c.a(r110, "getDecorView");
    L243:
        if (r94 == null) goto L248;
        r94.setOnTouchListener(new g0(this));
        return;
    L248:
        return;
    L247:
        return;
    L246:
        return;
    L230:
        r12.f.setVisibility(8);
        r12.g.setVisibility(8);
        goto L231
    L224:
        r12.d.setVisibility(8);
        r12.e.setVisibility(8);
        goto L226
    L215:
        r12.b.setVisibility(8);
        r12.c.setVisibility(8);
        goto L217
    L203:
        r12 = r86;
        goto L205
    L79:
        if (r34.length() == 0) goto L82;
        r2 = false;
        goto L82
    L64:
        if (r30.length() == 0) goto L67;
        r31 = false;
        goto L68
    L49:
        if (r25.length() == 0) goto L52;
        r26 = false;
        goto L53
    L18:
        if (r16.length() == 0) goto L21;
        r17 = false;
        goto L23
    L11:
        r1 = 8;
        goto L12
    }

    public final View onCreateView(LayoutInflater r13, ViewGroup r14, Bundle r15) {
        Intrinsics.checkNotNullParameter(r13, "inflater");
        View r16 = r13.inflate(2131562110, r14, false);
        int r17 = 2131368941;
        TextView r3 = (TextView) ViewBindings.findChildViewById(r16, 2131368941);
        if (r3 == null) goto L40;
        r17 = 2131368942;
        View r4 = ViewBindings.findChildViewById(r16, 2131368942);
        if (r4 == null) goto L40;
        r17 = 2131368943;
        TextView r5 = (TextView) ViewBindings.findChildViewById(r16, 2131368943);
        if (r5 == null) goto L40;
        r17 = 2131368944;
        View r6 = ViewBindings.findChildViewById(r16, 2131368944);
        if (r6 == null) goto L40;
        r17 = 2131368945;
        TextView r7 = (TextView) ViewBindings.findChildViewById(r16, 2131368945);
        if (r7 == null) goto L40;
        r17 = 2131368946;
        View r8 = ViewBindings.findChildViewById(r16, 2131368946);
        if (r8 == null) goto L40;
        r17 = 2131368971;
        TextView r9 = (TextView) ViewBindings.findChildViewById(r16, 2131368971);
        if (r9 == null) goto L40;
        r17 = 2131368982;
        TextView r10 = (TextView) ViewBindings.findChildViewById(r16, 2131368982);
        if (r10 == null) goto L40;
        r17 = 2131368985;
        SimpleDraweeView r11 = ViewBindings.findChildViewById(r16, 2131368985);
        if (r11 == null) goto L40;
        LarusDialogWithVerticalButtonBinding r18 = new LarusDialogWithVerticalButtonBinding((LinearLayout) r16, r3, r4, r5, r6, r7, r8, r9, r10, r11);
        this.d = r18;
        LinearLayout r110 = r18.a;
        if (this.w == false) goto L27;
        Dialog r111 = getDialog();
        if (r111 == null) goto L34;
        Window r112 = r111.getWindow();
        if (r112 == null) goto L34;
        r112.setBackgroundDrawable(new ColorDrawable(0));
    L34:
        this.B = r110;
        if (this.A == false) goto L38;
        if (r110 == null) goto L38;
        com.larus.utils.e1.o(r110);
    L38:
        return r110;
    L27:
        Context r113 = getContext();
        if (r113 == null) goto L34;
        Dialog r114 = getDialog();
        if (r114 == null) goto L34;
        Window r115 = r114.getWindow();
        if (r115 == null) goto L34;
        r115.setBackgroundDrawable(ContextCompat.getDrawable(r113, v19.c.b(2130970789, getContext(), 2131239539)));
    L40:
        throw new NullPointerException("Missing required view with ID: ".concat(r16.getResources().getResourceName(r17)));
    }
}
