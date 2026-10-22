package com.obric.oui.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatImageView;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import u8.c;
import u8.k;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u000bB1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/obric/oui/button/OButtonLink;", "Lcom/obric/oui/layout/OUILinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "a", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public final class OButtonLink extends OUILinearLayout {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private OBaseTextView f6267l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private ImageView f6268m;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    static {
        new a(null);
    }

    @JvmOverloads
    public OButtonLink(Context r10) {
        this(r10, null, 0, 0, 14, null);
    }

    @JvmOverloads
    public OButtonLink(Context r10, AttributeSet r11) {
        this(r10, r11, 0, 0, 12, null);
    }

    @JvmOverloads
    public OButtonLink(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, 0, 8, null);
    }

    @JvmOverloads
    public OButtonLink(Context r10, AttributeSet r11, int r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12, null, 8, null);
        c(r10, r11);
    }

    public /* synthetic */ OButtonLink(Context r10, AttributeSet r11, int r12, int r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = 0;
    L11:
        this(r10, r11, r12, r13);
    }

    private final float b(float r10) {
        return 1 - (r10 * 0.3f);
    }

    private final void c(Context r18, AttributeSet r19) {
        TypedArray r10 = r18.obtainStyledAttributes(r19, l.OButtonLink);
        Intrinsics.checkNotNullExpressionValue(r10, "context.obtainStyledAttr… R.styleable.OButtonLink)");
        String r11 = r10.getString(l.OButtonLink_oui_widgetText);
        int r12 = r10.getResourceId(l.OButtonLink_oui_widgetTextStyle, k.Button_1_Medium);
        Drawable r13 = null;
        int r14 = r10.getColor(l.OButtonLink_oui_widgetTextColor, getResources().getColor(c.oui_accent_7_fg, null));
        boolean r15 = r10.getBoolean(l.OButtonLink_oui_buttonLinkShowArrow, false);
        Drawable r16 = r10.getDrawable(l.OButtonLink_oui_buttonLinkArrowDrawable);
        setOrientation(0);
        OBaseTextView r17 = new OBaseTextView(r18, null, 0, 6, null);
        r17.setSingleLine();
        r17.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r17.setTextAppearance(r12);
        r17.setTextColor(r14);
        r17.setText(r11);
        r17.setIncludeFontPadding(false);
        r17.setGravity(17);
        Unit r20 = Unit.INSTANCE;
        this.f6267l = r17;
        LinearLayout.LayoutParams r21 = new LinearLayout.LayoutParams(-2, -2);
        r21.weight = 1.0f;
        addView(r17, r21);
        if (r15 == false) goto L10;
        AppCompatImageView r22 = new AppCompatImageView(r18);
        if (r16 == null) goto L9;
        Drawable r23 = r16.mutate();
        if (r23 == null) goto L9;
        r23.setTint(r14);
        r13 = r23;
    L9:
        r22.setImageDrawable(r13);
        this.f6268m = r22;
        addView(r22, new LinearLayout.LayoutParams(-2, -2));
    L10:
        r10.recycle();
        setOverridePressColor(0);
        refreshColors("OButtonLink");
        setChangeAlphaWhenPress(true);
        setClickable(true);
    }

    private final void d(float r10) {
        float r11 = b(r10);
        OBaseTextView r12 = this.f6267l;
        if (r12 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L5:
        r12.setAlpha(r11);
        ImageView r13 = this.f6268m;
        if (r13 == null) goto L9;
        r13.setImageAlpha(MathKt.roundToInt(r11 * 255));
        return;
    }

    @Override // com.obric.oui.layout.OUILinearLayout, o9.b
    public void onPressAlphaChange(int r10) {
        d(RangesKt.coerceIn(r10 / 255.0f, 0.0f, 1.0f));
    }
}
