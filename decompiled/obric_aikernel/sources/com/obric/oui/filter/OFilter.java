package com.obric.oui.filter;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import o9.q;
import u8.c;
import u8.d;
import u8.e;
import u8.l;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 G2\u00020\u0001:\u0002HIB1\b\u0007\u0012\u0006\u0010@\u001a\u00020?\u0012\n\b\u0002\u0010B\u001a\u0004\u0018\u00010A\u0012\b\b\u0002\u0010C\u001a\u00020\f\u0012\b\b\u0002\u0010D\u001a\u00020\u0007¢\u0006\u0004\bE\u0010FJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u000e\u0010\t\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0007J\u0010\u0010\u000b\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0018\u0010\u000f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0010\u001a\u00020\fJ\u0006\u0010\u0011\u001a\u00020\u0002J\u0016\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u0016\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0007J\u0006\u0010\u0017\u001a\u00020\u0007J\u0010\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0007H\u0016J\u000e\u0010\u001c\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001aJ\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010\u001d\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\fH\u0014J0\u0010%\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010$\u001a\u00020\fH\u0014J\u0010\u0010&\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0014R\u0016\u0010'\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010(R\u0018\u0010)\u001a\u0004\u0018\u00010\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0016\u0010\r\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\r\u0010+R\u0016\u0010-\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b-\u0010.R\u0016\u0010\u000e\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010(R\u0016\u00100\u001a\u00020/8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b0\u00101R\u0018\u00103\u001a\u0004\u0018\u0001028\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b3\u00104R\u0016\u00105\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u0010+R\u0016\u00106\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b6\u0010+R\u0016\u00107\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b7\u0010+R\u0016\u00108\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u0010+R\u0016\u00109\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b9\u0010+R\u0016\u0010;\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u0010<R\u0016\u0010=\u001a\u00020:8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b=\u0010<R\u0016\u0010>\u001a\u00020,8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010.¨\u0006J"}, d2 = {"Lcom/obric/oui/filter/OFilter;", "Lcom/obric/oui/filter/DrawableCenterButton;", "", "internalSetDrawable", "Landroid/graphics/Canvas;", "canvas", "drawCustomBackground", "", "visible", "changeIconVisibility", "selected", "setSelected", "", "style", "isAlwaysLight", "setStyle", "getStyle", "refreshStyle", "horizontalPadding", "verticalPadding", "setWithIconPadding", "setNormalPadding", "setAlwaysLight", "getIsAlwaysLight", "enabled", "setEnabled", "Lcom/obric/oui/filter/OFilter$b;", "listener", "setSelectChangeListener", "widthMeasureSpec", "heightMeasureSpec", "onMeasure", "changed", "left", "top", "right", "bottom", "onLayout", "onDraw", "showIcon", "Z", "onFilterSelectChangeListener", "Lcom/obric/oui/filter/OFilter$b;", "I", "Landroid/graphics/RectF;", "strokeRect", "Landroid/graphics/RectF;", "", "paintStrokeWidth", "F", "Landroid/graphics/drawable/Drawable;", "drawable", "Landroid/graphics/drawable/Drawable;", "tintAndTextColor", "withIconPaddingHorizontal", "normalPaddingHorizontal", "withIconPaddingVertical", "normalPaddingVertical", "Landroid/graphics/Paint;", "strokePaint", "Landroid/graphics/Paint;", "bgPaint", "bgRect", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "isAlwaysLightByCode", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;IZ)V", "Companion", "a", "b", "OUI_standardRelease"}, k = 1, mv = {1, 4, 3})
public class OFilter extends DrawableCenterButton {
    public static final a Companion = null;
    public static final int FILTER_STYLE_HIGHLIGHT = 1;
    public static final int FILTER_STYLE_NORMAL = 0;
    public static final int NORMAL_PADDING_HORIZONTAL = 12;
    public static final int NORMAL_PADDING_VERTICAL = 5;
    public static final int WITH_ICON_PADDING_HORIZONTAL = 16;
    public static final int WITH_ICON_PADDING_VERTICAL = 7;
    private final Paint bgPaint;
    private final RectF bgRect;
    private Drawable drawable;
    private boolean isAlwaysLight;
    private int normalPaddingHorizontal;
    private int normalPaddingVertical;
    private b onFilterSelectChangeListener;
    private final float paintStrokeWidth;
    private boolean showIcon;
    private final Paint strokePaint;
    private final RectF strokeRect;
    private int style;
    private int tintAndTextColor;
    private int withIconPaddingHorizontal;
    private int withIconPaddingVertical;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r10) {
            this();
        }
    }

    public interface b {
        void a(OFilter r10, boolean r11);
    }

    static {
        Companion = new a(null);
    }

    @JvmOverloads
    public OFilter(Context r10) {
        this(r10, null, 0, false, 14, null);
    }

    @JvmOverloads
    public OFilter(Context r10, AttributeSet r11) {
        this(r10, r11, 0, false, 12, null);
    }

    @JvmOverloads
    public OFilter(Context r10, AttributeSet r11, int r12) {
        this(r10, r11, r12, false, 8, null);
    }

    @JvmOverloads
    public OFilter(Context r10, AttributeSet r11, int r12, boolean r13) {
        Intrinsics.checkNotNullParameter(r10, "context");
        super(r10, r11, r12);
        Resources r14 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r14, "Resources.getSystem()");
        this.normalPaddingHorizontal = MathKt.roundToInt(TypedValue.applyDimension(1, 12, r14.getDisplayMetrics()));
        Resources r15 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r15, "Resources.getSystem()");
        this.normalPaddingVertical = MathKt.roundToInt(TypedValue.applyDimension(1, 5, r15.getDisplayMetrics()));
        Resources r16 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r16, "Resources.getSystem()");
        this.withIconPaddingHorizontal = MathKt.roundToInt(TypedValue.applyDimension(1, 16, r16.getDisplayMetrics()));
        Resources r17 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r17, "Resources.getSystem()");
        this.withIconPaddingVertical = MathKt.roundToInt(TypedValue.applyDimension(1, 7, r17.getDisplayMetrics()));
        Resources r18 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r18, "Resources.getSystem()");
        float r19 = MathKt.roundToInt(TypedValue.applyDimension(1, (float) 0.5d, r18.getDisplayMetrics()));
        this.paintStrokeWidth = r19;
        Paint r20 = new Paint(1);
        r20.setStyle(Paint.Style.FILL);
        Unit r21 = Unit.INSTANCE;
        this.bgPaint = r20;
        Paint r22 = new Paint(1);
        r22.setStyle(Paint.Style.STROKE);
        r22.setStrokeWidth(r19);
        this.strokePaint = r22;
        this.bgRect = new RectF();
        this.strokeRect = new RectF();
        TypedArray r23 = r10.getTheme().obtainStyledAttributes(r11, l.OFilter, r12, 0);
        this.style = r23.getInt(l.OFilter_oui_filterStyle, 0);     // Catch: Throwable -> L6
        this.showIcon = r23.getBoolean(l.OFilter_showIcon, false);     // Catch: Throwable -> L6
        this.isAlwaysLight = r23.getBoolean(l.OFilter_oui_isAlwaysLight, r13);     // Catch: Throwable -> L6
        r23.recycle();
        setSingleLine();
        setTextSize(0, r10.getResources().getDimension(d.oui_filter_text_size));
        setCompoundDrawablePadding(r10.getResources().getDimensionPixelSize(d.oui_filter_drawable_padding));
        setGravity(17);
        refreshStyle();
        return;
    L6:
        th = move-exception;
        r23.recycle();
        throw th;
    }

    public /* synthetic */ OFilter(Context r10, AttributeSet r11, int r12, boolean r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 2) == 0) goto L6;
        r11 = null;
    L6:
        if ((r14 & 4) == 0) goto L9;
        r12 = 0;
    L9:
        if ((r14 & 8) == 0) goto L11;
        r13 = false;
    L11:
        this(r10, r11, r12, r13);
    }

    private final void drawCustomBackground(Canvas r10) {
        r10.save();
        r10.translate(getScrollX() * 1.0f, getScrollY() * 1.0f);
        if (this.style != 0) goto L5;
        int r11 = 4;
    L6:
        Resources r12 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r12, "Resources.getSystem()");
        float r13 = MathKt.roundToInt(TypedValue.applyDimension(1, r11, r12.getDisplayMetrics()));
        this.bgRect.set(0.0f, 0.0f, getWidth(), getHeight());
        q.i(r10, this.bgRect, r13, this.bgPaint);
        if (this.style != 1) goto L9;
        float r14 = this.paintStrokeWidth * 0.5f;
        this.strokeRect.set(r14, r14, getWidth() - r14, getHeight() - r14);
        q.i(r10, this.strokeRect, r13, this.strokePaint);
    L9:
        r10.restore();
        return;
    L5:
        r11 = 8;
        goto L6
    }

    private final void internalSetDrawable() {
        if (this.showIcon == true) goto L5;
        setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
        int r10 = this.normalPaddingHorizontal;
        int r11 = this.normalPaddingVertical;
        setPadding(r10, r11, r10, r11);
        setGravity(17);
        return;
    L5:
        if (this.drawable != null) goto L11;
        Drawable r12 = ContextCompat.getDrawable(getContext(), e.o_arrow_forward_filter);
        if (r12 == null) goto L9;
        Drawable r13 = r12.mutate();
    L10:
        this.drawable = r13;
        goto L11
    L9:
        r13 = null;
    L11:
        Drawable r14 = this.drawable;
        Intrinsics.checkNotNull(r14);
        Drawable r15 = DrawableCompat.wrap(r14);
        DrawableCompat.setTintMode(r15, PorterDuff.Mode.SRC_IN);
        DrawableCompat.setTint(r15, ContextCompat.getColor(getContext(), this.tintAndTextColor));
        Intrinsics.checkNotNullExpressionValue(r15, "drawableCompat");
        r15.setBounds(0, 0, r15.getIntrinsicWidth(), r15.getIntrinsicHeight());
        setGravity(8388629);
        setCompoundDrawablesWithIntrinsicBounds(null, null, r15, null);
        int r16 = this.withIconPaddingHorizontal;
        int r17 = this.withIconPaddingVertical;
        setPadding(r16, r17, r16, r17);
    }

    public static /* synthetic */ void setStyle$default(OFilter r10, int r11, boolean r12, int r13, Object r14) {
        if (r14 != null) goto L9;
        if ((r13 & 2) == 0) goto L6;
        r12 = false;
    L6:
        r10.setStyle(r11, r12);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setStyle");
    }

    public final void changeIconVisibility(boolean r10) {
        this.showIcon = r10;
        if (r10 == false) goto L5;
        setStyle$default(this, 1, false, 2, null);
        return;
    L5:
        internalSetDrawable();
    }

    public final boolean getIsAlwaysLight() {
        return this.isAlwaysLight;
    }

    public final int getStyle() {
        return this.style;
    }

    @Override // com.obric.oui.filter.DrawableCenterButton, android.widget.TextView, android.view.View
    protected void onDraw(Canvas r10) {
        Intrinsics.checkNotNullParameter(r10, "canvas");
        drawCustomBackground(r10);
        super.onDraw(r10);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean r10, int r11, int r12, int r13, int r14) {
        super.onLayout(r10, r11, r12, r13, r14);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int r10, int r11) {
        super.onMeasure(r10, r11);
    }

    public final void refreshStyle() {
        if (isEnabled() == true) goto L6;
        return;
    L6:
        if (this.style != 1) goto L8;
        Resources r10 = Resources.getSystem();
        Intrinsics.checkNotNullExpressionValue(r10, "Resources.getSystem()");
        int r11 = MathKt.roundToInt(TypedValue.applyDimension(1, 36, r10.getDisplayMetrics()));
    L9:
        setMinHeight(r11);
        if (isSelected() == false) goto L20;
        if (this.isAlwaysLight == false) goto L16;
        int r12 = c.primary;
        int r13 = c.BGBrand;
        this.tintAndTextColor = r12;
    L14:
        setTypeface(null, 1);
    L28:
        this.bgPaint.setColor(ContextCompat.getColor(getContext(), r13));
        this.strokePaint.setColor(ContextCompat.getColor(getContext(), r12));
        setTextColor(ContextCompat.getColor(getContext(), this.tintAndTextColor));
        internalSetDrawable();
        return;
    L16:
        if (this.style != 1) goto L18;
        r12 = c.primary;
        this.tintAndTextColor = r12;
        r13 = c.Transparent;
        goto L14
    L18:
        r12 = c.BGInput;
        this.tintAndTextColor = c.TextPrimary;
        setTypeface(null, 1);
        r13 = r12;
        goto L28
    L20:
        if (this.isAlwaysLight == false) goto L25;
        r12 = c.LineReverse2;
        this.tintAndTextColor = c.TextReverse;
    L22:
        int r14 = c.Transparent;
    L23:
        setTypeface(null, 0);
        r13 = r14;
        goto L28
    L25:
        if (this.style != 1) goto L27;
        r12 = c.oui_basic_text_2;
        this.tintAndTextColor = r12;
        goto L22
    L27:
        r12 = c.oui_basic_text_2;
        this.tintAndTextColor = r12;
        r14 = c.oui_basic_text_4;
        goto L23
    L8:
        r11 = -1;
        goto L9
    }

    public final void setAlwaysLight(boolean r10) {
        this.isAlwaysLight = r10;
        refreshStyle();
    }

    @Override // android.widget.TextView, android.view.View
    public void setEnabled(boolean r10) {
        super.setEnabled(r10);
        if (r10 == false) goto L5;
        setAlpha(1.0f);
        refreshStyle();
        return;
    L5:
        setAlpha(0.5f);
    }

    public final void setNormalPadding(int r10, int r11) {
        this.normalPaddingHorizontal = r10;
        this.normalPaddingVertical = r11;
    }

    public final void setSelectChangeListener(b r10) {
        Intrinsics.checkNotNullParameter(r10, "listener");
        this.onFilterSelectChangeListener = r10;
    }

    @Override // android.widget.TextView, android.view.View
    public void setSelected(boolean r10) {
        super.setSelected(r10);
        refreshStyle();
        b r11 = this.onFilterSelectChangeListener;
        if (r11 == null) goto L6;
        r11.a(this, r10);
        return;
    }

    public final void setStyle(int r10, boolean r11) {
        this.style = r10;
        this.isAlwaysLight = r11;
        refreshStyle();
    }

    public final void setWithIconPadding(int r10, int r11) {
        this.withIconPaddingHorizontal = r10;
        this.withIconPaddingVertical = r11;
    }
}
