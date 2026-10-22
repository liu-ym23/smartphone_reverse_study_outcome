package com.larus.common_ui.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import z19.w;
import z19.x;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes27.dex */
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002NOB\u0011\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\u0004\u0010\bB#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\u000bB+\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n¢\u0006\u0004\b\u0004\u0010\rJ\u0010\u00100\u001a\u0002012\b\b\u0001\u00102\u001a\u00020\nJ\u0018\u00103\u001a\u0002012\u0006\u00104\u001a\u00020\n2\u0006\u00105\u001a\u00020\nH\u0014J0\u00106\u001a\u0002012\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\n2\u0006\u0010:\u001a\u00020\n2\u0006\u0010;\u001a\u00020\n2\u0006\u0010<\u001a\u00020\nH\u0014J\u0012\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u001a\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\nH\u0016J\u001c\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J$\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\n2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\"\u0010=\u001a\u0002012\b\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010C\u001a\u00020\n2\u0006\u0010D\u001a\u00020\nH\u0016J\u0012\u0010E\u001a\u00020F2\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0010\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020BH\u0014J\b\u0010H\u001a\u00020IH\u0014J\u001a\u0010J\u001a\u0002012\b\u0010K\u001a\u0004\u0018\u00010?2\u0006\u0010@\u001a\u00020\nH\u0002J\"\u0010L\u001a\u0002012\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0002J\b\u0010M\u001a\u000201H\u0002R$\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u0014@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n8\u0006@FX\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R$\u0010\u001d\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013R$\u0010 \u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0011\"\u0004\b\"\u0010\u0013R\u001b\u0010#\u001a\u00020$8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b'\u0010(\u001a\u0004\b%\u0010&R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u001f\u0010+\u001a\u00060,R\u00020\u00008BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b/\u0010(\u001a\u0004\b-\u0010.¨\u0006P"}, d2 = {"Lcom/larus/common_ui/widget/ShadowLayout;", "Landroid/view/ViewGroup;", "context", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "value", "shadowSize", "getShadowSize", "()I", "setShadowSize", "(I)V", "Landroid/graphics/Point;", "shadowOffset", "getShadowOffset", "()Landroid/graphics/Point;", "setShadowOffset", "(Landroid/graphics/Point;)V", "shadowColor", "getShadowColor", "setShadowColor", "shadowRadius", "getShadowRadius", "setShadowRadius", "shadowStrokeWidth", "getShadowStrokeWidth", "setShadowStrokeWidth", "shadowPaint", "Landroid/graphics/Paint;", "getShadowPaint", "()Landroid/graphics/Paint;", "shadowPaint$delegate", "Lkotlin/Lazy;", "shadowRect", "Landroid/graphics/RectF;", "shadowView", "Lcom/larus/common_ui/widget/ShadowLayout$UXShadowView;", "getShadowView", "()Lcom/larus/common_ui/widget/ShadowLayout$UXShadowView;", "shadowView$delegate", "applyStyle", "", "styleId", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onLayout", "changed", "", "l", "t", "r", "b", "addView", "child", "Landroid/view/View;", "index", "params", "Landroid/view/ViewGroup$LayoutParams;", "width", "height", "generateLayoutParams", "Lcom/larus/common_ui/widget/ShadowLayout$LayoutParams;", "lp", "generateDefaultLayoutParams", "Landroid/widget/FrameLayout$LayoutParams;", "checkChildrenCountBeforeAddView", "view", "applyAttrs", "setUpPaint", "LayoutParams", "UXShadowView", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ShadowLayout extends ViewGroup {
    public static final /* synthetic */ int i = 0;
    public int a;
    public Point b;
    public int c;
    public int d;
    public int e;
    public final Lazy f;
    public final RectF g;
    public final Lazy h;

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 +2\u00020\u0001:\u0001+B\u001b\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0019\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\u000bB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u0001¢\u0006\u0004\b\u0006\u0010\rB\u0011\b\u0016\u0012\u0006\u0010\f\u001a\u00020\u000e¢\u0006\u0004\b\u0006\u0010\u000fJ\u001a\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0002J(\u0010\"\u001a\u00020 2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\tH\u0016J\u0010\u0010'\u001a\u00020 2\u0006\u0010(\u001a\u00020\tH\u0016J\u0010\u0010)\u001a\u00020 2\u0006\u0010*\u001a\u00020\tH\u0016R\u001a\u0010\u0010\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015R\u001a\u0010\u0019\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0013\"\u0004\b\u001b\u0010\u0015R\u001a\u0010\u001c\u001a\u00020\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0013\"\u0004\b\u001e\u0010\u0015¨\u0006,"}, d2 = {"Lcom/larus/common_ui/widget/ShadowLayout$LayoutParams;", "Landroid/view/ViewGroup$MarginLayoutParams;", "c", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "width", "", "height", "(II)V", "source", "(Landroid/view/ViewGroup$MarginLayoutParams;)V", "Landroid/view/ViewGroup$LayoutParams;", "(Landroid/view/ViewGroup$LayoutParams;)V", "hasLeftMarginSet", "", "getHasLeftMarginSet$common_ui_mainlandRelease", "()Z", "setHasLeftMarginSet$common_ui_mainlandRelease", "(Z)V", "hasTopMarginSet", "getHasTopMarginSet$common_ui_mainlandRelease", "setHasTopMarginSet$common_ui_mainlandRelease", "hasRightMarginSet", "getHasRightMarginSet$common_ui_mainlandRelease", "setHasRightMarginSet$common_ui_mainlandRelease", "hasBottomMarginSet", "getHasBottomMarginSet$common_ui_mainlandRelease", "setHasBottomMarginSet$common_ui_mainlandRelease", "applyAttrs", "", "context", "setMargins", "left", "top", "right", "bottom", "setMarginStart", "start", "setMarginEnd", "end", "Companion", "common-ui_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class LayoutParams extends ViewGroup.MarginLayoutParams {
        public boolean a;
        public boolean b;
        public boolean c;
        public boolean d;

        public static final class a {
        }

        static {
        }

        public LayoutParams(ViewGroup.LayoutParams r2) {
            Intrinsics.checkNotNullParameter(r2, "source");
            super(r2);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginEnd(int r2) {
            super.setMarginEnd(r2);
            if (getLayoutDirection() != 0) goto L5;
            this.c = true;
            return;
        L5:
            this.a = true;
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMarginStart(int r2) {
            super.setMarginStart(r2);
            if (getLayoutDirection() != 0) goto L5;
            this.a = true;
            return;
        L5:
            this.c = true;
        }

        public LayoutParams(Context r4, AttributeSet r5) {
            Intrinsics.checkNotNullParameter(r4, "c");
            super(r4, r5);
            TypedArray r6 = r4.obtainStyledAttributes(r5, new int[]{R.attr.layout_margin, R.attr.layout_marginLeft, R.attr.layout_marginTop, R.attr.layout_marginRight, R.attr.layout_marginBottom, R.attr.layout_marginStart, R.attr.layout_marginEnd, R.attr.layout_marginHorizontal, R.attr.layout_marginVertical});
            if (r6.getDimensionPixelSize(0, -1) < 0) goto L5;
            this.b = true;
            this.a = true;
            this.c = true;
            this.d = true;
        L32:
            r6.recycle();
            return;
        L5:
            int r7 = r6.getDimensionPixelSize(7, -1);
            int r2 = r6.getDimensionPixelSize(8, -1);
            if (r7 < 0) goto L9;
            this.a = true;
            this.c = true;
        L14:
            if (r2 < 0) goto L17;
            this.b = true;
            this.d = true;
            goto L32
        L17:
            if (r6.getDimensionPixelSize(2, -1) < 0) goto L20;
            this.b = true;
        L20:
            if (r6.getDimensionPixelSize(4, -1) < 0) goto L22;
            this.d = true;
        L22:
            int r8 = r6.getDimensionPixelSize(5, -1);
            int r0 = r6.getDimensionPixelSize(6, -1);
            if (getLayoutDirection() != 0) goto L28;
            if (r8 < 0) goto L26;
            this.a = true;
        L26:
            if (r0 < 0) goto L32;
            this.c = true;
            goto L32
        L28:
            if (r8 < 0) goto L30;
            this.c = true;
        L30:
            if (r0 < 0) goto L32;
            this.a = true;
            goto L32
        L9:
            if (r6.getDimensionPixelSize(1, -1) < 0) goto L12;
            this.a = true;
        L12:
            if (r6.getDimensionPixelSize(3, -1) < 0) goto L14;
            this.c = true;
            goto L14
        }

        public LayoutParams(int r1, int r2) {
            super(r1, r2);
        }

        @Override // android.view.ViewGroup.MarginLayoutParams
        public final void setMargins(int r1, int r2, int r3, int r4) {
            super.setMargins(r1, r2, r3, r4);
            this.b = true;
            this.a = true;
            this.c = true;
            this.d = true;
        }
    }

    public final class a extends View {
        public final /* synthetic */ ShadowLayout a;

        @Override // android.view.View
        public final void onDraw(Canvas r5) {
            Intrinsics.checkNotNullParameter(r5, "canvas");
            if (this.a.getChildAt(1) == null) goto L8;
            ShadowLayout r0 = this.a;
            if (r0.getShadowStrokeWidth() <= 0) goto L7;
            ShadowLayout.a(r0).setStyle(Paint.Style.STROKE);
            ShadowLayout.a(r0).setStrokeWidth(r0.getShadowStrokeWidth());
        L7:
            r5.drawRoundRect(r0.g, r0.getShadowRadius(), r0.getShadowRadius(), ShadowLayout.a(r0));
        L8:
            super.onDraw(r5);
        }

        public a(ShadowLayout r2, Context r3) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.a = r2;
            super(r3);
            if (Build.VERSION.SDK_INT >= 28) goto L6;
            setLayerType(1, null);
            return;
        }
    }

    private final Paint getShadowPaint() {
        return (Paint) this.f.getValue();
    }

    private final a getShadowView() {
        return (a) this.h.getValue();
    }

    public final void c() {
        float r0 = this.a;
        int r1 = this.c;
        Paint r2 = getShadowPaint();
        Point r3 = this.b;
        r2.setShadowLayer(r0, r3.x, r3.y, r1);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new FrameLayout.LayoutParams(-1, -1);
    }

    public final int getShadowColor() {
        return this.c;
    }

    public final Point getShadowOffset() {
        return this.b;
    }

    public final int getShadowRadius() {
        return this.d;
    }

    public final int getShadowSize() {
        return this.a;
    }

    public final int getShadowStrokeWidth() {
        return this.e;
    }

    public ShadowLayout(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, null);
    }

    public static final /* synthetic */ Paint a(ShadowLayout r0) {
        return r0.getShadowPaint();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2) {
        b(r2, getChildCount());
        super.addView(r2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams r2) {
        Intrinsics.checkNotNullParameter(r2, "lp");
        return new LayoutParams(r2);
    }

    public final void setShadowColor(int r2) {
        if (r2 == this.c) goto L6;
        this.c = r2;
        c();
        invalidate();
        getShadowView().invalidate();
        return;
    }

    public final void setShadowOffset(Point r2) {
        Intrinsics.checkNotNullParameter(r2, "value");
        if (Intrinsics.areEqual(r2, this.b) == true) goto L6;
        this.b = r2;
        c();
        requestLayout();
        getShadowView().requestLayout();
        return;
    }

    public final void setShadowRadius(int r1) {
        this.d = r1;
        invalidate();
        getShadowView().invalidate();
    }

    public final void setShadowSize(int r2) {
        if (r2 == this.a) goto L6;
        this.a = r2;
        c();
        requestLayout();
        getShadowView().requestLayout();
        return;
    }

    public final void setShadowStrokeWidth(int r1) {
        this.e = r1;
        invalidate();
        getShadowView().invalidate();
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet r3) {
        return new LayoutParams(getContext(), r3);
    }

    public ShadowLayout(Context r2, AttributeSet r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        this(r2, r3, 0);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void addView(View r2, ViewGroup.LayoutParams r3) {
        b(r2, getChildCount());
        super.addView(r2, r3);
    }

    public final void b(View r5, int r6) {
        boolean r2 = true;
        if (getChildCount() >= 2) goto L5;
        boolean r0 = true;
    L6:
        if (r0 == false) goto L18;
        if (r6 != 0) goto L13;
        if (r6 == 0) goto L10;
    L12:
        r2 = false;
        goto L13
    L10:
        if ((r5 instanceof a) == false) goto L12;
    L13:
        if (r2 == false) goto L16;
        return;
    L16:
        throw new IllegalArgumentException("Must not add view at 0 in UXShadowLayout!".toString());
    L18:
        throw new IllegalArgumentException("UXShadowLayout can host only one direct child".toString());
    L5:
        r0 = false;
        goto L6
    }

    @Override // android.view.View
    public final void onMeasure(int r11, int r12) {
        View r0 = getChildAt(1);
        if (r0 == null) goto L21;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.larus.common_ui.widget.ShadowLayout.LayoutParams");
        LayoutParams r7 = (LayoutParams) r1;
        int r2 = 0;
        if (r7.b == false) goto L7;
        int r3 = 0;
    L8:
        int r4 = r3 + 0;
        if (r7.d == false) goto L11;
        int r5 = 0;
    L12:
        int r8 = r4 + r5;
        if (r7.a == false) goto L15;
        int r6 = 0;
    L16:
        int r9 = r6 + 0;
        if (r7.c == true) goto L20;
        r2 = Math.max(0, this.a + this.b.x);
    L20:
        int r10 = r9 + r2;
        measureChildWithMargins(r0, r11, r10, r12, r8);
        int r13 = r0.getMeasuredWidth();
        int r14 = r0.getMeasuredHeight();
        setMeasuredDimension(((((r13 + ((ViewGroup.MarginLayoutParams) r7).leftMargin) + ((ViewGroup.MarginLayoutParams) r7).rightMargin) + getPaddingLeft()) + getPaddingRight()) + r10, ((((r14 + ((ViewGroup.MarginLayoutParams) r7).topMargin) + ((ViewGroup.MarginLayoutParams) r7).bottomMargin) + getPaddingTop()) + getPaddingBottom()) + r8);
        goto L21
    L15:
        r6 = Math.max(0, this.a - this.b.x);
        goto L16
    L11:
        r5 = Math.max(0, this.a + this.b.y);
        goto L12
    L7:
        r3 = Math.max(0, this.a - this.b.y);
    L21:
        getShadowView().measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
    }

    @Override // android.view.ViewGroup
    public final void addView(View r1, int r2) {
        b(r1, r2);
        super.addView(r1, r2);
    }

    public ShadowLayout(Context r5, AttributeSet r6, int r7) {
        Intrinsics.checkNotNullParameter(r5, "context");
        Intrinsics.checkNotNullParameter(r5, "context");
        super(r5, r6, r7, 2131954365);
        this.b = new Point(0, 0);
        this.f = LazyKt.lazy(new w());
        this.g = new RectF();
        this.h = LazyKt.lazy(new x(this));
        addView(getShadowView(), 0, new LayoutParams(-1, -1));
        c();
        TypedArray r8 = getContext().obtainStyledAttributes(r6, new int[]{R.attr.maxWidth, R.attr.maxHeight, R.attr.minWidth, R.attr.minHeight, 2130969028, 2130969032, 2130969039, 2130969040, 2130969041, 2130969042, 2130969505, 2130970210, 2130970222, 2130970223, 2130970224, 2130970225, 2130970226, 2130970227, 2130970228, 2130970229, 2130970230, 2130970231, 2130970232, 2130970233, 2130970234, 2130970235, 2130970236, 2130970237, 2130970238, 2130970239, 2130970240, 2130970241, 2130970242, 2130970243, 2130970244, 2130970245, 2130970246, 2130970247, 2130970248, 2130970249, 2130972495, 2130972496, 2130972497, 2130972498, 2130973410, 2130973413, 2130973414, 2130973415, 2130973416, 2130973417, 2130973712, 2130973774, 2130973775, 2130973776, 2130973777, 2130974025, 2130974029, 2130974053, 2130974614, 2130974615, 2130974616, 2130974617, 2130975010, 2130975014, 2130975015, 2130975016, 2130975017, 2130975018, 2130975019}, r7, 2131954365);
        setShadowSize(r8.getDimensionPixelSize(67, 0));
        setShadowOffset(new Point(r8.getDimensionPixelSize(64, 0), r8.getDimensionPixelSize(65, 0)));
        setShadowColor(r8.getColor(63, this.c));
        setShadowRadius(r8.getDimensionPixelSize(66, 0));
        setShadowStrokeWidth(r8.getDimensionPixelSize(68, 0));
        r8.recycle();
    }

    @Override // android.view.ViewGroup
    public final void addView(View r2, int r3, int r4) {
        b(r2, getChildCount());
        super.addView(r2, r3, r4);
    }

    @Override // android.view.ViewGroup
    public final void addView(View r1, int r2, ViewGroup.LayoutParams r3) {
        b(r1, r2);
        super.addView(r1, r2, r3);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean r3, int r4, int r5, int r6, int r7) {
        View r8 = getChildAt(0);
        r8.layout(0, 0, r8.getMeasuredWidth(), r8.getMeasuredHeight());
        View r9 = getChildAt(1);
        if (r9 == null) goto L17;
        ViewGroup.LayoutParams r10 = r9.getLayoutParams();
        Intrinsics.checkNotNull(r10, "null cannot be cast to non-null type com.larus.common_ui.widget.ShadowLayout.LayoutParams");
        LayoutParams r11 = (LayoutParams) r10;
        if (r11.b == false) goto L7;
        int r12 = getPaddingTop();
        int r13 = ((ViewGroup.MarginLayoutParams) r11).topMargin;
    L8:
        int r14 = r12 + r13;
        if (r11.a == false) goto L11;
        int r15 = getPaddingLeft() + ((ViewGroup.MarginLayoutParams) r11).leftMargin;
    L12:
        r9.layout(r15, r14, r9.getMeasuredWidth() + r15, r9.getMeasuredHeight() + r14);
        int r16 = this.e;
        if (r16 <= 0) goto L15;
        float r17 = r15;
        float r18 = r14;
        this.g.set((r16 / 2) + r17, (r16 / 2) + r18, (r17 + r9.getMeasuredWidth()) - (this.e / 2), (r18 + r9.getMeasuredHeight()) - (this.e / 2));
        return;
    L15:
        float r20 = r15;
        float r21 = r14;
        this.g.set(r20, r21, r9.getMeasuredWidth() + r20, r9.getMeasuredHeight() + r21);
        return;
    L11:
        r15 = Math.max(0, this.a - this.b.x) + getPaddingLeft();
        goto L12
    L7:
        r12 = getPaddingTop();
        r13 = Math.max(0, this.a - this.b.y);
        goto L8
    }
}
