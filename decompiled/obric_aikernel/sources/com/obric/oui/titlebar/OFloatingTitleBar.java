package com.obric.oui.titlebar;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.obric.common.oea.foundation.blur.BlurUtils;
import com.obric.oui.button.OButtonGroup;
import com.obric.oui.text.OTextView;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import u8.c;
import u8.e;
import u8.f;
import u8.h;
import u8.k;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010!\u0012\b\b\u0002\u0010#\u001a\u00020\u0006¢\u0006\u0004\b$\u0010%J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006J\u0010\u0010\u000e\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0012\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u0010\u0010\u0016\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u0006J\u000e\u0010\u001b\u001a\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001c¨\u0006&"}, d2 = {"Lcom/obric/oui/titlebar/OFloatingTitleBar;", "Landroid/widget/FrameLayout;", "Landroid/view/View;", "view", "", "setCenterCustomView", "", "styleRes", "setStartButtonGroupStyle", "setCenterButtonGroupStyle", "setSubEndButtonGroupStyle", "setEndButtonGroupStyle", "", "text", "setStartTitle", "resId", TypedValues.Custom.S_COLOR, "setStartTitleColor", "setStartSubtitle", "setStartSubTitleColor", "setCenterTitle", "setCenterTitleColor", "setCenterSubtitle", "setCenterSubTitle", "setCenterSubTitleColor", "Landroid/graphics/drawable/Drawable;", "drawable", "setMaskBackground", "", "radius", "setMaskBlurRadius", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OFloatingTitleBar extends FrameLayout {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private FrameLayout f7686c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private OButtonGroup f7687g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private OTextView f7688h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private OTextView f7689i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private FrameLayout f7690j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private OButtonGroup f7691k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private FrameLayout f7692l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private OTextView f7693m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private OTextView f7694n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private LinearLayout f7695o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private OButtonGroup f7696p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private OButtonGroup f7697q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private View f7698r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private View f7699s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private int f7700t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private int f7701u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private int f7702v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private int f7703w;

    static final class a implements View.OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ OFloatingTitleBar f7704a;

        a(OFloatingTitleBar r10) {
            this.f7704a = r10;
        }

        @Override // android.view.View.OnApplyWindowInsetsListener
        public final WindowInsets onApplyWindowInsets(View r10, WindowInsets r11) {
            Intrinsics.checkNotNullParameter(r10, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(r11, "insets");
            int r12 = r11.getSystemWindowInsetTop();
            OFloatingTitleBar.j(this.f7704a, r12);
            return r11;
        }
    }

    @JvmOverloads
    public OFloatingTitleBar(Context r10) {
        this(r10, null, 0, 6, null);
    }

    @JvmOverloads
    public OFloatingTitleBar(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public OFloatingTitleBar(Context r10, AttributeSet r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        LayoutInflater.from(r10).inflate(h.o_floating_title_bar_layout, this, true);
        setClipChildren(false);
        setClipToPadding(false);
        m();
        if (r11 == null) goto L6;
        l(r11);
        return;
    }

    public /* synthetic */ OFloatingTitleBar(Context r10, AttributeSet r11, int r12, int r13, DefaultConstructorMarker r14) {
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        this(r10, r11, r12);
    }

    public static final /* synthetic */ OButtonGroup a(OFloatingTitleBar r10) {
        OButtonGroup r11 = r10.f7691k;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerButtonGroup");
    L5:
        return r11;
    }

    public static final /* synthetic */ OButtonGroup b(OFloatingTitleBar r10) {
        OButtonGroup r11 = r10.f7697q;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("endButtonGroup");
    L5:
        return r11;
    }

    public static final /* synthetic */ OButtonGroup c(OFloatingTitleBar r10) {
        OButtonGroup r11 = r10.f7696p;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("endSubButtonGroup");
    L5:
        return r11;
    }

    public static final /* synthetic */ OButtonGroup d(OFloatingTitleBar r10) {
        OButtonGroup r11 = r10.f7687g;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startButtonGroup");
    L5:
        return r11;
    }

    public static final /* synthetic */ void e(OFloatingTitleBar r10, int r11) {
        r10.f7701u = r11;
    }

    public static final /* synthetic */ void f(OFloatingTitleBar r10, int r11) {
        r10.f7703w = r11;
    }

    public static final /* synthetic */ void g(OFloatingTitleBar r10, int r11) {
        r10.f7702v = r11;
    }

    public static final /* synthetic */ void h(OFloatingTitleBar r10, int r11) {
        r10.f7700t = r11;
    }

    public static final /* synthetic */ void i(OFloatingTitleBar r10, OButtonGroup r11, int r12) {
        r10.t(r11, r12);
    }

    public static final /* synthetic */ void j(OFloatingTitleBar r10, int r11) {
        r10.u(r11);
    }

    private final void k(OButtonGroup r10, int r11, Function1<? super Integer, Unit> r12) {
        if (r11 != 0) goto L4;
        return;
    L4:
        TypedArray r13 = getContext().obtainStyledAttributes(r11, l.OShadowFrame);
        Intrinsics.checkNotNullExpressionValue(r13, "context.obtainStyledAttr…R.styleable.OShadowFrame)");
        int r14 = r13.getColor(l.OShadowFrame_oui_widgetBgColor, 0);
        int r15 = r13.getColor(l.OShadowFrame_oui_widgetPressColor, 0);
        int r16 = r13.getColor(l.OShadowFrame_oui_widgetBgColorDisabled, 0);
        int r17 = r13.getColor(l.OShadowFrame_oui_widgetTintColor, 0);
        r13.recycle();
        if (r14 == 0) goto L10;
        if (r16 != 0) goto L9;
        r16 = r14;
    L9:
        r10.m(r14, r16);
    L10:
        if (r15 == 0) goto L12;
        r10.setPressColor(r15);
    L12:
        if (r17 == 0) goto L15;
        r12.invoke(Integer.valueOf(r17));
        return;
    }

    private final void l(AttributeSet r10) {
        Context r11 = getContext();
        Intrinsics.checkNotNullExpressionValue(r11, "context");
        TypedArray r12 = r11.getTheme().obtainStyledAttributes(r10, l.OFloatingTitleBar, 0, 0);
        int r13 = l.OFloatingTitleBar_oFloatingTitleBar_startTitle;
        if (r12.hasValue(r13) == false) goto L5;
        setStartTitle(r12.getString(r13));
    L5:
        int r14 = l.OFloatingTitleBar_oFloatingTitleBar_startTitleColor;
        if (r12.hasValue(r14) == false) goto L8;
        setStartTitleColor(r12.getColor(r14, c.oui_basic_text_1));
    L8:
        int r15 = l.OFloatingTitleBar_oFloatingTitleBar_startSubTitle;
        if (r12.hasValue(r15) == false) goto L11;
        setStartSubtitle(r12.getString(r15));
    L11:
        int r16 = l.OFloatingTitleBar_oFloatingTitleBar_startSubTitleColor;
        if (r12.hasValue(r16) == false) goto L14;
        setStartSubTitleColor(r12.getColor(r16, c.oui_basic_text_3));
    L14:
        int r17 = l.OFloatingTitleBar_oFloatingTitleBar_centerTitle;
        if (r12.hasValue(r17) == false) goto L17;
        setCenterTitle(r12.getString(r17));
    L17:
        int r18 = l.OFloatingTitleBar_oFloatingTitleBar_centerTitleColor;
        if (r12.hasValue(r18) == false) goto L20;
        setCenterTitleColor(r12.getColor(r18, c.oui_basic_text_1));
    L20:
        int r19 = l.OFloatingTitleBar_oFloatingTitleBar_centerSubTitle;
        if (r12.hasValue(r19) == false) goto L23;
        setCenterSubtitle(r12.getString(r19));
    L23:
        int r20 = l.OFloatingTitleBar_oFloatingTitleBar_centerSubTitleColor;
        if (r12.hasValue(r20) == false) goto L26;
        setCenterSubTitleColor(r12.getColor(r20, c.oui_basic_text_3));
    L26:
        int r21 = l.OFloatingTitleBar_oFloatingTitleBar_startButtonGroupStyle;
        int r22 = k.OFloatingTitleBar_Action_Standard;
        setStartButtonGroupStyle(r12.getResourceId(r21, r22));
        setCenterButtonGroupStyle(r12.getResourceId(l.OFloatingTitleBar_oFloatingTitleBar_centerButtonGroupStyle, r22));
        setSubEndButtonGroupStyle(r12.getResourceId(l.OFloatingTitleBar_oFloatingTitleBar_endSubButtonGroupStyle, r22));
        setEndButtonGroupStyle(r12.getResourceId(l.OFloatingTitleBar_oFloatingTitleBar_endButtonGroupStyle, r22));
        int r23 = l.OFloatingTitleBar_oFloatingTitleBar_maskBackground;
        if (r12.hasValue(r23) == false) goto L33;
        Drawable r24 = r12.getDrawable(r23);
        if (r24 != null) goto L32;
        r24 = new ColorDrawable(r12.getColor(r23, 0));
    L32:
        setMaskBackground(r24);
    L33:
        int r25 = l.OFloatingTitleBar_oFloatingTitleBar_defaultMaskBackground;
        if (r12.hasValue(r25) == true) goto L36;
    L38:
        int r26 = l.OFloatingTitleBar_oFloatingTitleBar_maskBlurRadius;
        if (r12.hasValue(r26) == false) goto L41;
        setMaskBlurRadius(r12.getFloat(r26, 0.0f));
    L41:
        int r27 = l.OFloatingTitleBar_oFloatingTitleBar_statusBarImmersion;
        if (r12.hasValue(r27) == true) goto L44;
    L46:
        r12.recycle();
        return;
    L44:
        if (r12.getBoolean(r27, false) == false) goto L46;
        setOnApplyWindowInsetsListener(new a(this));
        goto L46
    L36:
        if (r12.getBoolean(r25, false) == false) goto L38;
        r();
        goto L38
    }

    private final void m() {
        View r10 = findViewById(f.start_container);
        Intrinsics.checkNotNullExpressionValue(r10, "findViewById(R.id.start_container)");
        this.f7686c = (FrameLayout) r10;
        View r11 = findViewById(f.start_button_group);
        Intrinsics.checkNotNullExpressionValue(r11, "findViewById(R.id.start_button_group)");
        this.f7687g = (OButtonGroup) r11;
        View r12 = findViewById(f.start_title_container);
        Intrinsics.checkNotNullExpressionValue(r12, "findViewById(R.id.start_title_container)");
        LinearLayout r13 = (LinearLayout) r12;
        View r14 = findViewById(f.start_title);
        Intrinsics.checkNotNullExpressionValue(r14, "findViewById(R.id.start_title)");
        this.f7688h = (OTextView) r14;
        View r15 = findViewById(f.start_sub_title);
        Intrinsics.checkNotNullExpressionValue(r15, "findViewById(R.id.start_sub_title)");
        this.f7689i = (OTextView) r15;
        View r16 = findViewById(f.center_container);
        Intrinsics.checkNotNullExpressionValue(r16, "findViewById(R.id.center_container)");
        this.f7690j = (FrameLayout) r16;
        View r17 = findViewById(f.center_button_group);
        Intrinsics.checkNotNullExpressionValue(r17, "findViewById(R.id.center_button_group)");
        this.f7691k = (OButtonGroup) r17;
        View r18 = findViewById(f.center_custom_container);
        Intrinsics.checkNotNullExpressionValue(r18, "findViewById(R.id.center_custom_container)");
        this.f7692l = (FrameLayout) r18;
        View r19 = findViewById(f.center_title_container);
        Intrinsics.checkNotNullExpressionValue(r19, "findViewById(R.id.center_title_container)");
        LinearLayout r20 = (LinearLayout) r19;
        View r21 = findViewById(f.center_title);
        Intrinsics.checkNotNullExpressionValue(r21, "findViewById(R.id.center_title)");
        this.f7693m = (OTextView) r21;
        View r22 = findViewById(f.center_sub_title);
        Intrinsics.checkNotNullExpressionValue(r22, "findViewById(R.id.center_sub_title)");
        this.f7694n = (OTextView) r22;
        View r23 = findViewById(f.end_container);
        Intrinsics.checkNotNullExpressionValue(r23, "findViewById(R.id.end_container)");
        this.f7695o = (LinearLayout) r23;
        View r24 = findViewById(f.end_sub_button_group);
        Intrinsics.checkNotNullExpressionValue(r24, "findViewById(R.id.end_sub_button_group)");
        this.f7696p = (OButtonGroup) r24;
        View r25 = findViewById(f.end_button_group);
        Intrinsics.checkNotNullExpressionValue(r25, "findViewById(R.id.end_button_group)");
        this.f7697q = (OButtonGroup) r25;
        View r26 = findViewById(f.mask);
        Intrinsics.checkNotNullExpressionValue(r26, "findViewById(R.id.mask)");
        this.f7698r = r26;
        View r27 = findViewById(f.title_bar_container);
        Intrinsics.checkNotNullExpressionValue(r27, "findViewById(R.id.title_bar_container)");
        this.f7699s = r27;
    }

    private final boolean n() {
        OButtonGroup r10 = this.f7691k;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("centerButtonGroup");
    L6:
        if (r10.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L37;
        OTextView r12 = this.f7693m;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L14:
        if (r12.getVisibility() != 0) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == true) goto L38;
        OTextView r14 = this.f7694n;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L22:
        if (r14.getVisibility() != 0) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == true) goto L39;
        FrameLayout r16 = this.f7692l;
        if (r16 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L30:
        if (r16.getVisibility() != 0) goto L32;
        boolean r17 = true;
    L33:
        if (r17 == false) goto L36;
        return true;
    L36:
        return false;
    L32:
        r17 = false;
        goto L33
    L39:
        return true;
    L24:
        r15 = false;
        goto L25
    L38:
        return true;
    L16:
        r13 = false;
        goto L17
    L37:
        return true;
    L8:
        r11 = false;
        goto L9
    }

    private final boolean o() {
        OButtonGroup r10 = this.f7697q;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("endButtonGroup");
    L6:
        if (r10.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L21;
        OButtonGroup r12 = this.f7696p;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("endSubButtonGroup");
    L14:
        if (r12.getVisibility() != 0) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == false) goto L20;
        return true;
    L20:
        return false;
    L16:
        r13 = false;
        goto L17
    L21:
        return true;
    L8:
        r11 = false;
        goto L9
    }

    private final boolean p() {
        OButtonGroup r10 = this.f7687g;
        if (r10 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("startButtonGroup");
    L6:
        if (r10.getVisibility() != 0) goto L8;
        boolean r11 = true;
    L9:
        if (r11 == true) goto L29;
        OTextView r12 = this.f7688h;
        if (r12 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L14:
        if (r12.getVisibility() != 0) goto L16;
        boolean r13 = true;
    L17:
        if (r13 == true) goto L30;
        OTextView r14 = this.f7689i;
        if (r14 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L22:
        if (r14.getVisibility() != 0) goto L24;
        boolean r15 = true;
    L25:
        if (r15 == false) goto L28;
        return true;
    L28:
        return false;
    L24:
        r15 = false;
        goto L25
    L30:
        return true;
    L16:
        r13 = false;
        goto L17
    L29:
        return true;
    L8:
        r11 = false;
        goto L9
    }

    private final void q(TextView r10) {
        CharSequence r11 = r10.getText();
        int r12 = 0;
        if (r11 != null) goto L5;
    L8:
        boolean r13 = true;
    L10:
        if ((!r13) == true) goto L13;
        r12 = 8;
    L13:
        r10.setVisibility(r12);
        return;
    L5:
        if (r11.length() == 0) goto L8;
        r13 = false;
        goto L10
    }

    private final void t(OButtonGroup r10, int r11) {
        int r12 = r10.getItemCount();
        int r13 = 0;
    L3:
        if (r13 >= r12) goto L5;
        v(r10.q(r13), r11);
        r13 = r13 + 1;
        goto L3
    }

    private final void u(int r10) {
        View r11 = this.f7698r;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mask");
    L5:
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        Resources r13 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r13, "Resources.getSystem()");
        r12.height = MathKt.roundToInt(TypedValue.applyDimension(1, 80, r13.getDisplayMetrics())) + r10;
        View r14 = this.f7698r;
        if (r14 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("mask");
    L8:
        r14.setLayoutParams(r12);
        View r15 = this.f7699s;
        if (r15 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L11:
        ViewGroup.LayoutParams r16 = r15.getLayoutParams();
        Objects.requireNonNull(r16, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams r17 = (ViewGroup.MarginLayoutParams) r16;
        r17.topMargin = r10;
        View r18 = this.f7699s;
        if (r18 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L14:
        r18.setLayoutParams(r17);
    }

    private final void v(View r10, int r11) {
        if ((r10 instanceof ViewGroup) == false) goto L8;
        int r12 = 0;
        ViewGroup r13 = (ViewGroup) r10;
        int r14 = r13.getChildCount();
    L5:
        if (r12 >= r14) goto L17;
        v(r13.getChildAt(r12), r11);
        r12 = r12 + 1;
        goto L5
    L17:
        return;
    L8:
        if ((r10 instanceof ImageView) == false) goto L11;
        ((ImageView) r10).setColorFilter(r11);
        return;
    L11:
        if ((r10 instanceof TextView) == false) goto L16;
        ((TextView) r10).setTextColor(r11);
        return;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int r19, int r20) {
        OTextView r10 = this.f7693m;
        if (r10 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L5:
        r10.setMaxWidth(Integer.MAX_VALUE);
        OTextView r11 = this.f7694n;
        if (r11 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L8:
        r11.setMaxWidth(Integer.MAX_VALUE);
        OTextView r12 = this.f7688h;
        if (r12 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L11:
        r12.setMaxWidth(Integer.MAX_VALUE);
        OTextView r13 = this.f7689i;
        if (r13 != null) goto L14;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L14:
        r13.setMaxWidth(Integer.MAX_VALUE);
        super.onMeasure(r19, r20);
        boolean r14 = p();
        boolean r15 = n();
        boolean r16 = o();
        int r17 = getMeasuredWidth();
        View r18 = this.f7699s;
        if (r18 != null) goto L17;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L17:
        int r21 = r18.getPaddingLeft();
        View r110 = this.f7699s;
        if (r110 != null) goto L20;
        Intrinsics.throwUninitializedPropertyAccessException("titleBarContainer");
    L20:
        int r111 = r110.getPaddingRight();
        Resources r112 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r112, "Resources.getSystem()");
        int r113 = MathKt.roundToInt(TypedValue.applyDimension(1, 8, r112.getDisplayMetrics()));
        if (r15 == false) goto L26;
        int r114 = r17 / 2;
        FrameLayout r115 = this.f7690j;
        if (r115 != null) goto L25;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L25:
        int r116 = (r114 - (r115.getMeasuredWidth() / 2)) - r113;
    L33:
        if (r14 == false) goto L38;
        int r117 = (r17 / 2) - r21;
        FrameLayout r22 = this.f7686c;
        if (r22 != null) goto L37;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
    L37:
        int r118 = (r117 - r22.getMeasuredWidth()) - r113;
    L39:
        int r23 = (r17 / 2) - r111;
        if (r16 == false) goto L46;
        LinearLayout r24 = this.f7695o;
        if (r24 != null) goto L44;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
    L44:
        r23 = (r23 - r24.getMeasuredWidth()) - r113;
    L46:
        if (r14 == false) goto L59;
        int r25 = Math.max(0, r116 - r21);
        FrameLayout r26 = this.f7686c;
        if (r26 != null) goto L51;
        Intrinsics.throwUninitializedPropertyAccessException("startContainer");
    L51:
        if (r26.getMeasuredWidth() <= r25) goto L59;
        OTextView r27 = this.f7688h;
        if (r27 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L55:
        r27.setMaxWidth(r25);
        OTextView r28 = this.f7689i;
        if (r28 != null) goto L58;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L58:
        r28.setMaxWidth(r25);
        boolean r29 = true;
    L60:
        if (r15 == false) goto L73;
        int r30 = Math.max(0, Math.min(r118 * 2, r23 * 2));
        FrameLayout r31 = this.f7690j;
        if (r31 != null) goto L65;
        Intrinsics.throwUninitializedPropertyAccessException("centerContainer");
    L65:
        if (r31.getMeasuredWidth() <= r30) goto L73;
        OTextView r32 = this.f7693m;
        if (r32 != null) goto L69;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L69:
        r32.setMaxWidth(r30);
        OTextView r33 = this.f7694n;
        if (r33 != null) goto L72;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L72:
        r33.setMaxWidth(r30);
        boolean r119 = true;
    L74:
        if (r119 == false) goto L77;
        super.onMeasure(r19, r20);
        return;
    L77:
        return;
    L73:
        r119 = r29;
    L59:
        r29 = false;
        goto L60
    L38:
        r118 = (r17 / 2) - r21;
        goto L39
    L26:
        if (r16 == false) goto L31;
        int r120 = r17 - r111;
        LinearLayout r121 = this.f7695o;
        if (r121 != null) goto L30;
        Intrinsics.throwUninitializedPropertyAccessException("endContainer");
    L30:
        r116 = (r120 - r121.getMeasuredWidth()) - r113;
        goto L33
    L31:
        r116 = r17 - r111;
        goto L33
    }

    public final void r() {
        Drawable r10 = getResources().getDrawable(e.o_floating_title_bar_default_mask_bg);
        Intrinsics.checkNotNullExpressionValue(r10, "resources.getDrawable(R.…itle_bar_default_mask_bg)");
        setMaskBackground(r10);
    }

    public final void s(boolean r10) {
        View r11 = this.f7698r;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mask");
    L5:
        if (r10 == false) goto L7;
        int r12 = 0;
    L8:
        r11.setVisibility(r12);
        return;
    L7:
        r12 = 8;
        goto L8
    }

    public final void setCenterButtonGroupStyle(int r10) {
        OButtonGroup r11 = this.f7691k;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerButtonGroup");
    L5:
        k(r11, r10, new AnonymousClass1(this));
    }

    public final void setCenterCustomView(View r10) {
        Intrinsics.checkNotNullParameter(r10, "view");
        FrameLayout r11 = this.f7692l;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L5:
        r11.removeAllViews();
        FrameLayout r12 = this.f7692l;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L8:
        r12.addView(r10);
        FrameLayout r13 = this.f7692l;
        if (r13 != null) goto L11;
        Intrinsics.throwUninitializedPropertyAccessException("centerCustomContainer");
    L11:
        r13.setVisibility(0);
    }

    public final void setCenterSubTitle(int r10) {
        setCenterSubtitle(getResources().getString(r10));
    }

    public final void setCenterSubTitleColor(int r10) {
        OTextView r11 = this.f7694n;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L5:
        r11.setTextColor(r10);
    }

    public final void setCenterSubtitle(String r10) {
        OTextView r11 = this.f7694n;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L5:
        r11.setText(r10);
        OTextView r12 = this.f7694n;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerSubtitleView");
    L8:
        q(r12);
    }

    public final void setCenterTitle(int r10) {
        setCenterTitle(getResources().getString(r10));
    }

    public final void setCenterTitle(String r10) {
        OTextView r11 = this.f7693m;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L5:
        r11.setText(r10);
        OTextView r12 = this.f7693m;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L8:
        q(r12);
    }

    public final void setCenterTitleColor(int r10) {
        OTextView r11 = this.f7693m;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("centerTitleView");
    L5:
        r11.setTextColor(r10);
    }

    public final void setEndButtonGroupStyle(int r10) {
        OButtonGroup r11 = this.f7697q;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("endButtonGroup");
    L5:
        k(r11, r10, new C03931(this));
    }

    public final void setMaskBackground(Drawable r10) {
        Intrinsics.checkNotNullParameter(r10, "drawable");
        View r11 = this.f7698r;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mask");
    L5:
        r11.setBackground(r10);
        s(true);
    }

    public final void setMaskBlurRadius(float r10) {
        View r11 = this.f7698r;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("mask");
    L5:
        BlurUtils.b(r11, BlurUtils.BlurType.PROGRESS_BLUR_DOWN_UP, r10);
        if (r10 == 0.0f) goto L8;
        boolean r12 = true;
    L9:
        s(r12);
        return;
    L8:
        r12 = false;
        goto L9
    }

    public final void setStartButtonGroupStyle(int r10) {
        OButtonGroup r11 = this.f7687g;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startButtonGroup");
    L5:
        k(r11, r10, new C03941(this));
    }

    public final void setStartSubTitleColor(int r10) {
        OTextView r11 = this.f7689i;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L5:
        r11.setTextColor(r10);
    }

    public final void setStartSubtitle(int r10) {
        setStartSubtitle(getResources().getString(r10));
    }

    public final void setStartSubtitle(String r10) {
        OTextView r11 = this.f7689i;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L5:
        r11.setText(r10);
        OTextView r12 = this.f7689i;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startSubtitleView");
    L8:
        q(r12);
    }

    public final void setStartTitle(int r10) {
        setStartTitle(getResources().getString(r10));
    }

    public final void setStartTitle(String r10) {
        OTextView r11 = this.f7688h;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L5:
        r11.setText(r10);
        OTextView r12 = this.f7688h;
        if (r12 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L8:
        q(r12);
    }

    public final void setStartTitleColor(int r10) {
        OTextView r11 = this.f7688h;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("startTitleView");
    L5:
        r11.setTextColor(r10);
    }

    public final void setSubEndButtonGroupStyle(int r10) {
        OButtonGroup r11 = this.f7696p;
        if (r11 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("endSubButtonGroup");
    L5:
        k(r11, r10, new C03951(this));
    }
}
