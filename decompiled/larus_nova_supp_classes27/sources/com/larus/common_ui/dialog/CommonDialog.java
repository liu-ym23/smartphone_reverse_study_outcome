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
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.common_res.common_ui.databinding.LarusDialogCommonBinding;
import com.larus.image.loader.ImageLoaderKt;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricEnvService;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.landscape.childwindow.LandscapeChildDialogBoundsAdapter;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import v19.c7;
import v19.i5;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0001`B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010@\u001a\u00020A2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010D\u001a\u00020AH\u0016J$\u0010E\u001a\u00020\u00072\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010I2\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\u0010\u0010J\u001a\u00020\u00052\u0006\u0010K\u001a\u00020\u0007H\u0002J\u001a\u0010L\u001a\u00020A2\u0006\u0010M\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010CH\u0016J\b\u0010N\u001a\u00020AH\u0002J\u0018\u0010O\u001a\u00020A2\u0006\u0010P\u001a\u00020Q2\b\u0010R\u001a\u0004\u0018\u00010\u0012J\b\u0010S\u001a\u00020AH\u0002J\b\u0010T\u001a\u00020AH\u0002J\u0010\u0010U\u001a\u00020A2\u0006\u0010V\u001a\u00020WH\u0016J\u0010\u0010X\u001a\u00020A2\u0006\u0010V\u001a\u00020WH\u0016J\b\u0010Y\u001a\u00020AH\u0002J\u0018\u0010Z\u001a\u00020A2\u0006\u0010M\u001a\u00020\u00072\u0006\u0010[\u001a\u00020\u000eH\u0002J\b\u0010\\\u001a\u00020AH\u0002J\u0010\u0010]\u001a\u00020A2\u0006\u0010^\u001a\u00020\u000eH\u0002J\b\u0010_\u001a\u00020AH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001a\"\u0004\b\u001f\u0010\u001cR\u0010\u0010 \u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u0004\u0018\u00010-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00106\u001a\u0004\u0018\u000107X\u0082\u000e¢\u0006\u0004\n\u0002\u00108R\u000e\u00109\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u0004\u0018\u00010>X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006a"}, d2 = {"Lcom/larus/common_ui/dialog/CommonDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", "binding", "Lcom/larus/common_res/common_ui/databinding/LarusDialogCommonBinding;", "closeButtonView", "Landroid/view/View;", "mTitle", "", "mShowMessage", "", "mMessage", "mMessageColor", "", "Ljava/lang/Integer;", "mMessageGravity", "mConfirmText", "", "mConfirmTextColor", "mCancelTextColor", "mConfirmBold", "mCancelBold", "mConfirmClickListener", "Lcom/larus/common_ui/dialog/ConfirmClickListener;", "getMConfirmClickListener", "()Lcom/larus/common_ui/dialog/ConfirmClickListener;", "setMConfirmClickListener", "(Lcom/larus/common_ui/dialog/ConfirmClickListener;)V", "mEarlyConfirmClickListener", "getMEarlyConfirmClickListener", "setMEarlyConfirmClickListener", "mCancelText", "mCancelClickListener", "Lcom/larus/common_ui/dialog/CancelClickListener;", "mWhiteClickListener", "Lcom/larus/common_ui/dialog/WhiteClickListener;", "mOnDismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "mButtonTrim", "mCanceledOnTouchOutside", "mCancelable", "backListener", "Lkotlin/Function0;", "mMessageTestStyle", "Lcom/larus/common_ui/dialog/CommonDialogTextStyleConfig;", "mConfirmTextStyle", "mCancelTextStyle", "needSetWindowTransparent", "useShadow", "mTopImageUrl", "Landroid/net/Uri;", "mTopImageSize", "Landroid/util/Size;", "mTopImageRadius", "", "Ljava/lang/Float;", "needResumeVisible", "mDismissWhenConfirm", "mDismissWhenCancel", "mShowCloseButton", "mCloseClickListener", "Landroid/view/View$OnClickListener;", "dialogView", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "bindDialogContent", "rootView", "onViewCreated", "view", "setUpMessageTextStyle", "showAllowingStateLoss", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "tag", "setUpConfirmTextStyle", "setUpCancelTextStyle", "onCancel", "dialog", "Landroid/content/DialogInterface;", "onDismiss", "setupView", "updateBottomButtonVisibility", "visibility", "setupCloseButton", "updateTitleHorizontalMargin", "horizontalMargin", "setTopImage", "Builder", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CommonDialog extends DialogFragment {
    public static final /* synthetic */ int N = 0;
    public f0 A;
    public f0 B;
    public boolean C;
    public boolean D;
    public Uri E;
    public Size F;
    public Float G;
    public boolean H;
    public boolean I;
    public boolean J;
    public boolean K;
    public View.OnClickListener L;
    public View M;
    public LarusDialogCommonBinding d;
    public View e;
    public CharSequence f;
    public boolean g;
    public CharSequence h;
    public Integer i;
    public Integer j;
    public String k;
    public int l;
    public int m;
    public boolean n;
    public boolean o;
    public p0 p;
    public p0 q;
    public String r;
    public u s;
    public l1 t;
    public DialogInterface.OnDismissListener u;
    public boolean v;
    public boolean w;
    public boolean x;
    public Function0<Boolean> y;
    public f0 z;

    public static final class a {
        public boolean A;
        public Function0<Boolean> B;
        public f0 C;
        public f0 D;
        public f0 E;
        public boolean F;
        public boolean G;
        public CharSequence a;
        public boolean b;
        public Float c;
        public boolean d;
        public Uri e;
        public Size f;
        public boolean g;
        public View.OnClickListener h;
        public CharSequence i;
        public Integer j;
        public Integer k;
        public String l;
        public boolean m;
        public p0 n;
        public p0 o;
        public boolean p;
        public int q;
        public int r;
        public String s;
        public boolean t;
        public u u;
        public l1 v;
        public boolean w;
        public DialogInterface.OnDismissListener x;
        public boolean y;
        public boolean z;

        public final CommonDialog a() {
            CommonDialog r0 = new CommonDialog();
            r0.f = this.a;
            r0.h = this.i;
            r0.i = this.j;
            r0.j = this.k;
            r0.k = this.l;
            r0.p = this.n;
            r0.q = this.o;
            r0.n = this.m;
            r0.o = this.t;
            r0.l = this.q;
            r0.m = this.r;
            r0.r = this.s;
            r0.s = this.u;
            r0.t = this.v;
            r0.v = this.w;
            r0.u = this.x;
            r0.w = this.z;
            r0.x = this.A;
            r0.y = this.B;
            r0.z = this.C;
            r0.A = this.D;
            r0.B = this.E;
            r0.C = this.F;
            r0.D = this.G;
            r0.E = this.e;
            r0.F = this.f;
            r0.G = this.c;
            r0.H = this.d;
            r0.g = this.b;
            r0.I = this.p;
            r0.J = this.y;
            r0.K = this.g;
            r0.L = this.h;
            return r0;
        }

        public a() {
            this.b = true;
            this.p = true;
            this.y = true;
            this.z = true;
            this.A = true;
            this.F = true;
        }

        public final CommonDialog c() {
            CommonDialog r0 = a();
            r0.g = false;
            return r0;
        }

        public final CommonDialog b(int r2) {
            CommonDialog r0 = a();
            r0.l = r2;
            return r0;
        }

        public final CommonDialog d(int r2) {
            CommonDialog r0 = a();
            r0.l = r2;
            r0.g = false;
            return r0;
        }

        public final void g(CharSequence r2) {
            Intrinsics.checkNotNullParameter(r2, "message");
            this.i = r2;
        }

        public final void h(int r1) {
            this.j = Integer.valueOf(r1);
        }

        public final void i(CharSequence r2) {
            Intrinsics.checkNotNullParameter(r2, "title");
            this.a = r2;
        }

        public static void e(a r1, u r2, String r3, int r4) {
            if ((r4 & 2) == 0) goto L6;
            r3 = null;
        L6:
            if ((r4 & 4) == 0) goto L8;
            boolean r5 = true;
        L9:
            Intrinsics.checkNotNullParameter(r2, "listener");
            r1.s = r3;
            r1.u = r2;
            r1.y = r5;
            return;
        L8:
            r5 = false;
            goto L9
        }

        public static void f(a r2, p0 r3, String r4, boolean r5, int r6) {
            if ((r6 & 2) == 0) goto L5;
            r4 = null;
        L5:
            boolean r1 = false;
            if ((r6 & 4) == 0) goto L9;
            r5 = false;
        L9:
            if ((r6 & 8) == 0) goto L11;
            r1 = true;
        L11:
            Intrinsics.checkNotNullParameter(r3, "listener");
            r2.l = r4;
            if (r5 == false) goto L14;
            r2.o = r3;
        L15:
            r2.p = r1;
            return;
        L14:
            r2.n = r3;
            goto L15
        }
    }

    public CommonDialog() {
        this.f = "";
        this.g = true;
        this.h = "";
        this.w = true;
        this.x = true;
        this.C = true;
        this.I = true;
        this.J = true;
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
        if (this.H == false) goto L15;
        View r5 = this.M;
        if (r5 == null) goto L15;
        com.larus.utils.e1.x(r5);
    L15:
        final Function0<Boolean> r6 = this.y;
        if (r6 == null) goto L21;
        Dialog r7 = getDialog();
        if (r7 == null) goto L22;
        r7.setOnKeyListener(new z(r6));
        return;
    L22:
        return;
    }

    public static void S90(CommonDialog r1) {
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

    public final void U90(View r5) {
        r5.setVisibility(8);
        LarusDialogCommonBinding r6 = this.d;
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

    /* JADX WARN: Type inference failed for: r0v1, types: [com.larus.common_ui.dialog.a0] */
    public final void onCreate(Bundle r2) {
        super.onCreate(r2);
        IObricEnvService r3 = (IObricEnvService) ServiceManager.get().getService(IObricEnvService.class);
        if (r3 == null) goto L6;
        r3.b(new a0(this));
        return;
    }

    public final void onDismiss(DialogInterface r2) {
        Intrinsics.checkNotNullParameter(r2, "dialog");     // Catch: Throwable -> L7
        super.onDismiss(r2);     // Catch: Throwable -> L7
        DialogInterface.OnDismissListener r0 = this.u;     // Catch: Throwable -> L7
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

    public final void T90(FragmentManager r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "fragmentManager");
        FragmentTransaction r5 = r3.beginTransaction();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r5, this, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_ADD, r4, 0) == true) goto L6;
        r5.add(this, r4);
    L6:
        r5.commitAllowingStateLoss();
    }

    public final void onViewCreated(View r8, Bundle r9) {
        Intrinsics.checkNotNullParameter(r8, "view");
        super/*androidx.fragment.app.Fragment*/.onViewCreated(r8, r9);
        LarusDialogCommonBinding r10 = this.d;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r10 = null;
    L5:
        r10.e.setText(this.f);
        View r11 = this.e;
        boolean r2 = false;
        if (r11 != null) goto L9;
    L24:
        LarusDialogCommonBinding r12 = this.d;
        if (r12 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r12 = null;
    L27:
        TextView r13 = r12.d;
        if (this.g == false) goto L30;
        int r3 = 0;
    L31:
        r13.setVisibility(r3);
        LarusDialogCommonBinding r14 = this.d;
        if (r14 != null) goto L34;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r14 = null;
    L34:
        r14.d.setText(this.h);
        CharSequence r15 = this.f;
        if (r15 != null) goto L37;
    L40:
        boolean r16 = true;
    L42:
        if (r16 == false) goto L51;
        LarusDialogCommonBinding r17 = this.d;
        if (r17 != null) goto L46;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r17 = null;
    L46:
        r17.e.setVisibility(8);
        LinearLayout.LayoutParams r18 = new LinearLayout.LayoutParams(-1, -2);
        r18.topMargin = i5.E();
        r18.leftMargin = i5.A();
        r18.rightMargin = i5.A();
        LarusDialogCommonBinding r1 = this.d;
        if (r1 != null) goto L49;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r1 = null;
    L49:
        r1.d.setLayoutParams(r18);
    L51:
        if ((this.h instanceof SpannableString) == false) goto L59;
        LarusDialogCommonBinding r20 = this.d;
        if (r20 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r20 = null;
    L55:
        r20.d.setMovementMethod(LinkMovementMethod.getInstance());
        LarusDialogCommonBinding r21 = this.d;
        if (r21 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r21 = null;
    L58:
        r21.d.setHighlightColor(0);
    L59:
        Integer r22 = this.i;
        if (r22 == null) goto L65;
        int r23 = r22.intValue();
        LarusDialogCommonBinding r4 = this.d;
        if (r4 != null) goto L64;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r4 = null;
    L64:
        r4.d.setTextColor(r23);
    L65:
        Integer r24 = this.j;
        if (r24 == null) goto L71;
        int r25 = r24.intValue();
        LarusDialogCommonBinding r5 = this.d;
        if (r5 != null) goto L70;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r5 = null;
    L70:
        r5.d.setGravity(r25);
    L71:
        String r26 = this.k;
        if (r26 != null) goto L74;
    L77:
        boolean r27 = true;
    L78:
        if (r27 == true) goto L84;
        LarusDialogCommonBinding r28 = this.d;
        if (r28 != null) goto L82;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r28 = null;
    L82:
        r28.c.setText(this.k);
    L84:
        if (this.l != 0) goto L91;
        Context r30 = getContext();
        if (r30 == null) goto L96;
        LarusDialogCommonBinding r6 = this.d;
        if (r6 != null) goto L90;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r6 = null;
    L90:
        r6.c.setTextColor(ContextCompat.getColor(r30, 2131102650));
    L96:
        if (this.n == false) goto L102;
        LarusDialogCommonBinding r31 = this.d;
        if (r31 != null) goto L100;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r31 = null;
    L100:
        r31.c.setTypeface(Typeface.DEFAULT_BOLD);
    L102:
        if (this.m != 0) goto L109;
        Context r32 = getContext();
        if (r32 == null) goto L114;
        LarusDialogCommonBinding r7 = this.d;
        if (r7 != null) goto L108;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r7 = null;
    L108:
        r7.b.setTextColor(ContextCompat.getColor(r32, v19.c.b(2130972079, r32, 2131103136)));
    L114:
        if (this.o == false) goto L119;
        LarusDialogCommonBinding r33 = this.d;
        if (r33 != null) goto L118;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r33 = null;
    L118:
        r33.b.setTypeface(Typeface.DEFAULT_BOLD);
    L119:
        LarusDialogCommonBinding r34 = this.d;
        if (r34 != null) goto L122;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r34 = null;
    L122:
        r34.c.setOnClickListener(new b0(this));
        if (this.s != null) goto L128;
        LarusDialogCommonBinding r35 = this.d;
        if (r35 != null) goto L127;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r35 = null;
    L127:
        U90(r35.b);
    L145:
        if (this.v == false) goto L184;
        String r36 = this.k;
        if (r36 != null) goto L149;
    L152:
        boolean r37 = true;
    L153:
        if (r37 == true) goto L162;
        String r38 = this.r;
        if (r38 != null) goto L157;
    L160:
        boolean r40 = true;
    L161:
        if (r40 == false) goto L184;
    L157:
        if (r38.length() == 0) goto L160;
        r40 = false;
    L162:
        String r41 = this.k;
        if (r41 != null) goto L165;
    L168:
        boolean r42 = true;
    L169:
        if (r42 == false) goto L174;
        LarusDialogCommonBinding r43 = this.d;
        if (r43 != null) goto L173;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r43 = null;
    L173:
        U90(r43.c);
    L174:
        String r44 = this.r;
        if (r44 != null) goto L177;
    L178:
        r2 = true;
    L179:
        if (r2 == false) goto L184;
        LarusDialogCommonBinding r45 = this.d;
        if (r45 != null) goto L183;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r45 = null;
    L183:
        U90(r45.b);
        goto L184
    L177:
        if (r44.length() != 0) goto L179;
    L165:
        if (r41.length() == 0) goto L168;
        r42 = false;
        goto L169
    L149:
        if (r36.length() == 0) goto L152;
        r37 = false;
    L184:
        f0 r46 = this.z;
        if (r46 == null) goto L204;
        Integer r47 = r46.a;
        if (r47 == null) goto L192;
        int r48 = r47.intValue();
        LarusDialogCommonBinding r50 = this.d;
        if (r50 != null) goto L191;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r50 = null;
    L191:
        r50.d.setTextSize(r48);
    L192:
        Integer r51 = r46.b;
        if (r51 == null) goto L198;
        int r52 = r51.intValue();
        LarusDialogCommonBinding r53 = this.d;
        if (r53 != null) goto L197;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r53 = null;
    L197:
        r53.d.setTextColor(r52);
    L198:
        Typeface r54 = r46.c;
        if (r54 == null) goto L204;
        LarusDialogCommonBinding r55 = this.d;
        if (r55 != null) goto L203;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r55 = null;
    L203:
        r55.d.setTypeface(r54);
    L204:
        f0 r56 = this.A;
        if (r56 == null) goto L224;
        Integer r57 = r56.a;
        if (r57 == null) goto L212;
        int r58 = r57.intValue();
        LarusDialogCommonBinding r60 = this.d;
        if (r60 != null) goto L211;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r60 = null;
    L211:
        r60.c.setTextSize(r58);
    L212:
        Integer r61 = r56.b;
        if (r61 == null) goto L218;
        int r62 = r61.intValue();
        LarusDialogCommonBinding r63 = this.d;
        if (r63 != null) goto L217;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r63 = null;
    L217:
        r63.c.setTextColor(r62);
    L218:
        Typeface r64 = r56.c;
        if (r64 == null) goto L224;
        LarusDialogCommonBinding r65 = this.d;
        if (r65 != null) goto L223;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r65 = null;
    L223:
        r65.c.setTypeface(r64);
    L224:
        f0 r66 = this.B;
        if (r66 == null) goto L245;
        Integer r67 = r66.a;
        if (r67 == null) goto L232;
        int r68 = r67.intValue();
        LarusDialogCommonBinding r70 = this.d;
        if (r70 != null) goto L231;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r70 = null;
    L231:
        r70.b.setTextSize(r68);
    L232:
        Integer r71 = r66.b;
        if (r71 == null) goto L238;
        int r72 = r71.intValue();
        LarusDialogCommonBinding r73 = this.d;
        if (r73 != null) goto L237;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r73 = null;
    L237:
        r73.b.setTextColor(r72);
    L238:
        Typeface r74 = r66.c;
        if (r74 == null) goto L245;
        LarusDialogCommonBinding r75 = this.d;
        if (r75 != null) goto L243;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r75 = null;
    L243:
        r75.b.setTypeface(r74);
    L245:
        if (this.E == null) goto L274;
        LarusDialogCommonBinding r76 = this.d;
        if (r76 != null) goto L249;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r76 = null;
    L249:
        com.larus.utils.e1.x(r76.f);
        LarusDialogCommonBinding r77 = this.d;
        if (r77 != null) goto L252;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r77 = null;
    L252:
        SimpleDraweeView r78 = r77.f;
        if (this.F != null) goto L255;
        LinearLayout.LayoutParams r80 = new LinearLayout.LayoutParams(-2, -2);
    L264:
        r80.topMargin = c7.b(25);
        r78.setLayoutParams(r80);
        if (this.E == null) goto L274;
        LarusDialogCommonBinding r81 = this.d;
        if (r81 != null) goto L269;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r81 = null;
    L269:
        ImageLoaderKt.s(r81.f, this.E, null);
        Float r82 = this.G;
        if (r82 == null) goto L272;
        float r83 = r82.floatValue();
    L273:
        r78.getHierarchy().setRoundingParams(RoundingParams.fromCornersRadius(r83));
        goto L274
    L272:
        r83 = 0.0f;
        goto L273
    L255:
        Size r84 = this.F;
        if (r84 == null) goto L258;
        Integer r85 = Integer.valueOf(r84.getWidth());
    L259:
        Intrinsics.checkNotNull(r85);
        int r86 = r85.intValue();
        Size r87 = this.F;
        if (r87 == null) goto L262;
        Integer r88 = Integer.valueOf(r87.getHeight());
    L263:
        Intrinsics.checkNotNull(r88);
        r80 = new LinearLayout.LayoutParams(r86, r88.intValue());
        goto L264
    L262:
        r88 = null;
        goto L263
    L258:
        r85 = null;
    L274:
        Dialog r90 = getDialog();
        if (r90 == null) goto L277;
        r90.setCanceledOnTouchOutside(this.w);
        r90.setCancelable(this.x);
    L277:
        Dialog r91 = getDialog();
        if (r91 == null) goto L289;
        Window r92 = r91.getWindow();
        if (r92 == null) goto L290;
        View r93 = r92.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L286;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r94 = ThreadMethodProxy.currentThread();
        if (r94 == com.larus.home.impl.utils.c.a) goto L286;
        com.larus.home.impl.utils.c.a(r94, "getDecorView");
    L286:
        if (r93 == null) goto L291;
        r93.setOnTouchListener(new y(this));
        return;
    L291:
        return;
    L290:
        return;
    L289:
        return;
    L128:
        String r95 = this.r;
        if (r95 != null) goto L131;
    L134:
        boolean r96 = true;
    L135:
        if (r96 == true) goto L140;
        LarusDialogCommonBinding r97 = this.d;
        if (r97 != null) goto L139;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r97 = null;
    L139:
        r97.b.setText(this.r);
    L140:
        LarusDialogCommonBinding r98 = this.d;
        if (r98 != null) goto L143;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r98 = null;
    L143:
        r98.b.setOnClickListener(new c0(this));
        goto L145
    L131:
        if (r95.length() == 0) goto L134;
        r96 = false;
        goto L135
    L109:
        LarusDialogCommonBinding r100 = this.d;
        if (r100 != null) goto L112;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r100 = null;
    L112:
        r100.b.setTextColor(this.m);
        goto L114
    L91:
        LarusDialogCommonBinding r101 = this.d;
        if (r101 != null) goto L94;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r101 = null;
    L94:
        r101.c.setTextColor(this.l);
        goto L96
    L74:
        if (r26.length() == 0) goto L77;
        r27 = false;
        goto L78
    L37:
        if (r15.length() == 0) goto L40;
        r16 = false;
        goto L42
    L30:
        r3 = 8;
        goto L31
    L9:
        if (this.K == true) goto L11;
        r11.setVisibility(8);
        r11.setOnClickListener(null);
        goto L24
    L11:
        r11.setVisibility(0);
        int r102 = i5.d0();
        LarusDialogCommonBinding r103 = this.d;
        if (r103 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r103 = null;
    L14:
        ViewGroup.LayoutParams r104 = r103.e.getLayoutParams();
        if ((r104 instanceof ViewGroup.MarginLayoutParams) == false) goto L17;
        ViewGroup.MarginLayoutParams r105 = (ViewGroup.MarginLayoutParams) r104;
    L18:
        if (r105 == null) goto L23;
        r105.setMarginStart(r102);
        r105.setMarginEnd(r102);
        LarusDialogCommonBinding r106 = this.d;
        if (r106 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        r106 = null;
    L22:
        r106.e.setLayoutParams(r105);
    L23:
        r11.setOnClickListener(new d0(this));
        int r107 = c7.b(8);
        com.larus.utils.e1.g(r11, r107, r107, r107, r107);
        goto L24
    L17:
        r105 = null;
        goto L18
    }

    public final View onCreateView(LayoutInflater r4, ViewGroup r5, Bundle r6) {
        Intrinsics.checkNotNullParameter(r4, "inflater");
        if (this.D == false) goto L17;
        if (this.K == false) goto L11;
        CardView r7 = r4.inflate(2131562049, r5, false);
        View r8 = r7.findViewById(2131368954);
        if (r8 == null) goto L10;
        this.d = LarusDialogCommonBinding.a(r8);
    L24:
        this.e = r7.findViewById(2131368952);
        if (this.C == false) goto L31;
        Dialog r9 = getDialog();
        if (r9 == null) goto L38;
        Window r10 = r9.getWindow();
        if (r10 == null) goto L38;
        r10.setBackgroundDrawable(new ColorDrawable(0));
    L38:
        this.M = r7;
        if (this.H == false) goto L41;
        com.larus.utils.e1.o(r7);
    L41:
        return r7;
    L31:
        Context r11 = getContext();
        if (r11 == null) goto L38;
        Dialog r12 = getDialog();
        if (r12 == null) goto L38;
        Window r13 = r12.getWindow();
        if (r13 == null) goto L38;
        r13.setBackgroundDrawable(ContextCompat.getDrawable(r11, v19.c.b(2130970789, getContext(), 2131239539)));
        goto L38
    L10:
        throw new IllegalArgumentException("Missing dialog content view for CommonDialog".toString());
    L11:
        CardView r14 = r4.inflate(2131562048, r5, false);
        if (r14 == null) goto L15;
        r7 = r14;
        this.d = LarusDialogCommonBinding.a(r7.getChildAt(0));
        goto L24
    L15:
        throw new NullPointerException("rootView");
    L17:
        if (this.K == false) goto L23;
        r7 = r4.inflate(2131562050, r5, false);
        View r15 = r7.findViewById(2131368954);
        if (r15 == null) goto L22;
        this.d = LarusDialogCommonBinding.a(r15);
        goto L24
    L22:
        throw new IllegalArgumentException("Missing dialog content view for CommonDialog".toString());
    L23:
        LarusDialogCommonBinding r16 = LarusDialogCommonBinding.a(r4.inflate(2131562044, r5, false));
        this.d = r16;
        r7 = r16.a;
        goto L24
    }
}
