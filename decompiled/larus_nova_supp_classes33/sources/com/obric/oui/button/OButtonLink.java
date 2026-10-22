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
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.core.graphics.ColorUtils;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.text.OBaseTextView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes33.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/obric/oui/button/OButtonLink;", "Lcom/obric/oui/layout/OUILinearLayout;", "a", "OUI_standardRelease"}, k = 1, mv = {1, 6, 0})
public final class OButtonLink extends OUILinearLayout {
    public OBaseTextView h;
    public AppCompatImageView i;
    public final int j;

    public static final class a {
    }

    static {
    }

    public OButtonLink(Context r4) {
        Intrinsics.checkNotNullParameter(r4, "context");
        this(r4, null, 0, 14);
    }

    public OButtonLink(Context r3, AttributeSet r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        this(r3, r4, 0, 12);
    }

    public OButtonLink(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, r4, 8);
    }

    public /* bridge */ /* synthetic */ void setChangeAlphaWhenEnabledChanged(boolean r1) {
    }

    public final void Q5(int r5) {
        float r6 = RangesKt.coerceIn(r5 / 255.0f, 0.0f, 1.0f);
        int r1 = ColorUtils.setAlphaComponent(this.j, RangesKt.coerceIn(MathKt.roundToInt(Color.alpha(this.j) * r6), 0, 255));
        TextView r2 = null;
        if (r6 <= 0.0f) goto L5;
        PorterDuffColorFilter r7 = new PorterDuffColorFilter(r1, PorterDuff.Mode.SRC_ATOP);
    L6:
        TextView r0 = this.h;
        if (r0 != null) goto L9;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
        r0 = null;
    L9:
        r0.getPaint().setColorFilter(r7);
        TextView r3 = this.h;
        if (r3 != null) goto L12;
        Intrinsics.throwUninitializedPropertyAccessException("textView");
    L13:
        r2.invalidate();
        if (r7 == null) goto L19;
        AppCompatImageView r4 = this.i;
        if (r4 == null) goto L25;
        r4.setColorFilter(r7);
        return;
    L25:
        return;
    L19:
        AppCompatImageView r8 = this.i;
        if (r8 == null) goto L26;
        r8.clearColorFilter();
        return;
    L26:
        return;
    L12:
        r2 = r3;
        goto L13
    L5:
        r7 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    public OButtonLink(Context r9, AttributeSet r10, int r11, int r12) {
        Drawable r1 = null;
        if ((r12 & 2) == 0) goto L6;
        r10 = null;
    L6:
        if ((r12 & 4) == 0) goto L8;
        r11 = 0;
    L8:
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11, 8);
        this.j = r9.getResources().getColor(2131105408);
        TypedArray r13 = r9.obtainStyledAttributes(r10, new int[]{2130973065, 2130973066, 2130973403, 2130973404, 2130973406});
        String r14 = r13.getString(2);
        int r15 = r13.getResourceId(4, 2131951948);
        int r0 = r13.getColor(3, getResources().getColor(2131104011, null));
        boolean r4 = r13.getBoolean(1, false);
        Drawable r5 = r13.getDrawable(0);
        setOrientation(0);
        OBaseTextView r6 = new OBaseTextView(r9, null, 6, 0);
        r6.setSingleLine();
        r6.setEllipsize(TextUtils.TruncateAt.MIDDLE);
        r6.setTextAppearance(r15);
        r6.setTextColor(r0);
        r6.setText(r14);
        r6.setIncludeFontPadding(false);
        r6.setGravity(17);
        this.h = r6;
        LinearLayout.LayoutParams r16 = new LinearLayout.LayoutParams(-2, -2);
        r16.weight = 1.0f;
        Unit r7 = Unit.INSTANCE;
        addView(r6, r16);
        if (r4 == false) goto L18;
        AppCompatImageView r17 = new AppCompatImageView(r9);
        if (r5 == null) goto L17;
        Drawable r18 = r5.mutate();
        if (r18 == null) goto L17;
        r18.setTint(r0);
        r1 = r18;
    L17:
        r17.setImageDrawable(r1);
        this.i = r17;
        addView(r17, new LinearLayout.LayoutParams(-2, -2));
    L18:
        r13.recycle();
        setOverridePressColor(0);
        m1("OButtonLink");
        setChangeAlphaWhenPress(true);
        setClickable(true);
    }
}
