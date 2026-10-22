package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.graphics.ColorUtils;
import com.obric.memorydata.plugin.R;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import com.volcengine.zeus.transform.ZeusTransformUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J\u0010\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0007H\u0016J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0011H\u0002R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/obric/oui/button/OButtonLink;", "Lcom/obric/oui/layout/OUILinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "arrowView", "Landroid/widget/ImageView;", "pressOverlayColor", "textView", "Lcom/obric/oui/text/OBaseTextView;", "getAnimatedOverlayColor", "fraction", "", "initView", "", "onPressAlphaChange", "alpha", "updateContentColorOnPress", "Companion", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonLink extends OUILinearLayout {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f13391a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private OBaseTextView f13392b;
    private ImageView c;
    private final int d;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/obric/oui/button/OButtonLink$Companion;", "", "()V", "ALPHA_ON_PRESS", "", "TAG", "", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }
    }

    static {
        f13391a = new a(null);
    }

    public OButtonLink(Context r8) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r8, Context.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r1, "context");
        this(r1, null, 0, 0, 14, null);
    }

    public OButtonLink(Context r10, AttributeSet r11) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 0, 12, null);
    }

    public OButtonLink(Context r10, AttributeSet r11, int r12) {
        Context r3 = (Context) ZeusTransformUtils.wrapperContextForParams(r10, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r4 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r11, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, r12, 0, 8, null);
    }

    public OButtonLink(Context r9, AttributeSet r10, int r11, int r12) {
        Context r13 = (Context) ZeusTransformUtils.wrapperContextForParams(r9, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r14 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r10, AttributeSet.class, "com.obric.memorydata.plugin");
        Intrinsics.checkNotNullParameter(r13, "context");
        super(r13, r14, r11, null, 8, null);
        this.d = ZeusTransformUtils.getResources(r13, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_state_overlay_pressed_on_color, TypedValues.Custom.S_COLOR, "oui_state_overlay_pressed_on_color"));
        a(r13, r14);
    }

    public /* synthetic */ OButtonLink(Context r2, AttributeSet r3, int r4, int r5, int r6, DefaultConstructorMarker r7) {
        Context r8 = (Context) ZeusTransformUtils.wrapperContextForParams(r2, Context.class, "com.obric.memorydata.plugin");
        AttributeSet r9 = (AttributeSet) ZeusTransformUtils.wrapperContextForParams(r3, AttributeSet.class, "com.obric.memorydata.plugin");
        if ((r6 & 2) == 0) goto L6;
        r9 = null;
    L6:
        if ((r6 & 4) == 0) goto L9;
        r4 = 0;
    L9:
        if ((r6 & 8) == 0) goto L11;
        r5 = 0;
    L11:
        this(r8, r9, r4, r5);
    }

    private final void a(float r6) {
        int r0 = b(r6);
        OBaseTextView r2 = null;
        if (r6 <= 0.0f) goto L5;
        PorterDuffColorFilter r7 = new PorterDuffColorFilter(r0, PorterDuff.Mode.SRC_ATOP);
    L6:
        OBaseTextView r1 = this.f13392b;
        if (r1 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r1 = null;
    L9:
        r1.getPaint().setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r7, ColorFilter.class, "com.obric.memorydata.plugin"));
        OBaseTextView r3 = this.f13392b;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L13:
        r2.invalidate();
        ImageView r5 = this.c;
        if (r7 == null) goto L18;
        if (r5 == null) goto L23;
        r5.setColorFilter((ColorFilter) ZeusTransformUtils.preCheckCast(r7, ColorFilter.class, "com.obric.memorydata.plugin"));
        return;
    L23:
        return;
    L18:
        if (r5 == null) goto L24;
        r5.clearColorFilter();
        return;
    L24:
        return;
    L12:
        r2 = r3;
        goto L13
    L5:
        r7 = (PorterDuffColorFilter) ZeusTransformUtils.preCheckCast(null, PorterDuffColorFilter.class, "com.obric.memorydata.plugin");
        goto L6
    }

    private final void a(Context r19, AttributeSet r20) {
        Context r1 = (Context) ZeusTransformUtils.wrapperContextForParams(r19, Context.class, "com.obric.memorydata.plugin");
        TypedArray r9 = r1.obtainStyledAttributes((AttributeSet) ZeusTransformUtils.wrapperContextForParams(r20, AttributeSet.class, "com.obric.memorydata.plugin"), R.styleable.OButtonLink);
        Intrinsics.checkNotNullExpressionValue(r9, "context.obtainStyledAttr… R.styleable.OButtonLink)");
        String r10 = r9.getString(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_widgetText, "styleable", "OButtonLink_oui_widgetText"));
        int r11 = r9.getResourceId(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_widgetTextStyle, "styleable", "OButtonLink_oui_widgetTextStyle"), ZeusTransformUtils.mapRes(R.style.Button_1_Medium, "style", "Button_1_Medium"));
        Drawable r12 = null;
        int r13 = r9.getColor(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_widgetTextColor, "styleable", "OButtonLink_oui_widgetTextColor"), ZeusTransformUtils.getResources(this, "com.obric.memorydata.plugin").getColor(ZeusTransformUtils.mapRes(R.color.oui_accent_7_fg, TypedValues.Custom.S_COLOR, "oui_accent_7_fg"), null));
        boolean r15 = r9.getBoolean(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_buttonLinkShowArrow, "styleable", "OButtonLink_oui_buttonLinkShowArrow"), false);
        Drawable r16 = r9.getDrawable(ZeusTransformUtils.mapRes(R.styleable.OButtonLink_oui_buttonLinkArrowDrawable, "styleable", "OButtonLink_oui_buttonLinkArrowDrawable"));
        setOrientation(0);
        OBaseTextView r8 = new OBaseTextView(r1, null, 0, 6, null);
        r8.setSingleLine();
        r8.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r8.setTextAppearance(r11);
        r8.setTextColor(r13);
        r8.setText((CharSequence) ZeusTransformUtils.preCheckCast(r10, CharSequence.class, "com.obric.memorydata.plugin"));
        r8.setIncludeFontPadding(false);
        r8.setGravity(17);
        this.f13392b = r8;
        if (r8 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        OBaseTextView r14 = null;
    L6:
        View r3 = (View) ZeusTransformUtils.preCheckCast(r14, View.class, "com.obric.memorydata.plugin");
        LinearLayout.LayoutParams r4 = new LinearLayout.LayoutParams(-2, -2);
        r4.weight = 1.0f;
        Unit r6 = Unit.INSTANCE;
        addView(r3, (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(r4, ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
        if (r15 == false) goto L16;
        AppCompatImageView r5 = new AppCompatImageView(r1);
        if (r16 == null) goto L15;
        Drawable r2 = r16.mutate();
        if (r2 == null) goto L15;
        r2.setTint(r13);
        r12 = r2;
    L15:
        r5.setImageDrawable(r12);
        ImageView r7 = (ImageView) ZeusTransformUtils.preCheckCast(r5, ImageView.class, "com.obric.memorydata.plugin");
        this.c = r7;
        addView((View) ZeusTransformUtils.preCheckCast(r7, View.class, "com.obric.memorydata.plugin"), (ViewGroup.LayoutParams) ZeusTransformUtils.preCheckCast(new LinearLayout.LayoutParams(-2, -2), ViewGroup.LayoutParams.class, "com.obric.memorydata.plugin"));
    L16:
        r9.recycle();
        setOverridePressColor(0);
        refreshColors("OButtonLink");
        setChangeAlphaWhenPress(true);
        setClickable(true);
        return;
    L5:
        r14 = r8;
        goto L6
    }

    private final int b(float r3) {
        return ColorUtils.setAlphaComponent(this.d, RangesKt.coerceIn(MathKt.roundToInt(r3 * Color.alpha(this.d)), 0, 255));
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.b
    public void onPressAlphaChange(int r3) {
        a(RangesKt.coerceIn(r3 / 255.0f, 0.0f, 1.0f));
    }
}
