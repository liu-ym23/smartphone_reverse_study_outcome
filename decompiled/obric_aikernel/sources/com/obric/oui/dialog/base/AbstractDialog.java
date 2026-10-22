package com.obric.oui.dialog.base;

import android.R;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.ImageView;
import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.obric.oui.common.util.f;
import com.obric.oui.common.util.g;
import com.obric.oui.common.util.k;
import com.obric.oui.dialog.alert.view.RadiusLayout;
import com.obric.oui.dialog.anim.DialogAnimStyle;
import com.ttnet.org.chromium.base.BaseSwitches;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.h;

/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(30)
public abstract class AbstractDialog extends Dialog {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f6490c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private View f6491g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ImageView f6492h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f6493i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public View f6494j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private CloseIconStyle f6495k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private View.OnClickListener f6496l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f6497m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f6498n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private boolean f6499o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final b f6500p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final boolean f6501q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final boolean f6502r;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/dialog/base/AbstractDialog$CloseIconStyle;", "", "<init>", "(Ljava/lang/String;I)V", "LIGHT", "DARK", "CUSTOM", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
    public static final enum CloseIconStyle extends Enum<CloseIconStyle> {
        private static final /* synthetic */ CloseIconStyle[] $VALUES = null;
        public static final CloseIconStyle CUSTOM = null;
        public static final CloseIconStyle DARK = null;
        public static final CloseIconStyle LIGHT = null;

        static {
            CloseIconStyle r10 = new CloseIconStyle("LIGHT", 0);
            LIGHT = r10;
            CloseIconStyle r11 = new CloseIconStyle("DARK", 1);
            DARK = r11;
            CloseIconStyle r12 = new CloseIconStyle("CUSTOM", 2);
            CUSTOM = r12;
            $VALUES = new CloseIconStyle[]{r10, r11, r12};
        }

        private CloseIconStyle(String r10, int r11) {
            super(r10, r11);
        }

        public static CloseIconStyle valueOf(String r10) {
            return (CloseIconStyle) Enum.valueOf(CloseIconStyle.class, r10);
        }

        public static CloseIconStyle[] values() {
            return (CloseIconStyle[]) $VALUES.clone();
        }
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public static final class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f6503a;

        b(AbstractDialog r10, Looper r11) {
            this.f6503a = r10;
            super(r11);
        }

        @Override // android.os.Handler
        public void handleMessage(Message r10) {
            Intrinsics.checkNotNullParameter(r10, NotificationCompat.CATEGORY_MESSAGE);
            super.handleMessage(r10);
            if (r10.what != 101) goto L6;
            AbstractDialog.e(this.f6503a);
            return;
        }
    }

    static final class c implements View.OnClickListener {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f6504c;

        c(AbstractDialog r10, boolean r11) {
            this.f6504c = r10;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r10) {
            this.f6504c.dismiss();
            View.OnClickListener r11 = AbstractDialog.c(this.f6504c);
            if (r11 == null) goto L6;
            r11.onClick(r10);
            return;
        }
    }

    static final class d implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ AbstractDialog f6505a;

