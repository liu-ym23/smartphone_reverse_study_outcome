package com.larksuite.component.universe_design.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatButton;
import com.larksuite.component.universe_design.radius.UDRadius;
import com.larksuite.component.universe_design.timepicker.impl.base.WheelView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0017\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0016J\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0018\u0010\u0011\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010J\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0012\u001a\u00020\u0007J\r\u0010\u0015\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0019H\u0007J&\u0010\u001b\u001a\u00020\r2\u0006\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u001f\u001a\u00020\u0019J\n\u0010 \u001a\u0004\u0018\u00010!H\u0007J\u000e\u0010\"\u001a\u00020\r2\u0006\u0010#\u001a\u00020$J\u0006\u0010#\u001a\u00020$J\u0010\u0010%\u001a\u00020\r2\b\b\u0001\u0010&\u001a\u00020\u0007J\"\u0010'\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/larksuite/component/universe_design/button/UDButton;", "Landroidx/appcompat/widget/AppCompatButton;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mRoundBg", "Lcom/larksuite/component/universe_design/drawable/UDRoundDrawable;", "setBackgroundColor", "", "color", "colors", "Landroid/content/res/ColorStateList;", "setStrokeData", "width", "setStrokeColor", "setStrokeWidth", "getStrokeWidth", "()Ljava/lang/Integer;", "setCornerRadius", "radius", "", "getCornerRadius", "setCornerRadii", "radiusTopLeft", "radiusTopRight", "radiusBottomLeft", "radiusBottomRight", "getCornerRadii", "", "setRadiusAdjustBounds", "isRadiusAdjustBounds", "", "applyStyle", "styleRes", "createRoundDrawableFromAttributeSet", "universe-ui-button_release"}, k = 1, mv = {2, 1, 0}, xi = WheelView.WHEEL_ITEM_HEIGHT)
public class UDButton extends AppCompatButton {
    public static final int $stable = 8;
    private t08.a mRoundBg;

