package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.ColorUtils;
import com.obric.common.oui.R$color;
import com.obric.common.oui.R$style;
import com.obric.common.oui.R$styleable;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/obric/oui/button/OButtonLink;", "Lcom/obric/oui/layout/OUILinearLayout;", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OButtonLink extends OUILinearLayout {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final OBaseTextView f12130h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final AppCompatImageView f12131i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f12132j;

    @JvmOverloads
    public OButtonLink(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, null, 0, 14);
    }

    @Override // com.obric.oui.layout.OUILinearLayout, com.obric.oui.common.style.b
    public final void j(int r10) {
        float r11 = RangesKt.coerceIn(r10 / 255.0f, 0.0f, 1.0f);
        int r5 = this.f12132j;
        int r12 = ColorUtils.setAlphaComponent(r5, RangesKt.coerceIn(MathKt.roundToInt(Color.alpha(r5) * r11), 0, 255));
        OBaseTextView r13 = null;
        if (r11 <= 0.0f) goto L5;
        PorterDuffColorFilter r14 = new PorterDuffColorFilter(r12, PorterDuff.Mode.SRC_ATOP);
    L6:
        OBaseTextView r15 = this.f12130h;
        if (r15 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r15 = null;
    L9:
        r15.getPaint().setColorFilter(r14);
        OBaseTextView r16 = this.f12130h;
        if (r16 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L13:
        r13.invalidate();
        if (r14 == null) goto L19;
        AppCompatImageView r17 = this.f12131i;
        if (r17 == null) goto L25;
        r17.setColorFilter(r14);
        return;
    L25:
        return;
    L19:
        AppCompatImageView r18 = this.f12131i;
        if (r18 == null) goto L26;
        r18.clearColorFilter();
        return;
    L26:
        return;
    L12:
        r13 = r16;
        goto L13
    L5:
        r14 = null;
        goto L6
    }

    @JvmOverloads
    public OButtonLink(Context r5, AttributeSet r10) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, 0, 12);
    }

    @JvmOverloads
    public OButtonLink(Context r5, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r5, "context");
        this(r5, r10, r11, 8);
    }

    public OButtonLink(Context r10, AttributeSet r11, int r12, int r13) {
        Drawable r5 = null;
        if ((r13 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r13 & 4) == 0) goto L8;
        r12 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, 8);
        this.f12132j = r10.getResources().getColor(R$color.oui_state_overlay_pressed_on_color);
        TypedArray r14 = r10.obtainStyledAttributes(r11, R$styleable.OButtonLink);
        String r15 = r14.getString(R$styleable.OButtonLink_oui_widgetText);
        int r16 = r14.getResourceId(R$styleable.OButtonLink_oui_widgetTextStyle, R$style.Button_1_Medium);
        int r17 = r14.getColor(R$styleable.OButtonLink_oui_widgetTextColor, getResources().getColor(R$color.oui_accent_7_fg, null));
        boolean r18 = r14.getBoolean(R$styleable.OButtonLink_oui_buttonLinkShowArrow, false);
        Drawable r19 = r14.getDrawable(R$styleable.OButtonLink_oui_buttonLinkArrowDrawable);
        setOrientation(0);
        OBaseTextView r20 = new OBaseTextView(r10, null, 6, 0);
        r20.setSingleLine();
        r20.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r20.setTextAppearance(r16);
        r20.setTextColor(r17);
        r20.setText(r15);
        r20.setIncludeFontPadding(false);
        r20.setGravity(17);
        this.f12130h = r20;
        LinearLayout.LayoutParams r110 = new LinearLayout.LayoutParams(-2, -2);
        r110.weight = 1.0f;
        Unit r21 = Unit.INSTANCE;
        addView(r20, r110);
        if (r18 == false) goto L18;
        AppCompatImageView r111 = new AppCompatImageView(r10);
        if (r19 == null) goto L17;
        Drawable r22 = r19.mutate();
        if (r22 == null) goto L17;
        r22.setTint(r17);
        r5 = r22;
    L17:
        r111.setImageDrawable(r5);
        this.f12131i = r111;
        addView(r111, new LinearLayout.LayoutParams(-2, -2));
    L18:
        r14.recycle();
        setOverridePressColor(0);
        i("OButtonLink");
        setChangeAlphaWhenPress(true);
        setClickable(true);
    }
}