        d(AbstractDialog r10) {
            this.f6505a = r10;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View r11, WindowInsets r12) {
            Intrinsics.checkNotNullParameter(r11, BaseSwitches.V);
            Intrinsics.checkNotNullParameter(r12, "insets");
            fa.a r10 = fa.a.f8880a;
            int r13 = r10.b(this.f6505a.getContext());
            int r14 = r10.a(this.f6505a.p());
            ea.b.i(AbstractDialog.d(this.f6505a), "onApplyWindowInsets, naviHeight: " + r13 + ", imeInsets: " + r14);
            Context r15 = this.f6505a.getContext();
            Intrinsics.checkNotNullExpressionValue(r15, "context");
            if (r14 >= f.d(r15)) goto L42;
            boolean r16 = true;
            Integer r17 = null;
            if (r14 <= 0) goto L20;
            if (this.f6505a.r() == false) goto L11;
            r11.setPadding(0, 0, 0, r14);
            String r18 = AbstractDialog.d(this.f6505a);
            StringBuilder r19 = new StringBuilder();
            r19.append("onApplyWindowInsets, update rootView.padding, bottomPadding: ");
        L9:
            r19.append(r14);
            String r20 = r19.toString();
        L10:
            ea.b.i(r18, r20);
            r16 = false;
        L31:
            if (r16 == false) goto L42;
            da.c r110 = da.c.f8520a;
            Object r111 = this.f6505a.p().getParent();
            if (r111 != null) goto L36;
        L34:
            r111 = null;
        L37:
            View r112 = (View) r111;
            String r21 = AbstractDialog.d(this.f6505a);
            StringBuilder r22 = new StringBuilder();
            r22.append("onApplyWindowInsets, post recheck, parentView.height: ");
            if (r112 == null) goto L40;
            r17 = Integer.valueOf(r112.getHeight());
        L40:
            r22.append(r17);
            r22.append(", rootView.height: ");
            r22.append(this.f6505a.p().getHeight());
            ea.b.i(r21, r22.toString());
            AbstractDialog.a(this.f6505a).removeMessages(101);
            AbstractDialog.a(this.f6505a).sendEmptyMessageDelayed(101, 200);
            goto L42
        L36:
            if ((r111 instanceof View) == false) goto L34;
        L11:
            View r113 = this.f6505a.p();
            ViewGroup.LayoutParams r23 = this.f6505a.p().getLayoutParams();
            if ((r23 instanceof ViewGroup.MarginLayoutParams) == true) goto L14;
            ViewGroup.LayoutParams r24 = null;
        L15:
            ViewGroup.MarginLayoutParams r25 = (ViewGroup.MarginLayoutParams) r24;
            if (r25 == null) goto L18;
            r25.bottomMargin = AbstractDialog.b(this.f6505a) + r14;
        L18:
            Unit r26 = Unit.INSTANCE;
            r113.setLayoutParams(r23);
            r18 = AbstractDialog.d(this.f6505a);
            r19 = new StringBuilder();
            r19.append("onApplyWindowInsets, update rootView.layoutParams, bottomMargin: ");
            Resources r27 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r27, "Resources.getSystem()");
            r14 = r14 + MathKt.roundToInt(TypedValue.applyDimension(1, 16, r27.getDisplayMetrics()));
            goto L9
        L14:
            r24 = r23;
            goto L15
        L20:
            if (this.f6505a.r() == false) goto L22;
            Resources r28 = Resources.getSystem();
            Intrinsics.checkNotNullExpressionValue(r28, "Resources.getSystem()");
            int r29 = r13 - MathKt.roundToInt(TypedValue.applyDimension(1, 16, r28.getDisplayMetrics()));
            this.f6505a.p().setPadding(0, 0, 0, r29);
            ea.b.i(AbstractDialog.d(this.f6505a), "onApplyWindowInsets, update rootView.padding, bottomPadding: " + r29);
            goto L31
        L22:
            View r114 = this.f6505a.p();
            ViewGroup.LayoutParams r30 = this.f6505a.p().getLayoutParams();
            if ((r30 instanceof ViewGroup.MarginLayoutParams) == true) goto L25;
            ViewGroup.LayoutParams r31 = null;
        L26:
            ViewGroup.MarginLayoutParams r32 = (ViewGroup.MarginLayoutParams) r31;
            if (r32 == null) goto L29;
            r32.bottomMargin = AbstractDialog.b(this.f6505a);
        L29:
            Unit r33 = Unit.INSTANCE;
            r114.setLayoutParams(r30);
            r18 = AbstractDialog.d(this.f6505a);
            r20 = "onApplyWindowInsets, update rootView.layoutParams, bottomMargin: " + r13;
            goto L10
        L25:
            r31 = r30;
        L42:
            return r12.consumeSystemWindowInsets();
        }
    }

    static {
        new a(null);
    }

    public AbstractDialog(Context r10, boolean r11, boolean r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10);
        this.f6501q = r11;
        this.f6502r = r12;
        this.f6490c = "AbstractDialog";
        this.f6495k = CloseIconStyle.DARK;
        this.f6499o = true;
        Window r13 = getWindow();
        if (r13 == null) goto L5;
        r13.requestFeature(1);
    L5:
        if (r12 == false) goto L7;
        int r14 = h.o_base_dialog_with_match_parent_height;
    L8:
        setContentView(r14);
        View r15 = findViewById(u8.f.root_view);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.root_view)");
        this.f6494j = r15;
        this.f6492h = (ImageView) findViewById(u8.f.btn_close);
        this.f6491g = findViewById(u8.f.close_container);
        if (r12 == false) goto L17;
        View r16 = this.f6494j;
        if (r16 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L13:
        View r17 = this.f6494j;
        if (r17 != null) goto L16;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L16:
        ViewGroup.LayoutParams r18 = r17.getLayoutParams();
        r18.height = -1;
        Unit r19 = Unit.INSTANCE;
        r16.setLayoutParams(r18);
    L17:
        y();
        x(this, this.f6493i, null, 2, null);
        ViewStub r20 = (ViewStub) findViewById(u8.f.contentView);
        Intrinsics.checkNotNullExpressionValue(r20, "viewStub");
        r20.setLayoutResource(l());
        r20.inflate();
        DialogAnimStyle r21 = DialogAnimStyle.f6478a;
        View r22 = this.f6494j;
        if (r22 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L20:
        r21.b(r22);
        this.f6500p = new b(this, Looper.getMainLooper());
        return;
    L7:
        r14 = h.o_base_dialog;
        goto L8
    }

    public static final /* synthetic */ b a(AbstractDialog r10) {
        return r10.f6500p;
    }

    public static final /* synthetic */ int b(AbstractDialog r10) {
        return r10.m();
    }

    public static final /* synthetic */ View.OnClickListener c(AbstractDialog r10) {
        return r10.f6496l;
    }

    public static final /* synthetic */ String d(AbstractDialog r10) {
        return r10.f6490c;
    }

    public static final /* synthetic */ void e(AbstractDialog r10) {
        r10.u();
    }

    public static /* synthetic */ void h(AbstractDialog r10, CloseIconStyle r11, Integer r12, Integer r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = null;
    L7:
        if ((r14 & 4) == 0) goto L9;
        r13 = null;
    L9:
        r10.g(r11, r12, r13);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyCloseIconStyle");
    }

    private final int m() {
        Context r10 = getContext();
        Intrinsics.checkNotNullExpressionValue(r10, "context");
        return r10.getResources().getDimensionPixelSize(u8.d.oui_dialog_layout_margin);
    }

    private final void s(Window r10) {
        if (Build.VERSION.SDK_INT < 29) goto L6;
        if (r10 == null) goto L6;
        r10.setNavigationBarContrastEnforced(false);
    L6:
        if (r10 == null) goto L8;
        r10.setDecorFitsSystemWindows(false);
    L8:
        if (r10 == null) goto L10;
        r10.clearFlags(134217728);
    L10:
        if (r10 == null) goto L12;
        r10.addFlags(Integer.MIN_VALUE);
    L12:
        if (r10 == null) goto L14;
        r10.setNavigationBarColor(0);
    L14:
        if (r10 == null) goto L17;
        r10.setNavigationBarDividerColor(0);
        return;
    }

    private final void u() {
        fa.a r10 = fa.a.f8880a;     // Catch: Exception -> L33
        View r11 = this.f6494j;     // Catch: Exception -> L33
        if (r11 != null) goto L7;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");     // Catch: Exception -> L33
    L7:
        if (r10.a(r11) <= 0) goto L9;
        return;
    L9:
        if (this.f6501q == false) goto L39;
        da.c r12 = da.c.f8520a;     // Catch: Exception -> L33
        View r13 = this.f6494j;     // Catch: Exception -> L33
        if (r13 != null) goto L13;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");     // Catch: Exception -> L33
    L13:
        Object r14 = r13.getParent();     // Catch: Exception -> L33
        if (r14 != null) goto L17;
    L15:
        r14 = null;
    L18:
        View r15 = (View) r14;     // Catch: Exception -> L33
        if (r15 == null) goto L40;
        int r16 = r15.getHeight();     // Catch: Exception -> L33
        View r17 = this.f6494j;     // Catch: Exception -> L33
        if (r17 != null) goto L24;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");     // Catch: Exception -> L33
    L24:
        if (r16 <= r17.getHeight()) goto L41;
        View r18 = this.f6494j;     // Catch: Exception -> L33
        if (r18 != null) goto L28;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");     // Catch: Exception -> L33
    L28:
        r18.requestLayout();     // Catch: Exception -> L33
        String r19 = this.f6490c;     // Catch: Exception -> L33
        StringBuilder r20 = new StringBuilder();     // Catch: Exception -> L33
        r20.append("recheckInset, requestLayout, parentView.height: ");     // Catch: Exception -> L33
        r20.append(r15.getHeight());     // Catch: Exception -> L33
        r20.append(", rootView.height: ");     // Catch: Exception -> L33
        View r21 = this.f6494j;     // Catch: Exception -> L33
        if (r21 != null) goto L31;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");     // Catch: Exception -> L33
    L31:
        r20.append(r21.getHeight());     // Catch: Exception -> L33
        ea.b.i(r19, r20.toString());     // Catch: Exception -> L33
        return;
    L41:
        return;
    L40:
        return;
    L17:
        if ((r14 instanceof View) == false) goto L15;
    L39:
        return;
    L33:
        e = move-exception;
        ea.b.c(this.f6490c, "recheckInset failed", e);
    }

    public static /* synthetic */ void x(AbstractDialog r10, boolean r11, View.OnClickListener r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = null;
    L6:
        r10.w(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setCloseIconEnabled");
    }

    private final void y() {
        View r10 = this.f6494j;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        r10.setOnApplyWindowInsetsListener(new d(this));
    }

    public final void f() {
        this.f6498n = true;
    }

    @JvmOverloads
    public final void g(CloseIconStyle r10, Integer r11, Integer r12) {
        Intrinsics.checkNotNullParameter(r10, "style");
        if (this.f6493i == false) goto L38;
        int r13 = com.obric.oui.dialog.base.a.f6506a[r10.ordinal()];
        if (r13 != 1) goto L7;
        int r14 = u8.c.ConstTextInverse;
        int r15 = u8.c.ConstBGContainer7;
    L17:
        r12 = Integer.valueOf(r15);
    L18:
        ImageView r16 = this.f6492h;
        if (r16 == null) goto L21;
        r16.setImageTintList(ContextCompat.getColorStateList(getContext(), r14));
    L21:
        Drawable r17 = null;
        if (r12 != null) goto L26;
        View r18 = this.f6491g;
        if (r18 == null) goto L39;
        r18.setBackground(null);
        return;
    L39:
        return;
    L26:
        View r19 = this.f6491g;
        if (r19 == null) goto L29;
        Drawable r20 = r19.getBackground();
    L31:
        if ((r20 instanceof GradientDrawable) == false) goto L34;
        r17 = r20;
    L34:
        GradientDrawable r21 = (GradientDrawable) r17;
        if (r21 == null) goto L41;
        r21.setColor(ContextCompat.getColorStateList(getContext(), r12.intValue()));
        return;
    L41:
        return;
    L29:
        r20 = null;
        goto L31
    L7:
        if (r13 != 2) goto L9;
        r14 = u8.c.TextReverse;
        r15 = u8.c.ConstTextInverse5;
        goto L17
    L9:
        if (r13 != 3) goto L14;
        if (r11 == null) goto L12;
        r14 = r11.intValue();
        goto L18
    L12:
        r14 = u8.c.ConstTextInverse;
        goto L18
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public final void i() {
        this.f6497m = true;
    }

    public final boolean j() {
        return this.f6498n;
    }

    protected final boolean k() {
        return this.f6497m;
    }

    public abstract int l();

    protected int n(Window r10) {
        Intrinsics.checkNotNullParameter(r10, "$this$getLayoutMarginHorizontal");
        Context r11 = r10.getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        return r11.getResources().getDimensionPixelSize(u8.d.oui_dialog_layout_margin);
    }

    public final boolean o() {
        return this.f6502r;
    }

    @Override // android.app.Dialog
    protected void onStop() {
        super.onStop();
        this.f6500p.removeCallbacksAndMessages(null);
    }

    public final View p() {
        View r10 = this.f6494j;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r10;
    }

    protected final float q(Context r10) {
        Intrinsics.checkNotNullParameter(r10, "context");
        Resources r11 = r10.getResources();
        Intrinsics.checkNotNullExpressionValue(r11, "context.resources");
        if ((r11.getConfiguration().uiMode & 48) != 32) goto L5;
        boolean r12 = true;
    L6:
        if (r12 == false) goto L8;
        return 0.8f;
    L8:
        return 0.32f;
    L5:
        r12 = false;
        goto L6
    }

    public final boolean r() {
        return this.f6501q;
    }

    @Override // android.app.Dialog
    @RequiresApi(30)
    public void show() {
        super.show();
        Window r10 = getWindow();
        if (r10 == null) goto L60;
        r10.setBackgroundDrawableResource(R.color.transparent);
        if (this.f6498n == false) goto L12;
        Window r11 = getWindow();
        if (r11 == null) goto L9;
        r11.setWindowAnimations(-1);
    L9:
        Window r12 = getWindow();
        if (r12 == null) goto L13;
        r12.clearFlags(2);
    L13:
        s(r10);
        WindowManager.LayoutParams r13 = r10.getAttributes();
        r13.gravity = 81;
        r13.setFitInsetsSides(WindowInsets.Side.all() ^ 8);
        if (this.f6502r == false) goto L16;
        r13.height = -1;
    L18:
        if (this.f6501q == false) goto L42;
        View r14 = this.f6494j;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L22:
        View r15 = this.f6494j;
        if (r15 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L25:
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        r16.width = -1;
        View r17 = null;
        if ((r16 instanceof ViewGroup.MarginLayoutParams) == true) goto L28;
        ViewGroup.LayoutParams r18 = null;
    L29:
        ViewGroup.MarginLayoutParams r19 = (ViewGroup.MarginLayoutParams) r18;
        if (r19 == null) goto L32;
        r19.bottomMargin = 0;
    L32:
        Unit r20 = Unit.INSTANCE;
        r14.setLayoutParams(r16);
        View r21 = this.f6494j;
        if (r21 != null) goto L36;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L36:
        if ((r21 instanceof RadiusLayout) == false) goto L39;
        r17 = r21;
    L39:
        RadiusLayout r22 = (RadiusLayout) r17;
        if (r22 == null) goto L49;
        Context r23 = r22.getContext();
        Intrinsics.checkNotNullExpressionValue(r23, "context");
        float r24 = r23.getResources().getDimension(u8.d.oui_r_l3);
        r22.d(r24, r24, 0.0f, 0.0f);
    L49:
        g r25 = g.f6399a;
        Context r26 = r10.getContext();
        Intrinsics.checkNotNullExpressionValue(r26, "context");
        if (r25.a(r26) == false) goto L58;
        View r27 = this.f6494j;
        if (r27 != null) goto L54;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L54:
        View r28 = this.f6494j;
        if (r28 != null) goto L57;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L57:
        ViewGroup.LayoutParams r29 = r28.getLayoutParams();
        Resources r30 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r30, "Resources.getSystem()");
        r29.width = MathKt.roundToInt(TypedValue.applyDimension(1, 440, r30.getDisplayMetrics()));
        Unit r31 = Unit.INSTANCE;
        r27.setLayoutParams(r29);
    L58:
        r10.setAttributes(r13);
        return;
    L28:
        r18 = r16;
        goto L29
    L42:
        View r32 = this.f6494j;
        if (r32 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L45:
        View r33 = this.f6494j;
        if (r33 != null) goto L48;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L48:
        ViewGroup.LayoutParams r34 = r33.getLayoutParams();
        Context r35 = r10.getContext();
        Intrinsics.checkNotNullExpressionValue(r35, "context");
        Resources r36 = r35.getResources();
        Intrinsics.checkNotNullExpressionValue(r36, "context.resources");
        r34.width = r36.getDisplayMetrics().widthPixels - (n(r10) * 2);
        Unit r37 = Unit.INSTANCE;
        r32.setLayoutParams(r34);
        goto L49
    L16:
        r13.height = -2;
        goto L18
    L12:
        r10.addFlags(2);
        goto L13
    }

    public final boolean t() {
        return this.f6499o;
    }

    public final void v(boolean r10) {
        this.f6499o = r10;
    }

    public void w(boolean r10, View.OnClickListener r11) {
        this.f6493i = r10;
        this.f6496l = r11;
        ImageView r12 = this.f6492h;
        if (r12 == null) goto L16;
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        k.a(r12, MathKt.roundToInt(TypedValue.applyDimension(1, 44, r13.getDisplayMetrics())));
        if (r10 == false) goto L12;
        View r14 = this.f6491g;
        if (r14 == null) goto L9;
        k.h(r14);
    L9:
        h(this, this.f6495k, null, null, 6, null);
        View r15 = this.f6491g;
        if (r15 == null) goto L17;
        r15.setOnClickListener(new c(this, r10));
        return;
    L17:
        return;
    L12:
        View r16 = this.f6491g;
        if (r16 == null) goto L19;
        k.f(r16);
        return;
    L19:
        return;
    }
}