    public UDButton(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, null, 0, 6, null);
    }

    public UDButton(Context r8, AttributeSet r9) {
        Intrinsics.checkNotNullParameter(r8, "context");
        this(r8, r9, 0, 4, null);
    }

    public final float[] getCornerRadii() {
        return this.mRoundBg.getCornerRadii();
    }

    public final float getCornerRadius() {
        return this.mRoundBg.getCornerRadius();
    }

    public final Integer getStrokeWidth() {
        return Integer.valueOf(this.mRoundBg.c);
    }

    public final boolean isRadiusAdjustBounds() {
        return this.mRoundBg.d;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void applyStyle(int r6) {
        TypedArray r7 = getContext().obtainStyledAttributes(null, new int[]{R.attr.textAppearance, R.attr.ellipsize, R.attr.gravity, R.attr.paddingLeft, R.attr.paddingRight, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginRight, R.attr.minWidth, R.attr.maxLines, 2130974844, 2130974915, 2130974935, 2130974936, 2130974937, 2130974938, 2130974939, 2130974945, 2130974946}, 0, r6);
        ViewGroup.LayoutParams r0 = getLayoutParams();
        if (r0 != null) goto L5;
        r0 = new ViewGroup.MarginLayoutParams(0, 0);
    L5:
        r0.width = r7.getLayoutDimension(5, r0.width);
        r0.height = r7.getLayoutDimension(6, r0.height);
        if ((r0 instanceof ViewGroup.MarginLayoutParams) == false) goto L8;
        ViewGroup.MarginLayoutParams r1 = (ViewGroup.MarginLayoutParams) r0;
        r1.leftMargin = r7.getDimensionPixelSize(7, r1.leftMargin);
        r1.rightMargin = r7.getDimensionPixelSize(8, r1.rightMargin);
    L8:
        setLayoutParams(r0);
        setPadding(r7.getDimensionPixelSize(3, getPaddingLeft()), getPaddingTop(), r7.getDimensionPixelSize(4, getPaddingRight()), getPaddingBottom());
        setMinWidth(r7.getDimensionPixelSize(9, getMinWidth()));
        setMaxLines(r7.getInt(10, getMaxLines()));
        int r2 = 2;
        setGravity(r7.getInt(2, getGravity()));
        TextUtils.TruncateAt[] r3 = TextUtils.TruncateAt.values();
        TextUtils.TruncateAt r4 = getEllipsize();
        if (r4 == null) goto L11;
        r2 = r4.ordinal();
    L11:
        setEllipsize(r3[r7.getInt(1, r2)]);
        int r5 = r7.getResourceId(0, -1);
        if (r5 <= 0) goto L14;
        setTextAppearance(getContext(), r5);
    L14:
        int r8 = r7.getInt(13, 0);
        if (r8 < 0) goto L17;
        UDRadius.Companion.getClass();
        setCornerRadius(UDRadius.a.a(r8).getRadiusSize(getContext()));
    L17:
        setRadiusAdjustBounds(r7.getBoolean(12, false));
        r7.recycle();
    }

    public void setBackgroundColor(int r2) {
        t08.a r0 = this.mRoundBg;
        ColorStateList r3 = ColorStateList.valueOf(r2);
        r0.a = r3;
        r0.setColor(r3);
    }

    public final void setCornerRadius(float r2) {
        this.mRoundBg.setCornerRadius(r2);
    }

    public final void setRadiusAdjustBounds(boolean r3) {
        t08.a r0 = this.mRoundBg;
        if (r0.d == r3) goto L10;
        r0.d = r3;
        if (r3 == false) goto L8;
        r0.setCornerRadius(Math.min(r0.getBounds().width(), r0.getBounds().height()) / 2);
    L8:
        r0.invalidateSelf();
        return;
    }

    public final void setStrokeColor(ColorStateList r3) {
        Intrinsics.checkNotNullParameter(r3, "colors");
        t08.a r0 = this.mRoundBg;
        int r1 = r0.c;
        r0.c = r1;
        r0.b = r3;
        r0.setStroke(r1, r3);
    }

    public final void setStrokeWidth(int r3) {
        t08.a r0 = this.mRoundBg;
        ColorStateList r1 = r0.b;
        r0.c = r3;
        r0.b = r1;
        r0.setStroke(r3, r1);
    }

    public final void setBackgroundColor(ColorStateList r2) {
        t08.a r0 = this.mRoundBg;
        r0.a = r2;
        r0.setColor(r2);
    }

    public final void setStrokeColor(int r1) {
        setStrokeColor(ColorStateList.valueOf(r1));
    }

    public final void setStrokeData(int r2, ColorStateList r3) {
        t08.a r0 = this.mRoundBg;
        r0.c = r2;
        r0.b = r3;
        r0.setStroke(r2, r3);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public UDButton(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        t08.a r5 = createRoundDrawableFromAttributeSet(r2, r3, r4);
        this.mRoundBg = r5;
        setBackground(r5);
    }

    private final t08.a createRoundDrawableFromAttributeSet(Context r12, AttributeSet r13, int r14) {
        TypedArray r15 = r12.obtainStyledAttributes(r13, new int[]{R.attr.textAppearance, R.attr.ellipsize, R.attr.gravity, R.attr.paddingLeft, R.attr.paddingRight, R.attr.layout_width, R.attr.layout_height, R.attr.layout_marginLeft, R.attr.layout_marginRight, R.attr.minWidth, R.attr.maxLines, 2130974844, 2130974915, 2130974935, 2130974936, 2130974937, 2130974938, 2130974939, 2130974945, 2130974946}, r14, 0);
        ColorStateList r2 = r15.getColorStateList(11);
        ColorStateList r4 = r15.getColorStateList(18);
        int r3 = r15.getDimensionPixelSize(19, 0);
        boolean r9 = r15.getBoolean(12, false);
        int r16 = r15.getInt(13, 0);
        if (r16 < 0) goto L5;
        UDRadius.Companion.getClass();
        int r10 = UDRadius.a.a(r16).getRadiusSize(r12);
    L6:
        int r5 = r15.getDimensionPixelSize(16, 0);
        int r6 = r15.getDimensionPixelSize(17, 0);
        int r7 = r15.getDimensionPixelSize(14, 0);
        int r8 = r15.getDimensionPixelSize(15, 0);
        r15.recycle();
        int r17 = t08.a.e;
        return t08.a.C0127a.a(r2, r3, r4, r5, r6, r7, r8, r9, r10);
    L5:
        r10 = r16;
        goto L6
    }

    public final void setCornerRadii(float r4, float r5, float r6, float r7) {
        this.mRoundBg.setCornerRadii(new float[]{r4, r4, r5, r5, r7, r7, r6, r6});
    }

    public /* synthetic */ UDButton(Context r1, AttributeSet r2, int r3, int r4, DefaultConstructorMarker r5) {
        if ((r4 & 2) == 0) goto L6;
        r2 = null;
    L6:
        if ((r4 & 4) == 0) goto L8;
        r3 = 0;
    L8:
        this(r1, r2, r3);
    }
}
